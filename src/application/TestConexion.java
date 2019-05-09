package application;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.sql.*;
import java.util.Properties;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;

public class TestConexion {

	
	
	private String bd;
	private String url= "";
	private String usr = "";
	private String pwd = "";
	private static Connection conexion;
	
	
	
	
	public TestConexion()  {
		
		Properties propiedades = new Properties();
		InputStream entrada=null;

		try {
			
			File miFichero = new File("src/application/Prueba.ini");
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
	
		
}