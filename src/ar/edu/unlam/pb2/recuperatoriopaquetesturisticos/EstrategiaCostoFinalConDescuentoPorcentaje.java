package ar.edu.unlam.pb2.recuperatoriopaquetesturisticos;

public class EstrategiaCostoFinalConDescuentoPorcentaje implements EstrategiaPrecioCalculable {

	private Double porcentaje = 0.0;

	public EstrategiaCostoFinalConDescuentoPorcentaje(Double porcentaje) {
		super();
		this.porcentaje = porcentaje;
	}

	@Override
	public Double calcularEstrategia(PaqueteTuristico paquete) {
		Double precioBaseDelPaquete = paquete.getPrecioBase() + paquete.calcularCostoTotalServicios();
		return precioBaseDelPaquete * (1 - this.porcentaje / 100);
	}

}
