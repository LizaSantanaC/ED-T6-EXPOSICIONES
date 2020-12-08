import java.util.Arrays;

public class FuncionHash {

	private String[] arreglo;
	private int tamaño;
	private int contador;

	// Constructor
	public FuncionHash(int tam) {
		tamaño = tam;
		arreglo = new String[tam];
		Arrays.fill(arreglo, "-1");
	}

	// Funcion HASH
	public void funcionHash(String[] cadArreglo, String[] arreglo) {
		int i;
		// Ciclo para asiganar a la varible elemento el valor de la cadena
		for (i = 0; i < cadArreglo.length; i++) {
			String elemento = cadArreglo[i];
			int indiceArreglo = Integer.parseInt(elemento) % 7;
			System.out.println("Indice: " + indiceArreglo + " para " + elemento);
			// Mpetodo para solucionar una colision
			while (arreglo[indiceArreglo] != "-1") {
				indiceArreglo++;
				System.out.println("Colisión en el indice: " + (indiceArreglo - 1) + " cambiando por " + indiceArreglo);
				// Cambiar al indice siguiente y asi evitar la colision
				indiceArreglo %= tamaño; // Para volver a sacar el valor
			}
			arreglo[indiceArreglo] = elemento;
		}
	}

	// Metodo para mostrar la funcion hash
	public void mostrar() {
		int incremento = 0;
		int j;

		for (int i = 0; i < 1; i++) {
			incremento += 8;
			for (j = 0; j < 100; j++) {
			}
			System.out.println("");
			System.out.println("------------------------------------------------------------------");
			for (j = incremento - 8; j < incremento; j++) {
				System.out.format(" | %3s " + " ", j);
			}
			System.out.println(" | ");
			for (int k = 0; k < 100; k++) {
			}
			System.out.println();
			for (j = incremento - 8; j < incremento; j++) {
				if (arreglo[j].equals("-1")) {
					System.out.println(" | ");
				} else {
					System.out.print(String.format(" | %3s" + " ", arreglo[j]));
				}
			}

			System.out.println("|");
			System.out.println("------------------------------------------------------------------");
			for (j = 0; j < 100; j++) {
			}
			System.out.println("");
		}
	}

	// Metodo para buscar una clave de los elementos
	public String buscarClave(String elemento) {
		
		int indiceArrglo = Integer.parseInt(elemento) % 7;
		int contador = 0;
		
		while (arreglo[indiceArrglo] != "-1") {
			if (arreglo[indiceArrglo] == elemento) {
				System.out.println("Elemento " + elemento + " se encontro en el indice" + indiceArrglo);
				return arreglo[indiceArrglo];
			}
			indiceArrglo++;
			indiceArrglo %= tamaño;
			contador++;
			if (contador > 7) {
				System.out.print("Error");
				break;
			}
		}
		return null;
	}

	public static void main(String[] args) {
		FuncionHash funcion = new FuncionHash(8);
		String[] elementos= {"25", "14", "96", "300", "1", "12", "8", "15"};
		funcion.funcionHash(elementos, funcion.arreglo);
		funcion.mostrar();
		
		//Buscar
		String buscarElemento= funcion.buscarClave("12");
		if(buscarElemento == null) {
			System.out.print("\n Elemento no encontrado");
		}
	}
}