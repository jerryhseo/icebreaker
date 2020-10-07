package com.osp.icebreaker.web.cluster.admin.portlet;

import com.liferay.application.list.BasePanelApp;
import com.liferay.application.list.PanelApp;
import com.liferay.portal.kernel.model.Portlet;
import com.osp.icebreaker.constants.OSPIcebreakerWebPortletKeys;

import org.osgi.service.component.annotations.Component;
import org.osgi.service.component.annotations.Reference;

@Component(
		 immediate = true,
		    property = {
		        "panel.app.order:Integer=200",
		        "panel.category.key=" + "OSPControlPanelCategoryIcebreaker"
		    },
		    service = PanelApp.class
)
public class OSPClusterAdminPanelApp extends BasePanelApp {

	@Override
	public String getPortletId() {
		return OSPIcebreakerWebPortletKeys.CLUSTERADMIN;
	}

	@Override
    @Reference(
        target = "(javax.portlet.name=" + OSPIcebreakerWebPortletKeys.CLUSTERADMIN + ")",
        unbind = "-"
    )
    public void setPortlet(Portlet portlet) {
        super.setPortlet(portlet);
    }
}
