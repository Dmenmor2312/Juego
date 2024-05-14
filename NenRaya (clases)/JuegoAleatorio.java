import java.util.Scanner;
import java.util.Random;

public class JuegoAleatorio extends Njuegos{
    private boolean terminado;
    private Jugador[] jugadores;
    private int numeroAleatorio;
    Random random = new Random();

    public JuegoAleatorio (){
        terminado = false;
        this.jugadores = new Jugador[2];
        crearJugador();
        seleccionarPrimerJugador();
        this.numeroAleatorio = random.nextInt(TamañoADelleatorio());
    }
    
    public void jugar() {
        verificarFinalizacion(jugadorActual(),IntroducirNumero(jugadorActual()));
    }

    public boolean verificarFinalizacion(Jugador jugadorActual,int numeroIntroducido) {
        if(numeroIntroducido == numeroAleatorio){
            terminado = true;
            System.out.println("El jugador " + jugadorActual.getNombre() + " ha ganado");
        }else{
            terminado = false;
        }
        return terminado;
    }

    public int TamañoADelleatorio(){
        Scanner leer = new Scanner(System.in);
        System.out.println("Introduce el tamaño de numero que hay en el juego");
        int numero = leer.nextInt();
        return numero;
    }

    public int IntroducirNumero(Jugador jugadorActual){
        Scanner leer = new Scanner(System.in);
        System.out.println("Introduce un numero para adivinar el número aleatorio, " + jugadorActual.getNombre());
        int numero = leer.nextInt();
        return numero;
    }

    public void crearJugador() {
        Scanner leer = new Scanner(System.in);
        String nombre;
        for (int i = 0; i < jugadores.length; i++) {
            System.out.println("Dime tu nombre");
            nombre = leer.next();
            jugadores[i] = new Jugador(nombre);
        }
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

    public boolean getTerminado() {
        return terminado;
    }

    public void setTerminado(boolean terminado){
        this.terminado = terminado;
    }
}
