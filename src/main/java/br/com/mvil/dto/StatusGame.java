package br.com.mvil.dto;

/**
 * Created by Aluno on 23/09/2016.
 */
public enum StatusGame {
    TURN_PLAYER_ONE(1),
    TURN_PLAYER_TWO(2),
    WINNER_PLAYER_ONE(3),
    WINNER_PLAYER_TWO(4),
    TIED_PLAYERS(5);

    int value;
    StatusGame(int value) {
        this.value = value;
    }

    public int getValue() {
        return value;
    }
}
