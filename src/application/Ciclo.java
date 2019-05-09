package application;

public class Ciclo {
	
	String nombre;
	int codigo;
	String capacidades;
	String familia_profesional;
	String tipo;
	String clave_fp;
	String actividades;
	String criterios;
	
	public Ciclo(String nombre, int codigo, String capacidades, String familia_profesional, String tipo,String clave_fp, String actividades, String criterios) {
		super();
		this.nombre = nombre;
		this.codigo = codigo;
		this.capacidades = capacidades;
		this.familia_profesional = familia_profesional;
		this.tipo = tipo;
		this.clave_fp = clave_fp;
		this.actividades = actividades;
		this.criterios = criterios;
	}

	public String getNombre() {
		return nombre;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

	public int getCodigo() {
		return codigo;
	}

	public void setCodigo(int codigo) {
		this.codigo = codigo;
	}

	public String getCapacidades() {
		return capacidades;
	}

	public void setCapacidades(String capacidades) {
		this.capacidades = capacidades;
	}

	public String getFamilia_profesional() {
		return familia_profesional;
	}

	public void setFamilia_profesional(String familia_profesional) {
		this.familia_profesional = familia_profesional;
	}

	public String getTipo() {
		return tipo;
	}

	public void setTipo(String tipo) {
		this.tipo = tipo;
	}

	public String getClave_fp() {
		return clave_fp;
	}

	public void setClave_fp(String clave_fp) {
		this.clave_fp = clave_fp;
	}

	public String getActividades() {
		return actividades;
	}

	public void setActividades(String actividades) {
		this.actividades = actividades;
	}

	public String getCriterios() {
		return criterios;
	}

	public void setCriterios(String criterios) {
		this.criterios = criterios;
	}
	
	

}
