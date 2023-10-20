package Tabuleiro;

public class Tabuleiro {
    private char[][] tabuleiro;
    public Tabuleiro() {
        tabuleiro = new char[3][3];
        iniciaTabuleiro();
    }

    public void iniciaTabuleiro() {
        for (int i = 0; i < 3; i++) {
            for (int j = 0; j < 3; j++) {
                tabuleiro[i][j] = ' ';
            }
        }
    }

    public void exibir() {
        System.out.println("   |0 |1 |2 |");
        for (int i = 0; i < 3; i++) {
            System.out.print(i + "  |");
            for (int j = 0; j < 3; j++) {
                System.out.print(tabuleiro[i][j] + " |");
            }
            System.out.println();
        }
    }

    public boolean estaCheio() {
        for (int i = 0; i < 3; i++) {
            for (int j = 0; j < 3; j++) {
                if (tabuleiro[i][j] == ' ') {
                    return false;
                }
            }
        }
        return true;
    }
    public char[][] getTabuleiro() {
        return tabuleiro;
    }
    public static boolean verificarVitoria(char[][] tabuleiro, char jogador) {
        for (int i = 0; i < 3; i++) {
            //horizontal
            if (tabuleiro[i][0] == jogador && tabuleiro[i][1] == jogador && tabuleiro[i][2] == jogador) {
                return true;
            }
            //vertical
            if (tabuleiro[0][i] == jogador && tabuleiro[1][i] == jogador && tabuleiro[2][i] == jogador) {
                return true;
            }
        }
        //diagonal1
        if (tabuleiro[0][0] == jogador && tabuleiro[1][1] == jogador && tabuleiro[2][2] == jogador) {
            return true;
        }
        //diagonal2
        if (tabuleiro[0][2] == jogador && tabuleiro[1][1] == jogador && tabuleiro[2][0] == jogador) {
            return true;
        }
        return false;
    }

    public char getCelula(int linha, int coluna) {
        return tabuleiro[linha][coluna];
    }
    public void fazerJogada(int linha, int coluna, char jogador) {
        tabuleiro[linha][coluna] = jogador;
    }
    public void limparTela(){
        int i;
        for(i=1; i<25;i++){
            System.out.println();
        }
    }
}

