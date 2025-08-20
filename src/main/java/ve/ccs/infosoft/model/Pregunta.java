package ve.ccs.infosoft.model;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Table(name = "pregunta")
@Data
@NoArgsConstructor
@AllArgsConstructor
public class Pregunta {

	
	 @Id
	    @GeneratedValue(strategy = GenerationType.IDENTITY)
	    @Column(name = "id_pregunta")
	    private Integer idPregunta;

	    @Column(name = "descripcion", nullable = false, length = 100,unique = true)
	    private String descripcion;

		public Integer getIdPregunta() {
			return idPregunta;
		}

		public void setIdPregunta(Integer idPregunta) {
			this.idPregunta = idPregunta;
		}

		public String getDescripcion() {
			return descripcion;
		}

		public void setDescripcion(String descripcion) {
			this.descripcion = descripcion;
		}
	    
	    
	    
	    
	
}
