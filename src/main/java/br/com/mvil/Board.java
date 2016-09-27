package br.com.mvil;

import br.com.mvil.dto.BoardDTO;
import br.com.mvil.dto.Position;

/**
 * @Author Marcos Vinicius
 */

public class Board {

    private BoardDTO boardDTO;

    public Board(){
        this.boardDTO = new BoardDTO();
    }
    public Board(BoardDTO boardDTO){
        this.boardDTO = boardDTO;
    }

	/*
	 * @Author Marcos Vinicius
	 * */
	public void showBoard() {
		System.out.println();
		for (int x = 0; x < 3; x++) {
			for (int y = 0; y < 3; y++) {
				
				if (boardDTO.isPositionEmpty(x, y)) {
                    boardDTO.setPosition(x, y, BoardDTO.CHAR_WITH_SPACE);
				}
				System.out.print("    " + boardDTO.getPosition(x, y) + "     ");
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
	void setValue(Position pos, char brandValue){
        boardDTO.setPosition(pos.getX(),pos.getY(),brandValue);
	}

	/*
	 * @Author Marcos Vinicius
	 * */
	private boolean validateCombination(char a, char b, char c){
		return a==b && b==c &&  a != BoardDTO.CHAR_WITH_SPACE;
		
	}
	 /*
	 * @Author Marcos Vinicius
	 * */
	public boolean validateGame(){

		for(int x=0;x<3;x++){
			if(validateCombination(boardDTO.getPosition(x,0),boardDTO.getPosition(x,1),boardDTO.getPosition(x,2))){
				return true;
			}
			if(validateCombination(boardDTO.getPosition(0,x),boardDTO.getPosition(1,x),boardDTO.getPosition(2,x))){
				return true;
			}
		}

		if(validateCombination(boardDTO.getPosition(0,0),boardDTO.getPosition(1,1),boardDTO.getPosition(2,2))){
			return true;
		}

		return validateCombination(boardDTO.getPosition(0, 2), boardDTO.getPosition(1, 1), boardDTO.getPosition(2, 0));

	}

	/*
	 * @Author Marcos Vinicius
	 * */
	boolean validatePosition(Position pos){
		return boardDTO.getPosition(pos.getX(), pos.getY()) == BoardDTO.CHAR_WITH_SPACE
                || boardDTO.getPosition(pos.getX(), pos.getY()) == BoardDTO.CHAR_NULL;
	}
	
	boolean isArrayFull(){
		for (int x = 0; x < 3; x++) {
			for (int y = 0; y < 3; y++) {
				if(boardDTO.getPosition(x, y) == BoardDTO.CHAR_WITH_SPACE){
					return false;
				}
			}
		}
		return true;
	}


}

