package chess;

/*--------------------------------------------------------------------*
* Bishop.java                             		             		  *
*---------------------------------------------------------------------*
* Description - A class used to emulate a specialized game piece in   *
* the game of chess. The bishop is allowed to move only linear	      *
* patterns along the line f(x) and -f(x).			      			  *
*---------------------------------------------------------------------*
* Project: Project 3 : Chess 	                                      *
* Author : McKim A. Jacob, Vonehr Kurt, Aernouts Kenneth	          *
* Date Of Creation: 3 - 1 - 2014                                      *                        
*---------------------------------------------------------------------*/


public class Bishop extends ChessPiece {
	
	//---------------------------------------------------------------//	
	// Class Constructors                                            //
	//---------------------------------------------------------------//	
	
	/*****************************************************************
	 The primary constructor for the bishop piece. It creates a bishop
	 for the given player specified.
	     
	 @return None 
    
	 *****************************************************************/
	public Bishop (Player player) {
		
		super (player);
		
	}
	
	//--------------------------------------------------------------//	
	// Override Function Definitions								//
	//--------------------------------------------------------------//
	
	/*****************************************************************
  	An overridden accesor method that returns the type of chess piece
  	this class piece is.
        
  	@return The class type of Bishop as a piece enum. 
    
  	*****************************************************************/
	@Override
	public Piece type() {
		
		return Piece.BISHOP;
		
	}
	
	
	/*****************************************************************
	An overridden validation method used to make sure that the
	requested move to perform is valid.
	
	@return Whether or not the move was valid.
	
	*****************************************************************/
	@Override
	public boolean isValidMove(Move move, IChessPiece[][] board) {
	
	// --- Variable Declarations -------------------------//
	
	/* The result of the computation. */
	boolean result = true;
	
	/* The lesser row value of the queen's position. */
	int lesser_row;
	
	/* The lesser col value of the queen's position. */
	int lesser_col;
	
	/* The greater row value of the queen's position. */
	int greater_row;
	
	/* The position in the array to be pointing. */
	int pos;
	
	// --- Main Routine -----------------------------------//
	
	// Perform the generic background check.
	result = super.isValidMove(move, board);
	
	// continue with checking for piece specifics.
	if (result)
	{
		// Check if it is on the positive slope diagonal.
		if ((move.getFromColumn() - move.getToColumn()) ==
		-(move.getFromRow() - move.getToRow()))
		{
			// Determine which part of the move is greater.
			if ( move.getFromRow() > move.getToRow() )
			{
				greater_row = move.getFromRow();
				lesser_row = move.getToRow();
			}
			else
			{
				greater_row = move.getToRow();
				lesser_row = move.getFromRow();
			}
			
			// Determine which part of the move is greater.
			if ( move.getFromColumn() > move.getToColumn() )
			{
				lesser_col = move.getToColumn();
			}
			else
			{
				lesser_col = move.getFromColumn();
			}
		
		
			// Find if there are any pieces in between the rows.
			for ( pos = 1; pos < (greater_row-lesser_row); pos++ )
			{
				if (board [greater_row - pos] [lesser_col + pos] != null)
				{	
					result = false;
					break;
				}
			}
		}
		
		// Check if it is on the negative slope diagonal
		else if ((move.getFromColumn() - move.getToColumn()) ==
		(move.getFromRow() - move.getToRow()))
		{
			// Determine which part of the move is greater.
			if ( move.getFromRow() > move.getToRow() )
			{
				greater_row = move.getFromRow();
				lesser_row = move.getToRow();
			}
			else
			{
				greater_row = move.getToRow();
				lesser_row = move.getFromRow();
			}
			
			// Determine which part of the move is greater.
			if ( move.getFromColumn() > move.getToColumn() )
			{
				lesser_col = move.getToColumn();
			}
			else
			{
				lesser_col = move.getFromColumn();
			}
		
		
			// Find if there are any pieces in between the rows.
			for ( pos = 1; pos < (greater_row-lesser_row); pos++ )
			{
				if (board [lesser_row + pos] [lesser_col + pos] != null)
				{	
					result = false;
					break;
				}
			}
		}
		
		else
			result = false;
		}
		
		// Return the result of the operation.
		return result;
	
	}

}
	
	//--------------------------------------------------------------//


