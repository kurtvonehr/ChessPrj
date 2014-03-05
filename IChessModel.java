package chess;

/**
 * Objects implementing this interface represent the state of a chess game.   Notice that this interface is designed
 * to maintain the game state only, it does not provide any methods to control the flow of the game.
 *
 * @author Kurt VonEhr, Jacob Mckim, 
 */

public interface IChessModel {

	private IChessPiece[][] board; 
	 private Player player; 
	 // declare other instance variables as needed 
	 
	 public ChessModel() { 
	 // complete this 
	 } 
	 
	 public boolean isComplete() { 
	 return false; 
	 } 
	 
	 public boolean isValidMove(Move moce) { 
	 // complete this 
	 } 
	 
	 public void move(Move move) { 
	 // complete this 
	 } 
	 
	 public boolean inCheck(Player p) { 
	 return false; 
	 } 
	 
	 public Player currentPlayer() { 
	 // complete this 
	 } 
	 
	 public int numRows() { 
	 // complete this 
	 } 
	 
	 public int numColumns() { 
	 // complete this 
	 } 
	 
	 public IChessPiece pieceAt(int row, int column) { 
	 // complete this 
	 } 

}
