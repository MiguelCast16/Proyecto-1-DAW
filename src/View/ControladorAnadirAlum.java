package View;

import Model.TestConexion;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Alert;
import javafx.scene.control.Button;
import javafx.scene.control.TextField;
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
	
	
	public void AnadirA(ActionEvent event) {
	if (NIF.getText().isEmpty() || Nombre.getText().isEmpty() || Apellidos.getText().isEmpty() || Telefono.getText().isEmpty() || Email.getText().isEmpty())
	{	
		Alert alert = new Alert(AlertType.ERROR); 
	    alert.setTitle("Campos Vacios");
	    alert.setHeaderText("Algunos De Los Campos Estan Vacios");
	    alert.setContentText("Por favor!!! Complete todos los datos de la tabla");
	
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
		}
	}
	
	

}
