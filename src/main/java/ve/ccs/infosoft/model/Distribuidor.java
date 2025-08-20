package ve.ccs.infosoft.model;

import com.fasterxml.jackson.annotation.JsonBackReference;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.FetchType;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Table(name = "distribuidor")
@Data
@NoArgsConstructor
@AllArgsConstructor
public class Distribuidor {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "id_distribuidor")
	private Integer idDistribuidor;

	@Column(name = "nombre_contacto", length = 100)
	private String nombreContacto;

	@Column(name = "telefono", length = 20)
	private String telefono;

	@Column(name = "correo", length = 100)
	private String correo;

	@Column(name = "zona_distribucion", length = 100)
	private String zonaDistribucion;

	
	
	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "id_proveedor", nullable = false)
	@JsonBackReference
	private Proveedor proveedor;

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

	public Proveedor getProveedor() {
		return proveedor;
	}

	public void setProveedor(Proveedor proveedor) {
		this.proveedor = proveedor;
	}
	
	
	
	
	
	
}
