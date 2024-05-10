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
    private byte numDecimal;
    
    public Bait(){
        vaciar();
    }
    public Bait(byte i){
        bait = pasarABinario(i);
        numDecimal = i;
    }
    
    public void vaciar(){
        for (byte i = 0; i < bait.length; i++) {
            bait[i] = false;
        }
    }
    
    public boolean[] pasarABinario(byte num){
        byte contador;
        
        boolean[] bits = new boolean[8];
        for (byte i = 0; i < num; i++) {
            contador = 0;            
            do{
                bits[contador] = !bits[contador];
            }while (!bits[contador++]);
        }
        
        return bits;
    }
    public byte pasarADecimal(boolean[] bits){
        byte num = 0;
        
        for (byte i = 0; i < bits.length; i++) {
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
        byte contador;
        for (byte i = 0; i < num.length - 1; i++) {
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
        byte contador;
        for (byte i = 0; i < num.length - 1; i++) {
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
        for (byte i = 0; i < pasarADecimal(num1); i++) {
            sumarABait(num2);
        }
    }
    
    public void potencia(boolean[] num1, boolean[] num2){
        for (byte i = 0; i < pasarADecimal(num2); i++) {
            multiplicar(num1, num1);
        }
    }
    
    /*
    public void pasarManco(Persona jaime){
        System.out.println("Manco");
    }
    */
}
