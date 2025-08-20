package ve.ccs.infosoft.service;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageImpl;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import jakarta.transaction.Transactional;
import ve.ccs.infosoft.DTO.DistribuidorDTO;
import ve.ccs.infosoft.model.Distribuidor;
import ve.ccs.infosoft.model.Proveedor;
import ve.ccs.infosoft.repository.DistribuidorRepository;
import ve.ccs.infosoft.repository.ProveedorRepository;

@Service
@Transactional
public class DistribuidorService {

	 @Autowired
	    private DistribuidorRepository distribuidorRepository;

	    @Autowired
	    private ProveedorRepository proveedorRepository;

	    // Operaciones CRUD básicas
	    public List<Distribuidor> findAll() {
	        return distribuidorRepository.findAll();
	    }
	    
	    public List<Distribuidor> guardarTodos(List<Distribuidor> distribuidores) {
	        return distribuidorRepository.saveAll(distribuidores);
	    }
	    
	    
	    public Page<DistribuidorDTO> listarDistribuidoresPaginados(Pageable pageable) {
	        var paginaDistribuidores = distribuidorRepository.findAll(pageable);
	        var listaDTO = paginaDistribuidores.getContent()
	                .stream()
	                .map(this::convertirADTO)
	                .collect(Collectors.toList());
	        
	        return new PageImpl<>(listaDTO, pageable, paginaDistribuidores.getTotalElements());
	    }
	    
	    
	    private DistribuidorDTO convertirADTO(Distribuidor distribuidor) {
	        DistribuidorDTO dto = new DistribuidorDTO();
	        dto.setIdDistribuidor(distribuidor.getIdDistribuidor());
	        dto.setNombreContacto(distribuidor.getNombreContacto());
	        dto.setTelefono(distribuidor.getTelefono());
	        dto.setCorreo(distribuidor.getCorreo());
	        dto.setZonaDistribucion(distribuidor.getZonaDistribucion());
	        
	        if (distribuidor.getProveedor() != null) {
	            dto.setIdProveedor(distribuidor.getProveedor().getIdProveedor());
	            
	        }
	        
	        return dto;
	    }

	    public Optional<Distribuidor> findById(Integer id) {
	        return distribuidorRepository.findById(id);
	    }

	    public Distribuidor save(Distribuidor distribuidor) {
	        // Validar datos antes de guardar
	        validateDistribuidor(distribuidor);
	        
	        return distribuidorRepository.save(distribuidor);
	    }

	    public Distribuidor update(Integer id, Distribuidor distribuidorActualizado) {
	        Optional<Distribuidor> distribuidorExistente = distribuidorRepository.findById(id);
	        if (distribuidorExistente.isPresent()) {
	            Distribuidor distribuidor = distribuidorExistente.get();
	            
	            // Actualizar campos
	            distribuidor.setNombreContacto(distribuidorActualizado.getNombreContacto());
	            distribuidor.setTelefono(distribuidorActualizado.getTelefono());
	            distribuidor.setCorreo(distribuidorActualizado.getCorreo());
	            distribuidor.setZonaDistribucion(distribuidorActualizado.getZonaDistribucion());
	            distribuidor.setProveedor(distribuidorActualizado.getProveedor());
	            
	            // Validar antes de actualizar
	            validateDistribuidorForUpdate(distribuidor);
	            
	            return distribuidorRepository.save(distribuidor);
	        }
	        throw new RuntimeException("Distribuidor no encontrado con ID: " + id);
	    }

	    public void deleteById(Integer id) {
	        if (distribuidorRepository.existsById(id)) {
	            distribuidorRepository.deleteById(id);
	        } else {
	            throw new RuntimeException("Distribuidor no encontrado con ID: " + id);
	        }
	    }

	    // Métodos de búsqueda específicos
	    public List<Distribuidor> findByProveedor(Proveedor proveedor) {
	        return distribuidorRepository.findByProveedor(proveedor);
	    }

	    public List<Distribuidor> findByProveedorId(Integer proveedorId) {
	        return distribuidorRepository.findByProveedorIdProveedor(proveedorId);
	    }

	    public List<Distribuidor> findByNombreContacto(String nombreContacto) {
	        return distribuidorRepository.findByNombreContactoContainingIgnoreCase(nombreContacto);
	    }

	    public Optional<Distribuidor> findByTelefono(String telefono) {
	        return distribuidorRepository.findByTelefono(telefono);
	    }

	    public Optional<Distribuidor> findByCorreo(String correo) {
	        return distribuidorRepository.findByCorreo(correo);
	    }

