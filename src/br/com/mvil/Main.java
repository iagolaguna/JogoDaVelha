package br.com.mvil;

public class Main {

    public static void main(String[] args) {
    	
    	char[][] array = new char[3][3];
    	
    	Board board = new Board(array);
    	board.showBoard();
    }
}
