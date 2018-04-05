package es.fpdual.eadmin.eadmin.repositorio.impl;

import static org.junit.Assert.assertTrue;

import java.util.Date;

import org.junit.Before;
import org.junit.Test;

import es.fpdual.eadmin.eadmin.modelo.Documento;
import es.fpdual.eadmin.eadmin.modelo.EstadoDocumento;

public class TestRepositorioDocumentoImpl {

	private static final Date FECHA_CREACION = new Date();
	private static final String NOMBRE_DOCUMENTO = "nombre";
	private static final boolean DOCUMENTO_PUBLICO = true;
	private static final Integer CODIGO_DOCUMENTO = 1, CODIGO_DOCUMENTO2 = 2;

	Documento documento, documento2;
	RepositorioDocumentoImpl repositorioDocumento;

	@Before
	public void inicializar() {
		repositorioDocumento = new RepositorioDocumentoImpl();
		documento = new Documento(CODIGO_DOCUMENTO, NOMBRE_DOCUMENTO, FECHA_CREACION, DOCUMENTO_PUBLICO,
				EstadoDocumento.ACTIVO);
		documento2 = new Documento(CODIGO_DOCUMENTO2, NOMBRE_DOCUMENTO, FECHA_CREACION, DOCUMENTO_PUBLICO,
				EstadoDocumento.ACTIVO);
		repositorioDocumento.altaDocumento(documento2);
	}

	@Test
	public void deberiaDarDeAltaUnDocumento() {
		repositorioDocumento.altaDocumento(documento);

		assertTrue(this.repositorioDocumento.getDocumentos().contains(documento));
	}

	@Test
	public void deberiaModificarUnDocumento() {
	}

	@Test
	public void deberiaEliminarUnDocumento() {
		repositorioDocumento.eliminarDocumento(2);

		assertTrue(this.repositorioDocumento.getDocumentos().isEmpty());
	}
}
