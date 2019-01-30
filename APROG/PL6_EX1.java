/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package pl6_ex1;

import java.util.Scanner;

/**
 *
 *  @author Henrique Silva (1171311@isep.ipp.pt)
 */
public class PL6_EX1 {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {     
        int nPalavras=0, exit=0;
        String palavra;
        
        Scanner input = new Scanner(System.in);
        
        System.out.print("Escreva uma palavra\n");
        
        do{
            palavra = input.next();
            
            if(!palindromo(palavra))
                nPalavras++;
            else
                exit = 1;
                
                       
        }
        while(exit != 1);
       
        System.out.print("Foram inseridos "+ nPalavras +" palavras antes do palindromo");
    }
    
    public static boolean palindromo (String pal){
        boolean resposta = true;
        pal = pal.toLowerCase();
        int tamanho = pal.length();
        for(int i=0; i<tamanho/2; i++ ){
            if(pal.charAt(i) != pal.charAt(tamanho-1-i)){
                resposta = false;
                break;
            }
        }
        return resposta;
    }
        
}
