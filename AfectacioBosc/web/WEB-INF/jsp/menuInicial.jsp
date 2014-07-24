<?xml version="1.0" encoding="UTF-8"?>
<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">
<%@ include file="/WEB-INF/jsp/include.jsp" %>
<%@ taglib tagdir="/WEB-INF/tags" prefix="tag" %>
<html xml:lang="ca" lang="ca" xmlns="http://www.w3.org/1999/xhtml">
    <head>
        <title>SISTEMA D'INFORMACI&Oacute; D'AFECTACI&Oacute; DELS BOSCOS DE CATALUNYA</title>
        <meta HTTP-EQUIV="CACHE-CONTROL" CONTENT="NO-CACHE"/>
        <meta HTTP-EQUIV="EXPIRES" CONTENT="0"/>
        <meta HTTP-EQUIV="PRAGMA" CONTENT="NO-CACHE"/>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8" />
        <meta http-equiv="Content-Style-Type" content="text/css" />
        <fmt:setBundle var="bundleSIPAN" basename="Literals.MSIPAN"/>
        <fmt:setBundle var="bundleAfectacio" basename="cat.creaf.afectaciobosc.literals.AfectacioBosc"/>
        <link rel="shortcut icon" href="<c:url value='/grafics/afectacio_ico_nav.ico' />"/>
        <link rel="stylesheet" type="text/css" href="<c:url value='/css/sipan.css' />" />
        <link rel="stylesheet" type="text/css" href="<c:url value='/css/estilAfectacio.css' />" />
        <%@ include file="/WEB-INF/jsp/Estructura/yui-sipan.jsp" %>
        <script type="text/javascript">
            function anarA(url){
                document.dades.idafectacio.value = "-1";
                document.dades.action = url;
                document.dades.submit();
            }
        </script>
    </head>
    <body class="yui-skin-sam">
        <div id="doc" class="yui-d2">
            <div id="hd">
                <%@ include file="/WEB-INF/jsp/Estructura/header.jsp" %>
            </div>
            <div id="bd">
                <br/><br/><br/><br/><br/><br/><br/><br/><br/><br/><br/><br/><br/><br/>
                <center>
                <table class="blanc centre">
                    <tr>
                        <td><h3><fmt:message key='processionaria' bundle='${bundleAfectacio}' /></h3></td>
                        <td><h3><fmt:message key='danysAbiotics' bundle='${bundleAfectacio}' /></h3></td>
                        <td><h3><fmt:message key='seguimentSequera' bundle='${bundleAfectacio}' /></h3></td>
                    </tr>
                    <tr>
                        <td><img id="boto_processionaria" src="<c:url value='/grafics/img_processionaria.jpg' />" class="boto" alt="<fmt:message key='processionaria' bundle='${bundleAfectacio}' />"/></td>
                        <td><img id="boto_danysmecanics" src="<c:url value='/grafics/img_nevades.png' />" class="boto" alt="<fmt:message key='danysMecanics' bundle='${bundleAfectacio}' />"/></td>
                        <td><img id="boto_sequera" src="<c:url value='/grafics/img_sequera.JPG' />" class="boto" alt="<fmt:message key='sequera' bundle='${bundleAfectacio}' />"/></td>
                    </tr>
                    <tr>
                        <td><input type="button" onclick="javascript:anarA('<c:url value='/processionaria/edicio/inserir.htm'/>');return false;" value="<fmt:message key='novaAfectacio' bundle='${bundleAfectacio}' />" /></td>
                        <td><input type="button" onclick="javascript:anarA('<c:url value='/danysabiotics/edicio/inserir.htm'/>');return false;" value="<fmt:message key='novaAfectacio' bundle='${bundleAfectacio}' />" /></td>
                        <td><input type="button" onclick="javascript:anarA('<c:url value='/sequeres/edicio/inserir.htm'/>');return false;" value="<fmt:message key='novaAfectacio' bundle='${bundleAfectacio}' />" /></td>
                    </tr>
                    <tr>
                        <td><input type="button" onclick="javascript:anarA('<c:url value='/processionaria/llistarprocessionaries.htm'/>');return false;" value="<fmt:message key='imprimir' bundle='${bundleAfectacio}' />" /></td>
                        <td><input type="button" onclick="javascript:anarA('<c:url value='/danysabiotics/llistardanysabiotics.htm'/>');return false;" value="<fmt:message key='editarImprimir' bundle='${bundleAfectacio}' />" /></td>
                        <td><input type="button" onclick="javascript:anarA('<c:url value='/sequeres/llistarsequeres.htm'/>');return false;" value="<fmt:message key='editarImprimir' bundle='${bundleAfectacio}' />" /></td>
                    </tr>
                </table>
                </center>
                    <br/><br/><br/><br/><br/><br/><br/><br/><br/><br/><br/>
                    <form name="dades" action="">
                        <input type="hidden" name="idafectacio" value=''/>
                    </form>
            </div>
            <div id="ft">
                <%@ include file="/WEB-INF/jsp/Estructura/footerAgentsRurals.jsp" %>
            </div>
        </div>
    </body>
</html>