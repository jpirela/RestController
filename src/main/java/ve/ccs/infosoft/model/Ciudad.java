package ve.ccs.infosoft.model;

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
import jakarta.persistence.ManyToOne;
import jakarta.persistence.OneToMany;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Table(name = "ciudad")
@Data
@NoArgsConstructor
@AllArgsConstructor
public class Ciudad {
	
	 @Id
	    @GeneratedValue(strategy = GenerationType.IDENTITY)
	    @Column(name = "id_ciudad")
	    private Integer idCiudad;

	    @Column(name = "nombre", nullable = false, length = 100)
	    private String nombre;

	    @ManyToOne(fetch = FetchType.LAZY)
	    @JoinColumn(name = "id_estado", nullable = false)
	    @JsonBackReference("estado-ciudad")
	    private Estado estado;
	    
	    @OneToMany(mappedBy = "ciudad")
	    @JsonManagedReference("ciudad-cliente")
	    private List<Cliente> clientes;

		public List<Cliente> getClientes() {
			return clientes;
		}

		public void setClientes(List<Cliente> clientes) {
			this.clientes = clientes;
		}

		public Integer getIdCiudad() {
			return idCiudad;
		}

		public void setIdCiudad(Integer idCiudad) {
			this.idCiudad = idCiudad;
		}

		public String getNombre() {
			return nombre;
		}

		public void setNombre(String nombre) {
			this.nombre = nombre;
		}

		public Estado getEstado() {
			return estado;
		}

		public void setEstado(Estado estado) {
			this.estado = estado;
		}
	    
	    
	    

}
