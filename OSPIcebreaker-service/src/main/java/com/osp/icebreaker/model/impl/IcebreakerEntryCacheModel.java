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

import com.osp.icebreaker.model.IcebreakerEntry;

import java.io.Externalizable;
import java.io.IOException;
import java.io.ObjectInput;
import java.io.ObjectOutput;

import java.util.Date;

import org.osgi.annotation.versioning.ProviderType;

/**
 * The cache model class for representing IcebreakerEntry in entity cache.
 *
 * @author Jerry H. Seo
 * @generated
 */
@ProviderType
public class IcebreakerEntryCacheModel
	implements CacheModel<IcebreakerEntry>, Externalizable {

	@Override
	public boolean equals(Object obj) {
		if (this == obj) {
			return true;
		}

		if (!(obj instanceof IcebreakerEntryCacheModel)) {
			return false;
		}

		IcebreakerEntryCacheModel icebreakerEntryCacheModel =
			(IcebreakerEntryCacheModel)obj;

		if (icebreakerEntryId == icebreakerEntryCacheModel.icebreakerEntryId) {
			return true;
		}

		return false;
	}

	@Override
	public int hashCode() {
		return HashUtil.hash(0, icebreakerEntryId);
	}

	@Override
	public String toString() {
		StringBundler sb = new StringBundler(33);

		sb.append("{uuid=");
		sb.append(uuid);
		sb.append(", icebreakerEntryId=");
		sb.append(icebreakerEntryId);
		sb.append(", groupId=");
		sb.append(groupId);
		sb.append(", companyId=");
		sb.append(companyId);
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
		sb.append(", name=");
		sb.append(name);
		sb.append(", type=");
		sb.append(type);
		sb.append(", ibIp=");
		sb.append(ibIp);
		sb.append(", ibPort=");
		sb.append(ibPort);
		sb.append(", ibUserId=");
		sb.append(ibUserId);
		sb.append(", ibUserPassword=");
		sb.append(ibUserPassword);
		sb.append(", description=");
		sb.append(description);
		sb.append("}");

		return sb.toString();
	}

	@Override
	public IcebreakerEntry toEntityModel() {
		IcebreakerEntryImpl icebreakerEntryImpl = new IcebreakerEntryImpl();

		if (uuid == null) {
			icebreakerEntryImpl.setUuid("");
		}
		else {
			icebreakerEntryImpl.setUuid(uuid);
		}

		icebreakerEntryImpl.setIcebreakerEntryId(icebreakerEntryId);
		icebreakerEntryImpl.setGroupId(groupId);
		icebreakerEntryImpl.setCompanyId(companyId);
		icebreakerEntryImpl.setUserId(userId);

		if (userName == null) {
			icebreakerEntryImpl.setUserName("");
		}
		else {
			icebreakerEntryImpl.setUserName(userName);
		}

		if (createDate == Long.MIN_VALUE) {
			icebreakerEntryImpl.setCreateDate(null);
		}
		else {
			icebreakerEntryImpl.setCreateDate(new Date(createDate));
		}

		if (modifiedDate == Long.MIN_VALUE) {
			icebreakerEntryImpl.setModifiedDate(null);
		}
		else {
			icebreakerEntryImpl.setModifiedDate(new Date(modifiedDate));
		}

		icebreakerEntryImpl.setStatus(status);

		if (name == null) {
			icebreakerEntryImpl.setName("");
		}
		else {
			icebreakerEntryImpl.setName(name);
		}

		if (type == null) {
			icebreakerEntryImpl.setType("");
		}
		else {
			icebreakerEntryImpl.setType(type);
		}

		if (ibIp == null) {
			icebreakerEntryImpl.setIbIp("");
		}
		else {
			icebreakerEntryImpl.setIbIp(ibIp);
		}

		if (ibPort == null) {
			icebreakerEntryImpl.setIbPort("");
		}
		else {
			icebreakerEntryImpl.setIbPort(ibPort);
		}

		if (ibUserId == null) {
			icebreakerEntryImpl.setIbUserId("");
		}
		else {
			icebreakerEntryImpl.setIbUserId(ibUserId);
		}

		if (ibUserPassword == null) {
			icebreakerEntryImpl.setIbUserPassword("");
		}
		else {
			icebreakerEntryImpl.setIbUserPassword(ibUserPassword);
		}

		if (description == null) {
			icebreakerEntryImpl.setDescription("");
		}
		else {
			icebreakerEntryImpl.setDescription(description);
		}

		icebreakerEntryImpl.resetOriginalValues();

		return icebreakerEntryImpl;
	}

	@Override
	public void readExternal(ObjectInput objectInput) throws IOException {
		uuid = objectInput.readUTF();

		icebreakerEntryId = objectInput.readLong();

		groupId = objectInput.readLong();

		companyId = objectInput.readLong();

		userId = objectInput.readLong();
		userName = objectInput.readUTF();
		createDate = objectInput.readLong();
		modifiedDate = objectInput.readLong();

		status = objectInput.readInt();
		name = objectInput.readUTF();
		type = objectInput.readUTF();
		ibIp = objectInput.readUTF();
		ibPort = objectInput.readUTF();
		ibUserId = objectInput.readUTF();
		ibUserPassword = objectInput.readUTF();
		description = objectInput.readUTF();
	}

	@Override
	public void writeExternal(ObjectOutput objectOutput) throws IOException {
		if (uuid == null) {
			objectOutput.writeUTF("");
		}
		else {
			objectOutput.writeUTF(uuid);
		}

		objectOutput.writeLong(icebreakerEntryId);

		objectOutput.writeLong(groupId);

		objectOutput.writeLong(companyId);

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

		if (name == null) {
			objectOutput.writeUTF("");
		}
		else {
			objectOutput.writeUTF(name);
		}

		if (type == null) {
			objectOutput.writeUTF("");
		}
		else {
			objectOutput.writeUTF(type);
		}

		if (ibIp == null) {
			objectOutput.writeUTF("");
		}
		else {
			objectOutput.writeUTF(ibIp);
		}

		if (ibPort == null) {
			objectOutput.writeUTF("");
		}
		else {
			objectOutput.writeUTF(ibPort);
		}

		if (ibUserId == null) {
			objectOutput.writeUTF("");
		}
		else {
			objectOutput.writeUTF(ibUserId);
		}

		if (ibUserPassword == null) {
			objectOutput.writeUTF("");
		}
		else {
			objectOutput.writeUTF(ibUserPassword);
		}

		if (description == null) {
			objectOutput.writeUTF("");
		}
		else {
			objectOutput.writeUTF(description);
		}
	}

	public String uuid;
	public long icebreakerEntryId;
	public long groupId;
	public long companyId;
	public long userId;
	public String userName;
	public long createDate;
	public long modifiedDate;
	public int status;
	public String name;
	public String type;
	public String ibIp;
	public String ibPort;
	public String ibUserId;
	public String ibUserPassword;
	public String description;

}