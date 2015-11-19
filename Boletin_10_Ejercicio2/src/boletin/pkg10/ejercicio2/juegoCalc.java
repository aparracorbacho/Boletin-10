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
    int jugaste = 0;
    int ganaste = 0;
    int perdiste = 0;
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
        jugaste++;
        int repetir = 0; // El valor 0 indica que no has acertado
        for (int i = 0; (i < numMaxAmigo && repetir == 0); i++) {
            System.out.println("===================================\nTienes " + (numMaxAmigo - i) + " intentos");
            System.out.println("Prueba con un numero");
            Scanner numPTeclado = new Scanner(System.in);
            int numP = numPTeclado.nextInt();
            if (numP == numamigo) {
                ganaste++;
                System.out.println("-----------------------------------\nAcertaste el numero, enhorabuena!\n-----------------------------------");
                repetir = 1;
            } else if (numMaxAmigo == (i + 1)) {
                perdiste++;
                System.out.println("-----------------------------------\nNo has acertado, se acabó el juego\n-----------------------------------");
                repetir = 1;
            } else if (numP < numamigo) {
                System.out.println("No has acertado, el numero es mayor, vuelve a probar");
            } else if (numP > numamigo) {
                System.out.println("No has acertado, el numero es menor, vuelve a probar");
            }

        }
    }

    public void jugarsolo() {
        int numAleatorio = (int) (Math.random() * 50 + 1);
        int numIntentos = 1; // Valor 1 repite la pregunta del numero de intentos
        do {
        System.out.println("Quieres intentos ilimitados o con un numero de intentos?(Teclea 'ilimitados' o 'limitados')");
        Scanner intentosTeclado = new Scanner(System.in);
        String intentos = intentosTeclado.next();
        switch (intentos){
            case "ilimitados":
                jugarsoloilimitado(numAleatorio);
                numIntentos = 0;
                break;
            case "limitados":
                System.out.println("Introduce el numero de intentos que quieres");
                Scanner numIntentosSoloTeclado = new Scanner(System.in);
                int numIntentosSolo = numIntentosSoloTeclado.nextInt();
                jugarsololimitado(numAleatorio,numIntentosSolo);
                numIntentos = 0;
                break;
            default:
                System.out.println("No es una respuesta valida, vuelve a probar");
                numIntentos = 1;
           }
        } while (numIntentos == 1);
    }
    public void jugarsololimitado(int numAleatorio,int numIntentosSolo){
        jugaste++;
           int acertaste = 1; //Valor 1 indica que has acertado
        do {
            for (int i=0;i<numIntentosSolo;i++) {
            System.out.println("-----------------------------------\nTienes " + (numIntentosSolo - i) + " intentos");
            System.out.println("Prueba con un numero");
            Scanner numalTeclado = new Scanner(System.in);
            int numal = numalTeclado.nextInt();
            int numAB = Math.abs((numAleatorio - numal));
            if (numAB == 0) {
                ganaste++;
                System.out.println("===================================\nAcertaste el numero, enhorabuena!\n-----------------------------------");
                acertaste = 1;
            } else if (numIntentosSolo == i+1) {
                perdiste++;
                System.out.println("===================================\nNo has acertado el numero era el "+numAleatorio +" se acabó el juego\n-----------------------------------");
                acertaste = 1;
            } else if (numAB > 20) {
                System.out.println("No has acertado, estas muy lejos");
                acertaste = 0;
            } else if ((numAB >= 10) && (numAB <= 20)) {
                System.out.println("No has acertado, estas lejos");
                acertaste = 0;
            } else if ((numAB < 10) && (numAB > 5)) {
                System.out.println("No has acertado, estas cerca");
                acertaste = 0;
            } else if (numAB<=5){
                System.out.println("Ui!!! Casi!!!, estas muy cerca");
                acertaste = 0;
            }
            }

        } while (acertaste == 0);
    }
    public void jugarsoloilimitado(int numAleatorio){
        jugaste++;
              int acertaste = 1; //Valor 1 indica que has acertado
        do {
            System.out.println("-----------------------------------\nPrueba con un numero");
            Scanner numalTeclado = new Scanner(System.in);
            int numal = numalTeclado.nextInt();
            int numAB = Math.abs((numAleatorio - numal));
            if (numAB == 0) {
                ganaste++;
                System.out.println("-----------------------------------\nAcertaste el numero, era el "+numAleatorio +" !Enhorabuena!\n-----------------------------------");
                acertaste = 1;
            } else if (numAB > 20) {
                System.out.println("No has acertado, estas muy lejos");
                acertaste = 0;
            } else if ((numAB >= 10) && (numAB <= 20)) {
                System.out.println("No has acertado, estas lejos");
                acertaste = 0;
            } else if ((numAB < 10) && (numAB > 5)) {
                System.out.println("No has acertado, estas cerca");
                acertaste = 0;
            } else {
                System.out.println("Ui!!! Casi!!!, estas muy cerca");
                acertaste = 0;
            }

        } while (acertaste == 0);
    }
    public String volverjugar(){
        String repetirp;
        int repetirm = 0; //Valor 0 indica que no quieres repetir
            do {
                System.out.println("Quieres volver a jugar?\nResponde 'si' o 'no'");
                Scanner repetirpTeclado = new Scanner(System.in);
                repetirp = repetirpTeclado.next();
                if (repetirp.equals("no")) {
                    System.out.println("-----------------------------------\nJugaste "+jugaste +" veces\nGanaste "+ganaste +" veces\nPerdiste "+perdiste +" veces\nGracias por jugar\n-----------------------------------");
                    repetirm = 0;
                } else if ((!repetirp.equals("si"))) {
                    System.out.println("No es una respuesta valida, responde 'si' o 'no'");
                    repetirm = 1;
                }

            } while (repetirm == 1);
            return repetirp;
    }
}
