package View;

import Model.Alumno;
import Model.TestConexion;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Alert;
import javafx.scene.control.Button;
import javafx.scene.control.ChoiceBox;
import javafx.scene.control.Labeled;
import javafx.scene.control.TextField;
import javafx.scene.control.Alert.AlertType;

public class ControladorAnadirTutorEmpresa {
	

	@FXML
	public TextField NIF;
	
	@FXML
	public TextField Nombre;
	
	@FXML
	public TextField Apellidos;
	
	@FXML
	public TextField Telefono;
	
	@FXML
	public TextField Email;
		
	@FXML
	public Button AnadirA;
	
	@FXML
	public Button Limpiar;
	
	@FXML
	ChoiceBox<String> Lista;
	
	TestConexion uno=new TestConexion();
	
	public void initialize(){
		
		Lista.setItems(uno.NombreEmpresa());		
	}
	
	
	
	public void AnadirA(ActionEvent event) {
		
		if (NIF.getText().equals("") || Nombre.getText().equals("") || Apellidos.getText().equals("") || Telefono.getText().equals("") || Email.getText().equals("") || Lista.getSelectionModel().isEmpty()==true)
		{	
			Alert alert = new Alert(AlertType.ERROR); 
		    alert.setTitle("Campos Vacios");
		    alert.setHeaderText("Algunos De Los Campos Estan Vacios");
		    alert.setContentText("Por favor!!! Complete Todos Los Datos De La Tabla");
		
		    alert.showAndWait();
					
		}
		
		else {
		TestConexion uno=new TestConexion();
		String dni= NIF.getText();
		String nombre= Nombre.getText();
		String apellidos=Apellidos.getText();
		String numero=Telefono.getText();
		int telefono=Integer.parseInt(numero);
		String email=Email.getText();
		uno.AnadirTutorPracticas(dni, nombre, apellidos, telefono, email, uno.ConvenioEmpresa(Lista.getSelectionModel().getSelectedItem()));
		Alert alert = new Alert(AlertType.INFORMATION); 
        alert.setTitle("Tutor Añadido");
        alert.setHeaderText("Datos De Tutor Introducidos Correctamente");
        alert.setContentText("El Insert Se Ha Realizado");
        alert.showAndWait();
        NIF.setText(null);
		Nombre.setText(null);
		Apellidos.setText(null);
		Telefono.setText(null);
		Email.setText(null);
		Lista.setValue(null);
	}
	

	}
	
	
	public void Limpiar(ActionEvent event) {
		
		NIF.setText(null);
		Nombre.setText(null);
		Apellidos.setText(null);
		Telefono.setText(null);
		Email.setText(null);
		Lista.setValue(null);
	}
	
	
	

}
