package model;
import java.awt.Color;
import java.awt.Point;

public class Car {
	
	//Fields
	private Point position = new Point();
	private Point velocity = new Point(0,0);
	private Color color;
	
	public Car(Color color, Point position){
		this.color = color;
		this.position = position;
	}
	
	public Point getPosition(){
		return position;
	}
	
	public Color getColor(){
		return color;
	}
	
	public void moveCar(Point speed){
		if (Board.pathOnBoard(position, speed) ){
			velocity.translate(speed.x, speed.y);
			position.translate(velocity.x, velocity.y);
		} else {
			velocity.setLocation(0, 0);
			position = Board.putBackOnBoard(position, speed);
		}
		
	}
	

}