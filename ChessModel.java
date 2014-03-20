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
  	protected static ChessModel instance;
  
	/* The game board holding all game pieces. Board is 8 x 8. */
	private IChessPiece[][] board;
	
	/* The current player playing the game. */
	private Player currentPlayer;
	
	/* The opposing player playing the game. */
	private Player opposingPlayer;
	
	/* The first player opponent. */
	private Player White = Player.WHITE;
	 
	/* The second player opponent. */
	private Player Black = Player.BLACK;
	
	/* The grid box dimension. */
	private final int boardDim = 8;
	
	//game over
	boolean gameOver;
	
	//---------------------------------------------------------------//	
	// Class Constructors                                            //
	//---------------------------------------------------------------//	
	
	public ChessModel() { 
		
		board = new ChessPiece[this.numRows()][this.numColumns()];
		
		//Place White pieces onto board
		board[0][0] = new Rook(Player.BLACK);
		board[0][1] = new Knight(Player.BLACK);
		board[0][2] = new Bishop(Player.BLACK);
		board[0][3] = new Queen(Player.BLACK);
		board[0][4] = new King(Player.BLACK);
		board[0][5] = new Bishop(Player.BLACK);
		board[0][6] = new Knight(Player.BLACK);
		board[0][7] = new Rook(Player.BLACK);
		
		//Place Black pieces onto board
		board[7][0] = new Rook(Player.WHITE);
		board[7][1] = new Knight(Player.WHITE);
		board[7][2] = new Bishop(Player.WHITE);
		board[7][3] = new Queen(Player.WHITE);
		board[7][4] = new King(Player.WHITE);
		board[7][5] = new Bishop(Player.WHITE);
		board[7][6] = new Knight(Player.WHITE);
		board[7][7] = new Rook(Player.WHITE);
		
		// Place black pawns.
		for(int i = 0; i < boardDim; i++)
			board[6][i] = new Pawn(Player.WHITE);
		
		// Place white pawns.
		for(int i = 0; i< boardDim; i++)
			board[1][i] = new Pawn(Player.BLACK);
		
		// Define the first current player.
		currentPlayer = White;
		
		// Define the opposing player
		opposingPlayer = Black; 
		
		gameOver = false;
	
		}
	
	
	//--------------------------------------------------------------//	
	// Function Definitions					     					//
	//--------------------------------------------------------------//   

	
	/* Returns whether checkmate can be declared. */
	public boolean isComplete() { 
		
		return gameOver;
		
	} 
	

	/* Calls a piece and asks if the move is valid. */
	public boolean isValidMove(Move move) { 
		
		/* The piece to ask for information from. */
		ChessPiece piece;
		
		// Get the piece to be pulled.
		piece = (ChessPiece) pieceAt(move.getFromRow(),
											move.getFromColumn());
		
		// Return the result of the board move.
		if (!(board[move.fromRow][move.fromColumn] == null ||
				board[move.fromRow][move.fromColumn].player() != currentPlayer))
			return piece.isValidMove(move, board);
		else 
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
		
		Player againstPlayer = p == Player.WHITE ? Player.BLACK
				: Player.WHITE;
		
		/* The to position x for all checks. */
		int KingX = -1;
		
		/* The to position y for all checks. */
		int KingY = -1;
		
		/* The move to check. */
		Move moveCheck;
		
		boolean check = false;
		
		// --- Main Routine -----------------------------------//
		
		// Find the king on the board.
		for (int x = 0; x < numRows(); x++) 
		{
			for (int y = 0; y < numColumns(); y++)
			{
				// If the piece matches the description set to pos.
				if (!(board[x][y] == null) && board[x][y].type() == Piece.KING &&
							board[x][y].player() == p)
				{
					KingX = x;
					KingY = y;
					break;
				}
			}
		}
		
		// Determine if there are any moves that the opposing player could
		//move and put the king into check
		for (int x = 0; x < numRows(); x++) 
		{
			for (int y = 0; y < numColumns(); y++)
			{
				if (!(board[x][y] == null) && board[x][y].player() == againstPlayer)
				{
					// Construct a move to check.
					moveCheck = new Move (x, y, KingX, KingY);
					
					// If it came back valid. Set in check to true.
					if (board[x][y].isValidMove(moveCheck,board))
						check = true;
				}
			}
		}
		
		
		//check for checkmate and set iscomplete to true if it is
		if(check){
			//check all valid moves of the king and if any will
			//allow it to move out of check			
			for (int x = 0; x < numRows(); x++) 
			{
				for (int y = 0; y < numColumns(); y++)
				{
						// Construct a move to check.
						moveCheck = new Move (KingX, KingY, x, y);
						
						// If it came back valid. Set in check to true.
						if (board[KingX][KingY].isValidMove(moveCheck,board))
							gameOver = false;
						else
							gameOver = true;
				}
			}
		}
			
		// Return the result.
		return check; 
		
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
		
		//Opposing Player is now the current player
		opposingPlayer = currentPlayer;
		
		return currentPlayer = currentPlayer == Player.WHITE ? 
										  Player.BLACK : Player.WHITE;
		
	}


protected void setBoardPiece(IChessPiece piece, int x, int y) {
	this.board[x][y] = piece;
}


public Player getOpposingPlayer() {
	return opposingPlayer;
}


public boolean inCheckMate(Player currentPlayer2) {
	return false;
}
	
	
}
