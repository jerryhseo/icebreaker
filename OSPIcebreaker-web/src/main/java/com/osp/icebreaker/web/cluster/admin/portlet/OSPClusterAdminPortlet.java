package com.osp.icebreaker.web.cluster.admin.portlet;

import com.liferay.portal.kernel.portlet.bridges.mvc.MVCPortlet;
import com.osp.icebreaker.constants.PortletKeys;
import com.osp.icebreaker.web.constants.OSPIcebreakerWebJSPPaths;

import javax.portlet.Portlet;

import org.osgi.service.component.annotations.Component;

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
		"javax.portlet.name=" + PortletKeys.OSPCLUSTERADMIN,
		"javax.portlet.resource-bundle=content.Language",
		"javax.portlet.security-role-ref=power-user,user"
	},
	service = Portlet.class
)
public class OSPClusterAdminPortlet extends MVCPortlet {
}