package application;

public class Tutor {
	
	String NIF;
	String Nombre;
	String Apellidos;
	String Email;
	
	
	public Tutor(String nIF, String nombre, String apellidos, String email) {
		super();
		NIF = nIF;
		Nombre = nombre;
		Apellidos = apellidos;
		Email = email;
	}


	public String getNIF() {
		return NIF;
	}


	public void setNIF(String nIF) {
		NIF = nIF;
	}


	public String getNombre() {
		return Nombre;
	}


	public void setNombre(String nombre) {
		Nombre = nombre;
	}


	public String getApellidos() {
		return Apellidos;
	}


	public void setApellidos(String apellidos) {
		Apellidos = apellidos;
	}


	public String getEmail() {
		return Email;
	}


	public void setEmail(String email) {
		Email = email;
	}
	
	
	
}
	
	
	
	