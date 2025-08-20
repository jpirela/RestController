package ve.ccs.infosoft.model;

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
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.OneToMany;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Table(name = "municipio")
@Data
@NoArgsConstructor
@AllArgsConstructor
public class Municipio {

	
	
	 @Id
	    @GeneratedValue(strategy = GenerationType.IDENTITY)
	    @Column(name = "id_municipio")
	    private Integer idMunicipio;

	    @Column(name = "nombre", nullable = false, length = 100)
	    private String nombre;

	    @ManyToOne(fetch = FetchType.LAZY)
	    @JoinColumn(name = "id_estado", nullable = false)
	    @JsonBackReference("estado-municipio")
	    private Estado estado;

	    @OneToMany(mappedBy = "municipio", cascade = CascadeType.ALL, fetch = FetchType.LAZY)
	    @JsonManagedReference("municipio-parroquia")
	    private List<Parroquia> parroquias;


	    @OneToMany(mappedBy = "municipio", cascade = CascadeType.ALL, fetch = FetchType.LAZY)
	    @JsonManagedReference("municipio-cliente")
	    private List<Cliente> clientes;

		public Integer getIdMunicipio() {
			return idMunicipio;
		}

		public void setIdMunicipio(Integer idMunicipio) {
			this.idMunicipio = idMunicipio;
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

		public List<Cliente> getClientes() {
			return clientes;
		}

		public void setClientes(List<Cliente> clientes) {
			this.clientes = clientes;
		}

		public List<Parroquia> getParroquias() {
			return parroquias;
		}

		public void setParroquias(List<Parroquia> parroquias) {
			this.parroquias = parroquias;
		}
		
		
	    
	    
	    
}
