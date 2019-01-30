/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package gameland;

import static gameland.Config.*;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileWriter;
import java.io.IOException;
import java.util.Formatter;
import java.util.Scanner;

/**
 *
 * @author Henrique Silva (1171311@isep.ipp.pt)
 */
public class GameLand {

    /**
     * @param args the command line arguments
     * @throws java.io.FileNotFoundException
     */
    public static void main(String[] args) throws FileNotFoundException, IOException {
        Scanner in = new Scanner(System.in);
        
        String[] jogos= new String[N_JOGOS];
        String[][] participantes= new String[MAX_PARTICIPANTES][N_CAMPOS_INFO];
        String nomeFich="";
        int nParticipantes= 0;
        int[][] pontos = new int[MAX_PARTICIPANTES][N_JOGOS];
        double[][] premios= new double[MAX_PARTICIPANTES][N_JOGOS];
        int op;
        
        do {
            op = Menu.mainMenu();
            switch (op) {
                case 1: //Carrega os dados do evento.
                    nomeFich=carregaEvento(jogos);
                    break;
                case 2: //Lista os jogos do evento.
                    listaJogosEvento(jogos);
                    break;
                case 3: //Carrega dados da equipa.
                    System.out.println("Insira o nome do ficheiro com a informação.");
                    String tmp=in.next();
                    nParticipantes=carregaDadosEquipa(tmp, participantes, nParticipantes);
                    break;
                case 4: //Lista dados da equipa.
                    listaDadosEquipa(participantes, nParticipantes);
                    break;
                case 5: //Atualiza dados do participante.
                    System.out.println("Insira o email do particioante a atualizar.");

                    actualizarInfoParticipante(nomeFich, participantes, nParticipantes);
                    break;
                case 6: //Carrega resultados.
                    carregaResultados(nomeFich, jogos, participantes, pontos);
                    break;    
                case 7: //Backup.
                    backup(nomeFich, jogos, participantes, nParticipantes, pontos ,premios);
                    break;    
                case 8: //Calcula valor dos prémios.
                    calculaPremios(nomeFich, jogos, participantes, nParticipantes, pontos ,premios);
                    break;    
                case 9: //Apagar equipa.
                    apagarEquipa();
                    break;
                case 10: //Listar os prémios da equipa.
                    listaPremiosEquipa();
                    break;
                case 11: //Listar resumo do jogo.
                    listarResumoJogo();
                    break;    
                case 12: //Listar prémios individuais.
                   // Menu.listarPremiosIndividuais(participantes, premios);
                    break;
                    case 0:
                    System.out.println("Já fez todas as gravações necessárias? Confirma terminar(s/n)?");
                    char resp = (in.next()).charAt(0);
                    if (resp != 's' && resp != 'S') {
                        op = 1;
                    }
                    break;
                default:
                    System.out.println("Opção incorreta. Repita");
                    break;
            }
        }while(op!=0);
        
    }
    /**
     * Carrega os dados do evento de um ficheiro indicado pelo utilisador
     * 
     * @param jogos vetor com os jogos a realisar no evento
     * @return  nome do ficheiro com a informacao
     * @throws FileNotFoundException 
     */
    public static String carregaEvento(String[] jogos) throws FileNotFoundException{
        Scanner in = new Scanner(System.in);
        System.out.println("Qual a data do evento (AAAAMMDD)?");
        String nomeFich = in.nextLine();
        if(carregarJogosDoEvento("./src/Dados/"+nomeFich+".txt", jogos)){
            System.out.println("Jogos carregados com sucesso");
        }else{
            System.out.println("Erro no carregamento dos jogos. Verifique ficheiro");
        }
        return nomeFich;
    }
    /**
     * Carrega os jogos do evento
     * 
     * @param nomeFichJogos nome do ficheiro com a informacao
     * @param jogos vetor onde guardar os jogos a realizar
     * @return true se ler com sucesso
     * @throws FileNotFoundException 
     */
    private static boolean carregarJogosDoEvento(String nomeFichJogos, String[] jogos)throws FileNotFoundException {
        int i;
        try (Scanner fInput = new Scanner(new File(nomeFichJogos))) {
            i = 0;
            while (fInput.hasNextLine()&& i < N_JOGOS) {
                String linha = fInput.nextLine();
                // Verifica se linha não está em branco
                if ((linha.trim()).length() > 0) {
                    jogos[i] = linha;
                    i++;
                }
            }
        }
        return i==N_JOGOS;
    }
    /**
     * Carrega os dados da equipa
     * @param nomeFich nome do ficheiro com os dados da equipa
     * @param info matriz com os dados de todos os elementos inscritos
     * @param nElems n elementos ja inscritos
     * @return n elementos inscritos no final do carregamento
     * @throws FileNotFoundException 
     */
    public static int carregaDadosEquipa (String nomeFich, String[][] info, int nElems) throws FileNotFoundException {
        int nElemsInic;
        try (Scanner fInput = new Scanner(new File("./src/Dados/"+nomeFich+".txt"))) {
            nElemsInic = nElems;
            while (fInput.hasNext() && nElems< MAX_PARTICIPANTES) {
                String linha = fInput.nextLine();
                // Verifica se linha não está em branco
                if (linha.trim().length() > 0) {
                    nElems = guardarDados(linha, info, nElems);
                }
            }
        }
        if(nElems-nElemsInic==3){
           return nElems;
        }
        else
            return nElemsInic;
    }
    /**
     * guarda na matriz info os dados passados na string linha, a partir da posicao nElems que ja estao inscritos
     * 
     * @param linha String com os dados a guardar
     * @param info Matriz onde guardar os dados
     * @param nElems numero de elementos ja existentes ma matriz
     * @return numero de elementos guardados na matriz no fim da operacao
     */
    private static int guardarDados(String linha, String[][] info, int nElems) {
        String[] temp = linha.split(SEPARADOR_DADOS_FICH);
        if (temp.length == N_CAMPOS_INFO) {
            String mail = temp[0].trim();
            int pos = Utilitarios.pesquisarElemento(mail, nElems, info);
            if (pos == -1)  {
                for(int i=0; i<N_CAMPOS_INFO;i++){
                    info[nElems][i] = temp[i].trim();
                }
                nElems++;
            }
        }
        return nElems;
    }
    /**
    * Atualiza informação alterável de um participante
    *
    * @param eMail – mail do participante
    * @param matriz
    * @param nElems número de elementos
    * @return false se o eMail não foi encontrado ou true se foi encontrado e
    * atualizado
    */
    public static boolean actualizarInfoParticipante(String eMail, String[][] matriz, int nElems) {
        Scanner in = new Scanner(System.in);
        int pos;
        if ((pos = Utilitarios.pesquisarElemento(eMail, nElems, matriz)) > -1) {
            int op;
            do {
                Formatter out = new Formatter(System.out);
                mostrarParticipante(out, matriz[pos]);
                op = Menu.menuInfoParticipante();
                switch (op) {
                    case 1:
                        System.out.println("Novo EMail:");
                        matriz[pos][0] = in.nextLine();
                        break;
                    case 2:
                        System.out.println("Novo nome:");
                        matriz[pos][2] = in.nextLine();
                        break;
                    case 3:
                        System.out.println("Nova data nascimento:");
                        matriz[pos][3] = in.nextLine();
                        break;
                    case 0:
                        System.out.println("FIM");
                        break;
                    default:
                        System.out.println("Opção incorreta");
                        break;
                }
            } while (op != 0);
            return true;
        }
        System.out.printf("O participante %s não foi encontrado!", eMail);
        return false;
    }
    /**
     * 
     * @param nomeFicheiro
     * @param jogos
     * @param participantes
     * @param pontos
     * @throws FileNotFoundException 
     */
    public static void carregaResultados(String nomeFicheiro, String[] jogos, String[][] participantes, int[][] pontos) throws FileNotFoundException {
        Scanner in = new Scanner(System.in);
        String[][] idJogos = new String[N_JOGOS][2];
        //cria um vetor com todos os nomes dos jogos formatados IDJOGO
        for (int i = 0; i < N_JOGOS; i++) {
            String[] dadosDoJogo = jogos[i].split("-");
            idJogos[i][0] = dadosDoJogo[0].trim();
            idJogos[i][1] = dadosDoJogo[2].trim();
        }
        System.out.println("Insira o código do jogo");
        int idJogo = in.nextInt();
        for (int i = 0; i < N_JOGOS; i++) {
            if(idJogo == Integer.getInteger(idJogos[i][0])){
                                int contadorParticipantes = 0;
                try (Scanner scannerFile = new Scanner(new File("./Dados/" + nomeFicheiro +"_" + idJogos[i][0] + ".txt"))) {
                    //coloca toda a pontuacao a zero
                    for(int k=0; k < MAX_PARTICIPANTES; k++){
                        pontos[k][i] = 0;
                    }
                    //le os dados e atualiza os que existem
                    while (scannerFile.hasNextLine() && contadorParticipantes < MAX_PARTICIPANTES) {
                        String[] data = scannerFile.nextLine().split(";");
                        String jogador = data[0].trim();
                        int pts = Integer.getInteger(data[1].trim());
                        if (!participantes[contadorParticipantes][0].equals(jogador)) {
                            contadorParticipantes++;
                            }
                        else{
                            if(0 > pts  || pts > Integer.getInteger(idJogos[i][1])) {
                            } else {
                                pontos[contadorParticipantes][i] = pts;
                            }
                        }
                    }
                }
            System.out.println("O ficheiro " + idJogos[i][0] + " foi carregado com sucesso.");
            } 
        }
    }
    /**
    * Mostrar a informação de um participante separada por ;
    * @param out - instancia de formatter associado ao stream pretendido
    * @param participante - array de Strings com a informação do participante
    */
    public static void mostrarParticipante(Formatter out, String[] participante) {
        for (int j = 0; j < N_CAMPOS_INFO; j++) {
            if (j == 1) {
                out.format("%30s;", participante[j]);
            }
            else {
                out.format("%12s;", participante[j]);
            }
        }
    }
    /**
     * Mostra os dados da equipa
     * 
     * @param matriz
     * @param nEl 
     */
    public static void listaDadosEquipa(String[][] matriz, int nEl){
        int contPaginas = 0;
        for (int i = 0; i < nEl; i++) {
            if (i % MAX_LINHAS_PAGINA == 0) {
                if (contPaginas > 0) {
                    Menu.pausa();
                }
                contPaginas++;
                System.out.println("\nPÁGINA: " + contPaginas);
                Menu.cabecalho(); 
            }
            for (int j = 0; j < N_CAMPOS_INFO; j++) {
                if (j == 1) {
                    System.out.printf("%30s", matriz [i][j]);
                    }
                else {
                    System.out.printf("%10s", matriz[i][j]);
                }
            }
            System.out.println("");
        } 
        Menu.pausa();
    }
    /**
     * Lista a informação dos jogos do evento
     * 
     * @param jogos 
     */
    public static void listaJogosEvento(String[] jogos) {
        System.out.println("Jogos do evento");
        System.out.println(" ============================================================================================"); 
        System.out.printf("%15s%15s%15s%n","ID do jogo", "Tipo de jogo", "Max. de pontos");
        System.out.println(" ============================================================================================");
        for(int i=0; i<N_JOGOS; i++){
            String[] temp=jogos[i].split("-");
            System.out.printf("%15s%15s%15s%n" ,temp[0], temp[1], temp[2]);
        }
        Menu.pausa();
    }
    /**
     * Lista os premios individuais
     * 
     * @param participantes
     * @param premios
     * @param nParticipantes 
     */
    public static void listarPremiosIndividuais(String[][] participantes, double[][] premios, int nParticipantes){
        String[][] listaPremios = new String[nParticipantes][4];
        for(int i=0; i<nParticipantes; i++){
                listaPremios[i][0] = participantes[i][0];
                listaPremios[i][1] = Utilitarios.apelidoELetraInicial(participantes[i][1]);
                listaPremios[i][2] = participantes[i][3];
                listaPremios[i][4] = calculaPremioTotal(premios[i]);
        }
        //ordenaDecrescente(listaPremios);
        int destino = Menu.premioIndividual();
        if(destino == 1){//no ecrã
            
        }
        else{//no ficheiro
           // Utils.escreveNoFicheiro("Premios.txt",listaPremios);
        }
    }  
    /**
     * Efetua o bacup da informacao para um fcheiro
     * 
     * @param nomeFich
     * @param jogos
     * @param participantes
     * @param nParticipantes
     * @param pontos
     * @param premios
     * @throws IOException 
     */
    public static void backup(String nomeFich, String[] jogos, String[][] participantes,  int nParticipantes, int[][] pontos, double[][] premios) throws IOException{
        Formatter output = new Formatter(new File(":/src/Dados/backup.txt"));
        output.format("%s;%n", nomeFich);
        output.format("%d;%n", nParticipantes);
        for(int i=0; i < N_JOGOS; i++){
            output.format("%s%,", jogos[i]);
        }
        output.format(";%n");
                for(int i=0; i < nParticipantes; i++){
            for(int j=0; j < 4; j++){
                output.format("%s%,", participantes[i][j]);
            }
        }
        output.format(";%n");
        for(int i=0; i < nParticipantes; i++){
            for(int j=0; j < N_JOGOS; j++){
                output.format("%d%,", pontos[i][j]);
            }
        }
        output.format(";%n");
        for(int i=0; i < nParticipantes; i++){
            for(int j=0; j < N_JOGOS; j++){
                output.format("%.2f%,", premios[i][j]);
            }
        }
        output.format(";%n");
        output.close();
        System.out.println("Backup concluido.");
        
    }
    /**
     * Calcula os premios do evento
     * 
     * @param nomeFich
     * @param jogos
     * @param participantes
     * @param nParticipantes
     * @param pontos
     * @param premios 
     */
    public static void calculaPremios(String nomeFich, String[] jogos, String[][] participantes, int nParticipantes, int[][] pontos ,double[][] premios){
        //limpa a matriz premios e atribui os premios de aniversario
        for(int j=0; j<N_JOGOS; j++){
            for(int i=0; i< nParticipantes; i++){
                if(nomeFich.equals(Utilitarios.converterddmmaaaaParaaaammdd(participantes[i][2]))){
                   premios[i][j]=(2.00*Utilitarios.idade(Utilitarios.converterddmmaaaaParaaaammdd(participantes[i][2])));
                }
                else
                   premios[i][j]=0;
            }
        }
        //premios de vencedor do jogo
        for(int j=0; j<N_JOGOS; j++){
            int max=-1, posicao=-1;
            String[] dadosDoJogo = jogos[j].split("-");
            double pontosMax = Integer.getInteger(dadosDoJogo[2].trim());
            for(int i=0; i< nParticipantes; i++){
                if(max < pontos[i][j]){
                    max = pontos[i][j];
                    posicao = i;
                }
            premios[posicao][j] = premios[posicao][j]+(pontos[posicao][j]/pontosMax)*100;
            } 
        }
        //premio da equipa vencedora
        for(int j=0; j<N_JOGOS; j++){
            int pontMax=-1, posicao=-1, i=0;
            while( i < nParticipantes){
               int pnts=pontos[i][j]+pontos[i+1][j]+pontos[i+2][j];
               if(pontMax < pnts){
                   posicao=i;
               }
               i=i+3;
            }
            premios[posicao][j] = premios[posicao][j]+50;
            premios[posicao+1][j] = premios[posicao+1][j]+50;
            premios[posicao+2][j] = premios[posicao+2][j]+50;
        }
    }

    public static void apagarEquipa(){
        System.out.println("Em desenvolvimento...");
        Menu.pausa();
        
    }

    public static void listaPremiosEquipa(){
        System.out.println("Em desenvolvimento...");
        Menu.pausa();
    }

    public static void listarResumoJogo(){
        System.out.println("Em desenvolvimento...");
        Menu.pausa();
    }
    
    public static String calculaPremioTotal(double[] premios){
        double soma = 0;
        for(int i=0; i<N_JOGOS; i++){
            soma = soma + premios[i];
        }
        return ""+soma;
    }
}
