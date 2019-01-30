/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package pl8_ex1;

/**
 *
 * @author Henrique Silva (1171311@isep.ipp.pt)
 */
public class PL8_EX1 {

    /**
     * @param args the command line arguments
     */
    public static void main( String[] args ) {
        int x;
        int m[][] = {{1,4,2,1},{9,7,2,2},{1,7,3,5},{2,5,0,3},{4,7,2,1}};

        for (int i=0; i < m.length; i++) {
            x = m[i][0];
            for (int j=1; j < m[i].length; j++){
                if (m[i][j] > x){
                    x = m[i][j];
                }
            }
            System.out.println(x);
        }
        
        printMatrix(m);
    }
    
    public static void printMatrix(int matrix[][]){
        
        for(int i=0; i < matrix.length; i++){
            int line[] = matrix[i];
            for(int j=0; j < matrix[i].length; j++){
                int value = line[i];
                
            }
        }
    }

}
