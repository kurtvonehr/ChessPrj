package chess;

/*--------------------------------------------------------------------*
* Player.java                             		             		  *
*---------------------------------------------------------------------*
* Description - An enumeration to name off the players currently 	  *
* Involved in the game. 					 					  	  *
*---------------------------------------------------------------------*
* Project: Project 3 : Chess 	                                      *
* Author : McKim A. Jacob, Vonehr Kurt, Aernouts Kenneth	          *
* Date Of Creation: 3 - 1 - 2014                                      *                          
*---------------------------------------------------------------------*/

public enum Player {
	
   BLACK, WHITE, NOBODY;

   /****************************************************************
    * Return the {@code Player} whose turn is next.
    *
    * @return the {@code Player} whose turn is next.
    * 
    ***************************************************************/
   public Player next() {
      return this == BLACK ? WHITE : BLACK;
   }
   
}
