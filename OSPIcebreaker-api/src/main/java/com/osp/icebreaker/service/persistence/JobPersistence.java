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

import com.osp.icebreaker.exception.NoSuchJobException;
import com.osp.icebreaker.model.Job;

import org.osgi.annotation.versioning.ProviderType;

/**
 * The persistence interface for the job service.
 *
 * <p>
 * Caching information and settings can be found in <code>portal.properties</code>
 * </p>
 *
 * @author Jerry H. Seo
 * @see JobUtil
 * @generated
 */
@ProviderType
public interface JobPersistence extends BasePersistence<Job> {

	/*
	 * NOTE FOR DEVELOPERS:
	 *
	 * Never modify or reference this interface directly. Always use {@link JobUtil} to access the job persistence. Modify <code>service.xml</code> and rerun ServiceBuilder to regenerate this interface.
	 */

	/**
	 * Returns all the jobs where uuid = &#63;.
	 *
	 * @param uuid the uuid
	 * @return the matching jobs
	 */
	public java.util.List<Job> findByUuid(String uuid);

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
	public java.util.List<Job> findByUuid(String uuid, int start, int end);

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
	public java.util.List<Job> findByUuid(
		String uuid, int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator<Job>
			orderByComparator);

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
	public java.util.List<Job> findByUuid(
		String uuid, int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator<Job> orderByComparator,
		boolean retrieveFromCache);

	/**
	 * Returns the first job in the ordered set where uuid = &#63;.
	 *
	 * @param uuid the uuid
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching job
	 * @throws NoSuchJobException if a matching job could not be found
	 */
	public Job findByUuid_First(
			String uuid,
			com.liferay.portal.kernel.util.OrderByComparator<Job>
				orderByComparator)
		throws NoSuchJobException;

	/**
	 * Returns the first job in the ordered set where uuid = &#63;.
	 *
	 * @param uuid the uuid
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching job, or <code>null</code> if a matching job could not be found
	 */
	public Job fetchByUuid_First(
		String uuid,
		com.liferay.portal.kernel.util.OrderByComparator<Job>
			orderByComparator);

	/**
	 * Returns the last job in the ordered set where uuid = &#63;.
	 *
	 * @param uuid the uuid
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching job
	 * @throws NoSuchJobException if a matching job could not be found
	 */
	public Job findByUuid_Last(
			String uuid,
			com.liferay.portal.kernel.util.OrderByComparator<Job>
				orderByComparator)
		throws NoSuchJobException;

	/**
	 * Returns the last job in the ordered set where uuid = &#63;.
	 *
	 * @param uuid the uuid
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching job, or <code>null</code> if a matching job could not be found
	 */
	public Job fetchByUuid_Last(
		String uuid,
		com.liferay.portal.kernel.util.OrderByComparator<Job>
			orderByComparator);

	/**
	 * Returns the jobs before and after the current job in the ordered set where uuid = &#63;.
	 *
	 * @param jobId the primary key of the current job
	 * @param uuid the uuid
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the previous, current, and next job
	 * @throws NoSuchJobException if a job with the primary key could not be found
	 */
	public Job[] findByUuid_PrevAndNext(
			long jobId, String uuid,
			com.liferay.portal.kernel.util.OrderByComparator<Job>
				orderByComparator)
		throws NoSuchJobException;

	/**
	 * Removes all the jobs where uuid = &#63; from the database.
	 *
	 * @param uuid the uuid
	 */
	public void removeByUuid(String uuid);

	/**
	 * Returns the number of jobs where uuid = &#63;.
	 *
	 * @param uuid the uuid
	 * @return the number of matching jobs
	 */
	public int countByUuid(String uuid);

	/**
	 * Returns the job where uuid = &#63; and groupId = &#63; or throws a <code>NoSuchJobException</code> if it could not be found.
	 *
	 * @param uuid the uuid
	 * @param groupId the group ID
	 * @return the matching job
	 * @throws NoSuchJobException if a matching job could not be found
	 */
	public Job findByUUID_G(String uuid, long groupId)
		throws NoSuchJobException;

	/**
	 * Returns the job where uuid = &#63; and groupId = &#63; or returns <code>null</code> if it could not be found. Uses the finder cache.
	 *
	 * @param uuid the uuid
	 * @param groupId the group ID
	 * @return the matching job, or <code>null</code> if a matching job could not be found
	 */
	public Job fetchByUUID_G(String uuid, long groupId);

	/**
	 * Returns the job where uuid = &#63; and groupId = &#63; or returns <code>null</code> if it could not be found, optionally using the finder cache.
	 *
	 * @param uuid the uuid
	 * @param groupId the group ID
	 * @param retrieveFromCache whether to retrieve from the finder cache
	 * @return the matching job, or <code>null</code> if a matching job could not be found
	 */
	public Job fetchByUUID_G(
		String uuid, long groupId, boolean retrieveFromCache);

	/**
	 * Removes the job where uuid = &#63; and groupId = &#63; from the database.
	 *
	 * @param uuid the uuid
	 * @param groupId the group ID
	 * @return the job that was removed
	 */
	public Job removeByUUID_G(String uuid, long groupId)
		throws NoSuchJobException;

	/**
	 * Returns the number of jobs where uuid = &#63; and groupId = &#63;.
	 *
	 * @param uuid the uuid
	 * @param groupId the group ID
	 * @return the number of matching jobs
	 */
	public int countByUUID_G(String uuid, long groupId);

	/**
	 * Returns all the jobs where uuid = &#63; and companyId = &#63;.
	 *
	 * @param uuid the uuid
	 * @param companyId the company ID
	 * @return the matching jobs
	 */
	public java.util.List<Job> findByUuid_C(String uuid, long companyId);

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
	public java.util.List<Job> findByUuid_C(
		String uuid, long companyId, int start, int end);

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
	public java.util.List<Job> findByUuid_C(
		String uuid, long companyId, int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator<Job>
			orderByComparator);

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
	public java.util.List<Job> findByUuid_C(
		String uuid, long companyId, int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator<Job> orderByComparator,
		boolean retrieveFromCache);

	/**
	 * Returns the first job in the ordered set where uuid = &#63; and companyId = &#63;.
	 *
	 * @param uuid the uuid
	 * @param companyId the company ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching job
	 * @throws NoSuchJobException if a matching job could not be found
	 */
	public Job findByUuid_C_First(
			String uuid, long companyId,
			com.liferay.portal.kernel.util.OrderByComparator<Job>
				orderByComparator)
		throws NoSuchJobException;

	/**
	 * Returns the first job in the ordered set where uuid = &#63; and companyId = &#63;.
	 *
	 * @param uuid the uuid
	 * @param companyId the company ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching job, or <code>null</code> if a matching job could not be found
	 */
	public Job fetchByUuid_C_First(
		String uuid, long companyId,
		com.liferay.portal.kernel.util.OrderByComparator<Job>
			orderByComparator);

	/**
	 * Returns the last job in the ordered set where uuid = &#63; and companyId = &#63;.
	 *
	 * @param uuid the uuid
	 * @param companyId the company ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching job
	 * @throws NoSuchJobException if a matching job could not be found
	 */
	public Job findByUuid_C_Last(
			String uuid, long companyId,
			com.liferay.portal.kernel.util.OrderByComparator<Job>
				orderByComparator)
		throws NoSuchJobException;

	/**
	 * Returns the last job in the ordered set where uuid = &#63; and companyId = &#63;.
	 *
	 * @param uuid the uuid
	 * @param companyId the company ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching job, or <code>null</code> if a matching job could not be found
	 */
	public Job fetchByUuid_C_Last(
		String uuid, long companyId,
		com.liferay.portal.kernel.util.OrderByComparator<Job>
			orderByComparator);

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
	public Job[] findByUuid_C_PrevAndNext(
			long jobId, String uuid, long companyId,
			com.liferay.portal.kernel.util.OrderByComparator<Job>
				orderByComparator)
		throws NoSuchJobException;

	/**
	 * Removes all the jobs where uuid = &#63; and companyId = &#63; from the database.
	 *
	 * @param uuid the uuid
	 * @param companyId the company ID
	 */
	public void removeByUuid_C(String uuid, long companyId);

	/**
	 * Returns the number of jobs where uuid = &#63; and companyId = &#63;.
	 *
	 * @param uuid the uuid
	 * @param companyId the company ID
	 * @return the number of matching jobs
	 */
	public int countByUuid_C(String uuid, long companyId);

	/**
	 * Returns all the jobs where groupId = &#63;.
	 *
	 * @param groupId the group ID
	 * @return the matching jobs
	 */
	public java.util.List<Job> findByGroupId(long groupId);

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
	public java.util.List<Job> findByGroupId(long groupId, int start, int end);

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
	public java.util.List<Job> findByGroupId(
		long groupId, int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator<Job>
			orderByComparator);

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
	public java.util.List<Job> findByGroupId(
		long groupId, int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator<Job> orderByComparator,
		boolean retrieveFromCache);

	/**
	 * Returns the first job in the ordered set where groupId = &#63;.
	 *
	 * @param groupId the group ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching job
	 * @throws NoSuchJobException if a matching job could not be found
	 */
	public Job findByGroupId_First(
			long groupId,
			com.liferay.portal.kernel.util.OrderByComparator<Job>
				orderByComparator)
		throws NoSuchJobException;

	/**
	 * Returns the first job in the ordered set where groupId = &#63;.
	 *
	 * @param groupId the group ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching job, or <code>null</code> if a matching job could not be found
	 */
	public Job fetchByGroupId_First(
		long groupId,
		com.liferay.portal.kernel.util.OrderByComparator<Job>
			orderByComparator);

	/**
	 * Returns the last job in the ordered set where groupId = &#63;.
	 *
	 * @param groupId the group ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching job
	 * @throws NoSuchJobException if a matching job could not be found
	 */
	public Job findByGroupId_Last(
			long groupId,
			com.liferay.portal.kernel.util.OrderByComparator<Job>
				orderByComparator)
		throws NoSuchJobException;

