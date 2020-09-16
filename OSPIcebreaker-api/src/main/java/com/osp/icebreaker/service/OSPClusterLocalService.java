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

package com.osp.icebreaker.service;

import com.liferay.exportimport.kernel.lar.PortletDataContext;
import com.liferay.portal.kernel.dao.orm.ActionableDynamicQuery;
import com.liferay.portal.kernel.dao.orm.DynamicQuery;
import com.liferay.portal.kernel.dao.orm.ExportActionableDynamicQuery;
import com.liferay.portal.kernel.dao.orm.IndexableActionableDynamicQuery;
import com.liferay.portal.kernel.dao.orm.Projection;
import com.liferay.portal.kernel.exception.PortalException;
import com.liferay.portal.kernel.exception.SystemException;
import com.liferay.portal.kernel.model.PersistedModel;
import com.liferay.portal.kernel.search.Indexable;
import com.liferay.portal.kernel.search.IndexableType;
import com.liferay.portal.kernel.service.BaseLocalService;
import com.liferay.portal.kernel.service.PersistedModelLocalService;
import com.liferay.portal.kernel.service.ServiceContext;
import com.liferay.portal.kernel.transaction.Isolation;
import com.liferay.portal.kernel.transaction.Propagation;
import com.liferay.portal.kernel.transaction.Transactional;
import com.liferay.portal.kernel.util.OrderByComparator;

import com.osp.icebreaker.model.OSPCluster;
import com.osp.icebreaker.model.OSPScheduler;

import java.io.Serializable;

import java.util.List;
import java.util.Locale;
import java.util.Map;

import org.osgi.annotation.versioning.ProviderType;

/**
 * Provides the local service interface for OSPCluster. Methods of this
 * service will not have security checks based on the propagated JAAS
 * credentials because this service can only be accessed from within the same
 * VM.
 *
 * @author Jerry H. Seo
 * @see OSPClusterLocalServiceUtil
 * @generated
 */
