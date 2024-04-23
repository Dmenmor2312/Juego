package n_en_raya;

import java.util.Scanner;

public class JuegoNRaya {

    private boolean terminado;
    private static Jugador[] jugadores;
    Scanner leer = new Scanner(System.in);

    public JuegoNRaya() {
        terminado = false;
        this.jugadores = new Jugador[2];
        crearJugador();
        seleccionarPrimerJugador();
        Tablero Tablero = new Tablero();
        Tablero.crearTablero();
    }

    public void iniciarJuego() {
        while (!terminado) {
            crearJugador();
            seleccionarPrimerJugador();
            Tablero Tablero = new Tablero();
            Tablero.crearTablero();
        }
    }

    public static String cambiarTurno() {
        String jugadorActual = null;
        for (int i = 0; i < jugadores.length; i++) {
            if (jugadores[i].isTurno() == true) {
                jugadores[i].setTurno(false);
            } else {
                jugadores[i].setTurno(true);
                jugadorActual = jugadores[i].getNombre();
            }
        }
        return jugadorActual;
    }

    public void seleccionarPrimerJugador() {
        String jugador;
        for (int i = 0; i < jugadores.length; i++) {
            System.out.println("¿Quien es el primer jugador?");
            jugador = leer.next();
            do {
                jugadores[i].setTurno(true);
            } while (jugadores[i].getNombre().equals(jugador));
        }
    }

    public void crearJugador() {
        String nombre;
        char ficha;
        for (int i = 0; i < jugadores.length; i++) {
            System.out.println("Dime tu nombre");
            nombre = leer.next();
            jugadores[i] = new Jugador(nombre);
            System.out.println("Dime la ficha que quieres utilizar");
            ficha = leer.next().charAt(0);
            jugadores[i].setFicha(ficha);
        }
    }

}
