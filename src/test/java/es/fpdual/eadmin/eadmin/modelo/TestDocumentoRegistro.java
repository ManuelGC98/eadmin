package es.fpdual.eadmin.eadmin.modelo;

import static org.junit.Assert.assertEquals;

import java.util.Date;

import org.junit.Before;
import org.junit.Test;

public class TestDocumentoRegistro {

	private static final Date FECHA_CREACION = new Date();
	private static final String NOMBRE_DOCUMENTO_PROPUESTA = "nombre";
	private static final boolean DOCUMENTO_PROPUESTA_PUBLICO = true;
	private static final Integer CODIGO_DOCUMENTO_PROPUESTA = 1;
	private static final String DNI_INTERESADO_DOCUMENTO_PROPUESTA = "12345678X";
	private static final String CODIGO_REGISTRO_DOCUMENTO_PROPUESTA = "555";
	DocumentoRegistro doc;

	@Before
	public void inicializar() {
		doc = new DocumentoRegistro(CODIGO_DOCUMENTO_PROPUESTA, NOMBRE_DOCUMENTO_PROPUESTA, FECHA_CREACION,
				DOCUMENTO_PROPUESTA_PUBLICO, EstadoDocumento.ACTIVO, DNI_INTERESADO_DOCUMENTO_PROPUESTA,
				CODIGO_REGISTRO_DOCUMENTO_PROPUESTA);
	}

	@Test
	public void deberiaComprobarGetters() {
		assertEquals(DNI_INTERESADO_DOCUMENTO_PROPUESTA, doc.getDniInteresado());
		assertEquals(CODIGO_REGISTRO_DOCUMENTO_PROPUESTA, doc.getCodigoRegistro());
	}
}
