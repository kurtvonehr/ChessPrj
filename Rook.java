package chess;

/*--------------------------------------------------------------------*
* Rook.java                             		              *
*---------------------------------------------------------------------*
* Description - A class used to emulate a specialized game peice in   *
* the game of chess. The Rook is allowed to move only linear 	      *
* patterns along the line of y = x and x = y.			      *
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

public class Rook extends ChessPiece {
	
	//---------------------------------------------------------------//	
	// Class Variable Definitions                                    //
	//---------------------------------------------------------------//

	//---------------------------------------------------------------//	
	// Class Constructors                                            //
	//---------------------------------------------------------------//	
	
	/*****************************************************************
  	The primary constructor for the rook piece. It creates a rook
  	for the given player specified.
        
	 @return None 
    
  	*****************************************************************/
  	public Rook (Player player) {
  		
		super(player);
		
	}

	//--------------------------------------------------------------//	
	// Override Function Definitions		      		//
	//--------------------------------------------------------------//  


	/*****************************************************************
  	An overridden assessor method that returns the type of chess piece
  	this class piece is.
        
  	@return The class type of rook as a string. 
    
  	*****************************************************************/
  	@Override
  	public Piece type () {
    
    	return Piece.ROOK;
    
  	}
  
  
  	/*****************************************************************
  	An overridden validation method used to make sure that the 
  	requested move to perform is valid.
        
  	@return Whether or not the move was valid.
    
  	*****************************************************************/
	@Override
	public boolean isValidMove(Move move, IChessPiece[ ][ ] board) {
		
		// --- Variable Declarations  -------------------------//
		
		/* The result of the computation. */
		boolean result;
		
		/* The lesser value of the rook's position. */
		int lesser;
		
		/* The greater value of the rook's position. */
		int greater;
		
		/* The position in the array to be pointing. */
		int pos;
		
		// --- Main Routine -----------------------------------//
		
		// Reform the generic background check.
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
					greater = move.getFromColumn();
					lesser = move.getToColumn();
				}
				else
				{
					greater = move.getToColumn();
					lesser = move.getFromColumn();
				}
				
				//  Find if there are any pieces in between the rows.
				for ( pos = lesser + 1; pos < greater; pos++ )
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
					greater = move.getFromRow();
					lesser = move.getToRow();
				}
				else
				{
					greater = move.getToRow();
					lesser = move.getFromRow();
				}
				
				//  Find if there are any pieces in between the rows.
				for ( pos = lesser + 1; pos < greater; pos++ )
				{
					if (board [pos] [move.getToColumn()] != null) 
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
	
	//--------------------------------------------------------------//  

}
