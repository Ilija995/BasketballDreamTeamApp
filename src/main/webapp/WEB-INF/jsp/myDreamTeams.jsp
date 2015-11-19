<jsp:directive.include file="header.jsp" />

<jsp:directive.include file="menu.jsp" />

<div class="player-group" id="player_list">
	<!-- Dream Teams -->

	<c:if test="${fn:length(dreamTeams) eq 0}">
		<p>There is no previously created dream teams. <a role="button" class="btn btn-link btn-lg" href="newDreamTeam">Create one</a>.</p>

	</c:if>

	<c:forEach items="${dreamTeams}" var="dreamTeam">
		<div class="panel panel-default">
			<div class="panel-heading">
				<h3 class="panel-title">
					<a data-toggle="collapse" data-parent="#player_list"
					   href="#${dreamTeam.id}">
						<p>${dreamTeam.name} - <strong>${dreamTeam.score}</strong></p>
					</a>
				</h3>
			</div>
			<div id="${dreamTeam.id}" class="panel-collapse collapse">
				<div class="panel-body">
					<!-- collapsible igraca (centri)-->
					<div class="player-group" id="center_player_list">
						<c:forEach items="${dreamTeam.players}" var="playerPair">
							<div class="panel panel-default">
								<!-- osnovni info o igracu u zaglavlju -->
								<div class="panel_heading">
									<h4 class="panel-title">
										<a data-toggle="collapse" data-parent="#center_player_list"
										   href="#${playerPair.value.id}">
											<p><strong><c:out value="${playerPair.key.toValue()}" />:</strong><br/>
												<c:out value="${playerPair.value.firstName}" />
												<c:out value="${playerPair.value.lastName}" />
											</p>
										</a>
									</h4>
								</div>
								<!-- dodatne informacije o igracu -->
								<div class="panel-collapse collapse" id="${playerPair.value.id}">
									<p><strong>Team:</strong>
										<c:out value="${playerPair.value.team}" />
									</p>
									<p><strong>League:</strong>
										<c:out value="${playerPair.value.league}" />
									</p>
								</div>
							</div>
						</c:forEach>
					</div>
				</div>
			</div>
		</div>
	</c:forEach>
</div>

<jsp:directive.include file="footer.jsp" />