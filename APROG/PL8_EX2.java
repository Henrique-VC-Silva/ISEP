/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package pl8_ex2;

import java.util.Scanner;

/**
 *
 * @author Henrique Silva (1171311@isep.ipp.pt)
 */
public class PL8_EX2 {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {

        int dimensao;
        boolean magico;

        Scanner input = new Scanner(System.in);
        
        do{
            System.out.println("Insira a dimensão do quadrado.(maior que 1)");
            dimensao = input.nextInt();
        }while(dimensao < 2);
        
        int matriz[][] = new int[dimensao][dimensao];
        
        for(int linha=0; linha < matriz.length; linha++){
            for(int coluna=0; coluna < matriz.length; coluna++){
                System.out.printf("Introduza o valor da posição (%d,%d)\n", linha+1, coluna+1);
                matriz[linha][coluna]=input.nextInt();
            }
        }
        
        magico = quadradoMagico(matriz);
        System.out.println(magico);
       
    }
    
    public static boolean quadradoMagico(int matriz[][]){
        boolean magico = true;
        int tam = matriz.length, somaLinhas[] = new int[matriz.length+1], somaColunas[] = new int[matriz.length+1];
        
        for(int linha=0; linha < tam; linha++){
            for(int coluna=0; coluna < tam; coluna++){
            
                somaLinhas[linha+1] = somaLinhas[linha+1] + matriz[linha][coluna];
                somaColunas[coluna+1] = somaColunas[coluna+1] + matriz[linha][coluna];
            }
            somaLinhas[0] = somaLinhas[0] + matriz[linha][linha];
            somaColunas[0] = somaColunas[0] + matriz[linha][tam-linha-1];
        }
        
        int i=0;
        while(magico && somaLinhas.length > i){
            
            if(somaLinhas[0] != somaLinhas[i] || somaLinhas[0] != somaColunas[i]){ 
                magico = false;
            }
            i++;
        }
        
        return magico;
    }
}
