package ve.ccs.infosoft.model;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

import com.fasterxml.jackson.annotation.JsonBackReference;
import com.fasterxml.jackson.annotation.JsonManagedReference;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.FetchType;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.OneToMany;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Table(name = "cliente")
@Data
@NoArgsConstructor
@AllArgsConstructor
public class Cliente {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "id_cliente")
	private Integer idCliente;

	@Column(name = "nombre", nullable = false, length = 100)
	private String nombre;

	@Column(name = "razon_social", length = 150)
	private String razonSocial;

	@Column(name = "rif", length = 20)
	private String rif;

	@Column(name = "contacto", length = 100)
	private String contacto;

	@Column(name = "correo", length = 100)
	private String correo;

	@Column(name = "telefono", length = 20)
	private String telefono;

	@Column(name = "contacto2", length = 100)
	private String contacto2;

	@Column(name = "correo2", length = 100)
	private String correo2;

	@Column(name = "telefono2", length = 20)
	private String telefono2;

	@Column(name = "direccion", columnDefinition = "TEXT")
	private String direccion;

	@Column(name = "ubicacion_map", columnDefinition = "TEXT")
	private String ubicacionMap;

	@Column(name = "local", length = 100)
	private String local;

	@Column(name = "punto_referencia", columnDefinition = "TEXT")
	private String puntoReferencia;

	@Column(name = "dia_recepcion", length = 20)
	private String diaRecepcion;

	@Column(name = "fecha_registro")
	private LocalDateTime fechaRegistro = LocalDateTime.now();

	@Column(name = "tipoComercio", length = 20)
	private String tipoComercio;


	@ManyToOne
	@JoinColumn(name = "id_estado")
	@JsonBackReference("estado-cliente")
	private Estado estado;

	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "id_municipio")
	@JsonBackReference("municipio-cliente")
	private Municipio municipio;

	@ManyToOne
	@JoinColumn(name = "id_parroquia")
	@JsonBackReference("parroquia-cliente")
	private Parroquia parroquia;

	@ManyToOne
	@JoinColumn(name = "id_ciudad")
	@JsonBackReference("ciudad-cliente")
	private Ciudad ciudad;

	@OneToMany(mappedBy = "cliente", fetch = FetchType.LAZY)
	@JsonManagedReference("cliente-reference") // Mismo nombre que en @JsonBackReference
	private List<ClienteRedSocial> redesSociales = new ArrayList<>();

	@OneToMany(mappedBy = "cliente", fetch = FetchType.LAZY)
	@JsonManagedReference("clienteCategoria-reference") // Mismo nombre que en @JsonBackReference
	private List<ClienteCategoria>  clienteCategoria = new ArrayList<>();
	

	@ManyToOne
	@JoinColumn(name = "id_producto")
	@JsonBackReference("cliente-producto")
	private Producto producto;
	
	
	@OneToMany(mappedBy = "cliente", fetch = FetchType.LAZY, cascade = CascadeType.ALL, orphanRemoval = true)
	@JsonManagedReference("cliente-formaspago")
	private List<ClienteFormaPago> formasPago = new ArrayList<>();
	
	
	
	@OneToMany(mappedBy = "cliente", fetch = FetchType.LAZY, cascade = CascadeType.ALL, orphanRemoval = true)
	@JsonManagedReference("cliente-condicionpago")
	private List<ClienteCondicionPago> condicionesPago = new ArrayList<>();
	
	
	

	public List<ClienteCondicionPago> getCondicionesPago() {
		return condicionesPago;
	}

	public void setCondicionesPago(List<ClienteCondicionPago> condicionesPago) {
		this.condicionesPago = condicionesPago;
	}

	public List<ClienteFormaPago> getFormasPago() {
		return formasPago;
	}

	public void setFormasPago(List<ClienteFormaPago> formasPago) {
		this.formasPago = formasPago;
	}

	public List<ClienteCategoria> getClienteCategoria() {
		return clienteCategoria;
	}

	public void setClienteCategoria(List<ClienteCategoria> clienteCategoria) {
		this.clienteCategoria = clienteCategoria;
	}


	public Producto getProducto() {
		return producto;
	}

	public void setProducto(Producto producto) {
		this.producto = producto;
	}

	// Getter y Setter
	public List<ClienteRedSocial> getRedesSociales() {
		return redesSociales;
	}

	public void setRedesSociales(List<ClienteRedSocial> redesSociales) {
		this.redesSociales = redesSociales;
	}

	public Ciudad getCiudad() {
		return ciudad;
	}

	public void setCiudad(Ciudad ciudad) {
		this.ciudad = ciudad;
	}

	public Integer getIdCliente() {
		return idCliente;
	}

	public void setIdCliente(Integer idCliente) {
		this.idCliente = idCliente;
	}

	public String getNombre() {
		return nombre;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

	public String getRazonSocial() {
		return razonSocial;
	}

	public void setRazonSocial(String razonSocial) {
		this.razonSocial = razonSocial;
	}

	public String getRif() {
		return rif;
	}

	public void setRif(String rif) {
		this.rif = rif;
	}

	public String getCorreo() {
		return correo;
	}

	public void setCorreo(String correo) {
		this.correo = correo;
	}

	public String getTelefono() {
		return telefono;
	}

	public void setTelefono(String telefono) {
		this.telefono = telefono;
	}

	public String getDireccion() {
		return direccion;
	}

	public void setDireccion(String direccion) {
		this.direccion = direccion;
	}

	public String getUbicacionMap() {
		return ubicacionMap;
	}

	public void setUbicacionMap(String ubicacionMap) {
		this.ubicacionMap = ubicacionMap;
	}

	public String getLocal() {
		return local;
	}

	public void setLocal(String local) {
		this.local = local;
	}

	public String getPuntoReferencia() {
		return puntoReferencia;
	}

	public void setPuntoReferencia(String puntoReferencia) {
		this.puntoReferencia = puntoReferencia;
	}

	public String getDiaRecepcion() {
		return diaRecepcion;
	}

	public void setDiaRecepcion(String diaRecepcion) {
		this.diaRecepcion = diaRecepcion;
	}

	public LocalDateTime getFechaRegistro() {
		return fechaRegistro;
	}

	public void setFechaRegistro(LocalDateTime fechaRegistro) {
		this.fechaRegistro = fechaRegistro;
	}



	public Estado getEstado() {
		return estado;
	}

	public void setEstado(Estado estado) {
		this.estado = estado;
	}

	public Municipio getMunicipio() {
		return municipio;
	}

	public void setMunicipio(Municipio municipio) {
		this.municipio = municipio;
	}

	public Parroquia getParroquia() {
		return parroquia;
	}

	public void setParroquia(Parroquia parroquia) {
		this.parroquia = parroquia;
	}

	public String getContacto() {
		return contacto;
	}

	public void setContacto(String contacto) {
		this.contacto = contacto;
	}

	public String getContacto2() {
		return contacto2;
	}

	public void setContacto2(String contacto2) {
		this.contacto2 = contacto2;
	}

	public String getCorreo2() {
		return correo2;
	}

	public void setCorreo2(String correo2) {
		this.correo2 = correo2;
	}

	public String getTelefono2() {
		return telefono2;
	}

	public void setTelefono2(String telefono2) {
		this.telefono2 = telefono2;
	}

	public String getTipoComercio() {
		return tipoComercio;
	}

	public void setTipoComercio(String tipoComercio) {
		this.tipoComercio = tipoComercio;
	}

}
