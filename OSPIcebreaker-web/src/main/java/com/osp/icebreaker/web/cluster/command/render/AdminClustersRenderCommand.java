package com.osp.icebreaker.web.cluster.command.render;

import com.liferay.portal.kernel.portlet.bridges.mvc.MVCRenderCommand;
import com.liferay.portal.kernel.util.ParamUtil;
import com.osp.icebreaker.web.constants.DefaultValues;
import com.osp.icebreaker.web.constants.JspPaths;
import com.osp.icebreaker.web.constants.MVCCommandNames;
import com.osp.icebreaker.web.constants.MessageKeys;
import com.osp.icebreaker.constants.PortletKeys;
import com.osp.icebreaker.model.OSPCluster;
import com.osp.icebreaker.service.OSPClusterLocalService;
import com.osp.icebreaker.service.OSPClusterLocalServiceUtil;
import com.osp.icebreaker.web.constants.ParameterNames;

import java.util.List;

import javax.portlet.PortletException;
import javax.portlet.RenderRequest;
import javax.portlet.RenderResponse;

import org.osgi.service.component.annotations.Component;
import org.osgi.service.component.annotations.Reference;

@Component(
		 property = {
		 "javax.portlet.name=" + PortletKeys.OSPCLUSTERADMIN,
		 "mvc.command.name=" + MVCCommandNames.ADMIN_CLUSTERS
		 },
		 service = MVCRenderCommand.class
)
public class AdminClustersRenderCommand implements MVCRenderCommand {

	@Override
	public String render(RenderRequest renderRequest, RenderResponse renderResponse) throws PortletException {
		
		System.out.println("in AdminClustersRenderCommand ");
		
		String jspPath = JspPaths.ADMIN_CLUSTERS_JSP;
		String renderMessage = "";
		int itemsPerPage = DefaultValues.DEFAULT_ITEMS_PER_PAGE;
		int pageNo = 0;
		int clustersCount = 0;
		List<OSPCluster> clustersList = null;
		String displayStyle = "";
		
		try{
			itemsPerPage = ParamUtil.getInteger(renderRequest, ParameterNames.ITEMS_PER_PAGE, DefaultValues.DEFAULT_ITEMS_PER_PAGE);
			pageNo = ParamUtil.getInteger(renderRequest, ParameterNames.PAGE_NO, DefaultValues.DEFAULT_PAGE_NO);
			clustersCount = OSPClusterLocalServiceUtil.countClusters();
			displayStyle = ParamUtil.getString(renderRequest, ParameterNames.DISPLAY_STYLE, "");
			
			int start = pageNo * itemsPerPage;
			int end = start + itemsPerPage;
			clustersList = _ospClusterLocalService.getClusters(start, end);
			
		}catch(Exception e){
			renderMessage = MessageKeys.AdminClustersRenderCommandFailed;
			jspPath = JspPaths.ERRORS_JSP;
		} finally {
			renderRequest.setAttribute( ParameterNames.RENDER_MESSAGE, renderMessage);
			renderRequest.setAttribute( ParameterNames.CLUSTERS_COUNT, clustersCount);
			renderRequest.setAttribute( ParameterNames.CLUSTERS_LIST, clustersList);
			renderRequest.setAttribute( ParameterNames.DISPLAY_STYLE, displayStyle);
		}
		
		return jspPath;
	}
	
	private OSPClusterLocalService _ospClusterLocalService;
	@Reference(unbind = "-")
	protected void setOSPClusterLocalService(OSPClusterLocalService ospClusterLocalService) {
		_ospClusterLocalService = ospClusterLocalService;
	}

}
