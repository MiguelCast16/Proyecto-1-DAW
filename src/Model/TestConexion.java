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
	private String usr = "";
	private String pwd = "";
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
				usr = propiedades.getProperty("usr");
				pwd = propiedades.getProperty("pwd");
				
				System.out.println( url + usr + pwd);
				
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
			conexion = DriverManager.getConnection(url, usr, pwd);
			
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
			ResultSet rset = stmt.executeQuery("SELECT * FROM APLICACIONMIGUEL.ALUMNOS" );
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
			stmt.executeQuery("INSERT INTO APLICACIONMIGUEL.ALUMNOS VALUES ('"+NIF+"','"+Nombre+"','"+Apellidos+"',"+numero+",'"+email+"')");
		}catch(SQLException s) {
			s.printStackTrace();
		}
	}
	
	
	
	public void ModificarAlumno(String NIF,String Nombre,String Apellidos,int numero,String email, String NIFViejo) {
		try {
			Statement stmt = conexion.createStatement();
			stmt.executeQuery("UPDATE  APLICACIONMIGUEL.ALUMNOS SET NIF='"+NIF+"', Nombre='"+Nombre+"', Apellidos='"+Apellidos+"', Telefono='"+numero+"', Email='"+email+"' WHERENIF='"+NIFViejo+"'");
		}catch(SQLException s) {
			s.printStackTrace();
		}
	}
	
	
	public ObservableList<Tutor> Tutor() {
		
		ObservableList<Tutor> data=FXCollections.observableArrayList();
		
		try {
			Statement stmt = conexion.createStatement();
			ResultSet rset = stmt.executeQuery("SELECT * FROM APLICACIONMIGUEL.Tutor" );
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
		stmt.executeQuery("INSERT INTO APLICACIONMIGUEL.TUTOR VALUES ('"+NIF+"','"+Nombre+"','"+Apellidos+"','"+email+"')");
	}catch(SQLException s) {
		s.printStackTrace();
		}
	}

	public void ModificarTutor(String NIF,String Nombre,String Apellidos, String email, String NIFViejo) {
		try {
			Statement stmt = conexion.createStatement();
			stmt.executeQuery("UPDATE  APLICACIONMIGUEL.TUTOR SET NIF='"+NIF+"', Nombre='"+Nombre+"', Apellidos='"+Apellidos+"', Email='"+email+"' WHERE NIF='"+NIFViejo+"' ");
		}catch(SQLException s) {
			s.printStackTrace();
		}
	}
	
	
