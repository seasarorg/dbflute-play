<c:import url="${viewPrefix}/common/header.jsp">
	<c:param name="title" value="エラー通知"/>
</c:import>
<div class="contents">
	<h2><html:messages id="labels.error.message.title"/></h2>
	<html:errors/>
</div>
<c:import url="${viewPrefix}/common/footer.jsp"/>