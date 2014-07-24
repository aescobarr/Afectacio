<table class="estil1">
    <thead>
        <tr>
            <th align="left"><fmt:message key="documents" bundle="${bundleSIPAN}" /></th>
            <th align="left"><fmt:message key="observacions" bundle="${bundleSIPAN}" /></th>
            <th align="left"><fmt:message key="extensio" bundle="${bundleSIPAN}" /></th>
            <c:if test="${dades.editable=='true'}">
                <th class ="moltpetit" align="right"> <a class="inserir"  href="#" onclick="javascript:inserir()" ></a></th>
            </c:if>
        </tr>
    </thead>
    <tbody>
        <c:forEach items="${dades.documents}" var="elem">
            <tr>
                <td><a href="/SIPAN/docs/${elem.idString}.${elem.extensio}" onclick="javascript:visualitzarDocument('${elem.idString}')" >${elem}</a></td>
                <td><a href="#" onclick="javascript:visualitzarDocument('${elem.idString}')" >${elem.observacions}</a></td>
                <td><a href="#" onclick="javascript:visualitzarDocument('${elem.idString}')" >${elem.extensio}</a></td>
                <c:if test="${dades.editable=='true'}">
                    <td><ul class="links">
                            <li><a class="veure"  href="#" onclick="javascript:visualitzarDocument('${elem.idString}')" ></a></li>
                            <li><a class="editar"  href="#" onclick="javascript:editar('${elem.idString}')" ></a></li>
                    <li><a class="esborrar"  href="#" onclick="javascript:eliminar('${elem.idString}')" ></a></li></ul></td>
                </c:if>
            </tr>
        </c:forEach>
    </tbody>
</table>

