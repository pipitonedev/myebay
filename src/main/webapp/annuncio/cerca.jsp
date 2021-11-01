<!doctype html>
<html lang="it" class="h-100" >
	 <head>
	 
	 	<!-- Common imports in pages -->
	 	<jsp:include page="../header.jsp" />
	   
	   <title>Ricerca</title>
	 </head>
	   <body class="d-flex flex-column h-100">
	   
	   		<!-- Fixed navbar -->
	   		<jsp:include page="../navbar.jsp"></jsp:include>
	    
			
			<!-- Begin page content -->
			<main class="flex-shrink-0">
			  <div class="container">
			  
			  		<div class="alert alert-danger alert-dismissible fade show ${errorMessage==null?'d-none':'' }" role="alert">
					  ${errorMessage}
					  <button type="button" class="btn-close" data-bs-dismiss="alert" aria-label="Close" ></button>
					</div>
			  
			  <div class='card'>
				    <div class='card-header'>
				        <h5>Ricerca Annuncio</h5> 
				    </div>
				    <div class='card-body'>
		
							<h6 class="card-title">I campi con <span class="text-danger">*</span> sono obbligatori</h6>
		
		
							<form method="post" action="${pageContext.request.contextPath}/ExecuteCercaAnnuncioServlet" class="row g-3" >
							
							
								<div class="col-md-6">
									<label>Testo Annuncio</label>
									<input type="text" name="testoAnnuncio" id="testoAnnuncio" class="form-control" placeholder="Inserire il testo dell'annuncio " value="${insert_annuncio_attr.testoAnnuncio}" >
								</div>
								
								<div class="col-md-6">
									<label>Prezzo da:</label>
									<input type="text" name="prezzo" id="prezzo" class="form-control" placeholder="Inserire il prezzo" value="0" >
								</div>
								
								<div class="col-md-3">
									<label>Data Pubblicazione annuncio:	</label>
                        			<input class="form-control" id="data" type="date" placeholder="dd/MM/yy"
                            			title="formato : gg/mm/aaaa"  name="data"  value="${parsedDate}" >
								</div>
								
								
							<div class="col-12">
								<button type="submit" name="submit" value="submit" id="submit" class="btn btn-success">Conferma</button>
								<input class="btn btn-outline-warning" type="reset" value="Resetta">
							</div>
		
						</form>
  
				    
				    
					<!-- end card-body -->			   
				    </div>
				<!-- end card -->
				</div>		
					  
			    
			  <!-- end container -->  
			  </div>
			  
			</main>
			
			<!-- Footer -->
			<jsp:include page="../footer.jsp" />
	  </body>
</html>