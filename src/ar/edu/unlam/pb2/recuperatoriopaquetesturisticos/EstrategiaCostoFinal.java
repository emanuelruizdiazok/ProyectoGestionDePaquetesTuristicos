package ar.edu.unlam.pb2.recuperatoriopaquetesturisticos;

public class EstrategiaCostoFinal implements EstrategiaPrecioCalculable {

	@Override
	public Double calcularEstrategia(PaqueteTuristico paquete) {
		return paquete.getPrecioBase() + paquete.calcularCostoTotalServicios();
	}

}
