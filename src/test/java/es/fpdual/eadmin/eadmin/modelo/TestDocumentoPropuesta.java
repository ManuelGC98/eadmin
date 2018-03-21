package es.fpdual.eadmin.eadmin.modelo;

import static org.junit.Assert.assertEquals;

import java.util.Date;

import org.junit.Before;
import org.junit.Test;

public class TestDocumentoPropuesta {

	private static final Date FECHA_CREACION = new Date();
	private static final String NOMBRE_DOCUMENTO_PROPUESTA = "nombre";
	private static final boolean DOCUMENTO_PROPUESTA_PUBLICO = true;
	private static final Integer CODIGO_DOCUMENTO_PROPUESTA = 1;
	private static final Integer COD_DOCUMENTO_PROPUESTA = 1;
	private static final Integer EJERCICIO_DOCUMENTO_PROPUESTA = 2;
	private static final String GRUPO_POLITICO_DOCUMENTO_PROPUESTA = "Grupo";

	DocumentoPropuesta doc;

	@Before
	public void inicializar() {
		doc = new DocumentoPropuesta(CODIGO_DOCUMENTO_PROPUESTA, NOMBRE_DOCUMENTO_PROPUESTA, FECHA_CREACION,
				DOCUMENTO_PROPUESTA_PUBLICO, EstadoDocumento.ACTIVO, COD_DOCUMENTO_PROPUESTA,
				EJERCICIO_DOCUMENTO_PROPUESTA, GRUPO_POLITICO_DOCUMENTO_PROPUESTA);
	}

	@Test
	public void deberiaComprobarGetters() {
		assertEquals(COD_DOCUMENTO_PROPUESTA, doc.getCodigo());
		assertEquals(EJERCICIO_DOCUMENTO_PROPUESTA, doc.getEjercicio());
		assertEquals(GRUPO_POLITICO_DOCUMENTO_PROPUESTA, doc.getGrupoPolitico());
	}
}
