package ve.ccs.infosoft.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import ve.ccs.infosoft.model.Pregunta;


@Repository
public interface PreguntaRepository extends JpaRepository<Pregunta, Integer> {

}
