package ve.ccs.infosoft.service;

import java.time.LocalDateTime;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import jakarta.transaction.Transactional;
import ve.ccs.infosoft.exception.BusinessException;
import ve.ccs.infosoft.model.Proveedor;
import ve.ccs.infosoft.repository.DistribuidorRepository;
import ve.ccs.infosoft.repository.ProveedorRepository;

@Service
@Transactional
public class ProveedorService {

	@Autowired
	private ProveedorRepository proveedorRepository;
	
	@Autowired
	private  DistribuidorRepository distribuidorRepository;

	
	
	
	// Operaciones CRUD básicas
	public List<Proveedor> findAll() {
		return proveedorRepository.findAll();
	}

	public Page<Proveedor> findAll(Pageable pageable) {
		return proveedorRepository.findAll(pageable);
	}

	public Optional<Proveedor> findById(Integer id) {
		return proveedorRepository.findById(id);
	}

	public Proveedor save(Proveedor proveedor) {
		// Validar datos antes de guardar
		validateProveedor(proveedor);

		// Si es un nuevo proveedor, establecer fecha de registro
		if (proveedor.getIdProveedor() == null) {
			proveedor.setFechaRegistro(LocalDateTime.now());
		}

		return proveedorRepository.save(proveedor);
	}

	public Proveedor update(Integer id, Proveedor proveedorActualizado) {
		Optional<Proveedor> proveedorExistente = proveedorRepository.findById(id);
		if (proveedorExistente.isPresent()) {
			Proveedor proveedor = proveedorExistente.get();

			// Actualizar campos
			proveedor.setNombre(proveedorActualizado.getNombre());
			proveedor.setCorreo(proveedorActualizado.getCorreo());
			proveedor.setTelefono(proveedorActualizado.getTelefono());
			proveedor.setContacto(proveedorActualizado.getContacto());
			proveedor.setDireccion(proveedorActualizado.getDireccion());

			// Validar antes de actualizar
			validateProveedorForUpdate(proveedor);

			return proveedorRepository.save(proveedor);
		}
		throw new RuntimeException("Proveedor no encontrado con ID: " + id);
	}

	public void deleteById(Integer id) {
		if (proveedorRepository.existsById(id)) {
			
		} else {
			throw new RuntimeException("Proveedor no encontrado con ID: " + id);
		}

		if (distribuidorRepository.existsByProveedorIdProveedor(id)) {
			throw new BusinessException("No se puede eliminar el proveedor porque tiene distribuidores asociados");
		}
		
		proveedorRepository.deleteById(id);
	}

	public List<Proveedor> guardarTodos(List<Proveedor> proveedores) {
		return proveedorRepository.saveAll(proveedores);
	}

	// Métodos de validación privados
	private void validateProveedor(Proveedor proveedor) {
		if (proveedor.getNombre() == null || proveedor.getNombre().trim().isEmpty()) {
			throw new IllegalArgumentException("El nombre del proveedor es obligatorio");
		}

	}

	private void validateProveedorForUpdate(Proveedor proveedor) {
		if (proveedor.getNombre() == null || proveedor.getNombre().trim().isEmpty()) {
			throw new IllegalArgumentException("El nombre del proveedor es obligatorio");
		}

	}

	// Métodos de utilidad
	public long count() {
		return proveedorRepository.count();
	}

}
