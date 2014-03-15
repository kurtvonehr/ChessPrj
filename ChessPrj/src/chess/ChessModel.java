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
	
		//Init blank board
		for(int i = 0; i< boardDim; i++) {
			for(int j = 0; j< boardDim; j++){
				board[i][j] = new ChessPiece();
			}
		}
		
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
		for(int i = 0; i < boardDim; i++) {
			board[6][i] = new Pawn(Player.BLACK);
		}
		
		
		//Place White pieces onto board
		board[0][0] = new Rook(Player.WHITE);
		board[0][1] = new Knight(Player.WHITE);
		board[0][2] = new Bishop(Player.WHITE);
		board[0][3] = new Queen(Player.WHITE);
		board[0][4] = new King(Player.WHITE);
		board[0][5] = new Bishop(Player.WHITE);
		board[0][6] = new Knight(Player.WHITE);
		board[0][7] = new Rook(Player.WHITE);
		
		// Place white pawns.
		for(int i = 0; i< boardDim; i++)
			board[6][i] = new Pawn(Player.WHITE);

		}
	
	//--------------------------------------------------------------//	
	// Function Definitions					     					//
	//--------------------------------------------------------------//   
	
	public static ChessModel getInstance () {
	    // Check to see if the instance exists.
       if (instance == null)
          instance = new ChessModel();
      return instance;
	}

	public boolean inCheck() { 
		return false; 
	}
	
	public boolean isComplete() { 
		// complete logic:
		// ?	if (piece.isKing() == null) <-- the king is dead
		//			return true;
		return false; 
	} 


	public boolean isValidMove(Move move) { 
		// returns...
		return false;
	} 


	public void move(Move move) { 
		// complete this
	} 
	
	public boolean inCheck(Player p) { 
		return false; 
	} 
	
	public Player currentPlayer() { 
		// complete this logic
		// if (this.player == a.black.piece) {
		// 		return black;
		//  else
				return white;
	} 		

	public int numRows() {
		int r = 8;
		return r;
	} 
	

	public int numColumns() {
		int c = 8;
		return c;
	} 

	public ChessPiece pieceAt(int row, int column) { 
		// complete this 
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
