package chess;


/*--------------------------------------------------------------------*
* Queen.java                             		              *
*---------------------------------------------------------------------*
* Description - A class used to emulate a specialized game peice in   *
* the game of chess. The Queen is allowed to move both in straight    *
* and diagonal lines.                                                 *
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

public class Queen extends ChessPiece {
  
	//---------------------------------------------------------------//	
	// Class Variable Definitions                                    //
	//---------------------------------------------------------------//

	//---------------------------------------------------------------//	
	// Class Constructors                                            //
	//---------------------------------------------------------------//	

	/*****************************************************************
  	The primary constructor for the Queen piece. It creates a queen
  	for the given player specified.
        
	 @return None 
    
  	*****************************************************************/
  	public Queen (Player player) {

		super (player);

	}

	//--------------------------------------------------------------//	
	// Override Function Definitions			        //
	//--------------------------------------------------------------//  


	/*****************************************************************
  	An overridden assessor method that returns the type of chess piece
  	this class piece is.
        
  	@return The class type of queen as a Piece enum. 
    
  	*****************************************************************/
  	@Override
  	public Piece type () {
    
    	return Piece.QUEEN;
    
  	}
  	
  	
  	/*****************************************************************
  	An overridden validation method used to make sure that the 
  	requested move to perform is valid.
        
  	@return Whether or not the move was valid.
    
  	*****************************************************************/
	@Override
	public boolean isValidMove(Move move, IChessPiece[][] board) {

		// --- Variable Declarations  -------------------------//

		/* The result of the computation. */
		boolean result;

		// --- Main Routine -----------------------------------//

		// Perform the generic background check.
		result = super.isValidMove(move, board);

		// continue with checking for piece specifics.
		if (result)
		{
		    //TODO implement queen search.
		}

		// Return the result of the operation.
		return result;

	}

	@Override
	public boolean inGrid(int xPos, int yPos) {
		// TODO Auto-generated method stub
		return false;
	}
}

	//--------------------------------------------------------------// 
