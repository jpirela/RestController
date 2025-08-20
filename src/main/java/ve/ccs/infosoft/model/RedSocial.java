package ve.ccs.infosoft.model;

import java.util.ArrayList;
import java.util.List;

import com.fasterxml.jackson.annotation.JsonManagedReference;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.OneToMany;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Table(name = "redes_sociales")
@Data
@NoArgsConstructor
@AllArgsConstructor
public class RedSocial {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "id_red_social")
	private Integer idRedSocial;

	@Column(name = "plataforma", nullable = false, length = 50)
	private String plataforma;
	
	@OneToMany(mappedBy = "redSocial", cascade = CascadeType.ALL, orphanRemoval = true)
	 @JsonManagedReference("redsocial-reference")
	private List<ClienteRedSocial> clientes = new ArrayList<>();

	// Getter y Setter
	public List<ClienteRedSocial> getClientes() {
	    return clientes;
	}

	public void setClientes(List<ClienteRedSocial> clientes) {
	    this.clientes = clientes;
	}

	public Integer getIdRedSocial() {
		return idRedSocial;
	}

	public void setIdRedSocial(Integer idRedSocial) {
		this.idRedSocial = idRedSocial;
	}

	public String getPlataforma() {
		return plataforma;
	}

	public void setPlataforma(String plataforma) {
		this.plataforma = plataforma;
	}

}
