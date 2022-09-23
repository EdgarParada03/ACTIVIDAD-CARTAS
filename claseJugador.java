public class Jugador {
    String nombre;
    int numeroJugador;

    public Jugador() {
    }

    public Jugador(String nombre, int numeroJugador) {
        this.nombre = nombre;
        this.numeroJugador = numeroJugador;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public int getNumeroJugador() {
        return numeroJugador;
    }

    public void setNumeroJugador(int numeroJugador) {
        this.numeroJugador = numeroJugador;
    }
    
    
}
