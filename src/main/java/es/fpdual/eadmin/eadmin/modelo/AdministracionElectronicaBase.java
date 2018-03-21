package es.fpdual.eadmin.eadmin.modelo;

import java.util.Date;

public class AdministracionElectronicaBase {

	private Integer codigo;
	private String nombre;
	private Date fechaCreacion;
	private Boolean publico;

	public AdministracionElectronicaBase(Integer codigo, String nombre, Date fechaCreacion, Boolean publico) {
		this.codigo = codigo;
		this.nombre = nombre;
		this.fechaCreacion = fechaCreacion;
		this.publico = publico;
	}

	public Integer getCodigo() {
		return codigo;
	}

	public String getNombre() {
		return nombre;
	}

	public Date getFechaCreacion() {
		return fechaCreacion;
	}

	public Boolean getPublico() {
		return publico;
	}
}
