/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package pl7_ex2;

import java.util.Scanner;

/**
 *
 * @author Henrique Silva (1171311@isep.ipp.pt)
 */
public class PL7_EX2 {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        final int COMPRIMENTO = 20; 
        int n_func=0;
        double valor=0;
        String[] funcionarios = new String[COMPRIMENTO];
        double[] salarios = new double[COMPRIMENTO];
        String nome = "";
        
        Scanner input = new Scanner(System.in);
        
        //System.out.print("Nome: ");
        nome = input.nextLine();
        while(n_func < COMPRIMENTO && !nome.equalsIgnoreCase("tt")){
            funcionarios[n_func]= nome;
            do{
                //System.out.print("Salário: ");
                salarios[n_func] = input.nextDouble();
            }while (salarios[n_func] <= 0);
            input.nextLine();// limpa o /n que ficou do nextDouble()
            //System.out.print("Nome: ");
            n_func++;
            if(n_func < COMPRIMENTO)
                nome = input.nextLine();
        }
             
        if(n_func!=0){
            do{
                //System.out.print("Valor máximo: ");
                valor = input.nextDouble();
            }while(valor<0);
            
            printMenorQueMedia(n_func, salarios, funcionarios);
            printPercMenorQueValor(n_func, valor, salarios, funcionarios);
        }
        else
            System.out.println("sem dados");
      
    }
    
    public static double calculaMedia(double sal[], int index){
        
        double soma=0;
        for(int i=0; i<index; i++){
            soma = soma + sal[i];           
        }
        return soma/index;        
    }
    
    public static void printMenorQueMedia(int n_func, double sal[], String nome[]){
        double media = calculaMedia(sal, n_func);
        //System.out.println("Funcionarios menores que a média:");
        for( int i=0; i<n_func; i++){
            if(sal[i]<media)
                System.out.println(nome[i]);
        }
    }
    
    public static void printPercMenorQueValor(int n_func, double valor, double sal[], String nome[]){
        double cont=0, perc=0;
        
        for(int i=0; i<n_func; i++){
            if(sal[i]<valor)
                cont++;    
        }
        //System.out.println("Percentagem de funcionarios com salário menor que o inserido: ");
        perc = (cont/(n_func))*100;
        System.out.format("%.2f%% \n", perc );
    }

}