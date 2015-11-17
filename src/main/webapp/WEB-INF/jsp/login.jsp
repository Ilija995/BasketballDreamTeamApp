<jsp:directive.include file="header.jsp"/>


<c:if test="${not empty error}">
	<div class="error">${error}</div>
</c:if>
<c:if test="${not empty msg}">
	<div class="msg">${msg}</div>
</c:if>
<form method="POST" action="/login" onsubmit="submitCheck()">
	<div class="row">
		<div class="col-sm-5" id="login-page-title-wrapper">
			<h1 id="login-page-title">
				Hello! Login with your username and password.
			</h1>
		</div>
	</div>
	<div class="row">
		<div class="col-sm-2" id="username-slot">
			Username:
			<input type="text" name="username" id="username"/>
		</div>
	</div>
	<div class="row">
		<div class="col-sm-2" id="password-slot">
			Password:
			<input type="password" name="password" id="password"/>
		</div>
	</div>
	<div class="row" id="submit-button-wrapper">
		<input type="submit" class="btn btn-success submit-button" value="Login" id="login-submit-btn"/>
	</div>

	<input type="hidden" name="${_csrf.parameterName}" value="${_csrf.token}"/>

</form>

<jsp:directive.include file="footer.jsp"/>