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

import com.osp.icebreaker.exception.NoSuchJobException;
import com.osp.icebreaker.model.Job;
import com.osp.icebreaker.model.impl.JobImpl;
import com.osp.icebreaker.model.impl.JobModelImpl;
import com.osp.icebreaker.service.persistence.JobPersistence;
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
 * The persistence implementation for the job service.
 *
 * <p>
 * Caching information and settings can be found in <code>portal.properties</code>
 * </p>
 *
 * @author Jerry H. Seo
 * @generated
 */
@Component(service = JobPersistence.class)
@ProviderType
public class JobPersistenceImpl
	extends BasePersistenceImpl<Job> implements JobPersistence {

	/*
	 * NOTE FOR DEVELOPERS:
	 *
	 * Never modify or reference this class directly. Always use <code>JobUtil</code> to access the job persistence. Modify <code>service.xml</code> and rerun ServiceBuilder to regenerate this class.
	 */
	public static final String FINDER_CLASS_NAME_ENTITY =
		JobImpl.class.getName();

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
	 * Returns all the jobs where uuid = &#63;.
	 *
	 * @param uuid the uuid
	 * @return the matching jobs
	 */
	@Override
	public List<Job> findByUuid(String uuid) {
		return findByUuid(uuid, QueryUtil.ALL_POS, QueryUtil.ALL_POS, null);
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
	@Override
	public List<Job> findByUuid(String uuid, int start, int end) {
		return findByUuid(uuid, start, end, null);
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
	@Override
	public List<Job> findByUuid(
		String uuid, int start, int end,
		OrderByComparator<Job> orderByComparator) {

		return findByUuid(uuid, start, end, orderByComparator, true);
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
	@Override
	public List<Job> findByUuid(
		String uuid, int start, int end,
		OrderByComparator<Job> orderByComparator, boolean retrieveFromCache) {

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

		List<Job> list = null;

		if (retrieveFromCache) {
			list = (List<Job>)finderCache.getResult(
				finderPath, finderArgs, this);

			if ((list != null) && !list.isEmpty()) {
				for (Job job : list) {
					if (!uuid.equals(job.getUuid())) {
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

			query.append(_SQL_SELECT_JOB_WHERE);

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
				query.append(JobModelImpl.ORDER_BY_JPQL);
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
					list = (List<Job>)QueryUtil.list(
						q, getDialect(), start, end, false);

					Collections.sort(list);

					list = Collections.unmodifiableList(list);
				}
				else {
					list = (List<Job>)QueryUtil.list(
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
	 * Returns the first job in the ordered set where uuid = &#63;.
	 *
	 * @param uuid the uuid
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching job
	 * @throws NoSuchJobException if a matching job could not be found
	 */
	@Override
	public Job findByUuid_First(
			String uuid, OrderByComparator<Job> orderByComparator)
		throws NoSuchJobException {

		Job job = fetchByUuid_First(uuid, orderByComparator);

		if (job != null) {
			return job;
		}

		StringBundler msg = new StringBundler(4);

		msg.append(_NO_SUCH_ENTITY_WITH_KEY);

		msg.append("uuid=");
		msg.append(uuid);

		msg.append("}");

		throw new NoSuchJobException(msg.toString());
	}

	/**
	 * Returns the first job in the ordered set where uuid = &#63;.
	 *
	 * @param uuid the uuid
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching job, or <code>null</code> if a matching job could not be found
	 */
	@Override
	public Job fetchByUuid_First(
		String uuid, OrderByComparator<Job> orderByComparator) {

		List<Job> list = findByUuid(uuid, 0, 1, orderByComparator);

		if (!list.isEmpty()) {
			return list.get(0);
		}

		return null;
	}

	/**
	 * Returns the last job in the ordered set where uuid = &#63;.
	 *
	 * @param uuid the uuid
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching job
	 * @throws NoSuchJobException if a matching job could not be found
	 */
	@Override
	public Job findByUuid_Last(
			String uuid, OrderByComparator<Job> orderByComparator)
		throws NoSuchJobException {

		Job job = fetchByUuid_Last(uuid, orderByComparator);

		if (job != null) {
			return job;
		}

		StringBundler msg = new StringBundler(4);

		msg.append(_NO_SUCH_ENTITY_WITH_KEY);

		msg.append("uuid=");
		msg.append(uuid);

		msg.append("}");

		throw new NoSuchJobException(msg.toString());
	}

	/**
	 * Returns the last job in the ordered set where uuid = &#63;.
	 *
	 * @param uuid the uuid
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching job, or <code>null</code> if a matching job could not be found
	 */
	@Override
	public Job fetchByUuid_Last(
		String uuid, OrderByComparator<Job> orderByComparator) {

		int count = countByUuid(uuid);

		if (count == 0) {
			return null;
		}

		List<Job> list = findByUuid(uuid, count - 1, count, orderByComparator);

		if (!list.isEmpty()) {
			return list.get(0);
		}

		return null;
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
	@Override
	public Job[] findByUuid_PrevAndNext(
			long jobId, String uuid, OrderByComparator<Job> orderByComparator)
		throws NoSuchJobException {

		uuid = Objects.toString(uuid, "");

		Job job = findByPrimaryKey(jobId);

		Session session = null;

		try {
			session = openSession();

			Job[] array = new JobImpl[3];

			array[0] = getByUuid_PrevAndNext(
				session, job, uuid, orderByComparator, true);

			array[1] = job;

			array[2] = getByUuid_PrevAndNext(
				session, job, uuid, orderByComparator, false);

			return array;
		}
		catch (Exception e) {
			throw processException(e);
		}
		finally {
			closeSession(session);
		}
	}

	protected Job getByUuid_PrevAndNext(
		Session session, Job job, String uuid,
		OrderByComparator<Job> orderByComparator, boolean previous) {

		StringBundler query = null;

		if (orderByComparator != null) {
			query = new StringBundler(
				4 + (orderByComparator.getOrderByConditionFields().length * 3) +
					(orderByComparator.getOrderByFields().length * 3));
		}
		else {
			query = new StringBundler(3);
		}

		query.append(_SQL_SELECT_JOB_WHERE);

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
			query.append(JobModelImpl.ORDER_BY_JPQL);
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
					orderByComparator.getOrderByConditionValues(job)) {

				qPos.add(orderByConditionValue);
			}
		}

		List<Job> list = q.list();

		if (list.size() == 2) {
			return list.get(1);
		}
		else {
			return null;
		}
	}

	/**
	 * Removes all the jobs where uuid = &#63; from the database.
	 *
	 * @param uuid the uuid
	 */
	@Override
	public void removeByUuid(String uuid) {
		for (Job job :
				findByUuid(uuid, QueryUtil.ALL_POS, QueryUtil.ALL_POS, null)) {

			remove(job);
		}
	}

	/**
	 * Returns the number of jobs where uuid = &#63;.
	 *
	 * @param uuid the uuid
	 * @return the number of matching jobs
	 */
	@Override
	public int countByUuid(String uuid) {
		uuid = Objects.toString(uuid, "");

		FinderPath finderPath = _finderPathCountByUuid;

		Object[] finderArgs = new Object[] {uuid};

		Long count = (Long)finderCache.getResult(finderPath, finderArgs, this);

		if (count == null) {
			StringBundler query = new StringBundler(2);

			query.append(_SQL_COUNT_JOB_WHERE);

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

	private static final String _FINDER_COLUMN_UUID_UUID_2 = "job.uuid = ?";

	private static final String _FINDER_COLUMN_UUID_UUID_3 =
		"(job.uuid IS NULL OR job.uuid = '')";

	private FinderPath _finderPathFetchByUUID_G;
	private FinderPath _finderPathCountByUUID_G;

	/**
	 * Returns the job where uuid = &#63; and groupId = &#63; or throws a <code>NoSuchJobException</code> if it could not be found.
	 *
	 * @param uuid the uuid
	 * @param groupId the group ID
	 * @return the matching job
	 * @throws NoSuchJobException if a matching job could not be found
	 */
	@Override
	public Job findByUUID_G(String uuid, long groupId)
		throws NoSuchJobException {

		Job job = fetchByUUID_G(uuid, groupId);

		if (job == null) {
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

			throw new NoSuchJobException(msg.toString());
		}

		return job;
	}

	/**
	 * Returns the job where uuid = &#63; and groupId = &#63; or returns <code>null</code> if it could not be found. Uses the finder cache.
	 *
	 * @param uuid the uuid
	 * @param groupId the group ID
	 * @return the matching job, or <code>null</code> if a matching job could not be found
	 */
	@Override
	public Job fetchByUUID_G(String uuid, long groupId) {
		return fetchByUUID_G(uuid, groupId, true);
	}

	/**
	 * Returns the job where uuid = &#63; and groupId = &#63; or returns <code>null</code> if it could not be found, optionally using the finder cache.
	 *
	 * @param uuid the uuid
	 * @param groupId the group ID
	 * @param retrieveFromCache whether to retrieve from the finder cache
	 * @return the matching job, or <code>null</code> if a matching job could not be found
	 */
	@Override
	public Job fetchByUUID_G(
		String uuid, long groupId, boolean retrieveFromCache) {

		uuid = Objects.toString(uuid, "");

		Object[] finderArgs = new Object[] {uuid, groupId};

		Object result = null;

		if (retrieveFromCache) {
			result = finderCache.getResult(
				_finderPathFetchByUUID_G, finderArgs, this);
		}

		if (result instanceof Job) {
			Job job = (Job)result;

			if (!Objects.equals(uuid, job.getUuid()) ||
				(groupId != job.getGroupId())) {

				result = null;
			}
		}

		if (result == null) {
			StringBundler query = new StringBundler(4);

			query.append(_SQL_SELECT_JOB_WHERE);

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

				List<Job> list = q.list();

				if (list.isEmpty()) {
					finderCache.putResult(
						_finderPathFetchByUUID_G, finderArgs, list);
				}
				else {
					Job job = list.get(0);

					result = job;

					cacheResult(job);
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
			return (Job)result;
		}
	}

	/**
	 * Removes the job where uuid = &#63; and groupId = &#63; from the database.
	 *
	 * @param uuid the uuid
	 * @param groupId the group ID
	 * @return the job that was removed
	 */
	@Override
	public Job removeByUUID_G(String uuid, long groupId)
		throws NoSuchJobException {

		Job job = findByUUID_G(uuid, groupId);

		return remove(job);
	}

	/**
	 * Returns the number of jobs where uuid = &#63; and groupId = &#63;.
	 *
	 * @param uuid the uuid
	 * @param groupId the group ID
	 * @return the number of matching jobs
	 */
	@Override
	public int countByUUID_G(String uuid, long groupId) {
		uuid = Objects.toString(uuid, "");

		FinderPath finderPath = _finderPathCountByUUID_G;

		Object[] finderArgs = new Object[] {uuid, groupId};

		Long count = (Long)finderCache.getResult(finderPath, finderArgs, this);

		if (count == null) {
			StringBundler query = new StringBundler(3);

			query.append(_SQL_COUNT_JOB_WHERE);

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
		"job.uuid = ? AND ";

	private static final String _FINDER_COLUMN_UUID_G_UUID_3 =
		"(job.uuid IS NULL OR job.uuid = '') AND ";

	private static final String _FINDER_COLUMN_UUID_G_GROUPID_2 =
		"job.groupId = ?";

	private FinderPath _finderPathWithPaginationFindByUuid_C;
	private FinderPath _finderPathWithoutPaginationFindByUuid_C;
	private FinderPath _finderPathCountByUuid_C;

	/**
	 * Returns all the jobs where uuid = &#63; and companyId = &#63;.
	 *
	 * @param uuid the uuid
	 * @param companyId the company ID
	 * @return the matching jobs
	 */
	@Override
	public List<Job> findByUuid_C(String uuid, long companyId) {
		return findByUuid_C(
			uuid, companyId, QueryUtil.ALL_POS, QueryUtil.ALL_POS, null);
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
	@Override
	public List<Job> findByUuid_C(
		String uuid, long companyId, int start, int end) {

		return findByUuid_C(uuid, companyId, start, end, null);
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
	@Override
	public List<Job> findByUuid_C(
		String uuid, long companyId, int start, int end,
		OrderByComparator<Job> orderByComparator) {

		return findByUuid_C(
			uuid, companyId, start, end, orderByComparator, true);
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
	@Override
	public List<Job> findByUuid_C(
		String uuid, long companyId, int start, int end,
		OrderByComparator<Job> orderByComparator, boolean retrieveFromCache) {

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

		List<Job> list = null;

		if (retrieveFromCache) {
			list = (List<Job>)finderCache.getResult(
				finderPath, finderArgs, this);

			if ((list != null) && !list.isEmpty()) {
				for (Job job : list) {
					if (!uuid.equals(job.getUuid()) ||
						(companyId != job.getCompanyId())) {

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

			query.append(_SQL_SELECT_JOB_WHERE);

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
				query.append(JobModelImpl.ORDER_BY_JPQL);
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
					list = (List<Job>)QueryUtil.list(
						q, getDialect(), start, end, false);

					Collections.sort(list);

					list = Collections.unmodifiableList(list);
				}
				else {
					list = (List<Job>)QueryUtil.list(
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
	 * Returns the first job in the ordered set where uuid = &#63; and companyId = &#63;.
	 *
	 * @param uuid the uuid
	 * @param companyId the company ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching job
	 * @throws NoSuchJobException if a matching job could not be found
	 */
	@Override
	public Job findByUuid_C_First(
			String uuid, long companyId,
			OrderByComparator<Job> orderByComparator)
		throws NoSuchJobException {

		Job job = fetchByUuid_C_First(uuid, companyId, orderByComparator);

		if (job != null) {
			return job;
		}

		StringBundler msg = new StringBundler(6);

		msg.append(_NO_SUCH_ENTITY_WITH_KEY);

		msg.append("uuid=");
		msg.append(uuid);

		msg.append(", companyId=");
		msg.append(companyId);

		msg.append("}");

		throw new NoSuchJobException(msg.toString());
	}

	/**
	 * Returns the first job in the ordered set where uuid = &#63; and companyId = &#63;.
	 *
	 * @param uuid the uuid
	 * @param companyId the company ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching job, or <code>null</code> if a matching job could not be found
	 */
	@Override
	public Job fetchByUuid_C_First(
		String uuid, long companyId, OrderByComparator<Job> orderByComparator) {

		List<Job> list = findByUuid_C(uuid, companyId, 0, 1, orderByComparator);

		if (!list.isEmpty()) {
			return list.get(0);
		}

		return null;
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
	@Override
	public Job findByUuid_C_Last(
			String uuid, long companyId,
			OrderByComparator<Job> orderByComparator)
		throws NoSuchJobException {

		Job job = fetchByUuid_C_Last(uuid, companyId, orderByComparator);

		if (job != null) {
			return job;
		}

		StringBundler msg = new StringBundler(6);

		msg.append(_NO_SUCH_ENTITY_WITH_KEY);

		msg.append("uuid=");
		msg.append(uuid);

		msg.append(", companyId=");
		msg.append(companyId);

		msg.append("}");

		throw new NoSuchJobException(msg.toString());
	}

	/**
	 * Returns the last job in the ordered set where uuid = &#63; and companyId = &#63;.
	 *
	 * @param uuid the uuid
	 * @param companyId the company ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching job, or <code>null</code> if a matching job could not be found
	 */
	@Override
	public Job fetchByUuid_C_Last(
		String uuid, long companyId, OrderByComparator<Job> orderByComparator) {

		int count = countByUuid_C(uuid, companyId);

		if (count == 0) {
			return null;
		}

		List<Job> list = findByUuid_C(
			uuid, companyId, count - 1, count, orderByComparator);

		if (!list.isEmpty()) {
			return list.get(0);
		}

		return null;
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
	@Override
	public Job[] findByUuid_C_PrevAndNext(
			long jobId, String uuid, long companyId,
			OrderByComparator<Job> orderByComparator)
		throws NoSuchJobException {

		uuid = Objects.toString(uuid, "");

		Job job = findByPrimaryKey(jobId);

		Session session = null;

		try {
			session = openSession();

			Job[] array = new JobImpl[3];

			array[0] = getByUuid_C_PrevAndNext(
				session, job, uuid, companyId, orderByComparator, true);

			array[1] = job;

			array[2] = getByUuid_C_PrevAndNext(
				session, job, uuid, companyId, orderByComparator, false);

			return array;
		}
		catch (Exception e) {
			throw processException(e);
		}
		finally {
			closeSession(session);
		}
	}

	protected Job getByUuid_C_PrevAndNext(
		Session session, Job job, String uuid, long companyId,
		OrderByComparator<Job> orderByComparator, boolean previous) {

		StringBundler query = null;

		if (orderByComparator != null) {
			query = new StringBundler(
				5 + (orderByComparator.getOrderByConditionFields().length * 3) +
					(orderByComparator.getOrderByFields().length * 3));
		}
		else {
			query = new StringBundler(4);
		}

		query.append(_SQL_SELECT_JOB_WHERE);

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
			query.append(JobModelImpl.ORDER_BY_JPQL);
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
					orderByComparator.getOrderByConditionValues(job)) {

				qPos.add(orderByConditionValue);
			}
		}

		List<Job> list = q.list();

		if (list.size() == 2) {
			return list.get(1);
		}
		else {
			return null;
		}
	}

	/**
	 * Removes all the jobs where uuid = &#63; and companyId = &#63; from the database.
	 *
	 * @param uuid the uuid
	 * @param companyId the company ID
	 */
	@Override
	public void removeByUuid_C(String uuid, long companyId) {
		for (Job job :
				findByUuid_C(
					uuid, companyId, QueryUtil.ALL_POS, QueryUtil.ALL_POS,
					null)) {

			remove(job);
		}
	}

	/**
	 * Returns the number of jobs where uuid = &#63; and companyId = &#63;.
	 *
	 * @param uuid the uuid
	 * @param companyId the company ID
	 * @return the number of matching jobs
	 */
	@Override
	public int countByUuid_C(String uuid, long companyId) {
		uuid = Objects.toString(uuid, "");

		FinderPath finderPath = _finderPathCountByUuid_C;

		Object[] finderArgs = new Object[] {uuid, companyId};

		Long count = (Long)finderCache.getResult(finderPath, finderArgs, this);

		if (count == null) {
			StringBundler query = new StringBundler(3);

			query.append(_SQL_COUNT_JOB_WHERE);

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
		"job.uuid = ? AND ";

	private static final String _FINDER_COLUMN_UUID_C_UUID_3 =
		"(job.uuid IS NULL OR job.uuid = '') AND ";

	private static final String _FINDER_COLUMN_UUID_C_COMPANYID_2 =
		"job.companyId = ?";

	private FinderPath _finderPathWithPaginationFindByGroupId;
	private FinderPath _finderPathWithoutPaginationFindByGroupId;
	private FinderPath _finderPathCountByGroupId;

	/**
	 * Returns all the jobs where groupId = &#63;.
	 *
	 * @param groupId the group ID
	 * @return the matching jobs
	 */
	@Override
	public List<Job> findByGroupId(long groupId) {
		return findByGroupId(
			groupId, QueryUtil.ALL_POS, QueryUtil.ALL_POS, null);
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
	@Override
	public List<Job> findByGroupId(long groupId, int start, int end) {
		return findByGroupId(groupId, start, end, null);
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
	@Override
	public List<Job> findByGroupId(
		long groupId, int start, int end,
		OrderByComparator<Job> orderByComparator) {

		return findByGroupId(groupId, start, end, orderByComparator, true);
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
	@Override
	public List<Job> findByGroupId(
		long groupId, int start, int end,
		OrderByComparator<Job> orderByComparator, boolean retrieveFromCache) {

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

		List<Job> list = null;

		if (retrieveFromCache) {
			list = (List<Job>)finderCache.getResult(
				finderPath, finderArgs, this);

			if ((list != null) && !list.isEmpty()) {
				for (Job job : list) {
					if ((groupId != job.getGroupId())) {
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

			query.append(_SQL_SELECT_JOB_WHERE);

			query.append(_FINDER_COLUMN_GROUPID_GROUPID_2);

			if (orderByComparator != null) {
				appendOrderByComparator(
					query, _ORDER_BY_ENTITY_ALIAS, orderByComparator);
			}
			else if (pagination) {
				query.append(JobModelImpl.ORDER_BY_JPQL);
			}

			String sql = query.toString();

			Session session = null;

			try {
				session = openSession();

				Query q = session.createQuery(sql);

				QueryPos qPos = QueryPos.getInstance(q);

				qPos.add(groupId);

				if (!pagination) {
					list = (List<Job>)QueryUtil.list(
						q, getDialect(), start, end, false);

					Collections.sort(list);

					list = Collections.unmodifiableList(list);
				}
				else {
					list = (List<Job>)QueryUtil.list(
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
	 * Returns the first job in the ordered set where groupId = &#63;.
	 *
	 * @param groupId the group ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching job
	 * @throws NoSuchJobException if a matching job could not be found
	 */
	@Override
	public Job findByGroupId_First(
			long groupId, OrderByComparator<Job> orderByComparator)
		throws NoSuchJobException {

		Job job = fetchByGroupId_First(groupId, orderByComparator);

		if (job != null) {
			return job;
		}

		StringBundler msg = new StringBundler(4);

		msg.append(_NO_SUCH_ENTITY_WITH_KEY);

		msg.append("groupId=");
		msg.append(groupId);

		msg.append("}");

		throw new NoSuchJobException(msg.toString());
	}

	/**
	 * Returns the first job in the ordered set where groupId = &#63;.
	 *
	 * @param groupId the group ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching job, or <code>null</code> if a matching job could not be found
	 */
	@Override
	public Job fetchByGroupId_First(
		long groupId, OrderByComparator<Job> orderByComparator) {

		List<Job> list = findByGroupId(groupId, 0, 1, orderByComparator);

		if (!list.isEmpty()) {
			return list.get(0);
		}

		return null;
	}

	/**
	 * Returns the last job in the ordered set where groupId = &#63;.
	 *
	 * @param groupId the group ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching job
	 * @throws NoSuchJobException if a matching job could not be found
	 */
	@Override
	public Job findByGroupId_Last(
			long groupId, OrderByComparator<Job> orderByComparator)
		throws NoSuchJobException {

		Job job = fetchByGroupId_Last(groupId, orderByComparator);

		if (job != null) {
			return job;
		}

		StringBundler msg = new StringBundler(4);

		msg.append(_NO_SUCH_ENTITY_WITH_KEY);

		msg.append("groupId=");
		msg.append(groupId);

		msg.append("}");

		throw new NoSuchJobException(msg.toString());
	}

	/**
	 * Returns the last job in the ordered set where groupId = &#63;.
	 *
	 * @param groupId the group ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching job, or <code>null</code> if a matching job could not be found
	 */
	@Override
	public Job fetchByGroupId_Last(
		long groupId, OrderByComparator<Job> orderByComparator) {

		int count = countByGroupId(groupId);

		if (count == 0) {
			return null;
		}

		List<Job> list = findByGroupId(
			groupId, count - 1, count, orderByComparator);

		if (!list.isEmpty()) {
			return list.get(0);
		}

		return null;
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
	@Override
	public Job[] findByGroupId_PrevAndNext(
			long jobId, long groupId, OrderByComparator<Job> orderByComparator)
		throws NoSuchJobException {

		Job job = findByPrimaryKey(jobId);

		Session session = null;

		try {
			session = openSession();

			Job[] array = new JobImpl[3];

			array[0] = getByGroupId_PrevAndNext(
				session, job, groupId, orderByComparator, true);

			array[1] = job;

			array[2] = getByGroupId_PrevAndNext(
				session, job, groupId, orderByComparator, false);

			return array;
		}
		catch (Exception e) {
			throw processException(e);
		}
		finally {
			closeSession(session);
		}
	}

	protected Job getByGroupId_PrevAndNext(
		Session session, Job job, long groupId,
		OrderByComparator<Job> orderByComparator, boolean previous) {

		StringBundler query = null;

		if (orderByComparator != null) {
			query = new StringBundler(
				4 + (orderByComparator.getOrderByConditionFields().length * 3) +
					(orderByComparator.getOrderByFields().length * 3));
		}
		else {
			query = new StringBundler(3);
		}

		query.append(_SQL_SELECT_JOB_WHERE);

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
			query.append(JobModelImpl.ORDER_BY_JPQL);
		}

		String sql = query.toString();

		Query q = session.createQuery(sql);

		q.setFirstResult(0);
		q.setMaxResults(2);

		QueryPos qPos = QueryPos.getInstance(q);

		qPos.add(groupId);

		if (orderByComparator != null) {
			for (Object orderByConditionValue :
					orderByComparator.getOrderByConditionValues(job)) {

				qPos.add(orderByConditionValue);
			}
		}

		List<Job> list = q.list();

		if (list.size() == 2) {
			return list.get(1);
		}
		else {
			return null;
		}
	}

	/**
	 * Removes all the jobs where groupId = &#63; from the database.
	 *
	 * @param groupId the group ID
	 */
	@Override
	public void removeByGroupId(long groupId) {
		for (Job job :
				findByGroupId(
					groupId, QueryUtil.ALL_POS, QueryUtil.ALL_POS, null)) {

			remove(job);
		}
	}

	/**
	 * Returns the number of jobs where groupId = &#63;.
	 *
	 * @param groupId the group ID
	 * @return the number of matching jobs
	 */
	@Override
	public int countByGroupId(long groupId) {
		FinderPath finderPath = _finderPathCountByGroupId;

		Object[] finderArgs = new Object[] {groupId};

		Long count = (Long)finderCache.getResult(finderPath, finderArgs, this);

		if (count == null) {
			StringBundler query = new StringBundler(2);

			query.append(_SQL_COUNT_JOB_WHERE);

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
		"job.groupId = ?";

	private FinderPath _finderPathWithPaginationFindByUserId;
	private FinderPath _finderPathWithoutPaginationFindByUserId;
	private FinderPath _finderPathCountByUserId;

	/**
	 * Returns all the jobs where userId = &#63;.
	 *
	 * @param userId the user ID
	 * @return the matching jobs
	 */
	@Override
	public List<Job> findByUserId(long userId) {
		return findByUserId(userId, QueryUtil.ALL_POS, QueryUtil.ALL_POS, null);
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
	@Override
	public List<Job> findByUserId(long userId, int start, int end) {
		return findByUserId(userId, start, end, null);
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
	@Override
	public List<Job> findByUserId(
		long userId, int start, int end,
		OrderByComparator<Job> orderByComparator) {

		return findByUserId(userId, start, end, orderByComparator, true);
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
	@Override
	public List<Job> findByUserId(
		long userId, int start, int end,
		OrderByComparator<Job> orderByComparator, boolean retrieveFromCache) {

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

		List<Job> list = null;

		if (retrieveFromCache) {
			list = (List<Job>)finderCache.getResult(
				finderPath, finderArgs, this);

			if ((list != null) && !list.isEmpty()) {
				for (Job job : list) {
					if ((userId != job.getUserId())) {
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

			query.append(_SQL_SELECT_JOB_WHERE);

			query.append(_FINDER_COLUMN_USERID_USERID_2);

			if (orderByComparator != null) {
				appendOrderByComparator(
					query, _ORDER_BY_ENTITY_ALIAS, orderByComparator);
			}
			else if (pagination) {
				query.append(JobModelImpl.ORDER_BY_JPQL);
			}

			String sql = query.toString();

			Session session = null;

			try {
				session = openSession();

				Query q = session.createQuery(sql);

				QueryPos qPos = QueryPos.getInstance(q);

				qPos.add(userId);

				if (!pagination) {
					list = (List<Job>)QueryUtil.list(
						q, getDialect(), start, end, false);

					Collections.sort(list);

					list = Collections.unmodifiableList(list);
				}
				else {
					list = (List<Job>)QueryUtil.list(
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
	 * Returns the first job in the ordered set where userId = &#63;.
	 *
	 * @param userId the user ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching job
	 * @throws NoSuchJobException if a matching job could not be found
	 */
	@Override
	public Job findByUserId_First(
			long userId, OrderByComparator<Job> orderByComparator)
		throws NoSuchJobException {

		Job job = fetchByUserId_First(userId, orderByComparator);

		if (job != null) {
			return job;
		}

		StringBundler msg = new StringBundler(4);

		msg.append(_NO_SUCH_ENTITY_WITH_KEY);

		msg.append("userId=");
		msg.append(userId);

		msg.append("}");

		throw new NoSuchJobException(msg.toString());
	}

	/**
	 * Returns the first job in the ordered set where userId = &#63;.
	 *
	 * @param userId the user ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching job, or <code>null</code> if a matching job could not be found
	 */
	@Override
	public Job fetchByUserId_First(
		long userId, OrderByComparator<Job> orderByComparator) {

		List<Job> list = findByUserId(userId, 0, 1, orderByComparator);

		if (!list.isEmpty()) {
			return list.get(0);
		}

		return null;
	}

	/**
	 * Returns the last job in the ordered set where userId = &#63;.
	 *
	 * @param userId the user ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching job
	 * @throws NoSuchJobException if a matching job could not be found
	 */
	@Override
	public Job findByUserId_Last(
			long userId, OrderByComparator<Job> orderByComparator)
		throws NoSuchJobException {

		Job job = fetchByUserId_Last(userId, orderByComparator);

		if (job != null) {
			return job;
		}

		StringBundler msg = new StringBundler(4);

		msg.append(_NO_SUCH_ENTITY_WITH_KEY);

		msg.append("userId=");
		msg.append(userId);

		msg.append("}");

		throw new NoSuchJobException(msg.toString());
	}

	/**
	 * Returns the last job in the ordered set where userId = &#63;.
	 *
	 * @param userId the user ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching job, or <code>null</code> if a matching job could not be found
	 */
	@Override
	public Job fetchByUserId_Last(
		long userId, OrderByComparator<Job> orderByComparator) {

		int count = countByUserId(userId);

		if (count == 0) {
			return null;
		}

		List<Job> list = findByUserId(
			userId, count - 1, count, orderByComparator);

		if (!list.isEmpty()) {
			return list.get(0);
		}

		return null;
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
	@Override
	public Job[] findByUserId_PrevAndNext(
			long jobId, long userId, OrderByComparator<Job> orderByComparator)
		throws NoSuchJobException {

		Job job = findByPrimaryKey(jobId);

		Session session = null;

		try {
			session = openSession();

			Job[] array = new JobImpl[3];

			array[0] = getByUserId_PrevAndNext(
				session, job, userId, orderByComparator, true);

			array[1] = job;

			array[2] = getByUserId_PrevAndNext(
				session, job, userId, orderByComparator, false);

			return array;
		}
		catch (Exception e) {
			throw processException(e);
		}
		finally {
			closeSession(session);
		}
	}

	protected Job getByUserId_PrevAndNext(
		Session session, Job job, long userId,
		OrderByComparator<Job> orderByComparator, boolean previous) {

		StringBundler query = null;

		if (orderByComparator != null) {
			query = new StringBundler(
				4 + (orderByComparator.getOrderByConditionFields().length * 3) +
					(orderByComparator.getOrderByFields().length * 3));
		}
		else {
			query = new StringBundler(3);
		}

		query.append(_SQL_SELECT_JOB_WHERE);

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
			query.append(JobModelImpl.ORDER_BY_JPQL);
		}

		String sql = query.toString();

		Query q = session.createQuery(sql);

		q.setFirstResult(0);
		q.setMaxResults(2);

		QueryPos qPos = QueryPos.getInstance(q);

		qPos.add(userId);

		if (orderByComparator != null) {
			for (Object orderByConditionValue :
					orderByComparator.getOrderByConditionValues(job)) {

				qPos.add(orderByConditionValue);
			}
		}

		List<Job> list = q.list();

		if (list.size() == 2) {
			return list.get(1);
		}
		else {
			return null;
		}
	}

	/**
	 * Removes all the jobs where userId = &#63; from the database.
	 *
	 * @param userId the user ID
	 */
	@Override
	public void removeByUserId(long userId) {
		for (Job job :
				findByUserId(
					userId, QueryUtil.ALL_POS, QueryUtil.ALL_POS, null)) {

			remove(job);
		}
	}

	/**
	 * Returns the number of jobs where userId = &#63;.
	 *
	 * @param userId the user ID
	 * @return the number of matching jobs
	 */
	@Override
	public int countByUserId(long userId) {
		FinderPath finderPath = _finderPathCountByUserId;

		Object[] finderArgs = new Object[] {userId};

		Long count = (Long)finderCache.getResult(finderPath, finderArgs, this);

		if (count == null) {
			StringBundler query = new StringBundler(2);

			query.append(_SQL_COUNT_JOB_WHERE);

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
		"job.userId = ?";

	private FinderPath _finderPathWithPaginationFindByUserId_G;
	private FinderPath _finderPathWithoutPaginationFindByUserId_G;
	private FinderPath _finderPathCountByUserId_G;

	/**
	 * Returns all the jobs where groupId = &#63; and userId = &#63;.
	 *
	 * @param groupId the group ID
	 * @param userId the user ID
	 * @return the matching jobs
	 */
	@Override
	public List<Job> findByUserId_G(long groupId, long userId) {
		return findByUserId_G(
			groupId, userId, QueryUtil.ALL_POS, QueryUtil.ALL_POS, null);
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
	@Override
	public List<Job> findByUserId_G(
		long groupId, long userId, int start, int end) {

		return findByUserId_G(groupId, userId, start, end, null);
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
	@Override
	public List<Job> findByUserId_G(
		long groupId, long userId, int start, int end,
		OrderByComparator<Job> orderByComparator) {

		return findByUserId_G(
			groupId, userId, start, end, orderByComparator, true);
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
	@Override
	public List<Job> findByUserId_G(
		long groupId, long userId, int start, int end,
		OrderByComparator<Job> orderByComparator, boolean retrieveFromCache) {

		boolean pagination = true;
		FinderPath finderPath = null;
		Object[] finderArgs = null;

		if ((start == QueryUtil.ALL_POS) && (end == QueryUtil.ALL_POS) &&
			(orderByComparator == null)) {

			pagination = false;
			finderPath = _finderPathWithoutPaginationFindByUserId_G;
			finderArgs = new Object[] {groupId, userId};
		}
		else {
			finderPath = _finderPathWithPaginationFindByUserId_G;
			finderArgs = new Object[] {
				groupId, userId, start, end, orderByComparator
			};
		}

		List<Job> list = null;

		if (retrieveFromCache) {
			list = (List<Job>)finderCache.getResult(
				finderPath, finderArgs, this);

			if ((list != null) && !list.isEmpty()) {
				for (Job job : list) {
					if ((groupId != job.getGroupId()) ||
						(userId != job.getUserId())) {

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

			query.append(_SQL_SELECT_JOB_WHERE);

			query.append(_FINDER_COLUMN_USERID_G_GROUPID_2);

			query.append(_FINDER_COLUMN_USERID_G_USERID_2);

			if (orderByComparator != null) {
				appendOrderByComparator(
					query, _ORDER_BY_ENTITY_ALIAS, orderByComparator);
			}
			else if (pagination) {
				query.append(JobModelImpl.ORDER_BY_JPQL);
			}

			String sql = query.toString();

			Session session = null;

			try {
				session = openSession();

				Query q = session.createQuery(sql);

				QueryPos qPos = QueryPos.getInstance(q);

				qPos.add(groupId);

				qPos.add(userId);

				if (!pagination) {
					list = (List<Job>)QueryUtil.list(
						q, getDialect(), start, end, false);

					Collections.sort(list);

					list = Collections.unmodifiableList(list);
				}
				else {
					list = (List<Job>)QueryUtil.list(
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
	 * Returns the first job in the ordered set where groupId = &#63; and userId = &#63;.
	 *
	 * @param groupId the group ID
	 * @param userId the user ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching job
	 * @throws NoSuchJobException if a matching job could not be found
	 */
	@Override
	public Job findByUserId_G_First(
			long groupId, long userId, OrderByComparator<Job> orderByComparator)
		throws NoSuchJobException {

		Job job = fetchByUserId_G_First(groupId, userId, orderByComparator);

		if (job != null) {
			return job;
		}

		StringBundler msg = new StringBundler(6);

		msg.append(_NO_SUCH_ENTITY_WITH_KEY);

		msg.append("groupId=");
		msg.append(groupId);

		msg.append(", userId=");
		msg.append(userId);

		msg.append("}");

		throw new NoSuchJobException(msg.toString());
	}

	/**
	 * Returns the first job in the ordered set where groupId = &#63; and userId = &#63;.
	 *
	 * @param groupId the group ID
	 * @param userId the user ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching job, or <code>null</code> if a matching job could not be found
	 */
	@Override
	public Job fetchByUserId_G_First(
		long groupId, long userId, OrderByComparator<Job> orderByComparator) {

		List<Job> list = findByUserId_G(
			groupId, userId, 0, 1, orderByComparator);

		if (!list.isEmpty()) {
			return list.get(0);
		}

		return null;
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
	@Override
	public Job findByUserId_G_Last(
			long groupId, long userId, OrderByComparator<Job> orderByComparator)
		throws NoSuchJobException {

		Job job = fetchByUserId_G_Last(groupId, userId, orderByComparator);

		if (job != null) {
			return job;
		}

		StringBundler msg = new StringBundler(6);

		msg.append(_NO_SUCH_ENTITY_WITH_KEY);

		msg.append("groupId=");
		msg.append(groupId);

		msg.append(", userId=");
		msg.append(userId);

		msg.append("}");

		throw new NoSuchJobException(msg.toString());
	}

	/**
	 * Returns the last job in the ordered set where groupId = &#63; and userId = &#63;.
	 *
	 * @param groupId the group ID
	 * @param userId the user ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching job, or <code>null</code> if a matching job could not be found
	 */
	@Override
	public Job fetchByUserId_G_Last(
		long groupId, long userId, OrderByComparator<Job> orderByComparator) {

		int count = countByUserId_G(groupId, userId);

		if (count == 0) {
			return null;
		}

		List<Job> list = findByUserId_G(
			groupId, userId, count - 1, count, orderByComparator);

		if (!list.isEmpty()) {
			return list.get(0);
		}

		return null;
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
	@Override
	public Job[] findByUserId_G_PrevAndNext(
			long jobId, long groupId, long userId,
			OrderByComparator<Job> orderByComparator)
		throws NoSuchJobException {

		Job job = findByPrimaryKey(jobId);

		Session session = null;

		try {
			session = openSession();

			Job[] array = new JobImpl[3];

			array[0] = getByUserId_G_PrevAndNext(
				session, job, groupId, userId, orderByComparator, true);

			array[1] = job;

			array[2] = getByUserId_G_PrevAndNext(
				session, job, groupId, userId, orderByComparator, false);

			return array;
		}
		catch (Exception e) {
			throw processException(e);
		}
		finally {
			closeSession(session);
		}
	}

	protected Job getByUserId_G_PrevAndNext(
		Session session, Job job, long groupId, long userId,
		OrderByComparator<Job> orderByComparator, boolean previous) {

		StringBundler query = null;

		if (orderByComparator != null) {
			query = new StringBundler(
				5 + (orderByComparator.getOrderByConditionFields().length * 3) +
					(orderByComparator.getOrderByFields().length * 3));
		}
		else {
			query = new StringBundler(4);
		}

		query.append(_SQL_SELECT_JOB_WHERE);

		query.append(_FINDER_COLUMN_USERID_G_GROUPID_2);

		query.append(_FINDER_COLUMN_USERID_G_USERID_2);

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
			query.append(JobModelImpl.ORDER_BY_JPQL);
		}

		String sql = query.toString();

		Query q = session.createQuery(sql);

		q.setFirstResult(0);
		q.setMaxResults(2);

		QueryPos qPos = QueryPos.getInstance(q);

		qPos.add(groupId);

		qPos.add(userId);

		if (orderByComparator != null) {
			for (Object orderByConditionValue :
					orderByComparator.getOrderByConditionValues(job)) {

				qPos.add(orderByConditionValue);
			}
		}

		List<Job> list = q.list();

		if (list.size() == 2) {
			return list.get(1);
		}
		else {
			return null;
		}
	}

	/**
	 * Removes all the jobs where groupId = &#63; and userId = &#63; from the database.
	 *
	 * @param groupId the group ID
	 * @param userId the user ID
	 */
	@Override
	public void removeByUserId_G(long groupId, long userId) {
		for (Job job :
				findByUserId_G(
					groupId, userId, QueryUtil.ALL_POS, QueryUtil.ALL_POS,
					null)) {

			remove(job);
		}
	}

	/**
	 * Returns the number of jobs where groupId = &#63; and userId = &#63;.
	 *
	 * @param groupId the group ID
	 * @param userId the user ID
	 * @return the number of matching jobs
	 */
	@Override
	public int countByUserId_G(long groupId, long userId) {
		FinderPath finderPath = _finderPathCountByUserId_G;

		Object[] finderArgs = new Object[] {groupId, userId};

		Long count = (Long)finderCache.getResult(finderPath, finderArgs, this);

		if (count == null) {
			StringBundler query = new StringBundler(3);

			query.append(_SQL_COUNT_JOB_WHERE);

			query.append(_FINDER_COLUMN_USERID_G_GROUPID_2);

			query.append(_FINDER_COLUMN_USERID_G_USERID_2);

			String sql = query.toString();

			Session session = null;

			try {
				session = openSession();

				Query q = session.createQuery(sql);

				QueryPos qPos = QueryPos.getInstance(q);

				qPos.add(groupId);

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

	private static final String _FINDER_COLUMN_USERID_G_GROUPID_2 =
		"job.groupId = ? AND ";

	private static final String _FINDER_COLUMN_USERID_G_USERID_2 =
		"job.userId = ?";

	private FinderPath _finderPathWithPaginationFindByStatus;
	private FinderPath _finderPathWithoutPaginationFindByStatus;
	private FinderPath _finderPathCountByStatus;

	/**
	 * Returns all the jobs where status = &#63;.
	 *
	 * @param status the status
	 * @return the matching jobs
	 */
	@Override
	public List<Job> findByStatus(int status) {
		return findByStatus(status, QueryUtil.ALL_POS, QueryUtil.ALL_POS, null);
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
	@Override
	public List<Job> findByStatus(int status, int start, int end) {
		return findByStatus(status, start, end, null);
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
	@Override
	public List<Job> findByStatus(
		int status, int start, int end,
		OrderByComparator<Job> orderByComparator) {

		return findByStatus(status, start, end, orderByComparator, true);
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
	@Override
	public List<Job> findByStatus(
		int status, int start, int end,
		OrderByComparator<Job> orderByComparator, boolean retrieveFromCache) {

		boolean pagination = true;
		FinderPath finderPath = null;
		Object[] finderArgs = null;

		if ((start == QueryUtil.ALL_POS) && (end == QueryUtil.ALL_POS) &&
			(orderByComparator == null)) {

			pagination = false;
			finderPath = _finderPathWithoutPaginationFindByStatus;
			finderArgs = new Object[] {status};
		}
		else {
			finderPath = _finderPathWithPaginationFindByStatus;
			finderArgs = new Object[] {status, start, end, orderByComparator};
		}

		List<Job> list = null;

		if (retrieveFromCache) {
			list = (List<Job>)finderCache.getResult(
				finderPath, finderArgs, this);

			if ((list != null) && !list.isEmpty()) {
				for (Job job : list) {
					if ((status != job.getStatus())) {
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

			query.append(_SQL_SELECT_JOB_WHERE);

			query.append(_FINDER_COLUMN_STATUS_STATUS_2);

			if (orderByComparator != null) {
				appendOrderByComparator(
					query, _ORDER_BY_ENTITY_ALIAS, orderByComparator);
			}
			else if (pagination) {
				query.append(JobModelImpl.ORDER_BY_JPQL);
			}

			String sql = query.toString();

			Session session = null;

			try {
				session = openSession();

				Query q = session.createQuery(sql);

				QueryPos qPos = QueryPos.getInstance(q);

				qPos.add(status);

				if (!pagination) {
					list = (List<Job>)QueryUtil.list(
						q, getDialect(), start, end, false);

					Collections.sort(list);

					list = Collections.unmodifiableList(list);
				}
				else {
					list = (List<Job>)QueryUtil.list(
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
	 * Returns the first job in the ordered set where status = &#63;.
	 *
	 * @param status the status
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching job
	 * @throws NoSuchJobException if a matching job could not be found
	 */
	@Override
	public Job findByStatus_First(
			int status, OrderByComparator<Job> orderByComparator)
		throws NoSuchJobException {

		Job job = fetchByStatus_First(status, orderByComparator);

		if (job != null) {
			return job;
		}

		StringBundler msg = new StringBundler(4);

		msg.append(_NO_SUCH_ENTITY_WITH_KEY);

		msg.append("status=");
		msg.append(status);

		msg.append("}");

		throw new NoSuchJobException(msg.toString());
	}

	/**
	 * Returns the first job in the ordered set where status = &#63;.
	 *
	 * @param status the status
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching job, or <code>null</code> if a matching job could not be found
	 */
	@Override
	public Job fetchByStatus_First(
		int status, OrderByComparator<Job> orderByComparator) {

		List<Job> list = findByStatus(status, 0, 1, orderByComparator);

		if (!list.isEmpty()) {
			return list.get(0);
		}

		return null;
	}

	/**
	 * Returns the last job in the ordered set where status = &#63;.
	 *
	 * @param status the status
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching job
	 * @throws NoSuchJobException if a matching job could not be found
	 */
	@Override
	public Job findByStatus_Last(
			int status, OrderByComparator<Job> orderByComparator)
		throws NoSuchJobException {

		Job job = fetchByStatus_Last(status, orderByComparator);

		if (job != null) {
			return job;
		}

		StringBundler msg = new StringBundler(4);

		msg.append(_NO_SUCH_ENTITY_WITH_KEY);

		msg.append("status=");
		msg.append(status);

		msg.append("}");

		throw new NoSuchJobException(msg.toString());
	}

	/**
	 * Returns the last job in the ordered set where status = &#63;.
	 *
	 * @param status the status
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching job, or <code>null</code> if a matching job could not be found
	 */
	@Override
	public Job fetchByStatus_Last(
		int status, OrderByComparator<Job> orderByComparator) {

		int count = countByStatus(status);

		if (count == 0) {
			return null;
		}

		List<Job> list = findByStatus(
			status, count - 1, count, orderByComparator);

		if (!list.isEmpty()) {
			return list.get(0);
		}

		return null;
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
	@Override
	public Job[] findByStatus_PrevAndNext(
			long jobId, int status, OrderByComparator<Job> orderByComparator)
		throws NoSuchJobException {

		Job job = findByPrimaryKey(jobId);

		Session session = null;

		try {
			session = openSession();

			Job[] array = new JobImpl[3];

			array[0] = getByStatus_PrevAndNext(
				session, job, status, orderByComparator, true);

			array[1] = job;

			array[2] = getByStatus_PrevAndNext(
				session, job, status, orderByComparator, false);

			return array;
		}
		catch (Exception e) {
			throw processException(e);
		}
		finally {
			closeSession(session);
		}
	}

	protected Job getByStatus_PrevAndNext(
		Session session, Job job, int status,
		OrderByComparator<Job> orderByComparator, boolean previous) {

		StringBundler query = null;

		if (orderByComparator != null) {
			query = new StringBundler(
				4 + (orderByComparator.getOrderByConditionFields().length * 3) +
					(orderByComparator.getOrderByFields().length * 3));
		}
		else {
			query = new StringBundler(3);
		}

		query.append(_SQL_SELECT_JOB_WHERE);

		query.append(_FINDER_COLUMN_STATUS_STATUS_2);

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
			query.append(JobModelImpl.ORDER_BY_JPQL);
		}

		String sql = query.toString();

		Query q = session.createQuery(sql);

		q.setFirstResult(0);
		q.setMaxResults(2);

		QueryPos qPos = QueryPos.getInstance(q);

		qPos.add(status);

		if (orderByComparator != null) {
			for (Object orderByConditionValue :
					orderByComparator.getOrderByConditionValues(job)) {

				qPos.add(orderByConditionValue);
			}
		}

		List<Job> list = q.list();

		if (list.size() == 2) {
			return list.get(1);
		}
		else {
			return null;
		}
	}

	/**
	 * Removes all the jobs where status = &#63; from the database.
	 *
	 * @param status the status
	 */
	@Override
	public void removeByStatus(int status) {
		for (Job job :
				findByStatus(
					status, QueryUtil.ALL_POS, QueryUtil.ALL_POS, null)) {

			remove(job);
		}
	}

	/**
	 * Returns the number of jobs where status = &#63;.
	 *
	 * @param status the status
	 * @return the number of matching jobs
	 */
	@Override
	public int countByStatus(int status) {
		FinderPath finderPath = _finderPathCountByStatus;

		Object[] finderArgs = new Object[] {status};

		Long count = (Long)finderCache.getResult(finderPath, finderArgs, this);

		if (count == null) {
			StringBundler query = new StringBundler(2);

			query.append(_SQL_COUNT_JOB_WHERE);

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
		"job.status = ?";

	private FinderPath _finderPathWithPaginationFindByStatus_G;
	private FinderPath _finderPathWithoutPaginationFindByStatus_G;
	private FinderPath _finderPathCountByStatus_G;

	/**
	 * Returns all the jobs where groupId = &#63; and status = &#63;.
	 *
	 * @param groupId the group ID
	 * @param status the status
	 * @return the matching jobs
	 */
	@Override
	public List<Job> findByStatus_G(long groupId, int status) {
		return findByStatus_G(
			groupId, status, QueryUtil.ALL_POS, QueryUtil.ALL_POS, null);
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
	@Override
	public List<Job> findByStatus_G(
		long groupId, int status, int start, int end) {

		return findByStatus_G(groupId, status, start, end, null);
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
	@Override
	public List<Job> findByStatus_G(
		long groupId, int status, int start, int end,
		OrderByComparator<Job> orderByComparator) {

		return findByStatus_G(
			groupId, status, start, end, orderByComparator, true);
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
	@Override
	public List<Job> findByStatus_G(
		long groupId, int status, int start, int end,
		OrderByComparator<Job> orderByComparator, boolean retrieveFromCache) {

		boolean pagination = true;
		FinderPath finderPath = null;
		Object[] finderArgs = null;

		if ((start == QueryUtil.ALL_POS) && (end == QueryUtil.ALL_POS) &&
			(orderByComparator == null)) {

			pagination = false;
			finderPath = _finderPathWithoutPaginationFindByStatus_G;
			finderArgs = new Object[] {groupId, status};
		}
		else {
			finderPath = _finderPathWithPaginationFindByStatus_G;
			finderArgs = new Object[] {
				groupId, status, start, end, orderByComparator
			};
		}

		List<Job> list = null;

		if (retrieveFromCache) {
			list = (List<Job>)finderCache.getResult(
				finderPath, finderArgs, this);

			if ((list != null) && !list.isEmpty()) {
				for (Job job : list) {
					if ((groupId != job.getGroupId()) ||
						(status != job.getStatus())) {

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

			query.append(_SQL_SELECT_JOB_WHERE);

			query.append(_FINDER_COLUMN_STATUS_G_GROUPID_2);

			query.append(_FINDER_COLUMN_STATUS_G_STATUS_2);

			if (orderByComparator != null) {
				appendOrderByComparator(
					query, _ORDER_BY_ENTITY_ALIAS, orderByComparator);
			}
			else if (pagination) {
				query.append(JobModelImpl.ORDER_BY_JPQL);
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
					list = (List<Job>)QueryUtil.list(
						q, getDialect(), start, end, false);

					Collections.sort(list);

					list = Collections.unmodifiableList(list);
				}
				else {
					list = (List<Job>)QueryUtil.list(
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
	 * Returns the first job in the ordered set where groupId = &#63; and status = &#63;.
	 *
	 * @param groupId the group ID
	 * @param status the status
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching job
	 * @throws NoSuchJobException if a matching job could not be found
	 */
	@Override
	public Job findByStatus_G_First(
			long groupId, int status, OrderByComparator<Job> orderByComparator)
		throws NoSuchJobException {

		Job job = fetchByStatus_G_First(groupId, status, orderByComparator);

		if (job != null) {
			return job;
		}

		StringBundler msg = new StringBundler(6);

		msg.append(_NO_SUCH_ENTITY_WITH_KEY);

		msg.append("groupId=");
		msg.append(groupId);

		msg.append(", status=");
		msg.append(status);

		msg.append("}");

		throw new NoSuchJobException(msg.toString());
	}

	/**
	 * Returns the first job in the ordered set where groupId = &#63; and status = &#63;.
	 *
	 * @param groupId the group ID
	 * @param status the status
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching job, or <code>null</code> if a matching job could not be found
	 */
	@Override
	public Job fetchByStatus_G_First(
		long groupId, int status, OrderByComparator<Job> orderByComparator) {

		List<Job> list = findByStatus_G(
			groupId, status, 0, 1, orderByComparator);

		if (!list.isEmpty()) {
			return list.get(0);
		}

		return null;
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
	@Override
	public Job findByStatus_G_Last(
			long groupId, int status, OrderByComparator<Job> orderByComparator)
		throws NoSuchJobException {

		Job job = fetchByStatus_G_Last(groupId, status, orderByComparator);

		if (job != null) {
			return job;
		}

		StringBundler msg = new StringBundler(6);

		msg.append(_NO_SUCH_ENTITY_WITH_KEY);

		msg.append("groupId=");
		msg.append(groupId);

		msg.append(", status=");
		msg.append(status);

		msg.append("}");

		throw new NoSuchJobException(msg.toString());
	}

	/**
	 * Returns the last job in the ordered set where groupId = &#63; and status = &#63;.
	 *
	 * @param groupId the group ID
	 * @param status the status
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching job, or <code>null</code> if a matching job could not be found
	 */
	@Override
	public Job fetchByStatus_G_Last(
		long groupId, int status, OrderByComparator<Job> orderByComparator) {

		int count = countByStatus_G(groupId, status);

		if (count == 0) {
			return null;
		}

		List<Job> list = findByStatus_G(
			groupId, status, count - 1, count, orderByComparator);

		if (!list.isEmpty()) {
			return list.get(0);
		}

		return null;
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
	@Override
	public Job[] findByStatus_G_PrevAndNext(
			long jobId, long groupId, int status,
			OrderByComparator<Job> orderByComparator)
		throws NoSuchJobException {

		Job job = findByPrimaryKey(jobId);

		Session session = null;

		try {
			session = openSession();

			Job[] array = new JobImpl[3];

			array[0] = getByStatus_G_PrevAndNext(
				session, job, groupId, status, orderByComparator, true);

			array[1] = job;

			array[2] = getByStatus_G_PrevAndNext(
				session, job, groupId, status, orderByComparator, false);

			return array;
		}
		catch (Exception e) {
			throw processException(e);
		}
		finally {
			closeSession(session);
		}
	}

	protected Job getByStatus_G_PrevAndNext(
		Session session, Job job, long groupId, int status,
		OrderByComparator<Job> orderByComparator, boolean previous) {

		StringBundler query = null;

		if (orderByComparator != null) {
			query = new StringBundler(
				5 + (orderByComparator.getOrderByConditionFields().length * 3) +
					(orderByComparator.getOrderByFields().length * 3));
		}
		else {
			query = new StringBundler(4);
		}

		query.append(_SQL_SELECT_JOB_WHERE);

		query.append(_FINDER_COLUMN_STATUS_G_GROUPID_2);

		query.append(_FINDER_COLUMN_STATUS_G_STATUS_2);

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
			query.append(JobModelImpl.ORDER_BY_JPQL);
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
					orderByComparator.getOrderByConditionValues(job)) {

				qPos.add(orderByConditionValue);
			}
		}

		List<Job> list = q.list();

		if (list.size() == 2) {
			return list.get(1);
		}
		else {
			return null;
		}
	}

	/**
	 * Removes all the jobs where groupId = &#63; and status = &#63; from the database.
	 *
	 * @param groupId the group ID
	 * @param status the status
	 */
	@Override
	public void removeByStatus_G(long groupId, int status) {
		for (Job job :
				findByStatus_G(
					groupId, status, QueryUtil.ALL_POS, QueryUtil.ALL_POS,
					null)) {

			remove(job);
		}
	}

	/**
	 * Returns the number of jobs where groupId = &#63; and status = &#63;.
	 *
	 * @param groupId the group ID
	 * @param status the status
	 * @return the number of matching jobs
	 */
	@Override
	public int countByStatus_G(long groupId, int status) {
		FinderPath finderPath = _finderPathCountByStatus_G;

		Object[] finderArgs = new Object[] {groupId, status};

		Long count = (Long)finderCache.getResult(finderPath, finderArgs, this);

		if (count == null) {
			StringBundler query = new StringBundler(3);

			query.append(_SQL_COUNT_JOB_WHERE);

			query.append(_FINDER_COLUMN_STATUS_G_GROUPID_2);

			query.append(_FINDER_COLUMN_STATUS_G_STATUS_2);

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

	private static final String _FINDER_COLUMN_STATUS_G_GROUPID_2 =
		"job.groupId = ? AND ";

	private static final String _FINDER_COLUMN_STATUS_G_STATUS_2 =
		"job.status = ?";

	private FinderPath _finderPathWithPaginationFindByStatus_U;
	private FinderPath _finderPathWithoutPaginationFindByStatus_U;
	private FinderPath _finderPathCountByStatus_U;

	/**
	 * Returns all the jobs where userId = &#63; and status = &#63;.
	 *
	 * @param userId the user ID
	 * @param status the status
	 * @return the matching jobs
	 */
	@Override
	public List<Job> findByStatus_U(long userId, int status) {
		return findByStatus_U(
			userId, status, QueryUtil.ALL_POS, QueryUtil.ALL_POS, null);
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
	@Override
	public List<Job> findByStatus_U(
		long userId, int status, int start, int end) {

		return findByStatus_U(userId, status, start, end, null);
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
	@Override
	public List<Job> findByStatus_U(
		long userId, int status, int start, int end,
		OrderByComparator<Job> orderByComparator) {

		return findByStatus_U(
			userId, status, start, end, orderByComparator, true);
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
	@Override
	public List<Job> findByStatus_U(
		long userId, int status, int start, int end,
		OrderByComparator<Job> orderByComparator, boolean retrieveFromCache) {

		boolean pagination = true;
		FinderPath finderPath = null;
		Object[] finderArgs = null;

		if ((start == QueryUtil.ALL_POS) && (end == QueryUtil.ALL_POS) &&
			(orderByComparator == null)) {

			pagination = false;
			finderPath = _finderPathWithoutPaginationFindByStatus_U;
			finderArgs = new Object[] {userId, status};
		}
		else {
			finderPath = _finderPathWithPaginationFindByStatus_U;
			finderArgs = new Object[] {
				userId, status, start, end, orderByComparator
			};
		}

		List<Job> list = null;

		if (retrieveFromCache) {
			list = (List<Job>)finderCache.getResult(
				finderPath, finderArgs, this);

			if ((list != null) && !list.isEmpty()) {
				for (Job job : list) {
					if ((userId != job.getUserId()) ||
						(status != job.getStatus())) {

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

			query.append(_SQL_SELECT_JOB_WHERE);

			query.append(_FINDER_COLUMN_STATUS_U_USERID_2);

			query.append(_FINDER_COLUMN_STATUS_U_STATUS_2);

			if (orderByComparator != null) {
				appendOrderByComparator(
					query, _ORDER_BY_ENTITY_ALIAS, orderByComparator);
			}
			else if (pagination) {
				query.append(JobModelImpl.ORDER_BY_JPQL);
			}

			String sql = query.toString();

			Session session = null;

			try {
				session = openSession();

				Query q = session.createQuery(sql);

				QueryPos qPos = QueryPos.getInstance(q);

				qPos.add(userId);

				qPos.add(status);

				if (!pagination) {
					list = (List<Job>)QueryUtil.list(
						q, getDialect(), start, end, false);

					Collections.sort(list);

					list = Collections.unmodifiableList(list);
				}
				else {
					list = (List<Job>)QueryUtil.list(
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
	 * Returns the first job in the ordered set where userId = &#63; and status = &#63;.
	 *
	 * @param userId the user ID
	 * @param status the status
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching job
	 * @throws NoSuchJobException if a matching job could not be found
	 */
	@Override
	public Job findByStatus_U_First(
			long userId, int status, OrderByComparator<Job> orderByComparator)
		throws NoSuchJobException {

		Job job = fetchByStatus_U_First(userId, status, orderByComparator);

		if (job != null) {
			return job;
		}

		StringBundler msg = new StringBundler(6);

		msg.append(_NO_SUCH_ENTITY_WITH_KEY);

		msg.append("userId=");
		msg.append(userId);

		msg.append(", status=");
		msg.append(status);

		msg.append("}");

		throw new NoSuchJobException(msg.toString());
	}

	/**
	 * Returns the first job in the ordered set where userId = &#63; and status = &#63;.
	 *
	 * @param userId the user ID
	 * @param status the status
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching job, or <code>null</code> if a matching job could not be found
	 */
	@Override
	public Job fetchByStatus_U_First(
		long userId, int status, OrderByComparator<Job> orderByComparator) {

		List<Job> list = findByStatus_U(
			userId, status, 0, 1, orderByComparator);

		if (!list.isEmpty()) {
			return list.get(0);
		}

		return null;
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
	@Override
	public Job findByStatus_U_Last(
			long userId, int status, OrderByComparator<Job> orderByComparator)
		throws NoSuchJobException {

		Job job = fetchByStatus_U_Last(userId, status, orderByComparator);

		if (job != null) {
			return job;
		}

		StringBundler msg = new StringBundler(6);

		msg.append(_NO_SUCH_ENTITY_WITH_KEY);

		msg.append("userId=");
		msg.append(userId);

		msg.append(", status=");
		msg.append(status);

		msg.append("}");

		throw new NoSuchJobException(msg.toString());
	}

	/**
	 * Returns the last job in the ordered set where userId = &#63; and status = &#63;.
	 *
	 * @param userId the user ID
	 * @param status the status
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching job, or <code>null</code> if a matching job could not be found
	 */
	@Override
	public Job fetchByStatus_U_Last(
		long userId, int status, OrderByComparator<Job> orderByComparator) {

		int count = countByStatus_U(userId, status);

		if (count == 0) {
			return null;
		}

		List<Job> list = findByStatus_U(
			userId, status, count - 1, count, orderByComparator);

		if (!list.isEmpty()) {
			return list.get(0);
		}

		return null;
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
	@Override
	public Job[] findByStatus_U_PrevAndNext(
			long jobId, long userId, int status,
			OrderByComparator<Job> orderByComparator)
		throws NoSuchJobException {

		Job job = findByPrimaryKey(jobId);

		Session session = null;

		try {
			session = openSession();

			Job[] array = new JobImpl[3];

			array[0] = getByStatus_U_PrevAndNext(
				session, job, userId, status, orderByComparator, true);

			array[1] = job;

			array[2] = getByStatus_U_PrevAndNext(
				session, job, userId, status, orderByComparator, false);

			return array;
		}
		catch (Exception e) {
			throw processException(e);
		}
		finally {
			closeSession(session);
		}
	}

	protected Job getByStatus_U_PrevAndNext(
		Session session, Job job, long userId, int status,
		OrderByComparator<Job> orderByComparator, boolean previous) {

		StringBundler query = null;

		if (orderByComparator != null) {
			query = new StringBundler(
				5 + (orderByComparator.getOrderByConditionFields().length * 3) +
					(orderByComparator.getOrderByFields().length * 3));
		}
		else {
			query = new StringBundler(4);
		}

		query.append(_SQL_SELECT_JOB_WHERE);

		query.append(_FINDER_COLUMN_STATUS_U_USERID_2);

		query.append(_FINDER_COLUMN_STATUS_U_STATUS_2);

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
			query.append(JobModelImpl.ORDER_BY_JPQL);
		}

		String sql = query.toString();

		Query q = session.createQuery(sql);

		q.setFirstResult(0);
		q.setMaxResults(2);

		QueryPos qPos = QueryPos.getInstance(q);

		qPos.add(userId);

		qPos.add(status);

		if (orderByComparator != null) {
			for (Object orderByConditionValue :
					orderByComparator.getOrderByConditionValues(job)) {

				qPos.add(orderByConditionValue);
			}
		}

		List<Job> list = q.list();

		if (list.size() == 2) {
			return list.get(1);
		}
		else {
			return null;
		}
	}

	/**
	 * Removes all the jobs where userId = &#63; and status = &#63; from the database.
	 *
	 * @param userId the user ID
	 * @param status the status
	 */
	@Override
	public void removeByStatus_U(long userId, int status) {
		for (Job job :
				findByStatus_U(
					userId, status, QueryUtil.ALL_POS, QueryUtil.ALL_POS,
					null)) {

			remove(job);
		}
	}

	/**
	 * Returns the number of jobs where userId = &#63; and status = &#63;.
	 *
	 * @param userId the user ID
	 * @param status the status
	 * @return the number of matching jobs
	 */
	@Override
	public int countByStatus_U(long userId, int status) {
		FinderPath finderPath = _finderPathCountByStatus_U;

		Object[] finderArgs = new Object[] {userId, status};

		Long count = (Long)finderCache.getResult(finderPath, finderArgs, this);

		if (count == null) {
			StringBundler query = new StringBundler(3);

			query.append(_SQL_COUNT_JOB_WHERE);

			query.append(_FINDER_COLUMN_STATUS_U_USERID_2);

			query.append(_FINDER_COLUMN_STATUS_U_STATUS_2);

			String sql = query.toString();

			Session session = null;

			try {
				session = openSession();

				Query q = session.createQuery(sql);

				QueryPos qPos = QueryPos.getInstance(q);

				qPos.add(userId);

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

	private static final String _FINDER_COLUMN_STATUS_U_USERID_2 =
		"job.userId = ? AND ";

	private static final String _FINDER_COLUMN_STATUS_U_STATUS_2 =
		"job.status = ?";

	private FinderPath _finderPathWithPaginationFindByStatus_G_U;
	private FinderPath _finderPathWithoutPaginationFindByStatus_G_U;
	private FinderPath _finderPathCountByStatus_G_U;

	/**
	 * Returns all the jobs where groupId = &#63; and userId = &#63; and status = &#63;.
	 *
	 * @param groupId the group ID
	 * @param userId the user ID
	 * @param status the status
	 * @return the matching jobs
	 */
	@Override
	public List<Job> findByStatus_G_U(long groupId, long userId, int status) {
		return findByStatus_G_U(
			groupId, userId, status, QueryUtil.ALL_POS, QueryUtil.ALL_POS,
			null);
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
	@Override
	public List<Job> findByStatus_G_U(
		long groupId, long userId, int status, int start, int end) {

		return findByStatus_G_U(groupId, userId, status, start, end, null);
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
	@Override
	public List<Job> findByStatus_G_U(
		long groupId, long userId, int status, int start, int end,
		OrderByComparator<Job> orderByComparator) {

		return findByStatus_G_U(
			groupId, userId, status, start, end, orderByComparator, true);
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
	@Override
	public List<Job> findByStatus_G_U(
		long groupId, long userId, int status, int start, int end,
		OrderByComparator<Job> orderByComparator, boolean retrieveFromCache) {

		boolean pagination = true;
		FinderPath finderPath = null;
		Object[] finderArgs = null;

		if ((start == QueryUtil.ALL_POS) && (end == QueryUtil.ALL_POS) &&
			(orderByComparator == null)) {

			pagination = false;
			finderPath = _finderPathWithoutPaginationFindByStatus_G_U;
			finderArgs = new Object[] {groupId, userId, status};
		}
		else {
			finderPath = _finderPathWithPaginationFindByStatus_G_U;
			finderArgs = new Object[] {
				groupId, userId, status, start, end, orderByComparator
			};
		}

		List<Job> list = null;

		if (retrieveFromCache) {
			list = (List<Job>)finderCache.getResult(
				finderPath, finderArgs, this);

			if ((list != null) && !list.isEmpty()) {
				for (Job job : list) {
					if ((groupId != job.getGroupId()) ||
						(userId != job.getUserId()) ||
						(status != job.getStatus())) {

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
					5 + (orderByComparator.getOrderByFields().length * 2));
			}
			else {
				query = new StringBundler(5);
			}

			query.append(_SQL_SELECT_JOB_WHERE);

			query.append(_FINDER_COLUMN_STATUS_G_U_GROUPID_2);

			query.append(_FINDER_COLUMN_STATUS_G_U_USERID_2);

			query.append(_FINDER_COLUMN_STATUS_G_U_STATUS_2);

			if (orderByComparator != null) {
				appendOrderByComparator(
					query, _ORDER_BY_ENTITY_ALIAS, orderByComparator);
			}
			else if (pagination) {
				query.append(JobModelImpl.ORDER_BY_JPQL);
			}

			String sql = query.toString();

			Session session = null;

			try {
				session = openSession();

				Query q = session.createQuery(sql);

				QueryPos qPos = QueryPos.getInstance(q);

				qPos.add(groupId);

				qPos.add(userId);

				qPos.add(status);

				if (!pagination) {
					list = (List<Job>)QueryUtil.list(
						q, getDialect(), start, end, false);

					Collections.sort(list);

					list = Collections.unmodifiableList(list);
				}
				else {
					list = (List<Job>)QueryUtil.list(
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
	 * Returns the first job in the ordered set where groupId = &#63; and userId = &#63; and status = &#63;.
	 *
	 * @param groupId the group ID
	 * @param userId the user ID
	 * @param status the status
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching job
	 * @throws NoSuchJobException if a matching job could not be found
	 */
	@Override
	public Job findByStatus_G_U_First(
			long groupId, long userId, int status,
			OrderByComparator<Job> orderByComparator)
		throws NoSuchJobException {

		Job job = fetchByStatus_G_U_First(
			groupId, userId, status, orderByComparator);

		if (job != null) {
			return job;
		}

		StringBundler msg = new StringBundler(8);

		msg.append(_NO_SUCH_ENTITY_WITH_KEY);

		msg.append("groupId=");
		msg.append(groupId);

		msg.append(", userId=");
		msg.append(userId);

		msg.append(", status=");
		msg.append(status);

		msg.append("}");

		throw new NoSuchJobException(msg.toString());
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
	@Override
	public Job fetchByStatus_G_U_First(
		long groupId, long userId, int status,
		OrderByComparator<Job> orderByComparator) {

		List<Job> list = findByStatus_G_U(
			groupId, userId, status, 0, 1, orderByComparator);

		if (!list.isEmpty()) {
			return list.get(0);
		}

		return null;
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
	@Override
	public Job findByStatus_G_U_Last(
			long groupId, long userId, int status,
			OrderByComparator<Job> orderByComparator)
		throws NoSuchJobException {

		Job job = fetchByStatus_G_U_Last(
			groupId, userId, status, orderByComparator);

		if (job != null) {
			return job;
		}

		StringBundler msg = new StringBundler(8);

		msg.append(_NO_SUCH_ENTITY_WITH_KEY);

		msg.append("groupId=");
		msg.append(groupId);

		msg.append(", userId=");
		msg.append(userId);

		msg.append(", status=");
		msg.append(status);

		msg.append("}");

		throw new NoSuchJobException(msg.toString());
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
	@Override
	public Job fetchByStatus_G_U_Last(
		long groupId, long userId, int status,
		OrderByComparator<Job> orderByComparator) {

		int count = countByStatus_G_U(groupId, userId, status);

		if (count == 0) {
			return null;
		}

		List<Job> list = findByStatus_G_U(
			groupId, userId, status, count - 1, count, orderByComparator);

		if (!list.isEmpty()) {
			return list.get(0);
		}

		return null;
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
	@Override
	public Job[] findByStatus_G_U_PrevAndNext(
			long jobId, long groupId, long userId, int status,
			OrderByComparator<Job> orderByComparator)
		throws NoSuchJobException {

		Job job = findByPrimaryKey(jobId);

		Session session = null;

		try {
			session = openSession();

			Job[] array = new JobImpl[3];

			array[0] = getByStatus_G_U_PrevAndNext(
				session, job, groupId, userId, status, orderByComparator, true);

			array[1] = job;

			array[2] = getByStatus_G_U_PrevAndNext(
				session, job, groupId, userId, status, orderByComparator,
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

	protected Job getByStatus_G_U_PrevAndNext(
		Session session, Job job, long groupId, long userId, int status,
		OrderByComparator<Job> orderByComparator, boolean previous) {

		StringBundler query = null;

		if (orderByComparator != null) {
			query = new StringBundler(
				6 + (orderByComparator.getOrderByConditionFields().length * 3) +
					(orderByComparator.getOrderByFields().length * 3));
		}
		else {
			query = new StringBundler(5);
		}

		query.append(_SQL_SELECT_JOB_WHERE);

		query.append(_FINDER_COLUMN_STATUS_G_U_GROUPID_2);

		query.append(_FINDER_COLUMN_STATUS_G_U_USERID_2);

		query.append(_FINDER_COLUMN_STATUS_G_U_STATUS_2);

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
			query.append(JobModelImpl.ORDER_BY_JPQL);
		}

		String sql = query.toString();

		Query q = session.createQuery(sql);

		q.setFirstResult(0);
		q.setMaxResults(2);

		QueryPos qPos = QueryPos.getInstance(q);

		qPos.add(groupId);

		qPos.add(userId);

		qPos.add(status);

		if (orderByComparator != null) {
			for (Object orderByConditionValue :
					orderByComparator.getOrderByConditionValues(job)) {

				qPos.add(orderByConditionValue);
			}
		}

		List<Job> list = q.list();

		if (list.size() == 2) {
			return list.get(1);
		}
		else {
			return null;
		}
	}

	/**
	 * Removes all the jobs where groupId = &#63; and userId = &#63; and status = &#63; from the database.
	 *
	 * @param groupId the group ID
	 * @param userId the user ID
	 * @param status the status
	 */
	@Override
	public void removeByStatus_G_U(long groupId, long userId, int status) {
		for (Job job :
				findByStatus_G_U(
					groupId, userId, status, QueryUtil.ALL_POS,
					QueryUtil.ALL_POS, null)) {

			remove(job);
		}
	}

	/**
	 * Returns the number of jobs where groupId = &#63; and userId = &#63; and status = &#63;.
	 *
	 * @param groupId the group ID
	 * @param userId the user ID
	 * @param status the status
	 * @return the number of matching jobs
	 */
	@Override
	public int countByStatus_G_U(long groupId, long userId, int status) {
		FinderPath finderPath = _finderPathCountByStatus_G_U;

		Object[] finderArgs = new Object[] {groupId, userId, status};

		Long count = (Long)finderCache.getResult(finderPath, finderArgs, this);

		if (count == null) {
			StringBundler query = new StringBundler(4);

			query.append(_SQL_COUNT_JOB_WHERE);

			query.append(_FINDER_COLUMN_STATUS_G_U_GROUPID_2);

			query.append(_FINDER_COLUMN_STATUS_G_U_USERID_2);

			query.append(_FINDER_COLUMN_STATUS_G_U_STATUS_2);

			String sql = query.toString();

			Session session = null;

			try {
				session = openSession();

				Query q = session.createQuery(sql);

				QueryPos qPos = QueryPos.getInstance(q);

				qPos.add(groupId);

				qPos.add(userId);

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

	private static final String _FINDER_COLUMN_STATUS_G_U_GROUPID_2 =
		"job.groupId = ? AND ";

	private static final String _FINDER_COLUMN_STATUS_G_U_USERID_2 =
		"job.userId = ? AND ";

	private static final String _FINDER_COLUMN_STATUS_G_U_STATUS_2 =
		"job.status = ?";

	private FinderPath _finderPathWithPaginationFindByQueueName;
	private FinderPath _finderPathWithoutPaginationFindByQueueName;
	private FinderPath _finderPathCountByQueueName;

	/**
	 * Returns all the jobs where queueName = &#63;.
	 *
	 * @param queueName the queue name
	 * @return the matching jobs
	 */
	@Override
	public List<Job> findByQueueName(String queueName) {
		return findByQueueName(
			queueName, QueryUtil.ALL_POS, QueryUtil.ALL_POS, null);
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
	@Override
	public List<Job> findByQueueName(String queueName, int start, int end) {
		return findByQueueName(queueName, start, end, null);
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
	@Override
	public List<Job> findByQueueName(
		String queueName, int start, int end,
		OrderByComparator<Job> orderByComparator) {

		return findByQueueName(queueName, start, end, orderByComparator, true);
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
	@Override
	public List<Job> findByQueueName(
		String queueName, int start, int end,
		OrderByComparator<Job> orderByComparator, boolean retrieveFromCache) {

		queueName = Objects.toString(queueName, "");

		boolean pagination = true;
		FinderPath finderPath = null;
		Object[] finderArgs = null;

		if ((start == QueryUtil.ALL_POS) && (end == QueryUtil.ALL_POS) &&
			(orderByComparator == null)) {

			pagination = false;
			finderPath = _finderPathWithoutPaginationFindByQueueName;
			finderArgs = new Object[] {queueName};
		}
		else {
			finderPath = _finderPathWithPaginationFindByQueueName;
			finderArgs = new Object[] {
				queueName, start, end, orderByComparator
			};
		}

		List<Job> list = null;

		if (retrieveFromCache) {
			list = (List<Job>)finderCache.getResult(
				finderPath, finderArgs, this);

			if ((list != null) && !list.isEmpty()) {
				for (Job job : list) {
					if (!queueName.equals(job.getQueueName())) {
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

			query.append(_SQL_SELECT_JOB_WHERE);

			boolean bindQueueName = false;

			if (queueName.isEmpty()) {
				query.append(_FINDER_COLUMN_QUEUENAME_QUEUENAME_3);
			}
			else {
				bindQueueName = true;

				query.append(_FINDER_COLUMN_QUEUENAME_QUEUENAME_2);
			}

			if (orderByComparator != null) {
				appendOrderByComparator(
					query, _ORDER_BY_ENTITY_ALIAS, orderByComparator);
			}
			else if (pagination) {
				query.append(JobModelImpl.ORDER_BY_JPQL);
			}

			String sql = query.toString();

			Session session = null;

			try {
				session = openSession();

				Query q = session.createQuery(sql);

				QueryPos qPos = QueryPos.getInstance(q);

				if (bindQueueName) {
					qPos.add(queueName);
				}

				if (!pagination) {
					list = (List<Job>)QueryUtil.list(
						q, getDialect(), start, end, false);

					Collections.sort(list);

					list = Collections.unmodifiableList(list);
				}
				else {
					list = (List<Job>)QueryUtil.list(
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
	 * Returns the first job in the ordered set where queueName = &#63;.
	 *
	 * @param queueName the queue name
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching job
	 * @throws NoSuchJobException if a matching job could not be found
	 */
	@Override
	public Job findByQueueName_First(
			String queueName, OrderByComparator<Job> orderByComparator)
		throws NoSuchJobException {

		Job job = fetchByQueueName_First(queueName, orderByComparator);

		if (job != null) {
			return job;
		}

		StringBundler msg = new StringBundler(4);

		msg.append(_NO_SUCH_ENTITY_WITH_KEY);

		msg.append("queueName=");
		msg.append(queueName);

		msg.append("}");

		throw new NoSuchJobException(msg.toString());
	}

	/**
	 * Returns the first job in the ordered set where queueName = &#63;.
	 *
	 * @param queueName the queue name
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching job, or <code>null</code> if a matching job could not be found
	 */
	@Override
	public Job fetchByQueueName_First(
		String queueName, OrderByComparator<Job> orderByComparator) {

		List<Job> list = findByQueueName(queueName, 0, 1, orderByComparator);

		if (!list.isEmpty()) {
			return list.get(0);
		}

		return null;
	}

	/**
	 * Returns the last job in the ordered set where queueName = &#63;.
	 *
	 * @param queueName the queue name
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching job
	 * @throws NoSuchJobException if a matching job could not be found
	 */
	@Override
	public Job findByQueueName_Last(
			String queueName, OrderByComparator<Job> orderByComparator)
		throws NoSuchJobException {

		Job job = fetchByQueueName_Last(queueName, orderByComparator);

		if (job != null) {
			return job;
		}

		StringBundler msg = new StringBundler(4);

		msg.append(_NO_SUCH_ENTITY_WITH_KEY);

		msg.append("queueName=");
		msg.append(queueName);

		msg.append("}");

		throw new NoSuchJobException(msg.toString());
	}

	/**
	 * Returns the last job in the ordered set where queueName = &#63;.
	 *
	 * @param queueName the queue name
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching job, or <code>null</code> if a matching job could not be found
	 */
	@Override
	public Job fetchByQueueName_Last(
		String queueName, OrderByComparator<Job> orderByComparator) {

		int count = countByQueueName(queueName);

		if (count == 0) {
			return null;
		}

		List<Job> list = findByQueueName(
			queueName, count - 1, count, orderByComparator);

		if (!list.isEmpty()) {
			return list.get(0);
		}

		return null;
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
	@Override
	public Job[] findByQueueName_PrevAndNext(
			long jobId, String queueName,
			OrderByComparator<Job> orderByComparator)
		throws NoSuchJobException {

		queueName = Objects.toString(queueName, "");

		Job job = findByPrimaryKey(jobId);

		Session session = null;

		try {
			session = openSession();

			Job[] array = new JobImpl[3];

			array[0] = getByQueueName_PrevAndNext(
				session, job, queueName, orderByComparator, true);

			array[1] = job;

			array[2] = getByQueueName_PrevAndNext(
				session, job, queueName, orderByComparator, false);

			return array;
		}
		catch (Exception e) {
			throw processException(e);
		}
		finally {
			closeSession(session);
		}
	}

	protected Job getByQueueName_PrevAndNext(
		Session session, Job job, String queueName,
		OrderByComparator<Job> orderByComparator, boolean previous) {

		StringBundler query = null;

		if (orderByComparator != null) {
			query = new StringBundler(
				4 + (orderByComparator.getOrderByConditionFields().length * 3) +
					(orderByComparator.getOrderByFields().length * 3));
		}
		else {
			query = new StringBundler(3);
		}

		query.append(_SQL_SELECT_JOB_WHERE);

		boolean bindQueueName = false;

		if (queueName.isEmpty()) {
			query.append(_FINDER_COLUMN_QUEUENAME_QUEUENAME_3);
		}
		else {
			bindQueueName = true;

			query.append(_FINDER_COLUMN_QUEUENAME_QUEUENAME_2);
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
			query.append(JobModelImpl.ORDER_BY_JPQL);
		}

		String sql = query.toString();

		Query q = session.createQuery(sql);

		q.setFirstResult(0);
		q.setMaxResults(2);

		QueryPos qPos = QueryPos.getInstance(q);

		if (bindQueueName) {
			qPos.add(queueName);
		}

		if (orderByComparator != null) {
			for (Object orderByConditionValue :
					orderByComparator.getOrderByConditionValues(job)) {

				qPos.add(orderByConditionValue);
			}
		}

		List<Job> list = q.list();

		if (list.size() == 2) {
			return list.get(1);
		}
		else {
			return null;
		}
	}

	/**
	 * Removes all the jobs where queueName = &#63; from the database.
	 *
	 * @param queueName the queue name
	 */
	@Override
	public void removeByQueueName(String queueName) {
		for (Job job :
				findByQueueName(
					queueName, QueryUtil.ALL_POS, QueryUtil.ALL_POS, null)) {

			remove(job);
		}
	}

	/**
	 * Returns the number of jobs where queueName = &#63;.
	 *
	 * @param queueName the queue name
	 * @return the number of matching jobs
	 */
	@Override
	public int countByQueueName(String queueName) {
		queueName = Objects.toString(queueName, "");

		FinderPath finderPath = _finderPathCountByQueueName;

		Object[] finderArgs = new Object[] {queueName};

		Long count = (Long)finderCache.getResult(finderPath, finderArgs, this);

		if (count == null) {
			StringBundler query = new StringBundler(2);

			query.append(_SQL_COUNT_JOB_WHERE);

			boolean bindQueueName = false;

			if (queueName.isEmpty()) {
				query.append(_FINDER_COLUMN_QUEUENAME_QUEUENAME_3);
			}
			else {
				bindQueueName = true;

				query.append(_FINDER_COLUMN_QUEUENAME_QUEUENAME_2);
			}

			String sql = query.toString();

			Session session = null;

			try {
				session = openSession();

				Query q = session.createQuery(sql);

				QueryPos qPos = QueryPos.getInstance(q);

				if (bindQueueName) {
					qPos.add(queueName);
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

	private static final String _FINDER_COLUMN_QUEUENAME_QUEUENAME_2 =
		"job.queueName = ?";

	private static final String _FINDER_COLUMN_QUEUENAME_QUEUENAME_3 =
		"(job.queueName IS NULL OR job.queueName = '')";

	private FinderPath _finderPathWithPaginationFindByJobStatus;
	private FinderPath _finderPathWithoutPaginationFindByJobStatus;
	private FinderPath _finderPathCountByJobStatus;

	/**
	 * Returns all the jobs where jobStatus = &#63;.
	 *
	 * @param jobStatus the job status
	 * @return the matching jobs
	 */
	@Override
	public List<Job> findByJobStatus(int jobStatus) {
		return findByJobStatus(
			jobStatus, QueryUtil.ALL_POS, QueryUtil.ALL_POS, null);
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
	@Override
	public List<Job> findByJobStatus(int jobStatus, int start, int end) {
		return findByJobStatus(jobStatus, start, end, null);
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
	@Override
	public List<Job> findByJobStatus(
		int jobStatus, int start, int end,
		OrderByComparator<Job> orderByComparator) {

		return findByJobStatus(jobStatus, start, end, orderByComparator, true);
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
	@Override
	public List<Job> findByJobStatus(
		int jobStatus, int start, int end,
		OrderByComparator<Job> orderByComparator, boolean retrieveFromCache) {

		boolean pagination = true;
		FinderPath finderPath = null;
		Object[] finderArgs = null;

		if ((start == QueryUtil.ALL_POS) && (end == QueryUtil.ALL_POS) &&
			(orderByComparator == null)) {

			pagination = false;
			finderPath = _finderPathWithoutPaginationFindByJobStatus;
			finderArgs = new Object[] {jobStatus};
		}
		else {
			finderPath = _finderPathWithPaginationFindByJobStatus;
			finderArgs = new Object[] {
				jobStatus, start, end, orderByComparator
			};
		}

		List<Job> list = null;

		if (retrieveFromCache) {
			list = (List<Job>)finderCache.getResult(
				finderPath, finderArgs, this);

			if ((list != null) && !list.isEmpty()) {
				for (Job job : list) {
					if ((jobStatus != job.getJobStatus())) {
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

			query.append(_SQL_SELECT_JOB_WHERE);

			query.append(_FINDER_COLUMN_JOBSTATUS_JOBSTATUS_2);

			if (orderByComparator != null) {
				appendOrderByComparator(
					query, _ORDER_BY_ENTITY_ALIAS, orderByComparator);
			}
			else if (pagination) {
				query.append(JobModelImpl.ORDER_BY_JPQL);
			}

			String sql = query.toString();

			Session session = null;

			try {
				session = openSession();

				Query q = session.createQuery(sql);

				QueryPos qPos = QueryPos.getInstance(q);

				qPos.add(jobStatus);

				if (!pagination) {
					list = (List<Job>)QueryUtil.list(
						q, getDialect(), start, end, false);

					Collections.sort(list);

					list = Collections.unmodifiableList(list);
				}
				else {
					list = (List<Job>)QueryUtil.list(
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
	 * Returns the first job in the ordered set where jobStatus = &#63;.
	 *
	 * @param jobStatus the job status
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching job
	 * @throws NoSuchJobException if a matching job could not be found
	 */
	@Override
	public Job findByJobStatus_First(
			int jobStatus, OrderByComparator<Job> orderByComparator)
		throws NoSuchJobException {

		Job job = fetchByJobStatus_First(jobStatus, orderByComparator);

		if (job != null) {
			return job;
		}

		StringBundler msg = new StringBundler(4);

		msg.append(_NO_SUCH_ENTITY_WITH_KEY);

		msg.append("jobStatus=");
		msg.append(jobStatus);

		msg.append("}");

		throw new NoSuchJobException(msg.toString());
	}

	/**
	 * Returns the first job in the ordered set where jobStatus = &#63;.
	 *
	 * @param jobStatus the job status
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching job, or <code>null</code> if a matching job could not be found
	 */
	@Override
	public Job fetchByJobStatus_First(
		int jobStatus, OrderByComparator<Job> orderByComparator) {

		List<Job> list = findByJobStatus(jobStatus, 0, 1, orderByComparator);

		if (!list.isEmpty()) {
			return list.get(0);
		}

		return null;
	}

	/**
	 * Returns the last job in the ordered set where jobStatus = &#63;.
	 *
	 * @param jobStatus the job status
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching job
	 * @throws NoSuchJobException if a matching job could not be found
	 */
	@Override
	public Job findByJobStatus_Last(
			int jobStatus, OrderByComparator<Job> orderByComparator)
		throws NoSuchJobException {

		Job job = fetchByJobStatus_Last(jobStatus, orderByComparator);

		if (job != null) {
			return job;
		}

		StringBundler msg = new StringBundler(4);

		msg.append(_NO_SUCH_ENTITY_WITH_KEY);

		msg.append("jobStatus=");
		msg.append(jobStatus);

		msg.append("}");

		throw new NoSuchJobException(msg.toString());
	}

	/**
	 * Returns the last job in the ordered set where jobStatus = &#63;.
	 *
	 * @param jobStatus the job status
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching job, or <code>null</code> if a matching job could not be found
	 */
	@Override
	public Job fetchByJobStatus_Last(
		int jobStatus, OrderByComparator<Job> orderByComparator) {

		int count = countByJobStatus(jobStatus);

		if (count == 0) {
			return null;
		}

		List<Job> list = findByJobStatus(
			jobStatus, count - 1, count, orderByComparator);

		if (!list.isEmpty()) {
			return list.get(0);
		}

		return null;
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
	@Override
	public Job[] findByJobStatus_PrevAndNext(
			long jobId, int jobStatus, OrderByComparator<Job> orderByComparator)
		throws NoSuchJobException {

		Job job = findByPrimaryKey(jobId);

		Session session = null;

		try {
			session = openSession();

			Job[] array = new JobImpl[3];

			array[0] = getByJobStatus_PrevAndNext(
				session, job, jobStatus, orderByComparator, true);

			array[1] = job;

			array[2] = getByJobStatus_PrevAndNext(
				session, job, jobStatus, orderByComparator, false);

			return array;
		}
		catch (Exception e) {
			throw processException(e);
		}
		finally {
			closeSession(session);
		}
	}

	protected Job getByJobStatus_PrevAndNext(
		Session session, Job job, int jobStatus,
		OrderByComparator<Job> orderByComparator, boolean previous) {

		StringBundler query = null;

		if (orderByComparator != null) {
			query = new StringBundler(
				4 + (orderByComparator.getOrderByConditionFields().length * 3) +
					(orderByComparator.getOrderByFields().length * 3));
		}
		else {
			query = new StringBundler(3);
		}

		query.append(_SQL_SELECT_JOB_WHERE);

		query.append(_FINDER_COLUMN_JOBSTATUS_JOBSTATUS_2);

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
			query.append(JobModelImpl.ORDER_BY_JPQL);
		}

		String sql = query.toString();

		Query q = session.createQuery(sql);

		q.setFirstResult(0);
		q.setMaxResults(2);

		QueryPos qPos = QueryPos.getInstance(q);

		qPos.add(jobStatus);

		if (orderByComparator != null) {
			for (Object orderByConditionValue :
					orderByComparator.getOrderByConditionValues(job)) {

				qPos.add(orderByConditionValue);
			}
		}

		List<Job> list = q.list();

		if (list.size() == 2) {
			return list.get(1);
		}
		else {
			return null;
		}
	}

	/**
	 * Removes all the jobs where jobStatus = &#63; from the database.
	 *
	 * @param jobStatus the job status
	 */
	@Override
	public void removeByJobStatus(int jobStatus) {
		for (Job job :
				findByJobStatus(
					jobStatus, QueryUtil.ALL_POS, QueryUtil.ALL_POS, null)) {

			remove(job);
		}
	}

	/**
	 * Returns the number of jobs where jobStatus = &#63;.
	 *
	 * @param jobStatus the job status
	 * @return the number of matching jobs
	 */
	@Override
	public int countByJobStatus(int jobStatus) {
		FinderPath finderPath = _finderPathCountByJobStatus;

		Object[] finderArgs = new Object[] {jobStatus};

		Long count = (Long)finderCache.getResult(finderPath, finderArgs, this);

		if (count == null) {
			StringBundler query = new StringBundler(2);

			query.append(_SQL_COUNT_JOB_WHERE);

			query.append(_FINDER_COLUMN_JOBSTATUS_JOBSTATUS_2);

			String sql = query.toString();

			Session session = null;

			try {
				session = openSession();

				Query q = session.createQuery(sql);

				QueryPos qPos = QueryPos.getInstance(q);

				qPos.add(jobStatus);

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

	private static final String _FINDER_COLUMN_JOBSTATUS_JOBSTATUS_2 =
		"job.jobStatus = ?";

	private FinderPath _finderPathWithPaginationFindByJobStatus_G;
	private FinderPath _finderPathWithoutPaginationFindByJobStatus_G;
	private FinderPath _finderPathCountByJobStatus_G;

	/**
	 * Returns all the jobs where groupId = &#63; and jobStatus = &#63;.
	 *
	 * @param groupId the group ID
	 * @param jobStatus the job status
	 * @return the matching jobs
	 */
	@Override
	public List<Job> findByJobStatus_G(long groupId, int jobStatus) {
		return findByJobStatus_G(
			groupId, jobStatus, QueryUtil.ALL_POS, QueryUtil.ALL_POS, null);
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
	@Override
	public List<Job> findByJobStatus_G(
		long groupId, int jobStatus, int start, int end) {

		return findByJobStatus_G(groupId, jobStatus, start, end, null);
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
	@Override
	public List<Job> findByJobStatus_G(
		long groupId, int jobStatus, int start, int end,
		OrderByComparator<Job> orderByComparator) {

		return findByJobStatus_G(
			groupId, jobStatus, start, end, orderByComparator, true);
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
	@Override
	public List<Job> findByJobStatus_G(
		long groupId, int jobStatus, int start, int end,
		OrderByComparator<Job> orderByComparator, boolean retrieveFromCache) {

		boolean pagination = true;
		FinderPath finderPath = null;
		Object[] finderArgs = null;

		if ((start == QueryUtil.ALL_POS) && (end == QueryUtil.ALL_POS) &&
			(orderByComparator == null)) {

			pagination = false;
			finderPath = _finderPathWithoutPaginationFindByJobStatus_G;
			finderArgs = new Object[] {groupId, jobStatus};
		}
		else {
			finderPath = _finderPathWithPaginationFindByJobStatus_G;
			finderArgs = new Object[] {
				groupId, jobStatus, start, end, orderByComparator
			};
		}

		List<Job> list = null;

		if (retrieveFromCache) {
			list = (List<Job>)finderCache.getResult(
				finderPath, finderArgs, this);

			if ((list != null) && !list.isEmpty()) {
				for (Job job : list) {
					if ((groupId != job.getGroupId()) ||
						(jobStatus != job.getJobStatus())) {

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

			query.append(_SQL_SELECT_JOB_WHERE);

			query.append(_FINDER_COLUMN_JOBSTATUS_G_GROUPID_2);

			query.append(_FINDER_COLUMN_JOBSTATUS_G_JOBSTATUS_2);

			if (orderByComparator != null) {
				appendOrderByComparator(
					query, _ORDER_BY_ENTITY_ALIAS, orderByComparator);
			}
			else if (pagination) {
				query.append(JobModelImpl.ORDER_BY_JPQL);
			}

			String sql = query.toString();

			Session session = null;

			try {
				session = openSession();

				Query q = session.createQuery(sql);

				QueryPos qPos = QueryPos.getInstance(q);

				qPos.add(groupId);

				qPos.add(jobStatus);

				if (!pagination) {
					list = (List<Job>)QueryUtil.list(
						q, getDialect(), start, end, false);

					Collections.sort(list);

					list = Collections.unmodifiableList(list);
				}
				else {
					list = (List<Job>)QueryUtil.list(
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
	 * Returns the first job in the ordered set where groupId = &#63; and jobStatus = &#63;.
	 *
	 * @param groupId the group ID
	 * @param jobStatus the job status
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching job
	 * @throws NoSuchJobException if a matching job could not be found
	 */
	@Override
	public Job findByJobStatus_G_First(
			long groupId, int jobStatus,
			OrderByComparator<Job> orderByComparator)
		throws NoSuchJobException {

		Job job = fetchByJobStatus_G_First(
			groupId, jobStatus, orderByComparator);

		if (job != null) {
			return job;
		}

		StringBundler msg = new StringBundler(6);

		msg.append(_NO_SUCH_ENTITY_WITH_KEY);

		msg.append("groupId=");
		msg.append(groupId);

		msg.append(", jobStatus=");
		msg.append(jobStatus);

		msg.append("}");

		throw new NoSuchJobException(msg.toString());
	}

	/**
	 * Returns the first job in the ordered set where groupId = &#63; and jobStatus = &#63;.
	 *
	 * @param groupId the group ID
	 * @param jobStatus the job status
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching job, or <code>null</code> if a matching job could not be found
	 */
	@Override
	public Job fetchByJobStatus_G_First(
		long groupId, int jobStatus, OrderByComparator<Job> orderByComparator) {

		List<Job> list = findByJobStatus_G(
			groupId, jobStatus, 0, 1, orderByComparator);

		if (!list.isEmpty()) {
			return list.get(0);
		}

		return null;
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
	@Override
	public Job findByJobStatus_G_Last(
			long groupId, int jobStatus,
			OrderByComparator<Job> orderByComparator)
		throws NoSuchJobException {

		Job job = fetchByJobStatus_G_Last(
			groupId, jobStatus, orderByComparator);

		if (job != null) {
			return job;
		}

		StringBundler msg = new StringBundler(6);

		msg.append(_NO_SUCH_ENTITY_WITH_KEY);

		msg.append("groupId=");
		msg.append(groupId);

		msg.append(", jobStatus=");
		msg.append(jobStatus);

		msg.append("}");

		throw new NoSuchJobException(msg.toString());
	}

	/**
	 * Returns the last job in the ordered set where groupId = &#63; and jobStatus = &#63;.
	 *
	 * @param groupId the group ID
	 * @param jobStatus the job status
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching job, or <code>null</code> if a matching job could not be found
	 */
	@Override
	public Job fetchByJobStatus_G_Last(
		long groupId, int jobStatus, OrderByComparator<Job> orderByComparator) {

		int count = countByJobStatus_G(groupId, jobStatus);

		if (count == 0) {
			return null;
		}

		List<Job> list = findByJobStatus_G(
			groupId, jobStatus, count - 1, count, orderByComparator);

		if (!list.isEmpty()) {
			return list.get(0);
		}

		return null;
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
	@Override
	public Job[] findByJobStatus_G_PrevAndNext(
			long jobId, long groupId, int jobStatus,
			OrderByComparator<Job> orderByComparator)
		throws NoSuchJobException {

		Job job = findByPrimaryKey(jobId);

		Session session = null;

		try {
			session = openSession();

			Job[] array = new JobImpl[3];

			array[0] = getByJobStatus_G_PrevAndNext(
				session, job, groupId, jobStatus, orderByComparator, true);

			array[1] = job;

			array[2] = getByJobStatus_G_PrevAndNext(
				session, job, groupId, jobStatus, orderByComparator, false);

			return array;
		}
		catch (Exception e) {
			throw processException(e);
		}
		finally {
			closeSession(session);
		}
	}

	protected Job getByJobStatus_G_PrevAndNext(
		Session session, Job job, long groupId, int jobStatus,
		OrderByComparator<Job> orderByComparator, boolean previous) {

		StringBundler query = null;

		if (orderByComparator != null) {
			query = new StringBundler(
				5 + (orderByComparator.getOrderByConditionFields().length * 3) +
					(orderByComparator.getOrderByFields().length * 3));
		}
		else {
			query = new StringBundler(4);
		}

		query.append(_SQL_SELECT_JOB_WHERE);

		query.append(_FINDER_COLUMN_JOBSTATUS_G_GROUPID_2);

		query.append(_FINDER_COLUMN_JOBSTATUS_G_JOBSTATUS_2);

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
			query.append(JobModelImpl.ORDER_BY_JPQL);
		}

		String sql = query.toString();

		Query q = session.createQuery(sql);

		q.setFirstResult(0);
		q.setMaxResults(2);

		QueryPos qPos = QueryPos.getInstance(q);

		qPos.add(groupId);

		qPos.add(jobStatus);

		if (orderByComparator != null) {
			for (Object orderByConditionValue :
					orderByComparator.getOrderByConditionValues(job)) {

				qPos.add(orderByConditionValue);
			}
		}

		List<Job> list = q.list();

		if (list.size() == 2) {
			return list.get(1);
		}
		else {
			return null;
		}
	}

	/**
	 * Removes all the jobs where groupId = &#63; and jobStatus = &#63; from the database.
	 *
	 * @param groupId the group ID
	 * @param jobStatus the job status
	 */
	@Override
	public void removeByJobStatus_G(long groupId, int jobStatus) {
		for (Job job :
				findByJobStatus_G(
					groupId, jobStatus, QueryUtil.ALL_POS, QueryUtil.ALL_POS,
					null)) {

			remove(job);
		}
	}

	/**
	 * Returns the number of jobs where groupId = &#63; and jobStatus = &#63;.
	 *
	 * @param groupId the group ID
	 * @param jobStatus the job status
	 * @return the number of matching jobs
	 */
	@Override
	public int countByJobStatus_G(long groupId, int jobStatus) {
		FinderPath finderPath = _finderPathCountByJobStatus_G;

		Object[] finderArgs = new Object[] {groupId, jobStatus};

		Long count = (Long)finderCache.getResult(finderPath, finderArgs, this);

		if (count == null) {
			StringBundler query = new StringBundler(3);

			query.append(_SQL_COUNT_JOB_WHERE);

			query.append(_FINDER_COLUMN_JOBSTATUS_G_GROUPID_2);

			query.append(_FINDER_COLUMN_JOBSTATUS_G_JOBSTATUS_2);

			String sql = query.toString();

			Session session = null;

			try {
				session = openSession();

				Query q = session.createQuery(sql);

				QueryPos qPos = QueryPos.getInstance(q);

				qPos.add(groupId);

				qPos.add(jobStatus);

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

	private static final String _FINDER_COLUMN_JOBSTATUS_G_GROUPID_2 =
		"job.groupId = ? AND ";

	private static final String _FINDER_COLUMN_JOBSTATUS_G_JOBSTATUS_2 =
		"job.jobStatus = ?";

	private FinderPath _finderPathWithPaginationFindByJobStatus_U;
	private FinderPath _finderPathWithoutPaginationFindByJobStatus_U;
	private FinderPath _finderPathCountByJobStatus_U;

	/**
	 * Returns all the jobs where userId = &#63; and jobStatus = &#63;.
	 *
	 * @param userId the user ID
	 * @param jobStatus the job status
	 * @return the matching jobs
	 */
	@Override
	public List<Job> findByJobStatus_U(long userId, int jobStatus) {
		return findByJobStatus_U(
			userId, jobStatus, QueryUtil.ALL_POS, QueryUtil.ALL_POS, null);
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
	@Override
	public List<Job> findByJobStatus_U(
		long userId, int jobStatus, int start, int end) {

		return findByJobStatus_U(userId, jobStatus, start, end, null);
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
	@Override
	public List<Job> findByJobStatus_U(
		long userId, int jobStatus, int start, int end,
		OrderByComparator<Job> orderByComparator) {

		return findByJobStatus_U(
			userId, jobStatus, start, end, orderByComparator, true);
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
	@Override
	public List<Job> findByJobStatus_U(
		long userId, int jobStatus, int start, int end,
		OrderByComparator<Job> orderByComparator, boolean retrieveFromCache) {

		boolean pagination = true;
		FinderPath finderPath = null;
		Object[] finderArgs = null;

		if ((start == QueryUtil.ALL_POS) && (end == QueryUtil.ALL_POS) &&
			(orderByComparator == null)) {

			pagination = false;
			finderPath = _finderPathWithoutPaginationFindByJobStatus_U;
			finderArgs = new Object[] {userId, jobStatus};
		}
		else {
			finderPath = _finderPathWithPaginationFindByJobStatus_U;
			finderArgs = new Object[] {
				userId, jobStatus, start, end, orderByComparator
			};
		}

		List<Job> list = null;

		if (retrieveFromCache) {
			list = (List<Job>)finderCache.getResult(
				finderPath, finderArgs, this);

			if ((list != null) && !list.isEmpty()) {
				for (Job job : list) {
					if ((userId != job.getUserId()) ||
						(jobStatus != job.getJobStatus())) {

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

			query.append(_SQL_SELECT_JOB_WHERE);

			query.append(_FINDER_COLUMN_JOBSTATUS_U_USERID_2);

			query.append(_FINDER_COLUMN_JOBSTATUS_U_JOBSTATUS_2);

			if (orderByComparator != null) {
				appendOrderByComparator(
					query, _ORDER_BY_ENTITY_ALIAS, orderByComparator);
			}
			else if (pagination) {
				query.append(JobModelImpl.ORDER_BY_JPQL);
			}

			String sql = query.toString();

			Session session = null;

			try {
				session = openSession();

				Query q = session.createQuery(sql);

				QueryPos qPos = QueryPos.getInstance(q);

				qPos.add(userId);

				qPos.add(jobStatus);

				if (!pagination) {
					list = (List<Job>)QueryUtil.list(
						q, getDialect(), start, end, false);

					Collections.sort(list);

					list = Collections.unmodifiableList(list);
				}
				else {
					list = (List<Job>)QueryUtil.list(
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
	 * Returns the first job in the ordered set where userId = &#63; and jobStatus = &#63;.
	 *
	 * @param userId the user ID
	 * @param jobStatus the job status
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching job
	 * @throws NoSuchJobException if a matching job could not be found
	 */
	@Override
	public Job findByJobStatus_U_First(
			long userId, int jobStatus,
			OrderByComparator<Job> orderByComparator)
		throws NoSuchJobException {

		Job job = fetchByJobStatus_U_First(
			userId, jobStatus, orderByComparator);

		if (job != null) {
			return job;
		}

		StringBundler msg = new StringBundler(6);

		msg.append(_NO_SUCH_ENTITY_WITH_KEY);

		msg.append("userId=");
		msg.append(userId);

		msg.append(", jobStatus=");
		msg.append(jobStatus);

		msg.append("}");

		throw new NoSuchJobException(msg.toString());
	}

	/**
	 * Returns the first job in the ordered set where userId = &#63; and jobStatus = &#63;.
	 *
	 * @param userId the user ID
	 * @param jobStatus the job status
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching job, or <code>null</code> if a matching job could not be found
	 */
	@Override
	public Job fetchByJobStatus_U_First(
		long userId, int jobStatus, OrderByComparator<Job> orderByComparator) {

		List<Job> list = findByJobStatus_U(
			userId, jobStatus, 0, 1, orderByComparator);

		if (!list.isEmpty()) {
			return list.get(0);
		}

		return null;
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
	@Override
	public Job findByJobStatus_U_Last(
			long userId, int jobStatus,
			OrderByComparator<Job> orderByComparator)
		throws NoSuchJobException {

		Job job = fetchByJobStatus_U_Last(userId, jobStatus, orderByComparator);

		if (job != null) {
			return job;
		}

		StringBundler msg = new StringBundler(6);

		msg.append(_NO_SUCH_ENTITY_WITH_KEY);

		msg.append("userId=");
		msg.append(userId);

		msg.append(", jobStatus=");
		msg.append(jobStatus);

		msg.append("}");

		throw new NoSuchJobException(msg.toString());
	}

	/**
	 * Returns the last job in the ordered set where userId = &#63; and jobStatus = &#63;.
	 *
	 * @param userId the user ID
	 * @param jobStatus the job status
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching job, or <code>null</code> if a matching job could not be found
	 */
	@Override
	public Job fetchByJobStatus_U_Last(
		long userId, int jobStatus, OrderByComparator<Job> orderByComparator) {

		int count = countByJobStatus_U(userId, jobStatus);

		if (count == 0) {
			return null;
		}

		List<Job> list = findByJobStatus_U(
			userId, jobStatus, count - 1, count, orderByComparator);

		if (!list.isEmpty()) {
			return list.get(0);
		}

		return null;
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
	@Override
	public Job[] findByJobStatus_U_PrevAndNext(
			long jobId, long userId, int jobStatus,
			OrderByComparator<Job> orderByComparator)
		throws NoSuchJobException {

		Job job = findByPrimaryKey(jobId);

		Session session = null;

		try {
			session = openSession();

			Job[] array = new JobImpl[3];

			array[0] = getByJobStatus_U_PrevAndNext(
				session, job, userId, jobStatus, orderByComparator, true);

			array[1] = job;

			array[2] = getByJobStatus_U_PrevAndNext(
				session, job, userId, jobStatus, orderByComparator, false);

			return array;
		}
		catch (Exception e) {
			throw processException(e);
		}
		finally {
			closeSession(session);
		}
	}

	protected Job getByJobStatus_U_PrevAndNext(
		Session session, Job job, long userId, int jobStatus,
		OrderByComparator<Job> orderByComparator, boolean previous) {

		StringBundler query = null;

		if (orderByComparator != null) {
			query = new StringBundler(
				5 + (orderByComparator.getOrderByConditionFields().length * 3) +
					(orderByComparator.getOrderByFields().length * 3));
		}
		else {
			query = new StringBundler(4);
		}

		query.append(_SQL_SELECT_JOB_WHERE);

		query.append(_FINDER_COLUMN_JOBSTATUS_U_USERID_2);

		query.append(_FINDER_COLUMN_JOBSTATUS_U_JOBSTATUS_2);

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
			query.append(JobModelImpl.ORDER_BY_JPQL);
		}

		String sql = query.toString();

		Query q = session.createQuery(sql);

		q.setFirstResult(0);
		q.setMaxResults(2);

		QueryPos qPos = QueryPos.getInstance(q);

		qPos.add(userId);

		qPos.add(jobStatus);

		if (orderByComparator != null) {
			for (Object orderByConditionValue :
					orderByComparator.getOrderByConditionValues(job)) {

				qPos.add(orderByConditionValue);
			}
		}

		List<Job> list = q.list();

		if (list.size() == 2) {
			return list.get(1);
		}
		else {
			return null;
		}
	}

	/**
	 * Removes all the jobs where userId = &#63; and jobStatus = &#63; from the database.
	 *
	 * @param userId the user ID
	 * @param jobStatus the job status
	 */
	@Override
	public void removeByJobStatus_U(long userId, int jobStatus) {
		for (Job job :
				findByJobStatus_U(
					userId, jobStatus, QueryUtil.ALL_POS, QueryUtil.ALL_POS,
					null)) {

			remove(job);
		}
	}

	/**
	 * Returns the number of jobs where userId = &#63; and jobStatus = &#63;.
	 *
	 * @param userId the user ID
	 * @param jobStatus the job status
	 * @return the number of matching jobs
	 */
	@Override
	public int countByJobStatus_U(long userId, int jobStatus) {
		FinderPath finderPath = _finderPathCountByJobStatus_U;

		Object[] finderArgs = new Object[] {userId, jobStatus};

		Long count = (Long)finderCache.getResult(finderPath, finderArgs, this);

		if (count == null) {
			StringBundler query = new StringBundler(3);

			query.append(_SQL_COUNT_JOB_WHERE);

			query.append(_FINDER_COLUMN_JOBSTATUS_U_USERID_2);

			query.append(_FINDER_COLUMN_JOBSTATUS_U_JOBSTATUS_2);

			String sql = query.toString();

			Session session = null;

			try {
				session = openSession();

				Query q = session.createQuery(sql);

				QueryPos qPos = QueryPos.getInstance(q);

				qPos.add(userId);

				qPos.add(jobStatus);

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

	private static final String _FINDER_COLUMN_JOBSTATUS_U_USERID_2 =
		"job.userId = ? AND ";

	private static final String _FINDER_COLUMN_JOBSTATUS_U_JOBSTATUS_2 =
		"job.jobStatus = ?";

	private FinderPath _finderPathWithPaginationFindByJobStatus_G_U;
	private FinderPath _finderPathWithoutPaginationFindByJobStatus_G_U;
	private FinderPath _finderPathCountByJobStatus_G_U;

	/**
	 * Returns all the jobs where groupId = &#63; and userId = &#63; and jobStatus = &#63;.
	 *
	 * @param groupId the group ID
	 * @param userId the user ID
	 * @param jobStatus the job status
	 * @return the matching jobs
	 */
	@Override
	public List<Job> findByJobStatus_G_U(
		long groupId, long userId, int jobStatus) {

		return findByJobStatus_G_U(
			groupId, userId, jobStatus, QueryUtil.ALL_POS, QueryUtil.ALL_POS,
			null);
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
	@Override
	public List<Job> findByJobStatus_G_U(
		long groupId, long userId, int jobStatus, int start, int end) {

		return findByJobStatus_G_U(
			groupId, userId, jobStatus, start, end, null);
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
	@Override
	public List<Job> findByJobStatus_G_U(
		long groupId, long userId, int jobStatus, int start, int end,
		OrderByComparator<Job> orderByComparator) {

		return findByJobStatus_G_U(
			groupId, userId, jobStatus, start, end, orderByComparator, true);
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
	@Override
	public List<Job> findByJobStatus_G_U(
		long groupId, long userId, int jobStatus, int start, int end,
		OrderByComparator<Job> orderByComparator, boolean retrieveFromCache) {

		boolean pagination = true;
		FinderPath finderPath = null;
		Object[] finderArgs = null;

		if ((start == QueryUtil.ALL_POS) && (end == QueryUtil.ALL_POS) &&
			(orderByComparator == null)) {

			pagination = false;
			finderPath = _finderPathWithoutPaginationFindByJobStatus_G_U;
			finderArgs = new Object[] {groupId, userId, jobStatus};
		}
		else {
			finderPath = _finderPathWithPaginationFindByJobStatus_G_U;
			finderArgs = new Object[] {
				groupId, userId, jobStatus, start, end, orderByComparator
			};
		}

		List<Job> list = null;

		if (retrieveFromCache) {
			list = (List<Job>)finderCache.getResult(
				finderPath, finderArgs, this);

			if ((list != null) && !list.isEmpty()) {
				for (Job job : list) {
					if ((groupId != job.getGroupId()) ||
						(userId != job.getUserId()) ||
						(jobStatus != job.getJobStatus())) {

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
					5 + (orderByComparator.getOrderByFields().length * 2));
			}
			else {
				query = new StringBundler(5);
			}

			query.append(_SQL_SELECT_JOB_WHERE);

			query.append(_FINDER_COLUMN_JOBSTATUS_G_U_GROUPID_2);

			query.append(_FINDER_COLUMN_JOBSTATUS_G_U_USERID_2);

			query.append(_FINDER_COLUMN_JOBSTATUS_G_U_JOBSTATUS_2);

			if (orderByComparator != null) {
				appendOrderByComparator(
					query, _ORDER_BY_ENTITY_ALIAS, orderByComparator);
			}
			else if (pagination) {
				query.append(JobModelImpl.ORDER_BY_JPQL);
			}

			String sql = query.toString();

			Session session = null;

			try {
				session = openSession();

				Query q = session.createQuery(sql);

				QueryPos qPos = QueryPos.getInstance(q);

				qPos.add(groupId);

				qPos.add(userId);

				qPos.add(jobStatus);

				if (!pagination) {
					list = (List<Job>)QueryUtil.list(
						q, getDialect(), start, end, false);

					Collections.sort(list);

					list = Collections.unmodifiableList(list);
				}
				else {
					list = (List<Job>)QueryUtil.list(
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
	 * Returns the first job in the ordered set where groupId = &#63; and userId = &#63; and jobStatus = &#63;.
	 *
	 * @param groupId the group ID
	 * @param userId the user ID
	 * @param jobStatus the job status
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching job
	 * @throws NoSuchJobException if a matching job could not be found
	 */
	@Override
	public Job findByJobStatus_G_U_First(
			long groupId, long userId, int jobStatus,
			OrderByComparator<Job> orderByComparator)
		throws NoSuchJobException {

		Job job = fetchByJobStatus_G_U_First(
			groupId, userId, jobStatus, orderByComparator);

		if (job != null) {
			return job;
		}

		StringBundler msg = new StringBundler(8);

		msg.append(_NO_SUCH_ENTITY_WITH_KEY);

		msg.append("groupId=");
		msg.append(groupId);

		msg.append(", userId=");
		msg.append(userId);

		msg.append(", jobStatus=");
		msg.append(jobStatus);

		msg.append("}");

		throw new NoSuchJobException(msg.toString());
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
	@Override
	public Job fetchByJobStatus_G_U_First(
		long groupId, long userId, int jobStatus,
		OrderByComparator<Job> orderByComparator) {

		List<Job> list = findByJobStatus_G_U(
			groupId, userId, jobStatus, 0, 1, orderByComparator);

		if (!list.isEmpty()) {
			return list.get(0);
		}

		return null;
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
	@Override
	public Job findByJobStatus_G_U_Last(
			long groupId, long userId, int jobStatus,
			OrderByComparator<Job> orderByComparator)
		throws NoSuchJobException {

		Job job = fetchByJobStatus_G_U_Last(
			groupId, userId, jobStatus, orderByComparator);

		if (job != null) {
			return job;
		}

		StringBundler msg = new StringBundler(8);

		msg.append(_NO_SUCH_ENTITY_WITH_KEY);

		msg.append("groupId=");
		msg.append(groupId);

		msg.append(", userId=");
		msg.append(userId);

		msg.append(", jobStatus=");
		msg.append(jobStatus);

		msg.append("}");

		throw new NoSuchJobException(msg.toString());
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
	@Override
	public Job fetchByJobStatus_G_U_Last(
		long groupId, long userId, int jobStatus,
		OrderByComparator<Job> orderByComparator) {

		int count = countByJobStatus_G_U(groupId, userId, jobStatus);

		if (count == 0) {
			return null;
		}

		List<Job> list = findByJobStatus_G_U(
			groupId, userId, jobStatus, count - 1, count, orderByComparator);

		if (!list.isEmpty()) {
			return list.get(0);
		}

		return null;
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
	@Override
	public Job[] findByJobStatus_G_U_PrevAndNext(
			long jobId, long groupId, long userId, int jobStatus,
			OrderByComparator<Job> orderByComparator)
		throws NoSuchJobException {

		Job job = findByPrimaryKey(jobId);

		Session session = null;

		try {
			session = openSession();

			Job[] array = new JobImpl[3];

			array[0] = getByJobStatus_G_U_PrevAndNext(
				session, job, groupId, userId, jobStatus, orderByComparator,
				true);

			array[1] = job;

			array[2] = getByJobStatus_G_U_PrevAndNext(
				session, job, groupId, userId, jobStatus, orderByComparator,
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

	protected Job getByJobStatus_G_U_PrevAndNext(
		Session session, Job job, long groupId, long userId, int jobStatus,
		OrderByComparator<Job> orderByComparator, boolean previous) {

		StringBundler query = null;

		if (orderByComparator != null) {
			query = new StringBundler(
				6 + (orderByComparator.getOrderByConditionFields().length * 3) +
					(orderByComparator.getOrderByFields().length * 3));
		}
		else {
			query = new StringBundler(5);
		}

		query.append(_SQL_SELECT_JOB_WHERE);

		query.append(_FINDER_COLUMN_JOBSTATUS_G_U_GROUPID_2);

		query.append(_FINDER_COLUMN_JOBSTATUS_G_U_USERID_2);

		query.append(_FINDER_COLUMN_JOBSTATUS_G_U_JOBSTATUS_2);

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
			query.append(JobModelImpl.ORDER_BY_JPQL);
		}

		String sql = query.toString();

		Query q = session.createQuery(sql);

		q.setFirstResult(0);
		q.setMaxResults(2);

		QueryPos qPos = QueryPos.getInstance(q);

		qPos.add(groupId);

		qPos.add(userId);

		qPos.add(jobStatus);

		if (orderByComparator != null) {
			for (Object orderByConditionValue :
					orderByComparator.getOrderByConditionValues(job)) {

				qPos.add(orderByConditionValue);
			}
		}

		List<Job> list = q.list();

		if (list.size() == 2) {
			return list.get(1);
		}
		else {
			return null;
		}
	}

	/**
	 * Removes all the jobs where groupId = &#63; and userId = &#63; and jobStatus = &#63; from the database.
	 *
	 * @param groupId the group ID
	 * @param userId the user ID
	 * @param jobStatus the job status
	 */
	@Override
	public void removeByJobStatus_G_U(
		long groupId, long userId, int jobStatus) {

		for (Job job :
				findByJobStatus_G_U(
					groupId, userId, jobStatus, QueryUtil.ALL_POS,
					QueryUtil.ALL_POS, null)) {

			remove(job);
		}
	}

	/**
	 * Returns the number of jobs where groupId = &#63; and userId = &#63; and jobStatus = &#63;.
	 *
	 * @param groupId the group ID
	 * @param userId the user ID
	 * @param jobStatus the job status
	 * @return the number of matching jobs
	 */
	@Override
	public int countByJobStatus_G_U(long groupId, long userId, int jobStatus) {
		FinderPath finderPath = _finderPathCountByJobStatus_G_U;

		Object[] finderArgs = new Object[] {groupId, userId, jobStatus};

		Long count = (Long)finderCache.getResult(finderPath, finderArgs, this);

		if (count == null) {
			StringBundler query = new StringBundler(4);

			query.append(_SQL_COUNT_JOB_WHERE);

			query.append(_FINDER_COLUMN_JOBSTATUS_G_U_GROUPID_2);

			query.append(_FINDER_COLUMN_JOBSTATUS_G_U_USERID_2);

			query.append(_FINDER_COLUMN_JOBSTATUS_G_U_JOBSTATUS_2);

			String sql = query.toString();

			Session session = null;

			try {
				session = openSession();

				Query q = session.createQuery(sql);

				QueryPos qPos = QueryPos.getInstance(q);

				qPos.add(groupId);

				qPos.add(userId);

				qPos.add(jobStatus);

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

	private static final String _FINDER_COLUMN_JOBSTATUS_G_U_GROUPID_2 =
		"job.groupId = ? AND ";

	private static final String _FINDER_COLUMN_JOBSTATUS_G_U_USERID_2 =
		"job.userId = ? AND ";

	private static final String _FINDER_COLUMN_JOBSTATUS_G_U_JOBSTATUS_2 =
		"job.jobStatus = ?";

	private FinderPath _finderPathWithPaginationFindByTitle;
	private FinderPath _finderPathWithPaginationCountByTitle;

	/**
	 * Returns all the jobs where title LIKE &#63;.
	 *
	 * @param title the title
	 * @return the matching jobs
	 */
	@Override
	public List<Job> findByTitle(String title) {
		return findByTitle(title, QueryUtil.ALL_POS, QueryUtil.ALL_POS, null);
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
	@Override
	public List<Job> findByTitle(String title, int start, int end) {
		return findByTitle(title, start, end, null);
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
	@Override
	public List<Job> findByTitle(
		String title, int start, int end,
		OrderByComparator<Job> orderByComparator) {

		return findByTitle(title, start, end, orderByComparator, true);
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
	@Override
	public List<Job> findByTitle(
		String title, int start, int end,
		OrderByComparator<Job> orderByComparator, boolean retrieveFromCache) {

		title = Objects.toString(title, "");

		boolean pagination = true;
		FinderPath finderPath = null;
		Object[] finderArgs = null;

		finderPath = _finderPathWithPaginationFindByTitle;
		finderArgs = new Object[] {title, start, end, orderByComparator};

		List<Job> list = null;

		if (retrieveFromCache) {
			list = (List<Job>)finderCache.getResult(
				finderPath, finderArgs, this);

			if ((list != null) && !list.isEmpty()) {
				for (Job job : list) {
					if (!StringUtil.wildcardMatches(
							job.getTitle(), title, '_', '%', '\\', true)) {

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

			query.append(_SQL_SELECT_JOB_WHERE);

			boolean bindTitle = false;

			if (title.isEmpty()) {
				query.append(_FINDER_COLUMN_TITLE_TITLE_3);
			}
			else {
				bindTitle = true;

				query.append(_FINDER_COLUMN_TITLE_TITLE_2);
			}

			if (orderByComparator != null) {
				appendOrderByComparator(
					query, _ORDER_BY_ENTITY_ALIAS, orderByComparator);
			}
			else if (pagination) {
				query.append(JobModelImpl.ORDER_BY_JPQL);
			}

			String sql = query.toString();

			Session session = null;

			try {
				session = openSession();

				Query q = session.createQuery(sql);

				QueryPos qPos = QueryPos.getInstance(q);

				if (bindTitle) {
					qPos.add(title);
				}

				if (!pagination) {
					list = (List<Job>)QueryUtil.list(
						q, getDialect(), start, end, false);

					Collections.sort(list);

					list = Collections.unmodifiableList(list);
				}
				else {
					list = (List<Job>)QueryUtil.list(
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
	 * Returns the first job in the ordered set where title LIKE &#63;.
	 *
	 * @param title the title
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching job
	 * @throws NoSuchJobException if a matching job could not be found
	 */
	@Override
	public Job findByTitle_First(
			String title, OrderByComparator<Job> orderByComparator)
		throws NoSuchJobException {

		Job job = fetchByTitle_First(title, orderByComparator);

		if (job != null) {
			return job;
		}

		StringBundler msg = new StringBundler(4);

		msg.append(_NO_SUCH_ENTITY_WITH_KEY);

		msg.append("title=");
		msg.append(title);

		msg.append("}");

		throw new NoSuchJobException(msg.toString());
	}

	/**
	 * Returns the first job in the ordered set where title LIKE &#63;.
	 *
	 * @param title the title
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching job, or <code>null</code> if a matching job could not be found
	 */
	@Override
	public Job fetchByTitle_First(
		String title, OrderByComparator<Job> orderByComparator) {

		List<Job> list = findByTitle(title, 0, 1, orderByComparator);

		if (!list.isEmpty()) {
			return list.get(0);
		}

		return null;
	}

	/**
	 * Returns the last job in the ordered set where title LIKE &#63;.
	 *
	 * @param title the title
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching job
	 * @throws NoSuchJobException if a matching job could not be found
	 */
	@Override
	public Job findByTitle_Last(
			String title, OrderByComparator<Job> orderByComparator)
		throws NoSuchJobException {

		Job job = fetchByTitle_Last(title, orderByComparator);

		if (job != null) {
			return job;
		}

		StringBundler msg = new StringBundler(4);

		msg.append(_NO_SUCH_ENTITY_WITH_KEY);

		msg.append("title=");
		msg.append(title);

		msg.append("}");

		throw new NoSuchJobException(msg.toString());
	}

	/**
	 * Returns the last job in the ordered set where title LIKE &#63;.
	 *
	 * @param title the title
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching job, or <code>null</code> if a matching job could not be found
	 */
	@Override
	public Job fetchByTitle_Last(
		String title, OrderByComparator<Job> orderByComparator) {

		int count = countByTitle(title);

		if (count == 0) {
			return null;
		}

		List<Job> list = findByTitle(
			title, count - 1, count, orderByComparator);

		if (!list.isEmpty()) {
			return list.get(0);
		}

		return null;
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
	@Override
	public Job[] findByTitle_PrevAndNext(
			long jobId, String title, OrderByComparator<Job> orderByComparator)
		throws NoSuchJobException {

		title = Objects.toString(title, "");

		Job job = findByPrimaryKey(jobId);

		Session session = null;

		try {
			session = openSession();

			Job[] array = new JobImpl[3];

			array[0] = getByTitle_PrevAndNext(
				session, job, title, orderByComparator, true);

			array[1] = job;

			array[2] = getByTitle_PrevAndNext(
				session, job, title, orderByComparator, false);

			return array;
		}
		catch (Exception e) {
			throw processException(e);
		}
		finally {
			closeSession(session);
		}
	}

	protected Job getByTitle_PrevAndNext(
		Session session, Job job, String title,
		OrderByComparator<Job> orderByComparator, boolean previous) {

		StringBundler query = null;

		if (orderByComparator != null) {
			query = new StringBundler(
				4 + (orderByComparator.getOrderByConditionFields().length * 3) +
					(orderByComparator.getOrderByFields().length * 3));
		}
		else {
			query = new StringBundler(3);
		}

		query.append(_SQL_SELECT_JOB_WHERE);

		boolean bindTitle = false;

		if (title.isEmpty()) {
			query.append(_FINDER_COLUMN_TITLE_TITLE_3);
		}
		else {
			bindTitle = true;

			query.append(_FINDER_COLUMN_TITLE_TITLE_2);
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
			query.append(JobModelImpl.ORDER_BY_JPQL);
		}

		String sql = query.toString();

		Query q = session.createQuery(sql);

		q.setFirstResult(0);
		q.setMaxResults(2);

		QueryPos qPos = QueryPos.getInstance(q);

		if (bindTitle) {
			qPos.add(title);
		}

		if (orderByComparator != null) {
			for (Object orderByConditionValue :
					orderByComparator.getOrderByConditionValues(job)) {

				qPos.add(orderByConditionValue);
			}
		}

		List<Job> list = q.list();

		if (list.size() == 2) {
			return list.get(1);
		}
		else {
			return null;
		}
	}

	/**
	 * Removes all the jobs where title LIKE &#63; from the database.
	 *
	 * @param title the title
	 */
	@Override
	public void removeByTitle(String title) {
		for (Job job :
				findByTitle(
					title, QueryUtil.ALL_POS, QueryUtil.ALL_POS, null)) {

			remove(job);
		}
	}

	/**
	 * Returns the number of jobs where title LIKE &#63;.
	 *
	 * @param title the title
	 * @return the number of matching jobs
	 */
	@Override
	public int countByTitle(String title) {
		title = Objects.toString(title, "");

		FinderPath finderPath = _finderPathWithPaginationCountByTitle;

		Object[] finderArgs = new Object[] {title};

		Long count = (Long)finderCache.getResult(finderPath, finderArgs, this);

		if (count == null) {
			StringBundler query = new StringBundler(2);

			query.append(_SQL_COUNT_JOB_WHERE);

			boolean bindTitle = false;

			if (title.isEmpty()) {
				query.append(_FINDER_COLUMN_TITLE_TITLE_3);
			}
			else {
				bindTitle = true;

				query.append(_FINDER_COLUMN_TITLE_TITLE_2);
			}

			String sql = query.toString();

			Session session = null;

			try {
				session = openSession();

				Query q = session.createQuery(sql);

				QueryPos qPos = QueryPos.getInstance(q);

				if (bindTitle) {
					qPos.add(title);
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

	private static final String _FINDER_COLUMN_TITLE_TITLE_2 =
		"job.title LIKE ?";

	private static final String _FINDER_COLUMN_TITLE_TITLE_3 =
		"(job.title IS NULL OR job.title LIKE '')";

	private FinderPath _finderPathWithPaginationFindByTitle_G;
	private FinderPath _finderPathWithPaginationCountByTitle_G;

	/**
	 * Returns all the jobs where groupId = &#63; and title LIKE &#63;.
	 *
	 * @param groupId the group ID
	 * @param title the title
	 * @return the matching jobs
	 */
	@Override
	public List<Job> findByTitle_G(long groupId, String title) {
		return findByTitle_G(
			groupId, title, QueryUtil.ALL_POS, QueryUtil.ALL_POS, null);
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
	@Override
	public List<Job> findByTitle_G(
		long groupId, String title, int start, int end) {

		return findByTitle_G(groupId, title, start, end, null);
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
	@Override
	public List<Job> findByTitle_G(
		long groupId, String title, int start, int end,
		OrderByComparator<Job> orderByComparator) {

		return findByTitle_G(
			groupId, title, start, end, orderByComparator, true);
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
	@Override
	public List<Job> findByTitle_G(
		long groupId, String title, int start, int end,
		OrderByComparator<Job> orderByComparator, boolean retrieveFromCache) {

		title = Objects.toString(title, "");

		boolean pagination = true;
		FinderPath finderPath = null;
		Object[] finderArgs = null;

		finderPath = _finderPathWithPaginationFindByTitle_G;
		finderArgs = new Object[] {
			groupId, title, start, end, orderByComparator
		};

		List<Job> list = null;

		if (retrieveFromCache) {
			list = (List<Job>)finderCache.getResult(
				finderPath, finderArgs, this);

			if ((list != null) && !list.isEmpty()) {
				for (Job job : list) {
					if ((groupId != job.getGroupId()) ||
						!StringUtil.wildcardMatches(
							job.getTitle(), title, '_', '%', '\\', true)) {

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

			query.append(_SQL_SELECT_JOB_WHERE);

			query.append(_FINDER_COLUMN_TITLE_G_GROUPID_2);

			boolean bindTitle = false;

			if (title.isEmpty()) {
				query.append(_FINDER_COLUMN_TITLE_G_TITLE_3);
			}
			else {
				bindTitle = true;

				query.append(_FINDER_COLUMN_TITLE_G_TITLE_2);
			}

			if (orderByComparator != null) {
				appendOrderByComparator(
					query, _ORDER_BY_ENTITY_ALIAS, orderByComparator);
			}
			else if (pagination) {
				query.append(JobModelImpl.ORDER_BY_JPQL);
			}

			String sql = query.toString();

			Session session = null;

			try {
				session = openSession();

				Query q = session.createQuery(sql);

				QueryPos qPos = QueryPos.getInstance(q);

				qPos.add(groupId);

				if (bindTitle) {
					qPos.add(title);
				}

				if (!pagination) {
					list = (List<Job>)QueryUtil.list(
						q, getDialect(), start, end, false);

					Collections.sort(list);

					list = Collections.unmodifiableList(list);
				}
				else {
					list = (List<Job>)QueryUtil.list(
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
	 * Returns the first job in the ordered set where groupId = &#63; and title LIKE &#63;.
	 *
	 * @param groupId the group ID
	 * @param title the title
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching job
	 * @throws NoSuchJobException if a matching job could not be found
	 */
	@Override
	public Job findByTitle_G_First(
			long groupId, String title,
			OrderByComparator<Job> orderByComparator)
		throws NoSuchJobException {

		Job job = fetchByTitle_G_First(groupId, title, orderByComparator);

		if (job != null) {
			return job;
		}

		StringBundler msg = new StringBundler(6);

		msg.append(_NO_SUCH_ENTITY_WITH_KEY);

		msg.append("groupId=");
		msg.append(groupId);

		msg.append(", title=");
		msg.append(title);

		msg.append("}");

		throw new NoSuchJobException(msg.toString());
	}

	/**
	 * Returns the first job in the ordered set where groupId = &#63; and title LIKE &#63;.
	 *
	 * @param groupId the group ID
	 * @param title the title
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching job, or <code>null</code> if a matching job could not be found
	 */
	@Override
	public Job fetchByTitle_G_First(
		long groupId, String title, OrderByComparator<Job> orderByComparator) {

		List<Job> list = findByTitle_G(groupId, title, 0, 1, orderByComparator);

		if (!list.isEmpty()) {
			return list.get(0);
		}

		return null;
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
	@Override
	public Job findByTitle_G_Last(
			long groupId, String title,
			OrderByComparator<Job> orderByComparator)
		throws NoSuchJobException {

		Job job = fetchByTitle_G_Last(groupId, title, orderByComparator);

		if (job != null) {
			return job;
		}

		StringBundler msg = new StringBundler(6);

		msg.append(_NO_SUCH_ENTITY_WITH_KEY);

		msg.append("groupId=");
		msg.append(groupId);

		msg.append(", title=");
		msg.append(title);

		msg.append("}");

		throw new NoSuchJobException(msg.toString());
	}

	/**
	 * Returns the last job in the ordered set where groupId = &#63; and title LIKE &#63;.
	 *
	 * @param groupId the group ID
	 * @param title the title
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching job, or <code>null</code> if a matching job could not be found
	 */
	@Override
	public Job fetchByTitle_G_Last(
		long groupId, String title, OrderByComparator<Job> orderByComparator) {

		int count = countByTitle_G(groupId, title);

		if (count == 0) {
			return null;
		}

		List<Job> list = findByTitle_G(
			groupId, title, count - 1, count, orderByComparator);

		if (!list.isEmpty()) {
			return list.get(0);
		}

		return null;
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
	@Override
	public Job[] findByTitle_G_PrevAndNext(
			long jobId, long groupId, String title,
			OrderByComparator<Job> orderByComparator)
		throws NoSuchJobException {

		title = Objects.toString(title, "");

		Job job = findByPrimaryKey(jobId);

		Session session = null;

		try {
			session = openSession();

			Job[] array = new JobImpl[3];

			array[0] = getByTitle_G_PrevAndNext(
				session, job, groupId, title, orderByComparator, true);

			array[1] = job;

			array[2] = getByTitle_G_PrevAndNext(
				session, job, groupId, title, orderByComparator, false);

			return array;
		}
		catch (Exception e) {
			throw processException(e);
		}
		finally {
			closeSession(session);
		}
	}

	protected Job getByTitle_G_PrevAndNext(
		Session session, Job job, long groupId, String title,
		OrderByComparator<Job> orderByComparator, boolean previous) {

		StringBundler query = null;

		if (orderByComparator != null) {
			query = new StringBundler(
				5 + (orderByComparator.getOrderByConditionFields().length * 3) +
					(orderByComparator.getOrderByFields().length * 3));
		}
		else {
			query = new StringBundler(4);
		}

		query.append(_SQL_SELECT_JOB_WHERE);

		query.append(_FINDER_COLUMN_TITLE_G_GROUPID_2);

		boolean bindTitle = false;

		if (title.isEmpty()) {
			query.append(_FINDER_COLUMN_TITLE_G_TITLE_3);
		}
		else {
			bindTitle = true;

			query.append(_FINDER_COLUMN_TITLE_G_TITLE_2);
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
			query.append(JobModelImpl.ORDER_BY_JPQL);
		}

		String sql = query.toString();

		Query q = session.createQuery(sql);

		q.setFirstResult(0);
		q.setMaxResults(2);

		QueryPos qPos = QueryPos.getInstance(q);

		qPos.add(groupId);

		if (bindTitle) {
			qPos.add(title);
		}

		if (orderByComparator != null) {
			for (Object orderByConditionValue :
					orderByComparator.getOrderByConditionValues(job)) {

				qPos.add(orderByConditionValue);
			}
		}

		List<Job> list = q.list();

		if (list.size() == 2) {
			return list.get(1);
		}
		else {
			return null;
		}
	}

	/**
	 * Removes all the jobs where groupId = &#63; and title LIKE &#63; from the database.
	 *
	 * @param groupId the group ID
	 * @param title the title
	 */
	@Override
	public void removeByTitle_G(long groupId, String title) {
		for (Job job :
				findByTitle_G(
					groupId, title, QueryUtil.ALL_POS, QueryUtil.ALL_POS,
					null)) {

			remove(job);
		}
	}

	/**
	 * Returns the number of jobs where groupId = &#63; and title LIKE &#63;.
	 *
	 * @param groupId the group ID
	 * @param title the title
	 * @return the number of matching jobs
	 */
	@Override
	public int countByTitle_G(long groupId, String title) {
		title = Objects.toString(title, "");

		FinderPath finderPath = _finderPathWithPaginationCountByTitle_G;

		Object[] finderArgs = new Object[] {groupId, title};

		Long count = (Long)finderCache.getResult(finderPath, finderArgs, this);

		if (count == null) {
			StringBundler query = new StringBundler(3);

			query.append(_SQL_COUNT_JOB_WHERE);

			query.append(_FINDER_COLUMN_TITLE_G_GROUPID_2);

			boolean bindTitle = false;

			if (title.isEmpty()) {
				query.append(_FINDER_COLUMN_TITLE_G_TITLE_3);
			}
			else {
				bindTitle = true;

				query.append(_FINDER_COLUMN_TITLE_G_TITLE_2);
			}

			String sql = query.toString();

			Session session = null;

			try {
				session = openSession();

				Query q = session.createQuery(sql);

				QueryPos qPos = QueryPos.getInstance(q);

				qPos.add(groupId);

				if (bindTitle) {
					qPos.add(title);
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

	private static final String _FINDER_COLUMN_TITLE_G_GROUPID_2 =
		"job.groupId = ? AND ";

	private static final String _FINDER_COLUMN_TITLE_G_TITLE_2 =
		"job.title LIKE ?";

	private static final String _FINDER_COLUMN_TITLE_G_TITLE_3 =
		"(job.title IS NULL OR job.title LIKE '')";

	private FinderPath _finderPathWithPaginationFindByTitle_U;
	private FinderPath _finderPathWithPaginationCountByTitle_U;

	/**
	 * Returns all the jobs where userId = &#63; and title LIKE &#63;.
	 *
	 * @param userId the user ID
	 * @param title the title
	 * @return the matching jobs
	 */
	@Override
	public List<Job> findByTitle_U(long userId, String title) {
		return findByTitle_U(
			userId, title, QueryUtil.ALL_POS, QueryUtil.ALL_POS, null);
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
	@Override
	public List<Job> findByTitle_U(
		long userId, String title, int start, int end) {

		return findByTitle_U(userId, title, start, end, null);
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
	@Override
	public List<Job> findByTitle_U(
		long userId, String title, int start, int end,
		OrderByComparator<Job> orderByComparator) {

		return findByTitle_U(
			userId, title, start, end, orderByComparator, true);
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
	@Override
	public List<Job> findByTitle_U(
		long userId, String title, int start, int end,
		OrderByComparator<Job> orderByComparator, boolean retrieveFromCache) {

		title = Objects.toString(title, "");

		boolean pagination = true;
		FinderPath finderPath = null;
		Object[] finderArgs = null;

		finderPath = _finderPathWithPaginationFindByTitle_U;
		finderArgs = new Object[] {
			userId, title, start, end, orderByComparator
		};

		List<Job> list = null;

		if (retrieveFromCache) {
			list = (List<Job>)finderCache.getResult(
				finderPath, finderArgs, this);

			if ((list != null) && !list.isEmpty()) {
				for (Job job : list) {
					if ((userId != job.getUserId()) ||
						!StringUtil.wildcardMatches(
							job.getTitle(), title, '_', '%', '\\', true)) {

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

			query.append(_SQL_SELECT_JOB_WHERE);

			query.append(_FINDER_COLUMN_TITLE_U_USERID_2);

			boolean bindTitle = false;

			if (title.isEmpty()) {
				query.append(_FINDER_COLUMN_TITLE_U_TITLE_3);
			}
			else {
				bindTitle = true;

				query.append(_FINDER_COLUMN_TITLE_U_TITLE_2);
			}

			if (orderByComparator != null) {
				appendOrderByComparator(
					query, _ORDER_BY_ENTITY_ALIAS, orderByComparator);
			}
			else if (pagination) {
				query.append(JobModelImpl.ORDER_BY_JPQL);
			}

			String sql = query.toString();

			Session session = null;

			try {
				session = openSession();

				Query q = session.createQuery(sql);

				QueryPos qPos = QueryPos.getInstance(q);

				qPos.add(userId);

				if (bindTitle) {
					qPos.add(title);
				}

				if (!pagination) {
					list = (List<Job>)QueryUtil.list(
						q, getDialect(), start, end, false);

					Collections.sort(list);

					list = Collections.unmodifiableList(list);
				}
				else {
					list = (List<Job>)QueryUtil.list(
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
	 * Returns the first job in the ordered set where userId = &#63; and title LIKE &#63;.
	 *
	 * @param userId the user ID
	 * @param title the title
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching job
	 * @throws NoSuchJobException if a matching job could not be found
	 */
	@Override
	public Job findByTitle_U_First(
			long userId, String title, OrderByComparator<Job> orderByComparator)
		throws NoSuchJobException {

		Job job = fetchByTitle_U_First(userId, title, orderByComparator);

		if (job != null) {
			return job;
		}

		StringBundler msg = new StringBundler(6);

		msg.append(_NO_SUCH_ENTITY_WITH_KEY);

		msg.append("userId=");
		msg.append(userId);

		msg.append(", title=");
		msg.append(title);

		msg.append("}");

		throw new NoSuchJobException(msg.toString());
	}

	/**
	 * Returns the first job in the ordered set where userId = &#63; and title LIKE &#63;.
	 *
	 * @param userId the user ID
	 * @param title the title
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching job, or <code>null</code> if a matching job could not be found
	 */
	@Override
	public Job fetchByTitle_U_First(
		long userId, String title, OrderByComparator<Job> orderByComparator) {

		List<Job> list = findByTitle_U(userId, title, 0, 1, orderByComparator);

		if (!list.isEmpty()) {
			return list.get(0);
		}

		return null;
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
	@Override
	public Job findByTitle_U_Last(
			long userId, String title, OrderByComparator<Job> orderByComparator)
		throws NoSuchJobException {

		Job job = fetchByTitle_U_Last(userId, title, orderByComparator);

		if (job != null) {
			return job;
		}

		StringBundler msg = new StringBundler(6);

		msg.append(_NO_SUCH_ENTITY_WITH_KEY);

		msg.append("userId=");
		msg.append(userId);

		msg.append(", title=");
		msg.append(title);

		msg.append("}");

		throw new NoSuchJobException(msg.toString());
	}

	/**
	 * Returns the last job in the ordered set where userId = &#63; and title LIKE &#63;.
	 *
	 * @param userId the user ID
	 * @param title the title
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching job, or <code>null</code> if a matching job could not be found
	 */
	@Override
	public Job fetchByTitle_U_Last(
		long userId, String title, OrderByComparator<Job> orderByComparator) {

		int count = countByTitle_U(userId, title);

		if (count == 0) {
			return null;
		}

		List<Job> list = findByTitle_U(
			userId, title, count - 1, count, orderByComparator);

		if (!list.isEmpty()) {
			return list.get(0);
		}

		return null;
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
	@Override
	public Job[] findByTitle_U_PrevAndNext(
			long jobId, long userId, String title,
			OrderByComparator<Job> orderByComparator)
		throws NoSuchJobException {

		title = Objects.toString(title, "");

		Job job = findByPrimaryKey(jobId);

		Session session = null;

		try {
			session = openSession();

			Job[] array = new JobImpl[3];

			array[0] = getByTitle_U_PrevAndNext(
				session, job, userId, title, orderByComparator, true);

			array[1] = job;

			array[2] = getByTitle_U_PrevAndNext(
				session, job, userId, title, orderByComparator, false);

			return array;
		}
		catch (Exception e) {
			throw processException(e);
		}
		finally {
			closeSession(session);
		}
	}

	protected Job getByTitle_U_PrevAndNext(
		Session session, Job job, long userId, String title,
		OrderByComparator<Job> orderByComparator, boolean previous) {

		StringBundler query = null;

		if (orderByComparator != null) {
			query = new StringBundler(
				5 + (orderByComparator.getOrderByConditionFields().length * 3) +
					(orderByComparator.getOrderByFields().length * 3));
		}
		else {
			query = new StringBundler(4);
		}

		query.append(_SQL_SELECT_JOB_WHERE);

		query.append(_FINDER_COLUMN_TITLE_U_USERID_2);

		boolean bindTitle = false;

		if (title.isEmpty()) {
			query.append(_FINDER_COLUMN_TITLE_U_TITLE_3);
		}
		else {
			bindTitle = true;

			query.append(_FINDER_COLUMN_TITLE_U_TITLE_2);
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
			query.append(JobModelImpl.ORDER_BY_JPQL);
		}

		String sql = query.toString();

		Query q = session.createQuery(sql);

		q.setFirstResult(0);
		q.setMaxResults(2);

		QueryPos qPos = QueryPos.getInstance(q);

		qPos.add(userId);

		if (bindTitle) {
			qPos.add(title);
		}

		if (orderByComparator != null) {
			for (Object orderByConditionValue :
					orderByComparator.getOrderByConditionValues(job)) {

				qPos.add(orderByConditionValue);
			}
		}

		List<Job> list = q.list();

		if (list.size() == 2) {
			return list.get(1);
		}
		else {
			return null;
		}
	}

	/**
	 * Removes all the jobs where userId = &#63; and title LIKE &#63; from the database.
	 *
	 * @param userId the user ID
	 * @param title the title
	 */
	@Override
	public void removeByTitle_U(long userId, String title) {
		for (Job job :
				findByTitle_U(
					userId, title, QueryUtil.ALL_POS, QueryUtil.ALL_POS,
					null)) {

			remove(job);
		}
	}

	/**
	 * Returns the number of jobs where userId = &#63; and title LIKE &#63;.
	 *
	 * @param userId the user ID
	 * @param title the title
	 * @return the number of matching jobs
	 */
	@Override
	public int countByTitle_U(long userId, String title) {
		title = Objects.toString(title, "");

		FinderPath finderPath = _finderPathWithPaginationCountByTitle_U;

		Object[] finderArgs = new Object[] {userId, title};

		Long count = (Long)finderCache.getResult(finderPath, finderArgs, this);

		if (count == null) {
			StringBundler query = new StringBundler(3);

			query.append(_SQL_COUNT_JOB_WHERE);

			query.append(_FINDER_COLUMN_TITLE_U_USERID_2);

			boolean bindTitle = false;

			if (title.isEmpty()) {
				query.append(_FINDER_COLUMN_TITLE_U_TITLE_3);
			}
			else {
				bindTitle = true;

				query.append(_FINDER_COLUMN_TITLE_U_TITLE_2);
			}

			String sql = query.toString();

			Session session = null;

			try {
				session = openSession();

				Query q = session.createQuery(sql);

				QueryPos qPos = QueryPos.getInstance(q);

				qPos.add(userId);

				if (bindTitle) {
					qPos.add(title);
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

	private static final String _FINDER_COLUMN_TITLE_U_USERID_2 =
		"job.userId = ? AND ";

	private static final String _FINDER_COLUMN_TITLE_U_TITLE_2 =
		"job.title LIKE ?";

	private static final String _FINDER_COLUMN_TITLE_U_TITLE_3 =
		"(job.title IS NULL OR job.title LIKE '')";

	private FinderPath _finderPathWithPaginationFindByTitle_G_U;
	private FinderPath _finderPathWithPaginationCountByTitle_G_U;

	/**
	 * Returns all the jobs where groupId = &#63; and userId = &#63; and title LIKE &#63;.
	 *
	 * @param groupId the group ID
	 * @param userId the user ID
	 * @param title the title
	 * @return the matching jobs
	 */
	@Override
	public List<Job> findByTitle_G_U(long groupId, long userId, String title) {
		return findByTitle_G_U(
			groupId, userId, title, QueryUtil.ALL_POS, QueryUtil.ALL_POS, null);
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
	@Override
	public List<Job> findByTitle_G_U(
		long groupId, long userId, String title, int start, int end) {

		return findByTitle_G_U(groupId, userId, title, start, end, null);
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
	@Override
	public List<Job> findByTitle_G_U(
		long groupId, long userId, String title, int start, int end,
		OrderByComparator<Job> orderByComparator) {

		return findByTitle_G_U(
			groupId, userId, title, start, end, orderByComparator, true);
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
	@Override
	public List<Job> findByTitle_G_U(
		long groupId, long userId, String title, int start, int end,
		OrderByComparator<Job> orderByComparator, boolean retrieveFromCache) {

		title = Objects.toString(title, "");

		boolean pagination = true;
		FinderPath finderPath = null;
		Object[] finderArgs = null;

		finderPath = _finderPathWithPaginationFindByTitle_G_U;
		finderArgs = new Object[] {
			groupId, userId, title, start, end, orderByComparator
		};

		List<Job> list = null;

		if (retrieveFromCache) {
			list = (List<Job>)finderCache.getResult(
				finderPath, finderArgs, this);

			if ((list != null) && !list.isEmpty()) {
				for (Job job : list) {
					if ((groupId != job.getGroupId()) ||
						(userId != job.getUserId()) ||
						!StringUtil.wildcardMatches(
							job.getTitle(), title, '_', '%', '\\', true)) {

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
					5 + (orderByComparator.getOrderByFields().length * 2));
			}
			else {
				query = new StringBundler(5);
			}

			query.append(_SQL_SELECT_JOB_WHERE);

			query.append(_FINDER_COLUMN_TITLE_G_U_GROUPID_2);

			query.append(_FINDER_COLUMN_TITLE_G_U_USERID_2);

			boolean bindTitle = false;

			if (title.isEmpty()) {
				query.append(_FINDER_COLUMN_TITLE_G_U_TITLE_3);
			}
			else {
				bindTitle = true;

				query.append(_FINDER_COLUMN_TITLE_G_U_TITLE_2);
			}

			if (orderByComparator != null) {
				appendOrderByComparator(
					query, _ORDER_BY_ENTITY_ALIAS, orderByComparator);
			}
			else if (pagination) {
				query.append(JobModelImpl.ORDER_BY_JPQL);
			}

			String sql = query.toString();

			Session session = null;

			try {
				session = openSession();

				Query q = session.createQuery(sql);

				QueryPos qPos = QueryPos.getInstance(q);

				qPos.add(groupId);

				qPos.add(userId);

				if (bindTitle) {
					qPos.add(title);
				}

				if (!pagination) {
					list = (List<Job>)QueryUtil.list(
						q, getDialect(), start, end, false);

					Collections.sort(list);

					list = Collections.unmodifiableList(list);
				}
				else {
					list = (List<Job>)QueryUtil.list(
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
	 * Returns the first job in the ordered set where groupId = &#63; and userId = &#63; and title LIKE &#63;.
	 *
	 * @param groupId the group ID
	 * @param userId the user ID
	 * @param title the title
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching job
	 * @throws NoSuchJobException if a matching job could not be found
	 */
	@Override
	public Job findByTitle_G_U_First(
			long groupId, long userId, String title,
			OrderByComparator<Job> orderByComparator)
		throws NoSuchJobException {

		Job job = fetchByTitle_G_U_First(
			groupId, userId, title, orderByComparator);

		if (job != null) {
			return job;
		}

		StringBundler msg = new StringBundler(8);

		msg.append(_NO_SUCH_ENTITY_WITH_KEY);

		msg.append("groupId=");
		msg.append(groupId);

		msg.append(", userId=");
		msg.append(userId);

		msg.append(", title=");
		msg.append(title);

		msg.append("}");

		throw new NoSuchJobException(msg.toString());
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
	@Override
	public Job fetchByTitle_G_U_First(
		long groupId, long userId, String title,
		OrderByComparator<Job> orderByComparator) {

		List<Job> list = findByTitle_G_U(
			groupId, userId, title, 0, 1, orderByComparator);

		if (!list.isEmpty()) {
			return list.get(0);
		}

		return null;
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
	@Override
	public Job findByTitle_G_U_Last(
			long groupId, long userId, String title,
			OrderByComparator<Job> orderByComparator)
		throws NoSuchJobException {

		Job job = fetchByTitle_G_U_Last(
			groupId, userId, title, orderByComparator);

		if (job != null) {
			return job;
		}

		StringBundler msg = new StringBundler(8);

		msg.append(_NO_SUCH_ENTITY_WITH_KEY);

		msg.append("groupId=");
		msg.append(groupId);

		msg.append(", userId=");
		msg.append(userId);

		msg.append(", title=");
		msg.append(title);

		msg.append("}");

		throw new NoSuchJobException(msg.toString());
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
	@Override
	public Job fetchByTitle_G_U_Last(
		long groupId, long userId, String title,
		OrderByComparator<Job> orderByComparator) {

		int count = countByTitle_G_U(groupId, userId, title);

		if (count == 0) {
			return null;
		}

		List<Job> list = findByTitle_G_U(
			groupId, userId, title, count - 1, count, orderByComparator);

		if (!list.isEmpty()) {
			return list.get(0);
		}

		return null;
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
	@Override
	public Job[] findByTitle_G_U_PrevAndNext(
			long jobId, long groupId, long userId, String title,
			OrderByComparator<Job> orderByComparator)
		throws NoSuchJobException {

		title = Objects.toString(title, "");

		Job job = findByPrimaryKey(jobId);

		Session session = null;

		try {
			session = openSession();

			Job[] array = new JobImpl[3];

			array[0] = getByTitle_G_U_PrevAndNext(
				session, job, groupId, userId, title, orderByComparator, true);

			array[1] = job;

			array[2] = getByTitle_G_U_PrevAndNext(
				session, job, groupId, userId, title, orderByComparator, false);

			return array;
		}
		catch (Exception e) {
			throw processException(e);
		}
		finally {
			closeSession(session);
		}
	}

	protected Job getByTitle_G_U_PrevAndNext(
		Session session, Job job, long groupId, long userId, String title,
		OrderByComparator<Job> orderByComparator, boolean previous) {

		StringBundler query = null;

		if (orderByComparator != null) {
			query = new StringBundler(
				6 + (orderByComparator.getOrderByConditionFields().length * 3) +
					(orderByComparator.getOrderByFields().length * 3));
		}
		else {
			query = new StringBundler(5);
		}

		query.append(_SQL_SELECT_JOB_WHERE);

		query.append(_FINDER_COLUMN_TITLE_G_U_GROUPID_2);

		query.append(_FINDER_COLUMN_TITLE_G_U_USERID_2);

		boolean bindTitle = false;

		if (title.isEmpty()) {
			query.append(_FINDER_COLUMN_TITLE_G_U_TITLE_3);
		}
		else {
			bindTitle = true;

			query.append(_FINDER_COLUMN_TITLE_G_U_TITLE_2);
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
			query.append(JobModelImpl.ORDER_BY_JPQL);
		}

		String sql = query.toString();

		Query q = session.createQuery(sql);

		q.setFirstResult(0);
		q.setMaxResults(2);

		QueryPos qPos = QueryPos.getInstance(q);

		qPos.add(groupId);

		qPos.add(userId);

		if (bindTitle) {
			qPos.add(title);
		}

		if (orderByComparator != null) {
			for (Object orderByConditionValue :
					orderByComparator.getOrderByConditionValues(job)) {

				qPos.add(orderByConditionValue);
			}
		}

		List<Job> list = q.list();

		if (list.size() == 2) {
			return list.get(1);
		}
		else {
			return null;
		}
	}

	/**
	 * Removes all the jobs where groupId = &#63; and userId = &#63; and title LIKE &#63; from the database.
	 *
	 * @param groupId the group ID
	 * @param userId the user ID
	 * @param title the title
	 */
	@Override
	public void removeByTitle_G_U(long groupId, long userId, String title) {
		for (Job job :
				findByTitle_G_U(
					groupId, userId, title, QueryUtil.ALL_POS,
					QueryUtil.ALL_POS, null)) {

			remove(job);
		}
	}

	/**
	 * Returns the number of jobs where groupId = &#63; and userId = &#63; and title LIKE &#63;.
	 *
	 * @param groupId the group ID
	 * @param userId the user ID
	 * @param title the title
	 * @return the number of matching jobs
	 */
	@Override
	public int countByTitle_G_U(long groupId, long userId, String title) {
		title = Objects.toString(title, "");

		FinderPath finderPath = _finderPathWithPaginationCountByTitle_G_U;

		Object[] finderArgs = new Object[] {groupId, userId, title};

		Long count = (Long)finderCache.getResult(finderPath, finderArgs, this);

		if (count == null) {
			StringBundler query = new StringBundler(4);

			query.append(_SQL_COUNT_JOB_WHERE);

			query.append(_FINDER_COLUMN_TITLE_G_U_GROUPID_2);

			query.append(_FINDER_COLUMN_TITLE_G_U_USERID_2);

			boolean bindTitle = false;

			if (title.isEmpty()) {
				query.append(_FINDER_COLUMN_TITLE_G_U_TITLE_3);
			}
			else {
				bindTitle = true;

				query.append(_FINDER_COLUMN_TITLE_G_U_TITLE_2);
			}

			String sql = query.toString();

			Session session = null;

			try {
				session = openSession();

				Query q = session.createQuery(sql);

				QueryPos qPos = QueryPos.getInstance(q);

				qPos.add(groupId);

				qPos.add(userId);

				if (bindTitle) {
					qPos.add(title);
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

	private static final String _FINDER_COLUMN_TITLE_G_U_GROUPID_2 =
		"job.groupId = ? AND ";

	private static final String _FINDER_COLUMN_TITLE_G_U_USERID_2 =
		"job.userId = ? AND ";

	private static final String _FINDER_COLUMN_TITLE_G_U_TITLE_2 =
		"job.title LIKE ?";

	private static final String _FINDER_COLUMN_TITLE_G_U_TITLE_3 =
		"(job.title IS NULL OR job.title LIKE '')";

	private FinderPath _finderPathWithPaginationFindByClusterId;
	private FinderPath _finderPathWithoutPaginationFindByClusterId;
	private FinderPath _finderPathCountByClusterId;

	/**
	 * Returns all the jobs where clusterId = &#63;.
	 *
	 * @param clusterId the cluster ID
	 * @return the matching jobs
	 */
	@Override
	public List<Job> findByClusterId(long clusterId) {
		return findByClusterId(
			clusterId, QueryUtil.ALL_POS, QueryUtil.ALL_POS, null);
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
	@Override
	public List<Job> findByClusterId(long clusterId, int start, int end) {
		return findByClusterId(clusterId, start, end, null);
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
	@Override
	public List<Job> findByClusterId(
		long clusterId, int start, int end,
		OrderByComparator<Job> orderByComparator) {

		return findByClusterId(clusterId, start, end, orderByComparator, true);
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
	@Override
	public List<Job> findByClusterId(
		long clusterId, int start, int end,
		OrderByComparator<Job> orderByComparator, boolean retrieveFromCache) {

		boolean pagination = true;
		FinderPath finderPath = null;
		Object[] finderArgs = null;

		if ((start == QueryUtil.ALL_POS) && (end == QueryUtil.ALL_POS) &&
			(orderByComparator == null)) {

			pagination = false;
			finderPath = _finderPathWithoutPaginationFindByClusterId;
			finderArgs = new Object[] {clusterId};
		}
		else {
			finderPath = _finderPathWithPaginationFindByClusterId;
			finderArgs = new Object[] {
				clusterId, start, end, orderByComparator
			};
		}

		List<Job> list = null;

		if (retrieveFromCache) {
			list = (List<Job>)finderCache.getResult(
				finderPath, finderArgs, this);

			if ((list != null) && !list.isEmpty()) {
				for (Job job : list) {
					if ((clusterId != job.getClusterId())) {
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

			query.append(_SQL_SELECT_JOB_WHERE);

			query.append(_FINDER_COLUMN_CLUSTERID_CLUSTERID_2);

			if (orderByComparator != null) {
				appendOrderByComparator(
					query, _ORDER_BY_ENTITY_ALIAS, orderByComparator);
			}
			else if (pagination) {
				query.append(JobModelImpl.ORDER_BY_JPQL);
			}

			String sql = query.toString();

			Session session = null;

			try {
				session = openSession();

				Query q = session.createQuery(sql);

				QueryPos qPos = QueryPos.getInstance(q);

				qPos.add(clusterId);

				if (!pagination) {
					list = (List<Job>)QueryUtil.list(
						q, getDialect(), start, end, false);

					Collections.sort(list);

					list = Collections.unmodifiableList(list);
				}
				else {
					list = (List<Job>)QueryUtil.list(
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
	 * Returns the first job in the ordered set where clusterId = &#63;.
	 *
	 * @param clusterId the cluster ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching job
	 * @throws NoSuchJobException if a matching job could not be found
	 */
	@Override
	public Job findByClusterId_First(
			long clusterId, OrderByComparator<Job> orderByComparator)
		throws NoSuchJobException {

		Job job = fetchByClusterId_First(clusterId, orderByComparator);

		if (job != null) {
			return job;
		}

		StringBundler msg = new StringBundler(4);

		msg.append(_NO_SUCH_ENTITY_WITH_KEY);

		msg.append("clusterId=");
		msg.append(clusterId);

		msg.append("}");

		throw new NoSuchJobException(msg.toString());
	}

	/**
	 * Returns the first job in the ordered set where clusterId = &#63;.
	 *
	 * @param clusterId the cluster ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching job, or <code>null</code> if a matching job could not be found
	 */
	@Override
	public Job fetchByClusterId_First(
		long clusterId, OrderByComparator<Job> orderByComparator) {

		List<Job> list = findByClusterId(clusterId, 0, 1, orderByComparator);

		if (!list.isEmpty()) {
			return list.get(0);
		}

		return null;
	}

	/**
	 * Returns the last job in the ordered set where clusterId = &#63;.
	 *
	 * @param clusterId the cluster ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching job
	 * @throws NoSuchJobException if a matching job could not be found
	 */
	@Override
	public Job findByClusterId_Last(
			long clusterId, OrderByComparator<Job> orderByComparator)
		throws NoSuchJobException {

		Job job = fetchByClusterId_Last(clusterId, orderByComparator);

		if (job != null) {
			return job;
		}

		StringBundler msg = new StringBundler(4);

		msg.append(_NO_SUCH_ENTITY_WITH_KEY);

		msg.append("clusterId=");
		msg.append(clusterId);

		msg.append("}");

		throw new NoSuchJobException(msg.toString());
	}

	/**
	 * Returns the last job in the ordered set where clusterId = &#63;.
	 *
	 * @param clusterId the cluster ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching job, or <code>null</code> if a matching job could not be found
	 */
	@Override
	public Job fetchByClusterId_Last(
		long clusterId, OrderByComparator<Job> orderByComparator) {

		int count = countByClusterId(clusterId);

		if (count == 0) {
			return null;
		}

		List<Job> list = findByClusterId(
			clusterId, count - 1, count, orderByComparator);

		if (!list.isEmpty()) {
			return list.get(0);
		}

		return null;
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
	@Override
	public Job[] findByClusterId_PrevAndNext(
			long jobId, long clusterId,
			OrderByComparator<Job> orderByComparator)
		throws NoSuchJobException {

		Job job = findByPrimaryKey(jobId);

		Session session = null;

		try {
			session = openSession();

			Job[] array = new JobImpl[3];

			array[0] = getByClusterId_PrevAndNext(
				session, job, clusterId, orderByComparator, true);

			array[1] = job;

			array[2] = getByClusterId_PrevAndNext(
				session, job, clusterId, orderByComparator, false);

			return array;
		}
		catch (Exception e) {
			throw processException(e);
		}
		finally {
			closeSession(session);
		}
	}

	protected Job getByClusterId_PrevAndNext(
		Session session, Job job, long clusterId,
		OrderByComparator<Job> orderByComparator, boolean previous) {

		StringBundler query = null;

		if (orderByComparator != null) {
			query = new StringBundler(
				4 + (orderByComparator.getOrderByConditionFields().length * 3) +
					(orderByComparator.getOrderByFields().length * 3));
		}
		else {
			query = new StringBundler(3);
		}

		query.append(_SQL_SELECT_JOB_WHERE);

		query.append(_FINDER_COLUMN_CLUSTERID_CLUSTERID_2);

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
			query.append(JobModelImpl.ORDER_BY_JPQL);
		}

		String sql = query.toString();

		Query q = session.createQuery(sql);

		q.setFirstResult(0);
		q.setMaxResults(2);

		QueryPos qPos = QueryPos.getInstance(q);

		qPos.add(clusterId);

		if (orderByComparator != null) {
			for (Object orderByConditionValue :
					orderByComparator.getOrderByConditionValues(job)) {

				qPos.add(orderByConditionValue);
			}
		}

		List<Job> list = q.list();

		if (list.size() == 2) {
			return list.get(1);
		}
		else {
			return null;
		}
	}

	/**
	 * Removes all the jobs where clusterId = &#63; from the database.
	 *
	 * @param clusterId the cluster ID
	 */
	@Override
	public void removeByClusterId(long clusterId) {
		for (Job job :
				findByClusterId(
					clusterId, QueryUtil.ALL_POS, QueryUtil.ALL_POS, null)) {

			remove(job);
		}
	}

	/**
	 * Returns the number of jobs where clusterId = &#63;.
	 *
	 * @param clusterId the cluster ID
	 * @return the number of matching jobs
	 */
	@Override
	public int countByClusterId(long clusterId) {
		FinderPath finderPath = _finderPathCountByClusterId;

		Object[] finderArgs = new Object[] {clusterId};

		Long count = (Long)finderCache.getResult(finderPath, finderArgs, this);

		if (count == null) {
			StringBundler query = new StringBundler(2);

			query.append(_SQL_COUNT_JOB_WHERE);

			query.append(_FINDER_COLUMN_CLUSTERID_CLUSTERID_2);

			String sql = query.toString();

			Session session = null;

			try {
				session = openSession();

				Query q = session.createQuery(sql);

				QueryPos qPos = QueryPos.getInstance(q);

				qPos.add(clusterId);

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

	private static final String _FINDER_COLUMN_CLUSTERID_CLUSTERID_2 =
		"job.clusterId = ?";

	private FinderPath _finderPathWithPaginationFindByClusterId_G;
	private FinderPath _finderPathWithoutPaginationFindByClusterId_G;
	private FinderPath _finderPathCountByClusterId_G;

	/**
	 * Returns all the jobs where groupId = &#63; and clusterId = &#63;.
	 *
	 * @param groupId the group ID
	 * @param clusterId the cluster ID
	 * @return the matching jobs
	 */
	@Override
	public List<Job> findByClusterId_G(long groupId, long clusterId) {
		return findByClusterId_G(
			groupId, clusterId, QueryUtil.ALL_POS, QueryUtil.ALL_POS, null);
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
	@Override
	public List<Job> findByClusterId_G(
		long groupId, long clusterId, int start, int end) {

		return findByClusterId_G(groupId, clusterId, start, end, null);
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
	@Override
	public List<Job> findByClusterId_G(
		long groupId, long clusterId, int start, int end,
		OrderByComparator<Job> orderByComparator) {

		return findByClusterId_G(
			groupId, clusterId, start, end, orderByComparator, true);
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
	@Override
	public List<Job> findByClusterId_G(
		long groupId, long clusterId, int start, int end,
		OrderByComparator<Job> orderByComparator, boolean retrieveFromCache) {

		boolean pagination = true;
		FinderPath finderPath = null;
		Object[] finderArgs = null;

		if ((start == QueryUtil.ALL_POS) && (end == QueryUtil.ALL_POS) &&
			(orderByComparator == null)) {

			pagination = false;
			finderPath = _finderPathWithoutPaginationFindByClusterId_G;
			finderArgs = new Object[] {groupId, clusterId};
		}
		else {
			finderPath = _finderPathWithPaginationFindByClusterId_G;
			finderArgs = new Object[] {
				groupId, clusterId, start, end, orderByComparator
			};
		}

		List<Job> list = null;

		if (retrieveFromCache) {
			list = (List<Job>)finderCache.getResult(
				finderPath, finderArgs, this);

			if ((list != null) && !list.isEmpty()) {
				for (Job job : list) {
					if ((groupId != job.getGroupId()) ||
						(clusterId != job.getClusterId())) {

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

			query.append(_SQL_SELECT_JOB_WHERE);

			query.append(_FINDER_COLUMN_CLUSTERID_G_GROUPID_2);

			query.append(_FINDER_COLUMN_CLUSTERID_G_CLUSTERID_2);

			if (orderByComparator != null) {
				appendOrderByComparator(
					query, _ORDER_BY_ENTITY_ALIAS, orderByComparator);
			}
			else if (pagination) {
				query.append(JobModelImpl.ORDER_BY_JPQL);
			}

			String sql = query.toString();

			Session session = null;

			try {
				session = openSession();

				Query q = session.createQuery(sql);

				QueryPos qPos = QueryPos.getInstance(q);

				qPos.add(groupId);

				qPos.add(clusterId);

				if (!pagination) {
					list = (List<Job>)QueryUtil.list(
						q, getDialect(), start, end, false);

					Collections.sort(list);

					list = Collections.unmodifiableList(list);
				}
				else {
					list = (List<Job>)QueryUtil.list(
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
	 * Returns the first job in the ordered set where groupId = &#63; and clusterId = &#63;.
	 *
	 * @param groupId the group ID
	 * @param clusterId the cluster ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching job
	 * @throws NoSuchJobException if a matching job could not be found
	 */
	@Override
	public Job findByClusterId_G_First(
			long groupId, long clusterId,
			OrderByComparator<Job> orderByComparator)
		throws NoSuchJobException {

		Job job = fetchByClusterId_G_First(
			groupId, clusterId, orderByComparator);

		if (job != null) {
			return job;
		}

		StringBundler msg = new StringBundler(6);

		msg.append(_NO_SUCH_ENTITY_WITH_KEY);

		msg.append("groupId=");
		msg.append(groupId);

		msg.append(", clusterId=");
		msg.append(clusterId);

		msg.append("}");

		throw new NoSuchJobException(msg.toString());
	}

	/**
	 * Returns the first job in the ordered set where groupId = &#63; and clusterId = &#63;.
	 *
	 * @param groupId the group ID
	 * @param clusterId the cluster ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching job, or <code>null</code> if a matching job could not be found
	 */
	@Override
	public Job fetchByClusterId_G_First(
		long groupId, long clusterId,
		OrderByComparator<Job> orderByComparator) {

		List<Job> list = findByClusterId_G(
			groupId, clusterId, 0, 1, orderByComparator);

		if (!list.isEmpty()) {
			return list.get(0);
		}

		return null;
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
	@Override
	public Job findByClusterId_G_Last(
			long groupId, long clusterId,
			OrderByComparator<Job> orderByComparator)
		throws NoSuchJobException {

		Job job = fetchByClusterId_G_Last(
			groupId, clusterId, orderByComparator);

		if (job != null) {
			return job;
		}

		StringBundler msg = new StringBundler(6);

		msg.append(_NO_SUCH_ENTITY_WITH_KEY);

		msg.append("groupId=");
		msg.append(groupId);

		msg.append(", clusterId=");
		msg.append(clusterId);

		msg.append("}");

		throw new NoSuchJobException(msg.toString());
	}

	/**
	 * Returns the last job in the ordered set where groupId = &#63; and clusterId = &#63;.
	 *
	 * @param groupId the group ID
	 * @param clusterId the cluster ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching job, or <code>null</code> if a matching job could not be found
	 */
	@Override
	public Job fetchByClusterId_G_Last(
		long groupId, long clusterId,
		OrderByComparator<Job> orderByComparator) {

		int count = countByClusterId_G(groupId, clusterId);

		if (count == 0) {
			return null;
		}

		List<Job> list = findByClusterId_G(
			groupId, clusterId, count - 1, count, orderByComparator);

		if (!list.isEmpty()) {
			return list.get(0);
		}

		return null;
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
	@Override
	public Job[] findByClusterId_G_PrevAndNext(
			long jobId, long groupId, long clusterId,
			OrderByComparator<Job> orderByComparator)
		throws NoSuchJobException {

		Job job = findByPrimaryKey(jobId);

		Session session = null;

		try {
			session = openSession();

			Job[] array = new JobImpl[3];

			array[0] = getByClusterId_G_PrevAndNext(
				session, job, groupId, clusterId, orderByComparator, true);

			array[1] = job;

			array[2] = getByClusterId_G_PrevAndNext(
				session, job, groupId, clusterId, orderByComparator, false);

			return array;
		}
		catch (Exception e) {
			throw processException(e);
		}
		finally {
			closeSession(session);
		}
	}

	protected Job getByClusterId_G_PrevAndNext(
		Session session, Job job, long groupId, long clusterId,
		OrderByComparator<Job> orderByComparator, boolean previous) {

		StringBundler query = null;

		if (orderByComparator != null) {
			query = new StringBundler(
				5 + (orderByComparator.getOrderByConditionFields().length * 3) +
					(orderByComparator.getOrderByFields().length * 3));
		}
		else {
			query = new StringBundler(4);
		}

		query.append(_SQL_SELECT_JOB_WHERE);

		query.append(_FINDER_COLUMN_CLUSTERID_G_GROUPID_2);

		query.append(_FINDER_COLUMN_CLUSTERID_G_CLUSTERID_2);

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
			query.append(JobModelImpl.ORDER_BY_JPQL);
		}

		String sql = query.toString();

		Query q = session.createQuery(sql);

		q.setFirstResult(0);
		q.setMaxResults(2);

		QueryPos qPos = QueryPos.getInstance(q);

		qPos.add(groupId);

		qPos.add(clusterId);

		if (orderByComparator != null) {
			for (Object orderByConditionValue :
					orderByComparator.getOrderByConditionValues(job)) {

				qPos.add(orderByConditionValue);
			}
		}

		List<Job> list = q.list();

		if (list.size() == 2) {
			return list.get(1);
		}
		else {
			return null;
		}
	}

	/**
	 * Removes all the jobs where groupId = &#63; and clusterId = &#63; from the database.
	 *
	 * @param groupId the group ID
	 * @param clusterId the cluster ID
	 */
	@Override
	public void removeByClusterId_G(long groupId, long clusterId) {
		for (Job job :
				findByClusterId_G(
					groupId, clusterId, QueryUtil.ALL_POS, QueryUtil.ALL_POS,
					null)) {

			remove(job);
		}
	}

	/**
	 * Returns the number of jobs where groupId = &#63; and clusterId = &#63;.
	 *
	 * @param groupId the group ID
	 * @param clusterId the cluster ID
	 * @return the number of matching jobs
	 */
	@Override
	public int countByClusterId_G(long groupId, long clusterId) {
		FinderPath finderPath = _finderPathCountByClusterId_G;

		Object[] finderArgs = new Object[] {groupId, clusterId};

		Long count = (Long)finderCache.getResult(finderPath, finderArgs, this);

		if (count == null) {
			StringBundler query = new StringBundler(3);

			query.append(_SQL_COUNT_JOB_WHERE);

			query.append(_FINDER_COLUMN_CLUSTERID_G_GROUPID_2);

			query.append(_FINDER_COLUMN_CLUSTERID_G_CLUSTERID_2);

			String sql = query.toString();

			Session session = null;

			try {
				session = openSession();

				Query q = session.createQuery(sql);

				QueryPos qPos = QueryPos.getInstance(q);

				qPos.add(groupId);

				qPos.add(clusterId);

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

	private static final String _FINDER_COLUMN_CLUSTERID_G_GROUPID_2 =
		"job.groupId = ? AND ";

	private static final String _FINDER_COLUMN_CLUSTERID_G_CLUSTERID_2 =
		"job.clusterId = ?";

	private FinderPath _finderPathWithPaginationFindByClusterId_U;
	private FinderPath _finderPathWithoutPaginationFindByClusterId_U;
	private FinderPath _finderPathCountByClusterId_U;

	/**
	 * Returns all the jobs where userId = &#63; and clusterId = &#63;.
	 *
	 * @param userId the user ID
	 * @param clusterId the cluster ID
	 * @return the matching jobs
	 */
	@Override
	public List<Job> findByClusterId_U(long userId, long clusterId) {
		return findByClusterId_U(
			userId, clusterId, QueryUtil.ALL_POS, QueryUtil.ALL_POS, null);
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
	@Override
	public List<Job> findByClusterId_U(
		long userId, long clusterId, int start, int end) {

		return findByClusterId_U(userId, clusterId, start, end, null);
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
	@Override
	public List<Job> findByClusterId_U(
		long userId, long clusterId, int start, int end,
		OrderByComparator<Job> orderByComparator) {

		return findByClusterId_U(
			userId, clusterId, start, end, orderByComparator, true);
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
	@Override
	public List<Job> findByClusterId_U(
		long userId, long clusterId, int start, int end,
		OrderByComparator<Job> orderByComparator, boolean retrieveFromCache) {

		boolean pagination = true;
		FinderPath finderPath = null;
		Object[] finderArgs = null;

		if ((start == QueryUtil.ALL_POS) && (end == QueryUtil.ALL_POS) &&
			(orderByComparator == null)) {

			pagination = false;
			finderPath = _finderPathWithoutPaginationFindByClusterId_U;
			finderArgs = new Object[] {userId, clusterId};
		}
		else {
			finderPath = _finderPathWithPaginationFindByClusterId_U;
			finderArgs = new Object[] {
				userId, clusterId, start, end, orderByComparator
			};
		}

		List<Job> list = null;

		if (retrieveFromCache) {
			list = (List<Job>)finderCache.getResult(
				finderPath, finderArgs, this);

			if ((list != null) && !list.isEmpty()) {
				for (Job job : list) {
					if ((userId != job.getUserId()) ||
						(clusterId != job.getClusterId())) {

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

			query.append(_SQL_SELECT_JOB_WHERE);

			query.append(_FINDER_COLUMN_CLUSTERID_U_USERID_2);

			query.append(_FINDER_COLUMN_CLUSTERID_U_CLUSTERID_2);

			if (orderByComparator != null) {
				appendOrderByComparator(
					query, _ORDER_BY_ENTITY_ALIAS, orderByComparator);
			}
			else if (pagination) {
				query.append(JobModelImpl.ORDER_BY_JPQL);
			}

			String sql = query.toString();

			Session session = null;

			try {
				session = openSession();

				Query q = session.createQuery(sql);

				QueryPos qPos = QueryPos.getInstance(q);

				qPos.add(userId);

				qPos.add(clusterId);

				if (!pagination) {
					list = (List<Job>)QueryUtil.list(
						q, getDialect(), start, end, false);

					Collections.sort(list);

					list = Collections.unmodifiableList(list);
				}
				else {
					list = (List<Job>)QueryUtil.list(
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
	 * Returns the first job in the ordered set where userId = &#63; and clusterId = &#63;.
	 *
	 * @param userId the user ID
	 * @param clusterId the cluster ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching job
	 * @throws NoSuchJobException if a matching job could not be found
	 */
	@Override
	public Job findByClusterId_U_First(
			long userId, long clusterId,
			OrderByComparator<Job> orderByComparator)
		throws NoSuchJobException {

		Job job = fetchByClusterId_U_First(
			userId, clusterId, orderByComparator);

		if (job != null) {
			return job;
		}

		StringBundler msg = new StringBundler(6);

		msg.append(_NO_SUCH_ENTITY_WITH_KEY);

		msg.append("userId=");
		msg.append(userId);

		msg.append(", clusterId=");
		msg.append(clusterId);

		msg.append("}");

		throw new NoSuchJobException(msg.toString());
	}

	/**
	 * Returns the first job in the ordered set where userId = &#63; and clusterId = &#63;.
	 *
	 * @param userId the user ID
	 * @param clusterId the cluster ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching job, or <code>null</code> if a matching job could not be found
	 */
	@Override
	public Job fetchByClusterId_U_First(
		long userId, long clusterId, OrderByComparator<Job> orderByComparator) {

		List<Job> list = findByClusterId_U(
			userId, clusterId, 0, 1, orderByComparator);

		if (!list.isEmpty()) {
			return list.get(0);
		}

		return null;
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
	@Override
	public Job findByClusterId_U_Last(
			long userId, long clusterId,
			OrderByComparator<Job> orderByComparator)
		throws NoSuchJobException {

		Job job = fetchByClusterId_U_Last(userId, clusterId, orderByComparator);

		if (job != null) {
			return job;
		}

		StringBundler msg = new StringBundler(6);

		msg.append(_NO_SUCH_ENTITY_WITH_KEY);

		msg.append("userId=");
		msg.append(userId);

		msg.append(", clusterId=");
		msg.append(clusterId);

		msg.append("}");

		throw new NoSuchJobException(msg.toString());
	}

	/**
	 * Returns the last job in the ordered set where userId = &#63; and clusterId = &#63;.
	 *
	 * @param userId the user ID
	 * @param clusterId the cluster ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching job, or <code>null</code> if a matching job could not be found
	 */
	@Override
	public Job fetchByClusterId_U_Last(
		long userId, long clusterId, OrderByComparator<Job> orderByComparator) {

		int count = countByClusterId_U(userId, clusterId);

		if (count == 0) {
			return null;
		}

		List<Job> list = findByClusterId_U(
			userId, clusterId, count - 1, count, orderByComparator);

		if (!list.isEmpty()) {
			return list.get(0);
		}

		return null;
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
	@Override
	public Job[] findByClusterId_U_PrevAndNext(
			long jobId, long userId, long clusterId,
			OrderByComparator<Job> orderByComparator)
		throws NoSuchJobException {

		Job job = findByPrimaryKey(jobId);

		Session session = null;

		try {
			session = openSession();

			Job[] array = new JobImpl[3];

			array[0] = getByClusterId_U_PrevAndNext(
				session, job, userId, clusterId, orderByComparator, true);

			array[1] = job;

			array[2] = getByClusterId_U_PrevAndNext(
				session, job, userId, clusterId, orderByComparator, false);

			return array;
		}
		catch (Exception e) {
			throw processException(e);
		}
		finally {
			closeSession(session);
		}
	}

	protected Job getByClusterId_U_PrevAndNext(
		Session session, Job job, long userId, long clusterId,
		OrderByComparator<Job> orderByComparator, boolean previous) {

		StringBundler query = null;

		if (orderByComparator != null) {
			query = new StringBundler(
				5 + (orderByComparator.getOrderByConditionFields().length * 3) +
					(orderByComparator.getOrderByFields().length * 3));
		}
		else {
			query = new StringBundler(4);
		}

		query.append(_SQL_SELECT_JOB_WHERE);

		query.append(_FINDER_COLUMN_CLUSTERID_U_USERID_2);

		query.append(_FINDER_COLUMN_CLUSTERID_U_CLUSTERID_2);

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
			query.append(JobModelImpl.ORDER_BY_JPQL);
		}

		String sql = query.toString();

		Query q = session.createQuery(sql);

		q.setFirstResult(0);
		q.setMaxResults(2);

		QueryPos qPos = QueryPos.getInstance(q);

		qPos.add(userId);

		qPos.add(clusterId);

		if (orderByComparator != null) {
			for (Object orderByConditionValue :
					orderByComparator.getOrderByConditionValues(job)) {

				qPos.add(orderByConditionValue);
			}
		}

		List<Job> list = q.list();

		if (list.size() == 2) {
			return list.get(1);
		}
		else {
			return null;
		}
	}

	/**
	 * Removes all the jobs where userId = &#63; and clusterId = &#63; from the database.
	 *
	 * @param userId the user ID
	 * @param clusterId the cluster ID
	 */
	@Override
	public void removeByClusterId_U(long userId, long clusterId) {
		for (Job job :
				findByClusterId_U(
					userId, clusterId, QueryUtil.ALL_POS, QueryUtil.ALL_POS,
					null)) {

			remove(job);
		}
	}

	/**
	 * Returns the number of jobs where userId = &#63; and clusterId = &#63;.
	 *
	 * @param userId the user ID
	 * @param clusterId the cluster ID
	 * @return the number of matching jobs
	 */
	@Override
	public int countByClusterId_U(long userId, long clusterId) {
		FinderPath finderPath = _finderPathCountByClusterId_U;

		Object[] finderArgs = new Object[] {userId, clusterId};

		Long count = (Long)finderCache.getResult(finderPath, finderArgs, this);

		if (count == null) {
			StringBundler query = new StringBundler(3);

			query.append(_SQL_COUNT_JOB_WHERE);

			query.append(_FINDER_COLUMN_CLUSTERID_U_USERID_2);

			query.append(_FINDER_COLUMN_CLUSTERID_U_CLUSTERID_2);

			String sql = query.toString();

			Session session = null;

			try {
				session = openSession();

				Query q = session.createQuery(sql);

				QueryPos qPos = QueryPos.getInstance(q);

				qPos.add(userId);

				qPos.add(clusterId);

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

	private static final String _FINDER_COLUMN_CLUSTERID_U_USERID_2 =
		"job.userId = ? AND ";

	private static final String _FINDER_COLUMN_CLUSTERID_U_CLUSTERID_2 =
		"job.clusterId = ?";

	private FinderPath _finderPathWithPaginationFindByClusterId_G_U;
	private FinderPath _finderPathWithoutPaginationFindByClusterId_G_U;
	private FinderPath _finderPathCountByClusterId_G_U;

	/**
	 * Returns all the jobs where groupId = &#63; and userId = &#63; and clusterId = &#63;.
	 *
	 * @param groupId the group ID
	 * @param userId the user ID
	 * @param clusterId the cluster ID
	 * @return the matching jobs
	 */
	@Override
	public List<Job> findByClusterId_G_U(
		long groupId, long userId, long clusterId) {

		return findByClusterId_G_U(
			groupId, userId, clusterId, QueryUtil.ALL_POS, QueryUtil.ALL_POS,
			null);
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
	@Override
	public List<Job> findByClusterId_G_U(
		long groupId, long userId, long clusterId, int start, int end) {

		return findByClusterId_G_U(
			groupId, userId, clusterId, start, end, null);
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
	@Override
	public List<Job> findByClusterId_G_U(
		long groupId, long userId, long clusterId, int start, int end,
		OrderByComparator<Job> orderByComparator) {

		return findByClusterId_G_U(
			groupId, userId, clusterId, start, end, orderByComparator, true);
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
	@Override
	public List<Job> findByClusterId_G_U(
		long groupId, long userId, long clusterId, int start, int end,
		OrderByComparator<Job> orderByComparator, boolean retrieveFromCache) {

		boolean pagination = true;
		FinderPath finderPath = null;
		Object[] finderArgs = null;

		if ((start == QueryUtil.ALL_POS) && (end == QueryUtil.ALL_POS) &&
			(orderByComparator == null)) {

			pagination = false;
			finderPath = _finderPathWithoutPaginationFindByClusterId_G_U;
			finderArgs = new Object[] {groupId, userId, clusterId};
		}
		else {
			finderPath = _finderPathWithPaginationFindByClusterId_G_U;
			finderArgs = new Object[] {
				groupId, userId, clusterId, start, end, orderByComparator
			};
		}

		List<Job> list = null;

		if (retrieveFromCache) {
			list = (List<Job>)finderCache.getResult(
				finderPath, finderArgs, this);

			if ((list != null) && !list.isEmpty()) {
				for (Job job : list) {
					if ((groupId != job.getGroupId()) ||
						(userId != job.getUserId()) ||
						(clusterId != job.getClusterId())) {

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
					5 + (orderByComparator.getOrderByFields().length * 2));
			}
			else {
				query = new StringBundler(5);
			}

			query.append(_SQL_SELECT_JOB_WHERE);

			query.append(_FINDER_COLUMN_CLUSTERID_G_U_GROUPID_2);

			query.append(_FINDER_COLUMN_CLUSTERID_G_U_USERID_2);

			query.append(_FINDER_COLUMN_CLUSTERID_G_U_CLUSTERID_2);

			if (orderByComparator != null) {
				appendOrderByComparator(
					query, _ORDER_BY_ENTITY_ALIAS, orderByComparator);
			}
			else if (pagination) {
				query.append(JobModelImpl.ORDER_BY_JPQL);
			}

			String sql = query.toString();

			Session session = null;

			try {
				session = openSession();

				Query q = session.createQuery(sql);

				QueryPos qPos = QueryPos.getInstance(q);

				qPos.add(groupId);

				qPos.add(userId);

				qPos.add(clusterId);

				if (!pagination) {
					list = (List<Job>)QueryUtil.list(
						q, getDialect(), start, end, false);

					Collections.sort(list);

					list = Collections.unmodifiableList(list);
				}
				else {
					list = (List<Job>)QueryUtil.list(
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
	 * Returns the first job in the ordered set where groupId = &#63; and userId = &#63; and clusterId = &#63;.
	 *
	 * @param groupId the group ID
	 * @param userId the user ID
	 * @param clusterId the cluster ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching job
	 * @throws NoSuchJobException if a matching job could not be found
	 */
	@Override
	public Job findByClusterId_G_U_First(
			long groupId, long userId, long clusterId,
			OrderByComparator<Job> orderByComparator)
		throws NoSuchJobException {

		Job job = fetchByClusterId_G_U_First(
			groupId, userId, clusterId, orderByComparator);

		if (job != null) {
			return job;
		}

		StringBundler msg = new StringBundler(8);

		msg.append(_NO_SUCH_ENTITY_WITH_KEY);

		msg.append("groupId=");
		msg.append(groupId);

		msg.append(", userId=");
		msg.append(userId);

		msg.append(", clusterId=");
		msg.append(clusterId);

		msg.append("}");

		throw new NoSuchJobException(msg.toString());
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
	@Override
	public Job fetchByClusterId_G_U_First(
		long groupId, long userId, long clusterId,
		OrderByComparator<Job> orderByComparator) {

		List<Job> list = findByClusterId_G_U(
			groupId, userId, clusterId, 0, 1, orderByComparator);

		if (!list.isEmpty()) {
			return list.get(0);
		}

		return null;
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
	@Override
	public Job findByClusterId_G_U_Last(
			long groupId, long userId, long clusterId,
			OrderByComparator<Job> orderByComparator)
		throws NoSuchJobException {

		Job job = fetchByClusterId_G_U_Last(
			groupId, userId, clusterId, orderByComparator);

		if (job != null) {
			return job;
		}

		StringBundler msg = new StringBundler(8);

		msg.append(_NO_SUCH_ENTITY_WITH_KEY);

		msg.append("groupId=");
		msg.append(groupId);

		msg.append(", userId=");
		msg.append(userId);

		msg.append(", clusterId=");
		msg.append(clusterId);

		msg.append("}");

		throw new NoSuchJobException(msg.toString());
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
	@Override
	public Job fetchByClusterId_G_U_Last(
		long groupId, long userId, long clusterId,
		OrderByComparator<Job> orderByComparator) {

		int count = countByClusterId_G_U(groupId, userId, clusterId);

		if (count == 0) {
			return null;
		}

		List<Job> list = findByClusterId_G_U(
			groupId, userId, clusterId, count - 1, count, orderByComparator);

		if (!list.isEmpty()) {
			return list.get(0);
		}

		return null;
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
	@Override
	public Job[] findByClusterId_G_U_PrevAndNext(
			long jobId, long groupId, long userId, long clusterId,
			OrderByComparator<Job> orderByComparator)
		throws NoSuchJobException {

		Job job = findByPrimaryKey(jobId);

		Session session = null;

		try {
			session = openSession();

			Job[] array = new JobImpl[3];

			array[0] = getByClusterId_G_U_PrevAndNext(
				session, job, groupId, userId, clusterId, orderByComparator,
				true);

			array[1] = job;

			array[2] = getByClusterId_G_U_PrevAndNext(
				session, job, groupId, userId, clusterId, orderByComparator,
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

	protected Job getByClusterId_G_U_PrevAndNext(
		Session session, Job job, long groupId, long userId, long clusterId,
		OrderByComparator<Job> orderByComparator, boolean previous) {

		StringBundler query = null;

		if (orderByComparator != null) {
			query = new StringBundler(
				6 + (orderByComparator.getOrderByConditionFields().length * 3) +
					(orderByComparator.getOrderByFields().length * 3));
		}
		else {
			query = new StringBundler(5);
		}

		query.append(_SQL_SELECT_JOB_WHERE);

		query.append(_FINDER_COLUMN_CLUSTERID_G_U_GROUPID_2);

		query.append(_FINDER_COLUMN_CLUSTERID_G_U_USERID_2);

		query.append(_FINDER_COLUMN_CLUSTERID_G_U_CLUSTERID_2);

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
			query.append(JobModelImpl.ORDER_BY_JPQL);
		}

		String sql = query.toString();

		Query q = session.createQuery(sql);

		q.setFirstResult(0);
		q.setMaxResults(2);

		QueryPos qPos = QueryPos.getInstance(q);

		qPos.add(groupId);

		qPos.add(userId);

		qPos.add(clusterId);

		if (orderByComparator != null) {
			for (Object orderByConditionValue :
					orderByComparator.getOrderByConditionValues(job)) {

				qPos.add(orderByConditionValue);
			}
		}

		List<Job> list = q.list();

		if (list.size() == 2) {
			return list.get(1);
		}
		else {
			return null;
		}
	}

	/**
	 * Removes all the jobs where groupId = &#63; and userId = &#63; and clusterId = &#63; from the database.
	 *
	 * @param groupId the group ID
	 * @param userId the user ID
	 * @param clusterId the cluster ID
	 */
	@Override
	public void removeByClusterId_G_U(
		long groupId, long userId, long clusterId) {

		for (Job job :
				findByClusterId_G_U(
					groupId, userId, clusterId, QueryUtil.ALL_POS,
					QueryUtil.ALL_POS, null)) {

			remove(job);
		}
	}

	/**
	 * Returns the number of jobs where groupId = &#63; and userId = &#63; and clusterId = &#63;.
	 *
	 * @param groupId the group ID
	 * @param userId the user ID
	 * @param clusterId the cluster ID
	 * @return the number of matching jobs
	 */
	@Override
	public int countByClusterId_G_U(long groupId, long userId, long clusterId) {
		FinderPath finderPath = _finderPathCountByClusterId_G_U;

		Object[] finderArgs = new Object[] {groupId, userId, clusterId};

		Long count = (Long)finderCache.getResult(finderPath, finderArgs, this);

		if (count == null) {
			StringBundler query = new StringBundler(4);

			query.append(_SQL_COUNT_JOB_WHERE);

			query.append(_FINDER_COLUMN_CLUSTERID_G_U_GROUPID_2);

			query.append(_FINDER_COLUMN_CLUSTERID_G_U_USERID_2);

			query.append(_FINDER_COLUMN_CLUSTERID_G_U_CLUSTERID_2);

			String sql = query.toString();

			Session session = null;

			try {
				session = openSession();

				Query q = session.createQuery(sql);

				QueryPos qPos = QueryPos.getInstance(q);

				qPos.add(groupId);

				qPos.add(userId);

				qPos.add(clusterId);

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

	private static final String _FINDER_COLUMN_CLUSTERID_G_U_GROUPID_2 =
		"job.groupId = ? AND ";

	private static final String _FINDER_COLUMN_CLUSTERID_G_U_USERID_2 =
		"job.userId = ? AND ";

	private static final String _FINDER_COLUMN_CLUSTERID_G_U_CLUSTERID_2 =
		"job.clusterId = ?";

	private FinderPath _finderPathWithPaginationFindByRunType;
	private FinderPath _finderPathWithoutPaginationFindByRunType;
	private FinderPath _finderPathCountByRunType;

	/**
	 * Returns all the jobs where runType = &#63;.
	 *
	 * @param runType the run type
	 * @return the matching jobs
	 */
	@Override
	public List<Job> findByRunType(String runType) {
		return findByRunType(
			runType, QueryUtil.ALL_POS, QueryUtil.ALL_POS, null);
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
	@Override
	public List<Job> findByRunType(String runType, int start, int end) {
		return findByRunType(runType, start, end, null);
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
	@Override
	public List<Job> findByRunType(
		String runType, int start, int end,
		OrderByComparator<Job> orderByComparator) {

		return findByRunType(runType, start, end, orderByComparator, true);
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
	@Override
	public List<Job> findByRunType(
		String runType, int start, int end,
		OrderByComparator<Job> orderByComparator, boolean retrieveFromCache) {

		runType = Objects.toString(runType, "");

		boolean pagination = true;
		FinderPath finderPath = null;
		Object[] finderArgs = null;

		if ((start == QueryUtil.ALL_POS) && (end == QueryUtil.ALL_POS) &&
			(orderByComparator == null)) {

			pagination = false;
			finderPath = _finderPathWithoutPaginationFindByRunType;
			finderArgs = new Object[] {runType};
		}
		else {
			finderPath = _finderPathWithPaginationFindByRunType;
			finderArgs = new Object[] {runType, start, end, orderByComparator};
		}

		List<Job> list = null;

		if (retrieveFromCache) {
			list = (List<Job>)finderCache.getResult(
				finderPath, finderArgs, this);

			if ((list != null) && !list.isEmpty()) {
				for (Job job : list) {
					if (!runType.equals(job.getRunType())) {
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

			query.append(_SQL_SELECT_JOB_WHERE);

			boolean bindRunType = false;

			if (runType.isEmpty()) {
				query.append(_FINDER_COLUMN_RUNTYPE_RUNTYPE_3);
			}
			else {
				bindRunType = true;

				query.append(_FINDER_COLUMN_RUNTYPE_RUNTYPE_2);
			}

			if (orderByComparator != null) {
				appendOrderByComparator(
					query, _ORDER_BY_ENTITY_ALIAS, orderByComparator);
			}
			else if (pagination) {
				query.append(JobModelImpl.ORDER_BY_JPQL);
			}

			String sql = query.toString();

			Session session = null;

			try {
				session = openSession();

				Query q = session.createQuery(sql);

				QueryPos qPos = QueryPos.getInstance(q);

				if (bindRunType) {
					qPos.add(runType);
				}

				if (!pagination) {
					list = (List<Job>)QueryUtil.list(
						q, getDialect(), start, end, false);

					Collections.sort(list);

					list = Collections.unmodifiableList(list);
				}
				else {
					list = (List<Job>)QueryUtil.list(
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
	 * Returns the first job in the ordered set where runType = &#63;.
	 *
	 * @param runType the run type
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching job
	 * @throws NoSuchJobException if a matching job could not be found
	 */
	@Override
	public Job findByRunType_First(
			String runType, OrderByComparator<Job> orderByComparator)
		throws NoSuchJobException {

		Job job = fetchByRunType_First(runType, orderByComparator);

		if (job != null) {
			return job;
		}

		StringBundler msg = new StringBundler(4);

		msg.append(_NO_SUCH_ENTITY_WITH_KEY);

		msg.append("runType=");
		msg.append(runType);

		msg.append("}");

		throw new NoSuchJobException(msg.toString());
	}

	/**
	 * Returns the first job in the ordered set where runType = &#63;.
	 *
	 * @param runType the run type
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching job, or <code>null</code> if a matching job could not be found
	 */
	@Override
	public Job fetchByRunType_First(
		String runType, OrderByComparator<Job> orderByComparator) {

		List<Job> list = findByRunType(runType, 0, 1, orderByComparator);

		if (!list.isEmpty()) {
			return list.get(0);
		}

		return null;
	}

	/**
	 * Returns the last job in the ordered set where runType = &#63;.
	 *
	 * @param runType the run type
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching job
	 * @throws NoSuchJobException if a matching job could not be found
	 */
	@Override
	public Job findByRunType_Last(
			String runType, OrderByComparator<Job> orderByComparator)
		throws NoSuchJobException {

		Job job = fetchByRunType_Last(runType, orderByComparator);

		if (job != null) {
			return job;
		}

		StringBundler msg = new StringBundler(4);

		msg.append(_NO_SUCH_ENTITY_WITH_KEY);

		msg.append("runType=");
		msg.append(runType);

		msg.append("}");

		throw new NoSuchJobException(msg.toString());
	}

	/**
	 * Returns the last job in the ordered set where runType = &#63;.
	 *
	 * @param runType the run type
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching job, or <code>null</code> if a matching job could not be found
	 */
	@Override
	public Job fetchByRunType_Last(
		String runType, OrderByComparator<Job> orderByComparator) {

		int count = countByRunType(runType);

		if (count == 0) {
			return null;
		}

		List<Job> list = findByRunType(
			runType, count - 1, count, orderByComparator);

		if (!list.isEmpty()) {
			return list.get(0);
		}

		return null;
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
	@Override
	public Job[] findByRunType_PrevAndNext(
			long jobId, String runType,
			OrderByComparator<Job> orderByComparator)
		throws NoSuchJobException {

		runType = Objects.toString(runType, "");

		Job job = findByPrimaryKey(jobId);

		Session session = null;

		try {
			session = openSession();

			Job[] array = new JobImpl[3];

			array[0] = getByRunType_PrevAndNext(
				session, job, runType, orderByComparator, true);

			array[1] = job;

			array[2] = getByRunType_PrevAndNext(
				session, job, runType, orderByComparator, false);

			return array;
		}
		catch (Exception e) {
			throw processException(e);
		}
		finally {
			closeSession(session);
		}
	}

	protected Job getByRunType_PrevAndNext(
		Session session, Job job, String runType,
		OrderByComparator<Job> orderByComparator, boolean previous) {

		StringBundler query = null;

		if (orderByComparator != null) {
			query = new StringBundler(
				4 + (orderByComparator.getOrderByConditionFields().length * 3) +
					(orderByComparator.getOrderByFields().length * 3));
		}
		else {
			query = new StringBundler(3);
		}

		query.append(_SQL_SELECT_JOB_WHERE);

		boolean bindRunType = false;

		if (runType.isEmpty()) {
			query.append(_FINDER_COLUMN_RUNTYPE_RUNTYPE_3);
		}
		else {
			bindRunType = true;

			query.append(_FINDER_COLUMN_RUNTYPE_RUNTYPE_2);
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
			query.append(JobModelImpl.ORDER_BY_JPQL);
		}

		String sql = query.toString();

		Query q = session.createQuery(sql);

		q.setFirstResult(0);
		q.setMaxResults(2);

		QueryPos qPos = QueryPos.getInstance(q);

		if (bindRunType) {
			qPos.add(runType);
		}

		if (orderByComparator != null) {
			for (Object orderByConditionValue :
					orderByComparator.getOrderByConditionValues(job)) {

				qPos.add(orderByConditionValue);
			}
		}

		List<Job> list = q.list();

		if (list.size() == 2) {
			return list.get(1);
		}
		else {
			return null;
		}
	}

	/**
	 * Removes all the jobs where runType = &#63; from the database.
	 *
	 * @param runType the run type
	 */
	@Override
	public void removeByRunType(String runType) {
		for (Job job :
				findByRunType(
					runType, QueryUtil.ALL_POS, QueryUtil.ALL_POS, null)) {

			remove(job);
		}
	}

	/**
	 * Returns the number of jobs where runType = &#63;.
	 *
	 * @param runType the run type
	 * @return the number of matching jobs
	 */
	@Override
	public int countByRunType(String runType) {
		runType = Objects.toString(runType, "");

		FinderPath finderPath = _finderPathCountByRunType;

		Object[] finderArgs = new Object[] {runType};

		Long count = (Long)finderCache.getResult(finderPath, finderArgs, this);

		if (count == null) {
			StringBundler query = new StringBundler(2);

			query.append(_SQL_COUNT_JOB_WHERE);

			boolean bindRunType = false;

			if (runType.isEmpty()) {
				query.append(_FINDER_COLUMN_RUNTYPE_RUNTYPE_3);
			}
			else {
				bindRunType = true;

				query.append(_FINDER_COLUMN_RUNTYPE_RUNTYPE_2);
			}

			String sql = query.toString();

			Session session = null;

			try {
				session = openSession();

				Query q = session.createQuery(sql);

				QueryPos qPos = QueryPos.getInstance(q);

				if (bindRunType) {
					qPos.add(runType);
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

	private static final String _FINDER_COLUMN_RUNTYPE_RUNTYPE_2 =
		"job.runType = ?";

	private static final String _FINDER_COLUMN_RUNTYPE_RUNTYPE_3 =
		"(job.runType IS NULL OR job.runType = '')";

	private FinderPath _finderPathWithPaginationFindByRunType_G;
	private FinderPath _finderPathWithoutPaginationFindByRunType_G;
	private FinderPath _finderPathCountByRunType_G;

	/**
	 * Returns all the jobs where groupId = &#63; and runType = &#63;.
	 *
	 * @param groupId the group ID
	 * @param runType the run type
	 * @return the matching jobs
	 */
	@Override
	public List<Job> findByRunType_G(long groupId, String runType) {
		return findByRunType_G(
			groupId, runType, QueryUtil.ALL_POS, QueryUtil.ALL_POS, null);
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
	@Override
	public List<Job> findByRunType_G(
		long groupId, String runType, int start, int end) {

		return findByRunType_G(groupId, runType, start, end, null);
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
	@Override
	public List<Job> findByRunType_G(
		long groupId, String runType, int start, int end,
		OrderByComparator<Job> orderByComparator) {

		return findByRunType_G(
			groupId, runType, start, end, orderByComparator, true);
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
	@Override
	public List<Job> findByRunType_G(
		long groupId, String runType, int start, int end,
		OrderByComparator<Job> orderByComparator, boolean retrieveFromCache) {

		runType = Objects.toString(runType, "");

		boolean pagination = true;
		FinderPath finderPath = null;
		Object[] finderArgs = null;

		if ((start == QueryUtil.ALL_POS) && (end == QueryUtil.ALL_POS) &&
			(orderByComparator == null)) {

			pagination = false;
			finderPath = _finderPathWithoutPaginationFindByRunType_G;
			finderArgs = new Object[] {groupId, runType};
		}
		else {
			finderPath = _finderPathWithPaginationFindByRunType_G;
			finderArgs = new Object[] {
				groupId, runType, start, end, orderByComparator
			};
		}

		List<Job> list = null;

		if (retrieveFromCache) {
			list = (List<Job>)finderCache.getResult(
				finderPath, finderArgs, this);

			if ((list != null) && !list.isEmpty()) {
				for (Job job : list) {
					if ((groupId != job.getGroupId()) ||
						!runType.equals(job.getRunType())) {

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

			query.append(_SQL_SELECT_JOB_WHERE);

			query.append(_FINDER_COLUMN_RUNTYPE_G_GROUPID_2);

			boolean bindRunType = false;

			if (runType.isEmpty()) {
				query.append(_FINDER_COLUMN_RUNTYPE_G_RUNTYPE_3);
			}
			else {
				bindRunType = true;

				query.append(_FINDER_COLUMN_RUNTYPE_G_RUNTYPE_2);
			}

			if (orderByComparator != null) {
				appendOrderByComparator(
					query, _ORDER_BY_ENTITY_ALIAS, orderByComparator);
			}
			else if (pagination) {
				query.append(JobModelImpl.ORDER_BY_JPQL);
			}

			String sql = query.toString();

			Session session = null;

			try {
				session = openSession();

				Query q = session.createQuery(sql);

				QueryPos qPos = QueryPos.getInstance(q);

				qPos.add(groupId);

				if (bindRunType) {
					qPos.add(runType);
				}

				if (!pagination) {
					list = (List<Job>)QueryUtil.list(
						q, getDialect(), start, end, false);

					Collections.sort(list);

					list = Collections.unmodifiableList(list);
				}
				else {
					list = (List<Job>)QueryUtil.list(
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
	 * Returns the first job in the ordered set where groupId = &#63; and runType = &#63;.
	 *
	 * @param groupId the group ID
	 * @param runType the run type
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching job
	 * @throws NoSuchJobException if a matching job could not be found
	 */
	@Override
	public Job findByRunType_G_First(
			long groupId, String runType,
			OrderByComparator<Job> orderByComparator)
		throws NoSuchJobException {

		Job job = fetchByRunType_G_First(groupId, runType, orderByComparator);

		if (job != null) {
			return job;
		}

		StringBundler msg = new StringBundler(6);

		msg.append(_NO_SUCH_ENTITY_WITH_KEY);

		msg.append("groupId=");
		msg.append(groupId);

		msg.append(", runType=");
		msg.append(runType);

		msg.append("}");

		throw new NoSuchJobException(msg.toString());
	}

	/**
	 * Returns the first job in the ordered set where groupId = &#63; and runType = &#63;.
	 *
	 * @param groupId the group ID
	 * @param runType the run type
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching job, or <code>null</code> if a matching job could not be found
	 */
	@Override
	public Job fetchByRunType_G_First(
		long groupId, String runType,
		OrderByComparator<Job> orderByComparator) {

		List<Job> list = findByRunType_G(
			groupId, runType, 0, 1, orderByComparator);

		if (!list.isEmpty()) {
			return list.get(0);
		}

		return null;
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
	@Override
	public Job findByRunType_G_Last(
			long groupId, String runType,
			OrderByComparator<Job> orderByComparator)
		throws NoSuchJobException {

		Job job = fetchByRunType_G_Last(groupId, runType, orderByComparator);

		if (job != null) {
			return job;
		}

		StringBundler msg = new StringBundler(6);

		msg.append(_NO_SUCH_ENTITY_WITH_KEY);

		msg.append("groupId=");
		msg.append(groupId);

		msg.append(", runType=");
		msg.append(runType);

		msg.append("}");

		throw new NoSuchJobException(msg.toString());
	}

	/**
	 * Returns the last job in the ordered set where groupId = &#63; and runType = &#63;.
	 *
	 * @param groupId the group ID
	 * @param runType the run type
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching job, or <code>null</code> if a matching job could not be found
	 */
	@Override
	public Job fetchByRunType_G_Last(
		long groupId, String runType,
		OrderByComparator<Job> orderByComparator) {

		int count = countByRunType_G(groupId, runType);

		if (count == 0) {
			return null;
		}

		List<Job> list = findByRunType_G(
			groupId, runType, count - 1, count, orderByComparator);

		if (!list.isEmpty()) {
			return list.get(0);
		}

		return null;
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
	@Override
	public Job[] findByRunType_G_PrevAndNext(
			long jobId, long groupId, String runType,
			OrderByComparator<Job> orderByComparator)
		throws NoSuchJobException {

		runType = Objects.toString(runType, "");

		Job job = findByPrimaryKey(jobId);

		Session session = null;

		try {
			session = openSession();

			Job[] array = new JobImpl[3];

			array[0] = getByRunType_G_PrevAndNext(
				session, job, groupId, runType, orderByComparator, true);

			array[1] = job;

			array[2] = getByRunType_G_PrevAndNext(
				session, job, groupId, runType, orderByComparator, false);

			return array;
		}
		catch (Exception e) {
			throw processException(e);
		}
		finally {
			closeSession(session);
		}
	}

	protected Job getByRunType_G_PrevAndNext(
		Session session, Job job, long groupId, String runType,
		OrderByComparator<Job> orderByComparator, boolean previous) {

		StringBundler query = null;

		if (orderByComparator != null) {
			query = new StringBundler(
				5 + (orderByComparator.getOrderByConditionFields().length * 3) +
					(orderByComparator.getOrderByFields().length * 3));
		}
		else {
			query = new StringBundler(4);
		}

		query.append(_SQL_SELECT_JOB_WHERE);

		query.append(_FINDER_COLUMN_RUNTYPE_G_GROUPID_2);

		boolean bindRunType = false;

		if (runType.isEmpty()) {
			query.append(_FINDER_COLUMN_RUNTYPE_G_RUNTYPE_3);
		}
		else {
			bindRunType = true;

			query.append(_FINDER_COLUMN_RUNTYPE_G_RUNTYPE_2);
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
			query.append(JobModelImpl.ORDER_BY_JPQL);
		}

		String sql = query.toString();

		Query q = session.createQuery(sql);

		q.setFirstResult(0);
		q.setMaxResults(2);

		QueryPos qPos = QueryPos.getInstance(q);

		qPos.add(groupId);

		if (bindRunType) {
			qPos.add(runType);
		}

		if (orderByComparator != null) {
			for (Object orderByConditionValue :
					orderByComparator.getOrderByConditionValues(job)) {

				qPos.add(orderByConditionValue);
			}
		}

		List<Job> list = q.list();

		if (list.size() == 2) {
			return list.get(1);
		}
		else {
			return null;
		}
	}

	/**
	 * Removes all the jobs where groupId = &#63; and runType = &#63; from the database.
	 *
	 * @param groupId the group ID
	 * @param runType the run type
	 */
	@Override
	public void removeByRunType_G(long groupId, String runType) {
		for (Job job :
				findByRunType_G(
					groupId, runType, QueryUtil.ALL_POS, QueryUtil.ALL_POS,
					null)) {

			remove(job);
		}
	}

	/**
	 * Returns the number of jobs where groupId = &#63; and runType = &#63;.
	 *
	 * @param groupId the group ID
	 * @param runType the run type
	 * @return the number of matching jobs
	 */
	@Override
	public int countByRunType_G(long groupId, String runType) {
		runType = Objects.toString(runType, "");

		FinderPath finderPath = _finderPathCountByRunType_G;

		Object[] finderArgs = new Object[] {groupId, runType};

		Long count = (Long)finderCache.getResult(finderPath, finderArgs, this);

		if (count == null) {
			StringBundler query = new StringBundler(3);

			query.append(_SQL_COUNT_JOB_WHERE);

			query.append(_FINDER_COLUMN_RUNTYPE_G_GROUPID_2);

			boolean bindRunType = false;

			if (runType.isEmpty()) {
				query.append(_FINDER_COLUMN_RUNTYPE_G_RUNTYPE_3);
			}
			else {
				bindRunType = true;

				query.append(_FINDER_COLUMN_RUNTYPE_G_RUNTYPE_2);
			}

			String sql = query.toString();

			Session session = null;

			try {
				session = openSession();

				Query q = session.createQuery(sql);

				QueryPos qPos = QueryPos.getInstance(q);

				qPos.add(groupId);

				if (bindRunType) {
					qPos.add(runType);
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

	private static final String _FINDER_COLUMN_RUNTYPE_G_GROUPID_2 =
		"job.groupId = ? AND ";

	private static final String _FINDER_COLUMN_RUNTYPE_G_RUNTYPE_2 =
		"job.runType = ?";

	private static final String _FINDER_COLUMN_RUNTYPE_G_RUNTYPE_3 =
		"(job.runType IS NULL OR job.runType = '')";

	private FinderPath _finderPathWithPaginationFindByRunType_U;
	private FinderPath _finderPathWithoutPaginationFindByRunType_U;
	private FinderPath _finderPathCountByRunType_U;

	/**
	 * Returns all the jobs where userId = &#63; and runType = &#63;.
	 *
	 * @param userId the user ID
	 * @param runType the run type
	 * @return the matching jobs
	 */
	@Override
	public List<Job> findByRunType_U(long userId, String runType) {
		return findByRunType_U(
			userId, runType, QueryUtil.ALL_POS, QueryUtil.ALL_POS, null);
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
	@Override
	public List<Job> findByRunType_U(
		long userId, String runType, int start, int end) {

		return findByRunType_U(userId, runType, start, end, null);
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
	@Override
	public List<Job> findByRunType_U(
		long userId, String runType, int start, int end,
		OrderByComparator<Job> orderByComparator) {

		return findByRunType_U(
			userId, runType, start, end, orderByComparator, true);
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
	@Override
	public List<Job> findByRunType_U(
		long userId, String runType, int start, int end,
		OrderByComparator<Job> orderByComparator, boolean retrieveFromCache) {

		runType = Objects.toString(runType, "");

		boolean pagination = true;
		FinderPath finderPath = null;
		Object[] finderArgs = null;

		if ((start == QueryUtil.ALL_POS) && (end == QueryUtil.ALL_POS) &&
			(orderByComparator == null)) {

			pagination = false;
			finderPath = _finderPathWithoutPaginationFindByRunType_U;
			finderArgs = new Object[] {userId, runType};
		}
		else {
			finderPath = _finderPathWithPaginationFindByRunType_U;
			finderArgs = new Object[] {
				userId, runType, start, end, orderByComparator
			};
		}

		List<Job> list = null;

		if (retrieveFromCache) {
			list = (List<Job>)finderCache.getResult(
				finderPath, finderArgs, this);

			if ((list != null) && !list.isEmpty()) {
				for (Job job : list) {
					if ((userId != job.getUserId()) ||
						!runType.equals(job.getRunType())) {

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

			query.append(_SQL_SELECT_JOB_WHERE);

			query.append(_FINDER_COLUMN_RUNTYPE_U_USERID_2);

			boolean bindRunType = false;

			if (runType.isEmpty()) {
				query.append(_FINDER_COLUMN_RUNTYPE_U_RUNTYPE_3);
			}
			else {
				bindRunType = true;

				query.append(_FINDER_COLUMN_RUNTYPE_U_RUNTYPE_2);
			}

			if (orderByComparator != null) {
				appendOrderByComparator(
					query, _ORDER_BY_ENTITY_ALIAS, orderByComparator);
			}
			else if (pagination) {
				query.append(JobModelImpl.ORDER_BY_JPQL);
			}

			String sql = query.toString();

			Session session = null;

			try {
				session = openSession();

				Query q = session.createQuery(sql);

				QueryPos qPos = QueryPos.getInstance(q);

				qPos.add(userId);

				if (bindRunType) {
					qPos.add(runType);
				}

				if (!pagination) {
					list = (List<Job>)QueryUtil.list(
						q, getDialect(), start, end, false);

					Collections.sort(list);

					list = Collections.unmodifiableList(list);
				}
				else {
					list = (List<Job>)QueryUtil.list(
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
	 * Returns the first job in the ordered set where userId = &#63; and runType = &#63;.
	 *
	 * @param userId the user ID
	 * @param runType the run type
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching job
	 * @throws NoSuchJobException if a matching job could not be found
	 */
	@Override
	public Job findByRunType_U_First(
			long userId, String runType,
			OrderByComparator<Job> orderByComparator)
		throws NoSuchJobException {

		Job job = fetchByRunType_U_First(userId, runType, orderByComparator);

		if (job != null) {
			return job;
		}

		StringBundler msg = new StringBundler(6);

		msg.append(_NO_SUCH_ENTITY_WITH_KEY);

		msg.append("userId=");
		msg.append(userId);

		msg.append(", runType=");
		msg.append(runType);

		msg.append("}");

		throw new NoSuchJobException(msg.toString());
	}

	/**
	 * Returns the first job in the ordered set where userId = &#63; and runType = &#63;.
	 *
	 * @param userId the user ID
	 * @param runType the run type
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching job, or <code>null</code> if a matching job could not be found
	 */
	@Override
	public Job fetchByRunType_U_First(
		long userId, String runType, OrderByComparator<Job> orderByComparator) {

		List<Job> list = findByRunType_U(
			userId, runType, 0, 1, orderByComparator);

		if (!list.isEmpty()) {
			return list.get(0);
		}

		return null;
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
	@Override
	public Job findByRunType_U_Last(
			long userId, String runType,
			OrderByComparator<Job> orderByComparator)
		throws NoSuchJobException {

		Job job = fetchByRunType_U_Last(userId, runType, orderByComparator);

		if (job != null) {
			return job;
		}

		StringBundler msg = new StringBundler(6);

		msg.append(_NO_SUCH_ENTITY_WITH_KEY);

		msg.append("userId=");
		msg.append(userId);

		msg.append(", runType=");
		msg.append(runType);

		msg.append("}");

		throw new NoSuchJobException(msg.toString());
	}

	/**
	 * Returns the last job in the ordered set where userId = &#63; and runType = &#63;.
	 *
	 * @param userId the user ID
	 * @param runType the run type
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching job, or <code>null</code> if a matching job could not be found
	 */
	@Override
	public Job fetchByRunType_U_Last(
		long userId, String runType, OrderByComparator<Job> orderByComparator) {

		int count = countByRunType_U(userId, runType);

		if (count == 0) {
			return null;
		}

		List<Job> list = findByRunType_U(
			userId, runType, count - 1, count, orderByComparator);

		if (!list.isEmpty()) {
			return list.get(0);
		}

		return null;
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
	@Override
	public Job[] findByRunType_U_PrevAndNext(
			long jobId, long userId, String runType,
			OrderByComparator<Job> orderByComparator)
		throws NoSuchJobException {

		runType = Objects.toString(runType, "");

		Job job = findByPrimaryKey(jobId);

		Session session = null;

		try {
			session = openSession();

			Job[] array = new JobImpl[3];

			array[0] = getByRunType_U_PrevAndNext(
				session, job, userId, runType, orderByComparator, true);

			array[1] = job;

			array[2] = getByRunType_U_PrevAndNext(
				session, job, userId, runType, orderByComparator, false);

			return array;
		}
		catch (Exception e) {
			throw processException(e);
		}
		finally {
			closeSession(session);
		}
	}

	protected Job getByRunType_U_PrevAndNext(
		Session session, Job job, long userId, String runType,
		OrderByComparator<Job> orderByComparator, boolean previous) {

		StringBundler query = null;

		if (orderByComparator != null) {
			query = new StringBundler(
				5 + (orderByComparator.getOrderByConditionFields().length * 3) +
					(orderByComparator.getOrderByFields().length * 3));
		}
		else {
			query = new StringBundler(4);
		}

		query.append(_SQL_SELECT_JOB_WHERE);

		query.append(_FINDER_COLUMN_RUNTYPE_U_USERID_2);

		boolean bindRunType = false;

		if (runType.isEmpty()) {
			query.append(_FINDER_COLUMN_RUNTYPE_U_RUNTYPE_3);
		}
		else {
			bindRunType = true;

			query.append(_FINDER_COLUMN_RUNTYPE_U_RUNTYPE_2);
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
			query.append(JobModelImpl.ORDER_BY_JPQL);
		}

		String sql = query.toString();

		Query q = session.createQuery(sql);

		q.setFirstResult(0);
		q.setMaxResults(2);

		QueryPos qPos = QueryPos.getInstance(q);

		qPos.add(userId);

		if (bindRunType) {
			qPos.add(runType);
		}

		if (orderByComparator != null) {
			for (Object orderByConditionValue :
					orderByComparator.getOrderByConditionValues(job)) {

				qPos.add(orderByConditionValue);
			}
		}

		List<Job> list = q.list();

		if (list.size() == 2) {
			return list.get(1);
		}
		else {
			return null;
		}
	}

	/**
	 * Removes all the jobs where userId = &#63; and runType = &#63; from the database.
	 *
	 * @param userId the user ID
	 * @param runType the run type
	 */
	@Override
	public void removeByRunType_U(long userId, String runType) {
		for (Job job :
				findByRunType_U(
					userId, runType, QueryUtil.ALL_POS, QueryUtil.ALL_POS,
					null)) {

			remove(job);
		}
	}

	/**
	 * Returns the number of jobs where userId = &#63; and runType = &#63;.
	 *
	 * @param userId the user ID
	 * @param runType the run type
	 * @return the number of matching jobs
	 */
	@Override
	public int countByRunType_U(long userId, String runType) {
		runType = Objects.toString(runType, "");

		FinderPath finderPath = _finderPathCountByRunType_U;

		Object[] finderArgs = new Object[] {userId, runType};

		Long count = (Long)finderCache.getResult(finderPath, finderArgs, this);

		if (count == null) {
			StringBundler query = new StringBundler(3);

			query.append(_SQL_COUNT_JOB_WHERE);

			query.append(_FINDER_COLUMN_RUNTYPE_U_USERID_2);

			boolean bindRunType = false;

			if (runType.isEmpty()) {
				query.append(_FINDER_COLUMN_RUNTYPE_U_RUNTYPE_3);
			}
			else {
				bindRunType = true;

				query.append(_FINDER_COLUMN_RUNTYPE_U_RUNTYPE_2);
			}

			String sql = query.toString();

			Session session = null;

			try {
				session = openSession();

				Query q = session.createQuery(sql);

				QueryPos qPos = QueryPos.getInstance(q);

				qPos.add(userId);

				if (bindRunType) {
					qPos.add(runType);
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

	private static final String _FINDER_COLUMN_RUNTYPE_U_USERID_2 =
		"job.userId = ? AND ";

	private static final String _FINDER_COLUMN_RUNTYPE_U_RUNTYPE_2 =
		"job.runType = ?";

	private static final String _FINDER_COLUMN_RUNTYPE_U_RUNTYPE_3 =
		"(job.runType IS NULL OR job.runType = '')";

	private FinderPath _finderPathWithPaginationFindByRunType_G_U;
	private FinderPath _finderPathWithoutPaginationFindByRunType_G_U;
	private FinderPath _finderPathCountByRunType_G_U;

	/**
	 * Returns all the jobs where groupId = &#63; and userId = &#63; and runType = &#63;.
	 *
	 * @param groupId the group ID
	 * @param userId the user ID
	 * @param runType the run type
	 * @return the matching jobs
	 */
	@Override
	public List<Job> findByRunType_G_U(
		long groupId, long userId, String runType) {

		return findByRunType_G_U(
			groupId, userId, runType, QueryUtil.ALL_POS, QueryUtil.ALL_POS,
			null);
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
	@Override
	public List<Job> findByRunType_G_U(
		long groupId, long userId, String runType, int start, int end) {

		return findByRunType_G_U(groupId, userId, runType, start, end, null);
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
	@Override
	public List<Job> findByRunType_G_U(
		long groupId, long userId, String runType, int start, int end,
		OrderByComparator<Job> orderByComparator) {

		return findByRunType_G_U(
			groupId, userId, runType, start, end, orderByComparator, true);
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
	@Override
	public List<Job> findByRunType_G_U(
		long groupId, long userId, String runType, int start, int end,
		OrderByComparator<Job> orderByComparator, boolean retrieveFromCache) {

		runType = Objects.toString(runType, "");

		boolean pagination = true;
		FinderPath finderPath = null;
		Object[] finderArgs = null;

		if ((start == QueryUtil.ALL_POS) && (end == QueryUtil.ALL_POS) &&
			(orderByComparator == null)) {

			pagination = false;
			finderPath = _finderPathWithoutPaginationFindByRunType_G_U;
			finderArgs = new Object[] {groupId, userId, runType};
		}
		else {
			finderPath = _finderPathWithPaginationFindByRunType_G_U;
			finderArgs = new Object[] {
				groupId, userId, runType, start, end, orderByComparator
			};
		}

		List<Job> list = null;

		if (retrieveFromCache) {
			list = (List<Job>)finderCache.getResult(
				finderPath, finderArgs, this);

			if ((list != null) && !list.isEmpty()) {
				for (Job job : list) {
					if ((groupId != job.getGroupId()) ||
						(userId != job.getUserId()) ||
						!runType.equals(job.getRunType())) {

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
					5 + (orderByComparator.getOrderByFields().length * 2));
			}
			else {
				query = new StringBundler(5);
			}

			query.append(_SQL_SELECT_JOB_WHERE);

			query.append(_FINDER_COLUMN_RUNTYPE_G_U_GROUPID_2);

			query.append(_FINDER_COLUMN_RUNTYPE_G_U_USERID_2);

			boolean bindRunType = false;

			if (runType.isEmpty()) {
				query.append(_FINDER_COLUMN_RUNTYPE_G_U_RUNTYPE_3);
			}
			else {
				bindRunType = true;

				query.append(_FINDER_COLUMN_RUNTYPE_G_U_RUNTYPE_2);
			}

			if (orderByComparator != null) {
				appendOrderByComparator(
					query, _ORDER_BY_ENTITY_ALIAS, orderByComparator);
			}
			else if (pagination) {
				query.append(JobModelImpl.ORDER_BY_JPQL);
			}

			String sql = query.toString();

			Session session = null;

			try {
				session = openSession();

				Query q = session.createQuery(sql);

				QueryPos qPos = QueryPos.getInstance(q);

				qPos.add(groupId);

				qPos.add(userId);

				if (bindRunType) {
					qPos.add(runType);
				}

				if (!pagination) {
					list = (List<Job>)QueryUtil.list(
						q, getDialect(), start, end, false);

					Collections.sort(list);

					list = Collections.unmodifiableList(list);
				}
				else {
					list = (List<Job>)QueryUtil.list(
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
	 * Returns the first job in the ordered set where groupId = &#63; and userId = &#63; and runType = &#63;.
	 *
	 * @param groupId the group ID
	 * @param userId the user ID
	 * @param runType the run type
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching job
	 * @throws NoSuchJobException if a matching job could not be found
	 */
	@Override
	public Job findByRunType_G_U_First(
			long groupId, long userId, String runType,
			OrderByComparator<Job> orderByComparator)
		throws NoSuchJobException {

		Job job = fetchByRunType_G_U_First(
			groupId, userId, runType, orderByComparator);

		if (job != null) {
			return job;
		}

		StringBundler msg = new StringBundler(8);

		msg.append(_NO_SUCH_ENTITY_WITH_KEY);

		msg.append("groupId=");
		msg.append(groupId);

		msg.append(", userId=");
		msg.append(userId);

		msg.append(", runType=");
		msg.append(runType);

		msg.append("}");

		throw new NoSuchJobException(msg.toString());
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
	@Override
	public Job fetchByRunType_G_U_First(
		long groupId, long userId, String runType,
		OrderByComparator<Job> orderByComparator) {

		List<Job> list = findByRunType_G_U(
			groupId, userId, runType, 0, 1, orderByComparator);

		if (!list.isEmpty()) {
			return list.get(0);
		}

		return null;
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
	@Override
	public Job findByRunType_G_U_Last(
			long groupId, long userId, String runType,
			OrderByComparator<Job> orderByComparator)
		throws NoSuchJobException {

		Job job = fetchByRunType_G_U_Last(
			groupId, userId, runType, orderByComparator);

		if (job != null) {
			return job;
		}

		StringBundler msg = new StringBundler(8);

		msg.append(_NO_SUCH_ENTITY_WITH_KEY);

		msg.append("groupId=");
		msg.append(groupId);

		msg.append(", userId=");
		msg.append(userId);

		msg.append(", runType=");
		msg.append(runType);

		msg.append("}");

		throw new NoSuchJobException(msg.toString());
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
	@Override
	public Job fetchByRunType_G_U_Last(
		long groupId, long userId, String runType,
		OrderByComparator<Job> orderByComparator) {

		int count = countByRunType_G_U(groupId, userId, runType);

		if (count == 0) {
			return null;
		}

		List<Job> list = findByRunType_G_U(
			groupId, userId, runType, count - 1, count, orderByComparator);

		if (!list.isEmpty()) {
			return list.get(0);
		}

		return null;
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
	@Override
	public Job[] findByRunType_G_U_PrevAndNext(
			long jobId, long groupId, long userId, String runType,
			OrderByComparator<Job> orderByComparator)
		throws NoSuchJobException {

		runType = Objects.toString(runType, "");

		Job job = findByPrimaryKey(jobId);

		Session session = null;

		try {
			session = openSession();

			Job[] array = new JobImpl[3];

			array[0] = getByRunType_G_U_PrevAndNext(
				session, job, groupId, userId, runType, orderByComparator,
				true);

			array[1] = job;

			array[2] = getByRunType_G_U_PrevAndNext(
				session, job, groupId, userId, runType, orderByComparator,
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

	protected Job getByRunType_G_U_PrevAndNext(
		Session session, Job job, long groupId, long userId, String runType,
		OrderByComparator<Job> orderByComparator, boolean previous) {

		StringBundler query = null;

		if (orderByComparator != null) {
			query = new StringBundler(
				6 + (orderByComparator.getOrderByConditionFields().length * 3) +
					(orderByComparator.getOrderByFields().length * 3));
		}
		else {
			query = new StringBundler(5);
		}

		query.append(_SQL_SELECT_JOB_WHERE);

		query.append(_FINDER_COLUMN_RUNTYPE_G_U_GROUPID_2);

		query.append(_FINDER_COLUMN_RUNTYPE_G_U_USERID_2);

		boolean bindRunType = false;

		if (runType.isEmpty()) {
			query.append(_FINDER_COLUMN_RUNTYPE_G_U_RUNTYPE_3);
		}
		else {
			bindRunType = true;

			query.append(_FINDER_COLUMN_RUNTYPE_G_U_RUNTYPE_2);
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
			query.append(JobModelImpl.ORDER_BY_JPQL);
		}

		String sql = query.toString();

		Query q = session.createQuery(sql);

		q.setFirstResult(0);
		q.setMaxResults(2);

		QueryPos qPos = QueryPos.getInstance(q);

		qPos.add(groupId);

		qPos.add(userId);

		if (bindRunType) {
			qPos.add(runType);
		}

		if (orderByComparator != null) {
			for (Object orderByConditionValue :
					orderByComparator.getOrderByConditionValues(job)) {

				qPos.add(orderByConditionValue);
			}
		}

		List<Job> list = q.list();

		if (list.size() == 2) {
			return list.get(1);
		}
		else {
			return null;
		}
	}

	/**
	 * Removes all the jobs where groupId = &#63; and userId = &#63; and runType = &#63; from the database.
	 *
	 * @param groupId the group ID
	 * @param userId the user ID
	 * @param runType the run type
	 */
	@Override
	public void removeByRunType_G_U(long groupId, long userId, String runType) {
		for (Job job :
				findByRunType_G_U(
					groupId, userId, runType, QueryUtil.ALL_POS,
					QueryUtil.ALL_POS, null)) {

			remove(job);
		}
	}

	/**
	 * Returns the number of jobs where groupId = &#63; and userId = &#63; and runType = &#63;.
	 *
	 * @param groupId the group ID
	 * @param userId the user ID
	 * @param runType the run type
	 * @return the number of matching jobs
	 */
	@Override
	public int countByRunType_G_U(long groupId, long userId, String runType) {
		runType = Objects.toString(runType, "");

		FinderPath finderPath = _finderPathCountByRunType_G_U;

		Object[] finderArgs = new Object[] {groupId, userId, runType};

		Long count = (Long)finderCache.getResult(finderPath, finderArgs, this);

		if (count == null) {
			StringBundler query = new StringBundler(4);

			query.append(_SQL_COUNT_JOB_WHERE);

			query.append(_FINDER_COLUMN_RUNTYPE_G_U_GROUPID_2);

			query.append(_FINDER_COLUMN_RUNTYPE_G_U_USERID_2);

			boolean bindRunType = false;

			if (runType.isEmpty()) {
				query.append(_FINDER_COLUMN_RUNTYPE_G_U_RUNTYPE_3);
			}
			else {
				bindRunType = true;

				query.append(_FINDER_COLUMN_RUNTYPE_G_U_RUNTYPE_2);
			}

			String sql = query.toString();

			Session session = null;

			try {
				session = openSession();

				Query q = session.createQuery(sql);

				QueryPos qPos = QueryPos.getInstance(q);

				qPos.add(groupId);

				qPos.add(userId);

				if (bindRunType) {
					qPos.add(runType);
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

	private static final String _FINDER_COLUMN_RUNTYPE_G_U_GROUPID_2 =
		"job.groupId = ? AND ";

	private static final String _FINDER_COLUMN_RUNTYPE_G_U_USERID_2 =
		"job.userId = ? AND ";

	private static final String _FINDER_COLUMN_RUNTYPE_G_U_RUNTYPE_2 =
		"job.runType = ?";

	private static final String _FINDER_COLUMN_RUNTYPE_G_U_RUNTYPE_3 =
		"(job.runType IS NULL OR job.runType = '')";

	public JobPersistenceImpl() {
		setModelClass(Job.class);

		setModelImplClass(JobImpl.class);
		setModelPKClass(long.class);

		Map<String, String> dbColumnNames = new HashMap<String, String>();

		dbColumnNames.put("uuid", "uuid_");

		setDBColumnNames(dbColumnNames);
	}

	/**
	 * Caches the job in the entity cache if it is enabled.
	 *
	 * @param job the job
	 */
	@Override
	public void cacheResult(Job job) {
		entityCache.putResult(
			entityCacheEnabled, JobImpl.class, job.getPrimaryKey(), job);

		finderCache.putResult(
			_finderPathFetchByUUID_G,
			new Object[] {job.getUuid(), job.getGroupId()}, job);

		job.resetOriginalValues();
	}

	/**
	 * Caches the jobs in the entity cache if it is enabled.
	 *
	 * @param jobs the jobs
	 */
	@Override
	public void cacheResult(List<Job> jobs) {
		for (Job job : jobs) {
			if (entityCache.getResult(
					entityCacheEnabled, JobImpl.class, job.getPrimaryKey()) ==
						null) {

				cacheResult(job);
			}
			else {
				job.resetOriginalValues();
			}
		}
	}

	/**
	 * Clears the cache for all jobs.
	 *
	 * <p>
	 * The <code>EntityCache</code> and <code>FinderCache</code> are both cleared by this method.
	 * </p>
	 */
	@Override
	public void clearCache() {
		entityCache.clearCache(JobImpl.class);

		finderCache.clearCache(FINDER_CLASS_NAME_ENTITY);
		finderCache.clearCache(FINDER_CLASS_NAME_LIST_WITH_PAGINATION);
		finderCache.clearCache(FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION);
	}

	/**
	 * Clears the cache for the job.
	 *
	 * <p>
	 * The <code>EntityCache</code> and <code>FinderCache</code> are both cleared by this method.
	 * </p>
	 */
	@Override
	public void clearCache(Job job) {
		entityCache.removeResult(
			entityCacheEnabled, JobImpl.class, job.getPrimaryKey());

		finderCache.clearCache(FINDER_CLASS_NAME_LIST_WITH_PAGINATION);
		finderCache.clearCache(FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION);

		clearUniqueFindersCache((JobModelImpl)job, true);
	}

	@Override
	public void clearCache(List<Job> jobs) {
		finderCache.clearCache(FINDER_CLASS_NAME_LIST_WITH_PAGINATION);
		finderCache.clearCache(FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION);

		for (Job job : jobs) {
			entityCache.removeResult(
				entityCacheEnabled, JobImpl.class, job.getPrimaryKey());

			clearUniqueFindersCache((JobModelImpl)job, true);
		}
	}

	protected void cacheUniqueFindersCache(JobModelImpl jobModelImpl) {
		Object[] args = new Object[] {
			jobModelImpl.getUuid(), jobModelImpl.getGroupId()
		};

		finderCache.putResult(
			_finderPathCountByUUID_G, args, Long.valueOf(1), false);
		finderCache.putResult(
			_finderPathFetchByUUID_G, args, jobModelImpl, false);
	}

	protected void clearUniqueFindersCache(
		JobModelImpl jobModelImpl, boolean clearCurrent) {

		if (clearCurrent) {
			Object[] args = new Object[] {
				jobModelImpl.getUuid(), jobModelImpl.getGroupId()
			};

			finderCache.removeResult(_finderPathCountByUUID_G, args);
			finderCache.removeResult(_finderPathFetchByUUID_G, args);
		}

		if ((jobModelImpl.getColumnBitmask() &
			 _finderPathFetchByUUID_G.getColumnBitmask()) != 0) {

			Object[] args = new Object[] {
				jobModelImpl.getOriginalUuid(),
				jobModelImpl.getOriginalGroupId()
			};

			finderCache.removeResult(_finderPathCountByUUID_G, args);
			finderCache.removeResult(_finderPathFetchByUUID_G, args);
		}
	}

	/**
	 * Creates a new job with the primary key. Does not add the job to the database.
	 *
	 * @param jobId the primary key for the new job
	 * @return the new job
	 */
	@Override
	public Job create(long jobId) {
		Job job = new JobImpl();

		job.setNew(true);
		job.setPrimaryKey(jobId);

		String uuid = PortalUUIDUtil.generate();

		job.setUuid(uuid);

		job.setCompanyId(companyProvider.getCompanyId());

		return job;
	}

	/**
	 * Removes the job with the primary key from the database. Also notifies the appropriate model listeners.
	 *
	 * @param jobId the primary key of the job
	 * @return the job that was removed
	 * @throws NoSuchJobException if a job with the primary key could not be found
	 */
	@Override
	public Job remove(long jobId) throws NoSuchJobException {
		return remove((Serializable)jobId);
	}

	/**
	 * Removes the job with the primary key from the database. Also notifies the appropriate model listeners.
	 *
	 * @param primaryKey the primary key of the job
	 * @return the job that was removed
	 * @throws NoSuchJobException if a job with the primary key could not be found
	 */
	@Override
	public Job remove(Serializable primaryKey) throws NoSuchJobException {
		Session session = null;

		try {
			session = openSession();

			Job job = (Job)session.get(JobImpl.class, primaryKey);

			if (job == null) {
				if (_log.isDebugEnabled()) {
					_log.debug(_NO_SUCH_ENTITY_WITH_PRIMARY_KEY + primaryKey);
				}

				throw new NoSuchJobException(
					_NO_SUCH_ENTITY_WITH_PRIMARY_KEY + primaryKey);
			}

			return remove(job);
		}
		catch (NoSuchJobException nsee) {
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
	protected Job removeImpl(Job job) {
		Session session = null;

		try {
			session = openSession();

			if (!session.contains(job)) {
				job = (Job)session.get(JobImpl.class, job.getPrimaryKeyObj());
			}

			if (job != null) {
				session.delete(job);
			}
		}
		catch (Exception e) {
			throw processException(e);
		}
		finally {
			closeSession(session);
		}

		if (job != null) {
			clearCache(job);
		}

		return job;
	}

	@Override
	public Job updateImpl(Job job) {
		boolean isNew = job.isNew();

		if (!(job instanceof JobModelImpl)) {
			InvocationHandler invocationHandler = null;

			if (ProxyUtil.isProxyClass(job.getClass())) {
				invocationHandler = ProxyUtil.getInvocationHandler(job);

				throw new IllegalArgumentException(
					"Implement ModelWrapper in job proxy " +
						invocationHandler.getClass());
			}

			throw new IllegalArgumentException(
				"Implement ModelWrapper in custom Job implementation " +
					job.getClass());
		}

		JobModelImpl jobModelImpl = (JobModelImpl)job;

		if (Validator.isNull(job.getUuid())) {
			String uuid = PortalUUIDUtil.generate();

			job.setUuid(uuid);
		}

		ServiceContext serviceContext =
			ServiceContextThreadLocal.getServiceContext();

		Date now = new Date();

		if (isNew && (job.getCreateDate() == null)) {
			if (serviceContext == null) {
				job.setCreateDate(now);
			}
			else {
				job.setCreateDate(serviceContext.getCreateDate(now));
			}
		}

		if (!jobModelImpl.hasSetModifiedDate()) {
			if (serviceContext == null) {
				job.setModifiedDate(now);
			}
			else {
				job.setModifiedDate(serviceContext.getModifiedDate(now));
			}
		}

		Session session = null;

		try {
			session = openSession();

			if (job.isNew()) {
				session.save(job);

				job.setNew(false);
			}
			else {
				job = (Job)session.merge(job);
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
			Object[] args = new Object[] {jobModelImpl.getUuid()};

			finderCache.removeResult(_finderPathCountByUuid, args);
			finderCache.removeResult(
				_finderPathWithoutPaginationFindByUuid, args);

			args = new Object[] {
				jobModelImpl.getUuid(), jobModelImpl.getCompanyId()
			};

			finderCache.removeResult(_finderPathCountByUuid_C, args);
			finderCache.removeResult(
				_finderPathWithoutPaginationFindByUuid_C, args);

			args = new Object[] {jobModelImpl.getGroupId()};

			finderCache.removeResult(_finderPathCountByGroupId, args);
			finderCache.removeResult(
				_finderPathWithoutPaginationFindByGroupId, args);

			args = new Object[] {jobModelImpl.getUserId()};

			finderCache.removeResult(_finderPathCountByUserId, args);
			finderCache.removeResult(
				_finderPathWithoutPaginationFindByUserId, args);

			args = new Object[] {
				jobModelImpl.getGroupId(), jobModelImpl.getUserId()
			};

			finderCache.removeResult(_finderPathCountByUserId_G, args);
			finderCache.removeResult(
				_finderPathWithoutPaginationFindByUserId_G, args);

			args = new Object[] {jobModelImpl.getStatus()};

			finderCache.removeResult(_finderPathCountByStatus, args);
			finderCache.removeResult(
				_finderPathWithoutPaginationFindByStatus, args);

			args = new Object[] {
				jobModelImpl.getGroupId(), jobModelImpl.getStatus()
			};

			finderCache.removeResult(_finderPathCountByStatus_G, args);
			finderCache.removeResult(
				_finderPathWithoutPaginationFindByStatus_G, args);

			args = new Object[] {
				jobModelImpl.getUserId(), jobModelImpl.getStatus()
			};

			finderCache.removeResult(_finderPathCountByStatus_U, args);
			finderCache.removeResult(
				_finderPathWithoutPaginationFindByStatus_U, args);

			args = new Object[] {
				jobModelImpl.getGroupId(), jobModelImpl.getUserId(),
				jobModelImpl.getStatus()
			};

			finderCache.removeResult(_finderPathCountByStatus_G_U, args);
			finderCache.removeResult(
				_finderPathWithoutPaginationFindByStatus_G_U, args);

			args = new Object[] {jobModelImpl.getQueueName()};

			finderCache.removeResult(_finderPathCountByQueueName, args);
			finderCache.removeResult(
				_finderPathWithoutPaginationFindByQueueName, args);

			args = new Object[] {jobModelImpl.getJobStatus()};

			finderCache.removeResult(_finderPathCountByJobStatus, args);
			finderCache.removeResult(
				_finderPathWithoutPaginationFindByJobStatus, args);

			args = new Object[] {
				jobModelImpl.getGroupId(), jobModelImpl.getJobStatus()
			};

			finderCache.removeResult(_finderPathCountByJobStatus_G, args);
			finderCache.removeResult(
				_finderPathWithoutPaginationFindByJobStatus_G, args);

			args = new Object[] {
				jobModelImpl.getUserId(), jobModelImpl.getJobStatus()
			};

			finderCache.removeResult(_finderPathCountByJobStatus_U, args);
			finderCache.removeResult(
				_finderPathWithoutPaginationFindByJobStatus_U, args);

			args = new Object[] {
				jobModelImpl.getGroupId(), jobModelImpl.getUserId(),
				jobModelImpl.getJobStatus()
			};

			finderCache.removeResult(_finderPathCountByJobStatus_G_U, args);
			finderCache.removeResult(
				_finderPathWithoutPaginationFindByJobStatus_G_U, args);

			args = new Object[] {jobModelImpl.getClusterId()};

			finderCache.removeResult(_finderPathCountByClusterId, args);
			finderCache.removeResult(
				_finderPathWithoutPaginationFindByClusterId, args);

			args = new Object[] {
				jobModelImpl.getGroupId(), jobModelImpl.getClusterId()
			};

			finderCache.removeResult(_finderPathCountByClusterId_G, args);
			finderCache.removeResult(
				_finderPathWithoutPaginationFindByClusterId_G, args);

			args = new Object[] {
				jobModelImpl.getUserId(), jobModelImpl.getClusterId()
			};

			finderCache.removeResult(_finderPathCountByClusterId_U, args);
			finderCache.removeResult(
				_finderPathWithoutPaginationFindByClusterId_U, args);

			args = new Object[] {
				jobModelImpl.getGroupId(), jobModelImpl.getUserId(),
				jobModelImpl.getClusterId()
			};

			finderCache.removeResult(_finderPathCountByClusterId_G_U, args);
			finderCache.removeResult(
				_finderPathWithoutPaginationFindByClusterId_G_U, args);

			args = new Object[] {jobModelImpl.getRunType()};

			finderCache.removeResult(_finderPathCountByRunType, args);
			finderCache.removeResult(
				_finderPathWithoutPaginationFindByRunType, args);

			args = new Object[] {
				jobModelImpl.getGroupId(), jobModelImpl.getRunType()
			};

			finderCache.removeResult(_finderPathCountByRunType_G, args);
			finderCache.removeResult(
				_finderPathWithoutPaginationFindByRunType_G, args);

			args = new Object[] {
				jobModelImpl.getUserId(), jobModelImpl.getRunType()
			};

			finderCache.removeResult(_finderPathCountByRunType_U, args);
			finderCache.removeResult(
				_finderPathWithoutPaginationFindByRunType_U, args);

			args = new Object[] {
				jobModelImpl.getGroupId(), jobModelImpl.getUserId(),
				jobModelImpl.getRunType()
			};

			finderCache.removeResult(_finderPathCountByRunType_G_U, args);
			finderCache.removeResult(
				_finderPathWithoutPaginationFindByRunType_G_U, args);

			finderCache.removeResult(_finderPathCountAll, FINDER_ARGS_EMPTY);
			finderCache.removeResult(
				_finderPathWithoutPaginationFindAll, FINDER_ARGS_EMPTY);
		}
		else {
			if ((jobModelImpl.getColumnBitmask() &
				 _finderPathWithoutPaginationFindByUuid.getColumnBitmask()) !=
					 0) {

				Object[] args = new Object[] {jobModelImpl.getOriginalUuid()};

				finderCache.removeResult(_finderPathCountByUuid, args);
				finderCache.removeResult(
					_finderPathWithoutPaginationFindByUuid, args);

				args = new Object[] {jobModelImpl.getUuid()};

				finderCache.removeResult(_finderPathCountByUuid, args);
				finderCache.removeResult(
					_finderPathWithoutPaginationFindByUuid, args);
			}

			if ((jobModelImpl.getColumnBitmask() &
				 _finderPathWithoutPaginationFindByUuid_C.getColumnBitmask()) !=
					 0) {

				Object[] args = new Object[] {
					jobModelImpl.getOriginalUuid(),
					jobModelImpl.getOriginalCompanyId()
				};

				finderCache.removeResult(_finderPathCountByUuid_C, args);
				finderCache.removeResult(
					_finderPathWithoutPaginationFindByUuid_C, args);

				args = new Object[] {
					jobModelImpl.getUuid(), jobModelImpl.getCompanyId()
				};

				finderCache.removeResult(_finderPathCountByUuid_C, args);
				finderCache.removeResult(
					_finderPathWithoutPaginationFindByUuid_C, args);
			}

			if ((jobModelImpl.getColumnBitmask() &
				 _finderPathWithoutPaginationFindByGroupId.
					 getColumnBitmask()) != 0) {

				Object[] args = new Object[] {
					jobModelImpl.getOriginalGroupId()
				};

				finderCache.removeResult(_finderPathCountByGroupId, args);
				finderCache.removeResult(
					_finderPathWithoutPaginationFindByGroupId, args);

				args = new Object[] {jobModelImpl.getGroupId()};

				finderCache.removeResult(_finderPathCountByGroupId, args);
				finderCache.removeResult(
					_finderPathWithoutPaginationFindByGroupId, args);
			}

			if ((jobModelImpl.getColumnBitmask() &
				 _finderPathWithoutPaginationFindByUserId.getColumnBitmask()) !=
					 0) {

				Object[] args = new Object[] {jobModelImpl.getOriginalUserId()};

				finderCache.removeResult(_finderPathCountByUserId, args);
				finderCache.removeResult(
					_finderPathWithoutPaginationFindByUserId, args);

				args = new Object[] {jobModelImpl.getUserId()};

				finderCache.removeResult(_finderPathCountByUserId, args);
				finderCache.removeResult(
					_finderPathWithoutPaginationFindByUserId, args);
			}

			if ((jobModelImpl.getColumnBitmask() &
				 _finderPathWithoutPaginationFindByUserId_G.
					 getColumnBitmask()) != 0) {

				Object[] args = new Object[] {
					jobModelImpl.getOriginalGroupId(),
					jobModelImpl.getOriginalUserId()
				};

				finderCache.removeResult(_finderPathCountByUserId_G, args);
				finderCache.removeResult(
					_finderPathWithoutPaginationFindByUserId_G, args);

				args = new Object[] {
					jobModelImpl.getGroupId(), jobModelImpl.getUserId()
				};

				finderCache.removeResult(_finderPathCountByUserId_G, args);
				finderCache.removeResult(
					_finderPathWithoutPaginationFindByUserId_G, args);
			}

			if ((jobModelImpl.getColumnBitmask() &
				 _finderPathWithoutPaginationFindByStatus.getColumnBitmask()) !=
					 0) {

				Object[] args = new Object[] {jobModelImpl.getOriginalStatus()};

				finderCache.removeResult(_finderPathCountByStatus, args);
				finderCache.removeResult(
					_finderPathWithoutPaginationFindByStatus, args);

				args = new Object[] {jobModelImpl.getStatus()};

				finderCache.removeResult(_finderPathCountByStatus, args);
				finderCache.removeResult(
					_finderPathWithoutPaginationFindByStatus, args);
			}

			if ((jobModelImpl.getColumnBitmask() &
				 _finderPathWithoutPaginationFindByStatus_G.
					 getColumnBitmask()) != 0) {

				Object[] args = new Object[] {
					jobModelImpl.getOriginalGroupId(),
					jobModelImpl.getOriginalStatus()
				};

				finderCache.removeResult(_finderPathCountByStatus_G, args);
				finderCache.removeResult(
					_finderPathWithoutPaginationFindByStatus_G, args);

				args = new Object[] {
					jobModelImpl.getGroupId(), jobModelImpl.getStatus()
				};

				finderCache.removeResult(_finderPathCountByStatus_G, args);
				finderCache.removeResult(
					_finderPathWithoutPaginationFindByStatus_G, args);
			}

			if ((jobModelImpl.getColumnBitmask() &
				 _finderPathWithoutPaginationFindByStatus_U.
					 getColumnBitmask()) != 0) {

				Object[] args = new Object[] {
					jobModelImpl.getOriginalUserId(),
					jobModelImpl.getOriginalStatus()
				};

				finderCache.removeResult(_finderPathCountByStatus_U, args);
				finderCache.removeResult(
					_finderPathWithoutPaginationFindByStatus_U, args);

				args = new Object[] {
					jobModelImpl.getUserId(), jobModelImpl.getStatus()
				};

				finderCache.removeResult(_finderPathCountByStatus_U, args);
				finderCache.removeResult(
					_finderPathWithoutPaginationFindByStatus_U, args);
			}

			if ((jobModelImpl.getColumnBitmask() &
				 _finderPathWithoutPaginationFindByStatus_G_U.
					 getColumnBitmask()) != 0) {

				Object[] args = new Object[] {
					jobModelImpl.getOriginalGroupId(),
					jobModelImpl.getOriginalUserId(),
					jobModelImpl.getOriginalStatus()
				};

				finderCache.removeResult(_finderPathCountByStatus_G_U, args);
				finderCache.removeResult(
					_finderPathWithoutPaginationFindByStatus_G_U, args);

				args = new Object[] {
					jobModelImpl.getGroupId(), jobModelImpl.getUserId(),
					jobModelImpl.getStatus()
				};

				finderCache.removeResult(_finderPathCountByStatus_G_U, args);
				finderCache.removeResult(
					_finderPathWithoutPaginationFindByStatus_G_U, args);
			}

			if ((jobModelImpl.getColumnBitmask() &
				 _finderPathWithoutPaginationFindByQueueName.
					 getColumnBitmask()) != 0) {

				Object[] args = new Object[] {
					jobModelImpl.getOriginalQueueName()
				};

				finderCache.removeResult(_finderPathCountByQueueName, args);
				finderCache.removeResult(
					_finderPathWithoutPaginationFindByQueueName, args);

				args = new Object[] {jobModelImpl.getQueueName()};

				finderCache.removeResult(_finderPathCountByQueueName, args);
				finderCache.removeResult(
					_finderPathWithoutPaginationFindByQueueName, args);
			}

			if ((jobModelImpl.getColumnBitmask() &
				 _finderPathWithoutPaginationFindByJobStatus.
					 getColumnBitmask()) != 0) {

				Object[] args = new Object[] {
					jobModelImpl.getOriginalJobStatus()
				};

				finderCache.removeResult(_finderPathCountByJobStatus, args);
				finderCache.removeResult(
					_finderPathWithoutPaginationFindByJobStatus, args);

				args = new Object[] {jobModelImpl.getJobStatus()};

				finderCache.removeResult(_finderPathCountByJobStatus, args);
				finderCache.removeResult(
					_finderPathWithoutPaginationFindByJobStatus, args);
			}

			if ((jobModelImpl.getColumnBitmask() &
				 _finderPathWithoutPaginationFindByJobStatus_G.
					 getColumnBitmask()) != 0) {

				Object[] args = new Object[] {
					jobModelImpl.getOriginalGroupId(),
					jobModelImpl.getOriginalJobStatus()
				};

				finderCache.removeResult(_finderPathCountByJobStatus_G, args);
				finderCache.removeResult(
					_finderPathWithoutPaginationFindByJobStatus_G, args);

				args = new Object[] {
					jobModelImpl.getGroupId(), jobModelImpl.getJobStatus()
				};

				finderCache.removeResult(_finderPathCountByJobStatus_G, args);
				finderCache.removeResult(
					_finderPathWithoutPaginationFindByJobStatus_G, args);
			}

			if ((jobModelImpl.getColumnBitmask() &
				 _finderPathWithoutPaginationFindByJobStatus_U.
					 getColumnBitmask()) != 0) {

				Object[] args = new Object[] {
					jobModelImpl.getOriginalUserId(),
					jobModelImpl.getOriginalJobStatus()
				};

				finderCache.removeResult(_finderPathCountByJobStatus_U, args);
				finderCache.removeResult(
					_finderPathWithoutPaginationFindByJobStatus_U, args);

				args = new Object[] {
					jobModelImpl.getUserId(), jobModelImpl.getJobStatus()
				};

				finderCache.removeResult(_finderPathCountByJobStatus_U, args);
				finderCache.removeResult(
					_finderPathWithoutPaginationFindByJobStatus_U, args);
			}

			if ((jobModelImpl.getColumnBitmask() &
				 _finderPathWithoutPaginationFindByJobStatus_G_U.
					 getColumnBitmask()) != 0) {

				Object[] args = new Object[] {
					jobModelImpl.getOriginalGroupId(),
					jobModelImpl.getOriginalUserId(),
					jobModelImpl.getOriginalJobStatus()
				};

				finderCache.removeResult(_finderPathCountByJobStatus_G_U, args);
				finderCache.removeResult(
					_finderPathWithoutPaginationFindByJobStatus_G_U, args);

				args = new Object[] {
					jobModelImpl.getGroupId(), jobModelImpl.getUserId(),
					jobModelImpl.getJobStatus()
				};

				finderCache.removeResult(_finderPathCountByJobStatus_G_U, args);
				finderCache.removeResult(
					_finderPathWithoutPaginationFindByJobStatus_G_U, args);
			}

			if ((jobModelImpl.getColumnBitmask() &
				 _finderPathWithoutPaginationFindByClusterId.
					 getColumnBitmask()) != 0) {

				Object[] args = new Object[] {
					jobModelImpl.getOriginalClusterId()
				};

				finderCache.removeResult(_finderPathCountByClusterId, args);
				finderCache.removeResult(
					_finderPathWithoutPaginationFindByClusterId, args);

				args = new Object[] {jobModelImpl.getClusterId()};

				finderCache.removeResult(_finderPathCountByClusterId, args);
				finderCache.removeResult(
					_finderPathWithoutPaginationFindByClusterId, args);
			}

			if ((jobModelImpl.getColumnBitmask() &
				 _finderPathWithoutPaginationFindByClusterId_G.
					 getColumnBitmask()) != 0) {

				Object[] args = new Object[] {
					jobModelImpl.getOriginalGroupId(),
					jobModelImpl.getOriginalClusterId()
				};

				finderCache.removeResult(_finderPathCountByClusterId_G, args);
				finderCache.removeResult(
					_finderPathWithoutPaginationFindByClusterId_G, args);

				args = new Object[] {
					jobModelImpl.getGroupId(), jobModelImpl.getClusterId()
				};

				finderCache.removeResult(_finderPathCountByClusterId_G, args);
				finderCache.removeResult(
					_finderPathWithoutPaginationFindByClusterId_G, args);
			}

			if ((jobModelImpl.getColumnBitmask() &
				 _finderPathWithoutPaginationFindByClusterId_U.
					 getColumnBitmask()) != 0) {

				Object[] args = new Object[] {
					jobModelImpl.getOriginalUserId(),
					jobModelImpl.getOriginalClusterId()
				};

				finderCache.removeResult(_finderPathCountByClusterId_U, args);
				finderCache.removeResult(
					_finderPathWithoutPaginationFindByClusterId_U, args);

				args = new Object[] {
					jobModelImpl.getUserId(), jobModelImpl.getClusterId()
				};

				finderCache.removeResult(_finderPathCountByClusterId_U, args);
				finderCache.removeResult(
					_finderPathWithoutPaginationFindByClusterId_U, args);
			}

			if ((jobModelImpl.getColumnBitmask() &
				 _finderPathWithoutPaginationFindByClusterId_G_U.
					 getColumnBitmask()) != 0) {

				Object[] args = new Object[] {
					jobModelImpl.getOriginalGroupId(),
					jobModelImpl.getOriginalUserId(),
					jobModelImpl.getOriginalClusterId()
				};

				finderCache.removeResult(_finderPathCountByClusterId_G_U, args);
				finderCache.removeResult(
					_finderPathWithoutPaginationFindByClusterId_G_U, args);

				args = new Object[] {
					jobModelImpl.getGroupId(), jobModelImpl.getUserId(),
					jobModelImpl.getClusterId()
				};

				finderCache.removeResult(_finderPathCountByClusterId_G_U, args);
				finderCache.removeResult(
					_finderPathWithoutPaginationFindByClusterId_G_U, args);
			}

			if ((jobModelImpl.getColumnBitmask() &
				 _finderPathWithoutPaginationFindByRunType.
					 getColumnBitmask()) != 0) {

				Object[] args = new Object[] {
					jobModelImpl.getOriginalRunType()
				};

				finderCache.removeResult(_finderPathCountByRunType, args);
				finderCache.removeResult(
					_finderPathWithoutPaginationFindByRunType, args);

				args = new Object[] {jobModelImpl.getRunType()};

				finderCache.removeResult(_finderPathCountByRunType, args);
				finderCache.removeResult(
					_finderPathWithoutPaginationFindByRunType, args);
			}

			if ((jobModelImpl.getColumnBitmask() &
				 _finderPathWithoutPaginationFindByRunType_G.
					 getColumnBitmask()) != 0) {

				Object[] args = new Object[] {
					jobModelImpl.getOriginalGroupId(),
					jobModelImpl.getOriginalRunType()
				};

				finderCache.removeResult(_finderPathCountByRunType_G, args);
				finderCache.removeResult(
					_finderPathWithoutPaginationFindByRunType_G, args);

				args = new Object[] {
					jobModelImpl.getGroupId(), jobModelImpl.getRunType()
				};

				finderCache.removeResult(_finderPathCountByRunType_G, args);
				finderCache.removeResult(
					_finderPathWithoutPaginationFindByRunType_G, args);
			}

			if ((jobModelImpl.getColumnBitmask() &
				 _finderPathWithoutPaginationFindByRunType_U.
					 getColumnBitmask()) != 0) {

				Object[] args = new Object[] {
					jobModelImpl.getOriginalUserId(),
					jobModelImpl.getOriginalRunType()
				};

				finderCache.removeResult(_finderPathCountByRunType_U, args);
				finderCache.removeResult(
					_finderPathWithoutPaginationFindByRunType_U, args);

				args = new Object[] {
					jobModelImpl.getUserId(), jobModelImpl.getRunType()
				};

				finderCache.removeResult(_finderPathCountByRunType_U, args);
				finderCache.removeResult(
					_finderPathWithoutPaginationFindByRunType_U, args);
			}

			if ((jobModelImpl.getColumnBitmask() &
				 _finderPathWithoutPaginationFindByRunType_G_U.
					 getColumnBitmask()) != 0) {

				Object[] args = new Object[] {
					jobModelImpl.getOriginalGroupId(),
					jobModelImpl.getOriginalUserId(),
					jobModelImpl.getOriginalRunType()
				};

				finderCache.removeResult(_finderPathCountByRunType_G_U, args);
				finderCache.removeResult(
					_finderPathWithoutPaginationFindByRunType_G_U, args);

				args = new Object[] {
					jobModelImpl.getGroupId(), jobModelImpl.getUserId(),
					jobModelImpl.getRunType()
				};

				finderCache.removeResult(_finderPathCountByRunType_G_U, args);
				finderCache.removeResult(
					_finderPathWithoutPaginationFindByRunType_G_U, args);
			}
		}

		entityCache.putResult(
			entityCacheEnabled, JobImpl.class, job.getPrimaryKey(), job, false);

		clearUniqueFindersCache(jobModelImpl, false);
		cacheUniqueFindersCache(jobModelImpl);

		job.resetOriginalValues();

		return job;
	}

	/**
	 * Returns the job with the primary key or throws a <code>com.liferay.portal.kernel.exception.NoSuchModelException</code> if it could not be found.
	 *
	 * @param primaryKey the primary key of the job
	 * @return the job
	 * @throws NoSuchJobException if a job with the primary key could not be found
	 */
	@Override
	public Job findByPrimaryKey(Serializable primaryKey)
		throws NoSuchJobException {

		Job job = fetchByPrimaryKey(primaryKey);

		if (job == null) {
			if (_log.isDebugEnabled()) {
				_log.debug(_NO_SUCH_ENTITY_WITH_PRIMARY_KEY + primaryKey);
			}

			throw new NoSuchJobException(
				_NO_SUCH_ENTITY_WITH_PRIMARY_KEY + primaryKey);
		}

		return job;
	}

	/**
	 * Returns the job with the primary key or throws a <code>NoSuchJobException</code> if it could not be found.
	 *
	 * @param jobId the primary key of the job
	 * @return the job
	 * @throws NoSuchJobException if a job with the primary key could not be found
	 */
	@Override
	public Job findByPrimaryKey(long jobId) throws NoSuchJobException {
		return findByPrimaryKey((Serializable)jobId);
	}

	/**
	 * Returns the job with the primary key or returns <code>null</code> if it could not be found.
	 *
	 * @param jobId the primary key of the job
	 * @return the job, or <code>null</code> if a job with the primary key could not be found
	 */
	@Override
	public Job fetchByPrimaryKey(long jobId) {
		return fetchByPrimaryKey((Serializable)jobId);
	}

	/**
	 * Returns all the jobs.
	 *
	 * @return the jobs
	 */
	@Override
	public List<Job> findAll() {
		return findAll(QueryUtil.ALL_POS, QueryUtil.ALL_POS, null);
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
	@Override
	public List<Job> findAll(int start, int end) {
		return findAll(start, end, null);
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
	@Override
	public List<Job> findAll(
		int start, int end, OrderByComparator<Job> orderByComparator) {

		return findAll(start, end, orderByComparator, true);
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
	@Override
	public List<Job> findAll(
		int start, int end, OrderByComparator<Job> orderByComparator,
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

		List<Job> list = null;

		if (retrieveFromCache) {
			list = (List<Job>)finderCache.getResult(
				finderPath, finderArgs, this);
		}

		if (list == null) {
			StringBundler query = null;
			String sql = null;

			if (orderByComparator != null) {
				query = new StringBundler(
					2 + (orderByComparator.getOrderByFields().length * 2));

				query.append(_SQL_SELECT_JOB);

				appendOrderByComparator(
					query, _ORDER_BY_ENTITY_ALIAS, orderByComparator);

				sql = query.toString();
			}
			else {
				sql = _SQL_SELECT_JOB;

				if (pagination) {
					sql = sql.concat(JobModelImpl.ORDER_BY_JPQL);
				}
			}

			Session session = null;

			try {
				session = openSession();

				Query q = session.createQuery(sql);

				if (!pagination) {
					list = (List<Job>)QueryUtil.list(
						q, getDialect(), start, end, false);

					Collections.sort(list);

					list = Collections.unmodifiableList(list);
				}
				else {
					list = (List<Job>)QueryUtil.list(
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
	 * Removes all the jobs from the database.
	 *
	 */
	@Override
	public void removeAll() {
		for (Job job : findAll()) {
			remove(job);
		}
	}

	/**
	 * Returns the number of jobs.
	 *
	 * @return the number of jobs
	 */
	@Override
	public int countAll() {
		Long count = (Long)finderCache.getResult(
			_finderPathCountAll, FINDER_ARGS_EMPTY, this);

		if (count == null) {
			Session session = null;

			try {
				session = openSession();

				Query q = session.createQuery(_SQL_COUNT_JOB);

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
		return "jobId";
	}

	@Override
	protected String getSelectSQL() {
		return _SQL_SELECT_JOB;
	}

	@Override
	protected Map<String, Integer> getTableColumnsMap() {
		return JobModelImpl.TABLE_COLUMNS_MAP;
	}

	/**
	 * Initializes the job persistence.
	 */
	@Activate
	public void activate() {
		JobModelImpl.setEntityCacheEnabled(entityCacheEnabled);
		JobModelImpl.setFinderCacheEnabled(finderCacheEnabled);

		_finderPathWithPaginationFindAll = new FinderPath(
			entityCacheEnabled, finderCacheEnabled, JobImpl.class,
			FINDER_CLASS_NAME_LIST_WITH_PAGINATION, "findAll", new String[0]);

		_finderPathWithoutPaginationFindAll = new FinderPath(
			entityCacheEnabled, finderCacheEnabled, JobImpl.class,
			FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION, "findAll",
			new String[0]);

		_finderPathCountAll = new FinderPath(
			entityCacheEnabled, finderCacheEnabled, Long.class,
			FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION, "countAll",
			new String[0]);

		_finderPathWithPaginationFindByUuid = new FinderPath(
			entityCacheEnabled, finderCacheEnabled, JobImpl.class,
			FINDER_CLASS_NAME_LIST_WITH_PAGINATION, "findByUuid",
			new String[] {
				String.class.getName(), Integer.class.getName(),
				Integer.class.getName(), OrderByComparator.class.getName()
			});

		_finderPathWithoutPaginationFindByUuid = new FinderPath(
			entityCacheEnabled, finderCacheEnabled, JobImpl.class,
			FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION, "findByUuid",
			new String[] {String.class.getName()},
			JobModelImpl.UUID_COLUMN_BITMASK |
			JobModelImpl.CREATEDATE_COLUMN_BITMASK);

		_finderPathCountByUuid = new FinderPath(
			entityCacheEnabled, finderCacheEnabled, Long.class,
			FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION, "countByUuid",
			new String[] {String.class.getName()});

		_finderPathFetchByUUID_G = new FinderPath(
			entityCacheEnabled, finderCacheEnabled, JobImpl.class,
			FINDER_CLASS_NAME_ENTITY, "fetchByUUID_G",
			new String[] {String.class.getName(), Long.class.getName()},
			JobModelImpl.UUID_COLUMN_BITMASK |
			JobModelImpl.GROUPID_COLUMN_BITMASK);

		_finderPathCountByUUID_G = new FinderPath(
			entityCacheEnabled, finderCacheEnabled, Long.class,
			FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION, "countByUUID_G",
			new String[] {String.class.getName(), Long.class.getName()});

		_finderPathWithPaginationFindByUuid_C = new FinderPath(
			entityCacheEnabled, finderCacheEnabled, JobImpl.class,
			FINDER_CLASS_NAME_LIST_WITH_PAGINATION, "findByUuid_C",
			new String[] {
				String.class.getName(), Long.class.getName(),
				Integer.class.getName(), Integer.class.getName(),
				OrderByComparator.class.getName()
			});

		_finderPathWithoutPaginationFindByUuid_C = new FinderPath(
			entityCacheEnabled, finderCacheEnabled, JobImpl.class,
			FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION, "findByUuid_C",
			new String[] {String.class.getName(), Long.class.getName()},
			JobModelImpl.UUID_COLUMN_BITMASK |
			JobModelImpl.COMPANYID_COLUMN_BITMASK |
			JobModelImpl.CREATEDATE_COLUMN_BITMASK);

		_finderPathCountByUuid_C = new FinderPath(
			entityCacheEnabled, finderCacheEnabled, Long.class,
			FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION, "countByUuid_C",
			new String[] {String.class.getName(), Long.class.getName()});

		_finderPathWithPaginationFindByGroupId = new FinderPath(
			entityCacheEnabled, finderCacheEnabled, JobImpl.class,
			FINDER_CLASS_NAME_LIST_WITH_PAGINATION, "findByGroupId",
			new String[] {
				Long.class.getName(), Integer.class.getName(),
				Integer.class.getName(), OrderByComparator.class.getName()
			});

		_finderPathWithoutPaginationFindByGroupId = new FinderPath(
			entityCacheEnabled, finderCacheEnabled, JobImpl.class,
			FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION, "findByGroupId",
			new String[] {Long.class.getName()},
			JobModelImpl.GROUPID_COLUMN_BITMASK |
			JobModelImpl.CREATEDATE_COLUMN_BITMASK);

		_finderPathCountByGroupId = new FinderPath(
			entityCacheEnabled, finderCacheEnabled, Long.class,
			FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION, "countByGroupId",
			new String[] {Long.class.getName()});

		_finderPathWithPaginationFindByUserId = new FinderPath(
			entityCacheEnabled, finderCacheEnabled, JobImpl.class,
			FINDER_CLASS_NAME_LIST_WITH_PAGINATION, "findByUserId",
			new String[] {
				Long.class.getName(), Integer.class.getName(),
				Integer.class.getName(), OrderByComparator.class.getName()
			});

		_finderPathWithoutPaginationFindByUserId = new FinderPath(
			entityCacheEnabled, finderCacheEnabled, JobImpl.class,
			FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION, "findByUserId",
			new String[] {Long.class.getName()},
			JobModelImpl.USERID_COLUMN_BITMASK |
			JobModelImpl.CREATEDATE_COLUMN_BITMASK);

		_finderPathCountByUserId = new FinderPath(
			entityCacheEnabled, finderCacheEnabled, Long.class,
			FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION, "countByUserId",
			new String[] {Long.class.getName()});

		_finderPathWithPaginationFindByUserId_G = new FinderPath(
			entityCacheEnabled, finderCacheEnabled, JobImpl.class,
			FINDER_CLASS_NAME_LIST_WITH_PAGINATION, "findByUserId_G",
			new String[] {
				Long.class.getName(), Long.class.getName(),
				Integer.class.getName(), Integer.class.getName(),
				OrderByComparator.class.getName()
			});

		_finderPathWithoutPaginationFindByUserId_G = new FinderPath(
			entityCacheEnabled, finderCacheEnabled, JobImpl.class,
			FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION, "findByUserId_G",
			new String[] {Long.class.getName(), Long.class.getName()},
			JobModelImpl.GROUPID_COLUMN_BITMASK |
			JobModelImpl.USERID_COLUMN_BITMASK |
			JobModelImpl.CREATEDATE_COLUMN_BITMASK);

		_finderPathCountByUserId_G = new FinderPath(
			entityCacheEnabled, finderCacheEnabled, Long.class,
			FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION, "countByUserId_G",
			new String[] {Long.class.getName(), Long.class.getName()});

		_finderPathWithPaginationFindByStatus = new FinderPath(
			entityCacheEnabled, finderCacheEnabled, JobImpl.class,
			FINDER_CLASS_NAME_LIST_WITH_PAGINATION, "findByStatus",
			new String[] {
				Integer.class.getName(), Integer.class.getName(),
				Integer.class.getName(), OrderByComparator.class.getName()
			});

		_finderPathWithoutPaginationFindByStatus = new FinderPath(
			entityCacheEnabled, finderCacheEnabled, JobImpl.class,
			FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION, "findByStatus",
			new String[] {Integer.class.getName()},
			JobModelImpl.STATUS_COLUMN_BITMASK |
			JobModelImpl.CREATEDATE_COLUMN_BITMASK);

		_finderPathCountByStatus = new FinderPath(
			entityCacheEnabled, finderCacheEnabled, Long.class,
			FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION, "countByStatus",
			new String[] {Integer.class.getName()});

		_finderPathWithPaginationFindByStatus_G = new FinderPath(
			entityCacheEnabled, finderCacheEnabled, JobImpl.class,
			FINDER_CLASS_NAME_LIST_WITH_PAGINATION, "findByStatus_G",
			new String[] {
				Long.class.getName(), Integer.class.getName(),
				Integer.class.getName(), Integer.class.getName(),
				OrderByComparator.class.getName()
			});

		_finderPathWithoutPaginationFindByStatus_G = new FinderPath(
			entityCacheEnabled, finderCacheEnabled, JobImpl.class,
			FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION, "findByStatus_G",
			new String[] {Long.class.getName(), Integer.class.getName()},
			JobModelImpl.GROUPID_COLUMN_BITMASK |
			JobModelImpl.STATUS_COLUMN_BITMASK |
			JobModelImpl.CREATEDATE_COLUMN_BITMASK);

		_finderPathCountByStatus_G = new FinderPath(
			entityCacheEnabled, finderCacheEnabled, Long.class,
			FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION, "countByStatus_G",
			new String[] {Long.class.getName(), Integer.class.getName()});

		_finderPathWithPaginationFindByStatus_U = new FinderPath(
			entityCacheEnabled, finderCacheEnabled, JobImpl.class,
			FINDER_CLASS_NAME_LIST_WITH_PAGINATION, "findByStatus_U",
			new String[] {
				Long.class.getName(), Integer.class.getName(),
				Integer.class.getName(), Integer.class.getName(),
				OrderByComparator.class.getName()
			});

		_finderPathWithoutPaginationFindByStatus_U = new FinderPath(
			entityCacheEnabled, finderCacheEnabled, JobImpl.class,
			FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION, "findByStatus_U",
			new String[] {Long.class.getName(), Integer.class.getName()},
			JobModelImpl.USERID_COLUMN_BITMASK |
			JobModelImpl.STATUS_COLUMN_BITMASK |
			JobModelImpl.CREATEDATE_COLUMN_BITMASK);

		_finderPathCountByStatus_U = new FinderPath(
			entityCacheEnabled, finderCacheEnabled, Long.class,
			FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION, "countByStatus_U",
			new String[] {Long.class.getName(), Integer.class.getName()});

		_finderPathWithPaginationFindByStatus_G_U = new FinderPath(
			entityCacheEnabled, finderCacheEnabled, JobImpl.class,
			FINDER_CLASS_NAME_LIST_WITH_PAGINATION, "findByStatus_G_U",
			new String[] {
				Long.class.getName(), Long.class.getName(),
				Integer.class.getName(), Integer.class.getName(),
				Integer.class.getName(), OrderByComparator.class.getName()
			});

		_finderPathWithoutPaginationFindByStatus_G_U = new FinderPath(
			entityCacheEnabled, finderCacheEnabled, JobImpl.class,
			FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION, "findByStatus_G_U",
			new String[] {
				Long.class.getName(), Long.class.getName(),
				Integer.class.getName()
			},
			JobModelImpl.GROUPID_COLUMN_BITMASK |
			JobModelImpl.USERID_COLUMN_BITMASK |
			JobModelImpl.STATUS_COLUMN_BITMASK |
			JobModelImpl.CREATEDATE_COLUMN_BITMASK);

		_finderPathCountByStatus_G_U = new FinderPath(
			entityCacheEnabled, finderCacheEnabled, Long.class,
			FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION, "countByStatus_G_U",
			new String[] {
				Long.class.getName(), Long.class.getName(),
				Integer.class.getName()
			});

		_finderPathWithPaginationFindByQueueName = new FinderPath(
			entityCacheEnabled, finderCacheEnabled, JobImpl.class,
			FINDER_CLASS_NAME_LIST_WITH_PAGINATION, "findByQueueName",
			new String[] {
				String.class.getName(), Integer.class.getName(),
				Integer.class.getName(), OrderByComparator.class.getName()
			});

		_finderPathWithoutPaginationFindByQueueName = new FinderPath(
			entityCacheEnabled, finderCacheEnabled, JobImpl.class,
			FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION, "findByQueueName",
			new String[] {String.class.getName()},
			JobModelImpl.QUEUENAME_COLUMN_BITMASK |
			JobModelImpl.CREATEDATE_COLUMN_BITMASK);

		_finderPathCountByQueueName = new FinderPath(
			entityCacheEnabled, finderCacheEnabled, Long.class,
			FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION, "countByQueueName",
			new String[] {String.class.getName()});

		_finderPathWithPaginationFindByJobStatus = new FinderPath(
			entityCacheEnabled, finderCacheEnabled, JobImpl.class,
			FINDER_CLASS_NAME_LIST_WITH_PAGINATION, "findByJobStatus",
			new String[] {
				Integer.class.getName(), Integer.class.getName(),
				Integer.class.getName(), OrderByComparator.class.getName()
			});

		_finderPathWithoutPaginationFindByJobStatus = new FinderPath(
			entityCacheEnabled, finderCacheEnabled, JobImpl.class,
			FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION, "findByJobStatus",
			new String[] {Integer.class.getName()},
			JobModelImpl.JOBSTATUS_COLUMN_BITMASK |
			JobModelImpl.CREATEDATE_COLUMN_BITMASK);

		_finderPathCountByJobStatus = new FinderPath(
			entityCacheEnabled, finderCacheEnabled, Long.class,
			FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION, "countByJobStatus",
			new String[] {Integer.class.getName()});

		_finderPathWithPaginationFindByJobStatus_G = new FinderPath(
			entityCacheEnabled, finderCacheEnabled, JobImpl.class,
			FINDER_CLASS_NAME_LIST_WITH_PAGINATION, "findByJobStatus_G",
			new String[] {
				Long.class.getName(), Integer.class.getName(),
				Integer.class.getName(), Integer.class.getName(),
				OrderByComparator.class.getName()
			});

		_finderPathWithoutPaginationFindByJobStatus_G = new FinderPath(
			entityCacheEnabled, finderCacheEnabled, JobImpl.class,
			FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION, "findByJobStatus_G",
			new String[] {Long.class.getName(), Integer.class.getName()},
			JobModelImpl.GROUPID_COLUMN_BITMASK |
			JobModelImpl.JOBSTATUS_COLUMN_BITMASK |
			JobModelImpl.CREATEDATE_COLUMN_BITMASK);

		_finderPathCountByJobStatus_G = new FinderPath(
			entityCacheEnabled, finderCacheEnabled, Long.class,
			FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION, "countByJobStatus_G",
			new String[] {Long.class.getName(), Integer.class.getName()});

		_finderPathWithPaginationFindByJobStatus_U = new FinderPath(
			entityCacheEnabled, finderCacheEnabled, JobImpl.class,
			FINDER_CLASS_NAME_LIST_WITH_PAGINATION, "findByJobStatus_U",
			new String[] {
				Long.class.getName(), Integer.class.getName(),
				Integer.class.getName(), Integer.class.getName(),
				OrderByComparator.class.getName()
			});

		_finderPathWithoutPaginationFindByJobStatus_U = new FinderPath(
			entityCacheEnabled, finderCacheEnabled, JobImpl.class,
			FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION, "findByJobStatus_U",
			new String[] {Long.class.getName(), Integer.class.getName()},
			JobModelImpl.USERID_COLUMN_BITMASK |
			JobModelImpl.JOBSTATUS_COLUMN_BITMASK |
			JobModelImpl.CREATEDATE_COLUMN_BITMASK);

		_finderPathCountByJobStatus_U = new FinderPath(
			entityCacheEnabled, finderCacheEnabled, Long.class,
			FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION, "countByJobStatus_U",
			new String[] {Long.class.getName(), Integer.class.getName()});

		_finderPathWithPaginationFindByJobStatus_G_U = new FinderPath(
			entityCacheEnabled, finderCacheEnabled, JobImpl.class,
			FINDER_CLASS_NAME_LIST_WITH_PAGINATION, "findByJobStatus_G_U",
			new String[] {
				Long.class.getName(), Long.class.getName(),
				Integer.class.getName(), Integer.class.getName(),
				Integer.class.getName(), OrderByComparator.class.getName()
			});

		_finderPathWithoutPaginationFindByJobStatus_G_U = new FinderPath(
			entityCacheEnabled, finderCacheEnabled, JobImpl.class,
			FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION, "findByJobStatus_G_U",
			new String[] {
				Long.class.getName(), Long.class.getName(),
				Integer.class.getName()
			},
			JobModelImpl.GROUPID_COLUMN_BITMASK |
			JobModelImpl.USERID_COLUMN_BITMASK |
			JobModelImpl.JOBSTATUS_COLUMN_BITMASK |
			JobModelImpl.CREATEDATE_COLUMN_BITMASK);

		_finderPathCountByJobStatus_G_U = new FinderPath(
			entityCacheEnabled, finderCacheEnabled, Long.class,
			FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION, "countByJobStatus_G_U",
			new String[] {
				Long.class.getName(), Long.class.getName(),
				Integer.class.getName()
			});

		_finderPathWithPaginationFindByTitle = new FinderPath(
			entityCacheEnabled, finderCacheEnabled, JobImpl.class,
			FINDER_CLASS_NAME_LIST_WITH_PAGINATION, "findByTitle",
			new String[] {
				String.class.getName(), Integer.class.getName(),
				Integer.class.getName(), OrderByComparator.class.getName()
			});

		_finderPathWithPaginationCountByTitle = new FinderPath(
			entityCacheEnabled, finderCacheEnabled, Long.class,
			FINDER_CLASS_NAME_LIST_WITH_PAGINATION, "countByTitle",
			new String[] {String.class.getName()});

		_finderPathWithPaginationFindByTitle_G = new FinderPath(
			entityCacheEnabled, finderCacheEnabled, JobImpl.class,
			FINDER_CLASS_NAME_LIST_WITH_PAGINATION, "findByTitle_G",
			new String[] {
				Long.class.getName(), String.class.getName(),
				Integer.class.getName(), Integer.class.getName(),
				OrderByComparator.class.getName()
			});

		_finderPathWithPaginationCountByTitle_G = new FinderPath(
			entityCacheEnabled, finderCacheEnabled, Long.class,
			FINDER_CLASS_NAME_LIST_WITH_PAGINATION, "countByTitle_G",
			new String[] {Long.class.getName(), String.class.getName()});

		_finderPathWithPaginationFindByTitle_U = new FinderPath(
			entityCacheEnabled, finderCacheEnabled, JobImpl.class,
			FINDER_CLASS_NAME_LIST_WITH_PAGINATION, "findByTitle_U",
			new String[] {
				Long.class.getName(), String.class.getName(),
				Integer.class.getName(), Integer.class.getName(),
				OrderByComparator.class.getName()
			});

		_finderPathWithPaginationCountByTitle_U = new FinderPath(
			entityCacheEnabled, finderCacheEnabled, Long.class,
			FINDER_CLASS_NAME_LIST_WITH_PAGINATION, "countByTitle_U",
			new String[] {Long.class.getName(), String.class.getName()});

		_finderPathWithPaginationFindByTitle_G_U = new FinderPath(
			entityCacheEnabled, finderCacheEnabled, JobImpl.class,
			FINDER_CLASS_NAME_LIST_WITH_PAGINATION, "findByTitle_G_U",
			new String[] {
				Long.class.getName(), Long.class.getName(),
				String.class.getName(), Integer.class.getName(),
				Integer.class.getName(), OrderByComparator.class.getName()
			});

		_finderPathWithPaginationCountByTitle_G_U = new FinderPath(
			entityCacheEnabled, finderCacheEnabled, Long.class,
			FINDER_CLASS_NAME_LIST_WITH_PAGINATION, "countByTitle_G_U",
			new String[] {
				Long.class.getName(), Long.class.getName(),
				String.class.getName()
			});

		_finderPathWithPaginationFindByClusterId = new FinderPath(
			entityCacheEnabled, finderCacheEnabled, JobImpl.class,
			FINDER_CLASS_NAME_LIST_WITH_PAGINATION, "findByClusterId",
			new String[] {
				Long.class.getName(), Integer.class.getName(),
				Integer.class.getName(), OrderByComparator.class.getName()
			});

		_finderPathWithoutPaginationFindByClusterId = new FinderPath(
			entityCacheEnabled, finderCacheEnabled, JobImpl.class,
			FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION, "findByClusterId",
			new String[] {Long.class.getName()},
			JobModelImpl.CLUSTERID_COLUMN_BITMASK |
			JobModelImpl.CREATEDATE_COLUMN_BITMASK);

		_finderPathCountByClusterId = new FinderPath(
			entityCacheEnabled, finderCacheEnabled, Long.class,
			FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION, "countByClusterId",
			new String[] {Long.class.getName()});

		_finderPathWithPaginationFindByClusterId_G = new FinderPath(
			entityCacheEnabled, finderCacheEnabled, JobImpl.class,
			FINDER_CLASS_NAME_LIST_WITH_PAGINATION, "findByClusterId_G",
			new String[] {
				Long.class.getName(), Long.class.getName(),
				Integer.class.getName(), Integer.class.getName(),
				OrderByComparator.class.getName()
			});

		_finderPathWithoutPaginationFindByClusterId_G = new FinderPath(
			entityCacheEnabled, finderCacheEnabled, JobImpl.class,
			FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION, "findByClusterId_G",
			new String[] {Long.class.getName(), Long.class.getName()},
			JobModelImpl.GROUPID_COLUMN_BITMASK |
			JobModelImpl.CLUSTERID_COLUMN_BITMASK |
			JobModelImpl.CREATEDATE_COLUMN_BITMASK);

		_finderPathCountByClusterId_G = new FinderPath(
			entityCacheEnabled, finderCacheEnabled, Long.class,
			FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION, "countByClusterId_G",
			new String[] {Long.class.getName(), Long.class.getName()});

		_finderPathWithPaginationFindByClusterId_U = new FinderPath(
			entityCacheEnabled, finderCacheEnabled, JobImpl.class,
			FINDER_CLASS_NAME_LIST_WITH_PAGINATION, "findByClusterId_U",
			new String[] {
				Long.class.getName(), Long.class.getName(),
				Integer.class.getName(), Integer.class.getName(),
				OrderByComparator.class.getName()
			});

		_finderPathWithoutPaginationFindByClusterId_U = new FinderPath(
			entityCacheEnabled, finderCacheEnabled, JobImpl.class,
			FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION, "findByClusterId_U",
			new String[] {Long.class.getName(), Long.class.getName()},
			JobModelImpl.USERID_COLUMN_BITMASK |
			JobModelImpl.CLUSTERID_COLUMN_BITMASK |
			JobModelImpl.CREATEDATE_COLUMN_BITMASK);

		_finderPathCountByClusterId_U = new FinderPath(
			entityCacheEnabled, finderCacheEnabled, Long.class,
			FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION, "countByClusterId_U",
			new String[] {Long.class.getName(), Long.class.getName()});

		_finderPathWithPaginationFindByClusterId_G_U = new FinderPath(
			entityCacheEnabled, finderCacheEnabled, JobImpl.class,
			FINDER_CLASS_NAME_LIST_WITH_PAGINATION, "findByClusterId_G_U",
			new String[] {
				Long.class.getName(), Long.class.getName(),
				Long.class.getName(), Integer.class.getName(),
				Integer.class.getName(), OrderByComparator.class.getName()
			});

		_finderPathWithoutPaginationFindByClusterId_G_U = new FinderPath(
			entityCacheEnabled, finderCacheEnabled, JobImpl.class,
			FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION, "findByClusterId_G_U",
			new String[] {
				Long.class.getName(), Long.class.getName(), Long.class.getName()
			},
			JobModelImpl.GROUPID_COLUMN_BITMASK |
			JobModelImpl.USERID_COLUMN_BITMASK |
			JobModelImpl.CLUSTERID_COLUMN_BITMASK |
			JobModelImpl.CREATEDATE_COLUMN_BITMASK);

		_finderPathCountByClusterId_G_U = new FinderPath(
			entityCacheEnabled, finderCacheEnabled, Long.class,
			FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION, "countByClusterId_G_U",
			new String[] {
				Long.class.getName(), Long.class.getName(), Long.class.getName()
			});

		_finderPathWithPaginationFindByRunType = new FinderPath(
			entityCacheEnabled, finderCacheEnabled, JobImpl.class,
			FINDER_CLASS_NAME_LIST_WITH_PAGINATION, "findByRunType",
			new String[] {
				String.class.getName(), Integer.class.getName(),
				Integer.class.getName(), OrderByComparator.class.getName()
			});

		_finderPathWithoutPaginationFindByRunType = new FinderPath(
			entityCacheEnabled, finderCacheEnabled, JobImpl.class,
			FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION, "findByRunType",
			new String[] {String.class.getName()},
			JobModelImpl.RUNTYPE_COLUMN_BITMASK |
			JobModelImpl.CREATEDATE_COLUMN_BITMASK);

		_finderPathCountByRunType = new FinderPath(
			entityCacheEnabled, finderCacheEnabled, Long.class,
			FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION, "countByRunType",
			new String[] {String.class.getName()});

		_finderPathWithPaginationFindByRunType_G = new FinderPath(
			entityCacheEnabled, finderCacheEnabled, JobImpl.class,
			FINDER_CLASS_NAME_LIST_WITH_PAGINATION, "findByRunType_G",
			new String[] {
				Long.class.getName(), String.class.getName(),
				Integer.class.getName(), Integer.class.getName(),
				OrderByComparator.class.getName()
			});

		_finderPathWithoutPaginationFindByRunType_G = new FinderPath(
			entityCacheEnabled, finderCacheEnabled, JobImpl.class,
			FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION, "findByRunType_G",
			new String[] {Long.class.getName(), String.class.getName()},
			JobModelImpl.GROUPID_COLUMN_BITMASK |
			JobModelImpl.RUNTYPE_COLUMN_BITMASK |
			JobModelImpl.CREATEDATE_COLUMN_BITMASK);

		_finderPathCountByRunType_G = new FinderPath(
			entityCacheEnabled, finderCacheEnabled, Long.class,
			FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION, "countByRunType_G",
			new String[] {Long.class.getName(), String.class.getName()});

		_finderPathWithPaginationFindByRunType_U = new FinderPath(
			entityCacheEnabled, finderCacheEnabled, JobImpl.class,
			FINDER_CLASS_NAME_LIST_WITH_PAGINATION, "findByRunType_U",
			new String[] {
				Long.class.getName(), String.class.getName(),
				Integer.class.getName(), Integer.class.getName(),
				OrderByComparator.class.getName()
			});

		_finderPathWithoutPaginationFindByRunType_U = new FinderPath(
			entityCacheEnabled, finderCacheEnabled, JobImpl.class,
			FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION, "findByRunType_U",
			new String[] {Long.class.getName(), String.class.getName()},
			JobModelImpl.USERID_COLUMN_BITMASK |
			JobModelImpl.RUNTYPE_COLUMN_BITMASK |
			JobModelImpl.CREATEDATE_COLUMN_BITMASK);

		_finderPathCountByRunType_U = new FinderPath(
			entityCacheEnabled, finderCacheEnabled, Long.class,
			FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION, "countByRunType_U",
			new String[] {Long.class.getName(), String.class.getName()});

		_finderPathWithPaginationFindByRunType_G_U = new FinderPath(
			entityCacheEnabled, finderCacheEnabled, JobImpl.class,
			FINDER_CLASS_NAME_LIST_WITH_PAGINATION, "findByRunType_G_U",
			new String[] {
				Long.class.getName(), Long.class.getName(),
				String.class.getName(), Integer.class.getName(),
				Integer.class.getName(), OrderByComparator.class.getName()
			});

		_finderPathWithoutPaginationFindByRunType_G_U = new FinderPath(
			entityCacheEnabled, finderCacheEnabled, JobImpl.class,
			FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION, "findByRunType_G_U",
			new String[] {
				Long.class.getName(), Long.class.getName(),
				String.class.getName()
			},
			JobModelImpl.GROUPID_COLUMN_BITMASK |
			JobModelImpl.USERID_COLUMN_BITMASK |
			JobModelImpl.RUNTYPE_COLUMN_BITMASK |
			JobModelImpl.CREATEDATE_COLUMN_BITMASK);

		_finderPathCountByRunType_G_U = new FinderPath(
			entityCacheEnabled, finderCacheEnabled, Long.class,
			FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION, "countByRunType_G_U",
			new String[] {
				Long.class.getName(), Long.class.getName(),
				String.class.getName()
			});
	}

	@Deactivate
	public void deactivate() {
		entityCache.removeCache(JobImpl.class.getName());
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
				"value.object.column.bitmask.enabled.com.osp.icebreaker.model.Job"),
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

	private static final String _SQL_SELECT_JOB = "SELECT job FROM Job job";

	private static final String _SQL_SELECT_JOB_WHERE =
		"SELECT job FROM Job job WHERE ";

	private static final String _SQL_COUNT_JOB =
		"SELECT COUNT(job) FROM Job job";

	private static final String _SQL_COUNT_JOB_WHERE =
		"SELECT COUNT(job) FROM Job job WHERE ";

	private static final String _ORDER_BY_ENTITY_ALIAS = "job.";

	private static final String _NO_SUCH_ENTITY_WITH_PRIMARY_KEY =
		"No Job exists with the primary key ";

	private static final String _NO_SUCH_ENTITY_WITH_KEY =
		"No Job exists with the key {";

	private static final Log _log = LogFactoryUtil.getLog(
		JobPersistenceImpl.class);

	private static final Set<String> _badColumnNames = SetUtil.fromArray(
		new String[] {"uuid"});

}