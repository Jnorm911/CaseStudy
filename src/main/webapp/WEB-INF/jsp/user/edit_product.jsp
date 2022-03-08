<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@ taglib prefix="sec" uri="http://www.springframework.org/security/tags" %>
<jsp:include page="../include/header.jsp"/>
<div id="formBin">
    <div class="formBin">
        <h2>Edit Product</h2>
        <form:form class="mainForm" action="${pageContext.request.contextPath}saveProd" method="post" modelAttribute="userProd">
            <form:hidden path="user.id"/>
            <form:hidden style="text-align: center" path="id" />
            Card Number:<form:input style="text-align: center" path="card"/>
            Type:<form:input style="text-align: center" path="type"/>
            Renew:<form:input style="text-align: center" path="renew"/>
            Cycle:<form:input style="text-align: center" path="cycle"/>
            Renew Date:<form:input style="text-align: center" path="renewDate"/>
            <button type="submit">Save</button>
        </form:form>
        <a href="${pageContext.request.contextPath}../user">Cancel</a>
    </div>
</div>
<jsp:include page="../include/footer.jsp"/>