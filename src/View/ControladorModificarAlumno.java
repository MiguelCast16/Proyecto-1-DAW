package View;

import java.io.IOException;

import Model.Alumno;
import Model.TestConexion;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Alert;
import javafx.scene.control.Button;
import javafx.scene.control.TextField;
import javafx.stage.Stage;
import javafx.scene.control.Alert.AlertType;

public class ControladorModificarAlumno {
	

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
	public Button Modificar;
	

	

	

	
	String NIFViejo;
	
	
	
	
		
	public void setAlumno(Alumno alumno) {
		
		NIF.setText(alumno.getNIF());
        Nombre.setText(alumno.getNombre());
        Apellidos.setText(alumno.getApellidos());
        int num = alumno.getTelefono();
        String arreglo = Integer.toString(num); 
        Telefono.setText(arreglo);
        Email.setText(alumno.getEmail());
        NIFViejo=NIF.getText();
	
	}
	
	


	
	
	public void ModificarA(ActionEvent event) throws IOException {
		if (NIF.getText().equals("") || Nombre.getText().equals("") || Apellidos.getText().equals("") || Telefono.getText().equals("") || Email.getText().equals(""))
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
				uno.ModificarAlumno(dni, nombre, apellidos, telefono, email, NIFViejo);
				Alert alert = new Alert(AlertType.INFORMATION); 
		        alert.setTitle("Alumno Modificado");
		        alert.setHeaderText("Datos De Alumno Modificados Correctamente");
		        alert.setContentText("El Update Se Ha Realizado");
		        alert.showAndWait();
		        NIF.setText(null);
	    		Nombre.setText(null);
	    		Apellidos.setText(null);
	    		Telefono.setText(null);
	    		Email.setText(null);

			}
		}
	
	
	
	


		
		
    }
	


