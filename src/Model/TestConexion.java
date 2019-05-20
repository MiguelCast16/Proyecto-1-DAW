package Model;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.sql.*;
import java.util.Properties;

import Model.Alumno;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;

public class TestConexion {

	
	private String url= "";
	private String user = "";
	private String pwd = "";
	private String usr = "";
	private static Connection conexion;
	
	
	public TestConexion()  {
		
		Properties propiedades = new Properties();
		InputStream entrada=null;

		try {
	
			File miFichero = new File("src/Model/Datos.ini");
			if (miFichero.exists()) {
				entrada = new FileInputStream(miFichero);
				propiedades.load(entrada);
				url = propiedades.getProperty("url");
				user = propiedades.getProperty("user");
				pwd = propiedades.getProperty("pwd");
				usr = propiedades.getProperty("usr");
				
				System.out.println( url + user + pwd);
				
			} else
				System.out.println("Fichero No Encontrado");
			
			} 
		catch (IOException ex) {
			ex.printStackTrace();
		}

			finally {
					if (entrada != null) {
						try {
								entrada.close();
							} 
						catch (IOException e) 
							{
								e.printStackTrace();
							}
				
				}
			}
		

			
		
		try {
			Class.forName("oracle.jdbc.driver.OracleDriver");
			conexion = DriverManager.getConnection(url, user, pwd);
			
			if(!conexion.isClosed()) {
				System.out.println("Conexión establecida");
				//conexion.close();
			}
			else
				System.out.println("Fallo en Conexión");	
			

		}catch (Exception e) {
			System.out.println("ERROR en conexión con ORACLE");	
			e.printStackTrace();
		}
		
	}
	
	
	
	public ObservableList<Alumno> Alumno() {
		
		ObservableList<Alumno> data=FXCollections.observableArrayList();
		
		try {
			Statement stmt = conexion.createStatement();
			ResultSet rset = stmt.executeQuery("SELECT * FROM " + usr + ".ALUMNOS" );
			while(rset.next()) {
				Alumno alm1 = new Alumno(rset.getString(1), rset.getString(2),rset.getString(3),rset.getInt(4),rset.getString(5));
				data.add(alm1);
				
	
			}
			rset.close();
			stmt.close();
			
		}catch (SQLException s){
			s.printStackTrace();
		}
		
		return data;
		
	}
	
	
	public void AnadirAlumno(String NIF,String Nombre,String Apellidos,int numero,String email) {
		try {
			Statement stmt = conexion.createStatement();
			stmt.executeQuery("INSERT INTO " + usr + ".ALUMNOS VALUES ('"+NIF+"','"+Nombre+"','"+Apellidos+"',"+numero+",'"+email+"')");
		}catch(SQLException s) {
			s.printStackTrace();
		}
	}
	
	
	
	public void ModificarAlumno(String NIF,String Nombre,String Apellidos,int numero,String email, String NIFViejo) {
		try {
			Statement stmt = conexion.createStatement();
			stmt.executeQuery("UPDATE " + usr + ".ALUMNOS SET NIF='"+NIF+"', Nombre='"+Nombre+"', Apellidos='"+Apellidos+"', Telefono='"+numero+"', Email='"+email+"' WHERE NIF='"+NIFViejo+"'");
		}catch(SQLException s) {
			s.printStackTrace();
		}
	}
	
	
	public ObservableList<Tutor> Tutor() {
		
		ObservableList<Tutor> data=FXCollections.observableArrayList();
		
		try {
			Statement stmt = conexion.createStatement();
			ResultSet rset = stmt.executeQuery("SELECT * FROM "+ usr +".Tutor" );
			while(rset.next()) {
				Tutor tutor1 = new Tutor(rset.getString(1), rset.getString(2),rset.getString(3),rset.getString(4));
				data.add(tutor1);
				
	
			}
			rset.close();
			stmt.close();
			
		}catch (SQLException s){
			s.printStackTrace();
		}
		
		return data;
		
	}

	public void AnadirTutor(String NIF,String Nombre,String Apellidos,String email) {
	try {
		Statement stmt = conexion.createStatement();
		stmt.executeQuery("INSERT INTO "+ usr +".TUTOR VALUES ('"+NIF+"','"+Nombre+"','"+Apellidos+"','"+email+"')");
	}catch(SQLException s) {
		s.printStackTrace();
		}
	}

