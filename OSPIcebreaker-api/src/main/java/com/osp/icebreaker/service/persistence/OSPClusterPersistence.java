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

import com.osp.icebreaker.exception.NoSuchOSPClusterException;
import com.osp.icebreaker.model.OSPCluster;

import org.osgi.annotation.versioning.ProviderType;

/**
 * The persistence interface for the osp cluster service.
 *
 * <p>
 * Caching information and settings can be found in <code>portal.properties</code>
 * </p>
 *
 * @author Jerry H. Seo
 * @see OSPClusterUtil
 * @generated
 */
@ProviderType
public interface OSPClusterPersistence extends BasePersistence<OSPCluster> {

	/*
	 * NOTE FOR DEVELOPERS:
	 *
	 * Never modify or reference this interface directly. Always use {@link OSPClusterUtil} to access the osp cluster persistence. Modify <code>service.xml</code> and rerun ServiceBuilder to regenerate this interface.
	 */

	/**
	 * Returns all the osp clusters where uuid = &#63;.
	 *
	 * @param uuid the uuid
	 * @return the matching osp clusters
	 */
	public java.util.List<OSPCluster> findByUuid(String uuid);

	/**
	 * Returns a range of all the osp clusters where uuid = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>OSPClusterModelImpl</code>.
	 * </p>
	 *
	 * @param uuid the uuid
	 * @param start the lower bound of the range of osp clusters
	 * @param end the upper bound of the range of osp clusters (not inclusive)
	 * @return the range of matching osp clusters
	 */
	public java.util.List<OSPCluster> findByUuid(
		String uuid, int start, int end);

	/**
	 * Returns an ordered range of all the osp clusters where uuid = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>OSPClusterModelImpl</code>.
	 * </p>
	 *
	 * @param uuid the uuid
	 * @param start the lower bound of the range of osp clusters
	 * @param end the upper bound of the range of osp clusters (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @return the ordered range of matching osp clusters
	 */
	public java.util.List<OSPCluster> findByUuid(
		String uuid, int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator<OSPCluster>
			orderByComparator);

	/**
	 * Returns an ordered range of all the osp clusters where uuid = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>OSPClusterModelImpl</code>.
	 * </p>
	 *
	 * @param uuid the uuid
	 * @param start the lower bound of the range of osp clusters
	 * @param end the upper bound of the range of osp clusters (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @param useFinderCache whether to use the finder cache
	 * @return the ordered range of matching osp clusters
	 */
	public java.util.List<OSPCluster> findByUuid(
		String uuid, int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator<OSPCluster>
			orderByComparator,
		boolean useFinderCache);

	/**
	 * Returns the first osp cluster in the ordered set where uuid = &#63;.
	 *
	 * @param uuid the uuid
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching osp cluster
	 * @throws NoSuchOSPClusterException if a matching osp cluster could not be found
	 */
	public OSPCluster findByUuid_First(
			String uuid,
			com.liferay.portal.kernel.util.OrderByComparator<OSPCluster>
				orderByComparator)
		throws NoSuchOSPClusterException;

	/**
	 * Returns the first osp cluster in the ordered set where uuid = &#63;.
	 *
	 * @param uuid the uuid
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching osp cluster, or <code>null</code> if a matching osp cluster could not be found
	 */
	public OSPCluster fetchByUuid_First(
		String uuid,
		com.liferay.portal.kernel.util.OrderByComparator<OSPCluster>
			orderByComparator);

	/**
	 * Returns the last osp cluster in the ordered set where uuid = &#63;.
	 *
	 * @param uuid the uuid
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching osp cluster
	 * @throws NoSuchOSPClusterException if a matching osp cluster could not be found
	 */
	public OSPCluster findByUuid_Last(
			String uuid,
			com.liferay.portal.kernel.util.OrderByComparator<OSPCluster>
				orderByComparator)
		throws NoSuchOSPClusterException;

	/**
	 * Returns the last osp cluster in the ordered set where uuid = &#63;.
	 *
	 * @param uuid the uuid
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching osp cluster, or <code>null</code> if a matching osp cluster could not be found
	 */
	public OSPCluster fetchByUuid_Last(
		String uuid,
		com.liferay.portal.kernel.util.OrderByComparator<OSPCluster>
			orderByComparator);

