<jsp:directive.include file="header.jsp"/>

<jsp:directive.include file="menu.jsp"/>

<c:if test="${pageContext.request.userPrincipal.name != null}">
	<h2 style="margin-left: 15px">
		Welcome ${pageContext.request.userPrincipal.name}!
	</h2>
</c:if>

<jsp:directive.include file="footer.jsp"/>