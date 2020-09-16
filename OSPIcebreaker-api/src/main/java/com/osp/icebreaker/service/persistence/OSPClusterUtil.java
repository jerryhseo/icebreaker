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

import com.osp.icebreaker.model.OSPCluster;

import java.io.Serializable;

import java.util.List;
import java.util.Map;
import java.util.Set;

import org.osgi.annotation.versioning.ProviderType;
import org.osgi.framework.Bundle;
import org.osgi.framework.FrameworkUtil;
import org.osgi.util.tracker.ServiceTracker;

/**
 * The persistence utility for the osp cluster service. This utility wraps <code>com.osp.icebreaker.service.persistence.impl.OSPClusterPersistenceImpl</code> and provides direct access to the database for CRUD operations. This utility should only be used by the service layer, as it must operate within a transaction. Never access this utility in a JSP, controller, model, or other front-end class.
 *
 * <p>
 * Caching information and settings can be found in <code>portal.properties</code>
 * </p>
 *
 * @author Jerry H. Seo
 * @see OSPClusterPersistence
 * @generated
 */
@ProviderType
public class OSPClusterUtil {

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
	public static void clearCache(OSPCluster ospCluster) {
		getPersistence().clearCache(ospCluster);
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
	public static Map<Serializable, OSPCluster> fetchByPrimaryKeys(
		Set<Serializable> primaryKeys) {

		return getPersistence().fetchByPrimaryKeys(primaryKeys);
	}

	/**
	 * @see com.liferay.portal.kernel.service.persistence.BasePersistence#findWithDynamicQuery(DynamicQuery)
	 */
	public static List<OSPCluster> findWithDynamicQuery(
		DynamicQuery dynamicQuery) {

		return getPersistence().findWithDynamicQuery(dynamicQuery);
	}

	/**
	 * @see com.liferay.portal.kernel.service.persistence.BasePersistence#findWithDynamicQuery(DynamicQuery, int, int)
	 */
	public static List<OSPCluster> findWithDynamicQuery(
		DynamicQuery dynamicQuery, int start, int end) {

		return getPersistence().findWithDynamicQuery(dynamicQuery, start, end);
	}

	/**
	 * @see com.liferay.portal.kernel.service.persistence.BasePersistence#findWithDynamicQuery(DynamicQuery, int, int, OrderByComparator)
	 */
	public static List<OSPCluster> findWithDynamicQuery(
		DynamicQuery dynamicQuery, int start, int end,
		OrderByComparator<OSPCluster> orderByComparator) {

		return getPersistence().findWithDynamicQuery(
			dynamicQuery, start, end, orderByComparator);
	}

	/**
	 * @see com.liferay.portal.kernel.service.persistence.BasePersistence#update(com.liferay.portal.kernel.model.BaseModel)
	 */
	public static OSPCluster update(OSPCluster ospCluster) {
		return getPersistence().update(ospCluster);
	}

	/**
	 * @see com.liferay.portal.kernel.service.persistence.BasePersistence#update(com.liferay.portal.kernel.model.BaseModel, ServiceContext)
	 */
	public static OSPCluster update(
		OSPCluster ospCluster, ServiceContext serviceContext) {

		return getPersistence().update(ospCluster, serviceContext);
	}

	/**
	 * Returns all the osp clusters where uuid = &#63;.
	 *
	 * @param uuid the uuid
	 * @return the matching osp clusters
	 */
	public static List<OSPCluster> findByUuid(String uuid) {
		return getPersistence().findByUuid(uuid);
	}

	/**
	 * Returns a range of all the osp clusters where uuid = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not <code>QueryUtil#ALL_POS</code>), then the query will include the default ORDER BY logic from <code>OSPClusterModelImpl</code>. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	 * </p>
	 *
	 * @param uuid the uuid
	 * @param start the lower bound of the range of osp clusters
	 * @param end the upper bound of the range of osp clusters (not inclusive)
	 * @return the range of matching osp clusters
	 */
	public static List<OSPCluster> findByUuid(String uuid, int start, int end) {
		return getPersistence().findByUuid(uuid, start, end);
	}

	/**
	 * Returns an ordered range of all the osp clusters where uuid = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not <code>QueryUtil#ALL_POS</code>), then the query will include the default ORDER BY logic from <code>OSPClusterModelImpl</code>. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	 * </p>
	 *
	 * @param uuid the uuid
	 * @param start the lower bound of the range of osp clusters
	 * @param end the upper bound of the range of osp clusters (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @return the ordered range of matching osp clusters
	 */
	public static List<OSPCluster> findByUuid(
		String uuid, int start, int end,
		OrderByComparator<OSPCluster> orderByComparator) {

		return getPersistence().findByUuid(uuid, start, end, orderByComparator);
	}

	/**
	 * Returns an ordered range of all the osp clusters where uuid = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not <code>QueryUtil#ALL_POS</code>), then the query will include the default ORDER BY logic from <code>OSPClusterModelImpl</code>. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	 * </p>
	 *
	 * @param uuid the uuid
	 * @param start the lower bound of the range of osp clusters
	 * @param end the upper bound of the range of osp clusters (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @param retrieveFromCache whether to retrieve from the finder cache
	 * @return the ordered range of matching osp clusters
	 */
	public static List<OSPCluster> findByUuid(
		String uuid, int start, int end,
		OrderByComparator<OSPCluster> orderByComparator,
		boolean retrieveFromCache) {

		return getPersistence().findByUuid(
			uuid, start, end, orderByComparator, retrieveFromCache);
	}

	/**
	 * Returns the first osp cluster in the ordered set where uuid = &#63;.
	 *
	 * @param uuid the uuid
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching osp cluster
	 * @throws NoSuchOSPClusterException if a matching osp cluster could not be found
	 */
	public static OSPCluster findByUuid_First(
			String uuid, OrderByComparator<OSPCluster> orderByComparator)
		throws com.osp.icebreaker.exception.NoSuchOSPClusterException {

		return getPersistence().findByUuid_First(uuid, orderByComparator);
	}

	/**
	 * Returns the first osp cluster in the ordered set where uuid = &#63;.
	 *
	 * @param uuid the uuid
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching osp cluster, or <code>null</code> if a matching osp cluster could not be found
	 */
	public static OSPCluster fetchByUuid_First(
		String uuid, OrderByComparator<OSPCluster> orderByComparator) {

		return getPersistence().fetchByUuid_First(uuid, orderByComparator);
	}

	/**
	 * Returns the last osp cluster in the ordered set where uuid = &#63;.
	 *
	 * @param uuid the uuid
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching osp cluster
	 * @throws NoSuchOSPClusterException if a matching osp cluster could not be found
	 */
	public static OSPCluster findByUuid_Last(
			String uuid, OrderByComparator<OSPCluster> orderByComparator)
		throws com.osp.icebreaker.exception.NoSuchOSPClusterException {

		return getPersistence().findByUuid_Last(uuid, orderByComparator);
	}

	/**
	 * Returns the last osp cluster in the ordered set where uuid = &#63;.
	 *
	 * @param uuid the uuid
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching osp cluster, or <code>null</code> if a matching osp cluster could not be found
	 */
	public static OSPCluster fetchByUuid_Last(
		String uuid, OrderByComparator<OSPCluster> orderByComparator) {

		return getPersistence().fetchByUuid_Last(uuid, orderByComparator);
	}

	/**
	 * Returns the osp clusters before and after the current osp cluster in the ordered set where uuid = &#63;.
	 *
	 * @param clusterId the primary key of the current osp cluster
	 * @param uuid the uuid
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the previous, current, and next osp cluster
	 * @throws NoSuchOSPClusterException if a osp cluster with the primary key could not be found
	 */
	public static OSPCluster[] findByUuid_PrevAndNext(
			long clusterId, String uuid,
			OrderByComparator<OSPCluster> orderByComparator)
		throws com.osp.icebreaker.exception.NoSuchOSPClusterException {

		return getPersistence().findByUuid_PrevAndNext(
			clusterId, uuid, orderByComparator);
	}

	/**
	 * Removes all the osp clusters where uuid = &#63; from the database.
	 *
	 * @param uuid the uuid
	 */
	public static void removeByUuid(String uuid) {
		getPersistence().removeByUuid(uuid);
	}

	/**
	 * Returns the number of osp clusters where uuid = &#63;.
	 *
	 * @param uuid the uuid
	 * @return the number of matching osp clusters
	 */
	public static int countByUuid(String uuid) {
		return getPersistence().countByUuid(uuid);
	}

	/**
	 * Returns the osp cluster where uuid = &#63; and groupId = &#63; or throws a <code>NoSuchOSPClusterException</code> if it could not be found.
	 *
	 * @param uuid the uuid
	 * @param groupId the group ID
	 * @return the matching osp cluster
	 * @throws NoSuchOSPClusterException if a matching osp cluster could not be found
	 */
	public static OSPCluster findByUUID_G(String uuid, long groupId)
		throws com.osp.icebreaker.exception.NoSuchOSPClusterException {

		return getPersistence().findByUUID_G(uuid, groupId);
	}

	/**
	 * Returns the osp cluster where uuid = &#63; and groupId = &#63; or returns <code>null</code> if it could not be found. Uses the finder cache.
	 *
	 * @param uuid the uuid
	 * @param groupId the group ID
	 * @return the matching osp cluster, or <code>null</code> if a matching osp cluster could not be found
	 */
	public static OSPCluster fetchByUUID_G(String uuid, long groupId) {
		return getPersistence().fetchByUUID_G(uuid, groupId);
	}

	/**
	 * Returns the osp cluster where uuid = &#63; and groupId = &#63; or returns <code>null</code> if it could not be found, optionally using the finder cache.
	 *
	 * @param uuid the uuid
	 * @param groupId the group ID
	 * @param retrieveFromCache whether to retrieve from the finder cache
	 * @return the matching osp cluster, or <code>null</code> if a matching osp cluster could not be found
	 */
	public static OSPCluster fetchByUUID_G(
		String uuid, long groupId, boolean retrieveFromCache) {

		return getPersistence().fetchByUUID_G(uuid, groupId, retrieveFromCache);
	}

	/**
	 * Removes the osp cluster where uuid = &#63; and groupId = &#63; from the database.
	 *
	 * @param uuid the uuid
	 * @param groupId the group ID
	 * @return the osp cluster that was removed
	 */
	public static OSPCluster removeByUUID_G(String uuid, long groupId)
		throws com.osp.icebreaker.exception.NoSuchOSPClusterException {

		return getPersistence().removeByUUID_G(uuid, groupId);
	}

	/**
	 * Returns the number of osp clusters where uuid = &#63; and groupId = &#63;.
	 *
	 * @param uuid the uuid
	 * @param groupId the group ID
	 * @return the number of matching osp clusters
	 */
	public static int countByUUID_G(String uuid, long groupId) {
		return getPersistence().countByUUID_G(uuid, groupId);
	}

	/**
	 * Returns all the osp clusters where uuid = &#63; and companyId = &#63;.
	 *
	 * @param uuid the uuid
	 * @param companyId the company ID
	 * @return the matching osp clusters
	 */
	public static List<OSPCluster> findByUuid_C(String uuid, long companyId) {
		return getPersistence().findByUuid_C(uuid, companyId);
	}

	/**
	 * Returns a range of all the osp clusters where uuid = &#63; and companyId = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not <code>QueryUtil#ALL_POS</code>), then the query will include the default ORDER BY logic from <code>OSPClusterModelImpl</code>. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	 * </p>
	 *
	 * @param uuid the uuid
	 * @param companyId the company ID
	 * @param start the lower bound of the range of osp clusters
	 * @param end the upper bound of the range of osp clusters (not inclusive)
	 * @return the range of matching osp clusters
	 */
	public static List<OSPCluster> findByUuid_C(
		String uuid, long companyId, int start, int end) {

		return getPersistence().findByUuid_C(uuid, companyId, start, end);
	}

	/**
	 * Returns an ordered range of all the osp clusters where uuid = &#63; and companyId = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not <code>QueryUtil#ALL_POS</code>), then the query will include the default ORDER BY logic from <code>OSPClusterModelImpl</code>. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	 * </p>
	 *
	 * @param uuid the uuid
	 * @param companyId the company ID
	 * @param start the lower bound of the range of osp clusters
	 * @param end the upper bound of the range of osp clusters (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @return the ordered range of matching osp clusters
	 */
	public static List<OSPCluster> findByUuid_C(
		String uuid, long companyId, int start, int end,
		OrderByComparator<OSPCluster> orderByComparator) {

		return getPersistence().findByUuid_C(
			uuid, companyId, start, end, orderByComparator);
	}

	/**
	 * Returns an ordered range of all the osp clusters where uuid = &#63; and companyId = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not <code>QueryUtil#ALL_POS</code>), then the query will include the default ORDER BY logic from <code>OSPClusterModelImpl</code>. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	 * </p>
	 *
	 * @param uuid the uuid
	 * @param companyId the company ID
	 * @param start the lower bound of the range of osp clusters
	 * @param end the upper bound of the range of osp clusters (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @param retrieveFromCache whether to retrieve from the finder cache
	 * @return the ordered range of matching osp clusters
	 */
	public static List<OSPCluster> findByUuid_C(
		String uuid, long companyId, int start, int end,
		OrderByComparator<OSPCluster> orderByComparator,
		boolean retrieveFromCache) {

		return getPersistence().findByUuid_C(
			uuid, companyId, start, end, orderByComparator, retrieveFromCache);
	}

	/**
	 * Returns the first osp cluster in the ordered set where uuid = &#63; and companyId = &#63;.
	 *
	 * @param uuid the uuid
	 * @param companyId the company ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching osp cluster
	 * @throws NoSuchOSPClusterException if a matching osp cluster could not be found
	 */
	public static OSPCluster findByUuid_C_First(
			String uuid, long companyId,
			OrderByComparator<OSPCluster> orderByComparator)
		throws com.osp.icebreaker.exception.NoSuchOSPClusterException {

		return getPersistence().findByUuid_C_First(
			uuid, companyId, orderByComparator);
	}

	/**
	 * Returns the first osp cluster in the ordered set where uuid = &#63; and companyId = &#63;.
	 *
	 * @param uuid the uuid
	 * @param companyId the company ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching osp cluster, or <code>null</code> if a matching osp cluster could not be found
	 */
	public static OSPCluster fetchByUuid_C_First(
		String uuid, long companyId,
		OrderByComparator<OSPCluster> orderByComparator) {

		return getPersistence().fetchByUuid_C_First(
			uuid, companyId, orderByComparator);
	}

	/**
	 * Returns the last osp cluster in the ordered set where uuid = &#63; and companyId = &#63;.
	 *
	 * @param uuid the uuid
	 * @param companyId the company ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching osp cluster
	 * @throws NoSuchOSPClusterException if a matching osp cluster could not be found
	 */
	public static OSPCluster findByUuid_C_Last(
			String uuid, long companyId,
			OrderByComparator<OSPCluster> orderByComparator)
		throws com.osp.icebreaker.exception.NoSuchOSPClusterException {

		return getPersistence().findByUuid_C_Last(
			uuid, companyId, orderByComparator);
	}

	/**
	 * Returns the last osp cluster in the ordered set where uuid = &#63; and companyId = &#63;.
	 *
	 * @param uuid the uuid
	 * @param companyId the company ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching osp cluster, or <code>null</code> if a matching osp cluster could not be found
	 */
	public static OSPCluster fetchByUuid_C_Last(
		String uuid, long companyId,
		OrderByComparator<OSPCluster> orderByComparator) {

		return getPersistence().fetchByUuid_C_Last(
			uuid, companyId, orderByComparator);
	}

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
	public static OSPCluster[] findByUuid_C_PrevAndNext(
			long clusterId, String uuid, long companyId,
			OrderByComparator<OSPCluster> orderByComparator)
		throws com.osp.icebreaker.exception.NoSuchOSPClusterException {

		return getPersistence().findByUuid_C_PrevAndNext(
			clusterId, uuid, companyId, orderByComparator);
	}

	/**
	 * Removes all the osp clusters where uuid = &#63; and companyId = &#63; from the database.
	 *
	 * @param uuid the uuid
	 * @param companyId the company ID
	 */
	public static void removeByUuid_C(String uuid, long companyId) {
		getPersistence().removeByUuid_C(uuid, companyId);
	}

	/**
	 * Returns the number of osp clusters where uuid = &#63; and companyId = &#63;.
	 *
	 * @param uuid the uuid
	 * @param companyId the company ID
	 * @return the number of matching osp clusters
	 */
	public static int countByUuid_C(String uuid, long companyId) {
		return getPersistence().countByUuid_C(uuid, companyId);
	}

	/**
	 * Returns all the osp clusters where groupId = &#63;.
	 *
	 * @param groupId the group ID
	 * @return the matching osp clusters
	 */
	public static List<OSPCluster> findByGroupId(long groupId) {
		return getPersistence().findByGroupId(groupId);
	}

	/**
	 * Returns a range of all the osp clusters where groupId = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not <code>QueryUtil#ALL_POS</code>), then the query will include the default ORDER BY logic from <code>OSPClusterModelImpl</code>. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	 * </p>
	 *
	 * @param groupId the group ID
	 * @param start the lower bound of the range of osp clusters
	 * @param end the upper bound of the range of osp clusters (not inclusive)
	 * @return the range of matching osp clusters
	 */
	public static List<OSPCluster> findByGroupId(
		long groupId, int start, int end) {

		return getPersistence().findByGroupId(groupId, start, end);
	}

	/**
	 * Returns an ordered range of all the osp clusters where groupId = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not <code>QueryUtil#ALL_POS</code>), then the query will include the default ORDER BY logic from <code>OSPClusterModelImpl</code>. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	 * </p>
	 *
	 * @param groupId the group ID
	 * @param start the lower bound of the range of osp clusters
	 * @param end the upper bound of the range of osp clusters (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @return the ordered range of matching osp clusters
	 */
	public static List<OSPCluster> findByGroupId(
		long groupId, int start, int end,
		OrderByComparator<OSPCluster> orderByComparator) {

		return getPersistence().findByGroupId(
			groupId, start, end, orderByComparator);
	}

	/**
	 * Returns an ordered range of all the osp clusters where groupId = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not <code>QueryUtil#ALL_POS</code>), then the query will include the default ORDER BY logic from <code>OSPClusterModelImpl</code>. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	 * </p>
	 *
	 * @param groupId the group ID
	 * @param start the lower bound of the range of osp clusters
	 * @param end the upper bound of the range of osp clusters (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @param retrieveFromCache whether to retrieve from the finder cache
	 * @return the ordered range of matching osp clusters
	 */
	public static List<OSPCluster> findByGroupId(
		long groupId, int start, int end,
		OrderByComparator<OSPCluster> orderByComparator,
		boolean retrieveFromCache) {

		return getPersistence().findByGroupId(
			groupId, start, end, orderByComparator, retrieveFromCache);
	}

	/**
	 * Returns the first osp cluster in the ordered set where groupId = &#63;.
	 *
	 * @param groupId the group ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching osp cluster
	 * @throws NoSuchOSPClusterException if a matching osp cluster could not be found
	 */
	public static OSPCluster findByGroupId_First(
			long groupId, OrderByComparator<OSPCluster> orderByComparator)
		throws com.osp.icebreaker.exception.NoSuchOSPClusterException {

		return getPersistence().findByGroupId_First(groupId, orderByComparator);
	}

	/**
	 * Returns the first osp cluster in the ordered set where groupId = &#63;.
	 *
	 * @param groupId the group ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching osp cluster, or <code>null</code> if a matching osp cluster could not be found
	 */
	public static OSPCluster fetchByGroupId_First(
		long groupId, OrderByComparator<OSPCluster> orderByComparator) {

		return getPersistence().fetchByGroupId_First(
			groupId, orderByComparator);
	}

	/**
	 * Returns the last osp cluster in the ordered set where groupId = &#63;.
	 *
	 * @param groupId the group ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching osp cluster
	 * @throws NoSuchOSPClusterException if a matching osp cluster could not be found
	 */
	public static OSPCluster findByGroupId_Last(
			long groupId, OrderByComparator<OSPCluster> orderByComparator)
		throws com.osp.icebreaker.exception.NoSuchOSPClusterException {

		return getPersistence().findByGroupId_Last(groupId, orderByComparator);
	}

	/**
	 * Returns the last osp cluster in the ordered set where groupId = &#63;.
	 *
	 * @param groupId the group ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching osp cluster, or <code>null</code> if a matching osp cluster could not be found
	 */
	public static OSPCluster fetchByGroupId_Last(
		long groupId, OrderByComparator<OSPCluster> orderByComparator) {

		return getPersistence().fetchByGroupId_Last(groupId, orderByComparator);
	}

	/**
	 * Returns the osp clusters before and after the current osp cluster in the ordered set where groupId = &#63;.
	 *
	 * @param clusterId the primary key of the current osp cluster
	 * @param groupId the group ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the previous, current, and next osp cluster
	 * @throws NoSuchOSPClusterException if a osp cluster with the primary key could not be found
	 */
	public static OSPCluster[] findByGroupId_PrevAndNext(
			long clusterId, long groupId,
			OrderByComparator<OSPCluster> orderByComparator)
		throws com.osp.icebreaker.exception.NoSuchOSPClusterException {

		return getPersistence().findByGroupId_PrevAndNext(
			clusterId, groupId, orderByComparator);
	}

	/**
	 * Removes all the osp clusters where groupId = &#63; from the database.
	 *
	 * @param groupId the group ID
	 */
	public static void removeByGroupId(long groupId) {
		getPersistence().removeByGroupId(groupId);
	}

	/**
	 * Returns the number of osp clusters where groupId = &#63;.
	 *
	 * @param groupId the group ID
	 * @return the number of matching osp clusters
	 */
	public static int countByGroupId(long groupId) {
		return getPersistence().countByGroupId(groupId);
	}

	/**
	 * Returns all the osp clusters where status = &#63;.
	 *
	 * @param status the status
	 * @return the matching osp clusters
	 */
	public static List<OSPCluster> findByStatus(int status) {
		return getPersistence().findByStatus(status);
	}

	/**
	 * Returns a range of all the osp clusters where status = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not <code>QueryUtil#ALL_POS</code>), then the query will include the default ORDER BY logic from <code>OSPClusterModelImpl</code>. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	 * </p>
	 *
	 * @param status the status
	 * @param start the lower bound of the range of osp clusters
	 * @param end the upper bound of the range of osp clusters (not inclusive)
	 * @return the range of matching osp clusters
	 */
	public static List<OSPCluster> findByStatus(
		int status, int start, int end) {

		return getPersistence().findByStatus(status, start, end);
	}

	/**
	 * Returns an ordered range of all the osp clusters where status = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not <code>QueryUtil#ALL_POS</code>), then the query will include the default ORDER BY logic from <code>OSPClusterModelImpl</code>. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	 * </p>
	 *
	 * @param status the status
	 * @param start the lower bound of the range of osp clusters
	 * @param end the upper bound of the range of osp clusters (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @return the ordered range of matching osp clusters
	 */
	public static List<OSPCluster> findByStatus(
		int status, int start, int end,
		OrderByComparator<OSPCluster> orderByComparator) {

		return getPersistence().findByStatus(
			status, start, end, orderByComparator);
	}

	/**
	 * Returns an ordered range of all the osp clusters where status = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not <code>QueryUtil#ALL_POS</code>), then the query will include the default ORDER BY logic from <code>OSPClusterModelImpl</code>. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	 * </p>
	 *
	 * @param status the status
	 * @param start the lower bound of the range of osp clusters
	 * @param end the upper bound of the range of osp clusters (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @param retrieveFromCache whether to retrieve from the finder cache
	 * @return the ordered range of matching osp clusters
	 */
	public static List<OSPCluster> findByStatus(
		int status, int start, int end,
		OrderByComparator<OSPCluster> orderByComparator,
		boolean retrieveFromCache) {

		return getPersistence().findByStatus(
			status, start, end, orderByComparator, retrieveFromCache);
	}

	/**
	 * Returns the first osp cluster in the ordered set where status = &#63;.
	 *
	 * @param status the status
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching osp cluster
	 * @throws NoSuchOSPClusterException if a matching osp cluster could not be found
	 */
	public static OSPCluster findByStatus_First(
			int status, OrderByComparator<OSPCluster> orderByComparator)
		throws com.osp.icebreaker.exception.NoSuchOSPClusterException {

		return getPersistence().findByStatus_First(status, orderByComparator);
	}

	/**
	 * Returns the first osp cluster in the ordered set where status = &#63;.
	 *
	 * @param status the status
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching osp cluster, or <code>null</code> if a matching osp cluster could not be found
	 */
	public static OSPCluster fetchByStatus_First(
		int status, OrderByComparator<OSPCluster> orderByComparator) {

		return getPersistence().fetchByStatus_First(status, orderByComparator);
	}

	/**
	 * Returns the last osp cluster in the ordered set where status = &#63;.
	 *
	 * @param status the status
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching osp cluster
	 * @throws NoSuchOSPClusterException if a matching osp cluster could not be found
	 */
	public static OSPCluster findByStatus_Last(
			int status, OrderByComparator<OSPCluster> orderByComparator)
		throws com.osp.icebreaker.exception.NoSuchOSPClusterException {

		return getPersistence().findByStatus_Last(status, orderByComparator);
	}

	/**
	 * Returns the last osp cluster in the ordered set where status = &#63;.
	 *
	 * @param status the status
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching osp cluster, or <code>null</code> if a matching osp cluster could not be found
	 */
	public static OSPCluster fetchByStatus_Last(
		int status, OrderByComparator<OSPCluster> orderByComparator) {

		return getPersistence().fetchByStatus_Last(status, orderByComparator);
	}

	/**
	 * Returns the osp clusters before and after the current osp cluster in the ordered set where status = &#63;.
	 *
	 * @param clusterId the primary key of the current osp cluster
	 * @param status the status
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the previous, current, and next osp cluster
	 * @throws NoSuchOSPClusterException if a osp cluster with the primary key could not be found
	 */
	public static OSPCluster[] findByStatus_PrevAndNext(
			long clusterId, int status,
			OrderByComparator<OSPCluster> orderByComparator)
		throws com.osp.icebreaker.exception.NoSuchOSPClusterException {

		return getPersistence().findByStatus_PrevAndNext(
			clusterId, status, orderByComparator);
	}

	/**
	 * Removes all the osp clusters where status = &#63; from the database.
	 *
	 * @param status the status
	 */
	public static void removeByStatus(int status) {
		getPersistence().removeByStatus(status);
	}

	/**
	 * Returns the number of osp clusters where status = &#63;.
	 *
	 * @param status the status
	 * @return the number of matching osp clusters
	 */
	public static int countByStatus(int status) {
		return getPersistence().countByStatus(status);
	}

	/**
	 * Returns the osp cluster where clusterName = &#63; or throws a <code>NoSuchOSPClusterException</code> if it could not be found.
	 *
	 * @param clusterName the cluster name
	 * @return the matching osp cluster
	 * @throws NoSuchOSPClusterException if a matching osp cluster could not be found
	 */
	public static OSPCluster findByClusterName(String clusterName)
		throws com.osp.icebreaker.exception.NoSuchOSPClusterException {

		return getPersistence().findByClusterName(clusterName);
	}

	/**
	 * Returns the osp cluster where clusterName = &#63; or returns <code>null</code> if it could not be found. Uses the finder cache.
	 *
	 * @param clusterName the cluster name
	 * @return the matching osp cluster, or <code>null</code> if a matching osp cluster could not be found
	 */
	public static OSPCluster fetchByClusterName(String clusterName) {
		return getPersistence().fetchByClusterName(clusterName);
	}

	/**
	 * Returns the osp cluster where clusterName = &#63; or returns <code>null</code> if it could not be found, optionally using the finder cache.
	 *
	 * @param clusterName the cluster name
	 * @param retrieveFromCache whether to retrieve from the finder cache
	 * @return the matching osp cluster, or <code>null</code> if a matching osp cluster could not be found
	 */
	public static OSPCluster fetchByClusterName(
		String clusterName, boolean retrieveFromCache) {

		return getPersistence().fetchByClusterName(
			clusterName, retrieveFromCache);
	}

	/**
	 * Removes the osp cluster where clusterName = &#63; from the database.
	 *
	 * @param clusterName the cluster name
	 * @return the osp cluster that was removed
	 */
	public static OSPCluster removeByClusterName(String clusterName)
		throws com.osp.icebreaker.exception.NoSuchOSPClusterException {

		return getPersistence().removeByClusterName(clusterName);
	}

	/**
	 * Returns the number of osp clusters where clusterName = &#63;.
	 *
	 * @param clusterName the cluster name
	 * @return the number of matching osp clusters
	 */
	public static int countByClusterName(String clusterName) {
		return getPersistence().countByClusterName(clusterName);
	}

	/**
	 * Returns all the osp clusters where osName = &#63;.
	 *
	 * @param osName the os name
	 * @return the matching osp clusters
	 */
	public static List<OSPCluster> findByOSName(String osName) {
		return getPersistence().findByOSName(osName);
	}

	/**
	 * Returns a range of all the osp clusters where osName = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not <code>QueryUtil#ALL_POS</code>), then the query will include the default ORDER BY logic from <code>OSPClusterModelImpl</code>. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	 * </p>
	 *
	 * @param osName the os name
	 * @param start the lower bound of the range of osp clusters
	 * @param end the upper bound of the range of osp clusters (not inclusive)
	 * @return the range of matching osp clusters
	 */
	public static List<OSPCluster> findByOSName(
		String osName, int start, int end) {

		return getPersistence().findByOSName(osName, start, end);
	}

	/**
	 * Returns an ordered range of all the osp clusters where osName = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not <code>QueryUtil#ALL_POS</code>), then the query will include the default ORDER BY logic from <code>OSPClusterModelImpl</code>. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	 * </p>
	 *
	 * @param osName the os name
	 * @param start the lower bound of the range of osp clusters
	 * @param end the upper bound of the range of osp clusters (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @return the ordered range of matching osp clusters
	 */
	public static List<OSPCluster> findByOSName(
		String osName, int start, int end,
		OrderByComparator<OSPCluster> orderByComparator) {

		return getPersistence().findByOSName(
			osName, start, end, orderByComparator);
	}

	/**
	 * Returns an ordered range of all the osp clusters where osName = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not <code>QueryUtil#ALL_POS</code>), then the query will include the default ORDER BY logic from <code>OSPClusterModelImpl</code>. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	 * </p>
	 *
	 * @param osName the os name
	 * @param start the lower bound of the range of osp clusters
	 * @param end the upper bound of the range of osp clusters (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @param retrieveFromCache whether to retrieve from the finder cache
	 * @return the ordered range of matching osp clusters
	 */
	public static List<OSPCluster> findByOSName(
		String osName, int start, int end,
		OrderByComparator<OSPCluster> orderByComparator,
		boolean retrieveFromCache) {

		return getPersistence().findByOSName(
			osName, start, end, orderByComparator, retrieveFromCache);
	}

	/**
	 * Returns the first osp cluster in the ordered set where osName = &#63;.
	 *
	 * @param osName the os name
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching osp cluster
	 * @throws NoSuchOSPClusterException if a matching osp cluster could not be found
	 */
	public static OSPCluster findByOSName_First(
			String osName, OrderByComparator<OSPCluster> orderByComparator)
		throws com.osp.icebreaker.exception.NoSuchOSPClusterException {

		return getPersistence().findByOSName_First(osName, orderByComparator);
	}

	/**
	 * Returns the first osp cluster in the ordered set where osName = &#63;.
	 *
	 * @param osName the os name
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching osp cluster, or <code>null</code> if a matching osp cluster could not be found
	 */
	public static OSPCluster fetchByOSName_First(
		String osName, OrderByComparator<OSPCluster> orderByComparator) {

		return getPersistence().fetchByOSName_First(osName, orderByComparator);
	}

	/**
	 * Returns the last osp cluster in the ordered set where osName = &#63;.
	 *
	 * @param osName the os name
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching osp cluster
	 * @throws NoSuchOSPClusterException if a matching osp cluster could not be found
	 */
	public static OSPCluster findByOSName_Last(
			String osName, OrderByComparator<OSPCluster> orderByComparator)
		throws com.osp.icebreaker.exception.NoSuchOSPClusterException {

		return getPersistence().findByOSName_Last(osName, orderByComparator);
	}

	/**
	 * Returns the last osp cluster in the ordered set where osName = &#63;.
	 *
	 * @param osName the os name
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching osp cluster, or <code>null</code> if a matching osp cluster could not be found
	 */
	public static OSPCluster fetchByOSName_Last(
		String osName, OrderByComparator<OSPCluster> orderByComparator) {

		return getPersistence().fetchByOSName_Last(osName, orderByComparator);
	}

	/**
	 * Returns the osp clusters before and after the current osp cluster in the ordered set where osName = &#63;.
	 *
	 * @param clusterId the primary key of the current osp cluster
	 * @param osName the os name
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the previous, current, and next osp cluster
	 * @throws NoSuchOSPClusterException if a osp cluster with the primary key could not be found
	 */
	public static OSPCluster[] findByOSName_PrevAndNext(
			long clusterId, String osName,
			OrderByComparator<OSPCluster> orderByComparator)
		throws com.osp.icebreaker.exception.NoSuchOSPClusterException {

		return getPersistence().findByOSName_PrevAndNext(
			clusterId, osName, orderByComparator);
	}

	/**
	 * Removes all the osp clusters where osName = &#63; from the database.
	 *
	 * @param osName the os name
	 */
	public static void removeByOSName(String osName) {
		getPersistence().removeByOSName(osName);
	}

	/**
	 * Returns the number of osp clusters where osName = &#63;.
	 *
	 * @param osName the os name
	 * @return the number of matching osp clusters
	 */
	public static int countByOSName(String osName) {
		return getPersistence().countByOSName(osName);
	}

	/**
	 * Caches the osp cluster in the entity cache if it is enabled.
	 *
	 * @param ospCluster the osp cluster
	 */
	public static void cacheResult(OSPCluster ospCluster) {
		getPersistence().cacheResult(ospCluster);
	}

	/**
	 * Caches the osp clusters in the entity cache if it is enabled.
	 *
	 * @param ospClusters the osp clusters
	 */
	public static void cacheResult(List<OSPCluster> ospClusters) {
		getPersistence().cacheResult(ospClusters);
	}

	/**
	 * Creates a new osp cluster with the primary key. Does not add the osp cluster to the database.
	 *
	 * @param clusterId the primary key for the new osp cluster
	 * @return the new osp cluster
	 */
	public static OSPCluster create(long clusterId) {
		return getPersistence().create(clusterId);
	}

	/**
	 * Removes the osp cluster with the primary key from the database. Also notifies the appropriate model listeners.
	 *
	 * @param clusterId the primary key of the osp cluster
	 * @return the osp cluster that was removed
	 * @throws NoSuchOSPClusterException if a osp cluster with the primary key could not be found
	 */
	public static OSPCluster remove(long clusterId)
		throws com.osp.icebreaker.exception.NoSuchOSPClusterException {

		return getPersistence().remove(clusterId);
	}

	public static OSPCluster updateImpl(OSPCluster ospCluster) {
		return getPersistence().updateImpl(ospCluster);
	}

	/**
	 * Returns the osp cluster with the primary key or throws a <code>NoSuchOSPClusterException</code> if it could not be found.
	 *
	 * @param clusterId the primary key of the osp cluster
	 * @return the osp cluster
	 * @throws NoSuchOSPClusterException if a osp cluster with the primary key could not be found
	 */
	public static OSPCluster findByPrimaryKey(long clusterId)
		throws com.osp.icebreaker.exception.NoSuchOSPClusterException {

		return getPersistence().findByPrimaryKey(clusterId);
	}

	/**
	 * Returns the osp cluster with the primary key or returns <code>null</code> if it could not be found.
	 *
	 * @param clusterId the primary key of the osp cluster
	 * @return the osp cluster, or <code>null</code> if a osp cluster with the primary key could not be found
	 */
	public static OSPCluster fetchByPrimaryKey(long clusterId) {
		return getPersistence().fetchByPrimaryKey(clusterId);
	}

	/**
	 * Returns all the osp clusters.
	 *
	 * @return the osp clusters
	 */
	public static List<OSPCluster> findAll() {
		return getPersistence().findAll();
	}

	/**
	 * Returns a range of all the osp clusters.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not <code>QueryUtil#ALL_POS</code>), then the query will include the default ORDER BY logic from <code>OSPClusterModelImpl</code>. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	 * </p>
	 *
	 * @param start the lower bound of the range of osp clusters
	 * @param end the upper bound of the range of osp clusters (not inclusive)
	 * @return the range of osp clusters
	 */
	public static List<OSPCluster> findAll(int start, int end) {
		return getPersistence().findAll(start, end);
	}

	/**
	 * Returns an ordered range of all the osp clusters.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not <code>QueryUtil#ALL_POS</code>), then the query will include the default ORDER BY logic from <code>OSPClusterModelImpl</code>. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	 * </p>
	 *
	 * @param start the lower bound of the range of osp clusters
	 * @param end the upper bound of the range of osp clusters (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @return the ordered range of osp clusters
	 */
	public static List<OSPCluster> findAll(
		int start, int end, OrderByComparator<OSPCluster> orderByComparator) {

		return getPersistence().findAll(start, end, orderByComparator);
	}

	/**
	 * Returns an ordered range of all the osp clusters.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not <code>QueryUtil#ALL_POS</code>), then the query will include the default ORDER BY logic from <code>OSPClusterModelImpl</code>. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	 * </p>
	 *
	 * @param start the lower bound of the range of osp clusters
	 * @param end the upper bound of the range of osp clusters (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @param retrieveFromCache whether to retrieve from the finder cache
	 * @return the ordered range of osp clusters
	 */
	public static List<OSPCluster> findAll(
		int start, int end, OrderByComparator<OSPCluster> orderByComparator,
		boolean retrieveFromCache) {

		return getPersistence().findAll(
			start, end, orderByComparator, retrieveFromCache);
	}

	/**
	 * Removes all the osp clusters from the database.
	 */
	public static void removeAll() {
		getPersistence().removeAll();
	}

	/**
	 * Returns the number of osp clusters.
	 *
	 * @return the number of osp clusters
	 */
	public static int countAll() {
		return getPersistence().countAll();
	}

	public static OSPClusterPersistence getPersistence() {
		return _serviceTracker.getService();
	}

	private static ServiceTracker<OSPClusterPersistence, OSPClusterPersistence>
		_serviceTracker;

	static {
		Bundle bundle = FrameworkUtil.getBundle(OSPClusterPersistence.class);

		ServiceTracker<OSPClusterPersistence, OSPClusterPersistence>
			serviceTracker =
				new ServiceTracker
					<OSPClusterPersistence, OSPClusterPersistence>(
						bundle.getBundleContext(), OSPClusterPersistence.class,
						null);

		serviceTracker.open();

		_serviceTracker = serviceTracker;
	}

}