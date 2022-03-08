<%@ taglib prefix="spring" uri="http://www.springframework.org/tags" %>
<jsp:include page="../include/header.jsp"/>
<div id="formBin">
    <div class="formBin">
        <h1>Register</h1>
        <div class="socialBin">
            <a href="#" class="loginSocial"><i class="fab fa fa-google fa-2x"></i></a>
            <a href="#" class="loginSocial"><i class="fab fa-facebook-square fa-2x"></i></a>
            <a href="#" class="loginSocial"><i class="fab fa-twitter fa-2x"></i></a>
        </div>
        <form class="mainForm" action="${pageContext.request.contextPath}register/save_user" method="post">
            <label for="userName">Enter Username</label>
            <input type="text" id="userName" name="username" placeholder="Username" pattern="^[a-zA-Z0-9_-]{5,20}$" style="text-align: center" required>
            <label for="email">Enter E-mail</label>
            <input type="email" id="email" name="email" placeholder="E-mail" pattern="[a-z0-9._%+-]+@[a-z0-9.-]+\.[a-z]{2,}$" style="text-align: center" required>
            <label for="password">Enter Password</label>
            <input type="text" id="password" name="password" placeholder="Password" style="text-align: center" pattern="^(?=.*?[A-Z])(?=.*?[a-z])(?=.*?[0-9])(?=.*?[#?!@$ %^&*-]).{8,}$" required>

            <label for="confirmPassword">Confirm Password</label>
            <input type="text" id="confirmPassword" name="confirmPassword" placeholder="Confirm Password" style="text-align: center" required>

            <button type="submit">Submit</button>
        </form>
    </div>
    <div class="formBin">
        <spring:url value="/login" var="login" htmlEscape="true"/>
        <span>Already have an account? <a href="${login}">Sign in</a></span>
    </div>
</div>
<jsp:include page="../include/footer.jsp"/>