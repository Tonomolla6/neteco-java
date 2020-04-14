package modules.products;

public abstract class product {
	private String nombre;
	private String precio;
	private String stock;
	private String imagen;
	private String description;
	private String garantia;

	public product(String nombre, String precio, String stock, String imagen, String description, String garantia) {
		this.nombre = nombre;
		this.precio = precio;
		this.stock = stock;
		this.imagen = imagen;
		this.description = description;
		this.garantia = garantia;
	}

	public String getNombre() {
		return nombre;
	}

	public String getGarantia() {
		return garantia;
	}

	public void setGarantia(String garantia) {
		this.garantia = garantia;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

	public String getPrecio() {
		return precio;
	}

	public void setPrecio(String precio) {
		this.precio = precio;
	}

	public String getStock() {
		return stock;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public void setStock(String stock) {
		this.stock = stock;
	}

	public String getImagen() {
		return imagen;
	}

	public void setImagen(String imagen) {
		this.imagen = imagen;
	}

	public String getFamilia() {
		// TODO Auto-generated method stub
		return null;
	}

	public String getMarca() {
		// TODO Auto-generated method stub
		return null;
	}

	public String getCantidad() {
		// TODO Auto-generated method stub
		return null;
	}

	public String getDimensiones() {
		return null;
	}

	public String getPeso() {
		return null;
	}

	public String getColor() {
		// TODO Auto-generated method stub
		return null;
	}

	public String getTalla() {
		// TODO Auto-generated method stub
		return null;
	}

	public String getMaterial() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public String toString() {
		return "product [nombre=" + nombre + ", precio=" + precio + ", stock=" + stock + ", imagen=" + imagen
				+ ", description=" + description + ", garantia=" + garantia + "]";
	}

}
