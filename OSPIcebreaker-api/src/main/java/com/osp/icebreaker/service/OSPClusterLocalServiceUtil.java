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

import org.osgi.annotation.versioning.ProviderType;
import org.osgi.framework.Bundle;
import org.osgi.framework.FrameworkUtil;
import org.osgi.util.tracker.ServiceTracker;

/**
 * Provides the local service utility for OSPCluster. This utility wraps
 * <code>com.osp.icebreaker.service.impl.OSPClusterLocalServiceImpl</code> and
 * is an access point for service operations in application layer code running
 * on the local server. Methods of this service will not have security checks
 * based on the propagated JAAS credentials because this service can only be
 * accessed from within the same VM.
 *
 * @author Jerry H. Seo
 * @see OSPClusterLocalService
 * @generated
 */
@ProviderType
public class OSPClusterLocalServiceUtil {

	/*
	 * NOTE FOR DEVELOPERS:
	 *
	 * Never modify this class directly. Add custom service methods to <code>com.osp.icebreaker.service.impl.OSPClusterLocalServiceImpl</code> and rerun ServiceBuilder to regenerate this class.
	 */
	public static com.osp.icebreaker.model.OSPCluster addCluster(
		com.osp.icebreaker.model.OSPCluster cluster) {

		return getService().addCluster(cluster);
	}

	public static com.osp.icebreaker.model.OSPCluster addCluster(
		String clusterName, String osFamily, String osName, String osVersion,
		String appRootDir, String dataRootDir, String contentRootDir,
		java.util.Map<java.util.Locale, String> descriptionMap, String serverIp,
		String accessMethod, String sshPort, String authorizedId,
		String authorizedPassword, String schedulerName,
		String schedulerVersion, String schedulerClass,
		com.liferay.portal.kernel.service.ServiceContext sc) {

		return getService().addCluster(
			clusterName, osFamily, osName, osVersion, appRootDir, dataRootDir,
			contentRootDir, descriptionMap, serverIp, accessMethod, sshPort,
			authorizedId, authorizedPassword, schedulerName, schedulerVersion,
			schedulerClass, sc);
	}

	/**
	 * Adds the osp cluster to the database. Also notifies the appropriate model listeners.
	 *
	 * @param ospCluster the osp cluster
	 * @return the osp cluster that was added
	 */
	public static com.osp.icebreaker.model.OSPCluster addOSPCluster(
		com.osp.icebreaker.model.OSPCluster ospCluster) {

		return getService().addOSPCluster(ospCluster);
	}

	public static int countClusters() {
		return getService().countClusters();
	}

	public static com.osp.icebreaker.model.OSPCluster createCluster(
		String clusterName,
		com.liferay.portal.kernel.service.ServiceContext sc) {

		return getService().createCluster(clusterName, sc);
	}

	/**
	 * Creates a new osp cluster with the primary key. Does not add the osp cluster to the database.
	 *
	 * @param clusterId the primary key for the new osp cluster
	 * @return the new osp cluster
	 */
	public static com.osp.icebreaker.model.OSPCluster createOSPCluster(
		long clusterId) {

		return getService().createOSPCluster(clusterId);
	}

	public static com.osp.icebreaker.model.OSPScheduler createOSPScheduler(
			long clusterId)
		throws com.liferay.portal.kernel.exception.PortalException {

		return getService().createOSPScheduler(clusterId);
	}

	public static com.osp.icebreaker.model.OSPScheduler createOSPScheduler(
		String className, String user, String password, String ip,
		String port) {

		return getService().createOSPScheduler(
			className, user, password, ip, port);
	}

	/**
	 * Deletes the osp cluster with the primary key from the database. Also notifies the appropriate model listeners.
	 *
	 * @param clusterId the primary key of the osp cluster
	 * @return the osp cluster that was removed
	 * @throws PortalException if a osp cluster with the primary key could not be found
	 */
	public static com.osp.icebreaker.model.OSPCluster deleteOSPCluster(
			long clusterId)
		throws com.liferay.portal.kernel.exception.PortalException {

		return getService().deleteOSPCluster(clusterId);
	}

	/**
	 * Deletes the osp cluster from the database. Also notifies the appropriate model listeners.
	 *
	 * @param ospCluster the osp cluster
	 * @return the osp cluster that was removed
	 */
	public static com.osp.icebreaker.model.OSPCluster deleteOSPCluster(
		com.osp.icebreaker.model.OSPCluster ospCluster) {

		return getService().deleteOSPCluster(ospCluster);
	}

