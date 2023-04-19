package rf.com.tienda.servicio;

import java.util.List;

import rf.com.tienda.dominio.Categoria;
import rf.com.tienda.dominio.Usuario;

public interface IUsuario {

	List<Usuario> listarUsuario();

	Usuario añadirUser(Usuario usuario);

	

	Usuario updateUser(Usuario usuario);

	
	void deleteUser(Integer id);
	
	

}
