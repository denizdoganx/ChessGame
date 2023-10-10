package model;

import java.awt.Point;
import java.util.ArrayList;

import view.GameArea;

public class Bishop extends Stone {

	@Override
	public ArrayList<Point> showMoveableLocations() {
		ArrayList<Point> moveableLocations = new ArrayList<>(); 
		Grid[][] gameArray = GameArea.gameArray;
		
		//Scanning Right Top
		int i = getI();
		int j = getJ();
		while(j <= 6 && i >= 1 && gameArray[--i][++j].isEmpty()) {
			moveableLocations.add(new Point(i, j));
		}
		addIfEatableStone(moveableLocations, i, j);
		//Scanning Right Bottom
		i = getI();
		j = getJ();
		while(j <= 6 && i <= 6 && gameArray[++i][++j].isEmpty()) {
			moveableLocations.add(new Point(i, j));
		}
		addIfEatableStone(moveableLocations, i, j);
		//Scanning Left Bottom
		i = getI();
		j = getJ();
		while(j >= 1 && i <= 6 && gameArray[++i][--j].isEmpty()) {
			moveableLocations.add(new Point(i, j));
		}
		addIfEatableStone(moveableLocations, i, j);
		//Scanning Left Top
		i = getI();
		j = getJ();
		while(j >= 1 && i >= 1 && gameArray[--i][--j].isEmpty()) {
			moveableLocations.add(new Point(i, j));
		}
		addIfEatableStone(moveableLocations, i, j);
		return moveableLocations;
	}



}
