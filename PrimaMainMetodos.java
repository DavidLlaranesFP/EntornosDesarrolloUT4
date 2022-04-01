import java.util.Scanner;

/**
 * <h1>Problema del c�lculo de la prima</h1>
 * 
 * <p>Se calcula la prima que corresponde a un empleado seg�n una serie de par�metros
 * Estos par�metros se introducir�n por teclado previa petici�n, siendo validados en el 
 * proceso de petici�n</p>
 * 
 * @version v1.2022
 * @author David Fern�ndez Mu�oz
 */



public class PrimaMainMetodos {
	

	/**
	 * Variable est�tica para la entrada de datos por teclado
	 */
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
	 * @param esDirectivo	char que indica si lo es o no
	 * @param meses	int que almacena el n�mero de meses de antig�edad del empleado
	 * @return	String de valor P1 si es directivo y tiene un antig�edad mayor o igual a 12 meses,
	 *  valor P2 si no es directivo y tiene una antig�edad mayor o igual a 12 meses,
	 *  valor P3 si es directivo y tiene una antig�edad menor que 12 meses,
	 *  valor P4 si no es directivo y tiene una antig�edad menor que 12 meses
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

	/**
	 * M�todo que lee el n�mero del empleado y valida que sea un entero positivo de tres d�gitos
	 * @return	int con el n�mero del empleado 
	 */
	public static int leerNumEmple() {		
		int numEmple;
		do{
			System.out.println("NÚMERO [100-999]: ");
			numEmple = teclado.nextInt();
		}while(numEmple<100 || numEmple>999);		
		teclado.nextLine();
		return numEmple;
	}
	
	/**
	 * M�todo que lee el nombre del empleado y valida que no tenga m�s de diez caracteres
	 * @return	String con el nombre del empleado
	 */
	public static String leerNomEmple() {
		String nomEmple;
		do {
			System.out.println("NOMBRE (max 10 caracteres): ");
			nomEmple = teclado.nextLine();
		}while(nomEmple.length()>10);		
		return nomEmple;
	}
	

	/**
	 * M�todo que lee la antig�edad del empleado en meses y valida que sea un entero positivo o cero
	 * @return	int con el n�mero de meses de antig�edad del empleado
	 */
	public static int leerMeses() {
		int meses;
		do {
			System.out.println("MESES DE TRABAJO: ");
			meses = teclado.nextInt();
		}while(meses<0);
		teclado.nextLine();
		return meses;
	}
	

	/**
	 * M�todo que lee por teclado si el empleado es directivo o no
	 * @return char de valor '+' si es directivo, '-' si no lo es
	 */
	public static char leerEsDirectivo() {
		char esDirectivo;
		do {
			System.out.println("¿ES DIRECTIVO? (+/-): ");
			esDirectivo = teclado.nextLine().charAt(0);
		}while(esDirectivo!='+' && esDirectivo!='-');
		return esDirectivo;
	}
}
