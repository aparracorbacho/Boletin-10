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
        String pvolverjugar;
        juegoCalc juego = new juegoCalc();
        do {
            juego.imprimir("Vamos a jugar a un juego\nRecuerda que los numeros son entre 1 y 50 y no son negativos");
            int ptipojugar = 1; //El valor uno indica que no es una respuesta valida
            do {
                juego.imprimir("Quieres jugar solo o con un amigo?(Teclea 'solo' o 'amigo')");
                Scanner cjugarTeclado = new Scanner(System.in);
                String cjugar = cjugarTeclado.next();
                switch (cjugar) {
                    case "amigo":
                        juego.pedirnum();
                        juego.jugaracom();
                        ptipojugar = 0;
                        break;
                    case "solo":
                        juego.jugarsolo();
                        ptipojugar = 0;
                        break;
                    default:
                        juego.imprimir("No es una respuesta valida, vuelve a probar");
                        ptipojugar = 1;
                }
            } while (ptipojugar == 1);
            pvolverjugar = juego.volverjugar();
        } while (pvolverjugar.equals("si"));
    }

}

