package model;

import java.awt.Point;
import java.util.ArrayList;

import view.GameArea;

public abstract class Stone {
	
	private int i, j;
	
	private String name;
	
	private boolean isMoved;
	
	private boolean isBlack;
	
	private String iconPath;

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

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public boolean isMoved() {
		return isMoved;
	}

	public void setMoved(boolean isMoved) {
		this.isMoved = isMoved;
	}

	public boolean isBlack() {
		return isBlack;
	}

	public void setBlack(boolean isBlack) {
		this.isBlack = isBlack;
	}

	public String getIconPath() {
		return iconPath;
	}

	public void setIconPath(String iconPath) {
		this.iconPath = iconPath;
	}
	
	public abstract ArrayList<Point> showMoveableLocations();
	
	public void addIfEatableStone(ArrayList<Point> moveableLocations, int realRowIndex, int realColumnIndex) {
		if(realRowIndex >= 0 && realRowIndex <= 7 && realColumnIndex >= 0 && realColumnIndex <= 7) {
			if(!GameArea.gameArray[realRowIndex][realColumnIndex].isEmpty()) {
				if(GameArea.discoverStone(getI(), getJ()).isBlack() == !GameArea.discoverStone(realRowIndex, realColumnIndex).isBlack()) {
					moveableLocations.add(new Point(realRowIndex, realColumnIndex));
				}
			}
		}

	}
	
}
