package br.com.mvil;

/**
 * Created by Aluno on 22/09/2016.
 */

public class Game {
    private  boolean turnPlayer = true;
    private  StatusGame status;
    private Player p1;
    private Player p2;
    private Board board;

    public Game(){

    }

    public void init(char brandPlayer1, char brandPlayer2){
        brandPlayer1 = 'X';
        brandPlayer2 = 'O';
        System.out.println("Montando Tabuleiro...");
        System.out.println("Jogador 1  seu simbolo no tabuleiro é  'X'");
        System.out.println("Jogador 2  seu simbolo no tabuleiro é  'O'");
        p1 = new Player(brandPlayer1);
        p2 = new Player(brandPlayer2);
        status = StatusGame.PLAYING;
        board = new Board();
        board.showBoard();
    }


    public void putPiece(int x, int y){
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
                setStatus();

            }else{
                message("Ja existe uma marca nesta posição, por favor informe outra posição");
            }
        }catch (ArrayIndexOutOfBoundsException e){
            message("Posição Invalida, favor inserir um Posição valida");
        }

        board.showBoard();
    }

    private void setStatus() {
        if (board.validateGame()){
            status = isTurnOfPlayer1() ? StatusGame.WINNER_PLAYER_ONE : StatusGame.WINNER_PLAYER_TWO;
        }else if(!board.validateGame() && board.isArrayFull()){
            status = StatusGame.TIED_PLAYERS;
        }
    }

    private void message(String message) {
        System.out.println("");
        System.out.println(message);
        System.out.println("");
    }

    public boolean isTurnOfPlayer1(){
        return turnPlayer;
    }


    public void finalizeGame(){
        if (status == StatusGame.TIED_PLAYERS) {
            System.out.println("Houve um empate entre os jogadores!");
        }else{
            if (isTurnOfPlayer1()) {
                System.out.println("O Jogador 1 foi o Vencedor Sua Letra era '" + p1.getBrand() + "'");
            } else {
                System.out.println("O Jogador 2 foi o Vencedor Sua Marca era :'" + p2.getBrand() + "'");
            }
        }
        board.showBoard();
    }


    public StatusGame getStatus() {
        return status;
    }
}
