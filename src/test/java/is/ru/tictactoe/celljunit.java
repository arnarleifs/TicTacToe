package is.ru.tictactoe;
import org.junit.Test;
import static org.junit.Assert.assertEquals;

public class celljunit {
	private Cell cell = new Cell(0,0, Seed.CROSS);

	@Test
	public void testSetEmptyForCell() {
		cell.empty();
		boolean returnValue = cell.isEmpty();
		assertEquals(true, returnValue);
		System.out.println("testSetEmptyForCell passed!");
	}

	@Test
	public void testMarkForCell() {
		cell.setMark(Seed.CIRCLE);
		boolean returnValue = cell.checkMark(Seed.CIRCLE);
		assertEquals(true, returnValue);
		System.out.println("testMarkForCell passed!");
	}
}
