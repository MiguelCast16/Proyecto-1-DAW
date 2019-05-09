package application;

public class Tutor {
	
	String nombre;
	String apellidos;
	String email;
	String nif;
	
	
	
	public Tutor(String nombre, String apellidos, String email, String nif) {
		super();
		this.nombre = nombre;
		this.apellidos = apellidos;
		this.email = email;
		this.nif = nif;
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
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	public String getNif() {
		return nif;
	}
	public void setNif(String nif) {
		this.nif = nif;
	}
	
	

}
