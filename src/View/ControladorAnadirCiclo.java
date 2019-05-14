package View;

import Model.TestConexion;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.TextField;


public class ControladorAnadirCiclo {
	
	@FXML
	public TextField Codigo;
	
	@FXML
	public TextField Nombre;
	
	@FXML
	public TextField Tipo;
	
	@FXML
	public TextField Familia;
	
	@FXML
	public TextField Capacidades;
	
	@FXML
	public TextField Actividades;
	
	@FXML
	public TextField Criterios;
	
	@FXML
	public TextField ClaveFP;
	
	@FXML
	public Button AnadirA;

	
	public void AnadirA(ActionEvent event) {
		TestConexion uno=new TestConexion();
		String codigo= Codigo.getText();
		int codig = Integer.parseInt(codigo);
		String nombre= Nombre.getText();
		String tipo=Tipo.getText();
		String familia=Familia.getText();
		String capacidades=Capacidades.getText();
		String actividades=Actividades.getText();
		String criterios=Criterios.getText();
		String clave=ClaveFP.getText();
		uno.AnadirCiclo(codig,nombre,tipo,familia,capacidades,actividades,criterios,clave);
		
	}
	
	

}