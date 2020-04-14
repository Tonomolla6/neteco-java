package functions;

import java.util.ArrayList;

import javax.swing.JOptionPane;

import dashboard.home;
import modules.products.clothes;
import modules.products.item;
import modules.products.machinery;
import modules.products.product;
import modules.products.functions.functions_Product_CRUD;
import modules.users.user;
import modules.users.functions.functions_User_CRUD;

public class dummies {
	static ArrayList<user> usuarios = new ArrayList<user>();
	static ArrayList<product> productos = new ArrayList<product>();

	public static void create_Products() {
		boolean[] interruptor = home.dummies_interruptor();
		if (interruptor[0] == true) {
			JOptionPane.showMessageDialog(null, "Ya se han creado 30 productos.", "Operación interrumpida",
					JOptionPane.WARNING_MESSAGE);
		} else {
			int random = 0;
			product item;
			product machinery;
			product clothes;

			ArrayList<Integer> registrados_item = new ArrayList<Integer>();
			String[] item_random = new String[30];
			String[] item_precios = new String[30];
			boolean interruptor_item = false;

			String[] productos_item = { "Papel laminado", "Papel rugoso", "Papel dorado", "Papel rossado",
					"Papel a puntos", "Papel maxi", "Papel mini", "Jabón fresa", "Jabón platano", "Jabón frutos",
					"Jabón menta", "Jabón standard", "Jabón melón", "Jabón arandano", "Jabón manzana", "Escoba larga",
					"Escoba mediana", "Escoba corta", "Escoba roja", "Escoba negra", "Escoba azul", "Recogedor corto",
					"Recogedor largo", "Recogedor mediano", "Mocho largo", "Mocho corto", "Mocho mediano", "Mocho azul",
					"Mocho verde", "Mocho naranja" };

			String[] precios_item = { "3.99", "4.99", "1.99", "2.99", "5.99", "6.99", "7.99", "8.99", "9.99", "0.99",
					"1", "2", "3", "4", "5", "6", "7", "8", "9", "0.25", "1.50", "2.50", "3.50", "4.50", "5.50", "6.50",
					"7.50", "8.50", "9.50", "0.50" };

			ArrayList<Integer> registrados_machinery = new ArrayList<Integer>();
			String[] machinery_random = new String[30];
			String[] machinery_precios = new String[30];
			boolean interruptor_machinery = false;

			String[] productos_machinery = { "Vitrinas de tapas", "Vitrinas de sushi", "Vitrinas neutras",
					"Vitrinas de ingredientes", "Vitrinas expositorias", "Vitrinas pasteleras", "Vitrinas de helados",
					"Vitrinas para pescado", "Batidora de vaso", "Batidora de bebida", "Cortadoras de fiambre",
					"Cortadoras de verduras", "Maquinas para pasta", "Picadoras de carne", "Procesamiento de carne",
					"Termos de leche", "Chocolateras", "Máquina de helado", "Máquina de zumo", "Máquina de cafe",
					"Accesorios de cafe", "Envasadoras al vacío", "Hornos de pizza", "Hornos de comida",
					"Hornos pequeños", "Hornos grandes", "Vitrinas de bocadillos", "Hornos medianos", "Lavaplatos",
					"Lava platos industrial" };

			String[] precios_machinery = { "213.99", "214.99", "211.99", "212.99", "215.99", "216.99", "217.99",
					"218.99", "219.99", "210.99", "121", "122", "23", "24", "125", "26", "127", "28", "129", "20",
					"31.50", "132.50", "33.50", "134.50", "35.50", "136.50", "137.50", "38.50", "139.50", "30.50" };

			ArrayList<Integer> registrados_clothes = new ArrayList<Integer>();
			String[] clothes_random = new String[30];
			String[] clothes_precios = new String[30];
			boolean interruptor_clothes = false;

			String[] productos_clothes = { "Pantalon negro", "Pantalon blanco", "Pantalon azul", "Pantalon verde",
					"Camisa blanca", "Camisa negra", "Camisa azul", "Camisa verde", "Americana negra",
					"Americana blanca", "Americana azul", "Americana verde", "Chaqueta blanca", "Chaqueta negra",
					"Chaqueta azul", "Chaqueta verde", "Sombrero cocina blanco", "Sombrero cocina negro",
					"Sombrero cocina azul", "Sombrero cocina verde", "Escoba azul", "Recogedor corto",
					"Recogedor largo", "Recogedor mediano", "Mocho largo", "Delantal blanco", "Delantal gris",
					"Delantal negro", "Delantal verde", "Delantal azul" };

			String[] precios_clothes = { "13.99", "14.99", "11.99", "12.99", "15.99", "16.99", "17.99", "18.99",
					"19.99", "10.99", "21", "22", "23", "24", "25", "26", "27", "28", "29", "20", "31.50", "32.50",
					"33.50", "34.50", "35.50", "36.50", "37.50", "38.50", "39.50", "30.50" };

			int[] stock_item = new int[30];
			int[] stock_machinery = new int[30];
			int[] stock_clothes = new int[30];

			int[] garantia_item = new int[30];
			int[] garantia_machinery = new int[30];
			int[] garantia_clothes = new int[30];

			// Item
			for (int i = 0; i < productos_item.length; i++) {
				if (registrados_item.size() == 0)
					interruptor_item = true;
				else
					interruptor_item = false;

				do {
					random = (int) (Math.random() * 30);
					for (int j = 0; j < registrados_item.size(); j++) {
						if (registrados_item.get(j) == random) {
							interruptor_item = false;
							break;
						} else {
							interruptor_item = true;
						}
					}
				} while (interruptor_item == false);
				registrados_item.add(random);
				item_random[i] = productos_item[random];
				item_precios[i] = precios_item[random];
			}

			// Machinery
			for (int i = 0; i < productos_machinery.length; i++) {
				if (registrados_machinery.size() == 0)
					interruptor_machinery = true;
				else
					interruptor_machinery = false;

				do {
					random = (int) (Math.random() * 30);
					for (int j = 0; j < registrados_machinery.size(); j++) {
						if (registrados_machinery.get(j) == random) {
							interruptor_machinery = false;
							break;
						} else {
							interruptor_machinery = true;
						}
					}
				} while (interruptor_machinery == false);
				registrados_machinery.add(random);
				machinery_random[i] = productos_machinery[random];
				machinery_precios[i] = precios_machinery[random];
			}

			// Clothes
			for (int i = 0; i < productos_clothes.length; i++) {
				if (registrados_clothes.size() == 0)
					interruptor_clothes = true;
				else
					interruptor_clothes = false;

				do {
					random = (int) (Math.random() * 30);
					for (int j = 0; j < registrados_clothes.size(); j++) {
						if (registrados_clothes.get(j) == random) {
							interruptor_clothes = false;
							break;
						} else {
							interruptor_clothes = true;
						}
					}
				} while (interruptor_clothes == false);
				registrados_clothes.add(random);
				clothes_random[i] = productos_clothes[random];
				clothes_precios[i] = precios_clothes[random];
			}

			for (int i = 0; i < stock_item.length; i++) {
				stock_item[i] = (int) (Math.random() * 25 + 1);
				garantia_item[i] = (int) (Math.random() * 3) + 4;
			}

			for (int i = 0; i < stock_machinery.length; i++) {
				stock_machinery[i] = (int) (Math.random() * 10 + 1);
				garantia_machinery[i] = (int) (Math.random() * 12) + 12;
			}

			for (int i = 0; i < stock_clothes.length; i++) {
				stock_clothes[i] = (int) (Math.random() * 900) + 100;
				garantia_clothes[i] = (int) (Math.random() * 2) + 2;
			}

			for (int i = 0; i < 30; i++) {
				item = new item(item_random[i], item_precios[i], Integer.toString(stock_item[i]), "", "",
						Integer.toString(garantia_item[i]), "", "", "");
				productos.add(item);

				machinery = new machinery(machinery_random[i], machinery_precios[i],
						Integer.toString(stock_machinery[i]), "", "", Integer.toString(garantia_machinery[i]), "", "");
				productos.add(machinery);

				clothes = new clothes(clothes_random[i], clothes_precios[i], Integer.toString(stock_clothes[i]), "", "",
						Integer.toString(garantia_clothes[i]), "", "", "");
				productos.add(clothes);
			}
			functions_Product_CRUD.productos_add(productos);
			interruptor[0] = true;
			home.dummies_interruptor_save(interruptor);
		}

	}

