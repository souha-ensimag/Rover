package Tools.Rover;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.Scanner;

import Model.Direction;
import Model.Plateau;
import Model.Rover;

public class App {
    public static void main( String[] args ) throws Exception {
        File file = new File("/home/souha/equipe4/Exercice/Rover/src/main/java/ressources/input.txt");
	    Scanner reader = new Scanner(file);
	    ArrayList<String> fileLines = readLines(reader);
	    
//	    Iterator<String> iterator = fileLines.iterator();
//	    while(iterator.hasNext()) {
//	    	System.out.println(iterator.next());
//	    }

	    if(fileLines != null && !fileLines.isEmpty()) {
		    Plateau plateau = readPlateauCoordinates(fileLines.get(0));
		    for(int i = 1; i < fileLines.size(); i += 2) {
	    		Rover rover = readRoverCoordinates(fileLines.get(i),plateau,reader);
		    	if(i + 1 < fileLines.size()) {
		    		String instructionsString = fileLines.get(i+1);
		    		for(int j = 0; j < instructionsString.length(); j++){
		    	    	char letter = instructionsString.charAt(j);
		    	    	if(letter == 'M') {
		    	    		rover.moveForward();
		    	    	}
		    	    	else if (letter == 'L' || letter == 'R'){
		    	    		rover.spin(letter);
		    	    	}
		    	    	else {
		    	    		throw new IllegalArgumentException("The instruction for the rover number is wrong");
		    	    	}
		    	    }
			    	System.out.println(rover.toString());
		    	}
		    	else {
		    		throw new IllegalArgumentException("There are now instructions for the rover");
		    	}
		    }
		    
	    } 
	    else {
	    	throw new IllegalArgumentException("The input file is empty");
	    }
	    
	    
	    
	    
	    
//	    Iterator<String> iterator = fileLines.iterator();
//	    while(iterator.hasNext()) {
//	    	System.out.println(iterator.next());
//	    }
	    reader.close();
	}
	
	public static ArrayList<String> readLines(Scanner reader) {
		ArrayList<String> lines = new ArrayList<String>();
		while(reader.hasNext()) {
		    String line = reader.nextLine();
		    lines.add(line);
		}
		return lines;
	}
	
	public static Plateau readPlateauCoordinates(String line) {
		String[] plateauCoordinates = line.split(" ");
		if(plateauCoordinates != null && plateauCoordinates.length == 2) {
			return new Plateau(Integer.parseInt(plateauCoordinates[0]),Integer.parseInt(plateauCoordinates[1]));
		}
		else {
			throw new IllegalArgumentException("readPlateauCoordinates - PlateauCoordinates is null or number of plateau coordinates is wrong");
		}
	}
	
	public static Rover readRoverCoordinates(String line, Plateau plateau, Scanner reader) {
		String[] roverCoordinates = line.split(" ");
		if(roverCoordinates.length == 3) {
			int x = Integer.parseInt(roverCoordinates[0]);
			int y = Integer.parseInt(roverCoordinates[1]);
			if(x <= plateau.getHigherX() && y <= plateau.getHigherY()) {
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
}
