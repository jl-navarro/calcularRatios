package calcular.ratios.utilidades;

import java.io.IOException;
import java.io.InputStreamReader;

import org.json.simple.JSONArray;
import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;
import org.json.simple.parser.ParseException;

import calcular.ratios.resources.Resources;

public class Utilidades {
	
	private Utilidades(){
		
	}
	
	/**
	 * Obtiene el mensaje completo.
	 * @param mensaje Mensaje parametrizado.
	 * @param parametros Valores por los que hay que sustituir los parámetros.
	 * @return Devuelve el mensaje completo.
	 */
	public static String getMensaje(String mensaje, String... parametros){
		if(mensaje == null || mensaje.isEmpty() || parametros == null || parametros.length == 0){
			return mensaje;
		}
		String msg = mensaje;
		for(int i=0; i<parametros.length; i++){
			msg = msg.replaceAll("\\{" +i +"\\}", parametros[i]);
		}
		return msg;
	}
	
	/**
	 * Obtiene el ticker de la empresa para la web de morningstar.
	 * @param empresa Nombre de la empresa.
	 * @return Devuelve el ticker de la empresa.
	 * @throws IOException
	 * @throws ParseException
	 */
	public static String obtenerTickerMorningstar(String empresa) throws IOException, ParseException{
		return obtenerTicker(empresa, "ms");
	}
	
	/**
	 * Obtiene el ticker de la empresa para la web de reuters.
	 * @param empresa Nombre de la empresa.
	 * @return Devuelve el ticker de la empresa.
	 * @throws IOException
	 * @throws ParseException
	 */
	public static String obtenerTickerReuters(String empresa) throws IOException, ParseException{
		return obtenerTicker(empresa, "reuters");
	}
	
	/*
	 * Obtiene el ticker de la empresa.
	 * @param empresa Ticker de la empresa.
	 * @param web Web a la que se va a tirar la petición.
	 * @return Devuelve el ticker de la empresa.
	 * @throws IOException
	 * @throws ParseException
	 */
	private static String obtenerTicker(String ticker, String web) throws IOException, ParseException{
		JSONParser parser = new JSONParser();
		JSONArray empresas = (JSONArray) parser.parse(new InputStreamReader(Resources.class.getResourceAsStream("empresas.json")));
		for(int i=0; i<empresas.size(); i++){
			JSONObject obj = (JSONObject) empresas.get(i);
			if(ticker.equals(obj.get("ticker"))){
				if("ms".equals(web)){
					return "" + obj.get("ticker_morningstar");
				} else if("reuters".equals(web)){
					return "" + obj.get("ticker_reuters");
				} else {
					return "";
				}
			}
		}
		return "";
	}
	
	public static String obtenerEmpresa(String ticker) throws IOException, ParseException{
		JSONParser parser = new JSONParser();
		JSONArray empresas = (JSONArray) parser.parse(new InputStreamReader(Resources.class.getResourceAsStream("empresas.json")));
		for(int i=0; i<empresas.size(); i++){
			JSONObject obj = (JSONObject) empresas.get(i);
			if(ticker.equals(obj.get("ticker"))){
				return "" + obj.get("empresa");
			}
		}
		return "";
	}

}
