package edu.toronto.csc301;

public class GridRobot1 implements IGridRobot {
	
	int gridSize;
	BasicRobot r;
	public GridRobot1(IBasicRobot obj1,int new_var) throws Exception{
		r = (BasicRobot)obj1;
		//checking for invalid arguments
		//case 1: gridSize is negative
		if(new_var <= 0){
			throw new IllegalArgumentException();
		}
		//case 2: rotation not according to direction
		else if(r.rotation % 90 != 0){
			throw new IllegalArgumentException(); 
		}
		//case 3: x and y values have to divisible
		else if(r.x % new_var != 0 || r.y % new_var != 0){
			throw new IllegalArgumentException();
		}
		
		this.gridSize = new_var;
		
	}
	public GridCell getLocation() {
		// TODO Auto-generated method stub
		return GridCell.at((int)(Math.round(r.x)/gridSize),(int)(Math.round(r.y)/gridSize));
	}

	//Based on the rotation of the robot
	public Direction getFacingDirection() {
		// TODO Auto-generated method stub
		if(r.rotation == 0){
			return Direction.NORTH;
		}else if(r.rotation == 90){
			return Direction.EAST;
		}else if(r.rotation == 180){
			return Direction.SOUTH;
		}else{
			return Direction.WEST;
		}
	}

	//Based on the direction of the bot
	//change x and y accordingly
	public void step(Direction direction) {
		if(direction == Direction.WEST){
			r.x = r.x - gridSize;
		}else if(direction == Direction.EAST){
			r.x = r.x + gridSize;
		}else if(direction == Direction.SOUTH){
			r.y = r.y - gridSize;
		}else{
			r.y = r.y + gridSize;
		}
		
	}

	@Override
	//change rotation based on the direction
	public void face(Direction direction) {
		if(direction == Direction.WEST){
			r.rotation = 270;
		}else if(direction == Direction.EAST){
			r.rotation = 90;
		}else if(direction == Direction.SOUTH){
			r.rotation = 180;
		}else{
			r.rotation = 0;
		}
	}
}
