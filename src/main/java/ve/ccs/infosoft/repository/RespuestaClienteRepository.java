package ve.ccs.infosoft.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import ve.ccs.infosoft.model.RespuestaCliente;

@Repository
public interface RespuestaClienteRepository extends JpaRepository<RespuestaCliente, Integer> {

}
