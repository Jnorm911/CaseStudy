<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@ taglib prefix="sec" uri="http://www.springframework.org/security/tags" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<jsp:include page="../include/header.jsp"/>
<div id="formBin">
    <div class="formBin">
        <h2>User Details</h2>
        <div class="mainForm">
            <form:form class="mainForm" modelAttribute="user">
                <form:hidden path="id"/>
                <span>User: ${user.username}<br><br>Email: ${user.email}<br><br>Password: *******</span>
                <br>
            </form:form>
        </div>
        <sec:authentication var="user" property="name"/>
        <a href="${pageContext.request.contextPath}../user/edit?id=${user}">Edit</a><br>
        <br>
    </div>
    <div class="formBin">
        <h2>Billing</h2>
        <form:form>
            <h3>Cards</h3>
            <div class="searchTable">
                <table border="1" cellpadding="5">
                    <tr>
                        <th>Card Number</th>
                        <th>First Name</th>
                        <th>Last Name</th>
                        <th>Options</th>
                    </tr>
                    <c:forEach items="${userCard}" var="userCard">
                        <tr>
                            <td>${userCard.id}</td>
                            <td>${userCard.fname}</td>
                            <td>${userCard.lname}</td>
                            <td>
                                <a href="${pageContext.request.contextPath}user/editCard?id=${userCard.id}">Edit</a><br>
                                <a href="${pageContext.request.contextPath}user/delete?id=${userCard.id}">Delete</a>
                            </td>
                        </tr>
                    </c:forEach>
                </table>
            </div>
        </form:form>
    </div>
    <br>
    <div class="formBin">
        <h2>Products</h2>
        <form:form>
            <div class="searchTable">
                <table border="1" cellpadding="5">
                    <tr>
                        <th>Type</th>
                        <th>Renew</th>
                        <th>Card</th>
                        <th>Options</th>
                    </tr>
                    <c:forEach items="${userProd}" var="userProd">
                        <tr>
                            <td>${userProd.type}</td>
                            <td>${userProd.renew}</td>
                            <td>${userProd.card.id}</td>
                            <td>
                                <a href="${pageContext.request.contextPath}user/editProd?id=${userProd.id}">Edit</a><br>
                                <a href="${pageContext.request.contextPath}user/cancel?id=${userProd.id}">Cancel</a>
                            </td>
                        </tr>
                    </c:forEach>
                </table>
            </div>
        </form:form>
    </div>
</div>
<jsp:include page="../include/footer.jsp"/>