	/**
	 * @throws PortalException
	 */
	public static com.liferay.portal.kernel.model.PersistedModel
			deletePersistedModel(
				com.liferay.portal.kernel.model.PersistedModel persistedModel)
		throws com.liferay.portal.kernel.exception.PortalException {

		return getService().deletePersistedModel(persistedModel);
	}

	public static com.liferay.portal.kernel.dao.orm.DynamicQuery
		dynamicQuery() {

		return getService().dynamicQuery();
	}

	/**
	 * Performs a dynamic query on the database and returns the matching rows.
	 *
	 * @param dynamicQuery the dynamic query
	 * @return the matching rows
	 */
	public static <T> java.util.List<T> dynamicQuery(
		com.liferay.portal.kernel.dao.orm.DynamicQuery dynamicQuery) {

		return getService().dynamicQuery(dynamicQuery);
	}

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
	public static <T> java.util.List<T> dynamicQuery(
		com.liferay.portal.kernel.dao.orm.DynamicQuery dynamicQuery, int start,
		int end) {

		return getService().dynamicQuery(dynamicQuery, start, end);
	}

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
	public static <T> java.util.List<T> dynamicQuery(
		com.liferay.portal.kernel.dao.orm.DynamicQuery dynamicQuery, int start,
		int end,
		com.liferay.portal.kernel.util.OrderByComparator<T> orderByComparator) {

		return getService().dynamicQuery(
			dynamicQuery, start, end, orderByComparator);
	}

	/**
	 * Returns the number of rows matching the dynamic query.
	 *
	 * @param dynamicQuery the dynamic query
	 * @return the number of rows matching the dynamic query
	 */
	public static long dynamicQueryCount(
		com.liferay.portal.kernel.dao.orm.DynamicQuery dynamicQuery) {

		return getService().dynamicQueryCount(dynamicQuery);
	}

	/**
	 * Returns the number of rows matching the dynamic query.
	 *
	 * @param dynamicQuery the dynamic query
	 * @param projection the projection to apply to the query
	 * @return the number of rows matching the dynamic query
	 */
	public static long dynamicQueryCount(
		com.liferay.portal.kernel.dao.orm.DynamicQuery dynamicQuery,
		com.liferay.portal.kernel.dao.orm.Projection projection) {

		return getService().dynamicQueryCount(dynamicQuery, projection);
	}

	public static com.osp.icebreaker.model.OSPCluster fetchOSPCluster(
		long clusterId) {

		return getService().fetchOSPCluster(clusterId);
	}

	/**
	 * Returns the osp cluster matching the UUID and group.
	 *
	 * @param uuid the osp cluster's UUID
	 * @param groupId the primary key of the group
	 * @return the matching osp cluster, or <code>null</code> if a matching osp cluster could not be found
	 */
	public static com.osp.icebreaker.model.OSPCluster
		fetchOSPClusterByUuidAndGroupId(String uuid, long groupId) {

		return getService().fetchOSPClusterByUuidAndGroupId(uuid, groupId);
	}

	public static com.liferay.portal.kernel.dao.orm.ActionableDynamicQuery
		getActionableDynamicQuery() {

		return getService().getActionableDynamicQuery();
	}

	public static com.osp.icebreaker.model.OSPCluster getCluster(
		String clusterName) {

		return getService().getCluster(clusterName);
	}

	public static java.util.List<com.osp.icebreaker.model.OSPCluster>
		getClusters() {

		return getService().getClusters();
	}

	public static java.util.List<com.osp.icebreaker.model.OSPCluster>
		getClusters(int start, int end) {

		return getService().getClusters(start, end);
	}

	public static java.util.List<com.osp.icebreaker.model.OSPCluster>
		getClusters(
			int start, int end,
			com.liferay.portal.kernel.util.OrderByComparator
				<com.osp.icebreaker.model.OSPCluster> orderByComparator) {

		return getService().getClusters(start, end, orderByComparator);
	}

	public static java.util.List<com.osp.icebreaker.model.OSPCluster>
		getClusters(
			int start, int end,
			com.liferay.portal.kernel.util.OrderByComparator
				<com.osp.icebreaker.model.OSPCluster> orderByComparator,
			boolean retrieveFromCache) {

		return getService().getClusters(
			start, end, orderByComparator, retrieveFromCache);
	}

	public static com.liferay.portal.kernel.dao.orm.ExportActionableDynamicQuery
		getExportActionableDynamicQuery(
			com.liferay.exportimport.kernel.lar.PortletDataContext
				portletDataContext) {

		return getService().getExportActionableDynamicQuery(portletDataContext);
	}

