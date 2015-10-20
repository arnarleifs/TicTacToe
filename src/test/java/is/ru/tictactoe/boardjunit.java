package is.ru.tictactoe;
import org.junit.Test;
import static org.junit.Assert.assertEquals;

public class boardjunit {
	@Test
	public void testInitializeBoard() {
		Board testBoard = new Board();
		boolean returnValue = testBoard.isInitialized();
		assertEquals(true, returnValue);
		System.out.println("testInitializeBoard passed!");
	}

	@Test
	public void testHasWonInDiagonal() {
		Board board = new Board();
		board.setNewCell(0,0,Seed.CIRCLE);
		board.setNewCell(1,1,Seed.CIRCLE);
		board.setNewCell(2,2,Seed.CIRCLE);
		boolean returnValue = board.hasWon(Seed.CIRCLE);
		assertEquals(true, returnValue);
	}

	@Test
	public void testHasWonInFirstRow() {
		Board board = new Board();
		board.setNewCell(0,0,Seed.CIRCLE);
		board.setNewCell(0,1,Seed.CIRCLE);
		board.setNewCell(0,2,Seed.CIRCLE);
		boolean returnValue = board.hasWon(Seed.CIRCLE);
		assertEquals(true, returnValue);
	}

	@Test
	public void testHasWonInSecondRow() {
		Board board = new Board();
		board.setNewCell(1,0,Seed.CIRCLE);
		board.setNewCell(1,1,Seed.CIRCLE);
		board.setNewCell(1,2,Seed.CIRCLE);
		boolean returnValue = board.hasWon(Seed.CIRCLE);
		assertEquals(true, returnValue);
	}

	@Test
	public void testHasWonInThirdRow() {
		Board board = new Board();
		board.setNewCell(2,0,Seed.CIRCLE);
		board.setNewCell(2,1,Seed.CIRCLE);
		board.setNewCell(2,2,Seed.CIRCLE);
		boolean returnValue = board.hasWon(Seed.CIRCLE);
		assertEquals(true, returnValue);
	}

	@Test
	public void testHasWonInFirstColumn() {
		Board board = new Board();
		board.setNewCell(0,0,Seed.CIRCLE);
		board.setNewCell(1,0,Seed.CIRCLE);
		board.setNewCell(2,0,Seed.CIRCLE);
		boolean returnValue = board.hasWon(Seed.CIRCLE);
		assertEquals(true, returnValue);
	}

	@Test
	public void testHasWonInSecondColumn() {
		Board board = new Board();
		board.setNewCell(0,1,Seed.CIRCLE);
		board.setNewCell(1,1,Seed.CIRCLE);
		board.setNewCell(2,1,Seed.CIRCLE);
		boolean returnValue = board.hasWon(Seed.CIRCLE);
		assertEquals(true, returnValue);
	}

	@Test
	public void testHasWonInThirdColumn() {
		Board board = new Board();
		board.setNewCell(0,2,Seed.CIRCLE);
		board.setNewCell(1,2,Seed.CIRCLE);
		board.setNewCell(2,2,Seed.CIRCLE);
		boolean returnValue = board.hasWon(Seed.CIRCLE);
		assertEquals(true, returnValue);
	}

	@Test
	public void testHasWonInOppositeDiagonal() {
		Board board = new Board();
		board.setNewCell(0,2,Seed.CIRCLE);
		board.setNewCell(1,1,Seed.CIRCLE);
		board.setNewCell(2,0,Seed.CIRCLE);
		boolean returnValue = board.hasWon(Seed.CIRCLE);
		assertEquals(true, returnValue);
	}

	@Test
	public void testIsDraw() {
		Board board = new Board();
		board.setNewCell(0,0,Seed.CIRCLE);
		board.setNewCell(0,1,Seed.CIRCLE);
		board.setNewCell(0,2,Seed.CROSS);
		board.setNewCell(1,0,Seed.CROSS);
		board.setNewCell(1,1,Seed.CROSS);
		board.setNewCell(1,2,Seed.CIRCLE);
		board.setNewCell(2,0,Seed.CIRCLE);
		board.setNewCell(2,1,Seed.CROSS);
		board.setNewCell(2,2,Seed.CIRCLE);

		boolean returnValue = board.isDraw();
		assertEquals(true, returnValue);
	}
}