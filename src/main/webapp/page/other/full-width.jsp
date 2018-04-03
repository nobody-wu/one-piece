<%@ page language="java" contentType="text/html; charset=UTF-8"%> 
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<html lang="en">

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
      <h1 class="mt-4 mb-3">Full Width
        <small>Subheading</small>
      </h1>

      <ol class="breadcrumb">
        <li class="breadcrumb-item">
          <a href="${ctx}/home/index">Home</a>
        </li>
        <li class="breadcrumb-item active">Full Width</li>
      </ol>

      <p>Most of Start Bootstrap's unstyled templates can be directly integrated into the Modern Business template. You can view all of our unstyled templates on our website at
        <a href="http://startbootstrap.com/template-categories/unstyled">http://startbootstrap.com/template-categories/unstyled</a>.</p>

    </div>
    <!-- /.container -->

    <jsp:include page="/page/footer.jsp"/>

  </body>

</html>