	    public List<Distribuidor> findByZonaDistribucion(String zonaDistribucion) {
	        return distribuidorRepository.findByZonaDistribucionContainingIgnoreCase(zonaDistribucion);
	    }

	    public List<Distribuidor> findByZonaDistribucionExacta(String zonaDistribucion) {
	        return distribuidorRepository.findByZonaDistribucion(zonaDistribucion);
	    }

	    // Métodos con paginación
	    public Page<Distribuidor> findAll(Pageable pageable) {
	        return distribuidorRepository.findAll(pageable);
	    }

	    public Page<Distribuidor> findByNombreContacto(String nombreContacto, Pageable pageable) {
	        return distribuidorRepository.findByNombreContactoContainingIgnoreCase(nombreContacto, pageable);
	    }

	    public Page<Distribuidor> findByZonaDistribucion(String zonaDistribucion, Pageable pageable) {
	        return distribuidorRepository.findByZonaDistribucionContainingIgnoreCase(zonaDistribucion, pageable);
	    }

	    public Page<Distribuidor> findByProveedorId(Integer proveedorId, Pageable pageable) {
	        return distribuidorRepository.findByProveedorIdProveedor(proveedorId, pageable);
	    }

	    // Métodos de consultas avanzadas
	    public List<String> findDistinctZonasDistribucion() {
	        return distribuidorRepository.findDistinctZonasDistribucion();
	    }

	    public List<Distribuidor> findAllWithProveedor() {
	        return distribuidorRepository.findAllWithProveedor();
	    }

	    public List<Distribuidor> findByNombreProveedor(String nombreProveedor) {
	        return distribuidorRepository.findByNombreProveedor(nombreProveedor);
	    }

	    public List<Object[]> getEstadisticasDistribuidoresPorZona() {
	        return distribuidorRepository.countDistribuidoresByZona();
	    }

	    public List<Object[]> getEstadisticasDistribuidoresPorProveedor() {
	        return distribuidorRepository.countDistribuidoresByProveedor();
	    }

	    public List<Distribuidor> findDistribuidoresConContactoCompleto() {
	        return distribuidorRepository.findDistribuidoresConContactoCompleto();
	    }

	    public List<Distribuidor> findByMultiplesCriterios(String nombreContacto, String zonaDistribucion, Integer proveedorId) {
	        return distribuidorRepository.findByMultiplesCriterios(nombreContacto, zonaDistribucion, proveedorId);
	    }

	    public List<Distribuidor> findByZonasDistribucion(List<String> zonas) {
	        return distribuidorRepository.findByZonasDistribucion(zonas);
	    }

	    public List<Distribuidor> findDistribuidoresActivos() {
	        return distribuidorRepository.findDistribuidoresActivos();
	    }

	    public List<Distribuidor> findDistribuidoresSinZona() {
	        return distribuidorRepository.findDistribuidoresSinZona();
	    }

	    public Object[] getEstadisticasGenerales() {
	        return distribuidorRepository.getEstadisticasDistribuidores();
	    }

	    // Métodos de validación
	    public boolean existsByCorreo(String correo) {
	        return distribuidorRepository.existsByCorreo(correo);
	    }

	    public boolean existsByTelefono(String telefono) {
	        return distribuidorRepository.existsByTelefono(telefono);
	    }

	    public boolean existsByProveedorId(Integer proveedorId) {
	        return distribuidorRepository.existsByProveedorIdProveedor(proveedorId);
	    }

	    public boolean existsById(Integer id) {
	        return distribuidorRepository.existsById(id);
	    }

	    // Métodos de ordenamiento
	    public List<Distribuidor> findAllOrderByNombreContacto() {
	        return distribuidorRepository.findAllByOrderByNombreContactoAsc();
	    }

	    public List<Distribuidor> findAllOrderByZonaDistribucion() {
	        return distribuidorRepository.findAllByOrderByZonaDistribucionAsc();
	    }

	    public List<Distribuidor> findByProveedorIdOrderByZona(Integer proveedorId) {
	        return distribuidorRepository.findByProveedorIdProveedorOrderByZonaDistribucionAsc(proveedorId);
	    }

