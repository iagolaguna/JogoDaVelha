package br.com.mvil.dto;

/**
 * Created by Aluno on 23/09/2016.
 */
public enum StatusGame {
    TURN_PLAYER_ONE(0),
    TURN_PLAYER_TWO(1),
    WINNER_PLAYER_ONE(2),
    WINNER_PLAYER_TWO(3),
    TIED_PLAYERS(4);

    int value;
    StatusGame(int value) {
        this.value = value;
    }

    public int getValue() {
        return value;
    }
}
