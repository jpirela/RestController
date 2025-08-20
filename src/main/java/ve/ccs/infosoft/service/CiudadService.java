package ve.ccs.infosoft.service;


import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import ve.ccs.infosoft.DTO.CiudadDTO;
import ve.ccs.infosoft.model.Ciudad;
import ve.ccs.infosoft.repository.CiudadRepository;


@Service
public class CiudadService {

	
	
	@Autowired
	CiudadRepository ciudadRepository;

	public Ciudad save(Ciudad ciudad) {
		return ciudadRepository.save(ciudad);
	}

	public List<Ciudad> findAll() {
		return ciudadRepository.findAll();
	}
	
	
	public Page<Ciudad> findAll(Pageable pageable) {
		return ciudadRepository.findAll(pageable);
	}

	public Optional<Ciudad> findById(Integer id) {
		return ciudadRepository.findById(id);
	}

	public void deleteById(Integer id) {
		ciudadRepository.deleteById(id);
	}

	public boolean existsById(Integer id) {
		return ciudadRepository.existsById(id);
	}

	public List<Ciudad> saveAll(List<Ciudad> ciudads) {
		return ciudadRepository.saveAll(ciudads);
	}
	
	public List<CiudadDTO> findAllWithEstadoId() {
        return ciudadRepository.findAll().stream()
                .map(ciudad -> new CiudadDTO(
                        ciudad.getIdCiudad(),
                        ciudad.getNombre(),
                        ciudad.getEstado().getIdEstado()))
                .collect(Collectors.toList());
    }
	
	 public List<CiudadDTO> findByEstadoId(Integer estadoId) {
	        return ciudadRepository.findByEstadoIdEstado(estadoId).stream()
	                .map(ciudad -> new CiudadDTO(
	                        ciudad.getIdCiudad(),
	                        ciudad.getNombre(),
	                        ciudad.getEstado().getIdEstado()))
	                .collect(Collectors.toList());
	    }
	
}
