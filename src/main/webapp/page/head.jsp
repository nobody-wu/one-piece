	<!-- Navigation -->
    <nav class="navbar fixed-top navbar-expand-lg navbar-dark bg-dark fixed-top">
      <div class="container">
        <a class="navbar-brand" href="${pageContext.request.contextPath}/home/index">Start Bootstrap</a>
        <button class="navbar-toggler navbar-toggler-right" type="button" data-toggle="collapse" data-target="#navbarResponsive" aria-controls="navbarResponsive" aria-expanded="false" aria-label="Toggle navigation">
          <span class="navbar-toggler-icon"></span>
        </button>
        <div class="collapse navbar-collapse" id="navbarResponsive">
          <ul class="navbar-nav ml-auto">
            <li class="nav-item">
              <a class="nav-link" href="${pageContext.request.contextPath}/home/about">About</a>
            </li>
            <li class="nav-item">
              <a class="nav-link" href="${pageContext.request.contextPath}/service/services">Services</a>
            </li>
            <li class="nav-item">
              <a class="nav-link" href="${pageContext.request.contextPath}/home/contact">Contact</a>
            </li>
            <li class="nav-item dropdown">
              <a class="nav-link dropdown-toggle" href="#" id="navbarDropdownPortfolio" data-toggle="dropdown" aria-haspopup="true" aria-expanded="false">
                Portfolio
              </a>
              <div class="dropdown-menu dropdown-menu-right" aria-labelledby="navbarDropdownPortfolio">
                <a class="dropdown-item" href="${pageContext.request.contextPath}/portfolio/1">1 Column Portfolio</a>
                <a class="dropdown-item" href="${pageContext.request.contextPath}/portfolio/2">2 Column Portfolio</a>
                <a class="dropdown-item" href="${pageContext.request.contextPath}/portfolio/3">3 Column Portfolio</a>
                <a class="dropdown-item" href="${pageContext.request.contextPath}/portfolio/4">4 Column Portfolio</a>
                <a class="dropdown-item" href="${pageContext.request.contextPath}/portfolio/item">Single Portfolio Item</a>
              </div>
            </li>
            <li class="nav-item dropdown">
              <a class="nav-link dropdown-toggle" href="#" id="navbarDropdownBlog" data-toggle="dropdown" aria-haspopup="true" aria-expanded="false">
                Blog
              </a>
              <div class="dropdown-menu dropdown-menu-right" aria-labelledby="navbarDropdownBlog">
                <a class="dropdown-item" href="${pageContext.request.contextPath}/blog/home-1">Blog Home 1</a>
                <a class="dropdown-item" href="${pageContext.request.contextPath}/blog/home-2">Blog Home 2</a>
                <a class="dropdown-item" href="${pageContext.request.contextPath}/blog/post">Blog Post</a>
              </div>
            </li>
            <li class="nav-item dropdown">
              <a class="nav-link dropdown-toggle" href="#" id="navbarDropdownBlog" data-toggle="dropdown" aria-haspopup="true" aria-expanded="false">
                Other Pages
              </a>
              <div class="dropdown-menu dropdown-menu-right" aria-labelledby="navbarDropdownBlog">
                <a class="dropdown-item" href="${pageContext.request.contextPath}/other/full-width">Full Width Page</a>
                <a class="dropdown-item" href="${pageContext.request.contextPath}/other/sidebar">Sidebar Page</a>
                <a class="dropdown-item" href="${pageContext.request.contextPath}/other/faq">FAQ</a>
                <a class="dropdown-item" href="${pageContext.request.contextPath}/page/error/404.jsp">404</a>
                <a class="dropdown-item" href="${pageContext.request.contextPath}/other/pricing">Pricing Table</a>
              </div>
            </li>
          </ul>
        </div>
      </div>
    </nav>
     <!-- Bootstrap core JavaScript -->
    <script src="${pageContext.request.contextPath}/js/jquery.min.js"></script>
    <script src="${pageContext.request.contextPath}/js/bootstrap.bundle.min.js"></script>
    <!-- click item -->
    <script src="${pageContext.request.contextPath}/js/clickbar.js"></script>