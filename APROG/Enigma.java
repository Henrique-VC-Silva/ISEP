/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package pl7_ex3;

/**
 *
 * @author Henrique Silva (1171311@isep.ipp.pt)
 */
import java.util.Scanner;

public class Enigma {
    
    public static void main(String[] args) {
        int n=0;
        String nomes[] = new String[100];
        Scanner ler = new Scanner(System.in);
        String m="1-Ler Nomes\n2-Enigma Nome\n3-Terminar\n\nEscolha uma opção:";
        char op;
        do {
            System.out.println(m);
            op = ler.next().charAt(0);
            switch (op) {
                case '1':
                    n = lerNomes(nomes);
                    break;
                case '2':
                    System.out.println("Nome:");
                    String nome = ler.next();
                    n = enigma(nomes,nome,n);
                    break;
                case '3':
                    break;
                default:
                    System.out.println("Opção inválida!!");
            }
        } while (op != '3');
    }
    // Lê uma sequência de nomes terminada com a palavra FIM.
    // Armazena os nomes em vec e retorna o número desses nomes.
    private static int lerNomes(String[] vec) {
        Scanner input = new Scanner(System.in);
        String nome="";
        int i=0;

        System.out.println("Insira os nomes:");
        nome = input.next();
        while(!nome.equals("FIM")){
            vec[i]=nome;
            nome=input.next();
            i++;
        }
        return i;
    }
    // Apresenta os primeiros n elementos de vec
    private static void listar(String[] vec, int n) {
        for(int i=0; i<n; i++){
            System.out.println(vec[i]);
        }
    }
    
    private static int enigma(String[] nomes, String nome, int n) {
        int i=0;
        while (i<n && !nomes[i].equalsIgnoreCase(nome)) {
            i++;
        }
        if(i==n)
            return n;
        else{
            for (int j = i; j < n-1; j++)
                nomes[j]=nomes[j+1];
            return --n;
        }
    }
}