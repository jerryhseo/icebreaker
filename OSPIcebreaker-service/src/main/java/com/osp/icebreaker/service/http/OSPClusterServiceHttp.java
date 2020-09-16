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
import com.liferay.portal.kernel.security.auth.HttpPrincipal;
import com.liferay.portal.kernel.service.http.TunnelUtil;
import com.liferay.portal.kernel.util.MethodHandler;
import com.liferay.portal.kernel.util.MethodKey;

import com.osp.icebreaker.service.OSPClusterServiceUtil;

import org.osgi.annotation.versioning.ProviderType;

/**
 * Provides the HTTP utility for the
 * <code>OSPClusterServiceUtil</code> service
 * utility. The
 * static methods of this class calls the same methods of the service utility.
 * However, the signatures are different because it requires an additional
 * <code>HttpPrincipal</code> parameter.
 *
 * <p>
 * The benefits of using the HTTP utility is that it is fast and allows for
 * tunneling without the cost of serializing to text. The drawback is that it
 * only works with Java.
 * </p>
 *
 * <p>
 * Set the property <b>tunnel.servlet.hosts.allowed</b> in portal.properties to
 * configure security.
 * </p>
 *
 * <p>
 * The HTTP utility is only generated for remote services.
 * </p>
 *
 * @author Jerry H. Seo
 * @see OSPClusterServiceSoap
 * @generated
 */
@ProviderType
public class OSPClusterServiceHttp {

	public static com.osp.icebreaker.model.OSPCluster addCluster(
		HttpPrincipal httpPrincipal, String clusterName,
		com.liferay.portal.kernel.service.ServiceContext sc) {

		try {
			MethodKey methodKey = new MethodKey(
				OSPClusterServiceUtil.class, "addCluster",
				_addClusterParameterTypes0);

			MethodHandler methodHandler = new MethodHandler(
				methodKey, clusterName, sc);

			Object returnObj = null;

			try {
				returnObj = TunnelUtil.invoke(httpPrincipal, methodHandler);
			}
			catch (Exception e) {
				throw new com.liferay.portal.kernel.exception.SystemException(
					e);
			}

			return (com.osp.icebreaker.model.OSPCluster)returnObj;
		}
		catch (com.liferay.portal.kernel.exception.SystemException se) {
			_log.error(se, se);

			throw se;
		}
	}

	public static com.osp.icebreaker.model.OSPCluster addCluster(
		HttpPrincipal httpPrincipal, String clusterName, String osFamily,
		String osName, String osVersion, String appRootDir, String dataRootDir,
		String contentRootDir,
		java.util.Map<java.util.Locale, String> descriptionMap, String serverIp,
		String accessMethod, String sshPort, String authorizedId,
		String authorizedPassword, String schedulerName,
		String schedulerVersion, String schedulerClass,
		com.liferay.portal.kernel.service.ServiceContext sc) {

		try {
			MethodKey methodKey = new MethodKey(
				OSPClusterServiceUtil.class, "addCluster",
				_addClusterParameterTypes1);

			MethodHandler methodHandler = new MethodHandler(
				methodKey, clusterName, osFamily, osName, osVersion, appRootDir,
				dataRootDir, contentRootDir, descriptionMap, serverIp,
				accessMethod, sshPort, authorizedId, authorizedPassword,
				schedulerName, schedulerVersion, schedulerClass, sc);

			Object returnObj = null;

			try {
				returnObj = TunnelUtil.invoke(httpPrincipal, methodHandler);
			}
			catch (Exception e) {
				throw new com.liferay.portal.kernel.exception.SystemException(
					e);
			}

			return (com.osp.icebreaker.model.OSPCluster)returnObj;
		}
		catch (com.liferay.portal.kernel.exception.SystemException se) {
			_log.error(se, se);

			throw se;
		}
	}

	public static com.osp.icebreaker.model.OSPCluster deleteCluster(
			HttpPrincipal httpPrincipal, long clusterId)
		throws com.liferay.portal.kernel.exception.PortalException {

		try {
			MethodKey methodKey = new MethodKey(
				OSPClusterServiceUtil.class, "deleteCluster",
				_deleteClusterParameterTypes2);

			MethodHandler methodHandler = new MethodHandler(
				methodKey, clusterId);

			Object returnObj = null;

			try {
				returnObj = TunnelUtil.invoke(httpPrincipal, methodHandler);
			}
			catch (Exception e) {
				if (e instanceof
						com.liferay.portal.kernel.exception.PortalException) {

					throw (com.liferay.portal.kernel.exception.PortalException)
						e;
				}

				throw new com.liferay.portal.kernel.exception.SystemException(
					e);
			}

			return (com.osp.icebreaker.model.OSPCluster)returnObj;
		}
		catch (com.liferay.portal.kernel.exception.SystemException se) {
			_log.error(se, se);

			throw se;
		}
	}

