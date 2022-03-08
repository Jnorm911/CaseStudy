<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<jsp:include page="../include/header.jsp"/>
<div id="formBin">
    <div class="formBin">
        <h2>Are you sure you wish to cancel this product?</h2>
        <form:form class="mainForm" action="cancel/${userProd.id}" method="post" modelAttribute="userProd">
            <h2>Card Number: ${userProd.card.id}<form:hidden path="id"/></h2>
            <span>Type: ${userProd.type}<br></span>
            <br>
            <button type="submit">CONFIRM CANCEL</button>
        </form:form>
        <a href="${pageContext.request.contextPath}../user">Go Back</a>
    </div>
</div>
<jsp:include page="../include/footer.jsp"/>