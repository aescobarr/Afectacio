<%-- 
    Document   : llistatTasques
    Created on : 05-dic-2008, 12:50:48
    Author     : a_escobar
--%>

<%@page contentType="text/html" pageEncoding="ISO-8859-1"  trimDirectiveWhitespaces="true"%>
<%@ include file="/WEB-INF/jsp/include.jsp" %>
<fmt:setBundle var="bundleSIPAN" basename="Literals.MSIPAN"/>
<link rel="stylesheet" type="text/css" href="../../css/estilSIPAN.css" />
<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN"
"http://www.w3.org/TR/html4/loose.dtd">
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
        <title></title>
        <script type="text/javascript">
            function llistarperlletra(lletra){
                document.dades.lletrapremuda.value=lletra;
                document.dades.submit();
            }

            function seleccionarresultat(idSeleccionat,nomSeleccionat){
               window.opener.document.getElementById('idespeciebuscada').value = idSeleccionat;
               window.opener.document.getElementById('fraseabuscar').value = nomSeleccionat;
               window.opener.afegirAltraObservacioATaula();
               window.close();
            }

            function init(){
                <c:if test="${fn:length(dades.resultats)==1}">
                    seleccionarresultat('${dades.resultats[0].idString}','${dades.resultats[0]}');
                </c:if>
            }
        </script>
    </head>
    <body onload="javascript:init();return false;">
        <div class="contenidor">
            <div class="centrat">
                <ul class="llistalletres">
                    <c:forEach items="${dades.lletres}" var="lletra" varStatus="loopStatus">
                        <c:choose>
                        <c:when test="${lletra==dades.lletrapremuda}">
                            <li class="seleccionat">
                        </c:when>
                        <c:otherwise>
                            <li>
                        </c:otherwise>
                        </c:choose>
                        <a href="#" onclick="javascript:llistarperlletra('${lletra}');return false;">${lletra}</a></li>
                    </c:forEach>
                </ul>
            </div>
            <div class="espaigran"></div>
            <div class="esquerra">
                <ul class="resultatscerca">
                <c:forEach items="${dades.resultats}" var="resultat" varStatus="loopStatus">
                    <li>
                        <a href="#" onclick="javascript:seleccionarresultat('${resultat.idString}','${resultat}')">${resultat}</a>
                    </li>
                </c:forEach>
                </ul>
            </div>
        </div>
        <form name="dades" method="GET">
            <input type="hidden" name="lletrapremuda" value="" />
            <input type="hidden" name="resultatseleccionat" value="" />
        </form>
    </body>
</html>
