package modules.users.functions;

import java.awt.Dimension;
import java.awt.Font;
import java.util.ArrayList;

import javax.swing.DefaultListModel;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JLabel;
import javax.swing.JList;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JPasswordField;
import javax.swing.JScrollPane;
import javax.swing.JSeparator;
import javax.swing.JTextField;
import javax.swing.text.JTextComponent;

import modules.products.product;
import modules.products.functions.CRUD_tool_product;
import modules.users.descount;
import modules.users.user;

public class formularios_user {
	static ArrayList<descount> clientes = new ArrayList<descount>();
	// items
	// --------------------------------------------------------------------------------------------------------

	public static String[] client_form(String[] modificacion) {

		JTextField nombre = new JTextField(20);
		JTextField apellidos = new JTextField(20);
		JPasswordField passwd = new JPasswordField();
		JTextField dni = new JTextField(20);
		JTextField edad = new JTextField(20);
		JComboBox<String> lugar_de_trabajo = new JComboBox<String>();
		String[] array = { "Empresa", "Particular" };
		JComboBox<String> tipo_de_usuario = new JComboBox<String>();
		String[] array_productos = { "Cliente", "Administrador" };
		Object[] error = new Object[7];
		String atexto = "";
		boolean interruptor = false;
		Object[] regex_result = new Object[3];
		int avisador = 0;
		String[] botones = { "Crear", "Cancelar" };
		int tmp = 0;
		String titulo = "CREAR CLIENTE";

		// Guardas las posiciones vacias.
		for (int i = 0; i < error.length; i++) {
			error[i] = "";
		}
		// Establezco los valores del jboxcombo
		for (int i = 0; i < array.length; i++) {
			lugar_de_trabajo.addItem(array[i]);
		}
		for (int i = 0; i < array_productos.length; i++) {
			tipo_de_usuario.addItem(array_productos[i]);
		}

		// Declaramos las variables en el input;
		Object[] inputs = { nombre, apellidos, dni, lugar_de_trabajo, edad, tipo_de_usuario, passwd };

		// Pregunta si hay variables
		if (modificacion[0] != null) {
			for (int i = 0; i < inputs.length; i++) {
				if (i == 3)
					lugar_de_trabajo.setSelectedItem(modificacion[i]);
				else if (i == 5)
					tipo_de_usuario.setSelectedItem(modificacion[i]);
				else
					((JTextComponent) inputs[i]).setText(modificacion[i]);
				botones[0] = "Modificar";
				titulo = "MODIFICAR CLIENTE";
			}
		}

		int[] posicion_avisador = new int[inputs.length];

		do {
			avisador = 0;
			Object[] muestras = { titulo, " ", "Nombre* ", error[0], inputs[0], "Apellidos*", error[1], inputs[1],
					"DNI", error[2], inputs[2], "Lugar de trabajo", error[3], inputs[3], "Edad", error[4], inputs[4],
					"Tipo de usuario", error[5], inputs[5], "Contraseña", error[6], inputs[6] };

			int opcion = JOptionPane.showOptionDialog(null, muestras, "NETECO", JOptionPane.YES_NO_OPTION,
					JOptionPane.PLAIN_MESSAGE, null, botones, botones);

			if (opcion != 0) {
				return null;
			}
			for (int i = 0; i < inputs.length; i++) {
				if (i == 3) {
					atexto = (String) lugar_de_trabajo.getSelectedItem();
					regex_result = regex_user.client(i, atexto);
				} else if (i == 5) {
					atexto = (String) lugar_de_trabajo.getSelectedItem();
					regex_result = regex_user.client(i, atexto);
				} else {
					atexto = ((JTextComponent) inputs[i]).getText();
					regex_result = regex_user.client(i, atexto);
				}

				if (regex_result[0] != (Object) false) {
					error[i] = regex_result[1];
					posicion_avisador[i] = 1;
				} else {
					error[i] = regex_result[1];
					posicion_avisador[i] = 0;
				}
			}

			tmp = 0;
			avisador = 0;
			do {
				if (posicion_avisador[tmp] == 1)
					avisador = 1;
				else if (tmp == (posicion_avisador.length - 1)) {
					interruptor = true;
					avisador = 1;
				} else
					tmp++;
			} while (avisador == 0);

		} while (interruptor == false);

		String[] item_salida = { nombre.getText(), apellidos.getText(), dni.getText(),
				(String) lugar_de_trabajo.getSelectedItem(), edad.getText(), (String) tipo_de_usuario.getSelectedItem(),
				passwd.getText() };
		return item_salida;
	}

