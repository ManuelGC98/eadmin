package es.fpdual.eadmin.eadmin.modelo;

import java.util.Date;

public class AdministracionElectronicaBase {

	protected Integer codigo;
	protected String nombre;
	protected Date fechaCreacion;
	protected Boolean publico;

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