	/**
	 * Returns the osp clusters before and after the current osp cluster in the ordered set where uuid = &#63;.
	 *
	 * @param clusterId the primary key of the current osp cluster
	 * @param uuid the uuid
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the previous, current, and next osp cluster
	 * @throws NoSuchOSPClusterException if a osp cluster with the primary key could not be found
	 */
	public OSPCluster[] findByUuid_PrevAndNext(
			long clusterId, String uuid,
			com.liferay.portal.kernel.util.OrderByComparator<OSPCluster>
				orderByComparator)
		throws NoSuchOSPClusterException;

	/**
	 * Removes all the osp clusters where uuid = &#63; from the database.
	 *
	 * @param uuid the uuid
	 */
	public void removeByUuid(String uuid);

	/**
	 * Returns the number of osp clusters where uuid = &#63;.
	 *
	 * @param uuid the uuid
	 * @return the number of matching osp clusters
	 */
	public int countByUuid(String uuid);

	/**
	 * Returns the osp cluster where uuid = &#63; and groupId = &#63; or throws a <code>NoSuchOSPClusterException</code> if it could not be found.
	 *
	 * @param uuid the uuid
	 * @param groupId the group ID
	 * @return the matching osp cluster
	 * @throws NoSuchOSPClusterException if a matching osp cluster could not be found
	 */
	public OSPCluster findByUUID_G(String uuid, long groupId)
		throws NoSuchOSPClusterException;

	/**
	 * Returns the osp cluster where uuid = &#63; and groupId = &#63; or returns <code>null</code> if it could not be found. Uses the finder cache.
	 *
	 * @param uuid the uuid
	 * @param groupId the group ID
	 * @return the matching osp cluster, or <code>null</code> if a matching osp cluster could not be found
	 */
	public OSPCluster fetchByUUID_G(String uuid, long groupId);

	/**
	 * Returns the osp cluster where uuid = &#63; and groupId = &#63; or returns <code>null</code> if it could not be found, optionally using the finder cache.
	 *
	 * @param uuid the uuid
	 * @param groupId the group ID
	 * @param useFinderCache whether to use the finder cache
	 * @return the matching osp cluster, or <code>null</code> if a matching osp cluster could not be found
	 */
	public OSPCluster fetchByUUID_G(
		String uuid, long groupId, boolean useFinderCache);

	/**
	 * Removes the osp cluster where uuid = &#63; and groupId = &#63; from the database.
	 *
	 * @param uuid the uuid
	 * @param groupId the group ID
	 * @return the osp cluster that was removed
	 */
	public OSPCluster removeByUUID_G(String uuid, long groupId)
		throws NoSuchOSPClusterException;

	/**
	 * Returns the number of osp clusters where uuid = &#63; and groupId = &#63;.
	 *
	 * @param uuid the uuid
	 * @param groupId the group ID
	 * @return the number of matching osp clusters
	 */
	public int countByUUID_G(String uuid, long groupId);

	/**
	 * Returns all the osp clusters where uuid = &#63; and companyId = &#63;.
	 *
	 * @param uuid the uuid
	 * @param companyId the company ID
	 * @return the matching osp clusters
	 */
	public java.util.List<OSPCluster> findByUuid_C(String uuid, long companyId);

	/**
	 * Returns a range of all the osp clusters where uuid = &#63; and companyId = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>OSPClusterModelImpl</code>.
	 * </p>
	 *
	 * @param uuid the uuid
	 * @param companyId the company ID
	 * @param start the lower bound of the range of osp clusters
	 * @param end the upper bound of the range of osp clusters (not inclusive)
	 * @return the range of matching osp clusters
	 */
	public java.util.List<OSPCluster> findByUuid_C(
		String uuid, long companyId, int start, int end);

	/**
	 * Returns an ordered range of all the osp clusters where uuid = &#63; and companyId = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>OSPClusterModelImpl</code>.
	 * </p>
	 *
	 * @param uuid the uuid
	 * @param companyId the company ID
	 * @param start the lower bound of the range of osp clusters
	 * @param end the upper bound of the range of osp clusters (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @return the ordered range of matching osp clusters
	 */
	public java.util.List<OSPCluster> findByUuid_C(
		String uuid, long companyId, int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator<OSPCluster>
			orderByComparator);

