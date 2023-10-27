
 package Examen;
import java.util.*;
import java.util.Scanner;
import java.util.concurrent.ThreadLocalRandom;

public class Ejercicios {
    
public static final String ANSI_BLACK = "\u001B[30m";
public static final String ANSI_RED = "\u001B[31m";
public static final String ANSI_GREEN = "\u001B[32m";
public static final String ANSI_YELLOW = "\u001B[33m";
public static final String ANSI_BLUE = "\u001B[34m";
public static final String ANSI_PURPLE = "\u001B[35m";
public static final String ANSI_CYAN = "\u001B[36m";
public static final String ANSI_WHITE = "\u001B[37m";
public static final String ANSI_RESET = "\u001B[0m";

public static void encontrarGanador(double sumaCartasUsuario1, double sumaCartasUsuario2, double sumaCartasUsuario3 ) {
    double ganador = 0; 
    if (ganador < sumaCartasUsuario1) {
    	ganador = sumaCartasUsuario1 ;
    }
    if (ganador < sumaCartasUsuario2) {
    	ganador = sumaCartasUsuario2 ;
    }
    if (ganador < sumaCartasUsuario3) {
    	ganador = sumaCartasUsuario3 ;
    }
	
    if ( ganador == sumaCartasUsuario1 ) {
    	System.out.println("El jugador 1 gana con :" + ganador);
    }
    if ( ganador == sumaCartasUsuario2 ) {
    	System.out.println("El jugador 2 gana con :" + ganador);
    }
    if ( ganador == sumaCartasUsuario3 ) {
    	System.out.println("El jugador 3 gana con :" + ganador);
    }     
}

public static double[] burbuja(double array[]) {
		
		int contador = 0, contador2 = contador + 1, operacion = 0;
		double aux = 0;
		boolean terminar = false;
		
		while ( !terminar ) {
			
			operacion = 0;
			contador = 0;
			contador2 = contador + 1;
			
			while ( contador2 < array.length ) {
			
				if ( array[contador] > array[contador2] ) {
					aux = array[contador];
					array[contador] = array[contador2];
					array[contador2] = aux;
					operacion++;
				}
			
				contador++;
				contador2++;
			
			}
			
			if ( operacion == 0 ) {
				terminar = true;
			}
			
		}
		return array;
	}

public static void rellenarCantidadesA4(int[] arrayCantidades) {
    
    for ( int contador = 0; contador < arrayCantidades.length - 1; contador++ ){
        
        arrayCantidades[contador] = 4;
        
    }
    
}

public static int numeroAleatorioEnRango(int minimo, int maximo) {
    
    return ThreadLocalRandom.current().nextInt(minimo, maximo + 1);
        
}

public static int posicion(String[] arrayNombres, String carta) {
    
    int posicion = 0;
    boolean encontrado = false;
    
    for ( int contador = 0; contador < arrayNombres.length - 1 && !encontrado; contador++ ){
        
        if ( carta.equals(arrayNombres[contador]) ) {
            posicion = contador;
            encontrado = true;
        }
       
    }
    return posicion;
}

public static int posicionGanador(double[] arrayGanador, double usuario) {
    
    int posicion = 0;
    boolean encontrado = false;
    
    for ( int contador = arrayGanador.length - 1; contador < 0 && !encontrado; contador-- ) {
        
        if ( usuario > 7.5 ) {
            posicion = - 1;
            encontrado = true;
        } else if ( usuario == arrayGanador[contador] ) {
            posicion = contador;
            encontrado = true;
        }
        encontrado = true;
    }
    return posicion;
}

public static void reducirCantidad(int[] arrayCantidades, String[] arrayNombres, String carta) {
    
    arrayCantidades[posicion(arrayNombres, carta)]--;
    
}

public static void main(String[] args) {
    Scanner entrada = new Scanner (System.in);
    
    double[] arrayValores = {1, 2, 3, 4, 5, 6, 7, 0.5, 0.5, 0.5};
    String[] arrayNombres = {"uno", "dos", "tres", "cuatro", "cinco", "seis", "siete", "sota", "caballo", "rey"};
    int[] arrayCantidades = new int[10];
    
    rellenarCantidadesA4(arrayCantidades);
    
    System.out.println("Vamos a jugar al 7 y medio");
        System.out.println("!NORMAS!");
        System.out.println("- Puedes sacar todas las cartas que quieras. Recuerda, las figuras (10, 11, 12) valen medio punto y, el resto, su valor");
        System.out.println("- Si la suma de los valores de las cartas sacadas es superior a 7 y medio, se pierde");
        System.out.println("- Puedes plantarte en cualquier momento");
        System.out.println("- Gana el que tiene la puntuacion mas alta");
        System.out.println("- En caso de empate se vuelve a jugar");
        
    double sumaCartasUsuario1 = 0;
    double sumaCartasUsuario2 = 0;
    double sumaCartasUsuario3 = 0;
    
    boolean fin1 = false, fin2 = false, fin3 = false;
    boolean plantado1 = false, plantado2 = false, plantado3 = false;
    
    while ( !fin1 || !fin2 || !fin3 ) {
        
        if ( !fin1 && !plantado1 ) {
            
            System.out.println( ANSI_RED + "\n** TURNO DEL JUGADOR 1 **" );
            System.out.println("Presiona 1 para recibir una carta");
            System.out.println("Presiona 2 para plantarte" + ANSI_RESET);
            
            int opcion = entrada.nextInt();
            
            if ( opcion == 1 ) {
                
                boolean repetir = true;
                
                while ( repetir ) {
                
                    int numAleatorio = numeroAleatorioEnRango(0, arrayNombres.length - 1);
                    
                    if ( arrayCantidades[numAleatorio] > 0 ) {
                        
                        String carta = arrayNombres[numAleatorio];
                        double valor = arrayValores[numAleatorio];
                        reducirCantidad(arrayCantidades, arrayNombres, carta);
                        
                        sumaCartasUsuario1 += valor;
                        
                        System.out.println("Te ha tocado un " + carta.toUpperCase());
                        System.out.println("Tienes un total de " + sumaCartasUsuario1);
                        
                        if ( sumaCartasUsuario1 > 7.5 ) {
                            
                            System.out.println("¡Te has pasado!");
                            repetir = false;
                            fin1 = true;
                            
                        }
                        
                        repetir = false;
                    }
                }
                
            } else if ( opcion == 2 ) {
                
                plantado1 = true;
                
            }
        }
        
        if ( !fin2 && !plantado2 ) {
            
            System.out.println(ANSI_GREEN +"\n** TURNO DEL JUGADOR 2 **");
            System.out.println("Presiona 1 para recibir una carta");
            System.out.println("Presiona 2 para plantarte" + ANSI_RESET);
            
            int opcion = entrada.nextInt();
            
            if ( opcion == 1 ) {
                
                boolean repetir = true;
                
                while ( repetir ) {
                
                    int numAleatorio = numeroAleatorioEnRango(0, arrayNombres.length - 1);
                    
                    if ( arrayCantidades[numAleatorio] > 0 ) {
                        
                        String carta = arrayNombres[numAleatorio];
                        double valor = arrayValores[numAleatorio];
                        reducirCantidad(arrayCantidades, arrayNombres, carta);
                        
                        sumaCartasUsuario2 += valor;
                        
                        System.out.println("Te ha tocado un " + carta.toUpperCase());
                        System.out.println("Tienes un total de " + sumaCartasUsuario2);
                        
                        if ( sumaCartasUsuario2 > 7.5 ) {
                            
                            System.out.println("¡Te has pasado!");
                            repetir = false;
                            fin2 = true;
                            
                        }
                        
                        repetir = false;
                    }
                }
                
            } else if ( opcion == 2 ) {
                
                plantado2 = true;
                
            }
        
        }
        
        if ( !fin3 && !plantado3 ) {
            
            System.out.println(ANSI_YELLOW + "\n** TURNO DEL JUGADOR 3 **");
            System.out.println("Presiona 1 para recibir una carta");
            System.out.println("Presiona 2 para plantarte" + ANSI_RESET );
            
            int opcion = entrada.nextInt();
            
            if ( opcion == 1 ) {
                
                boolean repetir = true;
                
                while ( repetir ) {
                
                    int numAleatorio = numeroAleatorioEnRango(0, arrayNombres.length - 1);
                    
                    if ( arrayCantidades[numAleatorio] > 0 ) {
                        
                        String carta = arrayNombres[numAleatorio];
                        double valor = arrayValores[numAleatorio];
                        reducirCantidad(arrayCantidades, arrayNombres, carta);
                        
                        sumaCartasUsuario3 += valor;
                        
                        System.out.println("Te ha tocado un " + carta.toUpperCase());
                        System.out.println("Tienes un total de " + sumaCartasUsuario3);
                        
                        if ( sumaCartasUsuario3 > 7.5 ) {
                            
                            System.out.println("¡Te has pasado!");
                            repetir = false;
                            fin3 = true;
                            
                        }
                        
                        repetir = false;
                    }
                }
                
            } else if ( opcion == 2 ) {
                
                plantado3 = true;
                
            }
        
        }
        
        if ( (fin1 && fin2) || (fin2 && fin3) || (fin1 && fin3) ) {
            
            fin1 = true;
            fin2 = true;
            fin3 = true;
            
        }
        
    }
    
    encontrarGanador( sumaCartasUsuario1,sumaCartasUsuario2,  sumaCartasUsuario3);
    
   
   
    
    System.out.println("¡Se ha terminado el juego!");
    
    }
}
