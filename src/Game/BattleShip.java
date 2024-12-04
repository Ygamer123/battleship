package Game;

import java.util.Scanner;
import java.util.Random;

/*Millora el joc dels vaixells que vas fer en la tasca7: Utilitza 5 files i 5 columnes  i amaga 2 vaixells. 
 * També cal que vagis mostrant les caselles on hi ha aigua després de cada jugada. El joc s'acaba quan s'han trobat els 2 vaixells*/

public class BattleShip {
    public static void main(String[] args) {
        // Declaramos el tablero y variables
        char[][] tablero = {
            {'*', '*', '*', '*', '*'},
            {'*', '*', '*', '*', '*'},
            {'*', '*', '*', '*', '*'},
            {'*', '*', '*', '*', '*'},
            {'*', '*', '*', '*', '*'}};
        
        boolean[][] barcos = new boolean[5][5];
        int barcosEncontrados = 0;

        // Ocultamos los 2 barcos
        Random ran = new Random();
        int barcosColocados = 0;

        while (barcosColocados < 2) {
            int fila = ran.nextInt(5);
            int columna = ran.nextInt(5);
            if (!barcos[fila][columna]) { // Solo coloca el barco si no hay otro
                barcos[fila][columna] = true;
                barcosColocados++;
            }
        }


        Scanner in = new Scanner(System.in);
        while (barcosEncontrados < 2) {
        	
            // Tablero
            System.out.println("Tauler:");
            System.out.println("  A B C D E");
            for (int i = 0; i < 5; i++) {
                System.out.print((i + 1) + " ");
                for (int j = 0; j < 5; j++) {
                    System.out.print(tablero[i][j]+" ");
                }
                System.out.println();
            }

            // Pedimos al usuario
            System.out.print("Introdueix la fila (1-5): ");
            int fila = in.nextInt() - 1;
            System.out.print("Introdueix la columna (A-E): ");
            char columnaChar = in.next().charAt(0);
            int columna = columnaChar - 'A'; // Letra a numero

            // Comprobamos
            if (barcos[fila][columna]) {
                System.out.println("---HAS TROBAT UN VAIELL---");
                tablero[fila][columna] = 'V';
                barcosEncontrados++;
            } else {
                System.out.println("---AGUA---");
                tablero[fila][columna] = 'A';
            }
            System.out.println();
        }

        // Fin
        System.out.println("Felicitats has guanyat (dos vaixells trobats)");
        System.out.println("  A B C D E");
        for (int i = 0; i < 5; i++) {
            System.out.print((i + 1) + " ");
            for (int j = 0; j < 5; j++) {
                System.out.print(tablero[i][j] + " ");
            }
            System.out.println();
        }

        in.close();
    }
}
