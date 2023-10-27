//Elton Saravia
package candyshop ;
import java.util.Arrays;
import java.util.Scanner;
import java.util.*;
public class CandyShop {
	// Esta funcion contiene los productos que podrán ser modificados desde el
	// programa main. El orden de los vectores concuerdan con las pocisiones en la maquina.
	public static String[][] productos() {
		String[][] productosDeProductos = { { "Lacasitos", "Chicles de fresa", "KitKat", "Palotes" },
				{ "Oreo", "Bolsa Haribo", "Chetoos", "Twix" },
				{ "M&M'S", "Kinder Bueno", "Papa Delta", "Chicles de menta" },
				{ "Lacasitos", "Crunch", "Milkybar", "KitKat" } };
		CandyShop.alinearTexto(productosDeProductos);
		return productosDeProductos;
	}
	// Esta funcion contiene los precios que podrán ser modificados desde el
	// programa main. El orden de los vectores concuerda con la matriz creada en productos.
	public static double[][] preciosDeProductos() {
		double[][] precios = { { 1.5, 0.8, 1.1, 0.9 }, { 1.8, 1, 1.2, 1 }, { 1.8, 1.3, 1.2, 0.8 },
				{ 1.5, 1.1, 1.1, 1.1 } };
		return precios;
	}
	// Esta funcion contendra la cantidad de productos y se modificará según las
	// ventas y las reposiciones. Esta hecha pra que al comenzar el programa todos los productos, en todas las posiciones tengan 3 unidades.
	public static int[][] cantidadDeProductos() {
		int[][] cantidadDeProductos = new int[4][4];
		for (int filas = 0; filas < cantidadDeProductos.length; filas++) {
			for (int columnas = 0; columnas < cantidadDeProductos.length; columnas++) {
				cantidadDeProductos[filas][columnas] = 3;
			}
		}
		return cantidadDeProductos;
	}
	/*Crea una matriz con todas las pocisiones de la maquina y el orden de los vectores coincide  con las matrices creadas 
	en las funciones : -preciosDeProductos-productos-cantidadDeProductos*/
	public static String[][] pocisionProductos() {
		String[][] posicionDeProductos = { { "AA", "AB", "AC", "AD" }, { "BA", "BB", "BC", "BD" },
				{ "CA", "CB", "CC", "CD" }, { "DA", "DB", "DC", "DD" }, };
		return posicionDeProductos;
	}
	/*
	 * le pedimos al ususario la posicion y la cantidad, verificamos si la posicion
	 * existe, luego verificamos que cantidad tenemos y si al sumarle la cantidad
	 * deseada con lo que ya habia no supera el la cantidad 5 se podra rellenar.
	 */
	public static boolean rellenarProducto(String posicionARellenar, int cantidadARellenar,
			int cantidadDeProductos[][]) {
		String[][] posicionDeProductos = CandyShop.pocisionProductos();
		int cantidadActual = 0;
		String pocisionEncotrada = "";
		boolean seRelleno = false;
		for (int filas = 0; filas < posicionDeProductos.length; filas++) {
			for (int columnas = 0; columnas < posicionDeProductos.length; columnas++) {
				pocisionEncotrada = posicionDeProductos[filas][columnas];
				if (posicionARellenar.equals(pocisionEncotrada)) {
					cantidadActual = cantidadDeProductos[filas][columnas];
					cantidadActual = cantidadActual + cantidadARellenar;
					if (cantidadActual < 6) {
						cantidadDeProductos[filas][columnas] = cantidadActual;
						seRelleno = true;
						break;
					}
				}
			}
		}
		return seRelleno;
	}
	/*
	 * tomaremos el nombre que nos ha indicado el usuario y lo buscaremos en la
	 * matriz de productos, cuando en contremos la coincidencia applicamos el cambio
	 * de precio a esa coincidencia y seguimos buscando maás coincidencias
	 */
	public static boolean cambiarPrecio(String nombreProducto, double preciosDeProductos[][], String nombresdeProductos[][], double precioNuevo) 
	{
		boolean cambiarPrecio = false;
		String productoEncontrado = "";
		double precioEncontrado = 0;
		nombreProducto.replace(" ", "");
		if (precioNuevo > 0) 
		{
			for (int filas = 0; filas < nombresdeProductos.length; filas++) {
				for (int columnas = 0; columnas < nombresdeProductos.length; columnas++) 
				{
					productoEncontrado = nombresdeProductos[filas][columnas];
					precioEncontrado = preciosDeProductos[filas][columnas];
					if (nombreProducto.replace(" ", "").equalsIgnoreCase(productoEncontrado.replace(" ", ""))) 
					{
						preciosDeProductos[filas][columnas] = precioNuevo;
						cambiarPrecio = true; // cambiamos el booleano a devolver.
					}
				}
			}
		}
		return cambiarPrecio;
	}
	/*verificamos si la contraseña actual coincide con la introducida para entrar al submenu*/
	public static boolean verificarUsuario(String contraseña, String entrada) {
		boolean aceptada = false;
		if (contraseña.equals(entrada)) {
			aceptada = true;
		}
		return aceptada;
	}
	/*
	 * Llamamos a a esta funcion para alinear el texto de una matriz de Strings
	 * verificando primero cual es el texto mas largo y luego llenado con espacios
	 * el resto de textos para que todos queden alineados
	 */
	public static void alinearTexto(String textoAAlinear[][]) {
		int contadorEspacios = 0;
		int tamaño = 0;
		String texto = "";
		int tamañoMaximo = 0;
		for (int filas = 0; filas < textoAAlinear.length; filas++) {
			for (int columnas = 0; columnas < textoAAlinear.length; columnas++) {
				texto = textoAAlinear[filas][columnas];
				tamaño = texto.length();
				if (tamaño > tamañoMaximo) {
					tamañoMaximo = tamaño;
				}
			}
		}
		for (int filas = 0; filas < textoAAlinear.length; filas++) {
			for (int columnas = 0; columnas < textoAAlinear.length; columnas++) {
				texto = textoAAlinear[filas][columnas];
				if (texto.length() < tamañoMaximo) {
					contadorEspacios = tamañoMaximo - texto.length();
					for (int i = 0; i < contadorEspacios; i++) {
						String espacio = " ";
						texto = texto + espacio;
					}
					textoAAlinear[filas][columnas] = texto;
				}
				textoAAlinear[filas][columnas] = texto;
			}
		}
	}

