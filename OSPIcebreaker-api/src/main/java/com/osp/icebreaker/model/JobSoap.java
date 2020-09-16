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

import java.io.Serializable;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import org.osgi.annotation.versioning.ProviderType;

/**
 * This class is used by SOAP remote services, specifically {@link com.osp.icebreaker.service.http.JobServiceSoap}.
 *
 * @author Jerry H. Seo
 * @generated
 */
@ProviderType
public class JobSoap implements Serializable {

	public static JobSoap toSoapModel(Job model) {
		JobSoap soapModel = new JobSoap();

		soapModel.setUuid(model.getUuid());
		soapModel.setJobId(model.getJobId());
		soapModel.setJobName(model.getJobName());
		soapModel.setCompanyId(model.getCompanyId());
		soapModel.setGroupId(model.getGroupId());
		soapModel.setUserId(model.getUserId());
		soapModel.setClusterId(model.getClusterId());
		soapModel.setStatus(model.getStatus());
		soapModel.setSubmitId(model.getSubmitId());
		soapModel.setSolverExe(model.getSolverExe());
		soapModel.setWorkingDir(model.getWorkingDir());
		soapModel.setRunType(model.getRunType());
		soapModel.setLogFileName(model.getLogFileName());
		soapModel.setTitle(model.getTitle());
		soapModel.setQueueName(model.getQueueName());
		soapModel.setCommand(model.getCommand());
		soapModel.setReferenceFiles(model.getReferenceFiles());
		soapModel.setEnvironmentVars(model.getEnvironmentVars());
		soapModel.setNodes(model.getNodes());
		soapModel.setProcessorsPerNode(model.getProcessorsPerNode());
		soapModel.setWallTime(model.getWallTime());
		soapModel.setEligibleTime(model.getEligibleTime());
		soapModel.setAfterAny(model.getAfterAny());
		soapModel.setAfterOk(model.getAfterOk());
		soapModel.setSubmitArgs(model.getSubmitArgs());
		soapModel.setJobStatus(model.getJobStatus());
		soapModel.setReserveResults(model.isReserveResults());
		soapModel.setCreateDate(model.getCreateDate());
		soapModel.setModifiedDate(model.getModifiedDate());
		soapModel.setQueuedDate(model.getQueuedDate());
		soapModel.setStartDate(model.getStartDate());
		soapModel.setCompleteDate(model.getCompleteDate());
		soapModel.setUsedMemory(model.getUsedMemory());
		soapModel.setUsedCpuTime(model.getUsedCpuTime());
		soapModel.setUsedWalltime(model.getUsedWalltime());

		return soapModel;
	}

	public static JobSoap[] toSoapModels(Job[] models) {
		JobSoap[] soapModels = new JobSoap[models.length];

		for (int i = 0; i < models.length; i++) {
			soapModels[i] = toSoapModel(models[i]);
		}

		return soapModels;
	}

	public static JobSoap[][] toSoapModels(Job[][] models) {
		JobSoap[][] soapModels = null;

		if (models.length > 0) {
			soapModels = new JobSoap[models.length][models[0].length];
		}
		else {
			soapModels = new JobSoap[0][0];
		}

		for (int i = 0; i < models.length; i++) {
			soapModels[i] = toSoapModels(models[i]);
		}

		return soapModels;
	}

	public static JobSoap[] toSoapModels(List<Job> models) {
		List<JobSoap> soapModels = new ArrayList<JobSoap>(models.size());

		for (Job model : models) {
			soapModels.add(toSoapModel(model));
		}

		return soapModels.toArray(new JobSoap[soapModels.size()]);
	}

	public JobSoap() {
	}

	public long getPrimaryKey() {
		return _jobId;
	}

	public void setPrimaryKey(long pk) {
		setJobId(pk);
	}

	public String getUuid() {
		return _uuid;
	}

	public void setUuid(String uuid) {
		_uuid = uuid;
	}

	public long getJobId() {
		return _jobId;
	}

	public void setJobId(long jobId) {
		_jobId = jobId;
	}

	public String getJobName() {
		return _jobName;
	}

	public void setJobName(String jobName) {
		_jobName = jobName;
	}

	public long getCompanyId() {
		return _companyId;
	}

	public void setCompanyId(long companyId) {
		_companyId = companyId;
	}

	public long getGroupId() {
		return _groupId;
	}

	public void setGroupId(long groupId) {
		_groupId = groupId;
	}

	public long getUserId() {
		return _userId;
	}

	public void setUserId(long userId) {
		_userId = userId;
	}

	public long getClusterId() {
		return _clusterId;
	}

	public void setClusterId(long clusterId) {
		_clusterId = clusterId;
	}

	public int getStatus() {
		return _status;
	}

	public void setStatus(int status) {
		_status = status;
	}

	public String getSubmitId() {
		return _submitId;
	}

	public void setSubmitId(String submitId) {
		_submitId = submitId;
	}

