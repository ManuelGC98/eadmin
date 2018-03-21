package es.fpdual.eadmin.eadmin.modelo;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;

import java.util.Date;

import org.junit.Before;
import org.junit.Test;

public class TestExpediente {

	private static final Date FECHA_CREACION = new Date();
	private static final Date FECHA_ARCHIVADO = new Date();
	private static final String NOMBRE_EXPEDIENTE = "nombre";
	private static final Boolean EXPEDIENTE_PUBLICO = true;
	private static final Integer CODIGO_EXPEDIENTE = 1;

	Expediente exp;

	@Before
	public void inicializar() {
		exp = new Expediente(CODIGO_EXPEDIENTE, NOMBRE_EXPEDIENTE, FECHA_CREACION, FECHA_ARCHIVADO, EXPEDIENTE_PUBLICO,
				EstadoExpediente.INICIADO);
	}

	@Test
	public void deberiaComprobarGetters() {
		assertEquals(CODIGO_EXPEDIENTE, exp.getCodigo());
		assertEquals(NOMBRE_EXPEDIENTE, exp.getNombre());
		assertEquals(FECHA_CREACION, exp.getFechaCreacion());
		assertEquals(FECHA_ARCHIVADO, exp.getFechaCreacion());
		assertEquals(EXPEDIENTE_PUBLICO, exp.getPublico());
		assertEquals(EstadoExpediente.INICIADO, exp.getEstado());
	}

	@Test
	public void deberiaDevolverTrueSiEsElMismoExpediente() {
		final Expediente exp2 = new Expediente(CODIGO_EXPEDIENTE, NOMBRE_EXPEDIENTE, FECHA_CREACION, FECHA_ARCHIVADO,
				EXPEDIENTE_PUBLICO, EstadoExpediente.INICIADO);

		final Boolean resultado = exp2.equals(exp);
		assertTrue(resultado);
	}

	@Test
	public void deberiaDevolverFalseSiNoEsElMismoExpediente() {
		final Expediente exp2 = new Expediente(5, null, null, null, null, null);

		final Boolean resultado = exp2.equals(exp);
		assertFalse(resultado);
	}

	@Test
	public void deberiaDevolverFalseSiNoEsUnDocumento() {
		final Boolean resultado = exp.equals(new Date());
		assertFalse(resultado);
	}

	@Test
	public void deberiaDevolverHashCodeDeLosDatosDelExpediente() {
		final int resultado = CODIGO_EXPEDIENTE.hashCode() + NOMBRE_EXPEDIENTE.hashCode() + FECHA_CREACION.hashCode()
				+ FECHA_ARCHIVADO.hashCode() + EXPEDIENTE_PUBLICO.hashCode() + EstadoExpediente.INICIADO.hashCode();

		assertEquals(resultado, exp.hashCode());
	}
}
