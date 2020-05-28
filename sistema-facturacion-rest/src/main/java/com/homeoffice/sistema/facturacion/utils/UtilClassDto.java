package com.homeoffice.sistema.facturacion.utils;

import java.io.Serializable;
import java.util.Date;

import com.homeoffice.sistema.facturacion.modelo.entidades.Categoria;
import com.homeoffice.sistema.facturacion.rest.request.CategoriaRequestDto;

/**
 * <p>
 * Clase que define los metodos de creacion y modificacion de objetos
 * </p>
 * 
 * @author Sebastian Rosero Diaz
 * @fechaCreacion 27/05/2020
 * @version 1.0
 *
 */

public class UtilClassDto implements Serializable {

	private static final long serialVersionUID = 1L;

	public static Categoria crearObjetoCategoria(CategoriaRequestDto categoriaRequest) {
		Categoria categoria = new Categoria();
		categoria.setNombre(categoriaRequest.getNombre());
		categoria.setDescripcion(categoriaRequest.getDescripcion());
		categoria.setFechaCreacion(new Date());
		categoria.setUsuarioCreacion("admin");
		categoria.setEstado(Boolean.TRUE);
		return categoria;
	}

	public static void actualizarObjetoCategoria(CategoriaRequestDto categoriaRequest, Categoria categoriaBdd) {
		categoriaBdd.setUsuarioModificacion("admin");
		categoriaBdd.setFechaModificacion(new Date());
		if (categoriaRequest.getEstado() != null && !categoriaRequest.getEstado()) {
			categoriaBdd.setEstado(Boolean.FALSE);
		} else {
			categoriaBdd.setNombre(categoriaRequest.getNombre());
			categoriaBdd.setDescripcion(categoriaRequest.getDescripcion());
		}
	}
}
