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

import com.osp.icebreaker.model.JobData;

import java.io.Externalizable;
import java.io.IOException;
import java.io.ObjectInput;
import java.io.ObjectOutput;

import org.osgi.annotation.versioning.ProviderType;

/**
 * The cache model class for representing JobData in entity cache.
 *
 * @author Jerry H. Seo
 * @generated
 */
@ProviderType
public class JobDataCacheModel implements CacheModel<JobData>, Externalizable {

	@Override
	public boolean equals(Object obj) {
		if (this == obj) {
			return true;
		}

		if (!(obj instanceof JobDataCacheModel)) {
			return false;
		}

		JobDataCacheModel jobDataCacheModel = (JobDataCacheModel)obj;

		if (jobId == jobDataCacheModel.jobId) {
			return true;
		}

		return false;
	}

	@Override
	public int hashCode() {
		return HashUtil.hash(0, jobId);
	}

	@Override
	public String toString() {
		StringBundler sb = new StringBundler(5);

		sb.append("{jobId=");
		sb.append(jobId);
		sb.append(", inputData=");
		sb.append(inputData);
		sb.append("}");

		return sb.toString();
	}

	@Override
	public JobData toEntityModel() {
		JobDataImpl jobDataImpl = new JobDataImpl();

		jobDataImpl.setJobId(jobId);

		if (inputData == null) {
			jobDataImpl.setInputData("");
		}
		else {
			jobDataImpl.setInputData(inputData);
		}

		jobDataImpl.resetOriginalValues();

		return jobDataImpl;
	}

	@Override
	public void readExternal(ObjectInput objectInput) throws IOException {
		jobId = objectInput.readLong();
		inputData = objectInput.readUTF();
	}

	@Override
	public void writeExternal(ObjectOutput objectOutput) throws IOException {
		objectOutput.writeLong(jobId);

		if (inputData == null) {
			objectOutput.writeUTF("");
		}
		else {
			objectOutput.writeUTF(inputData);
		}
	}

	public long jobId;
	public String inputData;

}