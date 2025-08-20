package ve.ccs.infosoft.model;



import java.util.ArrayList;
import java.util.List;

import com.fasterxml.jackson.annotation.JsonManagedReference;

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
@Table(name = "condicion_pago")
@Data
@NoArgsConstructor
@AllArgsConstructor
public class CondicionPago {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id_condicion_pago")
    private Integer idCondicionPago;

    @Column(name = "descripcion", nullable = false, length = 100, unique = true)
    private String descripcion;
    
    
    
    @OneToMany(mappedBy = "condicionPago", fetch = FetchType.LAZY)
    @JsonManagedReference("condicionpago-cliente")
    private List<ClienteCondicionPago> clientes = new ArrayList<>();


  
	public List<ClienteCondicionPago> getClientes() {
		return clientes;
	}

	public void setClientes(List<ClienteCondicionPago> clientes) {
		this.clientes = clientes;
	}

	public Integer getIdCondicionPago() {
		return idCondicionPago;
	}

	public void setIdCondicionPago(Integer idCondicionPago) {
		this.idCondicionPago = idCondicionPago;
	}

	public String getDescripcion() {
		return descripcion;
	}

	public void setDescripcion(String descripcion) {
		this.descripcion = descripcion;
	}

	
    
    
}