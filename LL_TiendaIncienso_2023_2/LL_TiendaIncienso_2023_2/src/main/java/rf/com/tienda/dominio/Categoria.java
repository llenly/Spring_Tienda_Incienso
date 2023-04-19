package rf.com.tienda.dominio;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
import rf.com.tienda.exception.DomainException;
//import rf.com.tienda.util.ErrorMessages;
import rf.com.tienda.util.Validator;

/**
 * se crea una tabla con la clase categ siendo ella una entity Nombre Categoria
 * Descripcion Lista de categorías
 * 
 * @author LLE
 * @version 13 de abr. de 2016
 *
 */
@Entity
@Table(name = "categoria", schema = "LLI_ALUMNO")

public class Categoria {

	@Id
	@GeneratedValue(strategy = GenerationType.TABLE)
	@Column(name = "id", nullable = false)
	private int id_categoria; // identificador categoria

	@Column(name = "categoria", nullable = false, columnDefinition = "VARCHAR(50")
	private String cat_nombre; // nombre de la categoria

	@Column(name = "descripcion", nullable = true, columnDefinition = "VARCHAR(200) DEFAULT 'null'")
	private String cat_descripcion; // descripcion de la categoria

	public Categoria() {
	}

	public boolean isValid() {
		return !Validator.isVacio(cat_nombre) && id_categoria > 0;
	}

	/**
	 * Getter para identificador de categoria
	 * 
	 * @return Integer con el id de la categoria
	 */
	public int getId_categoria() {
		return id_categoria;
	}

	/**
	 * Setter para identificador de categoria
	 * 
	 */
	public void setId_categoria(int id_categoria) {
		this.id_categoria = id_categoria;
	}

	/**
	 * Getter para el nombre de categoria
	 * 
	 * @return cadena con el nombre de la categoria
	 */
	public String getCat_nombre() {
		return cat_nombre;
	}

	/**
	 * Setter para el nombre de categoria
	 * 
	 */
	public void setCat_nombre(String cat_nombre) throws DomainException {
		this.cat_nombre = cat_nombre;

		if (Validator.categNombreValido(cat_nombre)) {
			this.cat_nombre = cat_nombre;
		}
		else {
			throw new DomainException("no cumple con la longitud");
		}

	}

	/**
	 * Getter para la descripcion de categoria
	 * 
	 * @return cadena con la descripcion de la categoria
	 */
	public String getCat_descripcion() {
		return cat_descripcion;
	}

	/**
	 * setter para la descripcion de categoria
	 * 
	 */
	public void setCat_descripcion(String cat_descripcion) {
		this.cat_descripcion = cat_descripcion;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((cat_descripcion == null) ? 0 : cat_descripcion.hashCode());
		result = prime * result + ((cat_nombre == null) ? 0 : cat_nombre.hashCode());
		result = prime * result + id_categoria;
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Categoria other = (Categoria) obj;
		if (cat_descripcion == null) {
			if (other.cat_descripcion != null)
				return false;
		} else if (!cat_descripcion.equals(other.cat_descripcion))
			return false;
		if (cat_nombre == null) {
			if (other.cat_nombre != null)
				return false;
		} else if (!cat_nombre.equals(other.cat_nombre))
			return false;
		if (id_categoria != other.id_categoria)
			return false;
		return true;
	}

	@Override
	public String toString() {
		return "Categoria [id_categoria=" + id_categoria + ", cat_nombre=" + cat_nombre + ", cat_descripcion="
				+ cat_descripcion + "]";
	}

}
