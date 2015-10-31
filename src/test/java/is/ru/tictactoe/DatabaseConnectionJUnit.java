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

    @Test
    public void testGetFirstRowFromDatabase() {
        String winner = "";
        String query = "SELECT TOP 1 * FROM tictactoe.Scores ORDER BY ID ASC;";
        try {
            Connection connection = conn.getConnection();
            Statement statement = connection.createStatement();
            ResultSet rs = statement.executeQuery(query);
            // Loops through the result set given from the query above
            while (rs.next()) {
                winner = rs.getString("winner");
            }
        } catch (Exception ex) {
            assertEquals("NOT1337", winner);
        }
        assertEquals("X_WON", winner);
    }

    @Test
    public void testInsertToDatabase() {
        String resultString = "";
        String query = "SELECT TOP 1 * FROM tictactoe.Scores ORDER BY ID DESC";
        try {
            Connection connection = conn.getConnection();
            DBConnection.insertResultsToDb(Seed.CROSS, connection);
            Statement statement = connection.createStatement();
            ResultSet rs = statement.executeQuery(query);
            while (rs.next()) {
                resultString = rs.getString("winner");
            }
            // Clean up afterwards
            statement.executeUpdate("DELETE FROM tictactoe.Scores " +
                                    " WHERE ID=(SELECT MAX(ID) FROM tictactoe.Scores)");
        } catch (Exception ex) {
            assertEquals("NOT1337", resultString);
        }
        assertEquals("X_WON", resultString);
    }
}
