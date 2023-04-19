package rf.com.tienda.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import rf.com.tienda.dominio.Categoria;
import rf.com.tienda.dominio.Usuario;
import rf.com.tienda.exception.DomainException;
import rf.com.tienda.servicio.IUsuario;

@RestController
@RequestMapping(path="/usuario")
public class UsuarioController {

	@Autowired
	private IUsuario userServicio;
	
	
	@GetMapping
	 public List<Usuario> listaCategoria(){
		return userServicio.listarUsuario();
	}

    @PostMapping
	 public Usuario crearUsuario(@RequestBody Usuario usuario) {
    	System.out.println(usuario);
    	usuario.setId_usuario(0);
    	return userServicio.añadirUser(usuario);
    }
    
 @PutMapping
    
    public Usuario actualizarUsuario(@RequestBody Usuario usuario) throws DomainException {
    	return userServicio.updateUser(usuario);
    	
    }
 
 @DeleteMapping("/{id}" )
     public void deletUser( @PathVariable("id") Integer id ) {
	   userServicio.deleteUser(id);
 }
	
}
