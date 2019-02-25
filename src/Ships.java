import java.awt.Dimension;

import javax.swing.JButton;

public class Ships extends JButton{
		private static final int SIZE = 50; 
		private int row = 0;
		private int col = 0;
		private boolean shipHit = false;
		private boolean shipRevealed = false; 


public Ships (int r, int c) {
	row = r;
	col = c;
	Dimension size = new Dimension (SIZE, SIZE);
	setPreferredSize(size);
}
public void setShip(boolean hasShip) {
	shipHit = hasShip; 
}
}
