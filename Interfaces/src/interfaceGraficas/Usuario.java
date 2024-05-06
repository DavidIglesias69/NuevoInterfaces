package interfaceGraficas;

public class Usuario {

	private int id;
	private String usuario;
	private String password;
	private String nombre;
	private String email;
	
	
	public Usuario(int id, String usuario, String password, String nombre, String email) {
		
		this.id = id;
		this.usuario = usuario;
		this.password = password;
		this.nombre = nombre;
		this.email = email;
	}
	
	public String getUsuario() {
		return usuario;
	}
	public void setUsuario(String usuario) {
		this.usuario = usuario;
	}
	public String getPassword() {
		return password;
	}
	public void setPassword(String password) {
		this.password = password;
	}
	public String getNombre() {
		return nombre;
	}
	public void setNombre(String nombre) {
		this.nombre = nombre;
	}
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}

	@Override
	public String toString() {
		return "Usuario [id=" + id + ", usuario=" + usuario + ", password=" + password + ", nombre=" + nombre
				+ ", email=" + email + "]";
	}

	
	
}
