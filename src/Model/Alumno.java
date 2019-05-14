package Model;

public class Alumno {
	
	String NIF;
	String Nombre;
	String Apellidos;
	String Email;
	int Telefono;
	
	
	
	
	public Alumno(String Nif, String nombre, String apellidos,  int telefono, String email) {
		super();
		Nombre = nombre;
		Apellidos = apellidos;
		Email = email;
		NIF = Nif;
		Telefono = telefono;
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


	public String getNIF() {
		return NIF;
	}


	public void setNIF(String nIF) {
		NIF = nIF;
	}


	public int getTelefono() {
		return Telefono;
	}


	public void setTelefono(int telefono) {
		Telefono = telefono;
	}
	
	
	
	

	
	
	
	

}
