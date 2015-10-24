package is.ru.tictactoe;
import org.junit.Test;
import static org.junit.Assert.assertEquals;

public class BoardIndexJUnit {
	@Test
	public void testCheckIndexWith100() {
		boolean returnValue = BoardIndex.checkIndex(100, 100);
		assertEquals(false, returnValue);
	}

	@Test
	public void testCheckIndexWith200() {
		boolean returnValue = BoardIndex.checkIndex(200, 200);
		assertEquals(false, returnValue);
	}

	@Test
	public void testCheckIndexWith300() {
		boolean returnValue = BoardIndex.checkIndex(300, 300);
		assertEquals(false, returnValue);
	}

	@Test
	public void testCheckOutOfRangeIndex() {
		boolean returnValue = BoardIndex.checkIndex(399, 300);
		assertEquals(false, returnValue);
	}

	@Test
	public void testCheckValidIndex() {
		boolean returnValue = BoardIndex.checkIndex(176, 56);
		assertEquals(true, returnValue);
	}
}