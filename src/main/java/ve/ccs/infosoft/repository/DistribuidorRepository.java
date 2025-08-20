package ve.ccs.infosoft.repository;

import java.util.List;
import java.util.Optional;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import ve.ccs.infosoft.model.Distribuidor;
import ve.ccs.infosoft.model.Proveedor;

public interface DistribuidorRepository extends JpaRepository<Distribuidor, Integer> {
	
	
	
    // Buscar distribuidores por proveedor
    List<Distribuidor> findByProveedor(Proveedor proveedor);

    // Buscar distribuidores por ID de proveedor
    List<Distribuidor> findByProveedorIdProveedor(Integer proveedorId);

    // Buscar distribuidor por nombre de contacto
    List<Distribuidor> findByNombreContactoContainingIgnoreCase(String nombreContacto);

    // Buscar distribuidor por teléfono
    Optional<Distribuidor> findByTelefono(String telefono);

    // Buscar distribuidor por correo
    Optional<Distribuidor> findByCorreo(String correo);

    // Buscar distribuidores por zona de distribución
    List<Distribuidor> findByZonaDistribucionContainingIgnoreCase(String zonaDistribucion);

    // Buscar distribuidores por zona específica
    List<Distribuidor> findByZonaDistribucion(String zonaDistribucion);

    // Buscar distribuidores con paginación por nombre de contacto
    Page<Distribuidor> findByNombreContactoContainingIgnoreCase(String nombreContacto, Pageable pageable);

    // Buscar distribuidores con paginación por zona
    Page<Distribuidor> findByZonaDistribucionContainingIgnoreCase(String zonaDistribucion, Pageable pageable);

    // Buscar distribuidores por proveedor con paginación
    Page<Distribuidor> findByProveedorIdProveedor(Integer proveedorId, Pageable pageable);

    // Obtener todas las zonas de distribución únicas
    @Query("SELECT DISTINCT d.zonaDistribucion FROM Distribuidor d WHERE d.zonaDistribucion IS NOT NULL")
    List<String> findDistinctZonasDistribucion();

    // Buscar distribuidores con información completa del proveedor
    @Query("SELECT d FROM Distribuidor d JOIN FETCH d.proveedor")
    List<Distribuidor> findAllWithProveedor();

    // Buscar distribuidores por nombre de proveedor
    @Query("SELECT d FROM Distribuidor d WHERE LOWER(d.proveedor.nombre) LIKE LOWER(CONCAT('%', :nombreProveedor, '%'))")
    List<Distribuidor> findByNombreProveedor(@Param("nombreProveedor") String nombreProveedor);

    // Contar distribuidores por zona
    @Query("SELECT d.zonaDistribucion, COUNT(d) FROM Distribuidor d " +
           "WHERE d.zonaDistribucion IS NOT NULL " +
           "GROUP BY d.zonaDistribucion " +
           "ORDER BY COUNT(d) DESC")
    List<Object[]> countDistribuidoresByZona();

    // Contar distribuidores por proveedor
    @Query("SELECT p.nombre, COUNT(d) FROM Distribuidor d " +
           "JOIN d.proveedor p " +
           "GROUP BY p.idProveedor, p.nombre " +
           "ORDER BY COUNT(d) DESC")
    List<Object[]> countDistribuidoresByProveedor();

    // Buscar distribuidores que tengan contacto completo (teléfono y correo)
    @Query("SELECT d FROM Distribuidor d WHERE d.telefono IS NOT NULL AND d.correo IS NOT NULL")
    List<Distribuidor> findDistribuidoresConContactoCompleto();

    // Buscar distribuidores por múltiples criterios
    @Query("SELECT d FROM Distribuidor d WHERE " +
           "(:nombreContacto IS NULL OR LOWER(d.nombreContacto) LIKE LOWER(CONCAT('%', :nombreContacto, '%'))) AND " +
           "(:zonaDistribucion IS NULL OR LOWER(d.zonaDistribucion) LIKE LOWER(CONCAT('%', :zonaDistribucion, '%'))) AND " +
           "(:proveedorId IS NULL OR d.proveedor.idProveedor = :proveedorId)")
    List<Distribuidor> findByMultiplesCriterios(@Param("nombreContacto") String nombreContacto,
                                              @Param("zonaDistribucion") String zonaDistribucion,
                                              @Param("proveedorId") Integer proveedorId);

    // Buscar distribuidores en múltiples zonas
    @Query("SELECT d FROM Distribuidor d WHERE d.zonaDistribucion IN :zonas")
    List<Distribuidor> findByZonasDistribucion(@Param("zonas") List<String> zonas);

    // Verificar si existe un distribuidor con el correo especificado
    boolean existsByCorreo(String correo);

    // Verificar si existe un distribuidor con el teléfono especificado
    boolean existsByTelefono(String telefono);

    // Verificar si existe un distribuidor para un proveedor específico
    boolean existsByProveedorIdProveedor(Integer proveedorId);

    // Obtener distribuidores ordenados por nombre de contacto
    List<Distribuidor> findAllByOrderByNombreContactoAsc();

    // Obtener distribuidores ordenados por zona de distribución
    List<Distribuidor> findAllByOrderByZonaDistribucionAsc();

    // Buscar distribuidores por proveedor ordenados por zona
    List<Distribuidor> findByProveedorIdProveedorOrderByZonaDistribucionAsc(Integer proveedorId);

    // Buscar distribuidores activos (con información de contacto)
    @Query("SELECT d FROM Distribuidor d WHERE " +
           "(d.telefono IS NOT NULL AND d.telefono != '') OR " +
           "(d.correo IS NOT NULL AND d.correo != '')")
    List<Distribuidor> findDistribuidoresActivos();

    // Buscar distribuidores sin zona asignada
    @Query("SELECT d FROM Distribuidor d WHERE d.zonaDistribucion IS NULL OR d.zonaDistribucion = ''")
    List<Distribuidor> findDistribuidoresSinZona();

    // Obtener estadísticas de distribuidores
    @Query("SELECT " +
           "COUNT(d) as total, " +
           "COUNT(CASE WHEN d.telefono IS NOT NULL THEN 1 END) as conTelefono, " +
           "COUNT(CASE WHEN d.correo IS NOT NULL THEN 1 END) as conCorreo, " +
           "COUNT(CASE WHEN d.zonaDistribucion IS NOT NULL THEN 1 END) as conZona " +
           "FROM Distribuidor d")
    Object[] getEstadisticasDistribuidores();

}
