package modules.products.functions;

import java.util.ArrayList;

import javax.swing.JOptionPane;
import javax.swing.JScrollPane;
import javax.swing.JTextArea;
import javax.swing.ScrollPaneConstants;

import modules.products.clothes;
import modules.products.item;
import modules.products.machinery;
import modules.products.product;

public class functions_Product_CRUD {
	static ArrayList<product> productos = new ArrayList<product>();

	// Crear un producto
	// --------------------------------------------------------------------------------------------------------------

	public static void create_Product(int opcion) {
		// random_products();
		product item;
		product machinery;
		product clothes;
		String[] modificacion = new String[1];

		if (opcion == 0) {
			modificacion[0] = null;

			String[] retorno = formularios_product.item_form(modificacion);

			if (retorno == null)
				return;
			else
				item = new item(retorno[0], retorno[1], retorno[2], retorno[3], retorno[4], retorno[5], retorno[6],
						retorno[7], retorno[8]);
			productos.add(item);
			return;
		} else if (opcion == 1) {
			modificacion[0] = null;
			String[] retorno = formularios_product.machinery_form(modificacion);

			if (retorno == null)
				return;
			else
				machinery = new machinery(retorno[0], retorno[1], retorno[2], retorno[3], retorno[4], retorno[5],
						retorno[6], retorno[7]);
			productos.add(machinery);
			return;
		} else if (opcion == 2) {
			modificacion[0] = null;
			String[] retorno = formularios_product.clothes_form(modificacion);

			if (retorno == null)
				return;
			else
				clothes = new clothes(retorno[0], retorno[1], retorno[2], retorno[3], retorno[4], retorno[5],
						retorno[6], retorno[7], retorno[8]);
			productos.add(clothes);
			return;
		}
	}

	// Modificar un producto
	// --------------------------------------------------------------------------------------------------------------

	public static void edit_Product(int opcion) {
		Object opcion_edit = "";
		String producto_nombre = CRUD_tool_product.name_product(opcion);
		int producto_size = CRUD_tool_product.size_product(opcion, productos);
		product producto;

		if (opcion == 0) {
			if (producto_size == 0) {
				JOptionPane.showMessageDialog(null, "No se encuentra ningun producto " + producto_nombre + ".",
						"Operación interrumpida", JOptionPane.WARNING_MESSAGE);
			} else {
				opcion_edit = CRUD_tool_product.buscar_producto(opcion, productos, "Modificar productos",
						"Busque el producto para modificar", "Modificar");

				if (opcion_edit == null)
					return;
				else {

					String[] modificacion = { productos.get((int) opcion_edit).getNombre(),
							productos.get((int) opcion_edit).getPrecio(), productos.get((int) opcion_edit).getStock(),
							productos.get((int) opcion_edit).getImagen(),
							productos.get((int) opcion_edit).getDescription(),
							productos.get((int) opcion_edit).getGarantia(),
							productos.get((int) opcion_edit).getFamilia(), productos.get((int) opcion_edit).getMarca(),
							productos.get((int) opcion_edit).getCantidad() };

					String[] retorno = formularios_product.item_form(modificacion);

					if (retorno == null) {
						return;
					}

					producto = new item(retorno[0], retorno[1], retorno[2], retorno[3], retorno[4], retorno[5],
							retorno[6], retorno[7], retorno[8]);

					productos.set((int) opcion_edit, producto);
				}
			}
		} else if (opcion == 1) {
			if (producto_size == 0) {
				JOptionPane.showMessageDialog(null, "No se encuentra ningun producto " + producto_nombre + ".",
						"Operación interrumpida", JOptionPane.WARNING_MESSAGE);
			} else {
				opcion_edit = CRUD_tool_product.buscar_producto(opcion, productos, "Modificar productos",
						"Busque el producto para modificar", "Modificar");

				if (opcion_edit == null)
					return;
				else {

					String[] modificacion = { productos.get((int) opcion_edit).getNombre(),
							productos.get((int) opcion_edit).getPrecio(), productos.get((int) opcion_edit).getStock(),
							productos.get((int) opcion_edit).getImagen(),
							productos.get((int) opcion_edit).getDescription(),
							productos.get((int) opcion_edit).getGarantia(),
							productos.get((int) opcion_edit).getDimensiones(),
							productos.get((int) opcion_edit).getPeso(), };

					String[] retorno = formularios_product.machinery_form(modificacion);

					if (retorno == null) {
						return;
					}

					producto = new machinery(retorno[0], retorno[1], retorno[2], retorno[3], retorno[4], retorno[5],
							retorno[6], retorno[7]);

					productos.set((int) opcion_edit, producto);
				}

				return;
			}
		} else if (opcion == 2) {
			if (producto_size == 0) {
				JOptionPane.showMessageDialog(null, "No se encuentra ningun producto " + producto_nombre + ".",
						"Operación interrumpida", JOptionPane.WARNING_MESSAGE);
			} else {
				opcion_edit = CRUD_tool_product.buscar_producto(opcion, productos, "Modificar productos",
						"Busque el producto para modificar", "Modificar");

				if (opcion_edit == null)
					return;
				else {
					String[] modificacion = { productos.get((int) opcion_edit).getNombre(),
							productos.get((int) opcion_edit).getPrecio(), productos.get((int) opcion_edit).getStock(),
							productos.get((int) opcion_edit).getImagen(),
							productos.get((int) opcion_edit).getDescription(),
							productos.get((int) opcion_edit).getGarantia(), productos.get((int) opcion_edit).getColor(),
							productos.get((int) opcion_edit).getTalla(),
							productos.get((int) opcion_edit).getMaterial(), };

					String[] retorno = formularios_product.clothes_form(modificacion);

					if (retorno == null) {
						return;
					}

					producto = new clothes(retorno[0], retorno[1], retorno[2], retorno[3], retorno[4], retorno[5],
							retorno[6], retorno[7], retorno[8]);

					productos.set((int) opcion_edit, producto);
				}
				return;
			}

		}

	}

