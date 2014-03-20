package chess;


/*--------------------------------------------------------------------*
* Kight.java                             		              		  *
*---------------------------------------------------------------------*
* Description - A class used to emulate a specialized game piece in   *
* the game of chess. The Knight is allowed to move only in L shaped   *
* patterns across the game board.                                     *
*---------------------------------------------------------------------*
* Project: Project 3 : Chess 	                                      *
* Author : McKim A. Jacob, Vonehr Kurt, Aernouts Kenneth	          *
* Date Of Creation: 3 - 1 - 2014                                      *                          
*---------------------------------------------------------------------*/

public class Knight extends ChessPiece {
	
	//---------------------------------------------------------------//	
	// Class Constructors                                            //
	//---------------------------------------------------------------//	

	/*****************************************************************
  	The primary constructor for the Pawn piece. It creates a pawn
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
  	An overridden accesor method that returns the type of chess piece
  	this class peice is.
        
  	@return The class type of knight as a Piece enum. 
    
  	*****************************************************************/
  	@Override
  	public Piece type () {
    
    	return Piece.KNIGHT;
    
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
		boolean result = false;
		
		/* The current row position of the pawn. */
		int row;
		
		/* The current column position of the pawn. */
		int col;
		
		/* The move to row position. */
		int toRow = move.getToRow();
		
		/* The move to column position. */
		int toCol = move.getToColumn();

		// --- Main Routine -----------------------------------//

		// Perform the generic background check.
		boolean validmove = super.isValidMove(move, board);
		
		// Get row position values.
		row = move.getFromRow ();
		col = move.getFromColumn ();
		toRow = move.getToRow ();
		toCol = move.getToColumn ();

		// continue with checking for piece specifics.
		if (validmove)
		{
			// Small North East Move.
			if (toRow == row + 2 && toCol == col + 1)
				result = true;
			
			// Big North East Move.
			else if (toRow == row + 1 && toCol == col + 2)
				result = true;
			
			// Small North West Move.
			else if (toRow == row + 2 && toCol == col - 1)
				result = true;
			
			// Big North West Move.
			else if (toRow == row + 1 && toCol == col - 2)
				result = true;
			
			// Small South East Move.
			else if (toRow == row - 2 && toCol == col + 1)
				result = true;
			
			// Big South East Move.
			else if (toRow == row - 1 && toCol == col + 2)
				result = true;

			// Small Small West Move.
			else if (toRow == row - 2 && toCol == col - 1)
				result = true;
			
			// Big South West Move.
			else if (toRow == row - 1 && toCol == col - 2)
				result = true;
		}

		// Return the result of the operation.
		return result;

	}

}

	//--------------------------------------------------------------//  
