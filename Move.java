package chess;

/*--------------------------------------------------------------------*
* Move.java                             		             		  *
*---------------------------------------------------------------------*
 * Description - Packages the four components of a move into a 		  *
 * single object. (Instance variables are public because this object  *
 * is a simple container.)    					 					  *
*---------------------------------------------------------------------*
* Project: Project 3 : Chess 	                                      *
* Author : McKim A. Jacob, Vonehr Kurt, Aernouts Kenneth	          *
* Date Of Creation: 3 - 1 - 2014                                      *                          
*---------------------------------------------------------------------*/

public class Move {

	//---------------------------------------------------------------//	
	// Class Variable Definitions                                    //
	//---------------------------------------------------------------//
	
	/* The row to move from. */
   public int fromRow;
   
   /* The column to move from. */
   public int fromColumn; 
   
   /* The row to move to. */
   public int toRow;
   
   /* The column to move to. */
   public int toColumn;
   
   //---------------------------------------------------------------//	
   // Class Constructors                                            //
   //---------------------------------------------------------------//	
   
	public Move() {
    
	}

	
    public Move(int fromRow, int fromColumn, int toRow, int toColumn) {
      this.fromRow = fromRow;
      this.fromColumn = fromColumn;
      this.toRow = toRow;
      this.toColumn = toColumn;
    }
   
	//--------------------------------------------------------------//	
	// Function Definitions											//
	//--------------------------------------------------------------//

    public int getFromRow() {
    	return fromRow;
	}
	
	public void setFromRow(int fromRow) {
		this.fromRow = fromRow;
	}
	
	public int getFromColumn() {
		return fromColumn;
	}
	
	public void setFromColumn(int fromColumn) {
		this.fromColumn = fromColumn;
	}
	
	public int getToRow() {
		return toRow;
	}
	
	public void setToRow(int toRow) {
		this.toRow = toRow;
	}
	
	public int getToColumn() {
		return toColumn;
	}
	
	public void setToColumn(int toColumn) {
		this.toColumn = toColumn;
	}
	
	//--------------------------------------------------------------//
	
}