	/**
	 * Returns an ordered range of all the osp clusters where uuid = &#63; and companyId = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>OSPClusterModelImpl</code>.
	 * </p>
	 *
	 * @param uuid the uuid
	 * @param companyId the company ID
	 * @param start the lower bound of the range of osp clusters
	 * @param end the upper bound of the range of osp clusters (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @param useFinderCache whether to use the finder cache
	 * @return the ordered range of matching osp clusters
	 */
	public java.util.List<OSPCluster> findByUuid_C(
		String uuid, long companyId, int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator<OSPCluster>
			orderByComparator,
		boolean useFinderCache);

	/**
	 * Returns the first osp cluster in the ordered set where uuid = &#63; and companyId = &#63;.
	 *
	 * @param uuid the uuid
	 * @param companyId the company ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching osp cluster
	 * @throws NoSuchOSPClusterException if a matching osp cluster could not be found
	 */
	public OSPCluster findByUuid_C_First(
			String uuid, long companyId,
			com.liferay.portal.kernel.util.OrderByComparator<OSPCluster>
				orderByComparator)
		throws NoSuchOSPClusterException;

	/**
	 * Returns the first osp cluster in the ordered set where uuid = &#63; and companyId = &#63;.
	 *
	 * @param uuid the uuid
	 * @param companyId the company ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching osp cluster, or <code>null</code> if a matching osp cluster could not be found
	 */
	public OSPCluster fetchByUuid_C_First(
		String uuid, long companyId,
		com.liferay.portal.kernel.util.OrderByComparator<OSPCluster>
			orderByComparator);

	/**
	 * Returns the last osp cluster in the ordered set where uuid = &#63; and companyId = &#63;.
	 *
	 * @param uuid the uuid
	 * @param companyId the company ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching osp cluster
	 * @throws NoSuchOSPClusterException if a matching osp cluster could not be found
	 */
	public OSPCluster findByUuid_C_Last(
			String uuid, long companyId,
			com.liferay.portal.kernel.util.OrderByComparator<OSPCluster>
				orderByComparator)
		throws NoSuchOSPClusterException;

	/**
	 * Returns the last osp cluster in the ordered set where uuid = &#63; and companyId = &#63;.
	 *
	 * @param uuid the uuid
	 * @param companyId the company ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching osp cluster, or <code>null</code> if a matching osp cluster could not be found
	 */
	public OSPCluster fetchByUuid_C_Last(
		String uuid, long companyId,
		com.liferay.portal.kernel.util.OrderByComparator<OSPCluster>
			orderByComparator);

	/**
	 * Returns the osp clusters before and after the current osp cluster in the ordered set where uuid = &#63; and companyId = &#63;.
	 *
	 * @param clusterId the primary key of the current osp cluster
	 * @param uuid the uuid
	 * @param companyId the company ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the previous, current, and next osp cluster
	 * @throws NoSuchOSPClusterException if a osp cluster with the primary key could not be found
	 */
	public OSPCluster[] findByUuid_C_PrevAndNext(
			long clusterId, String uuid, long companyId,
			com.liferay.portal.kernel.util.OrderByComparator<OSPCluster>
				orderByComparator)
		throws NoSuchOSPClusterException;

	/**
	 * Removes all the osp clusters where uuid = &#63; and companyId = &#63; from the database.
	 *
	 * @param uuid the uuid
	 * @param companyId the company ID
	 */
	public void removeByUuid_C(String uuid, long companyId);

	/**
	 * Returns the number of osp clusters where uuid = &#63; and companyId = &#63;.
	 *
	 * @param uuid the uuid
	 * @param companyId the company ID
	 * @return the number of matching osp clusters
	 */
	public int countByUuid_C(String uuid, long companyId);

	/**
	 * Returns all the osp clusters where groupId = &#63;.
	 *
	 * @param groupId the group ID
	 * @return the matching osp clusters
	 */
	public java.util.List<OSPCluster> findByGroupId(long groupId);

	/**
	 * Returns a range of all the osp clusters where groupId = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>OSPClusterModelImpl</code>.
	 * </p>
	 *
	 * @param groupId the group ID
	 * @param start the lower bound of the range of osp clusters
	 * @param end the upper bound of the range of osp clusters (not inclusive)
	 * @return the range of matching osp clusters
	 */
	public java.util.List<OSPCluster> findByGroupId(
		long groupId, int start, int end);