	/* verifica la que la posicion indicada por el usuario es correcta si la posicion existe en la matriz |posicionDeProductos| */
	public static boolean verificarPosicion(String posicionDeProductos[][], String posicionElegida) {
		boolean aceptada = false;
		String pocisionEncotrada = "";
		for (int filas = 0; filas < posicionDeProductos.length; filas++) {
			for (int columnas = 0; columnas < posicionDeProductos.length; columnas++) {
				pocisionEncotrada = posicionDeProductos[filas][columnas];
				if (posicionElegida.equals(pocisionEncotrada)) {
					aceptada = true;
				}
			}
		}
		return aceptada;
	}
	// se cambia el nombre en la matriz de nombres de productos que se creo en el main.
	public static void cambiarNombre(String nombresdeProductos[][], int filas, int columnas, String nuevoNombre) {
		nombresdeProductos[filas][columnas] = nuevoNombre;
	}
	/*
	 * En el ranking creo un array que donde se ingresara las ventas, cada posiscion
	 * corresponde a un producto, 0-Lacasitos 1-Chicles de fresa 2- KiKat 3-Palotes
	 * 4-Oreo 5-Bolsa haribo 6-Cheetos 7-Twix 8-M&M´S 9-Kinder Bueno 10-Papa Delta
	 * 11-Chicles de menta 12-crunch 13-Milkybar // LO UTILIZARE PARA RELLENAR CON
	 * LA FUNSION agregarVenta
	 */
	public static int[] rankingVentas() {
		int ventas[] = new int[15];
		for (int fila = 0; fila < ventas.length; fila++) {
			ventas[fila] = 0;
		}
		return ventas;
	}

