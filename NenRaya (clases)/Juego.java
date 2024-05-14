import java.util.Scanner;

public class Juego {

    public static void main(String[] args) {
        Juego j1 = new Juego();
        j1.jugarNJuegos(crearArrayJuegos());
    }

    public static Njuegos[] crearArrayJuegos() {
        Njuegos[] arrayJuegos;
        Scanner leer = new Scanner(System.in);
        System.out.println("¿A cuantos juegos quieres jugar al mismo tiempo?");
        int tamaño = leer.nextInt();
        arrayJuegos = new Njuegos[tamaño];
        for (int i = 0; i < arrayJuegos.length; i++) {
            System.out.println("¿A qué juego quieres jugar? 1-NRaya 2-Aleatorio");
            int juego = leer.nextInt();
            if (juego == 1) {
                arrayJuegos[i] = new JuegoNRaya();
            } else if (juego == 2) {
                arrayJuegos[i] = new JuegoAleatorio();
            }
        }
        return arrayJuegos;
    }

    public static void jugarNJuegos(Njuegos [] arrayJuegos){
        while(Njuegos.verificarJuegosTerminados(arrayJuegos)){
            Njuegos.cambiarJuegos(arrayJuegos);
        }
    }
}
