package ve.ccs.infosoft.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import ve.ccs.infosoft.model.Cliente;
import ve.ccs.infosoft.repository.ClienteRepository;

@Service
public class ClienteService {

	@Autowired
	ClienteRepository clienteRepository;

	public Cliente save(Cliente cliente) {
		return clienteRepository.save(cliente);
	}

	public List<Cliente> findAll() {
		return clienteRepository.findAll();
	}

	public Page<Cliente> findAll(Pageable pageable) {
		return clienteRepository.findAll(pageable);
	}

	public Optional<Cliente> findById(Integer id) {
		return clienteRepository.findById(id);
	}

	public void deleteById(Integer id) {
		clienteRepository.deleteById(id);
	}

	public boolean existsById(Integer id) {
		return clienteRepository.existsById(id);
	}

	public List<Cliente> saveAll(List<Cliente> clientes) {
		return clienteRepository.saveAll(clientes);
	}

}
