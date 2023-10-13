package view;

import javax.swing.BorderFactory;
import javax.swing.ImageIcon;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.Timer;

import model.Bishop;
import model.Grid;
import model.King;
import model.Knight;
import model.Pawn;
import model.Queen;
import model.Rook;
import model.Stone;
import util.Movement;

import java.awt.Color;
import java.awt.Graphics;
import java.awt.GridLayout;
import java.awt.Point;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;

@SuppressWarnings("serial")
public class GameArea extends JPanel implements ActionListener {

	/**
	 * Create the panel.
	 */
	
	private GamePage parentFrame;
	
	public static Grid[][] gameArray;
	
	public static ArrayList<Stone> stones;
	
	private static final int DELAY = 75;
	
	public static int stepNumber;
	
	Timer timer;
	
	boolean running;
	
	Movement movement;
	
	public GameArea(GamePage parentFrame) {
		
		this.parentFrame = parentFrame;
		Movement.getInstance().setGameAreaObject(this);
		
		setBackground(new Color(0, 0, 0));
		running = false;
		setLayout(new GridLayout(8, 8, 0, 0));
		gameArray = new Grid[8][8];
		stones = new ArrayList<>();
		startTheGame();
	}

	private void startTheGame() {
		fillInTheGrids();
		running = true;
		movement = Movement.getInstance();
		stepNumber = 0;
		timer = new Timer(DELAY, this);
		timer.start();
	}
	
	@Override
	protected void paintComponent(Graphics g) {
		// TODO Auto-generated method stub
		super.paintComponent(g);
		draw(g);
	}
	
	public void draw(Graphics g) {
		
		//for(int i = 0;i < 8; i++) {
			//for(int j = 0;j < 8; j++) {
				//if(!gameArray[i][j].isEmpty()) {
					//Stone stone = discoverStone(i, j);
					//gameArray[i][j].setIcon(new ImageIcon(stone.getIconPath()));
				//}
				//7else {
					//if(movement.getMoveableLocations().con)
				//}
			//}
		//}
		
	
		if(movement.getMoveableLocations() != null) {
			for(Point point : movement.getMoveableLocations()) {
				gameArray[(int)point.getX()][(int)point.getY()].setBorder(BorderFactory.createLineBorder(Color.green, 3));
			}
		}
		
		for(Stone stone : stones) {
			gameArray[stone.getI()][stone.getJ()].setIcon(new ImageIcon(stone.getIconPath()));
		}
		
	}
	
	public static Stone discoverStone(int i, int j) {
		Stone temp = null;
		for(Stone stone : stones) {
			if(stone.getI() == i && stone.getJ() == j) {
				temp = stone;
			}
		}
		return temp;
	}
	
	private void fillInTheGrids() {
		for(int i = 0;i < 8; i++) {
			for(int j = 0;j < 8; j++) {
				Grid grid = new Grid();
				Stone stone = null;
				grid.setI(i);
				grid.setJ(j);
				grid.setOpaque(true);
				grid.setHorizontalAlignment(JLabel.CENTER);
				
				if(i % 2 == 0) {
					if(j % 2 == 0) {
						grid.setBackground(new Color(226, 199, 153));
					}
					else {
						grid.setBackground(new Color(255, 155, 80));
					}
				}
				else {
					if(j % 2 == 0) {
						grid.setBackground(new Color(255, 155, 80));
					}
					else {
						grid.setBackground(new Color(226, 199, 153));
					}
				}
				
				if(i <= 1) {
					
					if(i == 1) {
						stone = new Pawn();
						stone.setIconPath("images/b_pawn.png");
						stone.setName("pawn");
					}
					else {
						if(j == 0 || j == 7) {
							stone = new Rook();
							stone.setIconPath("images/b_rook.png");
							stone.setName("rook");
						}
						else if(j == 1 || j == 6) {
							stone = new Knight();
							stone.setIconPath("images/b_knight.png");
							stone.setName("knight");
						}
						else if(j == 2 || j == 5) {
							stone = new Bishop();
							stone.setIconPath("images/b_bishop.png");
							stone.setName("bishop");
						}
						else if(j == 3) {
							stone = new Queen();
							stone.setIconPath("images/b_queen.png");
							stone.setName("queen");
						}
						else {
							stone = new King();
							stone.setIconPath("images/b_king.png");
							stone.setName("king");
						}
					}
					stone.setI(i);
					stone.setJ(j);
					stones.add(stone);
					stone.setBlack(true);
					grid.setEmpty(false);
				}
				
				else if(i >= 6) {
					if(i == 6) {
						stone = new Pawn();
						stone.setIconPath("images/w_pawn.png");
						stone.setName("pawn");
					}
					else {
						if(j == 0 || j == 7) {
							stone = new Rook();
							stone.setIconPath("images/w_rook.png");
							stone.setName("rook");
						}
						else if(j == 1 || j == 6) {
							stone = new Knight();
							stone.setIconPath("images/w_knight.png");
							stone.setName("knight");
						}
						else if(j == 2 || j == 5) {
							stone = new Bishop();
							stone.setIconPath("images/w_bishop.png");
							stone.setName("bishop");
						}
						else if(j == 3) {
							stone = new Queen();
							stone.setIconPath("images/w_queen.png");
							stone.setName("queen");
						}
						else {
							stone = new King();
							stone.setIconPath("images/w_king.png");
							stone.setName("king");
						}
					}
					stone.setI(i);
					stone.setJ(j);
					stones.add(stone);
					stone.setBlack(false);
					grid.setEmpty(false);
					
				}
				else {
					grid.setEmpty(true);
				}
				gameArray[i][j] = grid;
				add(grid);
			}
		}
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		//System.out.println(timer.getDelay());
		if(running) {
			// we should write here movement events for each stone.
		}
		this.repaint();
		
	}

	public boolean isCheck() {
		ArrayList<Stone> allEatableStones = new ArrayList<>();
		ArrayList<Stone> referenceCarrier;
		boolean isCheck = false;
		boolean isWhite = false;
		if(stepNumber % 2 == 0) {
			// white stones will play
			referenceCarrier = getStonesWithGivenColor("black");
		}
		else {
			// black stones will play
			referenceCarrier = getStonesWithGivenColor("white");
		}
		
		for(Stone stone : referenceCarrier) {
			ArrayList<Point> moveableLocations = stone.showMoveableLocations();
			
			for(Point point : moveableLocations) {
				Stone tempStone = discoverStone((int)point.getX(), (int)point.getY());
				if(tempStone != null) {
					allEatableStones.add(tempStone);
					
				}
			}
		}
		
		
		for(Stone stone : allEatableStones) {
			if(stone.getName().equals("king")) {
				isCheck = true;
				isWhite = stone.isBlack();
			}
		}
		
		if(isCheck) {
			if(!isWhite) {
				parentFrame.lblCheckAndGameOver.setText("King from White Stones");
			}
			else {
				parentFrame.lblCheckAndGameOver.setText("King from Black Stones");
			}
		}
		else {
			parentFrame.lblCheckAndGameOver.setText("");
		}
		return isCheck;
	}
	
	
	private  ArrayList<Stone> getStonesWithGivenColor(String color){
		ArrayList<Stone> stonesWithGivenColor = new ArrayList<>();
		

		if(color.equals("white")) {
			for(Stone stone : stones) {
				if(!stone.isBlack()) {
					stonesWithGivenColor.add(stone);
				}
			}
		}
		else {
			for(Stone stone : stones) {
				if(stone.isBlack()) {
					stonesWithGivenColor.add(stone);
				}
			}
		}
		return stonesWithGivenColor;
	}
}
