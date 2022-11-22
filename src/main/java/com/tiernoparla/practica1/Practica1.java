package com.tiernoparla.practica1;

import java.util.Scanner;
import java.lang.Math;
import java.util.Arrays;

public class Practica1 {
   public static void main(String[] args) {
       
    // creación del mensaje
        // código
    int N = 7;
    int M = 0;
    int mensaje2 [] = new int [N*N];
    int mensaje [][] = new int [N][N];
       
    for (int x = 0; x < mensaje.length; x++) {
        for (int i = 0; i < mensaje[x].length; i++) {
            mensaje[x][i] = (int)(Math.random()*2);
            //System.out.print(mensaje[x][i]);
            mensaje2[M] = mensaje[x][i];
            System.out.print(mensaje2[M]);
            M++;
        }// for
    }// for
    
    
    // acciones del Sender
        // código
    
        
        
        
        
    // acciones del Noise
        // código
        
    // acciones del Reciever
        // código
       
    // método 1 que calcula tal
        // código
        
    // método 2 que hace cual    
        // código
        
   }// main 
}// Practica 1
