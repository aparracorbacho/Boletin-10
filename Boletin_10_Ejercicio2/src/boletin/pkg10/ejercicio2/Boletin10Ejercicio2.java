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
        String repetirp = "si";
        do {
            System.out.println("Vamos a jugar a un juego");
            juegoCalc obx = new juegoCalc();
            int repetirp1 = 1; //El valor uno indica que no es una respuesta valida
            do {
                System.out.println("Quieres jugar solo o con un amigo?(Teclea 'solo' o 'amigo')");
                Scanner cjugarTeclado = new Scanner(System.in);
                String cjugar = cjugarTeclado.next();
                switch (cjugar) {
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
            repetirp=obx.volverjugar();
        } while (repetirp.equals("si"));
    }

}
