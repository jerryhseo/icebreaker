package com.osp.icebreaker.web.cluster.display.portlet;

import com.liferay.portal.kernel.portlet.bridges.mvc.MVCPortlet;
import com.osp.icebreaker.constants.OSPIcebreakerWebPortletKeys;
import com.osp.icebreaker.web.constants.OSPIcebreakerWebJSPPaths;

import javax.portlet.Portlet;

import org.osgi.service.component.annotations.Component;

@Component(
		immediate = true,
		property = {
			"com.liferay.portlet.display-category=category.osp",
			"com.liferay.portlet.header-portlet-css=/css/main.css",
			"com.liferay.portlet.instanceable=false",
			
			"javax.portlet.display-name=OSP Cluster Display",
			"javax.portlet.init-param.template-path=/",
			"javax.portlet.init-param.view-template="+OSPIcebreakerWebJSPPaths.DISPLAY_CLUSTERS_JSP,
			"javax.portlet.name=" + OSPIcebreakerWebPortletKeys.CLUSTERDISPLAY,
			"javax.portlet.resource-bundle=content.Language",
			"javax.portlet.security-role-ref=power-user,user"
		},
		service = Portlet.class
	)
public class OSPClustersDisplayPortlet extends MVCPortlet {

}
