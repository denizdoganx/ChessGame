package util;

import java.awt.Point;
import java.util.ArrayList;

import javax.swing.Icon;
import javax.swing.JOptionPane;

import model.Grid;
import model.Stone;
import view.GameArea;

public class Movement {

	
	private static Movement instance = null;
	
	private ArrayList<Point> moveableLocations;
	
	private Grid startGrid;
	
	private Grid endGrid;
	
	private Stone firstStone;
	
	private Stone eatenStone;
	
	private GameArea gameArea;
	
	private Icon oldIcon;
	
	private int oldI, oldJ;
	
	private boolean oldMoved;
	
	private boolean oldEndGridEmpty;
	
	private Movement() {
		
	}
	
	public void setGameAreaObject(GameArea gameArea) {
		this.gameArea = gameArea;
	}
	
	public static Movement getInstance() {
		if(instance == null) {
			instance = new Movement();
		}
		return instance;
	}

	public ArrayList<Point> getMoveableLocations() {
		return moveableLocations;
	}

	public void setMoveableLocations(ArrayList<Point> moveableLocations) {
		this.moveableLocations = moveableLocations;
	}

	public Grid getStartGrid() {
		return startGrid;
	}

	public void setStartGrid(Grid startGrid) {
		this.startGrid = startGrid;
	}

	public Grid getEndGrid() {
		return endGrid;
	}

	public void setEndGrid(Grid endGrid) {
		this.endGrid = endGrid;
	}

	public Stone getFirstStone() {
		return firstStone;
	}

	public void setFirstStone(Stone stone) {
		this.firstStone = stone;
	}
	
	public Stone getEatenStone() {
		return eatenStone;
	}

	public void setEatenStone(Stone eatenStone) {
		this.eatenStone = eatenStone;
	}

	public void deleteMoveableLocationsTracks() {
		if(getMoveableLocations() != null) {
			Grid[][] gameArray = GameArea.gameArray;
			for(Point point : getMoveableLocations()) {
				gameArray[(int)point.getX()][(int)point.getY()].setBorder(null);
			}
		}
		moveableLocations = null;
	}
	
	public boolean performMovement() {
		this.oldIcon = startGrid.getIcon();
		this.oldMoved = firstStone.isMoved();
		this.oldI = firstStone.getI();
		this.oldJ = firstStone.getJ();
		this.oldEndGridEmpty = endGrid.isEmpty();
		startGrid.setEmpty(true);
		startGrid.setIcon(null);
		endGrid.setEmpty(false);
		firstStone.setI(endGrid.getI());
		firstStone.setJ(endGrid.getJ());
		firstStone.setMoved(true);
		deleteMoveableLocationsTracks();
		GameArea.stepNumber++;
		boolean resultOfWhiteStones = gameArea.isCheck("black");
		boolean resultOfBlackStones = gameArea.isCheck("white");
		boolean returnflag = true;
		if(resultOfWhiteStones) {
			if(GameArea.stepNumber % 2 == 0) {
				gameArea.parentFrame.lblCheckAndGameOver.setText("King from black stones!");
			}
			else {
				if(returnflag) {
					resetMovement();
					gameArea.parentFrame.lblCheckAndGameOver.setText("This move cannot be done!");
					returnflag = false;
				}
			}
		}
		
		if(resultOfBlackStones) {
			if(GameArea.stepNumber % 2 != 0) {
				gameArea.parentFrame.lblCheckAndGameOver.setText("King from white stones!");
			}
			else {
				if(returnflag) {
					resetMovement();
					gameArea.parentFrame.lblCheckAndGameOver.setText("This move cannot be done!");
					returnflag = false;
				}
			}
		}
		
		if(!resultOfBlackStones && !resultOfWhiteStones) {
			gameArea.parentFrame.lblCheckAndGameOver.setText("");
		}
		
		return returnflag;
		
	}
	
	private void resetMovement() {
		startGrid.setEmpty(false);
		startGrid.setIcon(this.oldIcon);
		endGrid.setEmpty(this.oldEndGridEmpty);
		firstStone.setI(oldI);
		firstStone.setJ(oldJ);
		firstStone.setMoved(oldMoved);
		deleteMoveableLocationsTracks();
		GameArea.stepNumber--;
	}
	
	public boolean eatAgainstStone() {
		GameArea.stones.remove(this.eatenStone);
		if(!performMovement()) {
			GameArea.stones.add(this.eatenStone);
			return false;
		}
		return true;
	}
	
