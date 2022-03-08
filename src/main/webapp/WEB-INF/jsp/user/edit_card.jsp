<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@ taglib prefix="sec" uri="http://www.springframework.org/security/tags" %>
<jsp:include page="../include/header.jsp"/>
<div id="formBin">
    <div class="formBin">
        <h2>Edit Card</h2>
        <form:form class="mainForm" action="${pageContext.request.contextPath}saveCard" method="post" modelAttribute="userCard">
            <form:hidden path="user.id"/>
            <form:hidden path="products"/>
            <form:hidden style="text-align: center" path="id" />
            First Name:<form:input style="text-align: center" path="fname"/>
            Last Name:<form:input style="text-align: center" path="lname"/>
            Expire:<form:input style="text-align: center" path="expire"/>
            CVV:<form:input style="text-align: center" path="cvv"/>
            Brand:<form:input style="text-align: center" path="brand"/>
            <button type="submit">Save</button>
        </form:form>
        <a href="${pageContext.request.contextPath}../user">Cancel</a>
    </div>
</div>
<jsp:include page="../include/footer.jsp"/>