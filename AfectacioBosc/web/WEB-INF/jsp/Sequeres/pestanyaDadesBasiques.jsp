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
<c:set var="txtCodi">*&nbsp;<fmt:message key="codi" bundle="${bundleAfectacio}" />&nbsp;<fmt:message key="exempleCodi" bundle="${bundleAfectacio}" /></c:set>
<tag:inputFormText etiqueta="${txtCodi}" tamany="complet" path="codi" />
<spring:bind path="nouOAntic"><input  id="valorNouOAntic" name="valorNouOAntic" type="hidden" value="${afectacio.nouOAntic}"/></spring:bind>
<div class="campformulari"><div class="etiqueta"><label><fmt:message key="episodiNou" bundle="${bundleAfectacio}" /></label></div><div class="entradadades"><input type="radio" id="nou" name="nouOAntic" value="N" onchange="javascript:canviNouOAntic();" <c:if test="${afectacio.nouOAntic=='N'}">checked</c:if>/>&nbsp;<b><fmt:message key="episodiAntic" bundle="${bundleAfectacio}" /></b>&nbsp;<input type="radio" id="A" name="nouOAntic" value="A"  <c:if test="${afectacio.nouOAntic!='N'}">checked</c:if> onchange="javascript:canviNouOAntic();"/></div></div>
<spring:bind path="arbresNousAfectats"><input  id="arbresNousAfectats" name="arbresNousAfectats" type="hidden" value="${afectacio.arbresNousAfectats}"/></spring:bind>
<div class="campformulari" id="divArbresNousAfectats"><div class="etiqueta"><label><fmt:message key="hihaArbresNousAfectats" bundle="${bundleAfectacio}" /></label></div><div class="entradadades"><input type="radio" id="hihaArbresNousAfectats" name="radiosArbresNousAfectats" value="S" onchange="javascript:canviArbresNousAfectats();" <c:if test="${afectacio.arbresNousAfectats!='N'}">checked</c:if>/>&nbsp;<b><fmt:message key="nohihaArbresNousAfectats" bundle="${bundleAfectacio}" /></b>&nbsp;<input type="radio" id="nohihaArbresAfectats" name="radiosArbresNousAfectats" value="N"  <c:if test="${afectacio.arbresNousAfectats=='N'}">checked</c:if> onchange="javascript:canviArbresNousAfectats();"/></div></div>
<fmt:message key="coordenadesUTMPuntObservacio" bundle="${bundleAfectacio}" />
<c:set var="txtX">*&nbsp;<fmt:message key="x" bundle="${bundleAfectacio}" /></c:set>
<c:set var="txtY">*&nbsp;<fmt:message key="y" bundle="${bundleAfectacio}" /></c:set>
<tag:inputFormText etiqueta="${txtX}" tamany="complet" path="coordenadaXPuntObservacio" />
<tag:inputFormText etiqueta="${txtY}" tamany="complet" path="coordenadaYPuntObservacio" />
<c:set var="txtOrientacio">*&nbsp;<fmt:message key="orientacio" bundle="${bundleAfectacio}" /> (<fmt:message key="graus" bundle="${bundleAfectacio}" />)</c:set>
<tag:inputFormText etiqueta="${txtOrientacio}" tamany="complet" path="orientacioFoto" />
</div>
<div class="bloc_dades_fitxa">
<h3><fmt:message key="desenvolupamentMostreig" bundle="${bundleAfectacio}" /></h3>
<c:set var="txtData">*&nbsp;<fmt:message key="data" bundle="${bundleAfectacio}" /></c:set>
<tag:inputFormText etiqueta="${txtData}" tamany="complet" path="data"/>
<c:set var="txtCodiAgent1">*&nbsp;<fmt:message key="codiAgent1" bundle="${bundleAfectacio}" /></c:set>
<tag:inputFormText etiqueta="${txtCodiAgent1}" tamany="complet" path="codiAgent1"/>
<c:set var="txtCodiAgent2">*&nbsp;<fmt:message key="codiAgent2" bundle="${bundleAfectacio}" /></c:set>
<tag:inputFormText etiqueta="${txtCodiAgent2}" tamany="complet" path="codiAgent2"/>
</div>
<div class="bloc_dades_fitxa">
<h3><fmt:message key="caracteristiquesGeneralsZonaAfectada" bundle="${bundleAfectacio}" /></h3>
<%
     request.setAttribute("llista", request.getAttribute("distribucions"));
     request.setAttribute("objecteSeleccionat", afectacio.getDistribucioArbresAfectats());
%>
<c:set var="txtDistribucio">*&nbsp;<fmt:message key="distribucioArbresAfectats" bundle="${bundleAfectacio}" /></c:set>
<tag:inputFormCombo etiqueta="${txtDistribucio}"  tamany="complet" path="distribucioArbresAfectats" />
</div>
<div class="bloc_dades_fitxa">
    <h3><fmt:message key="altresCausesDecaiment" bundle="${bundleAfectacio}" /></h3>
    <div>
        <table class="blanc">
            <tr>
        <%
        java.util.List causes = (java.util.List)request.getAttribute("causesDecaiment");
        for(int i=0;i<causes.size();i++){
            cat.creaf.afectaciobosc.model.CausaDecaiment element = (cat.creaf.afectaciobosc.model.CausaDecaiment)causes.get(i);%>
            
            
                <td>
            <input type="checkbox" id="CAUSADECAIMENT_<%=i%>" name="CAUSADECAIMENT_<%=i%>" value="<%=element.getIdString()%>" <%if(afectacio.getCausesDecaiment().contains(element)){%> checked <%}%> />
            <label for="CAUSADECAIMENT_<%=i%>"><%=element%></label>
            </td>
            <% if((i+1)%3==0 && (i+1)<causes.size()){ out.print("</tr><tr>");}%>
        <%}%>
            </tr>
        </table>
    </div>    
</div>
</div>
<div class="bloc_dades_fitxa">
<h3><fmt:message key="afectacioGeneral" bundle="${bundleAfectacio}" /></h3>
<p><fmt:message key="descripcioAfectacioGeneral" bundle="${bundleAfectacio}" /></p>
<p><fmt:message key="descripcioTipusAfectacio" bundle="${bundleAfectacio}" /></p>
<p><fmt:message key="descripcioGrauAfectacio" bundle="${bundleAfectacio}" /></p>
<div id="dadesestimacions" class="scroll campformulari">
    <div class="scroll tauladadesestimacionssequera">
    <input class="linkAfegir" type="button" id="afegirestimacio" name="afegirestimacio" value="<fmt:message key='afegir' bundle='${bundleSIPAN}' />" />
    <div id="taulaestimacions"></div>
    <input type="hidden" id="idsDadesEstimacions" name="idsDadesEstimacions" value="" />
    </div>    
</div>
<c:set var="txtObservacions"><fmt:message key="observacions" bundle="${bundleAfectacio}" /></c:set>
<tag:inputFormTextarea etiqueta="${txtObservacions}" tamany="ampliTotal" path="observacions" />
</div>    