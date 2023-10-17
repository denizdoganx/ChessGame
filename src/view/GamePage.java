package view;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import model.Stone;

import java.awt.GridLayout;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.SwingConstants;
import java.awt.Font;
import java.awt.Color;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.awt.event.ActionEvent;

@SuppressWarnings("serial")
public class GamePage extends JFrame {

	private JPanel contentPane;
	public JLabel lblCheckAndGameOver;
	public JLabel numOfMoves;
	

	/**
	 * Create the frame.
	 */
	public GamePage(boolean isSavedGame) {
		
		
		
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 1000, 750);
		contentPane = new JPanel();
		contentPane.setBackground(new Color(0, 0, 0));
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));

		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JPanel panel = new JPanel();
		panel.setBackground(new Color(0, 0, 0));
		panel.setBounds(50, 50, 600, 614);
		panel.setLayout(new GridLayout(1, 1, 0, 0));
		panel.add(new GameArea(this, isSavedGame));
		contentPane.add(panel);
		
		JPanel panel_1 = new JPanel();
		panel_1.setBackground(new Color(0, 0, 0));
		panel_1.setBounds(10, 50, 30, 614);
		contentPane.add(panel_1);
		panel_1.setLayout(new GridLayout(8, 1, 0, 0));
		
		JLabel lblNewLabel_17 = new JLabel("8");
		lblNewLabel_17.setForeground(Color.gray);
		lblNewLabel_17.setHorizontalAlignment(SwingConstants.CENTER);
		panel_1.add(lblNewLabel_17);
		
		JLabel lblNewLabel_18 = new JLabel("7");
		lblNewLabel_18.setForeground(Color.gray);
		lblNewLabel_18.setHorizontalAlignment(SwingConstants.CENTER);
		panel_1.add(lblNewLabel_18);
		
		JLabel lblNewLabel_16 = new JLabel("6");
		lblNewLabel_16.setForeground(Color.gray);
		lblNewLabel_16.setHorizontalAlignment(SwingConstants.CENTER);
		panel_1.add(lblNewLabel_16);
		
		JLabel lblNewLabel_20 = new JLabel("5");
		lblNewLabel_20.setForeground(Color.gray);
		lblNewLabel_20.setHorizontalAlignment(SwingConstants.CENTER);
		panel_1.add(lblNewLabel_20);
		
		JLabel lblNewLabel_21 = new JLabel("4");
		lblNewLabel_21.setForeground(Color.gray);
		lblNewLabel_21.setHorizontalAlignment(SwingConstants.CENTER);
		panel_1.add(lblNewLabel_21);
		
		JLabel lblNewLabel_22 = new JLabel("3");
		lblNewLabel_22.setForeground(Color.gray);
		lblNewLabel_22.setHorizontalAlignment(SwingConstants.CENTER);
		panel_1.add(lblNewLabel_22);
		
		JLabel lblNewLabel_23 = new JLabel("2");
		lblNewLabel_23.setForeground(Color.gray);
		lblNewLabel_23.setHorizontalAlignment(SwingConstants.CENTER);
		panel_1.add(lblNewLabel_23);
		
		JLabel lblNewLabel_19 = new JLabel("1");
		lblNewLabel_19.setForeground(Color.gray);
		lblNewLabel_19.setHorizontalAlignment(SwingConstants.CENTER);
		panel_1.add(lblNewLabel_19);
		
		JPanel panel_2 = new JPanel();
		panel_2.setBackground(new Color(0, 0, 0));
		panel_2.setBounds(50, 11, 600, 28);
		contentPane.add(panel_2);
		panel_2.setLayout(new GridLayout(1, 8, 0, 0));
		
		JLabel lblNewLabel_1 = new JLabel("a");
		lblNewLabel_1.setForeground(Color.gray);
		lblNewLabel_1.setHorizontalAlignment(SwingConstants.CENTER);
		panel_2.add(lblNewLabel_1);
		
		JLabel lblNewLabel_2 = new JLabel("b");
		lblNewLabel_2.setForeground(Color.gray);
		lblNewLabel_2.setHorizontalAlignment(SwingConstants.CENTER);
		panel_2.add(lblNewLabel_2);
		
		JLabel lblNewLabel_6 = new JLabel("c");
		lblNewLabel_6.setForeground(Color.gray);
		lblNewLabel_6.setHorizontalAlignment(SwingConstants.CENTER);
		panel_2.add(lblNewLabel_6);
		
		JLabel lblNewLabel_5 = new JLabel("d");
		lblNewLabel_5.setForeground(Color.gray);
		lblNewLabel_5.setHorizontalAlignment(SwingConstants.CENTER);
		panel_2.add(lblNewLabel_5);
		
		JLabel lblNewLabel_7 = new JLabel("e");
		lblNewLabel_7.setForeground(Color.gray);
		lblNewLabel_7.setHorizontalAlignment(SwingConstants.CENTER);
		panel_2.add(lblNewLabel_7);
		
		JLabel lblNewLabel_4 = new JLabel("f");
		lblNewLabel_4.setForeground(Color.gray);
		lblNewLabel_4.setHorizontalAlignment(SwingConstants.CENTER);
		panel_2.add(lblNewLabel_4);
		
		JLabel lblNewLabel_3 = new JLabel("g");
		lblNewLabel_3.setForeground(Color.gray);
		lblNewLabel_3.setHorizontalAlignment(SwingConstants.CENTER);
		panel_2.add(lblNewLabel_3);
		
		JLabel lblNewLabel = new JLabel("h");
		lblNewLabel.setForeground(Color.gray);
		lblNewLabel.setHorizontalAlignment(SwingConstants.CENTER);
		panel_2.add(lblNewLabel);
		
		JPanel panel_3 = new JPanel();
		panel_3.setBackground(new Color(0, 0, 0));
		panel_3.setBounds(50, 675, 600, 25);
		contentPane.add(panel_3);
		panel_3.setLayout(new GridLayout(1, 8, 0, 0));
		
		JLabel lblNewLabel_15 = new JLabel("a");
		lblNewLabel_15.setForeground(Color.gray);
		lblNewLabel_15.setHorizontalAlignment(SwingConstants.CENTER);
		panel_3.add(lblNewLabel_15);
		
		JLabel lblNewLabel_14 = new JLabel("b");
		lblNewLabel_14.setForeground(Color.gray);
		lblNewLabel_14.setHorizontalAlignment(SwingConstants.CENTER);
		panel_3.add(lblNewLabel_14);
		
		JLabel lblNewLabel_13 = new JLabel("c");
		lblNewLabel_13.setForeground(Color.gray);
		lblNewLabel_13.setHorizontalAlignment(SwingConstants.CENTER);
		panel_3.add(lblNewLabel_13);
		
		JLabel lblNewLabel_12 = new JLabel("d");
		lblNewLabel_12.setForeground(Color.gray);
		lblNewLabel_12.setHorizontalAlignment(SwingConstants.CENTER);
		panel_3.add(lblNewLabel_12);
		
		JLabel lblNewLabel_11 = new JLabel("e");
		lblNewLabel_11.setForeground(Color.gray);
		lblNewLabel_11.setHorizontalAlignment(SwingConstants.CENTER);
		panel_3.add(lblNewLabel_11);
		
		JLabel lblNewLabel_10 = new JLabel("f");
		lblNewLabel_10.setForeground(Color.gray);
		lblNewLabel_10.setHorizontalAlignment(SwingConstants.CENTER);
		panel_3.add(lblNewLabel_10);
		
		JLabel lblNewLabel_9 = new JLabel("g");
		lblNewLabel_9.setForeground(Color.gray);
		lblNewLabel_9.setHorizontalAlignment(SwingConstants.CENTER);
		panel_3.add(lblNewLabel_9);
		
		JLabel lblNewLabel_8 = new JLabel("h");
		lblNewLabel_8.setForeground(Color.gray);
		lblNewLabel_8.setHorizontalAlignment(SwingConstants.CENTER);
		panel_3.add(lblNewLabel_8);
		
		JPanel panel_4 = new JPanel();
		panel_4.setBackground(new Color(0, 0, 0));
		panel_4.setBounds(660, 50, 30, 614);
		contentPane.add(panel_4);
		panel_4.setLayout(new GridLayout(8, 1, 0, 0));
		
		JLabel lblNewLabel_24 = new JLabel("8");
		lblNewLabel_24.setForeground(Color.gray);
		lblNewLabel_24.setHorizontalAlignment(SwingConstants.CENTER);
		panel_4.add(lblNewLabel_24);
		
		JLabel lblNewLabel_26 = new JLabel("7");
		lblNewLabel_26.setForeground(Color.gray);
		lblNewLabel_26.setHorizontalAlignment(SwingConstants.CENTER);
		panel_4.add(lblNewLabel_26);
		
		JLabel lblNewLabel_25 = new JLabel("6");
		lblNewLabel_25.setForeground(Color.gray);
		lblNewLabel_25.setHorizontalAlignment(SwingConstants.CENTER);
		panel_4.add(lblNewLabel_25);
		
		JLabel lblNewLabel_28 = new JLabel("5");
		lblNewLabel_28.setForeground(Color.gray);
		lblNewLabel_28.setHorizontalAlignment(SwingConstants.CENTER);
		panel_4.add(lblNewLabel_28);
		
		JLabel lblNewLabel_27 = new JLabel("4");
		lblNewLabel_27.setForeground(Color.gray);
		lblNewLabel_27.setHorizontalAlignment(SwingConstants.CENTER);
		panel_4.add(lblNewLabel_27);
		
		JLabel lblNewLabel_30 = new JLabel("3");
		lblNewLabel_30.setForeground(Color.gray);
		lblNewLabel_30.setHorizontalAlignment(SwingConstants.CENTER);
		panel_4.add(lblNewLabel_30);
		
		JLabel lblNewLabel_31 = new JLabel("2");
		lblNewLabel_31.setForeground(Color.gray);
		lblNewLabel_31.setHorizontalAlignment(SwingConstants.CENTER);
		panel_4.add(lblNewLabel_31);
		
		JLabel lblNewLabel_29 = new JLabel("1");
		lblNewLabel_29.setForeground(Color.gray);
		lblNewLabel_29.setHorizontalAlignment(SwingConstants.CENTER);
		panel_4.add(lblNewLabel_29);
		
		JPanel panel_5 = new JPanel();
		panel_5.setBackground(new Color(0, 0, 0));
		panel_5.setBounds(700, 50, 274, 377);
		contentPane.add(panel_5);
		panel_5.setLayout(new GridLayout(2, 1, 0, 5));
		
		JPanel panel_6 = new JPanel();
		panel_6.setBackground(new Color(0, 0, 0));
		panel_5.add(panel_6);
		panel_6.setLayout(null);
		
		JLabel lblNewLabel_32 = new JLabel("White Player");
		lblNewLabel_32.setForeground(new Color(255, 255, 255));
		lblNewLabel_32.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel_32.setFont(new Font("Tahoma", Font.BOLD, 18));
		lblNewLabel_32.setBounds(10, 11, 254, 45);
		panel_6.add(lblNewLabel_32);
		
		JPanel panel_7 = new JPanel();
		panel_7.setBackground(new Color(0, 0, 0));
		panel_5.add(panel_7);
		panel_7.setLayout(null);
		
		JLabel lblNewLabel_32_1 = new JLabel("Black Player");
		lblNewLabel_32_1.setForeground(new Color(255, 255, 255));
		lblNewLabel_32_1.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel_32_1.setFont(new Font("Tahoma", Font.BOLD, 18));
		lblNewLabel_32_1.setBounds(10, 11, 254, 45);
		panel_7.add(lblNewLabel_32_1);
		
		lblCheckAndGameOver = new JLabel();
		lblCheckAndGameOver.setForeground(new Color(255, 0, 0));
		lblCheckAndGameOver.setHorizontalAlignment(SwingConstants.CENTER);
		lblCheckAndGameOver.setFont(new Font("Tahoma", Font.BOLD, 18));
		lblCheckAndGameOver.setBounds(700, 438, 274, 46);
		contentPane.add(lblCheckAndGameOver);
		
		JLabel lblNewLabel_33 = new JLabel("");
		lblNewLabel_33.setForeground(new Color(255, 0, 0));
		lblNewLabel_33.setFont(new Font("Tahoma", Font.BOLD, 18));
		lblNewLabel_33.setBounds(700, 495, 274, 46);
		contentPane.add(lblNewLabel_33);
		
		numOfMoves = new JLabel("Number of Moves : ");
		numOfMoves.setForeground(new Color(255, 0, 0));
		numOfMoves.setFont(new Font("Tahoma", Font.BOLD, 15));
		numOfMoves.setBounds(700, 552, 274, 46);
		contentPane.add(numOfMoves);
		
		JButton btnNewButton = new JButton("Save This Game");
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				try {
					saveGame();
				} catch (IOException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}
			}
		});
		btnNewButton.setForeground(new Color(255, 0, 0));
		btnNewButton.setBackground(new Color(0, 0, 0));
		btnNewButton.setFocusable(false);
		btnNewButton.setFont(new Font("Tahoma", Font.BOLD, 18));
		btnNewButton.setBounds(700, 609, 274, 55);
		contentPane.add(btnNewButton);
		
		
		setVisible(true);
		setLocationRelativeTo(null);
	}
	
	public void saveGame() throws IOException {
		File file = new File(StartPage.filePath);
		int result = -1;
		if(!file.exists()) {
			file.createNewFile();
			result = 0;
		}
		else {
			result = JOptionPane.showConfirmDialog(null, "There is a previously saved game. Do you approve to be written on it?", "?", JOptionPane.YES_NO_OPTION, JOptionPane.QUESTION_MESSAGE);
		}
		if(result == 0) {
			FileWriter fw = new FileWriter(file);
			BufferedWriter bw = new BufferedWriter(fw);
			String rowString;
			for(Stone stone : GameArea.stones) {
				rowString = "";
				rowString += stone.getI();
				rowString += ";";
				rowString += stone.getJ();
				rowString += ";";
				rowString += stone.getName();
				rowString += ";";
				rowString += stone.isMoved();
				rowString += ";";
				rowString += stone.isBlack();
				rowString += ";";
				rowString += stone.getIconPath();
				rowString += ";";
				bw.write(rowString);
				bw.newLine();
			}
			bw.write("stepnumber " + String.valueOf(GameArea.stepNumber));
			bw.newLine();
			bw.close();
			JOptionPane.showMessageDialog(null, "Saved Successfully!", "Info", JOptionPane.INFORMATION_MESSAGE);
		}
	}
	
}
