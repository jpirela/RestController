package ve.ccs.infosoft.repository;

import java.time.LocalDateTime;
import java.util.List;
import java.util.Optional;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import ve.ccs.infosoft.model.Proveedor;


@Repository
public interface ProveedorRepository  extends JpaRepository<Proveedor, Integer> {
	
    // Buscar proveedor por nombre (exacto)
    Optional<Proveedor> findByNombre(String nombre);

    // Buscar proveedores que contengan el nombre especificado (case insensitive)
    List<Proveedor> findByNombreContainingIgnoreCase(String nombre);

    // Buscar proveedores por correo electrónico
    Optional<Proveedor> findByCorreo(String correo);

    // Buscar proveedores por teléfono
    List<Proveedor> findByTelefono(String telefono);

    // Buscar proveedores por contacto
    List<Proveedor> findByContactoContainingIgnoreCase(String contacto);

    // Buscar proveedores registrados después de una fecha específica
    List<Proveedor> findByFechaRegistroAfter(LocalDateTime fecha);

    // Buscar proveedores registrados entre fechas
    List<Proveedor> findByFechaRegistroBetween(LocalDateTime fechaInicio, LocalDateTime fechaFin);

    // Buscar proveedores con paginación por nombre
    Page<Proveedor> findByNombreContainingIgnoreCase(String nombre, Pageable pageable);

    // Buscar proveedores que tengan productos asociados
//    @Query("SELECT DISTINCT p FROM Proveedor p WHERE SIZE(p.productos) > 0")
//    List<Proveedor> findProveedoresConProductos();

    // Buscar proveedores que tengan pedidos
//    @Query("SELECT DISTINCT p FROM Proveedor p WHERE SIZE(p.pedidos) > 0")
//    List<Proveedor> findProveedoresConPedidos();

    // Buscar proveedores que tengan distribuidores
    @Query("SELECT DISTINCT p FROM Proveedor p WHERE SIZE(p.distribuidores) > 0")
    List<Proveedor> findProveedoresConDistribuidores();

    // Buscar proveedores asociados a un cliente específico
//    @Query("SELECT p FROM Proveedor p JOIN p.clientes c WHERE c.idCliente = :clienteId")
//    List<Proveedor> findProveedoresByClienteId(@Param("clienteId") Integer clienteId);

    // Contar productos por proveedor
//    @Query("SELECT p.idProveedor, p.nombre, COUNT(pr) as cantidadProductos " +
//           "FROM Proveedor p LEFT JOIN p.productos pr " +
//           "GROUP BY p.idProveedor, p.nombre")
//    List<Object[]> countProductosByProveedor();

    // Buscar proveedores con productos de stock bajo
//    @Query("SELECT DISTINCT p FROM Proveedor p " +
//           "JOIN p.productos pr " +
//           "WHERE pr.stock <= pr.stockMinimo")
//    List<Proveedor> findProveedoresConProductosStockBajo();

    // Buscar proveedores activos (que tengan movimientos recientes)
//    @Query("SELECT DISTINCT p FROM Proveedor p " +
//           "WHERE p.fechaRegistro > :fechaLimite " +
//           "OR EXISTS (SELECT 1 FROM Pedido ped WHERE ped.proveedor = p AND ped.fechaPedido > :fechaLimite)")
//    List<Proveedor> findProveedoresActivos(@Param("fechaLimite") LocalDateTime fechaLimite);

    // Buscar por múltiples criterios
    @Query("SELECT p FROM Proveedor p WHERE " +
           "(:nombre IS NULL OR LOWER(p.nombre) LIKE LOWER(CONCAT('%', :nombre, '%'))) AND " +
           "(:correo IS NULL OR LOWER(p.correo) LIKE LOWER(CONCAT('%', :correo, '%'))) AND " +
           "(:telefono IS NULL OR p.telefono = :telefono)")
    List<Proveedor> findByMultiplesCriterios(@Param("nombre") String nombre,
                                           @Param("correo") String correo,
                                           @Param("telefono") String telefono);

    // Verificar si existe un proveedor con el correo especificado
    boolean existsByCorreo(String correo);

    // Verificar si existe un proveedor con el teléfono especificado
    boolean existsByTelefono(String telefono);

    // Obtener proveedores ordenados por nombre
    List<Proveedor> findAllByOrderByNombreAsc();

    // Obtener proveedores ordenados por fecha de registro
    List<Proveedor> findAllByOrderByFechaRegistroDesc();

}
