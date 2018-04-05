package es.fpdual.eadmin.eadmin.modelo;

import java.util.Date;

public class Documento extends AdministracionElectronicaBase {

	private EstadoDocumento estado;

	public Documento(Integer codigo, String nombre, Date fechaCreacion, Date fechaUltimaActualizacion, Boolean publico,
			EstadoDocumento estado) {
		super(codigo, nombre, fechaCreacion, fechaUltimaActualizacion, publico);
		this.estado = estado;
	}

	public EstadoDocumento getEstado() {
		return estado;
	}

	@Override
	public int hashCode() {
		return codigo.hashCode() + nombre.hashCode() + fechaCreacion.hashCode() + publico.hashCode()
				+ estado.hashCode();
	}

	@Override
	public boolean equals(Object obj) {
		if (obj instanceof Documento) {
			return codigo.equals(((Documento) obj).getCodigo()) && nombre.equals(((Documento) obj).getNombre())
					&& fechaCreacion.equals(((Documento) obj).getFechaCreacion())
					&& publico.equals(((Documento) obj).getPublico()) && estado.equals(((Documento) obj).getEstado());
		}
		return false;
	}

	@Override
	public String toString() {
		return "Documento con código " + codigo;
	}

	public String getDatos() {
		return "Documento con código" + this.getCodigo() + " Nombre:  " + this.getNombre() + " FechaCracion: "
				+ this.getFechaCreacion() + " FechaUltimaActualizacion: " + this.getFechaUltimaActualizacion()
				+ " Publico: " + this.getPublico() + ".";
	}
}
