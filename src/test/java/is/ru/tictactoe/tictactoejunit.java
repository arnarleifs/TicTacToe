package is.ru.tictactoe;
import org.junit.Test;
import static org.junit.Assert.assertEquals;

public class tictactoejunit {
	private Cell cell = new Cell(0,0, Seed.CROSS);

	@Test
	public void testSetEmptyForCell() {
		cell.empty();
		boolean returnValue = cell.isEmpty();
		assertEquals(true, returnValue);
		System.out.println("testSetEmptyForCell passed!");
	}
}