package ordenarListaSocios;

import java.sql.Date;
import java.time.LocalDate;
import java.time.Period;
import java.util.Objects;

public class Socio implements Comparable<Object> {
 
	private String dni;
	private String nombre;
	private LocalDate fechaNacimiento;
	private LocalDate fechaAlta;
	private float cuota;
	private int cantidadFamilia;
	
	public Socio(String dni,String nombre,LocalDate fechaNacimiento, float cuota,int cantidadFamilia) {
		
		this.dni = dni;
		this.nombre = nombre ;
		this.fechaNacimiento = fechaNacimiento; //se le debe pasar el parametro  YYYY-MM-DD
		this.cuota = cuota;
		this.cantidadFamilia=cantidadFamilia;
		this.fechaAlta = LocalDate.now();
		
	}
	public Socio(String dni) {
		
		this.dni = dni;
		
	}
	

	/*metodo que que incluye el localdate.now para tomar la devha de ahora y usamos el compareto para que nos devuelva un entero
	que sera la diferencia con lo que pongamos dentro*/
	
	protected int calcularEdad() {
		return LocalDate.now().compareTo(this.fechaNacimiento);
	}
	
	protected String obtenerEdadCalculada() {
		int aux = LocalDate.now().compareTo(this.fechaNacimiento);
		String devolver = aux+"";
		return devolver;
	}
	/*
	 * Declaramos un tipo Perido que nos permite utlizar el metodo between para almacenar la diferencia entre
	 * 2 fechas, luego retornamos esa diferencia en meses, lo casteamos a int porque diferencia sigue siendo de tipo 
	 * periodo
	 */
	protected int mesesAntiguedad() {
		Period diferencia = Period.between(this.fechaAlta, LocalDate.now()); 
		return (int) diferencia.toTotalMonths();
	}
	
	public String getDni() {
		return dni;
	}
	public String getNombre() {
		return nombre;
	}
	public LocalDate getFechaNacimiento() {
		return fechaNacimiento;
	}
	public LocalDate getFechaAlta() {
		return fechaAlta;
	}
	public float getCuota() {
		return cuota;
	}
	
	
	@Override
	public int hashCode() {
		return Objects.hash(dni);
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Socio other = (Socio) obj;
		return Objects.equals(dni, other.dni);// UN SOCIO ES IGUAL OTRO SI EL DNI COINCIDE
	}




	@Override
	public String toString() {
		return String.format("%10s %10s %11s %11s %5s %3s \n"
				,this.dni, this.nombre, this.fechaNacimiento,this.fechaAlta,this.cuota,this.cantidadFamilia);
	}
	
	@Override
	public int compareTo(Object o) {
		
		return this.getDni().compareTo(((Socio) o).getDni());
	}
	
	
	
	
}
