package view;


import javax.swing.JFrame;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import model.Bishop;
import model.King;
import model.Knight;
import model.Pawn;
import model.Queen;
import model.Rook;
import model.Stone;

import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.awt.event.ActionEvent;

@SuppressWarnings("serial")
public class StartPage extends JFrame {

	private JPanel contentPane;
	
	public static final String filePath = "savedGame.txt";
	
	public static ArrayList<Stone> registeredStones;
	
	public static int registeredStepNumber;
	/**
	 * Create the frame.
	 */
	public StartPage() {
		setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		setBounds(100, 100, 450, 300);
		
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));

		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JButton btnNewButton = new JButton("New Game");
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				StartPage.this.dispose();
				new GamePage(false);
			}
		});
		btnNewButton.setFocusable(false);
		btnNewButton.setBounds(115, 73, 194, 37);
		contentPane.add(btnNewButton);
		
		JButton btnNewButton_1 = new JButton("Continue Where You Left Off");
		btnNewButton_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				try {
					if(uploadWhereYouLeftOff()) {
						StartPage.this.dispose();
						new GamePage(true);
					}
				} catch (IOException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}
			}
		});
		btnNewButton_1.setFocusable(false);
		btnNewButton_1.setBounds(115, 121, 194, 37);
		contentPane.add(btnNewButton_1);
		
		
		setLocationRelativeTo(null);
		setVisible(true);
	}
	
	public boolean uploadWhereYouLeftOff() throws IOException {
		File f = new File(filePath);
		
		if(f.exists()) {
			FileReader fr = new FileReader(f);
			BufferedReader br = new BufferedReader(fr);
			registeredStones = new ArrayList<>();
			String line = null;
			String[] stoneDetails;
			Stone tempStone = null;
			while((line = br.readLine()) != null) {
				
				
				if(line.startsWith("stepnumber")) {
					stoneDetails = line.split(" ");
					registeredStepNumber = Integer.valueOf(stoneDetails[1]);
				}
				else {
					stoneDetails = line.split(";");
					
					switch (stoneDetails[2]) {
					case "pawn":
						tempStone = new Pawn();
						break;
					case "rook":
						tempStone = new Rook();
						break;
					case "knight":
						tempStone = new Knight();
						break;
					case "bishop":
						tempStone = new Bishop();
						break;
					case "queen":
						tempStone = new Queen();
						break;
					case "king":
						tempStone = new King();
						break;
					}
					tempStone.setI(Integer.valueOf(stoneDetails[0]));
					tempStone.setJ(Integer.valueOf(stoneDetails[1]));
					tempStone.setName(stoneDetails[2]);
					tempStone.setMoved(Boolean.valueOf(stoneDetails[3]));
					tempStone.setBlack(Boolean.valueOf(stoneDetails[4]));
					tempStone.setIconPath(stoneDetails[5]);
					registeredStones.add(tempStone);
				}
			}
			br.close();
			return true;
		}
		else {
			JOptionPane.showMessageDialog(null, "No saved game found!", "Error!", JOptionPane.ERROR_MESSAGE);
			return false;
		}
	}
}