	/**
	 * Returns an ordered range of all the osp clusters where groupId = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>OSPClusterModelImpl</code>.
	 * </p>
	 *
	 * @param groupId the group ID
	 * @param start the lower bound of the range of osp clusters
	 * @param end the upper bound of the range of osp clusters (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @return the ordered range of matching osp clusters
	 */
	public java.util.List<OSPCluster> findByGroupId(
		long groupId, int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator<OSPCluster>
			orderByComparator);

	/**
	 * Returns an ordered range of all the osp clusters where groupId = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>OSPClusterModelImpl</code>.
	 * </p>
	 *
	 * @param groupId the group ID
	 * @param start the lower bound of the range of osp clusters
	 * @param end the upper bound of the range of osp clusters (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @param useFinderCache whether to use the finder cache
	 * @return the ordered range of matching osp clusters
	 */
	public java.util.List<OSPCluster> findByGroupId(
		long groupId, int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator<OSPCluster>
			orderByComparator,
		boolean useFinderCache);

	/**
	 * Returns the first osp cluster in the ordered set where groupId = &#63;.
	 *
	 * @param groupId the group ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching osp cluster
	 * @throws NoSuchOSPClusterException if a matching osp cluster could not be found
	 */
	public OSPCluster findByGroupId_First(
			long groupId,
			com.liferay.portal.kernel.util.OrderByComparator<OSPCluster>
				orderByComparator)
		throws NoSuchOSPClusterException;

	/**
	 * Returns the first osp cluster in the ordered set where groupId = &#63;.
	 *
	 * @param groupId the group ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching osp cluster, or <code>null</code> if a matching osp cluster could not be found
	 */
	public OSPCluster fetchByGroupId_First(
		long groupId,
		com.liferay.portal.kernel.util.OrderByComparator<OSPCluster>
			orderByComparator);

	/**
	 * Returns the last osp cluster in the ordered set where groupId = &#63;.
	 *
	 * @param groupId the group ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching osp cluster
	 * @throws NoSuchOSPClusterException if a matching osp cluster could not be found
	 */
	public OSPCluster findByGroupId_Last(
			long groupId,
			com.liferay.portal.kernel.util.OrderByComparator<OSPCluster>
				orderByComparator)
		throws NoSuchOSPClusterException;

	/**
	 * Returns the last osp cluster in the ordered set where groupId = &#63;.
	 *
	 * @param groupId the group ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching osp cluster, or <code>null</code> if a matching osp cluster could not be found
	 */
	public OSPCluster fetchByGroupId_Last(
		long groupId,
		com.liferay.portal.kernel.util.OrderByComparator<OSPCluster>
			orderByComparator);

	/**
	 * Returns the osp clusters before and after the current osp cluster in the ordered set where groupId = &#63;.
	 *
	 * @param clusterId the primary key of the current osp cluster
	 * @param groupId the group ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the previous, current, and next osp cluster
	 * @throws NoSuchOSPClusterException if a osp cluster with the primary key could not be found
	 */
	public OSPCluster[] findByGroupId_PrevAndNext(
			long clusterId, long groupId,
			com.liferay.portal.kernel.util.OrderByComparator<OSPCluster>
				orderByComparator)
		throws NoSuchOSPClusterException;

	/**
	 * Removes all the osp clusters where groupId = &#63; from the database.
	 *
	 * @param groupId the group ID
	 */
	public void removeByGroupId(long groupId);

	/**
	 * Returns the number of osp clusters where groupId = &#63;.
	 *
	 * @param groupId the group ID
	 * @return the number of matching osp clusters
	 */
	public int countByGroupId(long groupId);

	/**
	 * Returns all the osp clusters where status = &#63;.
	 *
	 * @param status the status
	 * @return the matching osp clusters
	 */
	public java.util.List<OSPCluster> findByStatus(int status);

	/**
	 * Returns a range of all the osp clusters where status = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>OSPClusterModelImpl</code>.
	 * </p>
	 *
	 * @param status the status
	 * @param start the lower bound of the range of osp clusters
	 * @param end the upper bound of the range of osp clusters (not inclusive)
	 * @return the range of matching osp clusters
	 */
	public java.util.List<OSPCluster> findByStatus(
		int status, int start, int end);

