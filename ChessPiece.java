package chess;

/*--------------------------------------------------------------------*
* ChessPeice.java                             		              	  *
*---------------------------------------------------------------------*
* Description - A class used as the default definition for all the    *
* board peices involved in the game of chess.						  *
*---------------------------------------------------------------------*
* Project: Project 3 : Chess 	                                      *
* Author : McKim A. Jacob, VonEhr Kurt                                *
* Date Of Creation: 3 - 1 - 2014                                      *
*---------------------------------------------------------------------*
* ISSUES AND NOTES						      						  *	                                      
*---------------------------------------------------------------------*
* 
*                                 
*                                 
*---------------------------------------------------------------------*/

public abstract class ChessPiece implements IChessPiece {

	//---------------------------------------------------------------//	
	// Class Variable Definitions                                    //
	//---------------------------------------------------------------//

	/* The player defined as the owner to this peice. */
	private Player owner; 
	
	//---------------------------------------------------------------//	
 	// Class Constructors                                            //
 	//---------------------------------------------------------------//	

	/*****************************************************************
	The default constructor for the base ChessPeice class. This
	constructor takes in a parameter for the owner of the peice.
	
	@param player The player who owns the peice.
        
	@return None 
    
 	*****************************************************************/
	protected ChessPiece(Player player) { 
		
		// Set class attributes.
		this.owner = player; 
		
	} 
	
	//--------------------------------------------------------------//	
	// Interface Function Definitions								//
	//--------------------------------------------------------------//
	 
	/* Method called to return peice type as string. */
	public abstract String type(); 
	 
	 
	/* Method called to return the owner of this peice. */
	public Player player() { 
		 
		return owner;
		 
	} 
	 
	/* Method called to see if move requested is valid. */
	public boolean isValidMove(Move move, IChessPiece[ ][ ] board) { 
	 	
	// --- Variable Declarations  ---------------------------//
	
	/* The chess peice that is defined at start of move. */
	ChessPeice fromPeice;
	
	/* The chess peice that is defined at end of move. */
	ChessPeice toPeice;
	
	/* The end result of this verification check. */
	boolean result = false;
	
	// --- Main Routine -------------------------------------//

	// Get start postion of cell.
	fromPeice = IChessPeice [move.getFromRow()]
					[move.getFromColumn()];
	
	// Get the end postion of the cell.
	toPeice = IChessPeice [move.getToRow()] [move.getToColumn()];
	
	// Verify that it's the right peice.
	if (fromPeice != null && fromPeice == Pawn.this)
	{
		// Verify that the move has a delta change.
		if ( (move.getFromRow() == move.getToRow() ) &&
			( move.getFromColumn() != move.getToColumn () ) )
		{
			// Verify that the end pos is not the players.
			if (toPeice != null && toPeice.player() == owner)
				result = true;
		}
		
	}
	
	// Return the result of the operation.
	return result;

 	} 
 	
 	//--------------------------------------------------------------//
 	
}
