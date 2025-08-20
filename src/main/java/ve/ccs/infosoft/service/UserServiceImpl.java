package ve.ccs.infosoft.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import ve.ccs.infosoft.model.User;
import ve.ccs.infosoft.repository.UserRepository;

@Service
public class UserServiceImpl implements UserService {

	
	@Autowired
	UserRepository userRepository;
	
	@Override
	public List<User> getAllUser() {
		// TODO Auto-generated method stub
		return userRepository.findAll();
	}


	@Override
	public User createUser(User user) {
		return userRepository.save(user);
	}


	@Override
	public Optional<User> finById(Long id) {
		// TODO Auto-generated method stub
		return userRepository.findById(id);
	}


	@Override
	public User updateUser(User user) {
		User existingUser = userRepository.findById(user.getId()).get();
	
			
		existingUser.setApellido(user.getApellido());
		existingUser.setCod_usuario(user.getCod_usuario());
		existingUser.setCorreo(user.getCorreo());
		existingUser.setNombre(user.getNombre());
		existingUser.setPerfil(user.getPerfil());
		existingUser.setPregunta_seguridad(user.getPregunta_seguridad());
		existingUser.setCod_usuario(user.getCod_usuario());
		
		User updateUser = userRepository.save(existingUser); 
		
		return updateUser;
	}


	@Override
	public void deleteUser(Long id) {
		userRepository.deleteById(id);
		
	}
	
	

}
