package ve.ccs.infosoft.model;

import java.time.LocalDateTime;
import java.util.List;

import com.fasterxml.jackson.annotation.JsonManagedReference;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.FetchType;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.OneToMany;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Table(name = "proveedor")
@Data
@NoArgsConstructor
@AllArgsConstructor
public class Proveedor {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "id_proveedor")
	private Integer idProveedor;

	@Column(name = "nombre", nullable = false, length = 100)
	private String nombre;

	@Column(name = "contacto", length = 100)
	private String contacto;

	@Column(name = "telefono", length = 20)
	private String telefono;

	@Column(name = "correo", length = 100)
	private String correo;

	@Column(name = "direccion", columnDefinition = "TEXT")
	private String direccion;

	@Column(name = "fecha_registro")
	private LocalDateTime fechaRegistro = LocalDateTime.now();
	
	
	 @OneToMany(mappedBy = "proveedor", cascade = {
		        CascadeType.PERSIST, 
		        CascadeType.MERGE,
		        CascadeType.REFRESH,
		        CascadeType.DETACH
		    }, fetch = FetchType.LAZY)
	 @JsonManagedReference
	    private List<Distribuidor> distribuidores;
	

	public Integer getIdProveedor() {
		return idProveedor;
	}

	public void setIdProveedor(Integer idProveedor) {
		this.idProveedor = idProveedor;
	}

	public String getNombre() {
		return nombre;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

	public String getContacto() {
		return contacto;
	}

	public void setContacto(String contacto) {
		this.contacto = contacto;
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

	public String getDireccion() {
		return direccion;
	}

	public void setDireccion(String direccion) {
		this.direccion = direccion;
	}

	public LocalDateTime getFechaRegistro() {
		return fechaRegistro;
	}

	public void setFechaRegistro(LocalDateTime fechaRegistro) {
		this.fechaRegistro = fechaRegistro;
	}

	
	
	public List<Distribuidor> getDistribuidores() {
		return distribuidores;
	}

	public void setDistribuidores(List<Distribuidor> distribuidores) {
		this.distribuidores = distribuidores;
	}

	/*
	 * @OneToMany(mappedBy = "proveedor", cascade = CascadeType.ALL, fetch =
	 * FetchType.LAZY) private List<Producto> productos;
	 * 
	 * @OneToMany(mappedBy = "proveedor", cascade = CascadeType.ALL, fetch =
	 * FetchType.LAZY) private List<Pedido> pedidos;
	 * 
	 * @OneToMany(mappedBy = "proveedor", cascade = CascadeType.ALL, fetch =
	 * FetchType.LAZY) private List<Distribuidor> distribuidores;
	 * 
	 * @ManyToMany
	 * 
	 * @JoinTable( name = "proveedores_clientes", joinColumns = @JoinColumn(name =
	 * "id_proveedor"), inverseJoinColumns = @JoinColumn(name = "id_cliente") )
	 * private Set<Cliente> clientes;
	 */

}
