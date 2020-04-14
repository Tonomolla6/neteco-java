package modules.orders;

public class order {
	private String cliente;
	private String producto;
	private date fecha;
	private date fecha_garantia;

	public order(String cliente, String producto, date fecha, date fecha_garantia) {
		this.cliente = cliente;
		this.producto = producto;
		this.fecha = fecha;
		this.fecha_garantia = fecha_garantia;
	}

	public String getCliente() {
		return cliente;
	}

	public void setCliente(String cliente) {
		this.cliente = cliente;
	}

	public String getProducto() {
		return producto;
	}

	public void setProducto(String producto) {
		this.producto = producto;
	}

	public date getFecha() {
		return fecha;
	}

	public void setFecha(date fecha) {
		this.fecha = fecha;
	}

	public date getFecha_garantia() {
		return fecha_garantia;
	}

	public void setFecha_garantia(date fecha_garantia) {
		this.fecha_garantia = fecha_garantia;
	}

	@Override
	public String toString() {
		return "order [cliente=" + cliente + ", producto=" + producto + ", fecha=" + fecha + ", fecha_garantia="
				+ fecha_garantia + "]";
	}
}
