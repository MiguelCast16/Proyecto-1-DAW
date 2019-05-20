package View;
import java.io.IOException;
import Controller.Main;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.scene.control.Alert;
import javafx.scene.control.Button;
import javafx.scene.control.PasswordField;
import javafx.scene.control.TextField;
import javafx.scene.control.Alert.AlertType;
import javafx.scene.layout.AnchorPane;
import javafx.stage.Stage;

public class ControladorLogin {

	Main programaPincipal;
	
	@FXML
	private Button Login;
	
	@FXML
	private Button Cerrar;
	
	@FXML
	private TextField Usuario;
	
	@FXML
	private PasswordField Contrasena;
	


		
	public void Login(ActionEvent event) throws IOException, InterruptedException{
		
		String usr=Usuario.getText();
		String pswd=Contrasena.getText();
		 
		if (usr.equals("Admin") && pswd.equals("1234"))
		 {	
		
	         FXMLLoader loader = new FXMLLoader(Main.class.getResource("../View/MenuPrincipal.fxml"));
	         
	         AnchorPane MenuP = (AnchorPane)loader.load();
	    
	         /* Creamos la segunda ventana como otro stage */
	         Stage ventana = new Stage();
	         ventana.setTitle("MenuPrincipal");
	         
	         /* Le decimos a la ventana quién es la ventana original */
	         Scene scene = new Scene(MenuP);
	         ventana.setScene(scene);
	         ventana.show();
	       
	         
		 }
		else {
        	Alert alert = new Alert(AlertType.ERROR); 
            alert.setTitle("ERROR");
            alert.setHeaderText("Error En Los Datos Introducidos");
            alert.setContentText("Por favor!!! Introduzca correctamente usuario y contraseña");
            alert.showAndWait();
            Usuario.setText(null);
            Contrasena.setText(null);
        }
	     
	 }
	
	

	}
	

