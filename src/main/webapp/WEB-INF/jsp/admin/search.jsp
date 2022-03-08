<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<jsp:include page="../include/header.jsp"/>
<div id="formBin">
    <div class="formBin">
        <h2>Search Results</h2>
        <div class="searchTable">
            <table border="1" cellpadding="5">
                <tr>
                    <th>ID</th>
                    <th>User Name</th>
                    <th>E-mail</th>
                    <th>Password</th>
                    <th>Options</th>
                </tr>
                <jsp:useBean id="result" scope="request" type="java.util.List"/>
                <c:forEach items="${result}" var="user">
                    <tr>
                        <td>${user.id}</td>
                        <td>${user.username}</td>
                        <td>${user.email}</td>
                        <td>${user.password}</td>
                        <td>
                            <a href="${pageContext.request.contextPath}edit?id=${user.id}">Edit</a><br>
                            <a href="${pageContext.request.contextPath}users/delete?id=${user.id}">Delete</a>
                        </td>
                    </tr>
                </c:forEach>
            </table>
        </div>
        <br>
        <a href="../admin">Return to admin page <br></a>
        <br>
    </div>
</div>
<jsp:include page="../include/footer.jsp"/>