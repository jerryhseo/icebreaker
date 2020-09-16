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

import com.liferay.portal.kernel.annotation.ImplementationClassName;
import com.liferay.portal.kernel.model.PersistedModel;
import com.liferay.portal.kernel.util.Accessor;

import org.osgi.annotation.versioning.ProviderType;

/**
 * The extended model interface for the Job service. Represents a row in the &quot;ICEBREAKER_Job&quot; database table, with each column mapped to a property of this class.
 *
 * @author Jerry H. Seo
 * @see JobModel
 * @generated
 */
@ImplementationClassName("com.osp.icebreaker.model.impl.JobImpl")
@ProviderType
public interface Job extends JobModel, PersistedModel {

	/*
	 * NOTE FOR DEVELOPERS:
	 *
	 * Never modify this interface directly. Add methods to <code>com.osp.icebreaker.model.impl.JobImpl</code> and rerun ServiceBuilder to automatically copy the method declarations to this interface.
	 */
	public static final Accessor<Job, String> UUID_ACCESSOR =
		new Accessor<Job, String>() {

			@Override
			public String get(Job job) {
				return job.getUuid();
			}

			@Override
			public Class<String> getAttributeClass() {
				return String.class;
			}

			@Override
			public Class<Job> getTypeClass() {
				return Job.class;
			}

		};

	public static final Accessor<Job, Long> JOB_ID_ACCESSOR =
		new Accessor<Job, Long>() {

			@Override
			public Long get(Job job) {
				return job.getJobId();
			}

			@Override
			public Class<Long> getAttributeClass() {
				return Long.class;
			}

			@Override
			public Class<Job> getTypeClass() {
				return Job.class;
			}

		};

}