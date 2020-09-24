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

import com.liferay.portal.kernel.service.ServiceWrapper;

/**
 * Provides a wrapper for {@link OSPClusterLocalService}.
 *
 * @author Jerry H. Seo
 * @see OSPClusterLocalService
 * @generated
 */
public class OSPClusterLocalServiceWrapper
	implements OSPClusterLocalService, ServiceWrapper<OSPClusterLocalService> {

	public OSPClusterLocalServiceWrapper(
		OSPClusterLocalService ospClusterLocalService) {

		_ospClusterLocalService = ospClusterLocalService;
	}

	@Override
	public com.osp.icebreaker.model.OSPCluster addCluster(
			String clusterName, String osFamily, String osName,
			String osVersion, String appRootDir,
			java.util.Map<java.util.Locale, String> descriptionMap,
			String serverIp, String sshPort, String identificationCommand,
			String accessMethod, String authorizedId, String authorizedPassword,
			String schedulerName, String schedulerVersion,
			String schedulerClass,
			com.osp.icebreaker.constants.OSPClusterSecurityLevels securityLevel,
			com.liferay.portal.kernel.service.ServiceContext sc)
		throws com.liferay.portal.kernel.exception.PortalException {

		return _ospClusterLocalService.addCluster(
			clusterName, osFamily, osName, osVersion, appRootDir,
			descriptionMap, serverIp, sshPort, identificationCommand,
			accessMethod, authorizedId, authorizedPassword, schedulerName,
			schedulerVersion, schedulerClass, securityLevel, sc);
	}

	/**
	 * Adds the osp cluster to the database. Also notifies the appropriate model listeners.
	 *
	 * @param ospCluster the osp cluster
	 * @return the osp cluster that was added
	 */
	@Override
	public com.osp.icebreaker.model.OSPCluster addOSPCluster(
		com.osp.icebreaker.model.OSPCluster ospCluster) {

		return _ospClusterLocalService.addOSPCluster(ospCluster);
	}

	@Override
	public int countClusters() {
		return _ospClusterLocalService.countClusters();
	}

	/**
	 * Creates a new osp cluster with the primary key. Does not add the osp cluster to the database.
	 *
	 * @param clusterId the primary key for the new osp cluster
	 * @return the new osp cluster
	 */
	@Override
	public com.osp.icebreaker.model.OSPCluster createOSPCluster(
		long clusterId) {

		return _ospClusterLocalService.createOSPCluster(clusterId);
	}

	@Override
	public com.osp.icebreaker.model.OSPScheduler createOSPScheduler(
			long clusterId)
		throws com.liferay.portal.kernel.exception.PortalException {

		return _ospClusterLocalService.createOSPScheduler(clusterId);
	}

	@Override
	public com.osp.icebreaker.model.OSPScheduler createOSPScheduler(
		String className, String identificationCommand, String accessMethod,
		String authorizedUserId, String password, String ip, String port) {

		return _ospClusterLocalService.createOSPScheduler(
			className, identificationCommand, accessMethod, authorizedUserId,
			password, ip, port);
	}

	/**
	 * Deletes the osp cluster with the primary key from the database. Also notifies the appropriate model listeners.
	 *
	 * @param clusterId the primary key of the osp cluster
	 * @return the osp cluster that was removed
	 * @throws PortalException if a osp cluster with the primary key could not be found
	 */
	@Override
	public com.osp.icebreaker.model.OSPCluster deleteOSPCluster(long clusterId)
		throws com.liferay.portal.kernel.exception.PortalException {

		return _ospClusterLocalService.deleteOSPCluster(clusterId);
	}

	/**
	 * Deletes the osp cluster from the database. Also notifies the appropriate model listeners.
	 *
	 * @param ospCluster the osp cluster
	 * @return the osp cluster that was removed
	 */
	@Override
	public com.osp.icebreaker.model.OSPCluster deleteOSPCluster(
		com.osp.icebreaker.model.OSPCluster ospCluster) {

		return _ospClusterLocalService.deleteOSPCluster(ospCluster);
	}

	/**
	 * @throws PortalException
	 */
	@Override
	public com.liferay.portal.kernel.model.PersistedModel deletePersistedModel(
			com.liferay.portal.kernel.model.PersistedModel persistedModel)
		throws com.liferay.portal.kernel.exception.PortalException {

		return _ospClusterLocalService.deletePersistedModel(persistedModel);
	}

	@Override
	public com.liferay.portal.kernel.dao.orm.DynamicQuery dynamicQuery() {
		return _ospClusterLocalService.dynamicQuery();
	}

	/**
	 * Performs a dynamic query on the database and returns the matching rows.
	 *
	 * @param dynamicQuery the dynamic query
	 * @return the matching rows
	 */
	@Override
	public <T> java.util.List<T> dynamicQuery(
		com.liferay.portal.kernel.dao.orm.DynamicQuery dynamicQuery) {

		return _ospClusterLocalService.dynamicQuery(dynamicQuery);
	}

	/**
	 * Performs a dynamic query on the database and returns a range of the matching rows.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>com.osp.icebreaker.model.impl.OSPClusterModelImpl</code>.
	 * </p>
	 *
	 * @param dynamicQuery the dynamic query
	 * @param start the lower bound of the range of model instances
	 * @param end the upper bound of the range of model instances (not inclusive)
	 * @return the range of matching rows
	 */
	@Override
	public <T> java.util.List<T> dynamicQuery(
		com.liferay.portal.kernel.dao.orm.DynamicQuery dynamicQuery, int start,
		int end) {

		return _ospClusterLocalService.dynamicQuery(dynamicQuery, start, end);
	}

	/**
	 * Performs a dynamic query on the database and returns an ordered range of the matching rows.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>com.osp.icebreaker.model.impl.OSPClusterModelImpl</code>.
	 * </p>
	 *
	 * @param dynamicQuery the dynamic query
	 * @param start the lower bound of the range of model instances
	 * @param end the upper bound of the range of model instances (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @return the ordered range of matching rows
	 */
	@Override
	public <T> java.util.List<T> dynamicQuery(
		com.liferay.portal.kernel.dao.orm.DynamicQuery dynamicQuery, int start,
		int end,
		com.liferay.portal.kernel.util.OrderByComparator<T> orderByComparator) {

		return _ospClusterLocalService.dynamicQuery(
			dynamicQuery, start, end, orderByComparator);
	}

	/**
	 * Returns the number of rows matching the dynamic query.
	 *
	 * @param dynamicQuery the dynamic query
	 * @return the number of rows matching the dynamic query
	 */
	@Override
	public long dynamicQueryCount(
		com.liferay.portal.kernel.dao.orm.DynamicQuery dynamicQuery) {

		return _ospClusterLocalService.dynamicQueryCount(dynamicQuery);
	}

	/**
	 * Returns the number of rows matching the dynamic query.
	 *
	 * @param dynamicQuery the dynamic query
	 * @param projection the projection to apply to the query
	 * @return the number of rows matching the dynamic query
	 */
	@Override
	public long dynamicQueryCount(
		com.liferay.portal.kernel.dao.orm.DynamicQuery dynamicQuery,
		com.liferay.portal.kernel.dao.orm.Projection projection) {

		return _ospClusterLocalService.dynamicQueryCount(
			dynamicQuery, projection);
	}

	@Override
	public com.osp.icebreaker.model.OSPCluster fetchOSPCluster(long clusterId) {
		return _ospClusterLocalService.fetchOSPCluster(clusterId);
	}

	/**
	 * Returns the osp cluster matching the UUID and group.
	 *
	 * @param uuid the osp cluster's UUID
	 * @param groupId the primary key of the group
	 * @return the matching osp cluster, or <code>null</code> if a matching osp cluster could not be found
	 */
	@Override
	public com.osp.icebreaker.model.OSPCluster fetchOSPClusterByUuidAndGroupId(
		String uuid, long groupId) {

		return _ospClusterLocalService.fetchOSPClusterByUuidAndGroupId(
			uuid, groupId);
	}

	@Override
	public com.liferay.portal.kernel.dao.orm.ActionableDynamicQuery
		getActionableDynamicQuery() {

		return _ospClusterLocalService.getActionableDynamicQuery();
	}

	@Override
	public com.osp.icebreaker.model.OSPCluster getCluster(String clusterName) {
		return _ospClusterLocalService.getCluster(clusterName);
	}

	@Override
	public java.util.List<com.osp.icebreaker.model.OSPCluster> getClusters() {
		return _ospClusterLocalService.getClusters();
	}

	@Override
	public java.util.List<com.osp.icebreaker.model.OSPCluster> getClusters(
		int start, int end) {

		return _ospClusterLocalService.getClusters(start, end);
	}

	@Override
	public com.liferay.portal.kernel.dao.orm.ExportActionableDynamicQuery
		getExportActionableDynamicQuery(
			com.liferay.exportimport.kernel.lar.PortletDataContext
				portletDataContext) {

		return _ospClusterLocalService.getExportActionableDynamicQuery(
			portletDataContext);
	}

	@Override
	public com.liferay.portal.kernel.dao.orm.IndexableActionableDynamicQuery
		getIndexableActionableDynamicQuery() {

		return _ospClusterLocalService.getIndexableActionableDynamicQuery();
	}

	/**
	 * Returns the OSGi service identifier.
	 *
	 * @return the OSGi service identifier
	 */
	@Override
	public String getOSGiServiceIdentifier() {
		return _ospClusterLocalService.getOSGiServiceIdentifier();
	}

	/**
	 * Returns the osp cluster with the primary key.
	 *
	 * @param clusterId the primary key of the osp cluster
	 * @return the osp cluster
	 * @throws PortalException if a osp cluster with the primary key could not be found
	 */
	@Override
	public com.osp.icebreaker.model.OSPCluster getOSPCluster(long clusterId)
		throws com.liferay.portal.kernel.exception.PortalException {

		return _ospClusterLocalService.getOSPCluster(clusterId);
	}

	/**
	 * Returns the osp cluster matching the UUID and group.
	 *
	 * @param uuid the osp cluster's UUID
	 * @param groupId the primary key of the group
	 * @return the matching osp cluster
	 * @throws PortalException if a matching osp cluster could not be found
	 */
	@Override
	public com.osp.icebreaker.model.OSPCluster getOSPClusterByUuidAndGroupId(
			String uuid, long groupId)
		throws com.liferay.portal.kernel.exception.PortalException {

		return _ospClusterLocalService.getOSPClusterByUuidAndGroupId(
			uuid, groupId);
	}

	/**
	 * Returns a range of all the osp clusters.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>com.osp.icebreaker.model.impl.OSPClusterModelImpl</code>.
	 * </p>
	 *
	 * @param start the lower bound of the range of osp clusters
	 * @param end the upper bound of the range of osp clusters (not inclusive)
	 * @return the range of osp clusters
	 */
	@Override
	public java.util.List<com.osp.icebreaker.model.OSPCluster> getOSPClusters(
		int start, int end) {

		return _ospClusterLocalService.getOSPClusters(start, end);
	}

	/**
	 * Returns all the osp clusters matching the UUID and company.
	 *
	 * @param uuid the UUID of the osp clusters
	 * @param companyId the primary key of the company
	 * @return the matching osp clusters, or an empty list if no matches were found
	 */
	@Override
	public java.util.List<com.osp.icebreaker.model.OSPCluster>
		getOSPClustersByUuidAndCompanyId(String uuid, long companyId) {

		return _ospClusterLocalService.getOSPClustersByUuidAndCompanyId(
			uuid, companyId);
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
	@Override
	public java.util.List<com.osp.icebreaker.model.OSPCluster>
		getOSPClustersByUuidAndCompanyId(
			String uuid, long companyId, int start, int end,
			com.liferay.portal.kernel.util.OrderByComparator
				<com.osp.icebreaker.model.OSPCluster> orderByComparator) {

		return _ospClusterLocalService.getOSPClustersByUuidAndCompanyId(
			uuid, companyId, start, end, orderByComparator);
	}

	/**
	 * Returns the number of osp clusters.
	 *
	 * @return the number of osp clusters
	 */
	@Override
	public int getOSPClustersCount() {
		return _ospClusterLocalService.getOSPClustersCount();
	}

	/**
	 * @throws PortalException
	 */
	@Override
	public com.liferay.portal.kernel.model.PersistedModel getPersistedModel(
			java.io.Serializable primaryKeyObj)
		throws com.liferay.portal.kernel.exception.PortalException {

		return _ospClusterLocalService.getPersistedModel(primaryKeyObj);
	}

	@Override
	public com.osp.icebreaker.model.OSPCluster removeCluster(long clusterId)
		throws com.liferay.portal.kernel.exception.PortalException {

		return _ospClusterLocalService.removeCluster(clusterId);
	}

	@Override
	public com.osp.icebreaker.model.OSPCluster removeCluster(
		String clusterName) {

		return _ospClusterLocalService.removeCluster(clusterName);
	}

	@Override
	public com.osp.icebreaker.model.OSPCluster updateCluster(
			long clusterId, String clusterName, String osFamily, String osName,
			String osVersion, String appRootDir,
			java.util.Map<java.util.Locale, String> descriptionMap,
			String serverIp, String sshPort, String identificationCommand,
			String accessMethod, String authorizedId, String authorizedPassword,
			String schedulerName, String schedulerVersion,
			String schedulerClass,
			com.osp.icebreaker.constants.OSPClusterSecurityLevels securityLevel,
			com.liferay.portal.kernel.service.ServiceContext sc)
		throws com.liferay.portal.kernel.exception.PortalException {

		return _ospClusterLocalService.updateCluster(
			clusterId, clusterName, osFamily, osName, osVersion, appRootDir,
			descriptionMap, serverIp, sshPort, identificationCommand,
			accessMethod, authorizedId, authorizedPassword, schedulerName,
			schedulerVersion, schedulerClass, securityLevel, sc);
	}

	/**
	 * Updates the osp cluster in the database or adds it if it does not yet exist. Also notifies the appropriate model listeners.
	 *
	 * @param ospCluster the osp cluster
	 * @return the osp cluster that was updated
	 */
	@Override
	public com.osp.icebreaker.model.OSPCluster updateOSPCluster(
		com.osp.icebreaker.model.OSPCluster ospCluster) {

		return _ospClusterLocalService.updateOSPCluster(ospCluster);
	}

	@Override
	public OSPClusterLocalService getWrappedService() {
		return _ospClusterLocalService;
	}

	@Override
	public void setWrappedService(
		OSPClusterLocalService ospClusterLocalService) {

		_ospClusterLocalService = ospClusterLocalService;
	}

	private OSPClusterLocalService _ospClusterLocalService;

}