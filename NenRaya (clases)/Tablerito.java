import java.util.Scanner;

public class Tablero {

    private char[][] arrayTablero;

    public void crearTablero() {
        int tamaño;
        Scanner leer = new Scanner(System.in);
        do {
            System.out.println("Introduce el tamaño del tablero para el N en Raya:");
            tamaño = leer.nextInt();
        } while (tamaño < 3);
        arrayTablero = new char[tamaño][tamaño];
    }

    public void colocarFicha(Jugador jugadorActual) {
        int fila, columna;
        boolean jugadaValida = false;
        Scanner leer = new Scanner(System.in);
        while (!jugadaValida) {
            System.out.print("Jugador " + jugadorActual.getNombre() + ", ingresa la fila (1-" + arrayTablero.length + "): ");
            fila = leer.nextInt() - 1;
            System.out.print("Jugador " + jugadorActual.getNombre() + ", ingresa la columna (1-" + arrayTablero.length + "): ");
            columna = leer.nextInt() - 1;
            if (fila >= 0 && fila < arrayTablero.length && columna >= 0 && columna < arrayTablero.length) {
                arrayTablero[fila][columna] = jugadorActual.getFicha();
                jugadaValida = true;
            } else {
                System.out.println("Casilla ocupada o entrada inválida. Inténtalo de nuevo.");
            }
        }
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

    public boolean verificarFinalizacion(Jugador jugadorActual) {
        if (comprobarFila(jugadorActual) || comprobarColumna(jugadorActual) || comprobarDiagonal(jugadorActual)
                || comprobarDiagonalInversa(jugadorActual)) {
            System.out.println("El jugador " + jugadorActual.getNombre() + " ha ganado la partida");
            return true;
        } else {
            if (tableroCompleto()) {
                System.out.println("La partida ha quedado en Empate");
                return true;
            } else {
                return false;
            }
        }
    }

    private boolean comprobarDiagonal(Jugador jugador) {
        int contadorDiagonal = 0;

        for (int i = 0; i < arrayTablero.length; i++) {
            if (arrayTablero[i][i] == jugador.getFicha()) {
                contadorDiagonal++;
            }
        }

        return (contadorDiagonal == arrayTablero.length) ? true : false;
    }

    private boolean comprobarDiagonalInversa(Jugador jugador) {
        int contadorDiagonalInversa = 0;

        for (int i = 0; i < arrayTablero.length; i++) {
            if (arrayTablero[i][arrayTablero.length - 1 - i] == jugador.getFicha()) {
                contadorDiagonalInversa++;
            }
        }

        return (contadorDiagonalInversa == arrayTablero.length) ? true : false;
    }

    private boolean comprobarColumna(Jugador jugador) {
        for (int i = 0; i < arrayTablero.length; i++) {
            int contador = 0;
            for (int j = 0; j < arrayTablero.length; j++) {
                if (arrayTablero[j][i] == jugador.getFicha()) {
                    contador++;
                }
            }
            if (contador == arrayTablero.length) {
                return true;
            } else {
                contador = 0;
            }
        }
        return false;
    }

    private boolean comprobarFila(Jugador jugador) {
        for (int i = 0; i < arrayTablero.length; i++) {
            int contador = 0;
            for (int j = 0; j < arrayTablero.length; j++) {
                if (arrayTablero[i][j] == jugador.getFicha()) {
                    contador++;
                }
            }
            if (contador == arrayTablero.length) {
                return true;
            } else {
                contador = 0;
            }
        }
        return false;
    }

    public boolean tableroCompleto() {
        for (int i = 0; i < arrayTablero.length; i++) {
            for (int j = 0; j < arrayTablero.length; j++) {
                if (arrayTablero[i][j] == '*') {
                    return false; // Devuelve false si hay alguna casilla vacía
                }
            }
        }
        return true; // Devuelve true si todas las casillas están llenas
    }

    public void rellenarTablero(){
        for (int i = 0; i < arrayTablero.length; i++) {
            for (int j = 0; j < arrayTablero[i].length; j++) {
                arrayTablero[i][j] = '*';
            }
        }
    }
}
