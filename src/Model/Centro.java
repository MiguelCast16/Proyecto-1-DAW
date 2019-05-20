package Model;


public class Centro {

	private String Codigo_Centro; // Código del Centro
	private String DirectorNombre; // Nombre director/a del Centro
	private String DirectorApellidos; // Apellidos director/a del Centro
	private String NIF; // NIF director/a del Centro
	private String NombreCentro; // Nombre del Centro
	private String ciudad;
	private String provincia; // Provincia de ubicacion del Centro
	private String direccion; // Dirección de ubicacion del Centro
	private String CP; // Código Postal de ubicacion del Centro
	private String CIF; // CIF del Centro
	private int telefono; // Telefono del Centro
	private int fax; // fax del Centro
	private String DAT; // Dirección del Area Territorial al que pertenece el Centro
	
	public Centro(String codigo_Centro, String directorNombre, String directorApellidos, String nIF,
			String nombreCentro, String ciudad, String provincia, String direccion, String cP, String cIF, int telefono,
			int fax, String dAT) {
		super();
		Codigo_Centro = codigo_Centro;
		DirectorNombre = directorNombre;
		DirectorApellidos = directorApellidos;
		NIF = nIF;
		NombreCentro = nombreCentro;
		this.ciudad = ciudad;
		this.provincia = provincia;
		this.direccion = direccion;
		CP = cP;
		CIF = cIF;
		this.telefono = telefono;
		this.fax = fax;
		DAT = dAT;
	}

	public String getCodigo_Centro() {
		return Codigo_Centro;
	}

	public void setCodigo_Centro(String codigo_Centro) {
		Codigo_Centro = codigo_Centro;
	}

	public String getDirectorNombre() {
		return DirectorNombre;
	}

	public void setDirectorNombre(String directorNombre) {
		DirectorNombre = directorNombre;
	}

	public String getDirectorApellidos() {
		return DirectorApellidos;
	}

	public void setDirectorApellidos(String directorApellidos) {
		DirectorApellidos = directorApellidos;
	}

	public String getNIF() {
		return NIF;
	}

	public void setNIF(String nIF) {
		NIF = nIF;
	}

	public String getNombreCentro() {
		return NombreCentro;
	}

	public void setNombreCentro(String nombreCentro) {
		NombreCentro = nombreCentro;
	}

	public String getCiudad() {
		return ciudad;
	}

	public void setCiudad(String ciudad) {
		this.ciudad = ciudad;
	}

	public String getProvincia() {
		return provincia;
	}

	public void setProvincia(String provincia) {
		this.provincia = provincia;
	}

	public String getDireccion() {
		return direccion;
	}

	public void setDireccion(String direccion) {
		this.direccion = direccion;
	}

	public String getCP() {
		return CP;
	}

	public void setCP(String cP) {
		CP = cP;
	}

	public String getCIF() {
		return CIF;
	}

	public void setCIF(String cIF) {
		CIF = cIF;
	}

	public int getTelefono() {
		return telefono;
	}

	public void setTelefono(int telefono) {
		this.telefono = telefono;
	}

	public int getFax() {
		return fax;
	}

	public void setFax(int fax) {
		this.fax = fax;
	}

	public String getDAT() {
		return DAT;
	}

	public void setDAT(String dAT) {
		DAT = dAT;
	}
	
	
	
	





}
