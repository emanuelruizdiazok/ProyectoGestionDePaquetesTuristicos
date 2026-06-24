package ar.edu.unlam.pb2.recuperatoriopaquetesturisticos;

import static org.junit.Assert.*;

import org.junit.Test;

public class ServiciosComplementariosTest {

	@Test
	public void queUnPaqueteConSeguroDeViajeCalculeSuPrecio() {
		PaqueteTuristico paquete = new PaqueteTuristico(520000.0, 12, "internacional", "5 estrellas");
		ServiciosComplementarios seguro = new SeguroDeViaje("seguro", 4000.0);
		paquete.agregarServiciosComplementarios(seguro);
		// 4mil * 12 dias = 48 * 1.20(internacional) = 57600.0
		assertEquals(57600.0, paquete.calcularCostoTotalServicios(), 0.0);
	}

	@Test
	public void queUnPaqueteConSeguroDeViajeCalculeSuPrecioSinTenerDestinoInternacional() {
		PaqueteTuristico paquete = new PaqueteTuristico(520000.0, 12, "local", "5 estrellas");
		ServiciosComplementarios seguro = new SeguroDeViaje("seguro", 4000.0);
		paquete.agregarServiciosComplementarios(seguro);
		// 4mil * 12dias = 48mil
		assertEquals(48000.0, paquete.calcularCostoTotalServicios(), 0.0);
	}

	@Test
	public void queUnPaqueteConTrasladoCalculeSuPrecio() {
		PaqueteTuristico paquete = new PaqueteTuristico(520000.0, 12, "internacional", "5 estrellas");
		ServiciosComplementarios traslado = new TrasladoAeropuerto("traslado", 30000.0);
		paquete.agregarServiciosComplementarios(traslado);
		// 30mil + 35mil(premuium) = 65mil
		assertEquals(65000.0, paquete.calcularCostoTotalServicios(), 0.0);
	}

	@Test
	public void queUnPaqueteConTrasladoCalculeSuPrecioSinSerPremium() {
		PaqueteTuristico paquete = new PaqueteTuristico(520000.0, 12, "local", "5 estrellas");
		ServiciosComplementarios traslado = new TrasladoAeropuerto("traslado", 30000.0);
		paquete.agregarServiciosComplementarios(traslado);
		// 30mil
		assertEquals(30000.0, paquete.calcularCostoTotalServicios(), 0.0);
	}

	@Test
	public void queUnPaqueteConExcursionesGuiadasCalculeSuPrecio() {
		PaqueteTuristico paquete = new PaqueteTuristico(520000.0, 12, "internacional", "5 estrellas");
		ServiciosComplementarios excursiones = new ExcursionesGuiadas("excursiones", 15000.0);
		paquete.agregarServiciosComplementarios(excursiones);
		// 15mil de base
		assertEquals(15000.0, paquete.calcularCostoTotalServicios(), 0.0);
	}

	@Test
	public void queUnPaqueteConExcursionesGuiadasCalculeSuPrecioSiendoExtendido() {
		PaqueteTuristico paquete = new PaqueteTuristico(520000.0, 15, "internacional", "5 estrellas");
		ServiciosComplementarios excursiones = new ExcursionesGuiadas("excursiones", 15000.0);
		paquete.agregarServiciosComplementarios(excursiones);
		// 15mil de base, al se extendido lo duplico = 30mil
		assertEquals(30000.0, paquete.calcularCostoTotalServicios(), 0.0);
	}

	@Test
	public void queUnPaqueteNoPermitaServiciosDuplicados() {
		PaqueteTuristico paquete = new PaqueteTuristico(520000.0, 12, "internacional", "5 estrellas");
		ServiciosComplementarios seguro = new SeguroDeViaje("seguro", 4000.0);
		ServiciosComplementarios seguroDuplicado = new SeguroDeViaje("seguro", 4000.0); // DUPLICADO
		assertTrue(paquete.agregarServiciosComplementarios(seguro));
		assertFalse(paquete.agregarServiciosComplementarios(seguroDuplicado)); // DUPLICADO
	}

}
