package is.ru.tictactoe;
import java.awt.*;
import java.awt.event.*;
import java.awt.image.*;
import java.awt.geom.*;
import javax.swing.*;
import javax.swing.border.*;

@SuppressWarnings("serial")
public class GameFrame extends JFrame {
    // Constants for determining the size of the frame and components
    private final String TITLE = "Tic 'n toe!";
    private GamePanel panel = new GamePanel();
    private BorderPanel border = new BorderPanel();
    private Board board = new Board();
    private Container pane;

    private void initializeFrame() {
        pane = this.getContentPane();
        pane.setLayout(new BorderLayout());
        JLabel label = new JLabel("Tic tac toe!", JLabel.CENTER);
        label.setFont(new Font("Courier", Font.BOLD, 36));
        label.setBorder(BorderFactory.createBevelBorder(BevelBorder.RAISED));
        pane.add(label, BorderLayout.NORTH);
    }

    private void drawSeed(BoardIndex idx, Seed mark) {
        if(board.isEmpty(idx.getRowIndex(), idx.getColIndex())) {
            board.setNewCell(idx.getRowIndex(), idx.getColIndex(), mark);
        }
    }

    public GameFrame() {
        initializeFrame();
        JButton button = new JButton("New game");
        button.setBounds(300, 500, 100, 50);
        button.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                // Initialize board
                board = new Board();
                repaint();
            }
        });
        panel.add(button);
        border.setBorder(new LineBorder(Color.black, 2));
        border.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseClicked(MouseEvent e) {
                // Check if clicked in a valid cell
                if (BoardIndex.checkIndex(e.getX(), e.getY()) && board.getGameStatus() == Status.ONGOING) {
                    BoardIndex idx = new BoardIndex(e.getX(), e.getY());
                    Seed turn = board.whichTurn();
                    if (turn == Seed.CROSS) {
                        drawSeed(idx, turn);
                    } else if (turn == Seed.CIRCLE) {
                        drawSeed(idx, turn);
                    }
                    // Check if game is finished
                    if (board.hasWon(Seed.CROSS)) {
                        JLabel label = new JLabel("X won!", JLabel.CENTER);
                        label.setFont(new Font("Courier", Font.BOLD, 36));
                        label.setBorder(BorderFactory.createBevelBorder(BevelBorder.RAISED));
                        panel.add(label, BorderLayout.SOUTH); 
                    } else if (board.hasWon(Seed.CIRCLE)) {
                        JLabel label = new JLabel("Circle won!", JLabel.CENTER);
                        label.setFont(new Font("Courier", Font.BOLD, 36));
                        label.setBorder(BorderFactory.createBevelBorder(BevelBorder.RAISED));
                        pane.add(label, BorderLayout.SOUTH); 
                    } else if (board.isDraw()) {
                        JLabel label = new JLabel("Draw :(", JLabel.CENTER);
                        label.setFont(new Font("Courier", Font.BOLD, 36));
                        label.setBorder(BorderFactory.createBevelBorder(BevelBorder.RAISED));
                        pane.add(label, BorderLayout.SOUTH);
                    }
                    repaint();
                }
            }
        });
        panel.add(border, BorderLayout.CENTER);
        this.add(panel);
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        this.setTitle(TITLE);
        this.setVisible(true);
        this.pack();
    } 

    // Panel which holds the entire game screen
    public class GamePanel extends JPanel {
        @Override
        public Dimension getPreferredSize() {
            return new Dimension(400, 500);
        }
    }

    // Panel which holds only the tictactoe gameboard
    public class BorderPanel extends JPanel {

        private void drawLines(Graphics2D g2d) {
            g2d.drawLine(100, 0, 100, 300);
            g2d.drawLine(200, 0, 200, 300);
            g2d.drawLine(0, 100, 300, 100);
            g2d.drawLine(0, 200, 300, 200);
        }
        @Override
        public void paintComponent(Graphics g) {
            Graphics2D g2d = (Graphics2D) g;
            g2d.setColor(Color.BLUE);
            drawLines(g2d);
            // Check the board to see which are noted and draw it considering which Seed it holds
            int x1 = 0, y1 = 0, x2 = 100, y2 = 100;
            for (int i = 0; i < 3; i++) {
                for (int j = 0; j < 3; j++) {
                    if (board.getSeedFromPosition(i, j) == Seed.CROSS) {
                        g2d.setColor(Color.RED);
                        g2d.setStroke(new BasicStroke(3));
                        g2d.drawLine(x1, y1, x2, y2);
                        g2d.drawLine(x2, y1, x1, y2);
                    } else if (board.getSeedFromPosition(i, j) == Seed.CIRCLE) {
                        g2d.setColor(Color.GREEN);
                        g2d.setStroke(new BasicStroke(3));
                        g2d.drawOval(x1, y1, 100, 100);
                    }
                    x1 = x2;
                    x2 += 100;
                }
                y1 = y2;
                y2 += 100;
                x1 = 0;
                x2 = 100;
            }

        }

        @Override
        public Dimension getPreferredSize() {
            return new Dimension(300, 300);
        }
    }

    public static void main(String[] args) {
        GameFrame game = new GameFrame();
    }
}