package Jogadores;

import Tabuleiro.Tabuleiro;
import java.util.Random;

public class JogadorMaquina extends Jogador {
    public JogadorMaquina(char simbolo) {
        super(simbolo);
    }

    public void fazerJogada(Tabuleiro tabuleiro) {
        Random random = new Random();
        int tamanhoTabuleiro = 3;

        while (true) {
            int linha = random.nextInt(tamanhoTabuleiro);
            int coluna = random.nextInt(tamanhoTabuleiro);

            if (tabuleiro.getCelula(linha, coluna) == ' ') {
                tabuleiro.fazerJogada(linha, coluna, getSimbolo());
                break;
            }
        }
    }
}
