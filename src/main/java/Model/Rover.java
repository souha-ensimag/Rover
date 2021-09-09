package Model;

import Utils.DirectionUtils;

public class Rover {
	private int x;
	private int y;
	private Direction direction;
	
	public Rover(int x, int y, Direction direction) {
		this.x = x;
		this.y = y;
		this.direction = direction;
	}
	
	@Override
	public String toString() {
		return (this.x + " " + this.y + " " + this.direction);
	}
	
	public void moveForward() {
		switch (this.direction) {
			case N :
				this.y += 1;
				break;
			case S :
				this.y -= 1;
				break;
			case E : 
				this.x += 1;
				break;
			case W : 
				this.x -= 1;
				break;
		}
	}
	
	/**
	 * @param direction
	 * @throws Exception
	 */
	public void spin(char side) {
		this.direction = DirectionUtils.getNextDirection(this.direction,side);
	}

	public int getX() {
		return x;
	}

	public void setX(int x) {
		this.x = x;
	}

	public int getY() {
		return y;
	}

	public void setY(int y) {
		this.y = y;
	}

	public Direction getDirection() {
		return direction;
	}

	public void setDirection(Direction direction) {
		this.direction = direction;
	}	
}
