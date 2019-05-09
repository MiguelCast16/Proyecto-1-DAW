package application;

public class Cursan {
	
	String NIF;
	int Codigo;
	String Año_Curso;
	
	public Cursan(String nIF, int codigo, String año_Curso) {
		super();
		NIF = nIF;
		Codigo = codigo;
		Año_Curso = año_Curso;
	}

	public String getNIF() {
		return NIF;
	}

	public void setNIF(String nIF) {
		NIF = nIF;
	}

	public int getCodigo() {
		return Codigo;
	}

	public void setCodigo(int codigo) {
		Codigo = codigo;
	}

	public String getAño_Curso() {
		return Año_Curso;
	}

	public void setAño_Curso(String año_Curso) {
		Año_Curso = año_Curso;
	}
	
	

	
}
