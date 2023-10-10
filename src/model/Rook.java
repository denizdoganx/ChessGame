package model;

import java.awt.Point;
import java.util.ArrayList;

import view.GameArea;

public class Rook extends Stone {

	@Override
	public ArrayList<Point> showMoveableLocations() {
		ArrayList<Point> moveableLocations = new ArrayList<>(); 
		Grid[][] gameArray = GameArea.gameArray;
		
		//Scanning Vertical
		int i = getI();
		while(i <= 6 && gameArray[++i][getJ()].isEmpty()) {
			moveableLocations.add(new Point(i, getJ()));
			
		}
		addIfEatableStone(moveableLocations, i, getJ());
		i = getI();
		while(i >= 1 && gameArray[--i][getJ()].isEmpty()) {
			moveableLocations.add(new Point(i, getJ()));
		}
		
		addIfEatableStone(moveableLocations, i, getJ());
		
		
		//Scanning Horizontal
		int j = getJ();
		while(j <= 6 && gameArray[getI()][++j].isEmpty()) {
			moveableLocations.add(new Point(getI(), j));
			
		}
		addIfEatableStone(moveableLocations, getI(), j);
		j = getJ();
		while(j >= 1 && gameArray[getI()][--j].isEmpty()) {
			moveableLocations.add(new Point(getI(), j));
		}
		addIfEatableStone(moveableLocations, getI(), j);
		return moveableLocations;
	}



}
