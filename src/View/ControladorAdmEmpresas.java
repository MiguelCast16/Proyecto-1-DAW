package View;

import java.io.IOException;

import Controller.Main;
import Model.Alumno;
import Model.Empresa;
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

public class ControladorAdmEmpresas {
	
	@FXML
	private Button Anadir;
	
	@FXML
	private Button Modificar;
	
	@FXML
	private Button TutorE;
	
	@FXML
	private TableView<Empresa> Tabla;

	@FXML
	private TableColumn<Empresa,String> Num_Convenio;
	
	@FXML
	private TableColumn<Empresa,String> CIF;
	
	@FXML
	private TableColumn<Empresa,String> Representante;
	
	@FXML
	private TableColumn<Empresa,String> NIF_Representante;
	
	@FXML
	private TableColumn<Empresa,String> Nombre;
	
	@FXML
	private TableColumn<Empresa,String> Ciudad;
	
	@FXML
	private TableColumn<Empresa,String> Provincia;
	
	@FXML
	private TableColumn<Empresa,String> Direccion;
	
	@FXML
	private TableColumn<Empresa,String> CP;
	
	@FXML
	private TableColumn<Empresa,Integer> Telefono;
	
	@FXML
	private TextField Familia;
	
	@FXML
	private TextField CiudadB;
	
	@FXML
	private TextField ProvinciaB;
	
	@FXML
	private TextField NombreB;
	
	@FXML
	private TextField Repre;
	
	@FXML
	private TextField Tutor;
	
	@FXML
	private Button Buscar;
	
	@FXML
	private Button Restablecer;
	
	TestConexion uno = new TestConexion();
	
	private final ObservableList<Empresa> data = FXCollections.observableArrayList();

	public void initialize(){
			
			Num_Convenio.setCellValueFactory(new PropertyValueFactory<Empresa,String>("Num_Convenio"));
			CIF.setCellValueFactory(new PropertyValueFactory<Empresa,String>("CIF"));
			Representante.setCellValueFactory(new PropertyValueFactory<Empresa,String>("Representante"));
			Nombre.setCellValueFactory(new PropertyValueFactory<Empresa,String>("Nombre"));
			Ciudad.setCellValueFactory(new PropertyValueFactory<Empresa,String>("Ciudad"));
			Provincia.setCellValueFactory(new PropertyValueFactory<Empresa,String>("Provincia"));
			Direccion.setCellValueFactory(new PropertyValueFactory<Empresa,String>("Direccion"));
			NIF_Representante.setCellValueFactory(new PropertyValueFactory<Empresa,String>("NIF_Representante"));
			CP.setCellValueFactory(new PropertyValueFactory<Empresa,String>("CP"));
			Telefono.setCellValueFactory(new PropertyValueFactory<Empresa,Integer>("Telefono"));
			data.addAll(uno.Empresa());
			Tabla.setItems(uno.Empresa());
			
			}
	
	
	
	
	public void Anadir(ActionEvent event) throws IOException{
		
		 
        FXMLLoader loader = new FXMLLoader(Main.class.getResource("../View/AnadirEmpresa.fxml"));
        
        AnchorPane Menu = (AnchorPane)loader.load();
   
        /* Creamos la segunda ventana como otro stage */
        Stage ventanaAE = new Stage();
        ventanaAE.setTitle("IncluirEmpresas");
        
        /* Le decimos a la ventana quién es la ventana original */
        Scene scene = new Scene(Menu);
        ventanaAE.setScene(scene);
        ventanaAE.show();
       
   
    
}
	
	public void Modificar(ActionEvent event) throws IOException{
		
		Empresa selectedItem = Tabla.getSelectionModel().getSelectedItem();
        if (selectedItem != null) {
		 
        FXMLLoader loader = new FXMLLoader(Main.class.getResource("../View/ModificarEmpresa.fxml"));
        
        AnchorPane Menu = (AnchorPane)loader.load();
   
        /* Creamos la segunda ventana como otro stage */
        Stage ventanaME = new Stage();
        ventanaME.setTitle("ModificarEmpresa");
        ControladorModificarEmpresa empresacontroller = loader.getController();
        empresacontroller.setEmpresa(selectedItem);
        /* Le decimos a la ventana quién es la ventana original */
        Scene scene = new Scene(Menu);
        ventanaME.setScene(scene);
        ventanaME.show();
        
        }
        else {
        	Alert alert = new Alert(AlertType.ERROR); 
            alert.setTitle("No Seleccionado");
            alert.setHeaderText("Persona No Seleccionada");
            alert.setContentText("Por favor!!! Seleccione Una Persona De La Tabla");

            alert.showAndWait();
        }
        
        }
       

	
	public void TutorE(ActionEvent event) throws IOException{
		
		 
        FXMLLoader loader = new FXMLLoader(Main.class.getResource("../View/AnadirTutorEmpresa.fxml"));
        
        AnchorPane Menu = (AnchorPane)loader.load();
   
        /* Creamos la segunda ventana como otro stage */
        Stage ventanaATE = new Stage();
        ventanaATE.setTitle("IncluirTutorEmpresa");
        
        /* Le decimos a la ventana quién es la ventana original */
        Scene scene = new Scene(Menu);
        ventanaATE.setScene(scene);
        ventanaATE.show();
       
   
    
	}
	
	public void Limpiar(ActionEvent event) throws IOException{
		
		data.addAll(uno.Empresa());
		Tabla.setItems(uno.Empresa());
	
	}
	

	
	public void Buscar(ActionEvent event) throws IOException{
		
		String ciudad =CiudadB.getText();
		String provincia = ProvinciaB.getText();
		String nombre = NombreB.getText(); 
		String familia = Familia.getText();
		String rep = Repre.getText();
		String tutor = Tutor.getText();
		
        if (CiudadB.getText().isEmpty()==false)
        {
        	
        	
    		data.addAll(uno.BusquedaEmpresaCiudad(ciudad));
    		Tabla.setItems(uno.BusquedaEmpresaCiudad(ciudad));
        		
        }
        
        else if (ProvinciaB.getText().isEmpty()==false)
        {
        	
        	data.addAll(uno.BusquedaEmpresaProvincia(provincia));
    		Tabla.setItems(uno.BusquedaEmpresaProvincia(provincia));
        }
        
        else if (NombreB.getText().isEmpty()==false)
        {
        	data.addAll(uno.BusquedaEmpresaNombre(nombre));
    		Tabla.setItems(uno.BusquedaEmpresaNombre(nombre));
        }
        
        else if (Familia.getText().isEmpty()==false)
        {
        	data.addAll(uno.BusquedaEmpresaFamilia(familia));
    		Tabla.setItems(uno.BusquedaEmpresaFamilia(familia));
        }
        
        else if (Repre.getText().isEmpty()==false)
        {
        	data.addAll(uno.BusquedaEmpresaRepre(rep));
        	Tabla.setItems(uno.BusquedaEmpresaRepre(rep));
        }
        
        else if (Tutor.getText().isEmpty()==false)
        {
        	data.addAll(uno.BusquedaEmpresaTutor(tutor));
        	Tabla.setItems(uno.BusquedaEmpresaTutor(tutor));
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
