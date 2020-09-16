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

import com.osp.icebreaker.exception.NoSuchIcebreakerEntryException;
import com.osp.icebreaker.model.IcebreakerEntry;

import org.osgi.annotation.versioning.ProviderType;

/**
 * The persistence interface for the icebreaker entry service.
 *
 * <p>
 * Caching information and settings can be found in <code>portal.properties</code>
 * </p>
 *
 * @author Jerry H. Seo
 * @see IcebreakerEntryUtil
 * @generated
 */
@ProviderType
public interface IcebreakerEntryPersistence
	extends BasePersistence<IcebreakerEntry> {

	/*
	 * NOTE FOR DEVELOPERS:
	 *
	 * Never modify or reference this interface directly. Always use {@link IcebreakerEntryUtil} to access the icebreaker entry persistence. Modify <code>service.xml</code> and rerun ServiceBuilder to regenerate this interface.
	 */

	/**
	 * Returns all the icebreaker entries where uuid = &#63;.
	 *
	 * @param uuid the uuid
	 * @return the matching icebreaker entries
	 */
	public java.util.List<IcebreakerEntry> findByUuid(String uuid);

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
	public java.util.List<IcebreakerEntry> findByUuid(
		String uuid, int start, int end);

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
	public java.util.List<IcebreakerEntry> findByUuid(
		String uuid, int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator<IcebreakerEntry>
			orderByComparator);

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
	public java.util.List<IcebreakerEntry> findByUuid(
		String uuid, int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator<IcebreakerEntry>
			orderByComparator,
		boolean retrieveFromCache);

	/**
	 * Returns the first icebreaker entry in the ordered set where uuid = &#63;.
	 *
	 * @param uuid the uuid
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching icebreaker entry
	 * @throws NoSuchIcebreakerEntryException if a matching icebreaker entry could not be found
	 */
	public IcebreakerEntry findByUuid_First(
			String uuid,
			com.liferay.portal.kernel.util.OrderByComparator<IcebreakerEntry>
				orderByComparator)
		throws NoSuchIcebreakerEntryException;

	/**
	 * Returns the first icebreaker entry in the ordered set where uuid = &#63;.
	 *
	 * @param uuid the uuid
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching icebreaker entry, or <code>null</code> if a matching icebreaker entry could not be found
	 */
	public IcebreakerEntry fetchByUuid_First(
		String uuid,
		com.liferay.portal.kernel.util.OrderByComparator<IcebreakerEntry>
			orderByComparator);

	/**
	 * Returns the last icebreaker entry in the ordered set where uuid = &#63;.
	 *
	 * @param uuid the uuid
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching icebreaker entry
	 * @throws NoSuchIcebreakerEntryException if a matching icebreaker entry could not be found
	 */
	public IcebreakerEntry findByUuid_Last(
			String uuid,
			com.liferay.portal.kernel.util.OrderByComparator<IcebreakerEntry>
				orderByComparator)
		throws NoSuchIcebreakerEntryException;

	/**
	 * Returns the last icebreaker entry in the ordered set where uuid = &#63;.
	 *
	 * @param uuid the uuid
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching icebreaker entry, or <code>null</code> if a matching icebreaker entry could not be found
	 */
	public IcebreakerEntry fetchByUuid_Last(
		String uuid,
		com.liferay.portal.kernel.util.OrderByComparator<IcebreakerEntry>
			orderByComparator);

	/**
	 * Returns the icebreaker entries before and after the current icebreaker entry in the ordered set where uuid = &#63;.
	 *
	 * @param icebreakerEntryId the primary key of the current icebreaker entry
	 * @param uuid the uuid
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the previous, current, and next icebreaker entry
	 * @throws NoSuchIcebreakerEntryException if a icebreaker entry with the primary key could not be found
	 */
	public IcebreakerEntry[] findByUuid_PrevAndNext(
			long icebreakerEntryId, String uuid,
			com.liferay.portal.kernel.util.OrderByComparator<IcebreakerEntry>
				orderByComparator)
		throws NoSuchIcebreakerEntryException;

	/**
	 * Removes all the icebreaker entries where uuid = &#63; from the database.
	 *
	 * @param uuid the uuid
	 */
	public void removeByUuid(String uuid);

	/**
	 * Returns the number of icebreaker entries where uuid = &#63;.
	 *
	 * @param uuid the uuid
	 * @return the number of matching icebreaker entries
	 */
	public int countByUuid(String uuid);

	/**
	 * Returns the icebreaker entry where uuid = &#63; and groupId = &#63; or throws a <code>NoSuchIcebreakerEntryException</code> if it could not be found.
	 *
	 * @param uuid the uuid
	 * @param groupId the group ID
	 * @return the matching icebreaker entry
	 * @throws NoSuchIcebreakerEntryException if a matching icebreaker entry could not be found
	 */
	public IcebreakerEntry findByUUID_G(String uuid, long groupId)
		throws NoSuchIcebreakerEntryException;

	/**
	 * Returns the icebreaker entry where uuid = &#63; and groupId = &#63; or returns <code>null</code> if it could not be found. Uses the finder cache.
	 *
	 * @param uuid the uuid
	 * @param groupId the group ID
	 * @return the matching icebreaker entry, or <code>null</code> if a matching icebreaker entry could not be found
	 */
	public IcebreakerEntry fetchByUUID_G(String uuid, long groupId);

	/**
	 * Returns the icebreaker entry where uuid = &#63; and groupId = &#63; or returns <code>null</code> if it could not be found, optionally using the finder cache.
	 *
	 * @param uuid the uuid
	 * @param groupId the group ID
	 * @param retrieveFromCache whether to retrieve from the finder cache
	 * @return the matching icebreaker entry, or <code>null</code> if a matching icebreaker entry could not be found
	 */
	public IcebreakerEntry fetchByUUID_G(
		String uuid, long groupId, boolean retrieveFromCache);

	/**
	 * Removes the icebreaker entry where uuid = &#63; and groupId = &#63; from the database.
	 *
	 * @param uuid the uuid
	 * @param groupId the group ID
	 * @return the icebreaker entry that was removed
	 */
	public IcebreakerEntry removeByUUID_G(String uuid, long groupId)
		throws NoSuchIcebreakerEntryException;

	/**
	 * Returns the number of icebreaker entries where uuid = &#63; and groupId = &#63;.
	 *
	 * @param uuid the uuid
	 * @param groupId the group ID
	 * @return the number of matching icebreaker entries
	 */
	public int countByUUID_G(String uuid, long groupId);

	/**
	 * Returns all the icebreaker entries where uuid = &#63; and companyId = &#63;.
	 *
	 * @param uuid the uuid
	 * @param companyId the company ID
	 * @return the matching icebreaker entries
	 */
	public java.util.List<IcebreakerEntry> findByUuid_C(
		String uuid, long companyId);

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
	public java.util.List<IcebreakerEntry> findByUuid_C(
		String uuid, long companyId, int start, int end);

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
	public java.util.List<IcebreakerEntry> findByUuid_C(
		String uuid, long companyId, int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator<IcebreakerEntry>
			orderByComparator);

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
	public java.util.List<IcebreakerEntry> findByUuid_C(
		String uuid, long companyId, int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator<IcebreakerEntry>
			orderByComparator,
		boolean retrieveFromCache);

	/**
	 * Returns the first icebreaker entry in the ordered set where uuid = &#63; and companyId = &#63;.
	 *
	 * @param uuid the uuid
	 * @param companyId the company ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching icebreaker entry
	 * @throws NoSuchIcebreakerEntryException if a matching icebreaker entry could not be found
	 */
	public IcebreakerEntry findByUuid_C_First(
			String uuid, long companyId,
			com.liferay.portal.kernel.util.OrderByComparator<IcebreakerEntry>
				orderByComparator)
		throws NoSuchIcebreakerEntryException;

	/**
	 * Returns the first icebreaker entry in the ordered set where uuid = &#63; and companyId = &#63;.
	 *
	 * @param uuid the uuid
	 * @param companyId the company ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching icebreaker entry, or <code>null</code> if a matching icebreaker entry could not be found
	 */
	public IcebreakerEntry fetchByUuid_C_First(
		String uuid, long companyId,
		com.liferay.portal.kernel.util.OrderByComparator<IcebreakerEntry>
			orderByComparator);

	/**
	 * Returns the last icebreaker entry in the ordered set where uuid = &#63; and companyId = &#63;.
	 *
	 * @param uuid the uuid
	 * @param companyId the company ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching icebreaker entry
	 * @throws NoSuchIcebreakerEntryException if a matching icebreaker entry could not be found
	 */
	public IcebreakerEntry findByUuid_C_Last(
			String uuid, long companyId,
			com.liferay.portal.kernel.util.OrderByComparator<IcebreakerEntry>
				orderByComparator)
		throws NoSuchIcebreakerEntryException;

	/**
	 * Returns the last icebreaker entry in the ordered set where uuid = &#63; and companyId = &#63;.
	 *
	 * @param uuid the uuid
	 * @param companyId the company ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching icebreaker entry, or <code>null</code> if a matching icebreaker entry could not be found
	 */
	public IcebreakerEntry fetchByUuid_C_Last(
		String uuid, long companyId,
		com.liferay.portal.kernel.util.OrderByComparator<IcebreakerEntry>
			orderByComparator);

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
	public IcebreakerEntry[] findByUuid_C_PrevAndNext(
			long icebreakerEntryId, String uuid, long companyId,
			com.liferay.portal.kernel.util.OrderByComparator<IcebreakerEntry>
				orderByComparator)
		throws NoSuchIcebreakerEntryException;

	/**
	 * Removes all the icebreaker entries where uuid = &#63; and companyId = &#63; from the database.
	 *
	 * @param uuid the uuid
	 * @param companyId the company ID
	 */
	public void removeByUuid_C(String uuid, long companyId);

	/**
	 * Returns the number of icebreaker entries where uuid = &#63; and companyId = &#63;.
	 *
	 * @param uuid the uuid
	 * @param companyId the company ID
	 * @return the number of matching icebreaker entries
	 */
	public int countByUuid_C(String uuid, long companyId);

	/**
	 * Returns all the icebreaker entries where groupId = &#63;.
	 *
	 * @param groupId the group ID
	 * @return the matching icebreaker entries
	 */
	public java.util.List<IcebreakerEntry> findByGroupId(long groupId);

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
	public java.util.List<IcebreakerEntry> findByGroupId(
		long groupId, int start, int end);

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
	public java.util.List<IcebreakerEntry> findByGroupId(
		long groupId, int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator<IcebreakerEntry>
			orderByComparator);

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
	public java.util.List<IcebreakerEntry> findByGroupId(
		long groupId, int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator<IcebreakerEntry>
			orderByComparator,
		boolean retrieveFromCache);

	/**
	 * Returns the first icebreaker entry in the ordered set where groupId = &#63;.
	 *
	 * @param groupId the group ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching icebreaker entry
	 * @throws NoSuchIcebreakerEntryException if a matching icebreaker entry could not be found
	 */
	public IcebreakerEntry findByGroupId_First(
			long groupId,
			com.liferay.portal.kernel.util.OrderByComparator<IcebreakerEntry>
				orderByComparator)
		throws NoSuchIcebreakerEntryException;

	/**
	 * Returns the first icebreaker entry in the ordered set where groupId = &#63;.
	 *
	 * @param groupId the group ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching icebreaker entry, or <code>null</code> if a matching icebreaker entry could not be found
	 */
	public IcebreakerEntry fetchByGroupId_First(
		long groupId,
		com.liferay.portal.kernel.util.OrderByComparator<IcebreakerEntry>
			orderByComparator);

	/**
	 * Returns the last icebreaker entry in the ordered set where groupId = &#63;.
	 *
	 * @param groupId the group ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching icebreaker entry
	 * @throws NoSuchIcebreakerEntryException if a matching icebreaker entry could not be found
	 */
	public IcebreakerEntry findByGroupId_Last(
			long groupId,
			com.liferay.portal.kernel.util.OrderByComparator<IcebreakerEntry>
				orderByComparator)
		throws NoSuchIcebreakerEntryException;

	/**
	 * Returns the last icebreaker entry in the ordered set where groupId = &#63;.
	 *
	 * @param groupId the group ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching icebreaker entry, or <code>null</code> if a matching icebreaker entry could not be found
	 */
	public IcebreakerEntry fetchByGroupId_Last(
		long groupId,
		com.liferay.portal.kernel.util.OrderByComparator<IcebreakerEntry>
			orderByComparator);

	/**
	 * Returns the icebreaker entries before and after the current icebreaker entry in the ordered set where groupId = &#63;.
	 *
	 * @param icebreakerEntryId the primary key of the current icebreaker entry
	 * @param groupId the group ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the previous, current, and next icebreaker entry
	 * @throws NoSuchIcebreakerEntryException if a icebreaker entry with the primary key could not be found
	 */
	public IcebreakerEntry[] findByGroupId_PrevAndNext(
			long icebreakerEntryId, long groupId,
			com.liferay.portal.kernel.util.OrderByComparator<IcebreakerEntry>
				orderByComparator)
		throws NoSuchIcebreakerEntryException;

	/**
	 * Removes all the icebreaker entries where groupId = &#63; from the database.
	 *
	 * @param groupId the group ID
	 */
	public void removeByGroupId(long groupId);

	/**
	 * Returns the number of icebreaker entries where groupId = &#63;.
	 *
	 * @param groupId the group ID
	 * @return the number of matching icebreaker entries
	 */
	public int countByGroupId(long groupId);

	/**
	 * Returns all the icebreaker entries where userId = &#63;.
	 *
	 * @param userId the user ID
	 * @return the matching icebreaker entries
	 */
	public java.util.List<IcebreakerEntry> findByUserId(long userId);

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
	public java.util.List<IcebreakerEntry> findByUserId(
		long userId, int start, int end);

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
	public java.util.List<IcebreakerEntry> findByUserId(
		long userId, int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator<IcebreakerEntry>
			orderByComparator);

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
	public java.util.List<IcebreakerEntry> findByUserId(
		long userId, int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator<IcebreakerEntry>
			orderByComparator,
		boolean retrieveFromCache);

	/**
	 * Returns the first icebreaker entry in the ordered set where userId = &#63;.
	 *
	 * @param userId the user ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching icebreaker entry
	 * @throws NoSuchIcebreakerEntryException if a matching icebreaker entry could not be found
	 */
	public IcebreakerEntry findByUserId_First(
			long userId,
			com.liferay.portal.kernel.util.OrderByComparator<IcebreakerEntry>
				orderByComparator)
		throws NoSuchIcebreakerEntryException;

	/**
	 * Returns the first icebreaker entry in the ordered set where userId = &#63;.
	 *
	 * @param userId the user ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching icebreaker entry, or <code>null</code> if a matching icebreaker entry could not be found
	 */
	public IcebreakerEntry fetchByUserId_First(
		long userId,
		com.liferay.portal.kernel.util.OrderByComparator<IcebreakerEntry>
			orderByComparator);

	/**
	 * Returns the last icebreaker entry in the ordered set where userId = &#63;.
	 *
	 * @param userId the user ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching icebreaker entry
	 * @throws NoSuchIcebreakerEntryException if a matching icebreaker entry could not be found
	 */
	public IcebreakerEntry findByUserId_Last(
			long userId,
			com.liferay.portal.kernel.util.OrderByComparator<IcebreakerEntry>
				orderByComparator)
		throws NoSuchIcebreakerEntryException;

	/**
	 * Returns the last icebreaker entry in the ordered set where userId = &#63;.
	 *
	 * @param userId the user ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching icebreaker entry, or <code>null</code> if a matching icebreaker entry could not be found
	 */
	public IcebreakerEntry fetchByUserId_Last(
		long userId,
		com.liferay.portal.kernel.util.OrderByComparator<IcebreakerEntry>
			orderByComparator);

	/**
	 * Returns the icebreaker entries before and after the current icebreaker entry in the ordered set where userId = &#63;.
	 *
	 * @param icebreakerEntryId the primary key of the current icebreaker entry
	 * @param userId the user ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the previous, current, and next icebreaker entry
	 * @throws NoSuchIcebreakerEntryException if a icebreaker entry with the primary key could not be found
	 */
	public IcebreakerEntry[] findByUserId_PrevAndNext(
			long icebreakerEntryId, long userId,
			com.liferay.portal.kernel.util.OrderByComparator<IcebreakerEntry>
				orderByComparator)
		throws NoSuchIcebreakerEntryException;

	/**
	 * Removes all the icebreaker entries where userId = &#63; from the database.
	 *
	 * @param userId the user ID
	 */
	public void removeByUserId(long userId);

	/**
	 * Returns the number of icebreaker entries where userId = &#63;.
	 *
	 * @param userId the user ID
	 * @return the number of matching icebreaker entries
	 */
	public int countByUserId(long userId);

	/**
	 * Returns the icebreaker entry where status = &#63; or throws a <code>NoSuchIcebreakerEntryException</code> if it could not be found.
	 *
	 * @param status the status
	 * @return the matching icebreaker entry
	 * @throws NoSuchIcebreakerEntryException if a matching icebreaker entry could not be found
	 */
	public IcebreakerEntry findByStatus(int status)
		throws NoSuchIcebreakerEntryException;

	/**
	 * Returns the icebreaker entry where status = &#63; or returns <code>null</code> if it could not be found. Uses the finder cache.
	 *
	 * @param status the status
	 * @return the matching icebreaker entry, or <code>null</code> if a matching icebreaker entry could not be found
	 */
	public IcebreakerEntry fetchByStatus(int status);

	/**
	 * Returns the icebreaker entry where status = &#63; or returns <code>null</code> if it could not be found, optionally using the finder cache.
	 *
	 * @param status the status
	 * @param retrieveFromCache whether to retrieve from the finder cache
	 * @return the matching icebreaker entry, or <code>null</code> if a matching icebreaker entry could not be found
	 */
	public IcebreakerEntry fetchByStatus(int status, boolean retrieveFromCache);

	/**
	 * Removes the icebreaker entry where status = &#63; from the database.
	 *
	 * @param status the status
	 * @return the icebreaker entry that was removed
	 */
	public IcebreakerEntry removeByStatus(int status)
		throws NoSuchIcebreakerEntryException;

	/**
	 * Returns the number of icebreaker entries where status = &#63;.
	 *
	 * @param status the status
	 * @return the number of matching icebreaker entries
	 */
	public int countByStatus(int status);

	/**
	 * Returns all the icebreaker entries where groupId = &#63; and status = &#63;.
	 *
	 * @param groupId the group ID
	 * @param status the status
	 * @return the matching icebreaker entries
	 */
	public java.util.List<IcebreakerEntry> findBy_G_S(long groupId, int status);

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
	public java.util.List<IcebreakerEntry> findBy_G_S(
		long groupId, int status, int start, int end);

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
	public java.util.List<IcebreakerEntry> findBy_G_S(
		long groupId, int status, int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator<IcebreakerEntry>
			orderByComparator);

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
	public java.util.List<IcebreakerEntry> findBy_G_S(
		long groupId, int status, int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator<IcebreakerEntry>
			orderByComparator,
		boolean retrieveFromCache);

	/**
	 * Returns the first icebreaker entry in the ordered set where groupId = &#63; and status = &#63;.
	 *
	 * @param groupId the group ID
	 * @param status the status
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching icebreaker entry
	 * @throws NoSuchIcebreakerEntryException if a matching icebreaker entry could not be found
	 */
	public IcebreakerEntry findBy_G_S_First(
			long groupId, int status,
			com.liferay.portal.kernel.util.OrderByComparator<IcebreakerEntry>
				orderByComparator)
		throws NoSuchIcebreakerEntryException;

	/**
	 * Returns the first icebreaker entry in the ordered set where groupId = &#63; and status = &#63;.
	 *
	 * @param groupId the group ID
	 * @param status the status
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching icebreaker entry, or <code>null</code> if a matching icebreaker entry could not be found
	 */
	public IcebreakerEntry fetchBy_G_S_First(
		long groupId, int status,
		com.liferay.portal.kernel.util.OrderByComparator<IcebreakerEntry>
			orderByComparator);

	/**
	 * Returns the last icebreaker entry in the ordered set where groupId = &#63; and status = &#63;.
	 *
	 * @param groupId the group ID
	 * @param status the status
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching icebreaker entry
	 * @throws NoSuchIcebreakerEntryException if a matching icebreaker entry could not be found
	 */
	public IcebreakerEntry findBy_G_S_Last(
			long groupId, int status,
			com.liferay.portal.kernel.util.OrderByComparator<IcebreakerEntry>
				orderByComparator)
		throws NoSuchIcebreakerEntryException;

	/**
	 * Returns the last icebreaker entry in the ordered set where groupId = &#63; and status = &#63;.
	 *
	 * @param groupId the group ID
	 * @param status the status
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching icebreaker entry, or <code>null</code> if a matching icebreaker entry could not be found
	 */
	public IcebreakerEntry fetchBy_G_S_Last(
		long groupId, int status,
		com.liferay.portal.kernel.util.OrderByComparator<IcebreakerEntry>
			orderByComparator);

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
	public IcebreakerEntry[] findBy_G_S_PrevAndNext(
			long icebreakerEntryId, long groupId, int status,
			com.liferay.portal.kernel.util.OrderByComparator<IcebreakerEntry>
				orderByComparator)
		throws NoSuchIcebreakerEntryException;

	/**
	 * Removes all the icebreaker entries where groupId = &#63; and status = &#63; from the database.
	 *
	 * @param groupId the group ID
	 * @param status the status
	 */
	public void removeBy_G_S(long groupId, int status);

	/**
	 * Returns the number of icebreaker entries where groupId = &#63; and status = &#63;.
	 *
	 * @param groupId the group ID
	 * @param status the status
	 * @return the number of matching icebreaker entries
	 */
	public int countBy_G_S(long groupId, int status);

	/**
	 * Returns the icebreaker entry where type = &#63; or throws a <code>NoSuchIcebreakerEntryException</code> if it could not be found.
	 *
	 * @param type the type
	 * @return the matching icebreaker entry
	 * @throws NoSuchIcebreakerEntryException if a matching icebreaker entry could not be found
	 */
	public IcebreakerEntry findByType(String type)
		throws NoSuchIcebreakerEntryException;

	/**
	 * Returns the icebreaker entry where type = &#63; or returns <code>null</code> if it could not be found. Uses the finder cache.
	 *
	 * @param type the type
	 * @return the matching icebreaker entry, or <code>null</code> if a matching icebreaker entry could not be found
	 */
	public IcebreakerEntry fetchByType(String type);

	/**
	 * Returns the icebreaker entry where type = &#63; or returns <code>null</code> if it could not be found, optionally using the finder cache.
	 *
	 * @param type the type
	 * @param retrieveFromCache whether to retrieve from the finder cache
	 * @return the matching icebreaker entry, or <code>null</code> if a matching icebreaker entry could not be found
	 */
	public IcebreakerEntry fetchByType(String type, boolean retrieveFromCache);

	/**
	 * Removes the icebreaker entry where type = &#63; from the database.
	 *
	 * @param type the type
	 * @return the icebreaker entry that was removed
	 */
	public IcebreakerEntry removeByType(String type)
		throws NoSuchIcebreakerEntryException;

	/**
	 * Returns the number of icebreaker entries where type = &#63;.
	 *
	 * @param type the type
	 * @return the number of matching icebreaker entries
	 */
	public int countByType(String type);

	/**
	 * Caches the icebreaker entry in the entity cache if it is enabled.
	 *
	 * @param icebreakerEntry the icebreaker entry
	 */
	public void cacheResult(IcebreakerEntry icebreakerEntry);

	/**
	 * Caches the icebreaker entries in the entity cache if it is enabled.
	 *
	 * @param icebreakerEntries the icebreaker entries
	 */
	public void cacheResult(java.util.List<IcebreakerEntry> icebreakerEntries);

	/**
	 * Creates a new icebreaker entry with the primary key. Does not add the icebreaker entry to the database.
	 *
	 * @param icebreakerEntryId the primary key for the new icebreaker entry
	 * @return the new icebreaker entry
	 */
	public IcebreakerEntry create(long icebreakerEntryId);

	/**
	 * Removes the icebreaker entry with the primary key from the database. Also notifies the appropriate model listeners.
	 *
	 * @param icebreakerEntryId the primary key of the icebreaker entry
	 * @return the icebreaker entry that was removed
	 * @throws NoSuchIcebreakerEntryException if a icebreaker entry with the primary key could not be found
	 */
	public IcebreakerEntry remove(long icebreakerEntryId)
		throws NoSuchIcebreakerEntryException;

	public IcebreakerEntry updateImpl(IcebreakerEntry icebreakerEntry);

	/**
	 * Returns the icebreaker entry with the primary key or throws a <code>NoSuchIcebreakerEntryException</code> if it could not be found.
	 *
	 * @param icebreakerEntryId the primary key of the icebreaker entry
	 * @return the icebreaker entry
	 * @throws NoSuchIcebreakerEntryException if a icebreaker entry with the primary key could not be found
	 */
	public IcebreakerEntry findByPrimaryKey(long icebreakerEntryId)
		throws NoSuchIcebreakerEntryException;

	/**
	 * Returns the icebreaker entry with the primary key or returns <code>null</code> if it could not be found.
	 *
	 * @param icebreakerEntryId the primary key of the icebreaker entry
	 * @return the icebreaker entry, or <code>null</code> if a icebreaker entry with the primary key could not be found
	 */
	public IcebreakerEntry fetchByPrimaryKey(long icebreakerEntryId);

	/**
	 * Returns all the icebreaker entries.
	 *
	 * @return the icebreaker entries
	 */
	public java.util.List<IcebreakerEntry> findAll();

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
	public java.util.List<IcebreakerEntry> findAll(int start, int end);

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
	public java.util.List<IcebreakerEntry> findAll(
		int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator<IcebreakerEntry>
			orderByComparator);

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
	public java.util.List<IcebreakerEntry> findAll(
		int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator<IcebreakerEntry>
			orderByComparator,
		boolean retrieveFromCache);

	/**
	 * Removes all the icebreaker entries from the database.
	 */
	public void removeAll();

	/**
	 * Returns the number of icebreaker entries.
	 *
	 * @return the number of icebreaker entries
	 */
	public int countAll();

}