	/* Aqui estan los productos que se venden en la maquina, tomamos los datos de la matriz productos y creamos una lista en la que no se repita el mismo nombre */
	public static String[] productosEnVenta(String nombresdeProductos[][]) {
		String productoEnArray = "";
		String productoEnMatriz = "";
		boolean productoRepetido = false;
		alinearTexto(nombresdeProductos);
		String productosEnVenta[] = { "", "", "", "", "", "", "", "", "", "", "", "", "", "", "", "", "" };
		int contadorFilasArray = 0;
		for (int fila = 0; fila < nombresdeProductos.length; fila++) {
			for (int columna = 0; columna < nombresdeProductos.length; columna++) {
				productoEnArray = productosEnVenta[contadorFilasArray];
				productoEnMatriz = nombresdeProductos[fila][columna];
				for (int filaArry = 0; filaArry < productosEnVenta.length; filaArry++) {
					productoEnArray = productosEnVenta[filaArry];
					productoRepetido = productoEnMatriz.equals(productoEnArray);
					if (productoRepetido == true) {
						break;
					}
				}
				if (productoRepetido == false) {
					productosEnVenta[contadorFilasArray] = nombresdeProductos[fila][columna];
					contadorFilasArray++;
				}
			}
		}
		Arrays.sort(productosEnVenta);
		return productosEnVenta;
	}
	// se llama a esta funcion cada vez que se entrega una golosina y asi almacenamos el numero de ventas para cada producto por su nombre en la lista de ventas |rankingVentas|
	public static void agregarVenta(int rankingVentas[], int filaProducto, int columnaProducto,
			String productosEnVenta[], String nombresDeProductos[][]) {
		String producto = nombresDeProductos[filaProducto][columnaProducto];
		for (int fila = 0; fila < rankingVentas.length; fila++) {
			String productoEncontrado = productosEnVenta[fila];
			if (productoEncontrado.replace(" ", "").equals(producto.replace(" ", ""))) {
				rankingVentas[fila] = rankingVentas[fila] + 1;
			}
		}
	}
	// sumamos todas a la variable ventas totales cada producto cada ves que se realiza una venta en la opcion 1 del menu.
	public static double sumarAVentasTotales(double ventasTotales, int filaProducto, int columnaProducto, double preciosDeProductos[][]) 
	{
		double precioProducto = preciosDeProductos[filaProducto][columnaProducto];
		ventasTotales = ventasTotales + precioProducto ;
		return ventasTotales;
		}
	/* Buscamos el mayor de la lista de ranking de ventas y lo mostramos por pantalla a ese y a todos los iguales 
	 * depúes mostramos el segundo mayor y luego el tercero y lo mostramos y a sus iguales. -si no hay ventas- muestra un mensaje indicandolo
	 * solo muestra si ha habido ventas de los productos.
	*/
	public static boolean rankingMasVendidos(int rankingVentas[], String productosVentas[]) {
		int mejoresTres = 0;
		boolean repetir = true;
		int numeroUno = 0;
		int numeroDos = 0;
		int numeroTres = 0;
		boolean noVentas = false;
		int contadorProductos = 0;
		while (repetir) {// se repetira hasta encontrar treS cifras superiores a 0
			int fila = 0;
			for (fila = 0; fila < rankingVentas.length; fila++) {
				int venta = rankingVentas[fila];
				if (venta > numeroUno) {
					numeroUno = venta; // primero buscamos el numero de mas alto que representa el producto que más se
					// vendio
				}
			}
			for (fila = 0; fila < rankingVentas.length; fila++) {
				int venta = rankingVentas[fila];
				if (venta > 0) {
					if (numeroUno == venta) {
						contadorProductos++;
						System.out.println("producto " + contadorProductos + " : " + productosVentas[fila]
								+ " y cantidad:" + numeroUno);
					}
				}
			}
			mejoresTres++;
			for (fila = 0; fila < rankingVentas.length; fila++) {
				int venta = rankingVentas[fila];
				if (venta > numeroDos && venta != numeroUno) { // segundo buscamos el numero más alto despues del top 1
					numeroDos = venta;
				}
			}
			for (fila = 0; fila < rankingVentas.length; fila++) {
				int venta = rankingVentas[fila];
				if (venta > 0) {
					if (numeroDos == venta) {
						contadorProductos++;
						System.out.println("producto " + contadorProductos + " : " + productosVentas[fila]
								+ " y cantidad:" + numeroDos);
					}
				}
			}
			mejoresTres++;
			for (fila = 0; fila < rankingVentas.length; fila++) {
				int venta = rankingVentas[fila];
				if (venta > numeroTres && venta != numeroDos && venta != numeroUno) { // buscamos el numero más alto
					// despúes del top 2
					numeroTres = venta;
				}
			}
			for (fila = 0; fila < rankingVentas.length; fila++) {
				int venta = rankingVentas[fila];
				if (venta > 0) {
					if (numeroTres == venta) {
						contadorProductos++;
						System.out.println("producto " + contadorProductos + " : " + productosVentas[fila]
								+ " y cantidad:" + numeroTres);
					}
				}
			}
			mejoresTres++;
			if (mejoresTres == 3) {
				repetir = false;
			}
		}
		if (contadorProductos == 0) { // si no se ha subido el contador quiere decir que no hay ningún numero mayor a
			// 0, por lo cual no hay ventas.
			noVentas = true;
		}
		return noVentas;
	}
	/*
	 * buscamos el numero más bajo tomando como referencia el primer numero de la
	 * casilla 0 del array , para hacer el top 3 peores ventas, pero si hay varias
	 * productos con el mismo numero de ventas se repetiran--- Al haber casillas
	 * vacias en productos en venta primero quitamos esas opciones
	 */
	public static void rankingMenosVendidos(int rankingVentas[], String productosVentas[]) {
		int contadorPrimerProductoEnLista = 0;
		int fila = 0;
		for (fila = 0; fila < rankingVentas.length; fila++) {
			int venta = rankingVentas[fila];
			if (productosVentas[fila] == "") {
				contadorPrimerProductoEnLista++;
			}
		}
		int numeroUno = rankingVentas[contadorPrimerProductoEnLista];
		int numeroDos = rankingVentas[contadorPrimerProductoEnLista];
		int numeroTres = rankingVentas[contadorPrimerProductoEnLista];
		int contadorProductos = 0;

		for (fila = 0; fila < rankingVentas.length; fila++) {
			int venta = rankingVentas[fila];
			if (venta < numeroUno) {
				numeroUno = venta; // primero buscamos el numero de mas bajo que representa el producto que más se
				// vendio
			}
		}
		for (fila = 0; fila < rankingVentas.length; fila++) {
			int venta = rankingVentas[fila];

			if (numeroUno == venta && productosVentas[fila] != "") {
				contadorProductos++;
				System.out.println(
						"producto " + contadorProductos + " : " + productosVentas[fila] + " y cantidad:" + numeroUno);
			}
		}
		for (fila = 0; fila < rankingVentas.length; fila++) {
			int venta = rankingVentas[fila];
			if (venta < numeroDos && venta != numeroUno) {
				numeroDos = venta; // buscamos el segundo numero de mas bajo que representa el producto que más se
				// vendio
			}
		}
		for (fila = 0; fila < rankingVentas.length; fila++) {
			int venta = rankingVentas[fila];

			if (numeroDos == venta && venta != numeroUno && productosVentas[fila] != "") {
				contadorProductos++;
				System.out.println(
						"producto " + contadorProductos + " : " + productosVentas[fila] + " y cantidad:" + numeroDos);
			}
		}
		for (fila = 0; fila < rankingVentas.length; fila++) {
			int venta = rankingVentas[fila];
			if (venta < numeroTres && numeroDos != venta && venta != numeroUno) {
				numeroTres = venta; // buscamos el TERCER numero mas bajo que representa el producto que peor se
				// vendio
			}
		}
		for (fila = 0; fila < rankingVentas.length; fila++) {
			int venta = rankingVentas[fila];

			if (numeroTres == venta && venta != numeroUno && numeroDos != venta && productosVentas[fila] != "") {
				contadorProductos++;
				System.out.println(
						"producto " + contadorProductos + " : " + productosVentas[fila] + " y cantidad:" + numeroTres);
			}
		}
	}

