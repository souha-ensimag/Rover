package Utils;

import Model.Direction;

public class DirectionUtils {
	
	public static Direction getNextDirection(Direction direction, char side){
		if(side == 'L') {
			switch(direction) {
				case N :
					return Direction.W;
				case E :
					return Direction.N;
				case S :
					return Direction.E;
				case W :
					return Direction.S;
			}
		}
		else if(side == 'R') {
			switch(direction) {
				case N :
					return Direction.E;
				case E :
					return Direction.S;
				case S :
					return Direction.W;
				case W :
					return Direction.N;
			}
		}
		return null;
	}
}
