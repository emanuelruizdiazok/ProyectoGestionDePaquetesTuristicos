package ar.edu.unlam.pb2.recuperatoriopaquetesturisticos;

import java.util.Objects;

public abstract class ServiciosComplementarios {

	protected String nombre; // ESTE ATRIBUTO ES MI IDENTIFICADOR DE EQUALS Y HASHCODE, EL DIFERENCIADOR

	public abstract Double Costo(PaqueteTuristico paquete); // COMPORTAMIENTO ABSTACTO

	@Override
	public int hashCode() {
		return Objects.hash(nombre);
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		ServiciosComplementarios other = (ServiciosComplementarios) obj;
		return Objects.equals(nombre, other.nombre);
	}

	public ServiciosComplementarios(String nombre) {
		super();
		this.nombre = nombre;
	}

}
