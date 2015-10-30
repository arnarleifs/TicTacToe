package is.ru.tictactoe;
import java.sql.*;
import org.junit.Test;
import static org.junit.Assert.assertEquals;

public class DatabaseConnectionJUnit {
	private DBConnection conn = new DBConnection();

	@Test
	public void testDatabaseConnection() {
		int returnValue = 1;
		try {
			Connection connection = conn.getConnection();
		} catch (SQLException ex) {
			assertEquals(0, returnValue);
		} catch (ClassNotFoundException cex) {
			assertEquals(0, returnValue);
		}
		assertEquals(1, returnValue);
	}
}