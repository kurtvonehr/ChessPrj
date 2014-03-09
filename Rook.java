package chess;

/*--------------------------------------------------------------------*
* Rook.java                             		              		  *
*---------------------------------------------------------------------*
* Description - A class used to emulate a specialized game peice in   *
* the game of chess. The Rook is allowed to move only linear 	      *
* patterns along the line of y = x and x = y. 		    			  *
*---------------------------------------------------------------------*
* Project: Project 3 : Chess 	                                      *
* Author : McKim A. Jacob, Vonehr Kurt                                *
* Date Of Creation: 3 - 1 - 2014                                      *
*---------------------------------------------------------------------*
* ISSUES AND NOTES												      *	                                      
*---------------------------------------------------------------------*
* 
*                                 
*                                 
*---------------------------------------------------------------------*/

public class Rook extends ChessPiece {
	
	//---------------------------------------------------------------//	
	// Class Variable Definitions                                    //
	//---------------------------------------------------------------//
	
	private ChessModel model;
	
	//---------------------------------------------------------------//	
	// Class Constructors                                            //
	//---------------------------------------------------------------//	
	
	/*****************************************************************
  	The primary constructor for the rook peice. It creates a rook
  	for the given player specified.
        
	 @return None 
    
  	*****************************************************************/
  	public Rook () {
		
		// Get the model object for help with control.
		model = ChessModel.getInstance ();
		
	}

	//--------------------------------------------------------------//	
	// Override Function Definitions		      		//
	//--------------------------------------------------------------//  

	/*****************************************************************
  	An overriden acessor method that returns the type of chess peice
  	this class peice is.
        
  	@return The class type of rook as a string. 
    
  	*****************************************************************/
  	@Override
  	public String type () {
    
    	return "Rook";
    
  	}
  
	@Override
	public boolean isValidMove(Move move, IChessPiece[ ][ ] board) {
		
		// --- Variable Declarations  -------------------------------//
		
		/* The result of the computation. */
		boolean result;
		
		/* The lesser value of the rook's position. */
		int lesser;
		
		/* The greater value of the rook's position. */
		int greater;
		
		/* The position in the array to be pointing. */
		int pos;
		
		// --- Main Routine -----------------------------------------//
		
		// Preform the generic background check.
		result = super.isValidMove(move, board);
		
		// continue with checking for peice specifics.
		if (result)
		{
			// Check if it is horizontial.
			if (move.GetFromRow() == move.getToRow()) 
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
				
				//  Find if there are any peices in between the rows.
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
				
				//  Find if there are any peices in between the rows.
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
	
}
