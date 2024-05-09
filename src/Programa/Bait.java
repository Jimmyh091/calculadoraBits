/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Programa;

/**
 *
 * @author EAG
 */
public class Bait {
    private boolean[] bait = new boolean[8];
    
    public Bait(){
        vaciar();
    }
    public Bait(int i){
        bait = pasarABinario(i);
    }
    
    public void vaciar(){
        for (int i = 0; i < bait.length; i++) {
            bait[i] = false;
        }
    }
    
    public boolean[] pasarABinario(int num){
        int contador;
        
        boolean[] bits = new boolean[8];        
        for (int i = 0; i < num; i++) {
            contador = 0;
            
            do bits[contador] = !bits[contador];
            while (!bits[contador++]);
        }
        
        return bits;
    }
    public int pasarADecimal(boolean[] bits){
        int num = 0;
        
        for (int i = 0; i < bits.length; i++) {
            if (bits[i]) {
                num += Math.pow(2, i);
            }
        }
        
        return num;
    }

    public void sumar(boolean[] num1, boolean[] num2){
        sumarABait(num1);
        sumarABait(num2);        
    }

    public void sumarABait(boolean[] num){
        int contador;
        for (int i = 0; i < num.length - 1; i++) {
            if (num[i]) {
                contador = i;
                do {
                    bait[contador] = !bait[contador];                    
                } while (!bait[contador++]);                
            }
        }
    }
    
    public void restar(boolean[] num1, boolean[] num2){
        sumarABait(num1);
        restarABait(num2);
    }
    
    public void restarABait(boolean[] num){
        int contador;
        for (int i = 0; i < num.length - 1; i++) {
            if (num[i]) {
                contador = i;
                do {
                    bait[contador] = !bait[contador];                    
                } while (bait[contador++]);                
            }
        }
    }
    
    public boolean[] getBait(){
        return bait;
    }
    
    public void multiplicar(boolean[] num1, boolean[] num2){
        for (int i = 0; i < pasarADecimal(num1); i++) {
            sumarABait(num2);
        }
    }
    /*
    public void pasarManco(Persona jaime){
        System.out.println("Manco");
    }
    */
}
