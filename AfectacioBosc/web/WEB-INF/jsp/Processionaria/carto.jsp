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
            <h2>Com digitalitzar i utilitzar el mapa</h2>
            <p>El mapa de cartografia permet fer consultes i tamb� digitalitzar en el cas 
                que s'estigui entrant una nova afectaci�. En aquest segon cas, en la
                part de botons del panell de cartografia apareixen m�s botons per a dibuixar els
                pol�gons.</p>
            <img alt="ajuda cartografia" src="<c:url value='/grafics/ajudaMapa.JPG' />" />
            <p>Components del mapa:</p>
            <ul>
                <li><strong>Selector de capes:</strong> Permet canviar la cartografia de refer�ncia,
                disposant d'imatges o d'un mapa topogr�fic. Tamb� permet activar i desactivar les capes
                dels poligons de l'afectaci� digitalitzada en les entrades ja fetes a la base de dades i
                l'afectaci� que s'estigui digitalitzant en aquell moment.</li>
                <li><strong>Eines de zoom:</strong> A la part superior d'aquestes eines
                hi ha fletxes per a moure el mapa i tamb� per a situar-nos en la posici�
                inicial veient l'envolupant de tota Catalunya. La barra inferior permet
                triar un nivell de zoom directament.</li>
                <li><strong>Mapa de situaci�:</strong> Ajuda a tenir una refer�ncia de la localitzaci� que
                estem veient en el visor de mapes.</li>
                <li><strong>Botons de consulta i d'edici�:</strong> En el cas de no estar
                inserint una nova afectaci� hi ha un n�mero limitat de botons per poder
                moure'ns en el mapa, fer zoom i demanar informaci�. Si estem inserint una
                afectaci� tamb� tindrem els botons per digitalitzar.</li>
                <li><strong>Zoom a comarques i municipis:</strong> Hi ha tres desplegables que
                corresponen a les prov�ncies, a les comarques i als municipis. En triar
                una prov�ncia s'omplir� el desplegable de comarques amb les comarques
                d'aquella prov�ncia, i aix� igualment amb els municipis. Despr�s clicant
                el bot� 'Anar-hi' es fa un zoom a la comarca o municipi seleccionats.</li>
            </ul>
            <p>Passos per digitalitzar:</p>
            <ol>
                <li>Despr�s de tenir localitzat el lloc on volem digitalitzar el pol�gon cal
                pr�mer el bot� de digitalitzaci�.</li>
                <li>Premem amb el bot� esquerra del ratol� al mapa on volem comen�ar la digitalitzaci�
                i despr�s anem fent clics per anar creant el contorn del pol�gon. En el moment que premem
                dues vegades r�pidament amb el bot� dret del ratol� tancarem el pol�gon que estem
                digitalitzant. Per comprovar que hem acabat correctament la digitalitzaci� veiem
                que mentre estem digitalitzant, el punter del ratol� sobre el mapa t� un cercle de color
                taronja, per� que en acabar el punt� del ratol� torna a ser normal.</li>
            </ol>
            <img alt="ajuda cartografia digitalitzar" src="<c:url value='/grafics/ajudaMapaDigitalitzar.JPG' />" />
            <br/>
            <a href="<c:url value='/processionaria/ajuda.htm'/>?contingut=ajuda">Tornar a l'ajuda</a>
            </div>
            </div>
            <div id="ft">
                <%@ include file="/WEB-INF/jsp/Estructura/footer.jsp" %>
            </div>
        </div>
    </body>
</html>