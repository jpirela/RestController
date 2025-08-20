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
@Table(name = "cliente_red_social")
@Data
public class ClienteRedSocial {

	
	
	 @Id
	    @GeneratedValue(strategy = GenerationType.IDENTITY)
	    @Column(name = "id_cliente_red_social")
	    private Integer id;

	 	@ManyToOne(fetch = FetchType.LAZY)
	    @JoinColumn(name = "id_cliente", nullable = false)
	    @JsonBackReference("cliente-reference") // Nombre de referencia único
	    private Cliente cliente;

	    @ManyToOne(fetch = FetchType.LAZY)
	    @JoinColumn(name = "id_red_social", nullable = false)
	    @JsonBackReference("redsocial-reference") // Nombre de referencia único
	    private RedSocial redSocial;

	    @Column(name = "usuario", length = 100)
	    private String usuario; // Nombre de usuario o URL

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

		public RedSocial getRedSocial() {
			return redSocial;
		}

		public void setRedSocial(RedSocial redSocial) {
			this.redSocial = redSocial;
		}

		public String getUsuario() {
			return usuario;
		}

		public void setUsuario(String usuario) {
			this.usuario = usuario;
		}
	    
	    
	    
	
}
