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
@Table(name = "cliente_forma_pago")
@Data
public class ClienteFormaPago {

	
	 @Id
	    @GeneratedValue(strategy = GenerationType.IDENTITY)
	    @Column(name = "id_cliente_forma_pago")
	    private Integer id;

	    @ManyToOne(fetch = FetchType.LAZY)
	    @JoinColumn(name = "id_cliente", nullable = false)
	    @JsonBackReference("cliente-formaspago")
	    private Cliente cliente;

	    @ManyToOne(fetch = FetchType.LAZY)
	    @JoinColumn(name = "id_forma_pago", nullable = false)
	    @JsonBackReference("formapago-clientes")
	    private FormaPago formaPago;

	  

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

		public FormaPago getFormaPago() {
			return formaPago;
		}

		public void setFormaPago(FormaPago formaPago) {
			this.formaPago = formaPago;
		}

		
}
