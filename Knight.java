package chess;


/*--------------------------------------------------------------------*
* Kight.java                             		              *
*---------------------------------------------------------------------*
* Description - A class used to emulate a specialized game peice in   *
* the game of chess. The Knight is allowed to move only in L shaped   *
* paterns across the game board.                                      *
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

public class Knight extends ChessPiece {
  
	//---------------------------------------------------------------//	
	// Class Variable Definitions                                    //
	//---------------------------------------------------------------//

	//---------------------------------------------------------------//	
	// Class Constructors                                            //
	//---------------------------------------------------------------//	

	/*****************************************************************
  	The primary constructor for the Pawn peice. It creates a pawn
  	for the given player specified.
        
	 @return None 
    
  	*****************************************************************/
  	public Kight (Player player) {

		super (player);

	}

	//--------------------------------------------------------------//	
	// Override Function Definitions				//
	//--------------------------------------------------------------//  


	/*****************************************************************
  	An overriden acessor method that returns the type of chess peice
  	this class peice is.
        
  	@return The class type of knight as a Piece enum. 
    
  	*****************************************************************/
  	@Override
  	public Piece type () {
    
    	return Piece.KNIGHT;
    
  	}
  	
  	
  	/*****************************************************************
  	An overriden validation method used to make sure that the 
  	requested move to preform is valid.
        
  	@return Whether or not the move was valid.
    
  	*****************************************************************/
	@Override
	public boolean isValidMove(Move move, IChessPiece[][] board) {

		// --- Variable Declarations  -------------------------//

		/* The result of the computation. */
		boolean result;

		// --- Main Routine -----------------------------------//

		// Preform the generic background check.
		result = super.isValidMove(move, board);

		// continue with checking for peice specifics.
		if (result)
		{
		    //TODO implement pawn search.
		}

		// Return the result of the operation.
		return result;

	}

	//--------------------------------------------------------------//  
