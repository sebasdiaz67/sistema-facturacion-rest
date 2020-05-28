package com.homeoffice.sistema.facturacion.servicios.implementacion;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.homeoffice.sistema.facturacion.modelo.entidades.Categoria;
import com.homeoffice.sistema.facturacion.modelo.repositorio.CategoriaRepositorio;
import com.homeoffice.sistema.facturacion.servicios.CategoriaServicio;

/**
 * <p>
 * Clase que define la clase del servicio categoria
 * </p>
 * 
 * @author Sebastian Rosero Diaz
 * @fechaCreacion 27/05/2020
 * @version 1.0
 *
 */

@Service
public class CategoriaServicioImpl implements CategoriaServicio {

	@Autowired
	private CategoriaRepositorio categoriaRepositorio;

	@Override
	@Transactional(readOnly = true)
	public List<Categoria> buscarTodo() {
		return categoriaRepositorio.findAll();
	}

	@Override
	@Transactional(readOnly = true)
	public Page<Categoria> buscarTodo(Pageable pageable) {
		return categoriaRepositorio.findAll(pageable);
	}

	@Override
	@Transactional(readOnly = true)
	public Categoria buscarPorId(Long id) {
		return categoriaRepositorio.findById(id).orElse(null);
	}

	@Override
	@Transactional
	public Categoria guardar(Categoria categoria) {
		return categoriaRepositorio.save(categoria);
	}

}