	/**
	 * Returns the last job in the ordered set where groupId = &#63;.
	 *
	 * @param groupId the group ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching job, or <code>null</code> if a matching job could not be found
	 */
	public Job fetchByGroupId_Last(
		long groupId,
		com.liferay.portal.kernel.util.OrderByComparator<Job>
			orderByComparator);

	/**
	 * Returns the jobs before and after the current job in the ordered set where groupId = &#63;.
	 *
	 * @param jobId the primary key of the current job
	 * @param groupId the group ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the previous, current, and next job
	 * @throws NoSuchJobException if a job with the primary key could not be found
	 */
	public Job[] findByGroupId_PrevAndNext(
			long jobId, long groupId,
			com.liferay.portal.kernel.util.OrderByComparator<Job>
				orderByComparator)
		throws NoSuchJobException;

	/**
	 * Removes all the jobs where groupId = &#63; from the database.
	 *
	 * @param groupId the group ID
	 */
	public void removeByGroupId(long groupId);

	/**
	 * Returns the number of jobs where groupId = &#63;.
	 *
	 * @param groupId the group ID
	 * @return the number of matching jobs
	 */
	public int countByGroupId(long groupId);

	/**
	 * Returns all the jobs where userId = &#63;.
	 *
	 * @param userId the user ID
	 * @return the matching jobs
	 */
	public java.util.List<Job> findByUserId(long userId);

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
	public java.util.List<Job> findByUserId(long userId, int start, int end);

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
	public java.util.List<Job> findByUserId(
		long userId, int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator<Job>
			orderByComparator);

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
	public java.util.List<Job> findByUserId(
		long userId, int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator<Job> orderByComparator,
		boolean retrieveFromCache);

	/**
	 * Returns the first job in the ordered set where userId = &#63;.
	 *
	 * @param userId the user ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching job
	 * @throws NoSuchJobException if a matching job could not be found
	 */
	public Job findByUserId_First(
			long userId,
			com.liferay.portal.kernel.util.OrderByComparator<Job>
				orderByComparator)
		throws NoSuchJobException;

	/**
	 * Returns the first job in the ordered set where userId = &#63;.
	 *
	 * @param userId the user ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching job, or <code>null</code> if a matching job could not be found
	 */
	public Job fetchByUserId_First(
		long userId,
		com.liferay.portal.kernel.util.OrderByComparator<Job>
			orderByComparator);

	/**
	 * Returns the last job in the ordered set where userId = &#63;.
	 *
	 * @param userId the user ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching job
	 * @throws NoSuchJobException if a matching job could not be found
	 */
	public Job findByUserId_Last(
			long userId,
			com.liferay.portal.kernel.util.OrderByComparator<Job>
				orderByComparator)
		throws NoSuchJobException;

	/**
	 * Returns the last job in the ordered set where userId = &#63;.
	 *
	 * @param userId the user ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching job, or <code>null</code> if a matching job could not be found
	 */
	public Job fetchByUserId_Last(
		long userId,
		com.liferay.portal.kernel.util.OrderByComparator<Job>
			orderByComparator);

	/**
	 * Returns the jobs before and after the current job in the ordered set where userId = &#63;.
	 *
	 * @param jobId the primary key of the current job
	 * @param userId the user ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the previous, current, and next job
	 * @throws NoSuchJobException if a job with the primary key could not be found
	 */
	public Job[] findByUserId_PrevAndNext(
			long jobId, long userId,
			com.liferay.portal.kernel.util.OrderByComparator<Job>
				orderByComparator)
		throws NoSuchJobException;

	/**
	 * Removes all the jobs where userId = &#63; from the database.
	 *
	 * @param userId the user ID
	 */
	public void removeByUserId(long userId);

	/**
	 * Returns the number of jobs where userId = &#63;.
	 *
	 * @param userId the user ID
	 * @return the number of matching jobs
	 */
	public int countByUserId(long userId);

	/**
	 * Returns all the jobs where groupId = &#63; and userId = &#63;.
	 *
	 * @param groupId the group ID
	 * @param userId the user ID
	 * @return the matching jobs
	 */
	public java.util.List<Job> findByUserId_G(long groupId, long userId);

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
	public java.util.List<Job> findByUserId_G(
		long groupId, long userId, int start, int end);

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
	public java.util.List<Job> findByUserId_G(
		long groupId, long userId, int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator<Job>
			orderByComparator);

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
	public java.util.List<Job> findByUserId_G(
		long groupId, long userId, int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator<Job> orderByComparator,
		boolean retrieveFromCache);

	/**
	 * Returns the first job in the ordered set where groupId = &#63; and userId = &#63;.
	 *
	 * @param groupId the group ID
	 * @param userId the user ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching job
	 * @throws NoSuchJobException if a matching job could not be found
	 */
	public Job findByUserId_G_First(
			long groupId, long userId,
			com.liferay.portal.kernel.util.OrderByComparator<Job>
				orderByComparator)
		throws NoSuchJobException;

	/**
	 * Returns the first job in the ordered set where groupId = &#63; and userId = &#63;.
	 *
	 * @param groupId the group ID
	 * @param userId the user ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching job, or <code>null</code> if a matching job could not be found
	 */
	public Job fetchByUserId_G_First(
		long groupId, long userId,
		com.liferay.portal.kernel.util.OrderByComparator<Job>
			orderByComparator);

	/**
	 * Returns the last job in the ordered set where groupId = &#63; and userId = &#63;.
	 *
	 * @param groupId the group ID
	 * @param userId the user ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching job
	 * @throws NoSuchJobException if a matching job could not be found
	 */
	public Job findByUserId_G_Last(
			long groupId, long userId,
			com.liferay.portal.kernel.util.OrderByComparator<Job>
				orderByComparator)
		throws NoSuchJobException;

	/**
	 * Returns the last job in the ordered set where groupId = &#63; and userId = &#63;.
	 *
	 * @param groupId the group ID
	 * @param userId the user ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching job, or <code>null</code> if a matching job could not be found
	 */
	public Job fetchByUserId_G_Last(
		long groupId, long userId,
		com.liferay.portal.kernel.util.OrderByComparator<Job>
			orderByComparator);

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
	public Job[] findByUserId_G_PrevAndNext(
			long jobId, long groupId, long userId,
			com.liferay.portal.kernel.util.OrderByComparator<Job>
				orderByComparator)
		throws NoSuchJobException;

	/**
	 * Removes all the jobs where groupId = &#63; and userId = &#63; from the database.
	 *
	 * @param groupId the group ID
	 * @param userId the user ID
	 */
	public void removeByUserId_G(long groupId, long userId);

	/**
	 * Returns the number of jobs where groupId = &#63; and userId = &#63;.
	 *
	 * @param groupId the group ID
	 * @param userId the user ID
	 * @return the number of matching jobs
	 */
	public int countByUserId_G(long groupId, long userId);

	/**
	 * Returns all the jobs where status = &#63;.
	 *
	 * @param status the status
	 * @return the matching jobs
	 */
	public java.util.List<Job> findByStatus(int status);

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
	public java.util.List<Job> findByStatus(int status, int start, int end);

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
	public java.util.List<Job> findByStatus(
		int status, int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator<Job>
			orderByComparator);

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
	public java.util.List<Job> findByStatus(
		int status, int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator<Job> orderByComparator,
		boolean retrieveFromCache);

	/**
	 * Returns the first job in the ordered set where status = &#63;.
	 *
	 * @param status the status
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching job
	 * @throws NoSuchJobException if a matching job could not be found
	 */
	public Job findByStatus_First(
			int status,
			com.liferay.portal.kernel.util.OrderByComparator<Job>
				orderByComparator)
		throws NoSuchJobException;

	/**
	 * Returns the first job in the ordered set where status = &#63;.
	 *
	 * @param status the status
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching job, or <code>null</code> if a matching job could not be found
	 */
	public Job fetchByStatus_First(
		int status,
		com.liferay.portal.kernel.util.OrderByComparator<Job>
			orderByComparator);

	/**
	 * Returns the last job in the ordered set where status = &#63;.
	 *
	 * @param status the status
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching job
	 * @throws NoSuchJobException if a matching job could not be found
	 */
	public Job findByStatus_Last(
			int status,
			com.liferay.portal.kernel.util.OrderByComparator<Job>
				orderByComparator)
		throws NoSuchJobException;

	/**
	 * Returns the last job in the ordered set where status = &#63;.
	 *
	 * @param status the status
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching job, or <code>null</code> if a matching job could not be found
	 */
	public Job fetchByStatus_Last(
		int status,
		com.liferay.portal.kernel.util.OrderByComparator<Job>
			orderByComparator);

	/**
	 * Returns the jobs before and after the current job in the ordered set where status = &#63;.
	 *
	 * @param jobId the primary key of the current job
	 * @param status the status
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the previous, current, and next job
	 * @throws NoSuchJobException if a job with the primary key could not be found
	 */
	public Job[] findByStatus_PrevAndNext(
			long jobId, int status,
			com.liferay.portal.kernel.util.OrderByComparator<Job>
				orderByComparator)
		throws NoSuchJobException;

	/**
	 * Removes all the jobs where status = &#63; from the database.
	 *
	 * @param status the status
	 */
	public void removeByStatus(int status);

	/**
	 * Returns the number of jobs where status = &#63;.
	 *
	 * @param status the status
	 * @return the number of matching jobs
	 */
	public int countByStatus(int status);

	/**
	 * Returns all the jobs where groupId = &#63; and status = &#63;.
	 *
	 * @param groupId the group ID
	 * @param status the status
	 * @return the matching jobs
	 */
	public java.util.List<Job> findByStatus_G(long groupId, int status);

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
	public java.util.List<Job> findByStatus_G(
		long groupId, int status, int start, int end);

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
	public java.util.List<Job> findByStatus_G(
		long groupId, int status, int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator<Job>
			orderByComparator);

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
	public java.util.List<Job> findByStatus_G(
		long groupId, int status, int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator<Job> orderByComparator,
		boolean retrieveFromCache);

