<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<jsp:include page="../include/header.jsp"/>
<div id="formBin">
    <div class="formBin">
        <h2>Thanks for signing up!</h2>
        <form:form class="mainForm" method="get" modelAttribute="user">
            <span>User: ${user.username}<br><br>Email: ${user.email}<br></span>
            <br>
        </form:form>
        <a href="${pageContext.request.contextPath}/">Return Home</a>
        <br>
        <br>
    </div>
</div>
<jsp:include page="../include/footer.jsp"/>