	public void ModificarTutor(String NIF,String Nombre,String Apellidos, String email, String NIFViejo) {
		try {
			Statement stmt = conexion.createStatement();
			stmt.executeQuery("UPDATE "+ usr +".TUTOR SET NIF='"+NIF+"', Nombre='"+Nombre+"', Apellidos='"+Apellidos+"', Email='"+email+"' WHERE NIF='"+NIFViejo+"' ");
		}catch(SQLException s) {
			s.printStackTrace();
		}
	}
	
	
	public ObservableList<Ciclo> Ciclo() {
			
			ObservableList<Ciclo> data=FXCollections.observableArrayList();
			
			try {
				Statement stmt = conexion.createStatement();
				ResultSet rset = stmt.executeQuery("SELECT * FROM "+ usr +".CICLOS" );
				while(rset.next()) {
					Ciclo ciclo1 = new Ciclo(rset.getInt(1), rset.getString(2),rset.getString(3),rset.getString(4),rset.getString(5),rset.getString(6),rset.getString(7),rset.getString(8));
					data.add(ciclo1);
					
		
				}
				rset.close();
				stmt.close();
				
			}catch (SQLException s){
				s.printStackTrace();
			}
			
			return data;
			
		}

	public void AnadirCiclo(int Codigo, String Nombre, String Tipo, String Familia_Profesional, String Capacidades,String Actividades, String Criterios, String Clave_FP) {
	try {
		Statement stmt = conexion.createStatement();
		stmt.executeQuery("INSERT INTO "+ usr +".CICLOS VALUES ("+Codigo+",'"+Nombre+"','"+Tipo+"','"+Familia_Profesional+"','"+Capacidades+"','"+Actividades+"','"+Criterios+"','"+Clave_FP+"')");
	}catch(SQLException s) {
		s.printStackTrace();
		}
	}

	public void ModificarCiclo(int Codigo, String Nombre, String Tipo, String Familia_Profesional, String Capacidades,String Actividades, String Criterios, String Clave_FP, int CodigoViejo) {
		try {
			Statement stmt = conexion.createStatement();
			stmt.executeQuery("UPDATE "+ usr +".CICLOS SET Codigo="+Codigo+", Nombre='"+Nombre+"', Tipo='"+Tipo+"', Familia_Profesional='"+Familia_Profesional+"', Capacidades='"+Capacidades+"', Actividades='"+Actividades+"', Criterios_Evaluacion='"+Criterios+"', Clave_FP='"+Clave_FP+"' WHERE Codigo='"+CodigoViejo+"'");
		}catch(SQLException s) {
			s.printStackTrace();
		}
	}
	
	
	
	
	
	public ObservableList<Empresa> Empresa() {
			
			ObservableList<Empresa> data=FXCollections.observableArrayList();
			
			try {
				Statement stmt = conexion.createStatement();
				ResultSet rset = stmt.executeQuery("SELECT * FROM "+ usr +".Empresas" );
				while(rset.next()) {
					Empresa emp1 = new Empresa(rset.getString(1), rset.getString(2),rset.getString(3),rset.getString(4),rset.getString(5),rset.getString(6),rset.getString(7),rset.getString(8),rset.getString(9),rset.getString(10),rset.getString(11),rset.getInt(12),rset.getInt(13),rset.getString(14),rset.getString(15),rset.getString(16),rset.getString(17));
					data.add(emp1);
					
		
				}
				rset.close();
				stmt.close();
				
			}catch (SQLException s){
				s.printStackTrace();
			}
			
			return data;
			
		}
		
	
	
	
	
	
	public void AnadirEmpresa(String num_Convenio, String Cif, String representante, String NIF_Representante,String Apellidos, String nombre, String pais, String ciudadN, String provincia, String direccion, String CP, int telefono, int fax, String ciudad_FirmaConvenio, String fecha_FirmaConvenio, String familia_Profesional, String codigo_Centro) {
		try {
			Statement stmt = conexion.createStatement();
			stmt.executeQuery("INSERT INTO "+ usr +".EMPRESAS VALUES ('"+num_Convenio+"','"+Cif+"','"+representante+"','"+NIF_Representante+"','"+Apellidos+"','"+nombre+"','"+pais+"','"+ciudadN+"','"+provincia+"','"+direccion+"','"+CP+"',"+telefono+","+fax+",'"+ciudad_FirmaConvenio+"','"+fecha_FirmaConvenio+"','"+familia_Profesional+"','"+codigo_Centro+"')");
		}catch(SQLException s) {
			s.printStackTrace();
		}
	}
	
