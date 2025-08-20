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
import lombok.Data;

@Entity
@Table(name = "cliente_categoria")
@Data
public class ClienteCategoria {

	
	

	 @Id
	    @GeneratedValue(strategy = GenerationType.IDENTITY)
	    @Column(name = "id_cliente_categoria")
	    private Integer id;

	 	@ManyToOne(fetch = FetchType.LAZY)
	    @JoinColumn(name = "id_cliente", nullable = false)
	    @JsonBackReference("clienteCategoria-reference") // Nombre de referencia único
	    private Cliente cliente;

	    @ManyToOne(fetch = FetchType.LAZY)
	    @JoinColumn(name = "id_categoria", nullable = false)
	    @JsonBackReference("categoriaCliente-reference") // Nombre de referencia único
	    private Categoria categoria;

	    @Column(name = "cantidad", length = 100)
	    private String cantidad; // Nombre de usuario o URL

		public Integer getId() {
			return id;
		}

		public void setId(Integer id) {
			this.id = id;
		}

		public Cliente getCliente() {
			return cliente;
		}

		public void setCliente(Cliente cliente) {
			this.cliente = cliente;
		}

		public Categoria getCategoria() {
			return categoria;
		}

		public void setCategoria(Categoria categoria) {
			this.categoria = categoria;
		}

		public String getCantidad() {
			return cantidad;
		}

		public void setCantidad(String cantidad) {
			this.cantidad = cantidad;
		}
	    
	    
	    
	
}
