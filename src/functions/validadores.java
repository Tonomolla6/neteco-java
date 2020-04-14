package functions;

import javax.swing.JOptionPane;

public class validadores {

	// Funcion para validar si la información introducida es un numero int.
	// fact 0 = title.
	// fact 1 = message.
	public static Integer intverifier(String[] fact) {
		// Comprobamos la información de la variable fact.
		if (fact[0] == null)
			fact[0] = "Java program";
		if (fact[1] == null)
			fact[1] = "Write a number";

		// Declaration of the variables.
		String num_entry = "";
		Integer num_exit = 0;
		boolean switche = false;

		// Bucle infinito hasta que el usuario escriba un numero int valido.
		do {
			try {
				num_entry = JOptionPane.showInputDialog(null, fact[1], fact[0], JOptionPane.QUESTION_MESSAGE);
				if (num_entry == null) {
					num_exit = null;
					switche = true;
				} else {
					num_exit = Integer.parseInt(num_entry);
					switche = true;
				}
			} catch (Exception e) {
				JOptionPane.showMessageDialog(null, "You have not entered a number", fact[0] + " - Error",
						JOptionPane.ERROR_MESSAGE);
			}

		} while (switche == false);

		return num_exit;
	}

	// Funcion para validar si la información introducida es un numero int.
	// fact 0 = title.
	// fact 1 = message.
	public static Integer intverifier_cero(String[] fact) {
		// Comprobamos la información de la variable fact.
		if (fact[0] == null)
			fact[0] = "Java program";
		if (fact[1] == null)
			fact[1] = "Write a number";

		// Declaration of the variables.
		String num_entry = "";
		Integer num_exit = 0;
		boolean switche = false;

		// Bucle infinito hasta que el usuario escriba un numero int valido.
		do {
			try {
				num_entry = JOptionPane.showInputDialog(null, fact[1], fact[0], JOptionPane.QUESTION_MESSAGE);
				if (num_entry == null) {
					num_exit = null;
					switche = true;
				} else if (Integer.parseInt(num_entry) == 0) {
					JOptionPane.showMessageDialog(null, "The number 0 is not accepted", fact[0] + " - Error",
							JOptionPane.ERROR_MESSAGE);
				} else {
					num_exit = Integer.parseInt(num_entry);
					switche = true;
				}
			} catch (Exception e) {
				JOptionPane.showMessageDialog(null, "You have not entered a number", fact[0] + " - Error",
						JOptionPane.ERROR_MESSAGE);
			}

		} while (switche == false);

		return num_exit;
	}

	public static Integer intverifier_nagativo(String[] fact) {
		// Comprobamos la información de la variable fact.
		if (fact[0] == null)
			fact[0] = "Java program";
		if (fact[1] == null)
			fact[1] = "Write a number";

		// Declaration of the variables.
		String num_entry = "";
		Integer num_exit = 0;
		boolean switche = false;

		// Bucle infinito hasta que el usuario escriba un numero int valido.
		do {
			try {
				num_entry = JOptionPane.showInputDialog(null, fact[1], fact[0], JOptionPane.QUESTION_MESSAGE);
				if (num_entry == null) {
					num_exit = null;
					switche = true;
				} else if (Integer.parseInt(num_entry) > 0) {
					JOptionPane.showMessageDialog(null, "Negative numbers are not accepted.", fact[0] + " - Error",
							JOptionPane.ERROR_MESSAGE);
				} else {
					num_exit = Integer.parseInt(num_entry);
					switche = true;
				}
			} catch (Exception e) {
				JOptionPane.showMessageDialog(null, "You have not entered a number", fact[0] + " - Error",
						JOptionPane.ERROR_MESSAGE);
			}

		} while (switche == false);

		return num_exit;
	}

	public static Integer intverifier_nagativo_cero(String[] fact) {
		// Comprobamos la información de la variable fact.
		if (fact[0] == null)
			fact[0] = "Java program";
		if (fact[1] == null)
			fact[1] = "Write a number";

		// Declaration of the variables.
		String num_entry = "";
		Integer num_exit = 0;
		boolean switche = false;

		// Bucle infinito hasta que el usuario escriba un numero int valido.
		do {
			try {
				num_entry = JOptionPane.showInputDialog(null, fact[1], fact[0], JOptionPane.QUESTION_MESSAGE);
				if (num_entry == null) {
					num_exit = null;
					switche = true;
				} else if (Integer.parseInt(num_entry) < 0) {
					JOptionPane.showMessageDialog(null, "Negative numbers are not accepted.", fact[0] + " - Error",
							JOptionPane.ERROR_MESSAGE);
				} else if (Integer.parseInt(num_entry) == 0) {
					JOptionPane.showMessageDialog(null, "The number 0 is not accepted", fact[0] + " - Error",
							JOptionPane.ERROR_MESSAGE);
				} else {
					num_exit = Integer.parseInt(num_entry);
					switche = true;
				}
			} catch (Exception e) {
				JOptionPane.showMessageDialog(null, "You have not entered a number", fact[0] + " - Error",
						JOptionPane.ERROR_MESSAGE);
			}

		} while (switche == false);

		return num_exit;
	}

}
