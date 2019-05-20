package Model;

import java.io.FileNotFoundException;
import java.io.FileOutputStream;

import com.itextpdf.text.Chunk;
import com.itextpdf.text.Document;
import com.itextpdf.text.DocumentException;
import com.itextpdf.text.Element;
import com.itextpdf.text.Font;
import com.itextpdf.text.FontFactory;
import com.itextpdf.text.Image;
import com.itextpdf.text.Paragraph;
import com.itextpdf.text.pdf.PdfPTable;
import com.itextpdf.text.pdf.PdfWriter;

public class AnexoII {
	
	DatosSelectAnexo2 datos;




	public AnexoII(DatosSelectAnexo2 datos) {
		this.datos=datos;


	}

	/* Este método generará el PDF del AnexoII con los datos que se han pasado al constructor
	 * recibirá como parámentro el nombre del archivo y la ruta donde se ha de almacenar, si estos parámetros están vacíos
	 * generará uno con AnexoI.pdf
	 */
	public void generarAnexoII(String filename, String filepath) throws FileNotFoundException, DocumentException {
		String sFileNamePath = "";

		if(!filepath.equals(""))
			sFileNamePath = filepath;

		if(filename.equals(""))
			sFileNamePath += "AnexoII";
		else
			sFileNamePath += filename;

		sFileNamePath += ".pdf";

		// Se crea el documento
		Document documento = new Document();


		// Se crea el OutputStream para el fichero donde queremos dejar el pdf.
		FileOutputStream ficheroPdf = new FileOutputStream(sFileNamePath);

		// Se asocia el documento al OutputStream y se indica que el espaciado entre
		// lineas sera de 20. Esta llamada debe hacerse antes de abrir el documento
		PdfWriter.getInstance(documento,ficheroPdf).setInitialLeading(20);

		// Se abre el documento.
		documento.open();

		try
		{
			Image foto = Image.getInstance("src/Model/CAM.jpg");
			foto.scaleToFit(100, 100);
			foto.setAlignment(Chunk.ALIGN_LEFT);
			documento.add(foto);
		}
		catch ( Exception e )
		{
			System.out.println(e.getMessage());
		}

		Paragraph p1 = new Paragraph("Anexo 2.1 \n MÓDULO DE FORMACIÓN EN CENTROS DE TRABAJO ",
		FontFactory.getFont("arial",   // fuente
		11,                            // tamaño
		Font.BOLD));
		p1.setAlignment(Element.ALIGN_CENTER);
		documento.add(p1);

		Paragraph p2 = new Paragraph("\n\nRelación de Alumnos (1)               Dirección del Área Territorial de MADRID " + this.datos.getDAT(),
						FontFactory.getFont("arial",   // fuente
						11,                            // tamaño
						Font.BOLDITALIC));
		p2.setAlignment(Element.ALIGN_CENTER);
		documento.add(p2);

		Paragraph p3 = new Paragraph("\n\nNº del CONVENIO         Nº del Anexo 2.1 \n...............         ................",
						FontFactory.getFont("arial",   // fuente
						11,
						Font.BOLD));
		p3.setAlignment(Element.ALIGN_CENTER);
		documento.add(p3);


		Paragraph p4 = new Paragraph("\nRelación de alumnos acogidos al CONVENIO  Nº " + datos.getNum_Convenio() + " suscrito con fecha "+datos.getFecha_Firma()+ " entre el Centro Educativo " + datos.getNombreCentro() + " y la Empresa " + datos.getNombreEmpresa() + " , que realizarán el módulo de Formación en Centros de Trabajo (FCT) o Prácticas Formativas en el período abajo indicado." ,
		FontFactory.getFont("arial",   // fuente
				10,                            // tamaño
						Font.NORMAL));

		documento.add(p4);

				Paragraph p5 = new Paragraph("\nCURSO ACADÉMICO: " + datos.getAñoCurso() +"\nCLAVE: " + datos.getClaveFp() + " CICLO FORMATIVO: " + datos.getNombreCiclo() + "\nOTRAS ENSEÑANZAS: ………………..…………………………………………..………………………………………………………… ",
						FontFactory.getFont("arial",   // fuente
						9));

				documento.add(p5);

				Paragraph p6 = new Paragraph("\n Fecha de inicio:  " + datos.getFechaInicio() + "  Fecha de terminación:  " + datos.getFechaFin() + "  Días de la semana  " + 7,
						FontFactory.getFont("arial",   // fuente
						9));

				documento.add(p6);
				Paragraph p7 = new Paragraph("\n\n            Horario de mañana                                                    Horario de tarde                                     Horas día:         Total Horas:",
						FontFactory.getFont("arial",   // fuente
						9));

				documento.add(p7);


				Paragraph p8 = new Paragraph("\nHora inicio: " + datos.getHora_MañanaInicio() + " Hora terminación: " + datos.getHora_MañanaFin()+"    Hora de inicio: " + datos.getHora_TardeInicio() + " Hora de terminación: " + datos.getHora_TardeFin() + "             " + datos.getHorasdia() +  "                      " + datos.getHorastotal(),
						FontFactory.getFont("arial",   // fuente
						10));
				documento.add(p8);

				Paragraph p9 = new Paragraph("\n\nLOCALIDAD DEL CENTRO DE TRABAJO: " + datos.getCiudadempresa() + "  DIRECCIÓN:" + datos.getDireccionempresa() + "\n\n",
						FontFactory.getFont("arial",   // fuente
						9));
				
				documento.add(p9);

				PdfPTable tabla = new PdfPTable(2);
				tabla.addCell("APELLIDOS y Nombre " );
				tabla.addCell("DNI " );
				tabla.addCell(datos.getApellidosAlumno() + " , " + datos.getNombreAlumno());
				tabla.addCell(datos.getNIF_Alumno());
				for (int i = 0; i < 10; i++)
				{
					tabla.addCell(" ");
				}
				documento.add(tabla);

				Paragraph p10 = new Paragraph("\nEn cumplimiento de la cláusula tercera del CONVENIO, se procede a designar Profesor-Tutor del Centro Educativo a D." + datos.getNombreTutor() + " " + datos.getApellidosTutor()+ " con NIF " + datos.getNIF_Tutor() +  " y Tutor del centro de trabajo a D." + datos.getNombre_TutorEmpresa() + " " + datos.getNIF_TutorEmpresa(),
						FontFactory.getFont("arial",   // fuente
						9));

				documento.add(p10);


				Paragraph p15 = new Paragraph("\n\n\nEn                                                           a               de                                               de      \nEL TITULAR DEL CENTRO                                                                     EL REPRESENTANTE  DE LA EMPRESA\n\n\n\n\nFdo.:                                                                     Fdo.:",
						FontFactory.getFont("arial",   // fuente
						9));
				documento.add(p15);

				documento.close();


	}

}

