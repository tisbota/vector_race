package model;
import java.awt.Color;
import java.awt.Point;

public class Car {
	
	//Fields
	public Point position = new Point();
	private Point velocity = new Point(0,0);
	public Color color;
	
	/**
	 * 
	 * @param color
	 * @param position
	 * 
	 */
	public Car(Color color, Point position){
		this.color = color;
		this.position = position;
	}
	

}