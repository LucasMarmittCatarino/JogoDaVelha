//Lucas Marmitt Catarino
import Tabuleiro.Tabuleiro;
import Jogadores.Jogador;
import Jogadores.JogadorMaquina;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Tabuleiro tabuleiro = new Tabuleiro();
        Jogador jogadorX = new Jogador('X');
        Jogador jogadorO = new Jogador('O');
        boolean jogadorXVenceu;
        boolean jogadorOVenceu;
        int resp;
        Scanner scanner = new Scanner(System.in);

        do{
        System.out.println("================== Escolha o modo de jogo ==================");
        System.out.println("1- Contra amigo \n2- Contra máquina");
        resp = scanner.nextInt();

        if (resp == 1){
            while (true) {
                tabuleiro.limparTela();
                tabuleiro.exibir();

                jogadorX.fazerJogada(tabuleiro);
                jogadorXVenceu = Tabuleiro.verificarVitoria(tabuleiro.getTabuleiro(), jogadorX.getSimbolo());
                if (jogadorXVenceu) {
                    tabuleiro.limparTela();
                    tabuleiro.exibir();
                    System.out.println("Jogador X venceu a rodada!");
                    break;
                }

                if (tabuleiro.estaCheio()) {
                    tabuleiro.limparTela();
                    tabuleiro.exibir();
                    System.out.println("Deu velha!");
                    break;
                }

                tabuleiro.limparTela();
                tabuleiro.exibir();

                jogadorO.fazerJogada(tabuleiro);
                jogadorOVenceu = Tabuleiro.verificarVitoria(tabuleiro.getTabuleiro(), jogadorO.getSimbolo());
                if (jogadorOVenceu) {
                    tabuleiro.limparTela();
                    tabuleiro.exibir();
                    System.out.println("Jogador O venceu a rodada!");
                    break;
                }
            }
        } else if(resp == 2){
            while(true){
                tabuleiro.limparTela();
                tabuleiro.exibir();
                Jogador jogadorMaquina = new JogadorMaquina('O');

                jogadorX.fazerJogada(tabuleiro);
                jogadorXVenceu = Tabuleiro.verificarVitoria(tabuleiro.getTabuleiro(), jogadorX.getSimbolo());
                if (jogadorXVenceu) {
                    tabuleiro.limparTela();
                    tabuleiro.exibir();
                    System.out.println("Jogador X venceu a rodada!");
                    break;
                }

                if (tabuleiro.estaCheio()) {
                    tabuleiro.limparTela();
                    tabuleiro.exibir();
                    System.out.println("Deu velha!");
                    break;
                }

                tabuleiro.limparTela();
                tabuleiro.exibir();

                try {
                    Thread.sleep(2000);
                } catch (InterruptedException e) {
                    //Exceção
                }

                jogadorMaquina.fazerJogada(tabuleiro);
                jogadorOVenceu = Tabuleiro.verificarVitoria(tabuleiro.getTabuleiro(), jogadorMaquina.getSimbolo());
                if (jogadorOVenceu) {
                    tabuleiro.limparTela();
                    tabuleiro.exibir();
                    System.out.println("Máquina venceu a rodada!");
                    break;
                }
            }
        } else{
            tabuleiro.limparTela();
            System.out.println("Entrada inválida, escolha uma das duas opções abaixo!");
        }
        }while(resp !=1 && resp !=2);
    }
}