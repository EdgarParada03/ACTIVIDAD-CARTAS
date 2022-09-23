import java.util.concurrent.ThreadLocalRandom;

/**
 *
 * @author Edgar Parada
 */
public class Barajas {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        // TODO code application logic here
        Carta[] crearPalo1 = crearPalo("Corazones", "Rojo");
        Carta[] crearPalo2 = crearPalo("Diamantes", "Negro");
        Carta[] crearPalo3 = crearPalo("Trevoles", "Rojo");
        Carta[] crearPalo4 = crearPalo("Pica", "Negro");
        Carta[] unionArreglos = unirArreglos(crearPalo1, crearPalo2, crearPalo3, crearPalo4);
        Carta[] shuffleCarts = revolverCartas(unionArreglos);

        Carta[] distributeCarts = new Carta[7];
        distributeCarts[0] = new Carta("Negro", "Picas", 10, "5");
        distributeCarts[1] = new Carta("Negro", "Picas", 9, "4");
        distributeCarts[2] = new Carta("Negro", "Picas", 8, "8");
        distributeCarts[3] = new Carta("Negro", "Picas", 7, "2");
        distributeCarts[4] = new Carta("Negro", "Picas", 6, "K");
        distributeCarts[5] = new Carta("Rojo", "Picas", 1, "10");
        distributeCarts[6] = new Carta("Rojo", "Picas", 3, "3");

        System.out.println("//////////////////////////////////////////////////////////////////////////////////////////");

        //boolean escReaCol = escaleraRealColor(distributeCarts);
        //System.out.println(escReaCol);

        System.out.println("//////////////////////////////////////////////////////////////////////////////////////////");

        boolean escRea = escaleraReal(distributeCarts);
        System.out.println(escRea);

        System.out.println("//////////////////////////////////////////////////////////////////////////////////////////");

        boolean pok = poker(distributeCarts);
        System.out.println(pok);

        System.out.println("//////////////////////////////////////////////////////////////////////////////////////////");

        boolean ful = full(distributeCarts);
        System.out.println(ful);

        System.out.println("//////////////////////////////////////////////////////////////////////////////////////////");

        boolean col = color(distributeCarts);
        System.out.println(col);

