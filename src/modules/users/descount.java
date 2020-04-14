package modules.users;

public class descount {
	private int cliente;
	private int producto;
	private int descuento;

	public descount(int cliente, int producto, int descuento) {
		super();
		this.cliente = cliente;
		this.producto = producto;
		this.descuento = descuento;
	}

	public int getCliente() {
		return cliente;
	}

	public void setCliente(int cliente) {
		this.cliente = cliente;
	}

	public int getProducto() {
		return producto;
	}

	public void setProducto(int preducto) {
		this.producto = preducto;
	}

	public int getDescuento() {
		return descuento;
	}

	public void setDescuento(int descuento) {
		this.descuento = descuento;
	}

	@Override
	public String toString() {
		return "descount [cliente=" + cliente + ", producto=" + producto + ", descuento=" + descuento + "]";
	}

}
