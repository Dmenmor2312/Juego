import java.util.Scanner;

public class JuegoNRaya {
    private boolean terminado;
    private Jugador[] jugadores;
    private Tablero tablero;

    public JuegoNRaya() {
        terminado = false;
        this.jugadores = new Jugador[2];
        crearJugador();
        seleccionarPrimerJugador();
        tablero = new Tablero();
        tablero.crearTablero();
        tablero.rellenarTablero();
    }

    public void jugar() {
        tablero.colocarFicha(jugadorActual());
        tablero.mostrarTablero();
        terminado = tablero.verificarFinalizacion(jugadorActual());
    }

    public void cambiarTurno() {
        if (jugadores[0].isTurno()) {
            jugadores[0].setTurno(false);
            jugadores[1].setTurno(true);
        } else {
            jugadores[0].setTurno(true);
            jugadores[1].setTurno(false);
        }
    }

    public Jugador jugadorActual() {
        if (jugadores[0].isTurno()) {
            return jugadores[0];
        } else {
            return jugadores[1];
        }
    }

    public void seleccionarPrimerJugador() {
        Scanner leer = new Scanner(System.in);
        String jugador;
        do {
            System.out.println("¿Quien es el primer jugador?");
            jugador = leer.next();
        } while (!jugador.equals(jugadores[0].getNombre()) && !jugador.equals(jugadores[1].getNombre()));
        if (jugador.equals(jugadores[0].getNombre())) {
            jugadores[0].setTurno(true);
        } else if (jugador.equals(jugadores[1].getNombre())) {
            jugadores[1].setTurno(true);
        }
    }

    public void crearJugador() {
        Scanner leer = new Scanner(System.in);
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

    public boolean getTerminado() {
        return terminado;
    }

    public void setTerminado(boolean terminado){
        this.terminado = terminado;
    }
}
