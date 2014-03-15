package chess;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.GridLayout;
import java.awt.Image;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.image.BufferedImage;
import java.io.File;

import javax.imageio.ImageIO;
import javax.swing.BoxLayout;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JPanel;

/**
 * Responsible for presenting the GUI, the user's actions, and updating the view
 * Implement a standard form of chess (White moves first, then black)
 * Only allow valid moves (i.e. isMoveValid())
 * changed
 */
@SuppressWarnings("serial")
public class ChessPanel extends JPanel {

	private ChessModel model;
	
	private JButton[][] boardButtons;
	private Image[][] boardImages;
	
	private JPanel top_panel, bottom_panel, grid;
	private JLabel message;
	//private JButton moveButton;
	
	private ButtonListener bl = new ButtonListener();

	// JUNK BOX of variables
	private int rows, cols;
	public int clickCount;
	public Move moving;
	private JLabel coordinates;
	
	// These are purely for visual purposes...
	public static final int QUEEN=0, KING=1, ROOK=2, KNIGHT=3, BISHOP=4, PAWN=5;
	public static final int BLK=0, WHT=1;
	public static final int[] MAIN_ROW = {ROOK, KNIGHT, BISHOP, KING, QUEEN, BISHOP, KNIGHT, ROOK};
	
	public ChessPanel() {
		
		//---------------------------------------------------------------//	
		// Creates a new ChessModel object                               //
		//---------------------------------------------------------------//
		model = ChessModel.getInstance();
		
		//---------------------------------------------------------------//	
		// Gets number of Rows and Columns from ChessModel               //
		//---------------------------------------------------------------//
		rows = model.numRows();
		cols = model.numColumns();
		
		//-----------------------------------------------------------------------------//	
		// Inst. array of chess board 'cells' and the array of icons used for the pieces
		//-----------------------------------------------------------------------------//	
		boardButtons = new JButton[rows][cols];
		boardImages = new Image[2][6];
		
		//-----------------------------------------------------------------------------//
		// Inst. bottom panel and adds "Move" button to it (depreciated)
		//-----------------------------------------------------------------------------//
		bottom_panel = new JPanel();
		bottom_panel.setPreferredSize(new Dimension(500, 100));
		//moveButton = new JButton("Move");
		//moveButton.addActionListener((ActionListener) bl);
		coordinates = new JLabel("Coordinates");
		bottom_panel.add(coordinates);
		
		//-----------------------------------------------------------------------------//
		// Inst. top panel and adds message label where messages can be displayed
		//-----------------------------------------------------------------------------//
		top_panel = new JPanel();
		message = new JLabel("This is a game of chess...that might work");
		top_panel.add(message);
		
		//-----------------------------------------------------------------------------//
		// Builds out all of the buttons (aka the chess board squares)
		//-----------------------------------------------------------------------------//
		grid = new JPanel(new GridLayout (rows, cols));
		for (int row = 0; row < 8; row++) {
			for (int col = 0; col < 8; col++) {
				// Create a new button
				boardButtons[row][col] = new JButton("");
				// Add an ActionListener to that button
				boardButtons[row][col].addActionListener(bl);
				// Add each button to the JPanel grid
				grid.add(boardButtons[row][col]);
				// Sets blank background image to each piece
				boardButtons[row][col].setIcon(new ImageIcon(new BufferedImage(64, 64, BufferedImage.TYPE_INT_ARGB)));
				// Then, sets background colors of buttons to black or white, as required by rules of chess **/
				if ( (row % 2 == 0 && col % 2 == 0) || (row % 2 == 1 && col % 2 ==1)) {
					boardButtons[row][col].setBackground(Color.white);
					boardButtons[row][col].setOpaque(true);
				}
				else {
					boardButtons[row][col].setBackground(Color.black);
					boardButtons[row][col].setOpaque(true);
				}
			}
		}
		
		//-----------------------------------------------------------------------------//
		// Builds boardImages[][] array (sprites)
		//-----------------------------------------------------------------------------//
		createImages();
		
		//-----------------------------------------------------------------------------//
		// Displays the chess board
		//-----------------------------------------------------------------------------//
		displayBoard();
		
		//-----------------------------------------------------------------------------//
		// incrementing int that counts the clicks from the actionListener //
		//-----------------------------------------------------------------------------//
		clickCount = 0;
		
		//-----------------------------------------------------------------------------//		
		// Adds everything above to the JFrame and styles it a tad
		//-----------------------------------------------------------------------------//
		add(top_panel);
		add(grid);
		add(bottom_panel);
		setLayout(new BoxLayout(this, BoxLayout.Y_AXIS));
	}

	//-----------------------------------------------------------------------------//
	// Displays the ChessBoard
	//-----------------------------------------------------------------------------//
	private void displayBoard() {		
		for (int ii = 0; ii < rows; ii++) {
			for (int jj = 0; jj < cols; jj++) {
				boardButtons[ii][jj].setIcon(new ImageIcon(boardImages[model.pieceAt(ii, jj).player().ordinal()][model.pieceAt(ii, jj).type().ordinal()]));
				
				// TODO Add if NULL exception?
			}
		}
	}
	
	//-----------------------------------------------------------------------------//
	// Creates the sprite images that will be used in displayBoard() for each button
	//-----------------------------------------------------------------------------//
	private void createImages() {
		// Loads and creates image for each piece from the "sprite"
		// Sprite's original location: http://i.stack.imgur.com/memIO.png
		try {
			BufferedImage bi = ImageIO.read(new File("src/chess/pieces.png"));
			for (int i=0; i < 2; i++) {
				for (int j=0; j < 6; j++) {
					boardImages[i][j] = bi.getSubimage(j * 64, i * 64, 64, 64);
				}
			}
		}
		catch (Exception e){			// ??
			e.printStackTrace();		// ??
			System.exit(1);				// close window on error?? what?
		}
	}
	
	
	
	
	
//	public static int getClickOne() {
//		int row;
//		int column;
//		return x, y;
//	}
//	public static int getClickTwo() {
//		re
//	}
	
	//-----------------------------------------------------------------------------//
	// ActionListener InnerClass
	//-----------------------------------------------------------------------------//
	private class ButtonListener implements ActionListener {
		public void actionPerformed(ActionEvent e) {
			// Loops through all the [rows,cols] of the ChessPiece[][] array 
			// and checks for an "action event"
			
			for (int i = 0; i < rows; i++) {
				for (int j = 0; j < cols; j++) {
					if (e.getSource() == boardButtons[i][j]) {
						
						if (clickCount == 0) {
							moving.setFromRow(i);
							moving.setFromColumn(j);
							clickCount++;
						}
						if (clickCount == 1) {
							moving.setToRow(i);
							moving.setToColumn(j);
							clickCount = 0;
							}
						}
					
						// Shows coordinates in message pane (TESTING)
						coordinates.setText("( " + i + "," + j + ")");	
					}
				}
			
			displayBoard();
		}
	}
}