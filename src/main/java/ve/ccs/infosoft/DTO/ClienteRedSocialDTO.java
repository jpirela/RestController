package ve.ccs.infosoft.DTO;

import lombok.Data;

@Data
public class ClienteRedSocialDTO {

	 private Integer id;
	    private Integer clienteId;
	    private Integer redSocialId;
	    private String usuario;
		public Integer getId() {
			return id;
		}
		public void setId(Integer id) {
			this.id = id;
		}
		public Integer getClienteId() {
			return clienteId;
		}
		public void setClienteId(Integer clienteId) {
			this.clienteId = clienteId;
		}
		public Integer getRedSocialId() {
			return redSocialId;
		}
		public void setRedSocialId(Integer redSocialId) {
			this.redSocialId = redSocialId;
		}
		public String getUsuario() {
			return usuario;
		}
		public void setUsuario(String usuario) {
			this.usuario = usuario;
		}

	

}
