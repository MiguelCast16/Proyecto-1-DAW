package View;

import java.io.IOException;

import Controller.Main;
import Model.Alumno;
import Model.Ciclo;
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

public class ControladorAdmCiclos {
	
	@FXML
	private Button Anadir;
	
	@FXML
	private Button Modificar;
	
	@FXML
	private TableView<Ciclo> Tabla;

	@FXML
	private TableColumn<Ciclo,Integer> Codigo;
	
	@FXML
	private TableColumn<Ciclo,String> Nombre;

	@FXML
	private TableColumn<Ciclo,String> Tipo;
	
	@FXML
	private TableColumn<Ciclo,String> Familia;
	
	@FXML
	private TableColumn<Ciclo,String> ClaveFP;
	
	@FXML
	private TextField Clave;
	
	@FXML
	private TextField FamiliaB;
	
	@FXML
	private TextField TipoB;
	
	@FXML
	private TextField NombreB;
	
	@FXML
	private Button Buscar;
	
	@FXML
	private Button Restablecer;
	
	TestConexion uno = new TestConexion();
	
	private final ObservableList<Ciclo> data = FXCollections.observableArrayList();

	

	
	public void initialize(){
			
			Codigo.setCellValueFactory(new PropertyValueFactory<Ciclo,Integer>("Codigo"));
			Nombre.setCellValueFactory(new PropertyValueFactory<Ciclo,String>("Nombre"));
			Tipo.setCellValueFactory(new PropertyValueFactory<Ciclo,String>("Tipo"));
			Familia.setCellValueFactory(new PropertyValueFactory<Ciclo,String>("Familia_Profesional"));
			ClaveFP.setCellValueFactory(new PropertyValueFactory<Ciclo,String>("Clave_FP"));
			data.addAll(uno.Ciclo());
			Tabla.setItems(uno.Ciclo());
			
			}
		
	
	
	
	public void Anadir(ActionEvent event) throws IOException{
		
		 
		
        FXMLLoader loader = new FXMLLoader(Main.class.getResource("../View/AnadirCiclo.fxml"));
        
        AnchorPane Menu = (AnchorPane)loader.load();
   
        /* Creamos la segunda ventana como otro stage */
        Stage ventanaAC = new Stage();
        ventanaAC.setTitle("IncluirCiclo");
        
        /* Le decimos a la ventana quién es la ventana original */
        Scene scene = new Scene(Menu);
        ventanaAC.setScene(scene);
        ventanaAC.show();
       
   
    
}
	
	public void Modificar(ActionEvent event) throws IOException{
		
		Ciclo selectedItem = Tabla.getSelectionModel().getSelectedItem();
        if (selectedItem != null) {
		 
        FXMLLoader loader = new FXMLLoader(Main.class.getResource("../View/ModificarCiclo.fxml"));
        
        AnchorPane Menu = (AnchorPane)loader.load();
   
        /* Creamos la segunda ventana como otro stage */
        Stage ventanaMC = new Stage();
        ventanaMC.setTitle("ModificarCiclo");
        ControladorModificarCiclo ciclocontroller = loader.getController();
        ciclocontroller.setAlumno(selectedItem);
        /* Le decimos a la ventana quién es la ventana original */
        Scene scene = new Scene(Menu);
        ventanaMC.setScene(scene);
        ventanaMC.show();   
        }
        else {
        	Alert alert = new Alert(AlertType.ERROR); 
            alert.setTitle("No Seleccionado");
            alert.setHeaderText("Persona No seleccionada");
            alert.setContentText("Por favor!!! Seleccione Una Persona De La Tabla");

            alert.showAndWait();
        }

	}
	
	public void Limpiar(ActionEvent event) throws IOException{
		
		data.addAll(uno.Ciclo());
		Tabla.setItems(uno.Ciclo());
	
	}
	

	
	public void Buscar(ActionEvent event) throws IOException{
		
		String clave =Clave.getText();
		String nomb = NombreB.getText();
		String tipo = TipoB.getText(); 
		String familia = FamiliaB.getText();
		
        if (Clave.getText().isEmpty()==false)
        {
        	
        	
    		data.addAll(uno.BusquedaCicloClaVe(clave));
    		Tabla.setItems(uno.BusquedaCicloClaVe(clave));
        		
        }
        
        else if (NombreB.getText().isEmpty()==false)
        {
        	
        	data.addAll(uno.BusquedaCicloNombre(nomb));
    		Tabla.setItems(uno.BusquedaCicloNombre(nomb));
        }
        
        else if (TipoB.getText().isEmpty()==false)
        {
        	data.addAll(uno.BusquedaCicloTipo(tipo));
    		Tabla.setItems(uno.BusquedaCicloTipo(tipo));
        }
        
        else if (FamiliaB.getText().isEmpty()==false)
        {
        	data.addAll(uno.BusquedaCicloFamilia(familia));
    		Tabla.setItems(uno.BusquedaCicloFamilia(familia));
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