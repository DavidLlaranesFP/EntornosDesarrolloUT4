import java.util.Scanner;

/**
 * Problema del c�lculo de la prima
 * 
 * Se calcula la prima que corresponde a un empleado seg�n una serie de par�metros
 * Estos par�metros se introducir�n por teclado previa petici�n
 * 
 * @version v1.2022
 * @author David Fern�ndez Mu�oz
 */
public class PrimaMainMetodos {
	

	static Scanner  teclado=new Scanner(System.in);

	public static void main(String[] args) {

		int numEmple;
		String nomEmple;
		int meses;
		char esDirectivo;
		char respuesta;
		

		do {
			System.out.println("\nDATOS  EMPLEADO/A");
			numEmple=leerNumEmple();
			nomEmple=leerNomEmple();
			meses=leerMeses();
			esDirectivo=leerEsDirectivo();
			System.out.println("\n\tLe corresponde la prima "+hallarPrima(esDirectivo, meses));
			
			
			System.out.println("\n¿CALCULAR MAS PRIMAS? (S/N): ");
			respuesta=teclado.nextLine().toUpperCase().charAt(0);
		}while(respuesta=='S');		
	}


	/**
	 * M�todo est�tico que halla el tipo de la prima
	 * @param	char esDirectivo caracter que indica si lo es o no
	 * @param	int  meses entero que almacena el n�mero de meses de antig�edad del empleado
	 * @return	String de valor P1 si es directivo y tiene un antig�edad mayor o igual a 12 meses,
	 * String de valor P2 si no es directivo y tiene una antig�edad mayor o igual a 12 meses
	 * String de valor P3 si es directivo y tiene una antig�edad menor que 12 meses
	 * String de valor P4 si no es directivo y tiene una antig�edad menor que 12 meses
	 */
	public static String hallarPrima(char esDirectivo, int meses) {
		if(esDirectivo=='+') // ES DIRECTIVO
			if(meses>=12)
				return "P1";
			else
				return "P3";
		else 	// NO ES DIRECTIVO
			if(meses>=12)
				return "P2";
			else
				return "P4";
	}

	
	public static int leerNumEmple() {		
		int numEmple;
		do{
			System.out.println("NÚMERO [100-999]: ");
			numEmple = teclado.nextInt();
		}while(numEmple<100 || numEmple>999);		
		teclado.nextLine();
		return numEmple;
	}
	
	
	public static String leerNomEmple() {
		String nomEmple;
		do {
			System.out.println("NOMBRE (max 10 caracteres): ");
			nomEmple = teclado.nextLine();
		}while(nomEmple.length()>10);		
		return nomEmple;
	}
	

	public static int leerMeses() {
		int meses;
		do {
			System.out.println("MESES DE TRABAJO: ");
			meses = teclado.nextInt();
		}while(meses<0);
		teclado.nextLine();
		return meses;
	}
	

	public static char leerEsDirectivo() {
		char esDirectivo;
		do {
			System.out.println("¿ES DIRECTIVO? (+/-): ");
			esDirectivo = teclado.nextLine().charAt(0);
		}while(esDirectivo!='+' && esDirectivo!='-');
		return esDirectivo;
	}
}
