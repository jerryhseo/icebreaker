package com.osp.icebreaker.scheduler.torque;

import java.io.ByteArrayOutputStream;
import java.io.File;
import java.io.IOException;
import java.io.OutputStream;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.logging.Logger;

import org.apache.commons.exec.CommandLine;
import org.apache.commons.exec.DefaultExecuteResultHandler;
import org.apache.commons.exec.DefaultExecutor;
import org.apache.commons.exec.ExecuteException;
import org.apache.commons.exec.ExecuteStreamHandler;
import org.apache.commons.exec.PumpStreamHandler;
import org.apache.commons.lang3.StringUtils;

import com.osp.icebreaker.model.OSPScheduler;
import com.osp.icebreaker.scheduler.torque.model.TorqueJob;
import com.osp.icebreaker.scheduler.torque.model.TorqueNode;
import com.osp.icebreaker.scheduler.torque.model.TorqueQueue;
import com.osp.icebreaker.scheduler.torque.model.TorqueQueueState;
import com.osp.icebreaker.scheduler.torque.parser.TorqueNodeXmlParser;
import com.osp.icebreaker.scheduler.torque.parser.TorqueParseException;
import com.osp.icebreaker.scheduler.torque.parser.TorqueQstatJobsParser;
import com.osp.icebreaker.scheduler.torque.parser.TorqueQstatQueuesParser;
import com.osp.icebreaker.scheduler.torque.util.TorqueCommandOutput;
import com.osp.icebreaker.scheduler.torque.util.TorqueException;
import com.liferay.portal.kernel.json.JSONArray;
import com.liferay.portal.kernel.json.JSONFactoryUtil;
import com.liferay.portal.kernel.json.JSONObject;
import com.liferay.portal.kernel.util.StringPool;

public class Torque implements OSPScheduler{
	private static final String SEQ_RUN_SCRIPT="seq_run.pbs";
	
	@Override
	public String submitJob(
			String appBinDir,
			String solverExe,
			String runType,
			String inputArgs,
			String workingDir,
			String logFileName,
			String jobTitle,
			String nodes,
			String ppn,
			String qName,
			String wallTime
			) throws IOException{
		System.out.println("Qsub: "+this.COMMAND_QSUB);
		String input = "";
		
		if( workingDir == null || workingDir.isEmpty() ){
			//Set Default working dir 
		}
		
		this.createExeScript(appBinDir, solverExe, runType, inputArgs, workingDir, logFileName, jobTitle, nodes, ppn, qName, wallTime);
		
		//return this.qsub(input);
		String jobId = "";
		return jobId;
	}
	
	public void delete(){
		
	}
	
	@Override
	public void createExeScript(
			String appBinDir,
			String appExe,
			String runType,
			String inputArgs,
			String workingDir,
			String logFileName,
			String jobTitle,
			String nodes,
			String ppn,
			String qName,
			String wallTime
			) throws IOException {
		
		// create working directory if not exist
		Path workingPath = Paths.get("workingDir");
		if( ! Files.exists(workingPath) ){
			Files.createDirectories(workingPath);
		}
		
		StringBuilder out = new StringBuilder();
			out.append("#!/bin/sh");
			out.append(StringPool.NEW_LINE);
			out.append(StringPool.NEW_LINE);
			out.append( "#PBS -N " + jobTitle );
			out.append(StringPool.NEW_LINE);
			out.append("#PBS -d " + workingDir);
			out.append(StringPool.NEW_LINE);
			out.append("#PBS -q " + qName);
			out.append(StringPool.NEW_LINE);
			out.append("#PBS -o " + workingDir + File.separator+logFileName);
			out.append(StringPool.NEW_LINE);
			out.append("#PBS -j oe");
			out.append(StringPool.NEW_LINE);
			out.append("#PBS -l nodes=" + nodes + ":ppn=" + ppn);
			out.append(StringPool.NEW_LINE);
			out.append(StringPool.NEW_LINE);
			
			out.append("cd " + workingDir);
			out.append(StringPool.NEW_LINE);
			
			Path appBasePath = Paths.get(appBinDir);
			String[] runfiles = appBasePath.toFile().list();
			for( String fileName : runfiles ){
				out.append("ln -sf "+ appBasePath.resolve(fileName).toString()+" "+appExe);
				out.append(StringPool.NEW_LINE);
			}
			out.append(StringPool.NEW_LINE);
			
			out.append( "./" + appExe + " " + inputArgs );
			out.append(StringPool.NEW_LINE);
			out.append(StringPool.NEW_LINE);
			
			for( String fileName : runfiles ){
				out.append("rm -f "+ fileName);
				out.append(StringPool.NEW_LINE);
			}
			
			Path runScriptPath = Paths.get( workingDir+File.separator+SEQ_RUN_SCRIPT );
			System.out.println("runScriptPath: "+runScriptPath );
			System.out.println( out.toString() );
			Files.write(runScriptPath, out.toString().getBytes() );
	}
	
