package chess;

/*--------------------------------------------------------------------*
* ChessModel.java                             		              	  *
*---------------------------------------------------------------------*
* Description - A class used to control all game logic of the game of *
* chess during the users interactions with the game. This class can   *
* only be initialized once.											  *
*---------------------------------------------------------------------*
* Project: Project 3 : Chess 	                                      *
* Author : McKim A. Jacob, Vonehr Kurt                                *
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
  	private ChessModel instance;
  
	/* The game board holding all game pieces. Board is 8x8 */
	private IChessPiece[][] board = new ChessPiece[8][8]; 
	
	/* The first player opponent. */
	private Player White = Player.WHITE;
	 
	/* The second player opponent. */
	private Player Black = Player.BLACK;
	
	//---------------------------------------------------------------//	
	// Class Constructors                                            //
	//---------------------------------------------------------------//	

	private ChessModel() { 
	
		
		
		
	}
	
	//--------------------------------------------------------------//	
	// Function Definitions					      					//
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


	public boolean isValidMove(Move moce) { 
		// complete this 
	} 


	public void move(Move move) { 
		// complete this 
	} 
	

	public boolean inCheck(Player p) { 
		return false; 
	} 
	

	public Player currentPlayer() { 
		// complete this 
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