	public void ModificarEmpresa(String num_Convenio, String Cif, String representante, String NIF_Representante, String Apellidos,String nombre, String pais, String ciudad, String provincia, String direccion, String CP, int telefono, int fax, String ciudad_FirmaConvenio, String fecha_FirmaConvenio, String familia_Profesional, String codigo_Centro, String Num_ConvenioV) {

		try {
			Statement stmt = conexion.createStatement();
			stmt.executeQuery("UPDATE "+ usr +".EMPRESAS SET Num_Convenio='"+num_Convenio+"', CIF='"+Cif+"', Representante='"+representante+"', NIF_Representante='"+NIF_Representante+"',Apellidos='"+Apellidos+"', Nombre='"+nombre+"', Pais='"+pais+"', Ciudad='"+ciudad+"', Provincia='"+provincia+"',Direccion='"+direccion+"', CP='"+CP+"', Telefono="+telefono+", FAX="+fax+", Ciudad_FirmaConvenio='"+ciudad_FirmaConvenio+"', Fecha_FirmaConvenio='"+fecha_FirmaConvenio+"', Familia_Profesional='"+familia_Profesional+"', Codigo_Centro='"+codigo_Centro+"' WHERE Num_Convenio='"+Num_ConvenioV+"'");
		}catch(SQLException s) {
			s.printStackTrace();
		}
	}
	
	
	public ObservableList<TutorPracticas> TutorPracticas() {
			
			ObservableList<TutorPracticas> data=FXCollections.observableArrayList();
			
			try {
				Statement stmt = conexion.createStatement();
				ResultSet rset = stmt.executeQuery("SELECT * FROM "+ usr +".Tutor_Practicas" );
				while(rset.next()) {
					TutorPracticas tutorp1 = new TutorPracticas(rset.getString(1), rset.getString(2),rset.getString(3),rset.getInt(4),rset.getString(5),rset.getString(6));
					data.add(tutorp1);
					
		
				}
				rset.close();
				stmt.close();
				
			}catch (SQLException s){
				s.printStackTrace();
			}
			
			return data;
			
		}
		
	
	public void AnadirTutorPracticas(String NIF,String Nombre,String Apellidos,int Numero,String Email,String NumConvenio) {
		try {
			Statement stmt = conexion.createStatement();
			stmt.executeQuery("INSERT INTO "+ usr +".TUTOR_PRACTICAS VALUES ('"+NIF+"','"+Nombre+"','"+Apellidos+"',"+Numero+",'"+Email+"','"+NumConvenio+"')");
		}catch(SQLException s) {
			s.printStackTrace();
		}
	}
	
	
	
	public ObservableList<String> NombreEmpresa() {
		
		ObservableList<String> convenio=FXCollections.observableArrayList();
		
		try {
			Statement stmt = conexion.createStatement();
			ResultSet rset = stmt.executeQuery("SELECT Nombre FROM "+ usr +".Empresas" );
			while(rset.next()) {
				
				convenio.add(rset.getString(1));
				
			}
			rset.close();
			stmt.close();
			
		}catch (SQLException s){
			s.printStackTrace();
		}
		
		return convenio;
		
	}
	
	public String ConvenioEmpresa(String nombre) {
		
		String a = null;

		try {
			Statement stmt = conexion.createStatement();
			ResultSet rset = stmt.executeQuery("SELECT Num_Convenio FROM "+ usr +".Empresas WHERE NOMBRE= '" + nombre+ "'");
			while(rset.next()) {
				
				 a=rset.getString(1);
				
			}
			rset.close();
			stmt.close();
			
		}catch (SQLException s){
			s.printStackTrace();
		}
		
		return a;
		
	}
	
	public ObservableList<Centro> DatosCentro() {
		
		
		ObservableList<Centro> data=FXCollections.observableArrayList();
		
		try {
			Statement stmt = conexion.createStatement();
			ResultSet rset = stmt.executeQuery("SELECT * FROM "+ usr +".CENTRO" );
			while(rset.next()) {
				Centro centro1 = new Centro(rset.getString(1),rset.getString(2),rset.getString(3),rset.getString(4),rset.getString(5),rset.getString(6),rset.getString(7),rset.getString(8),rset.getString(9),rset.getString(10),rset.getInt(11),rset.getInt(12),rset.getString(13));
				data.add(centro1);
	
			}
			rset.close();
			stmt.close();
			
		}catch (SQLException s){
			s.printStackTrace();
		}
		
	
		return data;
		
	}
	

	
	
	public ObservableList<String> NombreCentro() {
			
			ObservableList<String> nombre=FXCollections.observableArrayList();
			
			try {
				Statement stmt = conexion.createStatement();
				ResultSet rset = stmt.executeQuery("SELECT Nombre FROM "+ usr +".Centro" );
				while(rset.next()) {
					
					nombre.add(rset.getString(1));
					
				}
				rset.close();
				stmt.close();
				
			}catch (SQLException s){
				s.printStackTrace();
			}
			
			return nombre;
			
		}

