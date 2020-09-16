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
import java.util.List;

import org.osgi.annotation.versioning.ProviderType;

/**
 * This class is used by SOAP remote services.
 *
 * @author Jerry H. Seo
 * @generated
 */
@ProviderType
public class JobDataSoap implements Serializable {

	public static JobDataSoap toSoapModel(JobData model) {
		JobDataSoap soapModel = new JobDataSoap();

		soapModel.setJobId(model.getJobId());
		soapModel.setInputData(model.getInputData());

		return soapModel;
	}

	public static JobDataSoap[] toSoapModels(JobData[] models) {
		JobDataSoap[] soapModels = new JobDataSoap[models.length];

		for (int i = 0; i < models.length; i++) {
			soapModels[i] = toSoapModel(models[i]);
		}

		return soapModels;
	}

	public static JobDataSoap[][] toSoapModels(JobData[][] models) {
		JobDataSoap[][] soapModels = null;

		if (models.length > 0) {
			soapModels = new JobDataSoap[models.length][models[0].length];
		}
		else {
			soapModels = new JobDataSoap[0][0];
		}

		for (int i = 0; i < models.length; i++) {
			soapModels[i] = toSoapModels(models[i]);
		}

		return soapModels;
	}

	public static JobDataSoap[] toSoapModels(List<JobData> models) {
		List<JobDataSoap> soapModels = new ArrayList<JobDataSoap>(
			models.size());

		for (JobData model : models) {
			soapModels.add(toSoapModel(model));
		}

		return soapModels.toArray(new JobDataSoap[soapModels.size()]);
	}

	public JobDataSoap() {
	}

	public long getPrimaryKey() {
		return _jobId;
	}

	public void setPrimaryKey(long pk) {
		setJobId(pk);
	}

	public long getJobId() {
		return _jobId;
	}

	public void setJobId(long jobId) {
		_jobId = jobId;
	}

	public String getInputData() {
		return _inputData;
	}

	public void setInputData(String inputData) {
		_inputData = inputData;
	}

	private long _jobId;
	private String _inputData;

}