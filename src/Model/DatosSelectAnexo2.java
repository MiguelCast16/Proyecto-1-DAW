package Model;

public class DatosSelectAnexo2 {
	String DAT;
	String Num_Convenio;
	String Fecha_Firma;
	String NombreCentro;
	String NombreEmpresa;
	String AñoCurso;
	String ClaveFp;
	String NombreCiclo;
	String FechaInicio;
	String FechaFin;
	String Hora_MañanaInicio;
	String Hora_MañanaFin;
	String Hora_TardeInicio;
	String Hora_TardeFin;
	int horasdia;
	int horastotal;
	String ciudadempresa;
	String direccionempresa;
	String ApellidosAlumno;
	String NombreAlumno;
	String NIF_Alumno;
	String NombreTutor;
	String ApellidosTutor;
	String NIF_Tutor;
	String Nombre_TutorEmpresa;
	String NIF_TutorEmpresa;
	
	public DatosSelectAnexo2(String dAT, String num_Convenio, String fecha_Firma, String nombreCentro,
			String nombreEmpresa, String añoCurso, String claveFp, String nombreCiclo, String fechaInicio,
			String fechaFin, String hora_MañanaInicio, String hora_MañanaFin, String hora_TardeInicio,
			String hora_TardeFin, int horasdia, int horastotal, String ciudadempresa, String direccionempresa,
			String apellidosAlumno, String nombreAlumno, String nIF_Alumno, String nombreTutor, String apellidosTutor,
			String nIF_Tutor, String nombre_TutorEmpresa, String nIF_TutorEmpresa) {
		super();
		DAT = dAT;
		Num_Convenio = num_Convenio;
		Fecha_Firma = fecha_Firma;
		NombreCentro = nombreCentro;
		NombreEmpresa = nombreEmpresa;
		AñoCurso = añoCurso;
		ClaveFp = claveFp;
		NombreCiclo = nombreCiclo;
		FechaInicio = fechaInicio;
		FechaFin = fechaFin;
		Hora_MañanaInicio = hora_MañanaInicio;
		Hora_MañanaFin = hora_MañanaFin;
		Hora_TardeInicio = hora_TardeInicio;
		Hora_TardeFin = hora_TardeFin;
		this.horasdia = horasdia;
		this.horastotal = horastotal;
		this.ciudadempresa = ciudadempresa;
		this.direccionempresa = direccionempresa;
		ApellidosAlumno = apellidosAlumno;
		NombreAlumno = nombreAlumno;
		NIF_Alumno = nIF_Alumno;
		NombreTutor = nombreTutor;
		ApellidosTutor = apellidosTutor;
		NIF_Tutor = nIF_Tutor;
		Nombre_TutorEmpresa = nombre_TutorEmpresa;
		NIF_TutorEmpresa = nIF_TutorEmpresa;
	}

	public String getDAT() {
		return DAT;
	}

	public void setDAT(String dAT) {
		DAT = dAT;
	}

	public String getNum_Convenio() {
		return Num_Convenio;
	}

	public void setNum_Convenio(String num_Convenio) {
		Num_Convenio = num_Convenio;
	}

	public String getFecha_Firma() {
		return Fecha_Firma;
	}

	public void setFecha_Firma(String fecha_Firma) {
		Fecha_Firma = fecha_Firma;
	}

	public String getNombreCentro() {
		return NombreCentro;
	}

	public void setNombreCentro(String nombreCentro) {
		NombreCentro = nombreCentro;
	}

	public String getNombreEmpresa() {
		return NombreEmpresa;
	}

	public void setNombreEmpresa(String nombreEmpresa) {
		NombreEmpresa = nombreEmpresa;
	}

	public String getAñoCurso() {
		return AñoCurso;
	}

	public void setAñoCurso(String añoCurso) {
		AñoCurso = añoCurso;
	}

	public String getClaveFp() {
		return ClaveFp;
	}

	public void setClaveFp(String claveFp) {
		ClaveFp = claveFp;
	}

	public String getNombreCiclo() {
		return NombreCiclo;
	}

	public void setNombreCiclo(String nombreCiclo) {
		NombreCiclo = nombreCiclo;
	}

	public String getFechaInicio() {
		return FechaInicio;
	}

	public void setFechaInicio(String fechaInicio) {
		FechaInicio = fechaInicio;
	}

	public String getFechaFin() {
		return FechaFin;
	}

	public void setFechaFin(String fechaFin) {
		FechaFin = fechaFin;
	}

	public String getHora_MañanaInicio() {
		return Hora_MañanaInicio;
	}

	public void setHora_MañanaInicio(String hora_MañanaInicio) {
		Hora_MañanaInicio = hora_MañanaInicio;
	}

	public String getHora_MañanaFin() {
		return Hora_MañanaFin;
	}

	public void setHora_MañanaFin(String hora_MañanaFin) {
		Hora_MañanaFin = hora_MañanaFin;
	}

	public String getHora_TardeInicio() {
		return Hora_TardeInicio;
	}

	public void setHora_TardeInicio(String hora_TardeInicio) {
		Hora_TardeInicio = hora_TardeInicio;
	}

	public String getHora_TardeFin() {
		return Hora_TardeFin;
	}

	public void setHora_TardeFin(String hora_TardeFin) {
		Hora_TardeFin = hora_TardeFin;
	}

	public int getHorasdia() {
		return horasdia;
	}

	public void setHorasdia(int horasdia) {
		this.horasdia = horasdia;
	}

	public int getHorastotal() {
		return horastotal;
	}

	public void setHorastotal(int horastotal) {
		this.horastotal = horastotal;
	}

	public String getCiudadempresa() {
		return ciudadempresa;
	}

	public void setCiudadempresa(String ciudadempresa) {
		this.ciudadempresa = ciudadempresa;
	}

	public String getDireccionempresa() {
		return direccionempresa;
	}

	public void setDireccionempresa(String direccionempresa) {
		this.direccionempresa = direccionempresa;
	}

	public String getApellidosAlumno() {
		return ApellidosAlumno;
	}

	public void setApellidosAlumno(String apellidosAlumno) {
		ApellidosAlumno = apellidosAlumno;
	}

	public String getNombreAlumno() {
		return NombreAlumno;
	}

	public void setNombreAlumno(String nombreAlumno) {
		NombreAlumno = nombreAlumno;
	}

	public String getNIF_Alumno() {
		return NIF_Alumno;
	}

	public void setNIF_Alumno(String nIF_Alumno) {
		NIF_Alumno = nIF_Alumno;
	}

	public String getNombreTutor() {
		return NombreTutor;
	}

	public void setNombreTutor(String nombreTutor) {
		NombreTutor = nombreTutor;
	}

	public String getApellidosTutor() {
		return ApellidosTutor;
	}

	public void setApellidosTutor(String apellidosTutor) {
		ApellidosTutor = apellidosTutor;
	}

	public String getNIF_Tutor() {
		return NIF_Tutor;
	}

	public void setNIF_Tutor(String nIF_Tutor) {
		NIF_Tutor = nIF_Tutor;
	}

	public String getNombre_TutorEmpresa() {
		return Nombre_TutorEmpresa;
	}

	public void setNombre_TutorEmpresa(String nombre_TutorEmpresa) {
		Nombre_TutorEmpresa = nombre_TutorEmpresa;
	}

	public String getNIF_TutorEmpresa() {
		return NIF_TutorEmpresa;
	}

	public void setNIF_TutorEmpresa(String nIF_TutorEmpresa) {
		NIF_TutorEmpresa = nIF_TutorEmpresa;
	}
	
	
	
	
	
}
