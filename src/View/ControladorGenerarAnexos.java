package View;

import java.io.FileNotFoundException;
import java.io.IOException;
import java.sql.SQLException;

import com.itextpdf.text.DocumentException;


import Model.Alumno;
import Model.AnexoI;
import Model.AnexoII;
import Model.Centro;
import Model.DatosSelectAnexo2;
import Model.Empresa;
import Model.TestConexion;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.scene.control.Alert;
import javafx.scene.control.Button;
import javafx.scene.control.CheckBox;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.Alert.AlertType;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.layout.AnchorPane;
import javafx.stage.Stage;

public class ControladorGenerarAnexos {
	

	@FXML
	private Button Generar;
	
	@FXML
	private TableView<Alumno> Tabla;

	@FXML
	private TableColumn<Alumno,String> NIF;

	@FXML
	private TableColumn<Alumno,String> Nombre;
	
	@FXML
	private TableColumn<Alumno,String> Apellidos;
		
	@FXML
	private CheckBox Anexo1;
	
	@FXML
	private CheckBox Anexo2;
	
	@FXML
	private CheckBox Anexo3;
	
	
	
	
	private final ObservableList<Alumno> data = FXCollections.observableArrayList();
	
	private final ObservableList<Empresa> data2 = FXCollections.observableArrayList();
	
	private final ObservableList<Centro> data3 = FXCollections.observableArrayList();
	
	private final ObservableList<DatosSelectAnexo2> data4 = FXCollections.observableArrayList();



	TestConexion uno = new TestConexion();
	

	
	public void initialize(){
			
			NIF.setCellValueFactory(new PropertyValueFactory<Alumno,String>("NIF"));
			Nombre.setCellValueFactory(new PropertyValueFactory<Alumno,String>("Nombre"));
			Apellidos.setCellValueFactory(new PropertyValueFactory<Alumno,String>("Apellidos"));
			data.addAll(uno.Alumno());
			Tabla.setItems(uno.Alumno());
			Alert alert = new Alert(AlertType.WARNING); 
            alert.setTitle("Aviso Para Navegantes");
            alert.setHeaderText("RECUERDA!!!!");
            alert.setContentText("Recuerda que para la generación de anexos la empresa debe tener asignado un tutor y el alumno debe haber sido inlcuido en un ciclo ");

            alert.showAndWait();
	}
	



	
	
	public void Generar(ActionEvent event) throws IOException, DocumentException, FileNotFoundException {
		Alumno a = Tabla.getSelectionModel().getSelectedItem();
		if (Anexo1.isSelected()==true && Anexo2.isSelected()==false)
		{
			
			Alumno selectedItems = Tabla.getSelectionModel().getSelectedItem();
			String num = selectedItems.getNIF();
			data2.addAll(uno.DatosEmpresa(num));
			data3.addAll(uno.DatosCentro());
			AnexoI anexoI = new AnexoI(data3.get(0),data2.get(0));
			anexoI.generarAnexoI("","");
			Alert alert = new Alert(AlertType.INFORMATION); 
            alert.setTitle("Anexo Nº1 Generado");
            alert.setHeaderText("Datos Introducidos Correctamente Al Anexo Nº1");
            alert.setContentText("El Anexo Se Ha Generado");
            alert.showAndWait();

		}
		
		else if (Anexo2.isSelected()==true && Anexo1.isSelected()==false)
		{
			Alumno selectedItems = Tabla.getSelectionModel().getSelectedItem();
			String num = selectedItems.getNIF();
			data4.addAll(uno.GenerarAnexo2(num));
			AnexoII anexoII = new AnexoII(data4.get(0));
			anexoII.generarAnexoII("", "");
			Alert alert = new Alert(AlertType.INFORMATION); 
            alert.setTitle("Anexo Nº2 Generado");
            alert.setHeaderText("Datos Introducidos Correctamente Al Anexo Nº2");
            alert.setContentText("El Anexo Se Ha Generado");
            alert.showAndWait();
		}
		else if (Anexo1.isSelected()==true && Anexo2.isSelected()==true)
		{
			Alumno selectedItems = Tabla.getSelectionModel().getSelectedItem();
			String num = selectedItems.getNIF();
			data2.addAll(uno.DatosEmpresa(num));
			data3.addAll(uno.DatosCentro());
			AnexoI anexoI = new AnexoI(data3.get(0),data2.get(0));
			anexoI.generarAnexoI("","");	
			data4.addAll(uno.GenerarAnexo2(num));
			AnexoII anexoII = new AnexoII(data4.get(0));
			anexoII.generarAnexoII("", "");
			Alert alert = new Alert(AlertType.INFORMATION); 
            alert.setTitle("Anexo Nº1, Nº2 Generados");
            alert.setHeaderText("Datos Introducidos Correctamente En Los Anexos");
            alert.setContentText("Los Anexos Se Han Generado");
            alert.showAndWait();
			
		}
		
		else if (Anexo1.isSelected()==false && Anexo2.isSelected()==false)
		{
			Alert alert = new Alert(AlertType.ERROR); 
            alert.setTitle("No Seleccionado");
            alert.setHeaderText("Anexos No Seleccionados");
            alert.setContentText("Por favor!!! Seleccione Al Menos Un Anexo");

            alert.showAndWait();
		}
		if (a==null)
		{
			Alert alert = new Alert(AlertType.ERROR); 
            alert.setTitle("No Seleccionado");
            alert.setHeaderText("Persona No Seleccionada");
            alert.setContentText("Por Favor!!! Seleccione Una Persona De La Tabla");

            alert.showAndWait();
		}
			
   
    
	}
	
	

	
	

}
