package View;

import Model.TestConexion;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.TextField;


public class ControladorAnadirTutor {
	
	@FXML
	public TextField NIF;
	
	@FXML
	public TextField Nombre;
	
	@FXML
	public TextField Apellidos;
	
	@FXML
	public TextField Email;
	
	@FXML
	public Button AnadirA;

	
	public void AnadirA(ActionEvent event) {
		TestConexion uno=new TestConexion();
		String dni= NIF.getText();
		String nombre= Nombre.getText();
		String apellidos=Apellidos.getText();
		String email=Email.getText();
		uno.AnadirTutor(dni, nombre, apellidos, email);
		
	}
	
	

}