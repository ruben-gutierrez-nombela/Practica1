package com.tiernoparla.practica1;

import static com.tiernoparla.practica1.RefactorizarSimulacro.jugadaDeMachine;
import static com.tiernoparla.practica1.RefactorizarSimulacro.jugadaDePlayer;
import static com.tiernoparla.practica1.RefactorizarSimulacro.verQuienGana;
import java.util.Scanner;

public class EXAMEN {

    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);

        int N = 9;
        int tab[] = new int[N];

        int Position = 0;
        int Position_machine = Position + 1;
        int Player = 7;
        int Machine = 2;
        boolean ganador = true;

        for (int i = 0; i < tab.length; i++) {

            System.out.println("Dame una posicion del 0 al " + (N - 1) + ": ");
            Position = sc.nextInt();

            while (Position >= tab.length || Position < 0) {
                System.out.println("Esa posicion no es valida, pon otra posicion:");
                Position = sc.nextInt();
            }

            while (tab[Position] == 2 || tab[Position] == 7) {
                System.out.println("Posicion usada, pon otra posicion: ");
                Position = sc.nextInt();
            }// while

            tab[Position] = Player;
            System.out.println("");

            for (int j = 0; j < tab.length; j++) {
                System.out.print(tab[j]);
            }// for

            System.out.println("");
            System.out.println("--------------------------");
            System.out.println("");

            for (int j = 0; j < 9999; j++) {

                Position_machine = Position + 1;
                
                while (tab[Position_machine] == 2
                        || tab[Position_machine] == 7) {

                    Position_machine = Position - 1;
                }// while
                if(Position_machine == Position + 1 || Position_machine == Position - 1){
                    Position_machine = (int) (Math.random() * N);
                }// if
            }// for

            System.out.println("El ordenador ha colocado su ficha "
                    + "en la posicion " + Position_machine);

            tab[Position_machine] = Machine;
            System.out.println("");

            for (int j = 0; j < tab.length; j++) {
                System.out.print(tab[j]);
            }// for

            System.out.println("");
            System.out.println("El ordenador ha terminado su turno");

            int contador = 0;
            for (int j = 1; j < tab.length - 1; j++) {
                if (tab[j] == 7) {
                    if (tab[j] - tab[j - 1] == tab[j + 1] - tab[j]) {
                        System.out.println("Ha ganado el jugador");
                        ganador = false;
                        break;
                    }// if
                }// if
                if (tab[j] == 2) {
                    if (tab[j] - tab[j - 1] == tab[j + 1] - tab[j]) {
                        System.out.println("Ha ganado el ordenador");
                        ganador = false;
                        break;
                    }// if
                }// if
            }// for
            for (int b = 0; b < tab.length; b++) {
                if (tab[b] == Player || tab[b] == Machine) {
                    contador++;
                    if (contador == tab.length) {
                        System.out.println("EMPATE");
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

}// EXAMEN
