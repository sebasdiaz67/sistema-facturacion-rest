package com.homeoffice.sistema.facturacion.modelo.repositorio;

import org.springframework.data.jpa.repository.JpaRepository;

import com.homeoffice.sistema.facturacion.modelo.entidades.Producto;

/**
 * <p>
 * Clase que define la interfaz de Producto
 * </p>
 * 
 * @author Sebastian Rosero Diaz
 * @fechaCreacion 27/05/2020
 * @version 1.0
 *
 */

public interface ProductoRepositorio extends JpaRepository<Producto, Long> {

}
