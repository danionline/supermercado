
<jsp:include page="includes/cabecera.jsp" >
  <jsp:param name="pagina" value="Login" />
  <jsp:param name="title" value="Login" /> 
</jsp:include>

	
	<form action="loginform" method="post" class="form-login">
	
	 	<div class="form-group">
			<input type="text" name="nombre" placeholder="Tu Nombre"  class="form-control">
			<label class="mr-sm-2" for="inlineFormCustomSelect">Preferencia de Color</label>
      	<select class="custom-select mr-sm-2" name="color" id="inlineFormCustomSelect">
        <option selected>Color</option>
        <option value="1">rojo</option>
        <option value="2">verde</option>
        <option value="3">blanco</option>
      </select>
		</div>
		
		
		
		
		
		<input type="submit" value="Iniciar Sesión" class="btn btn-primary btn-block">
	
	</form>
	
	

<%@include file="includes/pie.jsp" %>	