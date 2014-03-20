package chess;

/*--------------------------------------------------------------------*
* ChessPanel.java                             		             	  *
*---------------------------------------------------------------------*
* Description - A class responsible for presenting the GUI, the       *
* user's actions, and updating the view Implement a standard form of  *
* chess (White moves first, then black) Only allow valid moves 		  *
* (i.e. isMoveValid()) changed.				      					  *
*---------------------------------------------------------------------*
* Project: Project 3 : Chess 	                                      *
* Author : McKim A. Jacob, Vonehr Kurt, Aernouts Kenneth	          *
* Date Of Creation: 3 - 1 - 2014                                      *                          
*---------------------------------------------------------------------*/

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
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;

@SuppressWarnings("serial")
public class ChessPanel extends JPanel {
	
	//---------------------------------------------------------------//	
	// Class Variable Definitions                                    //
	//---------------------------------------------------------------//

	/* The model used to control the game. */
	private ChessModel model;

	/* The array of buttons used to interface the user. */
	private JButton[][] boardButtons;

	/* THe image array for all the buttons on the board. */
	private Image[][] boardImages;

	/* The top panel for the title. */
	private JPanel top_panel;

	/* The bottom pane for game alert messages. */
	private JPanel bottom_panel;

	/* The grid of buttons for the chess game. */
	private JPanel grid;

	/* The message to be displayed. */
	private JLabel message;

	/* The label displaying game information. */
	private JLabel coordinates;

	/* The label displaying who's turn it is. */
	private JLabel turn;
	
	/* The button listener for all the chess buttons. */
	private ButtonListener bl = new ButtonListener();
		
	/* The number of rows in the game grid. */
	private int rows;
	
	/* The number of columns in the game grid. */
	private int cols;
	
	/* The total number of clicks counted by the user. */
	public int clickCount;
	
	/* A pre-defined move. */
	public Move moving;
	
	/* A pre-defined move. */
	public Move rev;
	
	//---------------------------------------------------------------//	
	// Sub Class Definitions                                         //
	//---------------------------------------------------------------//	
	
	private class ButtonListener implements ActionListener {
		
		// ==== Class Variable Definitions ========================= //
		
		/* Total number of clicks counted. */
		int clickCount = 0;
		
		/* A temporary chess piece object holder. */
		IChessPiece tmp;
		
		// ==== Implemented Abstract Methods ======================= //
		
		public void actionPerformed(ActionEvent e) {
			
			// Loop though grid and find the button.
			for (int i = 0; i < rows; i++) {
				
				for (int j = 0; j < cols; j++) {
					
					// Check and see if this is the triggered button.
					if (e.getSource() == boardButtons[i][j]) {
						
						// Determine which click it is.
						if (clickCount == 0) 
						{	
							moving.setFromRow(i);
							moving.setFromColumn(j);
							clickCount += 1;
							coordinates.setText("Piece selected");	
						}
						
						else if (clickCount == 1) 
						{
							
							// Attempt the move.
							moving.setToRow(i);
							moving.setToColumn(j);
							
							// Check if its a valid move.
							if (model.isValidMove(moving) &&  
												  !model.isComplete())
							{
								tmp = model.pieceAt(i,j);
								model.move(moving);
								
								// check if the current player in check.
								if(!(model.inCheck (
										model.currentPlayer() ) ) ) {
									
									// Go to next turn.
									model.nextTurn();
									
									//check if other player in check.
									if (model.inCheck(model.
													currentPlayer() ) )
									   coordinates.setText("In Check");
									
									if( model.isComplete() )
									JOptionPane.showMessageDialog( 
										(JFrame) ChessPanel.this.
										getRootPane().getParent(), 
										model.currentPlayer() + 
										" your king is in check mate.",
										"Game over!", 
										JOptionPane.PLAIN_MESSAGE);
								}
								
								else
								{
									//reverse the move from happening.
									rev.setFromColumn(moving.toColumn);
									rev.setToColumn(moving.fromColumn);
									rev.setFromRow(moving.toRow);
									rev.setToRow(moving.fromRow);
									model.move(rev);
									
									// Replace piece set to null.
									model.setBoardPiece(tmp, 
										  rev.fromRow, rev.fromColumn);
			
									// Reset the click count.
									clickCount = 0;
									
									if (model.inCheck( model.
													currentPlayer() ) )
									{
										JOptionPane.showMessageDialog( 
										(JFrame) ChessPanel.this.
										getRootPane().getParent(),
										model.currentPlayer() + 
										" player Your king is in check.",
										"Oh no your in trouble...", 
										JOptionPane.PLAIN_MESSAGE);
									}
								}
							}
							
							else
								coordinates.setText("That move is not valid");
							
							// Reset the click count.
							clickCount = 0;
							
						}
					}
				}
			}

			// Update the board.
			displayBoard();
			
		}
	}

	//---------------------------------------------------------------//	
	// Class Constructors                                            //
	//---------------------------------------------------------------//	

