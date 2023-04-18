package rf.com.tienda.util;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.time.format.DateTimeParseException;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

/********************************************************************************************
 * NOMBRE: Validator.java
 * 
 * DESCRIPCION: Clase auxiliar para validar los datos que sean introducidos en
 * la aplicaci�n.
 * 
 * @version 30/01/2023
 * @author Miguel Garcia
 * 
 ******************************************************************************************/
public class Validator {

	private static final String ALFANUMERIC_PATTERN = "^[0-9a-zA-Z]+$";

	private static final String PASSWORD_PATTERN = "((?=.*\\d)(?=.*[a-z])(?=.*[A-Z])(?=.*[@#$%]).{6,20})";
	/**
	 * Patr�n para validar el email, evitando puntos finales antes de la @ y que
	 * solo contenga car�cteres alfanum�ricos
	 */
	private final static String EMAIL_PATTERN = "^[_A-Za-z0-9-\\+]+(\\.[_A-Za-z0-9-]+)*@[A-Za-z0-9-]+(\\.[A-Za-z0-9]+)*(\\.[A-Za-z]{2,})$";

	/**
	 * Permite verificar que un DNI cumple con el patr�n XX.XXX.XXX-L
	 */
	private final static String DNI_PATTERN = "\\d{2}\\.\\d{3}\\.\\d{3}-[a-zA-Z]";
	private final static String FORMATO_FECHA = "dd-mm-yyyy";
	/**
	 * Permite validar un tel�fono, el cual debe contener de 10 a 20 d�gitos y donde
	 * los espacios est�n permitidos
	 */
	private final static String PHONE_PATTERN = "[\\d ]{10,20}";

	/**
	 * Orden de las letras con las cuales se comprobar� la validez del DNI
	 */
	private final static String LETRA_DNI = "TRWAGMYFPDXBNJZSQVHLCKE";

	/**
	 * Longitud que debe tener todo DNI pasado a la aplicaci�n.
	 */
	private final static int LONGITUD_DNI = 12;

	/**
	 * caracteres aceptados que debe tener todo nombre
	 */
	private final static String NOMBRE_PATTERN = "^[a-zA-Z]*$";

	/*
	 * *****************************************************************************
	 * ********** NOMBRE: isAlfanumeric *
	 * 
	 * DESCRIPCI�N:
	 *//**
		 * Permite verificar que el texto pasado solo contiene caracters alfanum�ricos
		 * 
		 * @param texto String a verificar que solo tenga car�cteres alfanum�ricos
		 * 
		 * @return true, si cumple solo contiene caracters alfanum�ricos. <br>
		 *         false en caso contrario FECHA: Enero 2023
		 * 
		 *         AUTOR: Miguel Garcia - Barcelona
		 * 
		 **************************************************************************************/
	public static boolean isAlfanumeric(String texto) {

		Pattern patron = Pattern.compile(ALFANUMERIC_PATTERN);

		if (patron.matches(ALFANUMERIC_PATTERN, texto)) {

			return true;
		} else {
			return false;
		}

	}

	public static boolean isVacio(String prueba) {

		if (prueba.isEmpty()) {
			return true;
		} else {
			return false;
		}

	}

	/*
	 * *****************************************************************************
	 * ********** NOMBRE: cumplePhoneNumber *
	 * 
	 * DESCRIPCI�N:
	 *//**
		 * El phone number debe tener un total de entre 10 y 20, contando d�gitos y
		 * espacios. M�nimo aceptable son 10 d�gitos.
		 * 
		 * @param phoneNumber String con el n�mero de telefono de entre 10 y 20 d�gitos.
		 *                    Puede tener espacios, pero siempre con 10 d�gitos como
		 *                    m�nimo.
		 * 
		 * @return true, si cumple todas las condiciones
		 *
		 *         FECHA: Enero 2023 AUTOR: Miguel Garcia
		 * 
		 **************************************************************************************/
	public static boolean cumplePhoneNumber(String phoneNumber) {

		Pattern phoneValido = Pattern.compile(PHONE_PATTERN);
		Matcher matcher = phoneValido.matcher(phoneNumber);

		boolean coincide = matcher.find();

		if (coincide) {
			return true;
		} else {
			return false;
		}

	}

