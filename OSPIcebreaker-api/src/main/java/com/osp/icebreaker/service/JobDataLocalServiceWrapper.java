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
 * Provides a wrapper for {@link JobDataLocalService}.
 *
 * @author Jerry H. Seo
 * @see JobDataLocalService
 * @generated
 */
public class JobDataLocalServiceWrapper
	implements JobDataLocalService, ServiceWrapper<JobDataLocalService> {

	public JobDataLocalServiceWrapper(JobDataLocalService jobDataLocalService) {
		_jobDataLocalService = jobDataLocalService;
	}

	/**
	 * Adds the job data to the database. Also notifies the appropriate model listeners.
	 *
	 * @param jobData the job data
	 * @return the job data that was added
	 */
	@Override
	public com.osp.icebreaker.model.JobData addJobData(
		com.osp.icebreaker.model.JobData jobData) {

		return _jobDataLocalService.addJobData(jobData);
	}

	/**
	 * Creates a new job data with the primary key. Does not add the job data to the database.
	 *
	 * @param jobId the primary key for the new job data
	 * @return the new job data
	 */
	@Override
	public com.osp.icebreaker.model.JobData createJobData(long jobId) {
		return _jobDataLocalService.createJobData(jobId);
	}

	/**
	 * Deletes the job data from the database. Also notifies the appropriate model listeners.
	 *
	 * @param jobData the job data
	 * @return the job data that was removed
	 */
	@Override
	public com.osp.icebreaker.model.JobData deleteJobData(
		com.osp.icebreaker.model.JobData jobData) {

		return _jobDataLocalService.deleteJobData(jobData);
	}

	/**
	 * Deletes the job data with the primary key from the database. Also notifies the appropriate model listeners.
	 *
	 * @param jobId the primary key of the job data
	 * @return the job data that was removed
	 * @throws PortalException if a job data with the primary key could not be found
	 */
	@Override
	public com.osp.icebreaker.model.JobData deleteJobData(long jobId)
		throws com.liferay.portal.kernel.exception.PortalException {

		return _jobDataLocalService.deleteJobData(jobId);
	}

	/**
	 * @throws PortalException
	 */
	@Override
	public com.liferay.portal.kernel.model.PersistedModel deletePersistedModel(
			com.liferay.portal.kernel.model.PersistedModel persistedModel)
		throws com.liferay.portal.kernel.exception.PortalException {

		return _jobDataLocalService.deletePersistedModel(persistedModel);
	}

	@Override
	public com.liferay.portal.kernel.dao.orm.DynamicQuery dynamicQuery() {
		return _jobDataLocalService.dynamicQuery();
	}

	/**
	 * Performs a dynamic query on the database and returns the matching rows.
	 *
	 * @param dynamicQuery the dynamic query
	 * @return the matching rows
	 */
	@Override
	public <T> java.util.List<T> dynamicQuery(
		com.liferay.portal.kernel.dao.orm.DynamicQuery dynamicQuery) {

		return _jobDataLocalService.dynamicQuery(dynamicQuery);
	}

	/**
	 * Performs a dynamic query on the database and returns a range of the matching rows.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>com.osp.icebreaker.model.impl.JobDataModelImpl</code>.
	 * </p>
	 *
	 * @param dynamicQuery the dynamic query
	 * @param start the lower bound of the range of model instances
	 * @param end the upper bound of the range of model instances (not inclusive)
	 * @return the range of matching rows
	 */
	@Override
	public <T> java.util.List<T> dynamicQuery(
		com.liferay.portal.kernel.dao.orm.DynamicQuery dynamicQuery, int start,
		int end) {

		return _jobDataLocalService.dynamicQuery(dynamicQuery, start, end);
	}

	/**
	 * Performs a dynamic query on the database and returns an ordered range of the matching rows.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>com.osp.icebreaker.model.impl.JobDataModelImpl</code>.
	 * </p>
	 *
	 * @param dynamicQuery the dynamic query
	 * @param start the lower bound of the range of model instances
	 * @param end the upper bound of the range of model instances (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @return the ordered range of matching rows
	 */
	@Override
	public <T> java.util.List<T> dynamicQuery(
		com.liferay.portal.kernel.dao.orm.DynamicQuery dynamicQuery, int start,
		int end,
		com.liferay.portal.kernel.util.OrderByComparator<T> orderByComparator) {

		return _jobDataLocalService.dynamicQuery(
			dynamicQuery, start, end, orderByComparator);
	}

	/**
	 * Returns the number of rows matching the dynamic query.
	 *
	 * @param dynamicQuery the dynamic query
	 * @return the number of rows matching the dynamic query
	 */
	@Override
	public long dynamicQueryCount(
		com.liferay.portal.kernel.dao.orm.DynamicQuery dynamicQuery) {

		return _jobDataLocalService.dynamicQueryCount(dynamicQuery);
	}

	/**
	 * Returns the number of rows matching the dynamic query.
	 *
	 * @param dynamicQuery the dynamic query
	 * @param projection the projection to apply to the query
	 * @return the number of rows matching the dynamic query
	 */
	@Override
	public long dynamicQueryCount(
		com.liferay.portal.kernel.dao.orm.DynamicQuery dynamicQuery,
		com.liferay.portal.kernel.dao.orm.Projection projection) {

		return _jobDataLocalService.dynamicQueryCount(dynamicQuery, projection);
	}

	@Override
	public com.osp.icebreaker.model.JobData fetchJobData(long jobId) {
		return _jobDataLocalService.fetchJobData(jobId);
	}

	@Override
	public com.liferay.portal.kernel.dao.orm.ActionableDynamicQuery
		getActionableDynamicQuery() {

		return _jobDataLocalService.getActionableDynamicQuery();
	}

	@Override
	public com.liferay.portal.kernel.dao.orm.IndexableActionableDynamicQuery
		getIndexableActionableDynamicQuery() {

		return _jobDataLocalService.getIndexableActionableDynamicQuery();
	}

	/**
	 * Returns the job data with the primary key.
	 *
	 * @param jobId the primary key of the job data
	 * @return the job data
	 * @throws PortalException if a job data with the primary key could not be found
	 */
	@Override
	public com.osp.icebreaker.model.JobData getJobData(long jobId)
		throws com.liferay.portal.kernel.exception.PortalException {

		return _jobDataLocalService.getJobData(jobId);
	}

	/**
	 * Returns a range of all the job datas.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>com.osp.icebreaker.model.impl.JobDataModelImpl</code>.
	 * </p>
	 *
	 * @param start the lower bound of the range of job datas
	 * @param end the upper bound of the range of job datas (not inclusive)
	 * @return the range of job datas
	 */
	@Override
	public java.util.List<com.osp.icebreaker.model.JobData> getJobDatas(
		int start, int end) {

		return _jobDataLocalService.getJobDatas(start, end);
	}

	/**
	 * Returns the number of job datas.
	 *
	 * @return the number of job datas
	 */
	@Override
	public int getJobDatasCount() {
		return _jobDataLocalService.getJobDatasCount();
	}

	/**
	 * Returns the OSGi service identifier.
	 *
	 * @return the OSGi service identifier
	 */
	@Override
	public String getOSGiServiceIdentifier() {
		return _jobDataLocalService.getOSGiServiceIdentifier();
	}

	/**
	 * @throws PortalException
	 */
	@Override
	public com.liferay.portal.kernel.model.PersistedModel getPersistedModel(
			java.io.Serializable primaryKeyObj)
		throws com.liferay.portal.kernel.exception.PortalException {

		return _jobDataLocalService.getPersistedModel(primaryKeyObj);
	}

	/**
	 * Updates the job data in the database or adds it if it does not yet exist. Also notifies the appropriate model listeners.
	 *
	 * @param jobData the job data
	 * @return the job data that was updated
	 */
	@Override
	public com.osp.icebreaker.model.JobData updateJobData(
		com.osp.icebreaker.model.JobData jobData) {

		return _jobDataLocalService.updateJobData(jobData);
	}

	@Override
	public JobDataLocalService getWrappedService() {
		return _jobDataLocalService;
	}

	@Override
	public void setWrappedService(JobDataLocalService jobDataLocalService) {
		_jobDataLocalService = jobDataLocalService;
	}

	private JobDataLocalService _jobDataLocalService;

}