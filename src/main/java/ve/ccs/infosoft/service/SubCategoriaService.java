package ve.ccs.infosoft.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import ve.ccs.infosoft.model.SubCategoria;
import ve.ccs.infosoft.repository.SubCategoriaRepository;

@Service
public class SubCategoriaService {

	@Autowired
	SubCategoriaRepository subCategoriaRepository;

	public SubCategoria save(SubCategoria subCategoria) {
		return subCategoriaRepository.save(subCategoria);
	}

	public List<SubCategoria> findAll() {
		return subCategoriaRepository.findAll();
	}

	public Page<SubCategoria> findAll(Pageable pageable) {
		return subCategoriaRepository.findAll(pageable);
	}

	public Optional<SubCategoria> findById(Integer id) {
		return subCategoriaRepository.findById(id);
	}

	public void deleteById(Integer id) {
		subCategoriaRepository.deleteById(id);
	}

	public boolean existsById(Integer id) {
		return subCategoriaRepository.existsById(id);
	}

	public List<SubCategoria> saveAll(List<SubCategoria> subCategorias) {
		return subCategoriaRepository.saveAll(subCategorias);
	}

}
