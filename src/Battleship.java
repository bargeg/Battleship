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
		private static final int GRIDSIZE = 10; 
		private static final int NUMBEROFSHIPSPACES = 12;
		private Ships[] [] water = new Ships [GRIDSIZE] [GRIDSIZE]; 
		private int totalHit = 0; 
		
		public Battleship() {
			initGUI(); 
			setShips();
			
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
					water[r][c] = new Ships(r,c);
					water[r][c].addActionListener(new ActionListener(){
						public void actionPerformed (ActionEvent e) {
							Ships button = (Ships) e.getSource();
							int row = button.getRow();
							int col = button.getCol();
							spaceClicked(row,col);
						}
					});
					centerPanel.add(water[r][c]);
				} 
			} 
		}
		private void spaceClicked (int row, int col) {
			if (water[row][col].hasShip()) {
				totalHit += 1;
				water[row][col].reveal(true);
				
				if (totalHit == NUMBEROFSHIPSPACES) {
				String message = "You win! Do you want to play again?";
				promptForNewGame(message);
			
		} }
		}
		private void setShips() {
			Random rand = new Random();
			int pickRow;
			int pickCol;
			for (int i = 0; i < NUMBEROFSHIPSPACES; i++) {
				do {
					pickRow = rand.nextInt(GRIDSIZE);
					pickCol = rand.nextInt(GRIDSIZE);
					
				}
				while (water[pickRow][pickCol].hasShip());
				water[pickRow][pickCol].setShip(true);
			}
				//addToNeighborsHoleCount(pickRow, pickCol);
				//terrain[pickRow][pickCol].reveal(true);
			}
		private void showShips() {
			for (int row = 0; row <GRIDSIZE; row++){
				for ( int col = 0; col <GRIDSIZE; col++  ) {
					if (water[row][col].hasShip()) {
						water[row][col].reveal(true);
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
					water[row][col].reset(); 
				} }
			setShips(); 
			totalHit = 0; 
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