	public String getSolverExe() {
		return _solverExe;
	}

	public void setSolverExe(String solverExe) {
		_solverExe = solverExe;
	}

	public String getWorkingDir() {
		return _workingDir;
	}

	public void setWorkingDir(String workingDir) {
		_workingDir = workingDir;
	}

	public String getRunType() {
		return _runType;
	}

	public void setRunType(String runType) {
		_runType = runType;
	}

	public String getLogFileName() {
		return _logFileName;
	}

	public void setLogFileName(String logFileName) {
		_logFileName = logFileName;
	}

	public String getTitle() {
		return _title;
	}

	public void setTitle(String title) {
		_title = title;
	}

	public String getQueueName() {
		return _queueName;
	}

	public void setQueueName(String queueName) {
		_queueName = queueName;
	}

	public String getCommand() {
		return _command;
	}

	public void setCommand(String command) {
		_command = command;
	}

	public String getReferenceFiles() {
		return _referenceFiles;
	}

	public void setReferenceFiles(String referenceFiles) {
		_referenceFiles = referenceFiles;
	}

	public String getEnvironmentVars() {
		return _environmentVars;
	}

	public void setEnvironmentVars(String environmentVars) {
		_environmentVars = environmentVars;
	}

	public int getNodes() {
		return _nodes;
	}

	public void setNodes(int nodes) {
		_nodes = nodes;
	}

	public int getProcessorsPerNode() {
		return _processorsPerNode;
	}

	public void setProcessorsPerNode(int processorsPerNode) {
		_processorsPerNode = processorsPerNode;
	}

	public String getWallTime() {
		return _wallTime;
	}

	public void setWallTime(String wallTime) {
		_wallTime = wallTime;
	}

	public String getEligibleTime() {
		return _eligibleTime;
	}

	public void setEligibleTime(String eligibleTime) {
		_eligibleTime = eligibleTime;
	}

	public String getAfterAny() {
		return _afterAny;
	}

	public void setAfterAny(String afterAny) {
		_afterAny = afterAny;
	}

	public String getAfterOk() {
		return _afterOk;
	}

	public void setAfterOk(String afterOk) {
		_afterOk = afterOk;
	}

	public String getSubmitArgs() {
		return _submitArgs;
	}

	public void setSubmitArgs(String submitArgs) {
		_submitArgs = submitArgs;
	}

	public int getJobStatus() {
		return _jobStatus;
	}

	public void setJobStatus(int jobStatus) {
		_jobStatus = jobStatus;
	}

	public boolean getReserveResults() {
		return _reserveResults;
	}

	public boolean isReserveResults() {
		return _reserveResults;
	}

	public void setReserveResults(boolean reserveResults) {
		_reserveResults = reserveResults;
	}

	public Date getCreateDate() {
		return _createDate;
	}

	public void setCreateDate(Date createDate) {
		_createDate = createDate;
	}

	public Date getModifiedDate() {
		return _modifiedDate;
	}

	public void setModifiedDate(Date modifiedDate) {
		_modifiedDate = modifiedDate;
	}

	public Date getQueuedDate() {
		return _queuedDate;
	}

	public void setQueuedDate(Date queuedDate) {
		_queuedDate = queuedDate;
	}

	public Date getStartDate() {
		return _startDate;
	}

	public void setStartDate(Date startDate) {
		_startDate = startDate;
	}

	public Date getCompleteDate() {
		return _completeDate;
	}

	public void setCompleteDate(Date completeDate) {
		_completeDate = completeDate;
	}

	public String getUsedMemory() {
		return _usedMemory;
	}

	public void setUsedMemory(String usedMemory) {
		_usedMemory = usedMemory;
	}

	public String getUsedCpuTime() {
		return _usedCpuTime;
	}

	public void setUsedCpuTime(String usedCpuTime) {
		_usedCpuTime = usedCpuTime;
	}

	public String getUsedWalltime() {
		return _usedWalltime;
	}

	public void setUsedWalltime(String usedWalltime) {
		_usedWalltime = usedWalltime;
	}

	private String _uuid;
	private long _jobId;
	private String _jobName;
	private long _companyId;
	private long _groupId;
	private long _userId;
	private long _clusterId;
	private int _status;
	private String _submitId;
	private String _solverExe;
	private String _workingDir;
	private String _runType;
	private String _logFileName;
	private String _title;
	private String _queueName;
	private String _command;
	private String _referenceFiles;
	private String _environmentVars;
	private int _nodes;
	private int _processorsPerNode;
	private String _wallTime;
	private String _eligibleTime;
	private String _afterAny;
	private String _afterOk;
	private String _submitArgs;
	private int _jobStatus;
	private boolean _reserveResults;
	private Date _createDate;
	private Date _modifiedDate;
	private Date _queuedDate;
	private Date _startDate;
	private Date _completeDate;
	private String _usedMemory;
	private String _usedCpuTime;
	private String _usedWalltime;

}