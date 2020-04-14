package modules.products;

public class clothes extends product {
	private String material;
	private String talla;
	private String color;

	public clothes(String nombre, String precio, String stock, String imagen, String description, String garantia,
			String color, String talla, String material) {
		super(nombre, precio, stock, imagen, description, garantia);
		// TODO Auto-generated constructor stub

		this.material = material;
		this.talla = talla;
		this.color = color;
	}

	public String getMaterial() {
		return material;
	}

	public void setMaterial(String material) {
		this.material = material;
	}

	public String getTalla() {
		return talla;
	}

	public void setTalla(String talla) {
		this.talla = talla;
	}

	public String getColor() {
		return color;
	}

	public void setColor(String color) {
		this.color = color;
	}

}
