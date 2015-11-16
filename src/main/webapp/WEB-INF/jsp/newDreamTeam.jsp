<jsp:directive.include file="header.jsp" />

<jsp:directive.include file="menu.jsp"/>

<form method="POST" action="/ChooseDreamTeam" onsubmit="submitCheck()">
	<div class="row" style="padding-top: 0.5cm;">
		<div class="col-sm-12" id="team_name_text_box">
			Dream Team name:
			<input type="text" name="teamName" id="teamName" />
		</div>
		<div class="col-sm-2" id="pg_slot">
			PG:
			<input type="hidden" name="pgId" id="pgId" />
			<p id="pg_name">N/A</p>

		</div>
		<div class="col-sm-2" id="sg_slot">
			SG:
			<input type="hidden" name="sgId" id="sgId" />
			<p id="sg_name">N/A</p>

		</div>
		<div class="col-sm-2" id="sf_slot">
			SF
			<input type="hidden" name="sfId" id="sfId" />
			<p id="sf_name">N/A</p>

		</div>
		<div class="col-sm-2" id="pf_slot">
			PF
			<input type="hidden" name="pfId" id="pfId" />
			<p id="pf_name">N/A</p>

		</div>
		<div class="col-sm-2" id="c_slot">
			C
			<input type="hidden" name="cId" id="cId" />
			<p id="c_name">N/A</p>

		</div>
	</div>
	<div class="row" id="acknowledge_button">
		<input type="submit" class="btn btn-success submit_dugme" value="Acknowledge your dream team picks" id="btn_submit" />
	</div>
</form>

