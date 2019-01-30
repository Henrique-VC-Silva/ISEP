/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package pl7_ex4;

import java.util.Arrays;
import java.util.Scanner;

/**
 *
 * @author Henrique Silva (1171311@isep.ipp.pt)
 */
public class PL7_EX4 {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {

        Scanner input = new Scanner(System.in);

        int n;

        do {
            System.out.println("Introduza quantos valores a ler.");
            n = input.nextInt();
        } while(n <= 0);

        int[] minhaArray = new int[n];

        for(int i = 0; i < n; i++) {
            System.out.println("Introduza um número:");
            minhaArray[i] = input.nextInt();
        }

        int[] minhaArrayInvertida = inverterVector(minhaArray);
        int[] minhaArrayRodada = rodarVectorDireita(minhaArrayInvertida);

        System.out.println("Output:");
        System.out.println(Arrays.toString(minhaArrayInvertida));
        System.out.println(Arrays.toString(minhaArrayRodada));

    }

    public static int[] inverterVector(int[] vector) {

        int[] vectorInvertido = new int[vector.length];

        for(int i = 0; i < vector.length; i++) {
            vectorInvertido[i] = vector[vector.length - i - 1];
        }

        return vectorInvertido;

    }

    public static int[] rodarVectorDireita(int[] vector) {

        int[] vectorRodado = new int[vector.length];

        vectorRodado[0] = vector[vector.length - 1];

        for(int i = 1; i < vector.length; i++) {
            vectorRodado[i] = vector[i - 1];
        }

        return vectorRodado;

    }

}
