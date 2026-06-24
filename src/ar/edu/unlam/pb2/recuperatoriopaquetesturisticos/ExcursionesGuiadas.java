package ar.edu.unlam.pb2.recuperatoriopaquetesturisticos;

public class ExcursionesGuiadas extends ServiciosComplementarios {

	private Double precioBaseFijo;

	public ExcursionesGuiadas(String nombre, Double precioBaseFijo) {
		super(nombre);
		this.precioBaseFijo = precioBaseFijo;
	}

	@Override
	public Double Costo(PaqueteTuristico paquete) {
		if (paquete.esExtendido()) {
			this.precioBaseFijo *= 2;
		}
		return this.precioBaseFijo;
	}

}
