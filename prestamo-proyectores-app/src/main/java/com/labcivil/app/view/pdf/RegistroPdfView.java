package com.labcivil.app.view.pdf;

import java.text.DateFormatSymbols;
import java.util.Calendar;
import java.util.Date;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.stereotype.Component;

import com.labcivil.app.models.entity.Registro;
import com.lowagie.text.Chunk;
import com.lowagie.text.Document;
import com.lowagie.text.Element;
import com.lowagie.text.Font;
import com.lowagie.text.Paragraph;
import com.lowagie.text.Phrase;
import com.lowagie.text.pdf.PdfPCell;
import com.lowagie.text.pdf.PdfPTable;
import com.lowagie.text.pdf.PdfWriter;

@Component("registro/ver")
public class RegistroPdfView extends AbstractPdfView2 {
	
	Font ffont = new Font(Font.UNDEFINED, 12f, Font.BOLD);
	Font ffont1 = new Font(Font.UNDEFINED, 10f, Font.BOLD);
	Font ffont2 = new Font(Font.UNDEFINED, 8f, Font.BOLD);
	Font ffont3 = new Font(Font.UNDEFINED, 11f, Font.BOLD);
	Font ffont4 = new Font(Font.UNDEFINED, 9f);
	Font ffont5 = new Font(Font.UNDEFINED, 11f);
    
	public String getMonth(int month) {
        return new DateFormatSymbols().getMonths() [month];
    }

