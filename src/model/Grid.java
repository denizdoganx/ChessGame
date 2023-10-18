package model;

import java.awt.Color;
import java.awt.Point;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.util.ArrayList;

import javax.swing.BorderFactory;
import javax.swing.JLabel;
import javax.swing.JOptionPane;

import util.Movement;
import view.GameArea;

@SuppressWarnings("serial")
public class Grid extends JLabel implements MouseListener {

	private boolean isEmpty;
	
	private int i, j;
	
	private Movement movement;
	
	public Grid() {
		this.addMouseListener(this);
		this.movement = Movement.getInstance();
	}
	public boolean isEmpty() {
		return isEmpty;
	}

	public void setEmpty(boolean isEmpty) {
		this.isEmpty = isEmpty;
	}
	public int getI() {
		return i;
	}
	public void setI(int i) {
		this.i = i;
	}
	public int getJ() {
		return j;
	}
	public void setJ(int j) {
		this.j = j;
	}
	@Override
	public void mouseClicked(MouseEvent e) {
		
	}
	
	
	@Override
	public void mousePressed(MouseEvent e) {
		// TODO Auto-generated method stub
		
	}
	@Override
	public void mouseReleased(MouseEvent e) {
		if(!isEmpty()) {
			//System.out.println((GameArea.discoverStone(i, j)).getName());
			//System.out.println((GameArea.discoverStone(i, j).isBlack()));
			Stone stone = GameArea.discoverStone(i, j);
			boolean flag;
			if(GameArea.stepNumber % 2 == 0) {
				if(!stone.isBlack()) {
					flag = true;
				}
				else {
					flag = false;
				}
			}
			else {
				if(stone.isBlack()) {
					flag = true;
				}
				else {
					flag = false;
				}
			}
			if(flag) {
				ArrayList<Point> moveableLocations = stone.showMoveableLocations();
				movement.deleteMoveableLocationsTracks();
				movement.setFirstStone(stone);
				movement.setMoveableLocations(moveableLocations);
				movement.setStartGrid(this);
			}
			else {
				if(movement.getFirstStone() != null) {
					boolean isEatable = false;
					if(movement.getFirstStone().isBlack() && !stone.isBlack()) {
						// Black stone will eat a white stone
						isEatable = true;
					}
					if(!movement.getFirstStone().isBlack() && stone.isBlack()) {
						// White stone will eat a black stone
						isEatable = true;
					}
					if(isEatable) {
						Point point = new Point(getI(), getJ());
						ArrayList<Point> moveableLocations = movement.getMoveableLocations();
						if(moveableLocations != null && moveableLocations.contains(point)) {
							movement.setEatenStone(stone);
							movement.setEndGrid(this);
							boolean control = movement.eatAgainstStone();
							if(control) {
								promotion();
							}
						}
					}
				}
			}
		}
		else {
			Point point = new Point(getI(), getJ());
			ArrayList<Point> moveableLocations = movement.getMoveableLocations();
			if(moveableLocations != null) {
				if(moveableLocations.contains(point)) {
					movement.setEndGrid(this);
					boolean control = movement.performMovement();
					if(control) {
						promotion();
					}
				}
			}
		}
		
	}
	
	private void promotion() {
		Stone temp = GameArea.discoverStone(getI(), getJ());
		if(temp.getName().equals("pawn") && (getI() == 0 || getI() == 7)) {
			String response = "";
			
			while(!response.equals("rook") && !response.equals("knight") && !response.equals("bishop") && !response.equals("queen")) {
				response = JOptionPane.showInputDialog("Which stone would you like to take ? (rook, knight, bishop or queen)");
				response = response.toLowerCase();
			}
			GameArea.stones.remove(temp);
			Stone stoneToBeTaken = null;
			if(response.equals("rook")) {
				stoneToBeTaken = new Rook();
				stoneToBeTaken.setName("rook");
				if(GameArea.stepNumber % 2 == 0) {
					stoneToBeTaken.setIconPath("images/b_rook.png");
				}
				else {
					stoneToBeTaken.setIconPath("images/w_rook.png");
				}
			}
			else if(response.equals("knight")) {
				stoneToBeTaken = new Knight();
				stoneToBeTaken.setName("knight");
				if(GameArea.stepNumber % 2 == 0) {
					stoneToBeTaken.setIconPath("images/b_knight.png");
				}
				else {
					stoneToBeTaken.setIconPath("images/w_knight.png");
				}
			}
			else if(response.equals("bishop")) {
				stoneToBeTaken = new Bishop();
				stoneToBeTaken.setName("bishop");
				if(GameArea.stepNumber % 2 == 0) {
					stoneToBeTaken.setIconPath("images/b_bishop.png");
				}
				else {
					stoneToBeTaken.setIconPath("images/w_bishop.png");
				}
			}
			else if(response.equals("queen")) {
				stoneToBeTaken = new Queen();
				stoneToBeTaken.setName("queen");
				if(GameArea.stepNumber % 2 == 0) {
					stoneToBeTaken.setIconPath("images/b_queen.png");
				}
				else {
					stoneToBeTaken.setIconPath("images/w_queen.png");
				}
			}
			
			stoneToBeTaken.setI(getI());
			stoneToBeTaken.setJ(getJ());
			if(GameArea.stepNumber % 2 == 0) {
				stoneToBeTaken.setBlack(true);
			}
			else {
				stoneToBeTaken.setBlack(false);
			}
			stoneToBeTaken.setMoved(true);
			GameArea.stones.add(stoneToBeTaken);
		}
	}
	
	@Override
	public void mouseEntered(MouseEvent e) {
		this.setBorder(BorderFactory.createLineBorder(Color.white, 3));
	}
	@Override
	public void mouseExited(MouseEvent e) {
		this.setBorder(null);
		
	}
}
