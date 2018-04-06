package es.fpdual.eadmin.eadmin.repositorio;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import es.fpdual.eadmin.eadmin.modelo.Documento;

public interface RepositorioDocumento {

	public abstract void altaDocumento(Documento documento);

	public abstract void modificarDocumento(Documento documento);

	public abstract void eliminarDocumento(Integer codigo);

	public abstract Documento obtenerDocumentoPorCodigo(Integer codigo);

	public abstract List<Documento> obtenerTodosLosDocumentos();

	public void GuardarDocumentoEnArchivo();

	public void altaDocumentoConArchivo(Documento documento);

	public void modificarDocumentoConArchivo(Documento documento, Documento documentoNuevo);

	public void eliminarDocumentoConArchivo(Integer codigo);
}
