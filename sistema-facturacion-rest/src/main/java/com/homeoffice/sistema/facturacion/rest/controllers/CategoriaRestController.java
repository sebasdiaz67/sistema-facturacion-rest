package com.homeoffice.sistema.facturacion.rest.controllers;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataAccessException;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.homeoffice.sistema.facturacion.modelo.entidades.Categoria;
import com.homeoffice.sistema.facturacion.rest.request.CategoriaRequestDto;
import com.homeoffice.sistema.facturacion.servicios.CategoriaServicio;
import com.homeoffice.sistema.facturacion.utils.UtilClassDto;

/**
 * <p>
 * Clase que define a los servicios rest de categoria
 * </p>
 * 
 * @author Sebastian Rosero Diaz
 * @fechaCreacion 27/05/2020
 * @version 1.0
 *
 */

@RestController
@RequestMapping("/api")
public class CategoriaRestController {

	@Autowired
	private CategoriaServicio categoriaServicio;

	private static final String MENSAJE = "mensaje";
	private static final String ERROR = "error";
	private static final String CATEGORY = "category";

	@GetMapping("/categorias")
	public List<Categoria> findAllCategorias() {
		return categoriaServicio.buscarTodo();
	}

	@GetMapping("/categorias/page/{page}/size/{size}")
	public Page<Categoria> findAllCategorias(@PathVariable Integer page, @PathVariable Integer size) {
		Pageable pageable = PageRequest.of(page, size);
		return categoriaServicio.buscarTodo(pageable);
	}

	@GetMapping("/categorias/{id}")
	public ResponseEntity<?> findCategoryById(@PathVariable Long id) {
		Categoria category = null;
		Map<String, Object> response = new HashMap<>();
		try {
			category = categoriaServicio.buscarPorId(id);
			if (category == null) {
				response.put(MENSAJE, "No existe la categoria para el ID enviado.");
				return new ResponseEntity<>(response, HttpStatus.NOT_FOUND);
			}
		} catch (DataAccessException e) {
			response.put(MENSAJE, "Error al realizar la consulta.");
			response.put(ERROR, e.getMessage().concat(": ").concat(e.getMostSpecificCause().getMessage()));
			return new ResponseEntity<>(response, HttpStatus.INTERNAL_SERVER_ERROR);
		}
		return new ResponseEntity<>(response, HttpStatus.OK);
	}

	@PostMapping("/categorias")
	public ResponseEntity<?> createCategorias(@Valid @RequestBody CategoriaRequestDto categoriaRequest) {
		Categoria categoryToSave = null;
		Map<String, Object> response = new HashMap<>();
		try {
			Categoria cate = UtilClassDto.crearObjetoCategoria(categoriaRequest);
			categoryToSave = categoriaServicio.guardar(cate);
		} catch (DataAccessException e) {
			response.put(MENSAJE, "Error al crear la categoria.");
			response.put(ERROR, e.getMessage().concat(": ").concat(e.getMostSpecificCause().getMessage()));
			return new ResponseEntity<>(response, HttpStatus.INTERNAL_SERVER_ERROR);
		}
		response.put(MENSAJE, "La categoria ha sido creado con éxito.");
		response.put(CATEGORY, categoryToSave);
		return new ResponseEntity<>(response, HttpStatus.CREATED);
	}

	@PutMapping("/categorias")
	public ResponseEntity<?> updateCategorias(@Valid @RequestBody CategoriaRequestDto categoriaRequest) {
		Categoria CategoriaUpdated = null;
		Map<String, Object> response = new HashMap<>();
		if (categoriaRequest.getId() == null) {
			response.put(MENSAJE, "El id no puede ser vacio.");
			return new ResponseEntity<>(response, HttpStatus.BAD_REQUEST);
		} else {
			Categoria categoriaBdd = categoriaServicio.buscarPorId(categoriaRequest.getId());
			if (categoriaBdd == null) {
				response.put(MENSAJE, "No existe la categoria para el ID enviado.");
				return new ResponseEntity<>(response, HttpStatus.NOT_FOUND);
			}
			try {
				UtilClassDto.actualizarObjetoCategoria(categoriaRequest, categoriaBdd);
				CategoriaUpdated = categoriaServicio.guardar(categoriaBdd);
			} catch (DataAccessException e) {
				response.put(MENSAJE, "Error al actualizar la categoria.");
				response.put(ERROR, e.getMessage().concat(": ").concat(e.getMostSpecificCause().getMessage()));
				return new ResponseEntity<>(response, HttpStatus.INTERNAL_SERVER_ERROR);
			}
			response.put(MENSAJE, "La categoria ha sido actualizado con éxito.");
			response.put(CATEGORY, CategoriaUpdated);
			return new ResponseEntity<>(response, HttpStatus.CREATED);
		}
	}
}
