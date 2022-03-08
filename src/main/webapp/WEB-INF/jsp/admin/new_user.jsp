<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<jsp:include page="../include/header.jsp"/>
<div id="formBin">
    <div class="formBin">
        <h2>User Details</h2>
        <form:form class="mainForm" modelAttribute="user">
            <h2>ID: ${user.id}<form:hidden path="id"/></h2>
            <span>User: ${user.username}<br><br>Email: ${user.email}<br><br>Password: ${user.password}</span>
            <br>
        </form:form>
        <a href="${pageContext.request.contextPath}../admin">Confirm</a>
        <br>
        <br>
    </div>
</div>
<jsp:include page="../include/footer.jsp"/>