	@Override
	public JSONArray nodes() {
		List<TorqueNode> nodes = this.qnodes();
		JSONArray jsonNodes = JSONFactoryUtil.createJSONArray();
		for( TorqueNode node : nodes ){
			JSONObject jsonNode = JSONFactoryUtil.createJSONObject();
			jsonNodes.put(jsonNode);
			
			List<TorqueJob> jobs = node.getJobs();
			JSONArray jsonJobs = JSONFactoryUtil.createJSONArray();
			for( TorqueJob job : jobs ){
				JSONObject jsonJob = JSONFactoryUtil.createJSONObject();
				jsonJobs.put(jsonJob);
			}
			
			jsonNode.put( "name", node.getName() );
			jsonNode.put( "nodeType", node.getNodeType() );
			jsonNode.put( "nop", node.getNumberOfProcessors() );
			TorqueQueueState state = node.getState();
			jsonNode.put( "state", state.getState() );
			
			JSONArray jsonStatus = JSONFactoryUtil.createJSONArray();
			jsonNode.put("status", jsonStatus );
			Map<String, String> mapStatus = node.getStatus();
			Set<String> keys = mapStatus.keySet();
			for( String key : keys ){
				String status = mapStatus.get(key);
				JSONObject jsonStata = JSONFactoryUtil.createJSONObject();
				jsonStata.put(key, status);
			}
		}
		
		return jsonNodes;
	}

	@Override
	public JSONArray nodes(String qName) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public JSONArray queueState() {
		// TODO Auto-generated method stub
		return null;
	}

	/**
	 * Torque qnodes command.
	 * <p>
	 * Get information about the cluster nodes.
	 *
	 * @return list of nodes
	 * @throws TorqueException if an error communicating with the Torque occurs
	 */
	public List<TorqueNode> qnodes() {
		return this.qnodes(null);
	}

	/**
	 * this qnodes command.
	 * <p>
	 * Get information about the cluster nodes.
	 *
	 * @param name node name
	 * @return list of nodes
	 * @throws TorqueException if an error communicating with the Torque occurs
	 */
	public List<TorqueNode> qnodes(String name) {
		List<TorqueNode> nodes = null;

		final CommandLine cmdLine = CommandLine.parse(COMMAND_QNODES);
		cmdLine.addArgument(Torque.OPTION_XML);
		if (StringUtils.isNotBlank(name)) {
			cmdLine.addArgument(name);
		}
		
		System.out.println("Command Line: "+cmdLine.toString());

		final OutputStream outStream = new ByteArrayOutputStream();
		final OutputStream errorStream = new ByteArrayOutputStream();

		DefaultExecuteResultHandler resultHandler;
		try {
			resultHandler = execute(cmdLine, null, outStream, errorStream);
			resultHandler.waitFor(Torque.DEFAULT_TIMEOUT);
		}
		catch (ExecuteException e) {
			throw new TorqueException("Failed to execute qnodes command: " + e.getMessage(), e);
		} 
		catch (IOException e) {
			throw new TorqueException("Failed to execute qnodes command: " + e.getMessage(), e);
		} 
		catch (InterruptedException e) {
			throw new TorqueException("Failed to execute qnodes command: " + e.getMessage(), e);
		}

		final int exitValue = resultHandler.getExitValue();
		Torque.LOGGER.info("qnodes exit value: " + exitValue);
		
		try {
			nodes = Torque.NODE_XML_PARSER.parse(outStream.toString());
		} 
		catch (TorqueParseException pe) {
			throw new TorqueException("Failed to parse node XML: " + pe.getMessage(), pe);
		}
 
		return nodes;
	}

	/**
	 * Torque qstat command.
	 * <p>
	 * Equivalent to qstat -Q -f [name]
	 *
	 * @return list of queues
	 */
	public List<TorqueQueue> qstatQueues() {
		return qstatQueues(null);
	}

