/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package pl7_ex5;

import java.util.Scanner;

/**
 *
 * @author Henrique Silva (1171311@isep.ipp.pt)
 */
public class PL7_EX5 {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        
        String[] nomes = new String[100];
        int comp;
        
        comp = lerNomes(nomes);
        
        
        
    }
    //lê os nomes até FIM
    private static int lerNomes(String[] vec) {
        Scanner input = new Scanner(System.in);
        String nome="";
        int i=0;

        System.out.println("Insira os nomes:");
        nome = input.next();
        while(!nome.equals("FIM") || i<100){
            vec[i]=nome;
            nome=input.next();
            i++;
        }
        return i;
    }
    //retorna o apelido.
    private static String apelido(String nome){
        nome = nome.trim();
        int last=nome.lastIndexOf(" ");
        
        return  nome.substring(last);
    }
    //lista o conteudo do vector até à posição j
    private static void mostrarListagem(String[] vec, int j){
        for(int i=0; i<j; i++){
            System.out.println(vec[i]);
        }
    }
    
    private static int preencherVetorApelidosS(String[] v1, String[] v2){
        int j=0;
        for(int i=0; i<v1.length; i++){
            if(apelido(v1[i]).substring(0,1).equals("S")){
                v2[j]=v1[i];
                j++;
            }
        }
        return j;
    }
    

}