@ProviderType
@Transactional(
	isolation = Isolation.PORTAL,
	rollbackFor = {PortalException.class, SystemException.class}
)
public interface OSPClusterLocalService
	extends BaseLocalService, PersistedModelLocalService {

	/*
	 * NOTE FOR DEVELOPERS:
	 *
	 * Never modify or reference this interface directly. Always use {@link OSPClusterLocalServiceUtil} to access the osp cluster local service. Add custom service methods to <code>com.osp.icebreaker.service.impl.OSPClusterLocalServiceImpl</code> and rerun ServiceBuilder to automatically copy the method declarations to this interface.
	 */
	public OSPCluster addCluster(OSPCluster cluster);

	public OSPCluster addCluster(
		String clusterName, String osFamily, String osName, String osVersion,
		String appRootDir, String dataRootDir, String contentRootDir,
		Map<Locale, String> descriptionMap, String serverIp,
		String accessMethod, String sshPort, String authorizedId,
		String authorizedPassword, String schedulerName,
		String schedulerVersion, String schedulerClass, ServiceContext sc);

	/**
	 * Adds the osp cluster to the database. Also notifies the appropriate model listeners.
	 *
	 * @param ospCluster the osp cluster
	 * @return the osp cluster that was added
	 */
	@Indexable(type = IndexableType.REINDEX)
	public OSPCluster addOSPCluster(OSPCluster ospCluster);

	public int countClusters();

	public OSPCluster createCluster(String clusterName, ServiceContext sc);

	/**
	 * Creates a new osp cluster with the primary key. Does not add the osp cluster to the database.
	 *
	 * @param clusterId the primary key for the new osp cluster
	 * @return the new osp cluster
	 */
	@Transactional(enabled = false)
	public OSPCluster createOSPCluster(long clusterId);

	public OSPScheduler createOSPScheduler(long clusterId)
		throws PortalException;

	public OSPScheduler createOSPScheduler(
		String className, String user, String password, String ip, String port);

	/**
	 * Deletes the osp cluster with the primary key from the database. Also notifies the appropriate model listeners.
	 *
	 * @param clusterId the primary key of the osp cluster
	 * @return the osp cluster that was removed
	 * @throws PortalException if a osp cluster with the primary key could not be found
	 */
	@Indexable(type = IndexableType.DELETE)
	public OSPCluster deleteOSPCluster(long clusterId) throws PortalException;

	/**
	 * Deletes the osp cluster from the database. Also notifies the appropriate model listeners.
	 *
	 * @param ospCluster the osp cluster
	 * @return the osp cluster that was removed
	 */
	@Indexable(type = IndexableType.DELETE)
	public OSPCluster deleteOSPCluster(OSPCluster ospCluster);

	/**
	 * @throws PortalException
	 */
	@Override
	public PersistedModel deletePersistedModel(PersistedModel persistedModel)
		throws PortalException;

	@Transactional(propagation = Propagation.SUPPORTS, readOnly = true)
	public DynamicQuery dynamicQuery();

	/**
	 * Performs a dynamic query on the database and returns the matching rows.
	 *
	 * @param dynamicQuery the dynamic query
	 * @return the matching rows
	 */
	@Transactional(propagation = Propagation.SUPPORTS, readOnly = true)
	public <T> List<T> dynamicQuery(DynamicQuery dynamicQuery);

	/**
	 * Performs a dynamic query on the database and returns a range of the matching rows.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not <code>com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS</code>), then the query will include the default ORDER BY logic from <code>com.osp.icebreaker.model.impl.OSPClusterModelImpl</code>. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	 * </p>
	 *
	 * @param dynamicQuery the dynamic query
	 * @param start the lower bound of the range of model instances
	 * @param end the upper bound of the range of model instances (not inclusive)
	 * @return the range of matching rows
	 */
	@Transactional(propagation = Propagation.SUPPORTS, readOnly = true)
	public <T> List<T> dynamicQuery(
		DynamicQuery dynamicQuery, int start, int end);

	/**
	 * Performs a dynamic query on the database and returns an ordered range of the matching rows.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not <code>com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS</code>), then the query will include the default ORDER BY logic from <code>com.osp.icebreaker.model.impl.OSPClusterModelImpl</code>. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	 * </p>
	 *
	 * @param dynamicQuery the dynamic query
	 * @param start the lower bound of the range of model instances
	 * @param end the upper bound of the range of model instances (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @return the ordered range of matching rows
	 */
	@Transactional(propagation = Propagation.SUPPORTS, readOnly = true)
	public <T> List<T> dynamicQuery(
		DynamicQuery dynamicQuery, int start, int end,
		OrderByComparator<T> orderByComparator);

	/**
	 * Returns the number of rows matching the dynamic query.
	 *
	 * @param dynamicQuery the dynamic query
	 * @return the number of rows matching the dynamic query
	 */
	@Transactional(propagation = Propagation.SUPPORTS, readOnly = true)
	public long dynamicQueryCount(DynamicQuery dynamicQuery);

	/**
	 * Returns the number of rows matching the dynamic query.
	 *
	 * @param dynamicQuery the dynamic query
	 * @param projection the projection to apply to the query
	 * @return the number of rows matching the dynamic query
	 */
	@Transactional(propagation = Propagation.SUPPORTS, readOnly = true)
	public long dynamicQueryCount(
		DynamicQuery dynamicQuery, Projection projection);

	@Transactional(propagation = Propagation.SUPPORTS, readOnly = true)
	public OSPCluster fetchOSPCluster(long clusterId);

	/**
	 * Returns the osp cluster matching the UUID and group.
	 *
	 * @param uuid the osp cluster's UUID
	 * @param groupId the primary key of the group
	 * @return the matching osp cluster, or <code>null</code> if a matching osp cluster could not be found
	 */
	@Transactional(propagation = Propagation.SUPPORTS, readOnly = true)
	public OSPCluster fetchOSPClusterByUuidAndGroupId(
		String uuid, long groupId);

	@Transactional(propagation = Propagation.SUPPORTS, readOnly = true)
	public ActionableDynamicQuery getActionableDynamicQuery();

	@Transactional(propagation = Propagation.SUPPORTS, readOnly = true)
	public OSPCluster getCluster(String clusterName);

	@Transactional(propagation = Propagation.SUPPORTS, readOnly = true)
	public List<OSPCluster> getClusters();

	@Transactional(propagation = Propagation.SUPPORTS, readOnly = true)
	public List<OSPCluster> getClusters(int start, int end);

	@Transactional(propagation = Propagation.SUPPORTS, readOnly = true)
	public List<OSPCluster> getClusters(
		int start, int end, OrderByComparator<OSPCluster> orderByComparator);

	@Transactional(propagation = Propagation.SUPPORTS, readOnly = true)
	public List<OSPCluster> getClusters(
		int start, int end, OrderByComparator<OSPCluster> orderByComparator,
		boolean retrieveFromCache);

	@Transactional(propagation = Propagation.SUPPORTS, readOnly = true)
	public ExportActionableDynamicQuery getExportActionableDynamicQuery(
		PortletDataContext portletDataContext);

	@Transactional(propagation = Propagation.SUPPORTS, readOnly = true)
	public IndexableActionableDynamicQuery getIndexableActionableDynamicQuery();

	/**
	 * Returns the OSGi service identifier.
	 *
	 * @return the OSGi service identifier
	 */
	public String getOSGiServiceIdentifier();

	/**
	 * Returns the osp cluster with the primary key.
	 *
	 * @param clusterId the primary key of the osp cluster
	 * @return the osp cluster
	 * @throws PortalException if a osp cluster with the primary key could not be found
	 */
	@Transactional(propagation = Propagation.SUPPORTS, readOnly = true)
	public OSPCluster getOSPCluster(long clusterId) throws PortalException;

	/**
	 * Returns the osp cluster matching the UUID and group.
	 *
	 * @param uuid the osp cluster's UUID
	 * @param groupId the primary key of the group
	 * @return the matching osp cluster
	 * @throws PortalException if a matching osp cluster could not be found
	 */
	@Transactional(propagation = Propagation.SUPPORTS, readOnly = true)
	public OSPCluster getOSPClusterByUuidAndGroupId(String uuid, long groupId)
		throws PortalException;

	/**
	 * Returns a range of all the osp clusters.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not <code>com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS</code>), then the query will include the default ORDER BY logic from <code>com.osp.icebreaker.model.impl.OSPClusterModelImpl</code>. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	 * </p>
	 *
	 * @param start the lower bound of the range of osp clusters
	 * @param end the upper bound of the range of osp clusters (not inclusive)
	 * @return the range of osp clusters
	 */
	@Transactional(propagation = Propagation.SUPPORTS, readOnly = true)
	public List<OSPCluster> getOSPClusters(int start, int end);

	/**
	 * Returns all the osp clusters matching the UUID and company.
	 *
	 * @param uuid the UUID of the osp clusters
	 * @param companyId the primary key of the company
	 * @return the matching osp clusters, or an empty list if no matches were found
	 */
	@Transactional(propagation = Propagation.SUPPORTS, readOnly = true)
	public List<OSPCluster> getOSPClustersByUuidAndCompanyId(
		String uuid, long companyId);

	/**
	 * Returns a range of osp clusters matching the UUID and company.
	 *
	 * @param uuid the UUID of the osp clusters
	 * @param companyId the primary key of the company
	 * @param start the lower bound of the range of osp clusters
	 * @param end the upper bound of the range of osp clusters (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @return the range of matching osp clusters, or an empty list if no matches were found
	 */
	@Transactional(propagation = Propagation.SUPPORTS, readOnly = true)
	public List<OSPCluster> getOSPClustersByUuidAndCompanyId(
		String uuid, long companyId, int start, int end,
		OrderByComparator<OSPCluster> orderByComparator);

	/**
	 * Returns the number of osp clusters.
	 *
	 * @return the number of osp clusters
	 */
	@Transactional(propagation = Propagation.SUPPORTS, readOnly = true)
	public int getOSPClustersCount();

	@Override
	@Transactional(propagation = Propagation.SUPPORTS, readOnly = true)
	public PersistedModel getPersistedModel(Serializable primaryKeyObj)
		throws PortalException;

	public OSPCluster removeCluster(long clusterId) throws PortalException;

	public OSPCluster removeCluster(String clusterName);

	public OSPCluster updateCluster(OSPCluster cluster);

	/**
	 * Updates the osp cluster in the database or adds it if it does not yet exist. Also notifies the appropriate model listeners.
	 *
	 * @param ospCluster the osp cluster
	 * @return the osp cluster that was updated
	 */
	@Indexable(type = IndexableType.REINDEX)
	public OSPCluster updateOSPCluster(OSPCluster ospCluster);

}