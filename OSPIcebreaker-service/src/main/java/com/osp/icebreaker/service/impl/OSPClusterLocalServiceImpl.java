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
import com.liferay.portal.kernel.util.OrderByComparator;
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

	public OSPCluster createCluster( String clusterName, ServiceContext sc) {
		long clusterId = super.counterLocalService.increment();
		
		OSPCluster cluster = super.createOSPCluster(clusterId);
		
		cluster.setClusterName(clusterName);
		
		Date now = new Date();
		
		cluster.setCompanyId(sc.getCompanyId());
		cluster.setGroupId(sc.getScopeGroupId());
		cluster.setUserId(sc.getUserId());
		cluster.setCreateDate(now);
		cluster.setModifiedDate(now);
		
		return cluster;
	}
	
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
					String accessMethod, 
					String sshPort, 
					String authorizedId, 
					String authorizedPassword, 
					String schedulerName, 
					String schedulerVersion, 
					String schedulerClass,
					ServiceContext sc) {
		
		OSPCluster cluster = createCluster( clusterName, sc );
		
		cluster.setOsFamily(osFamily);
		cluster.setOsName(osName);
		cluster.setOsVersion(osVersion);
		cluster.setAppRootDir(appRootDir);
		cluster.setDataRootDir(dataRootDir);
		cluster.setContentRootDir(contentRootDir);
		cluster.setDescriptionMap(descriptionMap);
		cluster.setServerIp(serverIp);
		cluster.setAccessMethod(accessMethod);
		cluster.setSshPort(sshPort);
		cluster.setAuthorizedId(authorizedId);
		cluster.setAuthorizedPassword(authorizedPassword);
		cluster.setSchedulerName(schedulerName);
		cluster.setSchedulerVersion(schedulerVersion);
		cluster.setSchedulerClass(schedulerClass);
		
		addCluster(cluster);
		
		return cluster;
	}
	
	public OSPCluster addCluster( OSPCluster cluster ) {
		
		super.addOSPCluster(cluster);
		
		return cluster;
	}
	
	public OSPCluster updateCluster( OSPCluster cluster) {
		return super.updateOSPCluster(cluster);
	}
	
	public OSPCluster removeCluster( long clusterId ) throws PortalException {
		return super.deleteOSPCluster(clusterId);
	}
	
	public OSPCluster removeCluster( String clusterName ) {
		OSPCluster cluster = super.ospClusterPersistence.fetchByClusterName(clusterName);
		
		return super.deleteOSPCluster(cluster);
	}

	public OSPCluster getCluster( String clusterName ) {
		return super.ospClusterPersistence.fetchByClusterName(clusterName);
	}
	
	public int countClusters() {
		return super.ospClusterPersistence.countAll();
	}
	
	public List<OSPCluster> getClusters() {
		return super.ospClusterPersistence.findAll();
	}
	
	public List<OSPCluster> getClusters(int start, int end) {
		return super.ospClusterPersistence.findAll(start, end);
	}

	public List<OSPCluster> getClusters(int start, int end, OrderByComparator<OSPCluster> orderByComparator) {
		return super.ospClusterPersistence.findAll(start, end, orderByComparator);
	}

	public List<OSPCluster> getClusters(int start, int end, OrderByComparator<OSPCluster> orderByComparator, boolean retrieveFromCache) {
		return super.ospClusterPersistence.findAll(start, end, orderByComparator, retrieveFromCache);
	}
	
	public OSPScheduler createOSPScheduler( String className, String user, String password, String ip, String port ){
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
			ctr = schedulerClass.getConstructor(String.class, String.class, String.class, String.class);
		} catch (NoSuchMethodException | SecurityException e) {
			e.printStackTrace();
		}
        // Finally create object of type Base and pass data to constructor.
        String[] arguments = {user, password, ip, port};
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
				cluster.getAuthorizedId(), 
				cluster.getAuthorizedPassword(), 
				cluster.getServerIp(), 
				cluster.getSshPort()
				);
	}


}