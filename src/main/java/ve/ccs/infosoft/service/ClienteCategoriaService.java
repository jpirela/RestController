package ve.ccs.infosoft.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import ve.ccs.infosoft.model.ClienteCategoria;
import ve.ccs.infosoft.repository.ClienteCategoriaRepository;

@Service
public class ClienteCategoriaService {

	
	@Autowired
	ClienteCategoriaRepository clienteCategoriaRepository;

	public ClienteCategoria save(ClienteCategoria clienteCategoria) {
		return clienteCategoriaRepository.save(clienteCategoria);
	}

	public ClienteCategoria update(ClienteCategoria clienteCategoria) {
		return clienteCategoriaRepository.save(clienteCategoria);
	}

	public List<ClienteCategoria> findAll() {
		return clienteCategoriaRepository.findAll();
	}
	
	 public void deleteById(Integer id) {
	        clienteCategoriaRepository.deleteById(id);
	    }
	
}
