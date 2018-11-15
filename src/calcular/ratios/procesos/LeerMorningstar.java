package calcular.ratios.procesos;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.URL;
import java.net.URLConnection;

import org.json.simple.parser.ParseException;

import calcular.ratios.utilidades.Constantes;
import calcular.ratios.utilidades.Utilidades;

public class LeerMorningstar {

	public String ejecutar(String empresa) throws IOException, ParseException {
		String ticker = Utilidades.obtenerTickerMorningstar(empresa);
		String urlStr = Utilidades.getMensaje(Constantes.URL_MORNINGSTAR, ticker);
		System.out.println("URL: " + urlStr);
		URL url = new URL(urlStr);
		URLConnection uc = url.openConnection();
		uc.connect();
		// Creamos el objeto con el que vamos a leer
		BufferedReader in = new BufferedReader(new InputStreamReader(uc.getInputStream()));
		String inputLine;
		StringBuilder contenido = new StringBuilder();
		while ((inputLine = in.readLine()) != null) {
			contenido.append(inputLine + "\n");
		}
		in.close();
		return contenido.toString();
	}

	public static void main(String[] args) {
		LeerReuters lr = new LeerReuters();
		try {
			if (Documento.generarWord(lr.ejecutar("REE"))) {
				Documento.generarPdf();
			}
		} catch (IOException | ParseException e) {
			e.printStackTrace();
		}
	}

}
