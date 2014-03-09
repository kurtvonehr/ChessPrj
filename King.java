package chess;

public class King extends ChessPiece {
	
	public King(Player player) {
		super(player);
		// TODO Auto-generated constructor stub
	}
	
	@Override
	public Piece type() {
		return Piece.KING;	
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