	public static int[] filaYColumna(String posicionElegida, String posicionDeProductos[][]) {
		int filaYColumna[] = new int[2];
		String pocisionEncotrada;
		for (int filas = 0; filas < posicionDeProductos.length; filas++) { // recorremos la matriz de posicion de
			// producto
			for (int columnas = 0; columnas < posicionDeProductos.length; columnas++) {
				pocisionEncotrada = posicionDeProductos[filas][columnas];
				if (pocisionEncotrada.equalsIgnoreCase(posicionElegida)) {
					filaYColumna[0] = filas;
					filaYColumna[1] = columnas;
				}
			}
		}
		return filaYColumna;
	}
	/*Al realizar una venta llamamos a esta funcion para reducir la cantidad de stock almacenado en el espacio correspondiente a la matriz |cantidadDeProductos|
	 * buscamos con los vectores indicados*/
	public static void descrementarProductoVendido(int filaProductoVendido, int columnaProductoVendido,
			String nombresdeProductos[][], int cantidadDeProductos[][]) {
		int unidadesProductoSolicitado = cantidadDeProductos[filaProductoVendido][columnaProductoVendido];
		String produtoVendido = nombresdeProductos[filaProductoVendido][columnaProductoVendido];
		cantidadDeProductos[filaProductoVendido][columnaProductoVendido] = unidadesProductoSolicitado - 1;

	}
	/* Buscamos en la lista de productosEnVenta y si el nombre aparece buscamos con ese mismo vector la en la lista de ventas para poder devolver 
	 * la cantidad vendida. 
	 */
	public static int buscarVentasDeProducto(String productoAMostrar, int rankingVentas[], String productosEnVenta[]) {
		int ventas = 0;
			for (int filas = 0; filas < productosEnVenta.length - 2; filas++) {
				String productoEncontrado = productosEnVenta[filas];
				if (productoEncontrado.replace(" ", "").equalsIgnoreCase(productoAMostrar.replace(" ", ""))) {
					int ventaEncontrada = rankingVentas[filas];
					ventas = ventas + ventaEncontrada;
				}
		}
		return ventas;
	}
	/* Buscamos en la lista de productosEnVenta y cuando el nombre aparece buscamos con esos mismos vectores la en la matriz de precios para poder devolver 
	 * el precio del producto. *es indiferente si el nombre se encuentra 2 veces, ya que sera el mismo precio para ambos 
	 */
	public static double buscarPrecioDeProducto(String productoAMostrar, double preciosDeProductos[][],String nombresdeProductos[][]) {
		double precioEncontrado = 0;
		for (int filas = 0; filas < nombresdeProductos.length; filas++) {
			for (int columnas = 0; columnas < nombresdeProductos.length; columnas++) {
				String productoEncontrado = nombresdeProductos[filas][columnas];
				if (productoEncontrado.replace(" ", "").equalsIgnoreCase(productoAMostrar.replace(" ", ""))) {
					precioEncontrado = preciosDeProductos[filas][columnas];
				}
			}
		}
		return precioEncontrado;
	}
	/* Con el nombre del producto buscamos en la matriz de |nombresdeProductos| y al encontrarlo, tomamos los vectores y verificamos en la matriz
	 * |cantidadDeProductos| y devolvemos esa cantidad *  si existen varias posiciones con el mismo producto las unidades se suman
	 */
	public static int buscarUnidadesDeProducto(String productoAMostrar, int cantidadDeProductos[][],
			String nombresdeProductos[][]) {
		int unidadesDeProductoAMostrar = 0;
		int unidadesEncontradas = 0;
		for (int filas = 0; filas < nombresdeProductos.length; filas++) {
			for (int columnas = 0; columnas < nombresdeProductos.length; columnas++) {
				String productoEncontrado = nombresdeProductos[filas][columnas];
				if (productoEncontrado.replace(" ", "").equalsIgnoreCase(productoAMostrar.replace(" ", ""))) {
					unidadesEncontradas = cantidadDeProductos[filas][columnas];
					unidadesDeProductoAMostrar = unidadesDeProductoAMostrar + unidadesEncontradas;
				}
			}
		}
		return unidadesDeProductoAMostrar;
	}