	/*
	 * *****************************************************************************
	 * ********** NOMBRE: isEmailValido *
	 * 
	 * DESCRIPCI�N:
	 *//**
		 * Comprueba si el email tiene un formato que pueda ser v�lido.
		 * 
		 * @param email String a comprobar
		 * 
		 * @return true, en caso que el formato sea v�lido FECHA: Enero 2023
		 * 
		 *         AUTOR: Miguel Garcia
		 * 
		 **************************************************************************************/
	public static boolean isEmailValido(String email) {

		Pattern emailValido = Pattern.compile(EMAIL_PATTERN);
		Matcher matcher = emailValido.matcher(email);

		boolean coincide = matcher.find();

		if (coincide) {
			return true;
		} else {
			return false;
		}

	}

	/*
	 * *****************************************************************************
	 * ********** NOMBRE: cumpleDNI *
	 * 
	 * DESCRIPCI�N:
	 *//**
		 * Esta funci�n verifica que el DNI cumple el siguiente formato: xx.xxx.xxx-L
		 * <br>
		 * El DNI ha de tener longitud 12
		 * 
		 * @param dni String con DNI a ser validado
		 * 
		 * @return true, si el DNI cumple el estandar nacional. FECHA: Enero 2023 AUTOR:
		 *         Miguel Garcia
		 * 
		 **************************************************************************************/
	public static boolean cumpleDNI(String dni) {

		Pattern dniValido = Pattern.compile(ALFANUMERIC_PATTERN);
		Matcher matcher = dniValido.matcher(dni);

		boolean coincide = matcher.find();

		if (coincide) {
			String dniOk = dni.replace("[a-za-Z.]", "");
			String letra = dni.substring(-1);
			int dniVal = Integer.parseInt(letra) % 23;

			if (LETRA_DNI.substring(dniVal + 1).equals(letra)) {

				return true;
			}

		} else

		{
			return false;
		}

		return false;

	}

	/**
	 * ***************************************************************************************
	 * NOMBRE: cumpleRango *
	 * 
	 * DESCRIPCI�N:
	 */
	/**
	 * Comprueba que un N�mero se necuentra entre 2 valores
	 * 
	 * @param valor       (int)/(double) N�mero a comprobar
	 * @param valorMinimo (int) N�mero valor aceptable
	 * @param valorMaximo (int) M�N�mero valor aceptable
	 * 
	 * @return true si valorMinimo > valor > valorMaximo FECHA: Enero 2023 AUTOR:
	 *         Miguel Garcia
	 * 
	 **************************************************************************************/
	public static boolean cumpleRango(int valor, int valorMinimo, int valorMaximo) {

		if (valor >= valorMinimo && valor <= valorMaximo) {
			return true;
		} else {
			return false;
		}

	}

	public static boolean cumpleRangoD(double valor, int valorMinimo, int valorMaximo) {

		if (valor >= valorMinimo && valor <= valorMaximo) {

			// double valor = Integer.parseInt(valor);
			return true;
		} else {
			return false;
		}

	}

	/*
	 * *****************************************************************************
	 * ********** NOMBRE: cumpleLongitudMin *
	 * 
	 * DESCRIPCI�N:
	 *//**
		 * Comprobar que el texto pasado tiene una longitud de al menos x caracteres,
		 * siendo x el entero pasado como par�metro
		 * 
		 * @param texto          String texto a comprobar
		 * @param longitudMinima int que indique longitud m�nima.
		 * 
		 * @return cierto, si la longitud del texto es mayor o igual que longitudMinima
		 *         FECHA: Enero 2023 AUTOR: Miguel Garcia
		 * 
		 **************************************************************************************/
	public static boolean cumpleLongitudMin(String texto, int longitudMinima) {

		if (texto.length() >= longitudMinima) {
			return true;
		} else {
			if (texto.length() <= longitudMinima) {

			}
			return false;
		}

	}

