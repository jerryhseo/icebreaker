package com.osp.icebreaker.web.cluster.toolbar;

import com.liferay.frontend.taglib.clay.servlet.taglib.display.context.SearchContainerManagementToolbarDisplayContext;
import com.liferay.portal.kernel.dao.search.SearchContainer;
import com.liferay.portal.kernel.portlet.LiferayPortletRequest;
import com.liferay.portal.kernel.portlet.LiferayPortletResponse;

import javax.servlet.http.HttpServletRequest;

public class ClustersManagementToolbarDisplayContext extends SearchContainerManagementToolbarDisplayContext {
	 public ClustersManagementToolbarDisplayContext(
				LiferayPortletRequest liferayPortletRequest,
				LiferayPortletResponse liferayPortletResponse,
				HttpServletRequest request, 
				SearchContainer searchContainer) {

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
