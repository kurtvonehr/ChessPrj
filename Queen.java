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
  	The primary constructor for the Queen peice. It creates a queen
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
  	An overriden acessor method that returns the type of chess peice
  	this class peice is.
        
  	@return The class type of queen as a Piece enum. 
    
  	*****************************************************************/
  	@Override
  	public Piece type () {
    
    	return Piece.QUEEN;
    
  	}
  	
  	
  	/*****************************************************************
  	An overriden validation method used to make sure that the 
  	requested move to preform is valid.
        
  	@return Whether or not the move was valid.
    
  	*****************************************************************/
	@Override
	public boolean isValidMove(Move move, IChessPiece[][] board) {

		// --- Variable Declarations  -------------------------//

		/* The result of the computation. */
		boolean result;

		// --- Main Routine -----------------------------------//

		// Preform the generic background check.
		result = super.isValidMove(move, board);

		// continue with checking for peice specifics.
		if (result)
		{
		    //TODO implement queen search.
		}

		// Return the result of the operation.
		return result;

	}

	//--------------------------------------------------------------// 
