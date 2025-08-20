package ve.ccs.infosoft.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import ve.ccs.infosoft.model.Instrumento;

@Repository
public interface InstrumentoRepository extends JpaRepository<Instrumento, Integer> {

}
