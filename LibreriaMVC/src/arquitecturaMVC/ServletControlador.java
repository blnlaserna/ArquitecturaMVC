package arquitecturaMVC;

import java.io.*;
import java.util.*;
import javax.servlet.*;
import javax.servlet.http.*;

public class ServletControlador extends HttpServlet {
	private static final long serialVersionUID = 1L;

	@Override
	public void init(ServletConfig config) throws ServletException {
		super.init(config);
		LibrosBD.cargarDatos();
	}

	@Override
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doPost(request, response);
	}
	
	@Override
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// Recupera la sesi�n actual o crea una nueva si no existe
		HttpSession session = request.getSession(true);
		
		// Recupera el carrito de la sesi�n actual
		List<ElementoPedido> elCarrito = (ArrayList<ElementoPedido>) session.getAttribute("carrito");
		
		// Determina a que p�gina jsp redirigir�
		String nextPage = "";
		String todo = request.getParameter("todo");
		
		if (todo == null) {
			// Primer acceso - redirecci�n a order.jsp
			nextPage = "/order.jsp";
		} else if (todo.equals("add")) {
			// Mandado por order.jsp con los par�metros idLibro y cantidad
			// Crea un elementoPedido y lo a�ade al carrito
			ElementoPedido nuevoElementoPedido = new ElementoPedido(
					Integer.parseInt(request.getParameter("idLibro")), 
					Integer.parseInt(request.getParameter("cantidad")));
			if (elCarrito == null) { // el carrito est� vac�o
				elCarrito = new ArrayList<>();
				elCarrito.add(nuevoElementoPedido);
				// enlaza el carrito con la sesi�n
				session.setAttribute("carrito",	"elCarrito");
			} else {
				// Comprueba si el libro est� en el carrito
				// si lo est�, actualiza la cantidad
				// si no, lo a�ade
				boolean encontrado = false;
				Iterator iter = elCarrito.iterator();
				while (!encontrado  && iter.hasNext()) {
					ElementoPedido unElementoPedido = (ElementoPedido)iter.next();
					if (unElementoPedido.getIdLibro() == nuevoElementoPedido.getIdLibro()) {
						unElementoPedido.setCantidad(unElementoPedido.getCantidad() 
								+ nuevoElementoPedido.getCantidad());
						encontrado = true;
					}
				}
				if (!encontrado) { // Lo a�ade al carrito
					elCarrito.add(nuevoElementoPedido);
				}
			}
			// Vuelve a order.jsp para m�s pedidos
			nextPage = "/order.jsp";
		} else if (todo.equals("remove")) {
			// Enviado por order.jsp con el par�metro indiceElemento
			// Borra el elemento indiceElemento del carrito
			int indiceCarrito = Integer.parseInt(request.getParameter("indiceElemento"));
			elCarrito.remove(indiceCarrito);
			// Vuelve a order.jsp
			// Calcula el precio total de todos los elementos del carrito
			float precioTotal = 0;
			int cantidadTotalOrdenada = 0;
			for (ElementoPedido item: elCarrito) {
				float precio = item.getPrecio();
				int cantidadOrdenada = item.getCantidad();
				precioTotal += precio * cantidadOrdenada;
				cantidadTotalOrdenada += cantidadOrdenada;
			}
			// Formatea el precio con dos decimales
			StringBuilder sb = new StringBuilder();
			Formatter formatter = new Formatter(sb);
			formatter.format("%.2f", precioTotal);
			// Coloca el precioTotal y la cantidadTotal en el request
			request.setAttribute("precioTotal", sb.toString());
			request.setAttribute("cantidadTotal", cantidadTotalOrdenada + "");
			// Redirige a checkout.jsp
			nextPage = "/checkout.jsp";
		}
		
		ServletContext servletContext = getServletContext();
		RequestDispatcher requestDispatcher = servletContext.getRequestDispatcher(nextPage);
		requestDispatcher.forward(request, response);
	}

}
