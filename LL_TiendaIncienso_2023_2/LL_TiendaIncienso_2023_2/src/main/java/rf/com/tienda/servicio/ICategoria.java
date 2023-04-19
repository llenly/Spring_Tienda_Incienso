package rf.com.tienda.servicio;

import java.util.List;
import rf.com.tienda.dominio.Categoria;
import rf.com.tienda.exception.DomainException;

public interface ICategoria{
	
	//insertar categoria 
	 List<Categoria> listarCatg();
	 
	 
     Categoria crearCategoria(Categoria categoria);
     
	 Categoria editarCategoria(Categoria categoria, int id) throws DomainException;
	
	 Categoria leerUnoCategoria(int id)throws DomainException;
	 
	
     void deleteCategoria(int id)throws DomainException;
     
     
     
     
     
     
     
     
//     
// Categoria editarCategoria(Categoria categoria);
//
// Categoria actualizarCategoria(Categoria categoria);
//
// Categoria borrarCategoria(Categoria categoria, Integer id);
	
	
	//public Categoria getRegistro(int num);
	
//	public boolean guardar(Categoria c);
//	public List<Categoria> crearCategoria();

}
