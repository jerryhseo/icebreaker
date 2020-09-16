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
import com.liferay.portal.kernel.dao.orm.QueryUtil;
import com.liferay.portal.kernel.dao.orm.Session;
import com.liferay.portal.kernel.dao.orm.SessionFactory;
import com.liferay.portal.kernel.log.Log;
import com.liferay.portal.kernel.log.LogFactoryUtil;
import com.liferay.portal.kernel.service.persistence.impl.BasePersistenceImpl;
import com.liferay.portal.kernel.util.GetterUtil;
import com.liferay.portal.kernel.util.OrderByComparator;

import com.osp.icebreaker.exception.NoSuchJobDataException;
import com.osp.icebreaker.model.JobData;
import com.osp.icebreaker.model.impl.JobDataImpl;
import com.osp.icebreaker.model.impl.JobDataModelImpl;
import com.osp.icebreaker.service.persistence.JobDataPersistence;
import com.osp.icebreaker.service.persistence.impl.constants.ICEBREAKERPersistenceConstants;

import java.io.Serializable;

import java.util.Collections;
import java.util.List;
import java.util.Map;

import javax.sql.DataSource;

import org.osgi.annotation.versioning.ProviderType;
import org.osgi.service.component.annotations.Activate;
import org.osgi.service.component.annotations.Component;
import org.osgi.service.component.annotations.Deactivate;
import org.osgi.service.component.annotations.Reference;

/**
 * The persistence implementation for the job data service.
 *
 * <p>
 * Caching information and settings can be found in <code>portal.properties</code>
 * </p>
 *
 * @author Jerry H. Seo
 * @generated
 */
