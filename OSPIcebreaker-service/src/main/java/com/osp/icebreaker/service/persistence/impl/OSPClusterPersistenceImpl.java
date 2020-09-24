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
import com.liferay.portal.kernel.security.auth.CompanyThreadLocal;
import com.liferay.portal.kernel.service.ServiceContext;
import com.liferay.portal.kernel.service.ServiceContextThreadLocal;
import com.liferay.portal.kernel.service.persistence.impl.BasePersistenceImpl;
import com.liferay.portal.kernel.util.GetterUtil;
import com.liferay.portal.kernel.util.OrderByComparator;
import com.liferay.portal.kernel.util.ProxyUtil;
import com.liferay.portal.kernel.util.SetUtil;
import com.liferay.portal.kernel.util.Validator;
import com.liferay.portal.kernel.uuid.PortalUUIDUtil;

import com.osp.icebreaker.exception.NoSuchOSPClusterException;
import com.osp.icebreaker.model.OSPCluster;
import com.osp.icebreaker.model.impl.OSPClusterImpl;
import com.osp.icebreaker.model.impl.OSPClusterModelImpl;
import com.osp.icebreaker.service.persistence.OSPClusterPersistence;
import com.osp.icebreaker.service.persistence.impl.constants.ICEBREAKERPersistenceConstants;

import java.io.Serializable;

import java.lang.reflect.InvocationHandler;

import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Objects;
import java.util.Set;

import javax.sql.DataSource;

import org.osgi.service.component.annotations.Activate;
import org.osgi.service.component.annotations.Component;
import org.osgi.service.component.annotations.Deactivate;
import org.osgi.service.component.annotations.Reference;

/**
 * The persistence implementation for the osp cluster service.
 *
 * <p>
 * Caching information and settings can be found in <code>portal.properties</code>
 * </p>
 *
 * @author Jerry H. Seo
 * @generated
 */