<div class="player-group" id="player_list">
	<!-- Center -->
	<div class="panel panel-default">
		<div class="panel-heading">
			<h3 class="panel-title">
				<a data-toggle="collapse" data-parent="#player_list"
				   href="#collapse_c_position">
					<p>Centers</p>
				</a>
			</h3>
		</div>
		<div id="collapse_c_position" class="panel-collapse collapse">
			<div class="panel-body">
				<!-- collapsible igraca (centri)-->
				<div class="player-group panel-scroll" id="center_player_list">
					<c:forEach items="${C}" var="centerPlayer">

						<div class="panel panel-default">
							<!-- osnovni info o igracu u zaglavlju -->
							<div class="panel_heading">
								<h4 class="panel-title">
									<a data-toggle="collapse" data-parent="#center_player_list"
									   href="#${centerPlayer.id}">
										<p>
											<c:out value="${centerPlayer.firstName}" />
											<c:out value="${centerPlayer.lastName}" />
										</p>
										<p class="hiddenid">
											<c:out value="${centerPlayer.id}"/>
										</p>
									</a>
								</h4>
								<button type="button" class="btn btn-primary dugme_centri">Add player to your dream team</button>
							</div>
							<!-- dodatne informacije o igracu -->
							<div class="panel-collapse collapse" id="${centerPlayer.id}">
								<p><strong>Team: </strong>
									<c:out value="${centerPlayer.team}" />
								</p>
								<p><strong>League: </strong>
									<c:out value="${centerPlayer.league}" />
								</p>
							</div>
						</div>
					</c:forEach>
				</div>
			</div>
		</div>
	</div>

	<!-- Power Forward -->
	<div class="panel panel-default">
		<div class="panel-heading">
			<h3 class="panel-title">
				<a data-toggle="collapse" data-parent="#player_list"
				   href="#collapse2"> Power Forwards </a>
			</h3>
		</div>
		<div id="collapse2" class="panel-collapse collapse">
			<div class="panel-body">
				<!-- power forward player group -->
				<div class="player-group panel-scroll" id="pf_player_list">
					<c:forEach items="${PF}" var="pfPlayer">
						<div class="panel panel-default">
							<!-- osnovni info o igracu u zaglavlju -->
							<div class="panel_heading">
								<h4 class="panel-title">
									<a data-toggle="collapse" data-parent="#pf_player_list"
									   href="#pf_player1">
										<p>
											<c:out value="${pfPlayer.firstName}" />
											<c:out value="${pfPlayer.lastName}" />
										</p>
										<p class="hiddenid">
											<c:out value="${pfPlayer.id}"/>
										</p>
									</a>
								</h4>
								<button type="button" class="btn btn-primary pf_dugme">Add player to your dream team</button>
							</div>
							<!-- dodatne informacije o igracu -->
							<div class="panel-collapse collapse" id="pf_player1">
								<p><strong>Team: </strong>
									<c:out value="${pfPlayer.team}" />
								</p>
								<p><strong>League: </strong>
									<c:out value="${pfPlayer.league}" />
								</p>
							</div>
						</div>
					</c:forEach>
				</div>
			</div>
		</div>
	</div>

	<!-- Small Forward -->
	<div class="panel panel-default">
		<div class="panel-heading">
			<h3 class="panel-title">
				<a data-toggle="collapse" data-parent="#player_list"
				   href="#collapse3"> Small Forwards </a>
			</h3>
		</div>
		<div id="collapse3" class="panel-collapse collapse">
			<div class="panel-body">
				<!-- power forward player group -->
				<div class="player-group panel-scroll" id="sf_player_list">
					<c:forEach items="${SF}" var="sfPlayer">
						<div class="panel panel-default">
							<!-- osnovni info o igracu u zaglavlju -->
							<div class="panel_heading">
								<h4 class="panel-title">
									<a data-toggle="collapse" data-parent="#sf_player_list"
									   href="#sf_player1">
										<p>
											<c:out value="${sfPlayer.firstName}" />
											<c:out value="${sfPlayer.lastName}" />
										</p>
										<p class="hiddenid">
											<c:out value="${sfPlayer.id}"/>
										</p>
									</a>
								</h4>
								<button type="button" class="btn btn-primary sf_dugme">Add player to your dream team</button>
							</div>
							<!-- dodatne informacije o igracu -->
							<div class="panel-collapse collapse" id="sf_player1">
								<p><strong>Team: </strong>
									<c:out value="${sfPlayer.team}" />
								</p>
								<p><strong>League: </strong>
									<c:out value="${sfPlayer.league}" />
								</p>
							</div>
						</div>
					</c:forEach>
				</div>
			</div>
		</div>
	</div>

	<!-- Shooting Guard -->
	<div class="panel panel-default">
		<div class="panel-heading">
			<h3 class="panel-title">
				<a data-toggle="collapse" data-parent="#player_list"
				   href="#collapse4"> Shooting Guards </a>
			</h3>
		</div>
		<div id="collapse4" class="panel-collapse collapse">
			<div class="panel-body">
				<!-- power forward player group -->
				<div class="player-group panel-scroll" id="sg_player_list">
					<c:forEach items="${SG}" var="sgPlayer">
						<div class="panel panel-default">
							<!-- osnovni info o igracu u zaglavlju -->
							<div class="panel_heading">
								<h4 class="panel-title">
									<a data-toggle="collapse" data-parent="#sg_player_list"
									   href="#sg_player1">
										<p>
											<c:out value="${sgPlayer.firstName}" />
											<c:out value="${sgPlayer.lastName}" />
										</p>
										<p class="hiddenid">
											<c:out value="${sgPlayer.id}"/>
										</p>

									</a>
								</h4>
								<button type="button" class="btn btn-primary sg_dugme">Add player to your dream team</button>
							</div>
							<!-- dodatne informacije o igracu -->
							<div class="panel-collapse collapse" id="sg_player1">
								<p><strong>Team: </strong>
									<c:out value="${sgPlayer.team}" />
								</p>
								<p><strong>League: </strong>
									<c:out value="${sgPlayer.league}" />
								</p>
							</div>
						</div>
					</c:forEach>
				</div>
			</div>
		</div>
	</div>

	<!-- Point Guard -->
	<div class="panel panel-default">
		<div class="panel-heading">
			<h3 class="panel-title">
				<a data-toggle="collapse" data-parent="#player_list"
				   href="#collapse5"> Point Guards </a>
			</h3>
		</div>
		<div id="collapse5" class="panel-collapse collapse">
			<div class="panel-body">
				<!-- power forward player group -->
				<div class="player-group panel-scroll" id="pg_player_list">
					<c:forEach items="${PG}" var="pgPlayer">
						<div class="panel panel-default">
							<!-- osnovni info o igracu u zaglavlju -->
							<div class="panel_heading">
								<h4 class="panel-title">
									<a data-toggle="collapse" data-parent="#pg_player_list"
									   href="#pg_player1">
										<p>
											<c:out value="${pgPlayer.firstName}" />
											<c:out value="${pgPlayer.lastName}" />
										</p>
										<p class="hiddenid">
											<c:out value="${pgPlayer.id}"/>
										</p>
									</a>
								</h4>
								<button type="button" class="btn btn-primary pg_dugme">Add player to your dream team</button>
							</div>
							<!-- dodatne informacije o igracu -->
							<div class="panel-collapse collapse" id="pg_player1">
								<p><strong>Team: </strong>
									<c:out value="${pgPlayer.team}" />
								</p>
								<p><strong>League: </strong>
									<c:out value="${pgPlayer.league}" />
								</p>
							</div>
						</div>
					</c:forEach>
				</div>
			</div>


		</div>
	</div>
</div>

<script type="text/javascript" src="js/newDreamTeam.js"></script>

<jsp:directive.include file="footer.jsp" />