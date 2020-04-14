package modules.orders.functions;

import java.util.ArrayList;
import java.util.Calendar;

import javax.swing.JOptionPane;

import dashboard.login;
import modules.orders.date;
import modules.orders.order;
import modules.products.product;
import modules.products.functions.functions_Product_CRUD;
import modules.users.descount;
import modules.users.user;
import modules.users.functions.formularios_user;
import modules.users.functions.functions_User_CRUD;

public class functions_Orders_CRUD {
	static ArrayList<product> productos = functions_Product_CRUD.products();
	static ArrayList<user> clientes = functions_User_CRUD.clientes();
	static ArrayList<descount> descuentos = functions_User_CRUD.descuentos();
	static ArrayList<order> compras = new ArrayList<order>();

	// Crear una compra
	// --------------------------------------------------------------------------------------------------------------

	public static void create_Order() {
		Object opcion_edit = 0;
		order compra;
		date fecha_garantia;
		date fecha_now;

		opcion_edit = CRUD_tool_order.buscar_producto(productos, descuentos, "Comprar productos",
				"Busque el producto para comprar", "Comprar");
		if (opcion_edit == null)
			return;

		Calendar now = Calendar.getInstance();
		fecha_now = new date(Integer.toString(now.get(Calendar.DATE)), Integer.toString(now.get(Calendar.MONTH) + 1),
				Integer.toString(now.get(Calendar.YEAR)));

		date.resta_fecha(now, Integer.parseInt(productos.get((int) opcion_edit).getGarantia()));
		fecha_garantia = new date(Integer.toString(now.get(Calendar.DATE)),
				Integer.toString(now.get(Calendar.MONTH) + 1), Integer.toString(now.get(Calendar.YEAR)));

		compra = new order(String.valueOf(login.logeado()), String.valueOf(opcion_edit), fecha_now, fecha_garantia);
		compras.add(compra);
		return;
	}

	public static void show_Orders() {
		CRUD_tool_order.buscar_order_beta(login.logeado(), productos, compras, descuentos, "Registro de Pedidos");
	}

	public static void edit_Profile() {
		user cliente;

		String[] modificacion = { clientes.get(login.logeado()).getNombre(),
				clientes.get(login.logeado()).getApellidos(), clientes.get(login.logeado()).getDni(),
				clientes.get(login.logeado()).getLugar_de_trabajo(), clientes.get(login.logeado()).getEdad(),
				clientes.get(login.logeado()).getTipo_de_usuario(), clientes.get(login.logeado()).getPasswd() };

		String[] retorno = formularios_user.client_form(modificacion);

		if (retorno == null) {
			return;
		}

		cliente = new user(retorno[0], retorno[1], retorno[2], retorno[3], retorno[4], retorno[5], retorno[6]);

		clientes.set(login.logeado(), cliente);
	}

	public static void show_general_Orders() {
		if (compras.size() == 0)
			JOptionPane.showMessageDialog(null, "No se encuentra ninguna compra.", "Operación interrumpida",
					JOptionPane.WARNING_MESSAGE);
		else
			CRUD_tool_order.buscar_order_beta_general(productos, compras, clientes, "Registro de pedidos", false);
	}

	public static void delate_general_Orders() {
		Object opcion = "";
		if (compras.size() == 0)
			JOptionPane.showMessageDialog(null, "No se encuentra ninguna compra.", "Operación interrumpida",
					JOptionPane.WARNING_MESSAGE);
		else {
			opcion = CRUD_tool_order.buscar_order_beta_general(productos, compras, clientes, "Registro de pedidos",
					true);
			if (opcion != null) {
				compras.remove((int) opcion);
				JOptionPane.showMessageDialog(null, "Operación realizada correctamente");
			}
		}
	}
}
