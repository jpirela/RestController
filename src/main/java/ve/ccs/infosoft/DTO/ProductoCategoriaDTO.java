package ve.ccs.infosoft.DTO;

import jakarta.annotation.Nonnull;

public record ProductoCategoriaDTO(
	    @Nonnull Integer productoId,
	    @Nonnull Integer categoriaId
	) {

	public Integer productoId() {
		return productoId;
	}

	public Integer categoriaId() {
		return categoriaId;
	}
	
	
	
}
