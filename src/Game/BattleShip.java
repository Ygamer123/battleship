package Game;

import java.util.Scanner;
import java.util.Random;

/*Mejora el juego de los barcos que hiciste en la tarea7: Usa 5 filas y 5 columnas y esconde 2 barcos. 
 * También es necesario que vayas mostrando las casillas donde hay agua después de cada jugada. El juego termina cuando se han encontrado los 2 barcos*/

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
            System.out.println("Tablero:");
            System.out.println("  A B C D E");
            for (int i = 0; i < 5; i++) {
                System.out.print((i + 1) + " ");
                for (int j = 0; j < 5; j++) {
                    System.out.print(tablero[i][j]+" ");
                }
                System.out.println();
            }

            // Pedimos al usuario
            System.out.print("Introduce la fila (1-5): ");
            int fila = in.nextInt() - 1;
            System.out.print("Introduce la columna (A-E): ");
            char columnaChar = in.next().charAt(0);
            int columna = columnaChar - 'A'; // Letra a numero

            // Comprobamos
            if (barcos[fila][columna]) {
                System.out.println("---HAS ENCONTRADO UN BARCO---");
                tablero[fila][columna] = 'V';
                barcosEncontrados++;
            } else {
                System.out.println("---AGUA---");
                tablero[fila][columna] = 'A';
            }
            System.out.println();
        }

        // Fin
        System.out.println("Felicidades has GANADO!! (dos barcos encontrados)");
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
