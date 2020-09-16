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

import com.liferay.portal.kernel.model.ModelWrapper;
import com.liferay.portal.kernel.model.wrapper.BaseModelWrapper;

import java.util.HashMap;
import java.util.Map;

import org.osgi.annotation.versioning.ProviderType;

/**
 * <p>
 * This class is a wrapper for {@link JobData}.
 * </p>
 *
 * @author Jerry H. Seo
 * @see JobData
 * @generated
 */
@ProviderType
public class JobDataWrapper
	extends BaseModelWrapper<JobData>
	implements JobData, ModelWrapper<JobData> {

	public JobDataWrapper(JobData jobData) {
		super(jobData);
	}

	@Override
	public Map<String, Object> getModelAttributes() {
		Map<String, Object> attributes = new HashMap<String, Object>();

		attributes.put("jobId", getJobId());
		attributes.put("inputData", getInputData());

		return attributes;
	}

	@Override
	public void setModelAttributes(Map<String, Object> attributes) {
		Long jobId = (Long)attributes.get("jobId");

		if (jobId != null) {
			setJobId(jobId);
		}

		String inputData = (String)attributes.get("inputData");

		if (inputData != null) {
			setInputData(inputData);
		}
	}

	/**
	 * Returns the input data of this job data.
	 *
	 * @return the input data of this job data
	 */
	@Override
	public String getInputData() {
		return model.getInputData();
	}

	/**
	 * Returns the job ID of this job data.
	 *
	 * @return the job ID of this job data
	 */
	@Override
	public long getJobId() {
		return model.getJobId();
	}

	/**
	 * Returns the primary key of this job data.
	 *
	 * @return the primary key of this job data
	 */
	@Override
	public long getPrimaryKey() {
		return model.getPrimaryKey();
	}

	@Override
	public void persist() {
		model.persist();
	}

	/**
	 * Sets the input data of this job data.
	 *
	 * @param inputData the input data of this job data
	 */
	@Override
	public void setInputData(String inputData) {
		model.setInputData(inputData);
	}

	/**
	 * Sets the job ID of this job data.
	 *
	 * @param jobId the job ID of this job data
	 */
	@Override
	public void setJobId(long jobId) {
		model.setJobId(jobId);
	}

	/**
	 * Sets the primary key of this job data.
	 *
	 * @param primaryKey the primary key of this job data
	 */
	@Override
	public void setPrimaryKey(long primaryKey) {
		model.setPrimaryKey(primaryKey);
	}

	@Override
	protected JobDataWrapper wrap(JobData jobData) {
		return new JobDataWrapper(jobData);
	}

}