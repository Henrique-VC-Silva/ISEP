/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package pl6_ex2;

import java.util.Scanner;

/**
 *
 * @author Henrique Silva (1171311@isep.ipp.pt)
 */
public class PL6_EX2 {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {

        int nAlunos, nDisciplinas, aprovados;
        String nome = "";
        
        Scanner input = new Scanner(System.in);
        
        do{
            System.out.println("Insira o numero de alunos inscritos.");
            nAlunos = input.nextInt();
        }while(0 > nAlunos);
        
        do{
            System.out.println("Insira o numero de disciplinas");
            nDisciplinas = input.nextInt();
        }while(0 > nDisciplinas);
        
        for(int i=0; i < nDisciplinas; i++){
            System.out.print("Nome da disciplina: ");
            nome = input.next();
            do{
                System.out.print("Alunos aprovados: ");
                aprovados = input.nextInt();
            }while(aprovados <= nAlunos);
            
            imprimeGrafico(nome, aprovados, nAlunos);
        }
    }
    
    public static void imprimeGrafico(String nome, int aprovados, int nAlunos){
        int i=0;
        String print="Disciplina: " + nome +"\n- Positivas: ";
        
        while(i<aprovados){
            print = print +"*";
            i++;
        }
        
        print = print + "\n- Negativas: ";
        
        while(i<nAlunos){
            print = print + "*";
            i++;
        }
       
        System.out.println(print);
        
    }

}
