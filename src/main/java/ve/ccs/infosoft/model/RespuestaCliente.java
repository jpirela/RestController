package ve.ccs.infosoft.model;

import java.time.LocalDateTime;

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
@Table(name = "respuesta_cliente")
@Data
@NoArgsConstructor
@AllArgsConstructor
public class RespuestaCliente {
	
	
	 @Id
	    @GeneratedValue(strategy = GenerationType.IDENTITY)
	    @Column(name = "id_respuesta")
	    private Long idRespuesta;

	    @ManyToOne
	    @JoinColumn(name = "id_cliente", nullable = false)
	    private Cliente cliente;

	    @ManyToOne
	    @JoinColumn(name = "id_pregunta", nullable = false)
	    private Pregunta pregunta;

	    @ManyToOne
	    @JoinColumn(name = "id_instrumento", nullable = false)
	    private Instrumento instrumento;

	    @Column(name = "respuesta", columnDefinition = "TEXT")
	    private String respuesta; 

	    @Column(name = "fecha_registro")
	    private LocalDateTime fechaRegistro = LocalDateTime.now();

	   
	    @Column(name = "comentarios", columnDefinition = "TEXT")
	    private String comentarios;


		public Long getIdRespuesta() {
			return idRespuesta;
		}


		public void setIdRespuesta(Long idRespuesta) {
			this.idRespuesta = idRespuesta;
		}


		public Cliente getCliente() {
			return cliente;
		}


		public void setCliente(Cliente cliente) {
			this.cliente = cliente;
		}


		public Pregunta getPregunta() {
			return pregunta;
		}


		public void setPregunta(Pregunta pregunta) {
			this.pregunta = pregunta;
		}


		public Instrumento getInstrumento() {
			return instrumento;
		}


		public void setInstrumento(Instrumento instrumento) {
			this.instrumento = instrumento;
		}


		public String getRespuesta() {
			return respuesta;
		}


		public void setRespuesta(String respuesta) {
			this.respuesta = respuesta;
		}


		public LocalDateTime getFechaRegistro() {
			return fechaRegistro;
		}


		public void setFechaRegistro(LocalDateTime fechaRegistro) {
			this.fechaRegistro = fechaRegistro;
		}


		public String getComentarios() {
			return comentarios;
		}


		public void setComentarios(String comentarios) {
			this.comentarios = comentarios;
		}
	    
	    
	    
	

}
