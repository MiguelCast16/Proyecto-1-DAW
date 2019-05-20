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
import javafx.scene.control.Alert;
import javafx.scene.control.Button;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.TextField;
import javafx.scene.control.Alert.AlertType;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.layout.AnchorPane;
import javafx.stage.Stage;

public class ControladorAdmAlumnos {
	
	@FXML
	private Button Anadir;
	
	@FXML
	private Button Modificar;
	
	@FXML
	private Button Incluir;
	
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
	
	@FXML
	private TextField ApellidosB;
	
	@FXML
	private TextField dni;
	
	@FXML
	private TextField ciclo;
	
	@FXML
	private TextField empresa;
	
	@FXML
	private Button Buscar;
	
	@FXML
	private Button Restablecer;
	
	TestConexion uno = new TestConexion();


	

	private final ObservableList<Alumno> data = FXCollections.observableArrayList();
	
	
	public void initialize(){
		
		NIF.setCellValueFactory(new PropertyValueFactory<Alumno,String>("NIF"));
		Nombre.setCellValueFactory(new PropertyValueFactory<Alumno,String>("Nombre"));
		Apellidos.setCellValueFactory(new PropertyValueFactory<Alumno,String>("Apellidos"));
		Telefono.setCellValueFactory(new PropertyValueFactory<Alumno,Integer>("Telefono"));
		Email.setCellValueFactory(new PropertyValueFactory<Alumno,String>("Email"));
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

	public void Limpiar(ActionEvent event) throws IOException{
	
		data.addAll(uno.Alumno());
		Tabla.setItems(uno.Alumno());
	
	}
		
	
	
	public void Modificar(ActionEvent event) throws IOException{
		
		Alumno selectedItem = Tabla.getSelectionModel().getSelectedItem();
        if (selectedItem != null) {
		 
        FXMLLoader loader = new FXMLLoader(Main.class.getResource("../View/ModificarAlumno.fxml"));
        
        AnchorPane Menu = (AnchorPane)loader.load();
   
        /* Creamos la segunda ventana como otro stage */
        Stage ventanaMA = new Stage();
        ventanaMA.setTitle("ModificarAlumnos");
        ControladorModificarAlumno alumnocontroller = loader.getController();
        alumnocontroller.setAlumno(selectedItem);
        /* Le decimos a la ventana quién es la ventana original */
        Scene scene = new Scene(Menu);
        ventanaMA.setScene(scene);
        ventanaMA.show();
       
        }
        else {
        	Alert alert = new Alert(AlertType.ERROR); 
            alert.setTitle("No Seleccionado");
            alert.setHeaderText("Persona No Seleccionada");
            alert.setContentText("Por Favor!!! Seleccione Una Persona De La Tabla");

            alert.showAndWait();
        }
	}
	
	public void Incluir(ActionEvent event) throws IOException{
		
		 
        FXMLLoader loader = new FXMLLoader(Main.class.getResource("../View/Cursan.fxml"));
        
        AnchorPane Menu = (AnchorPane)loader.load();
   
        /* Creamos la segunda ventana como otro stage */
        Stage ventanaIAC = new Stage();
        ventanaIAC.setTitle("AnadirAlCiclo");
        
        /* Le decimos a la ventana quién es la ventana original */
        Scene scene = new Scene(Menu);
        ventanaIAC.setScene(scene);
        ventanaIAC.show();
       
   
    
}
	
	
	public void Buscar(ActionEvent event) throws IOException{
		
		String dn =dni.getText();
		String ape = ApellidosB.getText();
		String cicl = ciclo.getText(); 
		String emp = empresa.getText();
		
        if (dni.getText().isEmpty()==false)
        {
        	
        	
    		data.addAll(uno.BusquedaAlumnosNif(dn));
    		Tabla.setItems(uno.BusquedaAlumnosNif(dn));
        		
        }
        
        else if (ApellidosB.getText().isEmpty()==false)
        {
        	
        	data.addAll(uno.BusquedaAlumnosApellidos(ape));
    		Tabla.setItems(uno.BusquedaAlumnosApellidos(ape));
        }
        
        else if (empresa.getText().isEmpty()==false)
        {
        	data.addAll(uno.BusquedaAlumnosEmpresa(emp));
    		Tabla.setItems(uno.BusquedaAlumnosEmpresa(emp));
        }
        
        else if (ciclo.getText().isEmpty()==false)
        {
        	data.addAll(uno.BusquedaAlumnosCiclo(cicl));
    		Tabla.setItems(uno.BusquedaAlumnosCiclo(cicl));
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