	public String CodigoCentro(String nombre) {
		
		String a = null;
	
		try {
			Statement stmt = conexion.createStatement();
			ResultSet rset = stmt.executeQuery("SELECT Codigo_Centro FROM "+ usr +".Centro WHERE NOMBRE= '" + nombre+ "'");
			while(rset.next()) {
				
				 a=rset.getString(1);
				
			}
			rset.close();
			stmt.close();
			
		}catch (SQLException s){
			s.printStackTrace();
		}
		
		return a;
		
	}
	
	public ObservableList<AsignanPracticas> Asignar() {
			
			ObservableList<AsignanPracticas> data=FXCollections.observableArrayList();
			
			try {
				Statement stmt = conexion.createStatement();
				ResultSet rset = stmt.executeQuery("SELECT * FROM "+ usr +".Asignan_Empresa" );
				while(rset.next()) {
					AsignanPracticas asg1 = new AsignanPracticas(rset.getString(1), rset.getString(2),rset.getString(3),rset.getString(4),rset.getString(5),rset.getString(6),rset.getInt(7),rset.getInt(8),rset.getString(9),rset.getString(10),rset.getString(11),rset.getString(12));
					data.add(asg1);
					
		
				}
				rset.close();
				stmt.close();
				
			}catch (SQLException s){
				s.printStackTrace();
			}
			
			return data;
			
		}


	public ObservableList<String> NombreCiclo() {
		
		ObservableList<String> nombre=FXCollections.observableArrayList();
		
		try {
			Statement stmt = conexion.createStatement();
			ResultSet rset = stmt.executeQuery("SELECT Nombre FROM "+ usr +".Ciclos" );
			while(rset.next()) {
				
				nombre.add(rset.getString(1));
				
			}
			rset.close();
			stmt.close();
			
		}catch (SQLException s){
			s.printStackTrace();
		}
		
		return nombre;
		
	}
	
	public int CodigoCurso(String nombre) {
			
			int a = 0;
		
			try {
				Statement stmt = conexion.createStatement();
				ResultSet rset = stmt.executeQuery("SELECT Codigo FROM "+ usr +".Ciclos WHERE NOMBRE= '" + nombre+ "'");
				while(rset.next()) {
					
					 a=rset.getInt(1);
					
				}
				rset.close();
				stmt.close();
				
			}catch (SQLException s){
				s.printStackTrace();
			}
			
			return a;
			
		}
	

	public void Cursan(String nifa, int codigo, String curso) 
		{
			try {
				Statement stmt = conexion.createStatement();
				stmt.executeQuery("INSERT INTO "+ usr +".Cursan VALUES ('"+nifa+"',"+codigo+",'"+curso+"')");
			}catch(SQLException s) {
				s.printStackTrace();
			}
		}
	


	public ObservableList<DatosSelectAnexo2> GenerarAnexo2(String Nif) {
		
		ObservableList<DatosSelectAnexo2> data=FXCollections.observableArrayList();
		
		try {
			Statement stmt = conexion.createStatement();
			ResultSet rset = stmt.executeQuery("SELECT "+ usr +".CENTRO.DAT,"+ usr +".ASIGNAN_EMPRESA.NUM_CONVENIO,"+ usr +".EMPRESAS.FECHA_FIRMACONVENIO,"+ usr +".CENTRO.NOMBRE,"+ usr +".EMPRESAS.NOMBRE,"+ usr +".CURSAN.AÑO_CURSO,"+ usr +".CICLOS.CLAVE_FP,"+ usr +".CICLOS.NOMBRE,"+ usr +".ASIGNAN_EMPRESA.FECHA_INICIO,"+ usr +".ASIGNAN_EMPRESA.FECHA_FIN,"+ usr +".ASIGNAN_EMPRESA.HORAS_MAÑANAINICIO,"+ usr +".ASIGNAN_EMPRESA.HORAS_MAÑANAFIN,"+ usr +".ASIGNAN_EMPRESA.HORAS_TARDEINICIO,"+ usr +".ASIGNAN_EMPRESA.HORAS_TARDEFIN,"+ usr +".ASIGNAN_EMPRESA.HORAS_DIA,"+ usr +".ASIGNAN_EMPRESA.HORAS_TOTAL,"+ usr +".EMPRESAS.CIUDAD,"+ usr +".EMPRESAS.DIRECCION,"+ usr +".ALUMNOS.APELLIDOS,"+ usr +".ALUMNOS.NOMBRE,"+ usr +".ASIGNAN_EMPRESA.NIF_ALUMNO,"+ usr +".TUTOR.NOMBRE,"+ usr +".TUTOR.APELLIDOS,"+ usr +".TUTOR.NIF,"+ usr +".TUTOR_PRACTICAS.NOMBRE,"+ usr +".TUTOR_PRACTICAS.APELLIDOS FROM "+ usr +".EMPRESAS,"+ usr +".CICLOS,"+ usr +".ASIGNAN_EMPRESA,"+ usr +".CENTRO,"+ usr +".TUTOR,"+ usr +".TUTOR_PRACTICAS,"+ usr +".CURSAN,"+ usr +".ALUMNOS WHERE EMPRESAS.NUM_CONVENIO = ASIGNAN_EMPRESA.NUM_CONVENIO AND ASIGNAN_EMPRESA.NIF_TUTOR=TUTOR.NIF AND ASIGNAN_EMPRESA.NIF_TUTOREMPRESA = TUTOR_PRACTICAS.NIF AND ASIGNAN_EMPRESA.NIF_ALUMNO = ALUMNOS.NIF AND CICLOS.CODIGO=CURSAN.CODIGO AND CURSAN.NIF=ALUMNOS.NIF AND ALUMNOS.NIF= '" + Nif+ "'" );
			while(rset.next()) {
				DatosSelectAnexo2 datos = new DatosSelectAnexo2(rset.getString(1), rset.getString(2),rset.getString(3),rset.getString(4),rset.getString(5),rset.getString(6),rset.getString(7),rset.getString(8),rset.getString(9),rset.getString(10),rset.getString(11),rset.getString(12), rset.getString(13), rset.getString(14), rset.getInt(15), rset.getInt(16), rset.getString(17), rset.getString(18), rset.getString(19), rset.getString(20), rset.getString(21), rset.getString(22), rset.getString(23), rset.getString(24), rset.getString(25), rset.getString(26));
				data.add(datos);
				
	
			}
			rset.close();
			stmt.close();
			
		}catch (SQLException s){
			s.printStackTrace();
		}
		
		return data;
		
	}

