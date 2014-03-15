package chess;

/*--------------------------------------------------------------------*
* ChessModel.java                             		              *
*---------------------------------------------------------------------*
* Description - A class used to control all game logic of the game of *
* chess during the users interactions with the game. This class can   *
* only be initialized once.					      *
*---------------------------------------------------------------------*
* Project: Project 3 : Chess 	                                      *
* Author : McKim A. Jacob, Vonehr Kurt                                *
* Date Of Creation: 3 - 1 - 2014                                      *
*---------------------------------------------------------------------*
* ISSUES AND NOTES						      *	                                      
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
  
	/* The game board holding all game pieces. Board is 8x8 */
	private ChessPiece[][] board;
	
	/* The first player opponent. */
	private Player white = Player.WHITE;
	 
	/* The second player opponent. */
	private Player black = Player.BLACK;
	
	/* The grid box dimension. */
	private final int boardDim = 8;
	
	//---------------------------------------------------------------//	
	// Class Constructors                                            //
	//---------------------------------------------------------------//	
	
	public ChessModel() { 
	
		/** NOT NECESSARY, JUST INSTANTIATE THE ARRAY **/
		//Init blank board
//		for(int i = 0; i< boardDim; i++) {
//			for(int j = 0; j< boardDim; j++){
//				board[i][j] = new ChessPiece();
//			}
//		}
		board = new ChessPiece[boardDim][boardDim];
		
		//Places Black pieces onto board
		//board[7][0] = new Rook(Player.BLACK);
		board[7][1] = new Knight(Player.BLACK);
		board[7][2] = new Bishop(Player.BLACK);
		board[7][3] = new Queen(Player.BLACK);
		board[7][4] = new King(Player.BLACK);
		board[7][5] = new Bishop(Player.BLACK);
		board[7][6] = new Knight(Player.BLACK);
		board[7][7] = new Rook(Player.BLACK);
		
		// Places black pawns.
		for(int i = 0; i < boardDim; i++) {
			board[6][i] = new Pawn(Player.BLACK);
		}
		
		//Places White pieces onto board
		//board[0][0] = new Rook(Player.WHITE);
		board[0][1] = new Knight(Player.WHITE);
		board[0][2] = new Bishop(Player.WHITE);
		board[0][3] = new Queen(Player.WHITE);
		board[0][4] = new King(Player.WHITE);
		board[0][5] = new Bishop(Player.WHITE);
		board[0][6] = new Knight(Player.WHITE);
		board[0][7] = new Rook(Player.WHITE);
		
		// Places all the white pawns
		for(int i = 0; i< boardDim; i++)
			board[6][i] = new Pawn(Player.WHITE);

		}
	
	//--------------------------------------------------------------//	
	// Function Definitions					     					//
	//--------------------------------------------------------------//   
	
	// Is this necessary?
	public static ChessModel getInstance () {
	    // Check to see if the instance exists.
       if (instance == null)
          instance = new ChessModel();
      return instance;
	}

	
	/****************************************************************
     * This method returns whether the game is complete.
     *
     * @return {@code true} if complete, {@code false} otherwise.
     * 
     *****************************************************************/
	public boolean isComplete() { 
		// TODO complete logic:
		// ?	if (checkMate() = true) <-- the opposing player's king is dead meat
		//			return true;
		return false; 
	} 

	/****************************************************************
     * This method returns whether the piece at location {
     * @code [move.fromRow, move.fromColumn]} is allowed to move to 
     * location{@code [move.fromRow, move.fromColumn]}.
     *
     * @param move a {@link Move} object describing the move to be made.
     * 
     * @return {@code true} if the proposed move is valid, {@code false} 
     * otherwise.
     * 
     * @throws IndexOutOfBoundsException if either {@code [move.fromRow, 
     * move.fromColumn]} or {@code [move.toRow,move.toColumn]} don't 
     * represent valid locations on the board.
     * 
     *****************************************************************/
	public boolean isValidMove(Move move) { 
		// returns...
		// PIECE TYPE == board[move.fromRow][move.fromColumn].type();
		// board[move.fromRow][move.fromColumn].isValidMove(move, board[move.fromRow][move.fromColumn])
		return false;
	} 

	/****************************************************************
     * This method moves the piece from location {@code [move.fromRow,
     * move.fromColumn]} to location {@code [move.fromRow,move.
     * fromColumn]}.
     *
     * @param move a {@link Move} object describing the move to be
     * made.
     * 
     * @returns None
     * 
     * @throws IndexOutOfBoundsException if either {@code [move.fromRow,
     * move.fromColumn]} or {@code [move.toRow,move.toColumn]} don't 
     * represent valid locations on the board.
     * 
     *****************************************************************/
	public void move(Move move) { 
		// TODO complete this logic
		
		if (isValidMove(move)) {
			// Grabs ChessPiece.FROM and replaces ChessPiece.TO in the board[][] array
			board[move.fromRow][move.fromColumn] = board[move.toRow][move.toColumn];
			board[move.fromRow][move.fromColumn] = null;
		}
	} 
	
	/****************************************************************
     * This method reports whether the current player is in check.
     *
     * @return {@code true} if the current player is in check, 
     * {@code false} otherwise.
     * 
     *****************************************************************/
	public boolean inCheck(Player p) { 
		return false; 
	} 
	
	/****************************************************************
     * This method returns the current player.
     *
     * @return the current player.
     * 
     *****************************************************************/
	public Player currentPlayer() { 
		// TODO complete this logic
		// if (this.player == a.black.piece) {
		// 		return black;
		//  else
				return white;
	} 		

	/****************************************************************
     * This method reports back the number of rows that are on the 
     * board.
     *
     * @return The row count as an integer.
     * 
     *****************************************************************/
	public int numRows() {
		int r = 8;
		return r;
	} 
	
	/****************************************************************
     * This method reports back the number of columns that are on the 
     * board.
     *
     * @return The column count as an integer.
     * 
     *****************************************************************/
	public int numColumns() {
		int c = 8;
		return c;
	} 

	/****************************************************************
     * This method returns the {@code ChessPiece} object at location 
     * {@code [row, column]}.
     *
     * @param row    the row (numbered {@code 0} through 
     * {@code numRows -1}
     * 
     * @param column the row (numbered {@code 0} through 
     * {@code numColumns -1}
     * 
     * @return the {@code ChessPiece} object at location 
     * {@code [row, column]}.
     * 
     * @throws IndexOutOfBoundsException if {@code [row, column]} is 
     * not a valid location on the board.
     * 
     *****************************************************************/
	public ChessPiece pieceAt(int row, int column) {  
		// TODO complete this
		// Use ChessPiece.type() to grab Piece.enum
		// Use ChessPiece.player() to grab Player.enum
		return board[row][column];
	} 
	
   /****************************************************************
   * This method validates that a move position is within the grid.
   *
   * @return Whether or not the move is in the grid. 
   * 
   *****************************************************************/
	public boolean inGrid (int xPos, int yPos) {
		
			// Ternary operate whether its in the grid.
			return  (xPos <= 0 && xPos < boardDim) && (yPos >= 0 && 
						yPos < boardDim) ? true : false; 
	}
}
