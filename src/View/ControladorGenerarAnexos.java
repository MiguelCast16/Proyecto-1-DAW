package View;

import Model.Alumno;
import Model.TestConexion;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.cell.PropertyValueFactory;

public class ControladorGenerarAnexos {
	
	@FXML
	private Button Generar;
	
	@FXML
	private TableView<Alumno> Tabla;

	@FXML
	private TableColumn<Alumno,String> NIF;

	@FXML
	private TableColumn<Alumno,String> Nombre;
	
	@FXML
	private TableColumn<Alumno,String> Apellidos;
	
	private final ObservableList<Alumno> data = FXCollections.observableArrayList();


	
	
public void initialize(){
		
		NIF.setCellValueFactory(new PropertyValueFactory<Alumno,String>("NIF"));
		Nombre.setCellValueFactory(new PropertyValueFactory<Alumno,String>("Nombre"));
		Apellidos.setCellValueFactory(new PropertyValueFactory<Alumno,String>("Apellidos"));
		TestConexion uno = new TestConexion();
		data.addAll(uno.Alumno());
		Tabla.setItems(uno.Alumno());
		
		}

}
