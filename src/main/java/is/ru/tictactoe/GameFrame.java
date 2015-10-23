package is.ru.tictactoe;
import java.awt.*;
import java.awt.event.*;
import java.awt.geom.*;
import javax.swing.*;
import javax.swing.border.*;

@SuppressWarnings("serial")
public class GameFrame extends JFrame {
	// Constants for determining the size of the frame and components
	private Dimension sizeOfFrame = new Dimension(600, 600);
	private Dimension sizeOfPanel = new Dimension(300, 300);
	private final String TITLE = "Tic 'n toe!";
	private GamePanel panel;

	public GameFrame() {
		panel = new GamePanel();
		panel.setPreferredSize(sizeOfPanel);
		panel.setBorder(new TitledBorder(new LineBorder(Color.black, 5),
        "TicTacToe!"));
		panel.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) { 
				// Check if clicked in a valid cell

				System.out.println("X: " + e.getX());
				System.out.println("Y: " + e.getY());
				System.out.println("---------------");
				repaint();
			}
		});
		this.add(panel);
		this.setSize(sizeOfFrame);
		this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		this.setTitle(TITLE);
		this.setVisible(true);

		// Container for the layout of the screen
		Container container = this.getContentPane();
		container.setLayout(new BorderLayout());
		container.add(panel, BorderLayout.CENTER);
	} 

	public class GamePanel extends JPanel {
		private int x = -50;
		private int y = -50;
		@Override
		public void paintComponent(Graphics g) {
			Graphics2D g2d = (Graphics2D) g;
		}
	}

	public static void main(String[] args) {
		GameFrame game = new GameFrame();
	}
}