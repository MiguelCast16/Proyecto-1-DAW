package View;


import Model.Alumno;
import Model.TestConexion;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Alert;
import javafx.scene.control.ChoiceBox;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.TextField;
import javafx.scene.control.Alert.AlertType;
import javafx.scene.control.Button;
import javafx.scene.control.cell.PropertyValueFactory;

public class ControladorCursan {
	
	@FXML
	private ChoiceBox<String> ListaCiclos;
	
	@FXML
	private TextField Curso;
	
	@FXML
	private Button Anadir;
	
	@FXML
	private TableView<Alumno> Tabla;
	
	@FXML
	private TableColumn<Alumno,String> Nombre;
	
	@FXML
	private TableColumn<Alumno,String> Apellidos;
	
	@FXML
	private Button Limpiar;
	
	private final ObservableList<Alumno> data = FXCollections.observableArrayList();
	
	TestConexion uno=new TestConexion();
	
	public void initialize(){
		ListaCiclos.setItems(uno.NombreCiclo());
		Nombre.setCellValueFactory(new PropertyValueFactory<Alumno,String>("Nombre"));
		Apellidos.setCellValueFactory(new PropertyValueFactory<Alumno,String>("Apellidos"));
		data.addAll(uno.Alumno());
		Tabla.setItems(uno.Alumno());	
		
	}
	
	
	public void Incluir(ActionEvent event) {
			
			if (Tabla.getSelectionModel().isEmpty() ||  ListaCiclos.getSelectionModel().isEmpty() || Curso.getText().equals(""))
			{
				Alert alert = new Alert(AlertType.ERROR); 
			    alert.setTitle("Campos Vacios");
			    alert.setHeaderText("Algunos De Los Campos Estan Vacios");
			    alert.setContentText("Por favor!!! Complete Todos Los Datos De La Tabla");
			
			    alert.showAndWait();
			}
				
			else {	
				Alumno selectedItem = Tabla.getSelectionModel().getSelectedItem();
				String nifa = selectedItem.getNIF();	
				String curso = Curso.getText();
				uno.Cursan(nifa, uno.CodigoCurso(ListaCiclos.getSelectionModel().getSelectedItem()), curso);
				Alert alert = new Alert(AlertType.INFORMATION); 
	            alert.setTitle("Alumno Incluido");
	            alert.setHeaderText("Alumno Incluido En Ciclo Correctamente");
	            alert.setContentText("El Insert Se Ha Realizado");
	            alert.showAndWait();
			}
		}


	public void Limpiar(ActionEvent event) {
		
		Curso.setText(null);
		ListaCiclos.setValue(null);
		
	}
	
	
}
	
	
	

