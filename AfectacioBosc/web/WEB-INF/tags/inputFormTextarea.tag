<%@ tag body-content="scriptless" %>
<%@ attribute name="etiqueta" required="true" %>
<%@ attribute name="tamany" required="true" %>
<%@ attribute name="path" required="true" %>
<%@ taglib uri="http://www.springframework.org/tags" prefix="spring" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<div class="campformulari"><spring:bind path="${path}"><div class="etiqueta"><label for="${status.expression}" <c:if test="${status.error}"> class="error"</c:if>>${etiqueta}</label></div><div class="entradadades"><textarea id="${status.expression}" name="${status.expression}" rows="4" class="${tamany}">${status.value}</textarea></div></spring:bind></div>