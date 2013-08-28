<%@include file="/libs/foundation/global.jsp"%>
<body>
<div class="container">
	<div class="row">
		<div class="span12">
			<cq:include path="topnav" resourceType="sandbox/components/topnav" />
		</div>
	</div>
	<div class="row">
		<cq:include script="left.jsp" />
		<cq:include script="center.jsp" />
		<cq:include script="right.jsp" />
	</div>
	<footer>
		<cq:include path="toolbar" resourceType="foundation/components/toolbar"/>
	</footer>
</div>
</body>