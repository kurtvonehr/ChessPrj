package chess;

/*--------------------------------------------------------------------*
* King.java                             		              *
*---------------------------------------------------------------------*
* Description - A class used to emulate a specialized game peice in   *
* the game of chess. The King is the key peice to wining the game of  *
* chess. It can only move in single steps at a time.	              *
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

public class King extends ChessPiece {
	
	//---------------------------------------------------------------//	
	// Class Variable Definitions                                    //
	//---------------------------------------------------------------//
	
	//---------------------------------------------------------------//	
	// Class Constructors                                            //
	//---------------------------------------------------------------//	

	/*****************************************************************
  	The primary constructor for the king piece. It creates a king
  	for the given player specified.
        
	 @return None 
    
  	*****************************************************************/
	public King (Player player) {
		super(player);
	}
	
	
	//--------------------------------------------------------------//	
	// Override Function Definitions				//
	//--------------------------------------------------------------//  


	/*****************************************************************
  	An overriden acessor method that returns the type of chess peice
  	this class peice is.
        
  	@return The class type of pawn as a string. 
    
  	*****************************************************************/
	@Override
	public Piece type() {
		return Piece.KING;	
	}
	
	
	/*****************************************************************
  	An overriden validation method used to make sure that the 
  	requested move to preform is valid.
        
  	@return Whether or not the move was valid.
    
  	*****************************************************************/
	@Override
	public boolean isValidMove(Move move, IChessPiece[][] board) {
		
		boolean validMove = true;
		//If move is greater than one square in any direction, 
		//move is invalid.
		
		if(abs((move.getToRow() - move.getFromRow()))>1)
			validMove = false;
		if(abs((move.getToColumn() - move.getFromColumn()))>1)
			validMove = false;
		if(move.getToColumn == move.getFromColumn)
			if(move.getToRow == move.getFromRow)
				validMove = false;
		return validMove;
	}
	
	//--------------------------------------------------------------//  
}