	    // Métodos de validación privados
	    private void validateDistribuidor(Distribuidor distribuidor) {
	        if (distribuidor.getNombreContacto() == null || distribuidor.getNombreContacto().trim().isEmpty()) {
	            throw new IllegalArgumentException("El nombre de contacto del distribuidor es obligatorio");
	        }
	        
	        if (distribuidor.getProveedor() == null || distribuidor.getProveedor().getIdProveedor() == null) {
	            throw new IllegalArgumentException("El distribuidor debe estar asociado a un proveedor");
	        }
	        
	        // Verificar que el proveedor existe
	        if (!proveedorRepository.existsById(distribuidor.getProveedor().getIdProveedor())) {
	            throw new IllegalArgumentException("El proveedor especificado no existe");
	        }
	        
	        if (distribuidor.getCorreo() != null && !distribuidor.getCorreo().trim().isEmpty()) {
	            if (existsByCorreo(distribuidor.getCorreo())) {
	                throw new IllegalArgumentException("Ya existe un distribuidor con este correo electrónico");
	            }
	        }
	        
	        if (distribuidor.getTelefono() != null && !distribuidor.getTelefono().trim().isEmpty()) {
	            if (existsByTelefono(distribuidor.getTelefono())) {
	                throw new IllegalArgumentException("Ya existe un distribuidor con este teléfono");
	            }
	        }
	    }

	    private void validateDistribuidorForUpdate(Distribuidor distribuidor) {
	        if (distribuidor.getNombreContacto() == null || distribuidor.getNombreContacto().trim().isEmpty()) {
	            throw new IllegalArgumentException("El nombre de contacto del distribuidor es obligatorio");
	        }
	        
	        if (distribuidor.getProveedor() == null || distribuidor.getProveedor().getIdProveedor() == null) {
	            throw new IllegalArgumentException("El distribuidor debe estar asociado a un proveedor");
	        }
	        
	        // Verificar que el proveedor existe
	        if (!proveedorRepository.existsById(distribuidor.getProveedor().getIdProveedor())) {
	            throw new IllegalArgumentException("El proveedor especificado no existe");
	        }
	        
	        // Verificar duplicados excluyendo el mismo distribuidor
	        if (distribuidor.getCorreo() != null && !distribuidor.getCorreo().trim().isEmpty()) {
	            Optional<Distribuidor> existingByCorreo = distribuidorRepository.findByCorreo(distribuidor.getCorreo());
	            if (existingByCorreo.isPresent() && !existingByCorreo.get().getIdDistribuidor().equals(distribuidor.getIdDistribuidor())) {
	                throw new IllegalArgumentException("Ya existe otro distribuidor con este correo electrónico");
	            }
	        }
	        
	        if (distribuidor.getTelefono() != null && !distribuidor.getTelefono().trim().isEmpty()) {
	            Optional<Distribuidor> existingByTelefono = distribuidorRepository.findByTelefono(distribuidor.getTelefono());
	            if (existingByTelefono.isPresent() && !existingByTelefono.get().getIdDistribuidor().equals(distribuidor.getIdDistribuidor())) {
	                throw new IllegalArgumentException("Ya existe otro distribuidor con este teléfono");
	            }
	        }
	    }

	    // Métodos de utilidad
	    public long count() {
	        return distribuidorRepository.count();
	    }

	    public long countByProveedorId(Integer proveedorId) {
	        return distribuidorRepository.findByProveedorIdProveedor(proveedorId).size();
	    }

	    public List<Distribuidor> findDistribuidoresSinContacto() {
	        List<Distribuidor> todosLosDistribuidores = distribuidorRepository.findAll();
	        List<Distribuidor> distribuidoresConContacto = distribuidorRepository.findDistribuidoresConContactoCompleto();
	        
	        todosLosDistribuidores.removeAll(distribuidoresConContacto);
	        return todosLosDistribuidores;
	    }

	    // Métodos de negocio específicos
	    public Distribuidor asignarDistribuidorAProveedor(Integer proveedorId, Distribuidor distribuidor) {
	        Optional<Proveedor> proveedor = proveedorRepository.findById(proveedorId);
	        if (proveedor.isPresent()) {
	            distribuidor.setProveedor(proveedor.get());
	            return save(distribuidor);
	        }
	        throw new RuntimeException("Proveedor no encontrado con ID: " + proveedorId);
	    }

	    public List<Distribuidor> findDistribuidoresPorProveedorYZona(Integer proveedorId, String zona) {
	        return findByMultiplesCriterios(null, zona, proveedorId);
	    }

	    public boolean tieneDistribuidoresEnZona(String zona) {
	        return !findByZonaDistribucion(zona).isEmpty();
	    }

	    public int contarDistribuidoresPorZona(String zona) {
	        return findByZonaDistribucion(zona).size();
	    }
	
}
