
package com.tiernoparla.practica1;

import java.util.Scanner;

public class subString {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.print("Por favor, introduzca un número entero positivo:");
        String num = sc.next();
        System.out.println("Introduce la posición donde quieres insertar");
        int pos = sc.nextInt();
        System.out.println("Introduce el digito que quieres insertar");
        String dig = sc.next();

        //TODO comprobar que el indice se encuentre dentro de la longitud del numero    
        //Obtenemos la parte izquierda del numero
        String parte1 = num.substring(0, pos);
        //Obtenemos la parte derecha del numero
        String parte2 = num.substring(pos);
        //Las juntamos
        String result = parte1 + dig + parte2;

        System.out.println(result);
    }
}
