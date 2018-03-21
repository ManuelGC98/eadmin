package es.fpdual.eadmin.eadmin.modelo;

import static org.junit.Assert.assertEquals;

import java.util.Date;

import org.junit.Before;
import org.junit.Test;

public class TestAdministracionElectronicaBase {

	public class AdministracionElectronicaBaseFake extends AdministracionElectronicaBase {

		public AdministracionElectronicaBaseFake(Integer codigo, String nombre, Date fechaCreacion, Boolean publico) {
			super(codigo, nombre, fechaCreacion, publico);
		}
	}

	private static final Date FECHA_CREACION = new Date();
	private static final String NOMBRE_BASE = "nombre";
	private static final boolean BASE_PUBLICO = true;
	private static final Integer CODIGO_BASE = 1;

	AdministracionElectronicaBaseFake base;

	@Before
	public void inicializar() {
		base = new AdministracionElectronicaBaseFake(CODIGO_BASE, NOMBRE_BASE, FECHA_CREACION, BASE_PUBLICO);
	}

	@Test
	public void deberiaComprobarGetters() {
		assertEquals(CODIGO_BASE, base.getCodigo());
		assertEquals(NOMBRE_BASE, base.getNombre());
		assertEquals(FECHA_CREACION, base.getFechaCreacion());
		assertEquals(BASE_PUBLICO, base.getPublico());
	}
}
