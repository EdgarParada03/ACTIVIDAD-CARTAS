/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Poker;

import static Poker.Barajas.crearPalo;



/**
 *
 * @author Edgar Parada
 */
public class mezclarCartas {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        // TODO code application logic here
        Carta[] crearPalo1 = crearPalo("Corazones", "Rojo");
        Carta[] crearPalo2 = crearPalo("Diamantes" , "Negro");
        Carta[] crearPalo3 = crearPalo("Trevoles" , "Rojo");
        Carta[] crearPalo4 = crearPalo("Pica" , "Negro");
        /**
        String[] numero = {"A" , "2" , "3" , "4" , "5" , "6" , "7" , "8" , "9" , "10" , "J" , "Q" , "K"};
        List<String> number = Arrays.asList(numero);
        Collections.shuffle(number);
        
        String[] tipo = {"Corazones" , "Diamantes" , "Picas" , "Trevoles"};
        List<String> type = Arrays.asList(tipo);
        Collections.shuffle(type);
        
        String[] color = {"Rojo" , "Rojo" , "Negro" , "Negro"};
        List<String> colors = Arrays.asList(color);
        Collections.shuffle(colors);
        
        System.out.println("Las cartas para el jugador 1, son: " );
        
        for (int i = 0; i < 5; i++) {
            int a = (int) (Math.random()*13);
            int b = (int) (Math.random() * 4);
            int c = (int) (Math.random() * 4 );
            
            System.out.println("La carta es: " +number.get(a)+ ", tipo " +type.get(b) + " de color " +colors.get(c));
            
        }
            System.out.println("++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++");
     */      
    }
    
    public static Carta[] unirArreglos(Carta[] crearPalo1, Carta[] crearPalo2, Carta[] crearPalo3, Carta[] crearPalo4 ){
        
        Carta[] unionArreglos = new Carta[8];
        int j = 0;
        for (int i = 0; i < 2; i++) {
            unionArreglos[j] = crearPalo1[i];
            j++;
            unionArreglos[j] = crearPalo2[i];
            j++;
            unionArreglos[j] = crearPalo3[i];
            j++;
            unionArreglos[j] = crearPalo4[i];
            j++;
                 
        }
        System.out.println("La union de los arreglos es: ");
        for (int i = 0; i < 8; i++) {
            System.out.println(unionArreglos[i]+" ");
        }
        
        System.out.println();
        return unionArreglos;
        
        
    }
    
    
}
