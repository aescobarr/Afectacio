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
<h3><fmt:message key="identificacioLocalitzacio" bundle="${bundleAfectacio}" /></h3>
<c:set var="txtCodi">*&nbsp;<fmt:message key="codi" bundle="${bundleAfectacio}" />&nbsp;<fmt:message key="exempleCodiDanyMecanic" bundle="${bundleAfectacio}" /></c:set>
<tag:inputFormText etiqueta="${txtCodi}" tamany="complet" path="codi" />
</div>
<div class="bloc_dades_fitxa">
<h3><fmt:message key="desenvolupamentMostreig" bundle="${bundleAfectacio}" /></h3>
<c:set var="txtData">*&nbsp;<fmt:message key="dataMostreig" bundle="${bundleAfectacio}" /></c:set>
<tag:inputFormText etiqueta="${txtData}" tamany="complet" path="data"/>
<c:set var="txtDataEpisodi"><fmt:message key="dataEpisodi" bundle="${bundleAfectacio}" /></c:set>
<tag:inputFormText etiqueta="${txtDataEpisodi}" tamany="complet" path="dataEpisodi"/>
<c:set var="txtCodiAgent1">*&nbsp;<fmt:message key="codiAgent1" bundle="${bundleAfectacio}" /></c:set>
<tag:inputFormText etiqueta="${txtCodiAgent1}" tamany="complet" path="codiAgent1"/>
<c:set var="txtCodiAgent2">*&nbsp;<fmt:message key="codiAgent2" bundle="${bundleAfectacio}" /></c:set>
<tag:inputFormText etiqueta="${txtCodiAgent2}" tamany="complet" path="codiAgent2"/>
</div>
<div class="bloc_dades_fitxa">
<h3><fmt:message key="caracteristiquesGeneralsZonaAfectada" bundle="${bundleAfectacio}" /></h3>
<%
     request.setAttribute("llista", request.getAttribute("grausinfestacio"));
     request.setAttribute("objecteSeleccionat", afectacio.getGrauInfestacio());
%>
<c:set var="txtGrau">*&nbsp;<fmt:message key="grauAfectacioXarxaCamins" bundle="${bundleAfectacio}" /></c:set>
<tag:inputFormCombo etiqueta="${txtGrau}"  tamany="complet" path="grauInfestacio" />
<fmt:message key="descripcioGrausInfestacio" bundle="${bundleAfectacio}" />
</div>
<div class="bloc_dades_fitxa">
<h3><fmt:message key="afectacioGeneral" bundle="${bundleAfectacio}" /></h3>
<fmt:message key="descripcioAfectacioGeneral" bundle="${bundleAfectacio}" />
<div id="dadesestimacions" class="scroll campformulari">
    <div class="scroll tauladadesestimacions">
    <input class="linkAfegir" type="button" id="afegirestimacio" name="afegirestimacio" value="<fmt:message key='afegir' bundle='${bundleSIPAN}' />" />
    <div id="taulaestimacions"></div>
    <input type="hidden" id="idsDadesEstimacions" name="idsDadesEstimacions" value="" />
    </div>
</div>
<div class="bloc_dades_fitxa">
    <h3><fmt:message key="causaEpisodiDecaiment" bundle="${bundleAfectacio}" /></h3>
    <div>
        <%
        java.util.List causes = (java.util.List)request.getAttribute("causesDecaiment");
        for(int i=0;i<causes.size();i++){
            cat.creaf.afectaciobosc.model.CausaDecaiment element = (cat.creaf.afectaciobosc.model.CausaDecaiment)causes.get(i);%>
            <input type="checkbox" id="CAUSADECAIMENT_<%=i%>" name="CAUSADECAIMENT_<%=i%>" value="<%=element.getIdString()%>"
            <%if(afectacio.getCausesDecaiment().contains(element)){%>
                checked
            <%}%>
             />
            <label for="CAUSADECAIMENT_<%=i%>"><%=element%></label>
            <%if(i%4==0){ out.println("<br/>"); }%>
        <%}%>
    </div>
    <fmt:message key="indicarCausaAObservacions" bundle="${bundleAfectacio}" />
</div>
<c:set var="txtObservacions"><fmt:message key="observacions" bundle="${bundleAfectacio}" /></c:set>
<tag:inputFormTextarea etiqueta="${txtObservacions}" tamany="complet" path="observacions" />
</div>
</div>