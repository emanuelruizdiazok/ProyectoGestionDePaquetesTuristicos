package ar.edu.unlam.pb2.recuperatoriopaquetesturisticos;

import static org.junit.Assert.*;

import org.junit.Test;

public class PaqueteTuristicoTest {

	@Test
	public void queUnPaqueteTuristicoTengaPrecioBase() {
		PaqueteTuristico paquete = new PaqueteTuristico(520000.0, 12, "internacional", "5 estrellas");
		assertEquals(520000.0, paquete.getPrecioBase(), 0.0);
	}

	@Test
	public void queUnPaqueteTuristicoPuedaModificarSuPrecioBase() {
		PaqueteTuristico paquete = new PaqueteTuristico(520000.0, 12, "internacional", "5 estrellas");
		Double nuevoPrecio = 400000.0;
		paquete.setPrecioBase(nuevoPrecio);
		assertEquals(nuevoPrecio, paquete.getPrecioBase(), 0.0);
	}

	@Test
	public void queUnPaqueteTuristicoPuedaModificarSuAlojaminto() {
		PaqueteTuristico paquete = new PaqueteTuristico(520000.0, 12, "internacional", "5 estrellas");
		String nuevoAlojamiento = "3 estrellas";
		paquete.setAlojamiento(nuevoAlojamiento);
		assertEquals(nuevoAlojamiento, paquete.getAlojamiento());
	}

	@Test
	public void queUnPaqueteTuristicoSeaPremium() {
		PaqueteTuristico paquete = new PaqueteTuristico(520000.0, 12, "internacional", "5 estrellas");
		assertTrue(paquete.esPremium());
	}

	@Test
	public void queUnPaqueteTuristicoNoSeaPremiumSiNoEsInternacional() {
		PaqueteTuristico paquete = new PaqueteTuristico(520000.0, 12, "local", "5 estrellas");
		assertFalse(paquete.esPremium());
	}

	@Test
	public void queUnPaqueteTuristicoNoSeaPremiumSiNoTiene5Estrellas() {
		PaqueteTuristico paquete = new PaqueteTuristico(520000.0, 12, "Internacional", "3 estrellas");
		assertFalse(paquete.esPremium());
	}

	@Test
	public void queUnPaqueteTuristicoNoSeaPremiumSiNoTieneMasDe12Dias() {
		PaqueteTuristico paquete = new PaqueteTuristico(520000.0, 2, "Internacional", "5 estrellas");
		assertFalse(paquete.esPremium());
	}

	// *******

	@Test
	public void queUnPaqueteTuristicoSeaExtendido() {
		PaqueteTuristico paquete = new PaqueteTuristico(520000.0, 15, "internacional", "5 estrellas");
		assertTrue(paquete.esExtendido());
	}

	@Test
	public void queUnPaqueteTuristicoNoSeaExtendidoSiNoTieneMasDe14Dias() {
		PaqueteTuristico paquete = new PaqueteTuristico(520000.0, 14, "internacional", "5 estrellas");
		assertFalse(paquete.esExtendido());
	}

}
