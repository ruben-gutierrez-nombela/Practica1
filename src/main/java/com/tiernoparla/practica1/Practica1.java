package com.tiernoparla.practica1;

import static com.tiernoparla.practica1.Prueba2.getHammingCode;
import java.util.Scanner;
import java.lang.Math;
import java.util.Arrays;

public class Practica1 {
    public static void main(String[] args) {
       
    // CREACIÓN DEL MENSAJE
        // código    
   
    int N = 4;
    int M = 0;
    int a = N*N;
    int mensaje2 [] = new int [a];
    int mensaje [][] = new int [N][N];
    System.out.println("El mensaje a enviar es: ");
    
    for (int x = 0; x < mensaje.length; x++) {
        for (int i = 0; i < mensaje[x].length; i++) {
            mensaje[x][i] = (int)(Math.random()*2);
            //System.out.print(mensaje[x][i]);
            mensaje2[M] = mensaje[x][i];
            System.out.print(mensaje2[M]);
            M++;
        }// for
    }// for
    System.out.println();   
    
    // ACCIONES DEL SENDER
        // código
    int pot = 1;
    int bitspar = 0;
    
    for (int i = 0; i <= a; i++) {
        pot = pot*2;
        bitspar = i;
        if (pot >= a){
            System.out.println("obtenemos " + bitspar);
            break;
        }// if
    }// for
    
    
    
    for (int i = 0; i < mensaje2.length; i++) {
        System.out.println(mensaje2[i]);
            
    }
    
    
        
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
