package ve.ccs.infosoft.controller;

import java.util.List;
import java.util.Map;
import java.util.Optional;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.web.PageableDefault;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import ve.ccs.infosoft.DTO.DistribuidorDTO;
import ve.ccs.infosoft.model.Distribuidor;
import ve.ccs.infosoft.repository.DistribuidorRepository;
import ve.ccs.infosoft.service.DistribuidorService;

@RestController
@RequestMapping("/api/distribuidores")
@CrossOrigin(origins = "*")
public class DistribuidorController {

	

	
    @Autowired
    private DistribuidorService distribuidorService;
    
    @Autowired
    private DistribuidorRepository distribuidorRepository;
    
    // ==================== OPERACIONES CRUD BÁSICAS ====================

    @GetMapping
    public ResponseEntity<List<Distribuidor>> getAllDistribuidores() {
        try {
            List<Distribuidor> distribuidores = distribuidorService.findAll();
            return ResponseEntity.ok(distribuidores);
        } catch (Exception e) {
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).build();
        }
    }
    
    
    @GetMapping("/proveedorID")
    public List<DistribuidorDTO> listarTodos() {
        return distribuidorRepository.findAll().stream()
            .map(this::convertirADTO)
            .collect(Collectors.toList());
    }

    private DistribuidorDTO convertirADTO(Distribuidor distribuidor) {
        DistribuidorDTO dto = new DistribuidorDTO();
        dto.setIdDistribuidor(distribuidor.getIdDistribuidor());
        dto.setNombreContacto(distribuidor.getNombreContacto());
        dto.setTelefono(distribuidor.getTelefono());
        dto.setCorreo(distribuidor.getCorreo());
        dto.setZonaDistribucion(distribuidor.getZonaDistribucion());
        
        // Mapear datos del proveedor
        if (distribuidor.getProveedor() != null) {
            dto.setIdProveedor(distribuidor.getProveedor().getIdProveedor());
            
        }
        
        return dto;
    }
    
    
    @GetMapping("/proveedorID/paginado")
    public Page<DistribuidorDTO> listarDistribuidores(
            @PageableDefault(size = 10, sort = "nombreContacto") Pageable pageable) {
        return distribuidorService.listarDistribuidoresPaginados(pageable);
    }
  

    @GetMapping("/{id}")
    public ResponseEntity<Distribuidor> getDistribuidorById(@PathVariable Integer id) {
        try {
            Optional<Distribuidor> distribuidor = distribuidorService.findById(id);
            return distribuidor.map(ResponseEntity::ok)
                    .orElse(ResponseEntity.notFound().build());
        } catch (Exception e) {
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).build();
        }
    }

    @PostMapping
    public ResponseEntity<?> createDistribuidor(@RequestBody Distribuidor distribuidor) {
        try {
            Distribuidor nuevoDistribuidor = distribuidorService.save(distribuidor);
            return ResponseEntity.status(HttpStatus.CREATED).body(nuevoDistribuidor);
        } catch (IllegalArgumentException e) {
            return ResponseEntity.badRequest().body(Map.of("error", e.getMessage()));
        } catch (Exception e) {
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR)
                    .body(Map.of("error", "Error interno del servidor"));
        }
    }
    
    
    
    @PostMapping("/lote")
    public ResponseEntity<List<Distribuidor>> insertardistribuidores(@RequestBody List<Distribuidor> distribuidores) {
        List<Distribuidor> guardados = distribuidorService.guardarTodos(distribuidores);
        return ResponseEntity.ok(guardados);
    }

    @PutMapping("/{id}")
    public ResponseEntity<?> updateDistribuidor(@PathVariable Integer id, 
                                              @RequestBody Distribuidor distribuidor) {
        try {
            Distribuidor distribuidorActualizado = distribuidorService.update(id, distribuidor);
            return ResponseEntity.ok(distribuidorActualizado);
        } catch (IllegalArgumentException e) {
            return ResponseEntity.badRequest().body(Map.of("error", e.getMessage()));
        } catch (RuntimeException e) {
            return ResponseEntity.notFound().build();
        } catch (Exception e) {
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR)
                    .body(Map.of("error", "Error interno del servidor"));
        }
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<?> deleteDistribuidor(@PathVariable Integer id) {
        try {
            distribuidorService.deleteById(id);
            return ResponseEntity.noContent().build();
        } catch (RuntimeException e) {
            return ResponseEntity.notFound().build();
        } catch (Exception e) {
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR)
                    .body(Map.of("error", "Error interno del servidor"));
        }
    }
}
