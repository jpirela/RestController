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
@Table(name = "forma_pago")
@Data
@NoArgsConstructor
@AllArgsConstructor
public class FormaPago {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "id_forma_pago")
	private Integer idFormaPago;

	@Column(name = "descripcion", nullable = false, length = 100)
	private String descripcion;
	
	@OneToMany(mappedBy = "formaPago", fetch = FetchType.LAZY)
	@JsonManagedReference("formapago-clientes")
	private List<ClienteFormaPago> clientes = new ArrayList<>();
	
	
	

	

	public List<ClienteFormaPago> getClientes() {
		return clientes;
	}

	public void setClientes(List<ClienteFormaPago> clientes) {
		this.clientes = clientes;
	}

	public Integer getIdFormaPago() {
		return idFormaPago;
	}

	public void setIdFormaPago(Integer idFormaPago) {
		this.idFormaPago = idFormaPago;
	}

	public String getDescripcion() {
		return descripcion;
	}

	public void setDescripcion(String descripcion) {
		this.descripcion = descripcion;
	}



}