        System.out.println("//////////////////////////////////////////////////////////////////////////////////////////");
    }

    public static Carta[] crearPalo(String tipo, String color) {

        System.out.println("Las cartas de color " + color + " de " + tipo + " son las siguientes : ");

        String[] cartas = {"A", "2", "3", "4", "5", "6", "7", "8", "9", "10", "J", "Q", "K"};
        Carta[] palo = new Carta[cartas.length];
        for (int i = 0; i < cartas.length; i++) {
            palo[i] = new Carta(color, tipo, i + 1, cartas[i]);
            System.out.println(palo[i]);

        }

        System.out.println("+++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++");
        //Mezclar las cartas

        return palo;

    }

    //METODO
    public static Carta[] unirArreglos(Carta[] crearPalo1, Carta[] crearPalo2, Carta[] crearPalo3, Carta[] crearPalo4) {

        Carta[] unionArreglos = new Carta[52];
        int j = 0;
        for (int i = 0; i < 13; i++) {
            unionArreglos[j] = crearPalo1[i];
            j++;
            unionArreglos[j] = crearPalo2[i];
            j++;
            unionArreglos[j] = crearPalo3[i];
            j++;
            unionArreglos[j] = crearPalo4[i];
            j++;

        }

        System.out.println("La totalidad de cartas son:");

        for (int i = 0; i < 52; i++) {
            System.out.println(unionArreglos[i]);
        }

        System.out.println("+++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++");

        return unionArreglos;

    }

    public static Carta[] revolverCartas(Carta[] unionArreglos) { //Pa mezclar el arreglo 

        for (int i = 0; i < unionArreglos.length; i++) {
            // Restamos 1 de array.length porque los índices comienzan en 0
            int randomIndex = getRandomNumber(0, unionArreglos.length - 1);
            // Hacemos el intercambio...
            // Almacenamos el actual en una temporal
            Carta temp = unionArreglos[i];
            // Al actual le colocamos lo que haya en un índice aleatorio
            unionArreglos[i] = unionArreglos[randomIndex];
            // Y lo que había en el índice aleatorio lo remplazamos por lo que hay en temporal
            unionArreglos[randomIndex] = temp;
        }

        System.out.println("Las cartas mezcladas son: ");
        for (Carta value : unionArreglos) {
            System.out.println(value);

        }
        System.out.println("+++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++");
        return null;
        //FROM: https://parzibyte.me/blog/2020/08/19/java-mezclar-elementos-arreglo/
    }

    public static int getRandomNumber(int min, int max) {
        // nextInt regresa en rango pero con límite superior exclusivo, por eso sumamos 1
        return ThreadLocalRandom.current().nextInt(min, max + 1);
    }

    public static Carta[] repartirCartasFuncion(Carta[] shuffleCarts, Carta[] unionArreglos) {

        System.out.println("La reparticion de cartas, quedo de la siguiente manera: ");
        System.out.println("+++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++");

        for (int i = 0; i < 2; i++) {

            Carta aux = unionArreglos[i];

            System.out.println("Las cartas para el jugador 1 son :" + aux);

        }

        System.out.println("+++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++");

        for (int i = 2; i < 4; i++) {

            Carta aux2 = unionArreglos[i];

            System.out.println("Las cartas para el jugador 2 son :" + aux2);

        }

        System.out.println("+++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++");

        for (int i = 4; i < 6; i++) {

            Carta aux3 = unionArreglos[i];

            System.out.println("Las cartas para el jugador 3 son :" + aux3);

        }

        System.out.println("+++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++");

        for (int i = 6; i < 8; i++) {

            Carta aux4 = unionArreglos[i];

            System.out.println("Las cartas para el jugador 4 son :" + aux4);

        }

        System.out.println("+++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++");

        for (int i = 8; i < 10; i++) {

            Carta aux5 = unionArreglos[i];

            System.out.println("Las cartas para el jugador 5 son :" + aux5);

        }

        System.out.println("+++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++");

        for (int i = 10; i < 13; i++) {

            Carta aux6 = unionArreglos[i];

            System.out.println("Las cartas en mesa, son :" + aux6);

        }
        return null;

    }

    public static boolean escaleraRealColor(Carta[] distributeCarts) {
        String[] escaleraReaAux = {"K", "Q", "J", "A", "10"}; //Arreglo con cartas para una escalera real de color
        boolean validador = true;
        String colorAux = "";
        String tipoAux = "";

        for (int i = 0; i < escaleraReaAux.length; i++) {
            System.out.println(escaleraReaAux[i]);

            System.out.println("__________________________");
            if (validador) {
                for (int j = 0; j < distributeCarts.length; j++) {

                    if (escaleraReaAux[i] == distributeCarts[j].getValorTexto()) {

                        if (colorAux == "") {
                            colorAux = distributeCarts[j].getColor();

                            validador = true;
                        } else {
                            if (colorAux == distributeCarts[j].getColor()) {
                                validador = true;

                            } else {
                                validador = false;
                            }

                        }

                        if (tipoAux == "") {
                            tipoAux = distributeCarts[j].getTipo();
                            validador = true;
                        } else {
                            if (tipoAux == distributeCarts[j].getTipo()) {
                                validador = true;
                            } else {
                                validador = false;
                            }
                        }

                        break;
                    } else {
                        validador = false;

                    }
                    System.out.println("Acabas de entrar al for ");
                }

                System.out.println(validador);
                System.out.println("__________________________");
            }
        }
        return validador;

    }

    public static boolean escaleraReal(Carta[] distributeCarts) {
        String[] escaleraRealAux = {"A", "2", "3", "4", "5", "6", "7", "8", "9", "10", "J", "Q", "K"};
        boolean validador = false;
        String colorAux = "";
        String tipoAux = "";
        String[] escReaAux = new String [13];

        for (int i = 0; i < escaleraRealAux.length; i++) {

            for (int j = 0; j < distributeCarts.length; j++) {
                
                if (escaleraRealAux[i] == distributeCarts[j].getValorTexto()) {
                    escReaAux[i] = escaleraRealAux[i];
                    
                } 
            }
        }
        int contador = 0;
        for (int i = 0; i < escReaAux.length; i++) {
            if (escReaAux[i] != null) {
                contador++;
                
            }else{
                contador = 0;
            }
            
            if (contador == 5) {
                validador = true;
                break;
            }
            
        }
        return validador;

    }

    public static boolean poker(Carta[] distributeCarts) {
        String[] pokerAux = {"A", "2", "3", "4", "5", "6", "7", "8", "9", "10", "J", "Q", "K"};
        boolean validador = true;

        for (int i = 0; i < pokerAux.length; i++) {

            for (int j = 0; j < distributeCarts.length - 3; j++) {

                if (pokerAux[i] == distributeCarts[j].getValorTexto()) {
                    System.out.println("Las siguiente carta pertenece a un poker:");
                    System.out.println("La carta es: " + distributeCarts[j]);

                    System.out.println("+++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++");
                    validador = true;
                } else {
                    validador = false;

                }

            }

        }
        return validador;

    }

    public static boolean full(Carta[] distributeCarts) {
        String[] fullAux = {"A", "2", "3", "4", "5", "6", "7", "8", "9", "10", "J", "Q", "K"};
        boolean validador = true;

        for (int i = 0; i < fullAux.length; i++) {

            for (int j = 0; j < distributeCarts.length - 4; j++) {

                if (fullAux[i] == distributeCarts[j].getValorTexto()) {
                    System.out.println("Las siguiente carta pertenece a un full:");
                    System.out.println("La carta es: " + distributeCarts[j]);

                    System.out.println("+++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++");
                    validador = true;
                } else {
                    validador = false;

                }

            }
            for (int k = 3; k < distributeCarts.length - 2; k++) {

                if (fullAux[i] == distributeCarts[k].getValorTexto()) {
                    System.out.println("Las siguiente carta pertenece a un full:");
                    System.out.println("La carta es: " + distributeCarts[k]);

                    System.out.println("+++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++");
                    validador = true;
                } else {
                    validador = false;

                }
            }
        }
        return validador;

    }

    public static boolean color(Carta[] distributeCarts) {
        boolean validador = true;
        String auxColor = "Negro";

        for (int j = 0; j < distributeCarts.length; j++) {

            if (auxColor == distributeCarts[j].getColor()) {
                System.out.println("Las siguiente carta pertenece a un color:");
                System.out.println("La carta es: " + distributeCarts[j]);
                validador = true;
            } else {
                validador = false;
            }
        }

        return true;

    }

}
