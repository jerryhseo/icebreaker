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

package com.osp.icebreaker.service.persistence.impl;

import com.liferay.petra.string.StringBundler;
import com.liferay.portal.kernel.configuration.Configuration;
import com.liferay.portal.kernel.dao.orm.EntityCache;
import com.liferay.portal.kernel.dao.orm.FinderCache;
import com.liferay.portal.kernel.dao.orm.FinderPath;
import com.liferay.portal.kernel.dao.orm.Query;
import com.liferay.portal.kernel.dao.orm.QueryPos;
import com.liferay.portal.kernel.dao.orm.QueryUtil;
import com.liferay.portal.kernel.dao.orm.Session;
import com.liferay.portal.kernel.dao.orm.SessionFactory;
import com.liferay.portal.kernel.log.Log;
import com.liferay.portal.kernel.log.LogFactoryUtil;
import com.liferay.portal.kernel.service.ServiceContext;
import com.liferay.portal.kernel.service.ServiceContextThreadLocal;
import com.liferay.portal.kernel.service.persistence.CompanyProvider;
import com.liferay.portal.kernel.service.persistence.CompanyProviderWrapper;
import com.liferay.portal.kernel.service.persistence.impl.BasePersistenceImpl;
import com.liferay.portal.kernel.util.GetterUtil;
import com.liferay.portal.kernel.util.OrderByComparator;
import com.liferay.portal.kernel.util.ProxyUtil;
import com.liferay.portal.kernel.util.SetUtil;
import com.liferay.portal.kernel.util.StringUtil;
import com.liferay.portal.kernel.util.Validator;
import com.liferay.portal.kernel.uuid.PortalUUIDUtil;

import com.osp.icebreaker.exception.NoSuchIcebreakerEntryException;
import com.osp.icebreaker.model.IcebreakerEntry;
import com.osp.icebreaker.model.impl.IcebreakerEntryImpl;
import com.osp.icebreaker.model.impl.IcebreakerEntryModelImpl;
import com.osp.icebreaker.service.persistence.IcebreakerEntryPersistence;
import com.osp.icebreaker.service.persistence.impl.constants.ICEBREAKERPersistenceConstants;

import java.io.Serializable;

import java.lang.reflect.InvocationHandler;

import java.util.Collections;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Objects;
import java.util.Set;

import javax.sql.DataSource;

import org.osgi.annotation.versioning.ProviderType;
import org.osgi.service.component.annotations.Activate;
import org.osgi.service.component.annotations.Component;
import org.osgi.service.component.annotations.Deactivate;
import org.osgi.service.component.annotations.Reference;

/**
 * The persistence implementation for the icebreaker entry service.
 *
 * <p>
 * Caching information and settings can be found in <code>portal.properties</code>
 * </p>
 *
 * @author Jerry H. Seo
 * @generated
 */
