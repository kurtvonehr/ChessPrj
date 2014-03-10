package chess;

/*--------------------------------------------------------------------*
* Pawn.java                             		              *
*---------------------------------------------------------------------*
* Description - A class used to emulate a specialized game peice in   *
* the game of chess. The pawn is allowed to move only linear	      *
* patterns and can only attack diagonally.			      *
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

public class Pawn extends ChessPiece {
  
	//---------------------------------------------------------------//	
	// Class Variable Definitions                                    //
	//---------------------------------------------------------------//
	
	/* Determines if this is the pawn's first move. */
	private boolean firstMove;
	
	//---------------------------------------------------------------//	
	// Class Constructors                                            //
	//---------------------------------------------------------------//	
	
	/*****************************************************************
  	The primary constructor for the Pawn peice. It creates a pawn
  	for the given player specified.
        
	 @return None 
    
  	*****************************************************************/
  	public Pawn (Player player) {
		
		super (player);
		
		// Config class variables. 
		firstMove = true;
		
	}

	//--------------------------------------------------------------//	
	// Override Function Definitions				//
	//--------------------------------------------------------------//  


	/*****************************************************************
  	An overriden acessor method that returns the type of chess peice
  	this class peice is.
        
  	@return The class type of pawn as a Piece enum. 
    
  	*****************************************************************/
  	@Override
  	public Piece type () {
    
    	return Piece.PAWN;
    
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
			//TODO implement pawn search.
		}
		
		// Return the result of the operation.
		return result;
		
	}
	
	//--------------------------------------------------------------//  

	
}
