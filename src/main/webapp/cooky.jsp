<jsp:include page="includes/cabecera.jsp">
<jsp:param name="pagina" value="productos"/>
 <jsp:param name="title" value="Productos"/> 
</jsp:include>

<form  action="cooky" method="post">


	<input type="email" name="email" placeholder="Escribe el @email">

	
	
	
		
	
		
		<input type="text" name="email" placeholder="Tu Email" value="${ cookie['cEmail'].value }">
		<div class="form-row align-items-center">
    	<div class="col-auto my-1">
      <label class="mr-sm-2" for="inlineFormCustomSelect">Preference</label>
      <select class="custom-select mr-sm-2" id="inlineFormCustomSelect">
        <option selected>Idioma.</option>
        <option value="1">Esp</option>
        <option value="2">Eng</option>
        <option value="3">Fra</option>
      </select>
    </div>
    </div>
	<input type="submit" name="iniciarsesion">

</form>





	
<%@include file="includes/pie.jsp" %>
