/**
 * Copyright (c) 2000-present Liferay, Inc. All rights reserved.
 *
 * This library is free software; you can redistribute it and/or modify it under
 * the terms of the GNU Lesser General Public License as published by the Free
 * Software Foundation; either version 2.1 of the License, or (at your option)
 * any later version.
 *
 * This library is distributed in the hope that it will be useful, but WITHOUT
 * ANY WARRANTY; without even the implied warranty of MERCHANTABILITY or FITNESS
 * FOR A PARTICULAR PURPOSE. See the GNU Lesser General Public License for more
 * details.
 */

package com.osp.icebreaker.model;

import com.liferay.exportimport.kernel.lar.StagedModelType;
import com.liferay.portal.kernel.model.ModelWrapper;
import com.liferay.portal.kernel.model.wrapper.BaseModelWrapper;

import java.util.Date;
import java.util.HashMap;
import java.util.Map;

/**
 * <p>
 * This class is a wrapper for {@link Job}.
 * </p>
 *
 * @author Jerry H. Seo
 * @see Job
 * @generated
 */
public class JobWrapper
	extends BaseModelWrapper<Job> implements Job, ModelWrapper<Job> {

	public JobWrapper(Job job) {
		super(job);
	}

	@Override
	public Map<String, Object> getModelAttributes() {
		Map<String, Object> attributes = new HashMap<String, Object>();

		attributes.put("uuid", getUuid());
		attributes.put("jobId", getJobId());
		attributes.put("jobName", getJobName());
		attributes.put("companyId", getCompanyId());
		attributes.put("groupId", getGroupId());
		attributes.put("userId", getUserId());
		attributes.put("clusterId", getClusterId());
		attributes.put("status", getStatus());
		attributes.put("submitId", getSubmitId());
		attributes.put("solverExe", getSolverExe());
		attributes.put("workingDir", getWorkingDir());
		attributes.put("runType", getRunType());
		attributes.put("logFileName", getLogFileName());
		attributes.put("title", getTitle());
		attributes.put("queueName", getQueueName());
		attributes.put("command", getCommand());
		attributes.put("referenceFiles", getReferenceFiles());
		attributes.put("environmentVars", getEnvironmentVars());
		attributes.put("nodes", getNodes());
		attributes.put("processorsPerNode", getProcessorsPerNode());
		attributes.put("wallTime", getWallTime());
		attributes.put("eligibleTime", getEligibleTime());
		attributes.put("afterAny", getAfterAny());
		attributes.put("afterOk", getAfterOk());
		attributes.put("submitArgs", getSubmitArgs());
		attributes.put("jobStatus", getJobStatus());
		attributes.put("reserveResults", isReserveResults());
		attributes.put("createDate", getCreateDate());
		attributes.put("modifiedDate", getModifiedDate());
		attributes.put("queuedDate", getQueuedDate());
		attributes.put("startDate", getStartDate());
		attributes.put("completeDate", getCompleteDate());
		attributes.put("usedMemory", getUsedMemory());
		attributes.put("usedCpuTime", getUsedCpuTime());
		attributes.put("usedWalltime", getUsedWalltime());

		return attributes;
	}

	@Override
	public void setModelAttributes(Map<String, Object> attributes) {
		String uuid = (String)attributes.get("uuid");

		if (uuid != null) {
			setUuid(uuid);
		}

		Long jobId = (Long)attributes.get("jobId");

		if (jobId != null) {
			setJobId(jobId);
		}

		String jobName = (String)attributes.get("jobName");

		if (jobName != null) {
			setJobName(jobName);
		}

		Long companyId = (Long)attributes.get("companyId");

		if (companyId != null) {
			setCompanyId(companyId);
		}

		Long groupId = (Long)attributes.get("groupId");

		if (groupId != null) {
			setGroupId(groupId);
		}

		Long userId = (Long)attributes.get("userId");

		if (userId != null) {
			setUserId(userId);
		}

		Long clusterId = (Long)attributes.get("clusterId");

		if (clusterId != null) {
			setClusterId(clusterId);
		}

		Integer status = (Integer)attributes.get("status");

		if (status != null) {
			setStatus(status);
		}

		String submitId = (String)attributes.get("submitId");

		if (submitId != null) {
			setSubmitId(submitId);
		}

		String solverExe = (String)attributes.get("solverExe");

		if (solverExe != null) {
			setSolverExe(solverExe);
		}

		String workingDir = (String)attributes.get("workingDir");

		if (workingDir != null) {
			setWorkingDir(workingDir);
		}

		String runType = (String)attributes.get("runType");

		if (runType != null) {
			setRunType(runType);
		}

		String logFileName = (String)attributes.get("logFileName");

		if (logFileName != null) {
			setLogFileName(logFileName);
		}

		String title = (String)attributes.get("title");

		if (title != null) {
			setTitle(title);
		}

		String queueName = (String)attributes.get("queueName");

		if (queueName != null) {
			setQueueName(queueName);
		}

		String command = (String)attributes.get("command");

		if (command != null) {
			setCommand(command);
		}

		String referenceFiles = (String)attributes.get("referenceFiles");

		if (referenceFiles != null) {
			setReferenceFiles(referenceFiles);
		}

		String environmentVars = (String)attributes.get("environmentVars");

		if (environmentVars != null) {
			setEnvironmentVars(environmentVars);
		}

		Integer nodes = (Integer)attributes.get("nodes");

		if (nodes != null) {
			setNodes(nodes);
		}

		Integer processorsPerNode = (Integer)attributes.get(
			"processorsPerNode");

		if (processorsPerNode != null) {
			setProcessorsPerNode(processorsPerNode);
		}

		String wallTime = (String)attributes.get("wallTime");

		if (wallTime != null) {
			setWallTime(wallTime);
		}

		String eligibleTime = (String)attributes.get("eligibleTime");

		if (eligibleTime != null) {
			setEligibleTime(eligibleTime);
		}

		String afterAny = (String)attributes.get("afterAny");

		if (afterAny != null) {
			setAfterAny(afterAny);
		}

		String afterOk = (String)attributes.get("afterOk");

		if (afterOk != null) {
			setAfterOk(afterOk);
		}

		String submitArgs = (String)attributes.get("submitArgs");

		if (submitArgs != null) {
			setSubmitArgs(submitArgs);
		}

		Integer jobStatus = (Integer)attributes.get("jobStatus");

		if (jobStatus != null) {
			setJobStatus(jobStatus);
		}

		Boolean reserveResults = (Boolean)attributes.get("reserveResults");

		if (reserveResults != null) {
			setReserveResults(reserveResults);
		}

		Date createDate = (Date)attributes.get("createDate");

		if (createDate != null) {
			setCreateDate(createDate);
		}

		Date modifiedDate = (Date)attributes.get("modifiedDate");

		if (modifiedDate != null) {
			setModifiedDate(modifiedDate);
		}

		Date queuedDate = (Date)attributes.get("queuedDate");

		if (queuedDate != null) {
			setQueuedDate(queuedDate);
		}

		Date startDate = (Date)attributes.get("startDate");

		if (startDate != null) {
			setStartDate(startDate);
		}

		Date completeDate = (Date)attributes.get("completeDate");

		if (completeDate != null) {
			setCompleteDate(completeDate);
		}

		String usedMemory = (String)attributes.get("usedMemory");

		if (usedMemory != null) {
			setUsedMemory(usedMemory);
		}

		String usedCpuTime = (String)attributes.get("usedCpuTime");

		if (usedCpuTime != null) {
			setUsedCpuTime(usedCpuTime);
		}

		String usedWalltime = (String)attributes.get("usedWalltime");

		if (usedWalltime != null) {
			setUsedWalltime(usedWalltime);
		}
	}

	/**
	 * Returns the after any of this job.
	 *
	 * @return the after any of this job
	 */
	@Override
	public String getAfterAny() {
		return model.getAfterAny();
	}

	/**
	 * Returns the after ok of this job.
	 *
	 * @return the after ok of this job
	 */
	@Override
	public String getAfterOk() {
		return model.getAfterOk();
	}

	/**
	 * Returns the cluster ID of this job.
	 *
	 * @return the cluster ID of this job
	 */
	@Override
	public long getClusterId() {
		return model.getClusterId();
	}

	/**
	 * Returns the command of this job.
	 *
	 * @return the command of this job
	 */
	@Override
	public String getCommand() {
		return model.getCommand();
	}

	/**
	 * Returns the company ID of this job.
	 *
	 * @return the company ID of this job
	 */
	@Override
	public long getCompanyId() {
		return model.getCompanyId();
	}

	/**
	 * Returns the complete date of this job.
	 *
	 * @return the complete date of this job
	 */
	@Override
	public Date getCompleteDate() {
		return model.getCompleteDate();
	}

	/**
	 * Returns the create date of this job.
	 *
	 * @return the create date of this job
	 */
	@Override
	public Date getCreateDate() {
		return model.getCreateDate();
	}

	/**
	 * Returns the eligible time of this job.
	 *
	 * @return the eligible time of this job
	 */
	@Override
	public String getEligibleTime() {
		return model.getEligibleTime();
	}

	/**
	 * Returns the environment vars of this job.
	 *
	 * @return the environment vars of this job
	 */
	@Override
	public String getEnvironmentVars() {
		return model.getEnvironmentVars();
	}

	/**
	 * Returns the group ID of this job.
	 *
	 * @return the group ID of this job
	 */
	@Override
	public long getGroupId() {
		return model.getGroupId();
	}

	/**
	 * Returns the job ID of this job.
	 *
	 * @return the job ID of this job
	 */
	@Override
	public long getJobId() {
		return model.getJobId();
	}

	/**
	 * Returns the job name of this job.
	 *
	 * @return the job name of this job
	 */
	@Override
	public String getJobName() {
		return model.getJobName();
	}

	/**
	 * Returns the job status of this job.
	 *
	 * @return the job status of this job
	 */
	@Override
	public int getJobStatus() {
		return model.getJobStatus();
	}

	/**
	 * Returns the log file name of this job.
	 *
	 * @return the log file name of this job
	 */
	@Override
	public String getLogFileName() {
		return model.getLogFileName();
	}

	/**
	 * Returns the modified date of this job.
	 *
	 * @return the modified date of this job
	 */
	@Override
	public Date getModifiedDate() {
		return model.getModifiedDate();
	}

	/**
	 * Returns the nodes of this job.
	 *
	 * @return the nodes of this job
	 */
	@Override
	public int getNodes() {
		return model.getNodes();
	}

	/**
	 * Returns the primary key of this job.
	 *
	 * @return the primary key of this job
	 */
	@Override
	public long getPrimaryKey() {
		return model.getPrimaryKey();
	}

	/**
	 * Returns the processors per node of this job.
	 *
	 * @return the processors per node of this job
	 */
	@Override
	public int getProcessorsPerNode() {
		return model.getProcessorsPerNode();
	}

	/**
	 * Returns the queued date of this job.
	 *
	 * @return the queued date of this job
	 */
	@Override
	public Date getQueuedDate() {
		return model.getQueuedDate();
	}

	/**
	 * Returns the queue name of this job.
	 *
	 * @return the queue name of this job
	 */
	@Override
	public String getQueueName() {
		return model.getQueueName();
	}

	/**
	 * Returns the reference files of this job.
	 *
	 * @return the reference files of this job
	 */
	@Override
	public String getReferenceFiles() {
		return model.getReferenceFiles();
	}

	/**
	 * Returns the reserve results of this job.
	 *
	 * @return the reserve results of this job
	 */
	@Override
	public boolean getReserveResults() {
		return model.getReserveResults();
	}

	/**
	 * Returns the run type of this job.
	 *
	 * @return the run type of this job
	 */
	@Override
	public String getRunType() {
		return model.getRunType();
	}

	/**
	 * Returns the solver exe of this job.
	 *
	 * @return the solver exe of this job
	 */
	@Override
	public String getSolverExe() {
		return model.getSolverExe();
	}

	/**
	 * Returns the start date of this job.
	 *
	 * @return the start date of this job
	 */
	@Override
	public Date getStartDate() {
		return model.getStartDate();
	}

	/**
	 * Returns the status of this job.
	 *
	 * @return the status of this job
	 */
	@Override
	public int getStatus() {
		return model.getStatus();
	}

	/**
	 * Returns the submit args of this job.
	 *
	 * @return the submit args of this job
	 */
	@Override
	public String getSubmitArgs() {
		return model.getSubmitArgs();
	}

	/**
	 * Returns the submit ID of this job.
	 *
	 * @return the submit ID of this job
	 */
	@Override
	public String getSubmitId() {
		return model.getSubmitId();
	}

	/**
	 * Returns the title of this job.
	 *
	 * @return the title of this job
	 */
	@Override
	public String getTitle() {
		return model.getTitle();
	}

	/**
	 * Returns the used cpu time of this job.
	 *
	 * @return the used cpu time of this job
	 */
	@Override
	public String getUsedCpuTime() {
		return model.getUsedCpuTime();
	}

	/**
	 * Returns the used memory of this job.
	 *
	 * @return the used memory of this job
	 */
	@Override
	public String getUsedMemory() {
		return model.getUsedMemory();
	}

	/**
	 * Returns the used walltime of this job.
	 *
	 * @return the used walltime of this job
	 */
	@Override
	public String getUsedWalltime() {
		return model.getUsedWalltime();
	}

	/**
	 * Returns the user ID of this job.
	 *
	 * @return the user ID of this job
	 */
	@Override
	public long getUserId() {
		return model.getUserId();
	}

	/**
	 * Returns the user uuid of this job.
	 *
	 * @return the user uuid of this job
	 */
	@Override
	public String getUserUuid() {
		return model.getUserUuid();
	}

	/**
	 * Returns the uuid of this job.
	 *
	 * @return the uuid of this job
	 */
	@Override
	public String getUuid() {
		return model.getUuid();
	}

	/**
	 * Returns the wall time of this job.
	 *
	 * @return the wall time of this job
	 */
	@Override
	public String getWallTime() {
		return model.getWallTime();
	}

	/**
	 * Returns the working dir of this job.
	 *
	 * @return the working dir of this job
	 */
	@Override
	public String getWorkingDir() {
		return model.getWorkingDir();
	}

	/**
	 * Returns <code>true</code> if this job is reserve results.
	 *
	 * @return <code>true</code> if this job is reserve results; <code>false</code> otherwise
	 */
	@Override
	public boolean isReserveResults() {
		return model.isReserveResults();
	}

	@Override
	public void persist() {
		model.persist();
	}

	/**
	 * Sets the after any of this job.
	 *
	 * @param afterAny the after any of this job
	 */
	@Override
	public void setAfterAny(String afterAny) {
		model.setAfterAny(afterAny);
	}

	/**
	 * Sets the after ok of this job.
	 *
	 * @param afterOk the after ok of this job
	 */
	@Override
	public void setAfterOk(String afterOk) {
		model.setAfterOk(afterOk);
	}

	/**
	 * Sets the cluster ID of this job.
	 *
	 * @param clusterId the cluster ID of this job
	 */
	@Override
	public void setClusterId(long clusterId) {
		model.setClusterId(clusterId);
	}

	/**
	 * Sets the command of this job.
	 *
	 * @param command the command of this job
	 */
	@Override
	public void setCommand(String command) {
		model.setCommand(command);
	}

	/**
	 * Sets the company ID of this job.
	 *
	 * @param companyId the company ID of this job
	 */
	@Override
	public void setCompanyId(long companyId) {
		model.setCompanyId(companyId);
	}

	/**
	 * Sets the complete date of this job.
	 *
	 * @param completeDate the complete date of this job
	 */
	@Override
	public void setCompleteDate(Date completeDate) {
		model.setCompleteDate(completeDate);
	}

	/**
	 * Sets the create date of this job.
	 *
	 * @param createDate the create date of this job
	 */
	@Override
	public void setCreateDate(Date createDate) {
		model.setCreateDate(createDate);
	}

	/**
	 * Sets the eligible time of this job.
	 *
	 * @param eligibleTime the eligible time of this job
	 */
	@Override
	public void setEligibleTime(String eligibleTime) {
		model.setEligibleTime(eligibleTime);
	}

	/**
	 * Sets the environment vars of this job.
	 *
	 * @param environmentVars the environment vars of this job
	 */
	@Override
	public void setEnvironmentVars(String environmentVars) {
		model.setEnvironmentVars(environmentVars);
	}

	/**
	 * Sets the group ID of this job.
	 *
	 * @param groupId the group ID of this job
	 */
	@Override
	public void setGroupId(long groupId) {
		model.setGroupId(groupId);
	}

	/**
	 * Sets the job ID of this job.
	 *
	 * @param jobId the job ID of this job
	 */
	@Override
	public void setJobId(long jobId) {
		model.setJobId(jobId);
	}

	/**
	 * Sets the job name of this job.
	 *
	 * @param jobName the job name of this job
	 */
	@Override
	public void setJobName(String jobName) {
		model.setJobName(jobName);
	}

	/**
	 * Sets the job status of this job.
	 *
	 * @param jobStatus the job status of this job
	 */
	@Override
	public void setJobStatus(int jobStatus) {
		model.setJobStatus(jobStatus);
	}

	/**
	 * Sets the log file name of this job.
	 *
	 * @param logFileName the log file name of this job
	 */
	@Override
	public void setLogFileName(String logFileName) {
		model.setLogFileName(logFileName);
	}

	/**
	 * Sets the modified date of this job.
	 *
	 * @param modifiedDate the modified date of this job
	 */
	@Override
	public void setModifiedDate(Date modifiedDate) {
		model.setModifiedDate(modifiedDate);
	}

	/**
	 * Sets the nodes of this job.
	 *
	 * @param nodes the nodes of this job
	 */
	@Override
	public void setNodes(int nodes) {
		model.setNodes(nodes);
	}

	/**
	 * Sets the primary key of this job.
	 *
	 * @param primaryKey the primary key of this job
	 */
	@Override
	public void setPrimaryKey(long primaryKey) {
		model.setPrimaryKey(primaryKey);
	}

	/**
	 * Sets the processors per node of this job.
	 *
	 * @param processorsPerNode the processors per node of this job
	 */
	@Override
	public void setProcessorsPerNode(int processorsPerNode) {
		model.setProcessorsPerNode(processorsPerNode);
	}

	/**
	 * Sets the queued date of this job.
	 *
	 * @param queuedDate the queued date of this job
	 */
	@Override
	public void setQueuedDate(Date queuedDate) {
		model.setQueuedDate(queuedDate);
	}

	/**
	 * Sets the queue name of this job.
	 *
	 * @param queueName the queue name of this job
	 */
	@Override
	public void setQueueName(String queueName) {
		model.setQueueName(queueName);
	}

	/**
	 * Sets the reference files of this job.
	 *
	 * @param referenceFiles the reference files of this job
	 */
	@Override
	public void setReferenceFiles(String referenceFiles) {
		model.setReferenceFiles(referenceFiles);
	}

	/**
	 * Sets whether this job is reserve results.
	 *
	 * @param reserveResults the reserve results of this job
	 */
	@Override
	public void setReserveResults(boolean reserveResults) {
		model.setReserveResults(reserveResults);
	}

	/**
	 * Sets the run type of this job.
	 *
	 * @param runType the run type of this job
	 */
	@Override
	public void setRunType(String runType) {
		model.setRunType(runType);
	}

	/**
	 * Sets the solver exe of this job.
	 *
	 * @param solverExe the solver exe of this job
	 */
	@Override
	public void setSolverExe(String solverExe) {
		model.setSolverExe(solverExe);
	}

	/**
	 * Sets the start date of this job.
	 *
	 * @param startDate the start date of this job
	 */
	@Override
	public void setStartDate(Date startDate) {
		model.setStartDate(startDate);
	}

	/**
	 * Sets the status of this job.
	 *
	 * @param status the status of this job
	 */
	@Override
	public void setStatus(int status) {
		model.setStatus(status);
	}

	/**
	 * Sets the submit args of this job.
	 *
	 * @param submitArgs the submit args of this job
	 */
	@Override
	public void setSubmitArgs(String submitArgs) {
		model.setSubmitArgs(submitArgs);
	}

	/**
	 * Sets the submit ID of this job.
	 *
	 * @param submitId the submit ID of this job
	 */
	@Override
	public void setSubmitId(String submitId) {
		model.setSubmitId(submitId);
	}

	/**
	 * Sets the title of this job.
	 *
	 * @param title the title of this job
	 */
	@Override
	public void setTitle(String title) {
		model.setTitle(title);
	}

	/**
	 * Sets the used cpu time of this job.
	 *
	 * @param usedCpuTime the used cpu time of this job
	 */
	@Override
	public void setUsedCpuTime(String usedCpuTime) {
		model.setUsedCpuTime(usedCpuTime);
	}

	/**
	 * Sets the used memory of this job.
	 *
	 * @param usedMemory the used memory of this job
	 */
	@Override
	public void setUsedMemory(String usedMemory) {
		model.setUsedMemory(usedMemory);
	}

	/**
	 * Sets the used walltime of this job.
	 *
	 * @param usedWalltime the used walltime of this job
	 */
	@Override
	public void setUsedWalltime(String usedWalltime) {
		model.setUsedWalltime(usedWalltime);
	}

	/**
	 * Sets the user ID of this job.
	 *
	 * @param userId the user ID of this job
	 */
	@Override
	public void setUserId(long userId) {
		model.setUserId(userId);
	}

	/**
	 * Sets the user uuid of this job.
	 *
	 * @param userUuid the user uuid of this job
	 */
	@Override
	public void setUserUuid(String userUuid) {
		model.setUserUuid(userUuid);
	}

	/**
	 * Sets the uuid of this job.
	 *
	 * @param uuid the uuid of this job
	 */
	@Override
	public void setUuid(String uuid) {
		model.setUuid(uuid);
	}

	/**
	 * Sets the wall time of this job.
	 *
	 * @param wallTime the wall time of this job
	 */
	@Override
	public void setWallTime(String wallTime) {
		model.setWallTime(wallTime);
	}

	/**
	 * Sets the working dir of this job.
	 *
	 * @param workingDir the working dir of this job
	 */
	@Override
	public void setWorkingDir(String workingDir) {
		model.setWorkingDir(workingDir);
	}

	@Override
	public StagedModelType getStagedModelType() {
		return model.getStagedModelType();
	}

	@Override
	protected JobWrapper wrap(Job job) {
		return new JobWrapper(job);
	}

}