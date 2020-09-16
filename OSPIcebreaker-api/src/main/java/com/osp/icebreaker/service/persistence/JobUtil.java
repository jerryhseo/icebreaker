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

import com.liferay.portal.kernel.dao.orm.DynamicQuery;
import com.liferay.portal.kernel.service.ServiceContext;
import com.liferay.portal.kernel.util.OrderByComparator;

import com.osp.icebreaker.model.Job;

import java.io.Serializable;

import java.util.List;
import java.util.Map;
import java.util.Set;

import org.osgi.annotation.versioning.ProviderType;
import org.osgi.framework.Bundle;
import org.osgi.framework.FrameworkUtil;
import org.osgi.util.tracker.ServiceTracker;

/**
 * The persistence utility for the job service. This utility wraps <code>com.osp.icebreaker.service.persistence.impl.JobPersistenceImpl</code> and provides direct access to the database for CRUD operations. This utility should only be used by the service layer, as it must operate within a transaction. Never access this utility in a JSP, controller, model, or other front-end class.
 *
 * <p>
 * Caching information and settings can be found in <code>portal.properties</code>
 * </p>
 *
 * @author Jerry H. Seo
 * @see JobPersistence
 * @generated
 */
@ProviderType
public class JobUtil {

	/*
	 * NOTE FOR DEVELOPERS:
	 *
	 * Never modify this class directly. Modify <code>service.xml</code> and rerun ServiceBuilder to regenerate this class.
	 */

	/**
	 * @see com.liferay.portal.kernel.service.persistence.BasePersistence#clearCache()
	 */
	public static void clearCache() {
		getPersistence().clearCache();
	}

	/**
	 * @see com.liferay.portal.kernel.service.persistence.BasePersistence#clearCache(com.liferay.portal.kernel.model.BaseModel)
	 */
	public static void clearCache(Job job) {
		getPersistence().clearCache(job);
	}

	/**
	 * @see com.liferay.portal.kernel.service.persistence.BasePersistence#countWithDynamicQuery(DynamicQuery)
	 */
	public static long countWithDynamicQuery(DynamicQuery dynamicQuery) {
		return getPersistence().countWithDynamicQuery(dynamicQuery);
	}

	/**
	 * @see com.liferay.portal.kernel.service.persistence.BasePersistence#fetchByPrimaryKeys(Set)
	 */
	public static Map<Serializable, Job> fetchByPrimaryKeys(
		Set<Serializable> primaryKeys) {

		return getPersistence().fetchByPrimaryKeys(primaryKeys);
	}

	/**
	 * @see com.liferay.portal.kernel.service.persistence.BasePersistence#findWithDynamicQuery(DynamicQuery)
	 */
	public static List<Job> findWithDynamicQuery(DynamicQuery dynamicQuery) {
		return getPersistence().findWithDynamicQuery(dynamicQuery);
	}

	/**
	 * @see com.liferay.portal.kernel.service.persistence.BasePersistence#findWithDynamicQuery(DynamicQuery, int, int)
	 */
	public static List<Job> findWithDynamicQuery(
		DynamicQuery dynamicQuery, int start, int end) {

		return getPersistence().findWithDynamicQuery(dynamicQuery, start, end);
	}

	/**
	 * @see com.liferay.portal.kernel.service.persistence.BasePersistence#findWithDynamicQuery(DynamicQuery, int, int, OrderByComparator)
	 */
	public static List<Job> findWithDynamicQuery(
		DynamicQuery dynamicQuery, int start, int end,
		OrderByComparator<Job> orderByComparator) {

		return getPersistence().findWithDynamicQuery(
			dynamicQuery, start, end, orderByComparator);
	}

	/**
	 * @see com.liferay.portal.kernel.service.persistence.BasePersistence#update(com.liferay.portal.kernel.model.BaseModel)
	 */
	public static Job update(Job job) {
		return getPersistence().update(job);
	}

	/**
	 * @see com.liferay.portal.kernel.service.persistence.BasePersistence#update(com.liferay.portal.kernel.model.BaseModel, ServiceContext)
	 */
	public static Job update(Job job, ServiceContext serviceContext) {
		return getPersistence().update(job, serviceContext);
	}

	/**
	 * Returns all the jobs where uuid = &#63;.
	 *
	 * @param uuid the uuid
	 * @return the matching jobs
	 */
	public static List<Job> findByUuid(String uuid) {
		return getPersistence().findByUuid(uuid);
	}

	/**
	 * Returns a range of all the jobs where uuid = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not <code>QueryUtil#ALL_POS</code>), then the query will include the default ORDER BY logic from <code>JobModelImpl</code>. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	 * </p>
	 *
	 * @param uuid the uuid
	 * @param start the lower bound of the range of jobs
	 * @param end the upper bound of the range of jobs (not inclusive)
	 * @return the range of matching jobs
	 */
	public static List<Job> findByUuid(String uuid, int start, int end) {
		return getPersistence().findByUuid(uuid, start, end);
	}

	/**
	 * Returns an ordered range of all the jobs where uuid = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not <code>QueryUtil#ALL_POS</code>), then the query will include the default ORDER BY logic from <code>JobModelImpl</code>. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	 * </p>
	 *
	 * @param uuid the uuid
	 * @param start the lower bound of the range of jobs
	 * @param end the upper bound of the range of jobs (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @return the ordered range of matching jobs
	 */
	public static List<Job> findByUuid(
		String uuid, int start, int end,
		OrderByComparator<Job> orderByComparator) {

		return getPersistence().findByUuid(uuid, start, end, orderByComparator);
	}

	/**
	 * Returns an ordered range of all the jobs where uuid = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not <code>QueryUtil#ALL_POS</code>), then the query will include the default ORDER BY logic from <code>JobModelImpl</code>. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	 * </p>
	 *
	 * @param uuid the uuid
	 * @param start the lower bound of the range of jobs
	 * @param end the upper bound of the range of jobs (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @param retrieveFromCache whether to retrieve from the finder cache
	 * @return the ordered range of matching jobs
	 */
	public static List<Job> findByUuid(
		String uuid, int start, int end,
		OrderByComparator<Job> orderByComparator, boolean retrieveFromCache) {

		return getPersistence().findByUuid(
			uuid, start, end, orderByComparator, retrieveFromCache);
	}

	/**
	 * Returns the first job in the ordered set where uuid = &#63;.
	 *
	 * @param uuid the uuid
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching job
	 * @throws NoSuchJobException if a matching job could not be found
	 */
	public static Job findByUuid_First(
			String uuid, OrderByComparator<Job> orderByComparator)
		throws com.osp.icebreaker.exception.NoSuchJobException {

		return getPersistence().findByUuid_First(uuid, orderByComparator);
	}

	/**
	 * Returns the first job in the ordered set where uuid = &#63;.
	 *
	 * @param uuid the uuid
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching job, or <code>null</code> if a matching job could not be found
	 */
	public static Job fetchByUuid_First(
		String uuid, OrderByComparator<Job> orderByComparator) {

		return getPersistence().fetchByUuid_First(uuid, orderByComparator);
	}

	/**
	 * Returns the last job in the ordered set where uuid = &#63;.
	 *
	 * @param uuid the uuid
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching job
	 * @throws NoSuchJobException if a matching job could not be found
	 */
	public static Job findByUuid_Last(
			String uuid, OrderByComparator<Job> orderByComparator)
		throws com.osp.icebreaker.exception.NoSuchJobException {

		return getPersistence().findByUuid_Last(uuid, orderByComparator);
	}

	/**
	 * Returns the last job in the ordered set where uuid = &#63;.
	 *
	 * @param uuid the uuid
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching job, or <code>null</code> if a matching job could not be found
	 */
	public static Job fetchByUuid_Last(
		String uuid, OrderByComparator<Job> orderByComparator) {

		return getPersistence().fetchByUuid_Last(uuid, orderByComparator);
	}

	/**
	 * Returns the jobs before and after the current job in the ordered set where uuid = &#63;.
	 *
	 * @param jobId the primary key of the current job
	 * @param uuid the uuid
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the previous, current, and next job
	 * @throws NoSuchJobException if a job with the primary key could not be found
	 */
	public static Job[] findByUuid_PrevAndNext(
			long jobId, String uuid, OrderByComparator<Job> orderByComparator)
		throws com.osp.icebreaker.exception.NoSuchJobException {

		return getPersistence().findByUuid_PrevAndNext(
			jobId, uuid, orderByComparator);
	}

	/**
	 * Removes all the jobs where uuid = &#63; from the database.
	 *
	 * @param uuid the uuid
	 */
	public static void removeByUuid(String uuid) {
		getPersistence().removeByUuid(uuid);
	}

	/**
	 * Returns the number of jobs where uuid = &#63;.
	 *
	 * @param uuid the uuid
	 * @return the number of matching jobs
	 */
	public static int countByUuid(String uuid) {
		return getPersistence().countByUuid(uuid);
	}

	/**
	 * Returns the job where uuid = &#63; and groupId = &#63; or throws a <code>NoSuchJobException</code> if it could not be found.
	 *
	 * @param uuid the uuid
	 * @param groupId the group ID
	 * @return the matching job
	 * @throws NoSuchJobException if a matching job could not be found
	 */
	public static Job findByUUID_G(String uuid, long groupId)
		throws com.osp.icebreaker.exception.NoSuchJobException {

		return getPersistence().findByUUID_G(uuid, groupId);
	}

	/**
	 * Returns the job where uuid = &#63; and groupId = &#63; or returns <code>null</code> if it could not be found. Uses the finder cache.
	 *
	 * @param uuid the uuid
	 * @param groupId the group ID
	 * @return the matching job, or <code>null</code> if a matching job could not be found
	 */
	public static Job fetchByUUID_G(String uuid, long groupId) {
		return getPersistence().fetchByUUID_G(uuid, groupId);
	}

	/**
	 * Returns the job where uuid = &#63; and groupId = &#63; or returns <code>null</code> if it could not be found, optionally using the finder cache.
	 *
	 * @param uuid the uuid
	 * @param groupId the group ID
	 * @param retrieveFromCache whether to retrieve from the finder cache
	 * @return the matching job, or <code>null</code> if a matching job could not be found
	 */
	public static Job fetchByUUID_G(
		String uuid, long groupId, boolean retrieveFromCache) {

		return getPersistence().fetchByUUID_G(uuid, groupId, retrieveFromCache);
	}

	/**
	 * Removes the job where uuid = &#63; and groupId = &#63; from the database.
	 *
	 * @param uuid the uuid
	 * @param groupId the group ID
	 * @return the job that was removed
	 */
	public static Job removeByUUID_G(String uuid, long groupId)
		throws com.osp.icebreaker.exception.NoSuchJobException {

		return getPersistence().removeByUUID_G(uuid, groupId);
	}

	/**
	 * Returns the number of jobs where uuid = &#63; and groupId = &#63;.
	 *
	 * @param uuid the uuid
	 * @param groupId the group ID
	 * @return the number of matching jobs
	 */
	public static int countByUUID_G(String uuid, long groupId) {
		return getPersistence().countByUUID_G(uuid, groupId);
	}

	/**
	 * Returns all the jobs where uuid = &#63; and companyId = &#63;.
	 *
	 * @param uuid the uuid
	 * @param companyId the company ID
	 * @return the matching jobs
	 */
	public static List<Job> findByUuid_C(String uuid, long companyId) {
		return getPersistence().findByUuid_C(uuid, companyId);
	}

	/**
	 * Returns a range of all the jobs where uuid = &#63; and companyId = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not <code>QueryUtil#ALL_POS</code>), then the query will include the default ORDER BY logic from <code>JobModelImpl</code>. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	 * </p>
	 *
	 * @param uuid the uuid
	 * @param companyId the company ID
	 * @param start the lower bound of the range of jobs
	 * @param end the upper bound of the range of jobs (not inclusive)
	 * @return the range of matching jobs
	 */
	public static List<Job> findByUuid_C(
		String uuid, long companyId, int start, int end) {

		return getPersistence().findByUuid_C(uuid, companyId, start, end);
	}

	/**
	 * Returns an ordered range of all the jobs where uuid = &#63; and companyId = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not <code>QueryUtil#ALL_POS</code>), then the query will include the default ORDER BY logic from <code>JobModelImpl</code>. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	 * </p>
	 *
	 * @param uuid the uuid
	 * @param companyId the company ID
	 * @param start the lower bound of the range of jobs
	 * @param end the upper bound of the range of jobs (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @return the ordered range of matching jobs
	 */
	public static List<Job> findByUuid_C(
		String uuid, long companyId, int start, int end,
		OrderByComparator<Job> orderByComparator) {

		return getPersistence().findByUuid_C(
			uuid, companyId, start, end, orderByComparator);
	}

	/**
	 * Returns an ordered range of all the jobs where uuid = &#63; and companyId = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not <code>QueryUtil#ALL_POS</code>), then the query will include the default ORDER BY logic from <code>JobModelImpl</code>. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	 * </p>
	 *
	 * @param uuid the uuid
	 * @param companyId the company ID
	 * @param start the lower bound of the range of jobs
	 * @param end the upper bound of the range of jobs (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @param retrieveFromCache whether to retrieve from the finder cache
	 * @return the ordered range of matching jobs
	 */
	public static List<Job> findByUuid_C(
		String uuid, long companyId, int start, int end,
		OrderByComparator<Job> orderByComparator, boolean retrieveFromCache) {

		return getPersistence().findByUuid_C(
			uuid, companyId, start, end, orderByComparator, retrieveFromCache);
	}

	/**
	 * Returns the first job in the ordered set where uuid = &#63; and companyId = &#63;.
	 *
	 * @param uuid the uuid
	 * @param companyId the company ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching job
	 * @throws NoSuchJobException if a matching job could not be found
	 */
	public static Job findByUuid_C_First(
			String uuid, long companyId,
			OrderByComparator<Job> orderByComparator)
		throws com.osp.icebreaker.exception.NoSuchJobException {

		return getPersistence().findByUuid_C_First(
			uuid, companyId, orderByComparator);
	}

	/**
	 * Returns the first job in the ordered set where uuid = &#63; and companyId = &#63;.
	 *
	 * @param uuid the uuid
	 * @param companyId the company ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching job, or <code>null</code> if a matching job could not be found
	 */
	public static Job fetchByUuid_C_First(
		String uuid, long companyId, OrderByComparator<Job> orderByComparator) {

		return getPersistence().fetchByUuid_C_First(
			uuid, companyId, orderByComparator);
	}

	/**
	 * Returns the last job in the ordered set where uuid = &#63; and companyId = &#63;.
	 *
	 * @param uuid the uuid
	 * @param companyId the company ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching job
	 * @throws NoSuchJobException if a matching job could not be found
	 */
	public static Job findByUuid_C_Last(
			String uuid, long companyId,
			OrderByComparator<Job> orderByComparator)
		throws com.osp.icebreaker.exception.NoSuchJobException {

		return getPersistence().findByUuid_C_Last(
			uuid, companyId, orderByComparator);
	}

	/**
	 * Returns the last job in the ordered set where uuid = &#63; and companyId = &#63;.
	 *
	 * @param uuid the uuid
	 * @param companyId the company ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching job, or <code>null</code> if a matching job could not be found
	 */
	public static Job fetchByUuid_C_Last(
		String uuid, long companyId, OrderByComparator<Job> orderByComparator) {

		return getPersistence().fetchByUuid_C_Last(
			uuid, companyId, orderByComparator);
	}

	/**
	 * Returns the jobs before and after the current job in the ordered set where uuid = &#63; and companyId = &#63;.
	 *
	 * @param jobId the primary key of the current job
	 * @param uuid the uuid
	 * @param companyId the company ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the previous, current, and next job
	 * @throws NoSuchJobException if a job with the primary key could not be found
	 */
	public static Job[] findByUuid_C_PrevAndNext(
			long jobId, String uuid, long companyId,
			OrderByComparator<Job> orderByComparator)
		throws com.osp.icebreaker.exception.NoSuchJobException {

		return getPersistence().findByUuid_C_PrevAndNext(
			jobId, uuid, companyId, orderByComparator);
	}

	/**
	 * Removes all the jobs where uuid = &#63; and companyId = &#63; from the database.
	 *
	 * @param uuid the uuid
	 * @param companyId the company ID
	 */
	public static void removeByUuid_C(String uuid, long companyId) {
		getPersistence().removeByUuid_C(uuid, companyId);
	}

	/**
	 * Returns the number of jobs where uuid = &#63; and companyId = &#63;.
	 *
	 * @param uuid the uuid
	 * @param companyId the company ID
	 * @return the number of matching jobs
	 */
	public static int countByUuid_C(String uuid, long companyId) {
		return getPersistence().countByUuid_C(uuid, companyId);
	}

	/**
	 * Returns all the jobs where groupId = &#63;.
	 *
	 * @param groupId the group ID
	 * @return the matching jobs
	 */
	public static List<Job> findByGroupId(long groupId) {
		return getPersistence().findByGroupId(groupId);
	}

	/**
	 * Returns a range of all the jobs where groupId = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not <code>QueryUtil#ALL_POS</code>), then the query will include the default ORDER BY logic from <code>JobModelImpl</code>. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	 * </p>
	 *
	 * @param groupId the group ID
	 * @param start the lower bound of the range of jobs
	 * @param end the upper bound of the range of jobs (not inclusive)
	 * @return the range of matching jobs
	 */
	public static List<Job> findByGroupId(long groupId, int start, int end) {
		return getPersistence().findByGroupId(groupId, start, end);
	}

	/**
	 * Returns an ordered range of all the jobs where groupId = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not <code>QueryUtil#ALL_POS</code>), then the query will include the default ORDER BY logic from <code>JobModelImpl</code>. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	 * </p>
	 *
	 * @param groupId the group ID
	 * @param start the lower bound of the range of jobs
	 * @param end the upper bound of the range of jobs (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @return the ordered range of matching jobs
	 */
	public static List<Job> findByGroupId(
		long groupId, int start, int end,
		OrderByComparator<Job> orderByComparator) {

		return getPersistence().findByGroupId(
			groupId, start, end, orderByComparator);
	}

	/**
	 * Returns an ordered range of all the jobs where groupId = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not <code>QueryUtil#ALL_POS</code>), then the query will include the default ORDER BY logic from <code>JobModelImpl</code>. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	 * </p>
	 *
	 * @param groupId the group ID
	 * @param start the lower bound of the range of jobs
	 * @param end the upper bound of the range of jobs (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @param retrieveFromCache whether to retrieve from the finder cache
	 * @return the ordered range of matching jobs
	 */
	public static List<Job> findByGroupId(
		long groupId, int start, int end,
		OrderByComparator<Job> orderByComparator, boolean retrieveFromCache) {

		return getPersistence().findByGroupId(
			groupId, start, end, orderByComparator, retrieveFromCache);
	}

	/**
	 * Returns the first job in the ordered set where groupId = &#63;.
	 *
	 * @param groupId the group ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching job
	 * @throws NoSuchJobException if a matching job could not be found
	 */
	public static Job findByGroupId_First(
			long groupId, OrderByComparator<Job> orderByComparator)
		throws com.osp.icebreaker.exception.NoSuchJobException {

		return getPersistence().findByGroupId_First(groupId, orderByComparator);
	}

