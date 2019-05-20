package View;

import Model.Ciclo;
import Model.TestConexion;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Alert;
import javafx.scene.control.Button;
import javafx.scene.control.TextField;
import javafx.scene.control.Alert.AlertType;

public class ControladorModificarCiclo {
	
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
	public Button Modificar;
	
	int CodigoViejo; 

	public void setAlumno(Ciclo ciclo) {
		
		int cod = ciclo.getCodigo();
        String arreglo = Integer.toString(cod);
		Codigo.setText(arreglo);
		Nombre.setText(ciclo.getNombre());
		Tipo.setText(ciclo.getTipo());
		Familia.setText(ciclo.getFamilia_Profesional());
		Capacidades.setText(ciclo.getCapacidades());
		Actividades.setText(ciclo.getActividades());
		Criterios.setText(ciclo.getCriterios());
		ClaveFP.setText(ciclo.getClave_FP());
		CodigoViejo=cod;
	}
	
	public void ModificarA(ActionEvent event) {
		if(Codigo.getText().equals("")||Tipo.getText().equals("")||Familia.getText().equals("")||Capacidades.getText().equals("")||Actividades.getText().equals("")||Criterios.getText().equals("")||ClaveFP.getText().equals(""))
			{	
				Alert alert = new Alert(AlertType.ERROR); 
			    alert.setTitle("Campos Vacios");
			    alert.setHeaderText("Algunos De Los Campos Estan Vacios");
			    alert.setContentText("Por favor!!! Complete todos los datos de la tabla");
			
			    alert.showAndWait();
					
			}
		
		else {
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
			uno.ModificarCiclo(codig, nombre, tipo, familia, capacidades, actividades, criterios, clave, CodigoViejo);
			Alert alert = new Alert(AlertType.INFORMATION); 
	        alert.setTitle("Ciclo Modificado");
	        alert.setHeaderText("Datos De Ciclo Modificados Correctamente");
	        alert.setContentText("El Update Se Ha Realizado");
	        alert.showAndWait();
	        Codigo.setText(null);
			Nombre.setText(null);
			Tipo.setText(null);
			Familia.setText(null);
			Capacidades.setText(null);
			Actividades.setText(null);
			Criterios.setText(null);
			ClaveFP.setText(null);
		
	}
	
	
	

}
	}
