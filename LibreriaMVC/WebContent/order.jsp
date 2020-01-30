<%-- Página de Ordenes --%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@page session="true" import="java.util.*, arquitecturaMVC.*" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
	<head>
		<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
		<title>Pedido a la Librería MVC</title>
	</head>
	<body>
		<h2>Librería MVC</h2>
		<hr /><br />
		
		<p><strong>Elige un libro y la cantidad:</strong></p>
		<form name="AnyadirForm" action="shopping" method="POST">
			<input type="hidden" name="todo" value="add">
			Título: <select name=idLibro>
				<%
				//Scriptlet 1: Cargar los libros en el select
				for (int i = 0; i < LibrosBD.tamanyo(); i++) {
					out.println("<option value='" + i + "'>");
					out.println(LibrosBD.getTitulo(i) + " | " + LibrosBD.getAutor(i) + LibrosBD.getAutor(i) +
							" | " + LibrosBD.getPrecio(i));
					out.println("</option>");
				}
				%>
			</select>
			Cantidad: <input type="text" name="cantidad" size="10" value="1">
			<input type="submit" value="Añadir a la cesta">
		</form>
		<br /><hr /><br />
		
		<%
		// Scriplet 2: Chequea si la cesta está vacia
		@SuppressWarnings (value="unchecked")
		// print(session.getAttribute("carrito")(0));
		List<ElementoPedido> cesta = new ArrayList();
		cesta = (List<ElementoPedido>)session.getAttribute("carrito");
		if (cesta != null && cesta.size() > 0) {
		%>
		<p><strong>Tu cesta contiene: </strong></p>
		<table border="1" cellspacing="0" cellpadding="5">
			<tr>
				<th>Título</th>
				<th>Autor</th>
				<th>Precio</th>
				<th>Cantidad</th>
				<th>&nbsp</th>
			</tr>
			<%
			// Scriptlet 3: Muestra los libros del carrito
			for (int i = 0; i< cesta.size(); i++) {
				ElementoPedido elementoPedido = cesta.get(i);
			%>
			<tr>
				<form name="borrarForm" action="shopping" method="POST">
					<input type="hidden" name="todo" value="remove">
					<input type="hidden" name="indiceElemento" value="<%= i %>">
					<td><%= elementoPedido.getTitulo() %></td>
					<td><%= elementoPedido.getAutor() %></td>
					<td align="right"><%= elementoPedido.getPrecio() %></td>
					<td align="right"><%= elementoPedido.getCantidad() %></td>
					<td><input type="submit" value="Eliminar de la cesta"></td>
				</form>
			</tr>
			<%
			}
			%>
		</table><br />
		
		<form name="checkoutForm" action="shopping" method="POST">
			<input type="hidden" name="todo" value="checkout">
			<input type="submit" value="checkout">
		</form>
		<%
		}  // if
		%>
	</body>
</html>