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

import org.osgi.annotation.versioning.ProviderType;

/**
 * Provides a wrapper for {@link JobLocalService}.
 *
 * @author Jerry H. Seo
 * @see JobLocalService
 * @generated
 */
@ProviderType
public class JobLocalServiceWrapper
	implements JobLocalService, ServiceWrapper<JobLocalService> {

	public JobLocalServiceWrapper(JobLocalService jobLocalService) {
		_jobLocalService = jobLocalService;
	}

	/**
	 * Adds the job to the database. Also notifies the appropriate model listeners.
	 *
	 * @param job the job
	 * @return the job that was added
	 */
	@Override
	public com.osp.icebreaker.model.Job addJob(
		com.osp.icebreaker.model.Job job) {

		return _jobLocalService.addJob(job);
	}

	/**
	 * Creates a new job with the primary key. Does not add the job to the database.
	 *
	 * @param jobId the primary key for the new job
	 * @return the new job
	 */
	@Override
	public com.osp.icebreaker.model.Job createJob(long jobId) {
		return _jobLocalService.createJob(jobId);
	}

	/**
	 * Deletes the job from the database. Also notifies the appropriate model listeners.
	 *
	 * @param job the job
	 * @return the job that was removed
	 */
	@Override
	public com.osp.icebreaker.model.Job deleteJob(
		com.osp.icebreaker.model.Job job) {

		return _jobLocalService.deleteJob(job);
	}

	/**
	 * Deletes the job with the primary key from the database. Also notifies the appropriate model listeners.
	 *
	 * @param jobId the primary key of the job
	 * @return the job that was removed
	 * @throws PortalException if a job with the primary key could not be found
	 */
	@Override
	public com.osp.icebreaker.model.Job deleteJob(long jobId)
		throws com.liferay.portal.kernel.exception.PortalException {

		return _jobLocalService.deleteJob(jobId);
	}

	/**
	 * @throws PortalException
	 */
	@Override
	public com.liferay.portal.kernel.model.PersistedModel deletePersistedModel(
			com.liferay.portal.kernel.model.PersistedModel persistedModel)
		throws com.liferay.portal.kernel.exception.PortalException {

		return _jobLocalService.deletePersistedModel(persistedModel);
	}

	@Override
	public com.liferay.portal.kernel.dao.orm.DynamicQuery dynamicQuery() {
		return _jobLocalService.dynamicQuery();
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

		return _jobLocalService.dynamicQuery(dynamicQuery);
	}

	/**
	 * Performs a dynamic query on the database and returns a range of the matching rows.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not <code>com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS</code>), then the query will include the default ORDER BY logic from <code>com.osp.icebreaker.model.impl.JobModelImpl</code>. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
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

		return _jobLocalService.dynamicQuery(dynamicQuery, start, end);
	}

	/**
	 * Performs a dynamic query on the database and returns an ordered range of the matching rows.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not <code>com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS</code>), then the query will include the default ORDER BY logic from <code>com.osp.icebreaker.model.impl.JobModelImpl</code>. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
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

		return _jobLocalService.dynamicQuery(
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

		return _jobLocalService.dynamicQueryCount(dynamicQuery);
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

		return _jobLocalService.dynamicQueryCount(dynamicQuery, projection);
	}

	@Override
	public com.osp.icebreaker.model.Job fetchJob(long jobId) {
		return _jobLocalService.fetchJob(jobId);
	}

	/**
	 * Returns the job matching the UUID and group.
	 *
	 * @param uuid the job's UUID
	 * @param groupId the primary key of the group
	 * @return the matching job, or <code>null</code> if a matching job could not be found
	 */
	@Override
	public com.osp.icebreaker.model.Job fetchJobByUuidAndGroupId(
		String uuid, long groupId) {

		return _jobLocalService.fetchJobByUuidAndGroupId(uuid, groupId);
	}

	@Override
	public com.liferay.portal.kernel.dao.orm.ActionableDynamicQuery
		getActionableDynamicQuery() {

		return _jobLocalService.getActionableDynamicQuery();
	}

	@Override
	public com.liferay.portal.kernel.dao.orm.ExportActionableDynamicQuery
		getExportActionableDynamicQuery(
			com.liferay.exportimport.kernel.lar.PortletDataContext
				portletDataContext) {

		return _jobLocalService.getExportActionableDynamicQuery(
			portletDataContext);
	}

	@Override
	public com.liferay.portal.kernel.dao.orm.IndexableActionableDynamicQuery
		getIndexableActionableDynamicQuery() {

		return _jobLocalService.getIndexableActionableDynamicQuery();
	}

	/**
	 * Returns the job with the primary key.
	 *
	 * @param jobId the primary key of the job
	 * @return the job
	 * @throws PortalException if a job with the primary key could not be found
	 */
	@Override
	public com.osp.icebreaker.model.Job getJob(long jobId)
		throws com.liferay.portal.kernel.exception.PortalException {

		return _jobLocalService.getJob(jobId);
	}

	/**
	 * Returns the job matching the UUID and group.
	 *
	 * @param uuid the job's UUID
	 * @param groupId the primary key of the group
	 * @return the matching job
	 * @throws PortalException if a matching job could not be found
	 */
	@Override
	public com.osp.icebreaker.model.Job getJobByUuidAndGroupId(
			String uuid, long groupId)
		throws com.liferay.portal.kernel.exception.PortalException {

		return _jobLocalService.getJobByUuidAndGroupId(uuid, groupId);
	}

	/**
	 * Returns a range of all the jobs.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not <code>com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS</code>), then the query will include the default ORDER BY logic from <code>com.osp.icebreaker.model.impl.JobModelImpl</code>. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	 * </p>
	 *
	 * @param start the lower bound of the range of jobs
	 * @param end the upper bound of the range of jobs (not inclusive)
	 * @return the range of jobs
	 */
	@Override
	public java.util.List<com.osp.icebreaker.model.Job> getJobs(
		int start, int end) {

		return _jobLocalService.getJobs(start, end);
	}

	/**
	 * Returns all the jobs matching the UUID and company.
	 *
	 * @param uuid the UUID of the jobs
	 * @param companyId the primary key of the company
	 * @return the matching jobs, or an empty list if no matches were found
	 */
	@Override
	public java.util.List<com.osp.icebreaker.model.Job>
		getJobsByUuidAndCompanyId(String uuid, long companyId) {

		return _jobLocalService.getJobsByUuidAndCompanyId(uuid, companyId);
	}

	/**
	 * Returns a range of jobs matching the UUID and company.
	 *
	 * @param uuid the UUID of the jobs
	 * @param companyId the primary key of the company
	 * @param start the lower bound of the range of jobs
	 * @param end the upper bound of the range of jobs (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @return the range of matching jobs, or an empty list if no matches were found
	 */
	@Override
	public java.util.List<com.osp.icebreaker.model.Job>
		getJobsByUuidAndCompanyId(
			String uuid, long companyId, int start, int end,
			com.liferay.portal.kernel.util.OrderByComparator
				<com.osp.icebreaker.model.Job> orderByComparator) {

		return _jobLocalService.getJobsByUuidAndCompanyId(
			uuid, companyId, start, end, orderByComparator);
	}

	/**
	 * Returns the number of jobs.
	 *
	 * @return the number of jobs
	 */
	@Override
	public int getJobsCount() {
		return _jobLocalService.getJobsCount();
	}

	/**
	 * Returns the OSGi service identifier.
	 *
	 * @return the OSGi service identifier
	 */
	@Override
	public String getOSGiServiceIdentifier() {
		return _jobLocalService.getOSGiServiceIdentifier();
	}

	@Override
	public com.liferay.portal.kernel.model.PersistedModel getPersistedModel(
			java.io.Serializable primaryKeyObj)
		throws com.liferay.portal.kernel.exception.PortalException {

		return _jobLocalService.getPersistedModel(primaryKeyObj);
	}

	/**
	 * Updates the job in the database or adds it if it does not yet exist. Also notifies the appropriate model listeners.
	 *
	 * @param job the job
	 * @return the job that was updated
	 */
	@Override
	public com.osp.icebreaker.model.Job updateJob(
		com.osp.icebreaker.model.Job job) {

		return _jobLocalService.updateJob(job);
	}

	@Override
	public JobLocalService getWrappedService() {
		return _jobLocalService;
	}

	@Override
	public void setWrappedService(JobLocalService jobLocalService) {
		_jobLocalService = jobLocalService;
	}

	private JobLocalService _jobLocalService;

}