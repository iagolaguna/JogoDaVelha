package br.com.mvil;

/**
 * @Author Marcos Vinicius
 */

public class Board {

	private char[][] consoleBoard = new char[3][3];

	public Board(char[][] consoleBoard) {
		this.consoleBoard = consoleBoard;
	}

	public void showBoard() {
		System.out.println();
		for (int i = 0; i < 3; i++) {
			for (int i2 = 0; i2 < 3; i2++) {
				
				if (consoleBoard[i][i2] == '\u0000') {
					consoleBoard[i][i2]=' ';
				} 
				
				System.out.print("    " + consoleBoard[i][i2] + "     ");
				
				if (i2 == 0 || i2 == 1) {
					System.out.print("|");
				}
			}
			System.out.println();

			System.out.println(i == 2 ? "" : "---------------------------------");

		}
	}

}
