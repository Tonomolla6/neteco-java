package modules.products.functions;

import java.awt.Dimension;
import java.awt.Font;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.util.ArrayList;
import java.util.Collections;

import javax.swing.DefaultListModel;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JList;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JSeparator;
import javax.swing.JTable;
import javax.swing.JTextField;

import modules.products.clothes;
import modules.products.item;
import modules.products.machinery;
import modules.products.product;

public class CRUD_tool_product {

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

	public static String[] productos_nombre_precio_product(int dato, ArrayList<product> productos) {
		String[] dato_final = new String[size_product(dato, productos)];
		int inicio = 0;

		if (dato == 0) {
			for (int i = 0; i < productos.size(); i++) {
				if (productos.get(i) instanceof item) {
					dato_final[inicio] = productos.get(i).getNombre() + " - " + productos.get(i).getPrecio() + "\u20AC";
					inicio++;
				}
			}
		} else if (dato == 1) {
			for (int i = 0; i < productos.size(); i++) {
				if (productos.get(i) instanceof machinery) {
					dato_final[inicio] = productos.get(i).getNombre() + " - " + productos.get(i).getPrecio() + "\u20AC";
					inicio++;
				}
			}
		} else if (dato == 2) {
			for (int i = 0; i < productos.size(); i++) {
				if (productos.get(i) instanceof clothes) {
					dato_final[inicio] = productos.get(i).getNombre() + " - " + productos.get(i).getPrecio() + "\u20AC";
					inicio++;
				}
			}
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
					System.out.println(productos.get(i).getNombre());
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

	public static Object buscar_producto(int dato, ArrayList<product> productos, String titulo, String mensaje,
			String boton_i) {
		// Variables
		int opcion = 0;
		Object dato_final = null;

		// Inputs
		JTextField input = new JTextField();
		input.setPreferredSize(new Dimension(200, 26));
		JButton boton = new JButton("Buscar");

		// Separador
		JSeparator separador = new JSeparator();

		// JPanel
		JPanel busqueda = new JPanel();
		busqueda.add(input);
		busqueda.add(boton);

		// Title
		JLabel titulo_l = new JLabel(mensaje, JLabel.CENTER);
		titulo_l.setFont(new Font("DigifaceWide Regular", Font.BOLD, 17));

		// Lista
		Object[] nombres_producto = productos_nombre_product(dato, productos);
		DefaultListModel<String> model = new DefaultListModel<>();

		// Botones
		String[] botones = { boton_i, "Atras" };

		JList<String> lista = new JList<>(model);
		JScrollPane sp = new JScrollPane(lista);
		// lista.setPreferredSize(new Dimension(200, 200));

		for (int i = 0; i < nombres_producto.length; i++) {
			model.addElement((String) nombres_producto[i]);
			lista.setSelectedValue((String) nombres_producto[0], true);
		}

		boton.addActionListener(event -> {
			model.removeAllElements();
			lista.setEnabled(true);
			for (int i = 0; i < nombres_producto.length; i++) {
				if (((String) nombres_producto[i]).indexOf(input.getText()) != -1) {
					model.addElement(((String) nombres_producto[i]));
					lista.setSelectedValue((String) nombres_producto[0], true);
				}
			}
			if (model.getSize() == 0) {
				model.addElement("No se encuentra resultado");
				lista.setEnabled(false);
				lista.setSelectedValue((String) nombres_producto[0], false);
			} else {
				lista.setEnabled(true);
				lista.setSelectedValue((String) nombres_producto[0], true);
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
				for (int i = 0; i < productos.size(); i++) {
					if (productos.get(i).getNombre() == lista.getSelectedValue()) {
						dato_final = i;
						break;
					}
				}
			}
		} while (dato_final == null);

		return dato_final;
	}

	public static Object[][] datos;

	public static Object buscar_producto_beta(int dato, ArrayList<product> productos, String titulo, String mensaje,
			String boton_i) {
		Object[] nombres_columnas = { "Nombre \u25BC", "Precio \u25BC", "Stock \u25BC", "Garantia \u25BC" };
		ArrayList<product> nombres_producto = productos(dato, productos);
		datos = new Object[nombres_producto.size()][4];

		// Variables
		int opcion = 0;
		Object dato_final = null;

		// Inputs
		JTextField input = new JTextField();
		input.setPreferredSize(new Dimension(200, 26));
		JButton boton = new JButton("Buscar");

		// Separador
		JSeparator separador = new JSeparator();

//		// JPanel
//		JPanel busqueda = new JPanel();
//		busqueda.add(input);
//		busqueda.add(boton);
//
//		// Title
//		JLabel titulo_l = new JLabel(mensaje, JLabel.CENTER);
//		titulo_l.setFont(new Font("DigifaceWide Regular", Font.BOLD, 17));

		// Para que no se pueda editar
		JTable table = new JTable(datos, nombres_columnas) {
			/**
			 * 
			 */
			private static final long serialVersionUID = 1L;

			public boolean isCellEditable(int row, int column) {
				return false;
			}
		};

		// Meto la informacion en la tabla
		for (int i = 0; i < nombres_producto.size(); i++) {
			datos[i][0] = nombres_producto.get(i).getNombre();
			datos[i][1] = nombres_producto.get(i).getPrecio();
			datos[i][2] = nombres_producto.get(i).getStock();
			datos[i][3] = nombres_producto.get(i).getGarantia();
		}

		// Botones
		String[] botones = { boton_i, "Atras" };

		// Captura el clic de la columna.
		table.getTableHeader().addMouseListener(new MouseAdapter() {
			public void mouseClicked(MouseEvent e) {
				datos = ordena_producto(nombres_producto, table.columnAtPoint(e.getPoint()), nombres_columnas);
			}
		});

		boton.addActionListener(event -> {
			// Borramos la informacion
			for (int i = 0; i < nombres_producto.size(); i++) {
				datos[i][0] = "";
				datos[i][1] = "";
				datos[i][2] = "";
				datos[i][3] = "";
			}

			int index = 0;
			for (int i = 0; i < nombres_producto.size(); i++) {

				if ((nombres_producto.get(i).getNombre()).indexOf(input.getText()) != -1) {
					datos[index][0] = nombres_producto.get(i).getNombre();
					datos[index][1] = nombres_producto.get(i).getPrecio();
					datos[index][2] = nombres_producto.get(i).getStock();
					datos[index][3] = nombres_producto.get(i).getGarantia();
					index++;
				}
			}

		});

		JScrollPane scrollPane = new JScrollPane(table);
		scrollPane.setPreferredSize(new Dimension(450, 200));

		do {
			// Mete los Objetos
			Object[] inputs = { /* titulo_l, busqueda, */ separador, scrollPane };

			opcion = JOptionPane.showOptionDialog(null, inputs, titulo, JOptionPane.DEFAULT_OPTION,
					JOptionPane.PLAIN_MESSAGE, null, botones, botones);

			// Comprueba la informacion.
			if (opcion != 0)
				return null;
			else if (opcion == 0) {
				for (int i = 0; i < productos.size(); i++) {
					if (datos[table.getSelectedRow()][0] == productos.get(i).getNombre()) {
						dato_final = i;
					}
				}
			}
		} while (dato_final == null);

		return dato_final;
	}

	public static boolean interruptor = false;

	public static Object[][] ordena_producto(ArrayList<product> nombres_producto, int orden,
			Object[] nombres_columnas) {
		ArrayList<String> por_ordenar = new ArrayList<String>();
		ArrayList<product> ordenado = new ArrayList<product>();

		if (orden == 0) {
			// Obtiene el Nombre
			for (int i = 0; i < nombres_producto.size(); i++) {
				por_ordenar.add(nombres_producto.get(i).getNombre());
			}

			// Comprueba el orden de los nombres
			if (interruptor == false) {
				Collections.sort(por_ordenar);
				interruptor = true;
			} else {
				Collections.sort(por_ordenar, Collections.reverseOrder());
				interruptor = false;
			}

			// Extrae la informacion de el objeto para extrerlo
			for (int x = 0; x < nombres_producto.size(); x++) {
				for (int i = 0; i < por_ordenar.size(); i++) {
					if (por_ordenar.get(x) == nombres_producto.get(i).getNombre()) {
						ordenado.add(nombres_producto.get(i));
						break;
					}

				}
			}
		} else if (orden == 1) {
			// Obtiene el Precio
			for (int i = 0; i < nombres_producto.size(); i++) {
				por_ordenar.add(nombres_producto.get(i).getPrecio());
			}

			// Comprueba el orden de los Precio
			if (interruptor == false) {
				Collections.sort(por_ordenar);
				interruptor = true;
			} else {
				Collections.sort(por_ordenar, Collections.reverseOrder());
				interruptor = false;
			}

			// Extrae la informacion de el objeto para extrerlo
			for (int x = 0; x < nombres_producto.size(); x++) {
				for (int i = 0; i < por_ordenar.size(); i++) {
					if (por_ordenar.get(x) == nombres_producto.get(i).getPrecio()) {
						ordenado.add(nombres_producto.get(i));
						break;
					}
				}
			}
		} else if (orden == 2) {
			// Obtiene el Stock
			for (int i = 0; i < nombres_producto.size(); i++) {
				por_ordenar.add(nombres_producto.get(i).getStock());
			}

			// Comprueba el orden de los Stock
			if (interruptor == false) {
				Collections.sort(por_ordenar);
				interruptor = true;
			} else {
				Collections.sort(por_ordenar, Collections.reverseOrder());
				interruptor = false;
			}

			// Extrae la informacion de el objeto para extrerlo

			for (int x = 0; x < nombres_producto.size(); x++) {
				for (int i = 0; i < por_ordenar.size(); i++) {
					if (por_ordenar.get(x) == nombres_producto.get(i).getStock()) {
						ordenado.add(nombres_producto.get(i));
						break;
					}
				}
			}
		} else if (orden == 3) {
			// Obtiene el Garantia
			for (int i = 0; i < nombres_producto.size(); i++) {
				por_ordenar.add(nombres_producto.get(i).getGarantia());
			}

			// Comprueba el orden de los Garantia
			if (interruptor == false) {
				Collections.sort(por_ordenar);
				interruptor = true;
			} else {
				Collections.sort(por_ordenar, Collections.reverseOrder());
				interruptor = false;
			}

			// Extrae la informacion de el objeto para extrerlo
			for (int x = 0; x < nombres_producto.size(); x++) {

				for (int i = 0; i < por_ordenar.size(); i++) {
					if (por_ordenar.get(x) == nombres_producto.get(i).getGarantia()) {
						ordenado.add(nombres_producto.get(i));
						break;
					}
				}
			}
		}

		// Crea el array bidimensional para la tabla
		System.out.println(ordenado.size());
		for (int i = 0; i < ordenado.size(); i++) {
			datos[i][0] = ordenado.get(i).getNombre();
			datos[i][1] = ordenado.get(i).getPrecio();
			datos[i][2] = ordenado.get(i).getStock();
			datos[i][3] = ordenado.get(i).getGarantia();
		}
		return datos;
	}

}
