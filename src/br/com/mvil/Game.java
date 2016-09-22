package br.com.mvil;

/**
 * Created by Aluno on 22/09/2016.
 */
public class Game {
    private Player p1;
    private Player p2;

    public Game(){

    }

    public void init(char brandPlayer1, char brandPlayer2){
        brandPlayer1 = 'O';
        brandPlayer2 = 'X';
        System.out.println("Montando Tabuleiro...");
        System.out.println("Jogador 1  seu simbolo no tabuleiro é  'X'");
        System.out.println("Jogador 2  seu simbolo no tabuleiro é  'O'");
        p1 = new Player(brandPlayer1);
        p2 = new Player(brandPlayer2);
    }


    public void putPiece(){
        
    }
}
