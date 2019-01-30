/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package pl6_ex6;

import java.util.Scanner;

/**
 *
 * @author Henrique Silva (1171311@isep.ipp.pt)
 */
public class PL6_EX6 {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        String solido="";
        double raio, altura, volume;
        
        System.out.println("Introduza o nome do sólido. (Cone, Esfera ou Cilindro. FIM para terminar)");
        solido = input.next();
        
        while(!solido.equals("FIM")){
            
            switch(solido.toLowerCase()){
                case "esfera": 
                    System.out.print("Raio: ");
                    raio = input.nextDouble();
                    volume = calcVolumeEsfera(raio);
                    System.out.printf("Volume da esfera %.2f",volume);
                    break;

                case "cilindro": 
                    System.out.print("Raio: ");
                    raio = input.nextDouble();
                    System.out.print("Altura: ");
                    altura = input.nextDouble();
                    volume = calcVolumeCilindro(raio, altura);
                    System.out.printf("Volume do cilindro %.2f\n", volume );
                    break;

                case "cone": 
                    System.out.print("Raio: ");
                    raio = input.nextDouble();
                    System.out.print("Altura: ");
                    altura = input.nextDouble();
                    volume = calcVolumeCone(raio, altura);
                    System.out.printf("Volume do cone %.2f\n", volume );
                    break;
                
                default:
                    System.out.println("Sólido desconhecido.");
                    break;
            }
            
        System.out.println("Introduza o nome do sólido. (Cone, Esfera ou Cilindro. FIM para terminar)");
        solido = input.next();
                
        }
            
    }
        
    public static double calcVolumeEsfera(double raio){
        
        double volume = (3*Math.PI*Math.pow(raio,3))/4;
        return volume;
    }
    
    public static double calcVolumeCilindro(double raio, double altura){
        
        double volume = Math.PI*Math.pow(raio,2)*altura;
        return volume;
    }
    
    public static double calcVolumeCone(double raio, double altura){
        
        double volume = (Math.PI*Math.pow(raio,2)*altura)/3;
        return volume;
    }

}
