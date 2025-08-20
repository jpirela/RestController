package ve.ccs.infosoft.model;



import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

@Entity
@Table(name = "usuarios")
public class User {

	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	
	@Column(name = "cod_usuario")
	private Long cod_usuario;
	
	@Column(name = "nombre")
	private String nombre;

	@Column(name = "apellido")
	private String apellido;

	@Column(name = "perfil")
	private String perfil;
	
	@Column(name = "correo")
	private String correo;
	
	@Column(name = "pregunta_seguridad")
	private String pregunta_seguridad;

	public User() {
		super();
		// TODO Auto-generated constructor stub
	}

	public User(long id, long cod_usuario, String nombre, String apellido, String perfil, String correo,
			String pregunta_seguridad) {
		super();
		this.id = id;
		this.cod_usuario = cod_usuario;
		this.nombre = nombre;
		this.apellido = apellido;
		this.perfil = perfil;
		this.correo = correo;
		this.pregunta_seguridad = pregunta_seguridad;
	}

	@Override
	public String toString() {
		return "User [id=" + id + ", cod_usuario=" + cod_usuario + ", nombre=" + nombre + ", apellido=" + apellido
				+ ", perfil=" + perfil + ", correo=" + correo + ", pregunta_seguridad=" + pregunta_seguridad + "]";
	}

	public long getId() {
		return id;
	}

	public void setId(long id) {
		this.id = id;
	}

	public long getCod_usuario() {
		return cod_usuario;
	}

	public void setCod_usuario(long cod_usuario) {
		this.cod_usuario = cod_usuario;
	}

	public String getNombre() {
		return nombre;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

	public String getApellido() {
		return apellido;
	}

	public void setApellido(String apellido) {
		this.apellido = apellido;
	}

	public String getPerfil() {
		return perfil;
	}

	public void setPerfil(String perfil) {
		this.perfil = perfil;
	}

	public String getCorreo() {
		return correo;
	}

	public void setCorreo(String correo) {
		this.correo = correo;
	}

	public String getPregunta_seguridad() {
		return pregunta_seguridad;
	}

	public void setPregunta_seguridad(String pregunta_seguridad) {
		this.pregunta_seguridad = pregunta_seguridad;
	}
	
}
