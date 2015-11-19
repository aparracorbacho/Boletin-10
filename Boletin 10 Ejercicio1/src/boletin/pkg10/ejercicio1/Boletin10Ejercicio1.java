/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package boletin.pkg10.ejercicio1;

import java.util.Scanner;

/**
 *
 * @author aparracorbacho
 */
public class Boletin10Ejercicio1 {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        // TODO code application logic here
        String repetirp;
        do {
            System.out.println("Vamos a jugar a un juego\nIntroduce primero el numero a adiviniar");
            juegoCalc obx = new juegoCalc();
            obx.pedir();
            obx.jugaracom();
            int repetirm = 0;
            do {
            System.out.println("Quieres volver a jugar?\nResponde 'si' o 'no'");
            Scanner repetirpTeclado = new Scanner(System.in);
            repetirp = repetirpTeclado.next();
            if (repetirp.equals("no")) {
                System.out.println("-----------------------------------\nGracias por jugar\n-----------------------------------");
                repetirm = 0;
            } else if ((!repetirp.equals("si")) || (!repetirp.equals("no"))) {
                System.out.println("No es una respuesta valida, responde 'si' o 'no'");
                repetirm = 1;
            }
            } while (repetirm == 1);
        } while (repetirp.equals("si"));
    }

}