	/**
	 * Torque qstat command.
	 * <p>
	 * Equivalent to qstat -Q -f [queueName]
	 *
	 * @param name queue name
	 * @return list of queues
	 */
	public List<TorqueQueue> qstatQueues( String queueName ) {
		final CommandLine cmdLine = CommandLine.parse(this.COMMAND_QSTAT);
		cmdLine.addArgument(Torque.OPTION_FULL_STATUS);
		cmdLine.addArgument(Torque.OPTION_QUEUE);
		if (StringUtils.isNotBlank(queueName)) {
			cmdLine.addArgument(queueName);
		}

		final OutputStream outStream = new ByteArrayOutputStream();
		final OutputStream errorStream = new ByteArrayOutputStream();

		DefaultExecuteResultHandler resultHandler;
		try {
			resultHandler = execute(cmdLine, null, outStream, errorStream);
			resultHandler.waitFor(Torque.DEFAULT_TIMEOUT);
		}
		catch (ExecuteException e) {
			throw new TorqueException("Failed to execute qstat command: " + e.getMessage(), e);
		}
		catch (IOException e) {
			throw new TorqueException("Failed to execute qstat command: " + e.getMessage(), e);
		}
		catch (InterruptedException e) {
			throw new TorqueException("Failed to execute qstat command: " + e.getMessage(), e);
		}

		final int exitValue = resultHandler.getExitValue();
		Torque.LOGGER.info("qstat exit value: " + exitValue);

		final List<TorqueQueue> queues;
		try {
			queues = Torque.QSTAT_QUEUES_PARSER.parse(outStream.toString());
		}
		catch (TorqueParseException pe) {
			throw new TorqueException("Failed to parse qstat queues output: " + pe.getMessage(), pe);
		}

		return (queues == null ? new ArrayList<TorqueQueue>(0) : queues);
	}

	/**
	 * Torque qstat command.
	 * <p>
	 * Equivalent to qstat -f
	 *
	 * @return list of jobs
	 */
	public List<TorqueJob> qstat() {
		return qstat((String) null);
	}

	/**
	 * Torque qstat command.
	 * <p>
	 * Equivalent to qstat -f [queue_name]
	 *
	 * @param queue Torque {@link TorqueQueue}
	 * @return list of jobs
	 */
	public List<TorqueJob> qstat(TorqueQueue queue) {
		return qstat(queue.getName());
	}

	/**
	 * Torque qstat command.
	 * <p>
	 * Equivalent to qstat -f [job_name]
	 *
	 * @param job the Torque Job
	 * @return list of jobs
	 */
    public List<TorqueJob> qstat(TorqueJob job) {
        return qstat(job.getName());
    }

    /**
     * Torque qstat command.
     * <p>
     * Equivalent to qstat -f [param]
     *
     * @param name job name
     * @return list of jobs
     */
    public List<TorqueJob> qstat(String name) {
        final CommandLine cmdLine = CommandLine.parse(this.COMMAND_QSTAT);
        cmdLine.addArgument(Torque.OPTION_FULL_STATUS);
        if (StringUtils.isNotBlank(name)) {
            cmdLine.addArgument(name);
        }

        final OutputStream outStream = new ByteArrayOutputStream();
        final OutputStream errorStream = new ByteArrayOutputStream();

        DefaultExecuteResultHandler resultHandler;
        try {
            resultHandler = execute(cmdLine, null, outStream, errorStream);
            resultHandler.waitFor(Torque.DEFAULT_TIMEOUT);
        } catch (ExecuteException e) {
            throw new TorqueException("Failed to execute qstat command: " + e.getMessage(), e);
        } catch (IOException e) {
            throw new TorqueException("Failed to execute qstat command: " + e.getMessage(), e);
        } catch (InterruptedException e) {
            throw new TorqueException("Failed to execute qstat command: " + e.getMessage(), e);
        }

        final int exitValue = resultHandler.getExitValue();
        Torque.LOGGER.info("qstat exit value: " + exitValue);

        final List<TorqueJob> jobs;
        try {
            jobs = Torque.QSTAT_JOBS_PARSER.parse(outStream.toString());
        } catch (TorqueParseException pe) {
            throw new TorqueException("Failed to parse qstat jobs output: " + pe.getMessage(), pe);
        }

        return (jobs == null ? new ArrayList<TorqueJob>(0) : jobs);
    }

