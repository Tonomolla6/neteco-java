package modules.orders.functions;

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
import javax.swing.JScrollPane;
import javax.swing.JSeparator;
import javax.swing.JTable;
import javax.swing.JTextField;

import dashboard.login;
import modules.orders.order;
import modules.products.clothes;
import modules.products.item;
import modules.products.machinery;
import modules.products.product;
import modules.users.descount;
import modules.users.user;

public class CRUD_tool_order {

	public static int size_product(int dato, ArrayList<product> productos) {
		int dato_final = 0;

		if (dato == 0) {
			for (int i = 0; i < productos.size(); i++) {
				if (productos.get(i) instanceof item) {
					dato_final++;
				}
			}
		} else if (dato == 1) {
			for (int i = 0; i < productos.size(); i++) {
				if (productos.get(i) instanceof machinery) {
					dato_final++;
				}
			}
		} else if (dato == 2) {
			for (int i = 0; i < productos.size(); i++) {
				if (productos.get(i) instanceof clothes) {
					dato_final++;
				}
			}
		}

		return dato_final;
	}

	public static String name_product(int dato) {
		String dato_final = "";

		if (dato == 0)
			dato_final = "item";
		else if (dato == 1)
			dato_final = "machinery";
		else if (dato == 2)
			dato_final = "clothes";

		return dato_final;
	}

	public static Object input_list_product(int dato, ArrayList<product> productos, String titulo, String texto) {
		Object dato_final = "";

		dato_final = JOptionPane.showInputDialog(null, texto, titulo, JOptionPane.DEFAULT_OPTION, null,
				productos_nombre_product(dato, productos), productos_nombre_product(dato, productos));

		if (dato_final != null)
			for (int i = 0; i < productos.size(); i++) {
				if (productos.get(i).getNombre() == dato_final) {
					dato_final = i;
					break;
				}
			}

		return dato_final;

	}

	public static String[] productos_nombre_product(int dato, ArrayList<product> productos) {
		String[] dato_final = new String[size_product(dato, productos)];
		int inicio = 0;

		if (dato == 0) {
			for (int i = 0; i < productos.size(); i++) {
				if (productos.get(i) instanceof item) {
					dato_final[inicio] = productos.get(i).getNombre();
					inicio++;
				}
			}
		} else if (dato == 1) {
			for (int i = 0; i < productos.size(); i++) {
				if (productos.get(i) instanceof machinery) {
					dato_final[inicio] = productos.get(i).getNombre();
					inicio++;
				}
			}
		} else if (dato == 2) {
			for (int i = 0; i < productos.size(); i++) {
				if (productos.get(i) instanceof clothes) {
					dato_final[inicio] = productos.get(i).getNombre();
					inicio++;
				}
			}
		}
		return dato_final;
	}

	public static String[] productos_nombre_precio_product_descuento(int dato, ArrayList<product> productos,
			ArrayList<descount> descuentos) {
		String[] dato_final = new String[size_product(dato, productos)];
		int inicio = 0;
		ArrayList<descount> descuentos_por_usuario = new ArrayList<descount>();
		boolean interruptor = false;

		for (int i = 0; i < descuentos.size(); i++) {
			if (descuentos.get(i).getCliente() == login.logeado())
				descuentos_por_usuario.add(descuentos.get(i));
		}
		if (dato == 0) {
			for (int i = 0; i < productos.size(); i++) {
				if (productos.get(i) instanceof item) {
					for (int j = 0; j < descuentos_por_usuario.size(); j++) {
						if (descuentos_por_usuario.get(j).getProducto() == i) {
							dato_final[inicio] = productos.get(i).getNombre() + " - "
									+ ((Float.parseFloat(productos.get(i).getPrecio())
											- descuentos_por_usuario.get(j).getDescuento()
													* Float.parseFloat(productos.get(i).getPrecio()) / 100))
									+ "\u20AC";
							inicio++;
							interruptor = true;
							break;
						}
					}
					if (interruptor == false) {
						dato_final[inicio] = productos.get(i).getNombre() + " - " + productos.get(i).getPrecio() + "\u20AC";
						inicio++;
					} else
						interruptor = false;
				}
			}
		} else if (dato == 1) {
			for (int i = 0; i < productos.size(); i++) {
				if (productos.get(i) instanceof machinery) {
					for (int j = 0; j < descuentos_por_usuario.size(); j++) {
						if (descuentos_por_usuario.get(j).getProducto() == i) {
							dato_final[inicio] = productos.get(i).getNombre() + " - "
									+ ((Float.parseFloat(productos.get(i).getPrecio())
											- descuentos_por_usuario.get(j).getDescuento()
													* Float.parseFloat(productos.get(i).getPrecio()) / 100))
									+ "\u20AC";
							inicio++;
							interruptor = true;
							break;
						}
					}
					if (interruptor == false) {
						dato_final[inicio] = productos.get(i).getNombre() + " - " + productos.get(i).getPrecio() + "\u20AC";
						inicio++;
					} else
						interruptor = false;
				}
			}
		} else if (dato == 2) {
			for (int i = 0; i < productos.size(); i++) {
				if (productos.get(i) instanceof clothes) {
					for (int j = 0; j < descuentos_por_usuario.size(); j++) {
						if (descuentos_por_usuario.get(j).getProducto() == i) {
							dato_final[inicio] = productos.get(i).getNombre() + " - "
									+ ((Float.parseFloat(productos.get(i).getPrecio())
											- descuentos_por_usuario.get(j).getDescuento()
													* Float.parseFloat(productos.get(i).getPrecio()) / 100))
									+ "\u20AC";
							inicio++;
							interruptor = true;
							break;
						}
					}
					if (interruptor == false) {
						dato_final[inicio] = productos.get(i).getNombre() + " - " + productos.get(i).getPrecio() + "\u20AC";
						inicio++;
					} else
						interruptor = false;
				}
			}
		}
		return dato_final;
	}

