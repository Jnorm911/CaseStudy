<%--@elvariable id="errorMessage" type=""--%>
<jsp:include page="../include/header.jsp" />

<div id="formBin">
	<div class="formBin">
		<h1>Sign in</h1>
		<div class="socialBin">
			<a href="#" class="loginSocial"><i class="fab fa fa-google fa-2x"></i></a>
			<a href="#" class="loginSocial"><i class="fab fa-facebook-square fa-2x"></i></a>
			<a href="#" class="loginSocial"><i class="fab fa-twitter fa-2x"></i></a>
		</div>
<form class="mainForm" action="${pageContext.request.contextPath}loginSecurityPost" method="POST">
	<label for="username">Email</label>
	<input type="text" id="username" name="username" placeholder="Email">
	<label for="password">Password</label>
	<input type="password" id="password" name="password" placeholder="Password">
	<button type="submit">Sign in</button>
	<div class="formSpace">
		<a href="#">Forgot your password?</a>
	</div>
</form>
</div>
<div class="formBin">
	<span>Don't have an account? <a href="${pageContext.request.contextPath}register">Sign up</a></span>
</div>
</div>
<jsp:include page="../include/footer.jsp" />