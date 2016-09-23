package br.com.mvil;

/**
 * Created by Aluno on 22/09/2016.
 */

public class Game {
    private  boolean turnPlayer = true;
    private  boolean winner;
    private Player p1;
    private Player p2;
    private Board board;

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
        board = new Board();
        board.showBoard();
    }


    public boolean putPiece(int x, int y){
        x-=1;
        y-=1;
        try {
            if (board.validatePosition(x,y)) {
                if (turnPlayer) {
                    board.setValue(x, y, p1.getBrand());
                } else {
                    board.setValue(x, y, p2.getBrand());
                }
                turnPlayer = !turnPlayer;
            }else{
                System.out.println("");
                System.out.println("Ja existe uma marca nesta posição, por favor informe outra posição");
                System.out.println("");
            }

        }catch (ArrayIndexOutOfBoundsException e){
            System.out.println("");
            System.out.println("Posição Invalida, favor inserir um Posição valida");
            System.out.println("");
        }

        board.showBoard();
        winner = board.validateGame();
        return winner;
    }

    public boolean isTurnOfPlayer1(){
        return turnPlayer;
    }

    public boolean isTurnOfPlayer2(){
        return !turnPlayer;
    }
    

    public boolean hasWinner(){
        return winner;
    }
    public void finalizeGame(){
        if (isTurnOfPlayer1()){
            System.out.println("O Jogador 1 foi o Vencedor Sua Letra era '"+p1.getBrand()+"'");
        }else{
            System.out.println("O Jogador 2 foi o Vencedor Sua Marca era :'"+p2.getBrand()+"'");
        }
        board.showBoard();
    }

    public void getPositionsOfPlayer() {

    }
}