	/**
	 * Returns the first job in the ordered set where groupId = &#63; and status = &#63;.
	 *
	 * @param groupId the group ID
	 * @param status the status
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching job
	 * @throws NoSuchJobException if a matching job could not be found
	 */
	public Job findByStatus_G_First(
			long groupId, int status,
			com.liferay.portal.kernel.util.OrderByComparator<Job>
				orderByComparator)
		throws NoSuchJobException;

	/**
	 * Returns the first job in the ordered set where groupId = &#63; and status = &#63;.
	 *
	 * @param groupId the group ID
	 * @param status the status
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching job, or <code>null</code> if a matching job could not be found
	 */
	public Job fetchByStatus_G_First(
		long groupId, int status,
		com.liferay.portal.kernel.util.OrderByComparator<Job>
			orderByComparator);

	/**
	 * Returns the last job in the ordered set where groupId = &#63; and status = &#63;.
	 *
	 * @param groupId the group ID
	 * @param status the status
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching job
	 * @throws NoSuchJobException if a matching job could not be found
	 */
	public Job findByStatus_G_Last(
			long groupId, int status,
			com.liferay.portal.kernel.util.OrderByComparator<Job>
				orderByComparator)
		throws NoSuchJobException;

	/**
	 * Returns the last job in the ordered set where groupId = &#63; and status = &#63;.
	 *
	 * @param groupId the group ID
	 * @param status the status
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching job, or <code>null</code> if a matching job could not be found
	 */
	public Job fetchByStatus_G_Last(
		long groupId, int status,
		com.liferay.portal.kernel.util.OrderByComparator<Job>
			orderByComparator);

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
	public Job[] findByStatus_G_PrevAndNext(
			long jobId, long groupId, int status,
			com.liferay.portal.kernel.util.OrderByComparator<Job>
				orderByComparator)
		throws NoSuchJobException;

	/**
	 * Removes all the jobs where groupId = &#63; and status = &#63; from the database.
	 *
	 * @param groupId the group ID
	 * @param status the status
	 */
	public void removeByStatus_G(long groupId, int status);

	/**
	 * Returns the number of jobs where groupId = &#63; and status = &#63;.
	 *
	 * @param groupId the group ID
	 * @param status the status
	 * @return the number of matching jobs
	 */
	public int countByStatus_G(long groupId, int status);

	/**
	 * Returns all the jobs where userId = &#63; and status = &#63;.
	 *
	 * @param userId the user ID
	 * @param status the status
	 * @return the matching jobs
	 */
	public java.util.List<Job> findByStatus_U(long userId, int status);

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
	public java.util.List<Job> findByStatus_U(
		long userId, int status, int start, int end);

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
	public java.util.List<Job> findByStatus_U(
		long userId, int status, int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator<Job>
			orderByComparator);

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
	public java.util.List<Job> findByStatus_U(
		long userId, int status, int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator<Job> orderByComparator,
		boolean retrieveFromCache);

	/**
	 * Returns the first job in the ordered set where userId = &#63; and status = &#63;.
	 *
	 * @param userId the user ID
	 * @param status the status
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching job
	 * @throws NoSuchJobException if a matching job could not be found
	 */
	public Job findByStatus_U_First(
			long userId, int status,
			com.liferay.portal.kernel.util.OrderByComparator<Job>
				orderByComparator)
		throws NoSuchJobException;

	/**
	 * Returns the first job in the ordered set where userId = &#63; and status = &#63;.
	 *
	 * @param userId the user ID
	 * @param status the status
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching job, or <code>null</code> if a matching job could not be found
	 */
	public Job fetchByStatus_U_First(
		long userId, int status,
		com.liferay.portal.kernel.util.OrderByComparator<Job>
			orderByComparator);

	/**
	 * Returns the last job in the ordered set where userId = &#63; and status = &#63;.
	 *
	 * @param userId the user ID
	 * @param status the status
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching job
	 * @throws NoSuchJobException if a matching job could not be found
	 */
	public Job findByStatus_U_Last(
			long userId, int status,
			com.liferay.portal.kernel.util.OrderByComparator<Job>
				orderByComparator)
		throws NoSuchJobException;

	/**
	 * Returns the last job in the ordered set where userId = &#63; and status = &#63;.
	 *
	 * @param userId the user ID
	 * @param status the status
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching job, or <code>null</code> if a matching job could not be found
	 */
	public Job fetchByStatus_U_Last(
		long userId, int status,
		com.liferay.portal.kernel.util.OrderByComparator<Job>
			orderByComparator);

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
	public Job[] findByStatus_U_PrevAndNext(
			long jobId, long userId, int status,
			com.liferay.portal.kernel.util.OrderByComparator<Job>
				orderByComparator)
		throws NoSuchJobException;

	/**
	 * Removes all the jobs where userId = &#63; and status = &#63; from the database.
	 *
	 * @param userId the user ID
	 * @param status the status
	 */
	public void removeByStatus_U(long userId, int status);

	/**
	 * Returns the number of jobs where userId = &#63; and status = &#63;.
	 *
	 * @param userId the user ID
	 * @param status the status
	 * @return the number of matching jobs
	 */
	public int countByStatus_U(long userId, int status);

	/**
	 * Returns all the jobs where groupId = &#63; and userId = &#63; and status = &#63;.
	 *
	 * @param groupId the group ID
	 * @param userId the user ID
	 * @param status the status
	 * @return the matching jobs
	 */
	public java.util.List<Job> findByStatus_G_U(
		long groupId, long userId, int status);

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
	public java.util.List<Job> findByStatus_G_U(
		long groupId, long userId, int status, int start, int end);

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
	public java.util.List<Job> findByStatus_G_U(
		long groupId, long userId, int status, int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator<Job>
			orderByComparator);

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
	public java.util.List<Job> findByStatus_G_U(
		long groupId, long userId, int status, int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator<Job> orderByComparator,
		boolean retrieveFromCache);

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
	public Job findByStatus_G_U_First(
			long groupId, long userId, int status,
			com.liferay.portal.kernel.util.OrderByComparator<Job>
				orderByComparator)
		throws NoSuchJobException;

	/**
	 * Returns the first job in the ordered set where groupId = &#63; and userId = &#63; and status = &#63;.
	 *
	 * @param groupId the group ID
	 * @param userId the user ID
	 * @param status the status
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching job, or <code>null</code> if a matching job could not be found
	 */
	public Job fetchByStatus_G_U_First(
		long groupId, long userId, int status,
		com.liferay.portal.kernel.util.OrderByComparator<Job>
			orderByComparator);

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
	public Job findByStatus_G_U_Last(
			long groupId, long userId, int status,
			com.liferay.portal.kernel.util.OrderByComparator<Job>
				orderByComparator)
		throws NoSuchJobException;

	/**
	 * Returns the last job in the ordered set where groupId = &#63; and userId = &#63; and status = &#63;.
	 *
	 * @param groupId the group ID
	 * @param userId the user ID
	 * @param status the status
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching job, or <code>null</code> if a matching job could not be found
	 */
	public Job fetchByStatus_G_U_Last(
		long groupId, long userId, int status,
		com.liferay.portal.kernel.util.OrderByComparator<Job>
			orderByComparator);

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
	public Job[] findByStatus_G_U_PrevAndNext(
			long jobId, long groupId, long userId, int status,
			com.liferay.portal.kernel.util.OrderByComparator<Job>
				orderByComparator)
		throws NoSuchJobException;

	/**
	 * Removes all the jobs where groupId = &#63; and userId = &#63; and status = &#63; from the database.
	 *
	 * @param groupId the group ID
	 * @param userId the user ID
	 * @param status the status
	 */
	public void removeByStatus_G_U(long groupId, long userId, int status);

	/**
	 * Returns the number of jobs where groupId = &#63; and userId = &#63; and status = &#63;.
	 *
	 * @param groupId the group ID
	 * @param userId the user ID
	 * @param status the status
	 * @return the number of matching jobs
	 */
	public int countByStatus_G_U(long groupId, long userId, int status);

	/**
	 * Returns all the jobs where queueName = &#63;.
	 *
	 * @param queueName the queue name
	 * @return the matching jobs
	 */
	public java.util.List<Job> findByQueueName(String queueName);

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
	public java.util.List<Job> findByQueueName(
		String queueName, int start, int end);

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
	public java.util.List<Job> findByQueueName(
		String queueName, int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator<Job>
			orderByComparator);

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
	public java.util.List<Job> findByQueueName(
		String queueName, int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator<Job> orderByComparator,
		boolean retrieveFromCache);

	/**
	 * Returns the first job in the ordered set where queueName = &#63;.
	 *
	 * @param queueName the queue name
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching job
	 * @throws NoSuchJobException if a matching job could not be found
	 */
	public Job findByQueueName_First(
			String queueName,
			com.liferay.portal.kernel.util.OrderByComparator<Job>
				orderByComparator)
		throws NoSuchJobException;

	/**
	 * Returns the first job in the ordered set where queueName = &#63;.
	 *
	 * @param queueName the queue name
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching job, or <code>null</code> if a matching job could not be found
	 */
	public Job fetchByQueueName_First(
		String queueName,
		com.liferay.portal.kernel.util.OrderByComparator<Job>
			orderByComparator);

	/**
	 * Returns the last job in the ordered set where queueName = &#63;.
	 *
	 * @param queueName the queue name
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching job
	 * @throws NoSuchJobException if a matching job could not be found
	 */
	public Job findByQueueName_Last(
			String queueName,
			com.liferay.portal.kernel.util.OrderByComparator<Job>
				orderByComparator)
		throws NoSuchJobException;

	/**
	 * Returns the last job in the ordered set where queueName = &#63;.
	 *
	 * @param queueName the queue name
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching job, or <code>null</code> if a matching job could not be found
	 */
	public Job fetchByQueueName_Last(
		String queueName,
		com.liferay.portal.kernel.util.OrderByComparator<Job>
			orderByComparator);

