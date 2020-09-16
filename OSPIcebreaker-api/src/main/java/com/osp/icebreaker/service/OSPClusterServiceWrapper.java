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

import org.osgi.annotation.versioning.ProviderType;

/**
 * Provides a wrapper for {@link OSPClusterService}.
 *
 * @author Jerry H. Seo
 * @see OSPClusterService
 * @generated
 */
@ProviderType
public class OSPClusterServiceWrapper
	implements OSPClusterService, ServiceWrapper<OSPClusterService> {

	public OSPClusterServiceWrapper(OSPClusterService ospClusterService) {
		_ospClusterService = ospClusterService;
	}

	@Override
	public com.osp.icebreaker.model.OSPCluster addCluster(
		String clusterName,
		com.liferay.portal.kernel.service.ServiceContext sc) {

		return _ospClusterService.addCluster(clusterName, sc);
	}

	@Override
	public com.osp.icebreaker.model.OSPCluster addCluster(
		String clusterName, String osFamily, String osName, String osVersion,
		String appRootDir, String dataRootDir, String contentRootDir,
		java.util.Map<java.util.Locale, String> descriptionMap, String serverIp,
		String accessMethod, String sshPort, String authorizedId,
		String authorizedPassword, String schedulerName,
		String schedulerVersion, String schedulerClass,
		com.liferay.portal.kernel.service.ServiceContext sc) {

		return _ospClusterService.addCluster(
			clusterName, osFamily, osName, osVersion, appRootDir, dataRootDir,
			contentRootDir, descriptionMap, serverIp, accessMethod, sshPort,
			authorizedId, authorizedPassword, schedulerName, schedulerVersion,
			schedulerClass, sc);
	}

	@Override
	public com.osp.icebreaker.model.OSPCluster deleteCluster(long clusterId)
		throws com.liferay.portal.kernel.exception.PortalException {

		return _ospClusterService.deleteCluster(clusterId);
	}

	@Override
	public com.osp.icebreaker.model.OSPCluster getCluster(long clusterId)
		throws com.liferay.portal.kernel.exception.PortalException {

		return _ospClusterService.getCluster(clusterId);
	}

	@Override
	public com.osp.icebreaker.model.OSPCluster getCluster(String clusterName) {
		return _ospClusterService.getCluster(clusterName);
	}

	/**
	 * Returns the OSGi service identifier.
	 *
	 * @return the OSGi service identifier
	 */
	@Override
	public String getOSGiServiceIdentifier() {
		return _ospClusterService.getOSGiServiceIdentifier();
	}

	@Override
	public com.osp.icebreaker.model.OSPCluster updateCluster(
			long clusterId, com.liferay.portal.kernel.service.ServiceContext sc)
		throws com.liferay.portal.kernel.exception.PortalException {

		return _ospClusterService.updateCluster(clusterId, sc);
	}

	@Override
	public OSPClusterService getWrappedService() {
		return _ospClusterService;
	}

	@Override
	public void setWrappedService(OSPClusterService ospClusterService) {
		_ospClusterService = ospClusterService;
	}

	private OSPClusterService _ospClusterService;

}