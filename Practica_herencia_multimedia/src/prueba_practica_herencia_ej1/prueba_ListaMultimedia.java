package prueba_practica_herencia_ej1;
import practica_herencia_ej1.*;
import java.util.*;
public class prueba_ListaMultimedia {
	
	public static final String ANSI_RED = "\u001B[31m";
	public static final String ANSI_GREEN = "\u001B[32m";
	public static final String ANSI_RESET = "\u001B[0m";
	
	public static void main(String[] args) {
		try {
		Scanner sc = new Scanner(System.in);
		ListaMultimedia miDiscDuro = new ListaMultimedia();
		miDiscDuro.createDisk ("Rock", "Alterbrige","Metalingus", 3.19, Format.MP3);
		miDiscDuro.createDisk ("Rock", "American","ZZtop", 8.4, Format.MP3);
		miDiscDuro.createDisk ("Pop", "blue","Mario", 4.20, Format.MP3);
		miDiscDuro.createDisk ("Pop", "Blackbird","chia", 4.20, Format.MP3);
		miDiscDuro.createDisk ("Pop", "money","noav", 4.20, Format.MP3);
		miDiscDuro.createFilm("Antonio Banderas", "Salma Hayek","Gato con botas 2","Kevedo", 120, Format.MPG);
		miDiscDuro.createFilm("Antonio howkings",null,"mirando","chalo", 90, Format.MPG);
		miDiscDuro.createFilm("Brad pitt", "Angelina Jolie","sr ysra Smith","Doug Liman", 140, Format.WAV);
		//miDiscDuro.createFilm(null, null,"documental about Vicktor","Steven spielberg", 25, Format.MPG);
		
		System.out.println(ANSI_GREEN+miDiscDuro.toString()+ANSI_RESET);
		System.out.println("\nThe sum of the duration of each multimedia element in the list is: "+miDiscDuro.sumElemt());
		System.out.println("\nThe sum of the  music element with genre Rock in the list is: "+miDiscDuro.sumaGenre("Rock"));
		System.out.println("\nThese movies don't have a leading actress : " + miDiscDuro.moviesNoActress());
		}
		catch (Exception e) {
			System.out.println(ANSI_RED+"The data entered was wrong, and the program could not continue with data insertion");
		}
	}

}