	/**
	 * Returns the jobs before and after the current job in the ordered set where queueName = &#63;.
	 *
	 * @param jobId the primary key of the current job
	 * @param queueName the queue name
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the previous, current, and next job
	 * @throws NoSuchJobException if a job with the primary key could not be found
	 */
	public Job[] findByQueueName_PrevAndNext(
			long jobId, String queueName,
			com.liferay.portal.kernel.util.OrderByComparator<Job>
				orderByComparator)
		throws NoSuchJobException;

	/**
	 * Removes all the jobs where queueName = &#63; from the database.
	 *
	 * @param queueName the queue name
	 */
	public void removeByQueueName(String queueName);

	/**
	 * Returns the number of jobs where queueName = &#63;.
	 *
	 * @param queueName the queue name
	 * @return the number of matching jobs
	 */
	public int countByQueueName(String queueName);

	/**
	 * Returns all the jobs where jobStatus = &#63;.
	 *
	 * @param jobStatus the job status
	 * @return the matching jobs
	 */
	public java.util.List<Job> findByJobStatus(int jobStatus);

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
	public java.util.List<Job> findByJobStatus(
		int jobStatus, int start, int end);

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
	public java.util.List<Job> findByJobStatus(
		int jobStatus, int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator<Job>
			orderByComparator);

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
	public java.util.List<Job> findByJobStatus(
		int jobStatus, int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator<Job> orderByComparator,
		boolean retrieveFromCache);

	/**
	 * Returns the first job in the ordered set where jobStatus = &#63;.
	 *
	 * @param jobStatus the job status
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching job
	 * @throws NoSuchJobException if a matching job could not be found
	 */
	public Job findByJobStatus_First(
			int jobStatus,
			com.liferay.portal.kernel.util.OrderByComparator<Job>
				orderByComparator)
		throws NoSuchJobException;

	/**
	 * Returns the first job in the ordered set where jobStatus = &#63;.
	 *
	 * @param jobStatus the job status
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching job, or <code>null</code> if a matching job could not be found
	 */
	public Job fetchByJobStatus_First(
		int jobStatus,
		com.liferay.portal.kernel.util.OrderByComparator<Job>
			orderByComparator);

	/**
	 * Returns the last job in the ordered set where jobStatus = &#63;.
	 *
	 * @param jobStatus the job status
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching job
	 * @throws NoSuchJobException if a matching job could not be found
	 */
	public Job findByJobStatus_Last(
			int jobStatus,
			com.liferay.portal.kernel.util.OrderByComparator<Job>
				orderByComparator)
		throws NoSuchJobException;

	/**
	 * Returns the last job in the ordered set where jobStatus = &#63;.
	 *
	 * @param jobStatus the job status
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching job, or <code>null</code> if a matching job could not be found
	 */
	public Job fetchByJobStatus_Last(
		int jobStatus,
		com.liferay.portal.kernel.util.OrderByComparator<Job>
			orderByComparator);

	/**
	 * Returns the jobs before and after the current job in the ordered set where jobStatus = &#63;.
	 *
	 * @param jobId the primary key of the current job
	 * @param jobStatus the job status
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the previous, current, and next job
	 * @throws NoSuchJobException if a job with the primary key could not be found
	 */
	public Job[] findByJobStatus_PrevAndNext(
			long jobId, int jobStatus,
			com.liferay.portal.kernel.util.OrderByComparator<Job>
				orderByComparator)
		throws NoSuchJobException;

	/**
	 * Removes all the jobs where jobStatus = &#63; from the database.
	 *
	 * @param jobStatus the job status
	 */
	public void removeByJobStatus(int jobStatus);

	/**
	 * Returns the number of jobs where jobStatus = &#63;.
	 *
	 * @param jobStatus the job status
	 * @return the number of matching jobs
	 */
	public int countByJobStatus(int jobStatus);

	/**
	 * Returns all the jobs where groupId = &#63; and jobStatus = &#63;.
	 *
	 * @param groupId the group ID
	 * @param jobStatus the job status
	 * @return the matching jobs
	 */
	public java.util.List<Job> findByJobStatus_G(long groupId, int jobStatus);

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
	public java.util.List<Job> findByJobStatus_G(
		long groupId, int jobStatus, int start, int end);

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
	public java.util.List<Job> findByJobStatus_G(
		long groupId, int jobStatus, int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator<Job>
			orderByComparator);

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
	public java.util.List<Job> findByJobStatus_G(
		long groupId, int jobStatus, int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator<Job> orderByComparator,
		boolean retrieveFromCache);

	/**
	 * Returns the first job in the ordered set where groupId = &#63; and jobStatus = &#63;.
	 *
	 * @param groupId the group ID
	 * @param jobStatus the job status
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching job
	 * @throws NoSuchJobException if a matching job could not be found
	 */
	public Job findByJobStatus_G_First(
			long groupId, int jobStatus,
			com.liferay.portal.kernel.util.OrderByComparator<Job>
				orderByComparator)
		throws NoSuchJobException;

	/**
	 * Returns the first job in the ordered set where groupId = &#63; and jobStatus = &#63;.
	 *
	 * @param groupId the group ID
	 * @param jobStatus the job status
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching job, or <code>null</code> if a matching job could not be found
	 */
	public Job fetchByJobStatus_G_First(
		long groupId, int jobStatus,
		com.liferay.portal.kernel.util.OrderByComparator<Job>
			orderByComparator);

	/**
	 * Returns the last job in the ordered set where groupId = &#63; and jobStatus = &#63;.
	 *
	 * @param groupId the group ID
	 * @param jobStatus the job status
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching job
	 * @throws NoSuchJobException if a matching job could not be found
	 */
	public Job findByJobStatus_G_Last(
			long groupId, int jobStatus,
			com.liferay.portal.kernel.util.OrderByComparator<Job>
				orderByComparator)
		throws NoSuchJobException;

	/**
	 * Returns the last job in the ordered set where groupId = &#63; and jobStatus = &#63;.
	 *
	 * @param groupId the group ID
	 * @param jobStatus the job status
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching job, or <code>null</code> if a matching job could not be found
	 */
	public Job fetchByJobStatus_G_Last(
		long groupId, int jobStatus,
		com.liferay.portal.kernel.util.OrderByComparator<Job>
			orderByComparator);

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
	public Job[] findByJobStatus_G_PrevAndNext(
			long jobId, long groupId, int jobStatus,
			com.liferay.portal.kernel.util.OrderByComparator<Job>
				orderByComparator)
		throws NoSuchJobException;

	/**
	 * Removes all the jobs where groupId = &#63; and jobStatus = &#63; from the database.
	 *
	 * @param groupId the group ID
	 * @param jobStatus the job status
	 */
	public void removeByJobStatus_G(long groupId, int jobStatus);

	/**
	 * Returns the number of jobs where groupId = &#63; and jobStatus = &#63;.
	 *
	 * @param groupId the group ID
	 * @param jobStatus the job status
	 * @return the number of matching jobs
	 */
	public int countByJobStatus_G(long groupId, int jobStatus);

	/**
	 * Returns all the jobs where userId = &#63; and jobStatus = &#63;.
	 *
	 * @param userId the user ID
	 * @param jobStatus the job status
	 * @return the matching jobs
	 */
	public java.util.List<Job> findByJobStatus_U(long userId, int jobStatus);

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
	public java.util.List<Job> findByJobStatus_U(
		long userId, int jobStatus, int start, int end);

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
	public java.util.List<Job> findByJobStatus_U(
		long userId, int jobStatus, int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator<Job>
			orderByComparator);

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
	public java.util.List<Job> findByJobStatus_U(
		long userId, int jobStatus, int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator<Job> orderByComparator,
		boolean retrieveFromCache);

	/**
	 * Returns the first job in the ordered set where userId = &#63; and jobStatus = &#63;.
	 *
	 * @param userId the user ID
	 * @param jobStatus the job status
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching job
	 * @throws NoSuchJobException if a matching job could not be found
	 */
	public Job findByJobStatus_U_First(
			long userId, int jobStatus,
			com.liferay.portal.kernel.util.OrderByComparator<Job>
				orderByComparator)
		throws NoSuchJobException;

	/**
	 * Returns the first job in the ordered set where userId = &#63; and jobStatus = &#63;.
	 *
	 * @param userId the user ID
	 * @param jobStatus the job status
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching job, or <code>null</code> if a matching job could not be found
	 */
	public Job fetchByJobStatus_U_First(
		long userId, int jobStatus,
		com.liferay.portal.kernel.util.OrderByComparator<Job>
			orderByComparator);

	/**
	 * Returns the last job in the ordered set where userId = &#63; and jobStatus = &#63;.
	 *
	 * @param userId the user ID
	 * @param jobStatus the job status
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching job
	 * @throws NoSuchJobException if a matching job could not be found
	 */
	public Job findByJobStatus_U_Last(
			long userId, int jobStatus,
			com.liferay.portal.kernel.util.OrderByComparator<Job>
				orderByComparator)
		throws NoSuchJobException;

	/**
	 * Returns the last job in the ordered set where userId = &#63; and jobStatus = &#63;.
	 *
	 * @param userId the user ID
	 * @param jobStatus the job status
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching job, or <code>null</code> if a matching job could not be found
	 */
	public Job fetchByJobStatus_U_Last(
		long userId, int jobStatus,
		com.liferay.portal.kernel.util.OrderByComparator<Job>
			orderByComparator);

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
	public Job[] findByJobStatus_U_PrevAndNext(
			long jobId, long userId, int jobStatus,
			com.liferay.portal.kernel.util.OrderByComparator<Job>
				orderByComparator)
		throws NoSuchJobException;

	/**
	 * Removes all the jobs where userId = &#63; and jobStatus = &#63; from the database.
	 *
	 * @param userId the user ID
	 * @param jobStatus the job status
	 */
	public void removeByJobStatus_U(long userId, int jobStatus);

	/**
	 * Returns the number of jobs where userId = &#63; and jobStatus = &#63;.
	 *
	 * @param userId the user ID
	 * @param jobStatus the job status
	 * @return the number of matching jobs
	 */
	public int countByJobStatus_U(long userId, int jobStatus);

