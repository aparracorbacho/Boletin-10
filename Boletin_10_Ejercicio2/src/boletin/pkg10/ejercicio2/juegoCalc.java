/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package boletin.pkg10.ejercicio2;

import java.util.Scanner;
import javax.swing.JOptionPane;

/**
 *
 * @author aparracorbacho
 */
public class juegoCalc {

    int numamigo = 0;
    int numMaxAmigo;
    public void pedirnum() {
        System.out.println("Vamos a empezar!\nIntroduce un numero del 1 al 50 para que tu amigo lo adivine");
        do {
            numamigo = Integer.parseInt(JOptionPane.showInputDialog("Introduce el numero entre 1 y 50"));
        } while (numamigo < 1 || numamigo > 50);
        do {
            numMaxAmigo = Integer.parseInt(JOptionPane.showInputDialog("Introduce el numero máxmimo de intentos, tiene que ser mayor que 0"));
        } while (numMaxAmigo < 0);
    }

    public void jugaracom() {
        int repetir = 0;

        for (int i = 0; (i < numMaxAmigo && repetir == 0); i++) {
            System.out.println("===================================\nTienes " + (numMaxAmigo - i) + " intentos");
            System.out.println("Prueba con un numero");
            Scanner numPTeclado = new Scanner(System.in);
            int numP = numPTeclado.nextInt();
            if (numP == numamigo) {
                System.out.println("-----------------------------------\nAcertaste el numero, enhorabuena!\n-----------------------------------");
                repetir = 1;
            } else if (numMaxAmigo == (i + 1)) {
                System.out.println("-----------------------------------\nNo has acertado, se acabó el juego\n-----------------------------------");
                repetir = 1;
            } else if (numP<numamigo) {
                System.out.println("No has acertado, el numero es mayor, vuelve a probar");   
            } else if (numP>numamigo) {
                System.out.println("No has acertado, el numero es menor, vuelve a probar");
            }

        }
    }
    
    public void jugarsolo(){
       int numAleatorio = (int)(Math.random()*50 + 1);
       int acertaste = 1;
       do {
            System.out.println("-----------------------------------\nPrueba con un numero");
            Scanner numalTeclado = new Scanner(System.in);
            int numal = numalTeclado.nextInt();
            int numAB = Math.abs((numAleatorio-numal));
            if (numAB==0){
                System.out.println("-----------------------------------\nAcertaste el numero, enhorabuena!\n-----------------------------------");
                acertaste = 1;
            } else if (numAB > 20) {
                System.out.println("No has acertado, estas muy lejos");
                acertaste = 0;
            } else if ((numAB >= 10) && (numAB <=20)) {
                System.out.println("No has acertado, estas lejos");
                acertaste = 0;
            } else if ((numAB<10) && (numAB>5)) {
                System.out.println("No has acertado, estas cerca");
                acertaste = 0;
           } else {
                System.out.println("Ui!!! Casi!!!, estas muy cerca");
                acertaste = 0;
            }
            
                       
       } while (acertaste == 0);
      
      
       
       
    }
}
