package Model;

public class Ciclo {
	
	int Codigo;
	String Nombre;
	String Tipo;
	String Familia_Profesional;
	String Capacidades;
	String Actividades;
	String Criterios;
	String Clave_FP;
	
	
	
	public Ciclo(int codigo, String nombre, String tipo, String familia_Profesional, String capacidades,
			String actividades, String criterios, String clave_FP) {
		super();
		Codigo = codigo;
		Nombre = nombre;
		Tipo = tipo;
		Familia_Profesional = familia_Profesional;
		Capacidades = capacidades;
		Actividades = actividades;
		Criterios = criterios;
		Clave_FP = clave_FP;
	}
	
	
	public int getCodigo() {
		return Codigo;
	}
	public void setCodigo(int codigo) {
		Codigo = codigo;
	}
	public String getNombre() {
		return Nombre;
	}
	public void setNombre(String nombre) {
		Nombre = nombre;
	}
	public String getTipo() {
		return Tipo;
	}
	public void setTipo(String tipo) {
		Tipo = tipo;
	}
	public String getFamilia_Profesional() {
		return Familia_Profesional;
	}
	public void setFamilia_Profesional(String familia_Profesional) {
		Familia_Profesional = familia_Profesional;
	}
	public String getCapacidades() {
		return Capacidades;
	}
	public void setCapacidades(String capacidades) {
		Capacidades = capacidades;
	}
	public String getActividades() {
		return Actividades;
	}
	public void setActividades(String actividades) {
		Actividades = actividades;
	}
	public String getCriterios() {
		return Criterios;
	}
	public void setCriterios(String criterios) {
		Criterios = criterios;
	}
	public String getClave_FP() {
		return Clave_FP;
	}
	public void setClave_FP(String clave_FP) {
		Clave_FP = clave_FP;
	}
	
	
}
