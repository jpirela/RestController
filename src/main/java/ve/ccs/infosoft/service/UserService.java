package ve.ccs.infosoft.service;

import java.util.List;
import java.util.Optional;

import ve.ccs.infosoft.model.User;

public interface UserService {

	List<User> getAllUser();
	User createUser(User user);
	Optional<User> finById(Long id);
	User updateUser(User user);
	void deleteUser(Long id);

}
