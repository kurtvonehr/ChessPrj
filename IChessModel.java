package chess;

/**
 * Objects implementing this interface represent the state of a chess game.   Notice that this interface is designed
 * to maintain the game state only, it does not provide any methods to control the flow of the game.
 *
 * @author Kurt VonEhr, Jacob Mckim, 
 */

public interface IChessModel {


     /****************************************************************
     * This method returns whether the game is complete.
     *
     * @return {@code true} if complete, {@code false} otherwise.
     * 
     *****************************************************************/
     public boolean isComplete();
     
     
     /****************************************************************
     * This method returns whether the piece at location {
     * @code [move.fromRow, move.fromColumn]} is allowed to move to 
     * location{@code [move.fromRow, move.fromColumn]}.
     *
     * @param move a {@link Move} object describing the move to be made.
     * 
     * @return {@code true} if the proposed move is valid, {@code false} 
     * otherwise.
     * 
     * @throws IndexOutOfBoundsException if either {@code [move.fromRow, 
     * move.fromColumn]} or {@code [move.toRow,move.toColumn]} don't 
     * represent valid locations on the board.
     * 
     *****************************************************************/
     public boolean isValidMove(Move move);
     
     
     /****************************************************************
     * This method moves the piece from location {@code [move.fromRow,
     * move.fromColumn]} to location {@code [move.fromRow,move.
     * fromColumn]}.
     *
     * @param move a {@link Move} object describing the move to be
     * made.
     * 
     * @returns None
     * 
     * @throws IndexOutOfBoundsException if either {@code [move.fromRow,
     * move.fromColumn]} or {@code [move.toRow,move.toColumn]} don't 
     * represent valid locations on the board.
     * 
     *****************************************************************/
     
     public void move(Move move);
     
     
     /****************************************************************
     * This method reports whether the current player is in check.
     *
     * @return {@code true} if the current player is in check, 
     * {@code false} otherwise.
     * 
     *****************************************************************/
     public boolean inCheck(Player p);
     
     
     /****************************************************************
     * This method returns the current player.
     *
     * @return the current player.
     * 
     *****************************************************************/
     public Player currentPlayer(); 
     
     
     /****************************************************************
     * This method reports back the number of rows that are on the 
     * board.
     *
     * @return The row count as an integer.
     * 
     *****************************************************************/
     public int numRows();
     
     
     /****************************************************************
     * This method reports back the number of columns that are on the 
     * board.
     *
     * @return The column count as an integer.
     * 
     *****************************************************************/
     public int numColumns();
     
     
     /****************************************************************
     * This method returns the {@code ChessPiece} object at location 
     * {@code [row, column]}.
     *
     * @param row    the row (numbered {@code 0} through 
     * {@code numRows -1}
     * 
     * @param column the row (numbered {@code 0} through 
     * {@code numColumns -1}
     * 
     * @return the {@code ChessPiece} object at location 
     * {@code [row, column]}.
     * 
     * @throws IndexOutOfBoundsException if {@code [row, column]} is 
     * not a valid location on the board.
     * 
     *****************************************************************/
     public IChessPiece pieceAt(int row, int column);

}
