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

import com.osp.icebreaker.model.IcebreakerEntry;

import java.io.Serializable;

import java.util.List;
import java.util.Map;
import java.util.Set;

import org.osgi.annotation.versioning.ProviderType;
import org.osgi.framework.Bundle;
import org.osgi.framework.FrameworkUtil;
import org.osgi.util.tracker.ServiceTracker;

/**
 * The persistence utility for the icebreaker entry service. This utility wraps <code>com.osp.icebreaker.service.persistence.impl.IcebreakerEntryPersistenceImpl</code> and provides direct access to the database for CRUD operations. This utility should only be used by the service layer, as it must operate within a transaction. Never access this utility in a JSP, controller, model, or other front-end class.
 *
 * <p>
 * Caching information and settings can be found in <code>portal.properties</code>
 * </p>
 *
 * @author Jerry H. Seo
 * @see IcebreakerEntryPersistence
 * @generated
 */
@ProviderType
public class IcebreakerEntryUtil {

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
	public static void clearCache(IcebreakerEntry icebreakerEntry) {
		getPersistence().clearCache(icebreakerEntry);
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
	public static Map<Serializable, IcebreakerEntry> fetchByPrimaryKeys(
		Set<Serializable> primaryKeys) {

		return getPersistence().fetchByPrimaryKeys(primaryKeys);
	}

	/**
	 * @see com.liferay.portal.kernel.service.persistence.BasePersistence#findWithDynamicQuery(DynamicQuery)
	 */
	public static List<IcebreakerEntry> findWithDynamicQuery(
		DynamicQuery dynamicQuery) {

		return getPersistence().findWithDynamicQuery(dynamicQuery);
	}

	/**
	 * @see com.liferay.portal.kernel.service.persistence.BasePersistence#findWithDynamicQuery(DynamicQuery, int, int)
	 */
	public static List<IcebreakerEntry> findWithDynamicQuery(
		DynamicQuery dynamicQuery, int start, int end) {

		return getPersistence().findWithDynamicQuery(dynamicQuery, start, end);
	}

	/**
	 * @see com.liferay.portal.kernel.service.persistence.BasePersistence#findWithDynamicQuery(DynamicQuery, int, int, OrderByComparator)
	 */
	public static List<IcebreakerEntry> findWithDynamicQuery(
		DynamicQuery dynamicQuery, int start, int end,
		OrderByComparator<IcebreakerEntry> orderByComparator) {

		return getPersistence().findWithDynamicQuery(
			dynamicQuery, start, end, orderByComparator);
	}

	/**
	 * @see com.liferay.portal.kernel.service.persistence.BasePersistence#update(com.liferay.portal.kernel.model.BaseModel)
	 */
	public static IcebreakerEntry update(IcebreakerEntry icebreakerEntry) {
		return getPersistence().update(icebreakerEntry);
	}

	/**
	 * @see com.liferay.portal.kernel.service.persistence.BasePersistence#update(com.liferay.portal.kernel.model.BaseModel, ServiceContext)
	 */
	public static IcebreakerEntry update(
		IcebreakerEntry icebreakerEntry, ServiceContext serviceContext) {

		return getPersistence().update(icebreakerEntry, serviceContext);
	}

	/**
	 * Returns all the icebreaker entries where uuid = &#63;.
	 *
	 * @param uuid the uuid
	 * @return the matching icebreaker entries
	 */
	public static List<IcebreakerEntry> findByUuid(String uuid) {
		return getPersistence().findByUuid(uuid);
	}

	/**
	 * Returns a range of all the icebreaker entries where uuid = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not <code>QueryUtil#ALL_POS</code>), then the query will include the default ORDER BY logic from <code>IcebreakerEntryModelImpl</code>. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	 * </p>
	 *
	 * @param uuid the uuid
	 * @param start the lower bound of the range of icebreaker entries
	 * @param end the upper bound of the range of icebreaker entries (not inclusive)
	 * @return the range of matching icebreaker entries
	 */
	public static List<IcebreakerEntry> findByUuid(
		String uuid, int start, int end) {

		return getPersistence().findByUuid(uuid, start, end);
	}

	/**
	 * Returns an ordered range of all the icebreaker entries where uuid = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not <code>QueryUtil#ALL_POS</code>), then the query will include the default ORDER BY logic from <code>IcebreakerEntryModelImpl</code>. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	 * </p>
	 *
	 * @param uuid the uuid
	 * @param start the lower bound of the range of icebreaker entries
	 * @param end the upper bound of the range of icebreaker entries (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @return the ordered range of matching icebreaker entries
	 */
	public static List<IcebreakerEntry> findByUuid(
		String uuid, int start, int end,
		OrderByComparator<IcebreakerEntry> orderByComparator) {

		return getPersistence().findByUuid(uuid, start, end, orderByComparator);
	}

	/**
	 * Returns an ordered range of all the icebreaker entries where uuid = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not <code>QueryUtil#ALL_POS</code>), then the query will include the default ORDER BY logic from <code>IcebreakerEntryModelImpl</code>. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	 * </p>
	 *
	 * @param uuid the uuid
	 * @param start the lower bound of the range of icebreaker entries
	 * @param end the upper bound of the range of icebreaker entries (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @param retrieveFromCache whether to retrieve from the finder cache
	 * @return the ordered range of matching icebreaker entries
	 */
	public static List<IcebreakerEntry> findByUuid(
		String uuid, int start, int end,
		OrderByComparator<IcebreakerEntry> orderByComparator,
		boolean retrieveFromCache) {

		return getPersistence().findByUuid(
			uuid, start, end, orderByComparator, retrieveFromCache);
	}

	/**
	 * Returns the first icebreaker entry in the ordered set where uuid = &#63;.
	 *
	 * @param uuid the uuid
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching icebreaker entry
	 * @throws NoSuchIcebreakerEntryException if a matching icebreaker entry could not be found
	 */
	public static IcebreakerEntry findByUuid_First(
			String uuid, OrderByComparator<IcebreakerEntry> orderByComparator)
		throws com.osp.icebreaker.exception.NoSuchIcebreakerEntryException {

		return getPersistence().findByUuid_First(uuid, orderByComparator);
	}

	/**
	 * Returns the first icebreaker entry in the ordered set where uuid = &#63;.
	 *
	 * @param uuid the uuid
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching icebreaker entry, or <code>null</code> if a matching icebreaker entry could not be found
	 */
	public static IcebreakerEntry fetchByUuid_First(
		String uuid, OrderByComparator<IcebreakerEntry> orderByComparator) {

		return getPersistence().fetchByUuid_First(uuid, orderByComparator);
	}

	/**
	 * Returns the last icebreaker entry in the ordered set where uuid = &#63;.
	 *
	 * @param uuid the uuid
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching icebreaker entry
	 * @throws NoSuchIcebreakerEntryException if a matching icebreaker entry could not be found
	 */
	public static IcebreakerEntry findByUuid_Last(
			String uuid, OrderByComparator<IcebreakerEntry> orderByComparator)
		throws com.osp.icebreaker.exception.NoSuchIcebreakerEntryException {

		return getPersistence().findByUuid_Last(uuid, orderByComparator);
	}

	/**
	 * Returns the last icebreaker entry in the ordered set where uuid = &#63;.
	 *
	 * @param uuid the uuid
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching icebreaker entry, or <code>null</code> if a matching icebreaker entry could not be found
	 */
	public static IcebreakerEntry fetchByUuid_Last(
		String uuid, OrderByComparator<IcebreakerEntry> orderByComparator) {

		return getPersistence().fetchByUuid_Last(uuid, orderByComparator);
	}

	/**
	 * Returns the icebreaker entries before and after the current icebreaker entry in the ordered set where uuid = &#63;.
	 *
	 * @param icebreakerEntryId the primary key of the current icebreaker entry
	 * @param uuid the uuid
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the previous, current, and next icebreaker entry
	 * @throws NoSuchIcebreakerEntryException if a icebreaker entry with the primary key could not be found
	 */
	public static IcebreakerEntry[] findByUuid_PrevAndNext(
			long icebreakerEntryId, String uuid,
			OrderByComparator<IcebreakerEntry> orderByComparator)
		throws com.osp.icebreaker.exception.NoSuchIcebreakerEntryException {

		return getPersistence().findByUuid_PrevAndNext(
			icebreakerEntryId, uuid, orderByComparator);
	}

	/**
	 * Removes all the icebreaker entries where uuid = &#63; from the database.
	 *
	 * @param uuid the uuid
	 */
	public static void removeByUuid(String uuid) {
		getPersistence().removeByUuid(uuid);
	}

	/**
	 * Returns the number of icebreaker entries where uuid = &#63;.
	 *
	 * @param uuid the uuid
	 * @return the number of matching icebreaker entries
	 */
	public static int countByUuid(String uuid) {
		return getPersistence().countByUuid(uuid);
	}

	/**
	 * Returns the icebreaker entry where uuid = &#63; and groupId = &#63; or throws a <code>NoSuchIcebreakerEntryException</code> if it could not be found.
	 *
	 * @param uuid the uuid
	 * @param groupId the group ID
	 * @return the matching icebreaker entry
	 * @throws NoSuchIcebreakerEntryException if a matching icebreaker entry could not be found
	 */
	public static IcebreakerEntry findByUUID_G(String uuid, long groupId)
		throws com.osp.icebreaker.exception.NoSuchIcebreakerEntryException {

		return getPersistence().findByUUID_G(uuid, groupId);
	}

	/**
	 * Returns the icebreaker entry where uuid = &#63; and groupId = &#63; or returns <code>null</code> if it could not be found. Uses the finder cache.
	 *
	 * @param uuid the uuid
	 * @param groupId the group ID
	 * @return the matching icebreaker entry, or <code>null</code> if a matching icebreaker entry could not be found
	 */
	public static IcebreakerEntry fetchByUUID_G(String uuid, long groupId) {
		return getPersistence().fetchByUUID_G(uuid, groupId);
	}

	/**
	 * Returns the icebreaker entry where uuid = &#63; and groupId = &#63; or returns <code>null</code> if it could not be found, optionally using the finder cache.
	 *
	 * @param uuid the uuid
	 * @param groupId the group ID
	 * @param retrieveFromCache whether to retrieve from the finder cache
	 * @return the matching icebreaker entry, or <code>null</code> if a matching icebreaker entry could not be found
	 */
	public static IcebreakerEntry fetchByUUID_G(
		String uuid, long groupId, boolean retrieveFromCache) {

		return getPersistence().fetchByUUID_G(uuid, groupId, retrieveFromCache);
	}

	/**
	 * Removes the icebreaker entry where uuid = &#63; and groupId = &#63; from the database.
	 *
	 * @param uuid the uuid
	 * @param groupId the group ID
	 * @return the icebreaker entry that was removed
	 */
	public static IcebreakerEntry removeByUUID_G(String uuid, long groupId)
		throws com.osp.icebreaker.exception.NoSuchIcebreakerEntryException {

		return getPersistence().removeByUUID_G(uuid, groupId);
	}

	/**
	 * Returns the number of icebreaker entries where uuid = &#63; and groupId = &#63;.
	 *
	 * @param uuid the uuid
	 * @param groupId the group ID
	 * @return the number of matching icebreaker entries
	 */
	public static int countByUUID_G(String uuid, long groupId) {
		return getPersistence().countByUUID_G(uuid, groupId);
	}

	/**
	 * Returns all the icebreaker entries where uuid = &#63; and companyId = &#63;.
	 *
	 * @param uuid the uuid
	 * @param companyId the company ID
	 * @return the matching icebreaker entries
	 */
	public static List<IcebreakerEntry> findByUuid_C(
		String uuid, long companyId) {

		return getPersistence().findByUuid_C(uuid, companyId);
	}

	/**
	 * Returns a range of all the icebreaker entries where uuid = &#63; and companyId = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not <code>QueryUtil#ALL_POS</code>), then the query will include the default ORDER BY logic from <code>IcebreakerEntryModelImpl</code>. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	 * </p>
	 *
	 * @param uuid the uuid
	 * @param companyId the company ID
	 * @param start the lower bound of the range of icebreaker entries
	 * @param end the upper bound of the range of icebreaker entries (not inclusive)
	 * @return the range of matching icebreaker entries
	 */
	public static List<IcebreakerEntry> findByUuid_C(
		String uuid, long companyId, int start, int end) {

		return getPersistence().findByUuid_C(uuid, companyId, start, end);
	}

	/**
	 * Returns an ordered range of all the icebreaker entries where uuid = &#63; and companyId = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not <code>QueryUtil#ALL_POS</code>), then the query will include the default ORDER BY logic from <code>IcebreakerEntryModelImpl</code>. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	 * </p>
	 *
	 * @param uuid the uuid
	 * @param companyId the company ID
	 * @param start the lower bound of the range of icebreaker entries
	 * @param end the upper bound of the range of icebreaker entries (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @return the ordered range of matching icebreaker entries
	 */
	public static List<IcebreakerEntry> findByUuid_C(
		String uuid, long companyId, int start, int end,
		OrderByComparator<IcebreakerEntry> orderByComparator) {

		return getPersistence().findByUuid_C(
			uuid, companyId, start, end, orderByComparator);
	}

	/**
	 * Returns an ordered range of all the icebreaker entries where uuid = &#63; and companyId = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not <code>QueryUtil#ALL_POS</code>), then the query will include the default ORDER BY logic from <code>IcebreakerEntryModelImpl</code>. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	 * </p>
	 *
	 * @param uuid the uuid
	 * @param companyId the company ID
	 * @param start the lower bound of the range of icebreaker entries
	 * @param end the upper bound of the range of icebreaker entries (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @param retrieveFromCache whether to retrieve from the finder cache
	 * @return the ordered range of matching icebreaker entries
	 */
	public static List<IcebreakerEntry> findByUuid_C(
		String uuid, long companyId, int start, int end,
		OrderByComparator<IcebreakerEntry> orderByComparator,
		boolean retrieveFromCache) {

		return getPersistence().findByUuid_C(
			uuid, companyId, start, end, orderByComparator, retrieveFromCache);
	}

	/**
	 * Returns the first icebreaker entry in the ordered set where uuid = &#63; and companyId = &#63;.
	 *
	 * @param uuid the uuid
	 * @param companyId the company ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching icebreaker entry
	 * @throws NoSuchIcebreakerEntryException if a matching icebreaker entry could not be found
	 */
	public static IcebreakerEntry findByUuid_C_First(
			String uuid, long companyId,
			OrderByComparator<IcebreakerEntry> orderByComparator)
		throws com.osp.icebreaker.exception.NoSuchIcebreakerEntryException {

		return getPersistence().findByUuid_C_First(
			uuid, companyId, orderByComparator);
	}

	/**
	 * Returns the first icebreaker entry in the ordered set where uuid = &#63; and companyId = &#63;.
	 *
	 * @param uuid the uuid
	 * @param companyId the company ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching icebreaker entry, or <code>null</code> if a matching icebreaker entry could not be found
	 */
	public static IcebreakerEntry fetchByUuid_C_First(
		String uuid, long companyId,
		OrderByComparator<IcebreakerEntry> orderByComparator) {

		return getPersistence().fetchByUuid_C_First(
			uuid, companyId, orderByComparator);
	}

	/**
	 * Returns the last icebreaker entry in the ordered set where uuid = &#63; and companyId = &#63;.
	 *
	 * @param uuid the uuid
	 * @param companyId the company ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching icebreaker entry
	 * @throws NoSuchIcebreakerEntryException if a matching icebreaker entry could not be found
	 */
	public static IcebreakerEntry findByUuid_C_Last(
			String uuid, long companyId,
			OrderByComparator<IcebreakerEntry> orderByComparator)
		throws com.osp.icebreaker.exception.NoSuchIcebreakerEntryException {

		return getPersistence().findByUuid_C_Last(
			uuid, companyId, orderByComparator);
	}

	/**
	 * Returns the last icebreaker entry in the ordered set where uuid = &#63; and companyId = &#63;.
	 *
	 * @param uuid the uuid
	 * @param companyId the company ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching icebreaker entry, or <code>null</code> if a matching icebreaker entry could not be found
	 */
	public static IcebreakerEntry fetchByUuid_C_Last(
		String uuid, long companyId,
		OrderByComparator<IcebreakerEntry> orderByComparator) {

		return getPersistence().fetchByUuid_C_Last(
			uuid, companyId, orderByComparator);
	}

	/**
	 * Returns the icebreaker entries before and after the current icebreaker entry in the ordered set where uuid = &#63; and companyId = &#63;.
	 *
	 * @param icebreakerEntryId the primary key of the current icebreaker entry
	 * @param uuid the uuid
	 * @param companyId the company ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the previous, current, and next icebreaker entry
	 * @throws NoSuchIcebreakerEntryException if a icebreaker entry with the primary key could not be found
	 */
	public static IcebreakerEntry[] findByUuid_C_PrevAndNext(
			long icebreakerEntryId, String uuid, long companyId,
			OrderByComparator<IcebreakerEntry> orderByComparator)
		throws com.osp.icebreaker.exception.NoSuchIcebreakerEntryException {

		return getPersistence().findByUuid_C_PrevAndNext(
			icebreakerEntryId, uuid, companyId, orderByComparator);
	}

	/**
	 * Removes all the icebreaker entries where uuid = &#63; and companyId = &#63; from the database.
	 *
	 * @param uuid the uuid
	 * @param companyId the company ID
	 */
	public static void removeByUuid_C(String uuid, long companyId) {
		getPersistence().removeByUuid_C(uuid, companyId);
	}

	/**
	 * Returns the number of icebreaker entries where uuid = &#63; and companyId = &#63;.
	 *
	 * @param uuid the uuid
	 * @param companyId the company ID
	 * @return the number of matching icebreaker entries
	 */
	public static int countByUuid_C(String uuid, long companyId) {
		return getPersistence().countByUuid_C(uuid, companyId);
	}

	/**
	 * Returns all the icebreaker entries where groupId = &#63;.
	 *
	 * @param groupId the group ID
	 * @return the matching icebreaker entries
	 */
	public static List<IcebreakerEntry> findByGroupId(long groupId) {
		return getPersistence().findByGroupId(groupId);
	}

	/**
	 * Returns a range of all the icebreaker entries where groupId = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not <code>QueryUtil#ALL_POS</code>), then the query will include the default ORDER BY logic from <code>IcebreakerEntryModelImpl</code>. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	 * </p>
	 *
	 * @param groupId the group ID
	 * @param start the lower bound of the range of icebreaker entries
	 * @param end the upper bound of the range of icebreaker entries (not inclusive)
	 * @return the range of matching icebreaker entries
	 */
	public static List<IcebreakerEntry> findByGroupId(
		long groupId, int start, int end) {

		return getPersistence().findByGroupId(groupId, start, end);
	}

	/**
	 * Returns an ordered range of all the icebreaker entries where groupId = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not <code>QueryUtil#ALL_POS</code>), then the query will include the default ORDER BY logic from <code>IcebreakerEntryModelImpl</code>. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	 * </p>
	 *
	 * @param groupId the group ID
	 * @param start the lower bound of the range of icebreaker entries
	 * @param end the upper bound of the range of icebreaker entries (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @return the ordered range of matching icebreaker entries
	 */
	public static List<IcebreakerEntry> findByGroupId(
		long groupId, int start, int end,
		OrderByComparator<IcebreakerEntry> orderByComparator) {

		return getPersistence().findByGroupId(
			groupId, start, end, orderByComparator);
	}

	/**
	 * Returns an ordered range of all the icebreaker entries where groupId = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not <code>QueryUtil#ALL_POS</code>), then the query will include the default ORDER BY logic from <code>IcebreakerEntryModelImpl</code>. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	 * </p>
	 *
	 * @param groupId the group ID
	 * @param start the lower bound of the range of icebreaker entries
	 * @param end the upper bound of the range of icebreaker entries (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @param retrieveFromCache whether to retrieve from the finder cache
	 * @return the ordered range of matching icebreaker entries
	 */
	public static List<IcebreakerEntry> findByGroupId(
		long groupId, int start, int end,
		OrderByComparator<IcebreakerEntry> orderByComparator,
		boolean retrieveFromCache) {

		return getPersistence().findByGroupId(
			groupId, start, end, orderByComparator, retrieveFromCache);
	}

	/**
	 * Returns the first icebreaker entry in the ordered set where groupId = &#63;.
	 *
	 * @param groupId the group ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching icebreaker entry
	 * @throws NoSuchIcebreakerEntryException if a matching icebreaker entry could not be found
	 */
	public static IcebreakerEntry findByGroupId_First(
			long groupId, OrderByComparator<IcebreakerEntry> orderByComparator)
		throws com.osp.icebreaker.exception.NoSuchIcebreakerEntryException {

		return getPersistence().findByGroupId_First(groupId, orderByComparator);
	}

	/**
	 * Returns the first icebreaker entry in the ordered set where groupId = &#63;.
	 *
	 * @param groupId the group ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching icebreaker entry, or <code>null</code> if a matching icebreaker entry could not be found
	 */
	public static IcebreakerEntry fetchByGroupId_First(
		long groupId, OrderByComparator<IcebreakerEntry> orderByComparator) {

		return getPersistence().fetchByGroupId_First(
			groupId, orderByComparator);
	}

	/**
	 * Returns the last icebreaker entry in the ordered set where groupId = &#63;.
	 *
	 * @param groupId the group ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching icebreaker entry
	 * @throws NoSuchIcebreakerEntryException if a matching icebreaker entry could not be found
	 */
	public static IcebreakerEntry findByGroupId_Last(
			long groupId, OrderByComparator<IcebreakerEntry> orderByComparator)
		throws com.osp.icebreaker.exception.NoSuchIcebreakerEntryException {

		return getPersistence().findByGroupId_Last(groupId, orderByComparator);
	}

	/**
	 * Returns the last icebreaker entry in the ordered set where groupId = &#63;.
	 *
	 * @param groupId the group ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching icebreaker entry, or <code>null</code> if a matching icebreaker entry could not be found
	 */
	public static IcebreakerEntry fetchByGroupId_Last(
		long groupId, OrderByComparator<IcebreakerEntry> orderByComparator) {

		return getPersistence().fetchByGroupId_Last(groupId, orderByComparator);
	}

	/**
	 * Returns the icebreaker entries before and after the current icebreaker entry in the ordered set where groupId = &#63;.
	 *
	 * @param icebreakerEntryId the primary key of the current icebreaker entry
	 * @param groupId the group ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the previous, current, and next icebreaker entry
	 * @throws NoSuchIcebreakerEntryException if a icebreaker entry with the primary key could not be found
	 */
	public static IcebreakerEntry[] findByGroupId_PrevAndNext(
			long icebreakerEntryId, long groupId,
			OrderByComparator<IcebreakerEntry> orderByComparator)
		throws com.osp.icebreaker.exception.NoSuchIcebreakerEntryException {

		return getPersistence().findByGroupId_PrevAndNext(
			icebreakerEntryId, groupId, orderByComparator);
	}

	/**
	 * Removes all the icebreaker entries where groupId = &#63; from the database.
	 *
	 * @param groupId the group ID
	 */
	public static void removeByGroupId(long groupId) {
		getPersistence().removeByGroupId(groupId);
	}

	/**
	 * Returns the number of icebreaker entries where groupId = &#63;.
	 *
	 * @param groupId the group ID
	 * @return the number of matching icebreaker entries
	 */
	public static int countByGroupId(long groupId) {
		return getPersistence().countByGroupId(groupId);
	}

	/**
	 * Returns all the icebreaker entries where userId = &#63;.
	 *
	 * @param userId the user ID
	 * @return the matching icebreaker entries
	 */
	public static List<IcebreakerEntry> findByUserId(long userId) {
		return getPersistence().findByUserId(userId);
	}

	/**
	 * Returns a range of all the icebreaker entries where userId = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not <code>QueryUtil#ALL_POS</code>), then the query will include the default ORDER BY logic from <code>IcebreakerEntryModelImpl</code>. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	 * </p>
	 *
	 * @param userId the user ID
	 * @param start the lower bound of the range of icebreaker entries
	 * @param end the upper bound of the range of icebreaker entries (not inclusive)
	 * @return the range of matching icebreaker entries
	 */
	public static List<IcebreakerEntry> findByUserId(
		long userId, int start, int end) {

		return getPersistence().findByUserId(userId, start, end);
	}

	/**
	 * Returns an ordered range of all the icebreaker entries where userId = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not <code>QueryUtil#ALL_POS</code>), then the query will include the default ORDER BY logic from <code>IcebreakerEntryModelImpl</code>. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	 * </p>
	 *
	 * @param userId the user ID
	 * @param start the lower bound of the range of icebreaker entries
	 * @param end the upper bound of the range of icebreaker entries (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @return the ordered range of matching icebreaker entries
	 */
	public static List<IcebreakerEntry> findByUserId(
		long userId, int start, int end,
		OrderByComparator<IcebreakerEntry> orderByComparator) {

		return getPersistence().findByUserId(
			userId, start, end, orderByComparator);
	}

	/**
	 * Returns an ordered range of all the icebreaker entries where userId = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not <code>QueryUtil#ALL_POS</code>), then the query will include the default ORDER BY logic from <code>IcebreakerEntryModelImpl</code>. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	 * </p>
	 *
	 * @param userId the user ID
	 * @param start the lower bound of the range of icebreaker entries
	 * @param end the upper bound of the range of icebreaker entries (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @param retrieveFromCache whether to retrieve from the finder cache
	 * @return the ordered range of matching icebreaker entries
	 */
	public static List<IcebreakerEntry> findByUserId(
		long userId, int start, int end,
		OrderByComparator<IcebreakerEntry> orderByComparator,
		boolean retrieveFromCache) {

		return getPersistence().findByUserId(
			userId, start, end, orderByComparator, retrieveFromCache);
	}

	/**
	 * Returns the first icebreaker entry in the ordered set where userId = &#63;.
	 *
	 * @param userId the user ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching icebreaker entry
	 * @throws NoSuchIcebreakerEntryException if a matching icebreaker entry could not be found
	 */
	public static IcebreakerEntry findByUserId_First(
			long userId, OrderByComparator<IcebreakerEntry> orderByComparator)
		throws com.osp.icebreaker.exception.NoSuchIcebreakerEntryException {

		return getPersistence().findByUserId_First(userId, orderByComparator);
	}

	/**
	 * Returns the first icebreaker entry in the ordered set where userId = &#63;.
	 *
	 * @param userId the user ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching icebreaker entry, or <code>null</code> if a matching icebreaker entry could not be found
	 */
	public static IcebreakerEntry fetchByUserId_First(
		long userId, OrderByComparator<IcebreakerEntry> orderByComparator) {

		return getPersistence().fetchByUserId_First(userId, orderByComparator);
	}

	/**
	 * Returns the last icebreaker entry in the ordered set where userId = &#63;.
	 *
	 * @param userId the user ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching icebreaker entry
	 * @throws NoSuchIcebreakerEntryException if a matching icebreaker entry could not be found
	 */
	public static IcebreakerEntry findByUserId_Last(
			long userId, OrderByComparator<IcebreakerEntry> orderByComparator)
		throws com.osp.icebreaker.exception.NoSuchIcebreakerEntryException {

		return getPersistence().findByUserId_Last(userId, orderByComparator);
	}

	/**
	 * Returns the last icebreaker entry in the ordered set where userId = &#63;.
	 *
	 * @param userId the user ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching icebreaker entry, or <code>null</code> if a matching icebreaker entry could not be found
	 */
	public static IcebreakerEntry fetchByUserId_Last(
		long userId, OrderByComparator<IcebreakerEntry> orderByComparator) {

		return getPersistence().fetchByUserId_Last(userId, orderByComparator);
	}

	/**
	 * Returns the icebreaker entries before and after the current icebreaker entry in the ordered set where userId = &#63;.
	 *
	 * @param icebreakerEntryId the primary key of the current icebreaker entry
	 * @param userId the user ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the previous, current, and next icebreaker entry
	 * @throws NoSuchIcebreakerEntryException if a icebreaker entry with the primary key could not be found
	 */
	public static IcebreakerEntry[] findByUserId_PrevAndNext(
			long icebreakerEntryId, long userId,
			OrderByComparator<IcebreakerEntry> orderByComparator)
		throws com.osp.icebreaker.exception.NoSuchIcebreakerEntryException {

		return getPersistence().findByUserId_PrevAndNext(
			icebreakerEntryId, userId, orderByComparator);
	}

	/**
	 * Removes all the icebreaker entries where userId = &#63; from the database.
	 *
	 * @param userId the user ID
	 */
	public static void removeByUserId(long userId) {
		getPersistence().removeByUserId(userId);
	}

	/**
	 * Returns the number of icebreaker entries where userId = &#63;.
	 *
	 * @param userId the user ID
	 * @return the number of matching icebreaker entries
	 */
	public static int countByUserId(long userId) {
		return getPersistence().countByUserId(userId);
	}

	/**
	 * Returns the icebreaker entry where status = &#63; or throws a <code>NoSuchIcebreakerEntryException</code> if it could not be found.
	 *
	 * @param status the status
	 * @return the matching icebreaker entry
	 * @throws NoSuchIcebreakerEntryException if a matching icebreaker entry could not be found
	 */
	public static IcebreakerEntry findByStatus(int status)
		throws com.osp.icebreaker.exception.NoSuchIcebreakerEntryException {

		return getPersistence().findByStatus(status);
	}

	/**
	 * Returns the icebreaker entry where status = &#63; or returns <code>null</code> if it could not be found. Uses the finder cache.
	 *
	 * @param status the status
	 * @return the matching icebreaker entry, or <code>null</code> if a matching icebreaker entry could not be found
	 */
	public static IcebreakerEntry fetchByStatus(int status) {
		return getPersistence().fetchByStatus(status);
	}

	/**
	 * Returns the icebreaker entry where status = &#63; or returns <code>null</code> if it could not be found, optionally using the finder cache.
	 *
	 * @param status the status
	 * @param retrieveFromCache whether to retrieve from the finder cache
	 * @return the matching icebreaker entry, or <code>null</code> if a matching icebreaker entry could not be found
	 */
	public static IcebreakerEntry fetchByStatus(
		int status, boolean retrieveFromCache) {

		return getPersistence().fetchByStatus(status, retrieveFromCache);
	}

	/**
	 * Removes the icebreaker entry where status = &#63; from the database.
	 *
	 * @param status the status
	 * @return the icebreaker entry that was removed
	 */
	public static IcebreakerEntry removeByStatus(int status)
		throws com.osp.icebreaker.exception.NoSuchIcebreakerEntryException {

		return getPersistence().removeByStatus(status);
	}

	/**
	 * Returns the number of icebreaker entries where status = &#63;.
	 *
	 * @param status the status
	 * @return the number of matching icebreaker entries
	 */
	public static int countByStatus(int status) {
		return getPersistence().countByStatus(status);
	}

	/**
	 * Returns all the icebreaker entries where groupId = &#63; and status = &#63;.
	 *
	 * @param groupId the group ID
	 * @param status the status
	 * @return the matching icebreaker entries
	 */
	public static List<IcebreakerEntry> findBy_G_S(long groupId, int status) {
		return getPersistence().findBy_G_S(groupId, status);
	}

	/**
	 * Returns a range of all the icebreaker entries where groupId = &#63; and status = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not <code>QueryUtil#ALL_POS</code>), then the query will include the default ORDER BY logic from <code>IcebreakerEntryModelImpl</code>. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	 * </p>
	 *
	 * @param groupId the group ID
	 * @param status the status
	 * @param start the lower bound of the range of icebreaker entries
	 * @param end the upper bound of the range of icebreaker entries (not inclusive)
	 * @return the range of matching icebreaker entries
	 */
	public static List<IcebreakerEntry> findBy_G_S(
		long groupId, int status, int start, int end) {

		return getPersistence().findBy_G_S(groupId, status, start, end);
	}

	/**
	 * Returns an ordered range of all the icebreaker entries where groupId = &#63; and status = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not <code>QueryUtil#ALL_POS</code>), then the query will include the default ORDER BY logic from <code>IcebreakerEntryModelImpl</code>. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	 * </p>
	 *
	 * @param groupId the group ID
	 * @param status the status
	 * @param start the lower bound of the range of icebreaker entries
	 * @param end the upper bound of the range of icebreaker entries (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @return the ordered range of matching icebreaker entries
	 */
	public static List<IcebreakerEntry> findBy_G_S(
		long groupId, int status, int start, int end,
		OrderByComparator<IcebreakerEntry> orderByComparator) {

		return getPersistence().findBy_G_S(
			groupId, status, start, end, orderByComparator);
	}

	/**
	 * Returns an ordered range of all the icebreaker entries where groupId = &#63; and status = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not <code>QueryUtil#ALL_POS</code>), then the query will include the default ORDER BY logic from <code>IcebreakerEntryModelImpl</code>. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	 * </p>
	 *
	 * @param groupId the group ID
	 * @param status the status
	 * @param start the lower bound of the range of icebreaker entries
	 * @param end the upper bound of the range of icebreaker entries (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @param retrieveFromCache whether to retrieve from the finder cache
	 * @return the ordered range of matching icebreaker entries
	 */
	public static List<IcebreakerEntry> findBy_G_S(
		long groupId, int status, int start, int end,
		OrderByComparator<IcebreakerEntry> orderByComparator,
		boolean retrieveFromCache) {

		return getPersistence().findBy_G_S(
			groupId, status, start, end, orderByComparator, retrieveFromCache);
	}

	/**
	 * Returns the first icebreaker entry in the ordered set where groupId = &#63; and status = &#63;.
	 *
	 * @param groupId the group ID
	 * @param status the status
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching icebreaker entry
	 * @throws NoSuchIcebreakerEntryException if a matching icebreaker entry could not be found
	 */
	public static IcebreakerEntry findBy_G_S_First(
			long groupId, int status,
			OrderByComparator<IcebreakerEntry> orderByComparator)
		throws com.osp.icebreaker.exception.NoSuchIcebreakerEntryException {

		return getPersistence().findBy_G_S_First(
			groupId, status, orderByComparator);
	}

	/**
	 * Returns the first icebreaker entry in the ordered set where groupId = &#63; and status = &#63;.
	 *
	 * @param groupId the group ID
	 * @param status the status
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching icebreaker entry, or <code>null</code> if a matching icebreaker entry could not be found
	 */
	public static IcebreakerEntry fetchBy_G_S_First(
		long groupId, int status,
		OrderByComparator<IcebreakerEntry> orderByComparator) {

		return getPersistence().fetchBy_G_S_First(
			groupId, status, orderByComparator);
	}

	/**
	 * Returns the last icebreaker entry in the ordered set where groupId = &#63; and status = &#63;.
	 *
	 * @param groupId the group ID
	 * @param status the status
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching icebreaker entry
	 * @throws NoSuchIcebreakerEntryException if a matching icebreaker entry could not be found
	 */
	public static IcebreakerEntry findBy_G_S_Last(
			long groupId, int status,
			OrderByComparator<IcebreakerEntry> orderByComparator)
		throws com.osp.icebreaker.exception.NoSuchIcebreakerEntryException {

		return getPersistence().findBy_G_S_Last(
			groupId, status, orderByComparator);
	}

	/**
	 * Returns the last icebreaker entry in the ordered set where groupId = &#63; and status = &#63;.
	 *
	 * @param groupId the group ID
	 * @param status the status
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching icebreaker entry, or <code>null</code> if a matching icebreaker entry could not be found
	 */
	public static IcebreakerEntry fetchBy_G_S_Last(
		long groupId, int status,
		OrderByComparator<IcebreakerEntry> orderByComparator) {

		return getPersistence().fetchBy_G_S_Last(
			groupId, status, orderByComparator);
	}

	/**
	 * Returns the icebreaker entries before and after the current icebreaker entry in the ordered set where groupId = &#63; and status = &#63;.
	 *
	 * @param icebreakerEntryId the primary key of the current icebreaker entry
	 * @param groupId the group ID
	 * @param status the status
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the previous, current, and next icebreaker entry
	 * @throws NoSuchIcebreakerEntryException if a icebreaker entry with the primary key could not be found
	 */
	public static IcebreakerEntry[] findBy_G_S_PrevAndNext(
			long icebreakerEntryId, long groupId, int status,
			OrderByComparator<IcebreakerEntry> orderByComparator)
		throws com.osp.icebreaker.exception.NoSuchIcebreakerEntryException {

		return getPersistence().findBy_G_S_PrevAndNext(
			icebreakerEntryId, groupId, status, orderByComparator);
	}

	/**
	 * Removes all the icebreaker entries where groupId = &#63; and status = &#63; from the database.
	 *
	 * @param groupId the group ID
	 * @param status the status
	 */
	public static void removeBy_G_S(long groupId, int status) {
		getPersistence().removeBy_G_S(groupId, status);
	}

	/**
	 * Returns the number of icebreaker entries where groupId = &#63; and status = &#63;.
	 *
	 * @param groupId the group ID
	 * @param status the status
	 * @return the number of matching icebreaker entries
	 */
	public static int countBy_G_S(long groupId, int status) {
		return getPersistence().countBy_G_S(groupId, status);
	}

	/**
	 * Returns the icebreaker entry where type = &#63; or throws a <code>NoSuchIcebreakerEntryException</code> if it could not be found.
	 *
	 * @param type the type
	 * @return the matching icebreaker entry
	 * @throws NoSuchIcebreakerEntryException if a matching icebreaker entry could not be found
	 */
	public static IcebreakerEntry findByType(String type)
		throws com.osp.icebreaker.exception.NoSuchIcebreakerEntryException {

		return getPersistence().findByType(type);
	}

	/**
	 * Returns the icebreaker entry where type = &#63; or returns <code>null</code> if it could not be found. Uses the finder cache.
	 *
	 * @param type the type
	 * @return the matching icebreaker entry, or <code>null</code> if a matching icebreaker entry could not be found
	 */
	public static IcebreakerEntry fetchByType(String type) {
		return getPersistence().fetchByType(type);
	}

	/**
	 * Returns the icebreaker entry where type = &#63; or returns <code>null</code> if it could not be found, optionally using the finder cache.
	 *
	 * @param type the type
	 * @param retrieveFromCache whether to retrieve from the finder cache
	 * @return the matching icebreaker entry, or <code>null</code> if a matching icebreaker entry could not be found
	 */
	public static IcebreakerEntry fetchByType(
		String type, boolean retrieveFromCache) {

		return getPersistence().fetchByType(type, retrieveFromCache);
	}

	/**
	 * Removes the icebreaker entry where type = &#63; from the database.
	 *
	 * @param type the type
	 * @return the icebreaker entry that was removed
	 */
	public static IcebreakerEntry removeByType(String type)
		throws com.osp.icebreaker.exception.NoSuchIcebreakerEntryException {

		return getPersistence().removeByType(type);
	}

	/**
	 * Returns the number of icebreaker entries where type = &#63;.
	 *
	 * @param type the type
	 * @return the number of matching icebreaker entries
	 */
	public static int countByType(String type) {
		return getPersistence().countByType(type);
	}

	/**
	 * Caches the icebreaker entry in the entity cache if it is enabled.
	 *
	 * @param icebreakerEntry the icebreaker entry
	 */
	public static void cacheResult(IcebreakerEntry icebreakerEntry) {
		getPersistence().cacheResult(icebreakerEntry);
	}

	/**
	 * Caches the icebreaker entries in the entity cache if it is enabled.
	 *
	 * @param icebreakerEntries the icebreaker entries
	 */
	public static void cacheResult(List<IcebreakerEntry> icebreakerEntries) {
		getPersistence().cacheResult(icebreakerEntries);
	}

	/**
	 * Creates a new icebreaker entry with the primary key. Does not add the icebreaker entry to the database.
	 *
	 * @param icebreakerEntryId the primary key for the new icebreaker entry
	 * @return the new icebreaker entry
	 */
	public static IcebreakerEntry create(long icebreakerEntryId) {
		return getPersistence().create(icebreakerEntryId);
	}

	/**
	 * Removes the icebreaker entry with the primary key from the database. Also notifies the appropriate model listeners.
	 *
	 * @param icebreakerEntryId the primary key of the icebreaker entry
	 * @return the icebreaker entry that was removed
	 * @throws NoSuchIcebreakerEntryException if a icebreaker entry with the primary key could not be found
	 */
	public static IcebreakerEntry remove(long icebreakerEntryId)
		throws com.osp.icebreaker.exception.NoSuchIcebreakerEntryException {

		return getPersistence().remove(icebreakerEntryId);
	}

	public static IcebreakerEntry updateImpl(IcebreakerEntry icebreakerEntry) {
		return getPersistence().updateImpl(icebreakerEntry);
	}

	/**
	 * Returns the icebreaker entry with the primary key or throws a <code>NoSuchIcebreakerEntryException</code> if it could not be found.
	 *
	 * @param icebreakerEntryId the primary key of the icebreaker entry
	 * @return the icebreaker entry
	 * @throws NoSuchIcebreakerEntryException if a icebreaker entry with the primary key could not be found
	 */
	public static IcebreakerEntry findByPrimaryKey(long icebreakerEntryId)
		throws com.osp.icebreaker.exception.NoSuchIcebreakerEntryException {

		return getPersistence().findByPrimaryKey(icebreakerEntryId);
	}

	/**
	 * Returns the icebreaker entry with the primary key or returns <code>null</code> if it could not be found.
	 *
	 * @param icebreakerEntryId the primary key of the icebreaker entry
	 * @return the icebreaker entry, or <code>null</code> if a icebreaker entry with the primary key could not be found
	 */
	public static IcebreakerEntry fetchByPrimaryKey(long icebreakerEntryId) {
		return getPersistence().fetchByPrimaryKey(icebreakerEntryId);
	}

	/**
	 * Returns all the icebreaker entries.
	 *
	 * @return the icebreaker entries
	 */
	public static List<IcebreakerEntry> findAll() {
		return getPersistence().findAll();
	}

	/**
	 * Returns a range of all the icebreaker entries.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not <code>QueryUtil#ALL_POS</code>), then the query will include the default ORDER BY logic from <code>IcebreakerEntryModelImpl</code>. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	 * </p>
	 *
	 * @param start the lower bound of the range of icebreaker entries
	 * @param end the upper bound of the range of icebreaker entries (not inclusive)
	 * @return the range of icebreaker entries
	 */
	public static List<IcebreakerEntry> findAll(int start, int end) {
		return getPersistence().findAll(start, end);
	}

	/**
	 * Returns an ordered range of all the icebreaker entries.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not <code>QueryUtil#ALL_POS</code>), then the query will include the default ORDER BY logic from <code>IcebreakerEntryModelImpl</code>. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	 * </p>
	 *
	 * @param start the lower bound of the range of icebreaker entries
	 * @param end the upper bound of the range of icebreaker entries (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @return the ordered range of icebreaker entries
	 */
	public static List<IcebreakerEntry> findAll(
		int start, int end,
		OrderByComparator<IcebreakerEntry> orderByComparator) {

		return getPersistence().findAll(start, end, orderByComparator);
	}

	/**
	 * Returns an ordered range of all the icebreaker entries.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not <code>QueryUtil#ALL_POS</code>), then the query will include the default ORDER BY logic from <code>IcebreakerEntryModelImpl</code>. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	 * </p>
	 *
	 * @param start the lower bound of the range of icebreaker entries
	 * @param end the upper bound of the range of icebreaker entries (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @param retrieveFromCache whether to retrieve from the finder cache
	 * @return the ordered range of icebreaker entries
	 */
	public static List<IcebreakerEntry> findAll(
		int start, int end,
		OrderByComparator<IcebreakerEntry> orderByComparator,
		boolean retrieveFromCache) {

		return getPersistence().findAll(
			start, end, orderByComparator, retrieveFromCache);
	}

	/**
	 * Removes all the icebreaker entries from the database.
	 */
	public static void removeAll() {
		getPersistence().removeAll();
	}

	/**
	 * Returns the number of icebreaker entries.
	 *
	 * @return the number of icebreaker entries
	 */
	public static int countAll() {
		return getPersistence().countAll();
	}

	public static IcebreakerEntryPersistence getPersistence() {
		return _serviceTracker.getService();
	}

	private static ServiceTracker
		<IcebreakerEntryPersistence, IcebreakerEntryPersistence>
			_serviceTracker;

	static {
		Bundle bundle = FrameworkUtil.getBundle(
			IcebreakerEntryPersistence.class);

		ServiceTracker<IcebreakerEntryPersistence, IcebreakerEntryPersistence>
			serviceTracker =
				new ServiceTracker
					<IcebreakerEntryPersistence, IcebreakerEntryPersistence>(
						bundle.getBundleContext(),
						IcebreakerEntryPersistence.class, null);

		serviceTracker.open();

		_serviceTracker = serviceTracker;
	}

}