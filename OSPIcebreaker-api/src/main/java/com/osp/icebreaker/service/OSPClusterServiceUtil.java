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

import org.osgi.framework.Bundle;
import org.osgi.framework.FrameworkUtil;
import org.osgi.util.tracker.ServiceTracker;

/**
 * Provides the remote service utility for OSPCluster. This utility wraps
 * <code>com.osp.icebreaker.service.impl.OSPClusterServiceImpl</code> and is an
 * access point for service operations in application layer code running on a
 * remote server. Methods of this service are expected to have security checks
 * based on the propagated JAAS credentials because this service can be
 * accessed remotely.
 *
 * @author Jerry H. Seo
 * @see OSPClusterService
 * @generated
 */
public class OSPClusterServiceUtil {

	/*
	 * NOTE FOR DEVELOPERS:
	 *
	 * Never modify this class directly. Add custom service methods to <code>com.osp.icebreaker.service.impl.OSPClusterServiceImpl</code> and rerun ServiceBuilder to regenerate this class.
	 */
	public static com.osp.icebreaker.model.OSPCluster addCluster(
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

		return getService().addCluster(
			clusterName, osFamily, osName, osVersion, appRootDir, dataRootDir,
			contentRootDir, descriptionMap, serverIp, sshPort,
			identificationCommand, accessMethod, authorizedId,
			authorizedPassword, schedulerName, schedulerVersion, schedulerClass,
			securityLevel, sc);
	}

	public static com.osp.icebreaker.model.OSPCluster deleteCluster(
			long clusterId)
		throws com.liferay.portal.kernel.exception.PortalException {

		return getService().deleteCluster(clusterId);
	}

	public static com.osp.icebreaker.model.OSPCluster getCluster(long clusterId)
		throws com.liferay.portal.kernel.exception.PortalException {

		return getService().getCluster(clusterId);
	}

	public static com.osp.icebreaker.model.OSPCluster getCluster(
		String clusterName) {

		return getService().getCluster(clusterName);
	}

	/**
	 * Returns the OSGi service identifier.
	 *
	 * @return the OSGi service identifier
	 */
	public static String getOSGiServiceIdentifier() {
		return getService().getOSGiServiceIdentifier();
	}

	public static OSPClusterService getService() {
		return _serviceTracker.getService();
	}

	private static ServiceTracker<OSPClusterService, OSPClusterService>
		_serviceTracker;

	static {
		Bundle bundle = FrameworkUtil.getBundle(OSPClusterService.class);

		ServiceTracker<OSPClusterService, OSPClusterService> serviceTracker =
			new ServiceTracker<OSPClusterService, OSPClusterService>(
				bundle.getBundleContext(), OSPClusterService.class, null);

		serviceTracker.open();

		_serviceTracker = serviceTracker;
	}

}