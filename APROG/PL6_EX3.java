/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package pl6_ex3;

import java.util.Scanner;

/**
 *
 * @author Henrique Silva (1171311@isep.ipp.pt)
 */
public class PL6_EX3 {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {

    double a, b, c;
    String angulosInternos="";
    
    Scanner input = new Scanner(System.in);
    
    //Lê os valores dos lados
    
        System.out.print("Insira o valor do lado a: ");
        a = input.nextDouble();
 
        System.out.print("Insira o valor do lado b: ");
        b = input.nextDouble();

        System.out.print("Insira o valor do lado c: ");
        c = input.nextDouble();
    
    //Verifica se o triângulo é possivél
        if(0 >= a || 0 >= b || 0 >= c || a+b < c || a+c < b || b+c < a)
            System.out.print("Impossivel");
        else{
            System.out.printf("%.0f\n", calcAng(a,b,c));
            System.out.printf("%.0f\n", calcAng(a,c,b));
            System.out.printf("%.0f\n", calcAng(b,c,a));
        }
    }
    
    public static double calcAng(double a, double b, double c){
        
        return Math.toDegrees( Math.acos((a*a+b*b-c*c)/(2*a*b)));

    }

}
