/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package pl7_ex1;

/**
 *Calcula a média dos numeros pares de um vector
 * 
 * @author Henrique Silva (1171311@isep.ipp.pt)
 */
import java.util.Scanner;

public class pl7_ex1 {
    
    public static void main(String[] args) {
        int i, s=0, c=0;
        int[] v = new int[10];
        Scanner ler = new Scanner(System.in);
        for(i = 0; i < v.length; i++){
            System.out.println("Número?");
            v[i]=ler.nextInt();
        }
        for(i = 0; i < v.length; i++){
            if (v[i] % 2 == 0){
                s = s + v[i];
                c++;
            }
        }
                
        if(c!=0){
            System.out.println(((double)s)/c);
            System.out.printf("Indice do menor valor %d\n", indiceMenorInteiro(v));
        }
        else
            System.out.println("Operação impossível de realizar");
    }
    
    public static int indiceMenorInteiro(int[] vector){
        int min=0; 
        for(int i=0; i<vector.length; i++){
            if(vector[i]<vector[min])
                min=i;
        }
        return min;
    }
}