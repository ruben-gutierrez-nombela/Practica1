package com.tiernoparla.practica1;

import java.util.ArrayList;

public class Ruben_Gutierrez_practica_1 {

    public static void main(String[] args) {

        int TamN = 4;
        int N2 = 0;
        int TamN2 = TamN * TamN;
        int mensaje[][] = new int[TamN][TamN];
        int mensaje2[] = new int[TamN2];

        // PARTE 1
        // CREACIÓN DEL MENSAJE
        creacionDeMensaje(mensaje, mensaje2, N2);

        // PARTE 2 
        // CUÁNTOS BITSPAR NECESITAMOS
        int pote = 1;
        int bitspar = 0;
        bitspar = cuantosBitsparNecesito(TamN2, pote, bitspar);

        // PRINT ARRLIST
        int tamnuevo = TamN2 + bitspar + 1;
        int poten = 0;
        ArrayList<Long> arrlist = printNuevoArrlist(tamnuevo, mensaje2, poten);

        //CALCULAR LOS BITS DE PARIDAD
        long total = 0;
        int pos = 1;
        int NewNums = 1;
        calcularBitspar(bitspar, arrlist, NewNums, total, pos);

        //CALCULAR EL BIT GLOBAL
        long global = 0;
        calcularBitGlobal(arrlist, global);

        //PARTE 3 MODIFICACIONES DEL MENSAJE
        // PROVOCAR LOS CAMBIOS ALEATORIOS
        int cont = 0;
        double prob = Math.random();
        modificarMensaje(prob, cont, TamN2, arrlist);

        // COMPROBAR LOS ERRORES
        int error1 = 0;
        int newpos = 1;
        long total2 = 0;
        long suma = 0;
        int mas = 1;

        error1 = comprobarErrores1(bitspar, arrlist, mas, total2, error1, 
                                   newpos);
        suma = comprobarErrores2(arrlist, suma);

        encontrarErrores(error1, suma, arrlist);
    }// main 

    public static void encontrarErrores(int error1, long suma, 
                                        ArrayList<Long> arrlist) {
        for (int i = 0; i < 1; i++) {
            if (error1 > 0 && suma % 2 == 0) {
                System.out.println("Se encontraron 2 errores");
                break;
            }// if
            if (suma % 2 != 0 && arrlist.get(0) == 0) {
                System.out.println("Se encontró 1 error en la posicion 0");
                break;
            }// if
            if (error1 == 0) {
                System.out.println("No se encontraron errores");
                break;
            }// if
        }// for  
    }// encontrarErrores

    public static long comprobarErrores2(ArrayList<Long> arrlist, long suma) {
        for (int i = 0; i < arrlist.size(); i++) {
            suma += arrlist.get(i);
        }// for
        System.out.println("");
        return suma;
    }// comprobarErrores2

    public static int comprobarErrores1(int bitspar, ArrayList<Long> arrlist, 
                                     int mas, long total2, int error1, 
                                     int newpos) throws NumberFormatException {
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
        return error1;
    }// comprobarErrores1

    public static void modificarMensaje(double prob, int cont, int TamN2, 
                                        ArrayList<Long> arrlist) {
        int TamRandom = (int) (Math.random() * TamN2);
        long arr2 = arrlist.get(TamRandom);
        if (prob <= 0.4) {
            for (int i = 0; i < 2; i++) {
                cont++;
                TamRandom = (int) (Math.random() * TamN2);
                arr2 = arrlist.get(TamRandom);
                if (arr2 == 0) {
                    arrlist.set(TamRandom, (long) 1);
                }// if
                if (arr2 == 1) {
                    arrlist.set(TamRandom, (long) 0);
                }// if
            }// for
        }// if
        if (prob > 0.4 && prob <= 0.7) {
            cont++;
            if (arr2 == 0) {
                arrlist.set(TamRandom, (long) 1);
            }// if
            if (arr2 == 1) {
                arrlist.set(TamRandom, (long) 0);
            }// if
        }// if
        System.out.println("");
        System.out.println("Mensaje con posibles cambios realizados");
        System.out.println(arrlist);
        System.out.println("---------------------------");
        System.out.println("---------------------------");
    }// modificarMensaje

    public static void calcularBitGlobal(ArrayList<Long> arrlist, long global) {
        for (int i = 1; i < arrlist.size(); i++) {
            global = global + arrlist.get(i);
        } //for

        if (global % 2 == 0) {
            arrlist.set(0, (long) 0);
        }// if
        if (global % 2 != 0) {
            arrlist.set(0, (long) 1);
        }// if

        System.out.println("");
        System.out.println("Mensaje con bits de paridad "
                + "calculados y rellenados");
        System.out.println(arrlist);
        System.out.println("---------------------------");
        System.out.println("---------------------------");
    }// calcularBitGlobal

    public static void calcularBitspar(int bitspar, ArrayList<Long> arrlist, 
                                       int NewNums, long total, int pos) 
                                       throws NumberFormatException {
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
    }// calcularBitspar

    public static ArrayList<Long> printNuevoArrlist(int tamnuevo, 
                                                  int[] mensaje2, int poten) {
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
        return arrlist;
    }// printNuevoArrlist

    public static int cuantosBitsparNecesito(int TamN2, int pote, int bitspar) {
        for (int i = 1; i <= TamN2; i++) {
            pote = pote * 2;
            bitspar = i;
            if (pote > TamN2) {
                System.out.println("Necesitamos " + bitspar
                        + " bits de paridad");
                break;
            }// if
        }// for
        return bitspar;
    }// cuantosBitsparNecesito

    public static void creacionDeMensaje(int[][] mensaje, int[] mensaje2, 
                                         int N2) {
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
    }// creacionDeMensaje
}// Practica 1