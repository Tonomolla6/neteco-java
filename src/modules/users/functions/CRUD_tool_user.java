package modules.users.functions;

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

import modules.users.user;

public class CRUD_tool_user {

	public static int size_clients(int opcion, ArrayList<user> clientes) {
		int contador = 0;
		if (opcion == 0) {
			for (int i = 0; i < clientes.size(); i++) {
				if (clientes.get(i).getTipo_de_usuario().equals("Administrador")) {
					contador++;
				}
			}
		} else {
			for (int i = 0; i < clientes.size(); i++) {
				if (clientes.get(i).getTipo_de_usuario().equals("Cliente")) {
					contador++;
				}
			}
		}
		return contador;
	}

	public static Object input_list_client(ArrayList<user> clientes) {
		Object dato_final = "";
		String[] nombres = new String[clientes.size()];

		for (int i = 0; i < clientes.size(); i++) {
			nombres[i] = clientes.get(i).getNombre();
		}

		dato_final = JOptionPane.showInputDialog(null, "Seleccione un cliente para modificar", "Modificar producto",
				JOptionPane.DEFAULT_OPTION, null, nombres, nombres);

		if (dato_final != null)
			for (int i = 0; i < clientes.size(); i++) {
				if (clientes.get(i).getNombre() == dato_final) {
					dato_final = i;
					break;
				}
			}

		return dato_final;

	}

	public static Object buscar_cliente(ArrayList<user> clientes, String titulo, String mensaje, String boton_i) {
		// Variables
		int opcion = 0;
		Object dato_final = null;
		String[] nombres = new String[clientes.size()];

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
		for (int i = 0; i < clientes.size(); i++) {
			nombres[i] = clientes.get(i).getNombre();
		}
		DefaultListModel<String> model = new DefaultListModel<>();

		// Botones
		String[] botones = { boton_i, "Atras" };

		JList<String> lista = new JList<>(model);
		JScrollPane sp = new JScrollPane(lista);
//		lista.setPreferredSize(new Dimension(200, 200));

		for (int i = 0; i < nombres.length; i++) {
			model.addElement((String) nombres[i]);
			lista.setSelectedValue((String) nombres[0], true);
		}

		boton.addActionListener(event -> {
			model.removeAllElements();
			for (int i = 0; i < nombres.length; i++) {
				if (((String) nombres[i]).indexOf(input.getText()) != -1) {
					model.addElement(((String) nombres[i]));
					lista.setSelectedValue((String) nombres[0], true);
				}
			}
			if (model.getSize() == 0) {
				model.addElement("No se encuentra resultado");
				lista.setEnabled(false);
				lista.setSelectedValue((String) nombres[0], false);
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
				for (int i = 0; i < clientes.size(); i++) {
					if (clientes.get(i).getNombre() == lista.getSelectedValue()) {
						dato_final = i;
						break;
					}
				}
			}
		} while (dato_final == null);
		return dato_final;
	}

	public static Object[][] datos;

	public static Object buscar_cliente_beta(ArrayList<user> clientes, String titulo, String mensaje, String boton_i) {
		Object[] nombres_columnas = { "Nombre \u25BC", "Apellidos \u25BC", "Dni \u25BC", "Lugar de trabajo" };
		ArrayList<String> nombres = new ArrayList<String>();
		for (int i = 0; i < clientes.size(); i++) {
			nombres.add(clientes.get(i).getNombre());
		}
		datos = new Object[clientes.size()][4];

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
		for (int i = 0; i < clientes.size(); i++) {
			datos[i][0] = clientes.get(i).getNombre();
			datos[i][1] = clientes.get(i).getApellidos();
			datos[i][2] = clientes.get(i).getDni();
			datos[i][3] = clientes.get(i).getLugar_de_trabajo();
		}

		// Botones
		String[] botones = { boton_i, "Atras" };

		// Captura el clic de la columna.
		table.getTableHeader().addMouseListener(new MouseAdapter() {
			public void mouseClicked(MouseEvent e) {
				if (table.columnAtPoint(e.getPoint()) != 3)
					datos = ordena_cliente(clientes, table.columnAtPoint(e.getPoint()), nombres_columnas);
			}
		});

		boton.addActionListener(event -> {
			// Borramos la informacion
			for (int i = 0; i < clientes.size(); i++) {
				datos[i][0] = "";
				datos[i][1] = "";
				datos[i][2] = "";
				datos[i][3] = "";
			}

			int index = 0;
			for (int i = 0; i < clientes.size(); i++) {

				if ((clientes.get(i).getNombre()).indexOf(input.getText()) != -1) {
					datos[index][0] = clientes.get(i).getNombre();
					datos[index][1] = clientes.get(i).getApellidos();
					datos[index][2] = clientes.get(i).getDni();
					datos[index][3] = clientes.get(i).getLugar_de_trabajo();
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
				for (int i = 0; i < clientes.size(); i++) {
					if (datos[table.getSelectedRow()][0] == clientes.get(i).getNombre()) {
						dato_final = i;
					}
				}
			}
		} while (dato_final == null);

		return dato_final;
	}

	public static boolean interruptor = false;

	public static Object[][] ordena_cliente(ArrayList<user> clientes, int orden, Object[] nombres_columnas) {
		ArrayList<String> por_ordenar = new ArrayList<String>();
		ArrayList<user> ordenado = new ArrayList<user>();

		if (orden == 0) {
			// Obtiene el Nombre
			for (int i = 0; i < clientes.size(); i++) {
				por_ordenar.add(clientes.get(i).getNombre());
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
			for (int x = 0; x < clientes.size(); x++) {
				for (int i = 0; i < por_ordenar.size(); i++) {
					if (por_ordenar.get(x) == clientes.get(i).getNombre()) {
						ordenado.add(clientes.get(i));
					}
				}
			}
		} else if (orden == 1) {
			// Obtiene el Precio
			for (int i = 0; i < clientes.size(); i++) {
				por_ordenar.add(clientes.get(i).getApellidos());
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
			for (int x = 0; x < clientes.size(); x++) {
				for (int i = 0; i < por_ordenar.size(); i++) {
					if (por_ordenar.get(x) == clientes.get(i).getApellidos()) {
						ordenado.add(clientes.get(i));
					}
				}
			}
		} else if (orden == 2) {
			// Obtiene el Stock
			for (int i = 0; i < clientes.size(); i++) {
				por_ordenar.add(clientes.get(i).getDni());
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
			for (int x = 0; x < clientes.size(); x++) {
				for (int i = 0; i < por_ordenar.size(); i++) {
					if (por_ordenar.get(x) == clientes.get(i).getDni()) {
						ordenado.add(clientes.get(i));
					}
				}
			}
		} else if (orden == 3) {
			// Obtiene el Garantia
			for (int i = 0; i < clientes.size(); i++) {
				por_ordenar.add(clientes.get(i).getLugar_de_trabajo());
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
			for (int x = 0; x < clientes.size(); x++) {

				for (int i = 0; i < por_ordenar.size(); i++) {
					if (por_ordenar.get(x) == clientes.get(i).getLugar_de_trabajo()) {
						ordenado.add(clientes.get(i));
					}
				}
			}
		}

		// Crea el array bidimensional para la tabla
		for (int i = 0; i < ordenado.size(); i++) {
			datos[i][0] = ordenado.get(i).getNombre();
			datos[i][1] = ordenado.get(i).getApellidos();
			datos[i][2] = ordenado.get(i).getDni();
			datos[i][3] = ordenado.get(i).getLugar_de_trabajo();
		}
		return datos;
	}
}
