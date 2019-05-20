package View;

import Model.Empresa;
import Model.TestConexion;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Alert;
import javafx.scene.control.Button;
import javafx.scene.control.TextField;
import javafx.scene.control.Alert.AlertType;

public class ControladorModificarEmpresa {
	

	
	@FXML
	private Button Modificar;
	
	@FXML
	private TextField Tabla;

	@FXML
	private TextField Num_Convenio;
	
	@FXML
	private TextField CIF;
	
	@FXML
	private TextField Representante;
	
	@FXML
	private TextField NIF_Repre;
	
	@FXML
	private TextField Apellidos;
	
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
	private TextField Centro;
	
	TestConexion uno=new TestConexion();
	
	String Num_ConViejo;


	public void setEmpresa(Empresa empresa) {
		
		Num_Convenio.setText(empresa.getNum_Convenio());
		CIF.setText(empresa.getCIF());
		Representante.setText(empresa.getRepresentante());
		NIF_Repre.setText(empresa.getNIF_Representante());
		Apellidos.setText(empresa.getApellidos_Representante());
		Nombre.setText(empresa.getNombre());
		Pais.setText(empresa.getPais());
		Ciudad.setText(empresa.getCiudad());
		Provincia.setText(empresa.getProvincia());
		Direccion.setText(empresa.getDireccion());
		CP.setText(empresa.getCP());
		int num = empresa.getTelefono();
		String arreglo = Integer.toString(num); 
	    Telefono.setText(arreglo);
	    int num2 = empresa.getFax();
	    String arreglo2 = Integer.toString(num2);
	    FAX.setText(arreglo2);
	    CiudadFirma.setText(empresa.getCiudad_FirmaConvenio());
		Fecha.setText(empresa.getFecha_FirmaConvenio());
		Familia.setText(empresa.getFamilia_Profesional());
		Centro.setText(empresa.getCodigo_Centro());
		Num_ConViejo = Num_Convenio.getText();
	}
	
	public void Modificar(ActionEvent event) {
		if (Num_Convenio.getText().equals("") || CIF.getText().equals("") || Representante.getText().equals("")||NIF_Repre.getText().equals("")||Nombre.getText().equals("")||Pais.getText().equals("")||Ciudad.getText().equals("")||Provincia.getText().equals("")||Direccion.getText().equals("")||CP.getText().equals("")||Telefono.getText().equals("")||FAX.getText().equals("")||CiudadFirma.getText().equals("")||Fecha.getText().equals("")||Familia.getText().equals("")||Centro.getText().equals(""))
			{	
				Alert alert = new Alert(AlertType.ERROR); 
			    alert.setTitle("Campos Vacios");
			    alert.setHeaderText("Algunos De Los Campos Estan Vacios");
			    alert.setContentText("Por favor!!! Complete todos los datos de la tabla");
			
			    alert.showAndWait();
					
				
			}	
			else {
				
				String Num = Num_Convenio.getText();
				String Cif = CIF.getText();
				String Repre = Representante.getText();
				String NifR = NIF_Repre.getText();
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
				String codigo=Centro.getText();
				uno.ModificarEmpresa(Num, Cif, Repre, NifR, ape, nombre, pais, ciudad, provincia, direccion, cp, telefono, fax, ciudadfirma, fecha, familia, codigo, Num_ConViejo);
				Alert alert = new Alert(AlertType.INFORMATION); 
	            alert.setTitle("Empresa Añadida");
	            alert.setHeaderText("Datos De Empresa Introducidos Correctamente");
	            alert.setContentText("El Update Se Ha Realizado");
	            alert.showAndWait();
	            Num_Convenio.setText(null);
	    		CIF.setText(null);
	    		Representante.setText(null);
	    		NIF_Repre.setText(null);
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
	    		Centro.setText(null);	
			}

	}
}