	/**
	 * Returns an ordered range of all the osp clusters where status = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>OSPClusterModelImpl</code>.
	 * </p>
	 *
	 * @param status the status
	 * @param start the lower bound of the range of osp clusters
	 * @param end the upper bound of the range of osp clusters (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @return the ordered range of matching osp clusters
	 */
	public java.util.List<OSPCluster> findByStatus(
		int status, int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator<OSPCluster>
			orderByComparator);

	/**
	 * Returns an ordered range of all the osp clusters where status = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>OSPClusterModelImpl</code>.
	 * </p>
	 *
	 * @param status the status
	 * @param start the lower bound of the range of osp clusters
	 * @param end the upper bound of the range of osp clusters (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @param useFinderCache whether to use the finder cache
	 * @return the ordered range of matching osp clusters
	 */
	public java.util.List<OSPCluster> findByStatus(
		int status, int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator<OSPCluster>
			orderByComparator,
		boolean useFinderCache);

	/**
	 * Returns the first osp cluster in the ordered set where status = &#63;.
	 *
	 * @param status the status
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching osp cluster
	 * @throws NoSuchOSPClusterException if a matching osp cluster could not be found
	 */
	public OSPCluster findByStatus_First(
			int status,
			com.liferay.portal.kernel.util.OrderByComparator<OSPCluster>
				orderByComparator)
		throws NoSuchOSPClusterException;

	/**
	 * Returns the first osp cluster in the ordered set where status = &#63;.
	 *
	 * @param status the status
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching osp cluster, or <code>null</code> if a matching osp cluster could not be found
	 */
	public OSPCluster fetchByStatus_First(
		int status,
		com.liferay.portal.kernel.util.OrderByComparator<OSPCluster>
			orderByComparator);

	/**
	 * Returns the last osp cluster in the ordered set where status = &#63;.
	 *
	 * @param status the status
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching osp cluster
	 * @throws NoSuchOSPClusterException if a matching osp cluster could not be found
	 */
	public OSPCluster findByStatus_Last(
			int status,
			com.liferay.portal.kernel.util.OrderByComparator<OSPCluster>
				orderByComparator)
		throws NoSuchOSPClusterException;

	/**
	 * Returns the last osp cluster in the ordered set where status = &#63;.
	 *
	 * @param status the status
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching osp cluster, or <code>null</code> if a matching osp cluster could not be found
	 */
	public OSPCluster fetchByStatus_Last(
		int status,
		com.liferay.portal.kernel.util.OrderByComparator<OSPCluster>
			orderByComparator);

	/**
	 * Returns the osp clusters before and after the current osp cluster in the ordered set where status = &#63;.
	 *
	 * @param clusterId the primary key of the current osp cluster
	 * @param status the status
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the previous, current, and next osp cluster
	 * @throws NoSuchOSPClusterException if a osp cluster with the primary key could not be found
	 */
	public OSPCluster[] findByStatus_PrevAndNext(
			long clusterId, int status,
			com.liferay.portal.kernel.util.OrderByComparator<OSPCluster>
				orderByComparator)
		throws NoSuchOSPClusterException;

	/**
	 * Removes all the osp clusters where status = &#63; from the database.
	 *
	 * @param status the status
	 */
	public void removeByStatus(int status);

	/**
	 * Returns the number of osp clusters where status = &#63;.
	 *
	 * @param status the status
	 * @return the number of matching osp clusters
	 */
	public int countByStatus(int status);

	/**
	 * Returns the osp cluster where clusterName = &#63; or throws a <code>NoSuchOSPClusterException</code> if it could not be found.
	 *
	 * @param clusterName the cluster name
	 * @return the matching osp cluster
	 * @throws NoSuchOSPClusterException if a matching osp cluster could not be found
	 */
	public OSPCluster findByClusterName(String clusterName)
		throws NoSuchOSPClusterException;

	/**
	 * Returns the osp cluster where clusterName = &#63; or returns <code>null</code> if it could not be found. Uses the finder cache.
	 *
	 * @param clusterName the cluster name
	 * @return the matching osp cluster, or <code>null</code> if a matching osp cluster could not be found
	 */
	public OSPCluster fetchByClusterName(String clusterName);

