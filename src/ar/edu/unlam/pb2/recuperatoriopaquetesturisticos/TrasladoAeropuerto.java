package ar.edu.unlam.pb2.recuperatoriopaquetesturisticos;

public class TrasladoAeropuerto extends ServiciosComplementarios {

	private Double precioFijoBase;

	public TrasladoAeropuerto(String nombre, Double precioFijoBase) {
		super(nombre);
		this.precioFijoBase = precioFijoBase;
	}

	@Override
	public Double Costo(PaqueteTuristico paquete) {
		if (paquete.esPremium()) {
			this.precioFijoBase += 35000.0;
		}
		return this.precioFijoBase;
	}

}
