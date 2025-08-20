package ve.ccs.infosoft.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import ve.ccs.infosoft.model.Estado;
import ve.ccs.infosoft.repository.EstadoRepository;

@Service
public class EstadoService {

	@Autowired
	EstadoRepository estadoRepository;

	public Estado save(Estado estado) {
		return estadoRepository.save(estado);
	}

	public List<Estado> findAll() {
		return estadoRepository.findAll();
	}
	
	
	public Page<Estado> findAll(Pageable pageable) {
		return estadoRepository.findAll(pageable);
	}

	public Optional<Estado> findById(Integer id) {
		return estadoRepository.findById(id);
	}

	public void deleteById(Integer id) {
		estadoRepository.deleteById(id);
	}

	public boolean existsById(Integer id) {
		return estadoRepository.existsById(id);
	}

	public List<Estado> saveAll(List<Estado> estados) {
		return estadoRepository.saveAll(estados);
	}

}
