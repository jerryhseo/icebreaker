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

import org.osgi.framework.Bundle;
import org.osgi.framework.FrameworkUtil;
import org.osgi.util.tracker.ServiceTracker;

/**
 * Provides the local service utility for Job. This utility wraps
 * <code>com.osp.icebreaker.service.impl.JobLocalServiceImpl</code> and
 * is an access point for service operations in application layer code running
 * on the local server. Methods of this service will not have security checks
 * based on the propagated JAAS credentials because this service can only be
 * accessed from within the same VM.
 *
 * @author Jerry H. Seo
 * @see JobLocalService
 * @generated
 */
public class JobLocalServiceUtil {

	/*
	 * NOTE FOR DEVELOPERS:
	 *
	 * Never modify this class directly. Add custom service methods to <code>com.osp.icebreaker.service.impl.JobLocalServiceImpl</code> and rerun ServiceBuilder to regenerate this class.
	 */

	/**
	 * Adds the job to the database. Also notifies the appropriate model listeners.
	 *
	 * @param job the job
	 * @return the job that was added
	 */
	public static com.osp.icebreaker.model.Job addJob(
		com.osp.icebreaker.model.Job job) {

		return getService().addJob(job);
	}

	/**
	 * Creates a new job with the primary key. Does not add the job to the database.
	 *
	 * @param jobId the primary key for the new job
	 * @return the new job
	 */
	public static com.osp.icebreaker.model.Job createJob(long jobId) {
		return getService().createJob(jobId);
	}

	/**
	 * Deletes the job from the database. Also notifies the appropriate model listeners.
	 *
	 * @param job the job
	 * @return the job that was removed
	 */
	public static com.osp.icebreaker.model.Job deleteJob(
		com.osp.icebreaker.model.Job job) {

		return getService().deleteJob(job);
	}

	/**
	 * Deletes the job with the primary key from the database. Also notifies the appropriate model listeners.
	 *
	 * @param jobId the primary key of the job
	 * @return the job that was removed
	 * @throws PortalException if a job with the primary key could not be found
	 */
	public static com.osp.icebreaker.model.Job deleteJob(long jobId)
		throws com.liferay.portal.kernel.exception.PortalException {

		return getService().deleteJob(jobId);
	}

	/**
	 * @throws PortalException
	 */
	public static com.liferay.portal.kernel.model.PersistedModel
			deletePersistedModel(
				com.liferay.portal.kernel.model.PersistedModel persistedModel)
		throws com.liferay.portal.kernel.exception.PortalException {

		return getService().deletePersistedModel(persistedModel);
	}

	public static com.liferay.portal.kernel.dao.orm.DynamicQuery
		dynamicQuery() {

		return getService().dynamicQuery();
	}

	/**
	 * Performs a dynamic query on the database and returns the matching rows.
	 *
	 * @param dynamicQuery the dynamic query
	 * @return the matching rows
	 */
	public static <T> java.util.List<T> dynamicQuery(
		com.liferay.portal.kernel.dao.orm.DynamicQuery dynamicQuery) {

		return getService().dynamicQuery(dynamicQuery);
	}

	/**
	 * Performs a dynamic query on the database and returns a range of the matching rows.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>com.osp.icebreaker.model.impl.JobModelImpl</code>.
	 * </p>
	 *
	 * @param dynamicQuery the dynamic query
	 * @param start the lower bound of the range of model instances
	 * @param end the upper bound of the range of model instances (not inclusive)
	 * @return the range of matching rows
	 */
	public static <T> java.util.List<T> dynamicQuery(
		com.liferay.portal.kernel.dao.orm.DynamicQuery dynamicQuery, int start,
		int end) {

		return getService().dynamicQuery(dynamicQuery, start, end);
	}

	/**
	 * Performs a dynamic query on the database and returns an ordered range of the matching rows.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>com.osp.icebreaker.model.impl.JobModelImpl</code>.
	 * </p>
	 *
	 * @param dynamicQuery the dynamic query
	 * @param start the lower bound of the range of model instances
	 * @param end the upper bound of the range of model instances (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @return the ordered range of matching rows
	 */
	public static <T> java.util.List<T> dynamicQuery(
		com.liferay.portal.kernel.dao.orm.DynamicQuery dynamicQuery, int start,
		int end,
		com.liferay.portal.kernel.util.OrderByComparator<T> orderByComparator) {

		return getService().dynamicQuery(
			dynamicQuery, start, end, orderByComparator);
	}

	/**
	 * Returns the number of rows matching the dynamic query.
	 *
	 * @param dynamicQuery the dynamic query
	 * @return the number of rows matching the dynamic query
	 */
	public static long dynamicQueryCount(
		com.liferay.portal.kernel.dao.orm.DynamicQuery dynamicQuery) {

		return getService().dynamicQueryCount(dynamicQuery);
	}

	/**
	 * Returns the number of rows matching the dynamic query.
	 *
	 * @param dynamicQuery the dynamic query
	 * @param projection the projection to apply to the query
	 * @return the number of rows matching the dynamic query
	 */
	public static long dynamicQueryCount(
		com.liferay.portal.kernel.dao.orm.DynamicQuery dynamicQuery,
		com.liferay.portal.kernel.dao.orm.Projection projection) {

		return getService().dynamicQueryCount(dynamicQuery, projection);
	}