	/**
	 * Returns all the jobs where groupId = &#63; and userId = &#63; and jobStatus = &#63;.
	 *
	 * @param groupId the group ID
	 * @param userId the user ID
	 * @param jobStatus the job status
	 * @return the matching jobs
	 */
	public java.util.List<Job> findByJobStatus_G_U(
		long groupId, long userId, int jobStatus);

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
	public java.util.List<Job> findByJobStatus_G_U(
		long groupId, long userId, int jobStatus, int start, int end);

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
	public java.util.List<Job> findByJobStatus_G_U(
		long groupId, long userId, int jobStatus, int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator<Job>
			orderByComparator);

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
	public java.util.List<Job> findByJobStatus_G_U(
		long groupId, long userId, int jobStatus, int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator<Job> orderByComparator,
		boolean retrieveFromCache);

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
	public Job findByJobStatus_G_U_First(
			long groupId, long userId, int jobStatus,
			com.liferay.portal.kernel.util.OrderByComparator<Job>
				orderByComparator)
		throws NoSuchJobException;

	/**
	 * Returns the first job in the ordered set where groupId = &#63; and userId = &#63; and jobStatus = &#63;.
	 *
	 * @param groupId the group ID
	 * @param userId the user ID
	 * @param jobStatus the job status
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching job, or <code>null</code> if a matching job could not be found
	 */
	public Job fetchByJobStatus_G_U_First(
		long groupId, long userId, int jobStatus,
		com.liferay.portal.kernel.util.OrderByComparator<Job>
			orderByComparator);

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
	public Job findByJobStatus_G_U_Last(
			long groupId, long userId, int jobStatus,
			com.liferay.portal.kernel.util.OrderByComparator<Job>
				orderByComparator)
		throws NoSuchJobException;

	/**
	 * Returns the last job in the ordered set where groupId = &#63; and userId = &#63; and jobStatus = &#63;.
	 *
	 * @param groupId the group ID
	 * @param userId the user ID
	 * @param jobStatus the job status
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching job, or <code>null</code> if a matching job could not be found
	 */
	public Job fetchByJobStatus_G_U_Last(
		long groupId, long userId, int jobStatus,
		com.liferay.portal.kernel.util.OrderByComparator<Job>
			orderByComparator);

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
	public Job[] findByJobStatus_G_U_PrevAndNext(
			long jobId, long groupId, long userId, int jobStatus,
			com.liferay.portal.kernel.util.OrderByComparator<Job>
				orderByComparator)
		throws NoSuchJobException;

	/**
	 * Removes all the jobs where groupId = &#63; and userId = &#63; and jobStatus = &#63; from the database.
	 *
	 * @param groupId the group ID
	 * @param userId the user ID
	 * @param jobStatus the job status
	 */
	public void removeByJobStatus_G_U(long groupId, long userId, int jobStatus);

	/**
	 * Returns the number of jobs where groupId = &#63; and userId = &#63; and jobStatus = &#63;.
	 *
	 * @param groupId the group ID
	 * @param userId the user ID
	 * @param jobStatus the job status
	 * @return the number of matching jobs
	 */
	public int countByJobStatus_G_U(long groupId, long userId, int jobStatus);

	/**
	 * Returns all the jobs where title LIKE &#63;.
	 *
	 * @param title the title
	 * @return the matching jobs
	 */
	public java.util.List<Job> findByTitle(String title);

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
	public java.util.List<Job> findByTitle(String title, int start, int end);

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
	public java.util.List<Job> findByTitle(
		String title, int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator<Job>
			orderByComparator);

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
	public java.util.List<Job> findByTitle(
		String title, int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator<Job> orderByComparator,
		boolean retrieveFromCache);

	/**
	 * Returns the first job in the ordered set where title LIKE &#63;.
	 *
	 * @param title the title
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching job
	 * @throws NoSuchJobException if a matching job could not be found
	 */
	public Job findByTitle_First(
			String title,
			com.liferay.portal.kernel.util.OrderByComparator<Job>
				orderByComparator)
		throws NoSuchJobException;

	/**
	 * Returns the first job in the ordered set where title LIKE &#63;.
	 *
	 * @param title the title
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching job, or <code>null</code> if a matching job could not be found
	 */
	public Job fetchByTitle_First(
		String title,
		com.liferay.portal.kernel.util.OrderByComparator<Job>
			orderByComparator);

	/**
	 * Returns the last job in the ordered set where title LIKE &#63;.
	 *
	 * @param title the title
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching job
	 * @throws NoSuchJobException if a matching job could not be found
	 */
	public Job findByTitle_Last(
			String title,
			com.liferay.portal.kernel.util.OrderByComparator<Job>
				orderByComparator)
		throws NoSuchJobException;

	/**
	 * Returns the last job in the ordered set where title LIKE &#63;.
	 *
	 * @param title the title
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching job, or <code>null</code> if a matching job could not be found
	 */
	public Job fetchByTitle_Last(
		String title,
		com.liferay.portal.kernel.util.OrderByComparator<Job>
			orderByComparator);

	/**
	 * Returns the jobs before and after the current job in the ordered set where title LIKE &#63;.
	 *
	 * @param jobId the primary key of the current job
	 * @param title the title
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the previous, current, and next job
	 * @throws NoSuchJobException if a job with the primary key could not be found
	 */
	public Job[] findByTitle_PrevAndNext(
			long jobId, String title,
			com.liferay.portal.kernel.util.OrderByComparator<Job>
				orderByComparator)
		throws NoSuchJobException;

	/**
	 * Removes all the jobs where title LIKE &#63; from the database.
	 *
	 * @param title the title
	 */
	public void removeByTitle(String title);

	/**
	 * Returns the number of jobs where title LIKE &#63;.
	 *
	 * @param title the title
	 * @return the number of matching jobs
	 */
	public int countByTitle(String title);

	/**
	 * Returns all the jobs where groupId = &#63; and title LIKE &#63;.
	 *
	 * @param groupId the group ID
	 * @param title the title
	 * @return the matching jobs
	 */
	public java.util.List<Job> findByTitle_G(long groupId, String title);

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
	public java.util.List<Job> findByTitle_G(
		long groupId, String title, int start, int end);

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
	public java.util.List<Job> findByTitle_G(
		long groupId, String title, int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator<Job>
			orderByComparator);

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
	public java.util.List<Job> findByTitle_G(
		long groupId, String title, int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator<Job> orderByComparator,
		boolean retrieveFromCache);

	/**
	 * Returns the first job in the ordered set where groupId = &#63; and title LIKE &#63;.
	 *
	 * @param groupId the group ID
	 * @param title the title
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching job
	 * @throws NoSuchJobException if a matching job could not be found
	 */
	public Job findByTitle_G_First(
			long groupId, String title,
			com.liferay.portal.kernel.util.OrderByComparator<Job>
				orderByComparator)
		throws NoSuchJobException;

	/**
	 * Returns the first job in the ordered set where groupId = &#63; and title LIKE &#63;.
	 *
	 * @param groupId the group ID
	 * @param title the title
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching job, or <code>null</code> if a matching job could not be found
	 */
	public Job fetchByTitle_G_First(
		long groupId, String title,
		com.liferay.portal.kernel.util.OrderByComparator<Job>
			orderByComparator);

	/**
	 * Returns the last job in the ordered set where groupId = &#63; and title LIKE &#63;.
	 *
	 * @param groupId the group ID
	 * @param title the title
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching job
	 * @throws NoSuchJobException if a matching job could not be found
	 */
	public Job findByTitle_G_Last(
			long groupId, String title,
			com.liferay.portal.kernel.util.OrderByComparator<Job>
				orderByComparator)
		throws NoSuchJobException;

	/**
	 * Returns the last job in the ordered set where groupId = &#63; and title LIKE &#63;.
	 *
	 * @param groupId the group ID
	 * @param title the title
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching job, or <code>null</code> if a matching job could not be found
	 */
	public Job fetchByTitle_G_Last(
		long groupId, String title,
		com.liferay.portal.kernel.util.OrderByComparator<Job>
			orderByComparator);

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
	public Job[] findByTitle_G_PrevAndNext(
			long jobId, long groupId, String title,
			com.liferay.portal.kernel.util.OrderByComparator<Job>
				orderByComparator)
		throws NoSuchJobException;

	/**
	 * Removes all the jobs where groupId = &#63; and title LIKE &#63; from the database.
	 *
	 * @param groupId the group ID
	 * @param title the title
	 */
	public void removeByTitle_G(long groupId, String title);

	/**
	 * Returns the number of jobs where groupId = &#63; and title LIKE &#63;.
	 *
	 * @param groupId the group ID
	 * @param title the title
	 * @return the number of matching jobs
	 */
	public int countByTitle_G(long groupId, String title);

	/**
	 * Returns all the jobs where userId = &#63; and title LIKE &#63;.
	 *
	 * @param userId the user ID
	 * @param title the title
	 * @return the matching jobs
	 */
	public java.util.List<Job> findByTitle_U(long userId, String title);

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
	public java.util.List<Job> findByTitle_U(
		long userId, String title, int start, int end);

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
	public java.util.List<Job> findByTitle_U(
		long userId, String title, int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator<Job>
			orderByComparator);

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
	public java.util.List<Job> findByTitle_U(
		long userId, String title, int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator<Job> orderByComparator,
		boolean retrieveFromCache);

	/**
	 * Returns the first job in the ordered set where userId = &#63; and title LIKE &#63;.
	 *
	 * @param userId the user ID
	 * @param title the title
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching job
	 * @throws NoSuchJobException if a matching job could not be found
	 */
	public Job findByTitle_U_First(
			long userId, String title,
			com.liferay.portal.kernel.util.OrderByComparator<Job>
				orderByComparator)
		throws NoSuchJobException;

	/**
	 * Returns the first job in the ordered set where userId = &#63; and title LIKE &#63;.
	 *
	 * @param userId the user ID
	 * @param title the title
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching job, or <code>null</code> if a matching job could not be found
	 */
	public Job fetchByTitle_U_First(
		long userId, String title,
		com.liferay.portal.kernel.util.OrderByComparator<Job>
			orderByComparator);

