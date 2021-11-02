<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix = "fmt" uri = "http://java.sun.com/jsp/jstl/fmt" %>
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
					
					<div class="alert alert-danger alert-dismissible fade show ${errorePassword==null?'d-none':'' }" role="alert">
					  ${errorePassword}
					  <button type="button" class="btn-close" data-bs-dismiss="alert" aria-label="Close" ></button>
					</div>
			  
			  <div class='card'>
				    <div class='card-header'>
				        <h5>Aggiorna Utente</h5> 
				    </div>
				    <div class='card-body'>
		
		
							<form method="post" action="${pageContext.request.contextPath}/admin/ExecuteUpdateUtenteServlet" class="row g-3" >
							
								<input type="hidden" name="idUtente" value="${update_utente_attr.id}">
								<div class="col-md-6">
									<label>Nome <span class="text-danger">*</span></label>
									<input type="text" name="nome" id="nome" class="form-control" placeholder="Inserire il nome" value="${update_utente_attr.nome}" >
								</div>
								
								<div class="col-md-6">
									<label>Cognome <span class="text-danger">*</span></label>
									<input type="text" name="cognome" id="cognome" class="form-control" placeholder="Inserire il cognome" value="${update_utente_attr.cognome }" >
								</div>
							
								<div class="col-md-6">
									<label>Username <span class="text-danger">*</span></label>
									<input type="text" class="form-control" name="username" id="username" placeholder="Inserire l'username" value="${update_utente_attr.username }" >
								</div>
								
								<div class="col-md-6">
									<label>Password <span class="text-danger">*</span></label>
									<input type="password" class="form-control" name="password" id="password" placeholder="Inserire la password" value="${update_utente_attr.password }" >
								</div>
								
								<div class="col-md-6">
									<label>Conferma Password <span class="text-danger">*</span></label>
									<input type="password" class="form-control" name="conpassword" id="conpassword" placeholder="Conferma la password" value="${update_utente_attr.password }" >
								</div>
								
								<div class="col-md-6">
									<label>Credito <span class="text-danger">*</span></label>
									<input type="text" class="form-control" name="creditoResiduo" id="creditoResiduo" placeholder="Inserire il credito" value="${update_utente_attr.creditoResiduo }" >
								</div>
								
								
								
								<div class="col-md-6">
									<label for="statoUt">Stato Utente</label>
									<select class="form-select" id="statoUt" name="stato">
										<option value="" selected> -- Selezionare una voce -- </option>
										<option value="ATTIVO" ${update_utente_attr.stato == 'ATTIVO'?'selected':''} >ATTIVO</option>
										<option value="CREATO" ${update_utente_attr.stato == 'CREATO'?'selected':''} >CREATO</option>
										<option value="DISABILITATO" ${update_utente_attr.stato == 'DISABILITATO'?'selected':''} >DISABILITATO</option>
									</select>
								 </div>     
								
							<div class="col-12">
								
								<button type="submit" name="submit" value="submit" id="submit" class="btn btn-primary">Conferma</button>
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