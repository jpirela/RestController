package ve.ccs.infosoft.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import ve.ccs.infosoft.model.User;


@Repository
public interface UserRepository  extends JpaRepository<User, Long>{
	
	
}
