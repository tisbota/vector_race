package model;

import java.awt.Point;

public class Board {
	//Fields
	public boolean[][] board;
	
	
	public Board(int xsize, int ysize) {
		board = new boolean[xsize][ysize];
	}
	
	private boolean isOnBoard(Point point){
		if (point.x >= 0 && point.x < board.length && point.y >= 0 && point.y < board[0].length) return false;
		return board[point.x][point.y];
	}
	
	public boolean pathOnBoard(Point start, Point change){
		if (putBackOnBoard(start, change) == null){
			return true;
		}else{
			return false;
		}
	} 
	
	public Point putBackOnBoard(Point start, Point change){
		int a = change.y/change.x;
		int b = start.y - a*start.x;

		int deltaX = (change.x > 0) ? 1 : -1;
		int deltaY = (change.y > 0) ? 1 : -1;

		for (int i = start.x; i < start.x + change.x; i += deltaX) {
			int y = a*i + b;
			if (!(isOnBoard(new Point(i,y)) || isOnBoard(new Point(i,y+1)))){
				return new Point(i - deltaX, a * (i - deltaX) + b);
			}
		}
		for (int i = start.y; i < start.y + change.y; i += deltaY) {
			int x = (i-b)/a;
			if (!(isOnBoard(new Point(x+1,i)) || isOnBoard(new Point(x+1,i)))){
				return new Point(i - deltaY, (i - deltaY - b) / a);
			}
		}
		return null;
	}
	
}