	public static int[] descuentos_form_combo(ArrayList<product> productos, ArrayList<user> clientes,
			ArrayList<descount> descuentos) {
		// Variables
		boolean interruptor = false;
		int opcion = 0;
		Object cliente_elegido = null;
		int[] dato_final = new int[3];
		Object producto_elegido = null;
		String[] nombres_clientes = new String[CRUD_tool_user.size_clients(1, clientes)];
		int tipo_p = 0;
		String[] nombres_productos = CRUD_tool_product.productos_nombre_precio_product(tipo_p, productos);

		// Inputs
		JTextField input_clientes = new JTextField();
		input_clientes.setPreferredSize(new Dimension(200, 26));
		JButton boton_clientes = new JButton("Buscar");
		JTextField input_productos = new JTextField();
		input_productos.setPreferredSize(new Dimension(200, 26));
		JButton boton_productos = new JButton("Buscar");

		JComboBox<String> descuentos_ = new JComboBox<String>();
		for (int i = 1; i <= 20; i++) {
			descuentos_.addItem(i * 5 + "%");
		}

		JComboBox<String> productos_tipo = new JComboBox<String>();
		String[] array = { "Articulo", "Maquinaria", "Ropa" };
		for (int i = 0; i < array.length; i++) {
			productos_tipo.addItem(array[i]);
		}

		// Informacion final
		JLabel[] total = new JLabel[4];
		total[0] = new JLabel(
				"Precio del producto                                                                       0.00\u20AC");
		total[1] = new JLabel(
				"Descuento aplicado                                                                      -0.00\u20AC");
		total[2] = new JLabel(
				"Total                                                                                                 0.00\u20AC");

		// Separador
		JSeparator separador = new JSeparator();
		// JSeparator separador_vertical = new JSeparator(SwingConstants.VERTICAL);

		// Title
		JLabel titulo_clientes = new JLabel("Busqueda de clientes", JLabel.CENTER);
		titulo_clientes.setFont(new Font("DigifaceWide Regular", Font.BOLD, 17));

		JLabel titulo_productos = new JLabel("Busqueda de pedidos", JLabel.CENTER);
		titulo_productos.setFont(new Font("DigifaceWide Regular", Font.BOLD, 17));

		JLabel texto_label = new JLabel("Porcentaje de descuento", JLabel.CENTER);
		texto_label.setFont(new Font("DigifaceWide Regular", Font.PLAIN, 15));

		// JPanel
		JPanel clientes_p = new JPanel();
		clientes_p.add(input_clientes);
		clientes_p.add(boton_clientes);

		JPanel pedidos_p = new JPanel();
		pedidos_p.add(productos_tipo);
		pedidos_p.add(input_productos);
		pedidos_p.add(boton_productos);

		JPanel label = new JPanel();
		label.add(texto_label);
		label.add(descuentos_);

//		JPanel panel_global = new JPanel();
//		busqueda.add(busqueda);

		// Lista
		int index = 0;
		for (int i = 0; i < clientes.size(); i++) {
			if (clientes.get(i).getTipo_de_usuario().equals("Cliente")) {
				nombres_clientes[index] = clientes.get(i).getNombre() + " - " + clientes.get(i).getDni();
				index++;
			}
		}

		DefaultListModel<String> model_clientes = new DefaultListModel<>();
		DefaultListModel<String> model_productos = new DefaultListModel<>();

		// Botones
		String[] botones = { "Aplicar cambios", "Guardar descuento", "Atras" };

		// Clientes
		JList<String> lista_clientes = new JList<>(model_clientes);
		JScrollPane sp_clientes = new JScrollPane(lista_clientes);
		// lista_clientes.setPreferredSize(new Dimension(200, 200));

		// Productos
		JList<String> lista_productos = new JList<>(model_productos);
		JScrollPane sp_productos = new JScrollPane(lista_productos);
		// lista_productos.setPreferredSize(new Dimension(200, auto));

		for (int i = 0; i < nombres_clientes.length; i++) {
			model_clientes.addElement((String) nombres_clientes[i]);

			lista_clientes.setSelectedValue((String) nombres_clientes[0], true);
		}

		for (int i = 0; i < nombres_productos.length; i++) {
			model_productos.addElement((String) nombres_productos[i]);
			lista_productos.setSelectedValue((String) nombres_productos[0], true);
		}

		boton_clientes.addActionListener(event -> {
			model_clientes.removeAllElements();
			for (int i = 0; i < nombres_clientes.length; i++) {
				if (((String) nombres_clientes[i]).indexOf(input_clientes.getText()) != -1) {
					model_clientes.addElement(((String) nombres_clientes[i]));
					lista_clientes.setSelectedValue((String) nombres_clientes[0], true);
				}
			}

			if (model_clientes.getSize() == 0) {
				model_clientes.addElement("No se encuentra resultado");
				lista_clientes.setEnabled(false);
				lista_clientes.setSelectedValue((String) nombres_clientes[0], false);
			} else {
				lista_clientes.setEnabled(true);
				lista_clientes.setSelectedValue((String) nombres_clientes[0], true);
			}
		});

		boton_productos.addActionListener(event -> {
			model_productos.removeAllElements();
			String[] nuevos_nombres_productos = CRUD_tool_product
					.productos_nombre_precio_product(productos_tipo.getSelectedIndex(), productos);

			for (int i = 0; i < nuevos_nombres_productos.length; i++) {
				if (((String) nuevos_nombres_productos[i]).indexOf(input_productos.getText()) != -1) {
					model_productos.addElement(((String) nuevos_nombres_productos[i]));
					lista_productos.setSelectedValue((String) nuevos_nombres_productos[0], true);
				}
			}
			if (model_productos.getSize() == 0) {
				model_productos.addElement("No se encuentra resultado");
				lista_productos.setEnabled(false);
				lista_productos.setSelectedValue((String) nuevos_nombres_productos[0], false);
			} else {
				lista_productos.setEnabled(true);
				lista_productos.setSelectedValue((String) nuevos_nombres_productos[0], true);
			}

		});

		do {

			// Mete los Objetos
			Object[] inputs = { titulo_clientes, clientes_p, sp_clientes, titulo_productos, pedidos_p, sp_productos,
					label, separador, total[0], total[1], separador, total[2] };

			opcion = JOptionPane.showOptionDialog(null, inputs, "Descuentos", JOptionPane.DEFAULT_OPTION,
					JOptionPane.PLAIN_MESSAGE, null, botones, botones);

			// Comprueba la informacion.
			if (opcion != 0 && opcion != 1)
				return null;
			else if (opcion == 0) {
				for (int i = 0; i < clientes.size(); i++) {
					if ((clientes.get(i).getNombre() + " - " + clientes.get(i).getDni())
							.equals(lista_clientes.getSelectedValue())) {
						cliente_elegido = i;
						break;
					}
				}
				for (int i = 0; i < productos.size(); i++) {
					if ((productos.get(i).getNombre() + " - " + productos.get(i).getPrecio() + "\u20AC")
							.equals(lista_productos.getSelectedValue())) {
						producto_elegido = i;
						break;
					}
				}
				total[0] = new JLabel(
						"Precio del producto                                                                       "
								+ productos.get((int) producto_elegido).getPrecio() + "\u20AC");
				total[1] = new JLabel(
						"Descuento aplicado                                                                      -"
								+ ((descuentos_.getSelectedIndex() + 1) * 5
										* Float.parseFloat(productos.get((int) producto_elegido).getPrecio()) / 100)
								+ "\u20AC");
				total[2] = new JLabel(
						"Total                                                                                                "
								+ ((Float.parseFloat(productos.get((int) producto_elegido).getPrecio())
										- (descuentos_.getSelectedIndex() + 1) * 5
												* Float.parseFloat(productos.get((int) producto_elegido).getPrecio())
												/ 100))
								+ "\u20AC");

			} else if (opcion == 1) {
				for (int i = 0; i < clientes.size(); i++) {
					if ((clientes.get(i).getNombre() + " - " + clientes.get(i).getDni())
							.equals(lista_clientes.getSelectedValue())) {
						cliente_elegido = i;
						break;
					}
				}
				String[] nuevos_nombres_productos = CRUD_tool_product
						.productos_nombre_product(productos_tipo.getSelectedIndex(), productos);
				for (int i = 0; i < nuevos_nombres_productos.length; i++) {
					if ((productos.get(i).getNombre() + " - " + productos.get(i).getPrecio() + "\u20AC")
							.equals(lista_productos.getSelectedValue())) {
						producto_elegido = i;
						break;
					}
				}
				dato_final[0] = (int) cliente_elegido;
				dato_final[1] = (int) producto_elegido;
				dato_final[2] = (descuentos_.getSelectedIndex() + 1) * 5;

				return dato_final;
			}
		} while (interruptor == false);

		return null;
	}

