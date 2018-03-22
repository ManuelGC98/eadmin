package es.fpdual.eadmin.eadmin.modelo;

import java.util.Date;

public class Documento extends AdministracionElectronicaBase {

	private EstadoDocumento estado;

	public Documento(Integer codigo, String nombre, Date fechaCreacion, Boolean publico, EstadoDocumento estado) {
		super(codigo, nombre, fechaCreacion, publico);
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
}
