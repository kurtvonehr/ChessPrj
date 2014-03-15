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
		boolean result = true;

		/* The lesser row value of the queen's position. */
		int lesser_row;
		
		/* The lesser col value of the queen's position. */
		int lesser_col;
		
		/* The greater row value of the queen's position. */
		int greater_row;
		
		/* The greater col value of the queen's position. */
		int greater_col;
		
		/* The position in the array to be pointing. */
		int pos;

		// --- Main Routine -----------------------------------//

		// Perform the generic background check.
		result = super.isValidMove(move, board);

		// continue with checking for piece specifics.
		if (result)
		{
		    	// Check if it is horizontal.
			if (move.getFromRow() == move.getToRow())
			{
				// Determine which part of the move is greater.
				if ( move.getFromColumn() > move.getToColumn() )
				{
					greater_row = move.getFromColumn();
					lesser_row = move.getToColumn();
				}
				else
				{
					greater_row = move.getToColumn();
					lesser_row = move.getFromColumn();
				}
				
				// Find if there are any pieces in between the rows.
				for ( pos = lesser_row + 1; pos < greater_row; pos++ )
				{
					if (board [move.getToRow()] [pos] != null)
					{	
						result = false;
						break;
					}
				}
			}
			
			// Check if it is vertical.
			else if (move.getFromColumn() == move.getToColumn())
			{
				// Determine which part of the move is greater.
				if ( move.getFromRow() > move.getToRow() )
				{
					greater_col = move.getFromRow();
					lesser_col = move.getToRow();
				}
				else
				{
					greater_col = move.getToRow();
					lesser_col = move.getFromRow();
				}
				
				// Find if there are any pieces in between the rows.
				for ( pos = lesser_col + 1; pos < greater_col; pos++ )
				{
					if (board [pos] [move.getToColumn()] != null)
					{	
						result = false;
						break;
					}
				}
			}
			
			// Check if it is on the positive slope diagonal.
			else if ((move.getFromColumn() - move.getToColumn()) == 
			(move.getFromRow() - move.getFromRow()))
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
					greater_col = move.getFromColumn();
					lesser_col = move.getToColumn();
				}
				else
				{
					greater_col = move.getToColumn();
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
			
			// Check if it is on the negative slope diagonal
			else if ((move.getFromColumn() - move.getToColumn()) == 
			-(move.getFromRow() - move.getFromRow()))
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
					greater_col = move.getFromColumn();
					lesser_col = move.getToColumn();
				}
				else
				{
					greater_col = move.getToColumn();
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
			
			else
				result = false;
		}

		// Return the result of the operation.
		return result;

	}

}

	//--------------------------------------------------------------// 
