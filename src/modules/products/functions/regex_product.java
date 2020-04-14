package modules.products.functions;

import java.awt.Color;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

import javax.swing.JLabel;

public class regex_product {

	public static Object[] product(int num_input, String input) {
		Object[] output = new Object[2];
		output[0] = false;
		output[1] = "";

		switch (num_input) {
		// Nombre
		case 0:
			output = (Object[]) empty(input);
			break;
		// Precio
		case 1:
			output = (Object[]) empty(input);
			if (output[0] != (Object) true) {
				output = (Object[]) precio(input);
			}
			break;
		// Stock
		case 2:
			output = (Object[]) empty(input);
			if (output[0] != (Object) true) {
				output = (Object[]) stock(input);
			}
			break;
		// Imagen
		case 3:
			output = (Object[]) empty(input);
			if (output[0] == (Object) false) {
				output = (Object[]) imagen(input);
			} else {
				output[0] = false;
				output[1] = "";
			}
			break;
		// Garantia
		case 5:
			output = (Object[]) empty(input);
			if (output[0] != (Object) true) {
				output = (Object[]) garantia(input);
			}
			break;
		}

		return output;
	}

	public static Object[] item(int num_input, String input) {
		Object[] output = new Object[2];
		output[0] = false;
		output[1] = "";

		if (num_input <= 5) {
			output = product(num_input, input);
		} else {
			switch (num_input) {
			case 8:
				output = (Object[]) empty(input);
				if (output[0] == (Object) false) {
					output = (Object[]) cantidad(input);
				} else {
					output[0] = false;
					output[1] = "";
				}
				break;
			}
		}

		return output;
	}

	public static Object[] machinery(int num_input, String input) {
		Object[] output = new Object[2];
		output[0] = false;
		output[1] = "";

		if (num_input <= 5) {
			output = product(num_input, input);
		} else {
			switch (num_input) {
			case 6:
				output = (Object[]) empty(input);
				if (output[0] == (Object) false) {
					output = (Object[]) peso(input);
				} else {
					output[0] = false;
					output[1] = "";
				}
				break;
			case 7:
				output = (Object[]) empty(input);
				if (output[0] == (Object) false) {
					output = (Object[]) dimensiones(input);
				} else {
					output[0] = false;
					output[1] = "";
				}
				break;
			}
		}

		return output;
	}

	public static Object[] clothes(int num_input, String input) {
		Object[] output = new Object[2];
		output[0] = false;
		output[1] = "";

		if (num_input <= 5) {
			output = product(num_input, input);
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

	public static Object precio(String dato) {
		Pattern pattern = Pattern.compile("^[0-9]+([.][0-9]+)?$");
		Matcher matcher = pattern.matcher(dato);

		Object[] output = new Object[2];
		JLabel product = new JLabel("(El precio no es válido, ejemplo. 14 o 30.40)");
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

	public static Object stock(String dato) {
		Pattern pattern = Pattern.compile("^[0-9]+$");
		Matcher matcher = pattern.matcher(dato);

		Object[] output = new Object[2];
		JLabel product = new JLabel("(El stock no es válido, ejemplo. 9 o 300)");
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

	public static Object imagen(String dato) {
		Pattern pattern = Pattern.compile("^[http]+s?[:]{1}[/]{2}[a-z]*([.]{1}[a-z]+)[./a-z]*");
		Matcher matcher = pattern.matcher(dato);

		Object[] output = new Object[2];
		JLabel product = new JLabel("(La url no es válida, ejemplo. http://g.com/t.jpg)");
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

	public static Object garantia(String dato) {
		Pattern pattern = Pattern.compile("^[0-9]+$");
		Matcher matcher = pattern.matcher(dato);

		Object[] output = new Object[2];
		JLabel product = new JLabel("(La garantia no es válida, ejemplo. 6 o 24)");
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

	public static Object cantidad(String dato) {
		Pattern pattern = Pattern.compile("^[1-9]+$");
		Matcher matcher = pattern.matcher(dato);

		Object[] output = new Object[2];
		JLabel product = new JLabel("(La cantidad no es válida, ejemplo. 1 o 100)");
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

	public static Object peso(String dato) {
		Pattern pattern = Pattern.compile("^[0-9]+([,][0-9]+)?$");
		Matcher matcher = pattern.matcher(dato);

		Object[] output = new Object[2];
		JLabel product = new JLabel("(El peso no es válido, ejemplo. 30 o 440,4)");
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

	public static Object dimensiones(String dato) {
		Pattern pattern = Pattern.compile("[0-9]*([.][0-9]*)?([x][0-9]+)*");
		Matcher matcher = pattern.matcher(dato);

		Object[] output = new Object[2];
		JLabel product = new JLabel("(Las dimensiones no son válidas, \n ejemplo. 30.2 o 400.2x320x2)");
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
