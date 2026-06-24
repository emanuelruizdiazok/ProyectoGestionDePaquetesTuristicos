package ar.edu.unlam.pb2.recuperatoriopaquetesturisticos;

public class SeguroDeViaje extends ServiciosComplementarios {

	private Double precioFijoPorDia;

	public SeguroDeViaje(String nombre, Double precioFijoPorDia) {
		super(nombre);
		this.precioFijoPorDia = precioFijoPorDia;
	}

	@Override
	public Double Costo(PaqueteTuristico paquete) {
		Double costoDelSeguro = 0.0;

		costoDelSeguro += this.precioFijoPorDia * paquete.getDias();

		if (paquete.getDestino().equalsIgnoreCase("internacional")) {
			costoDelSeguro *= 1.20;
		}
		return costoDelSeguro;
	}

}
