        <% if (org.acegisecurity.context.SecurityContextHolder.getContext().getAuthentication() != null &&
                org.acegisecurity.context.SecurityContextHolder.getContext().getAuthentication().getName() != null &&
                !"".equals(org.acegisecurity.context.SecurityContextHolder.getContext().getAuthentication().getName().trim())) {
            //response.sendRedirect("logout.htm");
            response.sendRedirect("/AfectacioBosc/processionaria/llistarprocessionaries.htm");
        }
        %>
        <div class="login_inici">
            <c:set var="txtUsuari"><fmt:message key="Login.jlUsuari.text" bundle="${bundleSeguretat}" /></c:set>
            <c:set var="txtPwd"><fmt:message key="Login.jlContrassenya.text" bundle="${bundleSeguretat}" /></c:set>
            <c:set var="txtOK"><fmt:message key="Login.jbAcceptar.text" bundle="${bundleSeguretat}" /></c:set>
            <form name="formulari" method="POST" action="<c:url value='/seguretat/j_acegi_security_check'/>">
                <p class="errorlogin">
                <%  String classe = "";
                    if("1".equals(request.getParameter("login_error"))){
                        classe = "class='errorlogin'";%>
                        <fmt:message key="loginIncorrecte" bundle="${bundleSIPAN}" />
                <%}%>
                </p>
                <div class="controls_login">
                <p class="usuari">
                <label <%= classe%> for="j_username">${txtUsuari}:</label>
                <input type="text" id="usuari" name="usuari" onKeyPress="javascript:document.formulari.j_password.value=calcMD5(document.formulari.pwd.value).toUpperCase();document.formulari.j_username.value=document.formulari.usuari.value+'$'+getIP();return submitenter(this,event);">
                <input type="hidden" id="j_username" name="j_username">
                </p>
                <div class="separador_files_taula"></div>
                <p class="pwd">
                <label <%= classe%> for="j_password">${txtPwd}:</label>
                <input type="password" id="pwd" name="pwd"  onKeyPress="javascript:document.formulari.j_password.value=calcMD5(document.formulari.pwd.value).toUpperCase();document.formulari.j_username.value=document.formulari.usuari.value+'$'+getIP();return submitenter(this,event);">
                <input type="hidden" id="j_password" name="j_password">
                </p>
                <a class="boto" href="#" onClick="javascript:document.formulari.j_password.value=calcMD5(document.formulari.pwd.value).toUpperCase();document.formulari.j_username.value=document.formulari.usuari.value+'$'+getIP();document.formulari.submit();return false;">${txtOK}</a>
                </div>
            </form>
        </div>