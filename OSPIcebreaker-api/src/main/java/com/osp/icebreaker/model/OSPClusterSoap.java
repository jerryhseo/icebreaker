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
 * This class is used by SOAP remote services, specifically {@link com.osp.icebreaker.service.http.OSPClusterServiceSoap}.
 *
 * @author Jerry H. Seo
 * @generated
 */
@ProviderType
public class OSPClusterSoap implements Serializable {

	public static OSPClusterSoap toSoapModel(OSPCluster model) {
		OSPClusterSoap soapModel = new OSPClusterSoap();

		soapModel.setUuid(model.getUuid());
		soapModel.setClusterId(model.getClusterId());
		soapModel.setCompanyId(model.getCompanyId());
		soapModel.setGroupId(model.getGroupId());
		soapModel.setUserId(model.getUserId());
		soapModel.setUserName(model.getUserName());
		soapModel.setCreateDate(model.getCreateDate());
		soapModel.setModifiedDate(model.getModifiedDate());
		soapModel.setStatus(model.getStatus());
		soapModel.setClusterName(model.getClusterName());
		soapModel.setOsFamily(model.getOsFamily());
		soapModel.setOsName(model.getOsName());
		soapModel.setOsVersion(model.getOsVersion());
		soapModel.setAppRootDir(model.getAppRootDir());
		soapModel.setDataRootDir(model.getDataRootDir());
		soapModel.setContentRootDir(model.getContentRootDir());
		soapModel.setDescription(model.getDescription());
		soapModel.setServerIp(model.getServerIp());
		soapModel.setSshPort(model.getSshPort());
		soapModel.setAccessMethod(model.getAccessMethod());
		soapModel.setAuthorizedId(model.getAuthorizedId());
		soapModel.setAuthorizedPassword(model.getAuthorizedPassword());
		soapModel.setSchedulerName(model.getSchedulerName());
		soapModel.setSchedulerVersion(model.getSchedulerVersion());
		soapModel.setSchedulerClass(model.getSchedulerClass());
		soapModel.setSchedulerStatus(model.getSchedulerStatus());

		return soapModel;
	}

	public static OSPClusterSoap[] toSoapModels(OSPCluster[] models) {
		OSPClusterSoap[] soapModels = new OSPClusterSoap[models.length];

		for (int i = 0; i < models.length; i++) {
			soapModels[i] = toSoapModel(models[i]);
		}

		return soapModels;
	}

	public static OSPClusterSoap[][] toSoapModels(OSPCluster[][] models) {
		OSPClusterSoap[][] soapModels = null;

		if (models.length > 0) {
			soapModels = new OSPClusterSoap[models.length][models[0].length];
		}
		else {
			soapModels = new OSPClusterSoap[0][0];
		}

		for (int i = 0; i < models.length; i++) {
			soapModels[i] = toSoapModels(models[i]);
		}

		return soapModels;
	}

	public static OSPClusterSoap[] toSoapModels(List<OSPCluster> models) {
		List<OSPClusterSoap> soapModels = new ArrayList<OSPClusterSoap>(
			models.size());

		for (OSPCluster model : models) {
			soapModels.add(toSoapModel(model));
		}

		return soapModels.toArray(new OSPClusterSoap[soapModels.size()]);
	}

	public OSPClusterSoap() {
	}

	public long getPrimaryKey() {
		return _clusterId;
	}

	public void setPrimaryKey(long pk) {
		setClusterId(pk);
	}

	public String getUuid() {
		return _uuid;
	}

	public void setUuid(String uuid) {
		_uuid = uuid;
	}

	public long getClusterId() {
		return _clusterId;
	}

	public void setClusterId(long clusterId) {
		_clusterId = clusterId;
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

	public String getUserName() {
		return _userName;
	}

	public void setUserName(String userName) {
		_userName = userName;
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

	public int getStatus() {
		return _status;
	}

	public void setStatus(int status) {
		_status = status;
	}

	public String getClusterName() {
		return _clusterName;
	}

	public void setClusterName(String clusterName) {
		_clusterName = clusterName;
	}

	public String getOsFamily() {
		return _osFamily;
	}

	public void setOsFamily(String osFamily) {
		_osFamily = osFamily;
	}

	public String getOsName() {
		return _osName;
	}

	public void setOsName(String osName) {
		_osName = osName;
	}

	public String getOsVersion() {
		return _osVersion;
	}

	public void setOsVersion(String osVersion) {
		_osVersion = osVersion;
	}

	public String getAppRootDir() {
		return _appRootDir;
	}

	public void setAppRootDir(String appRootDir) {
		_appRootDir = appRootDir;
	}

	public String getDataRootDir() {
		return _dataRootDir;
	}

	public void setDataRootDir(String dataRootDir) {
		_dataRootDir = dataRootDir;
	}

	public String getContentRootDir() {
		return _contentRootDir;
	}

	public void setContentRootDir(String contentRootDir) {
		_contentRootDir = contentRootDir;
	}

	public String getDescription() {
		return _description;
	}

	public void setDescription(String description) {
		_description = description;
	}

	public String getServerIp() {
		return _serverIp;
	}

	public void setServerIp(String serverIp) {
		_serverIp = serverIp;
	}

	public String getSshPort() {
		return _sshPort;
	}

	public void setSshPort(String sshPort) {
		_sshPort = sshPort;
	}

	public String getAccessMethod() {
		return _accessMethod;
	}

	public void setAccessMethod(String accessMethod) {
		_accessMethod = accessMethod;
	}

	public String getAuthorizedId() {
		return _authorizedId;
	}

	public void setAuthorizedId(String authorizedId) {
		_authorizedId = authorizedId;
	}

	public String getAuthorizedPassword() {
		return _authorizedPassword;
	}

	public void setAuthorizedPassword(String authorizedPassword) {
		_authorizedPassword = authorizedPassword;
	}

	public String getSchedulerName() {
		return _schedulerName;
	}

	public void setSchedulerName(String schedulerName) {
		_schedulerName = schedulerName;
	}

	public String getSchedulerVersion() {
		return _schedulerVersion;
	}

	public void setSchedulerVersion(String schedulerVersion) {
		_schedulerVersion = schedulerVersion;
	}

	public String getSchedulerClass() {
		return _schedulerClass;
	}

	public void setSchedulerClass(String schedulerClass) {
		_schedulerClass = schedulerClass;
	}

	public int getSchedulerStatus() {
		return _schedulerStatus;
	}

	public void setSchedulerStatus(int schedulerStatus) {
		_schedulerStatus = schedulerStatus;
	}

	private String _uuid;
	private long _clusterId;
	private long _companyId;
	private long _groupId;
	private long _userId;
	private String _userName;
	private Date _createDate;
	private Date _modifiedDate;
	private int _status;
	private String _clusterName;
	private String _osFamily;
	private String _osName;
	private String _osVersion;
	private String _appRootDir;
	private String _dataRootDir;
	private String _contentRootDir;
	private String _description;
	private String _serverIp;
	private String _sshPort;
	private String _accessMethod;
	private String _authorizedId;
	private String _authorizedPassword;
	private String _schedulerName;
	private String _schedulerVersion;
	private String _schedulerClass;
	private int _schedulerStatus;

}