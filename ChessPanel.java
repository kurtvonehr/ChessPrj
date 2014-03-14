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
  	private ChessModel instance;
  
	/* The game board holding all game pieces. Board is 8x8 */
	private IChessPiece[][] board;
	
	/* The first player opponent. */
	private Player White = Player.WHITE;
	 
	/* The second player opponent. */
	private Player Black = Player.BLACK;
	
	//---------------------------------------------------------------//	
	// Class Constructors                                            //
	//---------------------------------------------------------------//	
	
	ChessModel() { 
	
		//Init blank board
		for(int i = 0; i<8; i++)
			for(int j = 0; j<8; j++){
				board[i][j] = null;
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
		
		for(int i =0; i<8;i++){
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
		
		for(int i =0; i<8;i++){
			board[6][i] = new Pawn(Player.WHITE);
		}
		
	
		}
	
	
	//--------------------------------------------------------------//	
	// Function Definitions					     	//
	//--------------------------------------------------------------//   
	
	public ChessModel getInstance () {
	  
	    // Check to see if the instance exists.
       if (instance == null)
          instance = new ChessModel();

      return instance;
	 
	}

	public boolean inCheck() { 
		return false; 
	}
	
	public boolean isComplete() { 
		return false; 
	} 


	public boolean isValidMove(Move move) {
		return false;
		
	} 


	public void move(Move move) { 
		// complete this 
	} 
	

	public boolean inCheck(Player p) { 
		return false; 
	} 
	

	public Player currentPlayer() { 
		// complete this 
		return White;
	} 
	

	public int numRows() { 
		// complete this 
	} 
	

	public int numColumns() { 
		// complete this 
	} 


	public IChessPiece pieceAt(int row, int column) { 
		// complete this 
	} 


}
