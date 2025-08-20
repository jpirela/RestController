package ve.ccs.infosoft.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import ve.ccs.infosoft.model.Parroquia;
import ve.ccs.infosoft.repository.ParroquiaRepository;

@Service
public class ParroquiaService {

	
	@Autowired
	ParroquiaRepository parroquiaRepository;

	public Parroquia save(Parroquia parroquia) {
		return parroquiaRepository.save(parroquia);
	}

	public List<Parroquia> findAll() {
		return parroquiaRepository.findAll();
	}

	public Page<Parroquia> findAll(Pageable pageable) {
		return parroquiaRepository.findAll(pageable);
	}

	public Optional<Parroquia> findById(Integer id) {
		return parroquiaRepository.findById(id);
	}

	public void deleteById(Integer id) {
		parroquiaRepository.deleteById(id);
	}

	public boolean existsById(Integer id) {
		return parroquiaRepository.existsById(id);
	}

	public List<Parroquia> saveAll(List<Parroquia> parroquias) {
		return parroquiaRepository.saveAll(parroquias);
	}
	
}
