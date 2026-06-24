package ar.edu.unlam.pb2.recuperatoriopaquetesturisticos;

import java.util.HashSet;

public class PaqueteTuristico {

	private Double precioBase;
	private Integer dias;
	private String destino;
	private String alojamiento;

	private HashSet<ServiciosComplementarios> servicios = new HashSet<ServiciosComplementarios>();

	public PaqueteTuristico(Double precioBase, Integer dias, String destino, String alojamiento) {
		this.precioBase = precioBase;
		this.dias = dias;
		this.destino = destino;
		this.alojamiento = alojamiento;
	}

	public Double getPrecioBase() {
		return precioBase;
	}

	public void setPrecioBase(Double precioBase) {
		this.precioBase = precioBase;
	}

	public String getAlojamiento() {
		return alojamiento;
	}

	public void setAlojamiento(String alojamiento) {
		this.alojamiento = alojamiento;
	}

	public Integer getDias() {
		return dias;
	}

	public String getDestino() {
		return destino;
	}

	public Boolean esPremium() {
//		Un paquete es Premium si:
//			 es internacional
//			 y el alojamiento es 5 estrellas
//			 y tiene más de 7 días.

		return this.destino.equalsIgnoreCase("internacional") && this.alojamiento.equalsIgnoreCase("5 estrellas")
				&& this.dias > 7;
	}

	public Boolean esExtendido() {
		// tiene más de 14 días.
		return this.dias > 14;
	}

	public Boolean agregarServiciosComplementarios(ServiciosComplementarios servicio) {
		return this.servicios.add(servicio);
	}

	public Double calcularCostoTotalServicios() {
		Double total = 0.0;
		for (ServiciosComplementarios servicio : this.servicios) {
			total += servicio.Costo(this);
		}
		return total;
	}

}
