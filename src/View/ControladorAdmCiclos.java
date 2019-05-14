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
import javafx.scene.control.Button;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
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
	
	private final ObservableList<Ciclo> data = FXCollections.observableArrayList();

	
	public void initialize(){
			
			Codigo.setCellValueFactory(new PropertyValueFactory<Ciclo,Integer>("Codigo"));
			Nombre.setCellValueFactory(new PropertyValueFactory<Ciclo,String>("Nombre"));
			Tipo.setCellValueFactory(new PropertyValueFactory<Ciclo,String>("Tipo"));
			Familia.setCellValueFactory(new PropertyValueFactory<Ciclo,String>("Familia_Profesional"));
			ClaveFP.setCellValueFactory(new PropertyValueFactory<Ciclo,String>("Clave_FP"));
			TestConexion uno = new TestConexion();
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
		
		 
        FXMLLoader loader = new FXMLLoader(Main.class.getResource("../View/ModificarCiclo.fxml"));
        
        AnchorPane Menu = (AnchorPane)loader.load();
   
        /* Creamos la segunda ventana como otro stage */
        Stage ventanaMC = new Stage();
        ventanaMC.setTitle("ModificarCiclo");
        
        /* Le decimos a la ventana quién es la ventana original */
        Scene scene = new Scene(Menu);
        ventanaMC.setScene(scene);
        ventanaMC.show();
       
   
    
}

}
