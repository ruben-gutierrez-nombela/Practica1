
package com.tiernoparla.practica1;

import java.util.Scanner;

public class SimulacroExamen {
          public static void main(String[] args) {
           
        Scanner sc = new Scanner(System.in);

        int N = 8;
        int tabla[] = new int[N];

        int Posicion;
        int Posicion_ordenador = (int) (Math.random() * N);
        int Usuario = 7;
        int Ordenador = 2;
        boolean ganador = true;

        for (int i = 0; i < tabla.length; i++) {
            System.out.println("");
            System.out.println("Dame una posicion del 0 al " + (N-1) + ": ");
            Posicion = sc.nextInt();
            while (tabla[Posicion] == 2 || tabla[Posicion] == 7) {
                System.out.println("Posicion usada, pon otra posicion");
                Posicion = sc.nextInt();
            }// while
            tabla[Posicion] = Usuario;
            System.out.println("");
            for (int j = 0; j < tabla.length; j++) {
                System.out.print(tabla[j]);
            }// for

            /////////////////////////////////////////////
            
            System.out.println("");
            System.out.println("------------------------");
            System.out.println("///////////////////////");
            System.out.println("------------------------");
            //tabla[Posicion_ordenador] = Ordenador;
            for (int j = 0; j < 9999; j++) {
                Posicion_ordenador = (int) (Math.random() * N);
                while (tabla[Posicion_ordenador] == 2 || tabla[Posicion_ordenador] == 7) {
                    Posicion_ordenador = (int)(Math.random() * N);
                }// while
                //System.out.println(Posicion_ordenador);
            }// for
            System.out.println("El ordenador ha colocado su número en la posicion " + Posicion_ordenador);
            tabla[Posicion_ordenador] = Ordenador;
            System.out.println("");
            for (int j = 0; j < tabla.length; j++) {
                System.out.print(tabla[j]);
            }
            System.out.println("");

            //System.out.println("El ordenador ha hecho su jugada");

            for (int j = 1; j < tabla.length - 1; j++) {
                if (tabla[j] == 7) {
                    if (tabla[j] - tabla[j - 1] == tabla[j + 1] - tabla[j]) {   
                        System.out.println("Ha ganado el jugador");
                        ganador = false;
                        break;
                    }// if 
                }// if
            }// for
            
            for (int j = 1; j < tabla.length - 1; j++) {
                if (tabla[j] == 2) {
                    if (tabla[j] - tabla[j - 1] == tabla[j + 1] - tabla[j]) {   
                        System.out.println("Ha ganado el ordenador");
                        ganador = false;
                        break;
                    }// if 
                }// if
            }// for
            
         
            if (ganador == false) {
                break;
            }// if
        }// for
        
    }// main 
}// todo 

