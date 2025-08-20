package ve.ccs.infosoft.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import ve.ccs.infosoft.model.Ciudad;

@Repository
public interface CiudadRepository extends JpaRepository<Ciudad,Integer> {

	 List<Ciudad> findByEstadoIdEstado(Integer idEstado);
	
}
