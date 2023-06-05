package ordenarListaSocios;

import java.time.LocalDate;
import java.util.ArrayList;

public class ListaSocios {

	private ArrayList <Socio> listadoInscripciones;
	
	protected ListaSocios() {
		this.listadoInscripciones = new ArrayList <Socio>();
	}
	
	/*
	 * Llamamos a este metodo pasandole los parametros del cual hay que tener en cuenta que 
	 * el socio se diferencia en el EQUALsS por el DNI, asi verificamos que no hayan repetidos con el contains.
	 */
	public void addSocio (String dni,String nombre,LocalDate fechaNacimiento, float cuota,int cantidadFamilia)throws SocioYaExiste_Error {
		Socio nuevoSocio = new Socio( dni, nombre, fechaNacimiento,  cuota, cantidadFamilia);
		if (!this.listadoInscripciones.contains(nuevoSocio)) {
				this.listadoInscripciones.add(nuevoSocio);
		}else {
			throw new SocioYaExiste_Error();
		}
	}
	/*
	 * metodo para eliminar socio si existe en la lista, si no lanza exepcion personalizada
	 */
	public void eliminarSocio (String dni,String nombre,LocalDate fechaNacimiento, float cuota,int cantidadFamilia)throws SocioNoExiste_Error {
		Socio nuevoSocio = new Socio( dni, nombre, fechaNacimiento,  cuota, cantidadFamilia);
		if (!this.listadoInscripciones.contains(nuevoSocio)) {
				this.listadoInscripciones.add(nuevoSocio);
		}else {
			throw new SocioNoExiste_Error();
		}
	}
	
	/* 
	 * con este metodo pedimos un dni para crear un socio, con el socio creado buscamos el indice donde se encuentra almacenado
	 * el socio con ese dni, despues usamos el metodo get para tomar ese socio y almacenarlo
	 * verificamos que no sea null y calculamos su edad.
	 */
	public int saberEdadSocio (String dni)throws SocioNoExiste_Error {
		Socio socioABuscar = new Socio (dni);
		Socio socioEncontrado = this.listadoInscripciones.get(this.listadoInscripciones.indexOf(socioABuscar));
		if (null != socioEncontrado) {
			return socioEncontrado.calcularEdad();
		}else {
			throw new SocioNoExiste_Error();
		}
	}
	
	public int saberMesesAntiguedad (String dni)throws SocioNoExiste_Error {
		Socio socioABuscar = new Socio (dni);
		Socio socioEncontrado = this.listadoInscripciones.get(this.listadoInscripciones.indexOf(socioABuscar));
		if (null != socioEncontrado) {
			return socioEncontrado.mesesAntiguedad();
		}else {
			throw new SocioNoExiste_Error();
		}
	}
	
}
