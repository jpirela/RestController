package ve.ccs.infosoft.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import ve.ccs.infosoft.model.Producto;
import ve.ccs.infosoft.repository.ProductoRepository;

@Service
public class ProductoService {

	@Autowired
	ProductoRepository productoRepository;

	public Producto save(Producto producto) {
		return productoRepository.save(producto);
	}

	public List<Producto> findAll() {
		return productoRepository.findAll();
	}

	public Page<Producto> findAll(Pageable pageable) {
		return productoRepository.findAll(pageable);
	}

	public Optional<Producto> findById(Integer id) {
		return productoRepository.findById(id);
	}

	public void deleteById(Integer id) {
		productoRepository.deleteById(id);
	}

	public boolean existsById(Integer id) {
		return productoRepository.existsById(id);
	}

	public List<Producto> saveAll(List<Producto> productos) {
		return productoRepository.saveAll(productos);
	}

}