@Component(service = OSPClusterPersistence.class)
public class OSPClusterPersistenceImpl
	extends BasePersistenceImpl<OSPCluster> implements OSPClusterPersistence {

	/*
	 * NOTE FOR DEVELOPERS:
	 *
	 * Never modify or reference this class directly. Always use <code>OSPClusterUtil</code> to access the osp cluster persistence. Modify <code>service.xml</code> and rerun ServiceBuilder to regenerate this class.
	 */
	public static final String FINDER_CLASS_NAME_ENTITY =
		OSPClusterImpl.class.getName();

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
	 * Returns all the osp clusters where uuid = &#63;.
	 *
	 * @param uuid the uuid
	 * @return the matching osp clusters
	 */
	@Override
	public List<OSPCluster> findByUuid(String uuid) {
		return findByUuid(uuid, QueryUtil.ALL_POS, QueryUtil.ALL_POS, null);
	}

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
	@Override
	public List<OSPCluster> findByUuid(String uuid, int start, int end) {
		return findByUuid(uuid, start, end, null);
	}

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
	@Override
	public List<OSPCluster> findByUuid(
		String uuid, int start, int end,
		OrderByComparator<OSPCluster> orderByComparator) {

		return findByUuid(uuid, start, end, orderByComparator, true);
	}

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
	@Override
	public List<OSPCluster> findByUuid(
		String uuid, int start, int end,
		OrderByComparator<OSPCluster> orderByComparator,
		boolean useFinderCache) {

		uuid = Objects.toString(uuid, "");

		FinderPath finderPath = null;
		Object[] finderArgs = null;

		if ((start == QueryUtil.ALL_POS) && (end == QueryUtil.ALL_POS) &&
			(orderByComparator == null)) {

			if (useFinderCache) {
				finderPath = _finderPathWithoutPaginationFindByUuid;
				finderArgs = new Object[] {uuid};
			}
		}
		else if (useFinderCache) {
			finderPath = _finderPathWithPaginationFindByUuid;
			finderArgs = new Object[] {uuid, start, end, orderByComparator};
		}

		List<OSPCluster> list = null;

		if (useFinderCache) {
			list = (List<OSPCluster>)finderCache.getResult(
				finderPath, finderArgs, this);

			if ((list != null) && !list.isEmpty()) {
				for (OSPCluster ospCluster : list) {
					if (!uuid.equals(ospCluster.getUuid())) {
						list = null;

						break;
					}
				}
			}
		}

		if (list == null) {
			StringBundler sb = null;

			if (orderByComparator != null) {
				sb = new StringBundler(
					3 + (orderByComparator.getOrderByFields().length * 2));
			}
			else {
				sb = new StringBundler(3);
			}

			sb.append(_SQL_SELECT_OSPCLUSTER_WHERE);

			boolean bindUuid = false;

			if (uuid.isEmpty()) {
				sb.append(_FINDER_COLUMN_UUID_UUID_3);
			}
			else {
				bindUuid = true;

				sb.append(_FINDER_COLUMN_UUID_UUID_2);
			}

			if (orderByComparator != null) {
				appendOrderByComparator(
					sb, _ORDER_BY_ENTITY_ALIAS, orderByComparator);
			}
			else {
				sb.append(OSPClusterModelImpl.ORDER_BY_JPQL);
			}

			String sql = sb.toString();

			Session session = null;

			try {
				session = openSession();

				Query query = session.createQuery(sql);

				QueryPos queryPos = QueryPos.getInstance(query);

				if (bindUuid) {
					queryPos.add(uuid);
				}

				list = (List<OSPCluster>)QueryUtil.list(
					query, getDialect(), start, end);

				cacheResult(list);

				if (useFinderCache) {
					finderCache.putResult(finderPath, finderArgs, list);
				}
			}
			catch (Exception exception) {
				if (useFinderCache) {
					finderCache.removeResult(finderPath, finderArgs);
				}

				throw processException(exception);
			}
			finally {
				closeSession(session);
			}
		}

		return list;
	}

	/**
	 * Returns the first osp cluster in the ordered set where uuid = &#63;.
	 *
	 * @param uuid the uuid
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching osp cluster
	 * @throws NoSuchOSPClusterException if a matching osp cluster could not be found
	 */
	@Override
	public OSPCluster findByUuid_First(
			String uuid, OrderByComparator<OSPCluster> orderByComparator)
		throws NoSuchOSPClusterException {

		OSPCluster ospCluster = fetchByUuid_First(uuid, orderByComparator);

		if (ospCluster != null) {
			return ospCluster;
		}

		StringBundler sb = new StringBundler(4);

		sb.append(_NO_SUCH_ENTITY_WITH_KEY);

		sb.append("uuid=");
		sb.append(uuid);

		sb.append("}");

		throw new NoSuchOSPClusterException(sb.toString());
	}

	/**
	 * Returns the first osp cluster in the ordered set where uuid = &#63;.
	 *
	 * @param uuid the uuid
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching osp cluster, or <code>null</code> if a matching osp cluster could not be found
	 */
	@Override
	public OSPCluster fetchByUuid_First(
		String uuid, OrderByComparator<OSPCluster> orderByComparator) {

		List<OSPCluster> list = findByUuid(uuid, 0, 1, orderByComparator);

		if (!list.isEmpty()) {
			return list.get(0);
		}

		return null;
	}

	/**
	 * Returns the last osp cluster in the ordered set where uuid = &#63;.
	 *
	 * @param uuid the uuid
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching osp cluster
	 * @throws NoSuchOSPClusterException if a matching osp cluster could not be found
	 */
	@Override
	public OSPCluster findByUuid_Last(
			String uuid, OrderByComparator<OSPCluster> orderByComparator)
		throws NoSuchOSPClusterException {

		OSPCluster ospCluster = fetchByUuid_Last(uuid, orderByComparator);

		if (ospCluster != null) {
			return ospCluster;
		}

		StringBundler sb = new StringBundler(4);

		sb.append(_NO_SUCH_ENTITY_WITH_KEY);

		sb.append("uuid=");
		sb.append(uuid);

		sb.append("}");

		throw new NoSuchOSPClusterException(sb.toString());
	}

	/**
	 * Returns the last osp cluster in the ordered set where uuid = &#63;.
	 *
	 * @param uuid the uuid
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching osp cluster, or <code>null</code> if a matching osp cluster could not be found
	 */
	@Override
	public OSPCluster fetchByUuid_Last(
		String uuid, OrderByComparator<OSPCluster> orderByComparator) {

		int count = countByUuid(uuid);

		if (count == 0) {
			return null;
		}

		List<OSPCluster> list = findByUuid(
			uuid, count - 1, count, orderByComparator);

		if (!list.isEmpty()) {
			return list.get(0);
		}

		return null;
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
	@Override
	public OSPCluster[] findByUuid_PrevAndNext(
			long clusterId, String uuid,
			OrderByComparator<OSPCluster> orderByComparator)
		throws NoSuchOSPClusterException {

		uuid = Objects.toString(uuid, "");

		OSPCluster ospCluster = findByPrimaryKey(clusterId);

		Session session = null;

		try {
			session = openSession();

			OSPCluster[] array = new OSPClusterImpl[3];

			array[0] = getByUuid_PrevAndNext(
				session, ospCluster, uuid, orderByComparator, true);

			array[1] = ospCluster;

			array[2] = getByUuid_PrevAndNext(
				session, ospCluster, uuid, orderByComparator, false);

			return array;
		}
		catch (Exception exception) {
			throw processException(exception);
		}
		finally {
			closeSession(session);
		}
	}

	protected OSPCluster getByUuid_PrevAndNext(
		Session session, OSPCluster ospCluster, String uuid,
		OrderByComparator<OSPCluster> orderByComparator, boolean previous) {

		StringBundler sb = null;

		if (orderByComparator != null) {
			sb = new StringBundler(
				4 + (orderByComparator.getOrderByConditionFields().length * 3) +
					(orderByComparator.getOrderByFields().length * 3));
		}
		else {
			sb = new StringBundler(3);
		}

		sb.append(_SQL_SELECT_OSPCLUSTER_WHERE);

		boolean bindUuid = false;

		if (uuid.isEmpty()) {
			sb.append(_FINDER_COLUMN_UUID_UUID_3);
		}
		else {
			bindUuid = true;

			sb.append(_FINDER_COLUMN_UUID_UUID_2);
		}

		if (orderByComparator != null) {
			String[] orderByConditionFields =
				orderByComparator.getOrderByConditionFields();

			if (orderByConditionFields.length > 0) {
				sb.append(WHERE_AND);
			}

			for (int i = 0; i < orderByConditionFields.length; i++) {
				sb.append(_ORDER_BY_ENTITY_ALIAS);
				sb.append(orderByConditionFields[i]);

				if ((i + 1) < orderByConditionFields.length) {
					if (orderByComparator.isAscending() ^ previous) {
						sb.append(WHERE_GREATER_THAN_HAS_NEXT);
					}
					else {
						sb.append(WHERE_LESSER_THAN_HAS_NEXT);
					}
				}
				else {
					if (orderByComparator.isAscending() ^ previous) {
						sb.append(WHERE_GREATER_THAN);
					}
					else {
						sb.append(WHERE_LESSER_THAN);
					}
				}
			}

			sb.append(ORDER_BY_CLAUSE);

			String[] orderByFields = orderByComparator.getOrderByFields();

			for (int i = 0; i < orderByFields.length; i++) {
				sb.append(_ORDER_BY_ENTITY_ALIAS);
				sb.append(orderByFields[i]);

				if ((i + 1) < orderByFields.length) {
					if (orderByComparator.isAscending() ^ previous) {
						sb.append(ORDER_BY_ASC_HAS_NEXT);
					}
					else {
						sb.append(ORDER_BY_DESC_HAS_NEXT);
					}
				}
				else {
					if (orderByComparator.isAscending() ^ previous) {
						sb.append(ORDER_BY_ASC);
					}
					else {
						sb.append(ORDER_BY_DESC);
					}
				}
			}
		}
		else {
			sb.append(OSPClusterModelImpl.ORDER_BY_JPQL);
		}

		String sql = sb.toString();

		Query query = session.createQuery(sql);

		query.setFirstResult(0);
		query.setMaxResults(2);

		QueryPos queryPos = QueryPos.getInstance(query);

		if (bindUuid) {
			queryPos.add(uuid);
		}

		if (orderByComparator != null) {
			for (Object orderByConditionValue :
					orderByComparator.getOrderByConditionValues(ospCluster)) {

				queryPos.add(orderByConditionValue);
			}
		}

		List<OSPCluster> list = query.list();

		if (list.size() == 2) {
			return list.get(1);
		}
		else {
			return null;
		}
	}

	/**
	 * Removes all the osp clusters where uuid = &#63; from the database.
	 *
	 * @param uuid the uuid
	 */
	@Override
	public void removeByUuid(String uuid) {
		for (OSPCluster ospCluster :
				findByUuid(uuid, QueryUtil.ALL_POS, QueryUtil.ALL_POS, null)) {

			remove(ospCluster);
		}
	}

	/**
	 * Returns the number of osp clusters where uuid = &#63;.
	 *
	 * @param uuid the uuid
	 * @return the number of matching osp clusters
	 */
	@Override
	public int countByUuid(String uuid) {
		uuid = Objects.toString(uuid, "");

		FinderPath finderPath = _finderPathCountByUuid;

		Object[] finderArgs = new Object[] {uuid};

		Long count = (Long)finderCache.getResult(finderPath, finderArgs, this);

		if (count == null) {
			StringBundler sb = new StringBundler(2);

			sb.append(_SQL_COUNT_OSPCLUSTER_WHERE);

			boolean bindUuid = false;

			if (uuid.isEmpty()) {
				sb.append(_FINDER_COLUMN_UUID_UUID_3);
			}
			else {
				bindUuid = true;

				sb.append(_FINDER_COLUMN_UUID_UUID_2);
			}

			String sql = sb.toString();

			Session session = null;

			try {
				session = openSession();

				Query query = session.createQuery(sql);

				QueryPos queryPos = QueryPos.getInstance(query);

				if (bindUuid) {
					queryPos.add(uuid);
				}

				count = (Long)query.uniqueResult();

				finderCache.putResult(finderPath, finderArgs, count);
			}
			catch (Exception exception) {
				finderCache.removeResult(finderPath, finderArgs);

				throw processException(exception);
			}
			finally {
				closeSession(session);
			}
		}

		return count.intValue();
	}

	private static final String _FINDER_COLUMN_UUID_UUID_2 =
		"ospCluster.uuid = ?";

	private static final String _FINDER_COLUMN_UUID_UUID_3 =
		"(ospCluster.uuid IS NULL OR ospCluster.uuid = '')";

	private FinderPath _finderPathFetchByUUID_G;
	private FinderPath _finderPathCountByUUID_G;

	/**
	 * Returns the osp cluster where uuid = &#63; and groupId = &#63; or throws a <code>NoSuchOSPClusterException</code> if it could not be found.
	 *
	 * @param uuid the uuid
	 * @param groupId the group ID
	 * @return the matching osp cluster
	 * @throws NoSuchOSPClusterException if a matching osp cluster could not be found
	 */
	@Override
	public OSPCluster findByUUID_G(String uuid, long groupId)
		throws NoSuchOSPClusterException {

		OSPCluster ospCluster = fetchByUUID_G(uuid, groupId);

		if (ospCluster == null) {
			StringBundler sb = new StringBundler(6);

			sb.append(_NO_SUCH_ENTITY_WITH_KEY);

			sb.append("uuid=");
			sb.append(uuid);

			sb.append(", groupId=");
			sb.append(groupId);

			sb.append("}");

			if (_log.isDebugEnabled()) {
				_log.debug(sb.toString());
			}

			throw new NoSuchOSPClusterException(sb.toString());
		}

		return ospCluster;
	}

	/**
	 * Returns the osp cluster where uuid = &#63; and groupId = &#63; or returns <code>null</code> if it could not be found. Uses the finder cache.
	 *
	 * @param uuid the uuid
	 * @param groupId the group ID
	 * @return the matching osp cluster, or <code>null</code> if a matching osp cluster could not be found
	 */
	@Override
	public OSPCluster fetchByUUID_G(String uuid, long groupId) {
		return fetchByUUID_G(uuid, groupId, true);
	}

	/**
	 * Returns the osp cluster where uuid = &#63; and groupId = &#63; or returns <code>null</code> if it could not be found, optionally using the finder cache.
	 *
	 * @param uuid the uuid
	 * @param groupId the group ID
	 * @param useFinderCache whether to use the finder cache
	 * @return the matching osp cluster, or <code>null</code> if a matching osp cluster could not be found
	 */
	@Override
	public OSPCluster fetchByUUID_G(
		String uuid, long groupId, boolean useFinderCache) {

		uuid = Objects.toString(uuid, "");

		Object[] finderArgs = null;

		if (useFinderCache) {
			finderArgs = new Object[] {uuid, groupId};
		}

		Object result = null;

		if (useFinderCache) {
			result = finderCache.getResult(
				_finderPathFetchByUUID_G, finderArgs, this);
		}

		if (result instanceof OSPCluster) {
			OSPCluster ospCluster = (OSPCluster)result;

			if (!Objects.equals(uuid, ospCluster.getUuid()) ||
				(groupId != ospCluster.getGroupId())) {

				result = null;
			}
		}

		if (result == null) {
			StringBundler sb = new StringBundler(4);

			sb.append(_SQL_SELECT_OSPCLUSTER_WHERE);

			boolean bindUuid = false;

			if (uuid.isEmpty()) {
				sb.append(_FINDER_COLUMN_UUID_G_UUID_3);
			}
			else {
				bindUuid = true;

				sb.append(_FINDER_COLUMN_UUID_G_UUID_2);
			}

			sb.append(_FINDER_COLUMN_UUID_G_GROUPID_2);

			String sql = sb.toString();

			Session session = null;

			try {
				session = openSession();

				Query query = session.createQuery(sql);

				QueryPos queryPos = QueryPos.getInstance(query);

				if (bindUuid) {
					queryPos.add(uuid);
				}

				queryPos.add(groupId);

				List<OSPCluster> list = query.list();

				if (list.isEmpty()) {
					if (useFinderCache) {
						finderCache.putResult(
							_finderPathFetchByUUID_G, finderArgs, list);
					}
				}
				else {
					OSPCluster ospCluster = list.get(0);

					result = ospCluster;

					cacheResult(ospCluster);
				}
			}
			catch (Exception exception) {
				if (useFinderCache) {
					finderCache.removeResult(
						_finderPathFetchByUUID_G, finderArgs);
				}

				throw processException(exception);
			}
			finally {
				closeSession(session);
			}
		}

		if (result instanceof List<?>) {
			return null;
		}
		else {
			return (OSPCluster)result;
		}
	}

	/**
	 * Removes the osp cluster where uuid = &#63; and groupId = &#63; from the database.
	 *
	 * @param uuid the uuid
	 * @param groupId the group ID
	 * @return the osp cluster that was removed
	 */
	@Override
	public OSPCluster removeByUUID_G(String uuid, long groupId)
		throws NoSuchOSPClusterException {

		OSPCluster ospCluster = findByUUID_G(uuid, groupId);

		return remove(ospCluster);
	}

	/**
	 * Returns the number of osp clusters where uuid = &#63; and groupId = &#63;.
	 *
	 * @param uuid the uuid
	 * @param groupId the group ID
	 * @return the number of matching osp clusters
	 */
	@Override
	public int countByUUID_G(String uuid, long groupId) {
		uuid = Objects.toString(uuid, "");

		FinderPath finderPath = _finderPathCountByUUID_G;

		Object[] finderArgs = new Object[] {uuid, groupId};

		Long count = (Long)finderCache.getResult(finderPath, finderArgs, this);

		if (count == null) {
			StringBundler sb = new StringBundler(3);

			sb.append(_SQL_COUNT_OSPCLUSTER_WHERE);

			boolean bindUuid = false;

			if (uuid.isEmpty()) {
				sb.append(_FINDER_COLUMN_UUID_G_UUID_3);
			}
			else {
				bindUuid = true;

				sb.append(_FINDER_COLUMN_UUID_G_UUID_2);
			}

			sb.append(_FINDER_COLUMN_UUID_G_GROUPID_2);

			String sql = sb.toString();

			Session session = null;

			try {
				session = openSession();

				Query query = session.createQuery(sql);

				QueryPos queryPos = QueryPos.getInstance(query);

				if (bindUuid) {
					queryPos.add(uuid);
				}

				queryPos.add(groupId);

				count = (Long)query.uniqueResult();

				finderCache.putResult(finderPath, finderArgs, count);
			}
			catch (Exception exception) {
				finderCache.removeResult(finderPath, finderArgs);

				throw processException(exception);
			}
			finally {
				closeSession(session);
			}
		}

		return count.intValue();
	}

	private static final String _FINDER_COLUMN_UUID_G_UUID_2 =
		"ospCluster.uuid = ? AND ";

	private static final String _FINDER_COLUMN_UUID_G_UUID_3 =
		"(ospCluster.uuid IS NULL OR ospCluster.uuid = '') AND ";

	private static final String _FINDER_COLUMN_UUID_G_GROUPID_2 =
		"ospCluster.groupId = ?";

	private FinderPath _finderPathWithPaginationFindByUuid_C;
	private FinderPath _finderPathWithoutPaginationFindByUuid_C;
	private FinderPath _finderPathCountByUuid_C;

	/**
	 * Returns all the osp clusters where uuid = &#63; and companyId = &#63;.
	 *
	 * @param uuid the uuid
	 * @param companyId the company ID
	 * @return the matching osp clusters
	 */
	@Override
	public List<OSPCluster> findByUuid_C(String uuid, long companyId) {
		return findByUuid_C(
			uuid, companyId, QueryUtil.ALL_POS, QueryUtil.ALL_POS, null);
	}

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
	@Override
	public List<OSPCluster> findByUuid_C(
		String uuid, long companyId, int start, int end) {

		return findByUuid_C(uuid, companyId, start, end, null);
	}

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
	@Override
	public List<OSPCluster> findByUuid_C(
		String uuid, long companyId, int start, int end,
		OrderByComparator<OSPCluster> orderByComparator) {

		return findByUuid_C(
			uuid, companyId, start, end, orderByComparator, true);
	}

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
	@Override
	public List<OSPCluster> findByUuid_C(
		String uuid, long companyId, int start, int end,
		OrderByComparator<OSPCluster> orderByComparator,
		boolean useFinderCache) {

		uuid = Objects.toString(uuid, "");

		FinderPath finderPath = null;
		Object[] finderArgs = null;

		if ((start == QueryUtil.ALL_POS) && (end == QueryUtil.ALL_POS) &&
			(orderByComparator == null)) {

			if (useFinderCache) {
				finderPath = _finderPathWithoutPaginationFindByUuid_C;
				finderArgs = new Object[] {uuid, companyId};
			}
		}
		else if (useFinderCache) {
			finderPath = _finderPathWithPaginationFindByUuid_C;
			finderArgs = new Object[] {
				uuid, companyId, start, end, orderByComparator
			};
		}

		List<OSPCluster> list = null;

		if (useFinderCache) {
			list = (List<OSPCluster>)finderCache.getResult(
				finderPath, finderArgs, this);

			if ((list != null) && !list.isEmpty()) {
				for (OSPCluster ospCluster : list) {
					if (!uuid.equals(ospCluster.getUuid()) ||
						(companyId != ospCluster.getCompanyId())) {

						list = null;

						break;
					}
				}
			}
		}

		if (list == null) {
			StringBundler sb = null;

			if (orderByComparator != null) {
				sb = new StringBundler(
					4 + (orderByComparator.getOrderByFields().length * 2));
			}
			else {
				sb = new StringBundler(4);
			}

			sb.append(_SQL_SELECT_OSPCLUSTER_WHERE);

			boolean bindUuid = false;

			if (uuid.isEmpty()) {
				sb.append(_FINDER_COLUMN_UUID_C_UUID_3);
			}
			else {
				bindUuid = true;

				sb.append(_FINDER_COLUMN_UUID_C_UUID_2);
			}

			sb.append(_FINDER_COLUMN_UUID_C_COMPANYID_2);

			if (orderByComparator != null) {
				appendOrderByComparator(
					sb, _ORDER_BY_ENTITY_ALIAS, orderByComparator);
			}
			else {
				sb.append(OSPClusterModelImpl.ORDER_BY_JPQL);
			}

			String sql = sb.toString();

			Session session = null;

			try {
				session = openSession();

				Query query = session.createQuery(sql);

				QueryPos queryPos = QueryPos.getInstance(query);

				if (bindUuid) {
					queryPos.add(uuid);
				}

				queryPos.add(companyId);

				list = (List<OSPCluster>)QueryUtil.list(
					query, getDialect(), start, end);

				cacheResult(list);

				if (useFinderCache) {
					finderCache.putResult(finderPath, finderArgs, list);
				}
			}
			catch (Exception exception) {
				if (useFinderCache) {
					finderCache.removeResult(finderPath, finderArgs);
				}

				throw processException(exception);
			}
			finally {
				closeSession(session);
			}
		}

		return list;
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
	@Override
	public OSPCluster findByUuid_C_First(
			String uuid, long companyId,
			OrderByComparator<OSPCluster> orderByComparator)
		throws NoSuchOSPClusterException {

		OSPCluster ospCluster = fetchByUuid_C_First(
			uuid, companyId, orderByComparator);

		if (ospCluster != null) {
			return ospCluster;
		}

		StringBundler sb = new StringBundler(6);

		sb.append(_NO_SUCH_ENTITY_WITH_KEY);

		sb.append("uuid=");
		sb.append(uuid);

		sb.append(", companyId=");
		sb.append(companyId);

		sb.append("}");

		throw new NoSuchOSPClusterException(sb.toString());
	}

	/**
	 * Returns the first osp cluster in the ordered set where uuid = &#63; and companyId = &#63;.
	 *
	 * @param uuid the uuid
	 * @param companyId the company ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching osp cluster, or <code>null</code> if a matching osp cluster could not be found
	 */
	@Override
	public OSPCluster fetchByUuid_C_First(
		String uuid, long companyId,
		OrderByComparator<OSPCluster> orderByComparator) {

		List<OSPCluster> list = findByUuid_C(
			uuid, companyId, 0, 1, orderByComparator);

		if (!list.isEmpty()) {
			return list.get(0);
		}

		return null;
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
	@Override
	public OSPCluster findByUuid_C_Last(
			String uuid, long companyId,
			OrderByComparator<OSPCluster> orderByComparator)
		throws NoSuchOSPClusterException {

		OSPCluster ospCluster = fetchByUuid_C_Last(
			uuid, companyId, orderByComparator);

		if (ospCluster != null) {
			return ospCluster;
		}

		StringBundler sb = new StringBundler(6);

		sb.append(_NO_SUCH_ENTITY_WITH_KEY);

		sb.append("uuid=");
		sb.append(uuid);

		sb.append(", companyId=");
		sb.append(companyId);

		sb.append("}");

		throw new NoSuchOSPClusterException(sb.toString());
	}

	/**
	 * Returns the last osp cluster in the ordered set where uuid = &#63; and companyId = &#63;.
	 *
	 * @param uuid the uuid
	 * @param companyId the company ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching osp cluster, or <code>null</code> if a matching osp cluster could not be found
	 */
	@Override
	public OSPCluster fetchByUuid_C_Last(
		String uuid, long companyId,
		OrderByComparator<OSPCluster> orderByComparator) {

		int count = countByUuid_C(uuid, companyId);

		if (count == 0) {
			return null;
		}

		List<OSPCluster> list = findByUuid_C(
			uuid, companyId, count - 1, count, orderByComparator);

		if (!list.isEmpty()) {
			return list.get(0);
		}

		return null;
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
	@Override
	public OSPCluster[] findByUuid_C_PrevAndNext(
			long clusterId, String uuid, long companyId,
			OrderByComparator<OSPCluster> orderByComparator)
		throws NoSuchOSPClusterException {

		uuid = Objects.toString(uuid, "");

		OSPCluster ospCluster = findByPrimaryKey(clusterId);

		Session session = null;

		try {
			session = openSession();

			OSPCluster[] array = new OSPClusterImpl[3];

			array[0] = getByUuid_C_PrevAndNext(
				session, ospCluster, uuid, companyId, orderByComparator, true);

			array[1] = ospCluster;

			array[2] = getByUuid_C_PrevAndNext(
				session, ospCluster, uuid, companyId, orderByComparator, false);

			return array;
		}
		catch (Exception exception) {
			throw processException(exception);
		}
		finally {
			closeSession(session);
		}
	}

	protected OSPCluster getByUuid_C_PrevAndNext(
		Session session, OSPCluster ospCluster, String uuid, long companyId,
		OrderByComparator<OSPCluster> orderByComparator, boolean previous) {

		StringBundler sb = null;

		if (orderByComparator != null) {
			sb = new StringBundler(
				5 + (orderByComparator.getOrderByConditionFields().length * 3) +
					(orderByComparator.getOrderByFields().length * 3));
		}
		else {
			sb = new StringBundler(4);
		}

		sb.append(_SQL_SELECT_OSPCLUSTER_WHERE);

		boolean bindUuid = false;

		if (uuid.isEmpty()) {
			sb.append(_FINDER_COLUMN_UUID_C_UUID_3);
		}
		else {
			bindUuid = true;

			sb.append(_FINDER_COLUMN_UUID_C_UUID_2);
		}

		sb.append(_FINDER_COLUMN_UUID_C_COMPANYID_2);

		if (orderByComparator != null) {
			String[] orderByConditionFields =
				orderByComparator.getOrderByConditionFields();

			if (orderByConditionFields.length > 0) {
				sb.append(WHERE_AND);
			}

			for (int i = 0; i < orderByConditionFields.length; i++) {
				sb.append(_ORDER_BY_ENTITY_ALIAS);
				sb.append(orderByConditionFields[i]);

				if ((i + 1) < orderByConditionFields.length) {
					if (orderByComparator.isAscending() ^ previous) {
						sb.append(WHERE_GREATER_THAN_HAS_NEXT);
					}
					else {
						sb.append(WHERE_LESSER_THAN_HAS_NEXT);
					}
				}
				else {
					if (orderByComparator.isAscending() ^ previous) {
						sb.append(WHERE_GREATER_THAN);
					}
					else {
						sb.append(WHERE_LESSER_THAN);
					}
				}
			}

			sb.append(ORDER_BY_CLAUSE);

			String[] orderByFields = orderByComparator.getOrderByFields();

			for (int i = 0; i < orderByFields.length; i++) {
				sb.append(_ORDER_BY_ENTITY_ALIAS);
				sb.append(orderByFields[i]);

				if ((i + 1) < orderByFields.length) {
					if (orderByComparator.isAscending() ^ previous) {
						sb.append(ORDER_BY_ASC_HAS_NEXT);
					}
					else {
						sb.append(ORDER_BY_DESC_HAS_NEXT);
					}
				}
				else {
					if (orderByComparator.isAscending() ^ previous) {
						sb.append(ORDER_BY_ASC);
					}
					else {
						sb.append(ORDER_BY_DESC);
					}
				}
			}
		}
		else {
			sb.append(OSPClusterModelImpl.ORDER_BY_JPQL);
		}

		String sql = sb.toString();

		Query query = session.createQuery(sql);

		query.setFirstResult(0);
		query.setMaxResults(2);

		QueryPos queryPos = QueryPos.getInstance(query);

		if (bindUuid) {
			queryPos.add(uuid);
		}

		queryPos.add(companyId);

		if (orderByComparator != null) {
			for (Object orderByConditionValue :
					orderByComparator.getOrderByConditionValues(ospCluster)) {

				queryPos.add(orderByConditionValue);
			}
		}

		List<OSPCluster> list = query.list();

		if (list.size() == 2) {
			return list.get(1);
		}
		else {
			return null;
		}
	}

	/**
	 * Removes all the osp clusters where uuid = &#63; and companyId = &#63; from the database.
	 *
	 * @param uuid the uuid
	 * @param companyId the company ID
	 */
	@Override
	public void removeByUuid_C(String uuid, long companyId) {
		for (OSPCluster ospCluster :
				findByUuid_C(
					uuid, companyId, QueryUtil.ALL_POS, QueryUtil.ALL_POS,
					null)) {

			remove(ospCluster);
		}
	}

	/**
	 * Returns the number of osp clusters where uuid = &#63; and companyId = &#63;.
	 *
	 * @param uuid the uuid
	 * @param companyId the company ID
	 * @return the number of matching osp clusters
	 */
	@Override
	public int countByUuid_C(String uuid, long companyId) {
		uuid = Objects.toString(uuid, "");

		FinderPath finderPath = _finderPathCountByUuid_C;

		Object[] finderArgs = new Object[] {uuid, companyId};

		Long count = (Long)finderCache.getResult(finderPath, finderArgs, this);

		if (count == null) {
			StringBundler sb = new StringBundler(3);

			sb.append(_SQL_COUNT_OSPCLUSTER_WHERE);

			boolean bindUuid = false;

			if (uuid.isEmpty()) {
				sb.append(_FINDER_COLUMN_UUID_C_UUID_3);
			}
			else {
				bindUuid = true;

				sb.append(_FINDER_COLUMN_UUID_C_UUID_2);
			}

			sb.append(_FINDER_COLUMN_UUID_C_COMPANYID_2);

			String sql = sb.toString();

			Session session = null;

			try {
				session = openSession();

				Query query = session.createQuery(sql);

				QueryPos queryPos = QueryPos.getInstance(query);

				if (bindUuid) {
					queryPos.add(uuid);
				}

				queryPos.add(companyId);

				count = (Long)query.uniqueResult();

				finderCache.putResult(finderPath, finderArgs, count);
			}
			catch (Exception exception) {
				finderCache.removeResult(finderPath, finderArgs);

				throw processException(exception);
			}
			finally {
				closeSession(session);
			}
		}

		return count.intValue();
	}

	private static final String _FINDER_COLUMN_UUID_C_UUID_2 =
		"ospCluster.uuid = ? AND ";

	private static final String _FINDER_COLUMN_UUID_C_UUID_3 =
		"(ospCluster.uuid IS NULL OR ospCluster.uuid = '') AND ";

	private static final String _FINDER_COLUMN_UUID_C_COMPANYID_2 =
		"ospCluster.companyId = ?";

	private FinderPath _finderPathWithPaginationFindByGroupId;
	private FinderPath _finderPathWithoutPaginationFindByGroupId;
	private FinderPath _finderPathCountByGroupId;

	/**
	 * Returns all the osp clusters where groupId = &#63;.
	 *
	 * @param groupId the group ID
	 * @return the matching osp clusters
	 */
	@Override
	public List<OSPCluster> findByGroupId(long groupId) {
		return findByGroupId(
			groupId, QueryUtil.ALL_POS, QueryUtil.ALL_POS, null);
	}

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
	@Override
	public List<OSPCluster> findByGroupId(long groupId, int start, int end) {
		return findByGroupId(groupId, start, end, null);
	}

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
	@Override
	public List<OSPCluster> findByGroupId(
		long groupId, int start, int end,
		OrderByComparator<OSPCluster> orderByComparator) {

		return findByGroupId(groupId, start, end, orderByComparator, true);
	}

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
	@Override
	public List<OSPCluster> findByGroupId(
		long groupId, int start, int end,
		OrderByComparator<OSPCluster> orderByComparator,
		boolean useFinderCache) {

		FinderPath finderPath = null;
		Object[] finderArgs = null;

		if ((start == QueryUtil.ALL_POS) && (end == QueryUtil.ALL_POS) &&
			(orderByComparator == null)) {

			if (useFinderCache) {
				finderPath = _finderPathWithoutPaginationFindByGroupId;
				finderArgs = new Object[] {groupId};
			}
		}
		else if (useFinderCache) {
			finderPath = _finderPathWithPaginationFindByGroupId;
			finderArgs = new Object[] {groupId, start, end, orderByComparator};
		}

		List<OSPCluster> list = null;

		if (useFinderCache) {
			list = (List<OSPCluster>)finderCache.getResult(
				finderPath, finderArgs, this);

			if ((list != null) && !list.isEmpty()) {
				for (OSPCluster ospCluster : list) {
					if (groupId != ospCluster.getGroupId()) {
						list = null;

						break;
					}
				}
			}
		}

		if (list == null) {
			StringBundler sb = null;

			if (orderByComparator != null) {
				sb = new StringBundler(
					3 + (orderByComparator.getOrderByFields().length * 2));
			}
			else {
				sb = new StringBundler(3);
			}

			sb.append(_SQL_SELECT_OSPCLUSTER_WHERE);

			sb.append(_FINDER_COLUMN_GROUPID_GROUPID_2);

			if (orderByComparator != null) {
				appendOrderByComparator(
					sb, _ORDER_BY_ENTITY_ALIAS, orderByComparator);
			}
			else {
				sb.append(OSPClusterModelImpl.ORDER_BY_JPQL);
			}

			String sql = sb.toString();

			Session session = null;

			try {
				session = openSession();

				Query query = session.createQuery(sql);

				QueryPos queryPos = QueryPos.getInstance(query);

				queryPos.add(groupId);

				list = (List<OSPCluster>)QueryUtil.list(
					query, getDialect(), start, end);

				cacheResult(list);

				if (useFinderCache) {
					finderCache.putResult(finderPath, finderArgs, list);
				}
			}
			catch (Exception exception) {
				if (useFinderCache) {
					finderCache.removeResult(finderPath, finderArgs);
				}

				throw processException(exception);
			}
			finally {
				closeSession(session);
			}
		}

		return list;
	}

	/**
	 * Returns the first osp cluster in the ordered set where groupId = &#63;.
	 *
	 * @param groupId the group ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching osp cluster
	 * @throws NoSuchOSPClusterException if a matching osp cluster could not be found
	 */
	@Override
	public OSPCluster findByGroupId_First(
			long groupId, OrderByComparator<OSPCluster> orderByComparator)
		throws NoSuchOSPClusterException {

		OSPCluster ospCluster = fetchByGroupId_First(
			groupId, orderByComparator);

		if (ospCluster != null) {
			return ospCluster;
		}

		StringBundler sb = new StringBundler(4);

		sb.append(_NO_SUCH_ENTITY_WITH_KEY);

		sb.append("groupId=");
		sb.append(groupId);

		sb.append("}");

		throw new NoSuchOSPClusterException(sb.toString());
	}

	/**
	 * Returns the first osp cluster in the ordered set where groupId = &#63;.
	 *
	 * @param groupId the group ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching osp cluster, or <code>null</code> if a matching osp cluster could not be found
	 */
	@Override
	public OSPCluster fetchByGroupId_First(
		long groupId, OrderByComparator<OSPCluster> orderByComparator) {

		List<OSPCluster> list = findByGroupId(groupId, 0, 1, orderByComparator);

		if (!list.isEmpty()) {
			return list.get(0);
		}

		return null;
	}

	/**
	 * Returns the last osp cluster in the ordered set where groupId = &#63;.
	 *
	 * @param groupId the group ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching osp cluster
	 * @throws NoSuchOSPClusterException if a matching osp cluster could not be found
	 */
	@Override
	public OSPCluster findByGroupId_Last(
			long groupId, OrderByComparator<OSPCluster> orderByComparator)
		throws NoSuchOSPClusterException {

		OSPCluster ospCluster = fetchByGroupId_Last(groupId, orderByComparator);

		if (ospCluster != null) {
			return ospCluster;
		}

		StringBundler sb = new StringBundler(4);

		sb.append(_NO_SUCH_ENTITY_WITH_KEY);

		sb.append("groupId=");
		sb.append(groupId);

		sb.append("}");

		throw new NoSuchOSPClusterException(sb.toString());
	}

	/**
	 * Returns the last osp cluster in the ordered set where groupId = &#63;.
	 *
	 * @param groupId the group ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching osp cluster, or <code>null</code> if a matching osp cluster could not be found
	 */
	@Override
	public OSPCluster fetchByGroupId_Last(
		long groupId, OrderByComparator<OSPCluster> orderByComparator) {

		int count = countByGroupId(groupId);

		if (count == 0) {
			return null;
		}

		List<OSPCluster> list = findByGroupId(
			groupId, count - 1, count, orderByComparator);

		if (!list.isEmpty()) {
			return list.get(0);
		}

		return null;
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
	@Override
	public OSPCluster[] findByGroupId_PrevAndNext(
			long clusterId, long groupId,
			OrderByComparator<OSPCluster> orderByComparator)
		throws NoSuchOSPClusterException {

		OSPCluster ospCluster = findByPrimaryKey(clusterId);

		Session session = null;

		try {
			session = openSession();

			OSPCluster[] array = new OSPClusterImpl[3];

			array[0] = getByGroupId_PrevAndNext(
				session, ospCluster, groupId, orderByComparator, true);

			array[1] = ospCluster;

			array[2] = getByGroupId_PrevAndNext(
				session, ospCluster, groupId, orderByComparator, false);

			return array;
		}
		catch (Exception exception) {
			throw processException(exception);
		}
		finally {
			closeSession(session);
		}
	}

	protected OSPCluster getByGroupId_PrevAndNext(
		Session session, OSPCluster ospCluster, long groupId,
		OrderByComparator<OSPCluster> orderByComparator, boolean previous) {

		StringBundler sb = null;

		if (orderByComparator != null) {
			sb = new StringBundler(
				4 + (orderByComparator.getOrderByConditionFields().length * 3) +
					(orderByComparator.getOrderByFields().length * 3));
		}
		else {
			sb = new StringBundler(3);
		}

		sb.append(_SQL_SELECT_OSPCLUSTER_WHERE);

		sb.append(_FINDER_COLUMN_GROUPID_GROUPID_2);

		if (orderByComparator != null) {
			String[] orderByConditionFields =
				orderByComparator.getOrderByConditionFields();

			if (orderByConditionFields.length > 0) {
				sb.append(WHERE_AND);
			}

			for (int i = 0; i < orderByConditionFields.length; i++) {
				sb.append(_ORDER_BY_ENTITY_ALIAS);
				sb.append(orderByConditionFields[i]);

				if ((i + 1) < orderByConditionFields.length) {
					if (orderByComparator.isAscending() ^ previous) {
						sb.append(WHERE_GREATER_THAN_HAS_NEXT);
					}
					else {
						sb.append(WHERE_LESSER_THAN_HAS_NEXT);
					}
				}
				else {
					if (orderByComparator.isAscending() ^ previous) {
						sb.append(WHERE_GREATER_THAN);
					}
					else {
						sb.append(WHERE_LESSER_THAN);
					}
				}
			}

			sb.append(ORDER_BY_CLAUSE);

			String[] orderByFields = orderByComparator.getOrderByFields();

			for (int i = 0; i < orderByFields.length; i++) {
				sb.append(_ORDER_BY_ENTITY_ALIAS);
				sb.append(orderByFields[i]);

				if ((i + 1) < orderByFields.length) {
					if (orderByComparator.isAscending() ^ previous) {
						sb.append(ORDER_BY_ASC_HAS_NEXT);
					}
					else {
						sb.append(ORDER_BY_DESC_HAS_NEXT);
					}
				}
				else {
					if (orderByComparator.isAscending() ^ previous) {
						sb.append(ORDER_BY_ASC);
					}
					else {
						sb.append(ORDER_BY_DESC);
					}
				}
			}
		}
		else {
			sb.append(OSPClusterModelImpl.ORDER_BY_JPQL);
		}

		String sql = sb.toString();

		Query query = session.createQuery(sql);

		query.setFirstResult(0);
		query.setMaxResults(2);

		QueryPos queryPos = QueryPos.getInstance(query);

		queryPos.add(groupId);

		if (orderByComparator != null) {
			for (Object orderByConditionValue :
					orderByComparator.getOrderByConditionValues(ospCluster)) {

				queryPos.add(orderByConditionValue);
			}
		}

		List<OSPCluster> list = query.list();

		if (list.size() == 2) {
			return list.get(1);
		}
		else {
			return null;
		}
	}

	/**
	 * Removes all the osp clusters where groupId = &#63; from the database.
	 *
	 * @param groupId the group ID
	 */
	@Override
	public void removeByGroupId(long groupId) {
		for (OSPCluster ospCluster :
				findByGroupId(
					groupId, QueryUtil.ALL_POS, QueryUtil.ALL_POS, null)) {

			remove(ospCluster);
		}
	}

	/**
	 * Returns the number of osp clusters where groupId = &#63;.
	 *
	 * @param groupId the group ID
	 * @return the number of matching osp clusters
	 */
	@Override
	public int countByGroupId(long groupId) {
		FinderPath finderPath = _finderPathCountByGroupId;

		Object[] finderArgs = new Object[] {groupId};

		Long count = (Long)finderCache.getResult(finderPath, finderArgs, this);

		if (count == null) {
			StringBundler sb = new StringBundler(2);

			sb.append(_SQL_COUNT_OSPCLUSTER_WHERE);

			sb.append(_FINDER_COLUMN_GROUPID_GROUPID_2);

			String sql = sb.toString();

			Session session = null;

			try {
				session = openSession();

				Query query = session.createQuery(sql);

				QueryPos queryPos = QueryPos.getInstance(query);

				queryPos.add(groupId);

				count = (Long)query.uniqueResult();

				finderCache.putResult(finderPath, finderArgs, count);
			}
			catch (Exception exception) {
				finderCache.removeResult(finderPath, finderArgs);

				throw processException(exception);
			}
			finally {
				closeSession(session);
			}
		}

		return count.intValue();
	}

	private static final String _FINDER_COLUMN_GROUPID_GROUPID_2 =
		"ospCluster.groupId = ?";

	private FinderPath _finderPathWithPaginationFindByStatus;
	private FinderPath _finderPathWithoutPaginationFindByStatus;
	private FinderPath _finderPathCountByStatus;

	/**
	 * Returns all the osp clusters where status = &#63;.
	 *
	 * @param status the status
	 * @return the matching osp clusters
	 */
	@Override
	public List<OSPCluster> findByStatus(int status) {
		return findByStatus(status, QueryUtil.ALL_POS, QueryUtil.ALL_POS, null);
	}

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
	@Override
	public List<OSPCluster> findByStatus(int status, int start, int end) {
		return findByStatus(status, start, end, null);
	}

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
	@Override
	public List<OSPCluster> findByStatus(
		int status, int start, int end,
		OrderByComparator<OSPCluster> orderByComparator) {

		return findByStatus(status, start, end, orderByComparator, true);
	}

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
	@Override
	public List<OSPCluster> findByStatus(
		int status, int start, int end,
		OrderByComparator<OSPCluster> orderByComparator,
		boolean useFinderCache) {

		FinderPath finderPath = null;
		Object[] finderArgs = null;

		if ((start == QueryUtil.ALL_POS) && (end == QueryUtil.ALL_POS) &&
			(orderByComparator == null)) {

			if (useFinderCache) {
				finderPath = _finderPathWithoutPaginationFindByStatus;
				finderArgs = new Object[] {status};
			}
		}
		else if (useFinderCache) {
			finderPath = _finderPathWithPaginationFindByStatus;
			finderArgs = new Object[] {status, start, end, orderByComparator};
		}

		List<OSPCluster> list = null;

		if (useFinderCache) {
			list = (List<OSPCluster>)finderCache.getResult(
				finderPath, finderArgs, this);

			if ((list != null) && !list.isEmpty()) {
				for (OSPCluster ospCluster : list) {
					if (status != ospCluster.getStatus()) {
						list = null;

						break;
					}
				}
			}
		}

		if (list == null) {
			StringBundler sb = null;

			if (orderByComparator != null) {
				sb = new StringBundler(
					3 + (orderByComparator.getOrderByFields().length * 2));
			}
			else {
				sb = new StringBundler(3);
			}

			sb.append(_SQL_SELECT_OSPCLUSTER_WHERE);

			sb.append(_FINDER_COLUMN_STATUS_STATUS_2);

			if (orderByComparator != null) {
				appendOrderByComparator(
					sb, _ORDER_BY_ENTITY_ALIAS, orderByComparator);
			}
			else {
				sb.append(OSPClusterModelImpl.ORDER_BY_JPQL);
			}

			String sql = sb.toString();

			Session session = null;

			try {
				session = openSession();

				Query query = session.createQuery(sql);

				QueryPos queryPos = QueryPos.getInstance(query);

				queryPos.add(status);

				list = (List<OSPCluster>)QueryUtil.list(
					query, getDialect(), start, end);

				cacheResult(list);

				if (useFinderCache) {
					finderCache.putResult(finderPath, finderArgs, list);
				}
			}
			catch (Exception exception) {
				if (useFinderCache) {
					finderCache.removeResult(finderPath, finderArgs);
				}

				throw processException(exception);
			}
			finally {
				closeSession(session);
			}
		}

		return list;
	}

	/**
	 * Returns the first osp cluster in the ordered set where status = &#63;.
	 *
	 * @param status the status
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching osp cluster
	 * @throws NoSuchOSPClusterException if a matching osp cluster could not be found
	 */
	@Override
	public OSPCluster findByStatus_First(
			int status, OrderByComparator<OSPCluster> orderByComparator)
		throws NoSuchOSPClusterException {

		OSPCluster ospCluster = fetchByStatus_First(status, orderByComparator);

		if (ospCluster != null) {
			return ospCluster;
		}

		StringBundler sb = new StringBundler(4);

		sb.append(_NO_SUCH_ENTITY_WITH_KEY);

		sb.append("status=");
		sb.append(status);

		sb.append("}");

		throw new NoSuchOSPClusterException(sb.toString());
	}

	/**
	 * Returns the first osp cluster in the ordered set where status = &#63;.
	 *
	 * @param status the status
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching osp cluster, or <code>null</code> if a matching osp cluster could not be found
	 */
	@Override
	public OSPCluster fetchByStatus_First(
		int status, OrderByComparator<OSPCluster> orderByComparator) {

		List<OSPCluster> list = findByStatus(status, 0, 1, orderByComparator);

		if (!list.isEmpty()) {
			return list.get(0);
		}

		return null;
	}

	/**
	 * Returns the last osp cluster in the ordered set where status = &#63;.
	 *
	 * @param status the status
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching osp cluster
	 * @throws NoSuchOSPClusterException if a matching osp cluster could not be found
	 */
	@Override
	public OSPCluster findByStatus_Last(
			int status, OrderByComparator<OSPCluster> orderByComparator)
		throws NoSuchOSPClusterException {

		OSPCluster ospCluster = fetchByStatus_Last(status, orderByComparator);

		if (ospCluster != null) {
			return ospCluster;
		}

		StringBundler sb = new StringBundler(4);

		sb.append(_NO_SUCH_ENTITY_WITH_KEY);

		sb.append("status=");
		sb.append(status);

		sb.append("}");

		throw new NoSuchOSPClusterException(sb.toString());
	}

	/**
	 * Returns the last osp cluster in the ordered set where status = &#63;.
	 *
	 * @param status the status
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching osp cluster, or <code>null</code> if a matching osp cluster could not be found
	 */
	@Override
	public OSPCluster fetchByStatus_Last(
		int status, OrderByComparator<OSPCluster> orderByComparator) {

		int count = countByStatus(status);

		if (count == 0) {
			return null;
		}

		List<OSPCluster> list = findByStatus(
			status, count - 1, count, orderByComparator);

		if (!list.isEmpty()) {
			return list.get(0);
		}

		return null;
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
	@Override
	public OSPCluster[] findByStatus_PrevAndNext(
			long clusterId, int status,
			OrderByComparator<OSPCluster> orderByComparator)
		throws NoSuchOSPClusterException {

		OSPCluster ospCluster = findByPrimaryKey(clusterId);

		Session session = null;

		try {
			session = openSession();

			OSPCluster[] array = new OSPClusterImpl[3];

			array[0] = getByStatus_PrevAndNext(
				session, ospCluster, status, orderByComparator, true);

			array[1] = ospCluster;

			array[2] = getByStatus_PrevAndNext(
				session, ospCluster, status, orderByComparator, false);

			return array;
		}
		catch (Exception exception) {
			throw processException(exception);
		}
		finally {
			closeSession(session);
		}
	}

	protected OSPCluster getByStatus_PrevAndNext(
		Session session, OSPCluster ospCluster, int status,
		OrderByComparator<OSPCluster> orderByComparator, boolean previous) {

		StringBundler sb = null;

		if (orderByComparator != null) {
			sb = new StringBundler(
				4 + (orderByComparator.getOrderByConditionFields().length * 3) +
					(orderByComparator.getOrderByFields().length * 3));
		}
		else {
			sb = new StringBundler(3);
		}

		sb.append(_SQL_SELECT_OSPCLUSTER_WHERE);

		sb.append(_FINDER_COLUMN_STATUS_STATUS_2);

		if (orderByComparator != null) {
			String[] orderByConditionFields =
				orderByComparator.getOrderByConditionFields();

			if (orderByConditionFields.length > 0) {
				sb.append(WHERE_AND);
			}

			for (int i = 0; i < orderByConditionFields.length; i++) {
				sb.append(_ORDER_BY_ENTITY_ALIAS);
				sb.append(orderByConditionFields[i]);

				if ((i + 1) < orderByConditionFields.length) {
					if (orderByComparator.isAscending() ^ previous) {
						sb.append(WHERE_GREATER_THAN_HAS_NEXT);
					}
					else {
						sb.append(WHERE_LESSER_THAN_HAS_NEXT);
					}
				}
				else {
					if (orderByComparator.isAscending() ^ previous) {
						sb.append(WHERE_GREATER_THAN);
					}
					else {
						sb.append(WHERE_LESSER_THAN);
					}
				}
			}

			sb.append(ORDER_BY_CLAUSE);

			String[] orderByFields = orderByComparator.getOrderByFields();

			for (int i = 0; i < orderByFields.length; i++) {
				sb.append(_ORDER_BY_ENTITY_ALIAS);
				sb.append(orderByFields[i]);

				if ((i + 1) < orderByFields.length) {
					if (orderByComparator.isAscending() ^ previous) {
						sb.append(ORDER_BY_ASC_HAS_NEXT);
					}
					else {
						sb.append(ORDER_BY_DESC_HAS_NEXT);
					}
				}
				else {
					if (orderByComparator.isAscending() ^ previous) {
						sb.append(ORDER_BY_ASC);
					}
					else {
						sb.append(ORDER_BY_DESC);
					}
				}
			}
		}
		else {
			sb.append(OSPClusterModelImpl.ORDER_BY_JPQL);
		}

		String sql = sb.toString();

		Query query = session.createQuery(sql);

		query.setFirstResult(0);
		query.setMaxResults(2);

		QueryPos queryPos = QueryPos.getInstance(query);

		queryPos.add(status);

		if (orderByComparator != null) {
			for (Object orderByConditionValue :
					orderByComparator.getOrderByConditionValues(ospCluster)) {

				queryPos.add(orderByConditionValue);
			}
		}

		List<OSPCluster> list = query.list();

		if (list.size() == 2) {
			return list.get(1);
		}
		else {
			return null;
		}
	}

	/**
	 * Removes all the osp clusters where status = &#63; from the database.
	 *
	 * @param status the status
	 */
	@Override
	public void removeByStatus(int status) {
		for (OSPCluster ospCluster :
				findByStatus(
					status, QueryUtil.ALL_POS, QueryUtil.ALL_POS, null)) {

			remove(ospCluster);
		}
	}

	/**
	 * Returns the number of osp clusters where status = &#63;.
	 *
	 * @param status the status
	 * @return the number of matching osp clusters
	 */
	@Override
	public int countByStatus(int status) {
		FinderPath finderPath = _finderPathCountByStatus;

		Object[] finderArgs = new Object[] {status};

		Long count = (Long)finderCache.getResult(finderPath, finderArgs, this);

		if (count == null) {
			StringBundler sb = new StringBundler(2);

			sb.append(_SQL_COUNT_OSPCLUSTER_WHERE);

			sb.append(_FINDER_COLUMN_STATUS_STATUS_2);

			String sql = sb.toString();

			Session session = null;

			try {
				session = openSession();

				Query query = session.createQuery(sql);

				QueryPos queryPos = QueryPos.getInstance(query);

				queryPos.add(status);

				count = (Long)query.uniqueResult();

				finderCache.putResult(finderPath, finderArgs, count);
			}
			catch (Exception exception) {
				finderCache.removeResult(finderPath, finderArgs);

				throw processException(exception);
			}
			finally {
				closeSession(session);
			}
		}

		return count.intValue();
	}

	private static final String _FINDER_COLUMN_STATUS_STATUS_2 =
		"ospCluster.status = ?";

	private FinderPath _finderPathFetchByClusterName;
	private FinderPath _finderPathCountByClusterName;

	/**
	 * Returns the osp cluster where clusterName = &#63; or throws a <code>NoSuchOSPClusterException</code> if it could not be found.
	 *
	 * @param clusterName the cluster name
	 * @return the matching osp cluster
	 * @throws NoSuchOSPClusterException if a matching osp cluster could not be found
	 */
	@Override
	public OSPCluster findByClusterName(String clusterName)
		throws NoSuchOSPClusterException {

		OSPCluster ospCluster = fetchByClusterName(clusterName);

		if (ospCluster == null) {
			StringBundler sb = new StringBundler(4);

			sb.append(_NO_SUCH_ENTITY_WITH_KEY);

			sb.append("clusterName=");
			sb.append(clusterName);

			sb.append("}");

			if (_log.isDebugEnabled()) {
				_log.debug(sb.toString());
			}

			throw new NoSuchOSPClusterException(sb.toString());
		}

		return ospCluster;
	}

	/**
	 * Returns the osp cluster where clusterName = &#63; or returns <code>null</code> if it could not be found. Uses the finder cache.
	 *
	 * @param clusterName the cluster name
	 * @return the matching osp cluster, or <code>null</code> if a matching osp cluster could not be found
	 */
	@Override
	public OSPCluster fetchByClusterName(String clusterName) {
		return fetchByClusterName(clusterName, true);
	}

	/**
	 * Returns the osp cluster where clusterName = &#63; or returns <code>null</code> if it could not be found, optionally using the finder cache.
	 *
	 * @param clusterName the cluster name
	 * @param useFinderCache whether to use the finder cache
	 * @return the matching osp cluster, or <code>null</code> if a matching osp cluster could not be found
	 */
	@Override
	public OSPCluster fetchByClusterName(
		String clusterName, boolean useFinderCache) {

		clusterName = Objects.toString(clusterName, "");

		Object[] finderArgs = null;

		if (useFinderCache) {
			finderArgs = new Object[] {clusterName};
		}

		Object result = null;

		if (useFinderCache) {
			result = finderCache.getResult(
				_finderPathFetchByClusterName, finderArgs, this);
		}

		if (result instanceof OSPCluster) {
			OSPCluster ospCluster = (OSPCluster)result;

			if (!Objects.equals(clusterName, ospCluster.getClusterName())) {
				result = null;
			}
		}

		if (result == null) {
			StringBundler sb = new StringBundler(3);

			sb.append(_SQL_SELECT_OSPCLUSTER_WHERE);

			boolean bindClusterName = false;

			if (clusterName.isEmpty()) {
				sb.append(_FINDER_COLUMN_CLUSTERNAME_CLUSTERNAME_3);
			}
			else {
				bindClusterName = true;

				sb.append(_FINDER_COLUMN_CLUSTERNAME_CLUSTERNAME_2);
			}

			String sql = sb.toString();

			Session session = null;

			try {
				session = openSession();

				Query query = session.createQuery(sql);

				QueryPos queryPos = QueryPos.getInstance(query);

				if (bindClusterName) {
					queryPos.add(clusterName);
				}

				List<OSPCluster> list = query.list();

				if (list.isEmpty()) {
					if (useFinderCache) {
						finderCache.putResult(
							_finderPathFetchByClusterName, finderArgs, list);
					}
				}
				else {
					OSPCluster ospCluster = list.get(0);

					result = ospCluster;

					cacheResult(ospCluster);
				}
			}
			catch (Exception exception) {
				if (useFinderCache) {
					finderCache.removeResult(
						_finderPathFetchByClusterName, finderArgs);
				}

				throw processException(exception);
			}
			finally {
				closeSession(session);
			}
		}

		if (result instanceof List<?>) {
			return null;
		}
		else {
			return (OSPCluster)result;
		}
	}

	/**
	 * Removes the osp cluster where clusterName = &#63; from the database.
	 *
	 * @param clusterName the cluster name
	 * @return the osp cluster that was removed
	 */
	@Override
	public OSPCluster removeByClusterName(String clusterName)
		throws NoSuchOSPClusterException {

		OSPCluster ospCluster = findByClusterName(clusterName);

		return remove(ospCluster);
	}

	/**
	 * Returns the number of osp clusters where clusterName = &#63;.
	 *
	 * @param clusterName the cluster name
	 * @return the number of matching osp clusters
	 */
	@Override
	public int countByClusterName(String clusterName) {
		clusterName = Objects.toString(clusterName, "");

		FinderPath finderPath = _finderPathCountByClusterName;

		Object[] finderArgs = new Object[] {clusterName};

		Long count = (Long)finderCache.getResult(finderPath, finderArgs, this);

		if (count == null) {
			StringBundler sb = new StringBundler(2);

			sb.append(_SQL_COUNT_OSPCLUSTER_WHERE);

			boolean bindClusterName = false;

			if (clusterName.isEmpty()) {
				sb.append(_FINDER_COLUMN_CLUSTERNAME_CLUSTERNAME_3);
			}
			else {
				bindClusterName = true;

				sb.append(_FINDER_COLUMN_CLUSTERNAME_CLUSTERNAME_2);
			}

			String sql = sb.toString();

			Session session = null;

			try {
				session = openSession();

				Query query = session.createQuery(sql);

				QueryPos queryPos = QueryPos.getInstance(query);

				if (bindClusterName) {
					queryPos.add(clusterName);
				}

				count = (Long)query.uniqueResult();

				finderCache.putResult(finderPath, finderArgs, count);
			}
			catch (Exception exception) {
				finderCache.removeResult(finderPath, finderArgs);

				throw processException(exception);
			}
			finally {
				closeSession(session);
			}
		}

		return count.intValue();
	}

	private static final String _FINDER_COLUMN_CLUSTERNAME_CLUSTERNAME_2 =
		"ospCluster.clusterName = ?";

	private static final String _FINDER_COLUMN_CLUSTERNAME_CLUSTERNAME_3 =
		"(ospCluster.clusterName IS NULL OR ospCluster.clusterName = '')";

	private FinderPath _finderPathWithPaginationFindByOSName;
	private FinderPath _finderPathWithoutPaginationFindByOSName;
	private FinderPath _finderPathCountByOSName;

	/**
	 * Returns all the osp clusters where osName = &#63;.
	 *
	 * @param osName the os name
	 * @return the matching osp clusters
	 */
	@Override
	public List<OSPCluster> findByOSName(String osName) {
		return findByOSName(osName, QueryUtil.ALL_POS, QueryUtil.ALL_POS, null);
	}

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
	@Override
	public List<OSPCluster> findByOSName(String osName, int start, int end) {
		return findByOSName(osName, start, end, null);
	}

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
	@Override
	public List<OSPCluster> findByOSName(
		String osName, int start, int end,
		OrderByComparator<OSPCluster> orderByComparator) {

		return findByOSName(osName, start, end, orderByComparator, true);
	}

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
	@Override
	public List<OSPCluster> findByOSName(
		String osName, int start, int end,
		OrderByComparator<OSPCluster> orderByComparator,
		boolean useFinderCache) {

		osName = Objects.toString(osName, "");

		FinderPath finderPath = null;
		Object[] finderArgs = null;

		if ((start == QueryUtil.ALL_POS) && (end == QueryUtil.ALL_POS) &&
			(orderByComparator == null)) {

			if (useFinderCache) {
				finderPath = _finderPathWithoutPaginationFindByOSName;
				finderArgs = new Object[] {osName};
			}
		}
		else if (useFinderCache) {
			finderPath = _finderPathWithPaginationFindByOSName;
			finderArgs = new Object[] {osName, start, end, orderByComparator};
		}

		List<OSPCluster> list = null;

		if (useFinderCache) {
			list = (List<OSPCluster>)finderCache.getResult(
				finderPath, finderArgs, this);

			if ((list != null) && !list.isEmpty()) {
				for (OSPCluster ospCluster : list) {
					if (!osName.equals(ospCluster.getOsName())) {
						list = null;

						break;
					}
				}
			}
		}

		if (list == null) {
			StringBundler sb = null;

			if (orderByComparator != null) {
				sb = new StringBundler(
					3 + (orderByComparator.getOrderByFields().length * 2));
			}
			else {
				sb = new StringBundler(3);
			}

			sb.append(_SQL_SELECT_OSPCLUSTER_WHERE);

			boolean bindOsName = false;

			if (osName.isEmpty()) {
				sb.append(_FINDER_COLUMN_OSNAME_OSNAME_3);
			}
			else {
				bindOsName = true;

				sb.append(_FINDER_COLUMN_OSNAME_OSNAME_2);
			}

			if (orderByComparator != null) {
				appendOrderByComparator(
					sb, _ORDER_BY_ENTITY_ALIAS, orderByComparator);
			}
			else {
				sb.append(OSPClusterModelImpl.ORDER_BY_JPQL);
			}

			String sql = sb.toString();

			Session session = null;

			try {
				session = openSession();

				Query query = session.createQuery(sql);

				QueryPos queryPos = QueryPos.getInstance(query);

				if (bindOsName) {
					queryPos.add(osName);
				}

				list = (List<OSPCluster>)QueryUtil.list(
					query, getDialect(), start, end);

				cacheResult(list);

				if (useFinderCache) {
					finderCache.putResult(finderPath, finderArgs, list);
				}
			}
			catch (Exception exception) {
				if (useFinderCache) {
					finderCache.removeResult(finderPath, finderArgs);
				}

				throw processException(exception);
			}
			finally {
				closeSession(session);
			}
		}

		return list;
	}

	/**
	 * Returns the first osp cluster in the ordered set where osName = &#63;.
	 *
	 * @param osName the os name
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching osp cluster
	 * @throws NoSuchOSPClusterException if a matching osp cluster could not be found
	 */
	@Override
	public OSPCluster findByOSName_First(
			String osName, OrderByComparator<OSPCluster> orderByComparator)
		throws NoSuchOSPClusterException {

		OSPCluster ospCluster = fetchByOSName_First(osName, orderByComparator);

		if (ospCluster != null) {
			return ospCluster;
		}

		StringBundler sb = new StringBundler(4);

		sb.append(_NO_SUCH_ENTITY_WITH_KEY);

		sb.append("osName=");
		sb.append(osName);

		sb.append("}");

		throw new NoSuchOSPClusterException(sb.toString());
	}

	/**
	 * Returns the first osp cluster in the ordered set where osName = &#63;.
	 *
	 * @param osName the os name
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching osp cluster, or <code>null</code> if a matching osp cluster could not be found
	 */
	@Override
	public OSPCluster fetchByOSName_First(
		String osName, OrderByComparator<OSPCluster> orderByComparator) {

		List<OSPCluster> list = findByOSName(osName, 0, 1, orderByComparator);

		if (!list.isEmpty()) {
			return list.get(0);
		}

		return null;
	}

	/**
	 * Returns the last osp cluster in the ordered set where osName = &#63;.
	 *
	 * @param osName the os name
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching osp cluster
	 * @throws NoSuchOSPClusterException if a matching osp cluster could not be found
	 */
	@Override
	public OSPCluster findByOSName_Last(
			String osName, OrderByComparator<OSPCluster> orderByComparator)
		throws NoSuchOSPClusterException {

		OSPCluster ospCluster = fetchByOSName_Last(osName, orderByComparator);

		if (ospCluster != null) {
			return ospCluster;
		}

		StringBundler sb = new StringBundler(4);

		sb.append(_NO_SUCH_ENTITY_WITH_KEY);

		sb.append("osName=");
		sb.append(osName);

		sb.append("}");

		throw new NoSuchOSPClusterException(sb.toString());
	}

	/**
	 * Returns the last osp cluster in the ordered set where osName = &#63;.
	 *
	 * @param osName the os name
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching osp cluster, or <code>null</code> if a matching osp cluster could not be found
	 */
	@Override
	public OSPCluster fetchByOSName_Last(
		String osName, OrderByComparator<OSPCluster> orderByComparator) {

		int count = countByOSName(osName);

		if (count == 0) {
			return null;
		}

		List<OSPCluster> list = findByOSName(
			osName, count - 1, count, orderByComparator);

		if (!list.isEmpty()) {
			return list.get(0);
		}

		return null;
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
	@Override
	public OSPCluster[] findByOSName_PrevAndNext(
			long clusterId, String osName,
			OrderByComparator<OSPCluster> orderByComparator)
		throws NoSuchOSPClusterException {

		osName = Objects.toString(osName, "");

		OSPCluster ospCluster = findByPrimaryKey(clusterId);

		Session session = null;

		try {
			session = openSession();

			OSPCluster[] array = new OSPClusterImpl[3];

			array[0] = getByOSName_PrevAndNext(
				session, ospCluster, osName, orderByComparator, true);

			array[1] = ospCluster;

			array[2] = getByOSName_PrevAndNext(
				session, ospCluster, osName, orderByComparator, false);

			return array;
		}
		catch (Exception exception) {
			throw processException(exception);
		}
		finally {
			closeSession(session);
		}
	}

	protected OSPCluster getByOSName_PrevAndNext(
		Session session, OSPCluster ospCluster, String osName,
		OrderByComparator<OSPCluster> orderByComparator, boolean previous) {

		StringBundler sb = null;

		if (orderByComparator != null) {
			sb = new StringBundler(
				4 + (orderByComparator.getOrderByConditionFields().length * 3) +
					(orderByComparator.getOrderByFields().length * 3));
		}
		else {
			sb = new StringBundler(3);
		}

		sb.append(_SQL_SELECT_OSPCLUSTER_WHERE);

		boolean bindOsName = false;

		if (osName.isEmpty()) {
			sb.append(_FINDER_COLUMN_OSNAME_OSNAME_3);
		}
		else {
			bindOsName = true;

			sb.append(_FINDER_COLUMN_OSNAME_OSNAME_2);
		}

		if (orderByComparator != null) {
			String[] orderByConditionFields =
				orderByComparator.getOrderByConditionFields();

			if (orderByConditionFields.length > 0) {
				sb.append(WHERE_AND);
			}

			for (int i = 0; i < orderByConditionFields.length; i++) {
				sb.append(_ORDER_BY_ENTITY_ALIAS);
				sb.append(orderByConditionFields[i]);

				if ((i + 1) < orderByConditionFields.length) {
					if (orderByComparator.isAscending() ^ previous) {
						sb.append(WHERE_GREATER_THAN_HAS_NEXT);
					}
					else {
						sb.append(WHERE_LESSER_THAN_HAS_NEXT);
					}
				}
				else {
					if (orderByComparator.isAscending() ^ previous) {
						sb.append(WHERE_GREATER_THAN);
					}
					else {
						sb.append(WHERE_LESSER_THAN);
					}
				}
			}

			sb.append(ORDER_BY_CLAUSE);

			String[] orderByFields = orderByComparator.getOrderByFields();

			for (int i = 0; i < orderByFields.length; i++) {
				sb.append(_ORDER_BY_ENTITY_ALIAS);
				sb.append(orderByFields[i]);

				if ((i + 1) < orderByFields.length) {
					if (orderByComparator.isAscending() ^ previous) {
						sb.append(ORDER_BY_ASC_HAS_NEXT);
					}
					else {
						sb.append(ORDER_BY_DESC_HAS_NEXT);
					}
				}
				else {
					if (orderByComparator.isAscending() ^ previous) {
						sb.append(ORDER_BY_ASC);
					}
					else {
						sb.append(ORDER_BY_DESC);
					}
				}
			}
		}
		else {
			sb.append(OSPClusterModelImpl.ORDER_BY_JPQL);
		}

		String sql = sb.toString();

		Query query = session.createQuery(sql);

		query.setFirstResult(0);
		query.setMaxResults(2);

		QueryPos queryPos = QueryPos.getInstance(query);

		if (bindOsName) {
			queryPos.add(osName);
		}

		if (orderByComparator != null) {
			for (Object orderByConditionValue :
					orderByComparator.getOrderByConditionValues(ospCluster)) {

				queryPos.add(orderByConditionValue);
			}
		}

		List<OSPCluster> list = query.list();

		if (list.size() == 2) {
			return list.get(1);
		}
		else {
			return null;
		}
	}

	/**
	 * Removes all the osp clusters where osName = &#63; from the database.
	 *
	 * @param osName the os name
	 */
	@Override
	public void removeByOSName(String osName) {
		for (OSPCluster ospCluster :
				findByOSName(
					osName, QueryUtil.ALL_POS, QueryUtil.ALL_POS, null)) {

			remove(ospCluster);
		}
	}

	/**
	 * Returns the number of osp clusters where osName = &#63;.
	 *
	 * @param osName the os name
	 * @return the number of matching osp clusters
	 */
	@Override
	public int countByOSName(String osName) {
		osName = Objects.toString(osName, "");

		FinderPath finderPath = _finderPathCountByOSName;

		Object[] finderArgs = new Object[] {osName};

		Long count = (Long)finderCache.getResult(finderPath, finderArgs, this);

		if (count == null) {
			StringBundler sb = new StringBundler(2);

			sb.append(_SQL_COUNT_OSPCLUSTER_WHERE);

			boolean bindOsName = false;

			if (osName.isEmpty()) {
				sb.append(_FINDER_COLUMN_OSNAME_OSNAME_3);
			}
			else {
				bindOsName = true;

				sb.append(_FINDER_COLUMN_OSNAME_OSNAME_2);
			}

			String sql = sb.toString();

			Session session = null;

			try {
				session = openSession();

				Query query = session.createQuery(sql);

				QueryPos queryPos = QueryPos.getInstance(query);

				if (bindOsName) {
					queryPos.add(osName);
				}

				count = (Long)query.uniqueResult();

				finderCache.putResult(finderPath, finderArgs, count);
			}
			catch (Exception exception) {
				finderCache.removeResult(finderPath, finderArgs);

				throw processException(exception);
			}
			finally {
				closeSession(session);
			}
		}

		return count.intValue();
	}

	private static final String _FINDER_COLUMN_OSNAME_OSNAME_2 =
		"ospCluster.osName = ?";

	private static final String _FINDER_COLUMN_OSNAME_OSNAME_3 =
		"(ospCluster.osName IS NULL OR ospCluster.osName = '')";

	public OSPClusterPersistenceImpl() {
		setModelClass(OSPCluster.class);

		setModelImplClass(OSPClusterImpl.class);
		setModelPKClass(long.class);

		Map<String, String> dbColumnNames = new HashMap<String, String>();

		dbColumnNames.put("uuid", "uuid_");

		setDBColumnNames(dbColumnNames);
	}

	/**
	 * Caches the osp cluster in the entity cache if it is enabled.
	 *
	 * @param ospCluster the osp cluster
	 */
	@Override
	public void cacheResult(OSPCluster ospCluster) {
		entityCache.putResult(
			entityCacheEnabled, OSPClusterImpl.class,
			ospCluster.getPrimaryKey(), ospCluster);

		finderCache.putResult(
			_finderPathFetchByUUID_G,
			new Object[] {ospCluster.getUuid(), ospCluster.getGroupId()},
			ospCluster);

		finderCache.putResult(
			_finderPathFetchByClusterName,
			new Object[] {ospCluster.getClusterName()}, ospCluster);

		ospCluster.resetOriginalValues();
	}

	/**
	 * Caches the osp clusters in the entity cache if it is enabled.
	 *
	 * @param ospClusters the osp clusters
	 */
	@Override
	public void cacheResult(List<OSPCluster> ospClusters) {
		for (OSPCluster ospCluster : ospClusters) {
			if (entityCache.getResult(
					entityCacheEnabled, OSPClusterImpl.class,
					ospCluster.getPrimaryKey()) == null) {

				cacheResult(ospCluster);
			}
			else {
				ospCluster.resetOriginalValues();
			}
		}
	}

	/**
	 * Clears the cache for all osp clusters.
	 *
	 * <p>
	 * The <code>EntityCache</code> and <code>FinderCache</code> are both cleared by this method.
	 * </p>
	 */
	@Override
	public void clearCache() {
		entityCache.clearCache(OSPClusterImpl.class);

		finderCache.clearCache(FINDER_CLASS_NAME_ENTITY);
		finderCache.clearCache(FINDER_CLASS_NAME_LIST_WITH_PAGINATION);
		finderCache.clearCache(FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION);
	}

	/**
	 * Clears the cache for the osp cluster.
	 *
	 * <p>
	 * The <code>EntityCache</code> and <code>FinderCache</code> are both cleared by this method.
	 * </p>
	 */
	@Override
	public void clearCache(OSPCluster ospCluster) {
		entityCache.removeResult(
			entityCacheEnabled, OSPClusterImpl.class,
			ospCluster.getPrimaryKey());

		finderCache.clearCache(FINDER_CLASS_NAME_LIST_WITH_PAGINATION);
		finderCache.clearCache(FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION);

		clearUniqueFindersCache((OSPClusterModelImpl)ospCluster, true);
	}

	@Override
	public void clearCache(List<OSPCluster> ospClusters) {
		finderCache.clearCache(FINDER_CLASS_NAME_LIST_WITH_PAGINATION);
		finderCache.clearCache(FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION);

		for (OSPCluster ospCluster : ospClusters) {
			entityCache.removeResult(
				entityCacheEnabled, OSPClusterImpl.class,
				ospCluster.getPrimaryKey());

			clearUniqueFindersCache((OSPClusterModelImpl)ospCluster, true);
		}
	}

	public void clearCache(Set<Serializable> primaryKeys) {
		finderCache.clearCache(FINDER_CLASS_NAME_ENTITY);
		finderCache.clearCache(FINDER_CLASS_NAME_LIST_WITH_PAGINATION);
		finderCache.clearCache(FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION);

		for (Serializable primaryKey : primaryKeys) {
			entityCache.removeResult(
				entityCacheEnabled, OSPClusterImpl.class, primaryKey);
		}
	}

	protected void cacheUniqueFindersCache(
		OSPClusterModelImpl ospClusterModelImpl) {

		Object[] args = new Object[] {
			ospClusterModelImpl.getUuid(), ospClusterModelImpl.getGroupId()
		};

		finderCache.putResult(
			_finderPathCountByUUID_G, args, Long.valueOf(1), false);
		finderCache.putResult(
			_finderPathFetchByUUID_G, args, ospClusterModelImpl, false);

		args = new Object[] {ospClusterModelImpl.getClusterName()};

		finderCache.putResult(
			_finderPathCountByClusterName, args, Long.valueOf(1), false);
		finderCache.putResult(
			_finderPathFetchByClusterName, args, ospClusterModelImpl, false);
	}

	protected void clearUniqueFindersCache(
		OSPClusterModelImpl ospClusterModelImpl, boolean clearCurrent) {

		if (clearCurrent) {
			Object[] args = new Object[] {
				ospClusterModelImpl.getUuid(), ospClusterModelImpl.getGroupId()
			};

			finderCache.removeResult(_finderPathCountByUUID_G, args);
			finderCache.removeResult(_finderPathFetchByUUID_G, args);
		}

		if ((ospClusterModelImpl.getColumnBitmask() &
			 _finderPathFetchByUUID_G.getColumnBitmask()) != 0) {

			Object[] args = new Object[] {
				ospClusterModelImpl.getOriginalUuid(),
				ospClusterModelImpl.getOriginalGroupId()
			};

			finderCache.removeResult(_finderPathCountByUUID_G, args);
			finderCache.removeResult(_finderPathFetchByUUID_G, args);
		}

		if (clearCurrent) {
			Object[] args = new Object[] {ospClusterModelImpl.getClusterName()};

			finderCache.removeResult(_finderPathCountByClusterName, args);
			finderCache.removeResult(_finderPathFetchByClusterName, args);
		}

		if ((ospClusterModelImpl.getColumnBitmask() &
			 _finderPathFetchByClusterName.getColumnBitmask()) != 0) {

			Object[] args = new Object[] {
				ospClusterModelImpl.getOriginalClusterName()
			};

			finderCache.removeResult(_finderPathCountByClusterName, args);
			finderCache.removeResult(_finderPathFetchByClusterName, args);
		}
	}

	/**
	 * Creates a new osp cluster with the primary key. Does not add the osp cluster to the database.
	 *
	 * @param clusterId the primary key for the new osp cluster
	 * @return the new osp cluster
	 */
	@Override
	public OSPCluster create(long clusterId) {
		OSPCluster ospCluster = new OSPClusterImpl();

		ospCluster.setNew(true);
		ospCluster.setPrimaryKey(clusterId);

		String uuid = PortalUUIDUtil.generate();

		ospCluster.setUuid(uuid);

		ospCluster.setCompanyId(CompanyThreadLocal.getCompanyId());

		return ospCluster;
	}

	/**
	 * Removes the osp cluster with the primary key from the database. Also notifies the appropriate model listeners.
	 *
	 * @param clusterId the primary key of the osp cluster
	 * @return the osp cluster that was removed
	 * @throws NoSuchOSPClusterException if a osp cluster with the primary key could not be found
	 */
	@Override
	public OSPCluster remove(long clusterId) throws NoSuchOSPClusterException {
		return remove((Serializable)clusterId);
	}

	/**
	 * Removes the osp cluster with the primary key from the database. Also notifies the appropriate model listeners.
	 *
	 * @param primaryKey the primary key of the osp cluster
	 * @return the osp cluster that was removed
	 * @throws NoSuchOSPClusterException if a osp cluster with the primary key could not be found
	 */
	@Override
	public OSPCluster remove(Serializable primaryKey)
		throws NoSuchOSPClusterException {

		Session session = null;

		try {
			session = openSession();

			OSPCluster ospCluster = (OSPCluster)session.get(
				OSPClusterImpl.class, primaryKey);

			if (ospCluster == null) {
				if (_log.isDebugEnabled()) {
					_log.debug(_NO_SUCH_ENTITY_WITH_PRIMARY_KEY + primaryKey);
				}

				throw new NoSuchOSPClusterException(
					_NO_SUCH_ENTITY_WITH_PRIMARY_KEY + primaryKey);
			}

			return remove(ospCluster);
		}
		catch (NoSuchOSPClusterException noSuchEntityException) {
			throw noSuchEntityException;
		}
		catch (Exception exception) {
			throw processException(exception);
		}
		finally {
			closeSession(session);
		}
	}

	@Override
	protected OSPCluster removeImpl(OSPCluster ospCluster) {
		Session session = null;

		try {
			session = openSession();

			if (!session.contains(ospCluster)) {
				ospCluster = (OSPCluster)session.get(
					OSPClusterImpl.class, ospCluster.getPrimaryKeyObj());
			}

			if (ospCluster != null) {
				session.delete(ospCluster);
			}
		}
		catch (Exception exception) {
			throw processException(exception);
		}
		finally {
			closeSession(session);
		}

		if (ospCluster != null) {
			clearCache(ospCluster);
		}

		return ospCluster;
	}

	@Override
	public OSPCluster updateImpl(OSPCluster ospCluster) {
		boolean isNew = ospCluster.isNew();

		if (!(ospCluster instanceof OSPClusterModelImpl)) {
			InvocationHandler invocationHandler = null;

			if (ProxyUtil.isProxyClass(ospCluster.getClass())) {
				invocationHandler = ProxyUtil.getInvocationHandler(ospCluster);

				throw new IllegalArgumentException(
					"Implement ModelWrapper in ospCluster proxy " +
						invocationHandler.getClass());
			}

			throw new IllegalArgumentException(
				"Implement ModelWrapper in custom OSPCluster implementation " +
					ospCluster.getClass());
		}

		OSPClusterModelImpl ospClusterModelImpl =
			(OSPClusterModelImpl)ospCluster;

		if (Validator.isNull(ospCluster.getUuid())) {
			String uuid = PortalUUIDUtil.generate();

			ospCluster.setUuid(uuid);
		}

		ServiceContext serviceContext =
			ServiceContextThreadLocal.getServiceContext();

		Date now = new Date();

		if (isNew && (ospCluster.getCreateDate() == null)) {
			if (serviceContext == null) {
				ospCluster.setCreateDate(now);
			}
			else {
				ospCluster.setCreateDate(serviceContext.getCreateDate(now));
			}
		}

		if (!ospClusterModelImpl.hasSetModifiedDate()) {
			if (serviceContext == null) {
				ospCluster.setModifiedDate(now);
			}
			else {
				ospCluster.setModifiedDate(serviceContext.getModifiedDate(now));
			}
		}

		Session session = null;

		try {
			session = openSession();

			if (ospCluster.isNew()) {
				session.save(ospCluster);

				ospCluster.setNew(false);
			}
			else {
				ospCluster = (OSPCluster)session.merge(ospCluster);
			}
		}
		catch (Exception exception) {
			throw processException(exception);
		}
		finally {
			closeSession(session);
		}

		finderCache.clearCache(FINDER_CLASS_NAME_LIST_WITH_PAGINATION);

		if (!_columnBitmaskEnabled) {
			finderCache.clearCache(FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION);
		}
		else if (isNew) {
			Object[] args = new Object[] {ospClusterModelImpl.getUuid()};

			finderCache.removeResult(_finderPathCountByUuid, args);
			finderCache.removeResult(
				_finderPathWithoutPaginationFindByUuid, args);

			args = new Object[] {
				ospClusterModelImpl.getUuid(),
				ospClusterModelImpl.getCompanyId()
			};

			finderCache.removeResult(_finderPathCountByUuid_C, args);
			finderCache.removeResult(
				_finderPathWithoutPaginationFindByUuid_C, args);

			args = new Object[] {ospClusterModelImpl.getGroupId()};

			finderCache.removeResult(_finderPathCountByGroupId, args);
			finderCache.removeResult(
				_finderPathWithoutPaginationFindByGroupId, args);

			args = new Object[] {ospClusterModelImpl.getStatus()};

			finderCache.removeResult(_finderPathCountByStatus, args);
			finderCache.removeResult(
				_finderPathWithoutPaginationFindByStatus, args);

			args = new Object[] {ospClusterModelImpl.getOsName()};

			finderCache.removeResult(_finderPathCountByOSName, args);
			finderCache.removeResult(
				_finderPathWithoutPaginationFindByOSName, args);

			finderCache.removeResult(_finderPathCountAll, FINDER_ARGS_EMPTY);
			finderCache.removeResult(
				_finderPathWithoutPaginationFindAll, FINDER_ARGS_EMPTY);
		}
		else {
			if ((ospClusterModelImpl.getColumnBitmask() &
				 _finderPathWithoutPaginationFindByUuid.getColumnBitmask()) !=
					 0) {

				Object[] args = new Object[] {
					ospClusterModelImpl.getOriginalUuid()
				};

				finderCache.removeResult(_finderPathCountByUuid, args);
				finderCache.removeResult(
					_finderPathWithoutPaginationFindByUuid, args);

				args = new Object[] {ospClusterModelImpl.getUuid()};

				finderCache.removeResult(_finderPathCountByUuid, args);
				finderCache.removeResult(
					_finderPathWithoutPaginationFindByUuid, args);
			}

			if ((ospClusterModelImpl.getColumnBitmask() &
				 _finderPathWithoutPaginationFindByUuid_C.getColumnBitmask()) !=
					 0) {

				Object[] args = new Object[] {
					ospClusterModelImpl.getOriginalUuid(),
					ospClusterModelImpl.getOriginalCompanyId()
				};

				finderCache.removeResult(_finderPathCountByUuid_C, args);
				finderCache.removeResult(
					_finderPathWithoutPaginationFindByUuid_C, args);

				args = new Object[] {
					ospClusterModelImpl.getUuid(),
					ospClusterModelImpl.getCompanyId()
				};

				finderCache.removeResult(_finderPathCountByUuid_C, args);
				finderCache.removeResult(
					_finderPathWithoutPaginationFindByUuid_C, args);
			}

			if ((ospClusterModelImpl.getColumnBitmask() &
				 _finderPathWithoutPaginationFindByGroupId.
					 getColumnBitmask()) != 0) {

				Object[] args = new Object[] {
					ospClusterModelImpl.getOriginalGroupId()
				};

				finderCache.removeResult(_finderPathCountByGroupId, args);
				finderCache.removeResult(
					_finderPathWithoutPaginationFindByGroupId, args);

				args = new Object[] {ospClusterModelImpl.getGroupId()};

				finderCache.removeResult(_finderPathCountByGroupId, args);
				finderCache.removeResult(
					_finderPathWithoutPaginationFindByGroupId, args);
			}

			if ((ospClusterModelImpl.getColumnBitmask() &
				 _finderPathWithoutPaginationFindByStatus.getColumnBitmask()) !=
					 0) {

				Object[] args = new Object[] {
					ospClusterModelImpl.getOriginalStatus()
				};

				finderCache.removeResult(_finderPathCountByStatus, args);
				finderCache.removeResult(
					_finderPathWithoutPaginationFindByStatus, args);

				args = new Object[] {ospClusterModelImpl.getStatus()};

				finderCache.removeResult(_finderPathCountByStatus, args);
				finderCache.removeResult(
					_finderPathWithoutPaginationFindByStatus, args);
			}

			if ((ospClusterModelImpl.getColumnBitmask() &
				 _finderPathWithoutPaginationFindByOSName.getColumnBitmask()) !=
					 0) {

				Object[] args = new Object[] {
					ospClusterModelImpl.getOriginalOsName()
				};

				finderCache.removeResult(_finderPathCountByOSName, args);
				finderCache.removeResult(
					_finderPathWithoutPaginationFindByOSName, args);

				args = new Object[] {ospClusterModelImpl.getOsName()};

				finderCache.removeResult(_finderPathCountByOSName, args);
				finderCache.removeResult(
					_finderPathWithoutPaginationFindByOSName, args);
			}
		}

		entityCache.putResult(
			entityCacheEnabled, OSPClusterImpl.class,
			ospCluster.getPrimaryKey(), ospCluster, false);

		clearUniqueFindersCache(ospClusterModelImpl, false);
		cacheUniqueFindersCache(ospClusterModelImpl);

		ospCluster.resetOriginalValues();

		return ospCluster;
	}

	/**
	 * Returns the osp cluster with the primary key or throws a <code>com.liferay.portal.kernel.exception.NoSuchModelException</code> if it could not be found.
	 *
	 * @param primaryKey the primary key of the osp cluster
	 * @return the osp cluster
	 * @throws NoSuchOSPClusterException if a osp cluster with the primary key could not be found
	 */
	@Override
	public OSPCluster findByPrimaryKey(Serializable primaryKey)
		throws NoSuchOSPClusterException {

		OSPCluster ospCluster = fetchByPrimaryKey(primaryKey);

		if (ospCluster == null) {
			if (_log.isDebugEnabled()) {
				_log.debug(_NO_SUCH_ENTITY_WITH_PRIMARY_KEY + primaryKey);
			}

			throw new NoSuchOSPClusterException(
				_NO_SUCH_ENTITY_WITH_PRIMARY_KEY + primaryKey);
		}

		return ospCluster;
	}

	/**
	 * Returns the osp cluster with the primary key or throws a <code>NoSuchOSPClusterException</code> if it could not be found.
	 *
	 * @param clusterId the primary key of the osp cluster
	 * @return the osp cluster
	 * @throws NoSuchOSPClusterException if a osp cluster with the primary key could not be found
	 */
	@Override
	public OSPCluster findByPrimaryKey(long clusterId)
		throws NoSuchOSPClusterException {

		return findByPrimaryKey((Serializable)clusterId);
	}

	/**
	 * Returns the osp cluster with the primary key or returns <code>null</code> if it could not be found.
	 *
	 * @param clusterId the primary key of the osp cluster
	 * @return the osp cluster, or <code>null</code> if a osp cluster with the primary key could not be found
	 */
	@Override
	public OSPCluster fetchByPrimaryKey(long clusterId) {
		return fetchByPrimaryKey((Serializable)clusterId);
	}

	/**
	 * Returns all the osp clusters.
	 *
	 * @return the osp clusters
	 */
	@Override
	public List<OSPCluster> findAll() {
		return findAll(QueryUtil.ALL_POS, QueryUtil.ALL_POS, null);
	}

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
	@Override
	public List<OSPCluster> findAll(int start, int end) {
		return findAll(start, end, null);
	}

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
	@Override
	public List<OSPCluster> findAll(
		int start, int end, OrderByComparator<OSPCluster> orderByComparator) {

		return findAll(start, end, orderByComparator, true);
	}

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
	@Override
	public List<OSPCluster> findAll(
		int start, int end, OrderByComparator<OSPCluster> orderByComparator,
		boolean useFinderCache) {

		FinderPath finderPath = null;
		Object[] finderArgs = null;

		if ((start == QueryUtil.ALL_POS) && (end == QueryUtil.ALL_POS) &&
			(orderByComparator == null)) {

			if (useFinderCache) {
				finderPath = _finderPathWithoutPaginationFindAll;
				finderArgs = FINDER_ARGS_EMPTY;
			}
		}
		else if (useFinderCache) {
			finderPath = _finderPathWithPaginationFindAll;
			finderArgs = new Object[] {start, end, orderByComparator};
		}

		List<OSPCluster> list = null;

		if (useFinderCache) {
			list = (List<OSPCluster>)finderCache.getResult(
				finderPath, finderArgs, this);
		}

		if (list == null) {
			StringBundler sb = null;
			String sql = null;

			if (orderByComparator != null) {
				sb = new StringBundler(
					2 + (orderByComparator.getOrderByFields().length * 2));

				sb.append(_SQL_SELECT_OSPCLUSTER);

				appendOrderByComparator(
					sb, _ORDER_BY_ENTITY_ALIAS, orderByComparator);

				sql = sb.toString();
			}
			else {
				sql = _SQL_SELECT_OSPCLUSTER;

				sql = sql.concat(OSPClusterModelImpl.ORDER_BY_JPQL);
			}

			Session session = null;

			try {
				session = openSession();

				Query query = session.createQuery(sql);

				list = (List<OSPCluster>)QueryUtil.list(
					query, getDialect(), start, end);

				cacheResult(list);

				if (useFinderCache) {
					finderCache.putResult(finderPath, finderArgs, list);
				}
			}
			catch (Exception exception) {
				if (useFinderCache) {
					finderCache.removeResult(finderPath, finderArgs);
				}

				throw processException(exception);
			}
			finally {
				closeSession(session);
			}
		}

		return list;
	}

	/**
	 * Removes all the osp clusters from the database.
	 *
	 */
	@Override
	public void removeAll() {
		for (OSPCluster ospCluster : findAll()) {
			remove(ospCluster);
		}
	}

	/**
	 * Returns the number of osp clusters.
	 *
	 * @return the number of osp clusters
	 */
	@Override
	public int countAll() {
		Long count = (Long)finderCache.getResult(
			_finderPathCountAll, FINDER_ARGS_EMPTY, this);

		if (count == null) {
			Session session = null;

			try {
				session = openSession();

				Query query = session.createQuery(_SQL_COUNT_OSPCLUSTER);

				count = (Long)query.uniqueResult();

				finderCache.putResult(
					_finderPathCountAll, FINDER_ARGS_EMPTY, count);
			}
			catch (Exception exception) {
				finderCache.removeResult(
					_finderPathCountAll, FINDER_ARGS_EMPTY);

				throw processException(exception);
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
		return "clusterId";
	}

	@Override
	protected String getSelectSQL() {
		return _SQL_SELECT_OSPCLUSTER;
	}

	@Override
	protected Map<String, Integer> getTableColumnsMap() {
		return OSPClusterModelImpl.TABLE_COLUMNS_MAP;
	}

	/**
	 * Initializes the osp cluster persistence.
	 */
	@Activate
	public void activate() {
		OSPClusterModelImpl.setEntityCacheEnabled(entityCacheEnabled);
		OSPClusterModelImpl.setFinderCacheEnabled(finderCacheEnabled);

		_finderPathWithPaginationFindAll = new FinderPath(
			entityCacheEnabled, finderCacheEnabled, OSPClusterImpl.class,
			FINDER_CLASS_NAME_LIST_WITH_PAGINATION, "findAll", new String[0]);

		_finderPathWithoutPaginationFindAll = new FinderPath(
			entityCacheEnabled, finderCacheEnabled, OSPClusterImpl.class,
			FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION, "findAll",
			new String[0]);

		_finderPathCountAll = new FinderPath(
			entityCacheEnabled, finderCacheEnabled, Long.class,
			FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION, "countAll",
			new String[0]);

		_finderPathWithPaginationFindByUuid = new FinderPath(
			entityCacheEnabled, finderCacheEnabled, OSPClusterImpl.class,
			FINDER_CLASS_NAME_LIST_WITH_PAGINATION, "findByUuid",
			new String[] {
				String.class.getName(), Integer.class.getName(),
				Integer.class.getName(), OrderByComparator.class.getName()
			});

		_finderPathWithoutPaginationFindByUuid = new FinderPath(
			entityCacheEnabled, finderCacheEnabled, OSPClusterImpl.class,
			FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION, "findByUuid",
			new String[] {String.class.getName()},
			OSPClusterModelImpl.UUID_COLUMN_BITMASK |
			OSPClusterModelImpl.CLUSTERNAME_COLUMN_BITMASK);

		_finderPathCountByUuid = new FinderPath(
			entityCacheEnabled, finderCacheEnabled, Long.class,
			FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION, "countByUuid",
			new String[] {String.class.getName()});

		_finderPathFetchByUUID_G = new FinderPath(
			entityCacheEnabled, finderCacheEnabled, OSPClusterImpl.class,
			FINDER_CLASS_NAME_ENTITY, "fetchByUUID_G",
			new String[] {String.class.getName(), Long.class.getName()},
			OSPClusterModelImpl.UUID_COLUMN_BITMASK |
			OSPClusterModelImpl.GROUPID_COLUMN_BITMASK);

		_finderPathCountByUUID_G = new FinderPath(
			entityCacheEnabled, finderCacheEnabled, Long.class,
			FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION, "countByUUID_G",
			new String[] {String.class.getName(), Long.class.getName()});

		_finderPathWithPaginationFindByUuid_C = new FinderPath(
			entityCacheEnabled, finderCacheEnabled, OSPClusterImpl.class,
			FINDER_CLASS_NAME_LIST_WITH_PAGINATION, "findByUuid_C",
			new String[] {
				String.class.getName(), Long.class.getName(),
				Integer.class.getName(), Integer.class.getName(),
				OrderByComparator.class.getName()
			});

		_finderPathWithoutPaginationFindByUuid_C = new FinderPath(
			entityCacheEnabled, finderCacheEnabled, OSPClusterImpl.class,
			FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION, "findByUuid_C",
			new String[] {String.class.getName(), Long.class.getName()},
			OSPClusterModelImpl.UUID_COLUMN_BITMASK |
			OSPClusterModelImpl.COMPANYID_COLUMN_BITMASK |
			OSPClusterModelImpl.CLUSTERNAME_COLUMN_BITMASK);

		_finderPathCountByUuid_C = new FinderPath(
			entityCacheEnabled, finderCacheEnabled, Long.class,
			FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION, "countByUuid_C",
			new String[] {String.class.getName(), Long.class.getName()});

		_finderPathWithPaginationFindByGroupId = new FinderPath(
			entityCacheEnabled, finderCacheEnabled, OSPClusterImpl.class,
			FINDER_CLASS_NAME_LIST_WITH_PAGINATION, "findByGroupId",
			new String[] {
				Long.class.getName(), Integer.class.getName(),
				Integer.class.getName(), OrderByComparator.class.getName()
			});

		_finderPathWithoutPaginationFindByGroupId = new FinderPath(
			entityCacheEnabled, finderCacheEnabled, OSPClusterImpl.class,
			FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION, "findByGroupId",
			new String[] {Long.class.getName()},
			OSPClusterModelImpl.GROUPID_COLUMN_BITMASK |
			OSPClusterModelImpl.CLUSTERNAME_COLUMN_BITMASK);

		_finderPathCountByGroupId = new FinderPath(
			entityCacheEnabled, finderCacheEnabled, Long.class,
			FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION, "countByGroupId",
			new String[] {Long.class.getName()});

		_finderPathWithPaginationFindByStatus = new FinderPath(
			entityCacheEnabled, finderCacheEnabled, OSPClusterImpl.class,
			FINDER_CLASS_NAME_LIST_WITH_PAGINATION, "findByStatus",
			new String[] {
				Integer.class.getName(), Integer.class.getName(),
				Integer.class.getName(), OrderByComparator.class.getName()
			});

		_finderPathWithoutPaginationFindByStatus = new FinderPath(
			entityCacheEnabled, finderCacheEnabled, OSPClusterImpl.class,
			FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION, "findByStatus",
			new String[] {Integer.class.getName()},
			OSPClusterModelImpl.STATUS_COLUMN_BITMASK |
			OSPClusterModelImpl.CLUSTERNAME_COLUMN_BITMASK);

		_finderPathCountByStatus = new FinderPath(
			entityCacheEnabled, finderCacheEnabled, Long.class,
			FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION, "countByStatus",
			new String[] {Integer.class.getName()});

		_finderPathFetchByClusterName = new FinderPath(
			entityCacheEnabled, finderCacheEnabled, OSPClusterImpl.class,
			FINDER_CLASS_NAME_ENTITY, "fetchByClusterName",
			new String[] {String.class.getName()},
			OSPClusterModelImpl.CLUSTERNAME_COLUMN_BITMASK);

		_finderPathCountByClusterName = new FinderPath(
			entityCacheEnabled, finderCacheEnabled, Long.class,
			FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION, "countByClusterName",
			new String[] {String.class.getName()});

		_finderPathWithPaginationFindByOSName = new FinderPath(
			entityCacheEnabled, finderCacheEnabled, OSPClusterImpl.class,
			FINDER_CLASS_NAME_LIST_WITH_PAGINATION, "findByOSName",
			new String[] {
				String.class.getName(), Integer.class.getName(),
				Integer.class.getName(), OrderByComparator.class.getName()
			});

		_finderPathWithoutPaginationFindByOSName = new FinderPath(
			entityCacheEnabled, finderCacheEnabled, OSPClusterImpl.class,
			FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION, "findByOSName",
			new String[] {String.class.getName()},
			OSPClusterModelImpl.OSNAME_COLUMN_BITMASK |
			OSPClusterModelImpl.CLUSTERNAME_COLUMN_BITMASK);

		_finderPathCountByOSName = new FinderPath(
			entityCacheEnabled, finderCacheEnabled, Long.class,
			FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION, "countByOSName",
			new String[] {String.class.getName()});
	}

	@Deactivate
	public void deactivate() {
		entityCache.removeCache(OSPClusterImpl.class.getName());
		finderCache.removeCache(FINDER_CLASS_NAME_ENTITY);
		finderCache.removeCache(FINDER_CLASS_NAME_LIST_WITH_PAGINATION);
		finderCache.removeCache(FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION);
	}

	@Override
	@Reference(
		target = ICEBREAKERPersistenceConstants.SERVICE_CONFIGURATION_FILTER,
		unbind = "-"
	)
	public void setConfiguration(Configuration configuration) {
		super.setConfiguration(configuration);

		_columnBitmaskEnabled = GetterUtil.getBoolean(
			configuration.get(
				"value.object.column.bitmask.enabled.com.osp.icebreaker.model.OSPCluster"),
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

	@Reference
	protected EntityCache entityCache;

	@Reference
	protected FinderCache finderCache;

	private static final String _SQL_SELECT_OSPCLUSTER =
		"SELECT ospCluster FROM OSPCluster ospCluster";

	private static final String _SQL_SELECT_OSPCLUSTER_WHERE =
		"SELECT ospCluster FROM OSPCluster ospCluster WHERE ";

	private static final String _SQL_COUNT_OSPCLUSTER =
		"SELECT COUNT(ospCluster) FROM OSPCluster ospCluster";

	private static final String _SQL_COUNT_OSPCLUSTER_WHERE =
		"SELECT COUNT(ospCluster) FROM OSPCluster ospCluster WHERE ";

	private static final String _ORDER_BY_ENTITY_ALIAS = "ospCluster.";

	private static final String _NO_SUCH_ENTITY_WITH_PRIMARY_KEY =
		"No OSPCluster exists with the primary key ";

	private static final String _NO_SUCH_ENTITY_WITH_KEY =
		"No OSPCluster exists with the key {";

	private static final Log _log = LogFactoryUtil.getLog(
		OSPClusterPersistenceImpl.class);

	private static final Set<String> _badColumnNames = SetUtil.fromArray(
		new String[] {"uuid"});

	static {
		try {
			Class.forName(ICEBREAKERPersistenceConstants.class.getName());
		}
		catch (ClassNotFoundException classNotFoundException) {
			throw new ExceptionInInitializerError(classNotFoundException);
		}
	}

}