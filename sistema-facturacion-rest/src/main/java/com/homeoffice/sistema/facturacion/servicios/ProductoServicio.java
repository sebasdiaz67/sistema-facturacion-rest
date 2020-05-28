package com.homeoffice.sistema.facturacion.servicios;

import java.util.List;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import com.homeoffice.sistema.facturacion.modelo.entidades.Producto;

/**
 * <p>
 * Clase que define la interfaz del servicio producto
 * </p>
 * 
 * @author Sebastian Rosero Diaz
 * @fechaCreacion 27/05/2020
 * @version 1.0
 *
 */

public interface ProductoServicio {

	public List<Producto> buscarTodo();

	public Page<Producto> buscarTodo(Pageable pageable);

	public Producto buscarPorId(Long id);

	public Producto guardar(Producto producto);
}