	/**
	 * Returns the first job in the ordered set where groupId = &#63;.
	 *
	 * @param groupId the group ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching job, or <code>null</code> if a matching job could not be found
	 */
	public static Job fetchByGroupId_First(
		long groupId, OrderByComparator<Job> orderByComparator) {

		return getPersistence().fetchByGroupId_First(
			groupId, orderByComparator);
	}

	/**
	 * Returns the last job in the ordered set where groupId = &#63;.
	 *
	 * @param groupId the group ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching job
	 * @throws NoSuchJobException if a matching job could not be found
	 */
	public static Job findByGroupId_Last(
			long groupId, OrderByComparator<Job> orderByComparator)
		throws com.osp.icebreaker.exception.NoSuchJobException {

		return getPersistence().findByGroupId_Last(groupId, orderByComparator);
	}

	/**
	 * Returns the last job in the ordered set where groupId = &#63;.
	 *
	 * @param groupId the group ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching job, or <code>null</code> if a matching job could not be found
	 */
	public static Job fetchByGroupId_Last(
		long groupId, OrderByComparator<Job> orderByComparator) {

		return getPersistence().fetchByGroupId_Last(groupId, orderByComparator);
	}

	/**
	 * Returns the jobs before and after the current job in the ordered set where groupId = &#63;.
	 *
	 * @param jobId the primary key of the current job
	 * @param groupId the group ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the previous, current, and next job
	 * @throws NoSuchJobException if a job with the primary key could not be found
	 */
	public static Job[] findByGroupId_PrevAndNext(
			long jobId, long groupId, OrderByComparator<Job> orderByComparator)
		throws com.osp.icebreaker.exception.NoSuchJobException {

		return getPersistence().findByGroupId_PrevAndNext(
			jobId, groupId, orderByComparator);
	}

	/**
	 * Removes all the jobs where groupId = &#63; from the database.
	 *
	 * @param groupId the group ID
	 */
	public static void removeByGroupId(long groupId) {
		getPersistence().removeByGroupId(groupId);
	}

	/**
	 * Returns the number of jobs where groupId = &#63;.
	 *
	 * @param groupId the group ID
	 * @return the number of matching jobs
	 */
	public static int countByGroupId(long groupId) {
		return getPersistence().countByGroupId(groupId);
	}

	/**
	 * Returns all the jobs where userId = &#63;.
	 *
	 * @param userId the user ID
	 * @return the matching jobs
	 */
	public static List<Job> findByUserId(long userId) {
		return getPersistence().findByUserId(userId);
	}

	/**
	 * Returns a range of all the jobs where userId = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not <code>QueryUtil#ALL_POS</code>), then the query will include the default ORDER BY logic from <code>JobModelImpl</code>. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	 * </p>
	 *
	 * @param userId the user ID
	 * @param start the lower bound of the range of jobs
	 * @param end the upper bound of the range of jobs (not inclusive)
	 * @return the range of matching jobs
	 */
	public static List<Job> findByUserId(long userId, int start, int end) {
		return getPersistence().findByUserId(userId, start, end);
	}

	/**
	 * Returns an ordered range of all the jobs where userId = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not <code>QueryUtil#ALL_POS</code>), then the query will include the default ORDER BY logic from <code>JobModelImpl</code>. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	 * </p>
	 *
	 * @param userId the user ID
	 * @param start the lower bound of the range of jobs
	 * @param end the upper bound of the range of jobs (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @return the ordered range of matching jobs
	 */
	public static List<Job> findByUserId(
		long userId, int start, int end,
		OrderByComparator<Job> orderByComparator) {

		return getPersistence().findByUserId(
			userId, start, end, orderByComparator);
	}

	/**
	 * Returns an ordered range of all the jobs where userId = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not <code>QueryUtil#ALL_POS</code>), then the query will include the default ORDER BY logic from <code>JobModelImpl</code>. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	 * </p>
	 *
	 * @param userId the user ID
	 * @param start the lower bound of the range of jobs
	 * @param end the upper bound of the range of jobs (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @param retrieveFromCache whether to retrieve from the finder cache
	 * @return the ordered range of matching jobs
	 */
	public static List<Job> findByUserId(
		long userId, int start, int end,
		OrderByComparator<Job> orderByComparator, boolean retrieveFromCache) {

		return getPersistence().findByUserId(
			userId, start, end, orderByComparator, retrieveFromCache);
	}

	/**
	 * Returns the first job in the ordered set where userId = &#63;.
	 *
	 * @param userId the user ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching job
	 * @throws NoSuchJobException if a matching job could not be found
	 */
	public static Job findByUserId_First(
			long userId, OrderByComparator<Job> orderByComparator)
		throws com.osp.icebreaker.exception.NoSuchJobException {

		return getPersistence().findByUserId_First(userId, orderByComparator);
	}

	/**
	 * Returns the first job in the ordered set where userId = &#63;.
	 *
	 * @param userId the user ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching job, or <code>null</code> if a matching job could not be found
	 */
	public static Job fetchByUserId_First(
		long userId, OrderByComparator<Job> orderByComparator) {

		return getPersistence().fetchByUserId_First(userId, orderByComparator);
	}

	/**
	 * Returns the last job in the ordered set where userId = &#63;.
	 *
	 * @param userId the user ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching job
	 * @throws NoSuchJobException if a matching job could not be found
	 */
	public static Job findByUserId_Last(
			long userId, OrderByComparator<Job> orderByComparator)
		throws com.osp.icebreaker.exception.NoSuchJobException {

		return getPersistence().findByUserId_Last(userId, orderByComparator);
	}

	/**
	 * Returns the last job in the ordered set where userId = &#63;.
	 *
	 * @param userId the user ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching job, or <code>null</code> if a matching job could not be found
	 */
	public static Job fetchByUserId_Last(
		long userId, OrderByComparator<Job> orderByComparator) {

		return getPersistence().fetchByUserId_Last(userId, orderByComparator);
	}

	/**
	 * Returns the jobs before and after the current job in the ordered set where userId = &#63;.
	 *
	 * @param jobId the primary key of the current job
	 * @param userId the user ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the previous, current, and next job
	 * @throws NoSuchJobException if a job with the primary key could not be found
	 */
	public static Job[] findByUserId_PrevAndNext(
			long jobId, long userId, OrderByComparator<Job> orderByComparator)
		throws com.osp.icebreaker.exception.NoSuchJobException {

		return getPersistence().findByUserId_PrevAndNext(
			jobId, userId, orderByComparator);
	}

	/**
	 * Removes all the jobs where userId = &#63; from the database.
	 *
	 * @param userId the user ID
	 */
	public static void removeByUserId(long userId) {
		getPersistence().removeByUserId(userId);
	}

	/**
	 * Returns the number of jobs where userId = &#63;.
	 *
	 * @param userId the user ID
	 * @return the number of matching jobs
	 */
	public static int countByUserId(long userId) {
		return getPersistence().countByUserId(userId);
	}

	/**
	 * Returns all the jobs where groupId = &#63; and userId = &#63;.
	 *
	 * @param groupId the group ID
	 * @param userId the user ID
	 * @return the matching jobs
	 */
	public static List<Job> findByUserId_G(long groupId, long userId) {
		return getPersistence().findByUserId_G(groupId, userId);
	}

	/**
	 * Returns a range of all the jobs where groupId = &#63; and userId = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not <code>QueryUtil#ALL_POS</code>), then the query will include the default ORDER BY logic from <code>JobModelImpl</code>. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	 * </p>
	 *
	 * @param groupId the group ID
	 * @param userId the user ID
	 * @param start the lower bound of the range of jobs
	 * @param end the upper bound of the range of jobs (not inclusive)
	 * @return the range of matching jobs
	 */
	public static List<Job> findByUserId_G(
		long groupId, long userId, int start, int end) {

		return getPersistence().findByUserId_G(groupId, userId, start, end);
	}

	/**
	 * Returns an ordered range of all the jobs where groupId = &#63; and userId = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not <code>QueryUtil#ALL_POS</code>), then the query will include the default ORDER BY logic from <code>JobModelImpl</code>. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	 * </p>
	 *
	 * @param groupId the group ID
	 * @param userId the user ID
	 * @param start the lower bound of the range of jobs
	 * @param end the upper bound of the range of jobs (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @return the ordered range of matching jobs
	 */
	public static List<Job> findByUserId_G(
		long groupId, long userId, int start, int end,
		OrderByComparator<Job> orderByComparator) {

		return getPersistence().findByUserId_G(
			groupId, userId, start, end, orderByComparator);
	}

	/**
	 * Returns an ordered range of all the jobs where groupId = &#63; and userId = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not <code>QueryUtil#ALL_POS</code>), then the query will include the default ORDER BY logic from <code>JobModelImpl</code>. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	 * </p>
	 *
	 * @param groupId the group ID
	 * @param userId the user ID
	 * @param start the lower bound of the range of jobs
	 * @param end the upper bound of the range of jobs (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @param retrieveFromCache whether to retrieve from the finder cache
	 * @return the ordered range of matching jobs
	 */
	public static List<Job> findByUserId_G(
		long groupId, long userId, int start, int end,
		OrderByComparator<Job> orderByComparator, boolean retrieveFromCache) {

		return getPersistence().findByUserId_G(
			groupId, userId, start, end, orderByComparator, retrieveFromCache);
	}

	/**
	 * Returns the first job in the ordered set where groupId = &#63; and userId = &#63;.
	 *
	 * @param groupId the group ID
	 * @param userId the user ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching job
	 * @throws NoSuchJobException if a matching job could not be found
	 */
	public static Job findByUserId_G_First(
			long groupId, long userId, OrderByComparator<Job> orderByComparator)
		throws com.osp.icebreaker.exception.NoSuchJobException {

		return getPersistence().findByUserId_G_First(
			groupId, userId, orderByComparator);
	}

	/**
	 * Returns the first job in the ordered set where groupId = &#63; and userId = &#63;.
	 *
	 * @param groupId the group ID
	 * @param userId the user ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching job, or <code>null</code> if a matching job could not be found
	 */
	public static Job fetchByUserId_G_First(
		long groupId, long userId, OrderByComparator<Job> orderByComparator) {

		return getPersistence().fetchByUserId_G_First(
			groupId, userId, orderByComparator);
	}

	/**
	 * Returns the last job in the ordered set where groupId = &#63; and userId = &#63;.
	 *
	 * @param groupId the group ID
	 * @param userId the user ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching job
	 * @throws NoSuchJobException if a matching job could not be found
	 */
	public static Job findByUserId_G_Last(
			long groupId, long userId, OrderByComparator<Job> orderByComparator)
		throws com.osp.icebreaker.exception.NoSuchJobException {

		return getPersistence().findByUserId_G_Last(
			groupId, userId, orderByComparator);
	}

	/**
	 * Returns the last job in the ordered set where groupId = &#63; and userId = &#63;.
	 *
	 * @param groupId the group ID
	 * @param userId the user ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching job, or <code>null</code> if a matching job could not be found
	 */
	public static Job fetchByUserId_G_Last(
		long groupId, long userId, OrderByComparator<Job> orderByComparator) {

		return getPersistence().fetchByUserId_G_Last(
			groupId, userId, orderByComparator);
	}

	/**
	 * Returns the jobs before and after the current job in the ordered set where groupId = &#63; and userId = &#63;.
	 *
	 * @param jobId the primary key of the current job
	 * @param groupId the group ID
	 * @param userId the user ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the previous, current, and next job
	 * @throws NoSuchJobException if a job with the primary key could not be found
	 */
	public static Job[] findByUserId_G_PrevAndNext(
			long jobId, long groupId, long userId,
			OrderByComparator<Job> orderByComparator)
		throws com.osp.icebreaker.exception.NoSuchJobException {

		return getPersistence().findByUserId_G_PrevAndNext(
			jobId, groupId, userId, orderByComparator);
	}

	/**
	 * Removes all the jobs where groupId = &#63; and userId = &#63; from the database.
	 *
	 * @param groupId the group ID
	 * @param userId the user ID
	 */
	public static void removeByUserId_G(long groupId, long userId) {
		getPersistence().removeByUserId_G(groupId, userId);
	}

	/**
	 * Returns the number of jobs where groupId = &#63; and userId = &#63;.
	 *
	 * @param groupId the group ID
	 * @param userId the user ID
	 * @return the number of matching jobs
	 */
	public static int countByUserId_G(long groupId, long userId) {
		return getPersistence().countByUserId_G(groupId, userId);
	}

	/**
	 * Returns all the jobs where status = &#63;.
	 *
	 * @param status the status
	 * @return the matching jobs
	 */
	public static List<Job> findByStatus(int status) {
		return getPersistence().findByStatus(status);
	}

	/**
	 * Returns a range of all the jobs where status = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not <code>QueryUtil#ALL_POS</code>), then the query will include the default ORDER BY logic from <code>JobModelImpl</code>. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	 * </p>
	 *
	 * @param status the status
	 * @param start the lower bound of the range of jobs
	 * @param end the upper bound of the range of jobs (not inclusive)
	 * @return the range of matching jobs
	 */
	public static List<Job> findByStatus(int status, int start, int end) {
		return getPersistence().findByStatus(status, start, end);
	}

	/**
	 * Returns an ordered range of all the jobs where status = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not <code>QueryUtil#ALL_POS</code>), then the query will include the default ORDER BY logic from <code>JobModelImpl</code>. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	 * </p>
	 *
	 * @param status the status
	 * @param start the lower bound of the range of jobs
	 * @param end the upper bound of the range of jobs (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @return the ordered range of matching jobs
	 */
	public static List<Job> findByStatus(
		int status, int start, int end,
		OrderByComparator<Job> orderByComparator) {

		return getPersistence().findByStatus(
			status, start, end, orderByComparator);
	}

	/**
	 * Returns an ordered range of all the jobs where status = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not <code>QueryUtil#ALL_POS</code>), then the query will include the default ORDER BY logic from <code>JobModelImpl</code>. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	 * </p>
	 *
	 * @param status the status
	 * @param start the lower bound of the range of jobs
	 * @param end the upper bound of the range of jobs (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @param retrieveFromCache whether to retrieve from the finder cache
	 * @return the ordered range of matching jobs
	 */
	public static List<Job> findByStatus(
		int status, int start, int end,
		OrderByComparator<Job> orderByComparator, boolean retrieveFromCache) {

		return getPersistence().findByStatus(
			status, start, end, orderByComparator, retrieveFromCache);
	}

	/**
	 * Returns the first job in the ordered set where status = &#63;.
	 *
	 * @param status the status
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching job
	 * @throws NoSuchJobException if a matching job could not be found
	 */
	public static Job findByStatus_First(
			int status, OrderByComparator<Job> orderByComparator)
		throws com.osp.icebreaker.exception.NoSuchJobException {

		return getPersistence().findByStatus_First(status, orderByComparator);
	}

	/**
	 * Returns the first job in the ordered set where status = &#63;.
	 *
	 * @param status the status
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching job, or <code>null</code> if a matching job could not be found
	 */
	public static Job fetchByStatus_First(
		int status, OrderByComparator<Job> orderByComparator) {

		return getPersistence().fetchByStatus_First(status, orderByComparator);
	}

	/**
	 * Returns the last job in the ordered set where status = &#63;.
	 *
	 * @param status the status
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching job
	 * @throws NoSuchJobException if a matching job could not be found
	 */
	public static Job findByStatus_Last(
			int status, OrderByComparator<Job> orderByComparator)
		throws com.osp.icebreaker.exception.NoSuchJobException {

		return getPersistence().findByStatus_Last(status, orderByComparator);
	}

	/**
	 * Returns the last job in the ordered set where status = &#63;.
	 *
	 * @param status the status
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching job, or <code>null</code> if a matching job could not be found
	 */
	public static Job fetchByStatus_Last(
		int status, OrderByComparator<Job> orderByComparator) {

		return getPersistence().fetchByStatus_Last(status, orderByComparator);
	}

	/**
	 * Returns the jobs before and after the current job in the ordered set where status = &#63;.
	 *
	 * @param jobId the primary key of the current job
	 * @param status the status
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the previous, current, and next job
	 * @throws NoSuchJobException if a job with the primary key could not be found
	 */
	public static Job[] findByStatus_PrevAndNext(
			long jobId, int status, OrderByComparator<Job> orderByComparator)
		throws com.osp.icebreaker.exception.NoSuchJobException {

		return getPersistence().findByStatus_PrevAndNext(
			jobId, status, orderByComparator);
	}

	/**
	 * Removes all the jobs where status = &#63; from the database.
	 *
	 * @param status the status
	 */
	public static void removeByStatus(int status) {
		getPersistence().removeByStatus(status);
	}

	/**
	 * Returns the number of jobs where status = &#63;.
	 *
	 * @param status the status
	 * @return the number of matching jobs
	 */
	public static int countByStatus(int status) {
		return getPersistence().countByStatus(status);
	}

	/**
	 * Returns all the jobs where groupId = &#63; and status = &#63;.
	 *
	 * @param groupId the group ID
	 * @param status the status
	 * @return the matching jobs
	 */
	public static List<Job> findByStatus_G(long groupId, int status) {
		return getPersistence().findByStatus_G(groupId, status);
	}

	/**
	 * Returns a range of all the jobs where groupId = &#63; and status = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not <code>QueryUtil#ALL_POS</code>), then the query will include the default ORDER BY logic from <code>JobModelImpl</code>. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	 * </p>
	 *
	 * @param groupId the group ID
	 * @param status the status
	 * @param start the lower bound of the range of jobs
	 * @param end the upper bound of the range of jobs (not inclusive)
	 * @return the range of matching jobs
	 */
	public static List<Job> findByStatus_G(
		long groupId, int status, int start, int end) {

		return getPersistence().findByStatus_G(groupId, status, start, end);
	}

	/**
	 * Returns an ordered range of all the jobs where groupId = &#63; and status = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not <code>QueryUtil#ALL_POS</code>), then the query will include the default ORDER BY logic from <code>JobModelImpl</code>. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	 * </p>
	 *
	 * @param groupId the group ID
	 * @param status the status
	 * @param start the lower bound of the range of jobs
	 * @param end the upper bound of the range of jobs (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @return the ordered range of matching jobs
	 */
	public static List<Job> findByStatus_G(
		long groupId, int status, int start, int end,
		OrderByComparator<Job> orderByComparator) {

		return getPersistence().findByStatus_G(
			groupId, status, start, end, orderByComparator);
	}

	/**
	 * Returns an ordered range of all the jobs where groupId = &#63; and status = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not <code>QueryUtil#ALL_POS</code>), then the query will include the default ORDER BY logic from <code>JobModelImpl</code>. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	 * </p>
	 *
	 * @param groupId the group ID
	 * @param status the status
	 * @param start the lower bound of the range of jobs
	 * @param end the upper bound of the range of jobs (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @param retrieveFromCache whether to retrieve from the finder cache
	 * @return the ordered range of matching jobs
	 */
	public static List<Job> findByStatus_G(
		long groupId, int status, int start, int end,
		OrderByComparator<Job> orderByComparator, boolean retrieveFromCache) {

		return getPersistence().findByStatus_G(
			groupId, status, start, end, orderByComparator, retrieveFromCache);
	}

