package model;

import java.awt.Point;
import java.util.ArrayList;

import view.GameArea;

public class Pawn extends Stone {

	@Override
	public ArrayList<Point> showMoveableLocations() {
		
		ArrayList<Point> moveableLocations = new ArrayList<>(); 
		Grid[][] gameArray = GameArea.gameArray;
		
		if(isBlack()) {
			int rowIndex = - 10, columnIndex = - 10;
			int realRowIndex, realColumnIndex;
			for(int i = 0;i < 4;i++) {
				switch (i) {
				case 0: 
					rowIndex = 2;
					columnIndex = 0;
					realRowIndex = getI() + rowIndex;
					realColumnIndex = getJ() + columnIndex;
					if(realRowIndex >= 0 && realRowIndex <= 7 && realColumnIndex >= 0 && realColumnIndex <= 7 
							&& !isMoved() && gameArray[realRowIndex][realColumnIndex].isEmpty() && gameArray[realRowIndex-1][realColumnIndex].isEmpty()) {
						
						moveableLocations.add(new Point(realRowIndex, realColumnIndex));
					}
					break;
				case 1: 
					rowIndex = 1;
					columnIndex = 0;
					realRowIndex = getI() + rowIndex;
					realColumnIndex = getJ() + columnIndex;
					if(realRowIndex >= 0 && realRowIndex <= 7 && realColumnIndex >= 0 && realColumnIndex <= 7 
							&& gameArray[realRowIndex][realColumnIndex].isEmpty()) {
						moveableLocations.add(new Point(realRowIndex, realColumnIndex));
					}
					break;
				case 2: 
					rowIndex = 1;
					columnIndex = 1;
					realRowIndex = getI() + rowIndex;
					realColumnIndex = getJ() + columnIndex;
					if(realRowIndex >= 0 && realRowIndex <= 7 && realColumnIndex >= 0 && realColumnIndex <= 7 
							&& !gameArray[realRowIndex][realColumnIndex].isEmpty()) {
						
						Stone stone = GameArea.discoverStone(realRowIndex, realColumnIndex);
						if(!stone.isBlack()) {
							moveableLocations.add(new Point(realRowIndex, realColumnIndex));
						}
					}
					break;
				case 3: 
					rowIndex = 1;
					columnIndex = -1;
					realRowIndex = getI() + rowIndex;
					realColumnIndex = getJ() + columnIndex;
					if(realRowIndex >= 0 && realRowIndex <= 7 && realColumnIndex >= 0 && realColumnIndex <= 7 
							&& !gameArray[realRowIndex][realColumnIndex].isEmpty()) {
						
						Stone stone = GameArea.discoverStone(realRowIndex, realColumnIndex);
						if(!stone.isBlack()) {
							moveableLocations.add(new Point(realRowIndex, realColumnIndex));
						}
					}
					break;
				}
			}
			
		}
		else {
	
			int rowIndex = - 10, columnIndex = - 10;
			int realRowIndex, realColumnIndex;
			for(int i = 0;i < 4;i++) {
				switch (i) {
				case 0: 
					rowIndex = -2;
					columnIndex = 0;
					realRowIndex = getI() + rowIndex;
					realColumnIndex = getJ() + columnIndex;
					if(realRowIndex >= 0 && realRowIndex <= 7 && realColumnIndex >= 0 && realColumnIndex <= 7 
							&& !isMoved() && gameArray[realRowIndex][realColumnIndex].isEmpty() && gameArray[realRowIndex+1][realColumnIndex].isEmpty()) {
						moveableLocations.add(new Point(realRowIndex, realColumnIndex));
					}
					break;
				case 1: 
					rowIndex = -1;
					columnIndex = 0;
					realRowIndex = getI() + rowIndex;
					realColumnIndex = getJ() + columnIndex;
					if(realRowIndex >= 0 && realRowIndex <= 7 && realColumnIndex >= 0 && realColumnIndex <= 7 
							&& gameArray[realRowIndex][realColumnIndex].isEmpty()) {
						moveableLocations.add(new Point(realRowIndex, realColumnIndex));
					}
					break;
				case 2: 
					rowIndex = -1;
					columnIndex = -1;
					realRowIndex = getI() + rowIndex;
					realColumnIndex = getJ() + columnIndex;
					if(realRowIndex >= 0 && realRowIndex <= 7 && realColumnIndex >= 0 && realColumnIndex <= 7 
							&& !gameArray[realRowIndex][realColumnIndex].isEmpty()) {
						
						Stone stone = GameArea.discoverStone(realRowIndex, realColumnIndex);
						if(stone.isBlack()) {
							moveableLocations.add(new Point(realRowIndex, realColumnIndex));
						}
						
					}
					break;
				case 3: 
					rowIndex = -1;
					columnIndex = +1;
					realRowIndex = getI() + rowIndex;
					realColumnIndex = getJ() + columnIndex;
					if(realRowIndex >= 0 && realRowIndex <= 7 && realColumnIndex >= 0 && realColumnIndex <= 7 
							&& !gameArray[realRowIndex][realColumnIndex].isEmpty()) {
						
						Stone stone = GameArea.discoverStone(realRowIndex, realColumnIndex);
						if(stone.isBlack()) {
							moveableLocations.add(new Point(realRowIndex, realColumnIndex));
						}
						
					}
					break;
				}
			}
		}
		
		return moveableLocations;
	}



}
