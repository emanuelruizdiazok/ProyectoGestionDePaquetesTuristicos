package ar.edu.unlam.pb2.recuperatoriopaquetesturisticos;

import static org.junit.Assert.*;

import org.junit.Test;

public class EstrategiaCostoFinalTest {

	@Test
	public void queUnPaquetePuedaCalcularSuCostoFinalConEstrategia() {
		PaqueteTuristico paquete = new PaqueteTuristico(520000.0, 12, "internacional", "5 estrellas");
		ServiciosComplementarios seguro = new SeguroDeViaje("seguro", 4000.0);
		ServiciosComplementarios traslado = new TrasladoAeropuerto("traslado", 30000.0);
		ServiciosComplementarios excursiones = new ExcursionesGuiadas("excursiones", 15000.0);

		paquete.agregarServiciosComplementarios(seguro);
		paquete.agregarServiciosComplementarios(traslado);
		paquete.agregarServiciosComplementarios(excursiones);

		EstrategiaCostoFinal estrategia = new EstrategiaCostoFinal();

		// 520mil(PRECIOBASE) + 57600.0(SEGURO) + 65000.0(TRASLADO) +
		// 15000.0(EXCURSIONES) =
		// 657600.0 (TOTALFINAL)
		assertEquals(657600.0, estrategia.calcularEstrategia(paquete), 0.0);
	}

}
