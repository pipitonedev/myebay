<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<header>
	<nav class="navbar navbar-expand-lg navbar-dark bg-danger"
		aria-label="Eighth navbar example">
		<div class="container-fluid">
			<a class="navbar-brand" href="index.jsp"> <b><i>My Ebay</i></b>
			</a>
			<button class="navbar-toggler" type="button"
				data-bs-toggle="collapse" data-bs-target="#navbarCollapse"
				aria-controls="navbarCollapse" aria-expanded="false"
				aria-label="Toggle navigation">
				<span class="navbar-toggler-icon"></span>
			</button>
			<div class="collapse navbar-collapse" id="navbarCollapse">
				<ul class="navbar-nav me-auto mb-2 mb-md-0">
					<li class="nav-item"><a class="nav-link active" href="#">Link</a>
					</li>
					<li class="nav-item"><a class="nav-link disabled" href="#"
						tabindex="-1" aria-disabled="true">Disabled</a></li>
						 <li class="nav-item dropdown">
            <a class="nav-link dropdown-toggle" href="#" id="dropdown07" data-bs-toggle="dropdown" aria-expanded="false">Dropdown</a>
            <ul class="dropdown-menu" aria-labelledby="dropdown07">
              <li><a class="dropdown-item" href="${pageContext.request.contextPath}/index.jsp">Home</a></li>
              <li><a class="dropdown-item" href="${pageContext.request.contextPath}/PrepareSearchRegistaServlet">Ricerca Registi</a></li>
              <li><a class="dropdown-item" href="${pageContext.request.contextPath}/PrepareInsertRegistaServlet">Inserisci Regista</a></li>
              <li><a class="dropdown-item" href="${pageContext.request.contextPath}/PrepareSearchFilmServlet">Ricerca Film</a></li>
              <li><a class="dropdown-item" href="${pageContext.request.contextPath}/PrepareInsertFilmServlet">Inserisci Film</a></li>
              
            </ul> 
          </li>
				</ul>
				<div class="col-md-3 text-end">
					<c:if test="${!userInfo.isLogged()}">
						<p class="navbar-text">
							<a href="${pageContext.request.contextPath}/login.jsp">Login</a>
						</p>
					</c:if>

					<c:if test="${userInfo.isLogged()}">
						<p class="navbar-text" style="color: #FFD700">
						Utente: ${userInfo.username } (${userInfo.nome } ${userInfo.cognome })
							<a href="${pageContext.request.contextPath}/LogoutServlet">Logout</a>
						</p>
					</c:if>
				</div>
			</div>
		</div>
	</nav>
</header>