	/**
	 * Returns the last job in the ordered set where userId = &#63; and title LIKE &#63;.
	 *
	 * @param userId the user ID
	 * @param title the title
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching job
	 * @throws NoSuchJobException if a matching job could not be found
	 */
	public Job findByTitle_U_Last(
			long userId, String title,
			com.liferay.portal.kernel.util.OrderByComparator<Job>
				orderByComparator)
		throws NoSuchJobException;

	/**
	 * Returns the last job in the ordered set where userId = &#63; and title LIKE &#63;.
	 *
	 * @param userId the user ID
	 * @param title the title
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching job, or <code>null</code> if a matching job could not be found
	 */
	public Job fetchByTitle_U_Last(
		long userId, String title,
		com.liferay.portal.kernel.util.OrderByComparator<Job>
			orderByComparator);

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
	public Job[] findByTitle_U_PrevAndNext(
			long jobId, long userId, String title,
			com.liferay.portal.kernel.util.OrderByComparator<Job>
				orderByComparator)
		throws NoSuchJobException;

	/**
	 * Removes all the jobs where userId = &#63; and title LIKE &#63; from the database.
	 *
	 * @param userId the user ID
	 * @param title the title
	 */
	public void removeByTitle_U(long userId, String title);

	/**
	 * Returns the number of jobs where userId = &#63; and title LIKE &#63;.
	 *
	 * @param userId the user ID
	 * @param title the title
	 * @return the number of matching jobs
	 */
	public int countByTitle_U(long userId, String title);

	/**
	 * Returns all the jobs where groupId = &#63; and userId = &#63; and title LIKE &#63;.
	 *
	 * @param groupId the group ID
	 * @param userId the user ID
	 * @param title the title
	 * @return the matching jobs
	 */
	public java.util.List<Job> findByTitle_G_U(
		long groupId, long userId, String title);

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
	public java.util.List<Job> findByTitle_G_U(
		long groupId, long userId, String title, int start, int end);

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
	public java.util.List<Job> findByTitle_G_U(
		long groupId, long userId, String title, int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator<Job>
			orderByComparator);

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
	public java.util.List<Job> findByTitle_G_U(
		long groupId, long userId, String title, int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator<Job> orderByComparator,
		boolean retrieveFromCache);

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
	public Job findByTitle_G_U_First(
			long groupId, long userId, String title,
			com.liferay.portal.kernel.util.OrderByComparator<Job>
				orderByComparator)
		throws NoSuchJobException;

	/**
	 * Returns the first job in the ordered set where groupId = &#63; and userId = &#63; and title LIKE &#63;.
	 *
	 * @param groupId the group ID
	 * @param userId the user ID
	 * @param title the title
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching job, or <code>null</code> if a matching job could not be found
	 */
	public Job fetchByTitle_G_U_First(
		long groupId, long userId, String title,
		com.liferay.portal.kernel.util.OrderByComparator<Job>
			orderByComparator);

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
	public Job findByTitle_G_U_Last(
			long groupId, long userId, String title,
			com.liferay.portal.kernel.util.OrderByComparator<Job>
				orderByComparator)
		throws NoSuchJobException;

	/**
	 * Returns the last job in the ordered set where groupId = &#63; and userId = &#63; and title LIKE &#63;.
	 *
	 * @param groupId the group ID
	 * @param userId the user ID
	 * @param title the title
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching job, or <code>null</code> if a matching job could not be found
	 */
	public Job fetchByTitle_G_U_Last(
		long groupId, long userId, String title,
		com.liferay.portal.kernel.util.OrderByComparator<Job>
			orderByComparator);

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
	public Job[] findByTitle_G_U_PrevAndNext(
			long jobId, long groupId, long userId, String title,
			com.liferay.portal.kernel.util.OrderByComparator<Job>
				orderByComparator)
		throws NoSuchJobException;

	/**
	 * Removes all the jobs where groupId = &#63; and userId = &#63; and title LIKE &#63; from the database.
	 *
	 * @param groupId the group ID
	 * @param userId the user ID
	 * @param title the title
	 */
	public void removeByTitle_G_U(long groupId, long userId, String title);

	/**
	 * Returns the number of jobs where groupId = &#63; and userId = &#63; and title LIKE &#63;.
	 *
	 * @param groupId the group ID
	 * @param userId the user ID
	 * @param title the title
	 * @return the number of matching jobs
	 */
	public int countByTitle_G_U(long groupId, long userId, String title);

	/**
	 * Returns all the jobs where clusterId = &#63;.
	 *
	 * @param clusterId the cluster ID
	 * @return the matching jobs
	 */
	public java.util.List<Job> findByClusterId(long clusterId);

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
	public java.util.List<Job> findByClusterId(
		long clusterId, int start, int end);

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
	public java.util.List<Job> findByClusterId(
		long clusterId, int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator<Job>
			orderByComparator);

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
	public java.util.List<Job> findByClusterId(
		long clusterId, int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator<Job> orderByComparator,
		boolean retrieveFromCache);

	/**
	 * Returns the first job in the ordered set where clusterId = &#63;.
	 *
	 * @param clusterId the cluster ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching job
	 * @throws NoSuchJobException if a matching job could not be found
	 */
	public Job findByClusterId_First(
			long clusterId,
			com.liferay.portal.kernel.util.OrderByComparator<Job>
				orderByComparator)
		throws NoSuchJobException;

	/**
	 * Returns the first job in the ordered set where clusterId = &#63;.
	 *
	 * @param clusterId the cluster ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching job, or <code>null</code> if a matching job could not be found
	 */
	public Job fetchByClusterId_First(
		long clusterId,
		com.liferay.portal.kernel.util.OrderByComparator<Job>
			orderByComparator);

	/**
	 * Returns the last job in the ordered set where clusterId = &#63;.
	 *
	 * @param clusterId the cluster ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching job
	 * @throws NoSuchJobException if a matching job could not be found
	 */
	public Job findByClusterId_Last(
			long clusterId,
			com.liferay.portal.kernel.util.OrderByComparator<Job>
				orderByComparator)
		throws NoSuchJobException;

	/**
	 * Returns the last job in the ordered set where clusterId = &#63;.
	 *
	 * @param clusterId the cluster ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching job, or <code>null</code> if a matching job could not be found
	 */
	public Job fetchByClusterId_Last(
		long clusterId,
		com.liferay.portal.kernel.util.OrderByComparator<Job>
			orderByComparator);

	/**
	 * Returns the jobs before and after the current job in the ordered set where clusterId = &#63;.
	 *
	 * @param jobId the primary key of the current job
	 * @param clusterId the cluster ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the previous, current, and next job
	 * @throws NoSuchJobException if a job with the primary key could not be found
	 */
	public Job[] findByClusterId_PrevAndNext(
			long jobId, long clusterId,
			com.liferay.portal.kernel.util.OrderByComparator<Job>
				orderByComparator)
		throws NoSuchJobException;

	/**
	 * Removes all the jobs where clusterId = &#63; from the database.
	 *
	 * @param clusterId the cluster ID
	 */
	public void removeByClusterId(long clusterId);

	/**
	 * Returns the number of jobs where clusterId = &#63;.
	 *
	 * @param clusterId the cluster ID
	 * @return the number of matching jobs
	 */
	public int countByClusterId(long clusterId);

	/**
	 * Returns all the jobs where groupId = &#63; and clusterId = &#63;.
	 *
	 * @param groupId the group ID
	 * @param clusterId the cluster ID
	 * @return the matching jobs
	 */
	public java.util.List<Job> findByClusterId_G(long groupId, long clusterId);

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
	public java.util.List<Job> findByClusterId_G(
		long groupId, long clusterId, int start, int end);

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
	public java.util.List<Job> findByClusterId_G(
		long groupId, long clusterId, int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator<Job>
			orderByComparator);

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
	public java.util.List<Job> findByClusterId_G(
		long groupId, long clusterId, int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator<Job> orderByComparator,
		boolean retrieveFromCache);

	/**
	 * Returns the first job in the ordered set where groupId = &#63; and clusterId = &#63;.
	 *
	 * @param groupId the group ID
	 * @param clusterId the cluster ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching job
	 * @throws NoSuchJobException if a matching job could not be found
	 */
	public Job findByClusterId_G_First(
			long groupId, long clusterId,
			com.liferay.portal.kernel.util.OrderByComparator<Job>
				orderByComparator)
		throws NoSuchJobException;

	/**
	 * Returns the first job in the ordered set where groupId = &#63; and clusterId = &#63;.
	 *
	 * @param groupId the group ID
	 * @param clusterId the cluster ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching job, or <code>null</code> if a matching job could not be found
	 */
	public Job fetchByClusterId_G_First(
		long groupId, long clusterId,
		com.liferay.portal.kernel.util.OrderByComparator<Job>
			orderByComparator);

	/**
	 * Returns the last job in the ordered set where groupId = &#63; and clusterId = &#63;.
	 *
	 * @param groupId the group ID
	 * @param clusterId the cluster ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching job
	 * @throws NoSuchJobException if a matching job could not be found
	 */
	public Job findByClusterId_G_Last(
			long groupId, long clusterId,
			com.liferay.portal.kernel.util.OrderByComparator<Job>
				orderByComparator)
		throws NoSuchJobException;

	/**
	 * Returns the last job in the ordered set where groupId = &#63; and clusterId = &#63;.
	 *
	 * @param groupId the group ID
	 * @param clusterId the cluster ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching job, or <code>null</code> if a matching job could not be found
	 */
	public Job fetchByClusterId_G_Last(
		long groupId, long clusterId,
		com.liferay.portal.kernel.util.OrderByComparator<Job>
			orderByComparator);

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
	public Job[] findByClusterId_G_PrevAndNext(
			long jobId, long groupId, long clusterId,
			com.liferay.portal.kernel.util.OrderByComparator<Job>
				orderByComparator)
		throws NoSuchJobException;

	/**
	 * Removes all the jobs where groupId = &#63; and clusterId = &#63; from the database.
	 *
	 * @param groupId the group ID
	 * @param clusterId the cluster ID
	 */
	public void removeByClusterId_G(long groupId, long clusterId);

