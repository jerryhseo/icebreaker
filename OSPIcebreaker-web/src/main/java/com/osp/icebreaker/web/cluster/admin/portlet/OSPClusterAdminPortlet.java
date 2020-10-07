package com.osp.icebreaker.web.cluster.admin.portlet;

import com.liferay.portal.kernel.dao.search.SearchContainer;
import com.liferay.portal.kernel.portlet.LiferayPortletRequest;
import com.liferay.portal.kernel.portlet.LiferayPortletResponse;
import com.liferay.portal.kernel.portlet.PortletURLUtil;
import com.liferay.portal.kernel.portlet.bridges.mvc.MVCPortlet;
import com.liferay.portal.kernel.util.ParamUtil;
import com.liferay.portal.kernel.util.PortalUtil;
import com.osp.icebreaker.constants.OSPIcebreakerWebPortletKeys;
import com.osp.icebreaker.model.OSPCluster;
import com.osp.icebreaker.service.OSPClusterLocalService;
import com.osp.icebreaker.service.OSPClusterLocalServiceUtil;
import com.osp.icebreaker.web.cluster.admin.portlet.toolbar.ClusterAdminToolbarDisplayContext;
import com.osp.icebreaker.web.constants.OSPIcebreakerWebDefaultValues;
import com.osp.icebreaker.web.constants.OSPIcebreakerWebJSPPaths;
import com.osp.icebreaker.web.constants.OSPIcebreakerWebMessageKeys;
import com.osp.icebreaker.web.constants.OSPIcebreakerWebParameterNames;

import java.io.IOException;
import java.util.List;

import javax.portlet.Portlet;
import javax.portlet.PortletException;
import javax.portlet.PortletURL;
import javax.portlet.RenderRequest;
import javax.portlet.RenderResponse;
import javax.servlet.http.HttpServletRequest;

import org.osgi.service.component.annotations.Component;
import org.osgi.service.component.annotations.Reference;

/**
 * @author DELL
 */
@Component(
	immediate = true,
	property = {
		"com.liferay.portlet.display-category=category.hidden",
		"com.liferay.portlet.header-portlet-css=/css/main.css",
		"com.liferay.portlet.instanceable=false",
		
		"javax.portlet.display-name=OSP Cluster Admin",
		"javax.portlet.init-param.template-path=/",
		"javax.portlet.init-param.view-template="+OSPIcebreakerWebJSPPaths.ADMIN_CLUSTERS_JSP,
		"javax.portlet.name=" + OSPIcebreakerWebPortletKeys.CLUSTERADMIN,
		"javax.portlet.resource-bundle=content.Language",
		"javax.portlet.security-role-ref=power-user,user"
	},
	service = Portlet.class
)
public class OSPClusterAdminPortlet extends MVCPortlet {

	@Override
	public void doView(RenderRequest renderRequest, RenderResponse renderResponse)
			throws IOException, PortletException {
		System.out.println("in AdminClustersRenderCommand ");
		
		String jspPath = OSPIcebreakerWebJSPPaths.ADMIN_CLUSTERS_JSP;
		String renderMessage = "";
		int itemsPerPage = OSPIcebreakerWebDefaultValues.DEFAULT_ITEMS_PER_PAGE;
		int pageNo = 0;
		int clustersCount = 0;
		List<OSPCluster> clustersList = null;
		String displayStyle = "";
		SearchContainer<OSPCluster> clusterSearchContainer = null;
		ClusterAdminToolbarDisplayContext clusterAdminToolbarDisplayContext = null;
		
		try{
			
			itemsPerPage = ParamUtil.getInteger(renderRequest, OSPIcebreakerWebParameterNames.ITEMS_PER_PAGE, OSPIcebreakerWebDefaultValues.DEFAULT_ITEMS_PER_PAGE);
			pageNo = ParamUtil.getInteger(renderRequest, OSPIcebreakerWebParameterNames.PAGE_NO, OSPIcebreakerWebDefaultValues.DEFAULT_PAGE_NO);
			clustersCount = OSPClusterLocalServiceUtil.countClusters();
			displayStyle = ParamUtil.getString(renderRequest, OSPIcebreakerWebParameterNames.DISPLAY_STYLE, "card");
			System.out.println("Display Style: "+displayStyle);
			
			int start = pageNo * itemsPerPage;
			int end = start + itemsPerPage;
			clustersList = _ospClusterLocalService.getClusters(start, end);
			
			PortletURL iteratorURL = PortletURLUtil.getCurrent(renderRequest, renderResponse);
			clusterSearchContainer = new  SearchContainer<OSPCluster>(renderRequest, iteratorURL, null, "nothing found");
			clusterSearchContainer.setResults(clustersList);
			clusterSearchContainer.setTotal(clustersCount);
			clusterSearchContainer.setDelta(itemsPerPage);
			clusterSearchContainer.setEmptyResultsMessage("No result");
			clusterSearchContainer.setId("cluster_search_container");
			
			HttpServletRequest request = PortalUtil.getHttpServletRequest(renderRequest);
			LiferayPortletRequest portletRequest = PortalUtil.getLiferayPortletRequest(renderRequest);
			LiferayPortletResponse portletResponse = PortalUtil.getLiferayPortletResponse(renderResponse);
			clusterAdminToolbarDisplayContext = new ClusterAdminToolbarDisplayContext(portletRequest, portletResponse, request, clusterSearchContainer);
		}catch(Exception e){
			renderMessage = OSPIcebreakerWebMessageKeys.AdminClustersRenderCommandFailed;
			jspPath = OSPIcebreakerWebJSPPaths.ERRORS_JSP;
		} finally {
			renderRequest.setAttribute( OSPIcebreakerWebParameterNames.RENDER_MESSAGE, renderMessage);
			renderRequest.setAttribute( OSPIcebreakerWebParameterNames.CLUSTERS_COUNT, clustersCount);
			renderRequest.setAttribute( OSPIcebreakerWebParameterNames.CLUSTERS_LIST, clustersList);
			renderRequest.setAttribute( OSPIcebreakerWebParameterNames.DISPLAY_STYLE, displayStyle);
			renderRequest.setAttribute( OSPIcebreakerWebParameterNames.CLUSTER_SEARCH_CONTAINER, clusterSearchContainer);
			renderRequest.setAttribute( OSPIcebreakerWebParameterNames.CLUSTER_DISPLAY_CONTEXT, clusterAdminToolbarDisplayContext);
		}
		
		super.doView(renderRequest, renderResponse);
	}
	
	private OSPClusterLocalService _ospClusterLocalService;
	@Reference(unbind = "-")
	protected void setOSPClusterLocalService(OSPClusterLocalService ospClusterLocalService) {
		_ospClusterLocalService = ospClusterLocalService;
	}		
	
}