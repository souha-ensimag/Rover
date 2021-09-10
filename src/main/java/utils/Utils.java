package utils;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.Scanner;

import model.Direction;
import model.Plateau;
import model.Rover;

public class Utils {
	
	/**
	 * @param direction
	 * @param side
	 * @return
	 */
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
				default :
					throw new IllegalArgumentException(" getNextDirection - The input direction is invalid");
			}
		}
		else if (side == 'R') {
			switch(direction) {
				case N :
					return Direction.E;
				case E :
					return Direction.S;
				case S :
					return Direction.W;
				case W :
					return Direction.N;
				default :
					throw new IllegalArgumentException(" getNextDirection - The input direction side is invalid");
			}
		}
		else {
			throw new IllegalArgumentException(" getNextDirection - The input side is invalid");
		}
	}
	
	/**
	 * @param reader
	 * @return
	 */
	public static ArrayList<String> readLines(Scanner reader) {
		ArrayList<String> lines = new ArrayList<String>();
		while(reader.hasNext()) {
		    String line = reader.nextLine();
		    lines.add(line);
		}
		return lines;
	}
	
	/**
	 * @param line
	 * @return
	 */
	public static Plateau readPlateauCoordinates(String line) {
		if(line != null) {
			String[] plateauCoordinates = line.split(" ");
			if(plateauCoordinates.length == 2 && Integer.parseInt(plateauCoordinates[0]) > 0 && Integer.parseInt(plateauCoordinates[1]) > 0) {
				return new Plateau(Integer.parseInt(plateauCoordinates[0]),Integer.parseInt(plateauCoordinates[1]));
			} 
			else {
				throw new IllegalArgumentException("readPlateauCoordinates - Number of plateau coordinates is wrong or coordinates equal to zero");
			}
		} 
		else {
			throw new IllegalArgumentException("readPlateauCoordinates - line is null");
		}

	}
	
	/**
	 * @param line
	 * @param plateau
	 * @return
	 */
	public static Rover readRoverCoordinates(String line, Plateau plateau) {
		if(line != null) {
			String[] roverCoordinates = line.split(" ");
			if(roverCoordinates.length == 3) {
				int x = Integer.parseInt(roverCoordinates[0]);
				int y = Integer.parseInt(roverCoordinates[1]);
				if(x <= plateau.getHigherX() && y <= plateau.getHigherY() && x >= Plateau.getLowerX() && y >= Plateau.getLowerY()) {
					return new Rover(Integer.parseInt(roverCoordinates[0]),Integer.parseInt(roverCoordinates[1]),Direction.valueOf(roverCoordinates[2]));
				}
				else {
					throw new IllegalArgumentException("readRoverCoordinates - Rover coordinates exceed plateau coordinates");
				}
			}
			else {
				throw new IllegalArgumentException("readRoverCoordinates - Number of rover coordinates is wrong");
			}
		}  
		else {
			throw new IllegalArgumentException("readRoverCoordinates - line is null");
		}

	}
	
	/**
	 * @param filePath
	 * @return
	 * @throws FileNotFoundException
	 */
	public static Scanner createScanner(String filePath) throws FileNotFoundException {
	    return new Scanner(new FileInputStream(filePath));
	}
	
	/**
	 * @param rover
	 */
	public static void displayRoverPosition(Rover rover) {
    	System.out.println(rover.toString());
	}
}
