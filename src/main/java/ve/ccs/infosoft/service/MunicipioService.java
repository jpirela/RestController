package ve.ccs.infosoft.service;


import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import ve.ccs.infosoft.model.Municipio;
import ve.ccs.infosoft.repository.MunicipioRepository;

@Service
public class MunicipioService {

	@Autowired
	MunicipioRepository municipioRepository;

	public Municipio save(Municipio municipio) {
		return municipioRepository.save(municipio);
	}

	public List<Municipio> findAll() {
		return municipioRepository.findAll();
	}

	public Page<Municipio> findAll(Pageable pageable) {
		return municipioRepository.findAll(pageable);
	}

	public Optional<Municipio> findById(Integer id) {
		return municipioRepository.findById(id);
	}

	public void deleteById(Integer id) {
		municipioRepository.deleteById(id);
	}

	public boolean existsById(Integer id) {
		return municipioRepository.existsById(id);
	}

	public List<Municipio> saveAll(List<Municipio> municipios) {
		return municipioRepository.saveAll(municipios);
	}
}
