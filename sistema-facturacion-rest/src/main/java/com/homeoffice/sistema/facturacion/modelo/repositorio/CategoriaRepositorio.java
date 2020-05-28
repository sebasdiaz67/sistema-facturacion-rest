package com.homeoffice.sistema.facturacion.modelo.repositorio;

import org.springframework.data.jpa.repository.JpaRepository;

import com.homeoffice.sistema.facturacion.modelo.entidades.Categoria;

/**
 * <p>
 * Clase que define la interfaz de Categoria
 * </p>
 * 
 * @author Sebastian Rosero Diaz
 * @fechaCreacion 27/05/2020
 * @version 1.0
 *
 */

public interface CategoriaRepositorio extends JpaRepository<Categoria, Long> {

}
