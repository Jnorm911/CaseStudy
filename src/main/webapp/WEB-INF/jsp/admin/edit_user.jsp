<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<jsp:include page="../include/header.jsp"/>
<div id="formBin">
    <div class="formBin">
        <h2>Edit User</h2>
        <form:form class="mainForm" action="${pageContext.request.contextPath}editSave" method="post" modelAttribute="user">
            <span>ID:${user.id}<form:hidden path="id"/></span>
            <br>
            User Name:<form:input style="text-align: center" path="username" />
            Email:<form:input style="text-align: center" path="email"/>
            Password:<form:input style="text-align: center" path="password"/>
            <button type="submit">Save</button>
        </form:form>
    </div>
</div>
<jsp:include page="../include/footer.jsp"/>