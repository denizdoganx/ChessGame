package view;


import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

@SuppressWarnings("serial")
public class StartPage extends JFrame {

	private JPanel contentPane;

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
				new GamePage();
			}
		});
		btnNewButton.setFocusable(false);
		btnNewButton.setBounds(115, 73, 194, 37);
		contentPane.add(btnNewButton);
		
		JButton btnNewButton_1 = new JButton("Continue Where You Left Off");
		btnNewButton_1.setFocusable(false);
		btnNewButton_1.setBounds(115, 121, 194, 37);
		contentPane.add(btnNewButton_1);
		
		
		setLocationRelativeTo(null);
		setVisible(true);
	}
}
