<%@ tag body-content="scriptless" %>
<%@ attribute name="name" required="true" %>
<%@ attribute name="titol" required="false" %>
<%@ taglib uri="http://www.springframework.org/tags" prefix="spring" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>


    <div id="errorsjavascript" class="quadreerrors">
        <h3>${titol}</h3>
        <ul id="llistaerrorsjavascript" class="errors">            
        </ul>
    </div>

    <spring:hasBindErrors name="${name}">
    <div class="quadreerrors">
        <ul id="errors" class="errors">
            <h3>${titol}</h3>
            <c:forEach items="${errors.allErrors}" var="error">
                <li><spring:message message="${error}" /></li>
            </c:forEach>
        </ul>
    </div>
    </spring:hasBindErrors>
    <div class="espaipetit"></div>
