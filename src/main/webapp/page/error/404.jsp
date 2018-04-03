<%@ page language="java" import="java.util.*" contentType="text/html; charset=UTF-8"%> 
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<html>
  <head>
    <meta charset="utf-8">
    <meta name="viewport" content="width=device-width, initial-scale=1, shrink-to-fit=no">
    <meta name="description" content="">
    <meta name="author" content="">
	<c:set var="ctx" value="${pageContext.request.contextPath}"/>
    <title>Modern Business - Start Bootstrap Template</title>

    <!-- Bootstrap core CSS -->
    <link href="${ctx}/css/bootstrap.min.css" rel="stylesheet">

    <!-- Custom styles for this template -->
    <link href="${ctx}/css/modern-business.css" rel="stylesheet">

  </head>

  <body>

    <jsp:include page="/page/head.jsp"/>

    <!-- Page Content -->
    <div class="container">

      <!-- Page Heading/Breadcrumbs -->
      <h1 class="mt-4 mb-3">404
        <small>Page Not Found</small>
      </h1>

      <ol class="breadcrumb">
        <li class="breadcrumb-item">
          <a href="${ctx}/home/index">Home</a>
        </li>
        <li class="breadcrumb-item active">404</li>
      </ol>

      <div class="jumbotron">
        <h1 class="display-1">404</h1>
        <p>The page you're looking for could not be found. Here are some helpful links to get you back on track:</p>
        <ul>
          <li>
            <a href="${ctx}/home/index">Home</a>
          </li>
          <li>
            <a href="${ctx}/home/about">About</a>
          </li>
          <li>
            <a href="${ctx}/service/services">Services</a>
          </li>
          <li>
            <a href="${ctx}/home/contact">Contact</a>
          </li>
          <li>
            Portfolio
            <ul>
              <li>
                <a href="${ctx}/portfolio/1">1 Column Portfolio</a>
              </li>
              <li>
                <a href="${ctx}/portfolio/2">2 Column Portfolio</a>
              </li>
              <li>
                <a href="${ctx}/portfolio/3">3 Column Portfolio</a>
              </li>
              <li>
                <a href="${ctx}/portfolio/4">4 Column Portfolio</a>
              </li>
            </ul>
          </li>
          <li>
            Blog
            <ul>
              <li>
                <a href="${ctx}/blog/home-1">Blog Home 1</a>
              </li>
              <li>
                <a href="${ctx}/blog/home-2">Blog Home 2</a>
              </li>
              <li>
                <a href="${ctx}/blog/post">Blog Post</a>
              </li>
            </ul>
          </li>
          <li>
            Other Pages
            <ul>
              <li>
                <a href="${ctx}/other/fullWidth">Full Width Page</a>
              </li>
              <li>
                <a href="${ctx}/other/sidebar">Sidebar Page</a>
              </li>
              <li>
                <a href="${ctx}/other/faq">FAQ</a>
              </li>
              <li>
                <a href="${ctx}/page/error/404.jsp">404 Page</a>
              </li>
              <li>
                <a href="${ctx}/other/pricing">Pricing Table</a>
              </li>
            </ul>
          </li>
        </ul>
      </div>
      <!-- /.jumbotron -->

    </div>
    <!-- /.container -->

   	<jsp:include page="/page/footer.jsp"/>

  </body>

</html>