	 public ObservableList<Empresa> DatosEmpresa(String num)
	 {
		 ObservableList<Empresa> data=FXCollections.observableArrayList();
			
			try {
				Statement stmt = conexion.createStatement();
				ResultSet rset = stmt.executeQuery("SELECT * FROM "+ usr +".Empresas WHERE NUM_CONVENIO IN (SELECT NUM_CONVENIO FROM "+usr+".Asignan_Empresa WHERE NIF_ALUMNO = '" + num+ "')");
				while(rset.next()) {
					Empresa emp1 = new Empresa(rset.getString(1), rset.getString(2),rset.getString(3),rset.getString(4),rset.getString(5),rset.getString(6),rset.getString(7),rset.getString(8),rset.getString(9),rset.getString(10),rset.getString(11),rset.getInt(12),rset.getInt(13),rset.getString(14),rset.getString(15),rset.getString(16),rset.getString(17));
					data.add(emp1);
					
		
				}
				rset.close();
				stmt.close();
				
			}catch (SQLException s){
				s.printStackTrace();
			}
			
			return data;
	 }
	 
	 public ObservableList<Alumno> BusquedaAlumnosApellidos(String Apellidos)
	 {
		 ObservableList<Alumno> data=FXCollections.observableArrayList();
			
			try {
				Statement stmt = conexion.createStatement();
				ResultSet rset = stmt.executeQuery("SELECT * FROM " + usr + ".ALUMNOS WHERE APELLIDOS = '" + Apellidos+ "'" );
				while(rset.next()) {
					Alumno alm1 = new Alumno(rset.getString(1), rset.getString(2),rset.getString(3),rset.getInt(4),rset.getString(5));
					data.add(alm1);
					
		
				}
				rset.close();
				stmt.close();
				
			}catch (SQLException s){
				s.printStackTrace();
			}
			
			return data;
		 
	 }
	 
	 public ObservableList<Alumno> BusquedaAlumnosNif(String NIF)
	 {
		 ObservableList<Alumno> data=FXCollections.observableArrayList();
			
			try {
				Statement stmt = conexion.createStatement();
				ResultSet rset = stmt.executeQuery("SELECT * FROM " + usr + ".ALUMNOS WHERE NIF = '" + NIF+ "'" );
				while(rset.next()) {
					Alumno alm1 = new Alumno(rset.getString(1), rset.getString(2),rset.getString(3),rset.getInt(4),rset.getString(5));
					data.add(alm1);
					
		
				}
				rset.close();
				stmt.close();
				
			}catch (SQLException s){
				s.printStackTrace();
			}
			
			return data;
		 
	 }
	 
