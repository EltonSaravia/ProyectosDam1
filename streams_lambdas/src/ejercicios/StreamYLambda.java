package ejercicios;


import java.util.*;
import java.util.stream.Collectors;
import java.util.stream.IntStream;
import java.util.stream.Stream;

public class StreamYLambda {
	
	//metodo para generar los numeros aleatorios 
	   private static ArrayList<Integer> generarNumerosAleatorios(int cantidadDeNumeros, int min, int max) {
	        Random random = new Random();
	        return (ArrayList<Integer>) random.ints(cantidadDeNumeros, min, max + 1)
	                .boxed()
	                .collect(Collectors.toList());
	    }
	   
	   
    public static void main(String[] args) {
    	
        ArrayList<Integer> numerosAleatorios = generarNumerosAleatorios(40, -20, 20);
        System.out.println("Lista de números enteros aleatorios:");
        System.out.println(numerosAleatorios);

        Stream<Integer> positivosStream = numerosAleatorios.stream()
                .filter(num -> num > 0)
                .distinct();
        
        long cantidadPositivos = positivosStream.count();
        
        System.out.println("Cantidad de números positivos: " + cantidadPositivos);

        Stream<Integer> negativosStream = numerosAleatorios.stream()
                .filter(num -> num < 0)
                .distinct();
        long cantidadNegativos = negativosStream.count();
        System.out.println("Cantidad de números negativos: " + cantidadNegativos);

        Stream<Integer> entreMenosDiezDiezStream = numerosAleatorios.stream()
                .filter(num -> num >= -10 && num <= 10)
                .distinct();
        long cantidadEntreMenosDiezDiez = entreMenosDiezDiezStream.count();
        System.out.println("Cantidad de números entre -10 y 10: " + cantidadEntreMenosDiezDiez);
    }

    
 
}
