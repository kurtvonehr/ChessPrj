package chess;

/*--------------------------------------------------------------------*
* ChessModel.java                             		             	  *
*---------------------------------------------------------------------*
* Description - A class used to control all game logic of the game of *
* chess during the users interactions with the game. This class can   *
* only be initialized once.					      					  *
*---------------------------------------------------------------------*
* Project: Project 3 : Chess 	                                      *
* Author : McKim A. Jacob, Vonehr Kurt, Aernouts Kenneth	          *
* Date Of Creation: 3 - 1 - 2014                                      *
*---------------------------------------------------------------------*
* ISSUES AND NOTES						      						  *	                                      
*---------------------------------------------------------------------*
* 
*                                 
*                                 
*---------------------------------------------------------------------*/

public class ChessModel implements IChessModel {

	//---------------------------------------------------------------//	
	// Class Variable Definitions                                    //
	//---------------------------------------------------------------//

  	/* The one instance of this class that exists. */
  	private static ChessModel instance;
  
	/* The game board holding all game pieces. Board is 8 x 8. */
	private IChessPiece[][] board;
	
	/* The current player playing the game. */
	private Player currentPlayer;
	
	/* The first player opponent. */
	private Player White = Player.WHITE;
	 
	/* The second player opponent. */
	private Player Black = Player.BLACK;
	
	/* The grid box dimension. */
	private final int boardDim = 8;
	
	//---------------------------------------------------------------//	
	// Class Constructors                                            //
	//---------------------------------------------------------------//	
	
	public ChessModel() { 
		
		board = new ChessPiece[this.numRows()][this.numColumns()];
		
		//Place White pieces onto board
		board[0][0] = new Rook(Player.WHITE);
		board[0][1] = new Knight(Player.WHITE);
		board[0][2] = new Bishop(Player.WHITE);
		board[0][3] = new Queen(Player.WHITE);
		board[0][4] = new King(Player.WHITE);
		board[0][5] = new Bishop(Player.WHITE);
		board[0][6] = new Knight(Player.WHITE);
		board[0][7] = new Rook(Player.WHITE);
		
		//Place Black pieces onto board
		board[7][0] = new Rook(Player.BLACK);
		board[7][1] = new Knight(Player.BLACK);
		board[7][2] = new Bishop(Player.BLACK);
		board[7][3] = new Queen(Player.BLACK);
		board[7][4] = new King(Player.BLACK);
		board[7][5] = new Bishop(Player.BLACK);
		board[7][6] = new Knight(Player.BLACK);
		board[7][7] = new Rook(Player.BLACK);
		
		// Place black pawns.
		for(int i = 0; i < boardDim; i++)
			board[6][i] = new Pawn(Player.BLACK);
		
		// Place white pawns.
		for(int i = 0; i< boardDim; i++)
			board[1][i] = new Pawn(Player.WHITE);
		
		// Define the first current player.
		currentPlayer = White;
	
		}
	
	
	//--------------------------------------------------------------//	
	// Function Definitions					     					//
	//--------------------------------------------------------------//   
	
	/* Allows this object to be a singleton object. */
	public static ChessModel getInstance () {
	  
	    // Check to see if the instance exists.
       if (instance == null)
          instance = new ChessModel();

       // Return the instance of the object. 
       return instance;
	 
	}

	
	/* Returns whether checkmate can be declared. */
	public boolean isComplete() { 
		
		return false;
		
	} 
	

	/* */
	public boolean isValidMove(Move move) { 
		// TODO DONT TOUCH. BAD THINGS WILL HAPPEN.
		return false;
	} 

	
	/* Moves a piece on the board. */
	public void move(Move move) { 
		
		// --- Variable Declarations  -------------------------//
		
		/* The temporary piece holder. */
		IChessPiece temp; 
		
		// --- Main Routine -----------------------------------//
		
		// get the piece at the start position.
		temp = pieceAt (move.getFromRow(), move.getFromColumn());
		
		// Perform the swap.
		board [move.getToRow()] [move.getToColumn()] = temp;
		board [move.getFromRow()] [move.getFromColumn()] = null;				
		
	} 
	
	
	/* Determines if a given player is in check. */
	public boolean inCheck(Player p) { 
		
		// --- Variable Declarations  -------------------------//
		
		/* The player who is checking the checked. */ 
		Player agianstPlayer = p == Player.WHITE ? Player.BLACK 
							 : Player.WHITE;
		
		/* The to position x for all checks. */
		int toKingX = -1;
		
		/* The to position y for all checks. */
		int toKingY = -1;
		
		/* The move to check. */
		Move moveCheck;
		
		// --- Main Routine -----------------------------------//
		
		// Find the king on the board to check for checked.
		for (int x = 0; x < numRows(); x++) 
		{
			for (int y = 0; y < numColumns(); y++)
			{
				// If the piece matches the description set to pos.
				if (board[x][y].type() == Piece.KING &&
							board[x][y].player() == p)
				{
					toKingX = x;
					toKingY = y;
					break;
				}
			}
		}
		
		// Determine any avenues that the king could be in check.
		for (int x = 0; x < numRows(); x++) 
		{
			for (int y = 0; y < numColumns(); y++)
			{
				if (board[x][y].player() == agianstPlayer)
				{
					// Construct a move to check.
					moveCheck = new Move (x, y, toKingX, toKingY);
					
					// If it came back valid. Set in check to true.
					if (board[x][y].isValidMove(moveCheck,board))
						return true;
				}
			}
		}
		
		// Return the result.
		return false; 
		
	} 
	

	/* Returns the current player. */
	public Player currentPlayer() { 

		return currentPlayer;
	
	} 
	
	
	/* Returns the number of rows on the board. */
	public int numRows() { 

		return boardDim;

	} 
	
	
	/* Returns the number of columns on the board. */
	public int numColumns() { 

		return boardDim;
		
	} 
	

	/* Returns a piece at a given point in the grid. */
	public IChessPiece pieceAt(int row, int column) { 
		
		if (inGrid (row, column))
			return board [row] [column];
					
		else
			return null;				
	} 
	
	
   /****************************************************************
   * This method validates that a move position is within the grid.
   *
   * @return Whether or not the move is in the grid. 
   * 
   *****************************************************************/
	public boolean inGrid (int xPos, int yPos) {
		
		// Ternary operate whether its in the grid.
		return  (xPos >= 0 && xPos < boardDim) && (yPos >= 0 && 
					yPos < boardDim) ? true : false; 
	}
	
	
   /****************************************************************
   * This method toggles which players turn it currently is.
   *
   * @return The player enum whose turn is up (WHITE or BLACK).
   * 
   *****************************************************************/
	public Player nextTurn () {
		
		return currentPlayer = currentPlayer == Player.WHITE ? 
										  Player.BLACK : Player.WHITE;
		
	}
	
	
}
