package chess;

/**
 * Describes a piece for a game of chess (King, Queen, Rook, etc.)
 *
 * @author Kurt VonEhr, Jacob Mckim, 
 */
// Created  12/3/12 at 3:29 PM
// (C) Zachary Kurmas 2012

public interface IChessPiece {


   /****************************************************************
   * This method returns the player that owns this piece.
   *
   * @return the player that owns this piece.
   * 
   *****************************************************************/
   Player player();


   /****************************************************************
   * This method returns the type of this piece ("King", "Queen", 
   * "Rook", etc.).  Note:  In this case "type" refers to the game.
   * of chess, not the type of the Java class.
   *
   * @return the type of this piece
   * 
   *****************************************************************/
   String type();


   /****************************************************************
   * This method returns whether the piece at location 
   * {@code [move.fromRow, move.fromColumn]} is allowed to move to 
   * location {@code [move.fromRow, move.fromColumn]}.
   *
   * @param move  a {@link ChessPrj.Move} object describing the 
   * move to be made.
   * 
   * @param board the {@link ChessPrj.IChessBoard} in which this
   * piece resides.
   * 
   * @return {@code true} if the proposed move is valid, 
   * {@code false} otherwise.
   * 
   * @throws IndexOutOfBoundsException if either {@code [move.fromRow,
   * move.fromColumn]} or {@code [move.toRow, move.toColumn]} don't 
   * represent valid locations on the board.
   * 
   * @throws IllegalArgumentException  if {@code this} object isn't 
   * the piece at location {@code [move.fromRow, move.fromColumn]}.
   * 
   *****************************************************************/
   boolean isValidMove(Move move, IChessPiece[][] board);
   
   /****************************************************************
   * This method validates that a move postion is within the grid.
   *
   * @return Whether or not the move is in the grid. 
   * 
   *****************************************************************/
   boolean inGrid (int xPos, int yPos);

}