	public boolean makeQueenSideCastling() {
		boolean flag = false;;
		if(GameArea.stepNumber % 2 == 0) {
			Stone rook = GameArea.discoverStone(7, 0);
			Stone empty1 = GameArea.discoverStone(7, 1);
			Stone empty2 = GameArea.discoverStone(7, 2);
			Stone empty3 = GameArea.discoverStone(7, 3);
			Stone king = GameArea.discoverStone(7, 4);
			if(king != null && rook != null && empty1 == null && empty2 == null && empty3 == null) {
				if(!king.isBlack() && !rook.isBlack()) {
					if(king.getName().equals("king") && rook.getName().equals("rook")) {
						if(!king.isMoved() && !rook.isMoved()) {
							king.setMoved(true);
							rook.setMoved(true);
							king.setJ(2);
							rook.setJ(3);
							GameArea.stepNumber++;
							GameArea.gameArray[7][0].setEmpty(true);
							GameArea.gameArray[7][1].setEmpty(true);
							GameArea.gameArray[7][2].setEmpty(false);
							GameArea.gameArray[7][3].setEmpty(false);
							GameArea.gameArray[7][4].setEmpty(true);
							GameArea.gameArray[7][0].setIcon(null);
							GameArea.gameArray[7][4].setIcon(null);
							flag = true;
						}
					}
				}
			}
		}
		else {
			Stone rook = GameArea.discoverStone(0, 0);
			Stone empty1 = GameArea.discoverStone(0, 1);
			Stone empty2 = GameArea.discoverStone(0, 2);
			Stone empty3 = GameArea.discoverStone(0, 3);
			Stone king = GameArea.discoverStone(0, 4);
			if(king != null && rook != null && empty1 == null && empty2 == null && empty3 == null) {
				if(king.isBlack() && rook.isBlack()) {
					if(king.getName().equals("king") && rook.getName().equals("rook")) {
						if(!king.isMoved() && !rook.isMoved()) {
							king.setMoved(true);
							rook.setMoved(true);
							king.setJ(2);
							rook.setJ(3);
							GameArea.stepNumber++;
							GameArea.gameArray[0][0].setEmpty(true);
							GameArea.gameArray[0][1].setEmpty(true);
							GameArea.gameArray[0][2].setEmpty(false);
							GameArea.gameArray[0][3].setEmpty(false);
							GameArea.gameArray[0][4].setEmpty(true);
							GameArea.gameArray[0][0].setIcon(null);
							GameArea.gameArray[0][4].setIcon(null);
							flag = true;
						}
					}
				}
			}
		}
		
		if(!flag) {
			JOptionPane.showMessageDialog(null, "You cannot make Queen Side Castling!", "Error!", JOptionPane.ERROR_MESSAGE);
		}
		return flag;
	}
	
	public boolean makeKingSideCastling() {
		boolean flag = false;
		if(GameArea.stepNumber % 2 == 0) {
			Stone king = GameArea.discoverStone(7, 4);
			Stone empty1 = GameArea.discoverStone(7, 5);
			Stone empty2 = GameArea.discoverStone(7, 6);
			Stone rook = GameArea.discoverStone(7, 7);
			if(king != null && rook != null && empty1 == null && empty2 == null) {
				if(!king.isBlack() && !rook.isBlack()) {
					if(king.getName().equals("king") && rook.getName().equals("rook")) {
						if(!king.isMoved() && !rook.isMoved()) {
							king.setMoved(true);
							rook.setMoved(true);
							king.setJ(6);
							rook.setJ(5);
							GameArea.stepNumber++;
							GameArea.gameArray[7][4].setEmpty(true);
							GameArea.gameArray[7][5].setEmpty(false);
							GameArea.gameArray[7][6].setEmpty(false);
							GameArea.gameArray[7][7].setEmpty(true);
							GameArea.gameArray[7][4].setIcon(null);
							GameArea.gameArray[7][7].setIcon(null);
							flag = true;
						}
					}
				}
			}
		}
		else {
			Stone king = GameArea.discoverStone(0, 4);
			Stone empty1 = GameArea.discoverStone(0, 5);
			Stone empty2 = GameArea.discoverStone(0, 6);
			Stone rook = GameArea.discoverStone(0, 7);
			if(king != null && rook != null && empty1 == null && empty2 == null) {
				if(king.isBlack() && rook.isBlack()) {
					if(king.getName().equals("king") && rook.getName().equals("rook")) {
						if(!king.isMoved() && !rook.isMoved()) {
							king.setMoved(true);
							rook.setMoved(true);
							king.setJ(6);
							rook.setJ(5);
							GameArea.stepNumber++;
							GameArea.gameArray[0][4].setEmpty(true);
							GameArea.gameArray[0][5].setEmpty(false);
							GameArea.gameArray[0][6].setEmpty(false);
							GameArea.gameArray[0][7].setEmpty(true);
							GameArea.gameArray[0][4].setIcon(null);
							GameArea.gameArray[0][7].setIcon(null);
							flag = true;
						}
					}
				}
			}
		}
		if(!flag) {
			JOptionPane.showMessageDialog(null, "You cannot make King Side Castling!", "Error!", JOptionPane.ERROR_MESSAGE);
		}
		return flag;
	}
}
