package ve.ccs.infosoft.model;

import com.fasterxml.jackson.annotation.JsonBackReference;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
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
@Table(name = "cliente_condicion_pago")
@Data
@NoArgsConstructor
@AllArgsConstructor
public class ClienteCondicionPago {

	
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id_cliente_condicion_pago")
    private Integer idClienteCondicionPago;

    @ManyToOne
    @JoinColumn(name = "id_cliente", nullable = false)
    @JsonBackReference("cliente-condicionpago")
    private Cliente cliente;

    @ManyToOne
    @JoinColumn(name = "id_condicion_pago", nullable = false)
    @JsonBackReference("condicionpago-cliente")
    private CondicionPago condicionPago;
    
    @Column(name = "dia_contado")
    private Integer diaContado;

    @Column(name = "dia_credito")
    private Integer diaCredito;

	public Integer getIdClienteCondicionPago() {
		return idClienteCondicionPago;
	}

	public void setIdClienteCondicionPago(Integer idClienteCondicionPago) {
		this.idClienteCondicionPago = idClienteCondicionPago;
	}

	public Cliente getCliente() {
		return cliente;
	}

	public void setCliente(Cliente cliente) {
		this.cliente = cliente;
	}

	public CondicionPago getCondicionPago() {
		return condicionPago;
	}

	public void setCondicionPago(CondicionPago condicionPago) {
		this.condicionPago = condicionPago;
	}

	public Integer getDiaContado() {
		return diaContado;
	}

	public void setDiaContado(Integer diaContado) {
		this.diaContado = diaContado;
	}

	public Integer getDiaCredito() {
		return diaCredito;
	}

	public void setDiaCredito(Integer diaCredito) {
		this.diaCredito = diaCredito;
	}
    
    
    
    
	
}
