package ve.ccs.infosoft.model;

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
@Table(name = "tipoproducto")
@Data
@NoArgsConstructor
@AllArgsConstructor
public class TipoProducto {

	
	 @Id
	    @GeneratedValue(strategy = GenerationType.IDENTITY)
	    @Column(name = "id_tipo_producto")
	    private Integer idTipoProducto;

	    @Column(name = "nombre", nullable = false, length = 100)
	    private String nombre;

	    @Column(name = "descripcion", columnDefinition = "TEXT")
	    private String descripcion;

	    @OneToMany(mappedBy = "tipoProducto", cascade = CascadeType.ALL, fetch = FetchType.LAZY)
	    @JsonManagedReference("tipo-producto")
	    private List<Producto> productos;

		public Integer getIdTipoProducto() {
			return idTipoProducto;
		}

		public void setIdTipoProducto(Integer idTipoProducto) {
			this.idTipoProducto = idTipoProducto;
		}

		public String getNombre() {
			return nombre;
		}

		public void setNombre(String nombre) {
			this.nombre = nombre;
		}

		public String getDescripcion() {
			return descripcion;
		}

		public void setDescripcion(String descripcion) {
			this.descripcion = descripcion;
		}

		public List<Producto> getProductos() {
			return productos;
		}

		public void setProductos(List<Producto> productos) {
			this.productos = productos;
		}
	    
	    
	    
}
