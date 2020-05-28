package com.homeoffice.sistema.facturacion.servicios.implementacion;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.homeoffice.sistema.facturacion.modelo.entidades.Producto;
import com.homeoffice.sistema.facturacion.modelo.repositorio.ProductoRepositorio;
import com.homeoffice.sistema.facturacion.servicios.ProductoServicio;

/**
 * <p>
 * Clase que define la clase del servicio producto
 * </p>
 * 
 * @author Sebastian Rosero Diaz
 * @fechaCreacion 27/05/2020
 * @version 1.0
 *
 */

@Service
public class ProductoServiceImpl implements ProductoServicio {

	@Autowired
	private ProductoRepositorio productoRepositorio;

	@Override
	@Transactional(readOnly = true)
	public List<Producto> buscarTodo() {
		return productoRepositorio.findAll();
	}

	@Override
	@Transactional(readOnly = true)
	public Page<Producto> buscarTodo(Pageable pageable) {
		return productoRepositorio.findAll(pageable);
	}

	@Override
	@Transactional(readOnly = true)
	public Producto buscarPorId(Long id) {
		return productoRepositorio.findById(id).orElse(null);
	}

	@Override
	@Transactional
	public Producto guardar(Producto producto) {
		return productoRepositorio.save(producto);
	}

}