	/**
	 * Returns the first job in the ordered set where groupId = &#63; and status = &#63;.
	 *
	 * @param groupId the group ID
	 * @param status the status
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching job
	 * @throws NoSuchJobException if a matching job could not be found
	 */
	public static Job findByStatus_G_First(
			long groupId, int status, OrderByComparator<Job> orderByComparator)
		throws com.osp.icebreaker.exception.NoSuchJobException {

		return getPersistence().findByStatus_G_First(
			groupId, status, orderByComparator);
	}

	/**
	 * Returns the first job in the ordered set where groupId = &#63; and status = &#63;.
	 *
	 * @param groupId the group ID
	 * @param status the status
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching job, or <code>null</code> if a matching job could not be found
	 */
	public static Job fetchByStatus_G_First(
		long groupId, int status, OrderByComparator<Job> orderByComparator) {

		return getPersistence().fetchByStatus_G_First(
			groupId, status, orderByComparator);
	}

	/**
	 * Returns the last job in the ordered set where groupId = &#63; and status = &#63;.
	 *
	 * @param groupId the group ID
	 * @param status the status
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching job
	 * @throws NoSuchJobException if a matching job could not be found
	 */
	public static Job findByStatus_G_Last(
			long groupId, int status, OrderByComparator<Job> orderByComparator)
		throws com.osp.icebreaker.exception.NoSuchJobException {

		return getPersistence().findByStatus_G_Last(
			groupId, status, orderByComparator);
	}

	/**
	 * Returns the last job in the ordered set where groupId = &#63; and status = &#63;.
	 *
	 * @param groupId the group ID
	 * @param status the status
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching job, or <code>null</code> if a matching job could not be found
	 */
	public static Job fetchByStatus_G_Last(
		long groupId, int status, OrderByComparator<Job> orderByComparator) {

		return getPersistence().fetchByStatus_G_Last(
			groupId, status, orderByComparator);
	}

	/**
	 * Returns the jobs before and after the current job in the ordered set where groupId = &#63; and status = &#63;.
	 *
	 * @param jobId the primary key of the current job
	 * @param groupId the group ID
	 * @param status the status
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the previous, current, and next job
	 * @throws NoSuchJobException if a job with the primary key could not be found
	 */
	public static Job[] findByStatus_G_PrevAndNext(
			long jobId, long groupId, int status,
			OrderByComparator<Job> orderByComparator)
		throws com.osp.icebreaker.exception.NoSuchJobException {

		return getPersistence().findByStatus_G_PrevAndNext(
			jobId, groupId, status, orderByComparator);
	}

	/**
	 * Removes all the jobs where groupId = &#63; and status = &#63; from the database.
	 *
	 * @param groupId the group ID
	 * @param status the status
	 */
	public static void removeByStatus_G(long groupId, int status) {
		getPersistence().removeByStatus_G(groupId, status);
	}

	/**
	 * Returns the number of jobs where groupId = &#63; and status = &#63;.
	 *
	 * @param groupId the group ID
	 * @param status the status
	 * @return the number of matching jobs
	 */
	public static int countByStatus_G(long groupId, int status) {
		return getPersistence().countByStatus_G(groupId, status);
	}

	/**
	 * Returns all the jobs where userId = &#63; and status = &#63;.
	 *
	 * @param userId the user ID
	 * @param status the status
	 * @return the matching jobs
	 */
	public static List<Job> findByStatus_U(long userId, int status) {
		return getPersistence().findByStatus_U(userId, status);
	}

	/**
	 * Returns a range of all the jobs where userId = &#63; and status = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not <code>QueryUtil#ALL_POS</code>), then the query will include the default ORDER BY logic from <code>JobModelImpl</code>. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	 * </p>
	 *
	 * @param userId the user ID
	 * @param status the status
	 * @param start the lower bound of the range of jobs
	 * @param end the upper bound of the range of jobs (not inclusive)
	 * @return the range of matching jobs
	 */
	public static List<Job> findByStatus_U(
		long userId, int status, int start, int end) {

		return getPersistence().findByStatus_U(userId, status, start, end);
	}

	/**
	 * Returns an ordered range of all the jobs where userId = &#63; and status = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not <code>QueryUtil#ALL_POS</code>), then the query will include the default ORDER BY logic from <code>JobModelImpl</code>. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	 * </p>
	 *
	 * @param userId the user ID
	 * @param status the status
	 * @param start the lower bound of the range of jobs
	 * @param end the upper bound of the range of jobs (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @return the ordered range of matching jobs
	 */
	public static List<Job> findByStatus_U(
		long userId, int status, int start, int end,
		OrderByComparator<Job> orderByComparator) {

		return getPersistence().findByStatus_U(
			userId, status, start, end, orderByComparator);
	}

	/**
	 * Returns an ordered range of all the jobs where userId = &#63; and status = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not <code>QueryUtil#ALL_POS</code>), then the query will include the default ORDER BY logic from <code>JobModelImpl</code>. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	 * </p>
	 *
	 * @param userId the user ID
	 * @param status the status
	 * @param start the lower bound of the range of jobs
	 * @param end the upper bound of the range of jobs (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @param retrieveFromCache whether to retrieve from the finder cache
	 * @return the ordered range of matching jobs
	 */
	public static List<Job> findByStatus_U(
		long userId, int status, int start, int end,
		OrderByComparator<Job> orderByComparator, boolean retrieveFromCache) {

		return getPersistence().findByStatus_U(
			userId, status, start, end, orderByComparator, retrieveFromCache);
	}

	/**
	 * Returns the first job in the ordered set where userId = &#63; and status = &#63;.
	 *
	 * @param userId the user ID
	 * @param status the status
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching job
	 * @throws NoSuchJobException if a matching job could not be found
	 */
	public static Job findByStatus_U_First(
			long userId, int status, OrderByComparator<Job> orderByComparator)
		throws com.osp.icebreaker.exception.NoSuchJobException {

		return getPersistence().findByStatus_U_First(
			userId, status, orderByComparator);
	}

	/**
	 * Returns the first job in the ordered set where userId = &#63; and status = &#63;.
	 *
	 * @param userId the user ID
	 * @param status the status
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching job, or <code>null</code> if a matching job could not be found
	 */
	public static Job fetchByStatus_U_First(
		long userId, int status, OrderByComparator<Job> orderByComparator) {

		return getPersistence().fetchByStatus_U_First(
			userId, status, orderByComparator);
	}

	/**
	 * Returns the last job in the ordered set where userId = &#63; and status = &#63;.
	 *
	 * @param userId the user ID
	 * @param status the status
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching job
	 * @throws NoSuchJobException if a matching job could not be found
	 */
	public static Job findByStatus_U_Last(
			long userId, int status, OrderByComparator<Job> orderByComparator)
		throws com.osp.icebreaker.exception.NoSuchJobException {

		return getPersistence().findByStatus_U_Last(
			userId, status, orderByComparator);
	}

	/**
	 * Returns the last job in the ordered set where userId = &#63; and status = &#63;.
	 *
	 * @param userId the user ID
	 * @param status the status
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching job, or <code>null</code> if a matching job could not be found
	 */
	public static Job fetchByStatus_U_Last(
		long userId, int status, OrderByComparator<Job> orderByComparator) {

		return getPersistence().fetchByStatus_U_Last(
			userId, status, orderByComparator);
	}

	/**
	 * Returns the jobs before and after the current job in the ordered set where userId = &#63; and status = &#63;.
	 *
	 * @param jobId the primary key of the current job
	 * @param userId the user ID
	 * @param status the status
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the previous, current, and next job
	 * @throws NoSuchJobException if a job with the primary key could not be found
	 */
	public static Job[] findByStatus_U_PrevAndNext(
			long jobId, long userId, int status,
			OrderByComparator<Job> orderByComparator)
		throws com.osp.icebreaker.exception.NoSuchJobException {

		return getPersistence().findByStatus_U_PrevAndNext(
			jobId, userId, status, orderByComparator);
	}

	/**
	 * Removes all the jobs where userId = &#63; and status = &#63; from the database.
	 *
	 * @param userId the user ID
	 * @param status the status
	 */
	public static void removeByStatus_U(long userId, int status) {
		getPersistence().removeByStatus_U(userId, status);
	}

	/**
	 * Returns the number of jobs where userId = &#63; and status = &#63;.
	 *
	 * @param userId the user ID
	 * @param status the status
	 * @return the number of matching jobs
	 */
	public static int countByStatus_U(long userId, int status) {
		return getPersistence().countByStatus_U(userId, status);
	}

	/**
	 * Returns all the jobs where groupId = &#63; and userId = &#63; and status = &#63;.
	 *
	 * @param groupId the group ID
	 * @param userId the user ID
	 * @param status the status
	 * @return the matching jobs
	 */
	public static List<Job> findByStatus_G_U(
		long groupId, long userId, int status) {

		return getPersistence().findByStatus_G_U(groupId, userId, status);
	}

	/**
	 * Returns a range of all the jobs where groupId = &#63; and userId = &#63; and status = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not <code>QueryUtil#ALL_POS</code>), then the query will include the default ORDER BY logic from <code>JobModelImpl</code>. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	 * </p>
	 *
	 * @param groupId the group ID
	 * @param userId the user ID
	 * @param status the status
	 * @param start the lower bound of the range of jobs
	 * @param end the upper bound of the range of jobs (not inclusive)
	 * @return the range of matching jobs
	 */
	public static List<Job> findByStatus_G_U(
		long groupId, long userId, int status, int start, int end) {

		return getPersistence().findByStatus_G_U(
			groupId, userId, status, start, end);
	}

	/**
	 * Returns an ordered range of all the jobs where groupId = &#63; and userId = &#63; and status = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not <code>QueryUtil#ALL_POS</code>), then the query will include the default ORDER BY logic from <code>JobModelImpl</code>. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	 * </p>
	 *
	 * @param groupId the group ID
	 * @param userId the user ID
	 * @param status the status
	 * @param start the lower bound of the range of jobs
	 * @param end the upper bound of the range of jobs (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @return the ordered range of matching jobs
	 */
	public static List<Job> findByStatus_G_U(
		long groupId, long userId, int status, int start, int end,
		OrderByComparator<Job> orderByComparator) {

		return getPersistence().findByStatus_G_U(
			groupId, userId, status, start, end, orderByComparator);
	}

	/**
	 * Returns an ordered range of all the jobs where groupId = &#63; and userId = &#63; and status = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not <code>QueryUtil#ALL_POS</code>), then the query will include the default ORDER BY logic from <code>JobModelImpl</code>. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	 * </p>
	 *
	 * @param groupId the group ID
	 * @param userId the user ID
	 * @param status the status
	 * @param start the lower bound of the range of jobs
	 * @param end the upper bound of the range of jobs (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @param retrieveFromCache whether to retrieve from the finder cache
	 * @return the ordered range of matching jobs
	 */
	public static List<Job> findByStatus_G_U(
		long groupId, long userId, int status, int start, int end,
		OrderByComparator<Job> orderByComparator, boolean retrieveFromCache) {

		return getPersistence().findByStatus_G_U(
			groupId, userId, status, start, end, orderByComparator,
			retrieveFromCache);
	}

	/**
	 * Returns the first job in the ordered set where groupId = &#63; and userId = &#63; and status = &#63;.
	 *
	 * @param groupId the group ID
	 * @param userId the user ID
	 * @param status the status
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching job
	 * @throws NoSuchJobException if a matching job could not be found
	 */
	public static Job findByStatus_G_U_First(
			long groupId, long userId, int status,
			OrderByComparator<Job> orderByComparator)
		throws com.osp.icebreaker.exception.NoSuchJobException {

		return getPersistence().findByStatus_G_U_First(
			groupId, userId, status, orderByComparator);
	}

	/**
	 * Returns the first job in the ordered set where groupId = &#63; and userId = &#63; and status = &#63;.
	 *
	 * @param groupId the group ID
	 * @param userId the user ID
	 * @param status the status
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching job, or <code>null</code> if a matching job could not be found
	 */
	public static Job fetchByStatus_G_U_First(
		long groupId, long userId, int status,
		OrderByComparator<Job> orderByComparator) {

		return getPersistence().fetchByStatus_G_U_First(
			groupId, userId, status, orderByComparator);
	}

	/**
	 * Returns the last job in the ordered set where groupId = &#63; and userId = &#63; and status = &#63;.
	 *
	 * @param groupId the group ID
	 * @param userId the user ID
	 * @param status the status
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching job
	 * @throws NoSuchJobException if a matching job could not be found
	 */
	public static Job findByStatus_G_U_Last(
			long groupId, long userId, int status,
			OrderByComparator<Job> orderByComparator)
		throws com.osp.icebreaker.exception.NoSuchJobException {

		return getPersistence().findByStatus_G_U_Last(
			groupId, userId, status, orderByComparator);
	}

	/**
	 * Returns the last job in the ordered set where groupId = &#63; and userId = &#63; and status = &#63;.
	 *
	 * @param groupId the group ID
	 * @param userId the user ID
	 * @param status the status
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching job, or <code>null</code> if a matching job could not be found
	 */
	public static Job fetchByStatus_G_U_Last(
		long groupId, long userId, int status,
		OrderByComparator<Job> orderByComparator) {

		return getPersistence().fetchByStatus_G_U_Last(
			groupId, userId, status, orderByComparator);
	}

	/**
	 * Returns the jobs before and after the current job in the ordered set where groupId = &#63; and userId = &#63; and status = &#63;.
	 *
	 * @param jobId the primary key of the current job
	 * @param groupId the group ID
	 * @param userId the user ID
	 * @param status the status
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the previous, current, and next job
	 * @throws NoSuchJobException if a job with the primary key could not be found
	 */
	public static Job[] findByStatus_G_U_PrevAndNext(
			long jobId, long groupId, long userId, int status,
			OrderByComparator<Job> orderByComparator)
		throws com.osp.icebreaker.exception.NoSuchJobException {

		return getPersistence().findByStatus_G_U_PrevAndNext(
			jobId, groupId, userId, status, orderByComparator);
	}

	/**
	 * Removes all the jobs where groupId = &#63; and userId = &#63; and status = &#63; from the database.
	 *
	 * @param groupId the group ID
	 * @param userId the user ID
	 * @param status the status
	 */
	public static void removeByStatus_G_U(
		long groupId, long userId, int status) {

		getPersistence().removeByStatus_G_U(groupId, userId, status);
	}

	/**
	 * Returns the number of jobs where groupId = &#63; and userId = &#63; and status = &#63;.
	 *
	 * @param groupId the group ID
	 * @param userId the user ID
	 * @param status the status
	 * @return the number of matching jobs
	 */
	public static int countByStatus_G_U(long groupId, long userId, int status) {
		return getPersistence().countByStatus_G_U(groupId, userId, status);
	}

	/**
	 * Returns all the jobs where queueName = &#63;.
	 *
	 * @param queueName the queue name
	 * @return the matching jobs
	 */
	public static List<Job> findByQueueName(String queueName) {
		return getPersistence().findByQueueName(queueName);
	}

	/**
	 * Returns a range of all the jobs where queueName = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not <code>QueryUtil#ALL_POS</code>), then the query will include the default ORDER BY logic from <code>JobModelImpl</code>. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	 * </p>
	 *
	 * @param queueName the queue name
	 * @param start the lower bound of the range of jobs
	 * @param end the upper bound of the range of jobs (not inclusive)
	 * @return the range of matching jobs
	 */
	public static List<Job> findByQueueName(
		String queueName, int start, int end) {

		return getPersistence().findByQueueName(queueName, start, end);
	}

	/**
	 * Returns an ordered range of all the jobs where queueName = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not <code>QueryUtil#ALL_POS</code>), then the query will include the default ORDER BY logic from <code>JobModelImpl</code>. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	 * </p>
	 *
	 * @param queueName the queue name
	 * @param start the lower bound of the range of jobs
	 * @param end the upper bound of the range of jobs (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @return the ordered range of matching jobs
	 */
	public static List<Job> findByQueueName(
		String queueName, int start, int end,
		OrderByComparator<Job> orderByComparator) {

		return getPersistence().findByQueueName(
			queueName, start, end, orderByComparator);
	}

	/**
	 * Returns an ordered range of all the jobs where queueName = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not <code>QueryUtil#ALL_POS</code>), then the query will include the default ORDER BY logic from <code>JobModelImpl</code>. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	 * </p>
	 *
	 * @param queueName the queue name
	 * @param start the lower bound of the range of jobs
	 * @param end the upper bound of the range of jobs (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @param retrieveFromCache whether to retrieve from the finder cache
	 * @return the ordered range of matching jobs
	 */
	public static List<Job> findByQueueName(
		String queueName, int start, int end,
		OrderByComparator<Job> orderByComparator, boolean retrieveFromCache) {

		return getPersistence().findByQueueName(
			queueName, start, end, orderByComparator, retrieveFromCache);
	}

	/**
	 * Returns the first job in the ordered set where queueName = &#63;.
	 *
	 * @param queueName the queue name
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching job
	 * @throws NoSuchJobException if a matching job could not be found
	 */
	public static Job findByQueueName_First(
			String queueName, OrderByComparator<Job> orderByComparator)
		throws com.osp.icebreaker.exception.NoSuchJobException {

		return getPersistence().findByQueueName_First(
			queueName, orderByComparator);
	}

	/**
	 * Returns the first job in the ordered set where queueName = &#63;.
	 *
	 * @param queueName the queue name
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching job, or <code>null</code> if a matching job could not be found
	 */
	public static Job fetchByQueueName_First(
		String queueName, OrderByComparator<Job> orderByComparator) {

		return getPersistence().fetchByQueueName_First(
			queueName, orderByComparator);
	}

	/**
	 * Returns the last job in the ordered set where queueName = &#63;.
	 *
	 * @param queueName the queue name
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching job
	 * @throws NoSuchJobException if a matching job could not be found
	 */
	public static Job findByQueueName_Last(
			String queueName, OrderByComparator<Job> orderByComparator)
		throws com.osp.icebreaker.exception.NoSuchJobException {

		return getPersistence().findByQueueName_Last(
			queueName, orderByComparator);
	}

	/**
	 * Returns the last job in the ordered set where queueName = &#63;.
	 *
	 * @param queueName the queue name
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching job, or <code>null</code> if a matching job could not be found
	 */
	public static Job fetchByQueueName_Last(
		String queueName, OrderByComparator<Job> orderByComparator) {

		return getPersistence().fetchByQueueName_Last(
			queueName, orderByComparator);
	}

	/**
	 * Returns the jobs before and after the current job in the ordered set where queueName = &#63;.
	 *
	 * @param jobId the primary key of the current job
	 * @param queueName the queue name
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the previous, current, and next job
	 * @throws NoSuchJobException if a job with the primary key could not be found
	 */
	public static Job[] findByQueueName_PrevAndNext(
			long jobId, String queueName,
			OrderByComparator<Job> orderByComparator)
		throws com.osp.icebreaker.exception.NoSuchJobException {

		return getPersistence().findByQueueName_PrevAndNext(
			jobId, queueName, orderByComparator);
	}

	/**
	 * Removes all the jobs where queueName = &#63; from the database.
	 *
	 * @param queueName the queue name
	 */
	public static void removeByQueueName(String queueName) {
		getPersistence().removeByQueueName(queueName);
	}

