package View;

import java.io.IOException;

import Controller.Main;
import Model.TestConexion;
import Model.Tutor;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.scene.control.Alert;
import javafx.scene.control.Button;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.TextField;
import javafx.scene.control.Alert.AlertType;
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
	
	@FXML
	private TextField ApellidosB;
	
	@FXML
	private TextField dni;
	
	@FXML
	private TextField ciclo;
	
	@FXML
	private Button Buscar;
	
	@FXML
	private Button Restablecer;
	
	TestConexion uno = new TestConexion();

	private final ObservableList<Tutor> data = FXCollections.observableArrayList();
	
	
	public void initialize(){
		
		NIF.setCellValueFactory(new PropertyValueFactory<Tutor,String>("NIF"));
		Nombre.setCellValueFactory(new PropertyValueFactory<Tutor,String>("Nombre"));
		Apellidos.setCellValueFactory(new PropertyValueFactory<Tutor,String>("Apellidos"));
		Email.setCellValueFactory(new PropertyValueFactory<Tutor,String>("Email"));
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
		
		Tutor selectedItem = Tabla.getSelectionModel().getSelectedItem();
        if (selectedItem != null) { 
		
        FXMLLoader loader = new FXMLLoader(Main.class.getResource("../View/ModificarTutor.fxml"));
        
        AnchorPane Menu = (AnchorPane)loader.load();
   
        /* Creamos la segunda ventana como otro stage */
        Stage ventanaMT = new Stage();
        ventanaMT.setTitle("ModificarTutor");
        ControladorModificarTutor tutorcontroller = loader.getController();
        tutorcontroller.setTutor(selectedItem);
        /* Le decimos a la ventana quién es la ventana original */
        Scene scene = new Scene(Menu);
        ventanaMT.setScene(scene);
        ventanaMT.show();
        }
         else {
        	Alert alert = new Alert(AlertType.ERROR); 
            alert.setTitle("No Seleccionado");
            alert.setHeaderText("Persona No Seleccionada");
            alert.setContentText("Por favor!!! Seleccione Una Persona De La tabla");

            alert.showAndWait();
        }
   
    
}
	
	
	public void Limpiar(ActionEvent event) throws IOException{
		
		data.addAll(uno.Tutor());
		Tabla.setItems(uno.Tutor());
	
	}
	

	
	public void Buscar(ActionEvent event) throws IOException{
		
		String dn =dni.getText();
		String ape = ApellidosB.getText();
		String cicl = ciclo.getText(); 
		
        if (dni.getText().isEmpty()==false)
        {
        	
        	
    		data.addAll(uno.BusquedaTutorNIF(dn));
    		Tabla.setItems(uno.BusquedaTutorNIF(dn));
        		
        }
        
        else if (ApellidosB.getText().isEmpty()==false)
        {
        	
        	data.addAll(uno.BusquedaTutorApellidos(ape));
    		Tabla.setItems(uno.BusquedaTutorApellidos(ape));
        }
        
        
        else if (ciclo.getText().isEmpty()==false)
        {
        	data.addAll(uno.BusquedaTutorCiclo(cicl));
    		Tabla.setItems(uno.BusquedaTutorCiclo(cicl));
        }
        
        else {
        	Alert alert = new Alert(AlertType.ERROR); 
            alert.setTitle("Campos Vacios");
            alert.setHeaderText("Debes Seleccionar Un Campo De Búsqueda");
            alert.setContentText("Por favor!!! Seleccione Un Campo De Búsqueda");
            alert.showAndWait();
        }

}
}
