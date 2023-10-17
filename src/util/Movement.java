package util;

import java.awt.Point;
import java.util.ArrayList;

import javax.swing.Icon;

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
}