	/**
	 * Returns the number of jobs where groupId = &#63; and clusterId = &#63;.
	 *
	 * @param groupId the group ID
	 * @param clusterId the cluster ID
	 * @return the number of matching jobs
	 */
	public int countByClusterId_G(long groupId, long clusterId);

	/**
	 * Returns all the jobs where userId = &#63; and clusterId = &#63;.
	 *
	 * @param userId the user ID
	 * @param clusterId the cluster ID
	 * @return the matching jobs
	 */
	public java.util.List<Job> findByClusterId_U(long userId, long clusterId);

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
	public java.util.List<Job> findByClusterId_U(
		long userId, long clusterId, int start, int end);

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
	public java.util.List<Job> findByClusterId_U(
		long userId, long clusterId, int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator<Job>
			orderByComparator);

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
	public java.util.List<Job> findByClusterId_U(
		long userId, long clusterId, int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator<Job> orderByComparator,
		boolean retrieveFromCache);

	/**
	 * Returns the first job in the ordered set where userId = &#63; and clusterId = &#63;.
	 *
	 * @param userId the user ID
	 * @param clusterId the cluster ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching job
	 * @throws NoSuchJobException if a matching job could not be found
	 */
	public Job findByClusterId_U_First(
			long userId, long clusterId,
			com.liferay.portal.kernel.util.OrderByComparator<Job>
				orderByComparator)
		throws NoSuchJobException;

	/**
	 * Returns the first job in the ordered set where userId = &#63; and clusterId = &#63;.
	 *
	 * @param userId the user ID
	 * @param clusterId the cluster ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching job, or <code>null</code> if a matching job could not be found
	 */
	public Job fetchByClusterId_U_First(
		long userId, long clusterId,
		com.liferay.portal.kernel.util.OrderByComparator<Job>
			orderByComparator);

	/**
	 * Returns the last job in the ordered set where userId = &#63; and clusterId = &#63;.
	 *
	 * @param userId the user ID
	 * @param clusterId the cluster ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching job
	 * @throws NoSuchJobException if a matching job could not be found
	 */
	public Job findByClusterId_U_Last(
			long userId, long clusterId,
			com.liferay.portal.kernel.util.OrderByComparator<Job>
				orderByComparator)
		throws NoSuchJobException;

	/**
	 * Returns the last job in the ordered set where userId = &#63; and clusterId = &#63;.
	 *
	 * @param userId the user ID
	 * @param clusterId the cluster ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching job, or <code>null</code> if a matching job could not be found
	 */
	public Job fetchByClusterId_U_Last(
		long userId, long clusterId,
		com.liferay.portal.kernel.util.OrderByComparator<Job>
			orderByComparator);

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
	public Job[] findByClusterId_U_PrevAndNext(
			long jobId, long userId, long clusterId,
			com.liferay.portal.kernel.util.OrderByComparator<Job>
				orderByComparator)
		throws NoSuchJobException;

	/**
	 * Removes all the jobs where userId = &#63; and clusterId = &#63; from the database.
	 *
	 * @param userId the user ID
	 * @param clusterId the cluster ID
	 */
	public void removeByClusterId_U(long userId, long clusterId);

	/**
	 * Returns the number of jobs where userId = &#63; and clusterId = &#63;.
	 *
	 * @param userId the user ID
	 * @param clusterId the cluster ID
	 * @return the number of matching jobs
	 */
	public int countByClusterId_U(long userId, long clusterId);

	/**
	 * Returns all the jobs where groupId = &#63; and userId = &#63; and clusterId = &#63;.
	 *
	 * @param groupId the group ID
	 * @param userId the user ID
	 * @param clusterId the cluster ID
	 * @return the matching jobs
	 */
	public java.util.List<Job> findByClusterId_G_U(
		long groupId, long userId, long clusterId);

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
	public java.util.List<Job> findByClusterId_G_U(
		long groupId, long userId, long clusterId, int start, int end);

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
	public java.util.List<Job> findByClusterId_G_U(
		long groupId, long userId, long clusterId, int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator<Job>
			orderByComparator);

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
	public java.util.List<Job> findByClusterId_G_U(
		long groupId, long userId, long clusterId, int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator<Job> orderByComparator,
		boolean retrieveFromCache);

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
	public Job findByClusterId_G_U_First(
			long groupId, long userId, long clusterId,
			com.liferay.portal.kernel.util.OrderByComparator<Job>
				orderByComparator)
		throws NoSuchJobException;

	/**
	 * Returns the first job in the ordered set where groupId = &#63; and userId = &#63; and clusterId = &#63;.
	 *
	 * @param groupId the group ID
	 * @param userId the user ID
	 * @param clusterId the cluster ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching job, or <code>null</code> if a matching job could not be found
	 */
	public Job fetchByClusterId_G_U_First(
		long groupId, long userId, long clusterId,
		com.liferay.portal.kernel.util.OrderByComparator<Job>
			orderByComparator);

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
	public Job findByClusterId_G_U_Last(
			long groupId, long userId, long clusterId,
			com.liferay.portal.kernel.util.OrderByComparator<Job>
				orderByComparator)
		throws NoSuchJobException;

	/**
	 * Returns the last job in the ordered set where groupId = &#63; and userId = &#63; and clusterId = &#63;.
	 *
	 * @param groupId the group ID
	 * @param userId the user ID
	 * @param clusterId the cluster ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching job, or <code>null</code> if a matching job could not be found
	 */
	public Job fetchByClusterId_G_U_Last(
		long groupId, long userId, long clusterId,
		com.liferay.portal.kernel.util.OrderByComparator<Job>
			orderByComparator);

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
	public Job[] findByClusterId_G_U_PrevAndNext(
			long jobId, long groupId, long userId, long clusterId,
			com.liferay.portal.kernel.util.OrderByComparator<Job>
				orderByComparator)
		throws NoSuchJobException;

	/**
	 * Removes all the jobs where groupId = &#63; and userId = &#63; and clusterId = &#63; from the database.
	 *
	 * @param groupId the group ID
	 * @param userId the user ID
	 * @param clusterId the cluster ID
	 */
	public void removeByClusterId_G_U(
		long groupId, long userId, long clusterId);

	/**
	 * Returns the number of jobs where groupId = &#63; and userId = &#63; and clusterId = &#63;.
	 *
	 * @param groupId the group ID
	 * @param userId the user ID
	 * @param clusterId the cluster ID
	 * @return the number of matching jobs
	 */
	public int countByClusterId_G_U(long groupId, long userId, long clusterId);

	/**
	 * Returns all the jobs where runType = &#63;.
	 *
	 * @param runType the run type
	 * @return the matching jobs
	 */
	public java.util.List<Job> findByRunType(String runType);

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
	public java.util.List<Job> findByRunType(
		String runType, int start, int end);

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
	public java.util.List<Job> findByRunType(
		String runType, int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator<Job>
			orderByComparator);

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
	public java.util.List<Job> findByRunType(
		String runType, int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator<Job> orderByComparator,
		boolean retrieveFromCache);

	/**
	 * Returns the first job in the ordered set where runType = &#63;.
	 *
	 * @param runType the run type
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching job
	 * @throws NoSuchJobException if a matching job could not be found
	 */
	public Job findByRunType_First(
			String runType,
			com.liferay.portal.kernel.util.OrderByComparator<Job>
				orderByComparator)
		throws NoSuchJobException;

	/**
	 * Returns the first job in the ordered set where runType = &#63;.
	 *
	 * @param runType the run type
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching job, or <code>null</code> if a matching job could not be found
	 */
	public Job fetchByRunType_First(
		String runType,
		com.liferay.portal.kernel.util.OrderByComparator<Job>
			orderByComparator);

	/**
	 * Returns the last job in the ordered set where runType = &#63;.
	 *
	 * @param runType the run type
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching job
	 * @throws NoSuchJobException if a matching job could not be found
	 */
	public Job findByRunType_Last(
			String runType,
			com.liferay.portal.kernel.util.OrderByComparator<Job>
				orderByComparator)
		throws NoSuchJobException;

	/**
	 * Returns the last job in the ordered set where runType = &#63;.
	 *
	 * @param runType the run type
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching job, or <code>null</code> if a matching job could not be found
	 */
	public Job fetchByRunType_Last(
		String runType,
		com.liferay.portal.kernel.util.OrderByComparator<Job>
			orderByComparator);

	/**
	 * Returns the jobs before and after the current job in the ordered set where runType = &#63;.
	 *
	 * @param jobId the primary key of the current job
	 * @param runType the run type
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the previous, current, and next job
	 * @throws NoSuchJobException if a job with the primary key could not be found
	 */
	public Job[] findByRunType_PrevAndNext(
			long jobId, String runType,
			com.liferay.portal.kernel.util.OrderByComparator<Job>
				orderByComparator)
		throws NoSuchJobException;

	/**
	 * Removes all the jobs where runType = &#63; from the database.
	 *
	 * @param runType the run type
	 */
	public void removeByRunType(String runType);

	/**
	 * Returns the number of jobs where runType = &#63;.
	 *
	 * @param runType the run type
	 * @return the number of matching jobs
	 */
	public int countByRunType(String runType);

	/**
	 * Returns all the jobs where groupId = &#63; and runType = &#63;.
	 *
	 * @param groupId the group ID
	 * @param runType the run type
	 * @return the matching jobs
	 */
	public java.util.List<Job> findByRunType_G(long groupId, String runType);

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
	public java.util.List<Job> findByRunType_G(
		long groupId, String runType, int start, int end);

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
	public java.util.List<Job> findByRunType_G(
		long groupId, String runType, int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator<Job>
			orderByComparator);

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
	public java.util.List<Job> findByRunType_G(
		long groupId, String runType, int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator<Job> orderByComparator,
		boolean retrieveFromCache);

