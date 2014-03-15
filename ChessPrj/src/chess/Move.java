package chess;

/**
 * Packages the four components of a move into a single object.    (Instance variables are public because this object
 * is a simple container.)
 *
 * @author Kurt VonEhr, Jacob Mckim, 
 */

public class Move {

   public int fromRow, fromColumn, toRow, toColumn;

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

	public Move() {
    }

    public Move(int fromRow, int fromColumn, int toRow, int toColumn) {
      this.fromRow = fromRow;
      this.fromColumn = fromColumn;
      this.toRow = toRow;
      this.toColumn = toColumn;
   }
}