	 public ObservableList<Alumno> BusquedaAlumnosEmpresa(String Empresa)
	 {
		 ObservableList<Alumno> data=FXCollections.observableArrayList();
			
			try {
				Statement stmt = conexion.createStatement();
				ResultSet rset = stmt.executeQuery("SELECT * FROM " +usr+".ALUMNOS WHERE NIF IN (SELECT NIF_ALUMNO FROM "+usr+".ASIGNAN_EMPRESA WHERE NUM_CONVENIO IN (SELECT NUM_CONVENIO FROM "+usr+".EMPRESAS WHERE NOMBRE = '" + Empresa+ "'))" );
				while(rset.next()) {
					Alumno alm1 = new Alumno(rset.getString(1), rset.getString(2),rset.getString(3),rset.getInt(4),rset.getString(5));
					data.add(alm1);
					
		
				}
				rset.close();
				stmt.close();
				
			}catch (SQLException s){
				s.printStackTrace();
			}
			
			return data;
		 
	 }
	 
	 public ObservableList<Alumno> BusquedaAlumnosCiclo(String Ciclo)
	 {
		 ObservableList<Alumno> data=FXCollections.observableArrayList();
			
			try {
				Statement stmt = conexion.createStatement();
				ResultSet rset = stmt.executeQuery("SELECT * FROM " +usr+".ALUMNOS WHERE NIF IN (SELECT NIF FROM "+usr+".CURSAN WHERE Codigo IN (SELECT Codigo FROM "+usr+".Ciclos WHERE NOMBRE = '" + Ciclo+ "'))" );
				while(rset.next()) {
					Alumno alm1 = new Alumno(rset.getString(1), rset.getString(2),rset.getString(3),rset.getInt(4),rset.getString(5));
					data.add(alm1);
					
		
				}
				rset.close();
				stmt.close();
				
			}catch (SQLException s){
				s.printStackTrace();
			}
			
			return data;
		 
	 }
	 
	public ObservableList<Ciclo> BusquedaCicloClaVe(String clave) {
			
			ObservableList<Ciclo> data=FXCollections.observableArrayList();
			
			try {
				Statement stmt = conexion.createStatement();
				ResultSet rset = stmt.executeQuery("SELECT * FROM "+ usr +".CICLOS WHERE Clave_FP= '" + clave+"'");
				while(rset.next()) {
					Ciclo ciclo1 = new Ciclo(rset.getInt(1), rset.getString(2),rset.getString(3),rset.getString(4),rset.getString(5),rset.getString(6),rset.getString(7),rset.getString(8));
					data.add(ciclo1);
					
		
				}
				rset.close();
				stmt.close();
				
			}catch (SQLException s){
				s.printStackTrace();
			}
			
			return data;
			
		}
	
	public ObservableList<Ciclo> BusquedaCicloNombre(String nombre) {
		
		ObservableList<Ciclo> data=FXCollections.observableArrayList();
		
		try {
			Statement stmt = conexion.createStatement();
			ResultSet rset = stmt.executeQuery("SELECT * FROM "+ usr +".CICLOS WHERE Nombre= '" + nombre+"'");
			while(rset.next()) {
				Ciclo ciclo1 = new Ciclo(rset.getInt(1), rset.getString(2),rset.getString(3),rset.getString(4),rset.getString(5),rset.getString(6),rset.getString(7),rset.getString(8));
				data.add(ciclo1);
				
	
			}
			rset.close();
			stmt.close();
			
		}catch (SQLException s){
			s.printStackTrace();
		}
		
		return data;
		
	}
	
	public ObservableList<Ciclo> BusquedaCicloTipo(String tipo) {
		
		ObservableList<Ciclo> data=FXCollections.observableArrayList();
		
		try {
			Statement stmt = conexion.createStatement();
			ResultSet rset = stmt.executeQuery("SELECT * FROM "+ usr +".CICLOS WHERE Tipo= '" + tipo+"'");
			while(rset.next()) {
				Ciclo ciclo1 = new Ciclo(rset.getInt(1), rset.getString(2),rset.getString(3),rset.getString(4),rset.getString(5),rset.getString(6),rset.getString(7),rset.getString(8));
				data.add(ciclo1);
				
	
			}
			rset.close();
			stmt.close();
			
		}catch (SQLException s){
			s.printStackTrace();
		}
		
		return data;
		
	}
	 
	public ObservableList<Ciclo> BusquedaCicloFamilia(String familia) {
		
		ObservableList<Ciclo> data=FXCollections.observableArrayList();
		
		try {
			Statement stmt = conexion.createStatement();
			ResultSet rset = stmt.executeQuery("SELECT * FROM "+ usr +".CICLOS WHERE FAMILIA_PROFESIONAL= '" + familia+"'");
			while(rset.next()) {
				Ciclo ciclo1 = new Ciclo(rset.getInt(1), rset.getString(2),rset.getString(3),rset.getString(4),rset.getString(5),rset.getString(6),rset.getString(7),rset.getString(8));
				data.add(ciclo1);
				
	
			}
			rset.close();
			stmt.close();
			
		}catch (SQLException s){
			s.printStackTrace();
		}
		
		return data;
		
	}
	 
