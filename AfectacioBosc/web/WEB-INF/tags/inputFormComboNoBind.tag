<%@ tag body-content="scriptless" %>
<%@ attribute name="etiqueta" required="true" %>
<%@ attribute name="tamany" required="true" %>
<%@ attribute name="identificador" required="true" %>
<%@ attribute name="senseElementBuit" required="false" %>
<%@ attribute name="iconaEspera" required="false" %>
<%@ attribute name="onchange" required="false" %>
<%@ taglib uri="http://www.springframework.org/tags" prefix="spring" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<div class="campformulari"><div class="etiqueta"><label for="${identificador}select">${etiqueta}</label></div><div class="entradadades"><input type="hidden" id="id${identificador}" name="id${identificador}" value="${objecteSeleccionat.idString}" /><select id="${identificador}select" name="${identificador}select" class="${tamany}" onchange="javascript:document.getElementById('id${identificador}').value=document.getElementById('${identificador}select').value;<c:if test="${onchange!=null}">${onchange}</c:if>"><c:if test="${senseElementBuit!='true'}"><option id="null" value="null" <c:if test="${objecteSeleccionat==null}">selected</c:if>></option></c:if><c:forEach items="${llista}" var="element" varStatus="loopStatus"><c:choose><c:when test="${objecteSeleccionat!=null && objecteSeleccionat.idString==element.idString}"><option id="${element.idString}" value="${element.idString}" selected>${element}</option></c:when><c:otherwise><option id="${element.idString}" value="${element.idString}">${element}</option></c:otherwise></c:choose></c:forEach></select><c:if test="${iconaEspera=='S'}"><img style="visibility:hidden" id="${identificador}IconaEspera" src="<c:url value='/grafics/indicator.white.gif'/>" width="16" height="16" alt="indicator.white"/></c:if></div></div>