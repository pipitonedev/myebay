<%@ taglib prefix = "fmt" uri = "http://java.sun.com/jsp/jstl/fmt" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!doctype html>
<html lang="it" class="h-100" >
	 <head>

	 	<!-- Common imports in pages -->
	 	<jsp:include page="../header.jsp" />
	 	
	   <title>Visualizza Elemento</title>
	   
	 </head>
	   <body class="d-flex flex-column h-100">
	   
	   		<!-- Fixed navbar -->
	   		<jsp:include page="../navbar.jsp"></jsp:include>
	    
			
			<!-- Begin page content -->
			<main class="flex-shrink-0">
			  <div class="container">
			  
			  
			  		<div class="alert alert-danger alert-dismissible fade show  ${successMessage==null?'d-none':'' }" role="alert">
				 ${errorMessage}
				  <button type="button" class="btn-close" data-bs-dismiss="alert" aria-label="Close" ></button>
				</div>
			  		<div class='card'>
					    <div class='card-header'>
					        <h5>Visualizza dettaglio</h5>
					    </div>
					    
					
					    <div class='card-body'>
					    	<dl class="row">
							  <dt class="col-sm-3 text-right">Id:</dt>
							  <dd class="col-sm-9">${show_annuncio_attr.id}</dd>
					    	</dl>
					    	
					    	<dl class="row">
							  <dt class="col-sm-3 text-right">Testo Annuncio:</dt>
							  <dd class="col-sm-9">${show_annuncio_attr.testoAnnuncio}</dd>
					    	</dl>
					    	
					    	<dl class="row">
							  <dt class="col-sm-3 text-right">Prezzo:</dt>
							  <dd class="col-sm-9">${show_annuncio_attr.prezzo}</dd>
					    	</dl>
					    	
					    	<dl class="row">
							  <dt class="col-sm-3 text-right">Data Pubblicazione Annuncio:</dt>
							  <dd class="col-sm-9"><fmt:formatDate type = "date" value = "${show_annuncio_attr.dataAnnuncio}" /></dd>
					    	</dl>
					    	
							<dl class="row">
								<dt class="col-sm-3 text-right">Categoria/e:</dt>
								<c:forEach items="${show_annuncio_attr.categorie}" var="categoriaItem">
									 <dd class="col-sm-9">${categoriaItem.descrizione}</dd>
								</c:forEach>
							</dl>
							
					    	
					    </div>
					    <!-- end card body -->
					    <c:if test="${userInfo.isLogged()}">
					    <div class='card-footer'>
					    	<form action="${pageContext.request.contextPath}/user/ExecuteAcquistaAnnuncioServlet" method="post">
					    		<input type="hidden" name="idAnnuncio" value="${show_annuncio_attr.id}">
					    		<input type="hidden" name="from" value="${pageContext.request.requestURI}">
						    	<button type="submit" name="submit" id="submit" class="btn btn-primary">Acquista</button>
						        <a href="list.jsp" class='btn btn-outline-secondary' style='width:80px'>
						            <i class='fa fa-chevron-left'></i> Back
						        </a>
					        </form>
					    </div>
					    </c:if>
					    
					     <c:if test="${!userInfo.isLogged()}">
					    <div class='card-footer'>
					    	<form action="${pageContext.request.contextPath}/PreparaLoginServlet" method="post">
					    		<input type="hidden" name="idAnnuncio" value="${show_annuncio_attr.id}">
					    		<input type="hidden" name="from" value="${pageContext.request.requestURI}">
						    	<button type="submit" name="submit" id="submit" class="btn btn-primary">Acquista</button>
						        <a href="list.jsp" class='btn btn-outline-secondary' style='width:80px'>
						            <i class='fa fa-chevron-left'></i> Back
						        </a>
					        </form>
					    </div>
					    </c:if>
					<!-- end card -->
					</div>	
			  
			    
			  <!-- end container -->  
			  </div>
			  
			</main>
			
			<!-- Footer -->
			<jsp:include page="../footer.jsp" />
	  </body>
</html>