    /**
     * Torque qstat command for Array Jobs
     * <p>
     * Equivalent to qstat -f -t [param]
     *
     * @param name job name
     * @return list of jobs
     */
    public List<TorqueJob> qstatArrayJob(String name) {
        final CommandLine cmdLine = CommandLine.parse(this.COMMAND_QSTAT);
        cmdLine.addArgument(Torque.OPTION_FULL_STATUS);
        cmdLine.addArgument(Torque.OPTION_ARRAY_JOB_STATUS);
        if (StringUtils.isNotBlank(name)) {
            cmdLine.addArgument(name);
        }

        final OutputStream outStream = new ByteArrayOutputStream();
        final OutputStream errorStream = new ByteArrayOutputStream();

        DefaultExecuteResultHandler resultHandler;
        try {
            resultHandler = execute(cmdLine, outStream, errorStream);
            resultHandler.waitFor(Torque.DEFAULT_TIMEOUT);
        } catch (ExecuteException e) {
            throw new TorqueException("Failed to execute qstat command: " + e.getMessage(), e);
        } catch (IOException e) {
            throw new TorqueException("Failed to execute qstat command: " + e.getMessage(), e);
        } catch (InterruptedException e) {
            throw new TorqueException("Failed to execute qstat command: " + e.getMessage(), e);
        }

        final int exitValue = resultHandler.getExitValue();
        Torque.LOGGER.info("qstat exit value: " + exitValue);

        final List<TorqueJob> jobs;
        try {
            jobs = Torque.QSTAT_JOBS_PARSER.parse(outStream.toString());
        } catch (TorqueParseException pe) {
            throw new TorqueException("Failed to parse qstat jobs output: " + pe.getMessage(), pe);
        }

        return (jobs == null ? new ArrayList<TorqueJob>(0) : jobs);
    }

    /**
     * Torque qdel command.
     * <p>
     * Equivalent to qdel [param]
     *
     * @param jobId job id
     */
    public void qdel(String jobId) {
        final CommandLine cmdLine = CommandLine.parse(this.COMMAND_QDEL);
        cmdLine.addArgument(jobId);

        final OutputStream outStream = new ByteArrayOutputStream();
        final OutputStream errorStream = new ByteArrayOutputStream();

        DefaultExecuteResultHandler resultHandler;
        try {
            resultHandler = execute(cmdLine, null, outStream, errorStream);
            resultHandler.waitFor(Torque.DEFAULT_TIMEOUT);
        } catch (ExecuteException e) {
            throw new TorqueException("Failed to execute qdel command: " + e.getMessage(), e);
        } catch (IOException e) {
            throw new TorqueException("Failed to execute qdel command: " + e.getMessage(), e);
        } catch (InterruptedException e) {
            throw new TorqueException("Failed to execute qdel command: " + e.getMessage(), e);
        }

        final int exitValue = resultHandler.getExitValue();
        Torque.LOGGER.info("qdel exit value: " + exitValue);

        if (exitValue != 0)
            throw new TorqueException("Failed to delete job " + jobId + ". Error output: " + errorStream.toString());
    }

    /**
     * Torque qsub command.
     * <p>
     * Equivalent to qsub [param]
     *
     * @param input job input file
     * @return job id
     */
    public String qsub(String input) {
        final CommandLine cmdLine = CommandLine.parse(this.COMMAND_QSUB);
        cmdLine.addArgument(input);

        final OutputStream outStream = new ByteArrayOutputStream();
        final OutputStream errorStream = new ByteArrayOutputStream();

        DefaultExecuteResultHandler resultHandler;
        try {
            resultHandler = execute(cmdLine, null, outStream, errorStream);
            resultHandler.waitFor(Torque.DEFAULT_TIMEOUT);
        } catch (ExecuteException e) {
            throw new TorqueException("Failed to execute qsub command: " + e.getMessage(), e);
        } catch (IOException e) {
            throw new TorqueException("Failed to execute qsub command: " + e.getMessage(), e);
        } catch (InterruptedException e) {
            throw new TorqueException("Failed to execute qsub command: " + e.getMessage(), e);
        }

        final int exitValue = resultHandler.getExitValue();
        Torque.LOGGER.info("qsub exit value: " + exitValue);
        Torque.LOGGER.fine("qsub output: " + outStream.toString());

        if (exitValue != 0)
            throw new TorqueException("Failed to submit job script " + input + ". Error output: " + errorStream.toString());

        String jobId = outStream.toString();
        return jobId.trim();
    }

