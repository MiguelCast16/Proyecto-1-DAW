package application;

public class Cursan {
	
	String NIF;
	int Codigo;
	String A�o_Curso;
	
	public Cursan(String nIF, int codigo, String a�o_Curso) {
		super();
		NIF = nIF;
		Codigo = codigo;
		A�o_Curso = a�o_Curso;
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

	public String getA�o_Curso() {
		return A�o_Curso;
	}

	public void setA�o_Curso(String a�o_Curso) {
		A�o_Curso = a�o_Curso;
	}
	
	

	
}
