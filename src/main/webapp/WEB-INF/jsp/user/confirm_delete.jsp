<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<jsp:include page="../include/header.jsp"/>
<div id="formBin">
    <div class="formBin">
        <h2>Are you sure you wish to delete this card?</h2>
        <form:form class="mainForm" action="delete/${userCard.id}" method="post" modelAttribute="userCard">
            <h2>Card Number: ${userCard.id}<form:hidden path="id"/></h2>
            <span>First Name: ${userCard.fname}<br><br>Last Name: ${userCard.lname}</span>
            <br>
            <button type="submit">DELETE</button>
        </form:form>
        <a href="${pageContext.request.contextPath}../user">Cancel</a>
    </div>
</div>
<jsp:include page="../include/footer.jsp"/>