@Component(service = JobDataPersistence.class)
@ProviderType
public class JobDataPersistenceImpl
	extends BasePersistenceImpl<JobData> implements JobDataPersistence {

	/*
	 * NOTE FOR DEVELOPERS:
	 *
	 * Never modify or reference this class directly. Always use <code>JobDataUtil</code> to access the job data persistence. Modify <code>service.xml</code> and rerun ServiceBuilder to regenerate this class.
	 */
	public static final String FINDER_CLASS_NAME_ENTITY =
		JobDataImpl.class.getName();

	public static final String FINDER_CLASS_NAME_LIST_WITH_PAGINATION =
		FINDER_CLASS_NAME_ENTITY + ".List1";

	public static final String FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION =
		FINDER_CLASS_NAME_ENTITY + ".List2";

	private FinderPath _finderPathWithPaginationFindAll;
	private FinderPath _finderPathWithoutPaginationFindAll;
	private FinderPath _finderPathCountAll;

	public JobDataPersistenceImpl() {
		setModelClass(JobData.class);

		setModelImplClass(JobDataImpl.class);
		setModelPKClass(long.class);
	}

	/**
	 * Caches the job data in the entity cache if it is enabled.
	 *
	 * @param jobData the job data
	 */
	@Override
	public void cacheResult(JobData jobData) {
		entityCache.putResult(
			entityCacheEnabled, JobDataImpl.class, jobData.getPrimaryKey(),
			jobData);

		jobData.resetOriginalValues();
	}

	/**
	 * Caches the job datas in the entity cache if it is enabled.
	 *
	 * @param jobDatas the job datas
	 */
	@Override
	public void cacheResult(List<JobData> jobDatas) {
		for (JobData jobData : jobDatas) {
			if (entityCache.getResult(
					entityCacheEnabled, JobDataImpl.class,
					jobData.getPrimaryKey()) == null) {

				cacheResult(jobData);
			}
			else {
				jobData.resetOriginalValues();
			}
		}
	}

	/**
	 * Clears the cache for all job datas.
	 *
	 * <p>
	 * The <code>EntityCache</code> and <code>FinderCache</code> are both cleared by this method.
	 * </p>
	 */
	@Override
	public void clearCache() {
		entityCache.clearCache(JobDataImpl.class);

		finderCache.clearCache(FINDER_CLASS_NAME_ENTITY);
		finderCache.clearCache(FINDER_CLASS_NAME_LIST_WITH_PAGINATION);
		finderCache.clearCache(FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION);
	}

	/**
	 * Clears the cache for the job data.
	 *
	 * <p>
	 * The <code>EntityCache</code> and <code>FinderCache</code> are both cleared by this method.
	 * </p>
	 */
	@Override
	public void clearCache(JobData jobData) {
		entityCache.removeResult(
			entityCacheEnabled, JobDataImpl.class, jobData.getPrimaryKey());

		finderCache.clearCache(FINDER_CLASS_NAME_LIST_WITH_PAGINATION);
		finderCache.clearCache(FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION);
	}

	@Override
	public void clearCache(List<JobData> jobDatas) {
		finderCache.clearCache(FINDER_CLASS_NAME_LIST_WITH_PAGINATION);
		finderCache.clearCache(FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION);

		for (JobData jobData : jobDatas) {
			entityCache.removeResult(
				entityCacheEnabled, JobDataImpl.class, jobData.getPrimaryKey());
		}
	}

	/**
	 * Creates a new job data with the primary key. Does not add the job data to the database.
	 *
	 * @param jobId the primary key for the new job data
	 * @return the new job data
	 */
	@Override
	public JobData create(long jobId) {
		JobData jobData = new JobDataImpl();

		jobData.setNew(true);
		jobData.setPrimaryKey(jobId);

		return jobData;
	}

	/**
	 * Removes the job data with the primary key from the database. Also notifies the appropriate model listeners.
	 *
	 * @param jobId the primary key of the job data
	 * @return the job data that was removed
	 * @throws NoSuchJobDataException if a job data with the primary key could not be found
	 */
	@Override
	public JobData remove(long jobId) throws NoSuchJobDataException {
		return remove((Serializable)jobId);
	}

	/**
	 * Removes the job data with the primary key from the database. Also notifies the appropriate model listeners.
	 *
	 * @param primaryKey the primary key of the job data
	 * @return the job data that was removed
	 * @throws NoSuchJobDataException if a job data with the primary key could not be found
	 */
	@Override
	public JobData remove(Serializable primaryKey)
		throws NoSuchJobDataException {

		Session session = null;

		try {
			session = openSession();

			JobData jobData = (JobData)session.get(
				JobDataImpl.class, primaryKey);

			if (jobData == null) {
				if (_log.isDebugEnabled()) {
					_log.debug(_NO_SUCH_ENTITY_WITH_PRIMARY_KEY + primaryKey);
				}

				throw new NoSuchJobDataException(
					_NO_SUCH_ENTITY_WITH_PRIMARY_KEY + primaryKey);
			}

			return remove(jobData);
		}
		catch (NoSuchJobDataException nsee) {
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
	protected JobData removeImpl(JobData jobData) {
		Session session = null;

		try {
			session = openSession();

			if (!session.contains(jobData)) {
				jobData = (JobData)session.get(
					JobDataImpl.class, jobData.getPrimaryKeyObj());
			}

			if (jobData != null) {
				session.delete(jobData);
			}
		}
		catch (Exception e) {
			throw processException(e);
		}
		finally {
			closeSession(session);
		}

		if (jobData != null) {
			clearCache(jobData);
		}

		return jobData;
	}

	@Override
	public JobData updateImpl(JobData jobData) {
		boolean isNew = jobData.isNew();

		Session session = null;

		try {
			session = openSession();

			if (jobData.isNew()) {
				session.save(jobData);

				jobData.setNew(false);
			}
			else {
				jobData = (JobData)session.merge(jobData);
			}
		}
		catch (Exception e) {
			throw processException(e);
		}
		finally {
			closeSession(session);
		}

		finderCache.clearCache(FINDER_CLASS_NAME_LIST_WITH_PAGINATION);

		if (isNew) {
			finderCache.removeResult(_finderPathCountAll, FINDER_ARGS_EMPTY);
			finderCache.removeResult(
				_finderPathWithoutPaginationFindAll, FINDER_ARGS_EMPTY);
		}

		entityCache.putResult(
			entityCacheEnabled, JobDataImpl.class, jobData.getPrimaryKey(),
			jobData, false);

		jobData.resetOriginalValues();

		return jobData;
	}

	/**
	 * Returns the job data with the primary key or throws a <code>com.liferay.portal.kernel.exception.NoSuchModelException</code> if it could not be found.
	 *
	 * @param primaryKey the primary key of the job data
	 * @return the job data
	 * @throws NoSuchJobDataException if a job data with the primary key could not be found
	 */
	@Override
	public JobData findByPrimaryKey(Serializable primaryKey)
		throws NoSuchJobDataException {

		JobData jobData = fetchByPrimaryKey(primaryKey);

		if (jobData == null) {
			if (_log.isDebugEnabled()) {
				_log.debug(_NO_SUCH_ENTITY_WITH_PRIMARY_KEY + primaryKey);
			}

			throw new NoSuchJobDataException(
				_NO_SUCH_ENTITY_WITH_PRIMARY_KEY + primaryKey);
		}

		return jobData;
	}

	/**
	 * Returns the job data with the primary key or throws a <code>NoSuchJobDataException</code> if it could not be found.
	 *
	 * @param jobId the primary key of the job data
	 * @return the job data
	 * @throws NoSuchJobDataException if a job data with the primary key could not be found
	 */
	@Override
	public JobData findByPrimaryKey(long jobId) throws NoSuchJobDataException {
		return findByPrimaryKey((Serializable)jobId);
	}

	/**
	 * Returns the job data with the primary key or returns <code>null</code> if it could not be found.
	 *
	 * @param jobId the primary key of the job data
	 * @return the job data, or <code>null</code> if a job data with the primary key could not be found
	 */
	@Override
	public JobData fetchByPrimaryKey(long jobId) {
		return fetchByPrimaryKey((Serializable)jobId);
	}

	/**
	 * Returns all the job datas.
	 *
	 * @return the job datas
	 */
	@Override
	public List<JobData> findAll() {
		return findAll(QueryUtil.ALL_POS, QueryUtil.ALL_POS, null);
	}

	/**
	 * Returns a range of all the job datas.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not <code>QueryUtil#ALL_POS</code>), then the query will include the default ORDER BY logic from <code>JobDataModelImpl</code>. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	 * </p>
	 *
	 * @param start the lower bound of the range of job datas
	 * @param end the upper bound of the range of job datas (not inclusive)
	 * @return the range of job datas
	 */
	@Override
	public List<JobData> findAll(int start, int end) {
		return findAll(start, end, null);
	}

	/**
	 * Returns an ordered range of all the job datas.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not <code>QueryUtil#ALL_POS</code>), then the query will include the default ORDER BY logic from <code>JobDataModelImpl</code>. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	 * </p>
	 *
	 * @param start the lower bound of the range of job datas
	 * @param end the upper bound of the range of job datas (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @return the ordered range of job datas
	 */
	@Override
	public List<JobData> findAll(
		int start, int end, OrderByComparator<JobData> orderByComparator) {

		return findAll(start, end, orderByComparator, true);
	}

	/**
	 * Returns an ordered range of all the job datas.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not <code>QueryUtil#ALL_POS</code>), then the query will include the default ORDER BY logic from <code>JobDataModelImpl</code>. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	 * </p>
	 *
	 * @param start the lower bound of the range of job datas
	 * @param end the upper bound of the range of job datas (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @param retrieveFromCache whether to retrieve from the finder cache
	 * @return the ordered range of job datas
	 */
	@Override
	public List<JobData> findAll(
		int start, int end, OrderByComparator<JobData> orderByComparator,
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

		List<JobData> list = null;

		if (retrieveFromCache) {
			list = (List<JobData>)finderCache.getResult(
				finderPath, finderArgs, this);
		}

		if (list == null) {
			StringBundler query = null;
			String sql = null;

			if (orderByComparator != null) {
				query = new StringBundler(
					2 + (orderByComparator.getOrderByFields().length * 2));

				query.append(_SQL_SELECT_JOBDATA);

				appendOrderByComparator(
					query, _ORDER_BY_ENTITY_ALIAS, orderByComparator);

				sql = query.toString();
			}
			else {
				sql = _SQL_SELECT_JOBDATA;

				if (pagination) {
					sql = sql.concat(JobDataModelImpl.ORDER_BY_JPQL);
				}
			}

			Session session = null;

			try {
				session = openSession();

				Query q = session.createQuery(sql);

				if (!pagination) {
					list = (List<JobData>)QueryUtil.list(
						q, getDialect(), start, end, false);

					Collections.sort(list);

					list = Collections.unmodifiableList(list);
				}
				else {
					list = (List<JobData>)QueryUtil.list(
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
	 * Removes all the job datas from the database.
	 *
	 */
	@Override
	public void removeAll() {
		for (JobData jobData : findAll()) {
			remove(jobData);
		}
	}

	/**
	 * Returns the number of job datas.
	 *
	 * @return the number of job datas
	 */
	@Override
	public int countAll() {
		Long count = (Long)finderCache.getResult(
			_finderPathCountAll, FINDER_ARGS_EMPTY, this);

		if (count == null) {
			Session session = null;

			try {
				session = openSession();

				Query q = session.createQuery(_SQL_COUNT_JOBDATA);

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
	protected EntityCache getEntityCache() {
		return entityCache;
	}

	@Override
	protected String getPKDBName() {
		return "jobId";
	}

	@Override
	protected String getSelectSQL() {
		return _SQL_SELECT_JOBDATA;
	}

	@Override
	protected Map<String, Integer> getTableColumnsMap() {
		return JobDataModelImpl.TABLE_COLUMNS_MAP;
	}

	/**
	 * Initializes the job data persistence.
	 */
	@Activate
	public void activate() {
		JobDataModelImpl.setEntityCacheEnabled(entityCacheEnabled);
		JobDataModelImpl.setFinderCacheEnabled(finderCacheEnabled);

		_finderPathWithPaginationFindAll = new FinderPath(
			entityCacheEnabled, finderCacheEnabled, JobDataImpl.class,
			FINDER_CLASS_NAME_LIST_WITH_PAGINATION, "findAll", new String[0]);

		_finderPathWithoutPaginationFindAll = new FinderPath(
			entityCacheEnabled, finderCacheEnabled, JobDataImpl.class,
			FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION, "findAll",
			new String[0]);

		_finderPathCountAll = new FinderPath(
			entityCacheEnabled, finderCacheEnabled, Long.class,
			FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION, "countAll",
			new String[0]);
	}

	@Deactivate
	public void deactivate() {
		entityCache.removeCache(JobDataImpl.class.getName());
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
				"value.object.column.bitmask.enabled.com.osp.icebreaker.model.JobData"),
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

	private static final String _SQL_SELECT_JOBDATA =
		"SELECT jobData FROM JobData jobData";

	private static final String _SQL_COUNT_JOBDATA =
		"SELECT COUNT(jobData) FROM JobData jobData";

	private static final String _ORDER_BY_ENTITY_ALIAS = "jobData.";

	private static final String _NO_SUCH_ENTITY_WITH_PRIMARY_KEY =
		"No JobData exists with the primary key ";

	private static final Log _log = LogFactoryUtil.getLog(
		JobDataPersistenceImpl.class);

}