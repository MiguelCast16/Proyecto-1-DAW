package View;

import Model.Alumno;
import Model.TestConexion;
import Model.Tutor;
import Model.TutorPracticas;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Alert;
import javafx.scene.control.Button;
import javafx.scene.control.ChoiceBox;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.TextField;
import javafx.scene.control.Alert.AlertType;
import javafx.scene.control.cell.PropertyValueFactory;

public class ControladorAsignarPracticas {
	
	
	@FXML
	public TextField FechaInicio;
	
	@FXML
	public TextField FechaFin;
	
	@FXML
	public TextField HorasDia;
	
	@FXML
	public TextField HorasTotales;
	
	@FXML
	public TextField InicioTarde;
		
	@FXML
	public TextField FinTarde;
	
	@FXML
	public TextField FinManana;
		
	@FXML
	public TextField InicioManana;
	
	@FXML
	ChoiceBox<String> Lista;

	@FXML
	public Button Asignar;
	
	@FXML
	private TableView<Alumno> TablaAlumno;
	
	@FXML
	private TableColumn<Alumno,String> Nombre;
	
	@FXML
	private TableColumn<Alumno,String> Apellidos;
	
	@FXML
	private TableView<TutorPracticas> TablaTutorP;
	
	@FXML
	private TableColumn<TutorPracticas,String> NombreTP;
	
	@FXML
	private TableColumn<TutorPracticas,String> ApellidosTP;
	
	@FXML
	private TableView<Tutor> TablaTutor;
	
	@FXML
	private TableColumn<Tutor,String> NombreT;
	
	@FXML
	private TableColumn<Tutor,String> ApellidosT;
	
	private final ObservableList<Alumno> data = FXCollections.observableArrayList();
	
	private final ObservableList<Tutor> data3 = FXCollections.observableArrayList();
	
	private final ObservableList<TutorPracticas> data2 = FXCollections.observableArrayList();



	
	TestConexion uno=new TestConexion();
	
	public void initialize(){
		Lista.setItems(uno.NombreEmpresa());
		
		Nombre.setCellValueFactory(new PropertyValueFactory<Alumno,String>("Nombre"));
		Apellidos.setCellValueFactory(new PropertyValueFactory<Alumno,String>("Apellidos"));
		data.addAll(uno.Alumno());
		TablaAlumno.setItems(uno.Alumno());	
		
		NombreTP.setCellValueFactory(new PropertyValueFactory<TutorPracticas,String>("Nombre"));
		ApellidosTP.setCellValueFactory(new PropertyValueFactory<TutorPracticas,String>("Apellidos"));
		data2.addAll(uno.TutorPracticas());
		TablaTutorP.setItems(uno.TutorPracticas());	
		
		NombreT.setCellValueFactory(new PropertyValueFactory<Tutor,String>("Nombre"));
		ApellidosT.setCellValueFactory(new PropertyValueFactory<Tutor,String>("Apellidos"));
		data3.addAll(uno.Tutor());
		TablaTutor.setItems(uno.Tutor());	
	}
	
	
public void AnadirA(ActionEvent event) {
		
		if (TablaAlumno.getSelectionModel().isEmpty() || TablaTutorP.getSelectionModel().isEmpty() || TablaTutor.getSelectionModel().isEmpty() || Lista.getSelectionModel().isEmpty() || FechaInicio.getText().equals("") || FechaFin.getText().equals("") || HorasDia.getText().equals("") || HorasTotales.getText().equals("") || InicioTarde.getText().equals("") || FinTarde.getText().equals("") || InicioManana.getText().equals("") || FinManana.getText().equals(""))
		{
			Alert alert = new Alert(AlertType.ERROR); 
		    alert.setTitle("Campos Vacios");
		    alert.setHeaderText("Algunos De Los Campos Estan Vacios");
		    alert.setContentText("Por favor!!! Complete Todos Los Datos De La Tabla");
		
		    alert.showAndWait();
		}
			
		else {	
			Alumno selectedItem = TablaAlumno.getSelectionModel().getSelectedItem();
			String nifa = selectedItem.getNIF();
			
			TutorPracticas selectedItem2 = TablaTutorP.getSelectionModel().getSelectedItem();
			String niftp = selectedItem2.getNIF();
			
			Tutor selectedItem3 = TablaTutor.getSelectionModel().getSelectedItem();
			String nift = selectedItem3.getNIF();
			
			String fechai = FechaInicio.getText();
			String fechaf = FechaFin.getText();
			String arreglo = HorasDia.getText();
			int horasd = Integer.parseInt(arreglo);
			String arreglo2 = HorasTotales.getText();
			int horast = Integer.parseInt(arreglo2);
			String HorasTardeI = InicioTarde.getText();
			String HorasTardeF = FinTarde.getText();
			String HorasMananaI = InicioManana.getText();
			String HorasMananaF = FinManana.getText();
			uno.AsignarP(nifa, uno.ConvenioEmpresa(Lista.getSelectionModel().getSelectedItem()), nift, niftp, fechai, fechaf, horasd, horast, HorasTardeI, HorasTardeF, HorasMananaI, HorasMananaF);
			Alert alert = new Alert(AlertType.INFORMATION); 
	        alert.setTitle("Practicas Asignadas");
	        alert.setHeaderText("Datos De Asignación Introducidos Correctamente");
	        alert.setContentText("La Asignacion Se Ha Realizado");
	        alert.showAndWait();
	        FechaInicio.setText(null);
			FechaFin.setText(null);
			HorasDia.setText(null);
			HorasTotales.setText(null);
			InicioTarde.setText(null);
			FinTarde.setText(null);
			InicioManana.setText(null);
			FinManana.setText(null);
			Lista.setValue(null);
		}
	}


	public void Limpiar(ActionEvent event) {
		
		FechaInicio.setText(null);
		FechaFin.setText(null);
		HorasDia.setText(null);
		HorasTotales.setText(null);
		InicioTarde.setText(null);
		FinTarde.setText(null);
		InicioManana.setText(null);
		FinManana.setText(null);
		Lista.setValue(null);
	}

}