    /**
     * <p>
     * Torque qsub command with arguments resource overrides
     * </p>
     *
     * <p>
     * Equivalent to qsub [param] -l [resource_name=value,resource_name=value]]
     * </p>
     *
     * @param input job input file
     * @param resourceOverrides variable number of resources to override
     * @return job id
     */
    public String qsub(String input, String... resourceOverrides) {
        final CommandLine cmdLine = CommandLine.parse(this.COMMAND_QSUB);
        cmdLine.addArgument(Torque.OPTION_RESOURCE_OVERRIDE_STATUS);
        String resourceOverrideArgument = StringUtils.join(resourceOverrides, ",");
        cmdLine.addArgument(resourceOverrideArgument);
        cmdLine.addArgument(input);

        final OutputStream outStream = new ByteArrayOutputStream();
        final OutputStream errorStream = new ByteArrayOutputStream();

        DefaultExecuteResultHandler resultHandler;
        try {
            resultHandler = execute(cmdLine, outStream, errorStream);
            resultHandler.waitFor(Torque.DEFAULT_TIMEOUT);
        } catch (ExecuteException e) {
            throw new TorqueException("Failed to execute qsub command: " + e.getMessage(), e);
        } catch (IOException e) {
            throw new TorqueException("Failed to execute qsub command: " + e.getMessage(), e);
        } catch (InterruptedException e) {
            throw new TorqueException("Failed to execute qsub command: " + e.getMessage(), e);
        }

        final int exitValue = resultHandler.getExitValue();
        Torque.LOGGER.info("qsub exit value: " + exitValue);
        Torque.LOGGER.fine("qsub output: " + outStream.toString());

        if (exitValue != 0)
            throw new TorqueException("Failed to submit job script " + input + ". Error output: " + errorStream.toString());

        String jobId = outStream.toString();
        return jobId.trim();
    }

    /**
     * Torque qsub command for an Array Job with Specific TORQUE_ARRAY_IDs to submit
     * <p>
     * Equivalent to qsub -t 1,2,3 [param]
     *
     * @param input job input file
     * @param torqueArrayIDs list of specified Torque indices
     * @return job id of array job
     */
    public String qsubArrayJob(String input, List<Integer> torqueArrayIDs) {
        final CommandLine cmdLine = CommandLine.parse(this.COMMAND_QSUB);
        cmdLine.addArgument(Torque.OPTION_ARRAY_JOB_STATUS);
        String listArgument = StringUtils.join(torqueArrayIDs, ",");
        cmdLine.addArgument(listArgument);
        cmdLine.addArgument(input);

        final OutputStream outStream = new ByteArrayOutputStream();
        final OutputStream errorStream = new ByteArrayOutputStream();

        DefaultExecuteResultHandler resultHandler;
        try {
            resultHandler = this.execute(cmdLine, outStream, errorStream);
            resultHandler.waitFor(Torque.DEFAULT_TIMEOUT);
        } catch (ExecuteException e) {
            throw new TorqueException("Failed to execute qsub command: " + e.getMessage(), e);
        } catch (IOException e) {
            throw new TorqueException("Failed to execute qsub command: " + e.getMessage(), e);
        } catch (InterruptedException e) {
            throw new TorqueException("Failed to execute qsub command: " + e.getMessage(), e);
        }

        final int exitValue = resultHandler.getExitValue();
        Torque.LOGGER.info("qsub exit value: " + exitValue);
        Torque.LOGGER.fine("qsub output: " + outStream.toString());

        if (exitValue != 0)
            throw new TorqueException("Failed to submit job script " + input + ". Error output: " + errorStream.toString());

        String jobId = outStream.toString();
        return jobId.trim();
    }

