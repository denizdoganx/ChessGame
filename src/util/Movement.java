package util;

import java.awt.Point;
import java.util.ArrayList;

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
		startGrid.setEmpty(true);
		startGrid.setIcon(null);
		endGrid.setEmpty(false);
		firstStone.setI(endGrid.getI());
		firstStone.setJ(endGrid.getJ());
		firstStone.setMoved(true);
		deleteMoveableLocationsTracks();
		GameArea.stepNumber++;
		return gameArea.isCheck();
	}
	
	public boolean eatAgainstStone() {
		return GameArea.stones.remove(this.eatenStone) && performMovement();
	}
}
