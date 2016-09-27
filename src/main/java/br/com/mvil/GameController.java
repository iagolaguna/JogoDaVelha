package br.com.mvil;

import br.com.mvil.dto.GameDTO;
import br.com.mvil.dto.PlayerDTO;
import br.com.mvil.dto.Position;
import br.com.mvil.dto.StatusGame;

import java.util.InputMismatchException;

import static br.com.mvil.InputOutputController.message;
import static br.com.mvil.InputOutputController.messageWithEspaces;
import static br.com.mvil.dto.StatusGame.TURN_PLAYER_ONE;
import static br.com.mvil.dto.StatusGame.TURN_PLAYER_TWO;
import static br.com.mvil.dto.StatusGame.WINNER_PLAYER_ONE;

/**
 * Created by Aluno on 22/09/2016.
 */

 class GameController {
    private GameDTO gameDTO;

     GameController(){
        gameDTO = new GameDTO();
    }

    public void init(char brandPlayer1, char brandPlayer2){
        PlayerDTO p1 = new PlayerDTO('X');
        PlayerDTO p2 = new PlayerDTO('O');
        gameDTO = new GameDTO(TURN_PLAYER_ONE, p1,p2,new Board());
        System.out.println("Montando Tabuleiro...");
        System.out.println("Jogador 1  seu simbolo no tabuleiro é  'X'");
        System.out.println("Jogador 2  seu simbolo no tabuleiro é  'O'");
        this.run();
    }

    void init(){
        message("Montando Tabuleiro...");
        message("Jogador 1  seu simbolo no tabuleiro é  'X'");
        message("Jogador 2  seu simbolo no tabuleiro é  'O'");
        gameDTO.getBoard().showBoard();
        this.run();
    }

    private void run() {
        InputOutputController mInputOutputController =new InputOutputController();
        while (isTurnOfAPlayer()){
                Position posPiece = mInputOutputController.
                        readPositionOfPlayer(String.valueOf(gameDTO.getStatus().getValue()));
                putPiece(posPiece);
        }
        finalizeGame();
    }

    private boolean isTurnOfAPlayer() {
        return gameDTO.getStatus() == TURN_PLAYER_ONE || gameDTO.getStatus() == StatusGame.TURN_PLAYER_TWO;
    }


    private void putPiece(Position pos){
        try {
            if (gameDTO.getBoard().validatePosition(pos)) {
                if (gameDTO.getStatus() == TURN_PLAYER_ONE) {
                    gameDTO.getBoard().setValue(pos, gameDTO.getPlayer1().getBrand());
                } else {
                    gameDTO.getBoard().setValue(pos, gameDTO.getPlayer2().getBrand());
                }
                setStatusOfGame();
            }else{
                message("Ja existe uma marca nesta posição, por favor informe outra posição");
            }
        }catch (ArrayIndexOutOfBoundsException e){
            message("Posição Invalida, favor inserir um Posição valida");
        }
        gameDTO.getBoard().showBoard();
    }

    private void setStatusOfGame() {
        if (gameDTO.getBoard().validateGame()){
            setStatusWinner();
        }else if(gameDTO.getBoard().isArrayFull()){
            gameDTO.setStatus(StatusGame.TIED_PLAYERS);
        }else{
            gameDTO.setStatus(gameDTO.getStatus() == TURN_PLAYER_ONE ? TURN_PLAYER_TWO : TURN_PLAYER_ONE);
        }
    }

    private void setStatusWinner() {
        switch (gameDTO.getStatus()){
            case TURN_PLAYER_ONE:
                gameDTO.setStatus(StatusGame.WINNER_PLAYER_ONE);
                break;
            case TURN_PLAYER_TWO:
                gameDTO.setStatus(StatusGame.WINNER_PLAYER_TWO);
                break;
        }
    }


    private void finalizeGame(){
        if (gameDTO.getStatus() == StatusGame.TIED_PLAYERS) {
            messageWithEspaces("Houve um empate entre os jogadores!");
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
