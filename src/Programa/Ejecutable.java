/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Programa;
//Juande
import java.util.Scanner;

/**
 *
 * @author EAG
 */
public class Ejecutable {
    static Scanner sc = new Scanner(System.in);
    
    public static void main(String[] args) {
        Bait[] datos = new Bait[6];
        
        System.out.println("Introduce el primer numero");
        datos[0] = new Bait(sc.nextByte());
        
        System.out.println("Introduce el segundo numero");
        datos[1] = new Bait(sc.nextByte());
        
        datos[2] = new Bait();
        datos[3] = new Bait();
        datos[4] = new Bait();
        datos[5] = new Bait();
        
        datos[2].sumar(datos[0].getBait(), datos[1].getBait());
        datos[3].restar(datos[0].getBait(), datos[1].getBait());
        datos[4].multiplicar(datos[0].getBait(), datos[1].getBait());
        datos[5].potencia(datos[0].getBait(), datos[1].getBait());
        
        System.out.println("\nSuma: " + datos[2].pasarADecimal(datos[2].getBait()) + 
                           "\nResta: " + datos[3].pasarADecimal(datos[3].getBait()) +
                           "\nMultiplicacion: " + datos[4].pasarADecimal(datos[4].getBait()) +
                           "\nPotencia: " + datos[5].pasarADecimal(datos[5].getBait()));
    }
}
