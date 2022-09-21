/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Poker;

import java.util.Arrays;
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
        //Carta[] distributeCarts = repartirCartasFuncion(shuffleCarts, unionArreglos);

        Carta[] distributeCarts = new Carta[7];
        distributeCarts[0] = new Carta("Negro", "Picas", 3, "3");
        distributeCarts[1] = new Carta("Negro", "Picas", 12, "Q");
        distributeCarts[2] = new Carta("Negro", "Picas", 13, "K");
        distributeCarts[3] = new Carta("Rojo", "Picas", 11, "J");
        distributeCarts[4] = new Carta("Negro", "Picas", 10, "10");
        distributeCarts[5] = new Carta("Negro", "Picas", 2, "2");
        distributeCarts[6] = new Carta("Negro", "Picas", 1, "A");

        //Metodo para que compruebe si existe o no una escalera real de color
        boolean escReaCol = escaleraRealColor(distributeCarts);

        System.out.println(escReaCol);
        //CARTAS NECESARIAS PARA HACER UNA ESCALERA REAL DE COLOR
        //Carta[] escaleraRealColor1 = escaleraRealColor("A", distributeCarts);
        //Carta[] escaleraRealColor2 = escaleraRealColor("K", distributeCarts);
        //Carta[] escaleraRealColor3 = escaleraRealColor("Q", distributeCarts);
        //Carta[] escaleraRealColor4 = escaleraRealColor("J", distributeCarts);
        //Carta[] escaleraRealColor5 = escaleraRealColor("10", distributeCarts);

        /**
         * Carta[] escaleraRealColor6 = escaleraRealColor("A" , "Diamantes");
         * Carta[] escaleraRealColor7 = escaleraRealColor("K" , "Diamantes");
         * Carta[] escaleraRealColor8 = escaleraRealColor("Q" , "Diamantes");
         * Carta[] escaleraRealColor9 = escaleraRealColor("J" , "Diamantes");
         * Carta[] escaleraRealColor10 = escaleraRealColor("10" , "Diamantes");
         *
         * Carta[] escaleraRealColor11 = escaleraRealColor("A" , "Trevoles");
         * Carta[] escaleraRealColor12 = escaleraRealColor("K" , "Trevoles");
         * Carta[] escaleraRealColor13 = escaleraRealColor("Q" , "Trevoles");
         * Carta[] escaleraRealColor14 = escaleraRealColor("J" , "Trevoles");
         * Carta[] escaleraRealColor15 = escaleraRealColor("10" , "Trevoles");
         *
         * Carta[] escaleraRealColor16 = escaleraRealColor("A" , "Pica");
         * Carta[] escaleraRealColor17 = escaleraRealColor("K" , "Pica");
         * Carta[] escaleraRealColor18 = escaleraRealColor("Q" , "Pica");
         * Carta[] escaleraRealColor19 = escaleraRealColor("J" , "Pica");
         * Carta[] escaleraRealColor120 = escaleraRealColor("10" , "Pica");
         */
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

            //int a = (int) (Math.random()* 13);
            //int b = (int) (Math.random() * 4);
            //int c = (int) (Math.random() * 4);
            Carta aux = unionArreglos[i];

            System.out.println("Las cartas para el jugador 1 son :" + aux);

        }

        System.out.println("+++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++");

        for (int i = 2; i < 4; i++) {

            //int a = (int) (Math.random()* 13);
            //int b = (int) (Math.random() * 4);
            //int c = (int) (Math.random() * 4);
            Carta aux2 = unionArreglos[i];

            System.out.println("Las cartas para el jugador 2 son :" + aux2);

        }

        System.out.println("+++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++");

        for (int i = 4; i < 6; i++) {

            //int a = (int) (Math.random()* 13);
            //int b = (int) (Math.random() * 4);
            //int c = (int) (Math.random() * 4);
            Carta aux3 = unionArreglos[i];

            System.out.println("Las cartas para el jugador 3 son :" + aux3);

        }

        System.out.println("+++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++");

        for (int i = 6; i < 8; i++) {

            //int a = (int) (Math.random()* 13);
            //int b = (int) (Math.random() * 4);
            //int c = (int) (Math.random() * 4);
            Carta aux4 = unionArreglos[i];

            System.out.println("Las cartas para el jugador 4 son :" + aux4);

        }

        System.out.println("+++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++");

        for (int i = 8; i < 10; i++) {

            //int a = (int) (Math.random()* 13);
            //int b = (int) (Math.random() * 4);
            //int c = (int) (Math.random() * 4);
            Carta aux5 = unionArreglos[i];

            System.out.println("Las cartas para el jugador 5 son :" + aux5);

        }

        System.out.println("+++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++");

        for (int i = 10; i < 13; i++) {

            //int a = (int) (Math.random()* 13);
            //int b = (int) (Math.random() * 4);
            //int c = (int) (Math.random() * 4);
            Carta aux6 = unionArreglos[i];

            System.out.println("Las cartas en mesa, son :" + aux6);

        }
        return null;

    }

    public static boolean escaleraRealColor(Carta[] distributeCarts) {
        String[] escaleraReaAux = {"K", "Q", "J", "A", "10"};
        boolean validador = true;
        String colorAux="";

        for (int i = 0; i < escaleraReaAux.length; i++) {
            System.out.println(escaleraReaAux[i]);
            
            System.out.println("__________________________");
            if (validador) {
                for (int j = 0; j < distributeCarts.length; j++) {

                    if (escaleraReaAux[i] == distributeCarts[j].getValorTexto()) {
                        
                        if(colorAux==""){
                        colorAux=distributeCarts[j].getColor();
                        validador = true;
                        }else{
                            if (colorAux==distributeCarts[j].getColor()){
                                validador=true;
                            
                            }else{
                            validador=false;
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
    //reparten las 2 cartas entre 5 jugadores - juntar todos los array YA HECHO
    //se sacan 3 cartas del array 

    public static Carta[] eliminarReparticion(Carta[] distributeCarts, Carta[] unionArreglos) {
        for (Carta i : unionArreglos) {
            Arrays.asList(unionArreglos);
            System.out.println(i);
            //unionArreglos[i] = 0;
        }
        //System.out.println("Despues de borrar el arreglo: ");
        //unionArreglos = new Carta[unionArreglos.length];
        //System.out.println(unionArreglos[1]);

        //System.out.println("After Clearing Array:");
        //Arrays.fill(distributeCarts, 0);
        //for (Carta i : distributeCarts) {
        //    System.out.println(i);
        //}
        return null;

    }

}
