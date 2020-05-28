package com.homeoffice.sistema.facturacion.rest.request;

import java.io.Serializable;
import java.util.Date;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

/**
 * <p>
 * Clase que define a la clase dto categoria
 * </p>
 * 
 * @author Sebastian Rosero Diaz
 * @fechaCreacion 27/05/2020
 * @version 1.0
 *
 */

@NoArgsConstructor
@Getter
@Setter
public class CategoriaRequestDto implements Serializable {

	private static final long serialVersionUID = 1L;

	private Long id;
	private String nombre;
	private String descripcion;
	private Boolean estado;
	private Date fechaCreacion;
	private String usuarioCreacion;
	private Date fechaModificacion;
	private String usuarioModificacion;
}
