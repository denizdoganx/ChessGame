package view;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import java.awt.GridLayout;
import javax.swing.JLabel;
import javax.swing.SwingConstants;

@SuppressWarnings("serial")
public class GamePage extends JFrame {

	private JPanel contentPane;

	/**
	 * Create the frame.
	 */
	public GamePage() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 1000, 750);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));

		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JPanel panel = new JPanel();
		panel.setBounds(50, 50, 600, 614);
		panel.setLayout(new GridLayout(1, 1, 0, 0));
		panel.add(new GameArea());
		contentPane.add(panel);
		
		JPanel panel_1 = new JPanel();
		panel_1.setBounds(10, 50, 30, 614);
		contentPane.add(panel_1);
		panel_1.setLayout(new GridLayout(8, 1, 0, 0));
		
		JLabel lblNewLabel_17 = new JLabel("8");
		lblNewLabel_17.setHorizontalAlignment(SwingConstants.CENTER);
		panel_1.add(lblNewLabel_17);
		
		JLabel lblNewLabel_18 = new JLabel("7");
		lblNewLabel_18.setHorizontalAlignment(SwingConstants.CENTER);
		panel_1.add(lblNewLabel_18);
		
		JLabel lblNewLabel_16 = new JLabel("6");
		lblNewLabel_16.setHorizontalAlignment(SwingConstants.CENTER);
		panel_1.add(lblNewLabel_16);
		
		JLabel lblNewLabel_20 = new JLabel("5");
		lblNewLabel_20.setHorizontalAlignment(SwingConstants.CENTER);
		panel_1.add(lblNewLabel_20);
		
		JLabel lblNewLabel_21 = new JLabel("4");
		lblNewLabel_21.setHorizontalAlignment(SwingConstants.CENTER);
		panel_1.add(lblNewLabel_21);
		
		JLabel lblNewLabel_22 = new JLabel("3");
		lblNewLabel_22.setHorizontalAlignment(SwingConstants.CENTER);
		panel_1.add(lblNewLabel_22);
		
		JLabel lblNewLabel_23 = new JLabel("2");
		lblNewLabel_23.setHorizontalAlignment(SwingConstants.CENTER);
		panel_1.add(lblNewLabel_23);
		
		JLabel lblNewLabel_19 = new JLabel("1");
		lblNewLabel_19.setHorizontalAlignment(SwingConstants.CENTER);
		panel_1.add(lblNewLabel_19);
		
		JPanel panel_2 = new JPanel();
		panel_2.setBounds(50, 11, 600, 28);
		contentPane.add(panel_2);
		panel_2.setLayout(new GridLayout(1, 8, 0, 0));
		
		JLabel lblNewLabel_1 = new JLabel("a");
		lblNewLabel_1.setHorizontalAlignment(SwingConstants.CENTER);
		panel_2.add(lblNewLabel_1);
		
		JLabel lblNewLabel_2 = new JLabel("b");
		lblNewLabel_2.setHorizontalAlignment(SwingConstants.CENTER);
		panel_2.add(lblNewLabel_2);
		
		JLabel lblNewLabel_6 = new JLabel("c");
		lblNewLabel_6.setHorizontalAlignment(SwingConstants.CENTER);
		panel_2.add(lblNewLabel_6);
		
		JLabel lblNewLabel_5 = new JLabel("d");
		lblNewLabel_5.setHorizontalAlignment(SwingConstants.CENTER);
		panel_2.add(lblNewLabel_5);
		
		JLabel lblNewLabel_7 = new JLabel("e");
		lblNewLabel_7.setHorizontalAlignment(SwingConstants.CENTER);
		panel_2.add(lblNewLabel_7);
		
		JLabel lblNewLabel_4 = new JLabel("f");
		lblNewLabel_4.setHorizontalAlignment(SwingConstants.CENTER);
		panel_2.add(lblNewLabel_4);
		
		JLabel lblNewLabel_3 = new JLabel("g");
		lblNewLabel_3.setHorizontalAlignment(SwingConstants.CENTER);
		panel_2.add(lblNewLabel_3);
		
		JLabel lblNewLabel = new JLabel("h");
		lblNewLabel.setHorizontalAlignment(SwingConstants.CENTER);
		panel_2.add(lblNewLabel);
		
		JPanel panel_3 = new JPanel();
		panel_3.setBounds(50, 675, 600, 25);
		contentPane.add(panel_3);
		panel_3.setLayout(new GridLayout(1, 8, 0, 0));
		
		JLabel lblNewLabel_15 = new JLabel("a");
		lblNewLabel_15.setHorizontalAlignment(SwingConstants.CENTER);
		panel_3.add(lblNewLabel_15);
		
		JLabel lblNewLabel_14 = new JLabel("b");
		lblNewLabel_14.setHorizontalAlignment(SwingConstants.CENTER);
		panel_3.add(lblNewLabel_14);
		
		JLabel lblNewLabel_13 = new JLabel("c");
		lblNewLabel_13.setHorizontalAlignment(SwingConstants.CENTER);
		panel_3.add(lblNewLabel_13);
		
		JLabel lblNewLabel_12 = new JLabel("d");
		lblNewLabel_12.setHorizontalAlignment(SwingConstants.CENTER);
		panel_3.add(lblNewLabel_12);
		
		JLabel lblNewLabel_11 = new JLabel("e");
		lblNewLabel_11.setHorizontalAlignment(SwingConstants.CENTER);
		panel_3.add(lblNewLabel_11);
		
		JLabel lblNewLabel_10 = new JLabel("f");
		lblNewLabel_10.setHorizontalAlignment(SwingConstants.CENTER);
		panel_3.add(lblNewLabel_10);
		
		JLabel lblNewLabel_9 = new JLabel("g");
		lblNewLabel_9.setHorizontalAlignment(SwingConstants.CENTER);
		panel_3.add(lblNewLabel_9);
		
		JLabel lblNewLabel_8 = new JLabel("h");
		lblNewLabel_8.setHorizontalAlignment(SwingConstants.CENTER);
		panel_3.add(lblNewLabel_8);
		
		JPanel panel_4 = new JPanel();
		panel_4.setBounds(660, 50, 30, 614);
		contentPane.add(panel_4);
		panel_4.setLayout(new GridLayout(8, 1, 0, 0));
		
		JLabel lblNewLabel_24 = new JLabel("8");
		lblNewLabel_24.setHorizontalAlignment(SwingConstants.CENTER);
		panel_4.add(lblNewLabel_24);
		
		JLabel lblNewLabel_26 = new JLabel("7");
		lblNewLabel_26.setHorizontalAlignment(SwingConstants.CENTER);
		panel_4.add(lblNewLabel_26);
		
		JLabel lblNewLabel_25 = new JLabel("6");
		lblNewLabel_25.setHorizontalAlignment(SwingConstants.CENTER);
		panel_4.add(lblNewLabel_25);
		
		JLabel lblNewLabel_28 = new JLabel("5");
		lblNewLabel_28.setHorizontalAlignment(SwingConstants.CENTER);
		panel_4.add(lblNewLabel_28);
		
		JLabel lblNewLabel_27 = new JLabel("4");
		lblNewLabel_27.setHorizontalAlignment(SwingConstants.CENTER);
		panel_4.add(lblNewLabel_27);
		
		JLabel lblNewLabel_30 = new JLabel("3");
		lblNewLabel_30.setHorizontalAlignment(SwingConstants.CENTER);
		panel_4.add(lblNewLabel_30);
		
		JLabel lblNewLabel_31 = new JLabel("2");
		lblNewLabel_31.setHorizontalAlignment(SwingConstants.CENTER);
		panel_4.add(lblNewLabel_31);
		
		JLabel lblNewLabel_29 = new JLabel("1");
		lblNewLabel_29.setHorizontalAlignment(SwingConstants.CENTER);
		panel_4.add(lblNewLabel_29);
		
		
		setVisible(true);
		setLocationRelativeTo(null);
	}
	
	

}
