package battleship;

import java.awt.event.WindowEvent;
import java.awt.event.WindowListener;
import javax.swing.JFrame;
import javax.swing.JOptionPane;

/* Shannon Haddox and Victor Stasek
 * Tic-Tac-Toe Java Project
 * Dr. Joey Kendall-Morwick
 * 4/20/2015
 */

class Board  implements WindowListener
{
	// ------------------------Win Method--------------------------------
	
  public void win()
  {
      String message = "Congratulations, you win!\nThanks for playing!";	// message for winning
      JOptionPane.showMessageDialog(new JFrame(),  message);				// showDialog for displaying pop up message
      playAgain();														// calls method playAgain
  }
  
  // -------------------------Draw Method--------------------------------
  
  public void draw()
  {
      String message = "Tie!\nThanks for playing!";						// message for a tie
      JOptionPane.showMessageDialog(new JFrame(),  message);				// showDialog for displaying pop up message
      playAgain();														// calls method playAgain
  }
  
  // ------------------------Play Again Method---------------------------
  
  public void playAgain(){
  	String message = "Would you like to play again?";														// message for playing again
  	int n = JOptionPane.showConfirmDialog(new JFrame(), message, "Play Again?", JOptionPane.YES_NO_OPTION);	// showDialog with yes/no option
  	if (n == 1)																								// if no was selected, exit
  	{																										// else will return and start new game
  		System.exit(0);
  	}
  }
  
  // ------------------------Window Listener Methods------------------------
  
  public void windowClosing(WindowEvent we)
  {
      System.exit(0);
  }
  
  public void windowOpened(WindowEvent we)
  {
  }
  
  public void windowClosed(WindowEvent we)
  {
  }
  
  public void windowActivated(WindowEvent we)
  {
  }
  
  public void windowDeactivated(WindowEvent we)
  {
  }
  
  public void windowIconified(WindowEvent we)
  {
  }
  
  public void windowDeiconified(WindowEvent we)
  {
  }
}