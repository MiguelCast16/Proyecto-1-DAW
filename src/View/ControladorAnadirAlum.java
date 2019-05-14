package View;

import Model.TestConexion;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.TextField;
import javafx.stage.Stage;

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
	
	private Stage ventana;
	
	public void AnadirA(ActionEvent event) {
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
