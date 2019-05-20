package View;

import Model.TestConexion;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Alert;
import javafx.scene.control.Button;
import javafx.scene.control.TextField;
import javafx.stage.Stage;
import javafx.scene.control.Alert.AlertType;

public class ControladorAnadirAlum {
	
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
	public Stage ventana;
	
	
	public void AnadirA(ActionEvent event) {
	if (NIF.getText().equals("") || Nombre.getText().equals("") || Apellidos.getText().equals("") || Telefono.getText().equals("") || Email.getText().equals(""))
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
			uno.AnadirAlumno(dni, nombre, apellidos, telefono, email);
			Alert alert = new Alert(AlertType.INFORMATION); 
            alert.setTitle("Alumno Añadido");
            alert.setHeaderText("Datos De Alumno Introducidos Correctamente");
            alert.setContentText("El Insert Se Ha Realizado");
            alert.showAndWait();
            NIF.setText(null);
    		Nombre.setText(null);
    		Apellidos.setText(null);
    		Telefono.setText(null);
    		Email.setText(null);
			}
		}
	
	
	public void Limpiar(ActionEvent event) {
		
		NIF.setText(null);
		Nombre.setText(null);
		Apellidos.setText(null);
		Telefono.setText(null);
		Email.setText(null);
	}
	
	
}
