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

package com.osp.icebreaker.service.impl;

import com.liferay.portal.aop.AopService;
import com.liferay.portal.kernel.exception.PortalException;
import com.liferay.portal.kernel.service.ServiceContext;
import com.osp.icebreaker.constants.OSPClusterSecurityLevels;
import com.osp.icebreaker.model.OSPCluster;
import com.osp.icebreaker.service.base.OSPClusterServiceBaseImpl;

import java.util.Locale;
import java.util.Map;

import org.osgi.service.component.annotations.Component;

/**
 * The implementation of the osp cluster remote service.
 *
 * <p>
 * All custom service methods should be put in this class. Whenever methods are added, rerun ServiceBuilder to copy their definitions into the <code>com.osp.icebreaker.service.OSPClusterService</code> interface.
 *
 * <p>
 * This is a remote service. Methods of this service are expected to have security checks based on the propagated JAAS credentials because this service can be accessed remotely.
 * </p>
 *
 * @author Jerry H. Seo
 * @see OSPClusterServiceBaseImpl
 */
@Component(
	property = {
		"json.web.service.context.name=icebreaker",
		"json.web.service.context.path=OSPCluster"
	},
	service = AopService.class
)
public class OSPClusterServiceImpl extends OSPClusterServiceBaseImpl {
	
	public OSPCluster addCluster( 
			String clusterName, 
			String osFamily, 
			String osName, 
			String osVersion, 
			String appRootDir, 
			String dataRootDir, 
			String contentRootDir, 
			Map<Locale, String> descriptionMap, 
			String serverIp, 
			String sshPort,
			String identificationCommand,
			String accessMethod, 
			String authorizedId, 
			String authorizedPassword, 
			String schedulerName, 
			String schedulerVersion, 
			String schedulerClass,
			OSPClusterSecurityLevels securityLevel,
			ServiceContext sc ) throws PortalException {
		
			return super.ospClusterLocalService.addCluster(
					clusterName,
					osFamily, 
					osName, 
					osVersion, 
					appRootDir, 
					descriptionMap, 
					serverIp, 
					sshPort,
					identificationCommand,
					accessMethod, 
					authorizedId, 
					authorizedPassword, 
					schedulerName, 
					schedulerVersion, 
					schedulerClass,
					securityLevel,
					sc);
	}

	public OSPCluster deleteCluster(long clusterId) throws PortalException{

		OSPCluster cluster = super.ospClusterLocalService.deleteOSPCluster(clusterId);

		return cluster;
	}
	
	public OSPCluster getCluster(long clusterId) throws PortalException{
		OSPCluster cluster = super.ospClusterLocalService.getOSPCluster(clusterId);

		return cluster;
	}

	public OSPCluster getCluster( String clusterName ) {
		OSPCluster cluster = super.ospClusterLocalService.getCluster(clusterName);
		return cluster;
	}
}