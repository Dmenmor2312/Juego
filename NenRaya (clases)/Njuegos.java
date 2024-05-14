public abstract class Njuegos extends Juego{
    private boolean terminado;

    public Njuegos(){
        this.terminado = false;
    }

    public static boolean verificarJuegosTerminados(Njuegos [] arrayJuegos) {
        boolean seguir = false;
        for (int i = 0; i < arrayJuegos.length && !seguir; i++) {
            if (!arrayJuegos[i].getTerminado()) {
                seguir = true;
            }
        }
        return seguir;
    }

    public static void cambiarJuegos(Njuegos [] arrayJuegos) {
        boolean juegoTerminado = false;
        while (!juegoTerminado) {
            juegoTerminado = true;
            for (int i = 0; i < arrayJuegos.length; i++) {
                if (!arrayJuegos[i].getTerminado()) {
                    arrayJuegos[i].jugar();
                    juegoTerminado = false;
                } else {
                    arrayJuegos[i].setTerminado(true);
                }
                arrayJuegos[i].cambiarTurno();
            }
        }
    }
    
    public boolean getTerminado() {
        return terminado;
    }

    public void setTerminado(boolean terminado){
        this.terminado = terminado;
    }
    
    public abstract void jugar();
    public abstract void cambiarTurno();
}
