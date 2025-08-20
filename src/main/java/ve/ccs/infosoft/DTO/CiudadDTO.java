package ve.ccs.infosoft.DTO;

public class CiudadDTO {
	private Integer idCiudad;
	private String nombre;
	private Integer idEstado;

	// Constructores, getters y setters
	public CiudadDTO() {
	}

	public CiudadDTO(Integer idCiudad, String nombre, Integer idEstado) {
		this.idCiudad = idCiudad;
		this.nombre = nombre;
		this.idEstado = idEstado;
	}

	// Getters y Setters
	public Integer getIdCiudad() {
		return idCiudad;
	}

	public void setIdCiudad(Integer idCiudad) {
		this.idCiudad = idCiudad;
	}

	public String getNombre() {
		return nombre;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

	public Integer getIdEstado() {
		return idEstado;
	}

	public void setIdEstado(Integer idEstado) {
		this.idEstado = idEstado;
	}
}