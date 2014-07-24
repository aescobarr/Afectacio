<%@ tag body-content="scriptless" %>
<%@ attribute name="etiqueta" required="true" %>
<%@ attribute name="path" required="true" %>
<%@ attribute name="tamany" required="false" %>
<%@ attribute name="valor" required="false" %>
<%@ attribute name="onchange" required="false" %>
<%@ attribute name="info" required="false" %>
<%@ taglib uri="http://www.springframework.org/tags" prefix="spring" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<c:if test="${tipus==null}"><c:set var="tipus">text</c:set></c:if>
<c:if test="${tamany==null}"><c:set var="tamany">gran</c:set></c:if>
<div class="campformulari"><div class="etiqueta"><label for="${path}">${etiqueta}<c:if test="${info!=null}" ><a href="#${path}" class="botoinfo" title="${info}"> &nbsp;</a></c:if></label></div><div class="entradadades"><input  id="${path}" name="${path}" type="text" class="${tamany}" value="<c:if test="${valor!=null}">${valor}</c:if>" <c:if test="${onchange!=null}">onchange="${onchange}"</c:if> /></div></div>