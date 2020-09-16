<%@page import="com.liferay.frontend.taglib.clay.servlet.taglib.util.JSPViewTypeItemList"%>
<%@page import="com.liferay.frontend.taglib.clay.servlet.taglib.util.JSPDropdownItemList"%>
<%@page import="com.liferay.frontend.taglib.clay.servlet.taglib.util.DropdownItemList"%>
<%@page import="com.osp.icebreaker.model.OSPCluster"%>
<%@page import="javax.portlet.PortletURL"%>
<%@page import="java.util.List"%>
<%@page import="com.osp.icebreaker.web.constants.ParameterNames"%>
<%@page import="com.liferay.portal.kernel.util.GetterUtil"%>
<%@page import="com.osp.icebreaker.web.constants.MVCCommandNames"%>
<%@ include file="../init.jsp"%>

<%
PortletURL portletURL = renderResponse.createRenderURL();
int clustersCount = GetterUtil.getInteger( renderRequest.getAttribute(ParameterNames.CLUSTERS_COUNT) );
List<OSPCluster> clustersList = (List<OSPCluster>)GetterUtil.getObject( renderRequest.getAttribute(ParameterNames.CLUSTERS_LIST) );
String displayStyle = GetterUtil.getString( renderRequest.getAttribute(ParameterNames.DISPLAY_STYLE) );
%>

<portlet:renderURL var="addClusterURL">
	<portlet:param name="mvcRenderCommand" value="<%= MVCCommandNames.EDIT_CLUSTER %>"></portlet:param>
</portlet:renderURL>

<%
%>
<div class="container-fluid-1280">

	<h1><liferay-ui:message key="registered-clusters" /></h1>
	
<liferay-frontend:management-bar
   includeCheckBox="<%= true %>"
   searchContainerId="trash"
>
   <liferay-frontend:management-bar-buttons>
       <liferay-frontend:management-bar-sidenav-toggler-button />

       <liferay-portlet:actionURL name="changeDisplayStyle"
       varImpl="changeDisplayStyleURL">
           <portlet:param name="redirect" value="<%= currentURL %>" />
       </liferay-portlet:actionURL>

       <liferay-frontend:management-bar-display-buttons
           displayViews='<%= new String[] {"descriptive", "icon",
           "list"} %>'
           portletURL="<%= changeDisplayStyleURL %>"
           selectedDisplayStyle="<%= trashDisplayContext.getDisplayStyle()
           %>"
       />
   </liferay-frontend:management-bar-buttons>

   <liferay-frontend:management-bar-filters>
       <liferay-frontend:management-bar-navigation
           navigationKeys='<%= new String[] {"all"} %>'
           portletURL="<%= trashDisplayContext.getPortletURL() %>"
       />

       <liferay-frontend:management-bar-sort
           orderByCol="<%= trashDisplayContext.getOrderByCol() %>"
           orderByType="<%= trashDisplayContext.getOrderByType() %>"
           orderColumns='<%= new String[] {"removed-date"} %>'
           portletURL="<%= trashDisplayContext.getPortletURL() %>"
       />
   </liferay-frontend:management-bar-filters>

   <liferay-frontend:management-bar-action-buttons>
       <liferay-frontend:management-bar-sidenav-toggler-button />

       <liferay-frontend:management-bar-button href="javascript:;"
       icon="trash" id="deleteSelectedEntries" label="delete" />
   </liferay-frontend:management-bar-action-buttons>
</liferay-frontend:management-bar>
</div>
