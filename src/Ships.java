import java.awt.Color;
import java.awt.Dimension;

import javax.swing.JButton;

public class Ships extends JButton{
		private static final int SIZE = 50; 
		private int row = 0;
		private int col = 0;
		private boolean shipHit = false;
		private boolean shipRevealed = false; 
		private int totalHit = 0;
		


public Ships (int r, int c) {
	row = r;
	col = c;
	Dimension size = new Dimension (SIZE, SIZE);
	setPreferredSize(size);
}
public void setShip(boolean hasShip) {
	shipHit = hasShip; 
}
public void increaseTotalHit() {
	totalHit += 1; 
}

public void reveal (boolean reveal) {
	shipRevealed = reveal; 
	if (shipRevealed == true) {
		if (shipHit == true) {
		setBackground(Color.BLACK); 	
	}
		else {
			setBackground(Color.CYAN); 
		}
		
		
		
		
	}		
		
		
}
public void reset() {
	shipHit = false;
	shipRevealed = false;
	setBackground(null); 
	setText(""); 
}
public boolean hasShip() {
	return shipHit;
}
public int getRow() {
	return row;
		}
public int getCol() {
	return col;
}
}
