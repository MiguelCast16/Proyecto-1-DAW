package Model;

import java.sql.Date;

public class AsignanPracticas {
	
	String NIF_Alumno;
	String Num_Convenio;
	String NIF_Tutor;
	String NIF_TutorEmpresa;
	Date Fecha_Inicio;
	Date Fecha_Fin;
	int Horas_Dia;
	int Horas_Total;
	String  Horas_TardeInicio;
	String Horas_TardeFin;
	String Horas_MañanaInicio;
	String Horas_MañanaFin;
	
	public AsignanPracticas(String nIF_Alumno, String num_Convenio, String nIF_Tutor, String nIF_TutorEmpresa,
			Date fecha_Inicio, Date fecha_Fin, int horas_Dia, int horas_Total, String horas_TardeInicio,
			String horas_TardeFin, String horas_MañanaInicio, String horas_MañanaFin) {
		super();
		NIF_Alumno = nIF_Alumno;
		Num_Convenio = num_Convenio;
		NIF_Tutor = nIF_Tutor;
		NIF_TutorEmpresa = nIF_TutorEmpresa;
		Fecha_Inicio = fecha_Inicio;
		Fecha_Fin = fecha_Fin;
		Horas_Dia = horas_Dia;
		Horas_Total = horas_Total;
		Horas_TardeInicio = horas_TardeInicio;
		Horas_TardeFin = horas_TardeFin;
		Horas_MañanaInicio = horas_MañanaInicio;
		Horas_MañanaFin = horas_MañanaFin;
	}

	public String getNIF_Alumno() {
		return NIF_Alumno;
	}

	public void setNIF_Alumno(String nIF_Alumno) {
		NIF_Alumno = nIF_Alumno;
	}

	public String getNum_Convenio() {
		return Num_Convenio;
	}

	public void setNum_Convenio(String num_Convenio) {
		Num_Convenio = num_Convenio;
	}

	public String getNIF_Tutor() {
		return NIF_Tutor;
	}

	public void setNIF_Tutor(String nIF_Tutor) {
		NIF_Tutor = nIF_Tutor;
	}

	public String getNIF_TutorEmpresa() {
		return NIF_TutorEmpresa;
	}

	public void setNIF_TutorEmpresa(String nIF_TutorEmpresa) {
		NIF_TutorEmpresa = nIF_TutorEmpresa;
	}

	public Date getFecha_Inicio() {
		return Fecha_Inicio;
	}

	public void setFecha_Inicio(Date fecha_Inicio) {
		Fecha_Inicio = fecha_Inicio;
	}

	public Date getFecha_Fin() {
		return Fecha_Fin;
	}

	public void setFecha_Fin(Date fecha_Fin) {
		Fecha_Fin = fecha_Fin;
	}

	public int getHoras_Dia() {
		return Horas_Dia;
	}

	public void setHoras_Dia(int horas_Dia) {
		Horas_Dia = horas_Dia;
	}

	public int getHoras_Total() {
		return Horas_Total;
	}

	public void setHoras_Total(int horas_Total) {
		Horas_Total = horas_Total;
	}

	public String getHoras_TardeInicio() {
		return Horas_TardeInicio;
	}

	public void setHoras_TardeInicio(String horas_TardeInicio) {
		Horas_TardeInicio = horas_TardeInicio;
	}

	public String getHoras_TardeFin() {
		return Horas_TardeFin;
	}

	public void setHoras_TardeFin(String horas_TardeFin) {
		Horas_TardeFin = horas_TardeFin;
	}

	public String getHoras_MañanaInicio() {
		return Horas_MañanaInicio;
	}

	public void setHoras_MañanaInicio(String horas_MañanaInicio) {
		Horas_MañanaInicio = horas_MañanaInicio;
	}

	public String getHoras_MañanaFin() {
		return Horas_MañanaFin;
	}

	public void setHoras_MañanaFin(String horas_MañanaFin) {
		Horas_MañanaFin = horas_MañanaFin;
	}
	
	
	

}
