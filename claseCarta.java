public class Carta {
    private String color;
    private String tipo;
    private int valorNumerico;    
    private String valorTexto;

    public Carta() {
    }

    public Carta(String color, String tipazo, int valorNumerico, String valorTexto) {
        this.color = color;
        this.tipo = tipazo;
        this.valorNumerico = valorNumerico;
        this.valorTexto = valorTexto;
    }

    public String getColor() {
        return color;
    }

    public void setColor(String color) {
        this.color = color;
    }

    public String getTipo() {
        return tipo;
    }

    public void setTipo(String tipo) {
        this.tipo = tipo;
    }

    public int getValorNumerico() {
        return valorNumerico;
    }

    public void setValorNumerico(int valorNumerico) {
        this.valorNumerico = valorNumerico;
    }

    public String getValorTexto() {
        return valorTexto;
    }

    public void setValorTexto(String valorTexto) {
        this.valorTexto = valorTexto;
    }

    @Override
    public String toString() {
        return "Carta{" + "color=" + color + ", tipo=" + tipo + ", valorNumerico=" + valorNumerico + ", valorTexto=" + valorTexto + '}';
    }
    
    
}