	/**
	 * Returns the number of jobs where queueName = &#63;.
	 *
	 * @param queueName the queue name
	 * @return the number of matching jobs
	 */
	public static int countByQueueName(String queueName) {
		return getPersistence().countByQueueName(queueName);
	}

	/**
	 * Returns all the jobs where jobStatus = &#63;.
	 *
	 * @param jobStatus the job status
	 * @return the matching jobs
	 */
	public static List<Job> findByJobStatus(int jobStatus) {
		return getPersistence().findByJobStatus(jobStatus);
	}

	/**
	 * Returns a range of all the jobs where jobStatus = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not <code>QueryUtil#ALL_POS</code>), then the query will include the default ORDER BY logic from <code>JobModelImpl</code>. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	 * </p>
	 *
	 * @param jobStatus the job status
	 * @param start the lower bound of the range of jobs
	 * @param end the upper bound of the range of jobs (not inclusive)
	 * @return the range of matching jobs
	 */
	public static List<Job> findByJobStatus(int jobStatus, int start, int end) {
		return getPersistence().findByJobStatus(jobStatus, start, end);
	}

	/**
	 * Returns an ordered range of all the jobs where jobStatus = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not <code>QueryUtil#ALL_POS</code>), then the query will include the default ORDER BY logic from <code>JobModelImpl</code>. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	 * </p>
	 *
	 * @param jobStatus the job status
	 * @param start the lower bound of the range of jobs
	 * @param end the upper bound of the range of jobs (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @return the ordered range of matching jobs
	 */
	public static List<Job> findByJobStatus(
		int jobStatus, int start, int end,
		OrderByComparator<Job> orderByComparator) {

		return getPersistence().findByJobStatus(
			jobStatus, start, end, orderByComparator);
	}

	/**
	 * Returns an ordered range of all the jobs where jobStatus = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not <code>QueryUtil#ALL_POS</code>), then the query will include the default ORDER BY logic from <code>JobModelImpl</code>. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	 * </p>
	 *
	 * @param jobStatus the job status
	 * @param start the lower bound of the range of jobs
	 * @param end the upper bound of the range of jobs (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @param retrieveFromCache whether to retrieve from the finder cache
	 * @return the ordered range of matching jobs
	 */
	public static List<Job> findByJobStatus(
		int jobStatus, int start, int end,
		OrderByComparator<Job> orderByComparator, boolean retrieveFromCache) {

		return getPersistence().findByJobStatus(
			jobStatus, start, end, orderByComparator, retrieveFromCache);
	}

	/**
	 * Returns the first job in the ordered set where jobStatus = &#63;.
	 *
	 * @param jobStatus the job status
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching job
	 * @throws NoSuchJobException if a matching job could not be found
	 */
	public static Job findByJobStatus_First(
			int jobStatus, OrderByComparator<Job> orderByComparator)
		throws com.osp.icebreaker.exception.NoSuchJobException {

		return getPersistence().findByJobStatus_First(
			jobStatus, orderByComparator);
	}

	/**
	 * Returns the first job in the ordered set where jobStatus = &#63;.
	 *
	 * @param jobStatus the job status
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching job, or <code>null</code> if a matching job could not be found
	 */
	public static Job fetchByJobStatus_First(
		int jobStatus, OrderByComparator<Job> orderByComparator) {

		return getPersistence().fetchByJobStatus_First(
			jobStatus, orderByComparator);
	}

	/**
	 * Returns the last job in the ordered set where jobStatus = &#63;.
	 *
	 * @param jobStatus the job status
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching job
	 * @throws NoSuchJobException if a matching job could not be found
	 */
	public static Job findByJobStatus_Last(
			int jobStatus, OrderByComparator<Job> orderByComparator)
		throws com.osp.icebreaker.exception.NoSuchJobException {

		return getPersistence().findByJobStatus_Last(
			jobStatus, orderByComparator);
	}

	/**
	 * Returns the last job in the ordered set where jobStatus = &#63;.
	 *
	 * @param jobStatus the job status
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching job, or <code>null</code> if a matching job could not be found
	 */
	public static Job fetchByJobStatus_Last(
		int jobStatus, OrderByComparator<Job> orderByComparator) {

		return getPersistence().fetchByJobStatus_Last(
			jobStatus, orderByComparator);
	}

	/**
	 * Returns the jobs before and after the current job in the ordered set where jobStatus = &#63;.
	 *
	 * @param jobId the primary key of the current job
	 * @param jobStatus the job status
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the previous, current, and next job
	 * @throws NoSuchJobException if a job with the primary key could not be found
	 */
	public static Job[] findByJobStatus_PrevAndNext(
			long jobId, int jobStatus, OrderByComparator<Job> orderByComparator)
		throws com.osp.icebreaker.exception.NoSuchJobException {

		return getPersistence().findByJobStatus_PrevAndNext(
			jobId, jobStatus, orderByComparator);
	}

	/**
	 * Removes all the jobs where jobStatus = &#63; from the database.
	 *
	 * @param jobStatus the job status
	 */
	public static void removeByJobStatus(int jobStatus) {
		getPersistence().removeByJobStatus(jobStatus);
	}

	/**
	 * Returns the number of jobs where jobStatus = &#63;.
	 *
	 * @param jobStatus the job status
	 * @return the number of matching jobs
	 */
	public static int countByJobStatus(int jobStatus) {
		return getPersistence().countByJobStatus(jobStatus);
	}

	/**
	 * Returns all the jobs where groupId = &#63; and jobStatus = &#63;.
	 *
	 * @param groupId the group ID
	 * @param jobStatus the job status
	 * @return the matching jobs
	 */
	public static List<Job> findByJobStatus_G(long groupId, int jobStatus) {
		return getPersistence().findByJobStatus_G(groupId, jobStatus);
	}

	/**
	 * Returns a range of all the jobs where groupId = &#63; and jobStatus = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not <code>QueryUtil#ALL_POS</code>), then the query will include the default ORDER BY logic from <code>JobModelImpl</code>. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	 * </p>
	 *
	 * @param groupId the group ID
	 * @param jobStatus the job status
	 * @param start the lower bound of the range of jobs
	 * @param end the upper bound of the range of jobs (not inclusive)
	 * @return the range of matching jobs
	 */
	public static List<Job> findByJobStatus_G(
		long groupId, int jobStatus, int start, int end) {

		return getPersistence().findByJobStatus_G(
			groupId, jobStatus, start, end);
	}

	/**
	 * Returns an ordered range of all the jobs where groupId = &#63; and jobStatus = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not <code>QueryUtil#ALL_POS</code>), then the query will include the default ORDER BY logic from <code>JobModelImpl</code>. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	 * </p>
	 *
	 * @param groupId the group ID
	 * @param jobStatus the job status
	 * @param start the lower bound of the range of jobs
	 * @param end the upper bound of the range of jobs (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @return the ordered range of matching jobs
	 */
	public static List<Job> findByJobStatus_G(
		long groupId, int jobStatus, int start, int end,
		OrderByComparator<Job> orderByComparator) {

		return getPersistence().findByJobStatus_G(
			groupId, jobStatus, start, end, orderByComparator);
	}

	/**
	 * Returns an ordered range of all the jobs where groupId = &#63; and jobStatus = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not <code>QueryUtil#ALL_POS</code>), then the query will include the default ORDER BY logic from <code>JobModelImpl</code>. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	 * </p>
	 *
	 * @param groupId the group ID
	 * @param jobStatus the job status
	 * @param start the lower bound of the range of jobs
	 * @param end the upper bound of the range of jobs (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @param retrieveFromCache whether to retrieve from the finder cache
	 * @return the ordered range of matching jobs
	 */
	public static List<Job> findByJobStatus_G(
		long groupId, int jobStatus, int start, int end,
		OrderByComparator<Job> orderByComparator, boolean retrieveFromCache) {

		return getPersistence().findByJobStatus_G(
			groupId, jobStatus, start, end, orderByComparator,
			retrieveFromCache);
	}

	/**
	 * Returns the first job in the ordered set where groupId = &#63; and jobStatus = &#63;.
	 *
	 * @param groupId the group ID
	 * @param jobStatus the job status
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching job
	 * @throws NoSuchJobException if a matching job could not be found
	 */
	public static Job findByJobStatus_G_First(
			long groupId, int jobStatus,
			OrderByComparator<Job> orderByComparator)
		throws com.osp.icebreaker.exception.NoSuchJobException {

		return getPersistence().findByJobStatus_G_First(
			groupId, jobStatus, orderByComparator);
	}

	/**
	 * Returns the first job in the ordered set where groupId = &#63; and jobStatus = &#63;.
	 *
	 * @param groupId the group ID
	 * @param jobStatus the job status
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching job, or <code>null</code> if a matching job could not be found
	 */
	public static Job fetchByJobStatus_G_First(
		long groupId, int jobStatus, OrderByComparator<Job> orderByComparator) {

		return getPersistence().fetchByJobStatus_G_First(
			groupId, jobStatus, orderByComparator);
	}

	/**
	 * Returns the last job in the ordered set where groupId = &#63; and jobStatus = &#63;.
	 *
	 * @param groupId the group ID
	 * @param jobStatus the job status
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching job
	 * @throws NoSuchJobException if a matching job could not be found
	 */
	public static Job findByJobStatus_G_Last(
			long groupId, int jobStatus,
			OrderByComparator<Job> orderByComparator)
		throws com.osp.icebreaker.exception.NoSuchJobException {

		return getPersistence().findByJobStatus_G_Last(
			groupId, jobStatus, orderByComparator);
	}

	/**
	 * Returns the last job in the ordered set where groupId = &#63; and jobStatus = &#63;.
	 *
	 * @param groupId the group ID
	 * @param jobStatus the job status
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching job, or <code>null</code> if a matching job could not be found
	 */
	public static Job fetchByJobStatus_G_Last(
		long groupId, int jobStatus, OrderByComparator<Job> orderByComparator) {

		return getPersistence().fetchByJobStatus_G_Last(
			groupId, jobStatus, orderByComparator);
	}

	/**
	 * Returns the jobs before and after the current job in the ordered set where groupId = &#63; and jobStatus = &#63;.
	 *
	 * @param jobId the primary key of the current job
	 * @param groupId the group ID
	 * @param jobStatus the job status
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the previous, current, and next job
	 * @throws NoSuchJobException if a job with the primary key could not be found
	 */
	public static Job[] findByJobStatus_G_PrevAndNext(
			long jobId, long groupId, int jobStatus,
			OrderByComparator<Job> orderByComparator)
		throws com.osp.icebreaker.exception.NoSuchJobException {

		return getPersistence().findByJobStatus_G_PrevAndNext(
			jobId, groupId, jobStatus, orderByComparator);
	}

	/**
	 * Removes all the jobs where groupId = &#63; and jobStatus = &#63; from the database.
	 *
	 * @param groupId the group ID
	 * @param jobStatus the job status
	 */
	public static void removeByJobStatus_G(long groupId, int jobStatus) {
		getPersistence().removeByJobStatus_G(groupId, jobStatus);
	}

	/**
	 * Returns the number of jobs where groupId = &#63; and jobStatus = &#63;.
	 *
	 * @param groupId the group ID
	 * @param jobStatus the job status
	 * @return the number of matching jobs
	 */
	public static int countByJobStatus_G(long groupId, int jobStatus) {
		return getPersistence().countByJobStatus_G(groupId, jobStatus);
	}

	/**
	 * Returns all the jobs where userId = &#63; and jobStatus = &#63;.
	 *
	 * @param userId the user ID
	 * @param jobStatus the job status
	 * @return the matching jobs
	 */
	public static List<Job> findByJobStatus_U(long userId, int jobStatus) {
		return getPersistence().findByJobStatus_U(userId, jobStatus);
	}

	/**
	 * Returns a range of all the jobs where userId = &#63; and jobStatus = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not <code>QueryUtil#ALL_POS</code>), then the query will include the default ORDER BY logic from <code>JobModelImpl</code>. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	 * </p>
	 *
	 * @param userId the user ID
	 * @param jobStatus the job status
	 * @param start the lower bound of the range of jobs
	 * @param end the upper bound of the range of jobs (not inclusive)
	 * @return the range of matching jobs
	 */
	public static List<Job> findByJobStatus_U(
		long userId, int jobStatus, int start, int end) {

		return getPersistence().findByJobStatus_U(
			userId, jobStatus, start, end);
	}

	/**
	 * Returns an ordered range of all the jobs where userId = &#63; and jobStatus = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not <code>QueryUtil#ALL_POS</code>), then the query will include the default ORDER BY logic from <code>JobModelImpl</code>. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	 * </p>
	 *
	 * @param userId the user ID
	 * @param jobStatus the job status
	 * @param start the lower bound of the range of jobs
	 * @param end the upper bound of the range of jobs (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @return the ordered range of matching jobs
	 */
	public static List<Job> findByJobStatus_U(
		long userId, int jobStatus, int start, int end,
		OrderByComparator<Job> orderByComparator) {

		return getPersistence().findByJobStatus_U(
			userId, jobStatus, start, end, orderByComparator);
	}

	/**
	 * Returns an ordered range of all the jobs where userId = &#63; and jobStatus = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not <code>QueryUtil#ALL_POS</code>), then the query will include the default ORDER BY logic from <code>JobModelImpl</code>. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	 * </p>
	 *
	 * @param userId the user ID
	 * @param jobStatus the job status
	 * @param start the lower bound of the range of jobs
	 * @param end the upper bound of the range of jobs (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @param retrieveFromCache whether to retrieve from the finder cache
	 * @return the ordered range of matching jobs
	 */
	public static List<Job> findByJobStatus_U(
		long userId, int jobStatus, int start, int end,
		OrderByComparator<Job> orderByComparator, boolean retrieveFromCache) {

		return getPersistence().findByJobStatus_U(
			userId, jobStatus, start, end, orderByComparator,
			retrieveFromCache);
	}

	/**
	 * Returns the first job in the ordered set where userId = &#63; and jobStatus = &#63;.
	 *
	 * @param userId the user ID
	 * @param jobStatus the job status
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching job
	 * @throws NoSuchJobException if a matching job could not be found
	 */
	public static Job findByJobStatus_U_First(
			long userId, int jobStatus,
			OrderByComparator<Job> orderByComparator)
		throws com.osp.icebreaker.exception.NoSuchJobException {

		return getPersistence().findByJobStatus_U_First(
			userId, jobStatus, orderByComparator);
	}

	/**
	 * Returns the first job in the ordered set where userId = &#63; and jobStatus = &#63;.
	 *
	 * @param userId the user ID
	 * @param jobStatus the job status
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching job, or <code>null</code> if a matching job could not be found
	 */
	public static Job fetchByJobStatus_U_First(
		long userId, int jobStatus, OrderByComparator<Job> orderByComparator) {

		return getPersistence().fetchByJobStatus_U_First(
			userId, jobStatus, orderByComparator);
	}

	/**
	 * Returns the last job in the ordered set where userId = &#63; and jobStatus = &#63;.
	 *
	 * @param userId the user ID
	 * @param jobStatus the job status
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching job
	 * @throws NoSuchJobException if a matching job could not be found
	 */
	public static Job findByJobStatus_U_Last(
			long userId, int jobStatus,
			OrderByComparator<Job> orderByComparator)
		throws com.osp.icebreaker.exception.NoSuchJobException {

		return getPersistence().findByJobStatus_U_Last(
			userId, jobStatus, orderByComparator);
	}

	/**
	 * Returns the last job in the ordered set where userId = &#63; and jobStatus = &#63;.
	 *
	 * @param userId the user ID
	 * @param jobStatus the job status
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching job, or <code>null</code> if a matching job could not be found
	 */
	public static Job fetchByJobStatus_U_Last(
		long userId, int jobStatus, OrderByComparator<Job> orderByComparator) {

		return getPersistence().fetchByJobStatus_U_Last(
			userId, jobStatus, orderByComparator);
	}

	/**
	 * Returns the jobs before and after the current job in the ordered set where userId = &#63; and jobStatus = &#63;.
	 *
	 * @param jobId the primary key of the current job
	 * @param userId the user ID
	 * @param jobStatus the job status
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the previous, current, and next job
	 * @throws NoSuchJobException if a job with the primary key could not be found
	 */
	public static Job[] findByJobStatus_U_PrevAndNext(
			long jobId, long userId, int jobStatus,
			OrderByComparator<Job> orderByComparator)
		throws com.osp.icebreaker.exception.NoSuchJobException {

		return getPersistence().findByJobStatus_U_PrevAndNext(
			jobId, userId, jobStatus, orderByComparator);
	}

	/**
	 * Removes all the jobs where userId = &#63; and jobStatus = &#63; from the database.
	 *
	 * @param userId the user ID
	 * @param jobStatus the job status
	 */
	public static void removeByJobStatus_U(long userId, int jobStatus) {
		getPersistence().removeByJobStatus_U(userId, jobStatus);
	}

	/**
	 * Returns the number of jobs where userId = &#63; and jobStatus = &#63;.
	 *
	 * @param userId the user ID
	 * @param jobStatus the job status
	 * @return the number of matching jobs
	 */
	public static int countByJobStatus_U(long userId, int jobStatus) {
		return getPersistence().countByJobStatus_U(userId, jobStatus);
	}

	/**
	 * Returns all the jobs where groupId = &#63; and userId = &#63; and jobStatus = &#63;.
	 *
	 * @param groupId the group ID
	 * @param userId the user ID
	 * @param jobStatus the job status
	 * @return the matching jobs
	 */
	public static List<Job> findByJobStatus_G_U(
		long groupId, long userId, int jobStatus) {

		return getPersistence().findByJobStatus_G_U(groupId, userId, jobStatus);
	}

	/**
	 * Returns a range of all the jobs where groupId = &#63; and userId = &#63; and jobStatus = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not <code>QueryUtil#ALL_POS</code>), then the query will include the default ORDER BY logic from <code>JobModelImpl</code>. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	 * </p>
	 *
	 * @param groupId the group ID
	 * @param userId the user ID
	 * @param jobStatus the job status
	 * @param start the lower bound of the range of jobs
	 * @param end the upper bound of the range of jobs (not inclusive)
	 * @return the range of matching jobs
	 */
	public static List<Job> findByJobStatus_G_U(
		long groupId, long userId, int jobStatus, int start, int end) {

		return getPersistence().findByJobStatus_G_U(
			groupId, userId, jobStatus, start, end);
	}

	/**
	 * Returns an ordered range of all the jobs where groupId = &#63; and userId = &#63; and jobStatus = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not <code>QueryUtil#ALL_POS</code>), then the query will include the default ORDER BY logic from <code>JobModelImpl</code>. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	 * </p>
	 *
	 * @param groupId the group ID
	 * @param userId the user ID
	 * @param jobStatus the job status
	 * @param start the lower bound of the range of jobs
	 * @param end the upper bound of the range of jobs (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @return the ordered range of matching jobs
	 */
	public static List<Job> findByJobStatus_G_U(
		long groupId, long userId, int jobStatus, int start, int end,
		OrderByComparator<Job> orderByComparator) {

		return getPersistence().findByJobStatus_G_U(
			groupId, userId, jobStatus, start, end, orderByComparator);
	}

