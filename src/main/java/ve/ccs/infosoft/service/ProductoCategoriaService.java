package ve.ccs.infosoft.service;

import java.util.Set;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import jakarta.persistence.EntityNotFoundException;
import ve.ccs.infosoft.DTO.CategoriaDTO;
import ve.ccs.infosoft.DTO.ProductoCategoriaDTO;
import ve.ccs.infosoft.DTO.ProductoWithCategoriasDTO;
import ve.ccs.infosoft.model.Categoria;
import ve.ccs.infosoft.model.Producto;
import ve.ccs.infosoft.repository.CategoriaRepository;
import ve.ccs.infosoft.repository.ProductoRepository;

@Service
public class ProductoCategoriaService {

	
	  @Autowired
	    private ProductoRepository productoRepository;

	    @Autowired
	    private CategoriaRepository categoriaRepository;
	    
	    public ProductoWithCategoriasDTO addCategoriaToProducto(ProductoCategoriaDTO dto) {
	        Producto producto = productoRepository.findById(dto.productoId())
	            .orElseThrow(() -> new EntityNotFoundException("Producto no encontrado"));
	        
	        Categoria categoria = categoriaRepository.findById(dto.categoriaId())
	            .orElseThrow(() -> new EntityNotFoundException("Categoría no encontrada"));
	        
	        producto.getCategorias().add(categoria);
	        productoRepository.save(producto);
	        
	        return toProductoWithCategoriasDTO(producto);
	    }
	    
	    public void removeCategoriaFromProducto(ProductoCategoriaDTO dto) {
	        Producto producto = productoRepository.findById(dto.productoId())
	            .orElseThrow(() -> new EntityNotFoundException("Producto no encontrado"));
	        
	        producto.getCategorias().removeIf(c -> c.getIdCategoria().equals(dto.categoriaId()));
	        productoRepository.save(producto);
	    }
	    
//	    @Transactional
//	    public ProductoWithCategoriasDTO getProductoWithCategorias(Integer productoId) {
//	        return productoRepository.findById(productoId)
//	            .map(this::toProductoWithCategoriasDTO)
//	            .orElseThrow(() -> new EntityNotFoundException("Producto no encontrado"));
//	    }
	    
	    
	    public ProductoWithCategoriasDTO getProductoWithCategorias(Integer productoId) {
	        return productoRepository.findByIdWithCategorias(productoId)
	            .map(this::toProductoWithCategoriasDTO)
	            .orElseThrow(() -> new EntityNotFoundException("Producto no encontrado"));
	    }
	    
	    
	    
	    private ProductoWithCategoriasDTO toProductoWithCategoriasDTO(Producto producto) {
	        Set<CategoriaDTO> categoriasDTO = producto.getCategorias().stream()
	            .map(c -> new CategoriaDTO(c.getIdCategoria(), c.getNombre()))
	            .collect(Collectors.toSet());
	        
	        return new ProductoWithCategoriasDTO(
	            producto.getIdProducto(),
	            producto.getNombre(),
	            producto.getCodigo_producto(),
	            categoriasDTO
	        );
	    }
	    
}
