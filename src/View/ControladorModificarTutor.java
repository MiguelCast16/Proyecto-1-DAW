package View;

import Model.TestConexion;
import Model.Tutor;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Alert;
import javafx.scene.control.Button;
import javafx.scene.control.TextField;
import javafx.scene.control.Alert.AlertType;

public class ControladorModificarTutor {
	
	@FXML
	public TextField NIF;
	
	@FXML
	public TextField Nombre;
	
	@FXML
	public TextField Apellidos;
	
	@FXML
	public TextField Email;
	
	@FXML
	public Button Modificar;
	
	String NIFViejo;
	
	
	public void setTutor(Tutor tutor) {
		
		NIF.setText(tutor.getNIF());
        Nombre.setText(tutor.getNombre());
        Apellidos.setText(tutor.getApellidos());
        Email.setText(tutor.getEmail());
        NIFViejo=NIF.getText();
	}
	
public void ModificarA(ActionEvent event) {
		
		if (NIF.getText().equals("") || Nombre.getText().equals("") || Apellidos.getText().equals("") || Email.getText().equals(""))
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
			String email=Email.getText();
			uno.ModificarTutor(dni, nombre, apellidos, email, NIFViejo);
			Alert alert = new Alert(AlertType.INFORMATION); 
            alert.setTitle("Tutor Añadido");
            alert.setHeaderText("Datos De Tutor Introducidos Correctamente");
            alert.setContentText("El Update Se Ha Realizado");
            alert.showAndWait();
            NIF.setText(null);
			Nombre.setText(null);
			Apellidos.setText(null);
			Email.setText(null);
		}
	}

}
