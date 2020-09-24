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
 * Provides the local service utility for JobData. This utility wraps
 * <code>com.osp.icebreaker.service.impl.JobDataLocalServiceImpl</code> and
 * is an access point for service operations in application layer code running
 * on the local server. Methods of this service will not have security checks
 * based on the propagated JAAS credentials because this service can only be
 * accessed from within the same VM.
 *
 * @author Jerry H. Seo
 * @see JobDataLocalService
 * @generated
 */
public class JobDataLocalServiceUtil {

	/*
	 * NOTE FOR DEVELOPERS:
	 *
	 * Never modify this class directly. Add custom service methods to <code>com.osp.icebreaker.service.impl.JobDataLocalServiceImpl</code> and rerun ServiceBuilder to regenerate this class.
	 */

	/**
	 * Adds the job data to the database. Also notifies the appropriate model listeners.
	 *
	 * @param jobData the job data
	 * @return the job data that was added
	 */
	public static com.osp.icebreaker.model.JobData addJobData(
		com.osp.icebreaker.model.JobData jobData) {

		return getService().addJobData(jobData);
	}

	/**
	 * Creates a new job data with the primary key. Does not add the job data to the database.
	 *
	 * @param jobId the primary key for the new job data
	 * @return the new job data
	 */
	public static com.osp.icebreaker.model.JobData createJobData(long jobId) {
		return getService().createJobData(jobId);
	}

	/**
	 * Deletes the job data from the database. Also notifies the appropriate model listeners.
	 *
	 * @param jobData the job data
	 * @return the job data that was removed
	 */
	public static com.osp.icebreaker.model.JobData deleteJobData(
		com.osp.icebreaker.model.JobData jobData) {

		return getService().deleteJobData(jobData);
	}

	/**
	 * Deletes the job data with the primary key from the database. Also notifies the appropriate model listeners.
	 *
	 * @param jobId the primary key of the job data
	 * @return the job data that was removed
	 * @throws PortalException if a job data with the primary key could not be found
	 */
	public static com.osp.icebreaker.model.JobData deleteJobData(long jobId)
		throws com.liferay.portal.kernel.exception.PortalException {

		return getService().deleteJobData(jobId);
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
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>com.osp.icebreaker.model.impl.JobDataModelImpl</code>.
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
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>com.osp.icebreaker.model.impl.JobDataModelImpl</code>.
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

	public static com.osp.icebreaker.model.JobData fetchJobData(long jobId) {
		return getService().fetchJobData(jobId);
	}

	public static com.liferay.portal.kernel.dao.orm.ActionableDynamicQuery
		getActionableDynamicQuery() {

		return getService().getActionableDynamicQuery();
	}

	public static
		com.liferay.portal.kernel.dao.orm.IndexableActionableDynamicQuery
			getIndexableActionableDynamicQuery() {

		return getService().getIndexableActionableDynamicQuery();
	}

	/**
	 * Returns the job data with the primary key.
	 *
	 * @param jobId the primary key of the job data
	 * @return the job data
	 * @throws PortalException if a job data with the primary key could not be found
	 */
	public static com.osp.icebreaker.model.JobData getJobData(long jobId)
		throws com.liferay.portal.kernel.exception.PortalException {

		return getService().getJobData(jobId);
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
	public static java.util.List<com.osp.icebreaker.model.JobData> getJobDatas(
		int start, int end) {

		return getService().getJobDatas(start, end);
	}

	/**
	 * Returns the number of job datas.
	 *
	 * @return the number of job datas
	 */
	public static int getJobDatasCount() {
		return getService().getJobDatasCount();
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
	 * Updates the job data in the database or adds it if it does not yet exist. Also notifies the appropriate model listeners.
	 *
	 * @param jobData the job data
	 * @return the job data that was updated
	 */
	public static com.osp.icebreaker.model.JobData updateJobData(
		com.osp.icebreaker.model.JobData jobData) {

		return getService().updateJobData(jobData);
	}

	public static JobDataLocalService getService() {
		return _serviceTracker.getService();
	}

	private static ServiceTracker<JobDataLocalService, JobDataLocalService>
		_serviceTracker;

	static {
		Bundle bundle = FrameworkUtil.getBundle(JobDataLocalService.class);

		ServiceTracker<JobDataLocalService, JobDataLocalService>
			serviceTracker =
				new ServiceTracker<JobDataLocalService, JobDataLocalService>(
					bundle.getBundleContext(), JobDataLocalService.class, null);

		serviceTracker.open();

		_serviceTracker = serviceTracker;
	}

}