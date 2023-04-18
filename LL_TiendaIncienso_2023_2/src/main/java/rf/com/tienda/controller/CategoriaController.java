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
import rf.com.tienda.exception.DomainException;
import rf.com.tienda.servicio.ICategoria;


@RestController
@RequestMapping("/categorias")
public class CategoriaController { 

@Autowired	
	private ICategoria catServicio;

	@GetMapping
	 public List<Categoria> listaCategoria(){
		return catServicio.listarCatg();
	}
	
    @PostMapping
	 public Categoria crearCategoria(@RequestBody Categoria categoria) {
    	System.out.println(categoria);
    	categoria.setId_categoria(0);
    	//return catServicio.crearCategoria(categoria);
    	return catServicio.crearCategoria(categoria);
    }
    
    @PutMapping
    
    public Categoria actualizarCategoria(@RequestBody Categoria categoria) throws DomainException {
    	return catServicio.editarCategoria(categoria, categoria.getId_categoria());
    	
    }
    
    @GetMapping("/{id}")
    public Categoria leerUno(@PathVariable("id") int id) throws DomainException {
    	return catServicio.leerUnoCategoria(id);
    }
    
    @DeleteMapping("/{id}")
    
    public void borrar(@PathVariable("id") int id)throws DomainException{
    	catServicio.deleteCategoria(id);
    }
}
