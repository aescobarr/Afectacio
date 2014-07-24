<div id="fitxa" class="yui-content mdanyabiotic"><form name="formAfectacio" method="POST" action="">
    <div class="bloc_dades_fitxa">
        <div class="campformulari"><div class="etiqueta"></div><div class="entradadades">
        <div id="botonera" class="botonera">
        <input type="button" value="<fmt:message key='desar' bundle='${bundleSIPAN}' />" onclick="javascript:acceptar()" />
        <input type="button" value="<fmt:message key='desarISortir' bundle='${bundleAfectacio}' />" onclick="javascript:acceptarISortir()" />
        <input type="button" value="<fmt:message key='cancelar' bundle='${bundleSIPAN}' />" onclick="javascript:enrera()" />
        </div>
        </div>
        </div>
    </div>
    <div class="bloc_dades_fitxa">
        <h3>1.- <fmt:message key="identificacioLocalitzacio" bundle="${bundleAfectacio}" /></h3>
        <c:set var="txtCodi">*&nbsp;<fmt:message key="codi" bundle="${bundleAfectacio}" />&nbsp;<fmt:message key="exempleCodiDanyMecanic" bundle="${bundleAfectacio}" />:</c:set>
        <tag:inputFormTextNoBind etiqueta="${txtCodi}" tamany="petit" path="codi" valor="${afectacio.codi}" />
        <c:set var="txtDataEpisodi">* <fmt:message key="dataEpisodiFormatada" bundle="${bundleAfectacio}" />:</c:set>
        <c:set var="valueData"><fmt:formatDate value="${afectacio.data}" pattern="dd/MM/yyyy" type="date"/></c:set>
        <tag:inputFormTextNoBind etiqueta="${txtDataEpisodi}" tamany="petit" path="dataEpisodi" valor="${valueData}"/>
        
    </div>
    <div class="bloc_dades_fitxa">
        <h3>2.- <fmt:message key="desenvolupamentReconeixement" bundle="${bundleAfectacio}" /></h3>
        <div class="campformulari"><div class="etiqueta"></div><div class="entradadades"><h4>2.1.- <fmt:message key="dates" bundle="${bundleAfectacio}" /> (*)</h4></div></div>
        <div class="campformulari"><div class="etiqueta"></div><div class="entradadades"><input type="checkbox" id="chckapreciacioinicial" name="chckapreciacioinicial" onchange="javascript:canviCheckData('dataApreciacioInicial',this);" <c:if test="${afectacio.dataApreciacioInicial!=null}">checked</c:if>/><label for="chckapreciacioinicial">&nbsp;<fmt:message key="apreciacioInicial" bundle="${bundleAfectacio}" /></label></div></div>
        <c:set var="txtDataApreciacioInicial"><fmt:message key="dataApreciacioInicial" bundle="${bundleAfectacio}" />:</c:set>
        <c:set var="valueData"><fmt:formatDate value="${afectacio.dataApreciacioInicial}" pattern="dd/MM/yyyy" type="date"/></c:set>
        <tag:inputFormTextNoBind etiqueta="${txtDataApreciacioInicial}" tamany="petit" path="dataApreciacioInicial" valor="${valueData}"/>
        <div class="campformulari"><div class="etiqueta"></div><div class="entradadades"><input type="checkbox" id="chckdadesdefinitives" name="chckdadesdefinitives" onchange="javascript:canviCheckData('dataDadesDefinitives',this);" <c:if test="${afectacio.dataDadesDefinitives!=null}">checked</c:if>/><label for="chckdadesdefinitives">&nbsp;<fmt:message key="dadesDefinitives" bundle="${bundleAfectacio}" /></label></div></div>
        <c:set var="txtDataDadesDefinitives"><fmt:message key="dataDadesDefinitives" bundle="${bundleAfectacio}" />:</c:set>
        <c:set var="valueData"><fmt:formatDate value="${afectacio.dataDadesDefinitives}" pattern="dd/MM/yyyy" type="date"/></c:set>
        <tag:inputFormTextNoBind etiqueta="${txtDataDadesDefinitives}" tamany="petit" path="dataDadesDefinitives" valor="${valueData}"/>
        <div class="campformulari"><div class="etiqueta"></div><div class="entradadades"><input type="checkbox" id="chckvalidacio" name="chckvalidacio" onchange="javascript:canviCheckData('dataValidacio',this);" <c:if test="${afectacio.dataValidacio!=null}">checked</c:if>/><label for="chckvalidacio">&nbsp;<fmt:message key="validacio" bundle="${bundleAfectacio}" /></label></div></div>
        <c:set var="txtDataValidacio"><fmt:message key="dataValidacio" bundle="${bundleAfectacio}" />:</c:set>
        <c:set var="valueData"><fmt:formatDate value="${afectacio.dataValidacio}" pattern="dd/MM/yyyy" type="date"/></c:set>
        <tag:inputFormTextNoBind etiqueta="${txtDataValidacio}" tamany="petit" path="dataValidacio" valor="${valueData}"/>
    </div>
    <div class="bloc_dades_fitxa">
        <div class="campformulari"><div class="etiqueta"></div><div class="entradadades"><h4>2.2.- <fmt:message key="nomOCodiIdentificadors" bundle="${bundleAfectacio}" /></h4></div></div>
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
        <div class="campformulari"><div class="etiqueta"></div><div class="entradadades"><h4>2.3.- <fmt:message key="excepcionalitatMeteorologica" bundle="${bundleAfectacio}" /></h4></div></div>
        <div class="campformulari"><div class="etiqueta"></div><div class="entradadades"><p><fmt:message key="explicacioExcepcionalitatMeteorologica" bundle="${bundleAfectacio}" /></p></div></div>
        <tag:inputFormTextareaNoBind etiqueta="" tamany="complet" path="excepcionalitatMeteorologica" valor="${afectacio.excepcionalitatMeteorologica}"/>
    </div>
    <div class="bloc_dades_fitxa">
        <h3>3.- <fmt:message key="tipusMostreig" bundle="${bundleAfectacio}" /></h3>
        <div class="campformulari"><div class="etiqueta"><label for="mostreigSistematicselect">* <fmt:message key="mostreigSistematic" bundle="${bundleAfectacio}" />:</label></div><div class="entradadades"><input type="hidden" id="idmostreigSistematic" name="idmostreigSistematic" value="" /><select id="mostreigSistematicselect" name="mostreigSistematicselect" class="moltpetit" onchange="javascript:document.getElementById('idmostreigSistematic').value=document.getElementById('mostreigSistematicselect').value;"><option id="null" value="null" <c:if test="${afectacio.esMostreigSistematic==null}">selected</c:if>></option><option id="S" value="S" <c:if test="${afectacio.esMostreigSistematic}">selected</c:if>><fmt:message key="si" bundle="${bundleSIPAN}" /></option><option id="N" value="N" <c:if test="${!afectacio.esMostreigSistematic}">selected</c:if>><fmt:message key="no" bundle="${bundleSIPAN}" /></option></select></div></div>
        <c:set var="txtObservacions"><fmt:message key="observacions" bundle="${bundleAfectacio}" />:</c:set>
        <tag:inputFormTextareaNoBind etiqueta="${txtObservacions}" tamany="complet" path="observacionsMostreigSistematic" valor="${afectacio.observacionsMostreigSistematic}"/>
    </div>
    <div class="bloc_dades_fitxa">
        <h3>4.- <fmt:message key="caracteristiquesGeneralsZonaAfectada" bundle="${bundleAfectacio}" /></h3>
        <div class="campformulari"><div class="etiqueta"></div><div class="entradadades"><h4>4.1.- <fmt:message key="tipusBoscIGestioZona" bundle="${bundleAfectacio}" /></h4></div></div>
        <div class="campformulari"><div class="etiqueta"></div><div class="entradadades"><p><fmt:message key="explicacioTipusBoscIGestioZona" bundle="${bundleAfectacio}" /></p></div></div>
        <div class="campformulari"><div class="etiqueta"></div><div class="entradadades">
        <table>
            <tr>
                <th><fmt:message key="gestioZona" bundle="${bundleAfectacio}" /></th>
                <th>%</th>
                <th><fmt:message key="tipusBosc" bundle="${bundleAfectacio}" /></th>
                <th>%</th>
            </tr>
            <tr>
                <td><fmt:message key="ambTreballsGestioAparent" bundle="${bundleAfectacio}" /></td>
                <td><input  id="percentatgeAmbTreballsGestioAparent" name="percentatgeAmbTreballsGestioAparent" type="text" class="moltpetit" value="${afectacio.percentatgeAmbTreballsGestioAparent}"  /></td>
                <td><fmt:message key="boscRegeneracioNatural" bundle="${bundleAfectacio}" /></td>
                <td><input  id="percentatgeBoscRegeneracioNatural" name="percentatgeBoscRegeneracioNatural" type="text" class="moltpetit" value="${afectacio.percentatgeBoscRegeneracioNatural}"  /></td>
            </tr>
            <tr>
                <td><fmt:message key="senseTreballsGestioAparent" bundle="${bundleAfectacio}" /></td>
                <td><input  id="percentatgeSenseTreballsGestioAparent" name="percentatgeSenseTreballsGestioAparent" type="text" class="moltpetit" value="${afectacio.percentatgeSenseTreballsGestioAparent}"  /></td>
                <td><fmt:message key="repoblacioArtificial" bundle="${bundleAfectacio}" /></td>
                <td><input  id="percentatgeRepoblacioArtificial" name="percentatgeRepoblacioArtificial" type="text" class="moltpetit" value="${afectacio.percentatgeRepoblacioArtificial}"  /></td>
            </tr>
            <tr>
                <td>&nbsp;</td>
                <td>&nbsp;</td>
                <td><fmt:message key="plantacioEspeciesCreixementRapid" bundle="${bundleAfectacio}" /></td>
                <td><input  id="percentatgePlantacioEspeciesCreixementRapid" name="percentatgePlantacioEspeciesCreixementRapid" type="text" class="moltpetit" value="${afectacio.percentatgePlantacioEspeciesCreixementRapid}"  /></td>
            </tr>
        </table>
        </div></div>
    </div>
    <div class="bloc_dades_fitxa">
        <h3>5.- <fmt:message key="afectacioGeneral" bundle="${bundleAfectacio}" /> (*)</h3>
        <div class="campformulari"><div class="etiqueta"></div><div class="entradadades"><p><fmt:message key="descripcioAfectacioGeneral" bundle="${bundleAfectacio}" /></p></div></div>
        <div class="campformulari"><div class="etiqueta"></div><div class="entradadades">
        <div id="dadesestimacions" class="scroll campformulari">
        <div class="scroll tauladadesestimacions">
        <input type="button" id="afegirestimacio" name="afegirestimacio" value="<fmt:message key='afegir' bundle='${bundleSIPAN}' />" onclick="javascript:onButtonAfegirAfectacioEstimadaClick();return false;"/>
        <div id="taulaestimacions"></div>
        <input type="hidden" id="idsDadesEstimacions" name="idsDadesEstimacions" value="" />
        </div>
        </div>
        </div></div>
        <div class="campformulari"><div class="etiqueta"></div><div class="entradadades"><h4>5.1.- <fmt:message key="grauAfectacioXarxaViaria" bundle="${bundleAfectacio}" /></h4></div></div>
        <div class="campformulari"><div class="etiqueta"></div><div class="entradadades">
            <p><fmt:message key="calMarcarGrauAfectacioSegons" bundle="${bundleAfectacio}" />:</p>
            <ul>
                <li><fmt:message key="grauAfectacio0" bundle="${bundleAfectacio}" /></li>
                <li><fmt:message key="grauAfectacio1" bundle="${bundleAfectacio}" /></li>
                <li><fmt:message key="grauAfectacio2" bundle="${bundleAfectacio}" /></li>
            </ul>
        <input type="radio" name="grauAfectacio" id="grau0" value="0" <c:if test="${afectacio.grauAfectacioXarxaViaria==0}">checked</c:if>/>
        <label for="grau0"><fmt:message key="0Nul" bundle="${bundleAfectacio}" /></label>
        <input type="radio" name="grauAfectacio" id="grau1" value="1" <c:if test="${afectacio.grauAfectacioXarxaViaria==1}">checked</c:if>/>
        <label for="grau1"><fmt:message key="1Moderat" bundle="${bundleAfectacio}" /></label>
        <input type="radio" name="grauAfectacio" id="grau2" value="2" <c:if test="${afectacio.grauAfectacioXarxaViaria==2}">checked</c:if>/>
        <label for="grau2"><fmt:message key="2Greu" bundle="${bundleAfectacio}" /></label>
        </div></div>
    </div>
    <div class="bloc_dades_fitxa">
        <h3>5.- <fmt:message key="causaEpisodiDecaiment" bundle="${bundleAfectacio}" /> (*)</h3>
        <div class="campformulari"><div class="etiqueta"></div><div class="entradadades">
        <%
        java.util.List causes = (java.util.List)request.getAttribute("causesDecaiment");
        for(int i=0;i<causes.size();i++){
        cat.creaf.afectaciobosc.model.CausaDecaimentDanyAbiotic element = (cat.creaf.afectaciobosc.model.CausaDecaimentDanyAbiotic)causes.get(i);%>
        <input type="checkbox" id="CAUSADECAIMENTDANYABIOTIC_<%=i%>" name="CAUSADECAIMENTDANYABIOTIC_<%=i%>" value="<%=element.getIdString()%>"
        <%if(afectacio.getCausesDecaiment().contains(element)){%>
        checked
        <%}%>
        />
        <label for="CAUSADECAIMENTDANYABIOTIC_<%=i%>"><%=element%></label>
        <%if(i%4==0){ out.println("<br/>"); }%>
        <%}%>
        <br/><fmt:message key="indicarCausaAObservacions" bundle="${bundleAfectacio}" />
        </div></div>        
        <c:set var="txtObservacions"><fmt:message key="observacions" bundle="${bundleAfectacio}" /></c:set>
        <tag:inputFormTextareaNoBind etiqueta="${txtObservacions}" tamany="complet" path="observacions" valor="${afectacio.observacions}"/>
    </div>
    <div class="bloc_dades_fitxa">
        <h3>6.- <fmt:message key="dibuixPoligon" bundle="${bundleAfectacio}" /> (*)</h3>
        <div id="mapa">
            <div id="map" class="mapacomplet"></div>
            <div class="anar_carto">
            <div id="container"></div>
            </div>
            <div class="anar_carto">
                <div class="element_anar_carto">
                <input type="button" id="botomoure" name="botomoure" class="botomoure" alt="<fmt:message key='moureMapa' bundle='${bundleAfectacio}' />"  onclick="javascript:toggleControl('moure');return false;"/>
                <input type="button" id="botozoomfinestra" name="botozoomfinestra" class="botozoomfinestra" alt="<fmt:message key='zoomFinestra' bundle='${bundleAfectacio}' />" onclick="javascript:toggleControl('zoom');return false;"/>
                <input type="button" id="botoinfo" name="botoinfo" class="botoinfo" alt="<fmt:message key='informacio' bundle='${bundleAfectacio}' />" onclick="javascript:toggleControl('info');return false;"/>
                </div>
                <div  class="element_anar_carto" id="controlToggle">
                <input type="button" id="botodigitalitzar" name="botodigitalitzar" class="botodigitalitzar" alt="<fmt:message key="digitalitzarPoligon" bundle="${bundleAfectacio}" />" onclick="javascript:toggleControl('polygon');return false;"/>
                <input type="button" id="botoesborrar" name="botoesborrar" class="botoesborrar" alt="<fmt:message key="esborrarElementMapa" bundle="${bundleAfectacio}" />" onclick="javascript:toggleControl('remove');return false;" />
                </div>
                <div  class="element_anar_carto">
                <div id="coordenades"></div>
                </div>
            </div>
            <%@ include file="/WEB-INF/jsp/Estructura/filtregeo.jsp" %>
        </div>
    </div>
    <br/>
    <div class="bloc_dades_fitxa">
        <div class="campformulari"><div class="etiqueta"></div><div class="entradadades">
        <div id="botonera" class="botonera">
        <input type="button" value="<fmt:message key='desar' bundle='${bundleSIPAN}' />" onclick="javascript:acceptar()" />
        <input type="button" value="<fmt:message key='desarISortir' bundle='${bundleAfectacio}' />" onclick="javascript:acceptarISortir()" />
        <input type="button" value="<fmt:message key='cancelar' bundle='${bundleSIPAN}' />" onclick="javascript:enrera()" />
        </div>
        </div>
        </div>
    </div>
    <input type="hidden" name="wkt" value='${afectacio.areaAfectadaWtk}'/>
    <input type="hidden" name="novaurl" value=''/>
    <input type="hidden" name="idafectacio" value='${afectacio.idString}'/>
    <input type="hidden" id="accio" name="accio" value='0'/>
</form></div>