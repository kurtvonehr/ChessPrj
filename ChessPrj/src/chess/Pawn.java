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
	
	private Player player;
	
	/* Determines if this is the pawn's first move. */
	private boolean firstMove;
	
	//---------------------------------------------------------------//	
	// Class Constructors                                            //
	//---------------------------------------------------------------//	
	
	/*****************************************************************
  	The primary constructor for the Pawn piece. It creates a pawn
  	for the given player specified.
        
	 @return None 
    
  	*****************************************************************/
  	public Pawn (Player player) {
		
		super (player);
		
		this.player = player;
		
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

		// continue with checking for piece specifics.
		if (validmove)
		{
			// Get row position values.
			row = move.getFromRow ();
			col = move.getFromColumn ();
			toRow = move.getToRow ();
			toCol = move.getToColumn ();
			
			// Determine which direction we should be moving.
			if (player() == Player.WHITE)
			{
				
				// -- Check what move call was performed. -- //
				
				// Check for a first move instance.
				if (firstMove && col == toCol && toRow == row - 2){
					result = true;
					// Make sure if the first move cleared that we turn it off.
					firstMove = false;
				}
				
				// If they called a north west move.
				else if (toRow == row - 1 && toCol == col - 1) 
				{
					// Check that the opponent has a piece there.
					if (!(board[toRow][toCol] == null || board[toRow][toCol].player().equals(Player.WHITE)))
						result = true;
				}
				
				// If they called a north east move.
				else if (toRow == row - 1 && toCol == col + 1) 
				{
					// Check that the opponent has a piece there.
					if (!(board[toRow][toCol] == null || board[toRow][toCol].player().equals(Player.WHITE)))
						result = true;
				}
				
				// If they called a due north move. 
				else if (toRow == row - 1 && toCol == col && 
						board[toRow][toCol] == null)
					result = true;
			}
			
			else
			{
				// -- Check what move call was performed. -- //
				
				// Check for a first move instance.
				if (firstMove && col == toCol && toRow == row + 2){
					result = true;
					// Make sure if the first move cleared that we turn it off.
					firstMove = false;
				}
				
				// If they called a north west move.
				else if (toRow == row + 1 && toCol == col - 1) 
				{
					// Check that the opponent has a piece there.
					if (!(board[toRow][toCol] == null || board[toRow][toCol].player().equals(Player.BLACK)))
						result = true;
				}
				
				// If they called a north east move.
				else if (toRow == row + 1 && toCol == col + 1) 
				{
					// Check that the opponent has a piece there.
					if (!(board[toRow][toCol] == null || board[toRow][toCol].player().equals(Player.BLACK)))
						result = true;
				}
				
				// If they called a due north move. 
				else if (toRow == row + 1 && toCol == col && 
						board[toRow][toCol] == null)
					result = true;
			}
		}
		
		// Return the result of the operation.
		return result;
		
	}
	
	//--------------------------------------------------------------//  

	
}
