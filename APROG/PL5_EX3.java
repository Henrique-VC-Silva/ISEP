/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package pl5_ex3;

import javax.swing.JOptionPane;

/**
 *
 * @author Henrique Silva (1171311@isep.ipp.pt)
 */
public class PL5_EX3 {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {

        String nomes = "", nome ="", nString;
        int idade, maiorIdade = 0, nPessoas = 0;
        double percAdultos;
        
        while(!"zzz".equals(nome)){
            nome = JOptionPane.showInputDialog("Introduza o nome.");
            
            if(!"zzz".equals(nome)){
                nString = JOptionPane.showInputDialog("Qual a idade de " + nome);
                idade = Integer.parseInt(nString);
                nPessoas++;
                nomes = nomes + nome + ", ";
                if(18 < idade){
                    maiorIdade++;
                }
            }
            
        }
        
        if(nPessoas != 0){
            JOptionPane.showMessageDialog(null, nomes);
            percAdultos = (double) maiorIdade/nPessoas * 100;
            JOptionPane.showMessageDialog(null,"Percentagem de adultos: " +percAdultos +"%");
        }
        else
            JOptionPane.showMessageDialog(null,"Não foram introduzidas idades.");
    }

}
