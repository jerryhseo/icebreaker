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
 * Provides a wrapper for {@link OSPClusterService}.
 *
 * @author Jerry H. Seo
 * @see OSPClusterService
 * @generated
 */
public class OSPClusterServiceWrapper
	implements OSPClusterService, ServiceWrapper<OSPClusterService> {

	public OSPClusterServiceWrapper(OSPClusterService ospClusterService) {
		_ospClusterService = ospClusterService;
	}

	@Override
	public com.osp.icebreaker.model.OSPCluster addCluster(
			String clusterName, String osFamily, String osName,
			String osVersion, String appRootDir, String dataRootDir,
			String contentRootDir,
			java.util.Map<java.util.Locale, String> descriptionMap,
			String serverIp, String sshPort, String identificationCommand,
			String accessMethod, String authorizedId, String authorizedPassword,
			String schedulerName, String schedulerVersion,
			String schedulerClass,
			com.osp.icebreaker.constants.OSPClusterSecurityLevels securityLevel,
			com.liferay.portal.kernel.service.ServiceContext sc)
		throws com.liferay.portal.kernel.exception.PortalException {

		return _ospClusterService.addCluster(
			clusterName, osFamily, osName, osVersion, appRootDir, dataRootDir,
			contentRootDir, descriptionMap, serverIp, sshPort,
			identificationCommand, accessMethod, authorizedId,
			authorizedPassword, schedulerName, schedulerVersion, schedulerClass,
			securityLevel, sc);
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
	public OSPClusterService getWrappedService() {
		return _ospClusterService;
	}

	@Override
	public void setWrappedService(OSPClusterService ospClusterService) {
		_ospClusterService = ospClusterService;
	}

	private OSPClusterService _ospClusterService;

}