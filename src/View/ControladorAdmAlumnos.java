package View;

import java.io.IOException;

import Controller.Main;
import Model.Alumno;
import Model.TestConexion;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.layout.AnchorPane;
import javafx.stage.Stage;

public class ControladorAdmAlumnos {
	
	@FXML
	private Button Anadir;
	
	@FXML
	private Button Modificar;
	
	@FXML
	private TableView<Alumno> Tabla;

	@FXML
	private TableColumn<Alumno,String> NIF;

	@FXML
	private TableColumn<Alumno,String> Nombre;
	
	@FXML
	private TableColumn<Alumno,String> Apellidos;
	
	@FXML
	private TableColumn<Alumno,Integer> Telefono;
	
	@FXML
	private TableColumn<Alumno,String> Email;
	

	private final ObservableList<Alumno> data = FXCollections.observableArrayList();
	
	
	public void initialize(){
		
		NIF.setCellValueFactory(new PropertyValueFactory<Alumno,String>("NIF"));
		Nombre.setCellValueFactory(new PropertyValueFactory<Alumno,String>("Nombre"));
		Apellidos.setCellValueFactory(new PropertyValueFactory<Alumno,String>("Apellidos"));
		Telefono.setCellValueFactory(new PropertyValueFactory<Alumno,Integer>("Telefono"));
		Email.setCellValueFactory(new PropertyValueFactory<Alumno,String>("Email"));
		TestConexion uno = new TestConexion();
		data.addAll(uno.Alumno());
		Tabla.setItems(uno.Alumno());
		
		}
	
	
	
	
	
	public void Anadir(ActionEvent event) throws IOException{
		
		 
        FXMLLoader loader = new FXMLLoader(Main.class.getResource("../View/AnadirAlumno.fxml"));
        
        AnchorPane Menu = (AnchorPane)loader.load();
   
        /* Creamos la segunda ventana como otro stage */
        Stage ventanaAA = new Stage();
        ventanaAA.setTitle("IncluirAlumnos");
        
        /* Le decimos a la ventana quién es la ventana original */
        Scene scene = new Scene(Menu);
        ventanaAA.setScene(scene);
        ventanaAA.show();
       
   
    
}
	
	public void Modificar(ActionEvent event) throws IOException{
		
		 
        FXMLLoader loader = new FXMLLoader(Main.class.getResource("../View/ModificarAlumno.fxml"));
        
        AnchorPane Menu = (AnchorPane)loader.load();
   
        /* Creamos la segunda ventana como otro stage */
        Stage ventanaMA = new Stage();
        ventanaMA.setTitle("ModificarAlumnos");
        
        /* Le decimos a la ventana quién es la ventana original */
        Scene scene = new Scene(Menu);
        ventanaMA.setScene(scene);
        ventanaMA.show();
       
   
    
}

}
