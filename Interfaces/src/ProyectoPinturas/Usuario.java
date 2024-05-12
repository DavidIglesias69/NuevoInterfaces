package ProyectoPinturas;

public class Usuario {


	private String DNI;
	private String nombre;
	private String password;	
	private String email;
	private boolean responsable; //  atributo para indicar si el usuario es responsable

	public Usuario(String DNI, String password, String nombre, String email) {
		this.DNI = DNI;
		this.password = password;
		this.nombre = nombre;
		this.email = email;
		
	}

	
	public boolean isResponsable() {
		return responsable;
	}

	public void setResponsable(boolean responsable) {
		this.responsable = responsable;
	}
	public String getDNI() {
		return DNI;
	}
	public void setDNI(String usuario) {
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