	@Override
	protected void buildPdfDocument(Map<String, Object> model, Document document, PdfWriter writer,
			HttpServletRequest request, HttpServletResponse response) throws Exception {
		
		document.addTitle("CARTA DE COMPROMISO");
		
		Registro registro = (Registro) model.get("registro");
		
		Paragraph paragraph = new Paragraph();		 
		// Agregar un titulo con su respectiva fuente
		paragraph.add(new Phrase("Carta de Compromiso", ffont));
		paragraph.setAlignment(Element.ALIGN_CENTER);		 
		paragraph.add(new Phrase(Chunk.NEWLINE));
		paragraph.add(new Phrase(Chunk.NEWLINE));
		paragraph.add(new Phrase(Chunk.NEWLINE));
		
		Date fr = registro.getCreateRe();
//		System.out.println("Date: " + fr);
		
	    Calendar calendar = Calendar.getInstance();
	    calendar.setTime(fr);
	    		
		Paragraph paragraph1 = new Paragraph();		
		paragraph1.add(new Phrase("Quito, "+ calendar.get(Calendar.DAY_OF_MONTH)+" de "+getMonth(calendar.get(Calendar.MONTH))+" de "+calendar.get(Calendar.YEAR)));
		paragraph1.setAlignment(Element.ALIGN_JUSTIFIED);
		paragraph1.add(new Phrase(Chunk.NEWLINE));
		paragraph1.add(new Phrase(Chunk.NEWLINE));
		paragraph1.add(new Phrase(Chunk.NEWLINE));
		paragraph1.add(new Phrase("NATALI LASCANO", ffont1));
		paragraph1.add(new Phrase(Chunk.NEWLINE));
		paragraph1.add(new Phrase("RESPONSABLE DE LOS BIENES DEL LABORATORIO DE C�MPUTO DE INGENIER�A CIVIL", ffont1));
		paragraph1.add(new Phrase(Chunk.NEWLINE));
		paragraph1.add(new Phrase(Chunk.NEWLINE));		
//		paragraph1.add(new Phrase(Chunk.NEWLINE));
		
		Paragraph paragraph2 = new Paragraph();	
		paragraph2.add("Yo ");
		paragraph2.add(new Phrase(registro.getProfesor().getNombre()+" "+registro.getProfesor().getApellido(),ffont3));
		paragraph2.add(", con documento de Identidad n�mero ");
		paragraph2.add(new Phrase(registro.getProfesor().getCedula(),ffont3));
		paragraph2.add(", docente de la Facultad de Ingenier�a, Ciencias F�sicas y Matem�tica de la Carrera de "
				+ "Ingenier�a Civil declaro mediante esta carta que; me comprometo a respetar el reglamento para "
				+ "el uso del equipo de c�mputo; y, de igual manera declaro que asumo la responsabilidad del "
				+ "correcto uso del equipo, en caso de surgir cualquier tipo de da�o responder� con mis propios "
				+ "bienes hasta solucionar la reparaci�n o reposici�n del equipo y componentes facilitados.");	
		paragraph2.setAlignment(Element.ALIGN_JUSTIFIED);
		paragraph2.add(new Phrase(Chunk.NEWLINE));
		paragraph2.add(new Phrase(Chunk.NEWLINE));
		paragraph2.add("En el caso de contar con un estudiante que apoye en la materia a mi cargo, me permito incluir,"
				+ " los datos correspondientes, quien asume la responsabilidad del correcto uso del equipo, respetar "
				+ "los reglamentos para uso del equipo y ser� la �nica persona autorizada para el retiro y entrega "
				+ "del equipo facilitado para el desarrollo de la c�tedra, detallo la informaci�n del horario en el "
				+ "que voy hacer uso del equipo de c�mputo dentro del per�odo acad�mico vigente de clases");
		paragraph2.add(new Phrase(Chunk.NEWLINE));
		paragraph2.add(new Phrase(Chunk.NEWLINE));
		document.add(paragraph);
		document.add(paragraph1);
		document.add(paragraph2);

		PdfPTable tabla = new PdfPTable(6);
		tabla.setWidths(new float [] {3.2f, 1.7f, 1.6f, 1.2f, 1.2f, 2.4f});
		tabla.setWidthPercentage(100);
		tabla.setSpacingBefore(12);
		tabla.setSpacingAfter(12);
		
		PdfPCell cell = null;	
		
		cell = new PdfPCell(new Phrase("NOMBRE AYUDANTE", ffont2));
//		cell.setBackgroundColor(new Color(184, 218, 255));
		cell.setHorizontalAlignment(PdfPCell.ALIGN_CENTER);
		tabla.addCell(cell);
		cell = new PdfPCell(new Phrase("CEDULA", ffont2));
		cell.setHorizontalAlignment(PdfPCell.ALIGN_CENTER);
		tabla.addCell(cell);
		cell = new PdfPCell(new Phrase("MATERIA", ffont2));
		cell.setHorizontalAlignment(PdfPCell.ALIGN_CENTER);
		tabla.addCell(cell);
		cell = new PdfPCell(new Phrase("SEMESTRE", ffont2));
		cell.setHorizontalAlignment(PdfPCell.ALIGN_CENTER);
		tabla.addCell(cell);
		cell = new PdfPCell(new Phrase("PARALELO", ffont2));
		cell.setHorizontalAlignment(PdfPCell.ALIGN_CENTER);
		tabla.addCell(cell);
		cell = new PdfPCell(new Phrase("HORARIO", ffont2));
		cell.setHorizontalAlignment(PdfPCell.ALIGN_CENTER);
		tabla.addCell(cell);
		
		cell = new PdfPCell(new Phrase(registro.getEstudiante().getNombre()+" "+registro.getEstudiante().getApellido(),ffont5));
		cell.setHorizontalAlignment(PdfPCell.ALIGN_CENTER);
		tabla.addCell(cell);
//		tabla.addCell(registro.getEstudiante().getNombre()+" "+registro.getEstudiante().getApellido());
		cell = new PdfPCell(new Phrase(registro.getEstudiante().getCedula(),ffont5));
		cell.setHorizontalAlignment(PdfPCell.ALIGN_CENTER);
		tabla.addCell(cell);
//		tabla.addCell(registro.getEstudiante().getCedula());
		cell = new PdfPCell(new Phrase(registro.getMateria().getNombre(),ffont5));
		cell.setHorizontalAlignment(PdfPCell.ALIGN_CENTER);
		tabla.addCell(cell);
//		tabla.addCell(registro.getMateria().getNombre());
		cell = new PdfPCell(new Phrase(Integer.toString(registro.getMateria().getSemestre()),ffont5));
		cell.setHorizontalAlignment(PdfPCell.ALIGN_CENTER);
		tabla.addCell(cell);
//		tabla.addCell(registro.getMateria().getSemestre());
		cell = new PdfPCell(new Phrase(Integer.toString(registro.getMateria().getParalelo()),ffont5));
		cell.setHorizontalAlignment(PdfPCell.ALIGN_CENTER);
		tabla.addCell(cell);
//		tabla.addCell("");
		cell = new PdfPCell(new Phrase(registro.getHorario(),ffont5));
		cell.setHorizontalAlignment(PdfPCell.ALIGN_CENTER);
		tabla.addCell(cell);
		
		for (int i = 0; i < 4; i++) {
			cell = new PdfPCell(new Phrase(""));
			cell.setPadding(9f);
			tabla.addCell(cell);
			tabla.addCell("");
			tabla.addCell("");
			tabla.addCell("");
			tabla.addCell("");		
			tabla.addCell("");
		}
		
		document.add(tabla);

		Paragraph paragraph3 = new Paragraph();	
		if(registro.getObservacion()== null) {
			paragraph3.add(new Phrase("Observaci�n: "));
		}else {
			paragraph3.add(new Phrase("Observaci�n: "+registro.getObservacion()));
		}		
		paragraph3.setAlignment(Element.ALIGN_JUSTIFIED);
		paragraph3.add(new Phrase(Chunk.NEWLINE));
		paragraph3.add(new Phrase(Chunk.NEWLINE));
		paragraph3.add(new Phrase(Chunk.NEWLINE));
		paragraph3.add("Atentamente,");
		paragraph3.add(new Phrase(Chunk.NEWLINE));
		paragraph3.add(new Phrase(Chunk.NEWLINE));
		paragraph3.add(new Phrase(Chunk.NEWLINE));
		paragraph3.add(new Phrase(Chunk.NEWLINE));
		paragraph3.add(new Phrase(Chunk.NEWLINE));
		
		
		Paragraph paragraph4 = new Paragraph();	
		paragraph4.add(new Phrase("                     CI: "+registro.getProfesor().getCedula()+"    	                   	"
				+ "																											"
				+ "           																								"
				+ "               						                                             "
				+ "															  CI: "+registro.getEstudiante().getCedula()+"\n"
				+ "                                                                                   						"
				+ "               						                "
				+ "                            						Cel: "+registro.getEstudiante().getTelefono()+"\n",ffont4));				
		paragraph4.setAlignment(Element.ALIGN_JUSTIFIED);
		
		Paragraph paragraph5 = new Paragraph();
		paragraph4.add(new Phrase("                 DOCENTE DE LA FICFM                                                 "
				+ "                                            ESTUDIANTE DE LA FICFM"+"\n"
				+ "             CARRERA DE INGENIERIA CIVIL                                            "
				+ "                                    CARRERA DE INGENIERIA CIVIL",ffont2));
		
		document.add(paragraph3);
		document.add(paragraph4);
		document.add(paragraph5);

//		tabla.addCell(registro.getObservacion());
//		tabla.addCell(registro.getCreateRe().toString());
		
//		PdfPTable tabla2 = new PdfPTable(1);
//		tabla2.setSpacingAfter(20);
//		
//		cell = new PdfPCell(new Phrase("Datos del Estudiante"));
//		cell.setBackgroundColor(new Color(195, 230, 203));
//		cell.setPadding(8f);		
//		tabla2.addCell(cell);
//		
//		tabla2.addCell(registro.getEstudiante().getNombre()+" "+registro.getEstudiante().getApellido());
//		tabla2.addCell(registro.getEstudiante().getEmail());
//		tabla2.addCell(registro.getEstudiante().getCedula());
//		
//		PdfPTable tabla3 = new PdfPTable(1);
//		tabla3.setSpacingAfter(20);
//		
//		cell = new PdfPCell(new Phrase("Datos del Profesor"));
//		cell.setBackgroundColor(new Color(195, 230, 203));
//		cell.setPadding(8f);		
//		tabla3.addCell(cell);
//		
//		tabla3.addCell(registro.getProfesor().getNombre()+" "+registro.getProfesor().getApellido());
//		tabla3.addCell(registro.getProfesor().getEmail());
//	
//		PdfPTable tabla4 = new PdfPTable(1);
//		tabla4.setSpacingAfter(20);
//		
//		cell = new PdfPCell(new Phrase("Datos de la Materia"));
//		cell.setBackgroundColor(new Color(195, 230, 203));
//		cell.setPadding(8f);		
//		tabla4.addCell(cell);
//
//		tabla4.addCell("Materia: " + registro.getMateria().getNombre());
//		tabla4.addCell("Semestre: " + registro.getMateria().getSemestre());
		
//		document.add(tabla2);
//		document.add(tabla3);
//		document.add(tabla4);
	}

}