    /**
     * Torque qsub command.
     * <p>
     * Equivalent to qsub [param]
     *
     * @param inputs job input file
     * @param environment environment variables
     * @return job id
     */
    public String qsub(String[] inputs, Map<String, String> environment) {
        final CommandLine cmdLine = CommandLine.parse(this.COMMAND_QSUB);
        for (int i = 0; i < inputs.length; ++i) {
            cmdLine.addArgument(inputs[i]);
        }

        final OutputStream outStream = new ByteArrayOutputStream();
        final OutputStream errorStream = new ByteArrayOutputStream();

        DefaultExecuteResultHandler resultHandler;
        try {
            resultHandler = execute(cmdLine, environment, outStream, errorStream);
            resultHandler.waitFor(Torque.DEFAULT_TIMEOUT);
        } catch (ExecuteException e) {
            throw new TorqueException("Failed to execute qsub command: " + e.getMessage(), e);
        } catch (IOException e) {
            throw new TorqueException("Failed to execute qsub command: " + e.getMessage(), e);
        } catch (InterruptedException e) {
            throw new TorqueException("Failed to execute qsub command: " + e.getMessage(), e);
        }

        final int exitValue = resultHandler.getExitValue();
        Torque.LOGGER.info("qsub exit value: " + exitValue);
        Torque.LOGGER.fine("qsub output: " + outStream.toString());

        if (exitValue != 0) {
            throw new TorqueException("Failed to submit job script with command line '" + cmdLine.toString()
            + "'. Error output: " + errorStream.toString());
        }

        String jobId = outStream.toString();
        return jobId.trim();
    }

    /**
     * Torque qsub command for an Array Job with Specific TORQUE_ARRAY_IDs to submit, and resource overrides
     * <p>
     * Equivalent to qsub -t 1,2,3 -l [resource_name=value,resource_name=value] [param]
     *
     * @param input job input file
     * @param torqueArrayIDs of specified Torque indices
     * @param resourceOverrides list of resource overrides
     * @return job id of array job
     */
    public String qsubArrayJob(String input, List<Integer> torqueArrayIDs, String... resourceOverrides) {
        final CommandLine cmdLine = CommandLine.parse(this.COMMAND_QSUB);
        cmdLine.addArgument(Torque.OPTION_ARRAY_JOB_STATUS);
        String listArgument = StringUtils.join(torqueArrayIDs, ",");
        cmdLine.addArgument(listArgument);
        cmdLine.addArgument(Torque.OPTION_RESOURCE_OVERRIDE_STATUS);
        String resourceOverrideArgument = StringUtils.join(resourceOverrides, ",");
        cmdLine.addArgument(resourceOverrideArgument);
        cmdLine.addArgument(input);

        final OutputStream outStream = new ByteArrayOutputStream();
        final OutputStream errorStream = new ByteArrayOutputStream();

        DefaultExecuteResultHandler resultHandler;
        try {
            resultHandler = execute(cmdLine, outStream, errorStream);
            resultHandler.waitFor(Torque.DEFAULT_TIMEOUT);
        } catch (ExecuteException e) {
            throw new TorqueException("Failed to execute qsub command: " + e.getMessage(), e);
        } catch (IOException e) {
            throw new TorqueException("Failed to execute qsub command: " + e.getMessage(), e);
        } catch (InterruptedException e) {
            throw new TorqueException("Failed to execute qsub command: " + e.getMessage(), e);
        }

        final int exitValue = resultHandler.getExitValue();
        Torque.LOGGER.info("qsub exit value: " + exitValue);
        Torque.LOGGER.fine("qsub output: " + outStream.toString());

        if (exitValue != 0)
            throw new TorqueException("Failed to submit job script " + input + ". Error output: " + errorStream.toString());

        String jobId = outStream.toString();
        return jobId.trim();
    }

    /**
     * Torque qsub command for an Array Job with Specific TORQUE_ARRAY_IDs to submit
     * <p>
     * Equivalent to qsub -t 5-20 [param]
     *
     * @param input job input file
     * @param beginIndex beginning of index range
     * @param endIndex end of index range
     * @return job id of array job
     */
    public String qsubArrayJob(String input, int beginIndex, int endIndex) {
        final CommandLine cmdLine = CommandLine.parse(this.COMMAND_QSUB);
        cmdLine.addArgument(Torque.OPTION_ARRAY_JOB_STATUS);
        String rangeArgument = beginIndex + "-" + endIndex;
        cmdLine.addArgument(rangeArgument);
        cmdLine.addArgument(input);

        final OutputStream outStream = new ByteArrayOutputStream();
        final OutputStream errorStream = new ByteArrayOutputStream();

        DefaultExecuteResultHandler resultHandler;
        try {
            resultHandler = this.execute(cmdLine, outStream, errorStream);
            resultHandler.waitFor(Torque.DEFAULT_TIMEOUT);
        } catch (ExecuteException e) {
            throw new TorqueException("Failed to execute qsub command: " + e.getMessage(), e);
        } catch (IOException e) {
            throw new TorqueException("Failed to execute qsub command: " + e.getMessage(), e);
        } catch (InterruptedException e) {
            throw new TorqueException("Failed to execute qsub command: " + e.getMessage(), e);
        }

        final int exitValue = resultHandler.getExitValue();
        Torque.LOGGER.info("qsub exit value: " + exitValue);
        Torque.LOGGER.fine("qsub output: " + outStream.toString());

        if (exitValue != 0)
            throw new TorqueException("Failed to submit job script " + input + ". Error output: " + errorStream.toString());

        String jobId = outStream.toString();
        return jobId.trim();
    }

