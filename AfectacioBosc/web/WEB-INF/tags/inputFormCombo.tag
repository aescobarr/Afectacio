<%@ tag body-content="scriptless" %>
<%@ attribute name="etiqueta" required="true" %>
<%@ attribute name="tamany" required="true" %>
<%@ attribute name="path" required="true" %>
<%@ taglib uri="http://www.springframework.org/tags" prefix="spring" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<div class="campformulari"><spring:bind path="${path}"><div class="etiqueta"><label for="${status.expression}" <c:if test="${status.error}"> class="error"</c:if>>${etiqueta}</label></div><div class="entradadades"><select id="${status.expression}" name="${status.expression}" class="${tamany}"><option id="null" value="null"<c:if test="${objecteSeleccionat==null}"> selected</c:if>></option><c:forEach items="${llista}" var="element" varStatus="loopStatus"><c:choose><c:when test="${objecteSeleccionat!=null && objecteSeleccionat.idString==element.idString}"><option id="${element.idString}" value="${element.idString}" selected>${element}</option></c:when><c:otherwise><option id="${element.idString}" value="${element.idString}">${element}</option></c:otherwise></c:choose></c:forEach></select></div></spring:bind></div>