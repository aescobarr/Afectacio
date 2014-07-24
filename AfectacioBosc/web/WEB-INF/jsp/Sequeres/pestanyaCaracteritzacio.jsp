<div class="bloc_dades_fitxa">
<h3><fmt:message key="caracteritzacioTopograficaZona" bundle="${bundleAfectacio}" /></h3>
<%
     request.setAttribute("llista", request.getAttribute("orientacions"));
     request.setAttribute("objecteSeleccionat", new MSIPANGeneral.ObjecteSIPANAmbNom(afectacio.getOrientacio()));
%>
<c:set var="txtOrientacio"><fmt:message key="orientacio" bundle="${bundleAfectacio}" /></c:set>
<tag:inputFormCombo etiqueta="${txtOrientacio}"  tamany="complet" path="orientacio" />
<%
     request.setAttribute("llista", request.getAttribute("pendents"));
     request.setAttribute("objecteSeleccionat", new MSIPANGeneral.ObjecteSIPANAmbNom(afectacio.getPendent()));
%>
<c:set var="txtPendent"><fmt:message key="pendent" bundle="${bundleAfectacio}" /></c:set>
<tag:inputFormCombo etiqueta="${txtPendent}"  tamany="complet" path="pendent" />
<%
     request.setAttribute("llista", request.getAttribute("posicionsPendent"));
     request.setAttribute("objecteSeleccionat", new MSIPANGeneral.ObjecteSIPANAmbNom(afectacio.getPosicioPendent()));
%>
<c:set var="txtPosicioPendent"><fmt:message key="posicioPendent" bundle="${bundleAfectacio}" /></c:set>
<tag:inputFormCombo etiqueta="${txtPosicioPendent}"  tamany="complet" path="posicioPendent" />
<%
     request.setAttribute("llista", request.getAttribute("disposicionsPendent"));
     request.setAttribute("objecteSeleccionat", new MSIPANGeneral.ObjecteSIPANAmbNom(afectacio.getDisposicioPendent()));
%>
<c:set var="txtDisposicioPendent"><fmt:message key="disposicioPendent" bundle="${bundleAfectacio}" /></c:set>
<tag:inputFormCombo etiqueta="${txtDisposicioPendent}"  tamany="complet" path="disposicioPendent" />
</div>
<div class="bloc_dades_fitxa">
<h3><fmt:message key="gestioForestal" bundle="${bundleAfectacio}" /></h3>
<%
     request.setAttribute("llista", request.getAttribute("tipusBoscos"));
     request.setAttribute("objecteSeleccionat", afectacio.getTipusBosc());
%>
<c:set var="txtTipusBosc"><fmt:message key="tipusBosc" bundle="${bundleAfectacio}" /></c:set>
<tag:inputFormCombo etiqueta="${txtTipusBosc}"  tamany="complet" path="tipusBosc" />
<%
     request.setAttribute("llista", request.getAttribute("especiesAOferirSequeraTipusBosc"));
     request.setAttribute("objecteSeleccionat", afectacio.getEspecie1TipusBosc());
%>
<c:set var="txtEspecieDominant1"><fmt:message key="especieDominant1" bundle="${bundleAfectacio}" /></c:set>
<tag:inputFormCombo etiqueta="${txtEspecieDominant1}"  tamany="complet" path="especie1TipusBosc" />
<%
     request.setAttribute("objecteSeleccionat", afectacio.getEspecie2TipusBosc());
%>
<c:set var="txtEspecieDominant2"><fmt:message key="especieDominant2" bundle="${bundleAfectacio}" /></c:set>
<tag:inputFormCombo etiqueta="${txtEspecieDominant2}"  tamany="complet" path="especie2TipusBosc" />
<%
     request.setAttribute("objecteSeleccionat", afectacio.getEspecie3TipusBosc());
