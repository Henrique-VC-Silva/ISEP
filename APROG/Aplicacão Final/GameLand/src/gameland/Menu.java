/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package gameland;

import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Scanner;

/**
 *
 * @author Henrique Silva (1171311@isep.ipp.pt)
 */
public class Menu {

    public static int mainMenu(){
        Scanner in = new Scanner(System.in);
        String data= new SimpleDateFormat("mm:ss dd/MM/yyyy").format(Calendar.getInstance().getTime());
        
        System.out.println(" ============================================================================================");
        System.out.println("    Menu                                                               "+ data +"            ");
        System.out.println(" ============================================================================================");
        System.out.println("  1. Carregar evento.       5. Atualizar participante.   9. Apagar equipa.");
        System.out.println("  2. Listar jogos evento.   6. Carregar resultados.     10. Listar prémios equipa.");
        System.out.println("  3. Carregar equipa.       7. Fazer backup.            11. Listar resumo jogo.");
        System.out.println("  4. Listar equipa.         8. Calcular prémios.        12. Listar prémios individuais.");
        System.out.println(" ============================================================================================");
        System.out.println("   0. TERMINAR.");
        System.out.println(" ============================================================================================");
        System.out.print(  "   Escolha a opção: ");
        int op = in.nextInt(); in.nextLine();
        return op;
    }
    /**
     * Mostra no ecrã o menu de escolha do output do premio individual
     * @return operação escolhida
     */
    public static int premioIndividual(){
        Scanner in = new Scanner(System.in);
        String data= new SimpleDateFormat("mm:ss dd/MM/yyyy").format(Calendar.getInstance().getTime());
        int op;
        do{
            System.out.println(" ============================================================================================");
            System.out.println("    Listar prémios individuais                                         "+ data +"            ");
            System.out.println(" ============================================================================================");
            System.out.println("  1. No ecrã.");
            System.out.println("  2. Para ficheiro.");
            System.out.println(" ============================================================================================");
            System.out.print(  "   Escolha a opção: ");
            op = in.nextInt(); in.nextLine();
            if(op!=1 || op!=2)
                System.out.println("Opção inválida. Tente de novo.");
        }while(op!=1 || op!=2);
        
        return op;        
    }
    /**
     * Mosra o cabeçalho
     */
    public static void cabecalho() {
        System.out.printf("%30s%n", "PARTICIPANTES");
        System.out.println(" ============================================================================================");
    }
    /**
     * Pára até o utilisador primir ENTER
     */
    public static void pausa() {
        Scanner in = new Scanner(System.in);
        System.out.println("\n\nPara continuar prima ENTER\n");
        in.nextLine();
    }
    /**
     * 
     * @return 
     */
    public static int menuInfoParticipante() {
        Scanner in = new Scanner(System.in);
        System.out.println("\n ============================================================================================");
        System.out.println("    ATUALIZAR INFORMAÇÃO DE PARTICIPANTE");
        System.out.println(" ============================================================================================");
        System.out.println("   1. Email     2. Nome     3. Data de Nasciento        0. TERMINAR ");
        System.out.println("\nOPCAO: ");
        int op = in.nextInt();
        in.nextLine();
        return op;
    }
}
