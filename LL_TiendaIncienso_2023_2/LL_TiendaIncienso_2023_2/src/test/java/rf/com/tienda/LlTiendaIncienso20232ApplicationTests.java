package rf.com.tienda;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertTrue;

import java.time.LocalDate;

import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;
//import org.springframework.boot.test.context.SpringBootTest;validator no esta creada con spring

import rf.com.tienda.util.Validator;

//SpringBootTest
public class LlTiendaIncienso20232ApplicationTests {

	// definicion de las pruebas metodo texto
	final String Prueba = "asdhcbdbkdj6";
	final String PruebaDos = "76dadeFF8";
	final String PruebaTres = "@";

	// PASSWORD
	final String Passw = "Lsdh9cBdb#dj6@*";
	final String Passw1 = "Lssd!hshak#";
	final String Passw2 = "12344877ashdgk#";

	// pruebas metodo email
	final String EmailOK = "hdkhkal@gmail.com";
	final String EmailERROR1 = "hdkhkal@gmail";
	final String EmailERROR2 = "hdkhkal.gmailcom";
	final String EmailERROR3 = "@gmail.com";

	// prueva texto vacio
	final String texook = "";
	final String textoerr = "cadena";

	// prueba fecha valida
	final String fecha = "12-03-2021";
	final String fecha1= "2021-03-12";
	final String fecha2= "20/3/12";
	final String fecha3= "2020-2-8";
	
	

	// prueba phone number
	final String Phone = "64538876";
	final String Phone1 = "64587652498";
	final String Phone2 = "657444";

	// prueva rango int
	final int Valor = 16;
	final int Valor1 = 5;
	final int Valor2 = 89;
	final int Valor3 = 15;
	
	// prueva rango duble
	final double ValorD = 8.2;
	final double ValorD1 = 30.5;
	final double ValorD2 = 22.8;

	// PRUEBA LONGITUD MAX
	final String LongitudMaxOk = "1234567";
	final String LongitudMaxOk1 = "5678";
	final String LongitudMaxOk2 = "344";

	// PRUEBA LONGITUD MIN
	final String LongitudMinOk = "textos";
	final String LongitudMinOk1 = "textossssss";
	final String LongitudMinOk2 = "";
	final String LongitudMinOk3 = "tex";

	// PRUEVA CUMPLELONGITUD
	final String CumpleLongitudOk = "";
	final String CumpleLongitudOk1 = "texma10me5";
	final String CumpleLongitudOk2 = "texmay5";
	final String CumpleLongitudOk3 = "tex";
	
	
	
	
	
	
	//PRUEBA PRODUCTO 
	
	
	
	
	
	//PRUEBA USUARIOS NOMBRE
	final String nombre1 = "ROSAMAEYLNUY";
	final String nombre2 = "Ros";
	final String nombre3 = "";
	final String nombre4 = "@";
	final String nombre5 = "sydhhhall";
	
	

	// prueba del primer metodo , se crea una var estatica por cada clase
	private static Validator validar;

	// instancio la obj validator

	@BeforeAll
	static void setUpBeforeClass()

	{
		validar = new Validator();

	}

	// TEST VALIDAR isAlfanumeric
	@Test
	void isAlfanumericTest() {

		assertEquals(Validator.isAlfanumeric(Prueba), true);
		assertEquals(Validator.isAlfanumeric(PruebaDos), true);
		assertEquals(Validator.isAlfanumeric(PruebaTres), false);

	}

	// TEST VALIDAR PASSWORD
	@Test
	void esPasswordValidaTest() {

		assertEquals(Validator.esPasswordValida(Passw), true);
		assertEquals(Validator.esPasswordValida(Passw1), false);
		assertEquals(Validator.esPasswordValida(Passw2), false);

	}

	// TEST VALIDAR EMAIL
	@Test
	void isEmailValidoTest() {

		assertTrue(Validator.isEmailValido(EmailOK));
		assertFalse(Validator.isEmailValido(EmailERROR1));
		assertFalse(Validator.isEmailValido(EmailERROR2));
		assertFalse(Validator.isEmailValido(EmailERROR3));

	}

