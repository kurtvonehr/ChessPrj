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
		super(Player);
		
	}
	
	//--------------------------------------------------------------//	
	// Override Function Definitions					      		//
	//--------------------------------------------------------------//
	
	
	@Override
	public String type() {
		return "Bishop";
		
	}
	
	
	@Override
	public boolean isValidMove(Move move, IChessPiece[][] board) {
		return false;
	}
	
	@Override
	public String type() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public boolean isValidMove(Move move, IChessPiece[][] board) {
		// TODO Auto-generated method stub
		return false;
	}
	
	
	boolean inGrid (int xPos, int yPos) {
		
		//TODO Add in this feature to allow checking of grid locations
		//validating that the give position is within the bounds of the
		//board. NEED TO TAKE INTO ACCOUNT DIMENSIONS OF GRID.
	}

	
	//--------------------------------------------------------------//

}
