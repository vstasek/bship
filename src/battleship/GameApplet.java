//GameApplet.java

package battleship;

import java.applet.Applet;
import java.awt.BasicStroke;
import java.awt.Color;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.awt.event.WindowEvent;
import java.awt.event.WindowListener;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JOptionPane;

public class GameApplet extends Applet
implements MouseListener, ActionListener, WindowListener
{
	// --------------------------------Global Variables---------------------------------
	
    JFrame frame;				// JFrame for displaying the game
    int flag = 2;				// Flag to keep track of the player
    int n;						// n (x coord) for drawing the objects on screen
    int m;						// y (y coord) for drawing the objects on screen
    int i = 0;					// var i used in for loops
    static int outcome = 0;		// outcome that keeps track of the final state of the board (used for wins/ties)
    char[] ch = new char[9];	// array that keeps track of the location of the xs and os
    JButton clear;				// JButton for clearing the game board
    JButton exit;				// JButton for exiting the game
    
    // ----------------------------------------------------------------------------------
    
    public GameApplet()
    {
    	/* Setting up the window for our game */
    	
        frame = new JFrame("Tic-Tac-Toe");					// Creating a new window and giving it a name
        clear = new JButton("CLEAR BOARD");					// Creating the clear button
        exit = new JButton("EXIT GAME");					// Creating the exit button
        frame.add(clear);									// adding the clear button to our window
        frame.add(exit);									// adding the exit button to our window 
        frame.addWindowListener(this);						// adding a window listener for interacting
        frame.getContentPane().setBackground(Color.WHITE);	// setting the background color to white
        frame.setLayout(null);								// specifying we do not want a layout manager
        frame.setVisible(true);								// making our window content visible
        frame.setSize(600, 450);							// setting the size of our window
        clear.setBounds(450, 50, 120, 60);					// setting the size of our clear button
        exit.setBounds(450, 250, 120, 60);					// setting the size of our exit button
        
        /* telling our listeners to listen to our gameApplet */
        frame.addMouseListener(this);
        clear.addActionListener(this);
        exit.addActionListener(this);
        
        /* initializing the array to be 'B' for blank */
        for (i = 0; i < 9; i += 1) {
        	ch[i] = 'B';
        }
        
        String message = "Click a square to start the game!";	// message for start up dialog
        JOptionPane.showMessageDialog(new JFrame(),  message);	// displays start up dialog
        
        /* drawing the lines on the window for our game */
        Graphics g = frame.getGraphics();
        g.drawLine(150, 0, 150, 450);
        g.drawLine(300, 0, 300, 450);
        g.drawLine(0, 150, 450, 150);
        g.drawLine(0, 300, 450, 300);
    }
    
    //----------------------------------Action Event Methods------------------------------------
    
    public void actionPerformed(ActionEvent ae)
    {
        if (ae.getSource() == clear)			// if we have clicked the clear button
        {
            frame.setVisible(false);			
            outcome = 0;						// no outcome has occurred
            new GameApplet();					// restart the game
        }
        if (ae.getSource() == exit)				// if we have selected exit
        {
            System.exit(0);						// exit the game
        }
    }
    
    public void windowClosing(WindowEvent de)
    {
    System.exit(0); }
    
    public void windowOpened(WindowEvent de) { }
    
    public void windowClosed(WindowEvent de) { }
    
    public void windowActivated(WindowEvent de) { }
    
    public void windowDeactivated(WindowEvent de) { }
    
    public void windowIconified(WindowEvent de) { }
    
    public void windowDeiconified(WindowEvent de) {  }
    
    // ----------------------------Mouse Clicked Methods--------------------------------------------
    
    public void mouseClicked(MouseEvent e) { 
        flag -= 1;				// initialize flag to -1
        int x = e.getX();		// get the x value of where we clicked
        int y = e.getY();		// get the y value of where we clicked
        
        /* if flag is 1 or if we are player O 
         *  Goes through a series of checks to see where we have clicked
         *  m and n are the amount we need to update by to draw within the square
         *  Adds an 'R' to the array in the corresponding position and calls the drawO method
         */
        if (flag == 1)
        {
            if ((x < 150) && (y < 150)) 
            { 
            	m = 0;
            	n = 0;
            	ch[0] = 'R';
            	drawO();
            }
            if ((x > 150) && (x < 300) && (y < 150)) 
            { 
            	m = 150; 
            	n = 0; 
            	ch[1] = 'R'; 
            	drawO();
            }
            if ((x > 300) && (x < 450) && (y < 150)) 
            {
            	m = 300;
            	n = 0;
            	ch[2] = 'R';
            	drawO();
            }
            if ((x < 150) && (y > 150) && (y < 300)) 
            {
            	m = 0;
            	n = 150;
            	ch[3] = 'R';
            	drawO();
            }
            if ((x > 150) && (x < 300) && (y > 150) && (y < 300)) 
            {
            	m = 150;
            	n = 150;
            	ch[4] = 'R';
            	drawO();
            }
            if ((x > 300) && (x < 450) && (y > 150) && (y < 300)) 
            {
            	m = 300;
            	n = 150;
            	ch[5] = 'R';
            	drawO();
            }
            if ((x < 150) && (y > 300) && (y < 450)) 
            {
            	m = 0;
            	n = 300;
            	ch[6] = 'R';
            	drawO();
            }
            if ((x > 150) && (x < 300) && (y > 300) && (y < 450)) 
            {
            	m = 150;
            	n = 300;
            	ch[7] = 'R';
            	drawO();
            }
            if ((x > 300) && (x < 450) && (y > 300) && (y < 450))
            {
            	m = 300;
            	n = 300;
            	ch[8] = 'R';
            	drawO();
            }
        }
        
        /* if flag is 0 or if we are player X 
         *  Goes through a series of checks to see where we have clicked
         *  m and n are the amount we need to update by to draw within the square
         *  Adds an 'P' to the array in the corresponding position and calls the drawX method
         */
        
        if (flag == 0)
        {
            if ((x < 150) && (y < 150)) 
            {
            	m = 0;
            	n = 0;
            	ch[0] = 'P';
            	drawX();
            }
            if ((x > 150) && (x < 300) && (y < 150)) 
            {
            	m = 150;
            	n = 0;
            	ch[1] = 'P';
            	drawX();
            }
            if ((x > 300) && (x < 450) && (y < 150)) 
            {
            	m = 300;
            	n = 0;
            	ch[2] = 'P';
            	drawX();
            }
            if ((x < 150) && (y > 150) && (y < 300)) 
            {
            	m = 0;
            	n = 150;
            	ch[3] = 'P';
            	drawX();
            }
            if ((x > 150) && (x < 300) && (y > 150) && (y < 300)) 
            {
            	m = 150;
            	n = 150;
            	ch[4] = 'P';
            	drawX();
            }
            if ((x > 300) && (x < 450) && (y > 150) && (y < 300)) 
            {
            	m = 300;
            	n = 150;
            	ch[5] = 'P';
            	drawX();
            }
            if ((x < 150) && (y > 300) && (y < 450)) 
            {
            	m = 0;
            	n = 300;
            	ch[6] = 'P';
            	drawX();
            }
            if ((x > 150) && (x < 300) && (y > 300) && (y < 450)) 
            {
            	m = 150;
            	n = 300;
            	ch[7] = 'P';
            	drawX();
            }
            if ((x > 300) && (x < 450) && (y > 300) && (y < 450)) 
            {
            	m = 300;
            	n = 300;
            	ch[8] = 'P';
            	drawX();
            }
            
            flag += 2;					// increments flag so we alternate players
        }
        
        // ------------------Loops to check for a winner--------------------------
        
        /* checking for a winner vertically */
        for (i = 0; i < 3; i += 1)
        {
            if ((ch[i] != 'B') && (ch[(i + 3)] == ch[i]) && (ch[(i + 6)] == ch[i]))	// if there are three in a row
            {
                new Board().win();					// we have a winner!
                outcome = 1;
                frame.setVisible(false);
                new GameApplet();
            }
        }
        
        /* checking for a winner horizontally */
        for (i = 0; i < 7; i += 1)
        {
            if (ch[i] != 'B')											// start with one
            {
                if ((ch[i] == ch[(i + 1)]) && (ch[i] == ch[(i + 2)]))	// check the next to positions
                {
                    new Board().win();									// we have a winner!
                    outcome = 1;
                    frame.setVisible(false);
                    new GameApplet();
                }
                i += 2;
            }
            
            else 														// else, nothing yet. Keep looking.
            {
                i += 2;
            }
        }
        
        /* final check if both for loops have failed to check for a winner diagonally */
        if ((ch[4] != 'B') && ((((ch[0] == ch[4]) && (ch[4] == ch[8])) || ((ch[2] == ch[4]) && (ch[4] == ch[6])))))
        {
            new Board().win();											// we have a winner!
            outcome = 1;
            frame.setVisible(false);
            new GameApplet();
        }
        
        /* if all has failed, we have a draw. Saftey check to make sure something didn't go wrong with our checks */
        for (i = 0; (i < 9) && (ch[i] != 'B'); i += 1)
        {
            if (i == 8)
            {
                if (outcome == 0){
                	new Board().draw();									// call draw
                	outcome = 0;
                	frame.setVisible(false);
                	new GameApplet();
                }
            }
        }
    }
    
    // -------------------------- Other Mouse Event Methods ---------------------------
    
    /* defaulted to not do anything because we want nothing to be displayed */
    
    public void mouseReleased(MouseEvent e)
    {
        System.out.print("");
    }
    
    public void mouseEntered(MouseEvent e)
    {
        System.out.print("");
    }
    
    public void mouseExited(MouseEvent e) {
        System.out.print("");
    }
    
    public void mousePressed(MouseEvent e) {
        System.out.print("");
    }
    
    // -------------------------Drawing O--------------------------------------
    
    public void drawO(){
    	Graphics2D g2;
        Graphics g = frame.getGraphics();
        g.setColor(new Color(178, 102, 255));		// setting the color for our Os
        g2 = (Graphics2D)g;
        g2.setStroke(new BasicStroke(10.0F));		// setting the width
        g.drawOval(m + 10, n + 10, 130, 130);		// drawing the oval based on the m and n values
    }
    
    // -------------------------Drawing X--------------------------------------
    
    public void drawX(){
    	Graphics2D g2;
        Graphics g = frame.getGraphics();
        g.setColor(new Color(0, 255, 255));				// setting the color for our Xs
        g2 = (Graphics2D)g;
        g2.setStroke(new BasicStroke(10.0F));			// setting the width
        g.drawLine(m + 10, n + 13, m + 130, n + 130);	// drawing one line of the x
        g.drawLine(m + 130, n + 10, m + 10, n + 130);	// drawing the other line of the x
    }
  
    // -------------------------Main--------------------------------------------
    
    public static void main(String[] args)
    {
        new GameApplet();	// creating a new GameApplet
    }
}