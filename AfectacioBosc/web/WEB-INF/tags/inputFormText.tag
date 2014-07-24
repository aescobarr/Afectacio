<%@ tag body-content="scriptless" %>
<%@ attribute name="etiqueta" required="true" %>
<%@ attribute name="path" required="true" %>
<%@ attribute name="tamany" required="false" %>
<%@ attribute name="tipus" required="false" %>
<%@ attribute name="identificador" required="false" %>
<%@ taglib uri="http://www.springframework.org/tags" prefix="spring" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<c:if test="${tipus==null}"><c:set var="tipus">text</c:set></c:if>
<c:if test="${tamany==null}"><c:set var="tamany">gran</c:set></c:if>
<c:if test="${identificador==null}"><c:set var="identificador">${status.expression}</c:set></c:if>
<div class="campformulari"><spring:bind path="${path}"><div class="etiqueta"><label for="${status.expression}" <c:if test="${status.error}"> class="error"</c:if>>${etiqueta}</label></div><div class="entradadades"><input  id="${identificador}" name="${status.expression}" type="${tipus}" class="${tamany}" value="${status.value}"/></div></spring:bind></div>