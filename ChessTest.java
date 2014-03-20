package chess;

/*--------------------------------------------------------------------*
* ChessTest.java                             		             	  *
*---------------------------------------------------------------------*
* Description - A class used to JUnit test the basic configuration of *
* the board as well as a few simple move commands upon start up of 	  *
* the game.															  *
*---------------------------------------------------------------------*
* Project: Project 3 : Chess 	                                      *
* Author : McKim A. Jacob, Vonehr Kurt, Aernouts Kenneth	          *
* Date Of Creation: 3 - 1 - 2014                                      *                          
*---------------------------------------------------------------------*/

import static org.junit.Assert.*;

import org.junit.Test;

public class ChessTest {
	
	//---------------------------------------------------------------//	
	// Class Variable Definitions                                    //
	//---------------------------------------------------------------//
	
	/* the master control object. */
	ChessModel model;
	
	//---------------------------------------------------------------//	
	// Class Constructors                                            //
	//---------------------------------------------------------------//	
	
	public ChessTest () {
		
		// Create a new game board controller.
		model = new ChessModel();
		
	}
	
	//--------------------------------------------------------------//	
	// JUNIT TESTING						     					//
	//--------------------------------------------------------------//  

	@Test
	public void test() {
		
		// --- Variable Declarations  -------------------------//
		
		/* The move object to test isValidMove states. */
		Move move;
		
		// --- Main Routine -----------------------------------//
		
		// ============== Test initial board dimensions ============ //

		// Test initial board Row dimension.
		assertEquals(8, model.numRows());
		
		// Test initial board Column dimension.
		assertEquals(8, model.numColumns());
		
		// =============== Test current player toggle ============== //
		
		// Test initial setup.
		assertEquals(Player.WHITE, model.currentPlayer());
		
		// Test current opponent.
		assertEquals(Player.BLACK, model.getOpposingPlayer());
		
		// Test a turn change. 
		assertEquals(Player.BLACK, model.nextTurn());
		
		// Test current opponent.
		assertEquals(Player.WHITE, model.getOpposingPlayer());
		
		// Test the current player.
		assertEquals(Player.BLACK, model.currentPlayer());

		// Test a turn change. 
		assertEquals(Player.WHITE, model.nextTurn());
		
		// ============ Test current State of the Game ============= //

		// Check if white is in check. 
		assertEquals(false, model.inCheck(Player.WHITE));
		
		// Check if black is in check. 
		assertEquals(false, model.inCheck(Player.BLACK));

		// Check if white is in check mate. 
		assertEquals(false, model.inCheckMate(Player.WHITE));
		
		// Check if black is in check mate. 
		assertEquals(false, model.inCheckMate(Player.BLACK));
		
		// Check that were not at the end of the game.
		assertEquals(false, model.isComplete());
		
		// === Test the generic isvalidMove in base chess piece === //
		
		// Test no mover entered.
		assertEquals(false, model.isValidMove(null));
				
		// Test same spot.
		move = new Move (1, 0, 0, 1);
		assertEquals(false, model.isValidMove(move));
		
		// Test same user piece.
		move = new Move (1, 0, 0, 2);
		assertEquals(false, model.isValidMove(move));
		
		// Test from piece != null.
		move = new Move (3, 0, 0, 1);
		assertEquals(false, model.isValidMove(move));
		
		
		// ================= Test Piece Types ================= //
		
		// Test for black ROOK one.
		assertEquals( Piece.ROOK, model.pieceAt(0, 0).type() );
		
		// Test for black KNIGHT one.
		assertEquals( Piece.KNIGHT, model.pieceAt(0, 1).type() );
		
		// Test for black BISHOP one.
		assertEquals( Piece.BISHOP, model.pieceAt(0, 2).type() );
		
		// Test for black QUEEN.
		assertEquals( Piece.QUEEN, model.pieceAt(0, 3).type() );
		
		// Test for black KING.
		assertEquals( Piece.KING, model.pieceAt(0, 4).type() );
		
		// Test for black BISHOP two.
		assertEquals( Piece.BISHOP, model.pieceAt(0, 5).type() );
		
		// Test for black KNIGHT two.
		assertEquals( Piece.KNIGHT, model.pieceAt(0, 6).type() );
		
		// Test for black ROOK two.
		assertEquals( Piece.ROOK, model.pieceAt(0, 7).type() );
		
		// Test for seven black pawns.
		for (int i = 0; i < 8; i++)
			assertEquals( Piece.PAWN, model.pieceAt(1, i).type() );
		
		// Test for white ROOK one.
		assertEquals( Piece.ROOK, model.pieceAt(7, 0).type() );
		
		// Test for white KNIGHT one.
		assertEquals( Piece.KNIGHT, model.pieceAt(7, 1).type() );
		
		// Test for white BISHOP one.
		assertEquals( Piece.BISHOP, model.pieceAt(7, 2).type() );
		
		// Test for white QUEEN.
		assertEquals( Piece.QUEEN, model.pieceAt(7, 3).type() );
		
		// Test for white KING.
		assertEquals( Piece.KING, model.pieceAt(7, 4).type() );
		
		// Test for white BISHOP two.
		assertEquals( Piece.BISHOP, model.pieceAt(7, 5).type() );
		
		// Test for white KNIGHT two.
		assertEquals( Piece.KNIGHT, model.pieceAt(7, 6).type() );
		
		// Test for white ROOK two.
		assertEquals( Piece.ROOK, model.pieceAt(7, 7).type() );
		
		// Test for seven white pawns.
		for (int i = 0; i < 8; i++)
			assertEquals( Piece.PAWN, model.pieceAt(6, i).type() );
		
		// Test middle rows for null.
		for (int a = 3; a < 6; a++)
		{
			for (int b = 0; b < 8; b++)
				assertEquals( null, model.pieceAt(a, b) );
		}
		
		// ================= Test Piece Colors ================= //
		
		// Make sure all the pieces belong to the black player.
		for (int j = 0; j < 2; j++)
		{
			for (int k = 0; k < 8; k++)
				assertEquals( Player.BLACK, model.pieceAt(j, k).
														player() );
			
		}
		
		// Make sure all the pieces belong to the white player.
		for (int j = 6; j < 8; j++)
		{
			for (int k = 0; k < 8; k++)
				assertEquals( Player.WHITE, model.pieceAt(j, k).
														player() );
			
		}
		
	}
	
	//--------------------------------------------------------------//  

}