	public static void main(String[] arg) {
		double ventasTotales = 0;
		String contraseña = "DAM";
		boolean encendida = true;
		int cantidadDeProductos[][] = cantidadDeProductos();
		String posicionDeProductos[][] = pocisionProductos();
		double preciosDeProductos[][] = preciosDeProductos();
		String nombresdeProductos[][] = productos();
		int rankingVentas[] = rankingVentas();
		String textoAlineado[][] = nombresdeProductos;
		String productosEnVenta[] = productosEnVenta(nombresdeProductos);
		double precioNuevo = 0;
		boolean posicionExiste; // se declara este valor porque en varias ocaciones verificaremos si la posicion indicada por el usuario es correcta
		while (encendida) {
			Scanner sc = new Scanner(System.in);
			System.out.println("*** Opciones ***");
			System.out.println("");
			System.out.println("1. Pedir golosina");
			System.out.println("2. Mostrar golosina");
			System.out.println("3. Submenu de administrador");
			System.out.println(""); // Mostramos el menu principal llamando a la funcion
			System.out.println("Selecciona una opción: ");
			try {
				int opcion = sc.nextInt();
				if (opcion < 1 && opcion > 3) { // verificamos que la opcion no este fuera de los parametros
					System.out.println("La opcion no existe, pruebe de nuevo ");
					encendida = true;
				}
				switch (opcion) {
				/*
				 * 1 ) Pedir golosina: el usuario indicará la posición de la golosina que quiere
				 * sacar. Cada posición, viene asociada por un código de letras que se
				 * corresponde con una fila y una columna
				 */
				case 1:
					System.out.println("Introduce la posicion de la golosina: ");
					String pocisionElegida = sc.next().toUpperCase();
					posicionExiste = verificarPosicion(posicionDeProductos, pocisionElegida); //////////////////////////////////
					if (posicionExiste) {
						int filaYColumna[] = CandyShop.filaYColumna(pocisionElegida, posicionDeProductos); //
						int filas = filaYColumna[0];
						int columnas = filaYColumna[1];
						int unidadesProductoSolicitado = cantidadDeProductos[filas][columnas];
						if (unidadesProductoSolicitado == 0) {
							System.out.println("El producto seleccionado está agotado por favor elija otro. ");
						} else {
							// restamos la unidad de la cantidad disponible
							descrementarProductoVendido(filas, columnas, nombresdeProductos, cantidadDeProductos);
							agregarVenta(rankingVentas, filas, columnas, productosEnVenta, nombresdeProductos );/////////////////////////////
							ventasTotales = sumarAVentasTotales(ventasTotales, filas, columnas, preciosDeProductos);
							// Añado la venta a su posicion correspondiente en el array de ranking de
							// ventas// segun el nombre del articulo a su espacio correspondiente.

							System.out.println("Puede retirar su producto");
						}
					} else {
						System.out.println("La posicion indicada no es correcta");
					}

					break;
				case 2:
					/*
					 * 2) Mostrar golosinas: mostrara todas las golosinas disponibles. Mostrará el
					 * nombre de la golosina, el código que debe introducir el usuario, y el precio
					 */
					System.out.println("El listado de productos es:");
					alinearTexto(textoAlineado); // llamamos a este metodo para alinear el texto
					// ////////////////////////////
					for (int filas = 0; filas < posicionDeProductos.length; filas++) {
						for (int columnas = 0; columnas < posicionDeProductos.length; columnas++) {
							System.out.println("------------------------------------------------------");
							System.out.print("|  " + textoAlineado[filas][columnas]);
							System.out.print("|	Posición: " + posicionDeProductos[filas][columnas]);
							System.out.println("| Precio: " + preciosDeProductos[filas][columnas]);
						}
					}
					System.out.println(" ");
					break;
				case 3:
					/*
					 * este es un menú exclusivo al que solo puede acceder un técnico por lo que nos
					 * pedirá una contraseña. Si el usuario escribe “DAM” podrá acceder a dicho
					 * menú. SI NO ES LA CONTRASEÑA VOLVERA AL MENU INICIAL
					 */
					boolean aceptado = false;
					System.out.println("Escriba la contraseña: ");
					String entrada = sc.next();
					aceptado = verificarUsuario(contraseña, entrada); //////////////////////////////////////////////
					if (aceptado == false) {
						System.out.println(
								"Su contraseña no es la correcta, si la ha olvidado contacte con el administrador.");
					}
					while (aceptado == true) {
						System.out.println("*** Opciones Submenú ***");
						System.out.println("");
						System.out.println("1  Cambiar contraseña:");
						System.out.println("2  Rellenar golosinas:");
						System.out.println("3  Cambiar precio:");
						System.out.println("4  Cambiar producto:");
						System.out.println("5  Ranking más vendidos:");
						System.out.println("6  Menos vendido:");
						System.out.println("7  Info productos:");
						System.out.println("8  Ventas totales:");
						System.out.println("9  Cerrar sesión administrador:");
						System.out.println("10 Apagar la máquina:"); // Una vez verficado el usuario mostramos el  Submenú solo para administradores.						
						System.out.println("Selecciona una opción: ");
						opcion = sc.nextInt();
						switch (opcion) {
						case 1:// Permite cambiar la contraseña de acceso del administrador.
							System.out.println("Introduzca la nueva contraseña ");
							String nuevaContraseña = sc.next();
							System.out.println("Repita la nueva contraseña ");
							String repitaContraseña = sc.next();
							if (nuevaContraseña.equals(repitaContraseña)) {
								contraseña = nuevaContraseña;
								System.out.println("¡¡¡ Password cambiado !!!");
							} else {
								System.out.println(
										"El password nuevo y su confirmacion NO COINCIDEN. Se mantiene el que ya habia.");
							}
							break;
						case 2:/*
						 * Pedirá la posición de la golosina y la cantidad que quiere añadir. La máquina
						 * solo tiene capacidad para alojar hasta 5 golosinas en cada compartimento.
						 */
							System.out.println("Indique que posicion desea rellenar");
							String posicionARellenar = sc.next();
							System.out.println("Indique la cantidad que desea rellenar");
							int cantidadARellnar = sc.nextInt();
							boolean seRelleno = rellenarProducto(posicionARellenar, cantidadARellnar,cantidadDeProductos);
							if (seRelleno == true) {
								System.out.println("Se ha rellenado la posicion: " + posicionARellenar);
							} else {
								System.out.println("Con la cantidad indicada supera el maximo de 5  ");
								System.out.println("No se ha rellenado el cajetin");
							}
							break;
						case 3: // Permite cambiar el precio de un producto que haya en la máquina, pedirá el
							// nombre del producto
							System.out.print("Introduzca el nombre del producto al cual desea cambiar el precio");
							sc.nextLine();
							String nombreProducto = sc.nextLine();
							System.out.print("");
							System.out.println("Introduzca el precio nuevo");
							precioNuevo = sc.nextDouble();
							/*
							 * LLamamos a la funcion que comprobara que el producto existe en la maquina y
							 * luego modificara el precio en cada apartado donde aparezca el nombre que el
							 * usuario a ingresado
							 */
							boolean cambiarPrecio = cambiarPrecio(nombreProducto, preciosDeProductos, nombresdeProductos, precioNuevo); //////////
							if (cambiarPrecio == true) {
								System.out.println("El precio se ha modificado de manera correcta");
							}
							if (cambiarPrecio == false) {
								System.out.println("No se ha encontrado el nombre indicado o el precio es inferior a 0");
								System.out.println("No se ha modificado ningún dato.");
							}
							break;
						case 4: // Permite cambiar el nombre del producto que hay en una posición determinada de
							// la máquina.
							System.out.println("Introduzca la posicion donde cambiará el producto");
							String posicionElegida = sc.next().toUpperCase();
							posicionExiste = verificarPosicion(posicionDeProductos, posicionElegida);////////////////////////////////////////
							if (posicionExiste) { /* comprobamos si la posicion correcta */
								System.out.println("Indique el nuevo nombre: ");
								String nuevoNombre = sc.next();
								System.out.println("Introduzca el precio nuevo");
								precioNuevo = sc.nextDouble();
									if (precioNuevo<0)
									{
										System.out.println("No se puede colocar un precio negativo \n No se ha modificado ningun dato.");
										break;
									}
								System.out.println("Indique la cantidad que desea rellenar (maximo 5)");
								cantidadARellnar = sc.nextInt();
								if (cantidadARellnar<0 || cantidadARellnar>5)
								{
									System.out.println("cantidad de unidades incorrecta \n No se ha modificado ningun dato.");
									break;
								}
								// llamamos a una funcionque nos indique los vectores en la matrices donde tenemos almacenados los datos.
								int filaYColumna[] = CandyShop.filaYColumna(posicionElegida, posicionDeProductos); /////////////////////////////
								// EN EL ARRAY ·filaYColumna· SOLO HAY 2 DATOS EN LA POSICION 0 LA FILA Y EN LA
								// 1 LA COLUMNA
								int filas = filaYColumna[0];
								int columnas = filaYColumna[1];
								cambiarNombre(nombresdeProductos, filas, columnas, nuevoNombre);/////////////////////////
								cambiarPrecio(nuevoNombre, preciosDeProductos, nombresdeProductos, precioNuevo);/////////////////////////////////
								cantidadDeProductos[filas][columnas] = 0;// vaciamos el cajetin del producto antiguo
								rellenarProducto(posicionElegida, cantidadARellnar, cantidadDeProductos);///////////////////////////////
								productosEnVenta = productosEnVenta(nombresdeProductos);
								System.out.println("Se ha añadido el producto de forma correcta");
							} else {
								System.out.println("La posicion indicada no es correcta");
							}
							break;
						case 5:
							boolean noHayventas = false;
							System.out.println("Los productos MAS vendidos son:");
							// rankingMasVendidos = recorre la lista de ventas, muestra los 3 más vendidos y sus repeticiones en candidatos.
							
							noHayventas = rankingMasVendidos(rankingVentas, productosEnVenta);////////////////////////
							if (noHayventas == true) {
								System.out.println("todavia no se ha vendido ningún producto");
							}
							break;
						case 6:
							System.out.println("Los productos MENOS vendidos son:");
							rankingMenosVendidos(rankingVentas, productosEnVenta);//////////////////////////
							break;
						case 7:
							System.out.println("Informacion de productos: ");
							for (int filas = 0; filas < productosEnVenta.length; filas++) 
							{
								String productoAMostrar = productosEnVenta[filas];
								if (productoAMostrar != "") {
									System.out.println("-----------------------------------------------------------------");
									System.out.print("|  " + productoAMostrar);
									double precioDeProductoAmostrar = buscarPrecioDeProducto(productoAMostrar,
											preciosDeProductos, nombresdeProductos);//////////////
									System.out.print("| Precio: " + precioDeProductoAmostrar + "€");
									int unidadesDeProductoAmostrar = buscarUnidadesDeProducto(productoAMostrar,
											cantidadDeProductos, nombresdeProductos);////////////
									System.out.print("| U. Disponibles: " + unidadesDeProductoAmostrar);
									int ventasDeProductoAmostrar = buscarVentasDeProducto(productoAMostrar,
											rankingVentas, productosEnVenta);//////////
									System.out.println("| Ventas: " + ventasDeProductoAmostrar);
								}
							}
							System.out.println(" ");
							break;
						case 8:
							System.out.println("Ventas totales: " +	 ventasTotales +" € .");
							System.out.println("");
							break;
						case 9:
							// se cambia la situacion de password para cerrar el bucle while
							aceptado = false;
							System.out.println("Ha vuelto al menu de usuario");
							break;
						case 10:
							// se cambia la situacion de password para cerrar el bucle while del SUBMENU y el booleano encendido para terminar el programa
							System.out.println("La maquina se ha apagado ");
							encendida = false;
							aceptado = false;
							break;

						default:
							System.out.println("La opcion no existe, pruebe de nuevo ");
						}
					}
					break;
				default:
					System.out.println("La opcion no existe, pruebe de nuevo ");
				}
			} catch (java.util.InputMismatchException error) {
				System.out.println("Error en dato introducido");
				System.out.println("Vuelve al menú principal \n");
			}
		}

	}
}