	/**
	 * Returns an ordered range of all the jobs where groupId = &#63; and userId = &#63; and jobStatus = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not <code>QueryUtil#ALL_POS</code>), then the query will include the default ORDER BY logic from <code>JobModelImpl</code>. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	 * </p>
	 *
	 * @param groupId the group ID
	 * @param userId the user ID
	 * @param jobStatus the job status
	 * @param start the lower bound of the range of jobs
	 * @param end the upper bound of the range of jobs (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @param retrieveFromCache whether to retrieve from the finder cache
	 * @return the ordered range of matching jobs
	 */
	public static List<Job> findByJobStatus_G_U(
		long groupId, long userId, int jobStatus, int start, int end,
		OrderByComparator<Job> orderByComparator, boolean retrieveFromCache) {

		return getPersistence().findByJobStatus_G_U(
			groupId, userId, jobStatus, start, end, orderByComparator,
			retrieveFromCache);
	}

	/**
	 * Returns the first job in the ordered set where groupId = &#63; and userId = &#63; and jobStatus = &#63;.
	 *
	 * @param groupId the group ID
	 * @param userId the user ID
	 * @param jobStatus the job status
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching job
	 * @throws NoSuchJobException if a matching job could not be found
	 */
	public static Job findByJobStatus_G_U_First(
			long groupId, long userId, int jobStatus,
			OrderByComparator<Job> orderByComparator)
		throws com.osp.icebreaker.exception.NoSuchJobException {

		return getPersistence().findByJobStatus_G_U_First(
			groupId, userId, jobStatus, orderByComparator);
	}

	/**
	 * Returns the first job in the ordered set where groupId = &#63; and userId = &#63; and jobStatus = &#63;.
	 *
	 * @param groupId the group ID
	 * @param userId the user ID
	 * @param jobStatus the job status
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching job, or <code>null</code> if a matching job could not be found
	 */
	public static Job fetchByJobStatus_G_U_First(
		long groupId, long userId, int jobStatus,
		OrderByComparator<Job> orderByComparator) {

		return getPersistence().fetchByJobStatus_G_U_First(
			groupId, userId, jobStatus, orderByComparator);
	}

	/**
	 * Returns the last job in the ordered set where groupId = &#63; and userId = &#63; and jobStatus = &#63;.
	 *
	 * @param groupId the group ID
	 * @param userId the user ID
	 * @param jobStatus the job status
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching job
	 * @throws NoSuchJobException if a matching job could not be found
	 */
	public static Job findByJobStatus_G_U_Last(
			long groupId, long userId, int jobStatus,
			OrderByComparator<Job> orderByComparator)
		throws com.osp.icebreaker.exception.NoSuchJobException {

		return getPersistence().findByJobStatus_G_U_Last(
			groupId, userId, jobStatus, orderByComparator);
	}

	/**
	 * Returns the last job in the ordered set where groupId = &#63; and userId = &#63; and jobStatus = &#63;.
	 *
	 * @param groupId the group ID
	 * @param userId the user ID
	 * @param jobStatus the job status
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching job, or <code>null</code> if a matching job could not be found
	 */
	public static Job fetchByJobStatus_G_U_Last(
		long groupId, long userId, int jobStatus,
		OrderByComparator<Job> orderByComparator) {

		return getPersistence().fetchByJobStatus_G_U_Last(
			groupId, userId, jobStatus, orderByComparator);
	}

	/**
	 * Returns the jobs before and after the current job in the ordered set where groupId = &#63; and userId = &#63; and jobStatus = &#63;.
	 *
	 * @param jobId the primary key of the current job
	 * @param groupId the group ID
	 * @param userId the user ID
	 * @param jobStatus the job status
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the previous, current, and next job
	 * @throws NoSuchJobException if a job with the primary key could not be found
	 */
	public static Job[] findByJobStatus_G_U_PrevAndNext(
			long jobId, long groupId, long userId, int jobStatus,
			OrderByComparator<Job> orderByComparator)
		throws com.osp.icebreaker.exception.NoSuchJobException {

		return getPersistence().findByJobStatus_G_U_PrevAndNext(
			jobId, groupId, userId, jobStatus, orderByComparator);
	}

	/**
	 * Removes all the jobs where groupId = &#63; and userId = &#63; and jobStatus = &#63; from the database.
	 *
	 * @param groupId the group ID
	 * @param userId the user ID
	 * @param jobStatus the job status
	 */
	public static void removeByJobStatus_G_U(
		long groupId, long userId, int jobStatus) {

		getPersistence().removeByJobStatus_G_U(groupId, userId, jobStatus);
	}

	/**
	 * Returns the number of jobs where groupId = &#63; and userId = &#63; and jobStatus = &#63;.
	 *
	 * @param groupId the group ID
	 * @param userId the user ID
	 * @param jobStatus the job status
	 * @return the number of matching jobs
	 */
	public static int countByJobStatus_G_U(
		long groupId, long userId, int jobStatus) {

		return getPersistence().countByJobStatus_G_U(
			groupId, userId, jobStatus);
	}

	/**
	 * Returns all the jobs where title LIKE &#63;.
	 *
	 * @param title the title
	 * @return the matching jobs
	 */
	public static List<Job> findByTitle(String title) {
		return getPersistence().findByTitle(title);
	}

	/**
	 * Returns a range of all the jobs where title LIKE &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not <code>QueryUtil#ALL_POS</code>), then the query will include the default ORDER BY logic from <code>JobModelImpl</code>. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	 * </p>
	 *
	 * @param title the title
	 * @param start the lower bound of the range of jobs
	 * @param end the upper bound of the range of jobs (not inclusive)
	 * @return the range of matching jobs
	 */
	public static List<Job> findByTitle(String title, int start, int end) {
		return getPersistence().findByTitle(title, start, end);
	}

	/**
	 * Returns an ordered range of all the jobs where title LIKE &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not <code>QueryUtil#ALL_POS</code>), then the query will include the default ORDER BY logic from <code>JobModelImpl</code>. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	 * </p>
	 *
	 * @param title the title
	 * @param start the lower bound of the range of jobs
	 * @param end the upper bound of the range of jobs (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @return the ordered range of matching jobs
	 */
	public static List<Job> findByTitle(
		String title, int start, int end,
		OrderByComparator<Job> orderByComparator) {

		return getPersistence().findByTitle(
			title, start, end, orderByComparator);
	}

	/**
	 * Returns an ordered range of all the jobs where title LIKE &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not <code>QueryUtil#ALL_POS</code>), then the query will include the default ORDER BY logic from <code>JobModelImpl</code>. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	 * </p>
	 *
	 * @param title the title
	 * @param start the lower bound of the range of jobs
	 * @param end the upper bound of the range of jobs (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @param retrieveFromCache whether to retrieve from the finder cache
	 * @return the ordered range of matching jobs
	 */
	public static List<Job> findByTitle(
		String title, int start, int end,
		OrderByComparator<Job> orderByComparator, boolean retrieveFromCache) {

		return getPersistence().findByTitle(
			title, start, end, orderByComparator, retrieveFromCache);
	}

	/**
	 * Returns the first job in the ordered set where title LIKE &#63;.
	 *
	 * @param title the title
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching job
	 * @throws NoSuchJobException if a matching job could not be found
	 */
	public static Job findByTitle_First(
			String title, OrderByComparator<Job> orderByComparator)
		throws com.osp.icebreaker.exception.NoSuchJobException {

		return getPersistence().findByTitle_First(title, orderByComparator);
	}

	/**
	 * Returns the first job in the ordered set where title LIKE &#63;.
	 *
	 * @param title the title
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching job, or <code>null</code> if a matching job could not be found
	 */
	public static Job fetchByTitle_First(
		String title, OrderByComparator<Job> orderByComparator) {

		return getPersistence().fetchByTitle_First(title, orderByComparator);
	}

	/**
	 * Returns the last job in the ordered set where title LIKE &#63;.
	 *
	 * @param title the title
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching job
	 * @throws NoSuchJobException if a matching job could not be found
	 */
	public static Job findByTitle_Last(
			String title, OrderByComparator<Job> orderByComparator)
		throws com.osp.icebreaker.exception.NoSuchJobException {

		return getPersistence().findByTitle_Last(title, orderByComparator);
	}

	/**
	 * Returns the last job in the ordered set where title LIKE &#63;.
	 *
	 * @param title the title
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching job, or <code>null</code> if a matching job could not be found
	 */
	public static Job fetchByTitle_Last(
		String title, OrderByComparator<Job> orderByComparator) {

		return getPersistence().fetchByTitle_Last(title, orderByComparator);
	}

	/**
	 * Returns the jobs before and after the current job in the ordered set where title LIKE &#63;.
	 *
	 * @param jobId the primary key of the current job
	 * @param title the title
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the previous, current, and next job
	 * @throws NoSuchJobException if a job with the primary key could not be found
	 */
	public static Job[] findByTitle_PrevAndNext(
			long jobId, String title, OrderByComparator<Job> orderByComparator)
		throws com.osp.icebreaker.exception.NoSuchJobException {

		return getPersistence().findByTitle_PrevAndNext(
			jobId, title, orderByComparator);
	}

	/**
	 * Removes all the jobs where title LIKE &#63; from the database.
	 *
	 * @param title the title
	 */
	public static void removeByTitle(String title) {
		getPersistence().removeByTitle(title);
	}

	/**
	 * Returns the number of jobs where title LIKE &#63;.
	 *
	 * @param title the title
	 * @return the number of matching jobs
	 */
	public static int countByTitle(String title) {
		return getPersistence().countByTitle(title);
	}

	/**
	 * Returns all the jobs where groupId = &#63; and title LIKE &#63;.
	 *
	 * @param groupId the group ID
	 * @param title the title
	 * @return the matching jobs
	 */
	public static List<Job> findByTitle_G(long groupId, String title) {
		return getPersistence().findByTitle_G(groupId, title);
	}

	/**
	 * Returns a range of all the jobs where groupId = &#63; and title LIKE &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not <code>QueryUtil#ALL_POS</code>), then the query will include the default ORDER BY logic from <code>JobModelImpl</code>. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	 * </p>
	 *
	 * @param groupId the group ID
	 * @param title the title
	 * @param start the lower bound of the range of jobs
	 * @param end the upper bound of the range of jobs (not inclusive)
	 * @return the range of matching jobs
	 */
	public static List<Job> findByTitle_G(
		long groupId, String title, int start, int end) {

		return getPersistence().findByTitle_G(groupId, title, start, end);
	}

	/**
	 * Returns an ordered range of all the jobs where groupId = &#63; and title LIKE &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not <code>QueryUtil#ALL_POS</code>), then the query will include the default ORDER BY logic from <code>JobModelImpl</code>. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	 * </p>
	 *
	 * @param groupId the group ID
	 * @param title the title
	 * @param start the lower bound of the range of jobs
	 * @param end the upper bound of the range of jobs (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @return the ordered range of matching jobs
	 */
	public static List<Job> findByTitle_G(
		long groupId, String title, int start, int end,
		OrderByComparator<Job> orderByComparator) {

		return getPersistence().findByTitle_G(
			groupId, title, start, end, orderByComparator);
	}

	/**
	 * Returns an ordered range of all the jobs where groupId = &#63; and title LIKE &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not <code>QueryUtil#ALL_POS</code>), then the query will include the default ORDER BY logic from <code>JobModelImpl</code>. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	 * </p>
	 *
	 * @param groupId the group ID
	 * @param title the title
	 * @param start the lower bound of the range of jobs
	 * @param end the upper bound of the range of jobs (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @param retrieveFromCache whether to retrieve from the finder cache
	 * @return the ordered range of matching jobs
	 */
	public static List<Job> findByTitle_G(
		long groupId, String title, int start, int end,
		OrderByComparator<Job> orderByComparator, boolean retrieveFromCache) {

		return getPersistence().findByTitle_G(
			groupId, title, start, end, orderByComparator, retrieveFromCache);
	}

	/**
	 * Returns the first job in the ordered set where groupId = &#63; and title LIKE &#63;.
	 *
	 * @param groupId the group ID
	 * @param title the title
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching job
	 * @throws NoSuchJobException if a matching job could not be found
	 */
	public static Job findByTitle_G_First(
			long groupId, String title,
			OrderByComparator<Job> orderByComparator)
		throws com.osp.icebreaker.exception.NoSuchJobException {

		return getPersistence().findByTitle_G_First(
			groupId, title, orderByComparator);
	}

	/**
	 * Returns the first job in the ordered set where groupId = &#63; and title LIKE &#63;.
	 *
	 * @param groupId the group ID
	 * @param title the title
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching job, or <code>null</code> if a matching job could not be found
	 */
	public static Job fetchByTitle_G_First(
		long groupId, String title, OrderByComparator<Job> orderByComparator) {

		return getPersistence().fetchByTitle_G_First(
			groupId, title, orderByComparator);
	}

	/**
	 * Returns the last job in the ordered set where groupId = &#63; and title LIKE &#63;.
	 *
	 * @param groupId the group ID
	 * @param title the title
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching job
	 * @throws NoSuchJobException if a matching job could not be found
	 */
	public static Job findByTitle_G_Last(
			long groupId, String title,
			OrderByComparator<Job> orderByComparator)
		throws com.osp.icebreaker.exception.NoSuchJobException {

		return getPersistence().findByTitle_G_Last(
			groupId, title, orderByComparator);
	}

	/**
	 * Returns the last job in the ordered set where groupId = &#63; and title LIKE &#63;.
	 *
	 * @param groupId the group ID
	 * @param title the title
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching job, or <code>null</code> if a matching job could not be found
	 */
	public static Job fetchByTitle_G_Last(
		long groupId, String title, OrderByComparator<Job> orderByComparator) {

		return getPersistence().fetchByTitle_G_Last(
			groupId, title, orderByComparator);
	}

	/**
	 * Returns the jobs before and after the current job in the ordered set where groupId = &#63; and title LIKE &#63;.
	 *
	 * @param jobId the primary key of the current job
	 * @param groupId the group ID
	 * @param title the title
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the previous, current, and next job
	 * @throws NoSuchJobException if a job with the primary key could not be found
	 */
	public static Job[] findByTitle_G_PrevAndNext(
			long jobId, long groupId, String title,
			OrderByComparator<Job> orderByComparator)
		throws com.osp.icebreaker.exception.NoSuchJobException {

		return getPersistence().findByTitle_G_PrevAndNext(
			jobId, groupId, title, orderByComparator);
	}

	/**
	 * Removes all the jobs where groupId = &#63; and title LIKE &#63; from the database.
	 *
	 * @param groupId the group ID
	 * @param title the title
	 */
	public static void removeByTitle_G(long groupId, String title) {
		getPersistence().removeByTitle_G(groupId, title);
	}

	/**
	 * Returns the number of jobs where groupId = &#63; and title LIKE &#63;.
	 *
	 * @param groupId the group ID
	 * @param title the title
	 * @return the number of matching jobs
	 */
	public static int countByTitle_G(long groupId, String title) {
		return getPersistence().countByTitle_G(groupId, title);
	}

	/**
	 * Returns all the jobs where userId = &#63; and title LIKE &#63;.
	 *
	 * @param userId the user ID
	 * @param title the title
	 * @return the matching jobs
	 */
	public static List<Job> findByTitle_U(long userId, String title) {
		return getPersistence().findByTitle_U(userId, title);
	}

	/**
	 * Returns a range of all the jobs where userId = &#63; and title LIKE &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not <code>QueryUtil#ALL_POS</code>), then the query will include the default ORDER BY logic from <code>JobModelImpl</code>. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	 * </p>
	 *
	 * @param userId the user ID
	 * @param title the title
	 * @param start the lower bound of the range of jobs
	 * @param end the upper bound of the range of jobs (not inclusive)
	 * @return the range of matching jobs
	 */
	public static List<Job> findByTitle_U(
		long userId, String title, int start, int end) {

		return getPersistence().findByTitle_U(userId, title, start, end);
	}

	/**
	 * Returns an ordered range of all the jobs where userId = &#63; and title LIKE &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not <code>QueryUtil#ALL_POS</code>), then the query will include the default ORDER BY logic from <code>JobModelImpl</code>. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	 * </p>
	 *
	 * @param userId the user ID
	 * @param title the title
	 * @param start the lower bound of the range of jobs
	 * @param end the upper bound of the range of jobs (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @return the ordered range of matching jobs
	 */
	public static List<Job> findByTitle_U(
		long userId, String title, int start, int end,
		OrderByComparator<Job> orderByComparator) {

		return getPersistence().findByTitle_U(
			userId, title, start, end, orderByComparator);
	}

	/**
	 * Returns an ordered range of all the jobs where userId = &#63; and title LIKE &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not <code>QueryUtil#ALL_POS</code>), then the query will include the default ORDER BY logic from <code>JobModelImpl</code>. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	 * </p>
	 *
	 * @param userId the user ID
	 * @param title the title
	 * @param start the lower bound of the range of jobs
	 * @param end the upper bound of the range of jobs (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @param retrieveFromCache whether to retrieve from the finder cache
	 * @return the ordered range of matching jobs
	 */
	public static List<Job> findByTitle_U(
		long userId, String title, int start, int end,
		OrderByComparator<Job> orderByComparator, boolean retrieveFromCache) {

		return getPersistence().findByTitle_U(
			userId, title, start, end, orderByComparator, retrieveFromCache);
	}

	/**
	 * Returns the first job in the ordered set where userId = &#63; and title LIKE &#63;.
	 *
	 * @param userId the user ID
	 * @param title the title
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching job
	 * @throws NoSuchJobException if a matching job could not be found
	 */
	public static Job findByTitle_U_First(
			long userId, String title, OrderByComparator<Job> orderByComparator)
		throws com.osp.icebreaker.exception.NoSuchJobException {

		return getPersistence().findByTitle_U_First(
			userId, title, orderByComparator);
	}

	/**
	 * Returns the first job in the ordered set where userId = &#63; and title LIKE &#63;.
	 *
	 * @param userId the user ID
	 * @param title the title
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching job, or <code>null</code> if a matching job could not be found
	 */
	public static Job fetchByTitle_U_First(
		long userId, String title, OrderByComparator<Job> orderByComparator) {

		return getPersistence().fetchByTitle_U_First(
			userId, title, orderByComparator);
	}

	/**
	 * Returns the last job in the ordered set where userId = &#63; and title LIKE &#63;.
	 *
	 * @param userId the user ID
	 * @param title the title
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching job
	 * @throws NoSuchJobException if a matching job could not be found
	 */
	public static Job findByTitle_U_Last(
			long userId, String title, OrderByComparator<Job> orderByComparator)
		throws com.osp.icebreaker.exception.NoSuchJobException {

		return getPersistence().findByTitle_U_Last(
			userId, title, orderByComparator);
	}

	/**
	 * Returns the last job in the ordered set where userId = &#63; and title LIKE &#63;.
	 *
	 * @param userId the user ID
	 * @param title the title
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching job, or <code>null</code> if a matching job could not be found
	 */
	public static Job fetchByTitle_U_Last(
		long userId, String title, OrderByComparator<Job> orderByComparator) {

		return getPersistence().fetchByTitle_U_Last(
			userId, title, orderByComparator);
	}

