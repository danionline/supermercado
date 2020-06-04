
<jsp:include page="includes/cabecera.jsp">
<jsp:param name="pagina" value="productos"/>
 <jsp:param name="title" value="Productos"/> 
</jsp:include>

<form  action="login" method="post">


	<input type="text" name="nombre">

	<input type="password" name="pass">

	<input type="submit" name="iniciarsesion">

</form>
<h2> Respuesta</h2>
<p>${respuestaddos}
<br>
<h2>Respuesta de la sesion</h2>
	<p>${respuesta}</p>




	
<%@include file="includes/pie.jsp" %>
