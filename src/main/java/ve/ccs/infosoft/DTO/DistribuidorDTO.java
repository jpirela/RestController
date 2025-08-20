package ve.ccs.infosoft.DTO;

public class DistribuidorDTO {
	
	
	private Integer idDistribuidor;
	private String nombreContacto;
	private String telefono;
	private String correo;
	private String zonaDistribucion;
	private Integer idProveedor;
	public Integer getIdDistribuidor() {
		return idDistribuidor;
	}
	public void setIdDistribuidor(Integer idDistribuidor) {
		this.idDistribuidor = idDistribuidor;
	}
	public String getNombreContacto() {
		return nombreContacto;
	}
	public void setNombreContacto(String nombreContacto) {
		this.nombreContacto = nombreContacto;
	}
	public String getTelefono() {
		return telefono;
	}
	public void setTelefono(String telefono) {
		this.telefono = telefono;
	}
	public String getCorreo() {
		return correo;
	}
	public void setCorreo(String correo) {
		this.correo = correo;
	}
	public String getZonaDistribucion() {
		return zonaDistribucion;
	}
	public void setZonaDistribucion(String zonaDistribucion) {
		this.zonaDistribucion = zonaDistribucion;
	}
	public Integer getIdProveedor() {
		return idProveedor;
	}
	public void setIdProveedor(Integer idProveedor) {
		this.idProveedor = idProveedor;
	}
	
	
}
