<?xml version="1.0" encoding="UTF-8"?>
<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">
<%@ include file="/WEB-INF/jsp/include.jsp" %>
<html xml:lang="ca" lang="ca" xmlns="http://www.w3.org/1999/xhtml">
    <head>
        <title>SISTEMA D'INFORMACI&Oacute; D'AFECTACI&Oacute; DELS BOSCOS DE CATALUNYA</title>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8" />
        <meta http-equiv="Content-Style-Type" content="text/css" />
        <link rel="shortcut icon" href="<c:url value='/grafics/afectacio_ico_nav.ico' />"/>
        <link rel="stylesheet" type="text/css" href="<c:url value='/css/sipan.css' />" />
        <link rel="stylesheet" type="text/css" href="<c:url value='/css/estilAfectacio.css' />" />
        <fmt:setBundle var="bundleAfectacio" basename="cat.creaf.afectaciobosc.literals.AfectacioBosc"/>
        <%@ include file="/WEB-INF/jsp/Estructura/yui-sipan.jsp" %>
    </head>
    <body class="yui-skin-sam">
        <div id="doc" class="yui-d2">
            <div id="hd">
                <div class="header"><img src="<c:url value='/grafics/img_header.png' />" alt="" /></div>
            </div>
            <div id="bd">
                <div class="modul mprocessionaria">
                <h2><fmt:message key="ajuda" bundle="${bundleAfectacio}" /></h2>
                <ul>
                    <li><a href="<c:url value='/processionaria/ajuda.htm'/>?contingut=processionaria">Funcionament general de l'aplicació</a></li>
                    <li><a href="<c:url value='/processionaria/ajuda.htm'/>?contingut=omplirfitxa">Forma de valorar el grau d'atac de processionària del pi en les diferents comarques</a></li>
                    <li><a href="<c:url value='/processionaria/ajuda.htm'/>?contingut=carto">Com digitalitzar i utilitzar el mapa</a></li>
                </ul>
            </div>
                </div>
            <div id="ft">
                <%@ include file="/WEB-INF/jsp/Estructura/footer.jsp" %>
            </div>
        </div>
    </body>
</html>