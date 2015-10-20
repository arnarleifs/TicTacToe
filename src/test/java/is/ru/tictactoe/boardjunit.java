package is.ru.tictactoe;
import org.junit.Test;
import static org.junit.Assert.assertEquals;

public class boardjunit {
	private Board board = new Board();

	@Test
	public void testInitializeBoard() {
		boolean returnValue = board.isInitialized();
		assertEquals(true, returnValue);
		System.out.println("testInitializeBoard passed!");
	}
}