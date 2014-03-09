package chess;

public class Pawn extends ChessPiece {
  
	//---------------------------------------------------------------//	
	// Class Variable Definitions                                    //
	//---------------------------------------------------------------//
	
	private ChessModel model;
	
	//---------------------------------------------------------------//	
	// Class Constructors                                            //
	//---------------------------------------------------------------//	
	
	/*****************************************************************
  	The primary constructor for the bishop peice. It creates a bishop
  	for the given player specified.
        
	 @return None 
    
  	*****************************************************************/
  	public Pawn () {
		
		// Get the model object for help with control.
		model = ChessModel.getInstance ();
		
	}

	//--------------------------------------------------------------//	
	// Override Function Definitions					      		//
	//--------------------------------------------------------------//  

	/*****************************************************************
  	An overriden acessor method that returns the type of chess peice
  	this class peice is.
        
  	@return The class type of pawn as a string. 
    
  	*****************************************************************/
  	@Override
  	public String type () {
    
    	return "Pawn";
    
  	}
  
	@Override
	public boolean isValidMove(Move move, IChessPiece[ ][ ] board) {
		
		// Preform the generic background check.
		super(move,board);
		
		// continue with checking for peice specifics.
		if (result)
		{
			//TODO implement pawn search.
		}
		
		// Return the result of the operation.
		return result;
		
	}
	
}