	public ChessPanel() {
		
		// === Generate Defaults for objects.  ====================== //
		
		// Create a new game board controller.
		model = new ChessModel();
		
		// Configure move objects.
		moving = new Move(0, 0, 0, 0);
		rev = new Move(0,0,0,0);
		
		// Get number of rows and columns of objects.
		rows = model.numRows();
		cols = model.numColumns();
		
		// === Build the panel.  =================================== //
		
		// Construct game array with images.
		boardButtons = new JButton[rows][cols];
		boardImages = new Image[2][6];
		
		// Construct the bottom panel.
		bottom_panel = new JPanel();
		bottom_panel.setPreferredSize(new Dimension(500, 100));
		
		// Add the coordinates label.
		coordinates = new JLabel("");
		bottom_panel.add(coordinates);

		// Add the turn label.
		turn = new JLabel("");
		bottom_panel.add(turn);

		// Build the top panel.
		top_panel = new JPanel();
		message = new JLabel("2 Player Chess");
		top_panel.add(message);

		// Construct the grid of buttons.
		grid = new JPanel(new GridLayout (rows, cols));
		
		// Loop through and add them in.
		for (int row = 0; row < 8; row++) {
			
			for (int col = 0; col < 8; col++) {
				
				// Creates a new button.
				boardButtons[row][col] = new JButton("");
				
				// Adds an ActionListener to that button.
				boardButtons[row][col].addActionListener(bl);
				
				// Adds each button to the JPanel grid.
				grid.add(boardButtons[row][col]);
				
				// Set the background colors of images.
				if ( (row % 2 == 0 && col % 2 == 0) || (row % 2 == 1 &&
														col % 2 ==1))
				{
					boardButtons[row][col].setBackground(Color.white);
					boardButtons[row][col].setOpaque(true);
					boardButtons[row][col].setBorderPainted(false);
				}
				
				else 
				{
					boardButtons[row][col].setBackground(Color.black);
					boardButtons[row][col].setOpaque(true);
					boardButtons[row][col].setBorderPainted(false);
				}
			}
		}
		
		// === Final Configurations.  ============================== //
		
		// Fill in the button images.
		createImages();
		
		// Display the board.
		displayBoard();
		
		// Set the action listener increment to zero.
		clickCount = 0;
		
		// === Add all elements to jFrame.  ======================== //

		add(top_panel);
		add(grid);
		add(bottom_panel);
		setLayout(new BoxLayout(this, BoxLayout.Y_AXIS));
		
	}
	
	//--------------------------------------------------------------//	
	// Function Definitions					     					//
	//--------------------------------------------------------------// 

	
    /****************************************************************
    * This method is invoked to update and display the game board on 
    * screen.
    *
    * @return None
    * 
    *****************************************************************/
	private void displayBoard() {
		
		// --- Variable Declarations  -------------------------//
		
		/* The x coordinate on the board. */
		int p = 0;
		
		/* The y coordinate on the board. */
		int t = 0;
		
		// --- Main Routine -----------------------------------//
		
		// Loop through each button.
		for (int i = 0; i < rows; i++) {
			
			for (int j = 0; j < cols; j++) {
				
				// Check if there's piece at a given point on board.
				if (model.pieceAt(i, j) == null)
					boardButtons[i][j].setIcon(new ImageIcon (new 
								   BufferedImage(64, 64, BufferedImage.
													TYPE_INT_ARGB) ) );
				else 
				{
					p = model.pieceAt(i, j).player().ordinal();
					t = model.pieceAt(i, j).type().ordinal();
					boardButtons[i][j].setIcon(new 
									ImageIcon( boardImages[p][t] ) );
				}
			}
		}
		
		// Set who's turn it currently is.
		turn.setText("Turn: " + model.currentPlayer());
		
	}
	
	
    /****************************************************************
    * This method is used to create the sprite images that will be 
    * used in displayBoard() for each button.
    *
    * @return None
    * 
    ******************************************************************/
	private void createImages() {
		
		/* The image buffer object used to create the icons. */
		BufferedImage bi;
		
		/* The y position in the button array. */
		int i;
		
		/* The y position in the button array. */
		int j;
		
		// --- Main Routine -----------------------------------//

		/* NOTE: Sprite's original location:
		 *  http://i.stack.imgur.com/memIO.png
		 */
		
		// Attempt to load the sprite from the file. 
		try {
			
			// Locate the and open the image buffer.
			bi = ImageIO.read(new File("src/chess/pieces.png"));
			
			// Loop through and add the images.
			for (i=0; i < 2; i++) {
				
				for (j=0; j < 6; j++)
					boardImages[i][j] = bi.getSubimage (j * 64, i * 64,
															   64, 64);
				
			}
			
		}
		
		// Crash the program otherwise.
		catch (Exception e) {		
			
			System.exit(1);	
			
		}
		
	}
	
	
	//--------------------------------------------------------------// 

}
	
