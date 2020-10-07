<%@page import="com.liferay.frontend.taglib.clay.servlet.taglib.util.JSPDropdownItemList"%>
<%@page import="com.liferay.portal.kernel.util.PortalUtil"%>
<%@page import="com.osp.icebreaker.web.cluster.admin.portlet.command.render.AdminClustersRenderCommand"%>
<%@page import="com.liferay.portal.kernel.util.Validator"%>
<%@page import="com.osp.icebreaker.web.cluster.admin.portlet.toolbar.ClusterAdminToolbarDisplayContext"%>
<%@page import="com.liferay.portal.kernel.dao.search.SearchContainer"%>
<%@page import="com.liferay.portal.kernel.portlet.LiferayPortletResponse"%>
<%@page import="com.osp.icebreaker.web.constants.OSPIcebreakerWebMVCCommandNames"%>
<%@page import="com.liferay.portal.kernel.util.ParamUtil"%>
<%@page import="com.osp.icebreaker.model.OSPCluster"%>
<%@page import="java.util.List"%>
<%@page import="com.osp.icebreaker.web.constants.OSPIcebreakerWebParameterNames"%>
<%@page import="com.liferay.portal.kernel.util.GetterUtil"%>
<%@page import="javax.portlet.PortletURL"%>
<%@page import="com.liferay.portal.kernel.language.LanguageUtil"%>
<%@ include file="../../init.jsp"%>

<%
	PortletURL portletURL = renderResponse.createRenderURL();
int clustersCount = GetterUtil.getInteger( renderRequest.getAttribute(OSPIcebreakerWebParameterNames.CLUSTERS_COUNT) );
List<OSPCluster> clustersList = (List<OSPCluster>)GetterUtil.getObject( renderRequest.getAttribute(OSPIcebreakerWebParameterNames.CLUSTERS_LIST) );
String displayStyle = ParamUtil.getString( request, OSPIcebreakerWebParameterNames.DISPLAY_STYLE, "" );
out.println("Display Style: "+displayStyle );
SearchContainer<OSPCluster> clusterSearchContainer = (SearchContainer<OSPCluster>)request.getAttribute(OSPIcebreakerWebParameterNames.CLUSTER_SEARCH_CONTAINER);
ClusterAdminToolbarDisplayContext clusterAdminToolbarDisplayContext =
(ClusterAdminToolbarDisplayContext)request.getAttribute(OSPIcebreakerWebParameterNames.CLUSTER_DISPLAY_CONTEXT);

String mvcRenderCommand = ParamUtil.getString(request, "mvcRenderCommand");
out.println("MVC Render Command: "+ mvcRenderCommand );

%>

<portlet:renderURL var="adminClustersRenderURL">
	<portlet:param name="mvcRenderCommand" value="<%=OSPIcebreakerWebMVCCommandNames.ADMIN_CLUSTERS%>"></portlet:param>
</portlet:renderURL>

<portlet:renderURL var="addClusterRenderURL">
	<portlet:param name="mvcRenderCommand" value="<%=OSPIcebreakerWebMVCCommandNames.EDIT_CLUSTER%>"></portlet:param>
</portlet:renderURL>
	
<h1> Clusters </h1>

<liferay-frontend:management-bar
			includeCheckBox="<%= true %>"
			searchContainerId="cluster_search_container"
>
	<liferay-frontend:management-bar-sidenav-toggler-button />
	<liferay-portlet:actionURL name="changeDisplayStyle" varImpl="changeDisplayStyleURL">
		<portlet:param name="redirect" value="<%= currentURL %>" />
	</liferay-portlet:actionURL>
	
	<liferay-frontend:management-bar-buttons>
		<liferay-frontend:add-menu inline="<%= true %>">
			<liferay-frontend:add-menu-item
						title='<%= LanguageUtil.get(request, "add-cluster-entry") %>'
						url="<%= addClusterRenderURL %>"
			/>
		</liferay-frontend:add-menu>
	</liferay-frontend:management-bar-buttons>
</liferay-frontend:management-bar>


<%
	PortletURL iteratorURL = renderResponse.createRenderURL();
%>



<liferay-ui:search-container
		searchContainer="<%= clusterSearchContainer %>"
		id="cluster_search_container"
		iteratorURL="<%= iteratorURL %>"
>
		<liferay-ui:search-container-row className="com.osp.icebreaker.model.OSPCluster" modelVar="cluster">
			<liferay-ui:search-container-column-text name="clusterName" value="<%= cluster.getClusterName() %>" />
		</liferay-ui:search-container-row>
		<liferay-ui:search-iterator />
</liferay-ui:search-container>
