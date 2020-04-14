package modules.users;

public class user {
	private String nombre;
	private String apellidos;
	private String dni;
	private String lugar_de_trabajo;
	private String edad;
	private String tipo_de_usuario;
	private String passwd;

	public user(String nombre, String apellidos, String dni, String lugar_de_trabajo, String edad,
			String tipo_de_usuario, String passwd) {
		super();
		this.nombre = nombre;
		this.apellidos = apellidos;
		this.dni = dni;
		this.lugar_de_trabajo = lugar_de_trabajo;
		this.edad = edad;
		this.tipo_de_usuario = tipo_de_usuario;
		this.passwd = passwd;
	}

	public String getNombre() {
		return nombre;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

	public String getApellidos() {
		return apellidos;
	}

	public void setApellidos(String apellidos) {
		this.apellidos = apellidos;
	}

	public String getDni() {
		return dni;
	}

	public void setDni(String dni) {
		this.dni = dni;
	}

	public String getLugar_de_trabajo() {
		return lugar_de_trabajo;
	}

	public void setLugar_de_trabajo(String lugar_de_trabajo) {
		this.lugar_de_trabajo = lugar_de_trabajo;
	}

	public String getEdad() {
		return edad;
	}

	public void setEdad(String edad) {
		this.edad = edad;
	}

	public String getTipo_de_usuario() {
		return tipo_de_usuario;
	}

	public void setTipo_de_usuario(String tipo_de_usuario) {
		this.tipo_de_usuario = tipo_de_usuario;
	}

	public String getPasswd() {
		return passwd;
	}

	public void setPasswd(String passwd) {
		this.passwd = passwd;
	}

	@Override
	public String toString() {
		return "user [nombre=" + nombre + ", apellidos=" + apellidos + ", dni=" + dni + ", lugar_de_trabajo="
				+ lugar_de_trabajo + ", edad=" + edad + ", tipo_de_usuario=" + tipo_de_usuario + ", passwd=" + passwd
				+ "]";
	}

}