    /**
     * Torque qsub command for an Array Job with Specific TORQUE_ARRAY_IDs to submit AND a range to submit
     * <p>
     * Equivalent to qsub -t 1,2,3,5-20 [param]
     *
     * @param input job input file
     * @param torqueArrayIDs list of specified indices
     * @param beginIndex beginning of index range
     * @param endIndex end of index range
     * @return job id of array job
     */
    public String qsubArrayJob(String input, List<Integer> torqueArrayIDs, int beginIndex, int endIndex) {
        final CommandLine cmdLine = CommandLine.parse(this.COMMAND_QSUB);
        cmdLine.addArgument(Torque.OPTION_ARRAY_JOB_STATUS);
        String rangeArgument = beginIndex + "-" + endIndex;
        String listArgument = StringUtils.join(torqueArrayIDs, ",");
        String combinedArgument = listArgument + "," + rangeArgument;
        cmdLine.addArgument(combinedArgument);
        cmdLine.addArgument(input);

        final OutputStream outStream = new ByteArrayOutputStream();
        final OutputStream errorStream = new ByteArrayOutputStream();

        DefaultExecuteResultHandler resultHandler;
        try {
            resultHandler = this.execute(cmdLine, outStream, errorStream);
            resultHandler.waitFor(Torque.DEFAULT_TIMEOUT);
        } catch (ExecuteException e) {
            throw new TorqueException("Failed to execute qsub command: " + e.getMessage(), e);
        } catch (IOException e) {
            throw new TorqueException("Failed to execute qsub command: " + e.getMessage(), e);
        } catch (InterruptedException e) {
            throw new TorqueException("Failed to execute qsub command: " + e.getMessage(), e);
        }

        final int exitValue = resultHandler.getExitValue();
        Torque.LOGGER.info("qsub exit value: " + exitValue);
        Torque.LOGGER.fine("qsub output: " + outStream.toString());

        if (exitValue != 0)
            throw new TorqueException("Failed to submit job script " + input + ". Error output: " + errorStream.toString());

        String jobId = outStream.toString();
        return jobId.trim();
    }

    /**
     * <p>
     * Torque tracejob command.
     * </p>
     * <p>
     * Equivalent to tracejob -n [numberOfDays] [jobId]
     * </p>
     *
     * @param jobId job id
     * @param numberOfDays number of days to look for the job
     * @return tracejob output
     */
    public TorqueCommandOutput traceJob(String jobId, int numberOfDays) {
        return traceJob(jobId, numberOfDays, true /* quiet */);
    }

    /**
     * Torque tracejob command.
     * <p>
     * Equivalent to tracejob -n [numberOfDays] [jobId]
     *
     * @param jobId job id
     * @param numberOfDays number of days to look for the job
     * @param quiet quiet mode flag
     * @return tracejob output
     */
    public TorqueCommandOutput traceJob(String jobId, int numberOfDays, boolean quiet) {
        final CommandLine cmdLine = CommandLine.parse(this.COMMAND_TRACEJOB);
        cmdLine.addArgument(Torque.OPTION_NUMBER_OF_DAYS);
        cmdLine.addArgument(Integer.toString(numberOfDays));
        if (quiet) {
            cmdLine.addArgument(Torque.OPTION_QUIET_MODE);
        }
        cmdLine.addArgument(jobId);

        final OutputStream outStream = new ByteArrayOutputStream();
        final OutputStream errorStream = new ByteArrayOutputStream();

        DefaultExecuteResultHandler resultHandler;
        try {
            resultHandler = this.execute(cmdLine, null, outStream, errorStream);
            resultHandler.waitFor(Torque.DEFAULT_TIMEOUT);
        } catch (ExecuteException e) {
            throw new TorqueException("Failed to execute tracejob command: " + e.getMessage(), e);
        } catch (IOException e) {
            throw new TorqueException("Failed to execute tracejob command: " + e.getMessage(), e);
        } catch (InterruptedException e) {
            throw new TorqueException("Failed to execute tracejob command: " + e.getMessage(), e);
        }

        final int exitValue = resultHandler.getExitValue();
        Torque.LOGGER.info("tracejob exit value: " + exitValue);
        Torque.LOGGER.fine("tracejob output: " + outStream.toString());

        return new TorqueCommandOutput(outStream.toString(), errorStream.toString());
    }

