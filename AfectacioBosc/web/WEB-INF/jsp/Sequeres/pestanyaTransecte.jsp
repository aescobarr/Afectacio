<div class="bloc_dades_fitxa">
    <fmt:message key="coordenadesUTMIniciTransecte" bundle="${bundleAfectacio}" />
    <c:set var="txtX">*&nbsp;<fmt:message key="x" bundle="${bundleAfectacio}" /></c:set>
    <c:set var="txtY">*&nbsp;<fmt:message key="y" bundle="${bundleAfectacio}" /></c:set>
    <div class="campformulari"><div class="etiqueta"><label for="coordenadaXIniciTransecte" >*&nbsp;<fmt:message key="x" bundle="${bundleAfectacio}" /></label></div><div class="entradadades"><input  id="coordenadaXIniciTransecte" name="coordenadaXIniciTransecte" type="text" class="complet" value="${afectacio.coordenadaXIniciTransecte}"/></div></div>
    <div class="campformulari"><div class="etiqueta"><label for="coordenadaYIniciTransecte" >*&nbsp;<fmt:message key="y" bundle="${bundleAfectacio}" /></label></div><div class="entradadades"><input  id="coordenadaYIniciTransecte" name="coordenadaYIniciTransecte" type="text" class="complet" value="${afectacio.coordenadaYIniciTransecte}"/></div></div>
</div>
<div class="bloc_dades_fitxa">
    <fmt:message key="coordenadesUTMFiTransecte" bundle="${bundleAfectacio}" />
    <div class="campformulari"><div class="etiqueta"><label for="coordenadaXFiTransecte" >*&nbsp;<fmt:message key="x" bundle="${bundleAfectacio}" /></label></div><div class="entradadades"><input  id="coordenadaXFiTransecte" name="coordenadaXFiTransecte" type="text" class="complet" value="${afectacio.coordenadaXFiTransecte}"/></div></div>
    <div class="campformulari"><div class="etiqueta"><label for="coordenadaYFiTransecte" >*&nbsp;<fmt:message key="y" bundle="${bundleAfectacio}" /></label></div><div class="entradadades"><input  id="coordenadaYFiTransecte" name="coordenadaYFiTransecte" type="text" class="complet" value="${afectacio.coordenadaYFiTransecte}"/></div></div>
</div>
<div id="dadestransecte" class="scroll campformulari">
    <div class="scroll taulatransecte">
    <input class="linkAfegir" type="button" id="afegirarbre" name="afegir" value="<fmt:message key="afegir" bundle="${bundleSIPAN}" />" />
    <div id="taulatransecte"></div>
    <input type="hidden" id="idsDadesTransecte" name="idsDadesTransecte" value="" />
    </div>
</div>