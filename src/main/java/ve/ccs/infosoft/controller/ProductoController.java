package ve.ccs.infosoft.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import ve.ccs.infosoft.model.Producto;
import ve.ccs.infosoft.service.ProductoService;

@RestController
@RequestMapping("/api/productos")
public class ProductoController {

	
	 @Autowired
	    private ProductoService productoService;

	    @PostMapping
	    public ResponseEntity<Producto> create(@RequestBody Producto producto) {
	        Producto savedProducto = productoService.save(producto);
	        return ResponseEntity.status(HttpStatus.CREATED).body(savedProducto);
	    }

	    @GetMapping
	    public ResponseEntity<List<Producto>> getAll() {
	        List<Producto> formasPago = productoService.findAll();
	        return ResponseEntity.ok(formasPago);
	    }

	    @GetMapping("/{id}")
	    public ResponseEntity<Producto> getById(@PathVariable Integer id) {
	        return productoService.findById(id)
	                .map(ResponseEntity::ok)
	                .orElse(ResponseEntity.notFound().build());
	    }

	    @PutMapping("/{id}")
	    public ResponseEntity<Producto> update(@PathVariable Integer id, @RequestBody Producto producto) {
	        if (!productoService.existsById(id)) {
	            return ResponseEntity.notFound().build();
	        }
	        producto.setIdProducto(id);
	        Producto updatedProducto = productoService.save(producto);
	        return ResponseEntity.ok(updatedProducto);
	    }

	    @DeleteMapping("/{id}")
	    public ResponseEntity<Void> delete(@PathVariable Integer id) {
	        if (!productoService.existsById(id)) {
	            return ResponseEntity.notFound().build();
	        }
	        productoService.deleteById(id);
	        return ResponseEntity.noContent().build();
	    }
	    
	    
	    @PostMapping("/lote")
	    public ResponseEntity<List<Producto>> saveAll(@RequestBody List<Producto> productos) {
	        List<Producto> guardados = productoService.saveAll(productos);
	        return ResponseEntity.ok(guardados);
	    }
	    
	    @GetMapping("/paginado")
	    public ResponseEntity<Page<Producto>> getProductoesPaginados(
	            @RequestParam(defaultValue = "0") int page,
	            @RequestParam(defaultValue = "10") int size) {
	        try {
	            PageRequest pageable = PageRequest.of(page, size);
	            Page<Producto> productos = productoService.findAll(pageable);
	            return ResponseEntity.ok(productos);
	        } catch (Exception e) {
	            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).build();
	        }
	    }
	   
	    

	
}
