<%@page import="com.osp.icebreaker.web.constants.OSPIcebreakerWebMVCCommandNames"%>
<%@ include file="../init.jsp"%>

<portlet:renderURL var="addClusterURL">
	<portlet:param name="mvcRenderCommand" value="<%=OSPIcebreakerWebMVCCommandNames.EDIT_CLUSTER%>"></portlet:param>
</portlet:renderURL>

<div class="container-fluid-1280">

	<h1><liferay-ui:message key="registered-clusters" /></h1>
	
	<%-- Clay management toolbar. --%>

	
	<%-- Search container. --%>

	<liferay-ui:search-container 
		emptyResultsMessage="no-clusters"
		id="clusterEntries"
		iteratorURL="${portletURL}" 
		total="${clusterCount}">

		<liferay-ui:search-container-results results="${clusters}" />

		<liferay-ui:search-container-row
			className="com.osp.icebreaker.model.OSPCluster"
			modelVar="cluster">

			<%@ include file="jspf/entry_search_columns.jspf" %>

		</liferay-ui:search-container-row>
		
		<%-- Iterator / Paging --%>

		<liferay-ui:search-iterator 
			displayStyle="${clustersManagementToolbarDisplayContext.getDisplayStyle()}"
			markupView="lexicon" 
		/>
	</liferay-ui:search-container>
</div>
