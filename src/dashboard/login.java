package dashboard;

import java.awt.Color;
import java.util.ArrayList;

import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPasswordField;
import javax.swing.JTextField;

import modules.users.user;
import modules.users.functions.functions_User_CRUD;

public class login {

	public static int logeado = 0;
	static ArrayList<user> usuarios = new ArrayList<user>();

	public static Object login() {
		try {
			if (usuarios.get(0).getTipo_de_usuario().equals("Administrador"))
				;
		} catch (Exception e) {
			user admin;
			admin = new user("admin", "", "", "", "", "Administrador", "admin");
			usuarios.add(admin);
			functions_User_CRUD.clientes_add(usuarios);
		}
		int opcion = 0;
		JTextField user = new JTextField();
		JPasswordField passwd = new JPasswordField();
		boolean key = false;
		Object[] inputs = { user, passwd };
		JLabel error = new JLabel();
		error.setForeground(Color.RED);
		String[] botones = { "Iniciar sesion" , "Salir" };
		int usuario = 0;
		boolean interruptor = false;
		String passwd_c = "";

		do {
			ArrayList<user> usuarios = functions_User_CRUD.clientes();
			Object[] muestras = { "Usuario", inputs[0], "Contraseña", inputs[1], error };

			opcion = JOptionPane.showOptionDialog(null, muestras, "NETECO", JOptionPane.YES_NO_OPTION,
					JOptionPane.PLAIN_MESSAGE, null, botones, botones);
			passwd_c = new String(passwd.getPassword());

			if (opcion != 0)
				return null;
			else {
				usuario = 0;
				key = false;
				for (int i = 0; i < usuarios.size(); i++) {
					if (usuarios.get(i).getNombre().equals(user.getText())) {
						error.setText("");
						if (usuarios.get(i).getPasswd().equals(passwd_c)) {
							usuario = i;
							logeado = usuario;
							key = true;
						} else {
							error.setText("Contraseña incorrecta");
							break;
						}
					} else {
						error.setText("El usuario no existe");
					}
				}

				if (key == true) {
					if (usuarios.get(usuario).getTipo_de_usuario() == "Administrador") {
						home.admin_main();
						interruptor = true;
					} else {
						home.user_main();
						interruptor = true;
					}
				}
			}
		} while (interruptor == false);

		return null;
	}

	public static int logeado() {
		return logeado;
	}
}
