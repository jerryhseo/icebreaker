package com.osp.icebreaker.web.cluster.admin.portlet.command.render;

import com.liferay.portal.kernel.portlet.bridges.mvc.MVCRenderCommand;
import com.liferay.portal.kernel.util.ParamUtil;
import com.osp.icebreaker.web.constants.OSPIcebreakerWebDefaultValues;
import com.osp.icebreaker.web.constants.OSPIcebreakerWebJSPPaths;
import com.osp.icebreaker.web.constants.OSPIcebreakerWebMVCCommandNames;
import com.osp.icebreaker.web.constants.OSPIcebreakerWebMessageKeys;
import com.osp.icebreaker.constants.PortletKeys;
import com.osp.icebreaker.model.OSPCluster;
import com.osp.icebreaker.service.OSPClusterLocalService;
import com.osp.icebreaker.service.OSPClusterLocalServiceUtil;
import com.osp.icebreaker.web.constants.OSPIcebreakerWebParameterNames;

import java.util.List;

import javax.portlet.PortletException;
import javax.portlet.RenderRequest;
import javax.portlet.RenderResponse;

import org.osgi.service.component.annotations.Component;
import org.osgi.service.component.annotations.Reference;

@Component(
		 property = {
		 "javax.portlet.name=" + PortletKeys.OSPCLUSTERADMIN,
		 "mvc.command.name=" + OSPIcebreakerWebMVCCommandNames.ADMIN_CLUSTERS
		 },
		 service = MVCRenderCommand.class
)
public class AdminClustersRenderCommand implements MVCRenderCommand {

	@Override
	public String render(RenderRequest renderRequest, RenderResponse renderResponse) throws PortletException {
		
		System.out.println("in AdminClustersRenderCommand ");
		
		String jspPath = OSPIcebreakerWebJSPPaths.ADMIN_CLUSTERS_JSP;
		String renderMessage = "";
		int itemsPerPage = OSPIcebreakerWebDefaultValues.DEFAULT_ITEMS_PER_PAGE;
		int pageNo = 0;
		int clustersCount = 0;
		List<OSPCluster> clustersList = null;
		String displayStyle = "";
		
		try{
			itemsPerPage = ParamUtil.getInteger(renderRequest, OSPIcebreakerWebParameterNames.ITEMS_PER_PAGE, OSPIcebreakerWebDefaultValues.DEFAULT_ITEMS_PER_PAGE);
			pageNo = ParamUtil.getInteger(renderRequest, OSPIcebreakerWebParameterNames.PAGE_NO, OSPIcebreakerWebDefaultValues.DEFAULT_PAGE_NO);
			clustersCount = OSPClusterLocalServiceUtil.countClusters();
			displayStyle = ParamUtil.getString(renderRequest, OSPIcebreakerWebParameterNames.DISPLAY_STYLE, "");
			
			int start = pageNo * itemsPerPage;
			int end = start + itemsPerPage;
			clustersList = _ospClusterLocalService.getClusters(start, end);
			
		}catch(Exception e){
			renderMessage = OSPIcebreakerWebMessageKeys.AdminClustersRenderCommandFailed;
			jspPath = OSPIcebreakerWebJSPPaths.ERRORS_JSP;
		} finally {
			renderRequest.setAttribute( OSPIcebreakerWebParameterNames.RENDER_MESSAGE, renderMessage);
			renderRequest.setAttribute( OSPIcebreakerWebParameterNames.CLUSTERS_COUNT, clustersCount);
			renderRequest.setAttribute( OSPIcebreakerWebParameterNames.CLUSTERS_LIST, clustersList);
			renderRequest.setAttribute( OSPIcebreakerWebParameterNames.DISPLAY_STYLE, displayStyle);
		}
		
		return jspPath;
	}
	
	private OSPClusterLocalService _ospClusterLocalService;
	@Reference(unbind = "-")
	protected void setOSPClusterLocalService(OSPClusterLocalService ospClusterLocalService) {
		_ospClusterLocalService = ospClusterLocalService;
	}

}
