package br.com.mvil.dto;

import br.com.mvil.Board;

/**
 * Created by iago.laguna on 26/09/2016.
 */
public class GameDTO {
    private StatusGame status;
    private PlayerDTO player1;
    private PlayerDTO player2;
    private Board board;

    public GameDTO(StatusGame status, PlayerDTO player1, PlayerDTO player2, Board board) {
        this.status = status;
        this.player1 = player1;
        this.player2 = player2;
        this.board = board;
    }
    public GameDTO() {
        this.status = StatusGame.TURN_PLAYER_ONE;
        this.player1 = new PlayerDTO('X');
        this.player2 = new PlayerDTO('O');
        this.board = new Board();
    }
    public StatusGame getStatus() {
        return status;
    }

    public PlayerDTO getPlayer1() {
        return player1;
    }

    public PlayerDTO getPlayer2() {
        return player2;
    }

    public Board getBoard() {
        return board;
    }


    public void setStatus(StatusGame status) {
        this.status = status;
    }

}
