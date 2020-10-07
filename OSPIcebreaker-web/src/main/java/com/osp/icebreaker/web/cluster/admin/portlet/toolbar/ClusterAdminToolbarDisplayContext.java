package com.osp.icebreaker.web.cluster.admin.portlet.toolbar;

import com.liferay.frontend.taglib.clay.servlet.taglib.display.context.SearchContainerManagementToolbarDisplayContext;
import com.liferay.portal.kernel.dao.search.SearchContainer;
import com.liferay.portal.kernel.portlet.LiferayPortletRequest;
import com.liferay.portal.kernel.portlet.LiferayPortletResponse;
import com.osp.icebreaker.model.OSPCluster;

import javax.servlet.http.HttpServletRequest;

public class ClusterAdminToolbarDisplayContext extends SearchContainerManagementToolbarDisplayContext {
	 public ClusterAdminToolbarDisplayContext(
				LiferayPortletRequest liferayPortletRequest,
				LiferayPortletResponse liferayPortletResponse,
				HttpServletRequest request, 
				SearchContainer<OSPCluster> searchContainer) {

		super(liferayPortletRequest, liferayPortletResponse, request, searchContainer);
	}
	 
	 @Override
	 protected String[] getNavigationKeys() {
	   return new String[] {"all"};
	 }
	 
	 @Override
	 protected String[] getOrderByKeys() {
	   return new String[] {"name", "items", "status"};
	 }
}
