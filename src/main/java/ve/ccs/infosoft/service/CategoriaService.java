package ve.ccs.infosoft.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import ve.ccs.infosoft.model.Categoria;
import ve.ccs.infosoft.repository.CategoriaRepository;

@Service
public class CategoriaService {

	@Autowired
	CategoriaRepository categoriaRepository;

	public Categoria save(Categoria categoria) {
		return categoriaRepository.save(categoria);
	}

	public List<Categoria> findAll() {
		return categoriaRepository.findAll();
	}
	
	
	public Page<Categoria> findAll(Pageable pageable) {
		return categoriaRepository.findAll(pageable);
	}

	public Optional<Categoria> findById(Integer id) {
		return categoriaRepository.findById(id);
	}

	public void deleteById(Integer id) {
		categoriaRepository.deleteById(id);
	}

	public boolean existsById(Integer id) {
		return categoriaRepository.existsById(id);
	}

	public List<Categoria> saveAll(List<Categoria> categorias) {
		return categoriaRepository.saveAll(categorias);
	}
	
	
}
