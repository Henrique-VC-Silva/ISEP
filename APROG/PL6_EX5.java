/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package pl6_ex5;

import java.util.Scanner;

/**
 *
 * @author Henrique Silva (1171311@isep.ipp.pt)
 */
public class PL6_EX5 {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        int n, a, b, cont, contMax=0, num1=0, num2=0;
        String par="";

        Scanner input = new Scanner(System.in);
        
        do{
            System.out.println("Quantos pares de valores pretende inserir?");
            n = input.nextInt();
        }while(0 >= n);
        
        for(int i=0; i<n; i++){
            
            System.out.printf("Par %d:\n", i+1);  
            a = input.nextInt();
            b = input.nextInt();

            if( a>=0 && b>=0){
                cont = verificaNumeros(a,b);
                if(cont >= contMax){
                    num1 = a;
                    num2 = b;
                    contMax = cont;
                }
            }
        }
        
        if(contMax > 0){
            par = par + num1 + "/" + num2;
            System.out.print(par);
        }
        else
            System.out.print("Sem resultados.");
    }
    
    /**
     * Verifica quantos digitos são iguais entre dois numeros
     * 
     * @param a numero 1
     * @param b numero 2
     * @return  numero de digitos iguais
     */
    public static int verificaNumeros( int a, int b){
        int cont=0;
        
        while(0 < a && 0 < b){
            if(a%10 - b%10 == 0){
                cont++;
            }
            a = a/10;
            b = b/10;
        }
        
        return cont;
    }
        
}