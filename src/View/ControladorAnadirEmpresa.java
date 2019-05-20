package View;

import Model.TestConexion;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Alert;
import javafx.scene.control.Button;
import javafx.scene.control.ChoiceBox;
import javafx.scene.control.TextField;
import javafx.scene.control.Alert.AlertType;

public class ControladorAnadirEmpresa {
	
	@FXML
	private Button Anadir;
	
	@FXML
	private TextField Num_Convenio;
	
	@FXML
	private TextField CIF;
	
	@FXML
	private TextField Representante;
	
	@FXML
	private TextField NIF_Representante;
	
	@FXML
	private TextField Nombre;
	
	@FXML
	private TextField Pais;
	
	@FXML
	private TextField Ciudad;
	
	@FXML
	private TextField Provincia;
	
	@FXML
	private TextField Direccion;
	
	@FXML
	private TextField CP;
	
	@FXML
	private TextField Telefono;
	
	@FXML
	private TextField FAX;
	
	@FXML
	private TextField CiudadFirma;
	
	@FXML
	private TextField Fecha;
	
	@FXML
	private TextField Familia;
	
	@FXML
	private TextField Apellidos;
	
	@FXML
	ChoiceBox<String> Lista;
	
	TestConexion uno=new TestConexion();
	
	
	public void initialize(){
		Lista.setItems(uno.NombreCentro());
			
	}
	
	
	public void AnadirA(ActionEvent event) {
		if (Num_Convenio.getText().equals("") || CIF.getText().equals("") || Representante.getText().equals("")|| Apellidos.getText().equals("")||NIF_Representante.getText().equals("")||Nombre.getText().equals("")||Pais.getText().equals("")||Ciudad.getText().equals("")||Provincia.getText().equals("")||Direccion.getText().equals("")||CP.getText().equals("")||Telefono.getText().equals("")||FAX.getText().equals("")||CiudadFirma.getText().equals("")||Fecha.getText().equals("")||Familia.getText().equals("")||Lista.getSelectionModel().isEmpty()==true)
			{	
				Alert alert = new Alert(AlertType.ERROR); 
			    alert.setTitle("Campos Vacios");
			    alert.setHeaderText("Algunos De Los Campos Estan Vacios");
			    alert.setContentText("Por favor!!! Complete Todos Los Datos De La Tabla");
			
			    alert.showAndWait();
					
				
			}	
			else {
				
				String Num = Num_Convenio.getText();
				String Cif = CIF.getText();
				String Repre = Representante.getText();
				String NifR = NIF_Representante.getText();
				String ape = Apellidos.getText();
				String nombre = Nombre.getText();
				String pais = Pais.getText();
				String ciudad = Ciudad.getText();
				String provincia = Provincia.getText();
				String direccion = Direccion.getText();
				String cp = CP.getText();
				String numero=Telefono.getText();
				int telefono=Integer.parseInt(numero);
				String numerof = FAX.getText();
				int fax = Integer.parseInt(numerof);
				String ciudadfirma = CiudadFirma.getText();
				String fecha = Fecha.getText();
				String familia = Familia.getText();
				String codigo=Lista.getSelectionModel().getSelectedItem();
				uno.AnadirEmpresa(Num, Cif, Repre, NifR, ape, nombre, pais, ciudad, provincia, direccion, cp, telefono, fax, ciudadfirma, fecha, familia, codigo);
				Alert alert = new Alert(AlertType.INFORMATION); 
	            alert.setTitle("Empresa Añadida");
	            alert.setHeaderText("Datos De Empresa Introducidos Correctamente");
	            alert.setContentText("El Insert Se Ha Realizado");
	            alert.showAndWait();
	            Num_Convenio.setText(null);
	    		CIF.setText(null);
	    		Representante.setText(null);
	    		NIF_Representante.setText(null);
	    		Apellidos.setText(null);
	    		Nombre.setText(null);
	    		Pais.setText(null);
	    		Ciudad.setText(null);
	    		Provincia.setText(null);
	    		Direccion.setText(null);
	    		CP.setText(null);
	    		Telefono.setText(null);
	    		FAX.setText(null);
	    		CiudadFirma.setText(null);
	    		Fecha.setText(null);
	    		Familia.setText(null);
	    		Lista.setValue(null);	
			}
	}
	
	
	public void Limpiar(ActionEvent event) {
		
		Num_Convenio.setText(null);
		CIF.setText(null);
		Representante.setText(null);
		NIF_Representante.setText(null);
		Apellidos.setText(null);
		Nombre.setText(null);
		Pais.setText(null);
		Ciudad.setText(null);
		Provincia.setText(null);
		Direccion.setText(null);
		CP.setText(null);
		Telefono.setText(null);
		FAX.setText(null);
		CiudadFirma.setText(null);
		Fecha.setText(null);
		Familia.setText(null);
		Lista.setValue(null);	
		
		}
	
	

}
