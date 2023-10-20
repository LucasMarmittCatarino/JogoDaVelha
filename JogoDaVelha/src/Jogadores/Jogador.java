package Jogadores;
import Tabuleiro.Tabuleiro;
import java.util.Scanner;
public class Jogador {
    public char simbolo;
    public Jogador(char simbolo) {
        this.simbolo = simbolo;
    }

    public char getSimbolo() {
        return simbolo;
    }

    public void fazerJogada(Tabuleiro tabuleiro) {
        Scanner scanner = new Scanner(System.in);

        while (true) {
            System.out.print("Jogador " + simbolo + ", informe a linha: ");
            int linha = scanner.nextInt();
            System.out.print("Jogador " + simbolo + ", informe a coluna: ");
            int coluna = scanner.nextInt();

            if (linha < 0 || linha > 2 || coluna < 0 || coluna > 2 || tabuleiro.getCelula(linha, coluna) != ' ') {
                System.out.println("Jogada inválida. Tente novamente.");
            } else {
                tabuleiro.fazerJogada(linha, coluna, simbolo);
                break;
            }
        }
    }
}
