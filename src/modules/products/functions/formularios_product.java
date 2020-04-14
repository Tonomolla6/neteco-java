package modules.products.functions;

import javax.swing.JComboBox;
import javax.swing.JOptionPane;
import javax.swing.JScrollPane;
import javax.swing.JTextArea;
import javax.swing.JTextField;
import javax.swing.ScrollPaneConstants;
import javax.swing.text.JTextComponent;

public class formularios_product {

	// items
	// --------------------------------------------------------------------------------------------------------

	public static String[] item_form(String[] modificacion) {

		JTextField nombre = new JTextField(20);
		JTextField precio = new JTextField(20);
		JTextField stock = new JTextField(20);
		JTextField imagen = new JTextField(20);
		JTextArea description_i = new JTextArea(4, 0);
		JScrollPane description = new JScrollPane(description_i);
		description.setVerticalScrollBarPolicy(ScrollPaneConstants.VERTICAL_SCROLLBAR_ALWAYS);
		JTextField garantia = new JTextField(20);
		JTextField marca = new JTextField();
		JComboBox<String> familia = new JComboBox<String>();
		String[] array = { "Ninguna", "Papel", "Quimico", "Guantes" };
		JTextField cantidad = new JTextField(20);
		Object[] error = new Object[9];
		String atexto = "";
		boolean interruptor = false;
		Object[] regex_result = new Object[3];
		int avisador = 0;
		String[] botones = { "Crear", "Cancelar" };
		int tmp = 0;
		String titulo = "CREAR PRODUCTO item";

		// Guardas las posiciones vacias.
		for (int i = 0; i < error.length; i++) {
			error[i] = "";
		}
		// Establezco los valores del jboxcombo
		for (int i = 0; i < array.length; i++) {
			familia.addItem(array[i]);
		}

		// Declaramos las variables en el input;
		Object[] inputs = { nombre, precio, stock, imagen, description, garantia, familia, marca, cantidad };

		// Pregunta si hay variables
		if (modificacion[0] != null) {
			for (int i = 0; i < inputs.length; i++) {
				if (i == 4)
					description_i.setText(modificacion[i]);
				else if (i == 6)
					familia.setSelectedItem(modificacion[i]);
				else
					((JTextComponent) inputs[i]).setText(modificacion[i]);
				botones[0] = "Modificar";
				titulo = "MODIFICAR PRODUCTO ITEM";
			}
		}

		int[] posicion_avisador = new int[inputs.length];

		do {
			avisador = 0;
			Object[] muestras = { titulo, " ", "Nombre* ", error[0], inputs[0], "Precio(eur)*", error[1], inputs[1],
					"Stock(pcs)*", error[2], inputs[2], "Imagen(url)", error[3], inputs[3], "Descripcion", error[4],
					inputs[4], "Garantia(meses)*", error[5], inputs[5], "Familia", error[6], inputs[6], "Marca",
					error[7], inputs[7], "Cantidad", error[8], inputs[8] };

			int opcion = JOptionPane.showOptionDialog(null, muestras, "NETECO", JOptionPane.YES_NO_OPTION,
					JOptionPane.PLAIN_MESSAGE, null, botones, botones);

			if (opcion != 0) {
				return null;
			}
			for (int i = 0; i < inputs.length; i++) {
				if (i == 4) {
					atexto = ((JTextComponent) description_i).getText();
					regex_result = regex_product.item(i, atexto);
				} else if (i == 6) {
					atexto = (String) familia.getSelectedItem();
					regex_result = regex_product.item(i, atexto);
				} else {
					atexto = ((JTextComponent) inputs[i]).getText();
					regex_result = regex_product.item(i, atexto);
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

		String[] item_salida = { nombre.getText(), precio.getText(), stock.getText(), imagen.getText(),
				description_i.getText(), garantia.getText(), (String) familia.getSelectedItem(), marca.getText(),
				cantidad.getText() };
		return item_salida;
	}

	// machinery
	// --------------------------------------------------------------------------------------------------------

	public static String[] machinery_form(String[] modificacion) {

		JTextField nombre = new JTextField(20);
		JTextField precio = new JTextField(20);
		JTextField stock = new JTextField(20);
		JTextField imagen = new JTextField(20);
		JTextArea description_i = new JTextArea(4, 0);
		JScrollPane description = new JScrollPane(description_i);
		description.setVerticalScrollBarPolicy(ScrollPaneConstants.VERTICAL_SCROLLBAR_ALWAYS);
		JTextField garantia = new JTextField(20);
		JTextField peso = new JTextField(20);
		JTextField dimensiones = new JTextField(20);
		Object[] error = new Object[9];
		String atexto = "";
		boolean interruptor = false;
		Object[] regex_result = new Object[3];
		int avisador = 0;
		String[] botones = { "Crear", "Cancelar" };
		int tmp = 0;
		String titulo = "CREAR PRODUCTO MACHINERY";

		// Guardas las posiciones vacias.
		for (int i = 0; i < error.length; i++) {
			error[i] = "";
		}

		// Declaramos las variables en el input;
		Object[] inputs = { nombre, precio, stock, imagen, description, garantia, peso, dimensiones };

		// Pregunta si hay variables
		if (modificacion[0] != null) {
			for (int i = 0; i < inputs.length; i++) {
				if (i == 4)
					description_i.setText(modificacion[i]);
				else
					((JTextComponent) inputs[i]).setText(modificacion[i]);
				botones[0] = "Modificar";

			}
		}

		int[] posicion_avisador = new int[inputs.length];

		do {
			avisador = 0;
			Object[] muestras = { titulo, " ", "Nombre*", error[0], inputs[0], "Precio(eur)*", error[1], inputs[1],
					"Stock(pcs)*", error[2], inputs[2], "Imagen(url)", error[3], inputs[3], "Descripcion", error[4],
					inputs[4], "Garantia(meses)*", error[5], inputs[5], "Peso(g)", error[6], inputs[6],
					"Dimensiones(cm)", error[7], inputs[7] };

			int opcion = JOptionPane.showOptionDialog(null, muestras, "NETECO", JOptionPane.YES_NO_OPTION,
					JOptionPane.PLAIN_MESSAGE, null, botones, botones);

			if (opcion != 0) {
				return null;
			}
			for (int i = 0; i < inputs.length; i++) {
				if (i == 4) {
					atexto = ((JTextComponent) description_i).getText();
					regex_result = regex_product.machinery(i, atexto);
				} else {
					atexto = ((JTextComponent) inputs[i]).getText();
					regex_result = regex_product.machinery(i, atexto);
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

		String[] item_salida = { nombre.getText(), precio.getText(), stock.getText(), imagen.getText(),
				description_i.getText(), garantia.getText(), peso.getText(), dimensiones.getText() };

		return item_salida;
	}

	// clothes
	// --------------------------------------------------------------------------------------------------------

	public static String[] clothes_form(String[] modificacion) {

		JTextField nombre = new JTextField(20);
		JTextField precio = new JTextField(20);
		JTextField stock = new JTextField(20);
		JTextField imagen = new JTextField(20);
		JTextArea description_i = new JTextArea(4, 0);
		JScrollPane description = new JScrollPane(description_i);
		description.setVerticalScrollBarPolicy(ScrollPaneConstants.VERTICAL_SCROLLBAR_ALWAYS);
		JTextField garantia = new JTextField(20);
		JTextField color = new JTextField(20);
		JTextField talla = new JTextField(20);
		JTextField material = new JTextField(20);
		Object[] error = new Object[9];
		String atexto = "";
		boolean interruptor = false;
		Object[] regex_result = new Object[3];
		int avisador = 0;
		String[] botones = { "Crear", "Cancelar" };
		int tmp = 0;
		String titulo = "CREAR PRODUCTO CLOTHES";

		// Guardas las posiciones vacias.
		for (int i = 0; i < error.length; i++) {
			error[i] = "";
		}

		// Declaramos las variables en el input;
		Object[] inputs = { nombre, precio, stock, imagen, description, garantia, color, talla, material };

		// Pregunta si hay variables
		if (modificacion[0] != null) {
			for (int i = 0; i < inputs.length; i++) {
				if (i == 4)
					description_i.setText(modificacion[i]);
				else
					((JTextComponent) inputs[i]).setText(modificacion[i]);
				botones[0] = "Modificar";
				titulo = "MODIFICAR PRODUCTO clothes";
			}
		}

		int[] posicion_avisador = new int[inputs.length];

		do {
			avisador = 0;
			Object[] muestras = { titulo, " ", "Nombre*", error[0], inputs[0], "Precio(eur)*", error[1], inputs[1],
					"Stock(pcs)*", error[2], inputs[2], "Imagen(url)", error[3], inputs[3], "Descripcion", error[4],
					inputs[4], "Garantia(meses)*", error[5], inputs[5], "Color", error[6], inputs[6], "Talla", error[7],
					inputs[7], "Material", error[8], inputs[8] };

			int opcion = JOptionPane.showOptionDialog(null, muestras, "NETECO", JOptionPane.YES_NO_OPTION,
					JOptionPane.PLAIN_MESSAGE, null, botones, botones);

			if (opcion != 0) {
				return null;
			}
			for (int i = 0; i < inputs.length; i++) {
				if (i == 4) {
					atexto = ((JTextComponent) description_i).getText();
					regex_result = regex_product.clothes(i, atexto);
				} else {
					atexto = ((JTextComponent) inputs[i]).getText();
					regex_result = regex_product.clothes(i, atexto);
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

		String[] item_salida = { nombre.getText(), precio.getText(), stock.getText(), imagen.getText(),
				description_i.getText(), garantia.getText(), color.getText(), talla.getText(), material.getText() };

		return item_salida;
	}
}
