package model;

import java.awt.Point;
import java.util.ArrayList;

public class Queen extends Stone {

	@Override
	public ArrayList<Point> showMoveableLocations() {
		
		ArrayList<Point> moveableLocationsForRook = new ArrayList<>();
		ArrayList<Point> moveableLocationsForBishop = new ArrayList<>();
		Stone rook = new Rook();
		Stone bishop = new Bishop();
		
		rook.setI(getI());
		rook.setJ(getJ());
		
		bishop.setI(getI());
		bishop.setJ(getJ());
		
		
		moveableLocationsForRook = rook.showMoveableLocations();
		
		moveableLocationsForBishop = bishop.showMoveableLocations();
		
		for(Point point : moveableLocationsForBishop) {
			moveableLocationsForRook.add(point);
		}
		
		return moveableLocationsForRook;
	}



}
