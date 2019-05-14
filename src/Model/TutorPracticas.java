package Model;

public class TutorPracticas {
	
	String NIF;
	String Nombre;
	String Apellidos;
	int Telefono;
	String Email;
	String Num_Convenio;
	
	
	public TutorPracticas(String nIF, String nombre, String apellidos, int telefono, String email,
			String num_Convenio) {
		super();
		NIF = nIF;
		Nombre = nombre;
		Apellidos = apellidos;
		Telefono = telefono;
		Email = email;
		Num_Convenio = num_Convenio;
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


	public int getTelefono() {
		return Telefono;
	}


	public void setTelefono(int telefono) {
		Telefono = telefono;
	}


	public String getEmail() {
		return Email;
	}


	public void setEmail(String email) {
		Email = email;
	}


	public String getNum_Convenio() {
		return Num_Convenio;
	}


	public void setNum_Convenio(String num_Convenio) {
		Num_Convenio = num_Convenio;
	}
	
	
	
	

}
