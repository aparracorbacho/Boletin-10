/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package boletin.pkg10.ejercicio1;

import java.util.Scanner;
import javax.swing.JOptionPane;

/**
 *
 * @author aparracorbacho
 */
public class juegoCalc {
 int num = 0;
 int numMax; 
    
 public void pedir (){
 do {
     num = Integer.parseInt(JOptionPane.showInputDialog("Introduce el numero entre 1 y 50"));
 } while (num<1 || num>50);
 do { numMax = Integer.parseInt(JOptionPane.showInputDialog("Introduce el numero máxmimo de intentos, tiene que ser mayor que 0"));
 } while (numMax<0);
 }
 
 public void jugar ()   {
  int repetir = 0;
  
  for (int i=0;(i<numMax && repetir==0);i++){
      System.out.println("===================================\nTe quedan "+(numMax-i)+" intentos");
      System.out.println("Prueba con un numero");
      Scanner numPTeclado = new Scanner(System.in);
      int numP = numPTeclado.nextInt();
      if (numP==num) {
          System.out.println("-----------------------------------\nAcertaste el numero, enhorabuena!\n-----------------------------------");
          repetir = 1;
      } else if (numMax==(i+1)){
          System.out.println("-----------------------------------\nNo has acertado, se acabó el juego\n-----------------------------------");
          repetir = 1;
      } else {
          System.out.println("No has acertado, vuelve a probar");
      }
      
  }
  }
 }