	/**
	 * Returns the osp cluster where clusterName = &#63; or returns <code>null</code> if it could not be found, optionally using the finder cache.
	 *
	 * @param clusterName the cluster name
	 * @param useFinderCache whether to use the finder cache
	 * @return the matching osp cluster, or <code>null</code> if a matching osp cluster could not be found
	 */
	public OSPCluster fetchByClusterName(
		String clusterName, boolean useFinderCache);

	/**
	 * Removes the osp cluster where clusterName = &#63; from the database.
	 *
	 * @param clusterName the cluster name
	 * @return the osp cluster that was removed
	 */
	public OSPCluster removeByClusterName(String clusterName)
		throws NoSuchOSPClusterException;

	/**
	 * Returns the number of osp clusters where clusterName = &#63;.
	 *
	 * @param clusterName the cluster name
	 * @return the number of matching osp clusters
	 */
	public int countByClusterName(String clusterName);

	/**
	 * Returns all the osp clusters where osName = &#63;.
	 *
	 * @param osName the os name
	 * @return the matching osp clusters
	 */
	public java.util.List<OSPCluster> findByOSName(String osName);

	/**
	 * Returns a range of all the osp clusters where osName = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>OSPClusterModelImpl</code>.
	 * </p>
	 *
	 * @param osName the os name
	 * @param start the lower bound of the range of osp clusters
	 * @param end the upper bound of the range of osp clusters (not inclusive)
	 * @return the range of matching osp clusters
	 */
	public java.util.List<OSPCluster> findByOSName(
		String osName, int start, int end);

	/**
	 * Returns an ordered range of all the osp clusters where osName = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>OSPClusterModelImpl</code>.
	 * </p>
	 *
	 * @param osName the os name
	 * @param start the lower bound of the range of osp clusters
	 * @param end the upper bound of the range of osp clusters (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @return the ordered range of matching osp clusters
	 */
	public java.util.List<OSPCluster> findByOSName(
		String osName, int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator<OSPCluster>
			orderByComparator);

	/**
	 * Returns an ordered range of all the osp clusters where osName = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>OSPClusterModelImpl</code>.
	 * </p>
	 *
	 * @param osName the os name
	 * @param start the lower bound of the range of osp clusters
	 * @param end the upper bound of the range of osp clusters (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @param useFinderCache whether to use the finder cache
	 * @return the ordered range of matching osp clusters
	 */
	public java.util.List<OSPCluster> findByOSName(
		String osName, int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator<OSPCluster>
			orderByComparator,
		boolean useFinderCache);

	/**
	 * Returns the first osp cluster in the ordered set where osName = &#63;.
	 *
	 * @param osName the os name
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching osp cluster
	 * @throws NoSuchOSPClusterException if a matching osp cluster could not be found
	 */
	public OSPCluster findByOSName_First(
			String osName,
			com.liferay.portal.kernel.util.OrderByComparator<OSPCluster>
				orderByComparator)
		throws NoSuchOSPClusterException;

	/**
	 * Returns the first osp cluster in the ordered set where osName = &#63;.
	 *
	 * @param osName the os name
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching osp cluster, or <code>null</code> if a matching osp cluster could not be found
	 */
	public OSPCluster fetchByOSName_First(
		String osName,
		com.liferay.portal.kernel.util.OrderByComparator<OSPCluster>
			orderByComparator);

	/**
	 * Returns the last osp cluster in the ordered set where osName = &#63;.
	 *
	 * @param osName the os name
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching osp cluster
	 * @throws NoSuchOSPClusterException if a matching osp cluster could not be found
	 */
	public OSPCluster findByOSName_Last(
			String osName,
			com.liferay.portal.kernel.util.OrderByComparator<OSPCluster>
				orderByComparator)
		throws NoSuchOSPClusterException;

	/**
	 * Returns the last osp cluster in the ordered set where osName = &#63;.
	 *
	 * @param osName the os name
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching osp cluster, or <code>null</code> if a matching osp cluster could not be found
	 */
	public OSPCluster fetchByOSName_Last(
		String osName,
		com.liferay.portal.kernel.util.OrderByComparator<OSPCluster>
			orderByComparator);

