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

/*--------------------------------------------------------------------*
* ChessGUI.java                             		                  *
*---------------------------------------------------------------------*
* Description: Presents the GUI, listens and reacts to user interaction
* with the chess board. Checks for valid moves, moves the pieces,
* finds the next player, and announces game status to the user
*---------------------------------------------------------------------*
* Project: Project 3 : Chess Game	                                  *
* Author : Kenneth Aernouts 										  *
* Group : McKim A. Jacob, Vonehr Kurt, Aernouts Kenneth				  *
* Date: 3/13/2014-3/20/14	                                          *
*---------------------------------------------------------------------*
* ISSUES AND NOTES						                              *	                                      
*---------------------------------------------------------------------*                            
* 
*---------------------------------------------------------------------*/

@SuppressWarnings("serial")
public class ChessPanel extends JPanel {
	private ChessModel model;
	private JButton[][] boardButtons;
	private Image[][] boardImages;	
	private JPanel top_panel, bottom_panel, grid;
	private JLabel message, gameStatus, turn;
	private ButtonListener bl = new ButtonListener();
	private int rows, cols;
	private Move moving;
	//---------------------------------------------------------------//
	// Constructor - creates a new model, builds the panels
	//---------------------------------------------------------------//	
	public ChessPanel() {
		
		//---------------------------------------------------------------//	
		// Creates a new ChessModel object                               //
		//---------------------------------------------------------------//
		model = new ChessModel();
		
		moving = new Move(0, 0, 0, 0);
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
		// Inst. bottom panel with String coordinates output
		//-----------------------------------------------------------------------------//
		bottom_panel = new JPanel();
		bottom_panel.setPreferredSize(new Dimension(500,50));
		gameStatus = new JLabel("");
		turn = new JLabel("");
		bottom_panel.add(turn);
		bottom_panel.add(gameStatus);

		//-----------------------------------------------------------------------------//
		// Inst. top panel and adds message label where messages can be displayed
		//-----------------------------------------------------------------------------//
		top_panel = new JPanel();
		message = new JLabel("A Fabulous Chess Game by Ken, Kurt, and Jake");
		top_panel.add(message);
		
		//-----------------------------------------------------------------------------//
		// Builds out all of the buttons (aka the chess board squares)
		//-----------------------------------------------------------------------------//
		grid = new JPanel(new GridLayout (rows, cols));
		for (int row = 0; row < 8; row++) {
			for (int col = 0; col < 8; col++) {
				// Creates a new button
				boardButtons[row][col] = new JButton("");
				// Adds an ActionListener to that button
				boardButtons[row][col].addActionListener(bl);
				// Adds each button to the JPanel grid
				grid.add(boardButtons[row][col]);
				// Sets blank image to each piece
				//boardButtons[row][col].setIcon(new ImageIcon(new BufferedImage(64, 64, BufferedImage.TYPE_INT_ARGB)));
				// Then, sets background colors of buttons to black or white, as required by rules of chess **/
				if ( (row % 2 == 0 && col % 2 == 0) || (row % 2 == 1 && col % 2 ==1)) {
					boardButtons[row][col].setBackground(Color.white);
					boardButtons[row][col].setOpaque(true);
					boardButtons[row][col].setBorderPainted(false);
				}
				else {
					boardButtons[row][col].setBackground(Color.black);
					boardButtons[row][col].setOpaque(true);
					boardButtons[row][col].setBorderPainted(false);
					
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
		
//		//-----------------------------------------------------------------------------//
//		// incrementing int that counts the clicks from the actionListener //
//		//-----------------------------------------------------------------------------//
//		clickCount = 0;
//		
		//-----------------------------------------------------------------------------//		
		// Adds everything above to the JFrame and sets the layout
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
		for (int i = 0; i < rows; i++) {
			for (int j = 0; j < cols; j++) {
				
				int p = 0;
				int t = 0;
				
				if (model.pieceAt(i, j) == null)
					boardButtons[i][j].setIcon(new ImageIcon(new BufferedImage(64, 64, BufferedImage.TYPE_INT_ARGB)));
					//boardButtons[i][j].setIcon(new ImageIcon(boardImages[p][t]));
				else {
					p = model.pieceAt(i, j).player().ordinal();
					t = model.pieceAt(i, j).type().ordinal();
//					if(t == 5)
//						t = 4;
//					else if(t == 3)
//						t = 5;
//					else if(t ==  4)
//						t = 3;
					boardButtons[i][j].setIcon(new ImageIcon(boardImages[p][t]));
				}
				
				
			}
		}
		turn.setText("Turn: " + model.currentPlayer());
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
	
	//-----------------------------------------------------------------------------//
	// ActionListener InnerClass
	//-----------------------------------------------------------------------------//
	private class ButtonListener implements ActionListener {
		int clickCount = 0;
		public void actionPerformed(ActionEvent e) {
			// Loops through all the [rows,cols] of the ChessPiece[][] array for ActionEvent
			for (int i = 0; i < rows; i++) {
				for (int j = 0; j < cols; j++) {
					if (e.getSource() == boardButtons[i][j]) {
						//--------------------------------------------//
						// Uses a click counter to determine if the
						// player has selected the piece to be moved
						// or where they would like to move the piece.
						//--------------------------------------------//
						if (clickCount == 0) {
							//--------------------------------------------//
							// Sets the beginning coordinates of the move
							// from the piece's current position.
							//--------------------------------------------//
							moving.setFromRow(i);
							moving.setFromColumn(j);
							//--------------------------------------------//
							// Increments the click counter and resets
							// the bottom JPanel message to show that a
							// piece has been selected.
							//--------------------------------------------//
							clickCount += 1;
							gameStatus.setText("Piece selected");
							//--------------------------------------------//
							// Gives selected button a red (or whatever)
							// color and re displays the chess board
							//--------------------------------------------//
							boardButtons[i][j].setBackground(Color.red);
							displayBoard();
							//--------------------------------------------//
						}
						else if (clickCount == 1) {
							//--------------------------------------------//
							// Checks the click counter to make sure this
							// is the user's second click and sets the
							// Move objects "to" coordinates.
							//--------------------------------------------//
							moving.setToRow(i);
							moving.setToColumn(j);
							//--------------------------------------------//
							// Checks if the Move is allowed and not in check.
							//--------------------------------------------//
							if (model.isValidMove(moving) && !model.inCheck(model.currentPlayer())) {
								// Executes the move method and sets the message to the player.
								model.move(moving);
								//--------------------------------------------//
								// Resets the background color of the chess
								// board, after a player has completed a move.
								//--------------------------------------------//
								if (model.currentPlayer() == Player.BLACK) {
									boardButtons[i][j].setBackground(Color.black);
								}
								else
									boardButtons[i][j].setBackground(Color.white);
								model.nextTurn();
								if (model.inCheck(model.currentPlayer()))
									gameStatus.setText("In Check");
							}
							else
								gameStatus.setText("Sorry, That move is not valid.");
							//--------------------------------------------//
							// Resets the click counter
							//--------------------------------------------//
							clickCount = 0;
						}
					}
				}
			}
			//--------------------------------------------//
			// Re-displays the board (reset, shows nxt player)
			//--------------------------------------------//
			displayBoard();
		}
	}
}
