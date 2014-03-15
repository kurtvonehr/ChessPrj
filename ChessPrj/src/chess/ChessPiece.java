package chess;

/*--------------------------------------------------------------------*
* ChessPiece.java                             		                  *
*---------------------------------------------------------------------*
* Description - A class used as the default definition for all the    *
* board pieces involved in the game of chess.			      		  *
*---------------------------------------------------------------------*
* Project: Project 3 : Chess 	                                      *
* Author : McKim A. Jacob, VonEhr Kurt                                *
* Date Of Creation: 3 - 1 - 2014                                      *
*---------------------------------------------------------------------*
* ISSUES AND NOTES						     						  *	                                      
*---------------------------------------------------------------------*
* 
*                                 
*                                 
*---------------------------------------------------------------------*/

public abstract class ChessPiece implements IChessPiece {

	//---------------------------------------------------------------//	
	// Class Global Variable Definitions                             //
	//---------------------------------------------------------------//

	/* The player defined as the owner to this piece. */
	private Player owner; 
	
	/* The core model controller that operates all pieces. */
	private ChessModel model;
	
	//---------------------------------------------------------------//	
 	// Class Constructors                                            //
 	//---------------------------------------------------------------//	

	/*****************************************************************
	The default constructor for the base ChessPiece class. This
	constructor takes in a parameter for the owner of the piece.
	
	@param player The player who owns the piece.
        
	@return None 
    
 	*****************************************************************/
	protected ChessPiece(Player player) { 
		
		// Sets the objects Player.enum to the given parameter
		this.owner = player; 
		
		// Instantiates a new model object which controls the game.
		model = new ChessModel();
		
		/** EDIT: Not really necessary, since we only want one game running at a time */
		// model = ChessModel.getInstance();
	} 
	
	//--------------------------------------------------------------//	
	// Interface Function Definitions				//
	//--------------------------------------------------------------//
	 
	/* Method called to return the owner of this piece. */
	public Player player() { 	 
		return owner;
	} 
	
	/* Method called to return piece type as Piece. */
	// Each piece (ex: Pawn.java, Rook.java) will return its own Piece.enum 
	public abstract Piece type(); 
		 
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
	fromPiece = board[move.getFromRow()]
					[move.getFromColumn()];
	
	// Get the end position of the cell.
	toPiece = board[move.getToRow()] [move.getToColumn()];
	
	// Verify that it's the right piece.
	if (fromPiece != null)
	{
		// Verify that the move change position of piece.
		if ( (move.getFromRow() != move.getToRow() ) &&
			( move.getFromColumn() != move.getToColumn () ) )
		{
			// Verify that the end pos is not on one of the the player's
			if (toPiece.player() != owner)
				result = true;
		}
		
	}
	
	// Return the result of the operation.
	return result;

 	} 
 	
 	//--------------------------------------------------------------//
 	
}
