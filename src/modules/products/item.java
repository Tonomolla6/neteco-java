package modules.products;

public class item extends product {
	private String familia;
	private String marca;
	private String cantidad;

	public item(String nombre, String precio, String stock, String imagen, String description, String garantia,
			String familia, String marca, String cantidad) {
		super(nombre, precio, stock, imagen, description, garantia);
		// TODO Auto-generated constructor stub

		this.familia = familia;
		this.marca = marca;
		this.cantidad = cantidad;
	}

	public String getFamilia() {
		return familia;
	}

	public void setFamilia(String familia) {
		this.familia = familia;
	}

	public String getMarca() {
		return marca;
	}

	public void setMarca(String marca) {
		this.marca = marca;
	}

	public String getCantidad() {
		return cantidad;
	}

	public void setCantidad(String cantidad) {
		this.cantidad = cantidad;
	}

	@Override
	public String toString() {
		return "item [getFamilia()=" + this.getFamilia() + ", getMarca()=" + this.getMarca() + ", getCantidad()="
				+ this.getCantidad() + ", getNombre()=" + this.getNombre() + ", getGarantia()=" + this.getGarantia()
				+ ", getPrecio()=" + this.getPrecio() + ", getStock()=" + this.getStock() + ", getDescription()="
				+ this.getDescription() + ", getImagen()=" + this.getImagen() + "]";
	}

}
