package Agenda;

import java.util.Arrays;
import java.util.Collections;
import java.util.LinkedList;
import java.util.List;
public class Agenda {
	/*
	 * Atributos de agenta
	 */
	Contacto contactosDeLaAgenda[] = new Contacto[100];
	/*
	 * Contructor de objeto agenda
	 */
	public Agenda() {
		Contacto predeterminado = new Contacto (".",1,".");
		for(int i =0; i< 100;i++) {
			contactosDeLaAgenda[i] = predeterminado;
		}
	}
	/*
	 * getters and setters 
	 */
	public Contacto[] getContactosDeLaAgenda() {
		
		return contactosDeLaAgenda;
	}

	public void setContactosDeLaAgenda(Contacto[] contactosDeLaAgenda) {
		this.contactosDeLaAgenda = contactosDeLaAgenda;
	}
	/*
	 * Metodo too string para mostrar por la pantalla  la lista de los contactos.
	 */
	@Override
	public String toString() {
		int contadorDeContactos = 0;
		for (int i = 0; i  < this.contactosDeLaAgenda.length; i++) {
			Contacto contactoEncontrado = contactosDeLaAgenda [i];
				if (contactoEncontrado.getNombre().equalsIgnoreCase(".") == false) {
					contadorDeContactos = i+1 ;
				}
		}
		Contacto arrayAuxContacto []= new Contacto [contadorDeContactos];
		for (int i = 0; i< this.contactosDeLaAgenda.length; i++) {
			Contacto contactoEncontrado = contactosDeLaAgenda [i];
				if (contactoEncontrado.getNombre().equalsIgnoreCase(".") == false) {
					arrayAuxContacto [i] = contactoEncontrado;
				}
		}
				return "" + Arrays.toString(arrayAuxContacto) + "";
	}
	/*
	 * metodo para añadir contactoc buscando 
	 */
	public void añadirContacto(String nombre, int telefono, String direccionDeCorreo) {
		Contacto nuevoContacto = new Contacto(nombre,telefono,direccionDeCorreo);
		for (int i = 0; i< this.contactosDeLaAgenda.length; i++) {
			Contacto contactoEncontrado = contactosDeLaAgenda [i];
				if (contactoEncontrado.getNombre().equalsIgnoreCase(".") == true) {
					contactosDeLaAgenda [i] = nuevoContacto;
					
					break;
				}
		}
	}
	/*
     * Recorre un bucle for de Agenda para pasar a un if y buscar la posicion que desea eliminar por el nombre que me pasa.
     */
    public void eliminarContactos(String nombre) {
        Contacto predeterminado = new Contacto(".",0,".");
        for(int contador = 0; contador < this.contactosDeLaAgenda.length; contador++) {
               Contacto contactoEncontrado = contactosDeLaAgenda[contador];

           if(nombre.equals(contactoEncontrado.getNombre())  == true) {
        	   contactosDeLaAgenda[contador] = predeterminado;
               break;
           }
        }
    }
    
    /*
     * Recorre un bucle for de Agenda para pasar a un if que nos encontrara la persona que nosotros queremos buscar
     */
    public Contacto buscaelContacto(String nombre) {
        Contacto buscarPersona = new Contacto(".",0,".");
        for(int contador = 0; contador < this.contactosDeLaAgenda.length; contador++) {
               Contacto contactoEncontrado = contactosDeLaAgenda[contador];

           if(nombre.equals(contactoEncontrado.getNombre())  == true) {
               buscarPersona = contactosDeLaAgenda[contador];
           }
        }
        return buscarPersona;
    }
	
}
