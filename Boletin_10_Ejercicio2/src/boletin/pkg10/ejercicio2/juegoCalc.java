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
        int repetir = 0; // El valor 0 indica que no has acertado
        for (int i = 0; (i < numMaxAmigo && repetir == 0); i++) {
            imprimir("===================================\nTienes " + (numMaxAmigo - i) + " intentos");
            imprimir("Prueba con un numero");
            Scanner numPTeclado = new Scanner(System.in);
            int numP = numPTeclado.nextInt();
            if (numP == numamigo) {
                ganaste++;
                imprimir("-----------------------------------\nAcertaste el numero, enhorabuena!\n-----------------------------------");
                repetir = 1;
            } else if (numMaxAmigo == (i + 1)) {
                perdiste++;
                imprimir("-----------------------------------\nNo has acertado, se acabó el juego\n-----------------------------------");
                repetir = 1;
            } else if (numP < numamigo) {
                imprimir("No has acertado, el numero es mayor, vuelve a probar");
            } else if (numP > numamigo) {
                imprimir("No has acertado, el numero es menor, vuelve a probar");
            }

        }
        jugaste++;
    }

    public void jugarsolo() {
        int numAleatorio = (int) (Math.random() * 50 + 1);
        int numIntentos = 1; // Valor 1 repite la pregunta del numero de intentos
        do {
            imprimir("Quieres intentos ilimitados o con un numero de intentos?(Teclea 'ilimitados' o 'limitados')");
            Scanner intentosTeclado = new Scanner(System.in);
            String intentos = intentosTeclado.next();
            switch (intentos) {
                case "ilimitados":
                    jugarsoloilimitado(numAleatorio);
                    numIntentos = 0;
                    break;
                case "limitados":
                    imprimir("Introduce el numero de intentos que quieres");
                    Scanner numIntentosSoloTeclado = new Scanner(System.in);
                    int numIntentosSolo = numIntentosSoloTeclado.nextInt();
                    jugarsololimitado(numAleatorio, numIntentosSolo);
                    numIntentos = 0;
                    break;
                default:
                    imprimir("No es una respuesta valida, vuelve a probar");
                    numIntentos = 1;
            }
        } while (numIntentos == 1);
        
    }

    public void jugarsololimitado(int numAleatorio, int numIntentosSolo) {
        
        int acertaste = 1; //Valor 1 indica que has acertado
        do {
            for (int i = 0; i < numIntentosSolo; i++) {
                imprimir("-----------------------------------\nTienes " + (numIntentosSolo - i) + " intentos");
                imprimir("Prueba con un numero");
                Scanner numalTeclado = new Scanner(System.in);
                int numal = numalTeclado.nextInt();
                int numAB = Math.abs((numAleatorio - numal));
                if (numAB == 0) {
                    ganaste++;
                    imprimir("===================================\nAcertaste el numero, enhorabuena!\n-----------------------------------");
                    acertaste = 1;
                } else if (numIntentosSolo == i + 1) {
                    perdiste++;
                    imprimir("===================================\nNo has acertado el numero era el " + numAleatorio + " se acabó el juego\n-----------------------------------");
                    acertaste = 1;
                } else if (numAB > 20) {
                    imprimir("No has acertado, estas muy lejos");
                    acertaste = 0;
                } else if ((numAB >= 10) && (numAB <= 20)) {
                    imprimir("No has acertado, estas lejos");
                    acertaste = 0;
                } else if ((numAB < 10) && (numAB > 5)) {
                    imprimir("No has acertado, estas cerca");
                    acertaste = 0;
                } else if (numAB <= 5) {
                    imprimir("Ui!!! Casi!!!, estas muy cerca");
                    acertaste = 0;
                }
            }

        } while (acertaste == 0);
        jugaste++;
    }

    public void jugarsoloilimitado(int numAleatorio) {
        
        int acertaste = 1; //Valor 1 indica que has acertado
        do {
            imprimir("-----------------------------------\nPrueba con un numero");
            Scanner numalTeclado = new Scanner(System.in);
            int numal = numalTeclado.nextInt();
            int numAB = Math.abs((numAleatorio - numal));
            if (numAB == 0) {
                ganaste++;
                imprimir("-----------------------------------\nAcertaste el numero, era el " + numAleatorio + " !Enhorabuena!\n-----------------------------------");
                acertaste = 1;
            } else if (numAB > 20) {
                imprimir("No has acertado, estas muy lejos");
                acertaste = 0;
            } else if ((numAB >= 10) && (numAB <= 20)) {
                imprimir("No has acertado, estas lejos");
                acertaste = 0;
            } else if ((numAB < 10) && (numAB > 5)) {
                imprimir("No has acertado, estas cerca");
                acertaste = 0;
            } else {
                imprimir("Ui!!! Casi!!!, estas muy cerca");
                acertaste = 0;
            }

        } while (acertaste == 0);
        jugaste++;
    }

    public String volverjugar() {
        String pvolverjugar;
        int pvolversino = 0; //Valor 0 indica que no quieres repetir
        do {
            imprimir("Quieres volver a jugar?\nResponde 'si' o 'no'");
            Scanner repetirpTeclado = new Scanner(System.in);
            pvolverjugar = repetirpTeclado.next();
            if (pvolverjugar.equals("no")) {
                imprimir("-----------------------------------\nJugaste " + jugaste + " veces\nGanaste " + ganaste + " veces\nPerdiste " + perdiste + " veces\nGracias por jugar\n-----------------------------------");
                pvolversino = 0;
            } else if ((!pvolverjugar.equals("si"))) {
                imprimir("No es una respuesta valida, responde 'si' o 'no'");
                pvolversino = 1;
            }

        } while (pvolversino == 1);
        return pvolverjugar;
    }
    public void imprimir(String imprimir){
        System.out.println(imprimir);
    }
}
