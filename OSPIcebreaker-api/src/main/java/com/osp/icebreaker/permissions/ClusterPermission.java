package com.osp.icebreaker.permissions;

import org.osgi.service.component.annotations.Component;
import org.osgi.service.component.annotations.Reference;

import com.osp.icebreaker.model.OSPCluster;
import com.osp.icebreaker.service.OSPClusterLocalService;
import com.liferay.portal.kernel.exception.PortalException;
import com.liferay.portal.kernel.exception.SystemException;
import com.liferay.portal.kernel.security.auth.PrincipalException;
import com.liferay.portal.kernel.security.permission.BaseModelPermissionChecker;
import com.liferay.portal.kernel.security.permission.PermissionChecker;

@Component(
	    immediate = true,
	    property = {
	    		"model.class.name=com.kisti.osp.icebreaker.model.OSPCluster"}
	)
public class ClusterPermission implements BaseModelPermissionChecker{
	@Reference(unbind = "-")
	protected void setOSPClusterLocalService(OSPClusterLocalService clusterLocalService) {
		_clusterLocalService = clusterLocalService;
	}
	
	@Override
	public void checkBaseModel( PermissionChecker permissionChecker, long groupId, long clusterId, String actionId) throws PortalException {
		check(permissionChecker, groupId, clusterId, actionId);
	}

    private static OSPClusterLocalService _clusterLocalService;
	
	public static void check(PermissionChecker permissionChecker, long entryId, String actionId) 
			throws PortalException, SystemException {

		if (!contains(permissionChecker, entryId, actionId)) {
			throw new PrincipalException();
		}
	}
	
	public static void check( PermissionChecker permissionChecker, long groupId, long clusterId, String actionId) 
			throws PortalException {

		if (!contains(permissionChecker, groupId, actionId)) {
			throw new PrincipalException.MustHavePermission(
					permissionChecker, 
					OSPCluster.class.getName(), 
					actionId);
		}
	}
	
	public static boolean contains(
			PermissionChecker permissionChecker, long groupId, long clusterId, String actionId) 
					throws PortalException {

		return IcebreakerModelPermission.contains(permissionChecker, groupId, actionId);
	}
	
	public static boolean contains( PermissionChecker permissionChecker, long clusterId, String actionId)
			throws PortalException, SystemException {

		OSPCluster cluster = _clusterLocalService.getOSPCluster(clusterId);
		return contains(permissionChecker, cluster, actionId);
	}

	public static boolean contains(PermissionChecker permissionChecker, OSPCluster cluster, String actionId) 
			throws PortalException, SystemException {

		return permissionChecker.hasPermission(
				cluster.getGroupId(), OSPCluster.class.getName(), cluster.getClusterId(), actionId);

	}
}
