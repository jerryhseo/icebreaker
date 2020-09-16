<%@page import="com.osp.icebreaker.constants.MVCCommandNames"%>
<%@ include file="../init.jsp"%>

 <%-- Generate add / edit action URL and set title. --%>

 <c:choose>
     <c:when test="${not empty cluster}">
         <portlet:actionURL var="clusterActionURL" name="<%=MVCCommandNames.EDIT_CLUSTER %>">
             <portlet:param name="redirect" value="${param.redirect}" />
         </portlet:actionURL>

         <c:set var="editTitle" value="edit-cluster"/>
     </c:when>
     <c:otherwise>
         <portlet:actionURL var="clusterActionURL" name="<%=MVCCommandNames.ADD_CLUSTER %>">
             <portlet:param name="redirect" value="${param.redirect}" />
         </portlet:actionURL>

         <c:set var="editTitle" value="add-cluster"/>
     </c:otherwise>
 </c:choose>

 <div class="container-fluid-1280 edit-cluster-entry">

     <h1><liferay-ui:message key="${editTitle}" /></h1>

     <aui:model-context bean="${cluster}" model="${clusterClass}" />

     <aui:form action="${clusterActionURL}" name="fm">

         <aui:input name="clusterId" field="clusterId" type="hidden" />

         <aui:fieldset-group markupView="lexicon">

             <aui:fieldset>

                 <%-- Title field. --%>

                 <aui:input name="cluterName">

                 </aui:input>

                 <%-- Description field. --%>

                 <aui:input name="description">
                     <aui:validator name="required" />
                 </aui:input>

                 <%-- Due date field. --%>

                 <aui:input name="dueDate">
                     <aui:validator name="required" />
                 </aui:input>
             </aui:fieldset>
         </aui:fieldset-group>

         <%-- Description for OS --%>
         <aui:fieldset-group markupView="lexicon">
             <aui:fieldset>
                 <aui:input name="osFamily">
                 	<aui:validator name="required" />
                 </aui:input>
                 <aui:input name="osName">
                     <aui:validator name="required" />
                 </aui:input>
                 <aui:input name="osVersion">
                     <aui:validator name="required" />
                 </aui:input>
             </aui:fieldset>
         </aui:fieldset-group>

         <%-- Description for Default Path --%>
         <aui:fieldset-group markupView="lexicon">
             <aui:fieldset>
                 <aui:input name="appRootDir">
                 	<aui:validator name="required" />
                 </aui:input>
                 <aui:input name="dataRootDir">
                     <aui:validator name="required" />
                 </aui:input>
                 <aui:input name="contentRootDir">
                 </aui:input>
             </aui:fieldset>
         </aui:fieldset-group>

         <%-- Description for Server --%>
         <aui:fieldset-group markupView="lexicon">
             <aui:fieldset>
                 <aui:input name="serverIp">
                 	<aui:validator name="required" />
                 </aui:input>
                 <aui:input name="sshPort">
                     <aui:validator name="required" />
                 </aui:input>
                 <aui:input name="authorizedId">
                     <aui:validator name="required" />
                 </aui:input>
                 <aui:input name="authorizedPassword">
                     <aui:validator name="required" />
                 </aui:input>
                 <aui:select name="accessMethod">
                 	<aui:option value="ssh">SSH</aui:option>
                 	<aui:option value="api">API</aui:option>
                    <aui:option value="url">URL</aui:option>
                 </aui:select>
             </aui:fieldset>
         </aui:fieldset-group>

         <%-- Description for Scheduler --%>
         <aui:fieldset-group markupView="lexicon">
             <aui:fieldset>
                 <aui:input name="schedulerName">
                 	<aui:validator name="required" />
                 </aui:input>
                 <aui:input name="schedulerVersion">
                     <aui:validator name="required" />
                 </aui:input>
                 <aui:input name="schedulerClass">
                     <aui:validator name="required" />
                 </aui:input>
             </aui:fieldset>
         </aui:fieldset-group>

         <%--Buttons. --%>

         <aui:button-row>
             <aui:button cssClass="btn btn-primary" type="submit" />
             <aui:button cssClass="btn btn-secondary" onClick="${param.redirect}" type="cancel" />
         </aui:button-row>
     </aui:form>

 </div>