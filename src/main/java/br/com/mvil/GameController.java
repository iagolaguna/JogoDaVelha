package br.com.mvil;

import br.com.mvil.dto.GameDTO;
import br.com.mvil.dto.PlayerDTO;
import br.com.mvil.dto.StatusGame;

import java.util.Scanner;

import static br.com.mvil.dto.StatusGame.TURN_PLAYER_ONE;
import static br.com.mvil.dto.StatusGame.WINNER_PLAYER_ONE;

/**
 * Created by Aluno on 22/09/2016.
 */

public class GameController {
    private GameDTO gameDTO;

    public GameController(){
        gameDTO = new GameDTO();
    }

    public void init(char brandPlayer1, char brandPlayer2){
        PlayerDTO p1 = new PlayerDTO('X');
        PlayerDTO p2 = new PlayerDTO('O');
        System.out.println("Montando Tabuleiro...");
        System.out.println("Jogador 1  seu simbolo no tabuleiro é  'X'");
        System.out.println("Jogador 2  seu simbolo no tabuleiro é  'O'");
        gameDTO = new GameDTO(TURN_PLAYER_ONE, p1,p2,new Board());
        run();
    }

    public void init(){
        System.out.println("Montando Tabuleiro...");
        System.out.println("Jogador 1  seu simbolo no tabuleiro é  'X'");
        System.out.println("Jogador 2  seu simbolo no tabuleiro é  'O'");
        gameDTO.getBoard().showBoard();
        run();
    }

    public void run() {
        Scanner scanner = new Scanner(System.in);
        int x;
        int y;
        while (gameDTO.getStatus() == TURN_PLAYER_ONE
               || gameDTO.getStatus() == StatusGame.TURN_PLAYER_TWO ){

            message(String.format("Jogador %s faça sua jogada",
                    String.valueOf(gameDTO.getStatus().getValue())));
            message("Insira a posição da linha");
            x = scanner.nextInt();
            message("Insira a posição da coluna");
            y = scanner.nextInt();
            message("A Linha escolhida foi: "+x+" A Coluna escolhida foi: "+y);
            putPiece(x,y);
        }
        finalizeGame();

    }

    public void putPiece(int x, int y){
        x-=1;
        y-=1;
        try {
            if (gameDTO.getBoard().validatePosition(x,y)) {
                if (gameDTO.getStatus() == TURN_PLAYER_ONE) {
                    gameDTO.getBoard().setValue(x, y, gameDTO.getPlayer1().getBrand());
                } else {
                    gameDTO.getBoard().setValue(x, y, gameDTO.getPlayer2().getBrand());
                }
                setStatus();
            }else{
                message("Ja existe uma marca nesta posição, por favor informe outra posição");
            }
        }catch (ArrayIndexOutOfBoundsException e){
            message("Posição Invalida, favor inserir um Posição valida");
        }

        gameDTO.getBoard().showBoard();
    }

    private void setStatus() {
        if (gameDTO.getBoard().validateGame()){
            switch (gameDTO.getStatus()){
                case TURN_PLAYER_ONE:
                    gameDTO.setStatus(StatusGame.WINNER_PLAYER_ONE);
                    break;
                case TURN_PLAYER_TWO:
                    gameDTO.setStatus(StatusGame.WINNER_PLAYER_TWO);
                    break;
            }
        }else if(!gameDTO.getBoard().validateGame() && gameDTO.getBoard().isArrayFull()){
            gameDTO.setStatus(StatusGame.TIED_PLAYERS);
        }
    }

    private void message(String message) {
        System.out.println(message);
    }
    private void messageWithEspaces(String message) {
        System.out.println("");
        System.out.println(message);
        System.out.println("");
    }

    public void finalizeGame(){
        if (gameDTO.getStatus() == StatusGame.TIED_PLAYERS) {
            message("Houve um empate entre os jogadores!");
        }else{
            if (gameDTO.getStatus() == WINNER_PLAYER_ONE) {
                messageWithEspaces("O Jogador 1 foi o Vencedor Sua Letra era '" + gameDTO.getPlayer1().getBrand() + "'");
            } else {
                messageWithEspaces("O Jogador 2 foi o Vencedor Sua Letra era :'" + gameDTO.getPlayer2().getBrand() + "'");
            }
        }
        gameDTO.getBoard().showBoard();
    }
}