	/**
	 * Returns the first job in the ordered set where groupId = &#63; and runType = &#63;.
	 *
	 * @param groupId the group ID
	 * @param runType the run type
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching job
	 * @throws NoSuchJobException if a matching job could not be found
	 */
	public Job findByRunType_G_First(
			long groupId, String runType,
			com.liferay.portal.kernel.util.OrderByComparator<Job>
				orderByComparator)
		throws NoSuchJobException;

	/**
	 * Returns the first job in the ordered set where groupId = &#63; and runType = &#63;.
	 *
	 * @param groupId the group ID
	 * @param runType the run type
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching job, or <code>null</code> if a matching job could not be found
	 */
	public Job fetchByRunType_G_First(
		long groupId, String runType,
		com.liferay.portal.kernel.util.OrderByComparator<Job>
			orderByComparator);

	/**
	 * Returns the last job in the ordered set where groupId = &#63; and runType = &#63;.
	 *
	 * @param groupId the group ID
	 * @param runType the run type
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching job
	 * @throws NoSuchJobException if a matching job could not be found
	 */
	public Job findByRunType_G_Last(
			long groupId, String runType,
			com.liferay.portal.kernel.util.OrderByComparator<Job>
				orderByComparator)
		throws NoSuchJobException;

	/**
	 * Returns the last job in the ordered set where groupId = &#63; and runType = &#63;.
	 *
	 * @param groupId the group ID
	 * @param runType the run type
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching job, or <code>null</code> if a matching job could not be found
	 */
	public Job fetchByRunType_G_Last(
		long groupId, String runType,
		com.liferay.portal.kernel.util.OrderByComparator<Job>
			orderByComparator);

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
	public Job[] findByRunType_G_PrevAndNext(
			long jobId, long groupId, String runType,
			com.liferay.portal.kernel.util.OrderByComparator<Job>
				orderByComparator)
		throws NoSuchJobException;

	/**
	 * Removes all the jobs where groupId = &#63; and runType = &#63; from the database.
	 *
	 * @param groupId the group ID
	 * @param runType the run type
	 */
	public void removeByRunType_G(long groupId, String runType);

	/**
	 * Returns the number of jobs where groupId = &#63; and runType = &#63;.
	 *
	 * @param groupId the group ID
	 * @param runType the run type
	 * @return the number of matching jobs
	 */
	public int countByRunType_G(long groupId, String runType);

	/**
	 * Returns all the jobs where userId = &#63; and runType = &#63;.
	 *
	 * @param userId the user ID
	 * @param runType the run type
	 * @return the matching jobs
	 */
	public java.util.List<Job> findByRunType_U(long userId, String runType);

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
	public java.util.List<Job> findByRunType_U(
		long userId, String runType, int start, int end);

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
	public java.util.List<Job> findByRunType_U(
		long userId, String runType, int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator<Job>
			orderByComparator);

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
	public java.util.List<Job> findByRunType_U(
		long userId, String runType, int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator<Job> orderByComparator,
		boolean retrieveFromCache);

	/**
	 * Returns the first job in the ordered set where userId = &#63; and runType = &#63;.
	 *
	 * @param userId the user ID
	 * @param runType the run type
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching job
	 * @throws NoSuchJobException if a matching job could not be found
	 */
	public Job findByRunType_U_First(
			long userId, String runType,
			com.liferay.portal.kernel.util.OrderByComparator<Job>
				orderByComparator)
		throws NoSuchJobException;

	/**
	 * Returns the first job in the ordered set where userId = &#63; and runType = &#63;.
	 *
	 * @param userId the user ID
	 * @param runType the run type
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching job, or <code>null</code> if a matching job could not be found
	 */
	public Job fetchByRunType_U_First(
		long userId, String runType,
		com.liferay.portal.kernel.util.OrderByComparator<Job>
			orderByComparator);

	/**
	 * Returns the last job in the ordered set where userId = &#63; and runType = &#63;.
	 *
	 * @param userId the user ID
	 * @param runType the run type
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching job
	 * @throws NoSuchJobException if a matching job could not be found
	 */
	public Job findByRunType_U_Last(
			long userId, String runType,
			com.liferay.portal.kernel.util.OrderByComparator<Job>
				orderByComparator)
		throws NoSuchJobException;

	/**
	 * Returns the last job in the ordered set where userId = &#63; and runType = &#63;.
	 *
	 * @param userId the user ID
	 * @param runType the run type
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching job, or <code>null</code> if a matching job could not be found
	 */
	public Job fetchByRunType_U_Last(
		long userId, String runType,
		com.liferay.portal.kernel.util.OrderByComparator<Job>
			orderByComparator);

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
	public Job[] findByRunType_U_PrevAndNext(
			long jobId, long userId, String runType,
			com.liferay.portal.kernel.util.OrderByComparator<Job>
				orderByComparator)
		throws NoSuchJobException;

	/**
	 * Removes all the jobs where userId = &#63; and runType = &#63; from the database.
	 *
	 * @param userId the user ID
	 * @param runType the run type
	 */
	public void removeByRunType_U(long userId, String runType);

	/**
	 * Returns the number of jobs where userId = &#63; and runType = &#63;.
	 *
	 * @param userId the user ID
	 * @param runType the run type
	 * @return the number of matching jobs
	 */
	public int countByRunType_U(long userId, String runType);

	/**
	 * Returns all the jobs where groupId = &#63; and userId = &#63; and runType = &#63;.
	 *
	 * @param groupId the group ID
	 * @param userId the user ID
	 * @param runType the run type
	 * @return the matching jobs
	 */
	public java.util.List<Job> findByRunType_G_U(
		long groupId, long userId, String runType);

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
	public java.util.List<Job> findByRunType_G_U(
		long groupId, long userId, String runType, int start, int end);

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
	public java.util.List<Job> findByRunType_G_U(
		long groupId, long userId, String runType, int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator<Job>
			orderByComparator);

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
	public java.util.List<Job> findByRunType_G_U(
		long groupId, long userId, String runType, int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator<Job> orderByComparator,
		boolean retrieveFromCache);

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
	public Job findByRunType_G_U_First(
			long groupId, long userId, String runType,
			com.liferay.portal.kernel.util.OrderByComparator<Job>
				orderByComparator)
		throws NoSuchJobException;

	/**
	 * Returns the first job in the ordered set where groupId = &#63; and userId = &#63; and runType = &#63;.
	 *
	 * @param groupId the group ID
	 * @param userId the user ID
	 * @param runType the run type
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching job, or <code>null</code> if a matching job could not be found
	 */
	public Job fetchByRunType_G_U_First(
		long groupId, long userId, String runType,
		com.liferay.portal.kernel.util.OrderByComparator<Job>
			orderByComparator);

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
	public Job findByRunType_G_U_Last(
			long groupId, long userId, String runType,
			com.liferay.portal.kernel.util.OrderByComparator<Job>
				orderByComparator)
		throws NoSuchJobException;

	/**
	 * Returns the last job in the ordered set where groupId = &#63; and userId = &#63; and runType = &#63;.
	 *
	 * @param groupId the group ID
	 * @param userId the user ID
	 * @param runType the run type
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching job, or <code>null</code> if a matching job could not be found
	 */
	public Job fetchByRunType_G_U_Last(
		long groupId, long userId, String runType,
		com.liferay.portal.kernel.util.OrderByComparator<Job>
			orderByComparator);

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
	public Job[] findByRunType_G_U_PrevAndNext(
			long jobId, long groupId, long userId, String runType,
			com.liferay.portal.kernel.util.OrderByComparator<Job>
				orderByComparator)
		throws NoSuchJobException;

	/**
	 * Removes all the jobs where groupId = &#63; and userId = &#63; and runType = &#63; from the database.
	 *
	 * @param groupId the group ID
	 * @param userId the user ID
	 * @param runType the run type
	 */
	public void removeByRunType_G_U(long groupId, long userId, String runType);

	/**
	 * Returns the number of jobs where groupId = &#63; and userId = &#63; and runType = &#63;.
	 *
	 * @param groupId the group ID
	 * @param userId the user ID
	 * @param runType the run type
	 * @return the number of matching jobs
	 */
	public int countByRunType_G_U(long groupId, long userId, String runType);

	/**
	 * Caches the job in the entity cache if it is enabled.
	 *
	 * @param job the job
	 */
	public void cacheResult(Job job);

	/**
	 * Caches the jobs in the entity cache if it is enabled.
	 *
	 * @param jobs the jobs
	 */
	public void cacheResult(java.util.List<Job> jobs);

	/**
	 * Creates a new job with the primary key. Does not add the job to the database.
	 *
	 * @param jobId the primary key for the new job
	 * @return the new job
	 */
	public Job create(long jobId);

	/**
	 * Removes the job with the primary key from the database. Also notifies the appropriate model listeners.
	 *
	 * @param jobId the primary key of the job
	 * @return the job that was removed
	 * @throws NoSuchJobException if a job with the primary key could not be found
	 */
	public Job remove(long jobId) throws NoSuchJobException;

	public Job updateImpl(Job job);

	/**
	 * Returns the job with the primary key or throws a <code>NoSuchJobException</code> if it could not be found.
	 *
	 * @param jobId the primary key of the job
	 * @return the job
	 * @throws NoSuchJobException if a job with the primary key could not be found
	 */
	public Job findByPrimaryKey(long jobId) throws NoSuchJobException;

	/**
	 * Returns the job with the primary key or returns <code>null</code> if it could not be found.
	 *
	 * @param jobId the primary key of the job
	 * @return the job, or <code>null</code> if a job with the primary key could not be found
	 */
	public Job fetchByPrimaryKey(long jobId);

	/**
	 * Returns all the jobs.
	 *
	 * @return the jobs
	 */
	public java.util.List<Job> findAll();

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
	public java.util.List<Job> findAll(int start, int end);

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
	public java.util.List<Job> findAll(
		int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator<Job>
			orderByComparator);

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
	public java.util.List<Job> findAll(
		int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator<Job> orderByComparator,
		boolean retrieveFromCache);

	/**
	 * Removes all the jobs from the database.
	 */
	public void removeAll();

	/**
	 * Returns the number of jobs.
	 *
	 * @return the number of jobs
	 */
	public int countAll();

}