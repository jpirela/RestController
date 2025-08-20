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
@Table(name = "instrumento")
@Data
@NoArgsConstructor
@AllArgsConstructor
public class Instrumento {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "id_instrumento")
	private Integer idInstrumento;

	@Column(name = "descripcion", nullable = false, length = 100)
	private String descripcion;

	@Column(name = "codigo_instrumento", nullable = false, length = 100)
	private String codInstrumento;

	public String getCodInstrumento() {
		return codInstrumento;
	}

	public void setCodInstrumento(String codInstrumento) {
		this.codInstrumento = codInstrumento;
	}

	public Integer getIdInstrumento() {
		return idInstrumento;
	}

	public void setIdInstrumento(Integer idInstrumento) {
		this.idInstrumento = idInstrumento;
	}

	public String getDescripcion() {
		return descripcion;
	}

	public void setDescripcion(String descripcion) {
		this.descripcion = descripcion;
	}

}
