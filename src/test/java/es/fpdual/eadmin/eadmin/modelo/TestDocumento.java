package es.fpdual.eadmin.eadmin.modelo;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;

import java.util.Date;

import org.junit.Before;
import org.junit.Test;

public class TestDocumento {

	private static final Date FECHA_CREACION = new Date();
	private static final String NOMBRE_DOCUMENTO = "nombre";
	private static final boolean DOCUMENTO_PUBLICO = true;
	private static final Integer CODIGO_DOCUMENTO = 1;

	Documento doc;

	@Before
	public void inicializar() {
		doc = new Documento(CODIGO_DOCUMENTO, NOMBRE_DOCUMENTO, FECHA_CREACION, DOCUMENTO_PUBLICO,
				EstadoDocumento.ACTIVO);
	}

	@Test
	public void deberiaComprobarGetters() {
		assertEquals(CODIGO_DOCUMENTO, doc.getCodigo());
		assertEquals(NOMBRE_DOCUMENTO, doc.getNombre());
		assertEquals(FECHA_CREACION, doc.getFechaCreacion());
		assertEquals(DOCUMENTO_PUBLICO, doc.getPublico());
		assertEquals(EstadoDocumento.ACTIVO, doc.getEstado());
	}

	@Test
	public void deberiaDevolverTrueSiTienenIgualCodigo() {
		final Documento doc2 = new Documento(CODIGO_DOCUMENTO, null, null, null, null);

		final Boolean resultado = doc2.equals(doc);
		assertTrue(resultado);
	}

	@Test
	public void deberiaDevolverFalseSiNoTienenIgualCodigo() {
		final Documento doc2 = new Documento(5, null, null, null, null);

		final Boolean resultado = doc2.equals(doc);
		assertFalse(resultado);
	}

	@Test
	public void deberiaDevolverFalseSiNoEsUnDocumento() {
		final Boolean resultado = doc.equals(new Date());
		assertFalse(resultado);
	}

	@Test
	public void deberiaDevolverHashCodeDelCodigo() {
		final int resultado = doc.hashCode();

		assertEquals(CODIGO_DOCUMENTO.hashCode(), resultado);
	}
}
