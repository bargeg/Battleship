import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.EventQueue;
import java.awt.Font;
import java.awt.GridLayout;

import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.UIManager;

public class Battleship extends JFrame {
		private static final int GRIDSIZE = 10; 
		private static final int NUMBEROFSHIPSPACES = 12;
		private Battleship[] [] terrain = new Battleship [GRIDSIZE] [GRIDSIZE]; 
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
