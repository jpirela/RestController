package ve.ccs.infosoft.DTO;

public record CategoriaDTO(Integer id, String nombre) {

	public Integer id() {
		return id;
	}

	public String nombre() {
		return nombre;
	}

}