	public static com.osp.icebreaker.model.OSPCluster updateCluster(
			HttpPrincipal httpPrincipal, long clusterId,
			com.liferay.portal.kernel.service.ServiceContext sc)
		throws com.liferay.portal.kernel.exception.PortalException {

		try {
			MethodKey methodKey = new MethodKey(
				OSPClusterServiceUtil.class, "updateCluster",
				_updateClusterParameterTypes3);

			MethodHandler methodHandler = new MethodHandler(
				methodKey, clusterId, sc);

			Object returnObj = null;

			try {
				returnObj = TunnelUtil.invoke(httpPrincipal, methodHandler);
			}
			catch (Exception e) {
				if (e instanceof
						com.liferay.portal.kernel.exception.PortalException) {

					throw (com.liferay.portal.kernel.exception.PortalException)
						e;
				}

				throw new com.liferay.portal.kernel.exception.SystemException(
					e);
			}

			return (com.osp.icebreaker.model.OSPCluster)returnObj;
		}
		catch (com.liferay.portal.kernel.exception.SystemException se) {
			_log.error(se, se);

			throw se;
		}
	}

	public static com.osp.icebreaker.model.OSPCluster getCluster(
			HttpPrincipal httpPrincipal, long clusterId)
		throws com.liferay.portal.kernel.exception.PortalException {

		try {
			MethodKey methodKey = new MethodKey(
				OSPClusterServiceUtil.class, "getCluster",
				_getClusterParameterTypes4);

			MethodHandler methodHandler = new MethodHandler(
				methodKey, clusterId);

			Object returnObj = null;

			try {
				returnObj = TunnelUtil.invoke(httpPrincipal, methodHandler);
			}
			catch (Exception e) {
				if (e instanceof
						com.liferay.portal.kernel.exception.PortalException) {

					throw (com.liferay.portal.kernel.exception.PortalException)
						e;
				}

				throw new com.liferay.portal.kernel.exception.SystemException(
					e);
			}

			return (com.osp.icebreaker.model.OSPCluster)returnObj;
		}
		catch (com.liferay.portal.kernel.exception.SystemException se) {
			_log.error(se, se);

			throw se;
		}
	}

	public static com.osp.icebreaker.model.OSPCluster getCluster(
		HttpPrincipal httpPrincipal, String clusterName) {

		try {
			MethodKey methodKey = new MethodKey(
				OSPClusterServiceUtil.class, "getCluster",
				_getClusterParameterTypes5);

			MethodHandler methodHandler = new MethodHandler(
				methodKey, clusterName);

			Object returnObj = null;

			try {
				returnObj = TunnelUtil.invoke(httpPrincipal, methodHandler);
			}
			catch (Exception e) {
				throw new com.liferay.portal.kernel.exception.SystemException(
					e);
			}

			return (com.osp.icebreaker.model.OSPCluster)returnObj;
		}
		catch (com.liferay.portal.kernel.exception.SystemException se) {
			_log.error(se, se);

			throw se;
		}
	}

	private static Log _log = LogFactoryUtil.getLog(
		OSPClusterServiceHttp.class);

	private static final Class<?>[] _addClusterParameterTypes0 = new Class[] {
		String.class, com.liferay.portal.kernel.service.ServiceContext.class
	};
	private static final Class<?>[] _addClusterParameterTypes1 = new Class[] {
		String.class, String.class, String.class, String.class, String.class,
		String.class, String.class, java.util.Map.class, String.class,
		String.class, String.class, String.class, String.class, String.class,
		String.class, String.class,
		com.liferay.portal.kernel.service.ServiceContext.class
	};
	private static final Class<?>[] _deleteClusterParameterTypes2 =
		new Class[] {long.class};
	private static final Class<?>[] _updateClusterParameterTypes3 =
		new Class[] {
			long.class, com.liferay.portal.kernel.service.ServiceContext.class
		};
	private static final Class<?>[] _getClusterParameterTypes4 = new Class[] {
		long.class
	};
	private static final Class<?>[] _getClusterParameterTypes5 = new Class[] {
		String.class
	};

}