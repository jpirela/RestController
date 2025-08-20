package ve.ccs.infosoft.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import ve.ccs.infosoft.model.Estado;


@Repository
public interface EstadoRepository extends JpaRepository<Estado, Integer> {

}