	public ObservableList<Empresa> BusquedaEmpresaNombre(String nombre) {
		
		ObservableList<Empresa> data=FXCollections.observableArrayList();
		
		try {
			Statement stmt = conexion.createStatement();
			ResultSet rset = stmt.executeQuery("SELECT * FROM "+ usr +".Empresas WHERE NOMBRE= '"+nombre+"'" );
			while(rset.next()) {
				Empresa emp1 = new Empresa(rset.getString(1), rset.getString(2),rset.getString(3),rset.getString(4),rset.getString(5),rset.getString(6),rset.getString(7),rset.getString(8),rset.getString(9),rset.getString(10),rset.getString(11),rset.getInt(12),rset.getInt(13),rset.getString(14),rset.getString(15),rset.getString(16),rset.getString(17));
				data.add(emp1);
				
	
			}
			rset.close();
			stmt.close();
			
		}catch (SQLException s){
			s.printStackTrace();
		}
		
		return data;
		
	}
	
public ObservableList<Empresa> BusquedaEmpresaProvincia(String provincia) {
		
		ObservableList<Empresa> data=FXCollections.observableArrayList();
		
		try {
			Statement stmt = conexion.createStatement();
			ResultSet rset = stmt.executeQuery("SELECT * FROM "+ usr +".Empresas WHERE PROVINCIA= '"+provincia+"'" );
			while(rset.next()) {
				Empresa emp1 = new Empresa(rset.getString(1), rset.getString(2),rset.getString(3),rset.getString(4),rset.getString(5),rset.getString(6),rset.getString(7),rset.getString(8),rset.getString(9),rset.getString(10),rset.getString(11),rset.getInt(12),rset.getInt(13),rset.getString(14),rset.getString(15),rset.getString(16),rset.getString(17));
				data.add(emp1);
				
	
			}
			rset.close();
			stmt.close();
			
		}catch (SQLException s){
			s.printStackTrace();
		}
		
		return data;
		
	}

	public ObservableList<Empresa> BusquedaEmpresaCiudad(String ciudad) {
		
		ObservableList<Empresa> data=FXCollections.observableArrayList();
		
		try {
			Statement stmt = conexion.createStatement();
			ResultSet rset = stmt.executeQuery("SELECT * FROM "+ usr +".Empresas WHERE CIUDAD= '"+ciudad+"'" );
			while(rset.next()) {
				Empresa emp1 = new Empresa(rset.getString(1), rset.getString(2),rset.getString(3),rset.getString(4),rset.getString(5),rset.getString(6),rset.getString(7),rset.getString(8),rset.getString(9),rset.getString(10),rset.getString(11),rset.getInt(12),rset.getInt(13),rset.getString(14),rset.getString(15),rset.getString(16),rset.getString(17));
				data.add(emp1);
				
	
			}
			rset.close();
			stmt.close();
			
		}catch (SQLException s){
			s.printStackTrace();
		}
		
		return data;
		
	}
	
	public ObservableList<Empresa> BusquedaEmpresaFamilia(String familia) {
			
			ObservableList<Empresa> data=FXCollections.observableArrayList();
			
			try {
				Statement stmt = conexion.createStatement();
				ResultSet rset = stmt.executeQuery("SELECT * FROM "+ usr +".Empresas WHERE Familia_Profesional= '"+familia+"'" );
				while(rset.next()) {
					Empresa emp1 = new Empresa(rset.getString(1), rset.getString(2),rset.getString(3),rset.getString(4),rset.getString(5),rset.getString(6),rset.getString(7),rset.getString(8),rset.getString(9),rset.getString(10),rset.getString(11),rset.getInt(12),rset.getInt(13),rset.getString(14),rset.getString(15),rset.getString(16),rset.getString(17));
					data.add(emp1);
					
		
				}
				rset.close();
				stmt.close();
				
			}catch (SQLException s){
				s.printStackTrace();
			}
			
			return data;
			
		}
	
	public ObservableList<Empresa> BusquedaEmpresaRepre(String rep) {
		
		ObservableList<Empresa> data=FXCollections.observableArrayList();
		
		try {
			Statement stmt = conexion.createStatement();
			ResultSet rset = stmt.executeQuery("SELECT * FROM "+ usr +".Empresas WHERE Representante= '"+rep+"'" );
			while(rset.next()) {
				Empresa emp1 = new Empresa(rset.getString(1), rset.getString(2),rset.getString(3),rset.getString(4),rset.getString(5),rset.getString(6),rset.getString(7),rset.getString(8),rset.getString(9),rset.getString(10),rset.getString(11),rset.getInt(12),rset.getInt(13),rset.getString(14),rset.getString(15),rset.getString(16),rset.getString(17));
				data.add(emp1);
				
	
			}
			rset.close();
			stmt.close();
			
		}catch (SQLException s){
			s.printStackTrace();
		}
		
		return data;
		
	}
	