	public static com.osp.icebreaker.model.Job fetchJob(long jobId) {
		return getService().fetchJob(jobId);
	}

	/**
	 * Returns the job matching the UUID and group.
	 *
	 * @param uuid the job's UUID
	 * @param groupId the primary key of the group
	 * @return the matching job, or <code>null</code> if a matching job could not be found
	 */
	public static com.osp.icebreaker.model.Job fetchJobByUuidAndGroupId(
		String uuid, long groupId) {

		return getService().fetchJobByUuidAndGroupId(uuid, groupId);
	}

	public static com.liferay.portal.kernel.dao.orm.ActionableDynamicQuery
		getActionableDynamicQuery() {

		return getService().getActionableDynamicQuery();
	}

	public static com.liferay.portal.kernel.dao.orm.ExportActionableDynamicQuery
		getExportActionableDynamicQuery(
			com.liferay.exportimport.kernel.lar.PortletDataContext
				portletDataContext) {

		return getService().getExportActionableDynamicQuery(portletDataContext);
	}

	public static
		com.liferay.portal.kernel.dao.orm.IndexableActionableDynamicQuery
			getIndexableActionableDynamicQuery() {

		return getService().getIndexableActionableDynamicQuery();
	}

	/**
	 * Returns the job with the primary key.
	 *
	 * @param jobId the primary key of the job
	 * @return the job
	 * @throws PortalException if a job with the primary key could not be found
	 */
	public static com.osp.icebreaker.model.Job getJob(long jobId)
		throws com.liferay.portal.kernel.exception.PortalException {

		return getService().getJob(jobId);
	}

	/**
	 * Returns the job matching the UUID and group.
	 *
	 * @param uuid the job's UUID
	 * @param groupId the primary key of the group
	 * @return the matching job
	 * @throws PortalException if a matching job could not be found
	 */
	public static com.osp.icebreaker.model.Job getJobByUuidAndGroupId(
			String uuid, long groupId)
		throws com.liferay.portal.kernel.exception.PortalException {

		return getService().getJobByUuidAndGroupId(uuid, groupId);
	}

	/**
	 * Returns a range of all the jobs.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>com.osp.icebreaker.model.impl.JobModelImpl</code>.
	 * </p>
	 *
	 * @param start the lower bound of the range of jobs
	 * @param end the upper bound of the range of jobs (not inclusive)
	 * @return the range of jobs
	 */
	public static java.util.List<com.osp.icebreaker.model.Job> getJobs(
		int start, int end) {

		return getService().getJobs(start, end);
	}

	/**
	 * Returns all the jobs matching the UUID and company.
	 *
	 * @param uuid the UUID of the jobs
	 * @param companyId the primary key of the company
	 * @return the matching jobs, or an empty list if no matches were found
	 */
	public static java.util.List<com.osp.icebreaker.model.Job>
		getJobsByUuidAndCompanyId(String uuid, long companyId) {

		return getService().getJobsByUuidAndCompanyId(uuid, companyId);
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
	public static java.util.List<com.osp.icebreaker.model.Job>
		getJobsByUuidAndCompanyId(
			String uuid, long companyId, int start, int end,
			com.liferay.portal.kernel.util.OrderByComparator
				<com.osp.icebreaker.model.Job> orderByComparator) {

		return getService().getJobsByUuidAndCompanyId(
			uuid, companyId, start, end, orderByComparator);
	}

	/**
	 * Returns the number of jobs.
	 *
	 * @return the number of jobs
	 */
	public static int getJobsCount() {
		return getService().getJobsCount();
	}

	/**
	 * Returns the OSGi service identifier.
	 *
	 * @return the OSGi service identifier
	 */
	public static String getOSGiServiceIdentifier() {
		return getService().getOSGiServiceIdentifier();
	}

	/**
	 * @throws PortalException
	 */
	public static com.liferay.portal.kernel.model.PersistedModel
			getPersistedModel(java.io.Serializable primaryKeyObj)
		throws com.liferay.portal.kernel.exception.PortalException {

		return getService().getPersistedModel(primaryKeyObj);
	}

	/**
	 * Updates the job in the database or adds it if it does not yet exist. Also notifies the appropriate model listeners.
	 *
	 * @param job the job
	 * @return the job that was updated
	 */
	public static com.osp.icebreaker.model.Job updateJob(
		com.osp.icebreaker.model.Job job) {

		return getService().updateJob(job);
	}

	public static JobLocalService getService() {
		return _serviceTracker.getService();
	}

	private static ServiceTracker<JobLocalService, JobLocalService>
		_serviceTracker;

	static {
		Bundle bundle = FrameworkUtil.getBundle(JobLocalService.class);

		ServiceTracker<JobLocalService, JobLocalService> serviceTracker =
			new ServiceTracker<JobLocalService, JobLocalService>(
				bundle.getBundleContext(), JobLocalService.class, null);

		serviceTracker.open();

		_serviceTracker = serviceTracker;
	}

}