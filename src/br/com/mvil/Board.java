package br.com.mvil;

/**
 * @Author Marcos Vinicius
 */

public class Board {

	private char[][] consoleBoard = new char[3][3];


	/*
	 * @Author Marcos Vinicius
	 * */
	public void showBoard() {
		System.out.println();
		for (int i = 0; i < 3; i++) {
			for (int i2 = 0; i2 < 3; i2++) {
				
				if (isPositionEmpty(i, i2)) {
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

	
	/*
	 * @Author Marcos Vinicius
	 * */
	public void setValue(int x,int y, char v){
		x-=1;
		y-=1;
		consoleBoard[x][y] = v;
	}
	
	
	/*
	 * @Author Marcos Vinicius
	 * */
	private boolean validateCombination(char a, char b, char c){
		return a==b && b==c &&  a !=' ' ;
		
	}
	
	/*
	 * @Author Marcos Vinicius
	 * */
	public boolean validateGame(){

		for(int x=0;x<3;x++){
			if(validateCombination(consoleBoard[x][0],consoleBoard[x][1],consoleBoard[x][2])){
				return true;
			} 
		}
		
		for(int y=0;y<3;y++){
			if(validateCombination(consoleBoard[0][y],consoleBoard[1][y],consoleBoard[2][y])){
				return true;
			}
		}
		
		if(validateCombination(consoleBoard[0][0],consoleBoard[1][1],consoleBoard[2][2])){
			return true;
		}
		
		if(validateCombination(consoleBoard[0][2],consoleBoard[1][1],consoleBoard[2][0])){
			return true;
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
	public boolean validatePosition(int x,int y){
		return consoleBoard[x][y]==' ';
	}
	
	 
}
