package ProyectoPinturas;

public class Usuario {

	
	private String DNI;
	private String nombre;
	private String password;	
	private String email;
	
	
	
	
	public Usuario( String dNI, String password, String nombre, String email) {
		
		DNI = dNI;
		this.password = password;
		this.nombre = nombre;
		this.email = email;
	}
	public String getUsuario() {
		return DNI;
	}
	public void setUsuario(String usuario) {
		this.DNI = usuario;
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

	@Override
	public String toString() {
		return  ", usuario=" + DNI + ", password=" + password + ", nombre=" + nombre
				+ ", email=" + email + "]";
	}

	
	
}
