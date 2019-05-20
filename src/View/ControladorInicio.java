package View;
import java.io.IOException;

import Controller.Main;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.layout.AnchorPane;
import javafx.stage.Stage;



public class ControladorInicio {
	
	@FXML
	private Button Empresas;
	
	@FXML
	private Button Alumnos;
	
	@FXML
	private Button Ciclos;
	
	@FXML
	private Button Tutores;
	
	@FXML
	private Button Asignar;
	
	@FXML
	private Button Generar;


	   ;
	
		
	
	public void Alumnos(ActionEvent event) throws IOException{
		
		 
        FXMLLoader loader = new FXMLLoader(Main.class.getResource("../View/AdministrarAlumnos.fxml"));
        
        AnchorPane Menu = (AnchorPane)loader.load();
   
        /* Creamos la segunda ventana como otro stage */
        Stage ventanaA = new Stage();
        ventanaA.setTitle("AdmAlumnos");
        
        /* Le decimos a la ventana quién es la ventana original */
        Scene scene = new Scene(Menu);
        ventanaA.setScene(scene);
        ventanaA.show();
        
        
}

	public void Empresas(ActionEvent event) throws IOException{
		
		 
        FXMLLoader loader = new FXMLLoader(Main.class.getResource("../View/AdministrarEmpresas.fxml"));
        
        AnchorPane Menu = (AnchorPane)loader.load();
   
        /* Creamos la segunda ventana como otro stage */
        Stage ventanaE = new Stage();
        ventanaE.setTitle("AdmEmpresas");
        
        /* Le decimos a la ventana quién es la ventana original */
        Scene scene = new Scene(Menu);
        ventanaE.setScene(scene);
        ventanaE.show();
       
   
    
}
	
	public void Tutores(ActionEvent event) throws IOException{
		
		 
        FXMLLoader loader = new FXMLLoader(Main.class.getResource("../View/AdministrarTutores.fxml"));
        
        AnchorPane Menu = (AnchorPane)loader.load();
   
        /* Creamos la segunda ventana como otro stage */
        Stage ventana = new Stage();
        ventana.setTitle("AdmTutores");
        
        /* Le decimos a la ventana quién es la ventana original */
        Scene scene = new Scene(Menu);
        ventana.setScene(scene);
        ventana.show();
       
   
    
}
	
	public void Ciclos(ActionEvent event) throws IOException{
		
		 
        FXMLLoader loader = new FXMLLoader(Main.class.getResource("../View/AdministrarCiclos.fxml"));
        
        AnchorPane Menu = (AnchorPane)loader.load();
   
        /* Creamos la segunda ventana como otro stage */
        Stage ventanaC = new Stage();
        ventanaC.setTitle("AdmCiclos");
        
        /* Le decimos a la ventana quién es la ventana original */
        Scene scene = new Scene(Menu);
        ventanaC.setScene(scene);
        ventanaC.show();
       
   
    
}
	
	public void Asignar(ActionEvent event) throws IOException{
		
		 
        FXMLLoader loader = new FXMLLoader(Main.class.getResource("../View/AsignarPracticas.fxml"));
        
        AnchorPane Menu = (AnchorPane)loader.load();
   
        /* Creamos la segunda ventana como otro stage */
        Stage ventanaAP = new Stage();
        ventanaAP.setTitle("Asignar");
        
        /* Le decimos a la ventana quién es la ventana original */
        Scene scene = new Scene(Menu);
        ventanaAP.setScene(scene);
        ventanaAP.show();
       
   
    
}
	
	public void Generar(ActionEvent event) throws IOException{
		
		 
        FXMLLoader loader = new FXMLLoader(Main.class.getResource("../View/GenerarAnexos.fxml"));
        
        AnchorPane Menu = (AnchorPane)loader.load();
   
        /* Creamos la segunda ventana como otro stage */
        Stage ventanaG = new Stage();
        ventanaG.setTitle("Generar");
        
        /* Le decimos a la ventana quién es la ventana original */
        Scene scene = new Scene(Menu);
        ventanaG.setScene(scene);
        ventanaG.show();
       
   
    
}
	
	
	
}
