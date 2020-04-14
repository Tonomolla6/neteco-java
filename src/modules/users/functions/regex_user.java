package modules.users.functions;

import java.awt.Color;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

import javax.swing.JLabel;

public class regex_user {

	public static Object[] client(int num_input, String input) {
		Object[] output = new Object[2];
		output[0] = false;
		output[1] = "";

		switch (num_input) {
		// Nombre
		case 0:
			output = (Object[]) empty(input);
			if (output[0] != (Object) true) {
				output = (Object[]) nombre_apellido(input, "nombre");
			}
			break;
		// Apellidos
		case 1:
			output = (Object[]) empty(input);
			if (output[0] != (Object) true) {
				output = (Object[]) nombre_apellido(input, "apellido");
			}
			break;
		// Stock
		case 2:
			output = (Object[]) empty(input);
			if (output[0] == (Object) false) {
				output = (Object[]) dni(input);
			} else {
				output[0] = false;
				output[1] = "";
			}
			break;
		// Garantia
		case 4:
			output = (Object[]) empty(input);
			if (output[0] == (Object) false) {
				output = (Object[]) edad(input);
			} else {
				output[0] = false;
				output[1] = "";
			}
			break;
		}

		return output;
	}

	public static Object empty(String input) {
		Object[] output = new Object[2];
		JLabel product = new JLabel("(No puede quedarse en blanco)");
		product.setForeground(Color.RED);

		if (input.isEmpty()) {
			output[0] = true;
			output[1] = product;
		} else {
			output[0] = false;
			output[1] = "";
		}

		return output;
	}

	public static Object nombre_apellido(String dato, String tipo) {
		Pattern pattern = Pattern.compile("^[a-zA-Z]+$");
		Matcher matcher = pattern.matcher(dato);

		Object[] output = new Object[2];
		JLabel product = new JLabel("(El " + tipo + " no es valido, ejemplo. Morales)");
		product.setForeground(Color.RED);

		if (matcher.matches()) {
			output[0] = false;
			output[1] = "";
		} else {
			output[0] = true;
			output[1] = product;
		}
		return output;
	}

	public static Object dni(String dato) {
		Pattern pattern = Pattern.compile("^[0-9]{8}[TRWAGMYFPDXBNJZSQVHLCKE]{1}$");
		Matcher matcher = pattern.matcher(dato);

		Object[] output = new Object[2];
		JLabel product = new JLabel("(El dni no es valido, ejemplo. 49323245E)");
		product.setForeground(Color.RED);

		if (matcher.matches()) {
			output[0] = false;
			output[1] = "";
		} else {
			output[0] = true;
			output[1] = product;
		}
		return output;
	}

	public static Object edad(String dato) {
		Pattern pattern = Pattern.compile("^[0-9]+$");
		Matcher matcher = pattern.matcher(dato);

		Object[] output = new Object[2];
		JLabel product = new JLabel("(La edad no es valida, ejemplo. 15)");
		product.setForeground(Color.RED);

		if (matcher.matches()) {
			output[0] = false;
			output[1] = "";
		} else {
			output[0] = true;
			output[1] = product;
		}
		return output;
	}

}
