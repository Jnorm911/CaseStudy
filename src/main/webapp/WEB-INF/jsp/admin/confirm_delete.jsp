<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<jsp:include page="../include/header.jsp"/>
<div id="formBin">
    <div class="formBin">
        <h2>Are you sure you wish to delete user</h2>
        <form:form class="mainForm" action="delete/${user.id}" method="post" modelAttribute="user">
            <h2>ID: ${user.id}<form:hidden path="id"/></h2>
            <span>User: ${user.username}<br><br>Email: ${user.email}</span>
            <br>
            <button type="submit">DELETE</button>
        </form:form>
    </div>
</div>
<jsp:include page="../include/footer.jsp"/>