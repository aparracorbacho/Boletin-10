/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package boletin.pkg10.ejercicio2;

import java.util.Scanner;

/**
 *
 * @author aparracorbacho
 */
public class Boletin10Ejercicio2 {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        // TODO code application logic here
        String repetirp;
        do {
            System.out.println("Vamos a jugar a un juego");
            juegoCalc obx = new juegoCalc();
           
          
            int repetirp1 = 1;
            do {
            System.out.println("Quieres jugar solo o con un amigo?(Teclea 'solo' o 'amigo')");
            Scanner cjugarTeclado = new Scanner(System.in);
            String cjugar = cjugarTeclado.next();
            switch (cjugar){
                case "amigo": 
                    obx.pedirnum();
                    obx.jugaracom();
                    repetirp1 = 0;
                    break;
                case "solo":
                    obx.jugarsolo();
                    repetirp1 = 0;
                    break;
                default:
                    System.out.println("No es una respuesta valida, vuelve a probar");
                    repetirp1 = 1;
            }
            } while (repetirp1 == 1);
          
            int repetirm = 0;
            do {
            System.out.println("Quieres volver a jugar?\nResponde 'si' o 'no'");
            Scanner repetirpTeclado = new Scanner(System.in);
            repetirp = repetirpTeclado.next();
            if (repetirp.equals("no")) {
                System.out.println("-----------------------------------\nGracias por jugar\n-----------------------------------");
                repetirm = 0;
            } else if ((!repetirp.equals("si"))) {
                System.out.println("No es una respuesta valida, responde 'si' o 'no'");
                repetirm = 1;
            }
            } while (repetirm == 1);
        } while (repetirp.equals("si"));
    }

}
