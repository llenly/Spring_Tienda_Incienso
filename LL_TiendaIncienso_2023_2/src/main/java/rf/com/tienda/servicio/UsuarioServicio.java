package rf.com.tienda.servicio;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import rf.com.tienda.dominio.Categoria;
import rf.com.tienda.dominio.Usuario;
import rf.com.tienda.repository.UsuarioRepository;

@Service
public class UsuarioServicio implements IUsuario{

	@Autowired
	private UsuarioRepository userrepository;
	
	@Override
	public List<Usuario> listarUsuario() {
		return userrepository.findAll();
	}
	
	@Override
	public Usuario añadirUser(Usuario usuario) {
		return userrepository.save(usuario);
	}
	
	
	@Override
	public Usuario updateUser(Usuario usuario) {
	
		return userrepository.save(usuario);
		
		
	}
	
	
	@Override
	public void deleteUser(Integer id) {
		userrepository.deleteById(id);
	}
	
	
}
