package chess;

import java.awt.Dimension;
import javax.swing.JFrame;

/*--------------------------------------------------------------------*
* ChessGUI.java                             		                  *
*---------------------------------------------------------------------*
* Description - A class that builds a JFrame ("frame") which contains *
* a new ChessPanel object ("panel")									  *
*---------------------------------------------------------------------*
* Project: Project 3 : Chess Game	                                  *
* Author : Kenneth Aernouts  										  *
* Group : McKim A. Jacob, Vonehr Kurt, Aernouts Kenneth				  *
* Date: 3/13/2014			                                          *
*---------------------------------------------------------------------*
* ISSUES AND NOTES						                              *	                                      
*---------------------------------------------------------------------*                            
*                                 
*---------------------------------------------------------------------*/

public class ChessGUI {

	public static void main(String[] args) {
		
		JFrame frame = new JFrame("A Fabulous Chess Game");
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		
		ChessPanel panel = new ChessPanel();
		frame.getContentPane().add(panel);
		
		frame.setMinimumSize(new Dimension(500, 500));
		frame.setResizable(false);
		
		frame.pack();
		frame.setVisible(true);
	}
}