	public static String[] productos_descuento_precio(ArrayList<product> productos, ArrayList<descount> descuentos) {
		String[] dato_final = new String[productos.size()];
		int inicio = 0;
		ArrayList<descount> descuentos_por_usuario = new ArrayList<descount>();
		boolean interruptor = false;

		for (int i = 0; i < descuentos.size(); i++) {
			if (descuentos.get(i).getCliente() == login.logeado())
				descuentos_por_usuario.add(descuentos.get(i));
		}

		for (int i = 0; i < productos.size(); i++) {
			for (int j = 0; j < descuentos_por_usuario.size(); j++) {
				if (descuentos_por_usuario.get(j).getProducto() == i) {
					dato_final[inicio] = productos.get(i).getNombre() + " - "
							+ ((Float.parseFloat(productos.get(i).getPrecio())
									- descuentos_por_usuario.get(j).getDescuento()
											* Float.parseFloat(productos.get(i).getPrecio()) / 100))
							+ "\u20AC";
					inicio++;
					interruptor = true;
					break;
				}
			}
			if (interruptor == false) {
				dato_final[inicio] = productos.get(i).getNombre() + " - " + productos.get(i).getPrecio() + "\u20AC";
				inicio++;
			} else
				interruptor = false;
		}

		return dato_final;
	}

	public static ArrayList<product> productos(int dato, ArrayList<product> productos) {
		ArrayList<product> dato_final = new ArrayList<product>();
		if (dato == 0) {
			for (int i = 0; i < productos.size(); i++) {
				if (productos.get(i) instanceof item) {
					dato_final.add(productos.get(i));
				}
			}
		} else if (dato == 1) {
			for (int i = 0; i < productos.size(); i++) {
				if (productos.get(i) instanceof machinery) {
					dato_final.add(productos.get(i));
				}
			}
		} else if (dato == 2) {
			for (int i = 0; i < productos.size(); i++) {
				if (productos.get(i) instanceof clothes) {
					dato_final.add(productos.get(i));
				}
			}
		}
		return dato_final;
	}

	public static String[] productos_precio_product(int dato, ArrayList<product> productos) {
		String[] dato_final = new String[size_product(dato, productos)];
		int inicio = 0;

		if (dato == 0) {
			for (int i = 0; i < productos.size(); i++) {
				if (productos.get(i) instanceof item) {
					dato_final[inicio] = productos.get(i).getPrecio();
					inicio++;
				}
			}
		} else if (dato == 1) {
			for (int i = 0; i < productos.size(); i++) {
				if (productos.get(i) instanceof machinery) {
					dato_final[inicio] = productos.get(i).getPrecio();
					inicio++;
				}
			}
		} else if (dato == 2) {
			for (int i = 0; i < productos.size(); i++) {
				if (productos.get(i) instanceof clothes) {
					dato_final[inicio] = productos.get(i).getPrecio();
					inicio++;
				}
			}
		}
		return dato_final;
	}

