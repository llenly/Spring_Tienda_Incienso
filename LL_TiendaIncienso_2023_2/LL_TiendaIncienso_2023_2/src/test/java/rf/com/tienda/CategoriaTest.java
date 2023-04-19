package rf.com.tienda;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;

import rf.com.tienda.dominio.Categoria;
import rf.com.tienda.exception.DomainException;

 public class CategoriaTest {

	    private static final String NOMBRE_CATEGORIA="nombre categoria valido";
		private static final String NOMBRE_ERRROR="123452";

		
		private static Categoria categoriaTes;
		
		
		@BeforeAll
		static void probar() {
			
			categoriaTes = new Categoria();
			
		}
		
		
//		@Test 
//	categNombreValido
//	
//	void setCat_nombreTest() throws DomainException {
//		
//		//assertThrows(categoriaTes.setCat_nombre(NOMBRE_CATEGORIA));
//	}




}
