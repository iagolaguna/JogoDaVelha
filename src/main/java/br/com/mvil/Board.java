package br.com.mvil;

import br.com.mvil.dto.Position;

/**
 * @Author Marcos Vinicius
 */

public class Board {

    public static final char EMPTY_CHAR = ' ';
    private char[][] consoleBoard = new char[3][3];


	/*
	 * @Author Marcos Vinicius
	 * */
	public void showBoard() {
		System.out.println();
		for (int x = 0; x < 3; x++) {
			for (int y = 0; y < 3; y++) {
				
				if (isPositionEmpty(x, y)) {
					consoleBoard[x][y]=EMPTY_CHAR;
				} 
				
				System.out.print("    " + consoleBoard[x][y] + "     ");
				
				if (y == 0 || y == 1) {
					System.out.print("|");
				}
			}
			System.out.println();

			System.out.println(x == 2 ? "" : "---------------------------------");

		}
	}

	
	/*
	 * @Author Marcos Vinicius
	 * */
	public void setValue(Position pos, char brandValue){
		consoleBoard[pos.getX()][pos.getY()] = brandValue;
	}

	/*
	 * @Author Marcos Vinicius
	 * */
	private boolean validateCombination(char a, char b, char c){
		return a==b && b==c &&  a != EMPTY_CHAR;
		
	}
	
	/*
	 * @Author Marcos Vinicius
	 * */
	public boolean validateGame(){
        return  validateHorizontal() && validateVertical() && validateDiagonal() && validateDiagonalReverse();
    }

    private boolean validateDiagonalReverse() {
        return  validateCombination(consoleBoard[0][2],consoleBoard[1][1],consoleBoard[2][0]);
    }

    private boolean validateDiagonal() {
        return validateCombination(consoleBoard[0][0],consoleBoard[1][1],consoleBoard[2][2]);
    }

    private boolean validateHorizontal() {
        for(int y = 0; y < 3; y++){
			if(validateCombination(consoleBoard[0][y],consoleBoard[1][y],consoleBoard[2][y])){
                return true;
			}
		}
        return false;
    }

    private boolean validateVertical() {
        for(int x = 0; x < 3; x++){
            if(validateCombination(consoleBoard[x][0],consoleBoard[x][1],consoleBoard[x][2])){
                return true;
            }
        }
        return false;
    }

    /*
     * @Author Marcos Vinicius
     * */
	public boolean isPositionEmpty(int x, int y){
		return isCharEmpty(consoleBoard[x][y]);
	}

	public boolean isCharEmpty(char value){
		return value == '\u0000';
	}
	
	/*
	 * @Author Marcos Vinicius
	 * */
	public boolean validatePosition(Position pos){
		return consoleBoard[pos.getX()][pos.getY()]==' ';
	}
	
	public boolean isArrayFull(){
		for (int x = 0; x < 3; x++) {
			for (int y = 0; y < 3; y++) {
				if(consoleBoard[x][y]==EMPTY_CHAR){
					return false;
				}
			}
		}
		return true;
	}


}

