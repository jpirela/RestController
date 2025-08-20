package ve.ccs.infosoft.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import lombok.RequiredArgsConstructor;
import ve.ccs.infosoft.DTO.ProductoCategoriaDTO;
import ve.ccs.infosoft.DTO.ProductoWithCategoriasDTO;
import ve.ccs.infosoft.service.ProductoCategoriaService;

@RestController
@RequestMapping("/api/productos-categorias")
@RequiredArgsConstructor
public class ProductoCategoriaController {

	
	
	@Autowired
	ProductoCategoriaService productoCategoriaService;
	
	 @PostMapping
	    public ResponseEntity<ProductoWithCategoriasDTO> addCategoria(
	            @RequestBody ProductoCategoriaDTO dto) {
	        return ResponseEntity.ok(productoCategoriaService.addCategoriaToProducto(dto));
	    }

	    @DeleteMapping
	    public ResponseEntity<Void> removeCategoria(
	    		 @RequestBody ProductoCategoriaDTO dto) {
	    	productoCategoriaService.removeCategoriaFromProducto(dto);
	        return ResponseEntity.noContent().build();
	    }

	    @GetMapping("/{productoId}")
	    public ResponseEntity<ProductoWithCategoriasDTO> getProductoWithCategorias(
	            @PathVariable Integer productoId) {
	        return ResponseEntity.ok(productoCategoriaService.getProductoWithCategorias(productoId));
	    }
	
}
