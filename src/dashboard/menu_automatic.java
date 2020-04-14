package dashboard;

import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;

import javax.swing.JOptionPane;

public class menu_automatic {

	public static void menu_automatic(String[] opciones, String[] funciones, String titulo, String clase, boolean dato,
			int ventana, int opcion, int other, String clase_dos) {
		int operacion = 0;
		boolean interruptor = false;

		do {
			// Pide la informacion de los botones.
			operacion = JOptionPane.showOptionDialog(null, titulo, "NETECO", JOptionPane.YES_NO_OPTION,
					JOptionPane.PLAIN_MESSAGE, null, opciones, opciones);

			// Comprueba el boton de atras, y la salida.
			if (operacion == -1 || funciones[operacion] == "exit(0)") {
				interruptor = true;
			} else if (funciones[operacion] == "back(0)") {
				return;
			} else {
				// Llama a la funcion.
				try {
					Class<?> clazz = Class.forName(clase);

					if (other != 0 && operacion == other)
						clazz = Class.forName(clase_dos);

					try {
						if (ventana == 1) {
							Method method = clazz.getDeclaredMethod(funciones[operacion], int.class);
							method.invoke(null, opcion);
						} else if (ventana == 2) {
							Method method = clazz.getDeclaredMethod(funciones[operacion], int.class);
							method.invoke(null, operacion);
						} else if (dato == false) {
							Method method = clazz.getDeclaredMethod(funciones[operacion]);
							method.invoke(null);
						} else {
							Method method = clazz.getDeclaredMethod(funciones[operacion], String.class, int.class);
							method.invoke(null, opciones[operacion], operacion);
						}

					} catch (InvocationTargetException e) {
						throw new RuntimeException(e);
					}
				} catch (NoSuchMethodException e) {
					throw new RuntimeException(e);
				} catch (IllegalAccessException e) {
					throw new RuntimeException(e);
				} catch (ClassNotFoundException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}
			}

		} while (interruptor == false);
		login.login();
	}
}
