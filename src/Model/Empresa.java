package Model;

public class Empresa {

	String Num_Convenio;
	String CIF;
	String Representante;
	String NIF_Representante;
	String Apellidos_Representante;
	String Nombre;
	String Pais;
	String Ciudad;
	String Provincia;
	String Direccion;
	String CP;
	int Telefono;
	int Fax;
	String Ciudad_FirmaConvenio;
	String Fecha_FirmaConvenio;
	String Familia_Profesional;
	String Codigo_Centro;
	
	public Empresa(String num_Convenio, String cIF, String representante, String nIF_Representante,
			String apellidos_Representante, String nombre, String pais, String ciudad, String provincia,
			String direccion, String cP, int telefono, int fax, String ciudad_FirmaConvenio, String fecha_FirmaConvenio,
			String familia_Profesional, String codigo_Centro) {
		super();
		Num_Convenio = num_Convenio;
		CIF = cIF;
		Representante = representante;
		NIF_Representante = nIF_Representante;
		Apellidos_Representante = apellidos_Representante;
		Nombre = nombre;
		Pais = pais;
		Ciudad = ciudad;
		Provincia = provincia;
		Direccion = direccion;
		CP = cP;
		Telefono = telefono;
		Fax = fax;
		Ciudad_FirmaConvenio = ciudad_FirmaConvenio;
		Fecha_FirmaConvenio = fecha_FirmaConvenio;
		Familia_Profesional = familia_Profesional;
		Codigo_Centro = codigo_Centro;
	}

	public String getNum_Convenio() {
		return Num_Convenio;
	}

	public void setNum_Convenio(String num_Convenio) {
		Num_Convenio = num_Convenio;
	}

	public String getCIF() {
		return CIF;
	}

	public void setCIF(String cIF) {
		CIF = cIF;
	}

	public String getRepresentante() {
		return Representante;
	}

	public void setRepresentante(String representante) {
		Representante = representante;
	}

	public String getNIF_Representante() {
		return NIF_Representante;
	}

	public void setNIF_Representante(String nIF_Representante) {
		NIF_Representante = nIF_Representante;
	}

	public String getApellidos_Representante() {
		return Apellidos_Representante;
	}

	public void setApellidos_Representante(String apellidos_Representante) {
		Apellidos_Representante = apellidos_Representante;
	}

	public String getNombre() {
		return Nombre;
	}

	public void setNombre(String nombre) {
		Nombre = nombre;
	}

	public String getPais() {
		return Pais;
	}

	public void setPais(String pais) {
		Pais = pais;
	}

	public String getCiudad() {
		return Ciudad;
	}

	public void setCiudad(String ciudad) {
		Ciudad = ciudad;
	}

	public String getProvincia() {
		return Provincia;
	}

	public void setProvincia(String provincia) {
		Provincia = provincia;
	}

	public String getDireccion() {
		return Direccion;
	}

	public void setDireccion(String direccion) {
		Direccion = direccion;
	}

	public String getCP() {
		return CP;
	}

	public void setCP(String cP) {
		CP = cP;
	}

	public int getTelefono() {
		return Telefono;
	}

	public void setTelefono(int telefono) {
		Telefono = telefono;
	}

	public int getFax() {
		return Fax;
	}

	public void setFax(int fax) {
		Fax = fax;
	}

	public String getCiudad_FirmaConvenio() {
		return Ciudad_FirmaConvenio;
	}

	public void setCiudad_FirmaConvenio(String ciudad_FirmaConvenio) {
		Ciudad_FirmaConvenio = ciudad_FirmaConvenio;
	}

	public String getFecha_FirmaConvenio() {
		return Fecha_FirmaConvenio;
	}

	public void setFecha_FirmaConvenio(String fecha_FirmaConvenio) {
		Fecha_FirmaConvenio = fecha_FirmaConvenio;
	}

	public String getFamilia_Profesional() {
		return Familia_Profesional;
	}

	public void setFamilia_Profesional(String familia_Profesional) {
		Familia_Profesional = familia_Profesional;
	}

	public String getCodigo_Centro() {
		return Codigo_Centro;
	}

	public void setCodigo_Centro(String codigo_Centro) {
		Codigo_Centro = codigo_Centro;
	}
	
	
}
	
		