	// public static int[] descuentos_form_combo(ArrayList<product> prodWuctos,
	// ArrayList<client> clientes,
	// ArrayList<descount> descuentos, int opcion) {

//		int opcion_input = 0;
//		String[] botones = { "Asignar descuento", "Atras" };
//
//		String producto_nombre = CRUD_tool_product.name_product(opcion);
//		int producto_size = CRUD_tool_product.size_product(opcion, productos);
//		JComboBox<String> productos_box = new JComboBox<String>();
//		JComboBox<String> clientes_box = new JComboBox<String>();
//		JComboBox<String> descuentos_box = new JComboBox<String>();
//
//		if (producto_size == 0) {
//			JOptionPane.showMessageDialog(null, "No se encuentra ningun producto " + producto_nombre + ".",
//					"Operación interrumpida", JOptionPane.WARNING_MESSAGE);
//			return null;
//		} else if (clientes.size() == 0) {
//			JOptionPane.showMessageDialog(null, "No se encuentra ningun cliente.", "Operación interrumpida",
//					JOptionPane.WARNING_MESSAGE);
//			return null;
//		} else {
//			String[] productos_nombre = CRUD_tool_product.productos_nombre_product(opcion, productos);
//			String[] productos_precio = CRUD_tool_product.productos_precio_product(opcion, productos);
//
//			System.out.println(productos_nombre);
//			System.out.println(productos_precio);
//
//			for (int i = 0; i < descuentos.size(); i++) {
//				String string = productos_precio[i];
//
//			}
//
//			// Establezco los valores de productos
//			for (int i = 0; i < CRUD_tool_product.size_product(opcion, productos); i++) {
//				productos_box.addItem(productos_nombre[i] + " - " + productos_precio[i]);
//			}
//
//			// Establezco los valores de productos
//			for (int i = 0; i < clientes.size(); i++) {
//				clientes_box.addItem(clientes.get(i).getNombre() + " - ID:" + (i + 1));
//			}
//
//			// Establezco los descuentos
//			for (int i = 1; i <= 20; i++) {
//				descuentos_box.addItem("" + (i * 5) + "%");
//			}
//
//			Object[] inputs_box = { "Cliente que tendra el descuento", clientes_box,
//					"Elige el producto al cual establecer el descuento", productos_box, "Porcentaje de decuento",
//					descuentos_box };
//
//			opcion_input = JOptionPane.showOptionDialog(null, inputs_box, "NETECO", JOptionPane.YES_NO_OPTION,
//					JOptionPane.PLAIN_MESSAGE, null, botones, botones);
//
//			if (opcion_input != 0)
//				return null;
//		}
//
//		// Comprueba la posicion de la eleccion.
//		int[] salida = { (int) productos_box.getSelectedIndex(), (int) clientes_box.getSelectedIndex(),
//				(int) descuentos_box.getSelectedIndex(), };
	// return salida;
	// }
}