	/*
	 * *****************************************************************************
	 * ********** NOMBRE: cumpleLongitudMax *
	 * 
	 * DESCRIPCI�N:
	 *//**
		 * Comprobar que el texto pasado tiene una longitud de, como mucho, x
		 * caracteres, siendo x el entero pasado como par�metro
		 * 
		 * @param texto          String con el texto a comprobar
		 * @param longitudMaxima int con la longitud m�xima del texto
		 * 
		 * @return true, si el texto es menor o igual que la longitud m�xima. FECHA:
		 *         Enero 2023 AUTOR: Miguel Garcia
		 * 
		 **************************************************************************************/
	public static boolean cumpleLongitudMax(String texto, int longitudMaxima) {

		if (texto.length() >= longitudMaxima) {
			return false;
		} else {
			if (texto.length() <= longitudMaxima) {

			}
			return true;
		}

	}

	/****************************************************************************************
	 * NOMBRE: cumpleLongitud *
	 * 
	 * DESCRIPCI�N:
	 */
	/**
	 * Comprobar que la longitud de un texto se encuentra entre unos valores m�ximos
	 * y m�nimos
	 * 
	 * @param texto          String con el texto que a validar
	 * @param longitudMinima (int) M�nima longitud del texto
	 * @param longitudMaxima (int) M�xima longitud v�lida para el texo
	 * 
	 * @return true, si la longitud del texto cumple: longitudMinima <=
	 *         longitudTexto <=longitudMaxima FECHA: Enero 2023 AUTOR: Miguel Garcia
	 *         - Barcelona
	 * 
	 **************************************************************************************/
	public static boolean cumpleLongitud(String texto, int longitudMaxima, int longitudMinima) {

		if (texto.length() <= longitudMaxima && texto.length() >= longitudMinima) {
			return true;
		} else {
			return false;
		}

	}

	/**
	 * Valida una fecha calendar con m�nimo min
	 * 
	 * @param fecha
	 * @param min
	 * @return
	 */

	public static boolean valDateMin(LocalDate fecha, LocalDate min) {
		// LocalDate actual = LocalDate();
		if (fecha.isAfter(min)) {

			return true;
		} else {
			return false;

		}
	}

	/**
	 * Valida una fecha calendar con m�ximo max
	 * 
	 * @param fecha
	 * @param max
	 * @return
	 */
	public static boolean valDateMax(LocalDate fecha, LocalDate max) {

		// LocalDate actual = LocalDate.now();

		if (fecha.isBefore(max)) {

			return true;
		} else {
			return false;

		}

	}

	/**
	 * esFechaValida Recibe una string con formato fecha dd/mm/aaaa y comprueba el
	 * formato
	 * 
	 * @param fecha
	 * @return
	 */

	public static boolean esFechaValida(String fecha) {

		try {

			DateTimeFormatter formatter = DateTimeFormatter.ofPattern(FORMATO_FECHA);

			LocalDate.parse(fecha, formatter);

			return true;

		} catch (DateTimeParseException e) {

			return false;

		}
	}

	/**
	 * Nombre esPasswordValida Descripcion Comprueba que la cadena recibida cumpla
	 * con lasnormas de contrase�a
	 * 
	 * @param password string con la contrase�a introducida
	 * @return true si cumple con las especificaciones
	 */
	public static boolean esPasswordValida(String password) {

		Pattern passValido = Pattern.compile(PASSWORD_PATTERN);
		Matcher matcher = passValido.matcher(password);

		boolean coincide = matcher.find();

		if (coincide) {
			return true;
		} else {
			return false;
		}

	}

	

	// nombre Alfanumerico LONG MIN 5 LONG MAX 100
	public static boolean nombreValido(String nombre, int longMIN, int longMAX) {

		Pattern nombreValid = Pattern.compile(NOMBRE_PATTERN);
		Matcher matcher = nombreValid.matcher(nombre);
		boolean coincide = matcher.find();

		if (coincide) {
			return true;
		}
		if (nombre == "") {
			return false;

		}
		if (nombre.length() >= longMIN && nombre.length() <= longMAX) {

			return true;
		} else {
			return false;
		}

	}

	
	//METODO CATEGORIA NOMBRE 
	
		 public static boolean categNombreValido(String cat)
		 {
			 
			 if(cumpleLongitud(cat, 5, 50))
			 {
				 return true;
			 }
			 else
			 {
				 return false;
			 }
			 
			 
		 }
	
	 
	 
	
	
}
