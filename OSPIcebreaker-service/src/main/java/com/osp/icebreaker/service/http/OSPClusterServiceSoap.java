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

package com.osp.icebreaker.service.http;

import com.liferay.portal.kernel.log.Log;
import com.liferay.portal.kernel.log.LogFactoryUtil;
import com.liferay.portal.kernel.util.LocalizationUtil;

import com.osp.icebreaker.service.OSPClusterServiceUtil;

import java.rmi.RemoteException;

import java.util.Locale;
import java.util.Map;

import org.osgi.annotation.versioning.ProviderType;

/**
 * Provides the SOAP utility for the
 * <code>OSPClusterServiceUtil</code> service
 * utility. The static methods of this class call the same methods of the
 * service utility. However, the signatures are different because it is
 * difficult for SOAP to support certain types.
 *
 * <p>
 * ServiceBuilder follows certain rules in translating the methods. For example,
 * if the method in the service utility returns a <code>java.util.List</code>,
 * that is translated to an array of
 * <code>com.osp.icebreaker.model.OSPClusterSoap</code>. If the method in the
 * service utility returns a
 * <code>com.osp.icebreaker.model.OSPCluster</code>, that is translated to a
 * <code>com.osp.icebreaker.model.OSPClusterSoap</code>. Methods that SOAP
 * cannot safely wire are skipped.
 * </p>
 *
 * <p>
 * The benefits of using the SOAP utility is that it is cross platform
 * compatible. SOAP allows different languages like Java, .NET, C++, PHP, and
 * even Perl, to call the generated services. One drawback of SOAP is that it is
 * slow because it needs to serialize all calls into a text format (XML).
 * </p>
 *
 * <p>
 * You can see a list of services at http://localhost:8080/api/axis. Set the
 * property <b>axis.servlet.hosts.allowed</b> in portal.properties to configure
 * security.
 * </p>
 *
 * <p>
 * The SOAP utility is only generated for remote services.
 * </p>
 *
 * @author Jerry H. Seo
 * @see OSPClusterServiceHttp
 * @generated
 */
@ProviderType
public class OSPClusterServiceSoap {

	public static com.osp.icebreaker.model.OSPClusterSoap addCluster(
			String clusterName,
			com.liferay.portal.kernel.service.ServiceContext sc)
		throws RemoteException {

		try {
			com.osp.icebreaker.model.OSPCluster returnValue =
				OSPClusterServiceUtil.addCluster(clusterName, sc);

			return com.osp.icebreaker.model.OSPClusterSoap.toSoapModel(
				returnValue);
		}
		catch (Exception e) {
			_log.error(e, e);

			throw new RemoteException(e.getMessage());
		}
	}

	public static com.osp.icebreaker.model.OSPClusterSoap addCluster(
			String clusterName, String osFamily, String osName,
			String osVersion, String appRootDir, String dataRootDir,
			String contentRootDir, String[] descriptionMapLanguageIds,
			String[] descriptionMapValues, String serverIp, String accessMethod,
			String sshPort, String authorizedId, String authorizedPassword,
			String schedulerName, String schedulerVersion,
			String schedulerClass,
			com.liferay.portal.kernel.service.ServiceContext sc)
		throws RemoteException {

		try {
			Map<Locale, String> descriptionMap =
				LocalizationUtil.getLocalizationMap(
					descriptionMapLanguageIds, descriptionMapValues);

			com.osp.icebreaker.model.OSPCluster returnValue =
				OSPClusterServiceUtil.addCluster(
					clusterName, osFamily, osName, osVersion, appRootDir,
					dataRootDir, contentRootDir, descriptionMap, serverIp,
					accessMethod, sshPort, authorizedId, authorizedPassword,
					schedulerName, schedulerVersion, schedulerClass, sc);

			return com.osp.icebreaker.model.OSPClusterSoap.toSoapModel(
				returnValue);
		}
		catch (Exception e) {
			_log.error(e, e);

			throw new RemoteException(e.getMessage());
		}
	}

	public static com.osp.icebreaker.model.OSPClusterSoap deleteCluster(
			long clusterId)
		throws RemoteException {

		try {
			com.osp.icebreaker.model.OSPCluster returnValue =
				OSPClusterServiceUtil.deleteCluster(clusterId);

			return com.osp.icebreaker.model.OSPClusterSoap.toSoapModel(
				returnValue);
		}
		catch (Exception e) {
			_log.error(e, e);

			throw new RemoteException(e.getMessage());
		}
	}

	public static com.osp.icebreaker.model.OSPClusterSoap updateCluster(
			long clusterId, com.liferay.portal.kernel.service.ServiceContext sc)
		throws RemoteException {

		try {
			com.osp.icebreaker.model.OSPCluster returnValue =
				OSPClusterServiceUtil.updateCluster(clusterId, sc);

			return com.osp.icebreaker.model.OSPClusterSoap.toSoapModel(
				returnValue);
		}
		catch (Exception e) {
			_log.error(e, e);

			throw new RemoteException(e.getMessage());
		}
	}

	public static com.osp.icebreaker.model.OSPClusterSoap getCluster(
			long clusterId)
		throws RemoteException {

		try {
			com.osp.icebreaker.model.OSPCluster returnValue =
				OSPClusterServiceUtil.getCluster(clusterId);

			return com.osp.icebreaker.model.OSPClusterSoap.toSoapModel(
				returnValue);
		}
		catch (Exception e) {
			_log.error(e, e);

			throw new RemoteException(e.getMessage());
		}
	}

	public static com.osp.icebreaker.model.OSPClusterSoap getCluster(
			String clusterName)
		throws RemoteException {

		try {
			com.osp.icebreaker.model.OSPCluster returnValue =
				OSPClusterServiceUtil.getCluster(clusterName);

			return com.osp.icebreaker.model.OSPClusterSoap.toSoapModel(
				returnValue);
		}
		catch (Exception e) {
			_log.error(e, e);

			throw new RemoteException(e.getMessage());
		}
	}

	private static Log _log = LogFactoryUtil.getLog(
		OSPClusterServiceSoap.class);

}