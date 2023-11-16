package test;
import org.junit.Test;
import static org.junit.Assert.*;
import main.TicTacToe;
public class TicTacToeTest {

    @Test
    public void testCheckWin() {
        TicTacToe game = new TicTacToe();
        game.makeMove(0, 0);
        game.makeMove(1, 0);
        game.makeMove(0, 1);
        game.makeMove(1, 1);
        game.makeMove(0, 2);
        assertTrue(game.checkWin());
    }

    @Test
    public void testReset() {
        TicTacToe game = new TicTacToe();
        game.makeMove(0, 0);
        game.makeMove(1, 1);
        game.reset();
        assertEquals('X', game.getCurrentPlayer());
        assertFalse(game.checkWin());
    }

    @Test
    public void testDraw() {
        TicTacToe game = new TicTacToe();
        game.makeMove(0, 0);
        game.makeMove(1, 0);
        game.makeMove(2, 0);
        game.makeMove(1, 1);
        game.makeMove(2, 1);
        game.makeMove(0, 1);
        game.makeMove(0, 2);
        game.makeMove(2, 2);
        game.makeMove(1, 2);
        assertTrue(game.isBoardFull());
        assertFalse(game.checkWin());
    }
}
