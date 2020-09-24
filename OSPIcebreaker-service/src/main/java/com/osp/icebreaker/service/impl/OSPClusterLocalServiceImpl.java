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
import com.liferay.portal.kernel.model.User;
import com.liferay.portal.kernel.service.ServiceContext;
import com.liferay.portal.kernel.util.OrderByComparator;
import com.liferay.portal.kernel.workflow.WorkflowConstants;
import com.osp.icebreaker.constants.OSPClusterIdentificationCommands;
import com.osp.icebreaker.constants.OSPClusterSecurityLevels;
import com.osp.icebreaker.exception.NoSuchOSPClusterException;
import com.osp.icebreaker.model.OSPCluster;
import com.osp.icebreaker.model.OSPScheduler;
import com.osp.icebreaker.service.base.OSPClusterLocalServiceBaseImpl;

import java.lang.reflect.Constructor;
import java.lang.reflect.InvocationTargetException;
import java.util.Date;
import java.util.List;
import java.util.Locale;
import java.util.Map;

import org.osgi.service.component.annotations.Component;

/**
 * The implementation of the osp cluster local service.
 *
 * <p>
 * All custom service methods should be put in this class. Whenever methods are added, rerun ServiceBuilder to copy their definitions into the <code>com.osp.icebreaker.service.OSPClusterLocalService</code> interface.
 *
 * <p>
 * This is a local service. Methods of this service will not have security checks based on the propagated JAAS credentials because this service can only be accessed from within the same VM.
 * </p>
 *
 * @author Jerry H. Seo
 * @see OSPClusterLocalServiceBaseImpl
 */
@Component(
	property = "model.class.name=com.osp.icebreaker.model.OSPCluster",
	service = AopService.class
)
public class OSPClusterLocalServiceImpl extends OSPClusterLocalServiceBaseImpl {

	public OSPCluster addCluster( 
					String clusterName,
					String osFamily, 
					String osName, 
					String osVersion, 
					String appRootDir, 
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
					ServiceContext sc) throws PortalException {
		
		long clusterId = super.counterLocalService.increment();
		OSPCluster cluster = super.createOSPCluster(clusterId);
		User user = super.userLocalService.getUser(sc.getUserId());
		Date now = new Date();
		
		cluster.setAttributes(
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
				WorkflowConstants.STATUS_APPROVED, 
				securityLevel.name(), 
				sc.getCompanyId(), 
				sc.getScopeGroupId(), 
				user.getUserId(), 
				user.getFullName(), 
				now, 
				now, 
				WorkflowConstants.STATUS_APPROVED);
		
		return super.ospClusterPersistence.update(cluster);
	}
	
	public OSPCluster updateCluster(
			long clusterId,
			String clusterName,
			String osFamily, 
			String osName, 
			String osVersion, 
			String appRootDir, 
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
			ServiceContext sc
			) throws PortalException {
		OSPCluster cluster = super.ospClusterPersistence.findByPrimaryKey(clusterId);

		cluster.setAttributes(
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
				cluster.getSchedulerStatus(), 
				securityLevel.name(), 
				cluster.getCompanyId(), 
				cluster.getGroupId(), 
				cluster.getUserId(), 
				cluster.getUserName(), 
				cluster.getCreateDate(), 
				new Date(), 
				cluster.getStatus());
		
		return super.ospClusterPersistence.update(cluster);
	}
	
	public OSPCluster removeCluster( long clusterId ) throws PortalException {
		return super.ospClusterPersistence.remove(clusterId);
	}
	
	public OSPCluster removeCluster( String clusterName ) {
		OSPCluster cluster = super.ospClusterPersistence.fetchByClusterName(clusterName);
		
		return super.ospClusterPersistence.remove(cluster);
	}

	public OSPCluster getCluster( String clusterName ) {
		return super.ospClusterPersistence.fetchByClusterName(clusterName);
	}
	
	public List<OSPCluster> getClusters() {
		return super.ospClusterPersistence.findAll();
	}
	public List<OSPCluster> getClusters(int start, int end) {
		return super.ospClusterPersistence.findAll(start, end);
	}
	public int countClusters() {
		return super.ospClusterPersistence.countAll();
	}

	/*
	public List<OSPCluster> getClusters(int start, int end, OrderByComparator<OSPCluster> orderByComparator) {
		return super.ospClusterPersistence.findAll(start, end, orderByComparator);
	}

	public List<OSPCluster> getClusters(int start, int end, OrderByComparator<OSPCluster> orderByComparator, boolean retrieveFromCache) {
		return super.ospClusterPersistence.findAll(start, end, orderByComparator, retrieveFromCache);
	}
	*/
	
	public OSPScheduler createOSPScheduler( String className,   String identificationCommand,  String accessMethod, String authorizedUserId,  String password, String ip, String port ){
        // Create class of type Base.
        Class<?> schedulerClass = null;
		try {
			schedulerClass = Class.forName(className);
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		}
        // Create constructor call with argument types.
        Constructor<?> ctr = null;
		try {
			ctr = schedulerClass.getConstructor(String.class, String.class, String.class, String.class, String.class, String.class);
		} catch (NoSuchMethodException | SecurityException e) {
			e.printStackTrace();
		}
        // Finally create object of type Base and pass data to constructor.
        String[] arguments = {authorizedUserId, identificationCommand,  accessMethod, password, ip, port};
        Object object = null;
		try {
			object = ctr.newInstance((Object[])arguments);
		} catch (InstantiationException | IllegalAccessException | IllegalArgumentException
		        | InvocationTargetException e) {
			e.printStackTrace();
		}
        // Type-cast and access the data from class Base.
        return (OSPScheduler)object;
	}
	
	public OSPScheduler createOSPScheduler( long clusterId ) throws PortalException{
		OSPCluster cluster = super.getOSPCluster(clusterId);
		
		return this.createOSPScheduler(
				cluster.getSchedulerClass(), 
				cluster.getIdentificationCommand(),
				cluster.getAccessMethod(),
				cluster.getAuthorizedId(), 
				cluster.getAuthorizedPassword(), 
				cluster.getServerIp(), 
				cluster.getSshPort()
				);
	}


}