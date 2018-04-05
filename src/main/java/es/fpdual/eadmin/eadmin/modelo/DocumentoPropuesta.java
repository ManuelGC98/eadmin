package es.fpdual.eadmin.eadmin.modelo;

import java.util.Date;

public class DocumentoPropuesta extends Documento {

	private Integer codigo;
	private Integer ejercicio;
	private String grupoPolitico;

	public DocumentoPropuesta(Integer codigo, String nombre, Date fechaCreacion, Date fechaUltimaActualizacion,
			Boolean publico, EstadoDocumento estado, Integer cod, Integer ejercicio, String grupoPolitico) {
		super(codigo, nombre, fechaCreacion, fechaUltimaActualizacion, publico, estado);
		this.codigo = cod;
		this.ejercicio = ejercicio;
		this.grupoPolitico = grupoPolitico;
	}

	public Integer getCodigo() {
		return codigo;
	}

	public Integer getEjercicio() {
		return ejercicio;
	}

	public String getGrupoPolitico() {
		return grupoPolitico;
	}
}
