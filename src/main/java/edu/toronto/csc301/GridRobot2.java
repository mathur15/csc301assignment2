package edu.toronto.csc301;


public class GridRobot2 extends BasicRobot implements IGridRobot{
    public int gridSize;
	public GridRobot2(GridCell obj, Direction dir, int gridSize)throws Exception{
		super(obj.x * gridSize,obj.y*gridSize,0);
		int degrees;
		if(gridSize <=0){
			throw new IllegalArgumentException();
		}else if(dir == null){
			throw new NullPointerException();
		}
		if(dir == Direction.EAST){
			degrees = 90;
		}else if(dir == Direction.SOUTH){
			degrees = 180;
		}else if(dir == Direction.WEST){
			degrees = 270;
		}else{
			degrees = 0;
		}
		this.rotation = degrees;
		this.gridSize = gridSize;
	}
	public GridCell getLocation() {
		return GridCell.at((int)(Math.round(this.x)/gridSize),(int)(Math.round(this.y)/gridSize));
	}
	public Direction getFacingDirection() {
		// TODO Auto-generated method stub
		if(this.rotation == 0){
			return Direction.NORTH;
		}else if(this.rotation == 90){
			return Direction.EAST;
		}else if(this.rotation == 180){
			return Direction.SOUTH;
		}else{
			return Direction.WEST;
		}
	}
	public void step(Direction direction) {
		// TODO Auto-generated method stub
		if(direction == Direction.WEST){
			this.x = this.x - gridSize;
		}else if(direction == Direction.EAST){
			this.x = this.x + gridSize;
		}else if(direction == Direction.SOUTH){
			this.y = this.y - gridSize;
		}else{
			this.y = this.y + gridSize;
		}
		
	}
	public void face(Direction direction) {
		// TODO Auto-generated method stub
		if(direction == Direction.WEST){
			this.rotation = 270;
		}else if(direction == Direction.EAST){
			this.rotation = 90;
		}else if(direction == Direction.SOUTH){
			this.rotation = 180;
		}else{
			this.rotation = 0;
		}
		
	}
	public void rotateRight(int degrees){
		if(degrees % 90 != 0){
			throw new IllegalArgumentException();
		}
	     this.rotation = (this.rotation + degrees)%360;
	     if(this.rotation < 0){
	    	 this.rotation = this.rotation + 360;
	     }
	}
	public void rotateLeft(int degrees){
		if(degrees % 90 != 0){
			throw new IllegalArgumentException();
		}
	     this.rotation = (this.rotation - degrees)%360;
	     if(this.rotation < 0){
	    	 this.rotation = this.rotation + 360;
	     }
	}
	public void moveForward(int centimeters){
		//move in terms of gridSize in this implementation of moveForward
		if(centimeters % gridSize !=0){
			throw new IllegalArgumentException();
		}
		this.x = this.x + Math.sin(Math.toRadians(this.rotation)) * centimeters;
		this.y = this.y + Math.cos(Math.toRadians(this.rotation)) * centimeters;
	}
	
}
