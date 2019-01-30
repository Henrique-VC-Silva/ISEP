/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package pl5_ex2;

import javax.swing.JOptionPane;

/**
 *
 * @author Henrique Silva (1171311@isep.ipp.pt)
 */
public class PL5_EX2 {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
 
        String nString = "";
        int n=0, tempMax=0;
                    
         /**
         * Lê quantas temperaturas são para classificar
         */
        nString = JOptionPane.showInputDialog("Introduza quantas temperaturas são para classificar.");
        n = Integer.parseInt(nString);
        
        /**
         * Classifica cada temperatura
         */
        for (int i = 0; i < n; i++) {
            nString = JOptionPane.showInputDialog("Introduza a temperatura máxima.");
            tempMax = Integer.parseInt(nString);
            
            if(tempMax < -30 || tempMax >= 50)
                JOptionPane.showMessageDialog(null,"Temperatura extrema.");
            else
                if(tempMax <= -30 && tempMax < 9)
                    JOptionPane.showMessageDialog(null,"Muito frio.");
                else
                    if(tempMax >= 9 && tempMax < 15)
                        JOptionPane.showMessageDialog(null,"Frio.");
                    else
                        if(tempMax >= 15 && tempMax < 20)
                            JOptionPane.showMessageDialog(null,"Ameno.");
                        else   
                            if(tempMax >= 20 && tempMax < 30)
                                JOptionPane.showMessageDialog(null,"Quente.");
                            else
                                JOptionPane.showMessageDialog(null,"Muito quente."); 
        }
    }
    
}
