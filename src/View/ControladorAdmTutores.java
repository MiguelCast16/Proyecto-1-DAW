package View;

import java.io.IOException;

import Controller.Main;
import Model.Alumno;
import Model.TestConexion;
import Model.Tutor;
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

public class ControladorAdmTutores {
	
	@FXML
	private Button Anadir;
	
	@FXML
	private Button Modificar;
	
	@FXML
	private TableView<Tutor> Tabla;

	@FXML
	private TableColumn<Tutor,String> NIF;

	@FXML
	private TableColumn<Tutor,String> Nombre;
	
	@FXML
	private TableColumn<Tutor,String> Apellidos;
	
	
	@FXML
	private TableColumn<Tutor,String> Email;
	

	private final ObservableList<Tutor> data = FXCollections.observableArrayList();
	
	
	public void initialize(){
		
		NIF.setCellValueFactory(new PropertyValueFactory<Tutor,String>("NIF"));
		Nombre.setCellValueFactory(new PropertyValueFactory<Tutor,String>("Nombre"));
		Apellidos.setCellValueFactory(new PropertyValueFactory<Tutor,String>("Apellidos"));
		Email.setCellValueFactory(new PropertyValueFactory<Tutor,String>("Email"));
		TestConexion uno = new TestConexion();
		data.addAll(uno.Tutor());
		Tabla.setItems(uno.Tutor());
		
		}
	
	
	
	public void Anadir(ActionEvent event) throws IOException{
		
		 
        FXMLLoader loader = new FXMLLoader(Main.class.getResource("../View/AnadirTutor.fxml"));
        
        AnchorPane Menu = (AnchorPane)loader.load();
   
        /* Creamos la segunda ventana como otro stage */
        Stage ventanaAT = new Stage();
        ventanaAT.setTitle("IncluirEmpresa");
        
        /* Le decimos a la ventana quién es la ventana original */
        Scene scene = new Scene(Menu);
        ventanaAT.setScene(scene);
        ventanaAT.show();
       
   
    
}
	
	public void Modificar(ActionEvent event) throws IOException{
		
		 
        FXMLLoader loader = new FXMLLoader(Main.class.getResource("../View/ModificarTutor.fxml"));
        
        AnchorPane Menu = (AnchorPane)loader.load();
   
        /* Creamos la segunda ventana como otro stage */
        Stage ventanaMT = new Stage();
        ventanaMT.setTitle("ModificarTutor");
        
        /* Le decimos a la ventana quién es la ventana original */
        Scene scene = new Scene(Menu);
        ventanaMT.setScene(scene);
        ventanaMT.show();
       
   
    
}

}