	public ObservableList<Empresa> BusquedaEmpresaTutor(String tutor) {
			
			ObservableList<Empresa> data=FXCollections.observableArrayList();
			
			try {
				Statement stmt = conexion.createStatement();
				ResultSet rset = stmt.executeQuery("SELECT * FROM "+ usr +".Empresas WHERE NUM_CONVENIO IN (SELECT NUM_CONVENIO FROM "+ usr +".ASIGNAN_EMPRESA WHERE NIF_TUTOREMPRESA IN (SELECT NIF FROM  "+ usr +".TUTOR_PRACTICAS WHERE  NOMBRE= '"+tutor+"'))" );
				while(rset.next()) {
					Empresa emp1 = new Empresa(rset.getString(1), rset.getString(2),rset.getString(3),rset.getString(4),rset.getString(5),rset.getString(6),rset.getString(7),rset.getString(8),rset.getString(9),rset.getString(10),rset.getString(11),rset.getInt(12),rset.getInt(13),rset.getString(14),rset.getString(15),rset.getString(16),rset.getString(17));
					data.add(emp1);
					
		
				}
				rset.close();
				stmt.close();
				
			}catch (SQLException s){
				s.printStackTrace();
			}
			
			return data;
			
		}

	public ObservableList<Tutor> BusquedaTutorApellidos(String Apellidos)
	{
		 ObservableList<Tutor> data=FXCollections.observableArrayList();
			
			try {
				Statement stmt = conexion.createStatement();
				ResultSet rset = stmt.executeQuery("SELECT * FROM " + usr + ".TUTOR WHERE APELLIDOS = '" + Apellidos+ "'" );
				while(rset.next()) {
					Tutor tutor1 = new Tutor(rset.getString(1), rset.getString(2),rset.getString(3),rset.getString(4));
					data.add(tutor1);
					
		
				}
				rset.close();
				stmt.close();
				
			}catch (SQLException s){
				s.printStackTrace();
			}
			
			return data;
				
		 
	}
	
	public ObservableList<Tutor> BusquedaTutorNIF(String nif)
	 {
		 ObservableList<Tutor> data=FXCollections.observableArrayList();
			
			try {
				Statement stmt = conexion.createStatement();
				ResultSet rset = stmt.executeQuery("SELECT * FROM " + usr + ".TUTOR WHERE NIF = '" + nif+ "'" );
			while(rset.next()) {
					Tutor tutor1 = new Tutor(rset.getString(1), rset.getString(2),rset.getString(3),rset.getString(4));
					data.add(tutor1);
					
		
				}
				rset.close();
				stmt.close();
				
			}catch (SQLException s){
				s.printStackTrace();
			}
			
			return data;
				
		 
	 }
	
	public ObservableList<Tutor> BusquedaTutorCiclo(String ciclo)
	 {
		 ObservableList<Tutor> data=FXCollections.observableArrayList();
			
			try {
				Statement stmt = conexion.createStatement();
				ResultSet rset = stmt.executeQuery("SELECT * FROM "+usr+".TUTOR WHERE NIF IN (SELECT NIF_TUTOR FROM "+usr+".ASIGNAN_EMPRESA WHERE NIF_ALUMNO IN (SELECT NIF FROM "+usr+".CURSAN WHERE CODIGO IN (SELECT CODIGO FROM "+usr+".Ciclos WHERE Nombre = '" + ciclo+ "')))");
			while(rset.next()) {
					Tutor tutor1 = new Tutor(rset.getString(1), rset.getString(2),rset.getString(3),rset.getString(4));
					data.add(tutor1);
					
		
				}
				rset.close();
				stmt.close();
				
			}catch (SQLException s){
				s.printStackTrace();
			}
			
			return data;
				
		 
	 }
		 

	public void AsignarP (String nifa, String num_conv, String nift, String niftp, String fechai, String fechaf, int horasd, int horast, String HorasTardeI, String HorasTardeF, String HorasMananaI, String HorasMananaF) {
		  {
			try {
				Statement stmt = conexion.createStatement();
				stmt.executeQuery("INSERT INTO "+ usr +".Asignan_Empresa VALUES ('"+nifa+"','"+num_conv+"','"+nift+"','"+niftp+"','"+fechai+"','"+fechaf+"',"+horasd+","+horast+",'"+HorasTardeI+"','"+HorasTardeF+"','"+HorasMananaI+"','"+HorasMananaF+"')");
			}catch(SQLException s) {
				s.printStackTrace();
			}
		}
		  
		 	

}

}


	
	
		
		
		
		
