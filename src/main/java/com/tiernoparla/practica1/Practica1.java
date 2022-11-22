package com.tiernoparla.practica1;

import java.util.Scanner;
import java.lang.Math;
import java.util.Arrays;

public class Practica1 {
   static void Mensaje(){
    // CREACIÓN DEL MENSAJE
        // código
    int N = 2;
    int M = 0;
    int mensaje2 [] = new int [N*N];
    int mensaje [][] = new int [N][N];
    System.out.println("El mensaje a enviar es:");
       
    for (int x = 0; x < mensaje.length; x++) {
        for (int i = 0; i < mensaje[x].length; i++) {
            mensaje[x][i] = (int)(Math.random()*2);
            //System.out.print(mensaje[x][i]);
            mensaje2[M] = mensaje[x][i];
            System.out.print(mensaje2[M]);
            M++;
        }// for
    }// for
   }// Method Mensaje
   
   public static void main(String[] args) {
   
   // Ejecución del método de la parte 1 el Mensaje    
   Mensaje(); 
    
    
    // ACCIONES DEL SENDER
        // código
    
        
        
        
        
    // ACCIONES DEL NOISE
        // código
        
    // ACCIONES DEL RECIEVER
        // código
       
    // MÉTODO 1 QUE CALCULA TAL
        // código
        
    // MÉTODO 2 QUE CALCULA CUAL    
        // código
        
   }// main 
}// Practica 1
