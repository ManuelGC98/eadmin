package es.fpdual.eadmin.eadmin.modelo;

import static org.junit.Assert.assertEquals;

import java.math.BigDecimal;
import java.util.Date;

import org.junit.Before;
import org.junit.Test;

public class TestDocumentoContable {

	private static final Date FECHA_CREACION = new Date();
	private static final String NOMBRE_DOCUMENTO_CONTABLE = "nombre";
	private static final boolean DOCUMENTO_CONTABLE_PUBLICO = true;
	private static final Integer CODIGO_DOCUMENTO_CONTABLE = 1;
	private static final BigDecimal IMPORTE_DOCUMENTO_CONTABLE = new BigDecimal(1.25);
	private static final String DNI_INTERESADO_DOCUMENTO_CONTABLE = "12345678X";

	DocumentoContable doc;

	@Before
	public void inicializar() {
		doc = new DocumentoContable(CODIGO_DOCUMENTO_CONTABLE, NOMBRE_DOCUMENTO_CONTABLE, FECHA_CREACION,
				DOCUMENTO_CONTABLE_PUBLICO, EstadoDocumento.ACTIVO, IMPORTE_DOCUMENTO_CONTABLE,
				DNI_INTERESADO_DOCUMENTO_CONTABLE);
	}

	@Test
	public void deberiaComprobarGetters() {
		assertEquals(IMPORTE_DOCUMENTO_CONTABLE, doc.getImporte());
		assertEquals(DNI_INTERESADO_DOCUMENTO_CONTABLE, doc.getDniInteresado());
	}
}
