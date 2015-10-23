package is.ru.tictactoe;
import java.awt.*;
import java.awt.event.*;
import java.awt.geom.*;
import javax.swing.*;

@SuppressWarnings("serial")
public class GameFrame extends JFrame {
	// Constants for determining the size of the frame and components
	private Dimension sizeOfFrame = new Dimension(600, 600);
	private Dimension sizeOfPanel = new Dimension(300, 300);
	private final String TITLE = "Tic 'n toe!";
	private GamePanel panel;

	public GameFrame() {
		panel = new GamePanel();
		this.add(panel);
		panel.setPreferredSize(sizeOfPanel);
		panel.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				System.out.println("X: " + e.getX());
				System.out.println("Y: " + e.getY());
				System.out.println("---------------");
			}
		});
		this.setSize(sizeOfFrame);
		this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		this.setTitle(TITLE);
		this.setVisible(true);

		Container container = this.getContentPane();
		container.setLayout(new BorderLayout());
		container.add(panel, BorderLayout.CENTER);
	} 

	public class GamePanel extends JPanel {
		@Override
		public void paintComponent(Graphics g) {
			Graphics2D g2d = (Graphics2D) g;
			g2d.setColor(Color.RED);
			g2d.drawRect(0, 0, 20, 20);
		}
	}

	public static void main(String[] args) {
		GameFrame game = new GameFrame();
	}
}