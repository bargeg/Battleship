import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.EventQueue;
import java.awt.Font;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.Random;

import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.UIManager;

public class Battleship extends JFrame {
		private static final int GRIDSIZE = 6; 
		private static final int NUMBEROFSHIPSPACES = 12;
		private Ships[] [] compWater = new Ships [GRIDSIZE] [GRIDSIZE];
		private Ships [] [] playerWater = new Ships [GRIDSIZE][GRIDSIZE];
		private int totalPlayerHit = 0;
		private int totalCompHit = 0; 
		
		public Battleship() {
			JOptionPane.showMessageDialog(null, "Welcome to Battleship! \n Your goal is to race against the computer to see who can win! \n You must hit all 12 targets! Good luck! ");
			initGUI(); 
			setCompShips();
			setPlayShips(); 
			
			setTitle("Battleship");
			setSize(700,500); //pixels
			setResizable(false);
			setLocationRelativeTo(null);
			setVisible(true);
			setDefaultCloseOperation(EXIT_ON_CLOSE);
		}
		public void initGUI(){
			//Title!!
			
			JLabel titleLabel = new JLabel("Battleship");
			add(titleLabel, BorderLayout.PAGE_START);
			titleLabel.setHorizontalAlignment(JLabel.CENTER); 
			//customize label
			Font titleFont = new Font ("Bitter" , Font.BOLD + Font.ITALIC,  48);
			titleLabel.setFont(titleFont);
			titleLabel.setForeground(Color.CYAN);
			titleLabel.setBackground(Color.BLACK);
			titleLabel.setOpaque(true);
			JPanel centerPanel = new JPanel();
			centerPanel.setLayout(new GridLayout(GRIDSIZE, GRIDSIZE));
			add(centerPanel, BorderLayout.CENTER);
			
			for (int r = 0; r < GRIDSIZE; r++) {
				for (int c = 0; c < GRIDSIZE; c++) {
					compWater[r][c] = new Ships(r,c);
					compWater[r][c].addActionListener(new ActionListener(){
						public void actionPerformed (ActionEvent e) {
							Ships button = (Ships) e.getSource();
							int row = button.getRow();
							int col = button.getCol();
							spaceClicked(row,col);
						}
					});
					centerPanel.add(compWater[r][c]);
				} 
			} 
		}
		private void spaceClicked (int row, int col) {
			if (compWater[row][col].hasShip()) {
				totalPlayerHit += 1;
				compWater[row][col].reveal(true);
				if (totalPlayerHit == NUMBEROFSHIPSPACES) {
				String message = "You win! Do you want to play again?";
				promptForNewGame(message);
			
		} }
			else {
				compWater[row][col].setText("x");
			}
			int compRow = (int) (Math.random () * 5) +0;
			int compCol = (int) (Math.random () * 5) +0;
			if (playerWater[compRow][compCol].hasShip()) {
				totalCompHit += 1;
				JOptionPane.showMessageDialog(null, "The computer hit one of your ships! It has hit" + totalCompHit + "ships...");  
				if (totalCompHit == NUMBEROFSHIPSPACES) {
					String message = "You win! Do you want to play again?";
					promptForNewGame(message);
				
			} }
			
		}
		private void setCompShips() {
			Random rand = new Random();
			int pickRow;
			int pickCol;
			for (int i = 0; i < NUMBEROFSHIPSPACES; i++) {
				do {
					pickRow = rand.nextInt(GRIDSIZE);
					pickCol = rand.nextInt(GRIDSIZE);
					
				}
				while (compWater[pickRow][pickCol].hasShip());
				compWater[pickRow][pickCol].setShip(true);
			}
				//addToNeighborsHoleCount(pickRow, pickCol);
				//terrain[pickRow][pickCol].reveal(true);
			}
		private void setPlayShips() {
			Random rand = new Random();
			int pickRow;
			int pickCol;
			for (int i = 0; i < NUMBEROFSHIPSPACES; i++) {
				do {
					pickRow = rand.nextInt(GRIDSIZE);
					pickCol = rand.nextInt(GRIDSIZE);
					
				}
				while (playerWater[pickRow][pickCol].hasShip());
				playerWater[pickRow][pickCol].setShip(true);
			}
				//addToNeighborsHoleCount(pickRow, pickCol);
				//terrain[pickRow][pickCol].reveal(true);
			}
		private void showShips() {
			for (int row = 0; row <GRIDSIZE; row++){
				for ( int col = 0; col <GRIDSIZE; col++  ) {
					if (compWater[row][col].hasShip()) {
						compWater[row][col].reveal(true);
					}
				}
			}
		}
		private void promptForNewGame(String mess) {
			showShips();
			int option = JOptionPane.showConfirmDialog(this, mess, "Play Again?", JOptionPane.YES_NO_OPTION);
			if (option == JOptionPane.YES_OPTION) {
				newGame();
			}
			else {
				System.exit(0);
			}
			
		}
		private void newGame() {
			for (int row = 0; row <GRIDSIZE; row++){
				for ( int col = 0; col <GRIDSIZE; col++  ) {
					compWater[row][col].reset(); 
				} }
			setCompShips(); 
			setPlayShips(); 
			totalCompHit = 0; 
			totalPlayerHit = 0; 
		}
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		try {
            String className = UIManager.getCrossPlatformLookAndFeelClassName();
            UIManager.setLookAndFeel(className);
        } catch ( Exception e) {}
        
        EventQueue.invokeLater(new Runnable (){
            @Override
            public void run() {
                new Battleship();
            }   
        });
	}

}