%>
<c:set var="txtEspecieDominant3"><fmt:message key="especieDominant3" bundle="${bundleAfectacio}" /></c:set>
<tag:inputFormCombo etiqueta="${txtEspecieDominant3}"  tamany="complet" path="especie3TipusBosc" />
<div class="campformulari"><div class="etiqueta"><label><fmt:message key="presenciaSoques" bundle="${bundleAfectacio}" /></label></div><div class="entradadades">
<input type="checkbox" id="presenciaSoquesRecentsString" name="presenciaSoquesRecentsString" value="S" <%if(afectacio.getPresenciaSoquesRecents()) out.print("checked");%>/>
<label for="recents"><fmt:message key="recents" bundle="${bundleAfectacio}" /></label>
<input type="checkbox" id="presenciaSoquesAntiguesString" name="presenciaSoquesAntiguesString" value="S" <%if(afectacio.getPresenciaSoquesAntigues()) out.print("checked");%> />
<label for="antigues"><fmt:message key="antigues" bundle="${bundleAfectacio}" /></label>
</div></div>
<%
     request.setAttribute("llista", request.getAttribute("especiesAOferirSequeraSoca"));
     request.setAttribute("objecteSeleccionat", afectacio.getEspecie1Soca());
%>
<c:set var="txtEspecieSoca1"><fmt:message key="especieSoca1" bundle="${bundleAfectacio}" /></c:set>
<tag:inputFormCombo etiqueta="${txtEspecieSoca1}"  tamany="complet" path="especie1Soca" />
<%
     request.setAttribute("objecteSeleccionat", afectacio.getEspecie2Soca());
%>
<c:set var="txtEspecieSoca2"><fmt:message key="especieSoca2" bundle="${bundleAfectacio}" /></c:set>
<tag:inputFormCombo etiqueta="${txtEspecieSoca2}"  tamany="complet" path="especie2Soca" />
<%
     request.setAttribute("objecteSeleccionat", afectacio.getEspecie3Soca());
%>
<c:set var="txtEspecieSoca3"><fmt:message key="especieSoca3" bundle="${bundleAfectacio}" /></c:set>
<tag:inputFormCombo etiqueta="${txtEspecieSoca3}"  tamany="complet" path="especie3Soca" />
<div class="campformulari"><div class="etiqueta"><label><fmt:message key="treballsSilvicoles" bundle="${bundleAfectacio}" /></label></div><div class="entradadades">
<input type="checkbox" id="aclaridaDeMilloraString" name="aclaridaDeMilloraString" value="S" <%if(afectacio.getAclaridaDeMillora()) out.print("checked");%>/>
<label for="aclaridaDeMilloraString"><fmt:message key="aclaridaMillora" bundle="${bundleAfectacio}" /></label>
<input type="checkbox" id="estassadaString" name="estassadaString" value="S" <%if(afectacio.getEstassada()) out.print("checked");%> />
<label for="estassadaString"><fmt:message key="estassadaSotabosc" bundle="${bundleAfectacio}" /></label>
<input type="checkbox" id="talladaDeRegeneracioString" name="talladaDeRegeneracioString" value="S" <%if(afectacio.getTalladaDeRegeneracio()) out.print("checked");%> />
<label for="talladaDeRegeneracioString"><fmt:message key="talladaRegeneracio" bundle="${bundleAfectacio}" /></label>
<input type="checkbox" id="talladaDeSeleccioString" name="talladaDeSeleccioString" value="S" <%if(afectacio.getTalladaDeSeleccio()) out.print("checked");%>/>
<label for="talladaDeSeleccioString"><fmt:message key="talladaSeleccio" bundle="${bundleAfectacio}" /></label>
</div></div>
</div>
<div class="bloc_dades_fitxa">
<h3><fmt:message key="regeneracioEspeciesForestals" bundle="${bundleAfectacio}" /></h3>
<div id="dadesregeneracio" class="scroll campformulari">
    <div class="scroll taularegeneracio">
    <input class="linkAfegir" type="button" id="afegir" name="afegir" value="<fmt:message key="afegir" bundle="${bundleSIPAN}" />" />
    <div id="taularegeneracio"></div>
    <input type="hidden" id="idsDadesRegeneracio" name="idsDadesRegeneracio" value="" />
    </div>
</div>
</div>