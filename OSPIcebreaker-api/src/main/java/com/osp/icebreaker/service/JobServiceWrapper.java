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

package com.osp.icebreaker.service;

import com.liferay.portal.kernel.service.ServiceWrapper;

/**
 * Provides a wrapper for {@link JobService}.
 *
 * @author Jerry H. Seo
 * @see JobService
 * @generated
 */
public class JobServiceWrapper
	implements JobService, ServiceWrapper<JobService> {

	public JobServiceWrapper(JobService jobService) {
		_jobService = jobService;
	}

	/**
	 * Returns the OSGi service identifier.
	 *
	 * @return the OSGi service identifier
	 */
	@Override
	public String getOSGiServiceIdentifier() {
		return _jobService.getOSGiServiceIdentifier();
	}

	@Override
	public JobService getWrappedService() {
		return _jobService;
	}

	@Override
	public void setWrappedService(JobService jobService) {
		_jobService = jobService;
	}

	private JobService _jobService;

}