	// Mostrar un producto
	// --------------------------------------------------------------------------------------------------------------

	public static void show_Product(int opcion) {
		Object opcion_edit = "";
		JTextArea description_i = new JTextArea(10, 0);
		JScrollPane description = new JScrollPane(description_i);
		Object[] mensaje = { "Los cambios no se guardarán" + "\n", description };
		String[] botones = { "Atras" };

		String producto_nombre = CRUD_tool_product.name_product(opcion);
		int producto_size = CRUD_tool_product.size_product(opcion, productos);

		description.setVerticalScrollBarPolicy(ScrollPaneConstants.VERTICAL_SCROLLBAR_ALWAYS);

		if (opcion == 0) {
			if (producto_size == 0) {
				JOptionPane.showMessageDialog(null, "No se encuentra ningun producto " + producto_nombre + ".",
						"Operación interrumpida", JOptionPane.WARNING_MESSAGE);
			} else {
				opcion_edit = CRUD_tool_product.buscar_producto_beta(opcion, productos, "Mostrar productos",
						"Busque el producto para mostrar", "Mostrar");

				if (opcion_edit == null)
					return;
				else {

					description_i.setText("Nombre: " + productos.get((int) opcion_edit).getNombre() + "\n" + "Precio: "
							+ productos.get((int) opcion_edit).getPrecio() + "\n" + "Stock: "
							+ productos.get((int) opcion_edit).getStock() + "\n" + "Imagen: "
							+ productos.get((int) opcion_edit).getImagen() + "\n" + "Descripcion: "
							+ productos.get((int) opcion_edit).getDescription() + "\n" + "Garantia: "
							+ productos.get((int) opcion_edit).getGarantia() + "\n" + "Familia: "
							+ productos.get((int) opcion_edit).getFamilia() + "\n" + "Marca: "
							+ productos.get((int) opcion_edit).getMarca() + "\n" + "Cantidad: "
							+ productos.get((int) opcion_edit).getCantidad());

					JOptionPane.showOptionDialog(null, mensaje, "Mostrar productos", JOptionPane.YES_NO_OPTION,
							JOptionPane.PLAIN_MESSAGE, null, botones, botones);
				}
			}
		} else if (opcion == 1) {
			if (producto_size == 0) {
				JOptionPane.showMessageDialog(null, "No se encuentra ningun producto " + producto_nombre + ".",
						"Operación interrumpida", JOptionPane.WARNING_MESSAGE);
			} else {
				opcion_edit = CRUD_tool_product.buscar_producto_beta(opcion, productos, "Mostrar productos",
						"Busque el producto para mostrar", "Mostrar");

				if (opcion_edit == null)
					return;
				else {

					description_i.setText("Nombre: " + productos.get((int) opcion_edit).getNombre() + "\n" + "Precio: "
							+ productos.get((int) opcion_edit).getPrecio() + "\n" + "Stock: "
							+ productos.get((int) opcion_edit).getStock() + "\n" + "Imagen: "
							+ productos.get((int) opcion_edit).getImagen() + "\n" + "Descripcion: "
							+ productos.get((int) opcion_edit).getDescription() + "\n" + "Garantia: "
							+ productos.get((int) opcion_edit).getGarantia() + "\n" + "Dimensiones: "
							+ productos.get((int) opcion_edit).getDimensiones() + "\n" + "Peso: "
							+ productos.get((int) opcion_edit).getPeso());

					JOptionPane.showOptionDialog(null, mensaje, "Mostrar productos", JOptionPane.YES_NO_OPTION,
							JOptionPane.PLAIN_MESSAGE, null, botones, botones);
				}
			}
		} else if (opcion == 2) {
			if (producto_size == 0) {
				JOptionPane.showMessageDialog(null, "No se encuentra ningun producto " + producto_nombre + ".",
						"Operación interrumpida", JOptionPane.WARNING_MESSAGE);
			} else {
				opcion_edit = CRUD_tool_product.buscar_producto_beta(opcion, productos, "Mostrar productos",
						"Busque el producto para mostrar", "Mostrar");

				if (opcion_edit == null)
					return;
				else {

					description_i.setText("Nombre: " + productos.get((int) opcion_edit).getNombre() + "\n" + "Precio: "
							+ productos.get((int) opcion_edit).getPrecio() + "\n" + "Stock: "
							+ productos.get((int) opcion_edit).getStock() + "\n" + "Imagen: "
							+ productos.get((int) opcion_edit).getImagen() + "\n" + "Descripcion: "
							+ productos.get((int) opcion_edit).getDescription() + "\n" + "Garantia: "
							+ productos.get((int) opcion_edit).getGarantia() + "\n" + "Color: "
							+ productos.get((int) opcion_edit).getColor() + "\n" + "Talla: "
							+ productos.get((int) opcion_edit).getTalla() + "\n" + "Material: "
							+ productos.get((int) opcion_edit).getMaterial());

					JOptionPane.showOptionDialog(null, mensaje, "Mostrar productos", JOptionPane.YES_NO_OPTION,
							JOptionPane.PLAIN_MESSAGE, null, botones, botones);
				}
			}
		}
	}
	// Borrar un producto
	// --------------------------------------------------------------------------------------------------------------

	public static void delete_Product(int opcion) {
		Object opcion_edit = "";
		String producto_nombre = CRUD_tool_product.name_product(opcion);
		int producto_size = CRUD_tool_product.size_product(opcion, productos);

		if (producto_size == 0) {
			JOptionPane.showMessageDialog(null, "No se encuentra ningun producto " + producto_nombre + ".",
					"Operación interrumpida", JOptionPane.WARNING_MESSAGE);
		} else {
			opcion_edit = CRUD_tool_product.buscar_producto(opcion, productos, "Borrar productos",
					"Busque el producto para borrar", "Borrar");

			if (opcion_edit == null)
				return;
			else {
				productos.remove((int) opcion_edit);

				JOptionPane.showMessageDialog(null, "Operación realizada correctamente");
				return;
			}
		}
	}

	public static void productos_add(ArrayList<product> productos_entrada) {
		for (int i = 0; i < productos_entrada.size(); i++) {
			productos.add(productos_entrada.get(i));
		}
	}

	public static ArrayList<product> products() {
		return productos;
	}
}