	/**
	 * Returns the osp clusters before and after the current osp cluster in the ordered set where osName = &#63;.
	 *
	 * @param clusterId the primary key of the current osp cluster
	 * @param osName the os name
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the previous, current, and next osp cluster
	 * @throws NoSuchOSPClusterException if a osp cluster with the primary key could not be found
	 */
	public OSPCluster[] findByOSName_PrevAndNext(
			long clusterId, String osName,
			com.liferay.portal.kernel.util.OrderByComparator<OSPCluster>
				orderByComparator)
		throws NoSuchOSPClusterException;

	/**
	 * Removes all the osp clusters where osName = &#63; from the database.
	 *
	 * @param osName the os name
	 */
	public void removeByOSName(String osName);

	/**
	 * Returns the number of osp clusters where osName = &#63;.
	 *
	 * @param osName the os name
	 * @return the number of matching osp clusters
	 */
	public int countByOSName(String osName);

	/**
	 * Caches the osp cluster in the entity cache if it is enabled.
	 *
	 * @param ospCluster the osp cluster
	 */
	public void cacheResult(OSPCluster ospCluster);

	/**
	 * Caches the osp clusters in the entity cache if it is enabled.
	 *
	 * @param ospClusters the osp clusters
	 */
	public void cacheResult(java.util.List<OSPCluster> ospClusters);

	/**
	 * Creates a new osp cluster with the primary key. Does not add the osp cluster to the database.
	 *
	 * @param clusterId the primary key for the new osp cluster
	 * @return the new osp cluster
	 */
	public OSPCluster create(long clusterId);

	/**
	 * Removes the osp cluster with the primary key from the database. Also notifies the appropriate model listeners.
	 *
	 * @param clusterId the primary key of the osp cluster
	 * @return the osp cluster that was removed
	 * @throws NoSuchOSPClusterException if a osp cluster with the primary key could not be found
	 */
	public OSPCluster remove(long clusterId) throws NoSuchOSPClusterException;

	public OSPCluster updateImpl(OSPCluster ospCluster);

	/**
	 * Returns the osp cluster with the primary key or throws a <code>NoSuchOSPClusterException</code> if it could not be found.
	 *
	 * @param clusterId the primary key of the osp cluster
	 * @return the osp cluster
	 * @throws NoSuchOSPClusterException if a osp cluster with the primary key could not be found
	 */
	public OSPCluster findByPrimaryKey(long clusterId)
		throws NoSuchOSPClusterException;

	/**
	 * Returns the osp cluster with the primary key or returns <code>null</code> if it could not be found.
	 *
	 * @param clusterId the primary key of the osp cluster
	 * @return the osp cluster, or <code>null</code> if a osp cluster with the primary key could not be found
	 */
	public OSPCluster fetchByPrimaryKey(long clusterId);

	/**
	 * Returns all the osp clusters.
	 *
	 * @return the osp clusters
	 */
	public java.util.List<OSPCluster> findAll();

	/**
	 * Returns a range of all the osp clusters.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>OSPClusterModelImpl</code>.
	 * </p>
	 *
	 * @param start the lower bound of the range of osp clusters
	 * @param end the upper bound of the range of osp clusters (not inclusive)
	 * @return the range of osp clusters
	 */
	public java.util.List<OSPCluster> findAll(int start, int end);

	/**
	 * Returns an ordered range of all the osp clusters.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>OSPClusterModelImpl</code>.
	 * </p>
	 *
	 * @param start the lower bound of the range of osp clusters
	 * @param end the upper bound of the range of osp clusters (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @return the ordered range of osp clusters
	 */
	public java.util.List<OSPCluster> findAll(
		int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator<OSPCluster>
			orderByComparator);

	/**
	 * Returns an ordered range of all the osp clusters.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>OSPClusterModelImpl</code>.
	 * </p>
	 *
	 * @param start the lower bound of the range of osp clusters
	 * @param end the upper bound of the range of osp clusters (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @param useFinderCache whether to use the finder cache
	 * @return the ordered range of osp clusters
	 */
	public java.util.List<OSPCluster> findAll(
		int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator<OSPCluster>
			orderByComparator,
		boolean useFinderCache);

	/**
	 * Removes all the osp clusters from the database.
	 */
	public void removeAll();

	/**
	 * Returns the number of osp clusters.
	 *
	 * @return the number of osp clusters
	 */
	public int countAll();

}