    /**
     * Executes a Torque command.
     *
     * @param cmdLine command
     * @param outStream output stream
     * @param errorStream error stream
     * @return execute handler
     * @throws ExecuteException
     * @throws IOException
     */
    DefaultExecuteResultHandler execute(CommandLine cmdLine, OutputStream outStream, OutputStream errorStream)
            throws ExecuteException, IOException {
        return execute(cmdLine, Collections.<String, String> emptyMap(), outStream, errorStream);
    }

    /**
     * Executes a Torque command.
     *
     * @param cmdLine command
     * @param environment env vars
     * @param outStream output stream
     * @param errorStream error stream
     * @return execute handler
     * @throws ExecuteException if there is an error executing a command
     * @throws IOException in case of an IO problem
     */
    DefaultExecuteResultHandler execute(CommandLine cmdLine, Map<String, String> environment, OutputStream outStream,
            OutputStream errorStream) throws ExecuteException, IOException {
        DefaultExecuteResultHandler resultHandler = new DefaultExecuteResultHandler();
        ExecuteStreamHandler streamHandler = new PumpStreamHandler(outStream, errorStream);
        DefaultExecutor executor = new DefaultExecutor();
        executor.setExitValue(0);
        executor.setStreamHandler(streamHandler);
        if (environment != null) {
            executor.execute(cmdLine, environment, resultHandler);
        } else {
            executor.execute(cmdLine, resultHandler);
        }
        return resultHandler;
    }

    private static final Logger LOGGER = Logger.getLogger(Torque.class.getName());
    
    private String COMMAND_QNODES = "qnodes";
    private String COMMAND_QSTAT = "qstat";
    private String COMMAND_QDEL = "qdel";
    private String COMMAND_QSUB = "qsub";
    private String COMMAND_TRACEJOB = "tracejob";
    // qstat
    private static final String OPTION_XML = "-x";
    private static final String OPTION_FULL_STATUS = "-f";
    private static final String OPTION_ARRAY_JOB_STATUS = "-t";
    private static final String OPTION_RESOURCE_OVERRIDE_STATUS = "-l";
    private static final String OPTION_QUEUE = "-Q";
    // tracejob
    private static final String OPTION_NUMBER_OF_DAYS = "-n";
    private static final String OPTION_QUIET_MODE = "-q";

    private static final TorqueNodeXmlParser NODE_XML_PARSER = new TorqueNodeXmlParser();
    private static final TorqueQstatQueuesParser QSTAT_QUEUES_PARSER = new TorqueQstatQueuesParser();
    private static final TorqueQstatJobsParser QSTAT_JOBS_PARSER = new TorqueQstatJobsParser();

    public Torque( String user, String password, String ip, String port){
    	StringBuilder prefix = new StringBuilder();
    	prefix.append("sshpass -p");
    	prefix.append(password);
    	prefix.append(StringPool.SPACE);
    	prefix.append("ssh -p");
    	prefix.append(StringPool.SPACE);
    	prefix.append(port);
    	prefix.append(StringPool.SPACE);
    	prefix.append(user);
    	prefix.append(StringPool.AT);
    	prefix.append(ip);
    	prefix.append(StringPool.SPACE);
    	
    	this.COMMAND_QNODES = prefix.toString() + this.COMMAND_QNODES;
    	this.COMMAND_QSTAT = prefix.toString() + this.COMMAND_QSTAT;
    	this.COMMAND_QDEL = prefix.toString() + this.COMMAND_QDEL;
    	this.COMMAND_QSUB = prefix.toString() + this.COMMAND_QSUB;
    	this.COMMAND_TRACEJOB = prefix.toString() + this.COMMAND_TRACEJOB;
    }
    /**
     * Default time-out for process execution.
     */
    private static final int DEFAULT_TIMEOUT = 60000;

}
