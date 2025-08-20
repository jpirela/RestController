package ve.ccs.infosoft.DTO;

import java.util.Set;

public record ProductoWithCategoriasDTO(   Integer id,
	    String nombre,
	    String codigo,
	    Set<CategoriaDTO> categorias) {

	public Integer id() {
		return id;
	}

	    public String nombre() {
		return nombre;
	}

	    public String codigo() {
		return codigo;
	}

	    public Set<CategoriaDTO> categorias() {
		return categorias;
	}

}
