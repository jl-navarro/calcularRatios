package calcular.ratios.procesos;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.URL;
import java.net.URLConnection;

import org.json.simple.parser.ParseException;

import calcular.ratios.modelo.Ratios;
import calcular.ratios.utilidades.Constantes;
import calcular.ratios.utilidades.Utilidades;

public class LeerReuters {
	
	public Ratios ejecutar(String empresa) throws IOException, ParseException{
		String ticker = Utilidades.obtenerTickerReuters(empresa);
		String urlStr = Utilidades.getMensaje(Constantes.URL_REUTERS, ticker);
		System.out.println("URL: " + urlStr);
		Ratios ratios = new Ratios();
		ratios.setEmpresa(Utilidades.obtenerEmpresa(empresa));
		URL url = new URL(urlStr);
	    URLConnection uc = url.openConnection();
	    uc.connect();
	    //Creamos el objeto con el que vamos a leer
	    BufferedReader in = new BufferedReader(new InputStreamReader(uc.getInputStream()));
	    String inputLine;
	    while ((inputLine = in.readLine()) != null) {
	    	if(inputLine.contains(Constantes.PER_REUTERS)){
	    		ratios.setPer(obtenerRatio(in, inputLine));
	    	} else if(inputLine.contains(Constantes.BETA_REUTERS)){
	    		ratios.setBeta(obtenerRatio(in, inputLine));
	    	} else if(inputLine.contains(Constantes.RENTABILIDAD_DIVIDENDO_RETUERS)){
	    		ratios.setRentabilidadDividendo(obtenerRatio(in, inputLine));
	    	} else if(inputLine.contains(Constantes.CRECIMIENTO_DIVIDENDO_REUTERS)){
	    		ratios.setCrecimientoDividendo(obtenerRatio(in, inputLine));
	    	} else if(inputLine.contains(Constantes.QUICK_RATIO_REUTERS)){
	    		ratios.setQuickRatio(obtenerRatio(in, inputLine));
	    	} else if(inputLine.contains(Constantes.CURRENT_RATIO_REUTERS)){
	    		ratios.setCurrentRatio(obtenerRatio(in, inputLine));
	    	} else if(inputLine.contains(Constantes.DEBT_EQUITY_REUTERS)){
	    		ratios.setDebtEquity(obtenerRatio(in, inputLine));
	    	} else if(inputLine.contains(Constantes.ROA_REUTERS)){
	    		ratios.setRoa(obtenerRatio(in, inputLine));
	    	} else if(inputLine.contains(Constantes.ROE_REUTERS)){
	    		ratios.setRoe(obtenerRatio(in, inputLine));
	    	}
	    }
	    in.close();
	    return ratios;
	}
	
	private Double obtenerRatio(BufferedReader in, String linea) throws IOException{
		linea = in.readLine();
		String valor = linea.substring(linea.indexOf('>') + 1, linea.lastIndexOf('<'));
		if("--".equals(valor)){
			return null;
		} else {
			return Double.parseDouble(valor);
		}
	}
}