public ObservableList<Ciclo> Ciclo() {
		
		ObservableList<Ciclo> data=FXCollections.observableArrayList();
		
		try {
			Statement stmt = conexion.createStatement();
			ResultSet rset = stmt.executeQuery("SELECT * FROM APLICACIONMIGUEL.CICLOS" );
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
		stmt.executeQuery("INSERT INTO APLICACIONMIGUEL.CICLOS VALUES ("+Codigo+",'"+Nombre+"','"+Tipo+"','"+Familia_Profesional+"','"+Capacidades+"','"+Actividades+"','"+Criterios+"','"+Clave_FP+"')");
	}catch(SQLException s) {
		s.printStackTrace();
		}
	}

	public void ModificarCiclo(int Codigo, String Nombre, String Tipo, String Familia_Profesional, String Capacidades,String Actividades, String Criterios, String Clave_FP, int CodigoViejo) {
		try {
			Statement stmt = conexion.createStatement();
			stmt.executeQuery("UPDATE  APLICACIONMIGUEL.CICLOS SET Codigo="+Codigo+", Nombre='"+Nombre+"', Tipo='"+Tipo+"', Familia_Profesional='"+Familia_Profesional+"', Capacidades='"+Capacidades+"', Actividades='"+Actividades+"', Criterios='"+Criterios+"', Clave_FP='"+Clave_FP+"' WHERE Codigo='"+CodigoViejo+"'");
		}catch(SQLException s) {
			s.printStackTrace();
		}
	}
	
	
	
	
	
	public ObservableList<Empresa> Empresa() {
			
			ObservableList<Empresa> data=FXCollections.observableArrayList();
			
			try {
				Statement stmt = conexion.createStatement();
				ResultSet rset = stmt.executeQuery("SELECT * FROM APLICACIONMIGUEL.Empresas" );
				while(rset.next()) {
					Empresa emp1 = new Empresa(rset.getString(1), rset.getString(2),rset.getString(3),rset.getString(4),rset.getString(5),rset.getString(6),rset.getString(7),rset.getString(8),rset.getString(9),rset.getString(10),rset.getInt(11),rset.getInt(12),rset.getString(13),rset.getString(14),rset.getString(15),rset.getInt(16));
					data.add(emp1);
					
		
				}
				rset.close();
				stmt.close();
				
			}catch (SQLException s){
				s.printStackTrace();
			}
			
			return data;
			
		}
		
	
	
	
	
	
	public void AnadirEmpresa(String num_Convenio, String Cif, String representante, String NIF_Representante, String nombre, String pais, String ciudad, String provincia, String direccion, String CP, int telefono, int fax, String ciudad_FirmaConvenio, String fecha_FirmaConvenio, String familia_Profesional, int codigo_Centro) {
		try {
			Statement stmt = conexion.createStatement();
			stmt.executeQuery("INSERT INTO APLICACIONMIGUEL.EMPRESAS VALUES ("+num_Convenio+",'"+Cif+"','"+representante+"','"+NIF_Representante+"','"+nombre+"','"+pais+"','"+ciudad+"','"+provincia+"','"+provincia+"','"+direccion+"','"+CP+"',"+telefono+","+fax+",'"+ciudad_FirmaConvenio+"','"+fecha_FirmaConvenio+"','"+familia_Profesional+"',"+codigo_Centro+")");
		}catch(SQLException s) {
			s.printStackTrace();
		}
	}
	
	public void ModificarEmpresa(String num_Convenio, String Cif, String representante, String NIF_Representante, String nombre, String pais, String ciudad, String provincia, String direccion, String CP, int telefono, int fax, String ciudad_FirmaConvenio, String fecha_FirmaConvenio, String familia_Profesional, int codigo_Centro, String Num_ConvenioV) {

		try {
			Statement stmt = conexion.createStatement();
			stmt.executeQuery("UPDATE  APLICACIONMIGUEL.EMPRESAS SET Num_Convenio="+num_Convenio+", CIF='"+Cif+"', Representante='"+representante+"', NIF_Representante='"+NIF_Representante+"', Nombre='"+nombre+"', Pais='"+pais+"', Ciudad='"+ciudad+"', Provincia='"+provincia+"',Direccion="+direccion+", CP='"+CP+"', Telefono="+telefono+", FAX='"+fax+", Ciudad_FirmaConvenio='"+ciudad_FirmaConvenio+"', Fecha_FirmaConvenio='"+fecha_FirmaConvenio+"', Familia_Profesional='"+familia_Profesional+"', Codigo_Centro='"+codigo_Centro+"' WHERE Num_Convenio='"+Num_ConvenioV+"'");
		}catch(SQLException s) {
			s.printStackTrace();
		}
	}
	
	
	public ObservableList<TutorPracticas> TutorPracticas() {
			
			ObservableList<TutorPracticas> data=FXCollections.observableArrayList();
			
			try {
				Statement stmt = conexion.createStatement();
				ResultSet rset = stmt.executeQuery("SELECT * FROM APLICACIONMIGUEL.Tutor_Practicas" );
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
			stmt.executeQuery("INSERT INTO APLICACIONMIGUEL.TUTOR_PRACTICAS VALUES ('"+NIF+"','"+Nombre+"','"+Apellidos+"',"+Numero+",'"+Email+"','"+NumConvenio+"')");
		}catch(SQLException s) {
			s.printStackTrace();
		}
	}
	
	
	}
	
		
