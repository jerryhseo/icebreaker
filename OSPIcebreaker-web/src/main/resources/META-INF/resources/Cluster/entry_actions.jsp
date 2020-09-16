<%@page import="com.osp.icebreaker.constants.MVCCommandNames"%>
<%@ include file="../init.jsp"%>

<c:set var="cluster" value="${SEARCH_CONTAINER_RESULT_ROW.object}" />

<liferay-ui:icon-menu markupView="lexicon">

	<%-- View action. --%>

	<portlet:renderURL var="viewClusterURL">
		<portlet:param name="mvcRenderCommandName"
			value="<%=MVCCommandNames.VIEW_CLUSTER %>" />
		<portlet:param name="redirect" value="${currentURL}" />
		<portlet:param name="clusterId" value="${cluster.clusterId}" />
	</portlet:renderURL>

	<liferay-ui:icon message="view" url="${viewClusterURL}" />

	<%-- Edit action. --%>
	
	<portlet:renderURL var="editClusterURL">
		<portlet:param name="mvcRenderCommandName"
			value="<%=MVCCommandNames.EDIT_CLUSTER %>" />
		<portlet:param name="redirect" value="${currentURL}" />
		<portlet:param name="clusterId" value="${cluster.clusterId}" />
	</portlet:renderURL>

	<liferay-ui:icon message="edit" url="${editClusterURL}" />	

	<%-- Delete action. --%>
	
	<portlet:actionURL name="<%=MVCCommandNames.DELETE_CLUSTER %>" var="deleteClusterURL">
		<portlet:param name="redirect" value="${currentURL}" />
		<portlet:param name="clusterId" value="${cluster.clusterId}" />
	</portlet:actionURL>

	<liferay-ui:icon-delete url="${deleteClusterURL}" />

</liferay-ui:icon-menu>