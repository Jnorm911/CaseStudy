
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<!doctype html>
<html class="no-js" lang="">

<head>
    <meta charset="utf-8">
    <title>Home</title>
    <meta name="viewport" content="width=device-width, initial-scale=1">
    <spring:url value="/theme1/css/main.css" var="mainCss"/>
    <link href="${mainCss}" rel="stylesheet"/>
    <link rel="preconnect" href="https://fonts.googleapis.com">
    <link rel="preconnect" href="https://fonts.gstatic.com" crossorigin>
    <link href="https://fonts.googleapis.com/css2?family=Josefin+Sans&family=Rubik&display=swap" rel="stylesheet">
    <meta name="theme-color" content="#282a36">
    <script src="https://kit.fontawesome.com/a4ea25a405.js" crossorigin="anonymous"></script>
</head>
<body>
<div id="lockSize">
    <header>
        <div id="olNav" class="olNav">
            <a href="javascript:void(0)" class="olClose" onclick="closeNav()">&times;</a>
            <div class="olLinks">
                <spring:url value="/register" var="register" htmlEscape="true"/>
                <a href="${register}">Register</a>
                <spring:url value="/login" var="login" htmlEscape="true"/>
                <a href="${login}">Login</a>
                <spring:url value="/about" var="about" htmlEscape="true"/>
                <a href="${about}">About</a>
                <spring:url value="/about#contact" var="contact" htmlEscape="true"/>
                <a href="${contact}">Contact</a>
                <a href="${pageContext.request.contextPath}login/logout">Logout</a>
            </div>
        </div>
        <div class="hbMenu" onclick="openNav()">&#9776;</div>
        <div class="profile">
            <a href="${login}" class="profileIcon"><i class="fas fa-user-circle"></i></a>
        </div>
        <div class="heroHome">
            <div class="hero-text">
                <h1>RCN</h1>
                <h2>Random Company Name</h2>
            </div>
        </div>
    </header>
