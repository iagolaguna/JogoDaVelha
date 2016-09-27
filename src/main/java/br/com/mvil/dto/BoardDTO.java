package br.com.mvil.dto;

/**
 * Created by iago.laguna on 26/09/2016.
 */
public class BoardDTO {
    public static final char CHAR_WITH_SPACE = ' ';
    public static final char CHAR_NULL = '\u0000';
    private char[][] consoleBoard = new char[3][3];

    public void setPosition(int x, int y,char value) {
        consoleBoard[x][y] = value;
    }
    public char getPosition(int x, int y) {
        return  consoleBoard[x][y];
    }

    public boolean isPositionEmpty(int x, int y){
        return isCharEmpty(consoleBoard[x][y]);
    }

    public boolean isCharEmpty(char value){
        return value == CHAR_NULL;
    }
}
