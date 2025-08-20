package ve.ccs.infosoft.model;

import java.math.BigDecimal;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

import com.fasterxml.jackson.annotation.JsonBackReference;
import com.fasterxml.jackson.annotation.JsonManagedReference;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.FetchType;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.JoinTable;
import jakarta.persistence.ManyToMany;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.OneToMany;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Table(name = "productos")
@Data
@NoArgsConstructor
@AllArgsConstructor
public class Producto {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "id_producto")
	private Integer idProducto;

	@Column(name = "codigo_producto", nullable = false, length = 100, unique = true)
	private String codigo_producto;

	@Column(name = "nombre", nullable = false, length = 100)
	private String nombre;

	@Column(name = "codigo_barra", unique = true, length = 50)
	private String codigoBarra;

	@Column(name = "descripcion", columnDefinition = "TEXT")
	private String descripcion;

	@Column(name = "precio_compra", nullable = false, precision = 10, scale = 2)
	private BigDecimal precioCompra;

	@Column(name = "precio_venta", nullable = false, precision = 10, scale = 2)
	private BigDecimal precioVenta;

	@Column(name = "stock", nullable = false)
	private Integer stock = 0;

	@Column(name = "stock_minimo")
	private Integer stockMinimo = 0;

	@Column(name = "fecha_vencimiento")
	private LocalDate fechaVencimiento;

	@ManyToMany
	@JoinTable(name = "producto_categoria", joinColumns = @JoinColumn(name = "id_producto"), inverseJoinColumns = @JoinColumn(name = "id_categoria"))
	@JsonBackReference("producto-categoria")
	private List<Categoria> categorias;

	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "id_tipo_producto")
	@JsonBackReference("tipo-producto")
	private TipoProducto tipoProducto;

	@OneToMany(mappedBy = "producto")
    @JsonManagedReference("cliente-producto")
	private List<Cliente> clientes = new ArrayList<>();;
	
	

	public List<Cliente> getClientes() {
		return clientes;
	}

	public void setClientes(List<Cliente> clientes) {
		this.clientes = clientes;
	}

	public List<Categoria> getCategorias() {
		return categorias;
	}

	public void setCategorias(List<Categoria> categorias) {
		this.categorias = categorias;
	}

	public Integer getIdProducto() {
		return idProducto;
	}

	public void setIdProducto(Integer idProducto) {
		this.idProducto = idProducto;
	}

	public String getNombre() {
		return nombre;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

	public String getCodigoBarra() {
		return codigoBarra;
	}

	public void setCodigoBarra(String codigoBarra) {
		this.codigoBarra = codigoBarra;
	}

	public String getDescripcion() {
		return descripcion;
	}

	public void setDescripcion(String descripcion) {
		this.descripcion = descripcion;
	}

	public BigDecimal getPrecioCompra() {
		return precioCompra;
	}

	public void setPrecioCompra(BigDecimal precioCompra) {
		this.precioCompra = precioCompra;
	}

	public BigDecimal getPrecioVenta() {
		return precioVenta;
	}

	public void setPrecioVenta(BigDecimal precioVenta) {
		this.precioVenta = precioVenta;
	}

	public Integer getStock() {
		return stock;
	}

	public void setStock(Integer stock) {
		this.stock = stock;
	}

	public Integer getStockMinimo() {
		return stockMinimo;
	}

	public void setStockMinimo(Integer stockMinimo) {
		this.stockMinimo = stockMinimo;
	}

	public LocalDate getFechaVencimiento() {
		return fechaVencimiento;
	}

	public void setFechaVencimiento(LocalDate fechaVencimiento) {
		this.fechaVencimiento = fechaVencimiento;
	}

	public String getCodigo_producto() {
		return codigo_producto;
	}

	public void setCodigo_producto(String codigo_producto) {
		this.codigo_producto = codigo_producto;

	}

	public TipoProducto getTipoProducto() {
		return tipoProducto;
	}

	public void setTipoProducto(TipoProducto tipoProducto) {
		this.tipoProducto = tipoProducto;
	}

}
