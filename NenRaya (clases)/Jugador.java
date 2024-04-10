package n_en_raya;

public class Jugador {

    private char ficha;
    private String nombre;
    private boolean turno;

    public Jugador(char ficha, String nombre, boolean turno) {
        this.ficha = ficha;
        this.nombre = nombre;
        this.turno = turno;
    }

    public char getFicha() {
        return ficha;
    }

    public void setFicha(char ficha) {
        this.ficha = ficha;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public boolean isTurno() {
        return turno;
    }

    public void setTurno(boolean turno) {
        this.turno = turno;
    }

}
