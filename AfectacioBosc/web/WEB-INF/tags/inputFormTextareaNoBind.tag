<%@ tag body-content="scriptless" %>
<%@ attribute name="etiqueta" required="true" %>
<%@ attribute name="tamany" required="true" %>
<%@ attribute name="path" required="true" %>
<%@ attribute name="valor" required="false" %>
<%@ attribute name="rows" required="false" %>
<%@ taglib uri="http://www.springframework.org/tags" prefix="spring" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<c:if test="${rows==null}"><c:set var="rows">4</c:set></c:if>
<div class="campformulari"><div class="etiqueta"><label for="${path}">${etiqueta}</label></div><div class="entradadades"><textarea id="${path}" name="${path}" rows="${rows}" class="${tamany}">${valor}</textarea></div></div>