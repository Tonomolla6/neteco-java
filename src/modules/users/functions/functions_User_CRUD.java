package modules.users.functions;

import java.util.ArrayList;

import javax.swing.JOptionPane;
import javax.swing.JScrollPane;
import javax.swing.JTextArea;
import javax.swing.ScrollPaneConstants;

import modules.products.product;
import modules.products.functions.functions_Product_CRUD;
import modules.users.descount;
import modules.users.user;

public class functions_User_CRUD {
	static ArrayList<user> clientes = new ArrayList<user>();
	static ArrayList<product> productos = functions_Product_CRUD.products();
	static ArrayList<descount> descuentos = new ArrayList<descount>();

	// Crear un cliente
	// --------------------------------------------------------------------------------------------------------------

	public static void create_Client() {
		String[] modificacion = new String[1];
		user client;

		String[] retorno = formularios_user.client_form(modificacion);
		if (retorno == null)
			return;
		else
			client = new user(retorno[0], retorno[1], retorno[2], retorno[3], retorno[4], retorno[5], retorno[6]);
		clientes.add(client);
		return;
	}

	// Modificar un cliente
	// --------------------------------------------------------------------------------------------------------------

	public static void edit_Profile() {
		Object opcion_edit = "";
		user cliente;

		if (clientes.size() == 0) {
			JOptionPane.showMessageDialog(null, "No se encuentra ningun cliente.", "Operación interrumpida",
					JOptionPane.WARNING_MESSAGE);
		} else {
			opcion_edit = CRUD_tool_user.buscar_cliente(clientes, "Editar cliente", "Busque el cliente para editar",
					"Editar");

			if (opcion_edit == null)
				return;
			else {

				String[] modificacion = { clientes.get((int) opcion_edit).getNombre(),
						clientes.get((int) opcion_edit).getApellidos(), clientes.get((int) opcion_edit).getDni(),
						clientes.get((int) opcion_edit).getLugar_de_trabajo(),
						clientes.get((int) opcion_edit).getEdad(), clientes.get((int) opcion_edit).getTipo_de_usuario(),
						clientes.get((int) opcion_edit).getPasswd() };

				String[] retorno = formularios_user.client_form(modificacion);

				if (retorno == null) {
					return;
				}

				cliente = new user(retorno[0], retorno[1], retorno[2], retorno[3], retorno[4], retorno[5], retorno[6]);

				clientes.set((int) opcion_edit, cliente);
			}
		}
	}

	// Mostrar un cliente
	// --------------------------------------------------------------------------------------------------------------

	public static void show_Client() {
		Object opcion_edit = "";
		JTextArea description_i = new JTextArea(10, 0);
		JScrollPane description = new JScrollPane(description_i);
		Object[] mensaje = { "Los cambios no se guardarán" + "\n", description };
		String[] botones = { "Atras" };

		description.setVerticalScrollBarPolicy(ScrollPaneConstants.VERTICAL_SCROLLBAR_ALWAYS);

		if (clientes.size() == 0) {
			JOptionPane.showMessageDialog(null, "No se encuentra ningun cliente.", "Operación interrumpida",
					JOptionPane.WARNING_MESSAGE);
		} else {
			opcion_edit = CRUD_tool_user.buscar_cliente_beta(clientes, "Mostrar cliente",
					"Busque el cliente para mostrar", "Mostrar");

			if (opcion_edit == null)
				return;
			else {

				description_i.setText("Nombre: " + clientes.get((int) opcion_edit).getNombre() + "\n" + "Apellidos: "
						+ clientes.get((int) opcion_edit).getApellidos() + "\n" + "Dni: "
						+ clientes.get((int) opcion_edit).getDni() + "\n" + "Lugar de trabajo: "
						+ clientes.get((int) opcion_edit).getLugar_de_trabajo() + "\n" + "Edad: "
						+ clientes.get((int) opcion_edit).getEdad() + "\n" + "Tipo de usuario: "
						+ clientes.get((int) opcion_edit).getTipo_de_usuario() + "\n" + "Contraseña: "
						+ clientes.get((int) opcion_edit).getPasswd());

				JOptionPane.showOptionDialog(null, mensaje, "Mostrar informacion cliente", JOptionPane.YES_NO_OPTION,
						JOptionPane.PLAIN_MESSAGE, null, botones, botones);
			}
		}
	}
	// Borrar un cliente
	// --------------------------------------------------------------------------------------------------------------

	public static void delete_Client() {
		Object opcion_edit = "";

		if (clientes.size() == 0) {
			JOptionPane.showMessageDialog(null, "No se encuentra ningun cliente", "Operación interrumpida",
					JOptionPane.WARNING_MESSAGE);
		} else {
			opcion_edit = CRUD_tool_user.buscar_cliente(clientes, "Borrar cliente", "Busque el cliente para borrar",
					"Borrar");

			if (opcion_edit == null)
				return;
			else {
				clientes.remove((int) opcion_edit);

				JOptionPane.showMessageDialog(null, "Operación realizada correctamente");
				return;
			}
		}
	}

	public static void descount_Client() {
		int[] opcion_edit = new int[3];
		descount descuento;

		if (productos.size() == 0) {
			JOptionPane.showMessageDialog(null, "No se encuentra ningun producto.", "Operación interrumpida",
					JOptionPane.WARNING_MESSAGE);
		} else if (clientes.size() == 0) {
			JOptionPane.showMessageDialog(null, "No se encuentra ningun cliente.", "Operación interrumpida",
					JOptionPane.WARNING_MESSAGE);
		} else {
			opcion_edit = formularios_user.descuentos_form_combo(productos, clientes, descuentos);
			if (opcion_edit == null)
				return;
			else {
				descuento = new descount(opcion_edit[0], opcion_edit[1], opcion_edit[2]);
				descuentos.add(descuento);

				JOptionPane.showMessageDialog(null, "Descuento creado correctamente", "Descuento aplicado",
						JOptionPane.WARNING_MESSAGE);
			}
		}
	}

	public static void clientes_add(ArrayList<user> usuarios) {
		for (int i = 0; i < usuarios.size(); i++) {
			clientes.add(usuarios.get(i));
		}
	}

	public static ArrayList<user> clientes() {
		return clientes;
	}

	public static ArrayList<descount> descuentos() {
		return descuentos;
	}

}