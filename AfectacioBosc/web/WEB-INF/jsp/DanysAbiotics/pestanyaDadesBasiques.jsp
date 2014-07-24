<div id="mapa">
    <div class="divmapa">
        <div id="map" class="mapafectacio"></div>
        <div class="anar_carto">
            <div id="container"></div>
        </div>
        <div class="anar_carto">
            <div class="element_anar_carto">
                <input type="button" id="botomoure" name="botomoure" class="botomoure" alt="<fmt:message key='moureMapa' bundle='${bundleAfectacio}' />"  onclick="javascript:toggleControl('moure');return false;"/>
                <input type="button" id="botozoomfinestra" name="botozoomfinestra" class="botozoomfinestra" alt="<fmt:message key='zoomFinestra' bundle='${bundleAfectacio}' />" onclick="javascript:toggleControl('zoom');return false;"/>
                <input type="button" id="botoinfo" name="botoinfo" class="botoinfo" alt="<fmt:message key='informacio' bundle='${bundleAfectacio}' />" onclick="javascript:toggleControl('info');return false;"/>
            </div>
            <% if (esEditable) {%>
            <div  class="element_anar_carto" id="controlToggle">
                <input type="button" id="botodigitalitzar" name="botodigitalitzar" class="botodigitalitzar" alt="<fmt:message key="digitalitzarPoligon" bundle="${bundleAfectacio}" />" onclick="javascript:toggleControl('polygon');return false;"/>
                <input type="button" id="botoesborrar" name="botoesborrar" class="botoesborrar" alt="<fmt:message key="esborrarElementMapa" bundle="${bundleAfectacio}" />" onclick="javascript:toggleControl('remove');return false;" />
            </div>
            <%}%>
            <div  class="element_anar_carto">
                <div id="coordenades"></div>
            </div>
        </div>
        <%@ include file="/WEB-INF/jsp/Estructura/filtregeo.jsp" %>
    </div>
</div>
<div class="diventradaDades">
<div class="bloc_dades_fitxa">
<h3>1.- <fmt:message key="identificacioLocalitzacio" bundle="${bundleAfectacio}" /></h3>
<c:set var="txtCodi">*&nbsp;<fmt:message key="codi" bundle="${bundleAfectacio}" />&nbsp;<fmt:message key="exempleCodiDanyMecanic" bundle="${bundleAfectacio}" />:</c:set>
<tag:inputFormText etiqueta="${txtCodi}" tamany="complet" path="codi" />
</div>
<div class="bloc_dades_fitxa">
<h3>2.- <fmt:message key="desenvolupamentReconeixement" bundle="${bundleAfectacio}" /></h3>
<h4>2.1.- <fmt:message key="dates" bundle="${bundleAfectacio}" /></h4>
<c:set var="txtDataApreciacioInicial"><fmt:message key="dataApreciacioInicial" bundle="${bundleAfectacio}" />:</c:set>
<tag:inputFormTextNoBind etiqueta="${txtDataApreciacioInicial}" tamany="complet" path="dataApreciacioInicial" valor="${afectacio.dataApreciacioInicial}"/>
<c:set var="txtDataDadesDefinitives"><fmt:message key="dataDadesDefinitives" bundle="${bundleAfectacio}" />:</c:set>
<tag:inputFormTextNoBind etiqueta="${txtDataDadesDefinitives}" tamany="complet" path="dataDadesDefinitives" valor="${afectacio.dataDadesDefinitives}"/>
<c:set var="txtDataValidacio"><fmt:message key="dataValidacio" bundle="${bundleAfectacio}" />:</c:set>
<tag:inputFormTextNoBind etiqueta="${txtDataValidacio}" tamany="complet" path="dataValidacio" valor="${afectacio.dataValidacio}"/>
</div>
<div class="bloc_dades_fitxa">
<h4>2.2.- <fmt:message key="nomOCodiIdentificadors" bundle="${bundleAfectacio}" /></h4>
<c:set var="txtNomEnginyer1"><fmt:message key="nomEnginyer1" bundle="${bundleAfectacio}" />:</c:set>
<tag:inputFormTextNoBind etiqueta="${txtNomEnginyer1}" tamany="complet" path="nomEnginyer1" valor="${afectacio.nomEnginyer1}"/>
<c:set var="txtNomEnginyer2"><fmt:message key="nomEnginyer2" bundle="${bundleAfectacio}" />:</c:set>
<tag:inputFormTextNoBind etiqueta="${txtNomEnginyer2}" tamany="complet" path="nomEnginyer2" valor="${afectacio.nomEnginyer2}"/>
<c:set var="txtCodiAgent1"><fmt:message key="codiAgent1" bundle="${bundleAfectacio}" />:</c:set>
<tag:inputFormTextNoBind etiqueta="${txtCodiAgent1}" tamany="complet" path="codiAgent1" valor="${afectacio.codiAgent1}"/>
<c:set var="txtCodiAgent2"><fmt:message key="codiAgent2" bundle="${bundleAfectacio}" />:</c:set>
<tag:inputFormTextNoBind etiqueta="${txtCodiAgent2}" tamany="complet" path="codiAgent2" valor="${afectacio.codiAgent2}"/>
</div>
<div class="bloc_dades_fitxa">
<h4>2.3.- <fmt:message key="excepcionalitatMeteorologica" bundle="${bundleAfectacio}" /></h4>
<p><fmt:message key="explicacioExcepcionalitatMeteorologica" bundle="${bundleAfectacio}" /></p>
<textarea id="excepcionalitatMeteorologica" name="excepcionalitatMeteorologica" rows="4" cols="103" class="columnaesquerra"></textarea>
<!--tag:inputFormTextareaNoBind etiqueta="" tamany="complet" path="excepcionalitatMeteorologica" valor="${afectacio.excepcionalitatMeteorologica}"/-->
</div>
<div class="bloc_dades_fitxa">
<h3>3.- <fmt:message key="tipusMostreig" bundle="${bundleAfectacio}" /></h3>
<c:set var="txtMostreigSistematic"><fmt:message key="mostreigSistematic" bundle="${bundleAfectacio}" />:</c:set>
<%  request.setAttribute("llista", request.getAttribute("siNo"));
    request.setAttribute("objecteSeleccionat", afectacio.getEsMostreigSistematicString());%>
<tag:inputFormComboNoBind etiqueta="${txtMostreigSistematic}" tamany="mitja" identificador="mostreigSistematic" />
<c:set var="txtObservacions"><fmt:message key="observacions" bundle="${bundleAfectacio}" />:</c:set>
<tag:inputFormTextarea etiqueta="${txtObservacions}" tamany="complet" path="observacionsMostreigSistematic" />
</div>
</div>