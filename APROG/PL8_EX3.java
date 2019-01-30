/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package pl8_ex3;

import java.util.Scanner;

/**
 *
 * @author Henrique Silva (1171311@isep.ipp.pt)
 */
public class PL8_EX3 {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        int nLinhas, nColunas;

        Scanner input = new Scanner(System.in);
        //n linhas?
        do{
            //System.out.println("Insira o numero de linhas da matriz.(maior que 0)");
            nLinhas = input.nextInt();
         }while(nLinhas < 1);
        //n colunas?
        do{
            //System.out.println("Insira o numero de colunas da matriz.(maior que 0)");
            nColunas = input.nextInt();
        }while(nColunas < 1); 
        //cria a matriz
        int matriz[][] = new int[nLinhas][nColunas];
        //preenche a matriz
        for(int linha=0; linha < nLinhas; linha++){
            for(int coluna=0; coluna < nColunas; coluna++){
                //System.out.printf("Introduza o valor da posição (%d,%d)\n", linha+1, coluna+1);
                matriz[linha][coluna]=input.nextInt();
            }
        }
        //cria matriz frequancia
        int freq[][];
        
        freq = calcFreq(matriz);
        System.out.println("Matriz");
        imprimeMatriz(matriz);
        System.out.println("Frequencia");
        imprimeMatriz(freq);
    }

    public static int[][] calcFreq(int[][] matriz){
        int dim = calculaValoresDiferentes(matriz);
        int[][] freq = new int[2][dim];
        //percorre a matriz original
        for(int i=0; i<matriz.length; i++){
            for(int j=0; j<matriz[i].length; j++){
                //percorre a matriz frequencia
                int k=0;
                boolean encontrou=false;

                do{
                    if(freq[0][k]==matriz[i][j]){
                        freq[1][k]++;
                        encontrou=true;
                    }
                    else{
                        if(freq[1][k]==0){
                            freq[0][k]=matriz[i][j];
                            freq[1][k]++;
                            encontrou=true;
                        }
                    }
                    k++;
                }while(!encontrou);
                  
            }
        }
        return freq;
               
    }
    
    public static void imprimeMatriz(int matriz[][]){
        
        for(int i=0; i<matriz.length; i++){
            for(int j=0; j<matriz[i].length; j++){
                System.out.printf(" %d",matriz[i][j]);
            }
            System.out.print("\n");
        }
    }
    
    public static int calculaValoresDiferentes(int[][] matriz){
        int valor=0, max=0;
        for(int i=0; i<matriz.length; i++){
            for(int j=0; j<matriz[i].length; j++){
                for(int k=0; k<matriz.length; k++){
                    for(int l=0; l<matriz[i].length; l++){
                        if(matriz[i][j]==matriz[k][l])
                            valor++;
                    }
                }
            if(max < valor)
                max=valor;
            }
        }
        return max;        
    }

}
