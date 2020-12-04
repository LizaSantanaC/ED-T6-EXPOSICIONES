class BusquedaBinaria {
	
	public static int busquedaBinaria(int[] matriz, int[] valorBuscado) {
		if (matriz.length == 0) {
			return -1;
		}
		int mitad, inferior = 0;
		int superior = matriz.length - 1;

		do {
			mitad = (inferior + superior) / 2;
			if (valorBuscado > matriz[mitad]) {
				inferior = mitad + 1;
			} else {
				superior = mitad - 1;
			}
		} while (matriz[mitad] != valorBuscado && inferior <= superior);
		if(matriz[mitad] == valorBuscado) {
			return mitad;
		}else {
			return -1;
		}
	}
}

public class PruebaBusquedaBinaria {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
	}

}
