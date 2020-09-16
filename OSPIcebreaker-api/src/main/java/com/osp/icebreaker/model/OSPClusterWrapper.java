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

import org.osgi.annotation.versioning.ProviderType;

/**
 * <p>
 * This class is a wrapper for {@link OSPCluster}.
 * </p>
 *
 * @author Jerry H. Seo
 * @see OSPCluster
 * @generated
 */
@ProviderType
public class OSPClusterWrapper
	extends BaseModelWrapper<OSPCluster>
	implements OSPCluster, ModelWrapper<OSPCluster> {

	public OSPClusterWrapper(OSPCluster ospCluster) {
		super(ospCluster);
	}

	@Override
	public Map<String, Object> getModelAttributes() {
		Map<String, Object> attributes = new HashMap<String, Object>();

		attributes.put("uuid", getUuid());
		attributes.put("clusterId", getClusterId());
		attributes.put("companyId", getCompanyId());
		attributes.put("groupId", getGroupId());
		attributes.put("userId", getUserId());
		attributes.put("userName", getUserName());
		attributes.put("createDate", getCreateDate());
		attributes.put("modifiedDate", getModifiedDate());
		attributes.put("status", getStatus());
		attributes.put("clusterName", getClusterName());
		attributes.put("osFamily", getOsFamily());
		attributes.put("osName", getOsName());
		attributes.put("osVersion", getOsVersion());
		attributes.put("appRootDir", getAppRootDir());
		attributes.put("dataRootDir", getDataRootDir());
		attributes.put("contentRootDir", getContentRootDir());
		attributes.put("description", getDescription());
		attributes.put("serverIp", getServerIp());
		attributes.put("sshPort", getSshPort());
		attributes.put("accessMethod", getAccessMethod());
		attributes.put("authorizedId", getAuthorizedId());
		attributes.put("authorizedPassword", getAuthorizedPassword());
		attributes.put("schedulerName", getSchedulerName());
		attributes.put("schedulerVersion", getSchedulerVersion());
		attributes.put("schedulerClass", getSchedulerClass());
		attributes.put("schedulerStatus", getSchedulerStatus());

		return attributes;
	}

	@Override
	public void setModelAttributes(Map<String, Object> attributes) {
		String uuid = (String)attributes.get("uuid");

		if (uuid != null) {
			setUuid(uuid);
		}

		Long clusterId = (Long)attributes.get("clusterId");

		if (clusterId != null) {
			setClusterId(clusterId);
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

		String userName = (String)attributes.get("userName");

		if (userName != null) {
			setUserName(userName);
		}

		Date createDate = (Date)attributes.get("createDate");

		if (createDate != null) {
			setCreateDate(createDate);
		}

		Date modifiedDate = (Date)attributes.get("modifiedDate");

		if (modifiedDate != null) {
			setModifiedDate(modifiedDate);
		}

		Integer status = (Integer)attributes.get("status");

		if (status != null) {
			setStatus(status);
		}

		String clusterName = (String)attributes.get("clusterName");

		if (clusterName != null) {
			setClusterName(clusterName);
		}

		String osFamily = (String)attributes.get("osFamily");

		if (osFamily != null) {
			setOsFamily(osFamily);
		}

		String osName = (String)attributes.get("osName");

		if (osName != null) {
			setOsName(osName);
		}

		String osVersion = (String)attributes.get("osVersion");

		if (osVersion != null) {
			setOsVersion(osVersion);
		}

		String appRootDir = (String)attributes.get("appRootDir");

		if (appRootDir != null) {
			setAppRootDir(appRootDir);
		}

		String dataRootDir = (String)attributes.get("dataRootDir");

		if (dataRootDir != null) {
			setDataRootDir(dataRootDir);
		}

		String contentRootDir = (String)attributes.get("contentRootDir");

		if (contentRootDir != null) {
			setContentRootDir(contentRootDir);
		}

		String description = (String)attributes.get("description");

		if (description != null) {
			setDescription(description);
		}

		String serverIp = (String)attributes.get("serverIp");

		if (serverIp != null) {
			setServerIp(serverIp);
		}

		String sshPort = (String)attributes.get("sshPort");

		if (sshPort != null) {
			setSshPort(sshPort);
		}

		String accessMethod = (String)attributes.get("accessMethod");

		if (accessMethod != null) {
			setAccessMethod(accessMethod);
		}

		String authorizedId = (String)attributes.get("authorizedId");

		if (authorizedId != null) {
			setAuthorizedId(authorizedId);
		}

		String authorizedPassword = (String)attributes.get(
			"authorizedPassword");

		if (authorizedPassword != null) {
			setAuthorizedPassword(authorizedPassword);
		}

		String schedulerName = (String)attributes.get("schedulerName");

		if (schedulerName != null) {
			setSchedulerName(schedulerName);
		}

		String schedulerVersion = (String)attributes.get("schedulerVersion");

		if (schedulerVersion != null) {
			setSchedulerVersion(schedulerVersion);
		}

		String schedulerClass = (String)attributes.get("schedulerClass");

		if (schedulerClass != null) {
			setSchedulerClass(schedulerClass);
		}

		Integer schedulerStatus = (Integer)attributes.get("schedulerStatus");

		if (schedulerStatus != null) {
			setSchedulerStatus(schedulerStatus);
		}
	}

	/**
	 * Returns the access method of this osp cluster.
	 *
	 * @return the access method of this osp cluster
	 */
	@Override
	public String getAccessMethod() {
		return model.getAccessMethod();
	}

	/**
	 * Returns the app root dir of this osp cluster.
	 *
	 * @return the app root dir of this osp cluster
	 */
	@Override
	public String getAppRootDir() {
		return model.getAppRootDir();
	}

	/**
	 * Returns the authorized ID of this osp cluster.
	 *
	 * @return the authorized ID of this osp cluster
	 */
	@Override
	public String getAuthorizedId() {
		return model.getAuthorizedId();
	}

	/**
	 * Returns the authorized password of this osp cluster.
	 *
	 * @return the authorized password of this osp cluster
	 */
	@Override
	public String getAuthorizedPassword() {
		return model.getAuthorizedPassword();
	}

	@Override
	public String[] getAvailableLanguageIds() {
		return model.getAvailableLanguageIds();
	}

	/**
	 * Returns the cluster ID of this osp cluster.
	 *
	 * @return the cluster ID of this osp cluster
	 */
	@Override
	public long getClusterId() {
		return model.getClusterId();
	}

	/**
	 * Returns the cluster name of this osp cluster.
	 *
	 * @return the cluster name of this osp cluster
	 */
	@Override
	public String getClusterName() {
		return model.getClusterName();
	}

	/**
	 * Returns the company ID of this osp cluster.
	 *
	 * @return the company ID of this osp cluster
	 */
	@Override
	public long getCompanyId() {
		return model.getCompanyId();
	}

	/**
	 * Returns the content root dir of this osp cluster.
	 *
	 * @return the content root dir of this osp cluster
	 */
	@Override
	public String getContentRootDir() {
		return model.getContentRootDir();
	}

	/**
	 * Returns the create date of this osp cluster.
	 *
	 * @return the create date of this osp cluster
	 */
	@Override
	public Date getCreateDate() {
		return model.getCreateDate();
	}

	/**
	 * Returns the data root dir of this osp cluster.
	 *
	 * @return the data root dir of this osp cluster
	 */
	@Override
	public String getDataRootDir() {
		return model.getDataRootDir();
	}

	@Override
	public String getDefaultLanguageId() {
		return model.getDefaultLanguageId();
	}

	/**
	 * Returns the description of this osp cluster.
	 *
	 * @return the description of this osp cluster
	 */
	@Override
	public String getDescription() {
		return model.getDescription();
	}

	/**
	 * Returns the localized description of this osp cluster in the language. Uses the default language if no localization exists for the requested language.
	 *
	 * @param locale the locale of the language
	 * @return the localized description of this osp cluster
	 */
	@Override
	public String getDescription(java.util.Locale locale) {
		return model.getDescription(locale);
	}

	/**
	 * Returns the localized description of this osp cluster in the language, optionally using the default language if no localization exists for the requested language.
	 *
	 * @param locale the local of the language
	 * @param useDefault whether to use the default language if no localization exists for the requested language
	 * @return the localized description of this osp cluster. If <code>useDefault</code> is <code>false</code> and no localization exists for the requested language, an empty string will be returned.
	 */
	@Override
	public String getDescription(java.util.Locale locale, boolean useDefault) {
		return model.getDescription(locale, useDefault);
	}

	/**
	 * Returns the localized description of this osp cluster in the language. Uses the default language if no localization exists for the requested language.
	 *
	 * @param languageId the ID of the language
	 * @return the localized description of this osp cluster
	 */
	@Override
	public String getDescription(String languageId) {
		return model.getDescription(languageId);
	}

	/**
	 * Returns the localized description of this osp cluster in the language, optionally using the default language if no localization exists for the requested language.
	 *
	 * @param languageId the ID of the language
	 * @param useDefault whether to use the default language if no localization exists for the requested language
	 * @return the localized description of this osp cluster
	 */
	@Override
	public String getDescription(String languageId, boolean useDefault) {
		return model.getDescription(languageId, useDefault);
	}

	@Override
	public String getDescriptionCurrentLanguageId() {
		return model.getDescriptionCurrentLanguageId();
	}

	@Override
	public String getDescriptionCurrentValue() {
		return model.getDescriptionCurrentValue();
	}

	/**
	 * Returns a map of the locales and localized descriptions of this osp cluster.
	 *
	 * @return the locales and localized descriptions of this osp cluster
	 */
	@Override
	public Map<java.util.Locale, String> getDescriptionMap() {
		return model.getDescriptionMap();
	}

	/**
	 * Returns the group ID of this osp cluster.
	 *
	 * @return the group ID of this osp cluster
	 */
	@Override
	public long getGroupId() {
		return model.getGroupId();
	}

	/**
	 * Returns the modified date of this osp cluster.
	 *
	 * @return the modified date of this osp cluster
	 */
	@Override
	public Date getModifiedDate() {
		return model.getModifiedDate();
	}

	/**
	 * Returns the os family of this osp cluster.
	 *
	 * @return the os family of this osp cluster
	 */
	@Override
	public String getOsFamily() {
		return model.getOsFamily();
	}

	/**
	 * Returns the os name of this osp cluster.
	 *
	 * @return the os name of this osp cluster
	 */
	@Override
	public String getOsName() {
		return model.getOsName();
	}

	/**
	 * Returns the os version of this osp cluster.
	 *
	 * @return the os version of this osp cluster
	 */
	@Override
	public String getOsVersion() {
		return model.getOsVersion();
	}

	/**
	 * Returns the primary key of this osp cluster.
	 *
	 * @return the primary key of this osp cluster
	 */
	@Override
	public long getPrimaryKey() {
		return model.getPrimaryKey();
	}

	/**
	 * Returns the scheduler class of this osp cluster.
	 *
	 * @return the scheduler class of this osp cluster
	 */
	@Override
	public String getSchedulerClass() {
		return model.getSchedulerClass();
	}

	/**
	 * Returns the scheduler name of this osp cluster.
	 *
	 * @return the scheduler name of this osp cluster
	 */
	@Override
	public String getSchedulerName() {
		return model.getSchedulerName();
	}

	/**
	 * Returns the scheduler status of this osp cluster.
	 *
	 * @return the scheduler status of this osp cluster
	 */
	@Override
	public int getSchedulerStatus() {
		return model.getSchedulerStatus();
	}

	/**
	 * Returns the scheduler version of this osp cluster.
	 *
	 * @return the scheduler version of this osp cluster
	 */
	@Override
	public String getSchedulerVersion() {
		return model.getSchedulerVersion();
	}

	/**
	 * Returns the server ip of this osp cluster.
	 *
	 * @return the server ip of this osp cluster
	 */
	@Override
	public String getServerIp() {
		return model.getServerIp();
	}

	/**
	 * Returns the ssh port of this osp cluster.
	 *
	 * @return the ssh port of this osp cluster
	 */
	@Override
	public String getSshPort() {
		return model.getSshPort();
	}

	/**
	 * Returns the status of this osp cluster.
	 *
	 * @return the status of this osp cluster
	 */
	@Override
	public int getStatus() {
		return model.getStatus();
	}

	/**
	 * Returns the user ID of this osp cluster.
	 *
	 * @return the user ID of this osp cluster
	 */
	@Override
	public long getUserId() {
		return model.getUserId();
	}

	/**
	 * Returns the user name of this osp cluster.
	 *
	 * @return the user name of this osp cluster
	 */
	@Override
	public String getUserName() {
		return model.getUserName();
	}

	/**
	 * Returns the user uuid of this osp cluster.
	 *
	 * @return the user uuid of this osp cluster
	 */
	@Override
	public String getUserUuid() {
		return model.getUserUuid();
	}

	/**
	 * Returns the uuid of this osp cluster.
	 *
	 * @return the uuid of this osp cluster
	 */
	@Override
	public String getUuid() {
		return model.getUuid();
	}

	@Override
	public void persist() {
		model.persist();
	}

	@Override
	public void prepareLocalizedFieldsForImport()
		throws com.liferay.portal.kernel.exception.LocaleException {

		model.prepareLocalizedFieldsForImport();
	}

	@Override
	public void prepareLocalizedFieldsForImport(
			java.util.Locale defaultImportLocale)
		throws com.liferay.portal.kernel.exception.LocaleException {

		model.prepareLocalizedFieldsForImport(defaultImportLocale);
	}

	/**
	 * Sets the access method of this osp cluster.
	 *
	 * @param accessMethod the access method of this osp cluster
	 */
	@Override
	public void setAccessMethod(String accessMethod) {
		model.setAccessMethod(accessMethod);
	}

	/**
	 * Sets the app root dir of this osp cluster.
	 *
	 * @param appRootDir the app root dir of this osp cluster
	 */
	@Override
	public void setAppRootDir(String appRootDir) {
		model.setAppRootDir(appRootDir);
	}

	/**
	 * Sets the authorized ID of this osp cluster.
	 *
	 * @param authorizedId the authorized ID of this osp cluster
	 */
	@Override
	public void setAuthorizedId(String authorizedId) {
		model.setAuthorizedId(authorizedId);
	}

	/**
	 * Sets the authorized password of this osp cluster.
	 *
	 * @param authorizedPassword the authorized password of this osp cluster
	 */
	@Override
	public void setAuthorizedPassword(String authorizedPassword) {
		model.setAuthorizedPassword(authorizedPassword);
	}

	/**
	 * Sets the cluster ID of this osp cluster.
	 *
	 * @param clusterId the cluster ID of this osp cluster
	 */
	@Override
	public void setClusterId(long clusterId) {
		model.setClusterId(clusterId);
	}

	/**
	 * Sets the cluster name of this osp cluster.
	 *
	 * @param clusterName the cluster name of this osp cluster
	 */
	@Override
	public void setClusterName(String clusterName) {
		model.setClusterName(clusterName);
	}

	/**
	 * Sets the company ID of this osp cluster.
	 *
	 * @param companyId the company ID of this osp cluster
	 */
	@Override
	public void setCompanyId(long companyId) {
		model.setCompanyId(companyId);
	}

	/**
	 * Sets the content root dir of this osp cluster.
	 *
	 * @param contentRootDir the content root dir of this osp cluster
	 */
	@Override
	public void setContentRootDir(String contentRootDir) {
		model.setContentRootDir(contentRootDir);
	}

	/**
	 * Sets the create date of this osp cluster.
	 *
	 * @param createDate the create date of this osp cluster
	 */
	@Override
	public void setCreateDate(Date createDate) {
		model.setCreateDate(createDate);
	}

	/**
	 * Sets the data root dir of this osp cluster.
	 *
	 * @param dataRootDir the data root dir of this osp cluster
	 */
	@Override
	public void setDataRootDir(String dataRootDir) {
		model.setDataRootDir(dataRootDir);
	}

	/**
	 * Sets the description of this osp cluster.
	 *
	 * @param description the description of this osp cluster
	 */
	@Override
	public void setDescription(String description) {
		model.setDescription(description);
	}

	/**
	 * Sets the localized description of this osp cluster in the language.
	 *
	 * @param description the localized description of this osp cluster
	 * @param locale the locale of the language
	 */
	@Override
	public void setDescription(String description, java.util.Locale locale) {
		model.setDescription(description, locale);
	}

	/**
	 * Sets the localized description of this osp cluster in the language, and sets the default locale.
	 *
	 * @param description the localized description of this osp cluster
	 * @param locale the locale of the language
	 * @param defaultLocale the default locale
	 */
	@Override
	public void setDescription(
		String description, java.util.Locale locale,
		java.util.Locale defaultLocale) {

		model.setDescription(description, locale, defaultLocale);
	}

	@Override
	public void setDescriptionCurrentLanguageId(String languageId) {
		model.setDescriptionCurrentLanguageId(languageId);
	}

	/**
	 * Sets the localized descriptions of this osp cluster from the map of locales and localized descriptions.
	 *
	 * @param descriptionMap the locales and localized descriptions of this osp cluster
	 */
	@Override
	public void setDescriptionMap(
		Map<java.util.Locale, String> descriptionMap) {

		model.setDescriptionMap(descriptionMap);
	}

	/**
	 * Sets the localized descriptions of this osp cluster from the map of locales and localized descriptions, and sets the default locale.
	 *
	 * @param descriptionMap the locales and localized descriptions of this osp cluster
	 * @param defaultLocale the default locale
	 */
	@Override
	public void setDescriptionMap(
		Map<java.util.Locale, String> descriptionMap,
		java.util.Locale defaultLocale) {

		model.setDescriptionMap(descriptionMap, defaultLocale);
	}

	/**
	 * Sets the group ID of this osp cluster.
	 *
	 * @param groupId the group ID of this osp cluster
	 */
	@Override
	public void setGroupId(long groupId) {
		model.setGroupId(groupId);
	}

	/**
	 * Sets the modified date of this osp cluster.
	 *
	 * @param modifiedDate the modified date of this osp cluster
	 */
	@Override
	public void setModifiedDate(Date modifiedDate) {
		model.setModifiedDate(modifiedDate);
	}

	/**
	 * Sets the os family of this osp cluster.
	 *
	 * @param osFamily the os family of this osp cluster
	 */
	@Override
	public void setOsFamily(String osFamily) {
		model.setOsFamily(osFamily);
	}

	/**
	 * Sets the os name of this osp cluster.
	 *
	 * @param osName the os name of this osp cluster
	 */
	@Override
	public void setOsName(String osName) {
		model.setOsName(osName);
	}

	/**
	 * Sets the os version of this osp cluster.
	 *
	 * @param osVersion the os version of this osp cluster
	 */
	@Override
	public void setOsVersion(String osVersion) {
		model.setOsVersion(osVersion);
	}

	/**
	 * Sets the primary key of this osp cluster.
	 *
	 * @param primaryKey the primary key of this osp cluster
	 */
	@Override
	public void setPrimaryKey(long primaryKey) {
		model.setPrimaryKey(primaryKey);
	}

	/**
	 * Sets the scheduler class of this osp cluster.
	 *
	 * @param schedulerClass the scheduler class of this osp cluster
	 */
	@Override
	public void setSchedulerClass(String schedulerClass) {
		model.setSchedulerClass(schedulerClass);
	}

	/**
	 * Sets the scheduler name of this osp cluster.
	 *
	 * @param schedulerName the scheduler name of this osp cluster
	 */
	@Override
	public void setSchedulerName(String schedulerName) {
		model.setSchedulerName(schedulerName);
	}

	/**
	 * Sets the scheduler status of this osp cluster.
	 *
	 * @param schedulerStatus the scheduler status of this osp cluster
	 */
	@Override
	public void setSchedulerStatus(int schedulerStatus) {
		model.setSchedulerStatus(schedulerStatus);
	}

	/**
	 * Sets the scheduler version of this osp cluster.
	 *
	 * @param schedulerVersion the scheduler version of this osp cluster
	 */
	@Override
	public void setSchedulerVersion(String schedulerVersion) {
		model.setSchedulerVersion(schedulerVersion);
	}

	/**
	 * Sets the server ip of this osp cluster.
	 *
	 * @param serverIp the server ip of this osp cluster
	 */
	@Override
	public void setServerIp(String serverIp) {
		model.setServerIp(serverIp);
	}

	/**
	 * Sets the ssh port of this osp cluster.
	 *
	 * @param sshPort the ssh port of this osp cluster
	 */
	@Override
	public void setSshPort(String sshPort) {
		model.setSshPort(sshPort);
	}

	/**
	 * Sets the status of this osp cluster.
	 *
	 * @param status the status of this osp cluster
	 */
	@Override
	public void setStatus(int status) {
		model.setStatus(status);
	}

	/**
	 * Sets the user ID of this osp cluster.
	 *
	 * @param userId the user ID of this osp cluster
	 */
	@Override
	public void setUserId(long userId) {
		model.setUserId(userId);
	}

	/**
	 * Sets the user name of this osp cluster.
	 *
	 * @param userName the user name of this osp cluster
	 */
	@Override
	public void setUserName(String userName) {
		model.setUserName(userName);
	}

	/**
	 * Sets the user uuid of this osp cluster.
	 *
	 * @param userUuid the user uuid of this osp cluster
	 */
	@Override
	public void setUserUuid(String userUuid) {
		model.setUserUuid(userUuid);
	}

	/**
	 * Sets the uuid of this osp cluster.
	 *
	 * @param uuid the uuid of this osp cluster
	 */
	@Override
	public void setUuid(String uuid) {
		model.setUuid(uuid);
	}

	@Override
	public StagedModelType getStagedModelType() {
		return model.getStagedModelType();
	}

	@Override
	protected OSPClusterWrapper wrap(OSPCluster ospCluster) {
		return new OSPClusterWrapper(ospCluster);
	}

}