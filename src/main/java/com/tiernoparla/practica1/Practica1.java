package com.tiernoparla.practica1;

import static com.tiernoparla.practica1.Prueba2.getHammingCode;
import java.util.Scanner;
import java.lang.Math;
import java.util.ArrayList;
import java.util.Arrays;

public class Practica1 {

    public static void main(String[] args) {

        // PARTE 1
        // CREACIÓN DEL MENSAJE
        // código    
        int N = 4;
        int M = 0;
        int a = N * N;
        int mensaje2[] = new int[a];
        int mensaje[][] = new int[N][N];
        System.out.println("El mensaje a enviar es: ");

        for (int x = 0; x < mensaje.length; x++) {
            for (int i = 0; i < mensaje[x].length; i++) {
                mensaje[x][i] = (int) (Math.random() * 2);
                //System.out.print(mensaje[x][i]);
                mensaje2[M] = mensaje[x][i];
                System.out.print(mensaje2[M]);
                M++;
            }// for
            System.out.println();
        }// for

        /////////////////////////////////////////////////////////////////
        /////////////////////////////////////////////////////////////77//
        System.out.println();

        // PARTE 2 A
        // ACCIONES DEL SENDER
        // código
        int pot = 1;
        int bitspar = 0;

        for (int i = 1; i <= a; i++) {
            pot = pot * 2;
            bitspar = i;
            if (pot > a) {
                System.out.println("Necesitamos " + bitspar + " bits de paridad");
                break;
            }// if
        }// for

        //PARTE 2 B
        // tam + bitspar + 1
        // nuevo tamaño del nuevo array = mensaje3[a + bitspar + 1]
        int tamnuevo = a + bitspar + 1;

        ArrayList<Long> arrlist = new ArrayList<Long>(tamnuevo);

        for (int i = 0; i < mensaje2.length; i++) {
            arrlist.add((long) mensaje2[i]);
        }// for

        int pote = 0;

        for (int i = 0; i < arrlist.size(); i++) {
            if (pote == i) {
                arrlist.add(pote, (long) 0);
                pote *= 2;
            }// if
            if (pote == 0) {
                pote = 1;
            }// if
        }// for

        System.out.println(arrlist);

        //////////////////////////////////////////////
        ///////////////////////////////////////7//////
        /////CALCULAR LOS BITS DE PARIDAD
        long suma = 0;
        int entrada = 1;
        int cambiar_cifras = 1;

        for (int z = 0; z < bitspar; z++) {
            for (int i = 1; i < arrlist.size(); i++) {
                String binario = Long.toBinaryString(i);
                long valor = Long.parseLong(binario);
                if ((valor / cambiar_cifras) % 2 == 1) {
                    suma = suma + arrlist.get(i);
                } //if
            } //for

            cambiar_cifras = cambiar_cifras * 10;

            if (suma % 2 == 0) {
                arrlist.set(entrada, (long) 0);
            }
            if (suma % 2 == 1) {
                arrlist.set(entrada, (long) 1);
            }
            suma = 0;
            entrada = entrada * 2;
        } //for

        //////CALCULAR EL BIT GLOBAL
        long y = 0;

        for (int i = 1; i < arrlist.size(); i++) {
            y = y + arrlist.get(i);
        } //for

        if (y % 2 == 0) {
            arrlist.set(0, (long) 0);
        }

        if (y % 2 != 0) {
            arrlist.set(0, (long) 1);
        }

        /////PRINTEAR POR PANTALLA LA NUEVA MATRIZ CON BITS DE PARIDAD LLENOS
        System.out.println("---------------------------");
        System.out.println("---------------------------");
        System.out.println("");
        System.out.println(arrlist);

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
