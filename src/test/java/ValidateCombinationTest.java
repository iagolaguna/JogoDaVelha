import br.com.mvil.Board;
import br.com.mvil.dto.BoardDTO;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.mockito.Mock;
import static org.mockito.Matchers.anyInt;
import static org.mockito.Mockito.*;
import org.mockito.MockitoAnnotations;

/**
 * Created by iago.laguna on 26/09/2016.
 */

public class ValidateCombinationTest {
    @Mock
    Board board;

    @Before
    public void init(){
        MockitoAnnotations.initMocks(this);
    }

    @Test
    public void validateDiagonalCorrectTest(){
        BoardDTO boardVertical = new BoardDTO();
        boardVertical.setPosition(0,0,'X');
        boardVertical.setPosition(1,1,'X');
        boardVertical.setPosition(2,2,'X');
        board = new Board(boardVertical);
        System.out.println("validateDiagonalCorrectTest");
        System.out.println("-------------------------------------------------------");
        board.showBoard();
        Assert.assertEquals("Its correct why a set the same brand for all diagonal ",true, board.validateGame());
    }
    @Test
    public void validateDiagonalIncorrectTest(){
        BoardDTO boardVertical = new BoardDTO();
        boardVertical.setPosition(0,0,'O');
        boardVertical.setPosition(1,1,'X');
        boardVertical.setPosition(2,2,'X');
        board = new Board(boardVertical);
        System.out.println("validateDiagonalCorrectTest");
        System.out.println("-------------------------------------------------------");
        board.showBoard();
        Assert.assertEquals("can't be true why this diagonal don't contain all brands equals",false, board.validateGame());
    }


    @Test
    public void validateDiagonalReverseCorrectTest(){
        BoardDTO boardVertical = new BoardDTO();
        boardVertical.setPosition(0,2,'X');
        boardVertical.setPosition(1,1,'X');
        boardVertical.setPosition(2,0,'X');
        board = new Board(boardVertical);
        System.out.println("validateDiagonalCorrectTest");
        System.out.println("-------------------------------------------------------");
        board.showBoard();
        Assert.assertEquals("Its correct why a set the same brand for all diagonal reverse",true, board.validateGame());
    }
    @Test
    public void validateDiagonalReverseIncorrectTest(){
        BoardDTO boardVertical = new BoardDTO();
        boardVertical.setPosition(0,2,'X');
        boardVertical.setPosition(1,1,'O');
        boardVertical.setPosition(2,0,'X');
        board = new Board(boardVertical);
        System.out.println("validateDiagonalCorrectTest");
        System.out.println("-------------------------------------------------------");
        board.showBoard();
        Assert.assertEquals("can't be true why this diagonal don't contain all brands equals",false, board.validateGame());
    }

    @Test
    public void validateVerticalIncorrectTest(){
        BoardDTO boardVertical = new BoardDTO();
        boardVertical.setPosition(0,0,'X');
        boardVertical.setPosition(0,1,'O');
        boardVertical.setPosition(0,2,'X');
        board = new Board(boardVertical);
        System.out.println("validateDiagonalCorrectTest");
        System.out.println("-------------------------------------------------------");
        board.showBoard();
        Assert.assertEquals("can't be true why this vertical don't contain all brands equals",false, board.validateGame());
    }

    @Test
    public void validateVerticalCorrectTest(){
        BoardDTO boardVertical = new BoardDTO();
        boardVertical.setPosition(0,0,'X');
        boardVertical.setPosition(0,1,'X');
        boardVertical.setPosition(0,2,'X');
        board = new Board(boardVertical);
        System.out.println("validateDiagonalCorrectTest");
        System.out.println("-------------------------------------------------------");
        board.showBoard();
        Assert.assertEquals("Its correct why a set the same brand for all diagonal reverse",true, board.validateGame());
    }

}
