package model;

import java.awt.Point;
import java.util.ArrayList;

import view.GameArea;

public class Knight extends Stone{

	@Override
	public ArrayList<Point> showMoveableLocations() {
		ArrayList<Point> moveableLocations = new ArrayList<>(); 
		Grid[][] gameArray = GameArea.gameArray;
		int rowIndex = - 10, columnIndex = - 10;
		// Scanning All Possibilities
		for(int i = 0;i < 8 ; i++) {
			
			switch (i) {
			case 0: 
				rowIndex = -1;
				columnIndex = -2;
				break;
			case 1: 
				rowIndex = -2;
				columnIndex = -1;
				break;
			case 2: 
				rowIndex = -2;
				columnIndex = +1;
				break;
			case 3: 
				rowIndex = -1;
				columnIndex = +2;
				break;
			case 4: 
				rowIndex = +1;
				columnIndex = -2;
				break;
			case 5: 
				rowIndex = +2;
				columnIndex = -1;
				break;
			case 6: 
				rowIndex = +2;
				columnIndex = +1;
				break;
			case 7: 
				rowIndex = +1;
				columnIndex = +2;
				break;
			}

			int realRowIndex = getI() + rowIndex;
			int realColumnIndex = getJ() + columnIndex;
			
			if(realRowIndex >= 0 && realRowIndex <= 7 && realColumnIndex >= 0 && realColumnIndex <= 7) {
				if(gameArray[realRowIndex][realColumnIndex].isEmpty()) {
					moveableLocations.add(new Point(realRowIndex, realColumnIndex));
				}
				else {
					if(GameArea.discoverStone(getI(), getJ()).isBlack() == !GameArea.discoverStone(realRowIndex, realColumnIndex).isBlack()) {
						moveableLocations.add(new Point(realRowIndex, realColumnIndex));
					}
				}
			}

		}
		
		return moveableLocations;
	}



}
