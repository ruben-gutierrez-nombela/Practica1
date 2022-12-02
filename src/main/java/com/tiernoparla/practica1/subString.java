package com.tiernoparla.practica1;

import static com.tiernoparla.practica1.Prueba2.getHammingCode;
import java.util.Scanner;
import java.lang.Math;
import java.util.ArrayList;
import java.util.Arrays;

public class subString {

    public static void main(String[] args) {

        // PARTE 1
        // CREACIÓN DEL MENSAJE   
        int TamN = 4;
        int N2 = 0;
        int TamN2 = TamN * TamN;
        int mensaje[][] = new int[TamN][TamN];
        int mensaje2[] = new int[TamN2];

        System.out.println("El mensaje a enviar es: ");

        for (int x = 0; x < mensaje.length; x++) {
            for (int i = 0; i < mensaje[x].length; i++) {
                mensaje[x][i] = (int) (Math.random() * 2);
                mensaje2[N2] = mensaje[x][i];
                System.out.print(mensaje2[N2]);
                N2++;
            }// for
            System.out.println();
        }// for
        System.out.println();

        // PARTE 2 A (CUÁNTOS BITSPAR NECESITAMOS)
        
        int pote = 1;
        int bitspar = 0;

        for (int i = 1; i <= TamN2; i++) {
            pote = pote * 2;
            bitspar = i;
            if (pote > TamN2) {
                System.out.println("Necesitamos " + bitspar 
                                   + " bits de paridad");
                break;
            }// if
        }// for

        //PARTE 2 B (PRINT ARRLIST)

        int tamnuevo = TamN2 + bitspar + 1;
        int poten = 0;

        ArrayList<Long> arrlist = new ArrayList<Long>(tamnuevo);

        for (int i = 0; i < mensaje2.length; i++) {
            arrlist.add((long) mensaje2[i]);
        }// for

        for (int i = 0; i < arrlist.size(); i++) {
            if (poten == i) {
                arrlist.add(poten, (long) 0);
                poten *= 2;
            }// if
            if (poten == 0) {
                poten = 1;
            }// if
        }// for

        System.out.println(arrlist);
        System.out.println("---------------------------");
        System.out.println("---------------------------");

        
        //CALCULAR LOS BITS DE PARIDAD
        long total = 0;
        int pos = 1;
        int NewNums = 1;

        for (int z = 0; z < bitspar; z++) {
            for (int i = 1; i < arrlist.size(); i++) {
                String binario = Long.toBinaryString(i);
                long valor = Long.parseLong(binario);
                if ((valor / NewNums) % 2 == 1) {
                    total = total + arrlist.get(i);
                } //if
            } //for

            if (total % 2 == 0) {
                arrlist.set(pos, (long) 0);
            }// if
            if (total % 2 == 1) {
                arrlist.set(pos, (long) 1);
            }// if
            
            total = 0;
            pos = pos * 2;
            NewNums = NewNums * 10;
        } //for

        //CALCULAR EL BIT GLOBAL
        long global = 0;

        for (int i = 1; i < arrlist.size(); i++) {
            global = global + arrlist.get(i);
        } //for

        if (global % 2 == 0) {
            arrlist.set(0, (long) 0);
        }// if
        if (global % 2 != 0) {
            arrlist.set(0, (long) 1);
        }// if

        //PRINTEAR POR PANTALLA LA NUEVA MATRIZ CON BITS DE PARIDAD LLENOS
        System.out.println("");
        System.out.println("Mensaje con bits de paridad "
                           + "calculados y rellenados");
        System.out.println(arrlist);
        System.out.println("---------------------------");
        System.out.println("---------------------------");

        //PARTE 3 MODIFICACIONES DEL MENSAJE
        // Provocar los cambios aleatorios
        int cont = 0;
        int TamRandom = (int)(Math.random()* TamN2);
        double prob = Math.random();
        long arr2 = arrlist.get(TamRandom);
        
        
        if (prob <= 0.4) {
            for (int i = 0; i < 2; i++) {
                cont++;
                TamRandom = (int) (Math.random() * TamN2);
                arr2 = arrlist.get(TamRandom);
                if (arr2 == 0) {
                    arrlist.set(TamRandom, (long)1) ;
                }// if
                if (arr2 == 1) {
                    arrlist.set(TamRandom, (long)0) ;
                }// if
            }// for
        }// if
        if (prob > 0.4 && prob <= 0.7) {
            cont++;
            if (arr2 == 0) {
                arrlist.set(TamRandom, (long)1) ;
            }// if
            if (arr2 == 1) {
                arrlist.set(TamRandom, (long)0) ;
            }// if
        }// if
        
        System.out.println("");
        System.out.println("Mensaje con posibles cambios realizados");
        System.out.println(arrlist);
        System.out.println("---------------------------");
        System.out.println("---------------------------");
        
        
        // COMPROBAR LOS ERRORES
        
        int error1 = 0;
        int newpos = 1;
        long total2 = 0;
        long suma = 0;
        int mas = 1;

        for (int i = 0; i < bitspar; i++) {
            for (int j = 0; j < arrlist.size(); j++) {
                String strarr = Long.toBinaryString(j);
                long temp = Long.parseLong(strarr);
                if (temp / mas % 2 == 1) {
                    total2 = total2 + arrlist.get(j);
                }// if
            }// for
            
            if (total2 % 2 == 1) {
                error1 = error1 + newpos;
            }// if
            
            total2 = 0;
            mas = mas * 10;
            newpos = newpos * 2;
        }// for
        
        for (int i = 0; i < arrlist.size(); i++) {
            suma += arrlist.get(i);  
        }// for
        
        System.out.println("");
        
        for (int i = 0; i < 1; i++) {
            if (error1 > 0 && suma % 2 == 0) {
                System.out.println("Se encontraron 2 errores");
            }// if
            if (suma % 2 != 0 && arrlist.get(0) == 0) {
                System.out.println("Se encontró 1 error en la posicion 0");
            }// if
            if (error1 == 0) {
                System.out.println("No se encontraron errores");   
            }// if
        }// for  
    }// main 
}// Practica 1