	public static
		com.liferay.portal.kernel.dao.orm.IndexableActionableDynamicQuery
			getIndexableActionableDynamicQuery() {

		return getService().getIndexableActionableDynamicQuery();
	}

	/**
	 * Returns the OSGi service identifier.
	 *
	 * @return the OSGi service identifier
	 */
	public static String getOSGiServiceIdentifier() {
		return getService().getOSGiServiceIdentifier();
	}

	/**
	 * Returns the osp cluster with the primary key.
	 *
	 * @param clusterId the primary key of the osp cluster
	 * @return the osp cluster
	 * @throws PortalException if a osp cluster with the primary key could not be found
	 */
	public static com.osp.icebreaker.model.OSPCluster getOSPCluster(
			long clusterId)
		throws com.liferay.portal.kernel.exception.PortalException {

		return getService().getOSPCluster(clusterId);
	}

	/**
	 * Returns the osp cluster matching the UUID and group.
	 *
	 * @param uuid the osp cluster's UUID
	 * @param groupId the primary key of the group
	 * @return the matching osp cluster
	 * @throws PortalException if a matching osp cluster could not be found
	 */
	public static com.osp.icebreaker.model.OSPCluster
			getOSPClusterByUuidAndGroupId(String uuid, long groupId)
		throws com.liferay.portal.kernel.exception.PortalException {

		return getService().getOSPClusterByUuidAndGroupId(uuid, groupId);
	}

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
	public static java.util.List<com.osp.icebreaker.model.OSPCluster>
		getOSPClusters(int start, int end) {

		return getService().getOSPClusters(start, end);
	}

	/**
	 * Returns all the osp clusters matching the UUID and company.
	 *
	 * @param uuid the UUID of the osp clusters
	 * @param companyId the primary key of the company
	 * @return the matching osp clusters, or an empty list if no matches were found
	 */
	public static java.util.List<com.osp.icebreaker.model.OSPCluster>
		getOSPClustersByUuidAndCompanyId(String uuid, long companyId) {

		return getService().getOSPClustersByUuidAndCompanyId(uuid, companyId);
	}

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
	public static java.util.List<com.osp.icebreaker.model.OSPCluster>
		getOSPClustersByUuidAndCompanyId(
			String uuid, long companyId, int start, int end,
			com.liferay.portal.kernel.util.OrderByComparator
				<com.osp.icebreaker.model.OSPCluster> orderByComparator) {

		return getService().getOSPClustersByUuidAndCompanyId(
			uuid, companyId, start, end, orderByComparator);
	}

	/**
	 * Returns the number of osp clusters.
	 *
	 * @return the number of osp clusters
	 */
	public static int getOSPClustersCount() {
		return getService().getOSPClustersCount();
	}

	public static com.liferay.portal.kernel.model.PersistedModel
			getPersistedModel(java.io.Serializable primaryKeyObj)
		throws com.liferay.portal.kernel.exception.PortalException {

		return getService().getPersistedModel(primaryKeyObj);
	}

	public static com.osp.icebreaker.model.OSPCluster removeCluster(
			long clusterId)
		throws com.liferay.portal.kernel.exception.PortalException {

		return getService().removeCluster(clusterId);
	}

	public static com.osp.icebreaker.model.OSPCluster removeCluster(
		String clusterName) {

		return getService().removeCluster(clusterName);
	}

	public static com.osp.icebreaker.model.OSPCluster updateCluster(
		com.osp.icebreaker.model.OSPCluster cluster) {

		return getService().updateCluster(cluster);
	}

	/**
	 * Updates the osp cluster in the database or adds it if it does not yet exist. Also notifies the appropriate model listeners.
	 *
	 * @param ospCluster the osp cluster
	 * @return the osp cluster that was updated
	 */
	public static com.osp.icebreaker.model.OSPCluster updateOSPCluster(
		com.osp.icebreaker.model.OSPCluster ospCluster) {

		return getService().updateOSPCluster(ospCluster);
	}

	public static OSPClusterLocalService getService() {
		return _serviceTracker.getService();
	}

	private static ServiceTracker
		<OSPClusterLocalService, OSPClusterLocalService> _serviceTracker;

	static {
		Bundle bundle = FrameworkUtil.getBundle(OSPClusterLocalService.class);

		ServiceTracker<OSPClusterLocalService, OSPClusterLocalService>
			serviceTracker =
				new ServiceTracker
					<OSPClusterLocalService, OSPClusterLocalService>(
						bundle.getBundleContext(), OSPClusterLocalService.class,
						null);

		serviceTracker.open();

		_serviceTracker = serviceTracker;
	}

}