	/**
	 * Returns the jobs before and after the current job in the ordered set where userId = &#63; and title LIKE &#63;.
	 *
	 * @param jobId the primary key of the current job
	 * @param userId the user ID
	 * @param title the title
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the previous, current, and next job
	 * @throws NoSuchJobException if a job with the primary key could not be found
	 */
	public static Job[] findByTitle_U_PrevAndNext(
			long jobId, long userId, String title,
			OrderByComparator<Job> orderByComparator)
		throws com.osp.icebreaker.exception.NoSuchJobException {

		return getPersistence().findByTitle_U_PrevAndNext(
			jobId, userId, title, orderByComparator);
	}

	/**
	 * Removes all the jobs where userId = &#63; and title LIKE &#63; from the database.
	 *
	 * @param userId the user ID
	 * @param title the title
	 */
	public static void removeByTitle_U(long userId, String title) {
		getPersistence().removeByTitle_U(userId, title);
	}

	/**
	 * Returns the number of jobs where userId = &#63; and title LIKE &#63;.
	 *
	 * @param userId the user ID
	 * @param title the title
	 * @return the number of matching jobs
	 */
	public static int countByTitle_U(long userId, String title) {
		return getPersistence().countByTitle_U(userId, title);
	}

	/**
	 * Returns all the jobs where groupId = &#63; and userId = &#63; and title LIKE &#63;.
	 *
	 * @param groupId the group ID
	 * @param userId the user ID
	 * @param title the title
	 * @return the matching jobs
	 */
	public static List<Job> findByTitle_G_U(
		long groupId, long userId, String title) {

		return getPersistence().findByTitle_G_U(groupId, userId, title);
	}

	/**
	 * Returns a range of all the jobs where groupId = &#63; and userId = &#63; and title LIKE &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not <code>QueryUtil#ALL_POS</code>), then the query will include the default ORDER BY logic from <code>JobModelImpl</code>. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	 * </p>
	 *
	 * @param groupId the group ID
	 * @param userId the user ID
	 * @param title the title
	 * @param start the lower bound of the range of jobs
	 * @param end the upper bound of the range of jobs (not inclusive)
	 * @return the range of matching jobs
	 */
	public static List<Job> findByTitle_G_U(
		long groupId, long userId, String title, int start, int end) {

		return getPersistence().findByTitle_G_U(
			groupId, userId, title, start, end);
	}

	/**
	 * Returns an ordered range of all the jobs where groupId = &#63; and userId = &#63; and title LIKE &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not <code>QueryUtil#ALL_POS</code>), then the query will include the default ORDER BY logic from <code>JobModelImpl</code>. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	 * </p>
	 *
	 * @param groupId the group ID
	 * @param userId the user ID
	 * @param title the title
	 * @param start the lower bound of the range of jobs
	 * @param end the upper bound of the range of jobs (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @return the ordered range of matching jobs
	 */
	public static List<Job> findByTitle_G_U(
		long groupId, long userId, String title, int start, int end,
		OrderByComparator<Job> orderByComparator) {

		return getPersistence().findByTitle_G_U(
			groupId, userId, title, start, end, orderByComparator);
	}

	/**
	 * Returns an ordered range of all the jobs where groupId = &#63; and userId = &#63; and title LIKE &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not <code>QueryUtil#ALL_POS</code>), then the query will include the default ORDER BY logic from <code>JobModelImpl</code>. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	 * </p>
	 *
	 * @param groupId the group ID
	 * @param userId the user ID
	 * @param title the title
	 * @param start the lower bound of the range of jobs
	 * @param end the upper bound of the range of jobs (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @param retrieveFromCache whether to retrieve from the finder cache
	 * @return the ordered range of matching jobs
	 */
	public static List<Job> findByTitle_G_U(
		long groupId, long userId, String title, int start, int end,
		OrderByComparator<Job> orderByComparator, boolean retrieveFromCache) {

		return getPersistence().findByTitle_G_U(
			groupId, userId, title, start, end, orderByComparator,
			retrieveFromCache);
	}

	/**
	 * Returns the first job in the ordered set where groupId = &#63; and userId = &#63; and title LIKE &#63;.
	 *
	 * @param groupId the group ID
	 * @param userId the user ID
	 * @param title the title
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching job
	 * @throws NoSuchJobException if a matching job could not be found
	 */
	public static Job findByTitle_G_U_First(
			long groupId, long userId, String title,
			OrderByComparator<Job> orderByComparator)
		throws com.osp.icebreaker.exception.NoSuchJobException {

		return getPersistence().findByTitle_G_U_First(
			groupId, userId, title, orderByComparator);
	}

	/**
	 * Returns the first job in the ordered set where groupId = &#63; and userId = &#63; and title LIKE &#63;.
	 *
	 * @param groupId the group ID
	 * @param userId the user ID
	 * @param title the title
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching job, or <code>null</code> if a matching job could not be found
	 */
	public static Job fetchByTitle_G_U_First(
		long groupId, long userId, String title,
		OrderByComparator<Job> orderByComparator) {

		return getPersistence().fetchByTitle_G_U_First(
			groupId, userId, title, orderByComparator);
	}

	/**
	 * Returns the last job in the ordered set where groupId = &#63; and userId = &#63; and title LIKE &#63;.
	 *
	 * @param groupId the group ID
	 * @param userId the user ID
	 * @param title the title
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching job
	 * @throws NoSuchJobException if a matching job could not be found
	 */
	public static Job findByTitle_G_U_Last(
			long groupId, long userId, String title,
			OrderByComparator<Job> orderByComparator)
		throws com.osp.icebreaker.exception.NoSuchJobException {

		return getPersistence().findByTitle_G_U_Last(
			groupId, userId, title, orderByComparator);
	}

	/**
	 * Returns the last job in the ordered set where groupId = &#63; and userId = &#63; and title LIKE &#63;.
	 *
	 * @param groupId the group ID
	 * @param userId the user ID
	 * @param title the title
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching job, or <code>null</code> if a matching job could not be found
	 */
	public static Job fetchByTitle_G_U_Last(
		long groupId, long userId, String title,
		OrderByComparator<Job> orderByComparator) {

		return getPersistence().fetchByTitle_G_U_Last(
			groupId, userId, title, orderByComparator);
	}

	/**
	 * Returns the jobs before and after the current job in the ordered set where groupId = &#63; and userId = &#63; and title LIKE &#63;.
	 *
	 * @param jobId the primary key of the current job
	 * @param groupId the group ID
	 * @param userId the user ID
	 * @param title the title
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the previous, current, and next job
	 * @throws NoSuchJobException if a job with the primary key could not be found
	 */
	public static Job[] findByTitle_G_U_PrevAndNext(
			long jobId, long groupId, long userId, String title,
			OrderByComparator<Job> orderByComparator)
		throws com.osp.icebreaker.exception.NoSuchJobException {

		return getPersistence().findByTitle_G_U_PrevAndNext(
			jobId, groupId, userId, title, orderByComparator);
	}

	/**
	 * Removes all the jobs where groupId = &#63; and userId = &#63; and title LIKE &#63; from the database.
	 *
	 * @param groupId the group ID
	 * @param userId the user ID
	 * @param title the title
	 */
	public static void removeByTitle_G_U(
		long groupId, long userId, String title) {

		getPersistence().removeByTitle_G_U(groupId, userId, title);
	}

	/**
	 * Returns the number of jobs where groupId = &#63; and userId = &#63; and title LIKE &#63;.
	 *
	 * @param groupId the group ID
	 * @param userId the user ID
	 * @param title the title
	 * @return the number of matching jobs
	 */
	public static int countByTitle_G_U(
		long groupId, long userId, String title) {

		return getPersistence().countByTitle_G_U(groupId, userId, title);
	}

	/**
	 * Returns all the jobs where clusterId = &#63;.
	 *
	 * @param clusterId the cluster ID
	 * @return the matching jobs
	 */
	public static List<Job> findByClusterId(long clusterId) {
		return getPersistence().findByClusterId(clusterId);
	}

	/**
	 * Returns a range of all the jobs where clusterId = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not <code>QueryUtil#ALL_POS</code>), then the query will include the default ORDER BY logic from <code>JobModelImpl</code>. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	 * </p>
	 *
	 * @param clusterId the cluster ID
	 * @param start the lower bound of the range of jobs
	 * @param end the upper bound of the range of jobs (not inclusive)
	 * @return the range of matching jobs
	 */
	public static List<Job> findByClusterId(
		long clusterId, int start, int end) {

		return getPersistence().findByClusterId(clusterId, start, end);
	}

	/**
	 * Returns an ordered range of all the jobs where clusterId = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not <code>QueryUtil#ALL_POS</code>), then the query will include the default ORDER BY logic from <code>JobModelImpl</code>. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	 * </p>
	 *
	 * @param clusterId the cluster ID
	 * @param start the lower bound of the range of jobs
	 * @param end the upper bound of the range of jobs (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @return the ordered range of matching jobs
	 */
	public static List<Job> findByClusterId(
		long clusterId, int start, int end,
		OrderByComparator<Job> orderByComparator) {

		return getPersistence().findByClusterId(
			clusterId, start, end, orderByComparator);
	}

	/**
	 * Returns an ordered range of all the jobs where clusterId = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not <code>QueryUtil#ALL_POS</code>), then the query will include the default ORDER BY logic from <code>JobModelImpl</code>. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	 * </p>
	 *
	 * @param clusterId the cluster ID
	 * @param start the lower bound of the range of jobs
	 * @param end the upper bound of the range of jobs (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @param retrieveFromCache whether to retrieve from the finder cache
	 * @return the ordered range of matching jobs
	 */
	public static List<Job> findByClusterId(
		long clusterId, int start, int end,
		OrderByComparator<Job> orderByComparator, boolean retrieveFromCache) {

		return getPersistence().findByClusterId(
			clusterId, start, end, orderByComparator, retrieveFromCache);
	}

	/**
	 * Returns the first job in the ordered set where clusterId = &#63;.
	 *
	 * @param clusterId the cluster ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching job
	 * @throws NoSuchJobException if a matching job could not be found
	 */
	public static Job findByClusterId_First(
			long clusterId, OrderByComparator<Job> orderByComparator)
		throws com.osp.icebreaker.exception.NoSuchJobException {

		return getPersistence().findByClusterId_First(
			clusterId, orderByComparator);
	}

	/**
	 * Returns the first job in the ordered set where clusterId = &#63;.
	 *
	 * @param clusterId the cluster ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching job, or <code>null</code> if a matching job could not be found
	 */
	public static Job fetchByClusterId_First(
		long clusterId, OrderByComparator<Job> orderByComparator) {

		return getPersistence().fetchByClusterId_First(
			clusterId, orderByComparator);
	}

	/**
	 * Returns the last job in the ordered set where clusterId = &#63;.
	 *
	 * @param clusterId the cluster ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching job
	 * @throws NoSuchJobException if a matching job could not be found
	 */
	public static Job findByClusterId_Last(
			long clusterId, OrderByComparator<Job> orderByComparator)
		throws com.osp.icebreaker.exception.NoSuchJobException {

		return getPersistence().findByClusterId_Last(
			clusterId, orderByComparator);
	}

	/**
	 * Returns the last job in the ordered set where clusterId = &#63;.
	 *
	 * @param clusterId the cluster ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching job, or <code>null</code> if a matching job could not be found
	 */
	public static Job fetchByClusterId_Last(
		long clusterId, OrderByComparator<Job> orderByComparator) {

		return getPersistence().fetchByClusterId_Last(
			clusterId, orderByComparator);
	}

	/**
	 * Returns the jobs before and after the current job in the ordered set where clusterId = &#63;.
	 *
	 * @param jobId the primary key of the current job
	 * @param clusterId the cluster ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the previous, current, and next job
	 * @throws NoSuchJobException if a job with the primary key could not be found
	 */
	public static Job[] findByClusterId_PrevAndNext(
			long jobId, long clusterId,
			OrderByComparator<Job> orderByComparator)
		throws com.osp.icebreaker.exception.NoSuchJobException {

		return getPersistence().findByClusterId_PrevAndNext(
			jobId, clusterId, orderByComparator);
	}

	/**
	 * Removes all the jobs where clusterId = &#63; from the database.
	 *
	 * @param clusterId the cluster ID
	 */
	public static void removeByClusterId(long clusterId) {
		getPersistence().removeByClusterId(clusterId);
	}

	/**
	 * Returns the number of jobs where clusterId = &#63;.
	 *
	 * @param clusterId the cluster ID
	 * @return the number of matching jobs
	 */
	public static int countByClusterId(long clusterId) {
		return getPersistence().countByClusterId(clusterId);
	}

	/**
	 * Returns all the jobs where groupId = &#63; and clusterId = &#63;.
	 *
	 * @param groupId the group ID
	 * @param clusterId the cluster ID
	 * @return the matching jobs
	 */
	public static List<Job> findByClusterId_G(long groupId, long clusterId) {
		return getPersistence().findByClusterId_G(groupId, clusterId);
	}

	/**
	 * Returns a range of all the jobs where groupId = &#63; and clusterId = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not <code>QueryUtil#ALL_POS</code>), then the query will include the default ORDER BY logic from <code>JobModelImpl</code>. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	 * </p>
	 *
	 * @param groupId the group ID
	 * @param clusterId the cluster ID
	 * @param start the lower bound of the range of jobs
	 * @param end the upper bound of the range of jobs (not inclusive)
	 * @return the range of matching jobs
	 */
	public static List<Job> findByClusterId_G(
		long groupId, long clusterId, int start, int end) {

		return getPersistence().findByClusterId_G(
			groupId, clusterId, start, end);
	}

	/**
	 * Returns an ordered range of all the jobs where groupId = &#63; and clusterId = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not <code>QueryUtil#ALL_POS</code>), then the query will include the default ORDER BY logic from <code>JobModelImpl</code>. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	 * </p>
	 *
	 * @param groupId the group ID
	 * @param clusterId the cluster ID
	 * @param start the lower bound of the range of jobs
	 * @param end the upper bound of the range of jobs (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @return the ordered range of matching jobs
	 */
	public static List<Job> findByClusterId_G(
		long groupId, long clusterId, int start, int end,
		OrderByComparator<Job> orderByComparator) {

		return getPersistence().findByClusterId_G(
			groupId, clusterId, start, end, orderByComparator);
	}

	/**
	 * Returns an ordered range of all the jobs where groupId = &#63; and clusterId = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not <code>QueryUtil#ALL_POS</code>), then the query will include the default ORDER BY logic from <code>JobModelImpl</code>. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	 * </p>
	 *
	 * @param groupId the group ID
	 * @param clusterId the cluster ID
	 * @param start the lower bound of the range of jobs
	 * @param end the upper bound of the range of jobs (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @param retrieveFromCache whether to retrieve from the finder cache
	 * @return the ordered range of matching jobs
	 */
	public static List<Job> findByClusterId_G(
		long groupId, long clusterId, int start, int end,
		OrderByComparator<Job> orderByComparator, boolean retrieveFromCache) {

		return getPersistence().findByClusterId_G(
			groupId, clusterId, start, end, orderByComparator,
			retrieveFromCache);
	}

	/**
	 * Returns the first job in the ordered set where groupId = &#63; and clusterId = &#63;.
	 *
	 * @param groupId the group ID
	 * @param clusterId the cluster ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching job
	 * @throws NoSuchJobException if a matching job could not be found
	 */
	public static Job findByClusterId_G_First(
			long groupId, long clusterId,
			OrderByComparator<Job> orderByComparator)
		throws com.osp.icebreaker.exception.NoSuchJobException {

		return getPersistence().findByClusterId_G_First(
			groupId, clusterId, orderByComparator);
	}

	/**
	 * Returns the first job in the ordered set where groupId = &#63; and clusterId = &#63;.
	 *
	 * @param groupId the group ID
	 * @param clusterId the cluster ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching job, or <code>null</code> if a matching job could not be found
	 */
	public static Job fetchByClusterId_G_First(
		long groupId, long clusterId,
		OrderByComparator<Job> orderByComparator) {

		return getPersistence().fetchByClusterId_G_First(
			groupId, clusterId, orderByComparator);
	}

	/**
	 * Returns the last job in the ordered set where groupId = &#63; and clusterId = &#63;.
	 *
	 * @param groupId the group ID
	 * @param clusterId the cluster ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching job
	 * @throws NoSuchJobException if a matching job could not be found
	 */
	public static Job findByClusterId_G_Last(
			long groupId, long clusterId,
			OrderByComparator<Job> orderByComparator)
		throws com.osp.icebreaker.exception.NoSuchJobException {

		return getPersistence().findByClusterId_G_Last(
			groupId, clusterId, orderByComparator);
	}

	/**
	 * Returns the last job in the ordered set where groupId = &#63; and clusterId = &#63;.
	 *
	 * @param groupId the group ID
	 * @param clusterId the cluster ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching job, or <code>null</code> if a matching job could not be found
	 */
	public static Job fetchByClusterId_G_Last(
		long groupId, long clusterId,
		OrderByComparator<Job> orderByComparator) {

		return getPersistence().fetchByClusterId_G_Last(
			groupId, clusterId, orderByComparator);
	}

	/**
	 * Returns the jobs before and after the current job in the ordered set where groupId = &#63; and clusterId = &#63;.
	 *
	 * @param jobId the primary key of the current job
	 * @param groupId the group ID
	 * @param clusterId the cluster ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the previous, current, and next job
	 * @throws NoSuchJobException if a job with the primary key could not be found
	 */
	public static Job[] findByClusterId_G_PrevAndNext(
			long jobId, long groupId, long clusterId,
			OrderByComparator<Job> orderByComparator)
		throws com.osp.icebreaker.exception.NoSuchJobException {

		return getPersistence().findByClusterId_G_PrevAndNext(
			jobId, groupId, clusterId, orderByComparator);
	}

	/**
	 * Removes all the jobs where groupId = &#63; and clusterId = &#63; from the database.
	 *
	 * @param groupId the group ID
	 * @param clusterId the cluster ID
	 */
	public static void removeByClusterId_G(long groupId, long clusterId) {
		getPersistence().removeByClusterId_G(groupId, clusterId);
	}

	/**
	 * Returns the number of jobs where groupId = &#63; and clusterId = &#63;.
	 *
	 * @param groupId the group ID
	 * @param clusterId the cluster ID
	 * @return the number of matching jobs
	 */
	public static int countByClusterId_G(long groupId, long clusterId) {
		return getPersistence().countByClusterId_G(groupId, clusterId);
	}

	/**
	 * Returns all the jobs where userId = &#63; and clusterId = &#63;.
	 *
	 * @param userId the user ID
	 * @param clusterId the cluster ID
	 * @return the matching jobs
	 */
	public static List<Job> findByClusterId_U(long userId, long clusterId) {
		return getPersistence().findByClusterId_U(userId, clusterId);
	}

	/**
	 * Returns a range of all the jobs where userId = &#63; and clusterId = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not <code>QueryUtil#ALL_POS</code>), then the query will include the default ORDER BY logic from <code>JobModelImpl</code>. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	 * </p>
	 *
	 * @param userId the user ID
	 * @param clusterId the cluster ID
	 * @param start the lower bound of the range of jobs
	 * @param end the upper bound of the range of jobs (not inclusive)
	 * @return the range of matching jobs
	 */
	public static List<Job> findByClusterId_U(
		long userId, long clusterId, int start, int end) {

		return getPersistence().findByClusterId_U(
			userId, clusterId, start, end);
	}

