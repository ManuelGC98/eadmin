package es.fpdual.eadmin.eadmin.repositorio.impl;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

import es.fpdual.eadmin.eadmin.modelo.Documento;
import es.fpdual.eadmin.eadmin.repositorio.RepositorioDocumento;

public class RepositorioDocumentoImpl implements RepositorioDocumento {

	private List<Documento> documentos = new ArrayList<>();

	@Override
	public void altaDocumento(Documento documento) {
		if (!documentos.contains(documento)) {
			documentos.add(documento);
		}
		throw new IllegalArgumentException("El documento ya existe");
	}

	@Override
	public void modificarDocumento(Documento documento) {
		if (!documentos.contains(documento)) {
			throw new IllegalArgumentException("El documento a modificar no existe");
		}
		documentos.set(documentos.indexOf(documento), documento);
	}

	@Override
	public void eliminarDocumento(Integer codigo) {
		Documento documentoEncontrado = documentos.stream().filter(d -> d.getCodigo().equals(codigo)).findFirst()
				.orElseGet(null);

		if (Objects.nonNull(documentoEncontrado)) {
			documentos.remove(documentoEncontrado);
		}
		throw new IllegalArgumentException("El documento no existe.");
	}

	public List<Documento> getDocumentos() {
		return this.documentos;
	}
}
