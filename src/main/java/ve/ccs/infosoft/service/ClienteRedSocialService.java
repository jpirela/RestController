package ve.ccs.infosoft.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import jakarta.transaction.Transactional;
import ve.ccs.infosoft.model.ClienteRedSocial;
import ve.ccs.infosoft.repository.ClienteRedSocialRepository;

@Service
@Transactional
public class ClienteRedSocialService {

	@Autowired
	ClienteRedSocialRepository clienteRedSocialRepository;

	public ClienteRedSocial save(ClienteRedSocial clienteRedSocial) {
		return clienteRedSocialRepository.save(clienteRedSocial);
	}

	public ClienteRedSocial update(ClienteRedSocial clienteRedSocial) {
		return clienteRedSocialRepository.save(clienteRedSocial);
	}

	public List<ClienteRedSocial> findAll() {
		return clienteRedSocialRepository.findAll();
	}
	
	 public void deleteById(Integer id) {
	        clienteRedSocialRepository.deleteById(id);
	    }

}