	/**
	 * Returns an ordered range of all the jobs where userId = &#63; and clusterId = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not <code>QueryUtil#ALL_POS</code>), then the query will include the default ORDER BY logic from <code>JobModelImpl</code>. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	 * </p>
	 *
	 * @param userId the user ID
	 * @param clusterId the cluster ID
	 * @param start the lower bound of the range of jobs
	 * @param end the upper bound of the range of jobs (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @return the ordered range of matching jobs
	 */
	public static List<Job> findByClusterId_U(
		long userId, long clusterId, int start, int end,
		OrderByComparator<Job> orderByComparator) {

		return getPersistence().findByClusterId_U(
			userId, clusterId, start, end, orderByComparator);
	}

	/**
	 * Returns an ordered range of all the jobs where userId = &#63; and clusterId = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not <code>QueryUtil#ALL_POS</code>), then the query will include the default ORDER BY logic from <code>JobModelImpl</code>. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	 * </p>
	 *
	 * @param userId the user ID
	 * @param clusterId the cluster ID
	 * @param start the lower bound of the range of jobs
	 * @param end the upper bound of the range of jobs (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @param retrieveFromCache whether to retrieve from the finder cache
	 * @return the ordered range of matching jobs
	 */
	public static List<Job> findByClusterId_U(
		long userId, long clusterId, int start, int end,
		OrderByComparator<Job> orderByComparator, boolean retrieveFromCache) {

		return getPersistence().findByClusterId_U(
			userId, clusterId, start, end, orderByComparator,
			retrieveFromCache);
	}

	/**
	 * Returns the first job in the ordered set where userId = &#63; and clusterId = &#63;.
	 *
	 * @param userId the user ID
	 * @param clusterId the cluster ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching job
	 * @throws NoSuchJobException if a matching job could not be found
	 */
	public static Job findByClusterId_U_First(
			long userId, long clusterId,
			OrderByComparator<Job> orderByComparator)
		throws com.osp.icebreaker.exception.NoSuchJobException {

		return getPersistence().findByClusterId_U_First(
			userId, clusterId, orderByComparator);
	}

	/**
	 * Returns the first job in the ordered set where userId = &#63; and clusterId = &#63;.
	 *
	 * @param userId the user ID
	 * @param clusterId the cluster ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching job, or <code>null</code> if a matching job could not be found
	 */
	public static Job fetchByClusterId_U_First(
		long userId, long clusterId, OrderByComparator<Job> orderByComparator) {

		return getPersistence().fetchByClusterId_U_First(
			userId, clusterId, orderByComparator);
	}

	/**
	 * Returns the last job in the ordered set where userId = &#63; and clusterId = &#63;.
	 *
	 * @param userId the user ID
	 * @param clusterId the cluster ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching job
	 * @throws NoSuchJobException if a matching job could not be found
	 */
	public static Job findByClusterId_U_Last(
			long userId, long clusterId,
			OrderByComparator<Job> orderByComparator)
		throws com.osp.icebreaker.exception.NoSuchJobException {

		return getPersistence().findByClusterId_U_Last(
			userId, clusterId, orderByComparator);
	}

	/**
	 * Returns the last job in the ordered set where userId = &#63; and clusterId = &#63;.
	 *
	 * @param userId the user ID
	 * @param clusterId the cluster ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching job, or <code>null</code> if a matching job could not be found
	 */
	public static Job fetchByClusterId_U_Last(
		long userId, long clusterId, OrderByComparator<Job> orderByComparator) {

		return getPersistence().fetchByClusterId_U_Last(
			userId, clusterId, orderByComparator);
	}

	/**
	 * Returns the jobs before and after the current job in the ordered set where userId = &#63; and clusterId = &#63;.
	 *
	 * @param jobId the primary key of the current job
	 * @param userId the user ID
	 * @param clusterId the cluster ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the previous, current, and next job
	 * @throws NoSuchJobException if a job with the primary key could not be found
	 */
	public static Job[] findByClusterId_U_PrevAndNext(
			long jobId, long userId, long clusterId,
			OrderByComparator<Job> orderByComparator)
		throws com.osp.icebreaker.exception.NoSuchJobException {

		return getPersistence().findByClusterId_U_PrevAndNext(
			jobId, userId, clusterId, orderByComparator);
	}

	/**
	 * Removes all the jobs where userId = &#63; and clusterId = &#63; from the database.
	 *
	 * @param userId the user ID
	 * @param clusterId the cluster ID
	 */
	public static void removeByClusterId_U(long userId, long clusterId) {
		getPersistence().removeByClusterId_U(userId, clusterId);
	}

	/**
	 * Returns the number of jobs where userId = &#63; and clusterId = &#63;.
	 *
	 * @param userId the user ID
	 * @param clusterId the cluster ID
	 * @return the number of matching jobs
	 */
	public static int countByClusterId_U(long userId, long clusterId) {
		return getPersistence().countByClusterId_U(userId, clusterId);
	}

	/**
	 * Returns all the jobs where groupId = &#63; and userId = &#63; and clusterId = &#63;.
	 *
	 * @param groupId the group ID
	 * @param userId the user ID
	 * @param clusterId the cluster ID
	 * @return the matching jobs
	 */
	public static List<Job> findByClusterId_G_U(
		long groupId, long userId, long clusterId) {

		return getPersistence().findByClusterId_G_U(groupId, userId, clusterId);
	}

	/**
	 * Returns a range of all the jobs where groupId = &#63; and userId = &#63; and clusterId = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not <code>QueryUtil#ALL_POS</code>), then the query will include the default ORDER BY logic from <code>JobModelImpl</code>. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	 * </p>
	 *
	 * @param groupId the group ID
	 * @param userId the user ID
	 * @param clusterId the cluster ID
	 * @param start the lower bound of the range of jobs
	 * @param end the upper bound of the range of jobs (not inclusive)
	 * @return the range of matching jobs
	 */
	public static List<Job> findByClusterId_G_U(
		long groupId, long userId, long clusterId, int start, int end) {

		return getPersistence().findByClusterId_G_U(
			groupId, userId, clusterId, start, end);
	}

	/**
	 * Returns an ordered range of all the jobs where groupId = &#63; and userId = &#63; and clusterId = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not <code>QueryUtil#ALL_POS</code>), then the query will include the default ORDER BY logic from <code>JobModelImpl</code>. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	 * </p>
	 *
	 * @param groupId the group ID
	 * @param userId the user ID
	 * @param clusterId the cluster ID
	 * @param start the lower bound of the range of jobs
	 * @param end the upper bound of the range of jobs (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @return the ordered range of matching jobs
	 */
	public static List<Job> findByClusterId_G_U(
		long groupId, long userId, long clusterId, int start, int end,
		OrderByComparator<Job> orderByComparator) {

		return getPersistence().findByClusterId_G_U(
			groupId, userId, clusterId, start, end, orderByComparator);
	}

	/**
	 * Returns an ordered range of all the jobs where groupId = &#63; and userId = &#63; and clusterId = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not <code>QueryUtil#ALL_POS</code>), then the query will include the default ORDER BY logic from <code>JobModelImpl</code>. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	 * </p>
	 *
	 * @param groupId the group ID
	 * @param userId the user ID
	 * @param clusterId the cluster ID
	 * @param start the lower bound of the range of jobs
	 * @param end the upper bound of the range of jobs (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @param retrieveFromCache whether to retrieve from the finder cache
	 * @return the ordered range of matching jobs
	 */
	public static List<Job> findByClusterId_G_U(
		long groupId, long userId, long clusterId, int start, int end,
		OrderByComparator<Job> orderByComparator, boolean retrieveFromCache) {

		return getPersistence().findByClusterId_G_U(
			groupId, userId, clusterId, start, end, orderByComparator,
			retrieveFromCache);
	}

	/**
	 * Returns the first job in the ordered set where groupId = &#63; and userId = &#63; and clusterId = &#63;.
	 *
	 * @param groupId the group ID
	 * @param userId the user ID
	 * @param clusterId the cluster ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching job
	 * @throws NoSuchJobException if a matching job could not be found
	 */
	public static Job findByClusterId_G_U_First(
			long groupId, long userId, long clusterId,
			OrderByComparator<Job> orderByComparator)
		throws com.osp.icebreaker.exception.NoSuchJobException {

		return getPersistence().findByClusterId_G_U_First(
			groupId, userId, clusterId, orderByComparator);
	}

	/**
	 * Returns the first job in the ordered set where groupId = &#63; and userId = &#63; and clusterId = &#63;.
	 *
	 * @param groupId the group ID
	 * @param userId the user ID
	 * @param clusterId the cluster ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching job, or <code>null</code> if a matching job could not be found
	 */
	public static Job fetchByClusterId_G_U_First(
		long groupId, long userId, long clusterId,
		OrderByComparator<Job> orderByComparator) {

		return getPersistence().fetchByClusterId_G_U_First(
			groupId, userId, clusterId, orderByComparator);
	}

	/**
	 * Returns the last job in the ordered set where groupId = &#63; and userId = &#63; and clusterId = &#63;.
	 *
	 * @param groupId the group ID
	 * @param userId the user ID
	 * @param clusterId the cluster ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching job
	 * @throws NoSuchJobException if a matching job could not be found
	 */
	public static Job findByClusterId_G_U_Last(
			long groupId, long userId, long clusterId,
			OrderByComparator<Job> orderByComparator)
		throws com.osp.icebreaker.exception.NoSuchJobException {

		return getPersistence().findByClusterId_G_U_Last(
			groupId, userId, clusterId, orderByComparator);
	}

	/**
	 * Returns the last job in the ordered set where groupId = &#63; and userId = &#63; and clusterId = &#63;.
	 *
	 * @param groupId the group ID
	 * @param userId the user ID
	 * @param clusterId the cluster ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching job, or <code>null</code> if a matching job could not be found
	 */
	public static Job fetchByClusterId_G_U_Last(
		long groupId, long userId, long clusterId,
		OrderByComparator<Job> orderByComparator) {

		return getPersistence().fetchByClusterId_G_U_Last(
			groupId, userId, clusterId, orderByComparator);
	}

	/**
	 * Returns the jobs before and after the current job in the ordered set where groupId = &#63; and userId = &#63; and clusterId = &#63;.
	 *
	 * @param jobId the primary key of the current job
	 * @param groupId the group ID
	 * @param userId the user ID
	 * @param clusterId the cluster ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the previous, current, and next job
	 * @throws NoSuchJobException if a job with the primary key could not be found
	 */
	public static Job[] findByClusterId_G_U_PrevAndNext(
			long jobId, long groupId, long userId, long clusterId,
			OrderByComparator<Job> orderByComparator)
		throws com.osp.icebreaker.exception.NoSuchJobException {

		return getPersistence().findByClusterId_G_U_PrevAndNext(
			jobId, groupId, userId, clusterId, orderByComparator);
	}

	/**
	 * Removes all the jobs where groupId = &#63; and userId = &#63; and clusterId = &#63; from the database.
	 *
	 * @param groupId the group ID
	 * @param userId the user ID
	 * @param clusterId the cluster ID
	 */
	public static void removeByClusterId_G_U(
		long groupId, long userId, long clusterId) {

		getPersistence().removeByClusterId_G_U(groupId, userId, clusterId);
	}

	/**
	 * Returns the number of jobs where groupId = &#63; and userId = &#63; and clusterId = &#63;.
	 *
	 * @param groupId the group ID
	 * @param userId the user ID
	 * @param clusterId the cluster ID
	 * @return the number of matching jobs
	 */
	public static int countByClusterId_G_U(
		long groupId, long userId, long clusterId) {

		return getPersistence().countByClusterId_G_U(
			groupId, userId, clusterId);
	}

	/**
	 * Returns all the jobs where runType = &#63;.
	 *
	 * @param runType the run type
	 * @return the matching jobs
	 */
	public static List<Job> findByRunType(String runType) {
		return getPersistence().findByRunType(runType);
	}

	/**
	 * Returns a range of all the jobs where runType = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not <code>QueryUtil#ALL_POS</code>), then the query will include the default ORDER BY logic from <code>JobModelImpl</code>. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	 * </p>
	 *
	 * @param runType the run type
	 * @param start the lower bound of the range of jobs
	 * @param end the upper bound of the range of jobs (not inclusive)
	 * @return the range of matching jobs
	 */
	public static List<Job> findByRunType(String runType, int start, int end) {
		return getPersistence().findByRunType(runType, start, end);
	}

	/**
	 * Returns an ordered range of all the jobs where runType = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not <code>QueryUtil#ALL_POS</code>), then the query will include the default ORDER BY logic from <code>JobModelImpl</code>. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	 * </p>
	 *
	 * @param runType the run type
	 * @param start the lower bound of the range of jobs
	 * @param end the upper bound of the range of jobs (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @return the ordered range of matching jobs
	 */
	public static List<Job> findByRunType(
		String runType, int start, int end,
		OrderByComparator<Job> orderByComparator) {

		return getPersistence().findByRunType(
			runType, start, end, orderByComparator);
	}

	/**
	 * Returns an ordered range of all the jobs where runType = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not <code>QueryUtil#ALL_POS</code>), then the query will include the default ORDER BY logic from <code>JobModelImpl</code>. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	 * </p>
	 *
	 * @param runType the run type
	 * @param start the lower bound of the range of jobs
	 * @param end the upper bound of the range of jobs (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @param retrieveFromCache whether to retrieve from the finder cache
	 * @return the ordered range of matching jobs
	 */
	public static List<Job> findByRunType(
		String runType, int start, int end,
		OrderByComparator<Job> orderByComparator, boolean retrieveFromCache) {

		return getPersistence().findByRunType(
			runType, start, end, orderByComparator, retrieveFromCache);
	}

	/**
	 * Returns the first job in the ordered set where runType = &#63;.
	 *
	 * @param runType the run type
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching job
	 * @throws NoSuchJobException if a matching job could not be found
	 */
	public static Job findByRunType_First(
			String runType, OrderByComparator<Job> orderByComparator)
		throws com.osp.icebreaker.exception.NoSuchJobException {

		return getPersistence().findByRunType_First(runType, orderByComparator);
	}

	/**
	 * Returns the first job in the ordered set where runType = &#63;.
	 *
	 * @param runType the run type
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching job, or <code>null</code> if a matching job could not be found
	 */
	public static Job fetchByRunType_First(
		String runType, OrderByComparator<Job> orderByComparator) {

		return getPersistence().fetchByRunType_First(
			runType, orderByComparator);
	}

	/**
	 * Returns the last job in the ordered set where runType = &#63;.
	 *
	 * @param runType the run type
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching job
	 * @throws NoSuchJobException if a matching job could not be found
	 */
	public static Job findByRunType_Last(
			String runType, OrderByComparator<Job> orderByComparator)
		throws com.osp.icebreaker.exception.NoSuchJobException {

		return getPersistence().findByRunType_Last(runType, orderByComparator);
	}

	/**
	 * Returns the last job in the ordered set where runType = &#63;.
	 *
	 * @param runType the run type
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching job, or <code>null</code> if a matching job could not be found
	 */
	public static Job fetchByRunType_Last(
		String runType, OrderByComparator<Job> orderByComparator) {

		return getPersistence().fetchByRunType_Last(runType, orderByComparator);
	}

	/**
	 * Returns the jobs before and after the current job in the ordered set where runType = &#63;.
	 *
	 * @param jobId the primary key of the current job
	 * @param runType the run type
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the previous, current, and next job
	 * @throws NoSuchJobException if a job with the primary key could not be found
	 */
	public static Job[] findByRunType_PrevAndNext(
			long jobId, String runType,
			OrderByComparator<Job> orderByComparator)
		throws com.osp.icebreaker.exception.NoSuchJobException {

		return getPersistence().findByRunType_PrevAndNext(
			jobId, runType, orderByComparator);
	}

	/**
	 * Removes all the jobs where runType = &#63; from the database.
	 *
	 * @param runType the run type
	 */
	public static void removeByRunType(String runType) {
		getPersistence().removeByRunType(runType);
	}

	/**
	 * Returns the number of jobs where runType = &#63;.
	 *
	 * @param runType the run type
	 * @return the number of matching jobs
	 */
	public static int countByRunType(String runType) {
		return getPersistence().countByRunType(runType);
	}

	/**
	 * Returns all the jobs where groupId = &#63; and runType = &#63;.
	 *
	 * @param groupId the group ID
	 * @param runType the run type
	 * @return the matching jobs
	 */
	public static List<Job> findByRunType_G(long groupId, String runType) {
		return getPersistence().findByRunType_G(groupId, runType);
	}

	/**
	 * Returns a range of all the jobs where groupId = &#63; and runType = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not <code>QueryUtil#ALL_POS</code>), then the query will include the default ORDER BY logic from <code>JobModelImpl</code>. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	 * </p>
	 *
	 * @param groupId the group ID
	 * @param runType the run type
	 * @param start the lower bound of the range of jobs
	 * @param end the upper bound of the range of jobs (not inclusive)
	 * @return the range of matching jobs
	 */
	public static List<Job> findByRunType_G(
		long groupId, String runType, int start, int end) {

		return getPersistence().findByRunType_G(groupId, runType, start, end);
	}

	/**
	 * Returns an ordered range of all the jobs where groupId = &#63; and runType = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not <code>QueryUtil#ALL_POS</code>), then the query will include the default ORDER BY logic from <code>JobModelImpl</code>. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	 * </p>
	 *
	 * @param groupId the group ID
	 * @param runType the run type
	 * @param start the lower bound of the range of jobs
	 * @param end the upper bound of the range of jobs (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @return the ordered range of matching jobs
	 */
	public static List<Job> findByRunType_G(
		long groupId, String runType, int start, int end,
		OrderByComparator<Job> orderByComparator) {

		return getPersistence().findByRunType_G(
			groupId, runType, start, end, orderByComparator);
	}

	/**
	 * Returns an ordered range of all the jobs where groupId = &#63; and runType = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not <code>QueryUtil#ALL_POS</code>), then the query will include the default ORDER BY logic from <code>JobModelImpl</code>. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	 * </p>
	 *
	 * @param groupId the group ID
	 * @param runType the run type
	 * @param start the lower bound of the range of jobs
	 * @param end the upper bound of the range of jobs (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @param retrieveFromCache whether to retrieve from the finder cache
	 * @return the ordered range of matching jobs
	 */
	public static List<Job> findByRunType_G(
		long groupId, String runType, int start, int end,
		OrderByComparator<Job> orderByComparator, boolean retrieveFromCache) {

		return getPersistence().findByRunType_G(
			groupId, runType, start, end, orderByComparator, retrieveFromCache);
	}

	/**
	 * Returns the first job in the ordered set where groupId = &#63; and runType = &#63;.
	 *
	 * @param groupId the group ID
	 * @param runType the run type
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching job
	 * @throws NoSuchJobException if a matching job could not be found
	 */
	public static Job findByRunType_G_First(
			long groupId, String runType,
			OrderByComparator<Job> orderByComparator)
		throws com.osp.icebreaker.exception.NoSuchJobException {

		return getPersistence().findByRunType_G_First(
			groupId, runType, orderByComparator);
	}

