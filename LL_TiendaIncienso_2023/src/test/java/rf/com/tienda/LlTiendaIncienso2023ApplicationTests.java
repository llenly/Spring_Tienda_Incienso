package rf.com.tienda;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertTrue;

import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;
//import org.springframework.boot.test.context.SpringBootTest;validator no esta creada con spring

import rf.tienda.util.Validator;

//SpringBootTest
public class LlTiendaIncienso2023ApplicationTests {

	// definicion de las pruebas metodo texto 
	String Prueba = "asdhcbdbkdj6";
	String PruebaDos = "76dadeFF8";
	String PruebaTres = "@";

	//PASSWORD 
	String Passw = "Lsdh9cBdb#dj6@*";
	String Passw1 = "Lssd!hshak#";
	String Passw2 = "12344877ashdgk#";
	
	//pruebas metodo email 
	String EmailOK = "hdkhkal@gmail.com";
	String EmailERROR1 = "hdkhkal@gmail";
	String EmailERROR2 = "hdkhkal.gmailcom";
	String EmailERROR3 = "@gmail.com";
	
	
	
	// prueba del primer metodo , se crea una var estatica por cada clase
	private static Validator validar;

	// instancio la obj validator

	@BeforeAll
	static void setUpBeforeClass()

	{
		validar = new Validator();

	}

	@Test
	void isAlfanumericTest() {

		assertEquals(Validator.isAlfanumeric(Prueba), true);
		assertEquals(validar.isAlfanumeric(PruebaDos), true);
		assertEquals(validar.isAlfanumeric(PruebaTres), false);

	}

	@Test
	void esPasswordValidaTest() {

		assertEquals(Validator.esPasswordValida(Passw), true);
		assertEquals(validar.esPasswordValida(Passw1), false);
		assertEquals(validar.esPasswordValida(Passw2), false);

	}

	@Test
	void isEmailValidoTest() {

		assertTrue(validar.isEmailValido(EmailOK));
		assertFalse(validar.isEmailValido(EmailERROR1));
		assertFalse(validar.isEmailValido(EmailERROR2));
		assertFalse(validar.isEmailValido(EmailERROR3));
		
	}
	
	
	

}
