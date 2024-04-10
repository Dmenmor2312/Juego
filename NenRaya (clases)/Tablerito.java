package n_en_raya;

import java.util.Scanner;

public class Tablerito {

    private char[][] arrayTablero;
    private int fichasColocadas;
    Scanner leer = new Scanner (System.in);
    
    public void introducirLongitud(){
        int longitud;
        boolean valido = true;
        System.out.println("Introduce la longitud del tablero para el N en Raya");
        longitud = leer.nextInt();
        while(valido){
            if(longitud > 3){
              valido = true;
            }else{
               System.out.println("Introduce otra longitud pero que sea mayor o igual a 3");
               valido = false;
            }
        }
        arrayTablero  = new char [longitud][longitud]; 
    }

    public void colocarFicha() {
        int fila, columna;
        boolean jugadaValida = false;
        do {
            System.out.print("Jugador " + jugadorActual+ ", ingresa la fila (1-" + arrayTablero.length + "): ");
            fila = leer.nextInt() - 1; 
            System.out.print("Jugador " + jugadorActual + ", ingresa la columna (1-" + arrayTablero.length + "): ");
            columna = leer.nextInt() - 1; 

            if (fila >= 0 && fila < arrayTablero.length && columna >= 0 && columna < arrayTablero.length && arrayTablero[fila][columna] == ' ') {
                arrayTablero[fila][columna] = jugadorActual;
                jugadaValida = true;
            } else {
                System.out.println("Casilla ocupada o entrada inválida. Inténtalo de nuevo."); 
            }

        } while (!jugadaValida);
    }

    public void mostrarTablero() {
       System.out.println("Tablero actual:");
        for (int i = 0; i < arrayTablero.length; i++) {
            for (int j = 0; j < arrayTablero.length; j++) {
                System.out.print(arrayTablero[i][j]);
                if (j < arrayTablero.length - 1) {
                    System.out.print(" | ");
                }
            }
            System.out.println();
            if (i < arrayTablero.length - 1) {
                for (int k = 0; k < arrayTablero.length * 4 - 1; k++) {
                    System.out.print("-");
                }
                System.out.println();
            }
        }
        System.out.println();
    }

    public void verificarFinalizacion() {
         
    }

    private boolean comprobarFila() {
        int consecutivosNecesarios = 3;
        boolean ganador = true;
        for (int i = 0; i < arrayTablero.length; i++) {
            for (int j = 0; j <= arrayTablero.length - consecutivosNecesarios; j++) {
                for (int k = 0; k < consecutivosNecesarios; k++) {
                    if (arrayTablero[i][j + k] != jugadorActual) {
                        ganador = false;
                    }
                }
                if (ganador) {
                    ganador = true;
                }
            }
        }
        return ganador;
    }

    private boolean comprobarColumna() {
        int consecutivosNecesarios = 3;
        boolean ganador = true;
        for (int i = 0; i < arrayTablero.length; i++) {
            for (int j = 0; j <= arrayTablero.length - consecutivosNecesarios; j++) {
                for (int k = 0; k < consecutivosNecesarios; k++) {
                    if (arrayTablero[j + k][i] != jugadorActual) {
                        ganador = false;
                    }
                }
                if (ganador) {
                    ganador = true;
                }
            }
        }
        return ganador;
    }

    private boolean comprobarDiagonal() {
        int consecutivosNecesarios = 3;
        boolean ganador = true;
        for (int i = 0; i <= arrayTablero.length - consecutivosNecesarios; i++) {
            for (int j = 0; j <= arrayTablero.length - consecutivosNecesarios; j++) {
                for (int k = 0; k < consecutivosNecesarios; k++) {
                    if (arrayTablero[i + k][j + k] != jugadorActual) {
                        ganador = false;
                    }
                }
                if (ganador) {
                    ganador = true;
                }
            }
        }
        return ganador;
    }

    private boolean comprobarDiagonalInversa() {
        int consecutivosNecesarios = 3;
        boolean ganador = true;
        for (int i = 0; i <= arrayTablero.length - consecutivosNecesarios; i++) {
            for (int j = arrayTablero.length - 1; j >= consecutivosNecesarios - 1; j--) {
                for (int k = 0; k < consecutivosNecesarios; k++) {
                    if (arrayTablero[i + k][j - k] != jugadorActual) {
                        ganador = false;
                    }
                }
                if (ganador) {
                    return true;
                }
            }
        }
        return ganador;
    }
}