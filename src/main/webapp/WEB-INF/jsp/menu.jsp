
<c:url value="/logout" var="logoutUrl" />
<form action="${logoutUrl}" method="post" id="logoutForm">
	<input type="hidden" name="${_csrf.parameterName}"
	       value="${_csrf.token}" />
</form>

<div id="menu-wrapper">
	<a role="button" class="btn btn-link btn-lg menu-button" href="NewDreamTeam">New Dream Team</a>
	<a role="button" class="btn btn-link btn-lg menu-button" href="MyDreamTeams">My Dream Teams</a>
	<a role="button" class="btn btn-link btn-lg menu-button" href="javascript:formSubmit()"> Logout</a>
</div>