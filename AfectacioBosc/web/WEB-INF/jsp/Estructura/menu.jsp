<script type="text/javascript">
    function anarANevades(){
        document.tipusaplicacio.tipus.value="<c:url value='/nevades/llistarnevades.htm'/>";
    }
</script>
<div id="menuprocessionaria" class="yuimenubar yuimenubarnav">
	<div class="bd">
		<ul id="navmenu-h" class="first-of-type">
                    <li class="yuimenubaritem mprocessionaria">
                        <a href="<c:url value='/processionaria/llistarprocessionaries.htm'/>">
                            <fmt:message key="processionaria" bundle="${bundleAfectacio}" />
                        </a>
                    </li>
                    <li class="yuimenubaritem mdanysabiotics">
                        <a href="<c:url value='/danysabiotics/llistardanysabiotics.htm'/>">
                            <fmt:message key="danysAbiotics" bundle="${bundleAfectacio}" />
                        </a>
                    </li>
                    <li class="yuimenubaritem msequera">
                        <a href="<c:url value='/sequeres/llistarsequeres.htm'/>">
                            <fmt:message key="seguimentSequera" bundle="${bundleAfectacio}" />
                        </a>
                    </li>
		</ul>                
	</div>
</div>