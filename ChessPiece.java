package chess;

/*--------------------------------------------------------------------*
* ChessPiece.java                             		              	  *
*---------------------------------------------------------------------*
* Description - A class used as the default definition for all the    *
* board pieces involved in the game of chess.			     		  *
*---------------------------------------------------------------------*
* Project: Project 3 : Chess Game	                                  *
* Group : McKim A. Jacob, Vonehr Kurt, Aernouts Kenneth				  *
* Date: 3/13/2014			                                          *
*---------------------------------------------------------------------*/


public abstract class ChessPiece implements IChessPiece {

	//---------------------------------------------------------------//	
	// Class Variable Definitions                                    //
	//---------------------------------------------------------------//

	/* The player defined as the owner to this piece. */
	private Player owner; 
	
	//---------------------------------------------------------------//	
 	// Class Constructors                                            //
 	//---------------------------------------------------------------//	

	
	/*****************************************************************
	The default constructor for the base ChessPiece class. This
	constructor sets the owner of the piece to NOBODY.
        
	@return None 
    
 	*****************************************************************/
	protected ChessPiece(){
		this.owner = Player.NOBODY;
	}
	
	
	/*****************************************************************
	A constructor for the base ChessPiece class. This
	constructor takes in a parameter for the owner of the piece.
	
	@param player The player who owns the piece.
        
	@return None 
    
 	*****************************************************************/
	protected ChessPiece(Player player) { 
		
		// Set class attributes.
		this.owner = player; 
		
	} 
	
	//--------------------------------------------------------------//	
	// Interface Function Definitions								//
	//--------------------------------------------------------------//
	 
	/* Method called to return piece type as Piece. */
	public abstract Piece type(); 
	
	
	/* Method called to set the piece type. */
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
				( move.getFromColumn() == move.getToColumn () ) ) )
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
