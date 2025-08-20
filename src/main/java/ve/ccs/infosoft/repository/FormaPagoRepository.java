package ve.ccs.infosoft.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import ve.ccs.infosoft.model.FormaPago;

@Repository
public interface FormaPagoRepository extends JpaRepository<FormaPago, Integer> {
   
}