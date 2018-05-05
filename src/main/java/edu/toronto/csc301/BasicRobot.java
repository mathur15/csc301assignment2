package edu.toronto.csc301;

public class BasicRobot implements IBasicRobot {
	
	public double x,y;
	public int rotation;
	public BasicRobot(double x, double y, int rotation) throws IllegalArgumentException{
		if(rotation >=360 || rotation < 0){
			throw new IllegalArgumentException();
		}
		this.x=x;
		this.y=y;
		this.rotation=rotation;
	}
	public double getXCoordinate(){
		return this.x;
	}
	public double getYCoordinate(){
		return this.y;
	}
	public int getRotation(){
		return this.rotation;
	}

	public void rotateRight(int degrees){
		//modulus because we want to keep it within 360 degrees
	     this.rotation = (this.rotation + degrees)%360;
	     if(this.rotation < 0){
	    	 this.rotation = this.rotation + 360;
	     }
	}
	public void rotateLeft(int degrees){
		//modulus because we want to keep it within 360 degrees
	     this.rotation = (this.rotation - degrees)%360;
	     if(this.rotation < 0){
	    	 this.rotation = this.rotation + 360;
	     }
	}
	public void moveForward(int centimeters){
		this.x = this.x + Math.sin(Math.toRadians(this.rotation)) * centimeters;
		this.y = this.y + Math.cos(Math.toRadians(this.rotation)) * centimeters;
	}

}