	public static Object buscar_producto(ArrayList<product> productos, ArrayList<descount> descuentos, String titulo,
			String mensaje, String boton_i) {

		// Variables
		int opcion = 0;
		Object dato_final = null;

		JComboBox<String> productos_tipo = new JComboBox<String>();
		String[] array = { "Articulo", "Maquinaria", "Ropa" };
		for (int i = 0; i < array.length; i++) {
			productos_tipo.addItem(array[i]);
		}

		// Inputs
		JTextField input = new JTextField();
		input.setPreferredSize(new Dimension(200, 26));
		JButton boton = new JButton("Buscar");

		// Separador
		JSeparator separador = new JSeparator();

		// JPanel
		JPanel busqueda = new JPanel();
		busqueda.add(productos_tipo);
		busqueda.add(input);
		busqueda.add(boton);

		// Title
		JLabel titulo_l = new JLabel(mensaje, JLabel.CENTER);
		titulo_l.setFont(new Font("DigifaceWide Regular", Font.BOLD, 17));

		// Lista
		String[] nombres_producto = productos_nombre_precio_product_descuento(productos_tipo.getSelectedIndex(),
				productos, descuentos);
		DefaultListModel<String> model = new DefaultListModel<>();

		// Botones
		String[] botones = { boton_i, "Atras" };

		JList<String> lista = new JList<>(model);
		JScrollPane sp = new JScrollPane(lista);
		lista.setPreferredSize(new Dimension(200, 200));

		for (int i = 0; i < nombres_producto.length; i++) {
			model.addElement((String) nombres_producto[i]);
			lista.setSelectedValue((String) nombres_producto[0], true);
		}

		boton.addActionListener(event -> {
			model.removeAllElements();
			String[] nuevos_nombres_productos = productos_nombre_precio_product_descuento(
					productos_tipo.getSelectedIndex(), productos, descuentos);
			lista.setEnabled(true);
			for (int i = 0; i < nuevos_nombres_productos.length; i++) {
				if (((String) nuevos_nombres_productos[i]).indexOf(input.getText()) != -1) {
					model.addElement(((String) nuevos_nombres_productos[i]));
					lista.setSelectedValue((String) nuevos_nombres_productos[0], true);
				}
			}
			if (model.getSize() == 0) {
				model.addElement("No se encuentra resultado");
				lista.setEnabled(false);
				lista.setSelectedValue((String) nuevos_nombres_productos[0], false);
			} else {
				lista.setEnabled(true);
				lista.setSelectedValue((String) nuevos_nombres_productos[0], true);
			}

		});
		do {
			// Mete los Objetos
			Object[] inputs = { titulo_l, busqueda, separador, sp };

			opcion = JOptionPane.showOptionDialog(null, inputs, titulo, JOptionPane.DEFAULT_OPTION,
					JOptionPane.PLAIN_MESSAGE, null, botones, botones);

			// Comprueba la informacion.
			if (opcion != 0)
				return null;
			else if (opcion == 0) {
				nombres_producto = productos_descuento_precio(productos, descuentos);
				for (int i = 0; i < productos.size(); i++) {
					if (nombres_producto[i].equals(lista.getSelectedValue())) {
						dato_final = i;
						break;
					}
				}
			}
		} while (dato_final == null);

		return dato_final;
	}

	public static Object[][] datos;

