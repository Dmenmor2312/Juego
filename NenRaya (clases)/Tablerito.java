package n_en_raya;

import java.util.Scanner;

public class Tablero {

    private static char[][] arrayTablero;
    private int fichasColocadas;
    Scanner leer = new Scanner (System.in);
    
    public void crearTablero(){
        int tamaño;
        do{
           System.out.println("Introduce el tamaño del tablero para el N en Raya:");
           tamaño = leer.nextInt();
        }while(tamaño < 3);
        arrayTablero  = new char [tamaño][tamaño]; 
    }

    public static void colocarFicha() {
        static int fila, columna;
        boolean jugadaValida = false;
        while (!jugadaValida){
            System.out.print("Jugador " + JuegoNRaya.cambiarTurno().getNombre()+ ", ingresa la fila (1-" + arrayTablero.length + "): ");
            fila = leer.nextInt() - 1; 
            System.out.print("Jugador " + JuegoNRaya.cambiarTurno().getNombre() + ", ingresa la columna (1-" + arrayTablero.length + "): ");
            columna = leer.nextInt() - 1; 

            if (fila >= 0 && fila < arrayTablero.length && columna >= 0 && columna < arrayTablero.length && arrayTablero[fila][columna] == ' ') {
                arrayTablero[fila][columna] = JuegoNRaya.cambiarTurno().getFicha();
                jugadaValida = true;
            } else {
                System.out.println("Casilla ocupada o entrada inválida. Inténtalo de nuevo.");
            {
        }
    }

    public static void mostrarTablero() {
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

    public static boolean verificarFinalizacion(boolean filaCompleta, boolean columnaCompleta, boolean diagPrincCompleta, boolean diagInversaCompleta, boolean tableroCompleto) {
        if(filaCompleta || columnaCompleta || diagPrincCompleta || diagInversaCompleta || tableroCompleto){
            JuegoNRaya.terminado = true;
        }else{
            JuegoNRaya.terminado = false;
        }
        return JuegoNRaya.terminado;
    }

    private boolean comprobarFila() {
        int consecutivosNecesarios = 3;
        boolean filaCompleta = true;
        for (int i = 0; i < arrayTablero.length; i++) {
            for (int j = 0; j <= arrayTablero.length - consecutivosNecesarios; j++) {
                for (int k = 0; k < consecutivosNecesarios; k++) {
                    if (arrayTablero[i][j + k] != JuegoNRaya.cambiarTurno().getFicha()) {
                        filaCompleta = false;
                    }
                }
                if (filaCompleta) {
                    filaCompleta = true;
                }
            }
        }
        return filaCompleta;
    }

    private boolean comprobarColumna() {
        int consecutivosNecesarios = 3;
        boolean columnaCompleta = true;
        for (int i = 0; i < arrayTablero.length; i++) {
            for (int j = 0; j <= arrayTablero.length - consecutivosNecesarios; j++) {
                for (int k = 0; k < consecutivosNecesarios; k++) {
                    if (arrayTablero[j + k][i] != JuegoNRaya.cambiarTurno().getFicha()) {
                        columnaCompleta = false;
                    }
                }
                if (columnaCompleta) {
                    columnaCompleta = true;
                }
            }
        }
        return columnaCompleta;
    }

    private boolean comprobarDiagonal() {
        int consecutivosNecesarios = 3;
        boolean diagPrincCompleta = true;
        for (int i = 0; i <= arrayTablero.length - consecutivosNecesarios; i++) {
            for (int j = 0; j <= arrayTablero.length - consecutivosNecesarios; j++) {
                for (int k = 0; k < consecutivosNecesarios; k++) {
                    if (arrayTablero[i + k][j + k] != JuegoNRaya.cambiarTurno().getFicha()) {
                        diagPrincCompleta = false;
                    }
                }
                if (diagPrincCompleta) {
                    diagPrincCompleta = true;
                }
            }
        }
        return diagPrincCompleta;
    }

    private boolean comprobarDiagonalInversa() {
        int consecutivosNecesarios = 3;
        boolean diagInversaCompleta = true;
        for (int i = 0; i <= arrayTablero.length - consecutivosNecesarios; i++) {
            for (int j = arrayTablero.length - 1; j >= consecutivosNecesarios - 1; j--) {
                for (int k = 0; k < consecutivosNecesarios; k++) {
                    if (arrayTablero[i + k][j - k] != JuegoNRaya.cambiarTurno().getFicha()) {
                        diagInversaCompleta = false;
                    }
                }
                if (diagInversaCompleta) {
                    return true;
                }
            }
        }
        return diagInversaCompleta;
    }
    
     public boolean tableroCompleto() {
        boolean tableroCompleto = true;
        for (int i = 0; i < arrayTablero.length; i++) {
            for (int j = 0; j < arrayTablero.length; j++) {
                if (arrayTablero[i][j] == ' ') {
                    tableroCompleto = false;
                    return tableroCompleto;
                }
            }
        }
        return tableroCompleto;
    }
}
