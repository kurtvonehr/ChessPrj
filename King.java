package chess;

private Player owner;

public class King extends ChessPiece {
	
	public Bishop (Player player) {
		this.owner = player;
		
	}
	
	@Override
	public String type() {
		return "King";	
	}
	
	
	@Override
	public boolean isValidMove(Move move, IChessPiece[][] board) {
		return false;
	}
	
	
	boolean inGrid (int xPos, int yPos) {
		
		//TODO Add in this feature to allow checking of grid locations
		//validating that the give position is within the bounds of the
		//board. NEED TO TAKE INTO ACCOUNT DIMENSIONS OF GRID.
	}
}
