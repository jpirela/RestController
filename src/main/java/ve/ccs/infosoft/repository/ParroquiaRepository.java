package ve.ccs.infosoft.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import ve.ccs.infosoft.model.Parroquia;

@Repository
public interface ParroquiaRepository extends JpaRepository<Parroquia, Integer> {

}
