package chess;

/*--------------------------------------------------------------------*
* ChessPiece.java                             		              	  *
*---------------------------------------------------------------------*
* Description - A class used as the default definition for all the    *
* board pieces involved in the game of chess.			     		  *
*---------------------------------------------------------------------*
* Project: Project 3 : Chess 	                                      *
* Author : McKim A. Jacob, Vonehr Kurt, Aernouts Kenneth	          *
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

	/* The player defined as the owner to this piece. */
	private Player owner; 
	
	/* The core model controller that operates all pieces. */
	//private ChessModel model;
	
	//---------------------------------------------------------------//	
 	// Class Constructors                                            //
 	//---------------------------------------------------------------//	

	/*****************************************************************
	The default constructor for the base ChessPiece class. This
	constructor takes in a parameter for the owner of the piece.
	
	@param player The player who owns the piece.
        
	@return None 
    
 	*****************************************************************/
	protected ChessPiece(){
		this.owner = owner.next();
	}
	
	protected ChessPiece(Player player) { 
		
		// Set class attributes.
		this.owner = player; 
		
		// Get the model object for help with control.
		//model = new ChessModel();
		
	} 
	
	//--------------------------------------------------------------//	
	// Interface Function Definitions								//
	//--------------------------------------------------------------//
	 
	/* Method called to return piece type as Piece. */
	public abstract Piece type(); 
	
	public void setType(Piece type){
		
	}
	 
	 
	/* Method called to return the owner of this piece. */
	public Player player() { 
		 
		return owner;
		 
	} 
	 
	/* Method called to see if move requested is valid. */
	public boolean isValidMove(Move move, IChessPiece[ ][ ] board) { 
	 	
	// --- Variable Declarations  ---------------------------//
	
	/* The chess piece that is defined at start of move. */
	IChessPiece fromPiece;
	
	/* The chess piece that is defined at end of move. */
	IChessPiece toPiece;
	
	/* The end result of this verification check. */
	boolean result = false;
	
	// --- Main Routine -------------------------------------//

	// Get start position of cell.
	fromPiece = board[move.getFromRow()] [move.getFromColumn()];
	
	// Get the end position of the cell.
	toPiece = board[move.getToRow()] [move.getToColumn()];
	
	if(fromPiece != null){
		// Verify that the move change position of piece.
		if ( !((move.getFromRow() == move.getToRow() ) &&
				( move.getFromColumn() == move.getToColumn () )) )
			{
				// Verify that the end pos is not a players piece.
				if ( toPiece == null )
					result = true;
				
				else if (toPiece.player() != owner)
					result = true;
			}
	}
		
	
	
	// Return the result of the operation.
	return result;

 	} 
 	
 	//--------------------------------------------------------------//
 	
}
