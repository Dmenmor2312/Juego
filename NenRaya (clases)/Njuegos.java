import java.util.Scanner;

public class Njuegos {

    private JuegoNRaya [] arrayJuegos;

    public Njuegos(){
        
    }

    public JuegoNRaya [] crearArrayJuegos() {
        Scanner leer = new Scanner(System.in);
        System.out.println("¿A cuantos juegos quieres jugar al mismo tiempo?");
        int tamaño = leer.nextInt();
        arrayJuegos = new JuegoNRaya[tamaño];
        for (int i = 0; i < arrayJuegos.length; i++) {
            arrayJuegos[i] = new JuegoNRaya();
        }
        return arrayJuegos;
    }

    public boolean verificarJuegosTerminados(JuegoNRaya[] arrayJuegos) {
        boolean seguir = false;
        for (int i = 0; i < arrayJuegos.length && !seguir; i++) {
            if (!arrayJuegos[i].getTerminado()) {
                seguir = true;
            }
        }
        return seguir;
    }
    public void cambiarJuegos(JuegoNRaya[] arrayJuegos) {
        boolean juegoTerminado = false;
        while (!juegoTerminado) {
            juegoTerminado = true;
            for (int i = 0; i < arrayJuegos.length; i++) {
                if (!arrayJuegos[i].getTerminado()) {
                    arrayJuegos[i].jugar();
                    juegoTerminado = false; // Si al menos un juego no está terminado, aún debemos continuar
                } else {
                    arrayJuegos[i].setTerminado(true);
                }
                arrayJuegos[i].cambiarTurno();
            }
        }
    }
    
}
