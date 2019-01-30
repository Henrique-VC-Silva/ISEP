/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package pl5_ex5;

import java.util.Scanner;

/**
 *
 * @author Henrique Silva (1171311@isep.ipp.pt)
 */
public class PL5_EX5 {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        int num, dig, aux=1, res=0;
        
        Scanner input = new Scanner(System.in);

        System.out.println("Introduza um número:");
        num = input.nextInt();
        
        while(num!=0){
            dig = num%10;
            if(dig%2 == 1){
                res=res+dig*aux;
                aux=aux*10;
            }
            num=num/10;
        }
        System.out.print("O resultado é: " +res);
    }
}
