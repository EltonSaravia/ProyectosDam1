package Agenda;

import java.util.Objects;

public class Contacto {

	String nombre;
	int telefono;
	String direccionDeCorreo;
	/*
	 * Constructores de Contacto, existe un constructor para cada caso pero siempre debe llevar un nombre.
	 */
	public Contacto(String nombre, int telefono, String direccionDeCorreo) {
		this.nombre = nombre;
		this.telefono = telefono;
		this.direccionDeCorreo = direccionDeCorreo;
	}
	public Contacto(String nombre) {
		this.nombre = nombre;
	}
	/*
	 * getters and setters
	 */
	public String getNombre() {
		return nombre;
	}
	public void setNombre(String nombre) {
		this.nombre = nombre;
	}
	public int getTelefono() {
		return telefono;
	}
	public void setTelefono(int telefono) {
		this.telefono = telefono;
	}
	public String getDireccionDeCorreo() {
		return direccionDeCorreo;
	}
	public void setDireccionDeCorreo(String direccionDeCorreo) {
		this.direccionDeCorreo = direccionDeCorreo;
	}
	/*
	 * toString para mostrar la informacion del contacto.
	 */
	@Override
	public String toString() {
		return "\nNombre : " + nombre + "	telefono :" + telefono + "	correo electronico: " + direccionDeCorreo;
				
	}
/*
 * metodo para comparar 2 objetos contacto.
 */
	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Contacto other = (Contacto) obj;
		return  Objects.equals(nombre, other.nombre)
				;
	}
	
	/*
     * Este metodo es para modificar contactos.
     */
    public void modificarContacto(String nombre, String direccionDeCorreo, int telefono) {
        this.nombre = nombre;
        this.direccionDeCorreo = direccionDeCorreo;
        this.telefono = telefono;
    }
	
	
}
