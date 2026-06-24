package ar.edu.unlam.pb2.recuperatoriopaquetesturisticos;

public class EstrategiaCostoFinalConDescuentoFijo implements EstrategiaPrecioCalculable {

	private Double descuentoFijoEnPesos = 0.0;

	public EstrategiaCostoFinalConDescuentoFijo(Double descuentoFijoEnPesos) {
		super();
		this.descuentoFijoEnPesos = descuentoFijoEnPesos;
	}

	@Override
	public Double calcularEstrategia(PaqueteTuristico paquete) {
		Double precioBaseDelPaquete = paquete.getPrecioBase() + paquete.calcularCostoTotalServicios();
		return precioBaseDelPaquete - this.descuentoFijoEnPesos;
	}

}
