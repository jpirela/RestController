package ve.ccs.infosoft.model;

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
import jakarta.persistence.ManyToMany;
import jakarta.persistence.OneToMany;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Table(name = "categoria")
@Data
@NoArgsConstructor
@AllArgsConstructor
public class Categoria {
	
	
	 @Id
	    @GeneratedValue(strategy = GenerationType.IDENTITY)
	    @Column(name = "id_categoria")
	    private Integer idCategoria;

	    @Column(name = "nombre", nullable = false, length = 100)
	    private String nombre;

	    @Column(name = "descripcion", columnDefinition = "TEXT")
	    private String descripcion;
	    
	    @ManyToMany(mappedBy = "categorias")
	    @JsonBackReference("producto-categoria")
	    private List<Producto> productos;
	    
	    
	    @OneToMany(mappedBy = "categoria", cascade = CascadeType.ALL, fetch = FetchType.LAZY)
	    @JsonManagedReference("categoria-subcategoria")
	    private List<SubCategoria> subcategorias;
	    
	
		@OneToMany(mappedBy = "categoria", cascade = CascadeType.ALL, orphanRemoval = true)
		 @JsonManagedReference("categoriaCliente-reference")
		private List<ClienteCategoria> clientes = new ArrayList<>();
	    
		public List<ClienteCategoria> getClientes() {
			return clientes;
		}

		public void setClientes(List<ClienteCategoria> clientes) {
			this.clientes = clientes;
		}

		public Integer getIdCategoria() {
			return idCategoria;
		}

		public void setIdCategoria(Integer idCategoria) {
			this.idCategoria = idCategoria;
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

		public List<SubCategoria> getSubcategorias() {
			return subcategorias;
		}

		public void setSubcategorias(List<SubCategoria> subcategorias) {
			this.subcategorias = subcategorias;
		}
	    
	    
	    

}
