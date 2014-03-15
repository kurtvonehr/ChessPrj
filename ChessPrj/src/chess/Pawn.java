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
  	An overridden assessor method that returns the type of chess piece
  	this class piece is.
        
  	@return The class type of pawn as a Piece enum. 
    
  	*****************************************************************/
  	@Override
  	public Piece type () {
    
    	return Piece.PAWN;
    
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
			// Determine which direction we should be moving.
			if (player() == Player.BLACK)
			{
				
				// TODO implement logic.
				
				// Step through and see what type of move it could be.
				//if (move.getTo) 
				
				// Take into account extra start case.
				//if ()
			}
			
			else
			{
				// TODO implement logic.

			}
			
		}
		
		// Return the result of the operation.
		return result;
		
	}
	
	//--------------------------------------------------------------//  

	
}
