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
 * This class is used by SOAP remote services, specifically {@link com.osp.icebreaker.service.http.IcebreakerEntryServiceSoap}.
 *
 * @author Jerry H. Seo
 * @generated
 */
@ProviderType
public class IcebreakerEntrySoap implements Serializable {

	public static IcebreakerEntrySoap toSoapModel(IcebreakerEntry model) {
		IcebreakerEntrySoap soapModel = new IcebreakerEntrySoap();

		soapModel.setUuid(model.getUuid());
		soapModel.setIcebreakerEntryId(model.getIcebreakerEntryId());
		soapModel.setGroupId(model.getGroupId());
		soapModel.setCompanyId(model.getCompanyId());
		soapModel.setUserId(model.getUserId());
		soapModel.setUserName(model.getUserName());
		soapModel.setCreateDate(model.getCreateDate());
		soapModel.setModifiedDate(model.getModifiedDate());
		soapModel.setStatus(model.getStatus());
		soapModel.setName(model.getName());
		soapModel.setType(model.getType());
		soapModel.setIbIp(model.getIbIp());
		soapModel.setIbPort(model.getIbPort());
		soapModel.setIbUserId(model.getIbUserId());
		soapModel.setIbUserPassword(model.getIbUserPassword());
		soapModel.setDescription(model.getDescription());

		return soapModel;
	}

	public static IcebreakerEntrySoap[] toSoapModels(IcebreakerEntry[] models) {
		IcebreakerEntrySoap[] soapModels =
			new IcebreakerEntrySoap[models.length];

		for (int i = 0; i < models.length; i++) {
			soapModels[i] = toSoapModel(models[i]);
		}

		return soapModels;
	}

	public static IcebreakerEntrySoap[][] toSoapModels(
		IcebreakerEntry[][] models) {

		IcebreakerEntrySoap[][] soapModels = null;

		if (models.length > 0) {
			soapModels =
				new IcebreakerEntrySoap[models.length][models[0].length];
		}
		else {
			soapModels = new IcebreakerEntrySoap[0][0];
		}

		for (int i = 0; i < models.length; i++) {
			soapModels[i] = toSoapModels(models[i]);
		}

		return soapModels;
	}

	public static IcebreakerEntrySoap[] toSoapModels(
		List<IcebreakerEntry> models) {

		List<IcebreakerEntrySoap> soapModels =
			new ArrayList<IcebreakerEntrySoap>(models.size());

		for (IcebreakerEntry model : models) {
			soapModels.add(toSoapModel(model));
		}

		return soapModels.toArray(new IcebreakerEntrySoap[soapModels.size()]);
	}

	public IcebreakerEntrySoap() {
	}

	public long getPrimaryKey() {
		return _icebreakerEntryId;
	}

	public void setPrimaryKey(long pk) {
		setIcebreakerEntryId(pk);
	}

	public String getUuid() {
		return _uuid;
	}

	public void setUuid(String uuid) {
		_uuid = uuid;
	}

	public long getIcebreakerEntryId() {
		return _icebreakerEntryId;
	}

	public void setIcebreakerEntryId(long icebreakerEntryId) {
		_icebreakerEntryId = icebreakerEntryId;
	}

	public long getGroupId() {
		return _groupId;
	}

	public void setGroupId(long groupId) {
		_groupId = groupId;
	}

	public long getCompanyId() {
		return _companyId;
	}

	public void setCompanyId(long companyId) {
		_companyId = companyId;
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

	public String getName() {
		return _name;
	}

	public void setName(String name) {
		_name = name;
	}

	public String getType() {
		return _type;
	}

	public void setType(String type) {
		_type = type;
	}

	public String getIbIp() {
		return _ibIp;
	}

	public void setIbIp(String ibIp) {
		_ibIp = ibIp;
	}

	public String getIbPort() {
		return _ibPort;
	}

	public void setIbPort(String ibPort) {
		_ibPort = ibPort;
	}

	public String getIbUserId() {
		return _ibUserId;
	}

	public void setIbUserId(String ibUserId) {
		_ibUserId = ibUserId;
	}

	public String getIbUserPassword() {
		return _ibUserPassword;
	}

	public void setIbUserPassword(String ibUserPassword) {
		_ibUserPassword = ibUserPassword;
	}

	public String getDescription() {
		return _description;
	}

	public void setDescription(String description) {
		_description = description;
	}

	private String _uuid;
	private long _icebreakerEntryId;
	private long _groupId;
	private long _companyId;
	private long _userId;
	private String _userName;
	private Date _createDate;
	private Date _modifiedDate;
	private int _status;
	private String _name;
	private String _type;
	private String _ibIp;
	private String _ibPort;
	private String _ibUserId;
	private String _ibUserPassword;
	private String _description;

}