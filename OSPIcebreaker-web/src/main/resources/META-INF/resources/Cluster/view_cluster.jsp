<%@ include file="../init.jsp"%>

<div class="container-fluid-1280">

	<h1>${cluster.getTitle(locale)}</h1>

	<h2><liferay-ui:message key="cluster-information" /></h2>
	
	<div class="cluster-metadata">

		<dl>
			<dt><liferay-ui:message key="created" /></dt>
			<dd>${createDate}</dd>
	
			<dt><liferay-ui:message key="created-by" /></dt>
			<dd>${assignment.userName}</dd>
	
			<dt><liferay-ui:message key="cluster-duedate" /></dt>
			<dd>${dueDate}</dd>
	
			<dt><liferay-ui:message key="description" /></dt>
			<dd>${cluster.getDescription(locale)}</dd>
		</dl>
	</div>
</div>