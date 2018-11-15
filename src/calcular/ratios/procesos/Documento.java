package calcular.ratios.procesos;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;

import org.apache.poi.xwpf.converter.pdf.PdfConverter;
import org.apache.poi.xwpf.converter.pdf.PdfOptions;
import org.apache.poi.xwpf.usermodel.XWPFDocument;

import calcular.ratios.modelo.Ratios;
import calcular.ratios.resources.Resources;
import fr.opensagres.xdocreport.core.XDocReportException;
import fr.opensagres.xdocreport.document.IXDocReport;
import fr.opensagres.xdocreport.document.registry.XDocReportRegistry;
import fr.opensagres.xdocreport.template.IContext;
import fr.opensagres.xdocreport.template.TemplateEngineKind;
//import fr.opensagres.xdocreport.template.formatter.FieldsMetadata;

public class Documento {
	
	private static final String FICHERO_DOCX = System.getProperty("java.io.tmpdir") + "archivo.docx";
	private static final String FICHERO_PDF = System.getProperty("user.home") + File.separator + "ratios.pdf";
	
	public static boolean generarWord(Ratios ratiosReuters){
        try {
        	// 1. Cargamos la plantilla
        	InputStream in = Resources.class.getResourceAsStream("plantilla.docx");
			IXDocReport report = XDocReportRegistry.getRegistry().loadReport( in, TemplateEngineKind.Velocity );
			
			// 2. Creamos los metadatos
//			FieldsMetadata metadata = report.createFieldsMetadata();
//			metadata.load( "ratiosReuters", Ratios.class, true );
//			metadata.saveXML(System.out);
//			System.out.println();
			
			// 3. Creamos el modelo Java
			IContext context = report.createContext();
			context.put("ratiosReuters", ratiosReuters);
			
			// 4. Generar el documento word
			System.out.println("Path: " + FICHERO_DOCX);
			OutputStream out = new FileOutputStream(new File(FICHERO_DOCX));
            report.process(context, out);
            return true;
		} catch (IOException | XDocReportException e) {
			e.printStackTrace();
		} catch (Exception e){
			e.printStackTrace();
		}
		return false;
	}
	
	public static boolean generarPdf(){
		try {
			// 1. Cargamos el fichero DOCX
			XWPFDocument document = new XWPFDocument(new FileInputStream(new File(FICHERO_DOCX)));
			
			// 2. Generamos el PDF
			System.out.println("Path: " + FICHERO_PDF);
			OutputStream out = new FileOutputStream(new File(FICHERO_PDF));
            PdfOptions options = PdfOptions.create().fontEncoding("iso-8859-15");
            PdfConverter.getInstance().convert(document, out, options);
            return true;
		} catch (IOException e) {
			e.printStackTrace();
		}
		
		return false;
	}

}
