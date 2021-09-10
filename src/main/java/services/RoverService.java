package services;

import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.Scanner;

import model.Direction;
import model.Plateau;
import model.Rover;
import utils.Utils;

public class RoverService {
	
	/**
	 * @param filePath
	 * @throws FileNotFoundException
	 */
	public static void explorePlateau(String filePath) throws FileNotFoundException {
	    Scanner reader = Utils.createScanner(filePath);
	    ArrayList<String> fileLines = Utils.readLines(reader);
	    if(fileLines != null && !fileLines.isEmpty()) {
		    Plateau plateau = Utils.readPlateauCoordinates(fileLines.get(0));
		    for(int i = 1; i < fileLines.size(); i += 2) {
	    		Rover rover = Utils.readRoverCoordinates(fileLines.get(i),plateau);
		    	if(i + 1 < fileLines.size()) {
		    		String instructionsString = fileLines.get(i+1);
		        	changeRoverPosition(instructionsString,rover,plateau);
		        	Utils.displayRoverPosition(rover);
		    	}
		    	else {
		    		throw new IllegalArgumentException("There are now instructions for the rover");
		    	}
		    }		    
	    } 
	    else {
	    	throw new IllegalArgumentException("The input file is empty");
	    }
	    reader.close();
	}
	
	/**
	 * @param instructionsString
	 * @param rover
	 * @param plateau
	 */
	public static void changeRoverPosition(String instructionsString, Rover rover, Plateau plateau) {
		for(int j = 0; j < instructionsString.length(); j++){
	    	char letter = instructionsString.charAt(j);
	    	if (letter == 'L' || letter == 'R'){
	    		rover.spin(letter);
	    	} else if(letter == 'M') {
	    		if(rover.getDirection().equals(Direction.E) && rover.getX() < plateau.getHigherX()) {
		    		rover.moveForward();
	    		}
	    		else if(rover.getDirection().equals(Direction.W) && rover.getX() > Plateau.getLowerX()) {
	    			rover.moveForward();
	    		}
	    		else if(rover.getDirection().equals(Direction.N) && rover.getY() < plateau.getHigherY()) {
	    			rover.moveForward();
	    		}
	    		else if(rover.getDirection().equals(Direction.S) && rover.getY() > Plateau.getLowerY()) {
	    			rover.moveForward();
	    		}
	    		else {
	    			throw new IllegalArgumentException("changeRoverPosition - The rover coordinates can't exceed the plateau coordinates");
	    		}
	    	}
	    	else {
	    		throw new IllegalArgumentException("changeRoverPosition - The instruction for the rover is wrong");
	    	}
	    }
	}
	
}
