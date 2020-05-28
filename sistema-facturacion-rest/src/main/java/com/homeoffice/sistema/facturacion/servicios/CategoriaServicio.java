package com.homeoffice.sistema.facturacion.servicios;

import java.util.List;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import com.homeoffice.sistema.facturacion.modelo.entidades.Categoria;

/**
 * <p>
 * Clase que define la interfaz del servicio categoria
 * </p>
 * 
 * @author Sebastian Rosero Diaz
 * @fechaCreacion 27/05/2020
 * @version 1.0
 *
 */

public interface CategoriaServicio {

	public List<Categoria> buscarTodo();

	public Page<Categoria> buscarTodo(Pageable pageable);

	public Categoria buscarPorId(Long id);

	public Categoria guardar(Categoria categoria);
}
