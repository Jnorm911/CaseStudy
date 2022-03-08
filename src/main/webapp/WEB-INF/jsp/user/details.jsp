<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@ taglib prefix="sec" uri="http://www.springframework.org/security/tags" %>
<jsp:include page="../include/header.jsp"/>
<div id="formBin">
    <div class="formBin">
        <h2>Edit User</h2>
        <form:form class="mainForm" action="${pageContext.request.contextPath}editSave" method="post" modelAttribute="user">
            <span><form:hidden path="id"/></span>
            <form:hidden style="text-align: center" path="username" />
            Email:<form:input style="text-align: center" path="email"/>
            Password:<form:input type="password" style="text-align: center" path="password"/>
            <button type="submit">Save</button>
        </form:form>
        <a href="${pageContext.request.contextPath}../user">Cancel</a>
    </div>
</div>
<jsp:include page="../include/footer.jsp"/>