	// TEST VALIDAR TEXTO VACIO
	@Test
	void isVacioTest() {
		assertTrue(Validator.isVacio(texook));
		assertFalse(Validator.isVacio(textoerr));
	}

	// TEST VALIDA PHONENUMBER
	@Test
	void cumplePhoneNumberTest() {

		assertEquals(Validator.cumplePhoneNumber(Phone), false);
		assertEquals(Validator.cumplePhoneNumber(Phone1), true);
		assertEquals(Validator.cumplePhoneNumber(Phone2), false);

	}

	// TEST VALIDAD FECHA
	@Test
	void esFechaValidaTest() {

		//assertTrue(Validator.esFechaValida(fecha));
		assertFalse(Validator.esFechaValida(fecha1));
		assertFalse(Validator.esFechaValida(fecha2));
		assertFalse(Validator.esFechaValida(fecha2));
		
	}

	// TEST VALIDAD RANGO INT
	@Test
	void cumpleRangoTest() {
		assertTrue(Validator.cumpleRango(Valor, 7, 20));// VALOR16 MIN7 Y MAX20
		assertFalse(Validator.cumpleRango(Valor1, 6, 10));// valor5
		assertFalse(Validator.cumpleRango(Valor2, 90, 99));// 89
		assertTrue(Validator.cumpleRango(Valor3, 12, 20));
	}

	// TEST VALIDAD RANGO DOUBLE
	@Test
	void cumpleRangoDTest() {
		assertTrue(Validator.cumpleRangoD(ValorD, (int) 7.1, (int) 20.5));// VALOR8.2 MIN7 Y MAX20
		assertTrue(Validator.cumpleRangoD(ValorD1, (int)27.2, (int) 40.0));// valor30.5
		assertFalse(Validator.cumpleRangoD(ValorD2, (int)25.5, (int)45.8));// 22.8
	}

	// TEST LONGITUD MAX
	@Test
	void cumpleLongitudMaxTest() {
		assertFalse(Validator.cumpleLongitudMax(LongitudMaxOk, 5));
		assertTrue(Validator.cumpleLongitudMax(LongitudMaxOk1, 5));
		assertTrue(Validator.cumpleLongitudMax(LongitudMaxOk2, 5));

	}

	// TEST LONGITUD MIN
	@Test
	void cumpleLongitudMinTest() {
		assertFalse(Validator.cumpleLongitudMax(LongitudMinOk, 5));
		assertFalse(Validator.cumpleLongitudMax(LongitudMinOk1, 5));
		assertTrue(Validator.cumpleLongitudMax(LongitudMinOk2, 5));
		assertTrue(Validator.cumpleLongitudMax(LongitudMinOk3, 5));

	}

	@Test
	void cumpleLongitudTest() {
		assertFalse(Validator.cumpleLongitud(CumpleLongitudOk, 5, 10));
		assertTrue(Validator.cumpleLongitud(CumpleLongitudOk1, 10, 5));
		assertFalse(Validator.cumpleLongitud(CumpleLongitudOk2, 4, 2));
		assertTrue(Validator.cumpleLongitud(CumpleLongitudOk3, 3, 1));
	}

	@Test
	void valDateMaxTest() {
		LocalDate hoy = LocalDate.now();
		LocalDate fecha1 = LocalDate.of(1995, 04, 07);
		LocalDate fecha2 = LocalDate.of(2024, 04, 07);

		assertFalse(Validator.valDateMax(hoy, fecha1));
		assertTrue(Validator.valDateMax(hoy, fecha2));

	}
	
	

	
	//TEST PARA LA TABLA DE PRODUCTOS
	@Test
	void nombreValidoTest() {
		
		assertEquals(Validator.nombreValido(nombre1, 5, 10), true);// min5 max10
		assertEquals(Validator.nombreValido(nombre2,7 , 15),true);
		assertEquals(Validator.nombreValido(nombre3,4, 12), true);//nom 0
		assertEquals(Validator.nombreValido(nombre4, 6 ,15 ),false);		
		
	}
	
	
	//TEST PARA LA TABLA USUARIOS
	
	
}