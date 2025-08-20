package ve.ccs.infosoft.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import ve.ccs.infosoft.model.TipoProducto;
import ve.ccs.infosoft.repository.TipoProductoRepository;

@Service
public class TipoProductoService {

	@Autowired
	TipoProductoRepository tipoProductoRepository;

	public TipoProducto save(TipoProducto tipoProducto) {
		return tipoProductoRepository.save(tipoProducto);
	}

	public List<TipoProducto> findAll() {
		return tipoProductoRepository.findAll();
	}

	public Page<TipoProducto> findAll(Pageable pageable) {
		return tipoProductoRepository.findAll(pageable);
	}

	public Optional<TipoProducto> findById(Integer id) {
		return tipoProductoRepository.findById(id);
	}

	public void deleteById(Integer id) {
		tipoProductoRepository.deleteById(id);
	}

	public boolean existsById(Integer id) {
		return tipoProductoRepository.existsById(id);
	}

	public List<TipoProducto> saveAll(List<TipoProducto> tipoProductos) {
		return tipoProductoRepository.saveAll(tipoProductos);
	}
}
