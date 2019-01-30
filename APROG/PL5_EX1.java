/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package pl5_ex1;

import javax.swing.JOptionPane;

/**
 *
 * @author Henrique Siva (1171311@isep.ipp.pt)
 */
public class PL5_EX1 {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        
        int somaPares = 0, contPares = 0, n, num;
        double perc, media;
        String nString = "";
        
        /**
         * Lê quantos numeros são para calcular
         */
        nString = JOptionPane.showInputDialog("Introduza quantos numeros são para ler.");
        n = Integer.parseInt(nString);
        
        /**
         * Lê os numeros e contabilisa quantos são pares
         */
        for (int i = 0; i < n; i++) {
            nString = JOptionPane.showInputDialog("Introduza um numero.");
            num = Integer.parseInt(nString);
            
            if(num %2 == 0){
                contPares++;
                somaPares = somaPares+num;
            }
        }
        
        /**
         * Se existirem pares... senão...
         */
        if ( contPares != 0){
            media = (double) somaPares/contPares;
            JOptionPane.showMessageDialog(null, "A média dos numeros pares é:" +media);
            perc = (double) contPares/n*100;
            JOptionPane.showMessageDialog(null,"A percentaguem de numeros pares é:" +perc +"%");            
        }
        else
            JOptionPane.showMessageDialog(null,"Não foram inseridos números pares.");
    }
    
}
