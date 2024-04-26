package n_en_raya;

import java.util.Scanner;

public class JuegoNRaya {

    static boolean terminado;
    private static Jugador[] jugadores;
    Scanner leer = new Scanner(System.in);

    public JuegoNRaya() {
        terminado = false;
        this.jugadores = new Jugador[2];
        crearJugador();
        seleccionarPrimerJugador();
        Tablero tablero = new Tablero();
        Tablero.crearTablero();
        JuegoNRaya.jugar();
    }

    public static void jugar() {
        while (!terminado) {
            Tablero.colocarFicha();
            Tablero.mostrarTablero();
            boolean verificarFinalizacion = Tablero.verificarFinalizacion(terminado, terminado, terminado, terminado, terminado);
            cambiarTurno();
        }
    }

    public static void cambiarTurno(){
        if(jugadores[0].isTurno()){
            jugadores[0].setTurno(false);
            jugadores[1].setTurno(true);
        } else {
            jugadores[0].setTurno(true);
            jugadores[1].setTurno(false);
        }
    }
    
    public static Jugador jugadorActual() {
        if (jugadores[0].isTurno()) {
            return jugadores[0];
        } else {
            return jugadores[1];
        }
    }

public void seleccionarPrimerJugador() {
        String jugador;
        do {
            System.out.println("¿Quien es el primer jugador?");
            jugador = leer.next();
        } while (!jugador.equals(jugadores[0].getNombre()) && !jugador.equals(jugadores[1].getNombre()));
        if(jugador.equals(jugadores[0])){
            jugadores[0].setTurno(true);
        }else{
            jugadores[1].setTurno(true);
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
