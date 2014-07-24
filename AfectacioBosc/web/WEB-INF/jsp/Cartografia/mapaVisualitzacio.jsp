<div id="layerswitcher" class="control_capes">
    <%--<ul id="llistacapes">
    </ul>--%>
</div>
<div class="divmapa">
    <div id="map" class="mapafectacio"></div>
    <%@ include file="/WEB-INF/jsp/Estructura/filtregeo.jsp" %>
    <ul class="controls_mida_mapa">
        <li>
            <a href="#" onclick="javascript:veureMapa('mappetit');return false;"><img alt="petit" src="../grafics/map_small.png"/></a>
        </li>
        <li>
            <a href="#" onclick="javascript:veureMapa('mapmitja');return false;"><img alt="mitja" src="../grafics/map_medium.png"/></a>
        </li>
        <li>
            <a href="#" onclick="javascript:veureMapa('mapgran');return false;"><img alt="gran" src="../grafics/map_big.png"/></a>
        </li>
        <li id="hidemap">
            <a href="#" onclick="javascript:amagarMapa();return false;"><img alt="gran" src="../grafics/eye_no.png"/></a>
        </li>
    </ul>
</div>
