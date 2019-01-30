/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package pl5_ex4;

import java.util.Scanner;

/**
 *
 * @author Henrique Silva (1171311@isep.ipp.pt)
 */
public class PL5_EX4 {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        int n, np=0, contDiv, nPrimo=1;
        double nPerfeito; 

        Scanner input = new Scanner(System.in);

        //enquanto o numero for menor que 0 pede um numero
        do {
            System.out.println("Introduza N:");
            n = input.nextInt();
        } while(n <= 0);

        
        //até encontrar n numeros perfeitos
        do {
            //se (2^n)-1 é primo
            contDiv = 0;
            for(int div = nPrimo; div > 0; div--){
                if(nPrimo % div == 0)
                        contDiv++;
            }

            if(contDiv == 2){
                //então 2^(n−1)((2^n)-1) é perfeito
                nPerfeito = Math.pow(2,nPrimo-1)*(Math.pow(2, nPrimo)-1);
                System.out.print(nPerfeito +" ,");
                np++;
            }

            nPrimo++;

        } while( np < n);
    }
}