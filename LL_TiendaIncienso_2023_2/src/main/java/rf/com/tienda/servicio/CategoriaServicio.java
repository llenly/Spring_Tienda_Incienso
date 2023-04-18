package rf.com.tienda.servicio;

import java.util.List;
import java.util.Objects;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import rf.com.tienda.dominio.Categoria;
import rf.com.tienda.exception.DomainException;
import rf.com.tienda.repository.CategoriaRepository;

@Service
public class CategoriaServicio implements ICategoria {

	@Autowired
	private CategoriaRepository categrepositorio;

	@Override
	public List<Categoria> listarCatg() {
		return categrepositorio.findAll();
	}

	@Override
	public Categoria crearCategoria(Categoria categoria) {
		System.out.println(categoria);
		return categrepositorio.save(categoria);
	}

	@Override
	public Categoria editarCategoria(Categoria categoria, int id) throws DomainException {
		// ("categoria");
		Categoria aux = categrepositorio.findById(id).get();
		if (Objects.nonNull(categoria.getCat_nombre()) && !"".equalsIgnoreCase(categoria.getCat_nombre())) {

			aux.setCat_nombre(categoria.getCat_nombre());

		}

		if (Objects.nonNull(categoria.getCat_descripcion()) && !"".equalsIgnoreCase(categoria.getCat_descripcion())) {

			aux.setCat_descripcion(categoria.getCat_descripcion());

		}
		return categrepositorio.save(aux);
	}

	@Override
	public Categoria leerUnoCategoria(int id) throws DomainException {
		// TODO Auto-generated method stub
		return categrepositorio.findById(id).get();
		
	}

	@Override
	public void deleteCategoria(int id) throws DomainException {
		
		Categoria aux = categrepositorio.findById(id).get();
		categrepositorio.delete(aux);
		
		
		
	}
	
	


}
