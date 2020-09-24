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

import java.util.Date;
import java.util.Locale;
import java.util.Map;

import org.osgi.annotation.versioning.ProviderType;

/**
 * The extended model implementation for the OSPCluster service. Represents a row in the &quot;ICEBREAKER_OSPCluster&quot; database table, with each column mapped to a property of this class.
 *
 * <p>
 * Helper methods and all application logic should be put in this class. Whenever methods are added, rerun ServiceBuilder to copy their definitions into the <code>com.osp.icebreaker.model.OSPCluster<code> interface.
 * </p>
 *
 * @author Jerry H. Seo
 */
@ProviderType
public class OSPClusterImpl extends OSPClusterBaseImpl {

	public OSPClusterImpl() {
	}

	public void setAttributes(
			String clusterName,
			String osFamily, 
			String osName, 
			String osVersion, 
			String appRootDir, 
			Map<Locale, String> descriptionMap, 
			String serverIp, 
			String sshPort, 
			String identificationCommand,
			String accessMethod, 
			String authorizedId, 
			String authorizedPassword, 
			String schedulerName, 
			String schedulerVersion, 
			String schedulerClass,
			int schedulerStatus,
			String securityLevel,
			long companyId,
			long groupId,
			long userId,
			String userName,
			Date createDate,
			Date modifiedDate,
			int status
			) {
		
		this.setClusterName(clusterName);
		this.setOsFamily(osFamily);
		this.setOsName(osName);
		this.setOsVersion(osVersion);
		this.setAppRootDir(appRootDir);
		this.setDescriptionMap(descriptionMap);
		this.setServerIp(serverIp);
		this.setAccessMethod(accessMethod);
		this.setSshPort(sshPort);
		this.setAuthorizedId(authorizedId);
		this.setAuthorizedPassword(authorizedPassword);
		this.setSchedulerName(schedulerName);
		this.setSchedulerVersion(schedulerVersion);
		this.setSchedulerStatus(schedulerStatus);
		this.setSchedulerClass(schedulerClass);
		this.setCompanyId(companyId);
		this.setGroupId(groupId);
		this.setUserId(userId);
		this.setUserName(userName);
		this.setCreateDate(createDate);
		this.setModifiedDate(modifiedDate);
		this.setStatus(status);
	}
}