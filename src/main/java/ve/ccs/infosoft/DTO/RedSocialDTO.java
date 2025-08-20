package ve.ccs.infosoft.DTO;

import lombok.Data;

@Data
public class RedSocialDTO {
	private Integer idRedSocial;
	private String plataforma;

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
