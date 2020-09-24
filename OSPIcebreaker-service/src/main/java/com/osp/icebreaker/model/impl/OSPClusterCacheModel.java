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

package com.osp.icebreaker.model.impl;

import com.liferay.petra.lang.HashUtil;
import com.liferay.petra.string.StringBundler;
import com.liferay.portal.kernel.model.CacheModel;

import com.osp.icebreaker.model.OSPCluster;

import java.io.Externalizable;
import java.io.IOException;
import java.io.ObjectInput;
import java.io.ObjectOutput;

import java.util.Date;

/**
 * The cache model class for representing OSPCluster in entity cache.
 *
 * @author Jerry H. Seo
 * @generated
 */
public class OSPClusterCacheModel
	implements CacheModel<OSPCluster>, Externalizable {

	@Override
	public boolean equals(Object obj) {
		if (this == obj) {
			return true;
		}

		if (!(obj instanceof OSPClusterCacheModel)) {
			return false;
		}

		OSPClusterCacheModel ospClusterCacheModel = (OSPClusterCacheModel)obj;

		if (clusterId == ospClusterCacheModel.clusterId) {
			return true;
		}

		return false;
	}

	@Override
	public int hashCode() {
		return HashUtil.hash(0, clusterId);
	}

	@Override
	public String toString() {
		StringBundler sb = new StringBundler(53);

		sb.append("{uuid=");
		sb.append(uuid);
		sb.append(", clusterId=");
		sb.append(clusterId);
		sb.append(", companyId=");
		sb.append(companyId);
		sb.append(", groupId=");
		sb.append(groupId);
		sb.append(", userId=");
		sb.append(userId);
		sb.append(", userName=");
		sb.append(userName);
		sb.append(", createDate=");
		sb.append(createDate);
		sb.append(", modifiedDate=");
		sb.append(modifiedDate);
		sb.append(", status=");
		sb.append(status);
		sb.append(", clusterName=");
		sb.append(clusterName);
		sb.append(", osFamily=");
		sb.append(osFamily);
		sb.append(", osName=");
		sb.append(osName);
		sb.append(", osVersion=");
		sb.append(osVersion);
		sb.append(", appRootDir=");
		sb.append(appRootDir);
		sb.append(", description=");
		sb.append(description);
		sb.append(", serverIp=");
		sb.append(serverIp);
		sb.append(", sshPort=");
		sb.append(sshPort);
		sb.append(", identificationCommand=");
		sb.append(identificationCommand);
		sb.append(", accessMethod=");
		sb.append(accessMethod);
		sb.append(", authorizedId=");
		sb.append(authorizedId);
		sb.append(", authorizedPassword=");
		sb.append(authorizedPassword);
		sb.append(", schedulerName=");
		sb.append(schedulerName);
		sb.append(", schedulerVersion=");
		sb.append(schedulerVersion);
		sb.append(", schedulerClass=");
		sb.append(schedulerClass);
		sb.append(", schedulerStatus=");
		sb.append(schedulerStatus);
		sb.append(", secutityLevel=");
		sb.append(secutityLevel);
		sb.append("}");

		return sb.toString();
	}

	@Override
	public OSPCluster toEntityModel() {
		OSPClusterImpl ospClusterImpl = new OSPClusterImpl();

		if (uuid == null) {
			ospClusterImpl.setUuid("");
		}
		else {
			ospClusterImpl.setUuid(uuid);
		}

		ospClusterImpl.setClusterId(clusterId);
		ospClusterImpl.setCompanyId(companyId);
		ospClusterImpl.setGroupId(groupId);
		ospClusterImpl.setUserId(userId);

		if (userName == null) {
			ospClusterImpl.setUserName("");
		}
		else {
			ospClusterImpl.setUserName(userName);
		}

		if (createDate == Long.MIN_VALUE) {
			ospClusterImpl.setCreateDate(null);
		}
		else {
			ospClusterImpl.setCreateDate(new Date(createDate));
		}

		if (modifiedDate == Long.MIN_VALUE) {
			ospClusterImpl.setModifiedDate(null);
		}
		else {
			ospClusterImpl.setModifiedDate(new Date(modifiedDate));
		}

		ospClusterImpl.setStatus(status);

		if (clusterName == null) {
			ospClusterImpl.setClusterName("");
		}
		else {
			ospClusterImpl.setClusterName(clusterName);
		}

		if (osFamily == null) {
			ospClusterImpl.setOsFamily("");
		}
		else {
			ospClusterImpl.setOsFamily(osFamily);
		}

		if (osName == null) {
			ospClusterImpl.setOsName("");
		}
		else {
			ospClusterImpl.setOsName(osName);
		}

		if (osVersion == null) {
			ospClusterImpl.setOsVersion("");
		}
		else {
			ospClusterImpl.setOsVersion(osVersion);
		}

		if (appRootDir == null) {
			ospClusterImpl.setAppRootDir("");
		}
		else {
			ospClusterImpl.setAppRootDir(appRootDir);
		}

		if (description == null) {
			ospClusterImpl.setDescription("");
		}
		else {
			ospClusterImpl.setDescription(description);
		}

		if (serverIp == null) {
			ospClusterImpl.setServerIp("");
		}
		else {
			ospClusterImpl.setServerIp(serverIp);
		}

		if (sshPort == null) {
			ospClusterImpl.setSshPort("");
		}
		else {
			ospClusterImpl.setSshPort(sshPort);
		}

		if (identificationCommand == null) {
			ospClusterImpl.setIdentificationCommand("");
		}
		else {
			ospClusterImpl.setIdentificationCommand(identificationCommand);
		}

		if (accessMethod == null) {
			ospClusterImpl.setAccessMethod("");
		}
		else {
			ospClusterImpl.setAccessMethod(accessMethod);
		}

		if (authorizedId == null) {
			ospClusterImpl.setAuthorizedId("");
		}
		else {
			ospClusterImpl.setAuthorizedId(authorizedId);
		}

		if (authorizedPassword == null) {
			ospClusterImpl.setAuthorizedPassword("");
		}
		else {
			ospClusterImpl.setAuthorizedPassword(authorizedPassword);
		}

		if (schedulerName == null) {
			ospClusterImpl.setSchedulerName("");
		}
		else {
			ospClusterImpl.setSchedulerName(schedulerName);
		}

		if (schedulerVersion == null) {
			ospClusterImpl.setSchedulerVersion("");
		}
		else {
			ospClusterImpl.setSchedulerVersion(schedulerVersion);
		}

		if (schedulerClass == null) {
			ospClusterImpl.setSchedulerClass("");
		}
		else {
			ospClusterImpl.setSchedulerClass(schedulerClass);
		}

		ospClusterImpl.setSchedulerStatus(schedulerStatus);

		if (secutityLevel == null) {
			ospClusterImpl.setSecutityLevel("");
		}
		else {
			ospClusterImpl.setSecutityLevel(secutityLevel);
		}

		ospClusterImpl.resetOriginalValues();

		return ospClusterImpl;
	}

	@Override
	public void readExternal(ObjectInput objectInput) throws IOException {
		uuid = objectInput.readUTF();

		clusterId = objectInput.readLong();

		companyId = objectInput.readLong();

		groupId = objectInput.readLong();

		userId = objectInput.readLong();
		userName = objectInput.readUTF();
		createDate = objectInput.readLong();
		modifiedDate = objectInput.readLong();

		status = objectInput.readInt();
		clusterName = objectInput.readUTF();
		osFamily = objectInput.readUTF();
		osName = objectInput.readUTF();
		osVersion = objectInput.readUTF();
		appRootDir = objectInput.readUTF();
		description = objectInput.readUTF();
		serverIp = objectInput.readUTF();
		sshPort = objectInput.readUTF();
		identificationCommand = objectInput.readUTF();
		accessMethod = objectInput.readUTF();
		authorizedId = objectInput.readUTF();
		authorizedPassword = objectInput.readUTF();
		schedulerName = objectInput.readUTF();
		schedulerVersion = objectInput.readUTF();
		schedulerClass = objectInput.readUTF();

		schedulerStatus = objectInput.readInt();
		secutityLevel = objectInput.readUTF();
	}

	@Override
	public void writeExternal(ObjectOutput objectOutput) throws IOException {
		if (uuid == null) {
			objectOutput.writeUTF("");
		}
		else {
			objectOutput.writeUTF(uuid);
		}

		objectOutput.writeLong(clusterId);

		objectOutput.writeLong(companyId);

		objectOutput.writeLong(groupId);

		objectOutput.writeLong(userId);

		if (userName == null) {
			objectOutput.writeUTF("");
		}
		else {
			objectOutput.writeUTF(userName);
		}

		objectOutput.writeLong(createDate);
		objectOutput.writeLong(modifiedDate);

		objectOutput.writeInt(status);

		if (clusterName == null) {
			objectOutput.writeUTF("");
		}
		else {
			objectOutput.writeUTF(clusterName);
		}

		if (osFamily == null) {
			objectOutput.writeUTF("");
		}
		else {
			objectOutput.writeUTF(osFamily);
		}

		if (osName == null) {
			objectOutput.writeUTF("");
		}
		else {
			objectOutput.writeUTF(osName);
		}

		if (osVersion == null) {
			objectOutput.writeUTF("");
		}
		else {
			objectOutput.writeUTF(osVersion);
		}

		if (appRootDir == null) {
			objectOutput.writeUTF("");
		}
		else {
			objectOutput.writeUTF(appRootDir);
		}

		if (description == null) {
			objectOutput.writeUTF("");
		}
		else {
			objectOutput.writeUTF(description);
		}

		if (serverIp == null) {
			objectOutput.writeUTF("");
		}
		else {
			objectOutput.writeUTF(serverIp);
		}

		if (sshPort == null) {
			objectOutput.writeUTF("");
		}
		else {
			objectOutput.writeUTF(sshPort);
		}

		if (identificationCommand == null) {
			objectOutput.writeUTF("");
		}
		else {
			objectOutput.writeUTF(identificationCommand);
		}

		if (accessMethod == null) {
			objectOutput.writeUTF("");
		}
		else {
			objectOutput.writeUTF(accessMethod);
		}

		if (authorizedId == null) {
			objectOutput.writeUTF("");
		}
		else {
			objectOutput.writeUTF(authorizedId);
		}

		if (authorizedPassword == null) {
			objectOutput.writeUTF("");
		}
		else {
			objectOutput.writeUTF(authorizedPassword);
		}

		if (schedulerName == null) {
			objectOutput.writeUTF("");
		}
		else {
			objectOutput.writeUTF(schedulerName);
		}

		if (schedulerVersion == null) {
			objectOutput.writeUTF("");
		}
		else {
			objectOutput.writeUTF(schedulerVersion);
		}

		if (schedulerClass == null) {
			objectOutput.writeUTF("");
		}
		else {
			objectOutput.writeUTF(schedulerClass);
		}

		objectOutput.writeInt(schedulerStatus);

		if (secutityLevel == null) {
			objectOutput.writeUTF("");
		}
		else {
			objectOutput.writeUTF(secutityLevel);
		}
	}

	public String uuid;
	public long clusterId;
	public long companyId;
	public long groupId;
	public long userId;
	public String userName;
	public long createDate;
	public long modifiedDate;
	public int status;
	public String clusterName;
	public String osFamily;
	public String osName;
	public String osVersion;
	public String appRootDir;
	public String description;
	public String serverIp;
	public String sshPort;
	public String identificationCommand;
	public String accessMethod;
	public String authorizedId;
	public String authorizedPassword;
	public String schedulerName;
	public String schedulerVersion;
	public String schedulerClass;
	public int schedulerStatus;
	public String secutityLevel;

}