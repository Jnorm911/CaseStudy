<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<jsp:useBean id="formBeanKey" scope="request" type="perscholas.database.form.AdminNewForm"/>
<jsp:include page="../include/header.jsp"/>
<div id="formBin">
    <div class="formBin">
        <h1>Admin</h1>
        <h2>Create New User</h2>
        <div class="profile2">
            <a href="#" class="profileIcon" onclick="on()"><i class="fas fa-user-circle"></i></a>
        </div>
        <div id="hiddenForm">
            <h2>New User</h2>
            <form class="mainForm" action="${pageContext.request.contextPath}../admin/save" method="post" modelAttribute="user">
                <label for="userName"></label>
                <input type="text" id="userName" name="username" value="${formBeanKey.username}" placeholder="Username" pattern="^[a-zA-Z0-9_-]{5,20}$" style="text-align: center" required>
                <label for="email"></label>
                <input type="email" id="email" name="email" value="${formBeanKey.email}" placeholder="E-mail" pattern="[a-z0-9._%+-]+@[a-z0-9.-]+\.[a-z]{2,}$" style="text-align: center" required>
                <label for="password"></label>
                <input type="text" id="password" name="password" placeholder="Password" style="text-align: center" pattern="^(?=.*?[A-Z])(?=.*?[a-z])(?=.*?[0-9])(?=.*?[#?!@$ %^&*-]).{8,}$" required>
                <button type="submit">Submit</button>
            </form>
        </div>
        <div class="space">
            <c:forEach items="${formBeanKey.errorMessages}" var="message">
                <span style="color:#ff79c6">ERROR: ${message}<br></span><br>
            </c:forEach>
        </div>

    </div>

    <div class="formBin">
        <h2>Search Users</h2>
        <form class="mainForm" method="get" action="${pageContext.request.contextPath}admin/search">
            <label for="keyword">Search Here</label>
            <input style="text-align: center" type="text" id="keyword" name="keyword" placeholder="Search User"/>
            <button type="submit">Search</button>
        </form>
    </div>
</div>
<jsp:include page="../include/footer.jsp"/>