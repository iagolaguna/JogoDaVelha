package br.com.mvil;

/**
 * Created by Aluno on 23/09/2016.
 */
public enum StatusGame {
    PLAYING(0),
    WINNER_PLAYER_ONE(1),
    WINNER_PLAYER_TWO(2),
    TIED_PLAYERS(3);

    int value;
    StatusGame(int value) {
        this.value = value;
    }
}
