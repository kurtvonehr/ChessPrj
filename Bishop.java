package chess;

/*--------------------------------------------------------------------*
* Bishop.java                             		                      *
*---------------------------------------------------------------------*
* Description - A class used to emulate a specialized game peice in   *
* the game of chess. The bishop is allowed to move only linear 		  *
* patterns along the line f(x) and -f(x).							  *
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

private Player owner;

public class Bishop extends ChessPiece {
	
	//---------------------------------------------------------------//	
	// Class Variable Definitions                                    //
	//---------------------------------------------------------------//
	
	//---------------------------------------------------------------//	
	// Class Constructors                                            //
	//---------------------------------------------------------------//	
	
	/*****************************************************************
    The primary constructor for the bishop peice. It creates a bishop
    for the given player specified.
        
    @return None 
    
    *****************************************************************/
	public Bishop (Player player) {
		
		super (player);
		
	}
	
	//--------------------------------------------------------------//	
	// Override Function Definitions					      		//
	//--------------------------------------------------------------//
	
	/*****************************************************************
  	An overriden acessor method that returns the type of chess peice
  	this class peice is.
        
  	@return The class type of Bishop as a string. 
    
  	*****************************************************************/
	@Override
	public String type() {
		
		return "Bishop";
		
	}
	
	
	/*****************************************************************
  	An overriden validation method used to make sure that the 
  	requested move to preform is valid.
        
  	@return Whether or not the move was valid.
    
  	*****************************************************************/
	@Override
	public boolean isValidMove(Move move, IChessPiece[][] board) {
		
		// TODO temp set.
		return false;
	}
	
	//--------------------------------------------------------------//

}