@Component(service = IcebreakerEntryPersistence.class)
@ProviderType
public class IcebreakerEntryPersistenceImpl
	extends BasePersistenceImpl<IcebreakerEntry>
	implements IcebreakerEntryPersistence {

	/*
	 * NOTE FOR DEVELOPERS:
	 *
	 * Never modify or reference this class directly. Always use <code>IcebreakerEntryUtil</code> to access the icebreaker entry persistence. Modify <code>service.xml</code> and rerun ServiceBuilder to regenerate this class.
	 */
	public static final String FINDER_CLASS_NAME_ENTITY =
		IcebreakerEntryImpl.class.getName();

	public static final String FINDER_CLASS_NAME_LIST_WITH_PAGINATION =
		FINDER_CLASS_NAME_ENTITY + ".List1";

	public static final String FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION =
		FINDER_CLASS_NAME_ENTITY + ".List2";

	private FinderPath _finderPathWithPaginationFindAll;
	private FinderPath _finderPathWithoutPaginationFindAll;
	private FinderPath _finderPathCountAll;
	private FinderPath _finderPathWithPaginationFindByUuid;
	private FinderPath _finderPathWithoutPaginationFindByUuid;
	private FinderPath _finderPathCountByUuid;

	/**
	 * Returns all the icebreaker entries where uuid = &#63;.
	 *
	 * @param uuid the uuid
	 * @return the matching icebreaker entries
	 */
	@Override
	public List<IcebreakerEntry> findByUuid(String uuid) {
		return findByUuid(uuid, QueryUtil.ALL_POS, QueryUtil.ALL_POS, null);
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
	@Override
	public List<IcebreakerEntry> findByUuid(String uuid, int start, int end) {
		return findByUuid(uuid, start, end, null);
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
	@Override
	public List<IcebreakerEntry> findByUuid(
		String uuid, int start, int end,
		OrderByComparator<IcebreakerEntry> orderByComparator) {

		return findByUuid(uuid, start, end, orderByComparator, true);
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
	@Override
	public List<IcebreakerEntry> findByUuid(
		String uuid, int start, int end,
		OrderByComparator<IcebreakerEntry> orderByComparator,
		boolean retrieveFromCache) {

		uuid = Objects.toString(uuid, "");

		boolean pagination = true;
		FinderPath finderPath = null;
		Object[] finderArgs = null;

		if ((start == QueryUtil.ALL_POS) && (end == QueryUtil.ALL_POS) &&
			(orderByComparator == null)) {

			pagination = false;
			finderPath = _finderPathWithoutPaginationFindByUuid;
			finderArgs = new Object[] {uuid};
		}
		else {
			finderPath = _finderPathWithPaginationFindByUuid;
			finderArgs = new Object[] {uuid, start, end, orderByComparator};
		}

		List<IcebreakerEntry> list = null;

		if (retrieveFromCache) {
			list = (List<IcebreakerEntry>)finderCache.getResult(
				finderPath, finderArgs, this);

			if ((list != null) && !list.isEmpty()) {
				for (IcebreakerEntry icebreakerEntry : list) {
					if (!uuid.equals(icebreakerEntry.getUuid())) {
						list = null;

						break;
					}
				}
			}
		}

		if (list == null) {
			StringBundler query = null;

			if (orderByComparator != null) {
				query = new StringBundler(
					3 + (orderByComparator.getOrderByFields().length * 2));
			}
			else {
				query = new StringBundler(3);
			}

			query.append(_SQL_SELECT_ICEBREAKERENTRY_WHERE);

			boolean bindUuid = false;

			if (uuid.isEmpty()) {
				query.append(_FINDER_COLUMN_UUID_UUID_3);
			}
			else {
				bindUuid = true;

				query.append(_FINDER_COLUMN_UUID_UUID_2);
			}

			if (orderByComparator != null) {
				appendOrderByComparator(
					query, _ORDER_BY_ENTITY_ALIAS, orderByComparator);
			}
			else if (pagination) {
				query.append(IcebreakerEntryModelImpl.ORDER_BY_JPQL);
			}

			String sql = query.toString();

			Session session = null;

			try {
				session = openSession();

				Query q = session.createQuery(sql);

				QueryPos qPos = QueryPos.getInstance(q);

				if (bindUuid) {
					qPos.add(uuid);
				}

				if (!pagination) {
					list = (List<IcebreakerEntry>)QueryUtil.list(
						q, getDialect(), start, end, false);

					Collections.sort(list);

					list = Collections.unmodifiableList(list);
				}
				else {
					list = (List<IcebreakerEntry>)QueryUtil.list(
						q, getDialect(), start, end);
				}

				cacheResult(list);

				finderCache.putResult(finderPath, finderArgs, list);
			}
			catch (Exception e) {
				finderCache.removeResult(finderPath, finderArgs);

				throw processException(e);
			}
			finally {
				closeSession(session);
			}
		}

		return list;
	}

	/**
	 * Returns the first icebreaker entry in the ordered set where uuid = &#63;.
	 *
	 * @param uuid the uuid
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching icebreaker entry
	 * @throws NoSuchIcebreakerEntryException if a matching icebreaker entry could not be found
	 */
	@Override
	public IcebreakerEntry findByUuid_First(
			String uuid, OrderByComparator<IcebreakerEntry> orderByComparator)
		throws NoSuchIcebreakerEntryException {

		IcebreakerEntry icebreakerEntry = fetchByUuid_First(
			uuid, orderByComparator);

		if (icebreakerEntry != null) {
			return icebreakerEntry;
		}

		StringBundler msg = new StringBundler(4);

		msg.append(_NO_SUCH_ENTITY_WITH_KEY);

		msg.append("uuid=");
		msg.append(uuid);

		msg.append("}");

		throw new NoSuchIcebreakerEntryException(msg.toString());
	}

	/**
	 * Returns the first icebreaker entry in the ordered set where uuid = &#63;.
	 *
	 * @param uuid the uuid
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching icebreaker entry, or <code>null</code> if a matching icebreaker entry could not be found
	 */
	@Override
	public IcebreakerEntry fetchByUuid_First(
		String uuid, OrderByComparator<IcebreakerEntry> orderByComparator) {

		List<IcebreakerEntry> list = findByUuid(uuid, 0, 1, orderByComparator);

		if (!list.isEmpty()) {
			return list.get(0);
		}

		return null;
	}

	/**
	 * Returns the last icebreaker entry in the ordered set where uuid = &#63;.
	 *
	 * @param uuid the uuid
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching icebreaker entry
	 * @throws NoSuchIcebreakerEntryException if a matching icebreaker entry could not be found
	 */
	@Override
	public IcebreakerEntry findByUuid_Last(
			String uuid, OrderByComparator<IcebreakerEntry> orderByComparator)
		throws NoSuchIcebreakerEntryException {

		IcebreakerEntry icebreakerEntry = fetchByUuid_Last(
			uuid, orderByComparator);

		if (icebreakerEntry != null) {
			return icebreakerEntry;
		}

		StringBundler msg = new StringBundler(4);

		msg.append(_NO_SUCH_ENTITY_WITH_KEY);

		msg.append("uuid=");
		msg.append(uuid);

		msg.append("}");

		throw new NoSuchIcebreakerEntryException(msg.toString());
	}

	/**
	 * Returns the last icebreaker entry in the ordered set where uuid = &#63;.
	 *
	 * @param uuid the uuid
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching icebreaker entry, or <code>null</code> if a matching icebreaker entry could not be found
	 */
	@Override
	public IcebreakerEntry fetchByUuid_Last(
		String uuid, OrderByComparator<IcebreakerEntry> orderByComparator) {

		int count = countByUuid(uuid);

		if (count == 0) {
			return null;
		}

		List<IcebreakerEntry> list = findByUuid(
			uuid, count - 1, count, orderByComparator);

		if (!list.isEmpty()) {
			return list.get(0);
		}

		return null;
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
	@Override
	public IcebreakerEntry[] findByUuid_PrevAndNext(
			long icebreakerEntryId, String uuid,
			OrderByComparator<IcebreakerEntry> orderByComparator)
		throws NoSuchIcebreakerEntryException {

		uuid = Objects.toString(uuid, "");

		IcebreakerEntry icebreakerEntry = findByPrimaryKey(icebreakerEntryId);

		Session session = null;

		try {
			session = openSession();

			IcebreakerEntry[] array = new IcebreakerEntryImpl[3];

			array[0] = getByUuid_PrevAndNext(
				session, icebreakerEntry, uuid, orderByComparator, true);

			array[1] = icebreakerEntry;

			array[2] = getByUuid_PrevAndNext(
				session, icebreakerEntry, uuid, orderByComparator, false);

			return array;
		}
		catch (Exception e) {
			throw processException(e);
		}
		finally {
			closeSession(session);
		}
	}

	protected IcebreakerEntry getByUuid_PrevAndNext(
		Session session, IcebreakerEntry icebreakerEntry, String uuid,
		OrderByComparator<IcebreakerEntry> orderByComparator,
		boolean previous) {

		StringBundler query = null;

		if (orderByComparator != null) {
			query = new StringBundler(
				4 + (orderByComparator.getOrderByConditionFields().length * 3) +
					(orderByComparator.getOrderByFields().length * 3));
		}
		else {
			query = new StringBundler(3);
		}

		query.append(_SQL_SELECT_ICEBREAKERENTRY_WHERE);

		boolean bindUuid = false;

		if (uuid.isEmpty()) {
			query.append(_FINDER_COLUMN_UUID_UUID_3);
		}
		else {
			bindUuid = true;

			query.append(_FINDER_COLUMN_UUID_UUID_2);
		}

		if (orderByComparator != null) {
			String[] orderByConditionFields =
				orderByComparator.getOrderByConditionFields();

			if (orderByConditionFields.length > 0) {
				query.append(WHERE_AND);
			}

			for (int i = 0; i < orderByConditionFields.length; i++) {
				query.append(_ORDER_BY_ENTITY_ALIAS);
				query.append(orderByConditionFields[i]);

				if ((i + 1) < orderByConditionFields.length) {
					if (orderByComparator.isAscending() ^ previous) {
						query.append(WHERE_GREATER_THAN_HAS_NEXT);
					}
					else {
						query.append(WHERE_LESSER_THAN_HAS_NEXT);
					}
				}
				else {
					if (orderByComparator.isAscending() ^ previous) {
						query.append(WHERE_GREATER_THAN);
					}
					else {
						query.append(WHERE_LESSER_THAN);
					}
				}
			}

			query.append(ORDER_BY_CLAUSE);

			String[] orderByFields = orderByComparator.getOrderByFields();

			for (int i = 0; i < orderByFields.length; i++) {
				query.append(_ORDER_BY_ENTITY_ALIAS);
				query.append(orderByFields[i]);

				if ((i + 1) < orderByFields.length) {
					if (orderByComparator.isAscending() ^ previous) {
						query.append(ORDER_BY_ASC_HAS_NEXT);
					}
					else {
						query.append(ORDER_BY_DESC_HAS_NEXT);
					}
				}
				else {
					if (orderByComparator.isAscending() ^ previous) {
						query.append(ORDER_BY_ASC);
					}
					else {
						query.append(ORDER_BY_DESC);
					}
				}
			}
		}
		else {
			query.append(IcebreakerEntryModelImpl.ORDER_BY_JPQL);
		}

		String sql = query.toString();

		Query q = session.createQuery(sql);

		q.setFirstResult(0);
		q.setMaxResults(2);

		QueryPos qPos = QueryPos.getInstance(q);

		if (bindUuid) {
			qPos.add(uuid);
		}

		if (orderByComparator != null) {
			for (Object orderByConditionValue :
					orderByComparator.getOrderByConditionValues(
						icebreakerEntry)) {

				qPos.add(orderByConditionValue);
			}
		}

		List<IcebreakerEntry> list = q.list();

		if (list.size() == 2) {
			return list.get(1);
		}
		else {
			return null;
		}
	}

	/**
	 * Removes all the icebreaker entries where uuid = &#63; from the database.
	 *
	 * @param uuid the uuid
	 */
	@Override
	public void removeByUuid(String uuid) {
		for (IcebreakerEntry icebreakerEntry :
				findByUuid(uuid, QueryUtil.ALL_POS, QueryUtil.ALL_POS, null)) {

			remove(icebreakerEntry);
		}
	}

	/**
	 * Returns the number of icebreaker entries where uuid = &#63;.
	 *
	 * @param uuid the uuid
	 * @return the number of matching icebreaker entries
	 */
	@Override
	public int countByUuid(String uuid) {
		uuid = Objects.toString(uuid, "");

		FinderPath finderPath = _finderPathCountByUuid;

		Object[] finderArgs = new Object[] {uuid};

		Long count = (Long)finderCache.getResult(finderPath, finderArgs, this);

		if (count == null) {
			StringBundler query = new StringBundler(2);

			query.append(_SQL_COUNT_ICEBREAKERENTRY_WHERE);

			boolean bindUuid = false;

			if (uuid.isEmpty()) {
				query.append(_FINDER_COLUMN_UUID_UUID_3);
			}
			else {
				bindUuid = true;

				query.append(_FINDER_COLUMN_UUID_UUID_2);
			}

			String sql = query.toString();

			Session session = null;

			try {
				session = openSession();

				Query q = session.createQuery(sql);

				QueryPos qPos = QueryPos.getInstance(q);

				if (bindUuid) {
					qPos.add(uuid);
				}

				count = (Long)q.uniqueResult();

				finderCache.putResult(finderPath, finderArgs, count);
			}
			catch (Exception e) {
				finderCache.removeResult(finderPath, finderArgs);

				throw processException(e);
			}
			finally {
				closeSession(session);
			}
		}

		return count.intValue();
	}

	private static final String _FINDER_COLUMN_UUID_UUID_2 =
		"icebreakerEntry.uuid = ?";

	private static final String _FINDER_COLUMN_UUID_UUID_3 =
		"(icebreakerEntry.uuid IS NULL OR icebreakerEntry.uuid = '')";

	private FinderPath _finderPathFetchByUUID_G;
	private FinderPath _finderPathCountByUUID_G;

	/**
	 * Returns the icebreaker entry where uuid = &#63; and groupId = &#63; or throws a <code>NoSuchIcebreakerEntryException</code> if it could not be found.
	 *
	 * @param uuid the uuid
	 * @param groupId the group ID
	 * @return the matching icebreaker entry
	 * @throws NoSuchIcebreakerEntryException if a matching icebreaker entry could not be found
	 */
	@Override
	public IcebreakerEntry findByUUID_G(String uuid, long groupId)
		throws NoSuchIcebreakerEntryException {

		IcebreakerEntry icebreakerEntry = fetchByUUID_G(uuid, groupId);

		if (icebreakerEntry == null) {
			StringBundler msg = new StringBundler(6);

			msg.append(_NO_SUCH_ENTITY_WITH_KEY);

			msg.append("uuid=");
			msg.append(uuid);

			msg.append(", groupId=");
			msg.append(groupId);

			msg.append("}");

			if (_log.isDebugEnabled()) {
				_log.debug(msg.toString());
			}

			throw new NoSuchIcebreakerEntryException(msg.toString());
		}

		return icebreakerEntry;
	}

	/**
	 * Returns the icebreaker entry where uuid = &#63; and groupId = &#63; or returns <code>null</code> if it could not be found. Uses the finder cache.
	 *
	 * @param uuid the uuid
	 * @param groupId the group ID
	 * @return the matching icebreaker entry, or <code>null</code> if a matching icebreaker entry could not be found
	 */
	@Override
	public IcebreakerEntry fetchByUUID_G(String uuid, long groupId) {
		return fetchByUUID_G(uuid, groupId, true);
	}

	/**
	 * Returns the icebreaker entry where uuid = &#63; and groupId = &#63; or returns <code>null</code> if it could not be found, optionally using the finder cache.
	 *
	 * @param uuid the uuid
	 * @param groupId the group ID
	 * @param retrieveFromCache whether to retrieve from the finder cache
	 * @return the matching icebreaker entry, or <code>null</code> if a matching icebreaker entry could not be found
	 */
	@Override
	public IcebreakerEntry fetchByUUID_G(
		String uuid, long groupId, boolean retrieveFromCache) {

		uuid = Objects.toString(uuid, "");

		Object[] finderArgs = new Object[] {uuid, groupId};

		Object result = null;

		if (retrieveFromCache) {
			result = finderCache.getResult(
				_finderPathFetchByUUID_G, finderArgs, this);
		}

		if (result instanceof IcebreakerEntry) {
			IcebreakerEntry icebreakerEntry = (IcebreakerEntry)result;

			if (!Objects.equals(uuid, icebreakerEntry.getUuid()) ||
				(groupId != icebreakerEntry.getGroupId())) {

				result = null;
			}
		}

		if (result == null) {
			StringBundler query = new StringBundler(4);

			query.append(_SQL_SELECT_ICEBREAKERENTRY_WHERE);

			boolean bindUuid = false;

			if (uuid.isEmpty()) {
				query.append(_FINDER_COLUMN_UUID_G_UUID_3);
			}
			else {
				bindUuid = true;

				query.append(_FINDER_COLUMN_UUID_G_UUID_2);
			}

			query.append(_FINDER_COLUMN_UUID_G_GROUPID_2);

			String sql = query.toString();

			Session session = null;

			try {
				session = openSession();

				Query q = session.createQuery(sql);

				QueryPos qPos = QueryPos.getInstance(q);

				if (bindUuid) {
					qPos.add(uuid);
				}

				qPos.add(groupId);

				List<IcebreakerEntry> list = q.list();

				if (list.isEmpty()) {
					finderCache.putResult(
						_finderPathFetchByUUID_G, finderArgs, list);
				}
				else {
					IcebreakerEntry icebreakerEntry = list.get(0);

					result = icebreakerEntry;

					cacheResult(icebreakerEntry);
				}
			}
			catch (Exception e) {
				finderCache.removeResult(_finderPathFetchByUUID_G, finderArgs);

				throw processException(e);
			}
			finally {
				closeSession(session);
			}
		}

		if (result instanceof List<?>) {
			return null;
		}
		else {
			return (IcebreakerEntry)result;
		}
	}

	/**
	 * Removes the icebreaker entry where uuid = &#63; and groupId = &#63; from the database.
	 *
	 * @param uuid the uuid
	 * @param groupId the group ID
	 * @return the icebreaker entry that was removed
	 */
	@Override
	public IcebreakerEntry removeByUUID_G(String uuid, long groupId)
		throws NoSuchIcebreakerEntryException {

		IcebreakerEntry icebreakerEntry = findByUUID_G(uuid, groupId);

		return remove(icebreakerEntry);
	}

	/**
	 * Returns the number of icebreaker entries where uuid = &#63; and groupId = &#63;.
	 *
	 * @param uuid the uuid
	 * @param groupId the group ID
	 * @return the number of matching icebreaker entries
	 */
	@Override
	public int countByUUID_G(String uuid, long groupId) {
		uuid = Objects.toString(uuid, "");

		FinderPath finderPath = _finderPathCountByUUID_G;

		Object[] finderArgs = new Object[] {uuid, groupId};

		Long count = (Long)finderCache.getResult(finderPath, finderArgs, this);

		if (count == null) {
			StringBundler query = new StringBundler(3);

			query.append(_SQL_COUNT_ICEBREAKERENTRY_WHERE);

			boolean bindUuid = false;

			if (uuid.isEmpty()) {
				query.append(_FINDER_COLUMN_UUID_G_UUID_3);
			}
			else {
				bindUuid = true;

				query.append(_FINDER_COLUMN_UUID_G_UUID_2);
			}

			query.append(_FINDER_COLUMN_UUID_G_GROUPID_2);

			String sql = query.toString();

			Session session = null;

			try {
				session = openSession();

				Query q = session.createQuery(sql);

				QueryPos qPos = QueryPos.getInstance(q);

				if (bindUuid) {
					qPos.add(uuid);
				}

				qPos.add(groupId);

				count = (Long)q.uniqueResult();

				finderCache.putResult(finderPath, finderArgs, count);
			}
			catch (Exception e) {
				finderCache.removeResult(finderPath, finderArgs);

				throw processException(e);
			}
			finally {
				closeSession(session);
			}
		}

		return count.intValue();
	}

	private static final String _FINDER_COLUMN_UUID_G_UUID_2 =
		"icebreakerEntry.uuid = ? AND ";

	private static final String _FINDER_COLUMN_UUID_G_UUID_3 =
		"(icebreakerEntry.uuid IS NULL OR icebreakerEntry.uuid = '') AND ";

	private static final String _FINDER_COLUMN_UUID_G_GROUPID_2 =
		"icebreakerEntry.groupId = ?";

	private FinderPath _finderPathWithPaginationFindByUuid_C;
	private FinderPath _finderPathWithoutPaginationFindByUuid_C;
	private FinderPath _finderPathCountByUuid_C;

	/**
	 * Returns all the icebreaker entries where uuid = &#63; and companyId = &#63;.
	 *
	 * @param uuid the uuid
	 * @param companyId the company ID
	 * @return the matching icebreaker entries
	 */
	@Override
	public List<IcebreakerEntry> findByUuid_C(String uuid, long companyId) {
		return findByUuid_C(
			uuid, companyId, QueryUtil.ALL_POS, QueryUtil.ALL_POS, null);
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
	@Override
	public List<IcebreakerEntry> findByUuid_C(
		String uuid, long companyId, int start, int end) {

		return findByUuid_C(uuid, companyId, start, end, null);
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
	@Override
	public List<IcebreakerEntry> findByUuid_C(
		String uuid, long companyId, int start, int end,
		OrderByComparator<IcebreakerEntry> orderByComparator) {

		return findByUuid_C(
			uuid, companyId, start, end, orderByComparator, true);
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
	@Override
	public List<IcebreakerEntry> findByUuid_C(
		String uuid, long companyId, int start, int end,
		OrderByComparator<IcebreakerEntry> orderByComparator,
		boolean retrieveFromCache) {

		uuid = Objects.toString(uuid, "");

		boolean pagination = true;
		FinderPath finderPath = null;
		Object[] finderArgs = null;

		if ((start == QueryUtil.ALL_POS) && (end == QueryUtil.ALL_POS) &&
			(orderByComparator == null)) {

			pagination = false;
			finderPath = _finderPathWithoutPaginationFindByUuid_C;
			finderArgs = new Object[] {uuid, companyId};
		}
		else {
			finderPath = _finderPathWithPaginationFindByUuid_C;
			finderArgs = new Object[] {
				uuid, companyId, start, end, orderByComparator
			};
		}

		List<IcebreakerEntry> list = null;

		if (retrieveFromCache) {
			list = (List<IcebreakerEntry>)finderCache.getResult(
				finderPath, finderArgs, this);

			if ((list != null) && !list.isEmpty()) {
				for (IcebreakerEntry icebreakerEntry : list) {
					if (!uuid.equals(icebreakerEntry.getUuid()) ||
						(companyId != icebreakerEntry.getCompanyId())) {

						list = null;

						break;
					}
				}
			}
		}

		if (list == null) {
			StringBundler query = null;

			if (orderByComparator != null) {
				query = new StringBundler(
					4 + (orderByComparator.getOrderByFields().length * 2));
			}
			else {
				query = new StringBundler(4);
			}

			query.append(_SQL_SELECT_ICEBREAKERENTRY_WHERE);

			boolean bindUuid = false;

			if (uuid.isEmpty()) {
				query.append(_FINDER_COLUMN_UUID_C_UUID_3);
			}
			else {
				bindUuid = true;

				query.append(_FINDER_COLUMN_UUID_C_UUID_2);
			}

			query.append(_FINDER_COLUMN_UUID_C_COMPANYID_2);

			if (orderByComparator != null) {
				appendOrderByComparator(
					query, _ORDER_BY_ENTITY_ALIAS, orderByComparator);
			}
			else if (pagination) {
				query.append(IcebreakerEntryModelImpl.ORDER_BY_JPQL);
			}

			String sql = query.toString();

			Session session = null;

			try {
				session = openSession();

				Query q = session.createQuery(sql);

				QueryPos qPos = QueryPos.getInstance(q);

				if (bindUuid) {
					qPos.add(uuid);
				}

				qPos.add(companyId);

				if (!pagination) {
					list = (List<IcebreakerEntry>)QueryUtil.list(
						q, getDialect(), start, end, false);

					Collections.sort(list);

					list = Collections.unmodifiableList(list);
				}
				else {
					list = (List<IcebreakerEntry>)QueryUtil.list(
						q, getDialect(), start, end);
				}

				cacheResult(list);

				finderCache.putResult(finderPath, finderArgs, list);
			}
			catch (Exception e) {
				finderCache.removeResult(finderPath, finderArgs);

				throw processException(e);
			}
			finally {
				closeSession(session);
			}
		}

		return list;
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
	@Override
	public IcebreakerEntry findByUuid_C_First(
			String uuid, long companyId,
			OrderByComparator<IcebreakerEntry> orderByComparator)
		throws NoSuchIcebreakerEntryException {

		IcebreakerEntry icebreakerEntry = fetchByUuid_C_First(
			uuid, companyId, orderByComparator);

		if (icebreakerEntry != null) {
			return icebreakerEntry;
		}

		StringBundler msg = new StringBundler(6);

		msg.append(_NO_SUCH_ENTITY_WITH_KEY);

		msg.append("uuid=");
		msg.append(uuid);

		msg.append(", companyId=");
		msg.append(companyId);

		msg.append("}");

		throw new NoSuchIcebreakerEntryException(msg.toString());
	}

	/**
	 * Returns the first icebreaker entry in the ordered set where uuid = &#63; and companyId = &#63;.
	 *
	 * @param uuid the uuid
	 * @param companyId the company ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching icebreaker entry, or <code>null</code> if a matching icebreaker entry could not be found
	 */
	@Override
	public IcebreakerEntry fetchByUuid_C_First(
		String uuid, long companyId,
		OrderByComparator<IcebreakerEntry> orderByComparator) {

		List<IcebreakerEntry> list = findByUuid_C(
			uuid, companyId, 0, 1, orderByComparator);

		if (!list.isEmpty()) {
			return list.get(0);
		}

		return null;
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
	@Override
	public IcebreakerEntry findByUuid_C_Last(
			String uuid, long companyId,
			OrderByComparator<IcebreakerEntry> orderByComparator)
		throws NoSuchIcebreakerEntryException {

		IcebreakerEntry icebreakerEntry = fetchByUuid_C_Last(
			uuid, companyId, orderByComparator);

		if (icebreakerEntry != null) {
			return icebreakerEntry;
		}

		StringBundler msg = new StringBundler(6);

		msg.append(_NO_SUCH_ENTITY_WITH_KEY);

		msg.append("uuid=");
		msg.append(uuid);

		msg.append(", companyId=");
		msg.append(companyId);

		msg.append("}");

		throw new NoSuchIcebreakerEntryException(msg.toString());
	}

	/**
	 * Returns the last icebreaker entry in the ordered set where uuid = &#63; and companyId = &#63;.
	 *
	 * @param uuid the uuid
	 * @param companyId the company ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching icebreaker entry, or <code>null</code> if a matching icebreaker entry could not be found
	 */
	@Override
	public IcebreakerEntry fetchByUuid_C_Last(
		String uuid, long companyId,
		OrderByComparator<IcebreakerEntry> orderByComparator) {

		int count = countByUuid_C(uuid, companyId);

		if (count == 0) {
			return null;
		}

		List<IcebreakerEntry> list = findByUuid_C(
			uuid, companyId, count - 1, count, orderByComparator);

		if (!list.isEmpty()) {
			return list.get(0);
		}

		return null;
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
	@Override
	public IcebreakerEntry[] findByUuid_C_PrevAndNext(
			long icebreakerEntryId, String uuid, long companyId,
			OrderByComparator<IcebreakerEntry> orderByComparator)
		throws NoSuchIcebreakerEntryException {

		uuid = Objects.toString(uuid, "");

		IcebreakerEntry icebreakerEntry = findByPrimaryKey(icebreakerEntryId);

		Session session = null;

		try {
			session = openSession();

			IcebreakerEntry[] array = new IcebreakerEntryImpl[3];

			array[0] = getByUuid_C_PrevAndNext(
				session, icebreakerEntry, uuid, companyId, orderByComparator,
				true);

			array[1] = icebreakerEntry;

			array[2] = getByUuid_C_PrevAndNext(
				session, icebreakerEntry, uuid, companyId, orderByComparator,
				false);

			return array;
		}
		catch (Exception e) {
			throw processException(e);
		}
		finally {
			closeSession(session);
		}
	}

	protected IcebreakerEntry getByUuid_C_PrevAndNext(
		Session session, IcebreakerEntry icebreakerEntry, String uuid,
		long companyId, OrderByComparator<IcebreakerEntry> orderByComparator,
		boolean previous) {

		StringBundler query = null;

		if (orderByComparator != null) {
			query = new StringBundler(
				5 + (orderByComparator.getOrderByConditionFields().length * 3) +
					(orderByComparator.getOrderByFields().length * 3));
		}
		else {
			query = new StringBundler(4);
		}

		query.append(_SQL_SELECT_ICEBREAKERENTRY_WHERE);

		boolean bindUuid = false;

		if (uuid.isEmpty()) {
			query.append(_FINDER_COLUMN_UUID_C_UUID_3);
		}
		else {
			bindUuid = true;

			query.append(_FINDER_COLUMN_UUID_C_UUID_2);
		}

		query.append(_FINDER_COLUMN_UUID_C_COMPANYID_2);

		if (orderByComparator != null) {
			String[] orderByConditionFields =
				orderByComparator.getOrderByConditionFields();

			if (orderByConditionFields.length > 0) {
				query.append(WHERE_AND);
			}

			for (int i = 0; i < orderByConditionFields.length; i++) {
				query.append(_ORDER_BY_ENTITY_ALIAS);
				query.append(orderByConditionFields[i]);

				if ((i + 1) < orderByConditionFields.length) {
					if (orderByComparator.isAscending() ^ previous) {
						query.append(WHERE_GREATER_THAN_HAS_NEXT);
					}
					else {
						query.append(WHERE_LESSER_THAN_HAS_NEXT);
					}
				}
				else {
					if (orderByComparator.isAscending() ^ previous) {
						query.append(WHERE_GREATER_THAN);
					}
					else {
						query.append(WHERE_LESSER_THAN);
					}
				}
			}

			query.append(ORDER_BY_CLAUSE);

			String[] orderByFields = orderByComparator.getOrderByFields();

			for (int i = 0; i < orderByFields.length; i++) {
				query.append(_ORDER_BY_ENTITY_ALIAS);
				query.append(orderByFields[i]);

				if ((i + 1) < orderByFields.length) {
					if (orderByComparator.isAscending() ^ previous) {
						query.append(ORDER_BY_ASC_HAS_NEXT);
					}
					else {
						query.append(ORDER_BY_DESC_HAS_NEXT);
					}
				}
				else {
					if (orderByComparator.isAscending() ^ previous) {
						query.append(ORDER_BY_ASC);
					}
					else {
						query.append(ORDER_BY_DESC);
					}
				}
			}
		}
		else {
			query.append(IcebreakerEntryModelImpl.ORDER_BY_JPQL);
		}

		String sql = query.toString();

		Query q = session.createQuery(sql);

		q.setFirstResult(0);
		q.setMaxResults(2);

		QueryPos qPos = QueryPos.getInstance(q);

		if (bindUuid) {
			qPos.add(uuid);
		}

		qPos.add(companyId);

		if (orderByComparator != null) {
			for (Object orderByConditionValue :
					orderByComparator.getOrderByConditionValues(
						icebreakerEntry)) {

				qPos.add(orderByConditionValue);
			}
		}

		List<IcebreakerEntry> list = q.list();

		if (list.size() == 2) {
			return list.get(1);
		}
		else {
			return null;
		}
	}

	/**
	 * Removes all the icebreaker entries where uuid = &#63; and companyId = &#63; from the database.
	 *
	 * @param uuid the uuid
	 * @param companyId the company ID
	 */
	@Override
	public void removeByUuid_C(String uuid, long companyId) {
		for (IcebreakerEntry icebreakerEntry :
				findByUuid_C(
					uuid, companyId, QueryUtil.ALL_POS, QueryUtil.ALL_POS,
					null)) {

			remove(icebreakerEntry);
		}
	}

	/**
	 * Returns the number of icebreaker entries where uuid = &#63; and companyId = &#63;.
	 *
	 * @param uuid the uuid
	 * @param companyId the company ID
	 * @return the number of matching icebreaker entries
	 */
	@Override
	public int countByUuid_C(String uuid, long companyId) {
		uuid = Objects.toString(uuid, "");

		FinderPath finderPath = _finderPathCountByUuid_C;

		Object[] finderArgs = new Object[] {uuid, companyId};

		Long count = (Long)finderCache.getResult(finderPath, finderArgs, this);

		if (count == null) {
			StringBundler query = new StringBundler(3);

			query.append(_SQL_COUNT_ICEBREAKERENTRY_WHERE);

			boolean bindUuid = false;

			if (uuid.isEmpty()) {
				query.append(_FINDER_COLUMN_UUID_C_UUID_3);
			}
			else {
				bindUuid = true;

				query.append(_FINDER_COLUMN_UUID_C_UUID_2);
			}

			query.append(_FINDER_COLUMN_UUID_C_COMPANYID_2);

			String sql = query.toString();

			Session session = null;

			try {
				session = openSession();

				Query q = session.createQuery(sql);

				QueryPos qPos = QueryPos.getInstance(q);

				if (bindUuid) {
					qPos.add(uuid);
				}

				qPos.add(companyId);

				count = (Long)q.uniqueResult();

				finderCache.putResult(finderPath, finderArgs, count);
			}
			catch (Exception e) {
				finderCache.removeResult(finderPath, finderArgs);

				throw processException(e);
			}
			finally {
				closeSession(session);
			}
		}

		return count.intValue();
	}

	private static final String _FINDER_COLUMN_UUID_C_UUID_2 =
		"icebreakerEntry.uuid = ? AND ";

	private static final String _FINDER_COLUMN_UUID_C_UUID_3 =
		"(icebreakerEntry.uuid IS NULL OR icebreakerEntry.uuid = '') AND ";

	private static final String _FINDER_COLUMN_UUID_C_COMPANYID_2 =
		"icebreakerEntry.companyId = ?";

	private FinderPath _finderPathWithPaginationFindByGroupId;
	private FinderPath _finderPathWithoutPaginationFindByGroupId;
	private FinderPath _finderPathCountByGroupId;

	/**
	 * Returns all the icebreaker entries where groupId = &#63;.
	 *
	 * @param groupId the group ID
	 * @return the matching icebreaker entries
	 */
	@Override
	public List<IcebreakerEntry> findByGroupId(long groupId) {
		return findByGroupId(
			groupId, QueryUtil.ALL_POS, QueryUtil.ALL_POS, null);
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
	@Override
	public List<IcebreakerEntry> findByGroupId(
		long groupId, int start, int end) {

		return findByGroupId(groupId, start, end, null);
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
	@Override
	public List<IcebreakerEntry> findByGroupId(
		long groupId, int start, int end,
		OrderByComparator<IcebreakerEntry> orderByComparator) {

		return findByGroupId(groupId, start, end, orderByComparator, true);
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
	@Override
	public List<IcebreakerEntry> findByGroupId(
		long groupId, int start, int end,
		OrderByComparator<IcebreakerEntry> orderByComparator,
		boolean retrieveFromCache) {

		boolean pagination = true;
		FinderPath finderPath = null;
		Object[] finderArgs = null;

		if ((start == QueryUtil.ALL_POS) && (end == QueryUtil.ALL_POS) &&
			(orderByComparator == null)) {

			pagination = false;
			finderPath = _finderPathWithoutPaginationFindByGroupId;
			finderArgs = new Object[] {groupId};
		}
		else {
			finderPath = _finderPathWithPaginationFindByGroupId;
			finderArgs = new Object[] {groupId, start, end, orderByComparator};
		}

		List<IcebreakerEntry> list = null;

		if (retrieveFromCache) {
			list = (List<IcebreakerEntry>)finderCache.getResult(
				finderPath, finderArgs, this);

			if ((list != null) && !list.isEmpty()) {
				for (IcebreakerEntry icebreakerEntry : list) {
					if ((groupId != icebreakerEntry.getGroupId())) {
						list = null;

						break;
					}
				}
			}
		}

		if (list == null) {
			StringBundler query = null;

			if (orderByComparator != null) {
				query = new StringBundler(
					3 + (orderByComparator.getOrderByFields().length * 2));
			}
			else {
				query = new StringBundler(3);
			}

			query.append(_SQL_SELECT_ICEBREAKERENTRY_WHERE);

			query.append(_FINDER_COLUMN_GROUPID_GROUPID_2);

			if (orderByComparator != null) {
				appendOrderByComparator(
					query, _ORDER_BY_ENTITY_ALIAS, orderByComparator);
			}
			else if (pagination) {
				query.append(IcebreakerEntryModelImpl.ORDER_BY_JPQL);
			}

			String sql = query.toString();

			Session session = null;

			try {
				session = openSession();

				Query q = session.createQuery(sql);

				QueryPos qPos = QueryPos.getInstance(q);

				qPos.add(groupId);

				if (!pagination) {
					list = (List<IcebreakerEntry>)QueryUtil.list(
						q, getDialect(), start, end, false);

					Collections.sort(list);

					list = Collections.unmodifiableList(list);
				}
				else {
					list = (List<IcebreakerEntry>)QueryUtil.list(
						q, getDialect(), start, end);
				}

				cacheResult(list);

				finderCache.putResult(finderPath, finderArgs, list);
			}
			catch (Exception e) {
				finderCache.removeResult(finderPath, finderArgs);

				throw processException(e);
			}
			finally {
				closeSession(session);
			}
		}

		return list;
	}

	/**
	 * Returns the first icebreaker entry in the ordered set where groupId = &#63;.
	 *
	 * @param groupId the group ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching icebreaker entry
	 * @throws NoSuchIcebreakerEntryException if a matching icebreaker entry could not be found
	 */
	@Override
	public IcebreakerEntry findByGroupId_First(
			long groupId, OrderByComparator<IcebreakerEntry> orderByComparator)
		throws NoSuchIcebreakerEntryException {

		IcebreakerEntry icebreakerEntry = fetchByGroupId_First(
			groupId, orderByComparator);

		if (icebreakerEntry != null) {
			return icebreakerEntry;
		}

		StringBundler msg = new StringBundler(4);

		msg.append(_NO_SUCH_ENTITY_WITH_KEY);

		msg.append("groupId=");
		msg.append(groupId);

		msg.append("}");

		throw new NoSuchIcebreakerEntryException(msg.toString());
	}

	/**
	 * Returns the first icebreaker entry in the ordered set where groupId = &#63;.
	 *
	 * @param groupId the group ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching icebreaker entry, or <code>null</code> if a matching icebreaker entry could not be found
	 */
	@Override
	public IcebreakerEntry fetchByGroupId_First(
		long groupId, OrderByComparator<IcebreakerEntry> orderByComparator) {

		List<IcebreakerEntry> list = findByGroupId(
			groupId, 0, 1, orderByComparator);

		if (!list.isEmpty()) {
			return list.get(0);
		}

		return null;
	}

	/**
	 * Returns the last icebreaker entry in the ordered set where groupId = &#63;.
	 *
	 * @param groupId the group ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching icebreaker entry
	 * @throws NoSuchIcebreakerEntryException if a matching icebreaker entry could not be found
	 */
	@Override
	public IcebreakerEntry findByGroupId_Last(
			long groupId, OrderByComparator<IcebreakerEntry> orderByComparator)
		throws NoSuchIcebreakerEntryException {

		IcebreakerEntry icebreakerEntry = fetchByGroupId_Last(
			groupId, orderByComparator);

		if (icebreakerEntry != null) {
			return icebreakerEntry;
		}

		StringBundler msg = new StringBundler(4);

		msg.append(_NO_SUCH_ENTITY_WITH_KEY);

		msg.append("groupId=");
		msg.append(groupId);

		msg.append("}");

		throw new NoSuchIcebreakerEntryException(msg.toString());
	}

	/**
	 * Returns the last icebreaker entry in the ordered set where groupId = &#63;.
	 *
	 * @param groupId the group ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching icebreaker entry, or <code>null</code> if a matching icebreaker entry could not be found
	 */
	@Override
	public IcebreakerEntry fetchByGroupId_Last(
		long groupId, OrderByComparator<IcebreakerEntry> orderByComparator) {

		int count = countByGroupId(groupId);

		if (count == 0) {
			return null;
		}

		List<IcebreakerEntry> list = findByGroupId(
			groupId, count - 1, count, orderByComparator);

		if (!list.isEmpty()) {
			return list.get(0);
		}

		return null;
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
	@Override
	public IcebreakerEntry[] findByGroupId_PrevAndNext(
			long icebreakerEntryId, long groupId,
			OrderByComparator<IcebreakerEntry> orderByComparator)
		throws NoSuchIcebreakerEntryException {

		IcebreakerEntry icebreakerEntry = findByPrimaryKey(icebreakerEntryId);

		Session session = null;

		try {
			session = openSession();

			IcebreakerEntry[] array = new IcebreakerEntryImpl[3];

			array[0] = getByGroupId_PrevAndNext(
				session, icebreakerEntry, groupId, orderByComparator, true);

			array[1] = icebreakerEntry;

			array[2] = getByGroupId_PrevAndNext(
				session, icebreakerEntry, groupId, orderByComparator, false);

			return array;
		}
		catch (Exception e) {
			throw processException(e);
		}
		finally {
			closeSession(session);
		}
	}

	protected IcebreakerEntry getByGroupId_PrevAndNext(
		Session session, IcebreakerEntry icebreakerEntry, long groupId,
		OrderByComparator<IcebreakerEntry> orderByComparator,
		boolean previous) {

		StringBundler query = null;

		if (orderByComparator != null) {
			query = new StringBundler(
				4 + (orderByComparator.getOrderByConditionFields().length * 3) +
					(orderByComparator.getOrderByFields().length * 3));
		}
		else {
			query = new StringBundler(3);
		}

		query.append(_SQL_SELECT_ICEBREAKERENTRY_WHERE);

		query.append(_FINDER_COLUMN_GROUPID_GROUPID_2);

		if (orderByComparator != null) {
			String[] orderByConditionFields =
				orderByComparator.getOrderByConditionFields();

			if (orderByConditionFields.length > 0) {
				query.append(WHERE_AND);
			}

			for (int i = 0; i < orderByConditionFields.length; i++) {
				query.append(_ORDER_BY_ENTITY_ALIAS);
				query.append(orderByConditionFields[i]);

				if ((i + 1) < orderByConditionFields.length) {
					if (orderByComparator.isAscending() ^ previous) {
						query.append(WHERE_GREATER_THAN_HAS_NEXT);
					}
					else {
						query.append(WHERE_LESSER_THAN_HAS_NEXT);
					}
				}
				else {
					if (orderByComparator.isAscending() ^ previous) {
						query.append(WHERE_GREATER_THAN);
					}
					else {
						query.append(WHERE_LESSER_THAN);
					}
				}
			}

			query.append(ORDER_BY_CLAUSE);

			String[] orderByFields = orderByComparator.getOrderByFields();

			for (int i = 0; i < orderByFields.length; i++) {
				query.append(_ORDER_BY_ENTITY_ALIAS);
				query.append(orderByFields[i]);

				if ((i + 1) < orderByFields.length) {
					if (orderByComparator.isAscending() ^ previous) {
						query.append(ORDER_BY_ASC_HAS_NEXT);
					}
					else {
						query.append(ORDER_BY_DESC_HAS_NEXT);
					}
				}
				else {
					if (orderByComparator.isAscending() ^ previous) {
						query.append(ORDER_BY_ASC);
					}
					else {
						query.append(ORDER_BY_DESC);
					}
				}
			}
		}
		else {
			query.append(IcebreakerEntryModelImpl.ORDER_BY_JPQL);
		}

		String sql = query.toString();

		Query q = session.createQuery(sql);

		q.setFirstResult(0);
		q.setMaxResults(2);

		QueryPos qPos = QueryPos.getInstance(q);

		qPos.add(groupId);

		if (orderByComparator != null) {
			for (Object orderByConditionValue :
					orderByComparator.getOrderByConditionValues(
						icebreakerEntry)) {

				qPos.add(orderByConditionValue);
			}
		}

		List<IcebreakerEntry> list = q.list();

		if (list.size() == 2) {
			return list.get(1);
		}
		else {
			return null;
		}
	}

	/**
	 * Removes all the icebreaker entries where groupId = &#63; from the database.
	 *
	 * @param groupId the group ID
	 */
	@Override
	public void removeByGroupId(long groupId) {
		for (IcebreakerEntry icebreakerEntry :
				findByGroupId(
					groupId, QueryUtil.ALL_POS, QueryUtil.ALL_POS, null)) {

			remove(icebreakerEntry);
		}
	}

	/**
	 * Returns the number of icebreaker entries where groupId = &#63;.
	 *
	 * @param groupId the group ID
	 * @return the number of matching icebreaker entries
	 */
	@Override
	public int countByGroupId(long groupId) {
		FinderPath finderPath = _finderPathCountByGroupId;

		Object[] finderArgs = new Object[] {groupId};

		Long count = (Long)finderCache.getResult(finderPath, finderArgs, this);

		if (count == null) {
			StringBundler query = new StringBundler(2);

			query.append(_SQL_COUNT_ICEBREAKERENTRY_WHERE);

			query.append(_FINDER_COLUMN_GROUPID_GROUPID_2);

			String sql = query.toString();

			Session session = null;

			try {
				session = openSession();

				Query q = session.createQuery(sql);

				QueryPos qPos = QueryPos.getInstance(q);

				qPos.add(groupId);

				count = (Long)q.uniqueResult();

				finderCache.putResult(finderPath, finderArgs, count);
			}
			catch (Exception e) {
				finderCache.removeResult(finderPath, finderArgs);

				throw processException(e);
			}
			finally {
				closeSession(session);
			}
		}

		return count.intValue();
	}

	private static final String _FINDER_COLUMN_GROUPID_GROUPID_2 =
		"icebreakerEntry.groupId = ?";

	private FinderPath _finderPathWithPaginationFindByUserId;
	private FinderPath _finderPathWithoutPaginationFindByUserId;
	private FinderPath _finderPathCountByUserId;

	/**
	 * Returns all the icebreaker entries where userId = &#63;.
	 *
	 * @param userId the user ID
	 * @return the matching icebreaker entries
	 */
	@Override
	public List<IcebreakerEntry> findByUserId(long userId) {
		return findByUserId(userId, QueryUtil.ALL_POS, QueryUtil.ALL_POS, null);
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
	@Override
	public List<IcebreakerEntry> findByUserId(long userId, int start, int end) {
		return findByUserId(userId, start, end, null);
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
	@Override
	public List<IcebreakerEntry> findByUserId(
		long userId, int start, int end,
		OrderByComparator<IcebreakerEntry> orderByComparator) {

		return findByUserId(userId, start, end, orderByComparator, true);
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
	@Override
	public List<IcebreakerEntry> findByUserId(
		long userId, int start, int end,
		OrderByComparator<IcebreakerEntry> orderByComparator,
		boolean retrieveFromCache) {

		boolean pagination = true;
		FinderPath finderPath = null;
		Object[] finderArgs = null;

		if ((start == QueryUtil.ALL_POS) && (end == QueryUtil.ALL_POS) &&
			(orderByComparator == null)) {

			pagination = false;
			finderPath = _finderPathWithoutPaginationFindByUserId;
			finderArgs = new Object[] {userId};
		}
		else {
			finderPath = _finderPathWithPaginationFindByUserId;
			finderArgs = new Object[] {userId, start, end, orderByComparator};
		}

		List<IcebreakerEntry> list = null;

		if (retrieveFromCache) {
			list = (List<IcebreakerEntry>)finderCache.getResult(
				finderPath, finderArgs, this);

			if ((list != null) && !list.isEmpty()) {
				for (IcebreakerEntry icebreakerEntry : list) {
					if ((userId != icebreakerEntry.getUserId())) {
						list = null;

						break;
					}
				}
			}
		}

		if (list == null) {
			StringBundler query = null;

			if (orderByComparator != null) {
				query = new StringBundler(
					3 + (orderByComparator.getOrderByFields().length * 2));
			}
			else {
				query = new StringBundler(3);
			}

			query.append(_SQL_SELECT_ICEBREAKERENTRY_WHERE);

			query.append(_FINDER_COLUMN_USERID_USERID_2);

			if (orderByComparator != null) {
				appendOrderByComparator(
					query, _ORDER_BY_ENTITY_ALIAS, orderByComparator);
			}
			else if (pagination) {
				query.append(IcebreakerEntryModelImpl.ORDER_BY_JPQL);
			}

			String sql = query.toString();

			Session session = null;

			try {
				session = openSession();

				Query q = session.createQuery(sql);

				QueryPos qPos = QueryPos.getInstance(q);

				qPos.add(userId);

				if (!pagination) {
					list = (List<IcebreakerEntry>)QueryUtil.list(
						q, getDialect(), start, end, false);

					Collections.sort(list);

					list = Collections.unmodifiableList(list);
				}
				else {
					list = (List<IcebreakerEntry>)QueryUtil.list(
						q, getDialect(), start, end);
				}

				cacheResult(list);

				finderCache.putResult(finderPath, finderArgs, list);
			}
			catch (Exception e) {
				finderCache.removeResult(finderPath, finderArgs);

				throw processException(e);
			}
			finally {
				closeSession(session);
			}
		}

		return list;
	}

	/**
	 * Returns the first icebreaker entry in the ordered set where userId = &#63;.
	 *
	 * @param userId the user ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching icebreaker entry
	 * @throws NoSuchIcebreakerEntryException if a matching icebreaker entry could not be found
	 */
	@Override
	public IcebreakerEntry findByUserId_First(
			long userId, OrderByComparator<IcebreakerEntry> orderByComparator)
		throws NoSuchIcebreakerEntryException {

		IcebreakerEntry icebreakerEntry = fetchByUserId_First(
			userId, orderByComparator);

		if (icebreakerEntry != null) {
			return icebreakerEntry;
		}

		StringBundler msg = new StringBundler(4);

		msg.append(_NO_SUCH_ENTITY_WITH_KEY);

		msg.append("userId=");
		msg.append(userId);

		msg.append("}");

		throw new NoSuchIcebreakerEntryException(msg.toString());
	}

	/**
	 * Returns the first icebreaker entry in the ordered set where userId = &#63;.
	 *
	 * @param userId the user ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching icebreaker entry, or <code>null</code> if a matching icebreaker entry could not be found
	 */
	@Override
	public IcebreakerEntry fetchByUserId_First(
		long userId, OrderByComparator<IcebreakerEntry> orderByComparator) {

		List<IcebreakerEntry> list = findByUserId(
			userId, 0, 1, orderByComparator);

		if (!list.isEmpty()) {
			return list.get(0);
		}

		return null;
	}

	/**
	 * Returns the last icebreaker entry in the ordered set where userId = &#63;.
	 *
	 * @param userId the user ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching icebreaker entry
	 * @throws NoSuchIcebreakerEntryException if a matching icebreaker entry could not be found
	 */
	@Override
	public IcebreakerEntry findByUserId_Last(
			long userId, OrderByComparator<IcebreakerEntry> orderByComparator)
		throws NoSuchIcebreakerEntryException {

		IcebreakerEntry icebreakerEntry = fetchByUserId_Last(
			userId, orderByComparator);

		if (icebreakerEntry != null) {
			return icebreakerEntry;
		}

		StringBundler msg = new StringBundler(4);

		msg.append(_NO_SUCH_ENTITY_WITH_KEY);

		msg.append("userId=");
		msg.append(userId);

		msg.append("}");

		throw new NoSuchIcebreakerEntryException(msg.toString());
	}

	/**
	 * Returns the last icebreaker entry in the ordered set where userId = &#63;.
	 *
	 * @param userId the user ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching icebreaker entry, or <code>null</code> if a matching icebreaker entry could not be found
	 */
	@Override
	public IcebreakerEntry fetchByUserId_Last(
		long userId, OrderByComparator<IcebreakerEntry> orderByComparator) {

		int count = countByUserId(userId);

		if (count == 0) {
			return null;
		}

		List<IcebreakerEntry> list = findByUserId(
			userId, count - 1, count, orderByComparator);

		if (!list.isEmpty()) {
			return list.get(0);
		}

		return null;
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
	@Override
	public IcebreakerEntry[] findByUserId_PrevAndNext(
			long icebreakerEntryId, long userId,
			OrderByComparator<IcebreakerEntry> orderByComparator)
		throws NoSuchIcebreakerEntryException {

		IcebreakerEntry icebreakerEntry = findByPrimaryKey(icebreakerEntryId);

		Session session = null;

		try {
			session = openSession();

			IcebreakerEntry[] array = new IcebreakerEntryImpl[3];

			array[0] = getByUserId_PrevAndNext(
				session, icebreakerEntry, userId, orderByComparator, true);

			array[1] = icebreakerEntry;

			array[2] = getByUserId_PrevAndNext(
				session, icebreakerEntry, userId, orderByComparator, false);

			return array;
		}
		catch (Exception e) {
			throw processException(e);
		}
		finally {
			closeSession(session);
		}
	}

	protected IcebreakerEntry getByUserId_PrevAndNext(
		Session session, IcebreakerEntry icebreakerEntry, long userId,
		OrderByComparator<IcebreakerEntry> orderByComparator,
		boolean previous) {

		StringBundler query = null;

		if (orderByComparator != null) {
			query = new StringBundler(
				4 + (orderByComparator.getOrderByConditionFields().length * 3) +
					(orderByComparator.getOrderByFields().length * 3));
		}
		else {
			query = new StringBundler(3);
		}

		query.append(_SQL_SELECT_ICEBREAKERENTRY_WHERE);

		query.append(_FINDER_COLUMN_USERID_USERID_2);

		if (orderByComparator != null) {
			String[] orderByConditionFields =
				orderByComparator.getOrderByConditionFields();

			if (orderByConditionFields.length > 0) {
				query.append(WHERE_AND);
			}

			for (int i = 0; i < orderByConditionFields.length; i++) {
				query.append(_ORDER_BY_ENTITY_ALIAS);
				query.append(orderByConditionFields[i]);

				if ((i + 1) < orderByConditionFields.length) {
					if (orderByComparator.isAscending() ^ previous) {
						query.append(WHERE_GREATER_THAN_HAS_NEXT);
					}
					else {
						query.append(WHERE_LESSER_THAN_HAS_NEXT);
					}
				}
				else {
					if (orderByComparator.isAscending() ^ previous) {
						query.append(WHERE_GREATER_THAN);
					}
					else {
						query.append(WHERE_LESSER_THAN);
					}
				}
			}

			query.append(ORDER_BY_CLAUSE);

			String[] orderByFields = orderByComparator.getOrderByFields();

			for (int i = 0; i < orderByFields.length; i++) {
				query.append(_ORDER_BY_ENTITY_ALIAS);
				query.append(orderByFields[i]);

				if ((i + 1) < orderByFields.length) {
					if (orderByComparator.isAscending() ^ previous) {
						query.append(ORDER_BY_ASC_HAS_NEXT);
					}
					else {
						query.append(ORDER_BY_DESC_HAS_NEXT);
					}
				}
				else {
					if (orderByComparator.isAscending() ^ previous) {
						query.append(ORDER_BY_ASC);
					}
					else {
						query.append(ORDER_BY_DESC);
					}
				}
			}
		}
		else {
			query.append(IcebreakerEntryModelImpl.ORDER_BY_JPQL);
		}

		String sql = query.toString();

		Query q = session.createQuery(sql);

		q.setFirstResult(0);
		q.setMaxResults(2);

		QueryPos qPos = QueryPos.getInstance(q);

		qPos.add(userId);

		if (orderByComparator != null) {
			for (Object orderByConditionValue :
					orderByComparator.getOrderByConditionValues(
						icebreakerEntry)) {

				qPos.add(orderByConditionValue);
			}
		}

		List<IcebreakerEntry> list = q.list();

		if (list.size() == 2) {
			return list.get(1);
		}
		else {
			return null;
		}
	}

	/**
	 * Removes all the icebreaker entries where userId = &#63; from the database.
	 *
	 * @param userId the user ID
	 */
	@Override
	public void removeByUserId(long userId) {
		for (IcebreakerEntry icebreakerEntry :
				findByUserId(
					userId, QueryUtil.ALL_POS, QueryUtil.ALL_POS, null)) {

			remove(icebreakerEntry);
		}
	}

	/**
	 * Returns the number of icebreaker entries where userId = &#63;.
	 *
	 * @param userId the user ID
	 * @return the number of matching icebreaker entries
	 */
	@Override
	public int countByUserId(long userId) {
		FinderPath finderPath = _finderPathCountByUserId;

		Object[] finderArgs = new Object[] {userId};

		Long count = (Long)finderCache.getResult(finderPath, finderArgs, this);

		if (count == null) {
			StringBundler query = new StringBundler(2);

			query.append(_SQL_COUNT_ICEBREAKERENTRY_WHERE);

			query.append(_FINDER_COLUMN_USERID_USERID_2);

			String sql = query.toString();

			Session session = null;

			try {
				session = openSession();

				Query q = session.createQuery(sql);

				QueryPos qPos = QueryPos.getInstance(q);

				qPos.add(userId);

				count = (Long)q.uniqueResult();

				finderCache.putResult(finderPath, finderArgs, count);
			}
			catch (Exception e) {
				finderCache.removeResult(finderPath, finderArgs);

				throw processException(e);
			}
			finally {
				closeSession(session);
			}
		}

		return count.intValue();
	}

	private static final String _FINDER_COLUMN_USERID_USERID_2 =
		"icebreakerEntry.userId = ?";

	private FinderPath _finderPathFetchByStatus;
	private FinderPath _finderPathCountByStatus;

	/**
	 * Returns the icebreaker entry where status = &#63; or throws a <code>NoSuchIcebreakerEntryException</code> if it could not be found.
	 *
	 * @param status the status
	 * @return the matching icebreaker entry
	 * @throws NoSuchIcebreakerEntryException if a matching icebreaker entry could not be found
	 */
	@Override
	public IcebreakerEntry findByStatus(int status)
		throws NoSuchIcebreakerEntryException {

		IcebreakerEntry icebreakerEntry = fetchByStatus(status);

		if (icebreakerEntry == null) {
			StringBundler msg = new StringBundler(4);

			msg.append(_NO_SUCH_ENTITY_WITH_KEY);

			msg.append("status=");
			msg.append(status);

			msg.append("}");

			if (_log.isDebugEnabled()) {
				_log.debug(msg.toString());
			}

			throw new NoSuchIcebreakerEntryException(msg.toString());
		}

		return icebreakerEntry;
	}

	/**
	 * Returns the icebreaker entry where status = &#63; or returns <code>null</code> if it could not be found. Uses the finder cache.
	 *
	 * @param status the status
	 * @return the matching icebreaker entry, or <code>null</code> if a matching icebreaker entry could not be found
	 */
	@Override
	public IcebreakerEntry fetchByStatus(int status) {
		return fetchByStatus(status, true);
	}

	/**
	 * Returns the icebreaker entry where status = &#63; or returns <code>null</code> if it could not be found, optionally using the finder cache.
	 *
	 * @param status the status
	 * @param retrieveFromCache whether to retrieve from the finder cache
	 * @return the matching icebreaker entry, or <code>null</code> if a matching icebreaker entry could not be found
	 */
	@Override
	public IcebreakerEntry fetchByStatus(
		int status, boolean retrieveFromCache) {

		Object[] finderArgs = new Object[] {status};

		Object result = null;

		if (retrieveFromCache) {
			result = finderCache.getResult(
				_finderPathFetchByStatus, finderArgs, this);
		}

		if (result instanceof IcebreakerEntry) {
			IcebreakerEntry icebreakerEntry = (IcebreakerEntry)result;

			if ((status != icebreakerEntry.getStatus())) {
				result = null;
			}
		}

		if (result == null) {
			StringBundler query = new StringBundler(3);

			query.append(_SQL_SELECT_ICEBREAKERENTRY_WHERE);

			query.append(_FINDER_COLUMN_STATUS_STATUS_2);

			String sql = query.toString();

			Session session = null;

			try {
				session = openSession();

				Query q = session.createQuery(sql);

				QueryPos qPos = QueryPos.getInstance(q);

				qPos.add(status);

				List<IcebreakerEntry> list = q.list();

				if (list.isEmpty()) {
					finderCache.putResult(
						_finderPathFetchByStatus, finderArgs, list);
				}
				else {
					if (list.size() > 1) {
						Collections.sort(list, Collections.reverseOrder());

						if (_log.isWarnEnabled()) {
							_log.warn(
								"IcebreakerEntryPersistenceImpl.fetchByStatus(int, boolean) with parameters (" +
									StringUtil.merge(finderArgs) +
										") yields a result set with more than 1 result. This violates the logical unique restriction. There is no order guarantee on which result is returned by this finder.");
						}
					}

					IcebreakerEntry icebreakerEntry = list.get(0);

					result = icebreakerEntry;

					cacheResult(icebreakerEntry);
				}
			}
			catch (Exception e) {
				finderCache.removeResult(_finderPathFetchByStatus, finderArgs);

				throw processException(e);
			}
			finally {
				closeSession(session);
			}
		}

		if (result instanceof List<?>) {
			return null;
		}
		else {
			return (IcebreakerEntry)result;
		}
	}

	/**
	 * Removes the icebreaker entry where status = &#63; from the database.
	 *
	 * @param status the status
	 * @return the icebreaker entry that was removed
	 */
	@Override
	public IcebreakerEntry removeByStatus(int status)
		throws NoSuchIcebreakerEntryException {

		IcebreakerEntry icebreakerEntry = findByStatus(status);

		return remove(icebreakerEntry);
	}

	/**
	 * Returns the number of icebreaker entries where status = &#63;.
	 *
	 * @param status the status
	 * @return the number of matching icebreaker entries
	 */
	@Override
	public int countByStatus(int status) {
		FinderPath finderPath = _finderPathCountByStatus;

		Object[] finderArgs = new Object[] {status};

		Long count = (Long)finderCache.getResult(finderPath, finderArgs, this);

		if (count == null) {
			StringBundler query = new StringBundler(2);

			query.append(_SQL_COUNT_ICEBREAKERENTRY_WHERE);

			query.append(_FINDER_COLUMN_STATUS_STATUS_2);

			String sql = query.toString();

			Session session = null;

			try {
				session = openSession();

				Query q = session.createQuery(sql);

				QueryPos qPos = QueryPos.getInstance(q);

				qPos.add(status);

				count = (Long)q.uniqueResult();

				finderCache.putResult(finderPath, finderArgs, count);
			}
			catch (Exception e) {
				finderCache.removeResult(finderPath, finderArgs);

				throw processException(e);
			}
			finally {
				closeSession(session);
			}
		}

		return count.intValue();
	}

	private static final String _FINDER_COLUMN_STATUS_STATUS_2 =
		"icebreakerEntry.status = ?";

	private FinderPath _finderPathWithPaginationFindBy_G_S;
	private FinderPath _finderPathWithoutPaginationFindBy_G_S;
	private FinderPath _finderPathCountBy_G_S;

	/**
	 * Returns all the icebreaker entries where groupId = &#63; and status = &#63;.
	 *
	 * @param groupId the group ID
	 * @param status the status
	 * @return the matching icebreaker entries
	 */
	@Override
	public List<IcebreakerEntry> findBy_G_S(long groupId, int status) {
		return findBy_G_S(
			groupId, status, QueryUtil.ALL_POS, QueryUtil.ALL_POS, null);
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
	@Override
	public List<IcebreakerEntry> findBy_G_S(
		long groupId, int status, int start, int end) {

		return findBy_G_S(groupId, status, start, end, null);
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
	@Override
	public List<IcebreakerEntry> findBy_G_S(
		long groupId, int status, int start, int end,
		OrderByComparator<IcebreakerEntry> orderByComparator) {

		return findBy_G_S(groupId, status, start, end, orderByComparator, true);
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
	@Override
	public List<IcebreakerEntry> findBy_G_S(
		long groupId, int status, int start, int end,
		OrderByComparator<IcebreakerEntry> orderByComparator,
		boolean retrieveFromCache) {

		boolean pagination = true;
		FinderPath finderPath = null;
		Object[] finderArgs = null;

		if ((start == QueryUtil.ALL_POS) && (end == QueryUtil.ALL_POS) &&
			(orderByComparator == null)) {

			pagination = false;
			finderPath = _finderPathWithoutPaginationFindBy_G_S;
			finderArgs = new Object[] {groupId, status};
		}
		else {
			finderPath = _finderPathWithPaginationFindBy_G_S;
			finderArgs = new Object[] {
				groupId, status, start, end, orderByComparator
			};
		}

		List<IcebreakerEntry> list = null;

		if (retrieveFromCache) {
			list = (List<IcebreakerEntry>)finderCache.getResult(
				finderPath, finderArgs, this);

			if ((list != null) && !list.isEmpty()) {
				for (IcebreakerEntry icebreakerEntry : list) {
					if ((groupId != icebreakerEntry.getGroupId()) ||
						(status != icebreakerEntry.getStatus())) {

						list = null;

						break;
					}
				}
			}
		}

		if (list == null) {
			StringBundler query = null;

			if (orderByComparator != null) {
				query = new StringBundler(
					4 + (orderByComparator.getOrderByFields().length * 2));
			}
			else {
				query = new StringBundler(4);
			}

			query.append(_SQL_SELECT_ICEBREAKERENTRY_WHERE);

			query.append(_FINDER_COLUMN__G_S_GROUPID_2);

			query.append(_FINDER_COLUMN__G_S_STATUS_2);

			if (orderByComparator != null) {
				appendOrderByComparator(
					query, _ORDER_BY_ENTITY_ALIAS, orderByComparator);
			}
			else if (pagination) {
				query.append(IcebreakerEntryModelImpl.ORDER_BY_JPQL);
			}

			String sql = query.toString();

			Session session = null;

			try {
				session = openSession();

				Query q = session.createQuery(sql);

				QueryPos qPos = QueryPos.getInstance(q);

				qPos.add(groupId);

				qPos.add(status);

				if (!pagination) {
					list = (List<IcebreakerEntry>)QueryUtil.list(
						q, getDialect(), start, end, false);

					Collections.sort(list);

					list = Collections.unmodifiableList(list);
				}
				else {
					list = (List<IcebreakerEntry>)QueryUtil.list(
						q, getDialect(), start, end);
				}

				cacheResult(list);

				finderCache.putResult(finderPath, finderArgs, list);
			}
			catch (Exception e) {
				finderCache.removeResult(finderPath, finderArgs);

				throw processException(e);
			}
			finally {
				closeSession(session);
			}
		}

		return list;
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
	@Override
	public IcebreakerEntry findBy_G_S_First(
			long groupId, int status,
			OrderByComparator<IcebreakerEntry> orderByComparator)
		throws NoSuchIcebreakerEntryException {

		IcebreakerEntry icebreakerEntry = fetchBy_G_S_First(
			groupId, status, orderByComparator);

		if (icebreakerEntry != null) {
			return icebreakerEntry;
		}

		StringBundler msg = new StringBundler(6);

		msg.append(_NO_SUCH_ENTITY_WITH_KEY);

		msg.append("groupId=");
		msg.append(groupId);

		msg.append(", status=");
		msg.append(status);

		msg.append("}");

		throw new NoSuchIcebreakerEntryException(msg.toString());
	}

	/**
	 * Returns the first icebreaker entry in the ordered set where groupId = &#63; and status = &#63;.
	 *
	 * @param groupId the group ID
	 * @param status the status
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching icebreaker entry, or <code>null</code> if a matching icebreaker entry could not be found
	 */
	@Override
	public IcebreakerEntry fetchBy_G_S_First(
		long groupId, int status,
		OrderByComparator<IcebreakerEntry> orderByComparator) {

		List<IcebreakerEntry> list = findBy_G_S(
			groupId, status, 0, 1, orderByComparator);

		if (!list.isEmpty()) {
			return list.get(0);
		}

		return null;
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
	@Override
	public IcebreakerEntry findBy_G_S_Last(
			long groupId, int status,
			OrderByComparator<IcebreakerEntry> orderByComparator)
		throws NoSuchIcebreakerEntryException {

		IcebreakerEntry icebreakerEntry = fetchBy_G_S_Last(
			groupId, status, orderByComparator);

		if (icebreakerEntry != null) {
			return icebreakerEntry;
		}

		StringBundler msg = new StringBundler(6);

		msg.append(_NO_SUCH_ENTITY_WITH_KEY);

		msg.append("groupId=");
		msg.append(groupId);

		msg.append(", status=");
		msg.append(status);

		msg.append("}");

		throw new NoSuchIcebreakerEntryException(msg.toString());
	}

	/**
	 * Returns the last icebreaker entry in the ordered set where groupId = &#63; and status = &#63;.
	 *
	 * @param groupId the group ID
	 * @param status the status
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching icebreaker entry, or <code>null</code> if a matching icebreaker entry could not be found
	 */
	@Override
	public IcebreakerEntry fetchBy_G_S_Last(
		long groupId, int status,
		OrderByComparator<IcebreakerEntry> orderByComparator) {

		int count = countBy_G_S(groupId, status);

		if (count == 0) {
			return null;
		}

		List<IcebreakerEntry> list = findBy_G_S(
			groupId, status, count - 1, count, orderByComparator);

		if (!list.isEmpty()) {
			return list.get(0);
		}

		return null;
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
	@Override
	public IcebreakerEntry[] findBy_G_S_PrevAndNext(
			long icebreakerEntryId, long groupId, int status,
			OrderByComparator<IcebreakerEntry> orderByComparator)
		throws NoSuchIcebreakerEntryException {

		IcebreakerEntry icebreakerEntry = findByPrimaryKey(icebreakerEntryId);

		Session session = null;

		try {
			session = openSession();

			IcebreakerEntry[] array = new IcebreakerEntryImpl[3];

			array[0] = getBy_G_S_PrevAndNext(
				session, icebreakerEntry, groupId, status, orderByComparator,
				true);

			array[1] = icebreakerEntry;

			array[2] = getBy_G_S_PrevAndNext(
				session, icebreakerEntry, groupId, status, orderByComparator,
				false);

			return array;
		}
		catch (Exception e) {
			throw processException(e);
		}
		finally {
			closeSession(session);
		}
	}

	protected IcebreakerEntry getBy_G_S_PrevAndNext(
		Session session, IcebreakerEntry icebreakerEntry, long groupId,
		int status, OrderByComparator<IcebreakerEntry> orderByComparator,
		boolean previous) {

		StringBundler query = null;

		if (orderByComparator != null) {
			query = new StringBundler(
				5 + (orderByComparator.getOrderByConditionFields().length * 3) +
					(orderByComparator.getOrderByFields().length * 3));
		}
		else {
			query = new StringBundler(4);
		}

		query.append(_SQL_SELECT_ICEBREAKERENTRY_WHERE);

		query.append(_FINDER_COLUMN__G_S_GROUPID_2);

		query.append(_FINDER_COLUMN__G_S_STATUS_2);

		if (orderByComparator != null) {
			String[] orderByConditionFields =
				orderByComparator.getOrderByConditionFields();

			if (orderByConditionFields.length > 0) {
				query.append(WHERE_AND);
			}

			for (int i = 0; i < orderByConditionFields.length; i++) {
				query.append(_ORDER_BY_ENTITY_ALIAS);
				query.append(orderByConditionFields[i]);

				if ((i + 1) < orderByConditionFields.length) {
					if (orderByComparator.isAscending() ^ previous) {
						query.append(WHERE_GREATER_THAN_HAS_NEXT);
					}
					else {
						query.append(WHERE_LESSER_THAN_HAS_NEXT);
					}
				}
				else {
					if (orderByComparator.isAscending() ^ previous) {
						query.append(WHERE_GREATER_THAN);
					}
					else {
						query.append(WHERE_LESSER_THAN);
					}
				}
			}

			query.append(ORDER_BY_CLAUSE);

			String[] orderByFields = orderByComparator.getOrderByFields();

			for (int i = 0; i < orderByFields.length; i++) {
				query.append(_ORDER_BY_ENTITY_ALIAS);
				query.append(orderByFields[i]);

				if ((i + 1) < orderByFields.length) {
					if (orderByComparator.isAscending() ^ previous) {
						query.append(ORDER_BY_ASC_HAS_NEXT);
					}
					else {
						query.append(ORDER_BY_DESC_HAS_NEXT);
					}
				}
				else {
					if (orderByComparator.isAscending() ^ previous) {
						query.append(ORDER_BY_ASC);
					}
					else {
						query.append(ORDER_BY_DESC);
					}
				}
			}
		}
		else {
			query.append(IcebreakerEntryModelImpl.ORDER_BY_JPQL);
		}

		String sql = query.toString();

		Query q = session.createQuery(sql);

		q.setFirstResult(0);
		q.setMaxResults(2);

		QueryPos qPos = QueryPos.getInstance(q);

		qPos.add(groupId);

		qPos.add(status);

		if (orderByComparator != null) {
			for (Object orderByConditionValue :
					orderByComparator.getOrderByConditionValues(
						icebreakerEntry)) {

				qPos.add(orderByConditionValue);
			}
		}

		List<IcebreakerEntry> list = q.list();

		if (list.size() == 2) {
			return list.get(1);
		}
		else {
			return null;
		}
	}

	/**
	 * Removes all the icebreaker entries where groupId = &#63; and status = &#63; from the database.
	 *
	 * @param groupId the group ID
	 * @param status the status
	 */
	@Override
	public void removeBy_G_S(long groupId, int status) {
		for (IcebreakerEntry icebreakerEntry :
				findBy_G_S(
					groupId, status, QueryUtil.ALL_POS, QueryUtil.ALL_POS,
					null)) {

			remove(icebreakerEntry);
		}
	}

	/**
	 * Returns the number of icebreaker entries where groupId = &#63; and status = &#63;.
	 *
	 * @param groupId the group ID
	 * @param status the status
	 * @return the number of matching icebreaker entries
	 */
	@Override
	public int countBy_G_S(long groupId, int status) {
		FinderPath finderPath = _finderPathCountBy_G_S;

		Object[] finderArgs = new Object[] {groupId, status};

		Long count = (Long)finderCache.getResult(finderPath, finderArgs, this);

		if (count == null) {
			StringBundler query = new StringBundler(3);

			query.append(_SQL_COUNT_ICEBREAKERENTRY_WHERE);

			query.append(_FINDER_COLUMN__G_S_GROUPID_2);

			query.append(_FINDER_COLUMN__G_S_STATUS_2);

			String sql = query.toString();

			Session session = null;

			try {
				session = openSession();

				Query q = session.createQuery(sql);

				QueryPos qPos = QueryPos.getInstance(q);

				qPos.add(groupId);

				qPos.add(status);

				count = (Long)q.uniqueResult();

				finderCache.putResult(finderPath, finderArgs, count);
			}
			catch (Exception e) {
				finderCache.removeResult(finderPath, finderArgs);

				throw processException(e);
			}
			finally {
				closeSession(session);
			}
		}

		return count.intValue();
	}

	private static final String _FINDER_COLUMN__G_S_GROUPID_2 =
		"icebreakerEntry.groupId = ? AND ";

	private static final String _FINDER_COLUMN__G_S_STATUS_2 =
		"icebreakerEntry.status = ?";

	private FinderPath _finderPathFetchByType;
	private FinderPath _finderPathCountByType;

	/**
	 * Returns the icebreaker entry where type = &#63; or throws a <code>NoSuchIcebreakerEntryException</code> if it could not be found.
	 *
	 * @param type the type
	 * @return the matching icebreaker entry
	 * @throws NoSuchIcebreakerEntryException if a matching icebreaker entry could not be found
	 */
	@Override
	public IcebreakerEntry findByType(String type)
		throws NoSuchIcebreakerEntryException {

		IcebreakerEntry icebreakerEntry = fetchByType(type);

		if (icebreakerEntry == null) {
			StringBundler msg = new StringBundler(4);

			msg.append(_NO_SUCH_ENTITY_WITH_KEY);

			msg.append("type=");
			msg.append(type);

			msg.append("}");

			if (_log.isDebugEnabled()) {
				_log.debug(msg.toString());
			}

			throw new NoSuchIcebreakerEntryException(msg.toString());
		}

		return icebreakerEntry;
	}

	/**
	 * Returns the icebreaker entry where type = &#63; or returns <code>null</code> if it could not be found. Uses the finder cache.
	 *
	 * @param type the type
	 * @return the matching icebreaker entry, or <code>null</code> if a matching icebreaker entry could not be found
	 */
	@Override
	public IcebreakerEntry fetchByType(String type) {
		return fetchByType(type, true);
	}

	/**
	 * Returns the icebreaker entry where type = &#63; or returns <code>null</code> if it could not be found, optionally using the finder cache.
	 *
	 * @param type the type
	 * @param retrieveFromCache whether to retrieve from the finder cache
	 * @return the matching icebreaker entry, or <code>null</code> if a matching icebreaker entry could not be found
	 */
	@Override
	public IcebreakerEntry fetchByType(String type, boolean retrieveFromCache) {
		type = Objects.toString(type, "");

		Object[] finderArgs = new Object[] {type};

		Object result = null;

		if (retrieveFromCache) {
			result = finderCache.getResult(
				_finderPathFetchByType, finderArgs, this);
		}

		if (result instanceof IcebreakerEntry) {
			IcebreakerEntry icebreakerEntry = (IcebreakerEntry)result;

			if (!Objects.equals(type, icebreakerEntry.getType())) {
				result = null;
			}
		}

		if (result == null) {
			StringBundler query = new StringBundler(3);

			query.append(_SQL_SELECT_ICEBREAKERENTRY_WHERE);

			boolean bindType = false;

			if (type.isEmpty()) {
				query.append(_FINDER_COLUMN_TYPE_TYPE_3);
			}
			else {
				bindType = true;

				query.append(_FINDER_COLUMN_TYPE_TYPE_2);
			}

			String sql = query.toString();

			Session session = null;

			try {
				session = openSession();

				Query q = session.createQuery(sql);

				QueryPos qPos = QueryPos.getInstance(q);

				if (bindType) {
					qPos.add(type);
				}

				List<IcebreakerEntry> list = q.list();

				if (list.isEmpty()) {
					finderCache.putResult(
						_finderPathFetchByType, finderArgs, list);
				}
				else {
					if (list.size() > 1) {
						Collections.sort(list, Collections.reverseOrder());

						if (_log.isWarnEnabled()) {
							_log.warn(
								"IcebreakerEntryPersistenceImpl.fetchByType(String, boolean) with parameters (" +
									StringUtil.merge(finderArgs) +
										") yields a result set with more than 1 result. This violates the logical unique restriction. There is no order guarantee on which result is returned by this finder.");
						}
					}

					IcebreakerEntry icebreakerEntry = list.get(0);

					result = icebreakerEntry;

					cacheResult(icebreakerEntry);
				}
			}
			catch (Exception e) {
				finderCache.removeResult(_finderPathFetchByType, finderArgs);

				throw processException(e);
			}
			finally {
				closeSession(session);
			}
		}

		if (result instanceof List<?>) {
			return null;
		}
		else {
			return (IcebreakerEntry)result;
		}
	}

	/**
	 * Removes the icebreaker entry where type = &#63; from the database.
	 *
	 * @param type the type
	 * @return the icebreaker entry that was removed
	 */
	@Override
	public IcebreakerEntry removeByType(String type)
		throws NoSuchIcebreakerEntryException {

		IcebreakerEntry icebreakerEntry = findByType(type);

		return remove(icebreakerEntry);
	}

	/**
	 * Returns the number of icebreaker entries where type = &#63;.
	 *
	 * @param type the type
	 * @return the number of matching icebreaker entries
	 */
	@Override
	public int countByType(String type) {
		type = Objects.toString(type, "");

		FinderPath finderPath = _finderPathCountByType;

		Object[] finderArgs = new Object[] {type};

		Long count = (Long)finderCache.getResult(finderPath, finderArgs, this);

		if (count == null) {
			StringBundler query = new StringBundler(2);

			query.append(_SQL_COUNT_ICEBREAKERENTRY_WHERE);

			boolean bindType = false;

			if (type.isEmpty()) {
				query.append(_FINDER_COLUMN_TYPE_TYPE_3);
			}
			else {
				bindType = true;

				query.append(_FINDER_COLUMN_TYPE_TYPE_2);
			}

			String sql = query.toString();

			Session session = null;

			try {
				session = openSession();

				Query q = session.createQuery(sql);

				QueryPos qPos = QueryPos.getInstance(q);

				if (bindType) {
					qPos.add(type);
				}

				count = (Long)q.uniqueResult();

				finderCache.putResult(finderPath, finderArgs, count);
			}
			catch (Exception e) {
				finderCache.removeResult(finderPath, finderArgs);

				throw processException(e);
			}
			finally {
				closeSession(session);
			}
		}

		return count.intValue();
	}

	private static final String _FINDER_COLUMN_TYPE_TYPE_2 =
		"icebreakerEntry.type = ?";

	private static final String _FINDER_COLUMN_TYPE_TYPE_3 =
		"(icebreakerEntry.type IS NULL OR icebreakerEntry.type = '')";

	public IcebreakerEntryPersistenceImpl() {
		setModelClass(IcebreakerEntry.class);

		setModelImplClass(IcebreakerEntryImpl.class);
		setModelPKClass(long.class);

		Map<String, String> dbColumnNames = new HashMap<String, String>();

		dbColumnNames.put("uuid", "uuid_");
		dbColumnNames.put("type", "type_");

		setDBColumnNames(dbColumnNames);
	}

	/**
	 * Caches the icebreaker entry in the entity cache if it is enabled.
	 *
	 * @param icebreakerEntry the icebreaker entry
	 */
	@Override
	public void cacheResult(IcebreakerEntry icebreakerEntry) {
		entityCache.putResult(
			entityCacheEnabled, IcebreakerEntryImpl.class,
			icebreakerEntry.getPrimaryKey(), icebreakerEntry);

		finderCache.putResult(
			_finderPathFetchByUUID_G,
			new Object[] {
				icebreakerEntry.getUuid(), icebreakerEntry.getGroupId()
			},
			icebreakerEntry);

		finderCache.putResult(
			_finderPathFetchByStatus,
			new Object[] {icebreakerEntry.getStatus()}, icebreakerEntry);

		finderCache.putResult(
			_finderPathFetchByType, new Object[] {icebreakerEntry.getType()},
			icebreakerEntry);

		icebreakerEntry.resetOriginalValues();
	}

	/**
	 * Caches the icebreaker entries in the entity cache if it is enabled.
	 *
	 * @param icebreakerEntries the icebreaker entries
	 */
	@Override
	public void cacheResult(List<IcebreakerEntry> icebreakerEntries) {
		for (IcebreakerEntry icebreakerEntry : icebreakerEntries) {
			if (entityCache.getResult(
					entityCacheEnabled, IcebreakerEntryImpl.class,
					icebreakerEntry.getPrimaryKey()) == null) {

				cacheResult(icebreakerEntry);
			}
			else {
				icebreakerEntry.resetOriginalValues();
			}
		}
	}

	/**
	 * Clears the cache for all icebreaker entries.
	 *
	 * <p>
	 * The <code>EntityCache</code> and <code>FinderCache</code> are both cleared by this method.
	 * </p>
	 */
	@Override
	public void clearCache() {
		entityCache.clearCache(IcebreakerEntryImpl.class);

		finderCache.clearCache(FINDER_CLASS_NAME_ENTITY);
		finderCache.clearCache(FINDER_CLASS_NAME_LIST_WITH_PAGINATION);
		finderCache.clearCache(FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION);
	}

	/**
	 * Clears the cache for the icebreaker entry.
	 *
	 * <p>
	 * The <code>EntityCache</code> and <code>FinderCache</code> are both cleared by this method.
	 * </p>
	 */
	@Override
	public void clearCache(IcebreakerEntry icebreakerEntry) {
		entityCache.removeResult(
			entityCacheEnabled, IcebreakerEntryImpl.class,
			icebreakerEntry.getPrimaryKey());

		finderCache.clearCache(FINDER_CLASS_NAME_LIST_WITH_PAGINATION);
		finderCache.clearCache(FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION);

		clearUniqueFindersCache(
			(IcebreakerEntryModelImpl)icebreakerEntry, true);
	}

	@Override
	public void clearCache(List<IcebreakerEntry> icebreakerEntries) {
		finderCache.clearCache(FINDER_CLASS_NAME_LIST_WITH_PAGINATION);
		finderCache.clearCache(FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION);

		for (IcebreakerEntry icebreakerEntry : icebreakerEntries) {
			entityCache.removeResult(
				entityCacheEnabled, IcebreakerEntryImpl.class,
				icebreakerEntry.getPrimaryKey());

			clearUniqueFindersCache(
				(IcebreakerEntryModelImpl)icebreakerEntry, true);
		}
	}

	protected void cacheUniqueFindersCache(
		IcebreakerEntryModelImpl icebreakerEntryModelImpl) {

		Object[] args = new Object[] {
			icebreakerEntryModelImpl.getUuid(),
			icebreakerEntryModelImpl.getGroupId()
		};

		finderCache.putResult(
			_finderPathCountByUUID_G, args, Long.valueOf(1), false);
		finderCache.putResult(
			_finderPathFetchByUUID_G, args, icebreakerEntryModelImpl, false);

		args = new Object[] {icebreakerEntryModelImpl.getStatus()};

		finderCache.putResult(
			_finderPathCountByStatus, args, Long.valueOf(1), false);
		finderCache.putResult(
			_finderPathFetchByStatus, args, icebreakerEntryModelImpl, false);

		args = new Object[] {icebreakerEntryModelImpl.getType()};

		finderCache.putResult(
			_finderPathCountByType, args, Long.valueOf(1), false);
		finderCache.putResult(
			_finderPathFetchByType, args, icebreakerEntryModelImpl, false);
	}

	protected void clearUniqueFindersCache(
		IcebreakerEntryModelImpl icebreakerEntryModelImpl,
		boolean clearCurrent) {

		if (clearCurrent) {
			Object[] args = new Object[] {
				icebreakerEntryModelImpl.getUuid(),
				icebreakerEntryModelImpl.getGroupId()
			};

			finderCache.removeResult(_finderPathCountByUUID_G, args);
			finderCache.removeResult(_finderPathFetchByUUID_G, args);
		}

		if ((icebreakerEntryModelImpl.getColumnBitmask() &
			 _finderPathFetchByUUID_G.getColumnBitmask()) != 0) {

			Object[] args = new Object[] {
				icebreakerEntryModelImpl.getOriginalUuid(),
				icebreakerEntryModelImpl.getOriginalGroupId()
			};

			finderCache.removeResult(_finderPathCountByUUID_G, args);
			finderCache.removeResult(_finderPathFetchByUUID_G, args);
		}

		if (clearCurrent) {
			Object[] args = new Object[] {icebreakerEntryModelImpl.getStatus()};

			finderCache.removeResult(_finderPathCountByStatus, args);
			finderCache.removeResult(_finderPathFetchByStatus, args);
		}

		if ((icebreakerEntryModelImpl.getColumnBitmask() &
			 _finderPathFetchByStatus.getColumnBitmask()) != 0) {

			Object[] args = new Object[] {
				icebreakerEntryModelImpl.getOriginalStatus()
			};

			finderCache.removeResult(_finderPathCountByStatus, args);
			finderCache.removeResult(_finderPathFetchByStatus, args);
		}

		if (clearCurrent) {
			Object[] args = new Object[] {icebreakerEntryModelImpl.getType()};

			finderCache.removeResult(_finderPathCountByType, args);
			finderCache.removeResult(_finderPathFetchByType, args);
		}

		if ((icebreakerEntryModelImpl.getColumnBitmask() &
			 _finderPathFetchByType.getColumnBitmask()) != 0) {

			Object[] args = new Object[] {
				icebreakerEntryModelImpl.getOriginalType()
			};

			finderCache.removeResult(_finderPathCountByType, args);
			finderCache.removeResult(_finderPathFetchByType, args);
		}
	}

	/**
	 * Creates a new icebreaker entry with the primary key. Does not add the icebreaker entry to the database.
	 *
	 * @param icebreakerEntryId the primary key for the new icebreaker entry
	 * @return the new icebreaker entry
	 */
	@Override
	public IcebreakerEntry create(long icebreakerEntryId) {
		IcebreakerEntry icebreakerEntry = new IcebreakerEntryImpl();

		icebreakerEntry.setNew(true);
		icebreakerEntry.setPrimaryKey(icebreakerEntryId);

		String uuid = PortalUUIDUtil.generate();

		icebreakerEntry.setUuid(uuid);

		icebreakerEntry.setCompanyId(companyProvider.getCompanyId());

		return icebreakerEntry;
	}

	/**
	 * Removes the icebreaker entry with the primary key from the database. Also notifies the appropriate model listeners.
	 *
	 * @param icebreakerEntryId the primary key of the icebreaker entry
	 * @return the icebreaker entry that was removed
	 * @throws NoSuchIcebreakerEntryException if a icebreaker entry with the primary key could not be found
	 */
	@Override
	public IcebreakerEntry remove(long icebreakerEntryId)
		throws NoSuchIcebreakerEntryException {

		return remove((Serializable)icebreakerEntryId);
	}

	/**
	 * Removes the icebreaker entry with the primary key from the database. Also notifies the appropriate model listeners.
	 *
	 * @param primaryKey the primary key of the icebreaker entry
	 * @return the icebreaker entry that was removed
	 * @throws NoSuchIcebreakerEntryException if a icebreaker entry with the primary key could not be found
	 */
	@Override
	public IcebreakerEntry remove(Serializable primaryKey)
		throws NoSuchIcebreakerEntryException {

		Session session = null;

		try {
			session = openSession();

			IcebreakerEntry icebreakerEntry = (IcebreakerEntry)session.get(
				IcebreakerEntryImpl.class, primaryKey);

			if (icebreakerEntry == null) {
				if (_log.isDebugEnabled()) {
					_log.debug(_NO_SUCH_ENTITY_WITH_PRIMARY_KEY + primaryKey);
				}

				throw new NoSuchIcebreakerEntryException(
					_NO_SUCH_ENTITY_WITH_PRIMARY_KEY + primaryKey);
			}

			return remove(icebreakerEntry);
		}
		catch (NoSuchIcebreakerEntryException nsee) {
			throw nsee;
		}
		catch (Exception e) {
			throw processException(e);
		}
		finally {
			closeSession(session);
		}
	}

	@Override
	protected IcebreakerEntry removeImpl(IcebreakerEntry icebreakerEntry) {
		Session session = null;

		try {
			session = openSession();

			if (!session.contains(icebreakerEntry)) {
				icebreakerEntry = (IcebreakerEntry)session.get(
					IcebreakerEntryImpl.class,
					icebreakerEntry.getPrimaryKeyObj());
			}

			if (icebreakerEntry != null) {
				session.delete(icebreakerEntry);
			}
		}
		catch (Exception e) {
			throw processException(e);
		}
		finally {
			closeSession(session);
		}

		if (icebreakerEntry != null) {
			clearCache(icebreakerEntry);
		}

		return icebreakerEntry;
	}

	@Override
	public IcebreakerEntry updateImpl(IcebreakerEntry icebreakerEntry) {
		boolean isNew = icebreakerEntry.isNew();

		if (!(icebreakerEntry instanceof IcebreakerEntryModelImpl)) {
			InvocationHandler invocationHandler = null;

			if (ProxyUtil.isProxyClass(icebreakerEntry.getClass())) {
				invocationHandler = ProxyUtil.getInvocationHandler(
					icebreakerEntry);

				throw new IllegalArgumentException(
					"Implement ModelWrapper in icebreakerEntry proxy " +
						invocationHandler.getClass());
			}

			throw new IllegalArgumentException(
				"Implement ModelWrapper in custom IcebreakerEntry implementation " +
					icebreakerEntry.getClass());
		}

		IcebreakerEntryModelImpl icebreakerEntryModelImpl =
			(IcebreakerEntryModelImpl)icebreakerEntry;

		if (Validator.isNull(icebreakerEntry.getUuid())) {
			String uuid = PortalUUIDUtil.generate();

			icebreakerEntry.setUuid(uuid);
		}

		ServiceContext serviceContext =
			ServiceContextThreadLocal.getServiceContext();

		Date now = new Date();

		if (isNew && (icebreakerEntry.getCreateDate() == null)) {
			if (serviceContext == null) {
				icebreakerEntry.setCreateDate(now);
			}
			else {
				icebreakerEntry.setCreateDate(
					serviceContext.getCreateDate(now));
			}
		}

		if (!icebreakerEntryModelImpl.hasSetModifiedDate()) {
			if (serviceContext == null) {
				icebreakerEntry.setModifiedDate(now);
			}
			else {
				icebreakerEntry.setModifiedDate(
					serviceContext.getModifiedDate(now));
			}
		}

		Session session = null;

		try {
			session = openSession();

			if (icebreakerEntry.isNew()) {
				session.save(icebreakerEntry);

				icebreakerEntry.setNew(false);
			}
			else {
				icebreakerEntry = (IcebreakerEntry)session.merge(
					icebreakerEntry);
			}
		}
		catch (Exception e) {
			throw processException(e);
		}
		finally {
			closeSession(session);
		}

		finderCache.clearCache(FINDER_CLASS_NAME_LIST_WITH_PAGINATION);

		if (!_columnBitmaskEnabled) {
			finderCache.clearCache(FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION);
		}
		else if (isNew) {
			Object[] args = new Object[] {icebreakerEntryModelImpl.getUuid()};

			finderCache.removeResult(_finderPathCountByUuid, args);
			finderCache.removeResult(
				_finderPathWithoutPaginationFindByUuid, args);

			args = new Object[] {
				icebreakerEntryModelImpl.getUuid(),
				icebreakerEntryModelImpl.getCompanyId()
			};

			finderCache.removeResult(_finderPathCountByUuid_C, args);
			finderCache.removeResult(
				_finderPathWithoutPaginationFindByUuid_C, args);

			args = new Object[] {icebreakerEntryModelImpl.getGroupId()};

			finderCache.removeResult(_finderPathCountByGroupId, args);
			finderCache.removeResult(
				_finderPathWithoutPaginationFindByGroupId, args);

			args = new Object[] {icebreakerEntryModelImpl.getUserId()};

			finderCache.removeResult(_finderPathCountByUserId, args);
			finderCache.removeResult(
				_finderPathWithoutPaginationFindByUserId, args);

			args = new Object[] {
				icebreakerEntryModelImpl.getGroupId(),
				icebreakerEntryModelImpl.getStatus()
			};

			finderCache.removeResult(_finderPathCountBy_G_S, args);
			finderCache.removeResult(
				_finderPathWithoutPaginationFindBy_G_S, args);

			finderCache.removeResult(_finderPathCountAll, FINDER_ARGS_EMPTY);
			finderCache.removeResult(
				_finderPathWithoutPaginationFindAll, FINDER_ARGS_EMPTY);
		}
		else {
			if ((icebreakerEntryModelImpl.getColumnBitmask() &
				 _finderPathWithoutPaginationFindByUuid.getColumnBitmask()) !=
					 0) {

				Object[] args = new Object[] {
					icebreakerEntryModelImpl.getOriginalUuid()
				};

				finderCache.removeResult(_finderPathCountByUuid, args);
				finderCache.removeResult(
					_finderPathWithoutPaginationFindByUuid, args);

				args = new Object[] {icebreakerEntryModelImpl.getUuid()};

				finderCache.removeResult(_finderPathCountByUuid, args);
				finderCache.removeResult(
					_finderPathWithoutPaginationFindByUuid, args);
			}

			if ((icebreakerEntryModelImpl.getColumnBitmask() &
				 _finderPathWithoutPaginationFindByUuid_C.getColumnBitmask()) !=
					 0) {

				Object[] args = new Object[] {
					icebreakerEntryModelImpl.getOriginalUuid(),
					icebreakerEntryModelImpl.getOriginalCompanyId()
				};

				finderCache.removeResult(_finderPathCountByUuid_C, args);
				finderCache.removeResult(
					_finderPathWithoutPaginationFindByUuid_C, args);

				args = new Object[] {
					icebreakerEntryModelImpl.getUuid(),
					icebreakerEntryModelImpl.getCompanyId()
				};

				finderCache.removeResult(_finderPathCountByUuid_C, args);
				finderCache.removeResult(
					_finderPathWithoutPaginationFindByUuid_C, args);
			}

			if ((icebreakerEntryModelImpl.getColumnBitmask() &
				 _finderPathWithoutPaginationFindByGroupId.
					 getColumnBitmask()) != 0) {

				Object[] args = new Object[] {
					icebreakerEntryModelImpl.getOriginalGroupId()
				};

				finderCache.removeResult(_finderPathCountByGroupId, args);
				finderCache.removeResult(
					_finderPathWithoutPaginationFindByGroupId, args);

				args = new Object[] {icebreakerEntryModelImpl.getGroupId()};

				finderCache.removeResult(_finderPathCountByGroupId, args);
				finderCache.removeResult(
					_finderPathWithoutPaginationFindByGroupId, args);
			}

			if ((icebreakerEntryModelImpl.getColumnBitmask() &
				 _finderPathWithoutPaginationFindByUserId.getColumnBitmask()) !=
					 0) {

				Object[] args = new Object[] {
					icebreakerEntryModelImpl.getOriginalUserId()
				};

				finderCache.removeResult(_finderPathCountByUserId, args);
				finderCache.removeResult(
					_finderPathWithoutPaginationFindByUserId, args);

				args = new Object[] {icebreakerEntryModelImpl.getUserId()};

				finderCache.removeResult(_finderPathCountByUserId, args);
				finderCache.removeResult(
					_finderPathWithoutPaginationFindByUserId, args);
			}

			if ((icebreakerEntryModelImpl.getColumnBitmask() &
				 _finderPathWithoutPaginationFindBy_G_S.getColumnBitmask()) !=
					 0) {

				Object[] args = new Object[] {
					icebreakerEntryModelImpl.getOriginalGroupId(),
					icebreakerEntryModelImpl.getOriginalStatus()
				};

				finderCache.removeResult(_finderPathCountBy_G_S, args);
				finderCache.removeResult(
					_finderPathWithoutPaginationFindBy_G_S, args);

				args = new Object[] {
					icebreakerEntryModelImpl.getGroupId(),
					icebreakerEntryModelImpl.getStatus()
				};

				finderCache.removeResult(_finderPathCountBy_G_S, args);
				finderCache.removeResult(
					_finderPathWithoutPaginationFindBy_G_S, args);
			}
		}

		entityCache.putResult(
			entityCacheEnabled, IcebreakerEntryImpl.class,
			icebreakerEntry.getPrimaryKey(), icebreakerEntry, false);

		clearUniqueFindersCache(icebreakerEntryModelImpl, false);
		cacheUniqueFindersCache(icebreakerEntryModelImpl);

		icebreakerEntry.resetOriginalValues();

		return icebreakerEntry;
	}

	/**
	 * Returns the icebreaker entry with the primary key or throws a <code>com.liferay.portal.kernel.exception.NoSuchModelException</code> if it could not be found.
	 *
	 * @param primaryKey the primary key of the icebreaker entry
	 * @return the icebreaker entry
	 * @throws NoSuchIcebreakerEntryException if a icebreaker entry with the primary key could not be found
	 */
	@Override
	public IcebreakerEntry findByPrimaryKey(Serializable primaryKey)
		throws NoSuchIcebreakerEntryException {

		IcebreakerEntry icebreakerEntry = fetchByPrimaryKey(primaryKey);

		if (icebreakerEntry == null) {
			if (_log.isDebugEnabled()) {
				_log.debug(_NO_SUCH_ENTITY_WITH_PRIMARY_KEY + primaryKey);
			}

			throw new NoSuchIcebreakerEntryException(
				_NO_SUCH_ENTITY_WITH_PRIMARY_KEY + primaryKey);
		}

		return icebreakerEntry;
	}

	/**
	 * Returns the icebreaker entry with the primary key or throws a <code>NoSuchIcebreakerEntryException</code> if it could not be found.
	 *
	 * @param icebreakerEntryId the primary key of the icebreaker entry
	 * @return the icebreaker entry
	 * @throws NoSuchIcebreakerEntryException if a icebreaker entry with the primary key could not be found
	 */
	@Override
	public IcebreakerEntry findByPrimaryKey(long icebreakerEntryId)
		throws NoSuchIcebreakerEntryException {

		return findByPrimaryKey((Serializable)icebreakerEntryId);
	}

	/**
	 * Returns the icebreaker entry with the primary key or returns <code>null</code> if it could not be found.
	 *
	 * @param icebreakerEntryId the primary key of the icebreaker entry
	 * @return the icebreaker entry, or <code>null</code> if a icebreaker entry with the primary key could not be found
	 */
	@Override
	public IcebreakerEntry fetchByPrimaryKey(long icebreakerEntryId) {
		return fetchByPrimaryKey((Serializable)icebreakerEntryId);
	}

	/**
	 * Returns all the icebreaker entries.
	 *
	 * @return the icebreaker entries
	 */
	@Override
	public List<IcebreakerEntry> findAll() {
		return findAll(QueryUtil.ALL_POS, QueryUtil.ALL_POS, null);
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
	@Override
	public List<IcebreakerEntry> findAll(int start, int end) {
		return findAll(start, end, null);
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
	@Override
	public List<IcebreakerEntry> findAll(
		int start, int end,
		OrderByComparator<IcebreakerEntry> orderByComparator) {

		return findAll(start, end, orderByComparator, true);
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
	@Override
	public List<IcebreakerEntry> findAll(
		int start, int end,
		OrderByComparator<IcebreakerEntry> orderByComparator,
		boolean retrieveFromCache) {

		boolean pagination = true;
		FinderPath finderPath = null;
		Object[] finderArgs = null;

		if ((start == QueryUtil.ALL_POS) && (end == QueryUtil.ALL_POS) &&
			(orderByComparator == null)) {

			pagination = false;
			finderPath = _finderPathWithoutPaginationFindAll;
			finderArgs = FINDER_ARGS_EMPTY;
		}
		else {
			finderPath = _finderPathWithPaginationFindAll;
			finderArgs = new Object[] {start, end, orderByComparator};
		}

		List<IcebreakerEntry> list = null;

		if (retrieveFromCache) {
			list = (List<IcebreakerEntry>)finderCache.getResult(
				finderPath, finderArgs, this);
		}

		if (list == null) {
			StringBundler query = null;
			String sql = null;

			if (orderByComparator != null) {
				query = new StringBundler(
					2 + (orderByComparator.getOrderByFields().length * 2));

				query.append(_SQL_SELECT_ICEBREAKERENTRY);

				appendOrderByComparator(
					query, _ORDER_BY_ENTITY_ALIAS, orderByComparator);

				sql = query.toString();
			}
			else {
				sql = _SQL_SELECT_ICEBREAKERENTRY;

				if (pagination) {
					sql = sql.concat(IcebreakerEntryModelImpl.ORDER_BY_JPQL);
				}
			}

			Session session = null;

			try {
				session = openSession();

				Query q = session.createQuery(sql);

				if (!pagination) {
					list = (List<IcebreakerEntry>)QueryUtil.list(
						q, getDialect(), start, end, false);

					Collections.sort(list);

					list = Collections.unmodifiableList(list);
				}
				else {
					list = (List<IcebreakerEntry>)QueryUtil.list(
						q, getDialect(), start, end);
				}

				cacheResult(list);

				finderCache.putResult(finderPath, finderArgs, list);
			}
			catch (Exception e) {
				finderCache.removeResult(finderPath, finderArgs);

				throw processException(e);
			}
			finally {
				closeSession(session);
			}
		}

		return list;
	}

	/**
	 * Removes all the icebreaker entries from the database.
	 *
	 */
	@Override
	public void removeAll() {
		for (IcebreakerEntry icebreakerEntry : findAll()) {
			remove(icebreakerEntry);
		}
	}

	/**
	 * Returns the number of icebreaker entries.
	 *
	 * @return the number of icebreaker entries
	 */
	@Override
	public int countAll() {
		Long count = (Long)finderCache.getResult(
			_finderPathCountAll, FINDER_ARGS_EMPTY, this);

		if (count == null) {
			Session session = null;

			try {
				session = openSession();

				Query q = session.createQuery(_SQL_COUNT_ICEBREAKERENTRY);

				count = (Long)q.uniqueResult();

				finderCache.putResult(
					_finderPathCountAll, FINDER_ARGS_EMPTY, count);
			}
			catch (Exception e) {
				finderCache.removeResult(
					_finderPathCountAll, FINDER_ARGS_EMPTY);

				throw processException(e);
			}
			finally {
				closeSession(session);
			}
		}

		return count.intValue();
	}

	@Override
	public Set<String> getBadColumnNames() {
		return _badColumnNames;
	}

	@Override
	protected EntityCache getEntityCache() {
		return entityCache;
	}

	@Override
	protected String getPKDBName() {
		return "icebreakerEntryId";
	}

	@Override
	protected String getSelectSQL() {
		return _SQL_SELECT_ICEBREAKERENTRY;
	}

	@Override
	protected Map<String, Integer> getTableColumnsMap() {
		return IcebreakerEntryModelImpl.TABLE_COLUMNS_MAP;
	}

	/**
	 * Initializes the icebreaker entry persistence.
	 */
	@Activate
	public void activate() {
		IcebreakerEntryModelImpl.setEntityCacheEnabled(entityCacheEnabled);
		IcebreakerEntryModelImpl.setFinderCacheEnabled(finderCacheEnabled);

		_finderPathWithPaginationFindAll = new FinderPath(
			entityCacheEnabled, finderCacheEnabled, IcebreakerEntryImpl.class,
			FINDER_CLASS_NAME_LIST_WITH_PAGINATION, "findAll", new String[0]);

		_finderPathWithoutPaginationFindAll = new FinderPath(
			entityCacheEnabled, finderCacheEnabled, IcebreakerEntryImpl.class,
			FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION, "findAll",
			new String[0]);

		_finderPathCountAll = new FinderPath(
			entityCacheEnabled, finderCacheEnabled, Long.class,
			FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION, "countAll",
			new String[0]);

		_finderPathWithPaginationFindByUuid = new FinderPath(
			entityCacheEnabled, finderCacheEnabled, IcebreakerEntryImpl.class,
			FINDER_CLASS_NAME_LIST_WITH_PAGINATION, "findByUuid",
			new String[] {
				String.class.getName(), Integer.class.getName(),
				Integer.class.getName(), OrderByComparator.class.getName()
			});

		_finderPathWithoutPaginationFindByUuid = new FinderPath(
			entityCacheEnabled, finderCacheEnabled, IcebreakerEntryImpl.class,
			FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION, "findByUuid",
			new String[] {String.class.getName()},
			IcebreakerEntryModelImpl.UUID_COLUMN_BITMASK |
			IcebreakerEntryModelImpl.CREATEDATE_COLUMN_BITMASK);

		_finderPathCountByUuid = new FinderPath(
			entityCacheEnabled, finderCacheEnabled, Long.class,
			FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION, "countByUuid",
			new String[] {String.class.getName()});

		_finderPathFetchByUUID_G = new FinderPath(
			entityCacheEnabled, finderCacheEnabled, IcebreakerEntryImpl.class,
			FINDER_CLASS_NAME_ENTITY, "fetchByUUID_G",
			new String[] {String.class.getName(), Long.class.getName()},
			IcebreakerEntryModelImpl.UUID_COLUMN_BITMASK |
			IcebreakerEntryModelImpl.GROUPID_COLUMN_BITMASK);

		_finderPathCountByUUID_G = new FinderPath(
			entityCacheEnabled, finderCacheEnabled, Long.class,
			FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION, "countByUUID_G",
			new String[] {String.class.getName(), Long.class.getName()});

		_finderPathWithPaginationFindByUuid_C = new FinderPath(
			entityCacheEnabled, finderCacheEnabled, IcebreakerEntryImpl.class,
			FINDER_CLASS_NAME_LIST_WITH_PAGINATION, "findByUuid_C",
			new String[] {
				String.class.getName(), Long.class.getName(),
				Integer.class.getName(), Integer.class.getName(),
				OrderByComparator.class.getName()
			});

		_finderPathWithoutPaginationFindByUuid_C = new FinderPath(
			entityCacheEnabled, finderCacheEnabled, IcebreakerEntryImpl.class,
			FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION, "findByUuid_C",
			new String[] {String.class.getName(), Long.class.getName()},
			IcebreakerEntryModelImpl.UUID_COLUMN_BITMASK |
			IcebreakerEntryModelImpl.COMPANYID_COLUMN_BITMASK |
			IcebreakerEntryModelImpl.CREATEDATE_COLUMN_BITMASK);

		_finderPathCountByUuid_C = new FinderPath(
			entityCacheEnabled, finderCacheEnabled, Long.class,
			FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION, "countByUuid_C",
			new String[] {String.class.getName(), Long.class.getName()});

		_finderPathWithPaginationFindByGroupId = new FinderPath(
			entityCacheEnabled, finderCacheEnabled, IcebreakerEntryImpl.class,
			FINDER_CLASS_NAME_LIST_WITH_PAGINATION, "findByGroupId",
			new String[] {
				Long.class.getName(), Integer.class.getName(),
				Integer.class.getName(), OrderByComparator.class.getName()
			});

		_finderPathWithoutPaginationFindByGroupId = new FinderPath(
			entityCacheEnabled, finderCacheEnabled, IcebreakerEntryImpl.class,
			FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION, "findByGroupId",
			new String[] {Long.class.getName()},
			IcebreakerEntryModelImpl.GROUPID_COLUMN_BITMASK |
			IcebreakerEntryModelImpl.CREATEDATE_COLUMN_BITMASK);

		_finderPathCountByGroupId = new FinderPath(
			entityCacheEnabled, finderCacheEnabled, Long.class,
			FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION, "countByGroupId",
			new String[] {Long.class.getName()});

		_finderPathWithPaginationFindByUserId = new FinderPath(
			entityCacheEnabled, finderCacheEnabled, IcebreakerEntryImpl.class,
			FINDER_CLASS_NAME_LIST_WITH_PAGINATION, "findByUserId",
			new String[] {
				Long.class.getName(), Integer.class.getName(),
				Integer.class.getName(), OrderByComparator.class.getName()
			});

		_finderPathWithoutPaginationFindByUserId = new FinderPath(
			entityCacheEnabled, finderCacheEnabled, IcebreakerEntryImpl.class,
			FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION, "findByUserId",
			new String[] {Long.class.getName()},
			IcebreakerEntryModelImpl.USERID_COLUMN_BITMASK |
			IcebreakerEntryModelImpl.CREATEDATE_COLUMN_BITMASK);

		_finderPathCountByUserId = new FinderPath(
			entityCacheEnabled, finderCacheEnabled, Long.class,
			FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION, "countByUserId",
			new String[] {Long.class.getName()});

		_finderPathFetchByStatus = new FinderPath(
			entityCacheEnabled, finderCacheEnabled, IcebreakerEntryImpl.class,
			FINDER_CLASS_NAME_ENTITY, "fetchByStatus",
			new String[] {Integer.class.getName()},
			IcebreakerEntryModelImpl.STATUS_COLUMN_BITMASK);

		_finderPathCountByStatus = new FinderPath(
			entityCacheEnabled, finderCacheEnabled, Long.class,
			FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION, "countByStatus",
			new String[] {Integer.class.getName()});

		_finderPathWithPaginationFindBy_G_S = new FinderPath(
			entityCacheEnabled, finderCacheEnabled, IcebreakerEntryImpl.class,
			FINDER_CLASS_NAME_LIST_WITH_PAGINATION, "findBy_G_S",
			new String[] {
				Long.class.getName(), Integer.class.getName(),
				Integer.class.getName(), Integer.class.getName(),
				OrderByComparator.class.getName()
			});

		_finderPathWithoutPaginationFindBy_G_S = new FinderPath(
			entityCacheEnabled, finderCacheEnabled, IcebreakerEntryImpl.class,
			FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION, "findBy_G_S",
			new String[] {Long.class.getName(), Integer.class.getName()},
			IcebreakerEntryModelImpl.GROUPID_COLUMN_BITMASK |
			IcebreakerEntryModelImpl.STATUS_COLUMN_BITMASK |
			IcebreakerEntryModelImpl.CREATEDATE_COLUMN_BITMASK);

		_finderPathCountBy_G_S = new FinderPath(
			entityCacheEnabled, finderCacheEnabled, Long.class,
			FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION, "countBy_G_S",
			new String[] {Long.class.getName(), Integer.class.getName()});

		_finderPathFetchByType = new FinderPath(
			entityCacheEnabled, finderCacheEnabled, IcebreakerEntryImpl.class,
			FINDER_CLASS_NAME_ENTITY, "fetchByType",
			new String[] {String.class.getName()},
			IcebreakerEntryModelImpl.TYPE_COLUMN_BITMASK);

		_finderPathCountByType = new FinderPath(
			entityCacheEnabled, finderCacheEnabled, Long.class,
			FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION, "countByType",
			new String[] {String.class.getName()});
	}

	@Deactivate
	public void deactivate() {
		entityCache.removeCache(IcebreakerEntryImpl.class.getName());
		finderCache.removeCache(FINDER_CLASS_NAME_ENTITY);
		finderCache.removeCache(FINDER_CLASS_NAME_LIST_WITH_PAGINATION);
		finderCache.removeCache(FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION);
	}

	@Override
	@Reference(
		target = ICEBREAKERPersistenceConstants.ORIGIN_BUNDLE_SYMBOLIC_NAME_FILTER,
		unbind = "-"
	)
	public void setConfiguration(Configuration configuration) {
		super.setConfiguration(configuration);

		_columnBitmaskEnabled = GetterUtil.getBoolean(
			configuration.get(
				"value.object.column.bitmask.enabled.com.osp.icebreaker.model.IcebreakerEntry"),
			true);
	}

	@Override
	@Reference(
		target = ICEBREAKERPersistenceConstants.ORIGIN_BUNDLE_SYMBOLIC_NAME_FILTER,
		unbind = "-"
	)
	public void setDataSource(DataSource dataSource) {
		super.setDataSource(dataSource);
	}

	@Override
	@Reference(
		target = ICEBREAKERPersistenceConstants.ORIGIN_BUNDLE_SYMBOLIC_NAME_FILTER,
		unbind = "-"
	)
	public void setSessionFactory(SessionFactory sessionFactory) {
		super.setSessionFactory(sessionFactory);
	}

	private boolean _columnBitmaskEnabled;

	@Reference(service = CompanyProviderWrapper.class)
	protected CompanyProvider companyProvider;

	@Reference
	protected EntityCache entityCache;

	@Reference
	protected FinderCache finderCache;

	private static final String _SQL_SELECT_ICEBREAKERENTRY =
		"SELECT icebreakerEntry FROM IcebreakerEntry icebreakerEntry";

	private static final String _SQL_SELECT_ICEBREAKERENTRY_WHERE =
		"SELECT icebreakerEntry FROM IcebreakerEntry icebreakerEntry WHERE ";

	private static final String _SQL_COUNT_ICEBREAKERENTRY =
		"SELECT COUNT(icebreakerEntry) FROM IcebreakerEntry icebreakerEntry";

	private static final String _SQL_COUNT_ICEBREAKERENTRY_WHERE =
		"SELECT COUNT(icebreakerEntry) FROM IcebreakerEntry icebreakerEntry WHERE ";

	private static final String _ORDER_BY_ENTITY_ALIAS = "icebreakerEntry.";

	private static final String _NO_SUCH_ENTITY_WITH_PRIMARY_KEY =
		"No IcebreakerEntry exists with the primary key ";

	private static final String _NO_SUCH_ENTITY_WITH_KEY =
		"No IcebreakerEntry exists with the key {";

	private static final Log _log = LogFactoryUtil.getLog(
		IcebreakerEntryPersistenceImpl.class);

	private static final Set<String> _badColumnNames = SetUtil.fromArray(
		new String[] {"uuid", "type"});

}