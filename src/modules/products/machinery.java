package modules.products;

public class machinery extends product {
	private String peso;
	private String dimensiones;

	public machinery(String nombre, String precio, String stock, String imagen, String description, String garantia,
			String dimensiones, String peso) {
		super(nombre, precio, stock, imagen, description, garantia);
		// TODO Auto-generated constructor stub

		this.peso = peso;
		this.dimensiones = dimensiones;
	}

	public String getPeso() {
		return peso;
	}

	public void setPeso(String peso) {
		this.peso = peso;
	}

	public String getDimensiones() {
		return dimensiones;
	}

	public void setDimensiones(String dimensiones) {
		this.dimensiones = dimensiones;
	}

}
