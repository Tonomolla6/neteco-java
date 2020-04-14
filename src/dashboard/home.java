package dashboard;

public class home {

	public static void main(String[] args) {
		login.login();
	}

	static boolean[] interruptor = new boolean[2];

	public static void admin_main() {
		// Creamos el array boton.
		String[] opciones = { "Productos", "Usuarios", "Pedidos", "Dummies", "Cerrar Sesión" };
		String[] funciones = { "productos", "usuarios", "pedidos", "dummies", "exit(0)" };

		// Creamos un menu con las funciones.
		menu_automatic.menu_automatic(opciones, funciones, "NETECO" + "\n" + "______", "dashboard.home", false, 0, 0, 0,
				"");
	}

	public static void user_main() {
		// Creamos el array boton.
		String[] opciones = { "Comprar", "Pedidos", "Perfil", "Cerrar Sesión" };
		String[] funciones = { "create_Order", "show_Orders", "edit_Profile", "exit(0)" };

		// Creamos un menu con las funciones.
		menu_automatic.menu_automatic(opciones, funciones, "COMPRAR" + "\n" + "______",
				"modules.orders.functions.functions_Orders_CRUD", false, 0, 0, 0, "");
	}

	public static void productos() {
		// Creamos el array boton.
		String[] opciones = { "Articulo", "Maquinaria", "Ropa", "Atras" };
		String[] funciones = { "opciones_productos", "opciones_productos", "opciones_productos", "back(0)" };

		// Creamos un menu con las funciones.
		menu_automatic.menu_automatic(opciones, funciones, "PRODUCTOS" + "\n" + "______", "dashboard.home", true, 0, 0,
				0, "");
	}

	public static void opciones_productos(String titulo, int opcion) {
		// Creamos el array boton.
		String[] opciones = { "Crear", "Modificar", "Mostrar", "Borrar", "Atras" };
		String[] funciones = { "create_Product", "edit_Product", "show_Product", "delete_Product", "back(0)" };

		// Creamos un menu con las funciones.
		menu_automatic.menu_automatic(opciones, funciones, titulo + "\n" + "______",
				"modules.products.functions.functions_Product_CRUD", false, 1, opcion, 0, "");
	}

	public static void usuarios() {
		// Creamos el array boton.
		String[] opciones = { "Crear", "Modificar", "Mostrar", "Eliminar", "Descuentos", "Atras" };
		String[] funciones = { "create_Client", "edit_Profile", "show_Client", "delete_Client", "descount_Client",
				"back(0)" };

		// Creamos un menu con las funciones.
		menu_automatic.menu_automatic(opciones, funciones, "USUARIOS" + "\n" + "______",
				"modules.users.functions.functions_User_CRUD", false, 0, 0, 0, "");
	}

	public static void pedidos() {
		// Creamos el array boton.
		String[] opciones = { "Listar", "Eliminar", "Atras" };
		String[] funciones = { "show_general_Orders", "delate_general_Orders", "back(0)" };

		// Creamos un menu con las funciones.
		menu_automatic.menu_automatic(opciones, funciones, "PEDIDOS" + "\n" + "______",
				"modules.orders.functions.functions_Orders_CRUD", false, 0, 0, 0, "");
	}

	public static void dummies() {
		// Creamos el array boton.

		String[] opciones = { "Productos", "Usuarios", "Atras" };
		String[] funciones = { "create_Products", "create_Users", "back(0)" };

		// Creamos un menu con las funciones.
		menu_automatic.menu_automatic(opciones, funciones, "DUMMIES" + "\n" + "______", "functions.dummies", false, 0,
				0, 0, "");
	}

	public static boolean[] dummies_interruptor() {
		return interruptor;
	}

	public static void dummies_interruptor_save(boolean[] interruptor_entrada) {
		interruptor = interruptor_entrada;
	}

}