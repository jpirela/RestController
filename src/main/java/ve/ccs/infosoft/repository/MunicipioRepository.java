package ve.ccs.infosoft.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import ve.ccs.infosoft.model.Municipio;


@Repository
public interface MunicipioRepository extends JpaRepository<Municipio, Integer>  {

}