	/**
	 * Returns the first job in the ordered set where groupId = &#63; and runType = &#63;.
	 *
	 * @param groupId the group ID
	 * @param runType the run type
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching job, or <code>null</code> if a matching job could not be found
	 */
	public static Job fetchByRunType_G_First(
		long groupId, String runType,
		OrderByComparator<Job> orderByComparator) {

		return getPersistence().fetchByRunType_G_First(
			groupId, runType, orderByComparator);
	}

	/**
	 * Returns the last job in the ordered set where groupId = &#63; and runType = &#63;.
	 *
	 * @param groupId the group ID
	 * @param runType the run type
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching job
	 * @throws NoSuchJobException if a matching job could not be found
	 */
	public static Job findByRunType_G_Last(
			long groupId, String runType,
			OrderByComparator<Job> orderByComparator)
		throws com.osp.icebreaker.exception.NoSuchJobException {

		return getPersistence().findByRunType_G_Last(
			groupId, runType, orderByComparator);
	}

	/**
	 * Returns the last job in the ordered set where groupId = &#63; and runType = &#63;.
	 *
	 * @param groupId the group ID
	 * @param runType the run type
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching job, or <code>null</code> if a matching job could not be found
	 */
	public static Job fetchByRunType_G_Last(
		long groupId, String runType,
		OrderByComparator<Job> orderByComparator) {

		return getPersistence().fetchByRunType_G_Last(
			groupId, runType, orderByComparator);
	}

	/**
	 * Returns the jobs before and after the current job in the ordered set where groupId = &#63; and runType = &#63;.
	 *
	 * @param jobId the primary key of the current job
	 * @param groupId the group ID
	 * @param runType the run type
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the previous, current, and next job
	 * @throws NoSuchJobException if a job with the primary key could not be found
	 */
	public static Job[] findByRunType_G_PrevAndNext(
			long jobId, long groupId, String runType,
			OrderByComparator<Job> orderByComparator)
		throws com.osp.icebreaker.exception.NoSuchJobException {

		return getPersistence().findByRunType_G_PrevAndNext(
			jobId, groupId, runType, orderByComparator);
	}

	/**
	 * Removes all the jobs where groupId = &#63; and runType = &#63; from the database.
	 *
	 * @param groupId the group ID
	 * @param runType the run type
	 */
	public static void removeByRunType_G(long groupId, String runType) {
		getPersistence().removeByRunType_G(groupId, runType);
	}

	/**
	 * Returns the number of jobs where groupId = &#63; and runType = &#63;.
	 *
	 * @param groupId the group ID
	 * @param runType the run type
	 * @return the number of matching jobs
	 */
	public static int countByRunType_G(long groupId, String runType) {
		return getPersistence().countByRunType_G(groupId, runType);
	}

	/**
	 * Returns all the jobs where userId = &#63; and runType = &#63;.
	 *
	 * @param userId the user ID
	 * @param runType the run type
	 * @return the matching jobs
	 */
	public static List<Job> findByRunType_U(long userId, String runType) {
		return getPersistence().findByRunType_U(userId, runType);
	}

	/**
	 * Returns a range of all the jobs where userId = &#63; and runType = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not <code>QueryUtil#ALL_POS</code>), then the query will include the default ORDER BY logic from <code>JobModelImpl</code>. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	 * </p>
	 *
	 * @param userId the user ID
	 * @param runType the run type
	 * @param start the lower bound of the range of jobs
	 * @param end the upper bound of the range of jobs (not inclusive)
	 * @return the range of matching jobs
	 */
	public static List<Job> findByRunType_U(
		long userId, String runType, int start, int end) {

		return getPersistence().findByRunType_U(userId, runType, start, end);
	}

	/**
	 * Returns an ordered range of all the jobs where userId = &#63; and runType = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not <code>QueryUtil#ALL_POS</code>), then the query will include the default ORDER BY logic from <code>JobModelImpl</code>. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	 * </p>
	 *
	 * @param userId the user ID
	 * @param runType the run type
	 * @param start the lower bound of the range of jobs
	 * @param end the upper bound of the range of jobs (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @return the ordered range of matching jobs
	 */
	public static List<Job> findByRunType_U(
		long userId, String runType, int start, int end,
		OrderByComparator<Job> orderByComparator) {

		return getPersistence().findByRunType_U(
			userId, runType, start, end, orderByComparator);
	}

	/**
	 * Returns an ordered range of all the jobs where userId = &#63; and runType = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not <code>QueryUtil#ALL_POS</code>), then the query will include the default ORDER BY logic from <code>JobModelImpl</code>. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	 * </p>
	 *
	 * @param userId the user ID
	 * @param runType the run type
	 * @param start the lower bound of the range of jobs
	 * @param end the upper bound of the range of jobs (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @param retrieveFromCache whether to retrieve from the finder cache
	 * @return the ordered range of matching jobs
	 */
	public static List<Job> findByRunType_U(
		long userId, String runType, int start, int end,
		OrderByComparator<Job> orderByComparator, boolean retrieveFromCache) {

		return getPersistence().findByRunType_U(
			userId, runType, start, end, orderByComparator, retrieveFromCache);
	}

	/**
	 * Returns the first job in the ordered set where userId = &#63; and runType = &#63;.
	 *
	 * @param userId the user ID
	 * @param runType the run type
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching job
	 * @throws NoSuchJobException if a matching job could not be found
	 */
	public static Job findByRunType_U_First(
			long userId, String runType,
			OrderByComparator<Job> orderByComparator)
		throws com.osp.icebreaker.exception.NoSuchJobException {

		return getPersistence().findByRunType_U_First(
			userId, runType, orderByComparator);
	}

	/**
	 * Returns the first job in the ordered set where userId = &#63; and runType = &#63;.
	 *
	 * @param userId the user ID
	 * @param runType the run type
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching job, or <code>null</code> if a matching job could not be found
	 */
	public static Job fetchByRunType_U_First(
		long userId, String runType, OrderByComparator<Job> orderByComparator) {

		return getPersistence().fetchByRunType_U_First(
			userId, runType, orderByComparator);
	}

	/**
	 * Returns the last job in the ordered set where userId = &#63; and runType = &#63;.
	 *
	 * @param userId the user ID
	 * @param runType the run type
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching job
	 * @throws NoSuchJobException if a matching job could not be found
	 */
	public static Job findByRunType_U_Last(
			long userId, String runType,
			OrderByComparator<Job> orderByComparator)
		throws com.osp.icebreaker.exception.NoSuchJobException {

		return getPersistence().findByRunType_U_Last(
			userId, runType, orderByComparator);
	}

	/**
	 * Returns the last job in the ordered set where userId = &#63; and runType = &#63;.
	 *
	 * @param userId the user ID
	 * @param runType the run type
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching job, or <code>null</code> if a matching job could not be found
	 */
	public static Job fetchByRunType_U_Last(
		long userId, String runType, OrderByComparator<Job> orderByComparator) {

		return getPersistence().fetchByRunType_U_Last(
			userId, runType, orderByComparator);
	}

	/**
	 * Returns the jobs before and after the current job in the ordered set where userId = &#63; and runType = &#63;.
	 *
	 * @param jobId the primary key of the current job
	 * @param userId the user ID
	 * @param runType the run type
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the previous, current, and next job
	 * @throws NoSuchJobException if a job with the primary key could not be found
	 */
	public static Job[] findByRunType_U_PrevAndNext(
			long jobId, long userId, String runType,
			OrderByComparator<Job> orderByComparator)
		throws com.osp.icebreaker.exception.NoSuchJobException {

		return getPersistence().findByRunType_U_PrevAndNext(
			jobId, userId, runType, orderByComparator);
	}

	/**
	 * Removes all the jobs where userId = &#63; and runType = &#63; from the database.
	 *
	 * @param userId the user ID
	 * @param runType the run type
	 */
	public static void removeByRunType_U(long userId, String runType) {
		getPersistence().removeByRunType_U(userId, runType);
	}

	/**
	 * Returns the number of jobs where userId = &#63; and runType = &#63;.
	 *
	 * @param userId the user ID
	 * @param runType the run type
	 * @return the number of matching jobs
	 */
	public static int countByRunType_U(long userId, String runType) {
		return getPersistence().countByRunType_U(userId, runType);
	}

	/**
	 * Returns all the jobs where groupId = &#63; and userId = &#63; and runType = &#63;.
	 *
	 * @param groupId the group ID
	 * @param userId the user ID
	 * @param runType the run type
	 * @return the matching jobs
	 */
	public static List<Job> findByRunType_G_U(
		long groupId, long userId, String runType) {

		return getPersistence().findByRunType_G_U(groupId, userId, runType);
	}

	/**
	 * Returns a range of all the jobs where groupId = &#63; and userId = &#63; and runType = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not <code>QueryUtil#ALL_POS</code>), then the query will include the default ORDER BY logic from <code>JobModelImpl</code>. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	 * </p>
	 *
	 * @param groupId the group ID
	 * @param userId the user ID
	 * @param runType the run type
	 * @param start the lower bound of the range of jobs
	 * @param end the upper bound of the range of jobs (not inclusive)
	 * @return the range of matching jobs
	 */
	public static List<Job> findByRunType_G_U(
		long groupId, long userId, String runType, int start, int end) {

		return getPersistence().findByRunType_G_U(
			groupId, userId, runType, start, end);
	}

	/**
	 * Returns an ordered range of all the jobs where groupId = &#63; and userId = &#63; and runType = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not <code>QueryUtil#ALL_POS</code>), then the query will include the default ORDER BY logic from <code>JobModelImpl</code>. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	 * </p>
	 *
	 * @param groupId the group ID
	 * @param userId the user ID
	 * @param runType the run type
	 * @param start the lower bound of the range of jobs
	 * @param end the upper bound of the range of jobs (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @return the ordered range of matching jobs
	 */
	public static List<Job> findByRunType_G_U(
		long groupId, long userId, String runType, int start, int end,
		OrderByComparator<Job> orderByComparator) {

		return getPersistence().findByRunType_G_U(
			groupId, userId, runType, start, end, orderByComparator);
	}

	/**
	 * Returns an ordered range of all the jobs where groupId = &#63; and userId = &#63; and runType = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not <code>QueryUtil#ALL_POS</code>), then the query will include the default ORDER BY logic from <code>JobModelImpl</code>. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	 * </p>
	 *
	 * @param groupId the group ID
	 * @param userId the user ID
	 * @param runType the run type
	 * @param start the lower bound of the range of jobs
	 * @param end the upper bound of the range of jobs (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @param retrieveFromCache whether to retrieve from the finder cache
	 * @return the ordered range of matching jobs
	 */
	public static List<Job> findByRunType_G_U(
		long groupId, long userId, String runType, int start, int end,
		OrderByComparator<Job> orderByComparator, boolean retrieveFromCache) {

		return getPersistence().findByRunType_G_U(
			groupId, userId, runType, start, end, orderByComparator,
			retrieveFromCache);
	}

	/**
	 * Returns the first job in the ordered set where groupId = &#63; and userId = &#63; and runType = &#63;.
	 *
	 * @param groupId the group ID
	 * @param userId the user ID
	 * @param runType the run type
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching job
	 * @throws NoSuchJobException if a matching job could not be found
	 */
	public static Job findByRunType_G_U_First(
			long groupId, long userId, String runType,
			OrderByComparator<Job> orderByComparator)
		throws com.osp.icebreaker.exception.NoSuchJobException {

		return getPersistence().findByRunType_G_U_First(
			groupId, userId, runType, orderByComparator);
	}

	/**
	 * Returns the first job in the ordered set where groupId = &#63; and userId = &#63; and runType = &#63;.
	 *
	 * @param groupId the group ID
	 * @param userId the user ID
	 * @param runType the run type
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching job, or <code>null</code> if a matching job could not be found
	 */
	public static Job fetchByRunType_G_U_First(
		long groupId, long userId, String runType,
		OrderByComparator<Job> orderByComparator) {

		return getPersistence().fetchByRunType_G_U_First(
			groupId, userId, runType, orderByComparator);
	}

	/**
	 * Returns the last job in the ordered set where groupId = &#63; and userId = &#63; and runType = &#63;.
	 *
	 * @param groupId the group ID
	 * @param userId the user ID
	 * @param runType the run type
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching job
	 * @throws NoSuchJobException if a matching job could not be found
	 */
	public static Job findByRunType_G_U_Last(
			long groupId, long userId, String runType,
			OrderByComparator<Job> orderByComparator)
		throws com.osp.icebreaker.exception.NoSuchJobException {

		return getPersistence().findByRunType_G_U_Last(
			groupId, userId, runType, orderByComparator);
	}

	/**
	 * Returns the last job in the ordered set where groupId = &#63; and userId = &#63; and runType = &#63;.
	 *
	 * @param groupId the group ID
	 * @param userId the user ID
	 * @param runType the run type
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching job, or <code>null</code> if a matching job could not be found
	 */
	public static Job fetchByRunType_G_U_Last(
		long groupId, long userId, String runType,
		OrderByComparator<Job> orderByComparator) {

		return getPersistence().fetchByRunType_G_U_Last(
			groupId, userId, runType, orderByComparator);
	}

	/**
	 * Returns the jobs before and after the current job in the ordered set where groupId = &#63; and userId = &#63; and runType = &#63;.
	 *
	 * @param jobId the primary key of the current job
	 * @param groupId the group ID
	 * @param userId the user ID
	 * @param runType the run type
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the previous, current, and next job
	 * @throws NoSuchJobException if a job with the primary key could not be found
	 */
	public static Job[] findByRunType_G_U_PrevAndNext(
			long jobId, long groupId, long userId, String runType,
			OrderByComparator<Job> orderByComparator)
		throws com.osp.icebreaker.exception.NoSuchJobException {

		return getPersistence().findByRunType_G_U_PrevAndNext(
			jobId, groupId, userId, runType, orderByComparator);
	}

	/**
	 * Removes all the jobs where groupId = &#63; and userId = &#63; and runType = &#63; from the database.
	 *
	 * @param groupId the group ID
	 * @param userId the user ID
	 * @param runType the run type
	 */
	public static void removeByRunType_G_U(
		long groupId, long userId, String runType) {

		getPersistence().removeByRunType_G_U(groupId, userId, runType);
	}

	/**
	 * Returns the number of jobs where groupId = &#63; and userId = &#63; and runType = &#63;.
	 *
	 * @param groupId the group ID
	 * @param userId the user ID
	 * @param runType the run type
	 * @return the number of matching jobs
	 */
	public static int countByRunType_G_U(
		long groupId, long userId, String runType) {

		return getPersistence().countByRunType_G_U(groupId, userId, runType);
	}

	/**
	 * Caches the job in the entity cache if it is enabled.
	 *
	 * @param job the job
	 */
	public static void cacheResult(Job job) {
		getPersistence().cacheResult(job);
	}

	/**
	 * Caches the jobs in the entity cache if it is enabled.
	 *
	 * @param jobs the jobs
	 */
	public static void cacheResult(List<Job> jobs) {
		getPersistence().cacheResult(jobs);
	}

	/**
	 * Creates a new job with the primary key. Does not add the job to the database.
	 *
	 * @param jobId the primary key for the new job
	 * @return the new job
	 */
	public static Job create(long jobId) {
		return getPersistence().create(jobId);
	}

	/**
	 * Removes the job with the primary key from the database. Also notifies the appropriate model listeners.
	 *
	 * @param jobId the primary key of the job
	 * @return the job that was removed
	 * @throws NoSuchJobException if a job with the primary key could not be found
	 */
	public static Job remove(long jobId)
		throws com.osp.icebreaker.exception.NoSuchJobException {

		return getPersistence().remove(jobId);
	}

	public static Job updateImpl(Job job) {
		return getPersistence().updateImpl(job);
	}

	/**
	 * Returns the job with the primary key or throws a <code>NoSuchJobException</code> if it could not be found.
	 *
	 * @param jobId the primary key of the job
	 * @return the job
	 * @throws NoSuchJobException if a job with the primary key could not be found
	 */
	public static Job findByPrimaryKey(long jobId)
		throws com.osp.icebreaker.exception.NoSuchJobException {

		return getPersistence().findByPrimaryKey(jobId);
	}

	/**
	 * Returns the job with the primary key or returns <code>null</code> if it could not be found.
	 *
	 * @param jobId the primary key of the job
	 * @return the job, or <code>null</code> if a job with the primary key could not be found
	 */
	public static Job fetchByPrimaryKey(long jobId) {
		return getPersistence().fetchByPrimaryKey(jobId);
	}

	/**
	 * Returns all the jobs.
	 *
	 * @return the jobs
	 */
	public static List<Job> findAll() {
		return getPersistence().findAll();
	}

	/**
	 * Returns a range of all the jobs.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not <code>QueryUtil#ALL_POS</code>), then the query will include the default ORDER BY logic from <code>JobModelImpl</code>. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	 * </p>
	 *
	 * @param start the lower bound of the range of jobs
	 * @param end the upper bound of the range of jobs (not inclusive)
	 * @return the range of jobs
	 */
	public static List<Job> findAll(int start, int end) {
		return getPersistence().findAll(start, end);
	}

	/**
	 * Returns an ordered range of all the jobs.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not <code>QueryUtil#ALL_POS</code>), then the query will include the default ORDER BY logic from <code>JobModelImpl</code>. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	 * </p>
	 *
	 * @param start the lower bound of the range of jobs
	 * @param end the upper bound of the range of jobs (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @return the ordered range of jobs
	 */
	public static List<Job> findAll(
		int start, int end, OrderByComparator<Job> orderByComparator) {

		return getPersistence().findAll(start, end, orderByComparator);
	}

	/**
	 * Returns an ordered range of all the jobs.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not <code>QueryUtil#ALL_POS</code>), then the query will include the default ORDER BY logic from <code>JobModelImpl</code>. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	 * </p>
	 *
	 * @param start the lower bound of the range of jobs
	 * @param end the upper bound of the range of jobs (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @param retrieveFromCache whether to retrieve from the finder cache
	 * @return the ordered range of jobs
	 */
	public static List<Job> findAll(
		int start, int end, OrderByComparator<Job> orderByComparator,
		boolean retrieveFromCache) {

		return getPersistence().findAll(
			start, end, orderByComparator, retrieveFromCache);
	}

	/**
	 * Removes all the jobs from the database.
	 */
	public static void removeAll() {
		getPersistence().removeAll();
	}

	/**
	 * Returns the number of jobs.
	 *
	 * @return the number of jobs
	 */
	public static int countAll() {
		return getPersistence().countAll();
	}

	public static JobPersistence getPersistence() {
		return _serviceTracker.getService();
	}

	private static ServiceTracker<JobPersistence, JobPersistence>
		_serviceTracker;

	static {
		Bundle bundle = FrameworkUtil.getBundle(JobPersistence.class);

		ServiceTracker<JobPersistence, JobPersistence> serviceTracker =
			new ServiceTracker<JobPersistence, JobPersistence>(
				bundle.getBundleContext(), JobPersistence.class, null);

		serviceTracker.open();

		_serviceTracker = serviceTracker;
	}

}