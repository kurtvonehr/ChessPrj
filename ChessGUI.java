package chess;

/*--------------------------------------------------------------------*
* ChessGUI.java                             		                  *
*---------------------------------------------------------------------*
* Description - A class that builds a JFrame ("frame") which contains *
* a new ChessPanel object ("panel")									  *
*---------------------------------------------------------------------*
* Project: Project 3 : Chess Game	                                  *
* Author : Kenneth Aernouts, 										  *
* Group : McKim A. Jacob, Vonehr Kurt, Aernouts Kenneth				  *
* Date: 3/13/2014			                                          *
*---------------------------------------------------------------------*/

import java.awt.Dimension;
import javax.swing.JFrame;

public class ChessGUI {

	public static void main(String[] args) {
		
		// --- Variable Declarations  -------------------------//
		
		/* The frame used to display the chess board. */
		JFrame frame;
		
		/* The chess pane that contains the visual game board. */
		ChessPanel panel;
		
		// --- Main Routine -----------------------------------//
		
		// Create the jframe.
	    frame = new JFrame("Chess Game");
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		
		// Create the game panel.
	    panel = new ChessPanel();
		frame.getContentPane().add(panel);
		
		// Define the dimensions of the frame.
		frame.setMinimumSize(new Dimension(500, 500));
		frame.setResizable(false);
		
		// Build and display the frame.
		frame.pack();
		frame.setVisible(true);
		
	}

}
