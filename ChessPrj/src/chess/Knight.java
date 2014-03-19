package chess;


/*--------------------------------------------------------------------*
* Kight.java                             		              		  *
*---------------------------------------------------------------------*
* Description - A class used to emulate a specialized game peice in   *
* the game of chess. The Knight is allowed to move only in L shaped   *
* paterns across the game board.                                      *
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

public class Knight extends ChessPiece {
  
	//---------------------------------------------------------------//	
	// Class Variable Definitions                                    //
	//---------------------------------------------------------------//

	//---------------------------------------------------------------//	
	// Class Constructors                                            //
	//---------------------------------------------------------------//	

	/*****************************************************************
  	The primary constructor for the Pawn peice. It creates a pawn
  	for the given player specified.
        
	 @return None 
    
  	*****************************************************************/
  	public Knight (Player player) {

		super (player);

	}

	//--------------------------------------------------------------//	
	// Override Function Definitions								//
	//--------------------------------------------------------------//  


	/*****************************************************************
  	An overriden acessor method that returns the type of chess peice
  	this class peice is.
        
  	@return The class type of knight as a Piece enum. 
    
  	*****************************************************************/
  	@Override
  	public Piece type () {
    
    	return Piece.KNIGHT;
    
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
		boolean result = false;
		
		/* The current row postion of the pawn. */
		int row;
		
		/* The current column position of the pawn. */
		int col;
		
		/* The move to row position. */
		int toRow = move.getToRow();
		
		/* The move to column position. */
		int toCol = move.getToColumn();

		// --- Main Routine -----------------------------------//

		// Perform the generic background check.
		result = super.isValidMove(move, board);
		
		// Get row positon values.
		row = move.getFromRow ();
		col = move.getFromColumn ();
		toRow = move.getToRow ();
		toCol = move.getToColumn ();

		// continue with checking for piece specifics.
		if (result)
		{
			// Small North East Move.
			if (toRow == row + 3 && toCol == + 2)
				result = true;
			
			// Big North East Move.
			else if (toRow == row + 2 && toCol == col + 3)
				result = true;
			
			// Small North West Move.
			else if (toRow == row + 3 && toCol == col - 2)
				result = true;
			
			// Big North West Move.
			else if (toRow == row + 2 && toCol == col - 3)
				result = true;
			
			// Small South East Move.
			else if (toRow == row - 3 && toCol == + 2)
				result = true;
			
			// Big South East Move.
			else if (toRow == row - 2 && toCol == col + 3)
				result = true;

			// Small Small West Move.
			else if (toRow == row - 3 && toCol == col - 2)
				result = true;
			
			// Big South West Move.
			else if (toRow == row - 2 && toCol == col - 3)
				result = true;
		}

		// Return the result of the operation.
		return result;

	}

}

	//--------------------------------------------------------------//  
