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

package com.osp.icebreaker.model;

import com.liferay.portal.kernel.annotation.ImplementationClassName;
import com.liferay.portal.kernel.model.PersistedModel;
import com.liferay.portal.kernel.util.Accessor;

import org.osgi.annotation.versioning.ProviderType;

/**
 * The extended model interface for the OSPCluster service. Represents a row in the &quot;ICEBREAKER_OSPCluster&quot; database table, with each column mapped to a property of this class.
 *
 * @author Jerry H. Seo
 * @see OSPClusterModel
 * @generated
 */
@ImplementationClassName("com.osp.icebreaker.model.impl.OSPClusterImpl")
@ProviderType
public interface OSPCluster extends OSPClusterModel, PersistedModel {

	/*
	 * NOTE FOR DEVELOPERS:
	 *
	 * Never modify this interface directly. Add methods to <code>com.osp.icebreaker.model.impl.OSPClusterImpl</code> and rerun ServiceBuilder to automatically copy the method declarations to this interface.
	 */
	public static final Accessor<OSPCluster, String> UUID_ACCESSOR =
		new Accessor<OSPCluster, String>() {

			@Override
			public String get(OSPCluster ospCluster) {
				return ospCluster.getUuid();
			}

			@Override
			public Class<String> getAttributeClass() {
				return String.class;
			}

			@Override
			public Class<OSPCluster> getTypeClass() {
				return OSPCluster.class;
			}

		};

	public static final Accessor<OSPCluster, Long> CLUSTER_ID_ACCESSOR =
		new Accessor<OSPCluster, Long>() {

			@Override
			public Long get(OSPCluster ospCluster) {
				return ospCluster.getClusterId();
			}

			@Override
			public Class<Long> getAttributeClass() {
				return Long.class;
			}

			@Override
			public Class<OSPCluster> getTypeClass() {
				return OSPCluster.class;
			}

		};

	public void setAttributes(
		String clusterName, String osFamily, String osName, String osVersion,
		String appRootDir,
		java.util.Map<java.util.Locale, String> descriptionMap, String serverIp,
		String sshPort, String identificationCommand, String accessMethod,
		String authorizedId, String authorizedPassword, String schedulerName,
		String schedulerVersion, String schedulerClass, int schedulerStatus,
		String securityLevel, long companyId, long groupId, long userId,
		String userName, java.util.Date createDate, java.util.Date modifiedDate,
		int status);

}