	public static void create_Users() {
		boolean[] interruptor = home.dummies_interruptor();
		if (interruptor[1] == true) {
			JOptionPane.showMessageDialog(null, "Ya se han creado 30 usuarios.", "Operación interrumpida",
					JOptionPane.WARNING_MESSAGE);
		} else {
			int random = 0;
			ArrayList<Integer> registrados_nombre = new ArrayList<Integer>();
			String[] nombres_random = new String[30];
			boolean interruptor_nombre = false;

			String[] nombres = { "Andrea", "David", "Baldomero", "Balduino", "Baldwin", "Baltasar", "Barry", "Bartolo",
					"Bartolome", "Baruc", "Baruj", "Candelaria", "Candida", "Canela", "Caridad", "Carina", "Carisa",
					"Caritina", "Carlota", "Baltazar", "Juan", "Lucas", "Eduardo", "Tono", "Andreu", "Victor", "Raul",
					"Carolina", "Marcos", "Vicente" };

			ArrayList<Integer> registrados_apellido = new ArrayList<Integer>();
			String[] apellidos_random = new String[30];
			boolean interruptor_apellido = false;

			String[] apellidos = { "Quesada", "Alcala", "Marin", "Molla", "Cobos", "Rios", "Martin", "Lopez", "Salas",
					"Mateo", "Abas", "Diego", "Gonzalez", "Rodriguez", "Gomez", "Fernandez", "Diaz", "Martinez",
					"Perez", "Garcia", "Sanchez", "Romero", "Torres", "Alvarez", "Ruiz", "Ramirez", "Suarez", "Gimenez",
					"Morales", "Ojeda" };

			ArrayList<Integer> registrados_dni = new ArrayList<Integer>();
			String[] dni_random = new String[30];
			boolean interruptor_dni = false;

			String[] dni = { "33287787W", "18320747M", "78271406Z", "22644609M", "04233029V", "31072314G", "60732901K",
					"03983050W", "98528112E", "43807242Q", "76266582P", "66837118S", "92266094F", "71802872T",
					"08960806Y", "58755539S", "31410950B", "02272984D", "83212042C", "22819134Y", "54921682M",
					"06842322Y", "09841394Q", "75144139B", "72093234X", "52007057D", "73900913G", "37306974P",
					"89282565S", "70491371M" };

			int[] edad = new int[30];
			// Nombres
			for (int i = 0; i < nombres.length; i++) {
				if (registrados_nombre.size() == 0)
					interruptor_nombre = true;
				else
					interruptor_nombre = false;

				do {
					random = (int) (Math.random() * 30);
					for (int j = 0; j < registrados_nombre.size(); j++) {
						if (registrados_nombre.get(j) == random) {
							interruptor_nombre = false;
							break;
						} else {
							interruptor_nombre = true;
						}
					}
				} while (interruptor_nombre == false);
				registrados_nombre.add(random);
				nombres_random[i] = nombres[random];
			}

			// Apellidos
			for (int i = 0; i < apellidos.length; i++) {
				if (registrados_apellido.size() == 0)
					interruptor_apellido = true;
				else
					interruptor_apellido = false;

				do {
					random = (int) (Math.random() * 30);
					for (int j = 0; j < registrados_apellido.size(); j++) {
						if (registrados_apellido.get(j) == random) {
							interruptor_apellido = false;
							break;
						} else {
							interruptor_apellido = true;
						}
					}
				} while (interruptor_apellido == false);
				registrados_apellido.add(random);
				apellidos_random[i] = apellidos[random];
			}

			// Dni
			for (int i = 0; i < dni.length; i++) {
				if (registrados_dni.size() == 0)
					interruptor_dni = true;
				else
					interruptor_dni = false;

				do {
					random = (int) (Math.random() * 30);
					for (int j = 0; j < registrados_dni.size(); j++) {
						if (registrados_dni.get(j) == random) {
							interruptor_dni = false;
							break;
						} else {
							interruptor_dni = true;
						}
					}
				} while (interruptor_dni == false);
				registrados_dni.add(random);
				dni_random[i] = dni[random];
			}

			// Edad
			for (int i = 0; i < edad.length; i++) {
				edad[i] = (int) (Math.random() * 30) + 20;
			}

			for (int i = 0; i < 5; i++) {
				user usuario;
				usuario = new user(nombres_random[i], apellidos_random[i], dni_random[i], "Particular",
						Integer.toString(edad[i]), "Administrador", "1234");
				usuarios.add(usuario);
			}

			for (int i = 6; i < 30; i++) {
				user usuario;
				usuario = new user(nombres_random[i], apellidos_random[i], dni_random[i], "Empresa",
						Integer.toString(edad[i]), "Cliente", "1234");
				usuarios.add(usuario);
			}
			System.out.println(usuarios.size());
			functions_User_CRUD.clientes_add(usuarios);
			interruptor[1] = true;
			home.dummies_interruptor_save(interruptor);
		}
	}
}
