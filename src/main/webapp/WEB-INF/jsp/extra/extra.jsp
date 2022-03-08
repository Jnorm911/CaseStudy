<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<jsp:include page="../include/header.jsp"/>
<form:form class="mainForm" modelAttribute="answer">

    ${answer};

    <img src="${pageContext.request.contextPath}/bridge.jpg" alt="">

    <br>
    <br>

    <iframe width="640" height="360" src="https://www.youtube.com/embed/dQw4w9WgXcQ" frameborder="0"
            allowfullscreen></iframe>

</form:form>
<jsp:include page="../include/footer.jsp"/>