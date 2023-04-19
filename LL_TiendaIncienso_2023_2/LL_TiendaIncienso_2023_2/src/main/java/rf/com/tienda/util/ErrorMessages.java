package rf.com.tienda.util;

/* *****************************************************
 * NOMBRE: ErrorMessages.java
 * 
 * DESCRIPCION:  
 * 			Clase con los String que contienen los mensajes de error 
 * 			especificados por las reglas de negocio.
 * 
 *  @version	Enero 2016
 *  
 *  @author 	Miguel Garcia
 *  
 *  *****************************************************/
public class ErrorMessages {

	/**
	 * Codigo de producto
	 */
	public final static String PROERR_001 = "Formato codigo erroneo";
	public final static String PROERR_002 = "Longitud de codigo erroneo";

	/**
	 * Campo con longitud erronea
	 */
	public final static String PROERR_003 = "La longitud de pro_descripcion ha de estar entre 5 y 100";
	public final static String PROERR_004 = "La longitud de pro_desLarga ha de estar entre 5 y 200";
	/**
	 * Fechas
	 */
	public final static String PROERR_005="Fecha anterior, no es válida ";
	/**
	 * Rangos
	 */
	public final static String PROERR_006="El precio ha de ser mayor a 0 y menor a 100";
	/**
	 * Stock
	 */
	public final static String PROERR_007="El stock no puede ser negativo";
	
	/* MENSAJES PARA USUARIOS ******************************/ 
	
	/**
	 * LONGITUD
	 */
	public final static String USUERR_001="La longitud de user_nombre tiene que estar entre 5 y 100";
	/**
	 * FORMATO
	 */
	public final static String USUERR_002="No cumple el formato del correo electrónico";
	public final static String USUERR_003="No cumplo el formato de contraseña";
	
	/**
	 * DNI
	 */
	
	public final static String USUERR_004="No cumple el formato de DNI";
	
	/**
	 *FECHA 
	 */
	
	public final static String USUERR_005="La fecha debe ser la actual";
	
}
