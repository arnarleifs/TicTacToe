package is.ru.tictactoe;
import org.junit.Test;
import static org.junit.Assert.assertEquals;

public class boardjunit {
	@Test
	public void testInitializeBoard() {
		Board testBoard = new Board();
		boolean returnValue = testBoard.isDraw();
		assertEquals(true, returnValue);
		System.out.println("testInitializeBoard passed!");
	}

	@Test
	public void testHasWon() {
		Board board = new Board();
		board.setNewCell(0,0,Seed.CIRCLE);
		board.setNewCell(1,1,Seed.CIRCLE);
		board.setNewCell(2,2,Seed.CIRCLE);
		boolean returnValue = board.hasWon(Seed.CIRCLE);
		assertEquals(true, returnValue);
		System.out.println("testHasWon passed!");
	}
}