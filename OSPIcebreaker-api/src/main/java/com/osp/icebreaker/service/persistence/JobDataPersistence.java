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

package com.osp.icebreaker.service.persistence;

import com.liferay.portal.kernel.service.persistence.BasePersistence;

import com.osp.icebreaker.exception.NoSuchJobDataException;
import com.osp.icebreaker.model.JobData;

import org.osgi.annotation.versioning.ProviderType;

/**
 * The persistence interface for the job data service.
 *
 * <p>
 * Caching information and settings can be found in <code>portal.properties</code>
 * </p>
 *
 * @author Jerry H. Seo
 * @see JobDataUtil
 * @generated
 */
@ProviderType
public interface JobDataPersistence extends BasePersistence<JobData> {

	/*
	 * NOTE FOR DEVELOPERS:
	 *
	 * Never modify or reference this interface directly. Always use {@link JobDataUtil} to access the job data persistence. Modify <code>service.xml</code> and rerun ServiceBuilder to regenerate this interface.
	 */

	/**
	 * Caches the job data in the entity cache if it is enabled.
	 *
	 * @param jobData the job data
	 */
	public void cacheResult(JobData jobData);

	/**
	 * Caches the job datas in the entity cache if it is enabled.
	 *
	 * @param jobDatas the job datas
	 */
	public void cacheResult(java.util.List<JobData> jobDatas);

	/**
	 * Creates a new job data with the primary key. Does not add the job data to the database.
	 *
	 * @param jobId the primary key for the new job data
	 * @return the new job data
	 */
	public JobData create(long jobId);

	/**
	 * Removes the job data with the primary key from the database. Also notifies the appropriate model listeners.
	 *
	 * @param jobId the primary key of the job data
	 * @return the job data that was removed
	 * @throws NoSuchJobDataException if a job data with the primary key could not be found
	 */
	public JobData remove(long jobId) throws NoSuchJobDataException;

	public JobData updateImpl(JobData jobData);

	/**
	 * Returns the job data with the primary key or throws a <code>NoSuchJobDataException</code> if it could not be found.
	 *
	 * @param jobId the primary key of the job data
	 * @return the job data
	 * @throws NoSuchJobDataException if a job data with the primary key could not be found
	 */
	public JobData findByPrimaryKey(long jobId) throws NoSuchJobDataException;

	/**
	 * Returns the job data with the primary key or returns <code>null</code> if it could not be found.
	 *
	 * @param jobId the primary key of the job data
	 * @return the job data, or <code>null</code> if a job data with the primary key could not be found
	 */
	public JobData fetchByPrimaryKey(long jobId);

	/**
	 * Returns all the job datas.
	 *
	 * @return the job datas
	 */
	public java.util.List<JobData> findAll();

	/**
	 * Returns a range of all the job datas.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>JobDataModelImpl</code>.
	 * </p>
	 *
	 * @param start the lower bound of the range of job datas
	 * @param end the upper bound of the range of job datas (not inclusive)
	 * @return the range of job datas
	 */
	public java.util.List<JobData> findAll(int start, int end);

	/**
	 * Returns an ordered range of all the job datas.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>JobDataModelImpl</code>.
	 * </p>
	 *
	 * @param start the lower bound of the range of job datas
	 * @param end the upper bound of the range of job datas (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @return the ordered range of job datas
	 */
	public java.util.List<JobData> findAll(
		int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator<JobData>
			orderByComparator);

	/**
	 * Returns an ordered range of all the job datas.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>JobDataModelImpl</code>.
	 * </p>
	 *
	 * @param start the lower bound of the range of job datas
	 * @param end the upper bound of the range of job datas (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @param useFinderCache whether to use the finder cache
	 * @return the ordered range of job datas
	 */
	public java.util.List<JobData> findAll(
		int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator<JobData>
			orderByComparator,
		boolean useFinderCache);

	/**
	 * Removes all the job datas from the database.
	 */
	public void removeAll();

	/**
	 * Returns the number of job datas.
	 *
	 * @return the number of job datas
	 */
	public int countAll();

}