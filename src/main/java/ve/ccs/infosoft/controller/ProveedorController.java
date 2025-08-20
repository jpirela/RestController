package ve.ccs.infosoft.controller;


import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.http.ResponseEntity.BodyBuilder;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import ve.ccs.infosoft.model.Proveedor;
import ve.ccs.infosoft.service.ProveedorService;

@RestController
@RequestMapping("/api/proveedores")
@CrossOrigin(origins = "*")
public class ProveedorController {
	
	
	 @Autowired
	    private ProveedorService proveedorService;

	    // ===== OPERACIONES CRUD BÁSICAS =====

	    @GetMapping
	    public ResponseEntity<List<Proveedor>> getAllProveedores() {
	        try {
	            List<Proveedor> proveedores = proveedorService.findAll();
	            return ResponseEntity.ok(proveedores);
	        } catch (Exception e) {
	            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).build();
	        }
	    }

	    @GetMapping("/{id}")
	    public ResponseEntity<Proveedor> getProveedorById(@PathVariable Integer id) {
	        try {
	            Optional<Proveedor> proveedor = proveedorService.findById(id);
	            return proveedor.map(ResponseEntity::ok)
	                          .orElse(ResponseEntity.notFound().build());
	        } catch (Exception e) {
	            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).build();
	        }
	    }

	    @PostMapping
	    public ResponseEntity<Map<String, Object>> createProveedor(@RequestBody Proveedor proveedor) {
	        Map<String, Object> response = new HashMap<>();
	        try {
	            Proveedor nuevoProveedor = proveedorService.save(proveedor);
	            response.put("proveedor", nuevoProveedor);
	            response.put("mensaje", "Proveedor creado exitosamente");
	            response.put("success", true);
	            return ResponseEntity.status(HttpStatus.CREATED).body(response);
	        } catch (IllegalArgumentException e) {
	            response.put("mensaje", e.getMessage());
	            response.put("success", false);
	            return ResponseEntity.badRequest().body(response);
	        } catch (Exception e) {
	            response.put("mensaje", "Error interno del servidor");
	            response.put("success", false);
	            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body(response);
	        }
	    }

	    @PutMapping("/{id}")
	    public ResponseEntity<Map<String, Object>> updateProveedor(@PathVariable Integer id, 
	                                                              @RequestBody Proveedor proveedor) {
	        Map<String, Object> response = new HashMap<>();
	        try {
	            Proveedor proveedorActualizado = proveedorService.update(id, proveedor);
	            response.put("proveedor", proveedorActualizado);
	            response.put("mensaje", "Proveedor actualizado exitosamente");
	            response.put("success", true);
	            return ResponseEntity.ok(response);
	        } catch (RuntimeException e) {
	            response.put("mensaje", e.getMessage());
	            response.put("success", false);
	            return ((BodyBuilder) ResponseEntity.notFound()).body(response);
	        } catch (Exception e) {
	            response.put("mensaje", "Error interno del servidor");
	            response.put("success", false);
	            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body(response);
	        }
	    }

	    @DeleteMapping("/{id}")
	    public ResponseEntity<Map<String, Object>> deleteProveedor(@PathVariable Integer id) {
	        Map<String, Object> response = new HashMap<>();
	        try {
	            proveedorService.deleteById(id);
	            response.put("mensaje", "Proveedor eliminado exitosamente");
	            response.put("success", true);
	            return ResponseEntity.ok(response);

	        } catch (RuntimeException e) {
	            response.put("mensaje", e.getMessage());
	            response.put("success", false);
	            return ((BodyBuilder) ResponseEntity.notFound()).body(response);
	        } catch (Exception e) {
	            response.put("mensaje", "Error interno del servidor");
	            response.put("success", false);
	            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body(response);
	        }
	    }
	    
	    @PostMapping("/lote")
	    public ResponseEntity<List<Proveedor>> insertarProveedores(@RequestBody List<Proveedor> proveedores) {
	        List<Proveedor> guardados = proveedorService.guardarTodos(proveedores);
	        return ResponseEntity.ok(guardados);
	    }
	    
	    @GetMapping("/paginado")
	    public ResponseEntity<Page<Proveedor>> getProveedoresPaginados(
	            @RequestParam(defaultValue = "0") int page,
	            @RequestParam(defaultValue = "10") int size) {
	        try {
	            Pageable pageable = PageRequest.of(page, size);
	            Page<Proveedor> proveedores = proveedorService.findAll(pageable);
	            return ResponseEntity.ok(proveedores);
	        } catch (Exception e) {
	            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).build();
	        }
	    }
	   

}