	public static Object buscar_order_beta(int dato, ArrayList<product> productos, ArrayList<order> compras,
			ArrayList<descount> descuentos, String titulo) {
		ArrayList<descount> descuentos_por_usuario = new ArrayList<descount>();
		boolean interruptor = false;
		int index = 0;
		Object[] nombres_columnas = { "Nombre", "Precio", "F. de compra", "Garantia" };
		ArrayList<product> nombres_producto = new ArrayList<product>();
		ArrayList<String> precio = new ArrayList<String>();
		for (int i = 0; i < descuentos.size(); i++) {
			if (descuentos.get(i).getCliente() == dato)
				descuentos_por_usuario.add(descuentos.get(i));
		}
		for (int i = 0; i < compras.size(); i++) {
			if (Integer.parseInt(compras.get(i).getCliente()) == dato) {
				for (int j = 0; j < descuentos_por_usuario.size(); j++) {
					if (descuentos_por_usuario.get(j).getProducto() == Integer.parseInt(compras.get(i).getProducto())) {
						nombres_producto.add(productos.get(Integer.parseInt(compras.get(i).getProducto())));
						precio.add(Float.toString(Float.parseFloat(nombres_producto.get(index).getPrecio())
								- (descuentos_por_usuario.get(j).getDescuento()
										* Float.parseFloat(nombres_producto.get(index).getPrecio()) / 100)));
						interruptor = true;
						index++;
						break;
					}
				}
				if (interruptor == false) {
					nombres_producto.add(productos.get(Integer.parseInt(compras.get(i).getProducto())));
					precio.add(nombres_producto.get(index).getPrecio());
					index++;
				} else
					interruptor = false;
			}
		}

		if (nombres_producto.size() == 0) {
			JOptionPane.showMessageDialog(null, "No se encuentra ninguna compra.", "Operacion interrumpida",
					JOptionPane.WARNING_MESSAGE);
			return null;
		}
		datos = new Object[nombres_producto.size()][4];

		// Variables
		int opcion = 0;
		Boolean dato_final = false;

		// Inputs
		JTextField input = new JTextField();
		input.setPreferredSize(new Dimension(200, 26));

		// Separador
		JSeparator separador = new JSeparator();

		// Para que no se pueda editar
		JTable table = new JTable(datos, nombres_columnas) {
			private static final long serialVersionUID = 1L;

			public boolean isCellEditable(int row, int column) {
				return false;
			}
		};

		// Meto la informacion en la tabla
		for (int i = 0; i < nombres_producto.size(); i++) {
			datos[i][0] = nombres_producto.get(i).getNombre();
			datos[i][1] = precio.get(i) + "\u20AC";
			datos[i][2] = compras.get(i).getFecha().getFecha();
			if (compras.get(i).getFecha().getFecha().equals(compras.get(i).getFecha_garantia().getFecha()))
				datos[i][3] = "Sin Garantia";
			else
				datos[i][3] = compras.get(i).getFecha_garantia().getFecha();
		}

		// Botones
		String[] botones = { "Atras" };

		JScrollPane scrollPane = new JScrollPane(table);
		scrollPane.setPreferredSize(new Dimension(450, 200));

		do {
			// Mete los Objetos
			Object[] inputs = { /* titulo_l, busqueda, */ separador, scrollPane };

			opcion = JOptionPane.showOptionDialog(null, inputs, titulo, JOptionPane.DEFAULT_OPTION,
					JOptionPane.PLAIN_MESSAGE, null, botones, botones);

			// Comprueba la informacion.
			dato_final = true;

		} while (dato_final == false);

		return dato_final;
	}

	public static Object buscar_order_beta_general(ArrayList<product> productos, ArrayList<order> compras,
			ArrayList<user> clientes, String titulo, boolean opcion_b) {
		Object[] nombres_columnas = { "ID Compra", "Nom. Cliente", "Nom. Producto", "F. Compra", "Garantia" };
		datos = new Object[compras.size()][5];

		// Variables
		int opcion = 0;
		Boolean dato_final = false;

		// Separador
		JSeparator separador = new JSeparator();

		// Input

		// Para que no se pueda editar
		JTable table = new JTable(datos, nombres_columnas) {
			private static final long serialVersionUID = 1L;

			public boolean isCellEditable(int row, int column) {
				return false;
			}
		};

		// Meto la informacion en la tabla
		for (int i = 0; i < compras.size(); i++) {
			datos[i][0] = i;
			datos[i][1] = clientes.get(Integer.parseInt(compras.get(i).getCliente())).getNombre();
			datos[i][2] = productos.get(Integer.parseInt(compras.get(i).getProducto())).getNombre();
			datos[i][3] = compras.get(i).getFecha().getFecha();
			if (compras.get(i).getFecha().getFecha().equals(compras.get(i).getFecha_garantia().getFecha()))
				datos[i][4] = "Sin Garantia";
			else
				datos[i][4] = compras.get(i).getFecha_garantia().getFecha();
		}

		String[] botones = { "Atras" };
		String[] botones_d = { "Borrar", "Atras" };

		JScrollPane scrollPane = new JScrollPane(table);
		scrollPane.setPreferredSize(new Dimension(450, 200));

		do {
			// Mete los Objetos
			Object[] inputs = { separador, scrollPane };
			if (opcion_b == true) {
				opcion = JOptionPane.showOptionDialog(null, inputs, titulo, JOptionPane.DEFAULT_OPTION,
						JOptionPane.PLAIN_MESSAGE, null, botones_d, botones_d);
				if (opcion != 0) {
					return null;
				} else if (opcion == 0) {
					return table.getSelectedRow();
				}
			} else
				opcion = JOptionPane.showOptionDialog(null, inputs, titulo, JOptionPane.DEFAULT_OPTION,
						JOptionPane.PLAIN_MESSAGE, null, botones, botones);

			// Comprueba la informacion.
			dato_final = true;

		} while (dato_final == false);

		return dato_final;
	}

}
