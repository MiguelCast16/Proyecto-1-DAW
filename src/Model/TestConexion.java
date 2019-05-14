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
	
	
	
	public void ModificarAlumno()
	{}
	
	
	
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
		stmt.executeQuery("INSERT INTO APLICACIONMIGUEL.ALUMNOS VALUES ('"+NIF+"','"+Nombre+"','"+Apellidos+"','"+email+"')");
	}catch(SQLException s) {
		s.printStackTrace();
	}
}

	public void ModificarTutor()
	{}
	
	
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

	public void ModificarCiclo()
	{}
	
	
	}
	
		
