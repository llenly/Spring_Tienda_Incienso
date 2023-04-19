package rf.com.tienda.servicio;

import java.util.List;

import rf.com.tienda.dominio.Producto;
import rf.com.tienda.dominio.Usuario;

public interface IProducto {

	
	List<Producto> listarProducto();

	Producto añadirProd(Producto producto);


	Producto updateProd(Producto producto);

	
	void deleteProd(Integer id);
}
