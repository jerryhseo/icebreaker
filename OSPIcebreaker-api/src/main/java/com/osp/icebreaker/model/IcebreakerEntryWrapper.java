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
 * This class is a wrapper for {@link IcebreakerEntry}.
 * </p>
 *
 * @author Jerry H. Seo
 * @see IcebreakerEntry
 * @generated
 */
@ProviderType
public class IcebreakerEntryWrapper
	extends BaseModelWrapper<IcebreakerEntry>
	implements IcebreakerEntry, ModelWrapper<IcebreakerEntry> {

	public IcebreakerEntryWrapper(IcebreakerEntry icebreakerEntry) {
		super(icebreakerEntry);
	}

	@Override
	public Map<String, Object> getModelAttributes() {
		Map<String, Object> attributes = new HashMap<String, Object>();

		attributes.put("uuid", getUuid());
		attributes.put("icebreakerEntryId", getIcebreakerEntryId());
		attributes.put("groupId", getGroupId());
		attributes.put("companyId", getCompanyId());
		attributes.put("userId", getUserId());
		attributes.put("userName", getUserName());
		attributes.put("createDate", getCreateDate());
		attributes.put("modifiedDate", getModifiedDate());
		attributes.put("status", getStatus());
		attributes.put("name", getName());
		attributes.put("type", getType());
		attributes.put("ibIp", getIbIp());
		attributes.put("ibPort", getIbPort());
		attributes.put("ibUserId", getIbUserId());
		attributes.put("ibUserPassword", getIbUserPassword());
		attributes.put("description", getDescription());

		return attributes;
	}

	@Override
	public void setModelAttributes(Map<String, Object> attributes) {
		String uuid = (String)attributes.get("uuid");

		if (uuid != null) {
			setUuid(uuid);
		}

		Long icebreakerEntryId = (Long)attributes.get("icebreakerEntryId");

		if (icebreakerEntryId != null) {
			setIcebreakerEntryId(icebreakerEntryId);
		}

		Long groupId = (Long)attributes.get("groupId");

		if (groupId != null) {
			setGroupId(groupId);
		}

		Long companyId = (Long)attributes.get("companyId");

		if (companyId != null) {
			setCompanyId(companyId);
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

		String name = (String)attributes.get("name");

		if (name != null) {
			setName(name);
		}

		String type = (String)attributes.get("type");

		if (type != null) {
			setType(type);
		}

		String ibIp = (String)attributes.get("ibIp");

		if (ibIp != null) {
			setIbIp(ibIp);
		}

		String ibPort = (String)attributes.get("ibPort");

		if (ibPort != null) {
			setIbPort(ibPort);
		}

		String ibUserId = (String)attributes.get("ibUserId");

		if (ibUserId != null) {
			setIbUserId(ibUserId);
		}

		String ibUserPassword = (String)attributes.get("ibUserPassword");

		if (ibUserPassword != null) {
			setIbUserPassword(ibUserPassword);
		}

		String description = (String)attributes.get("description");

		if (description != null) {
			setDescription(description);
		}
	}

	@Override
	public String[] getAvailableLanguageIds() {
		return model.getAvailableLanguageIds();
	}

	/**
	 * Returns the company ID of this icebreaker entry.
	 *
	 * @return the company ID of this icebreaker entry
	 */
	@Override
	public long getCompanyId() {
		return model.getCompanyId();
	}

	/**
	 * Returns the create date of this icebreaker entry.
	 *
	 * @return the create date of this icebreaker entry
	 */
	@Override
	public Date getCreateDate() {
		return model.getCreateDate();
	}

	@Override
	public String getDefaultLanguageId() {
		return model.getDefaultLanguageId();
	}

	/**
	 * Returns the description of this icebreaker entry.
	 *
	 * @return the description of this icebreaker entry
	 */
	@Override
	public String getDescription() {
		return model.getDescription();
	}

	/**
	 * Returns the localized description of this icebreaker entry in the language. Uses the default language if no localization exists for the requested language.
	 *
	 * @param locale the locale of the language
	 * @return the localized description of this icebreaker entry
	 */
	@Override
	public String getDescription(java.util.Locale locale) {
		return model.getDescription(locale);
	}

	/**
	 * Returns the localized description of this icebreaker entry in the language, optionally using the default language if no localization exists for the requested language.
	 *
	 * @param locale the local of the language
	 * @param useDefault whether to use the default language if no localization exists for the requested language
	 * @return the localized description of this icebreaker entry. If <code>useDefault</code> is <code>false</code> and no localization exists for the requested language, an empty string will be returned.
	 */
	@Override
	public String getDescription(java.util.Locale locale, boolean useDefault) {
		return model.getDescription(locale, useDefault);
	}

	/**
	 * Returns the localized description of this icebreaker entry in the language. Uses the default language if no localization exists for the requested language.
	 *
	 * @param languageId the ID of the language
	 * @return the localized description of this icebreaker entry
	 */
	@Override
	public String getDescription(String languageId) {
		return model.getDescription(languageId);
	}

	/**
	 * Returns the localized description of this icebreaker entry in the language, optionally using the default language if no localization exists for the requested language.
	 *
	 * @param languageId the ID of the language
	 * @param useDefault whether to use the default language if no localization exists for the requested language
	 * @return the localized description of this icebreaker entry
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
	 * Returns a map of the locales and localized descriptions of this icebreaker entry.
	 *
	 * @return the locales and localized descriptions of this icebreaker entry
	 */
	@Override
	public Map<java.util.Locale, String> getDescriptionMap() {
		return model.getDescriptionMap();
	}

	/**
	 * Returns the group ID of this icebreaker entry.
	 *
	 * @return the group ID of this icebreaker entry
	 */
	@Override
	public long getGroupId() {
		return model.getGroupId();
	}

	/**
	 * Returns the ib ip of this icebreaker entry.
	 *
	 * @return the ib ip of this icebreaker entry
	 */
	@Override
	public String getIbIp() {
		return model.getIbIp();
	}

	/**
	 * Returns the ib port of this icebreaker entry.
	 *
	 * @return the ib port of this icebreaker entry
	 */
	@Override
	public String getIbPort() {
		return model.getIbPort();
	}

	/**
	 * Returns the ib user ID of this icebreaker entry.
	 *
	 * @return the ib user ID of this icebreaker entry
	 */
	@Override
	public String getIbUserId() {
		return model.getIbUserId();
	}

	/**
	 * Returns the ib user password of this icebreaker entry.
	 *
	 * @return the ib user password of this icebreaker entry
	 */
	@Override
	public String getIbUserPassword() {
		return model.getIbUserPassword();
	}

	/**
	 * Returns the icebreaker entry ID of this icebreaker entry.
	 *
	 * @return the icebreaker entry ID of this icebreaker entry
	 */
	@Override
	public long getIcebreakerEntryId() {
		return model.getIcebreakerEntryId();
	}

	/**
	 * Returns the modified date of this icebreaker entry.
	 *
	 * @return the modified date of this icebreaker entry
	 */
	@Override
	public Date getModifiedDate() {
		return model.getModifiedDate();
	}

	/**
	 * Returns the name of this icebreaker entry.
	 *
	 * @return the name of this icebreaker entry
	 */
	@Override
	public String getName() {
		return model.getName();
	}

	/**
	 * Returns the primary key of this icebreaker entry.
	 *
	 * @return the primary key of this icebreaker entry
	 */
	@Override
	public long getPrimaryKey() {
		return model.getPrimaryKey();
	}

	/**
	 * Returns the status of this icebreaker entry.
	 *
	 * @return the status of this icebreaker entry
	 */
	@Override
	public int getStatus() {
		return model.getStatus();
	}

	/**
	 * Returns the type of this icebreaker entry.
	 *
	 * @return the type of this icebreaker entry
	 */
	@Override
	public String getType() {
		return model.getType();
	}

	/**
	 * Returns the user ID of this icebreaker entry.
	 *
	 * @return the user ID of this icebreaker entry
	 */
	@Override
	public long getUserId() {
		return model.getUserId();
	}

	/**
	 * Returns the user name of this icebreaker entry.
	 *
	 * @return the user name of this icebreaker entry
	 */
	@Override
	public String getUserName() {
		return model.getUserName();
	}

	/**
	 * Returns the user uuid of this icebreaker entry.
	 *
	 * @return the user uuid of this icebreaker entry
	 */
	@Override
	public String getUserUuid() {
		return model.getUserUuid();
	}

	/**
	 * Returns the uuid of this icebreaker entry.
	 *
	 * @return the uuid of this icebreaker entry
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
	 * Sets the company ID of this icebreaker entry.
	 *
	 * @param companyId the company ID of this icebreaker entry
	 */
	@Override
	public void setCompanyId(long companyId) {
		model.setCompanyId(companyId);
	}

	/**
	 * Sets the create date of this icebreaker entry.
	 *
	 * @param createDate the create date of this icebreaker entry
	 */
	@Override
	public void setCreateDate(Date createDate) {
		model.setCreateDate(createDate);
	}

	/**
	 * Sets the description of this icebreaker entry.
	 *
	 * @param description the description of this icebreaker entry
	 */
	@Override
	public void setDescription(String description) {
		model.setDescription(description);
	}

	/**
	 * Sets the localized description of this icebreaker entry in the language.
	 *
	 * @param description the localized description of this icebreaker entry
	 * @param locale the locale of the language
	 */
	@Override
	public void setDescription(String description, java.util.Locale locale) {
		model.setDescription(description, locale);
	}

	/**
	 * Sets the localized description of this icebreaker entry in the language, and sets the default locale.
	 *
	 * @param description the localized description of this icebreaker entry
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
	 * Sets the localized descriptions of this icebreaker entry from the map of locales and localized descriptions.
	 *
	 * @param descriptionMap the locales and localized descriptions of this icebreaker entry
	 */
	@Override
	public void setDescriptionMap(
		Map<java.util.Locale, String> descriptionMap) {

		model.setDescriptionMap(descriptionMap);
	}

	/**
	 * Sets the localized descriptions of this icebreaker entry from the map of locales and localized descriptions, and sets the default locale.
	 *
	 * @param descriptionMap the locales and localized descriptions of this icebreaker entry
	 * @param defaultLocale the default locale
	 */
	@Override
	public void setDescriptionMap(
		Map<java.util.Locale, String> descriptionMap,
		java.util.Locale defaultLocale) {

		model.setDescriptionMap(descriptionMap, defaultLocale);
	}

	/**
	 * Sets the group ID of this icebreaker entry.
	 *
	 * @param groupId the group ID of this icebreaker entry
	 */
	@Override
	public void setGroupId(long groupId) {
		model.setGroupId(groupId);
	}

	/**
	 * Sets the ib ip of this icebreaker entry.
	 *
	 * @param ibIp the ib ip of this icebreaker entry
	 */
	@Override
	public void setIbIp(String ibIp) {
		model.setIbIp(ibIp);
	}

	/**
	 * Sets the ib port of this icebreaker entry.
	 *
	 * @param ibPort the ib port of this icebreaker entry
	 */
	@Override
	public void setIbPort(String ibPort) {
		model.setIbPort(ibPort);
	}

	/**
	 * Sets the ib user ID of this icebreaker entry.
	 *
	 * @param ibUserId the ib user ID of this icebreaker entry
	 */
	@Override
	public void setIbUserId(String ibUserId) {
		model.setIbUserId(ibUserId);
	}

	/**
	 * Sets the ib user password of this icebreaker entry.
	 *
	 * @param ibUserPassword the ib user password of this icebreaker entry
	 */
	@Override
	public void setIbUserPassword(String ibUserPassword) {
		model.setIbUserPassword(ibUserPassword);
	}

	/**
	 * Sets the icebreaker entry ID of this icebreaker entry.
	 *
	 * @param icebreakerEntryId the icebreaker entry ID of this icebreaker entry
	 */
	@Override
	public void setIcebreakerEntryId(long icebreakerEntryId) {
		model.setIcebreakerEntryId(icebreakerEntryId);
	}

	/**
	 * Sets the modified date of this icebreaker entry.
	 *
	 * @param modifiedDate the modified date of this icebreaker entry
	 */
	@Override
	public void setModifiedDate(Date modifiedDate) {
		model.setModifiedDate(modifiedDate);
	}

	/**
	 * Sets the name of this icebreaker entry.
	 *
	 * @param name the name of this icebreaker entry
	 */
	@Override
	public void setName(String name) {
		model.setName(name);
	}

	/**
	 * Sets the primary key of this icebreaker entry.
	 *
	 * @param primaryKey the primary key of this icebreaker entry
	 */
	@Override
	public void setPrimaryKey(long primaryKey) {
		model.setPrimaryKey(primaryKey);
	}

	/**
	 * Sets the status of this icebreaker entry.
	 *
	 * @param status the status of this icebreaker entry
	 */
	@Override
	public void setStatus(int status) {
		model.setStatus(status);
	}

	/**
	 * Sets the type of this icebreaker entry.
	 *
	 * @param type the type of this icebreaker entry
	 */
	@Override
	public void setType(String type) {
		model.setType(type);
	}

	/**
	 * Sets the user ID of this icebreaker entry.
	 *
	 * @param userId the user ID of this icebreaker entry
	 */
	@Override
	public void setUserId(long userId) {
		model.setUserId(userId);
	}

	/**
	 * Sets the user name of this icebreaker entry.
	 *
	 * @param userName the user name of this icebreaker entry
	 */
	@Override
	public void setUserName(String userName) {
		model.setUserName(userName);
	}

	/**
	 * Sets the user uuid of this icebreaker entry.
	 *
	 * @param userUuid the user uuid of this icebreaker entry
	 */
	@Override
	public void setUserUuid(String userUuid) {
		model.setUserUuid(userUuid);
	}

	/**
	 * Sets the uuid of this icebreaker entry.
	 *
	 * @param uuid the uuid of this icebreaker entry
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
	protected IcebreakerEntryWrapper wrap(IcebreakerEntry icebreakerEntry) {
		return new IcebreakerEntryWrapper(icebreakerEntry);
	}

}