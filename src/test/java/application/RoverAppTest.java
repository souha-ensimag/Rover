package application;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.fail;

import java.io.FileNotFoundException;
import java.io.IOException;

import services.RoverService;
import utils.Utils;

import org.junit.Test;

import model.Direction;
import model.Plateau;
import model.Rover;

public class RoverAppTest {

	@Test
    public void changeRoverPosition_only_left_side_instructions_should_succeed() {
    	Rover rover = new Rover(1,2,Direction.N);
    	Plateau plateau = new Plateau(5,5);
    	String instructionsString = "LMLMLMLMM";
    	RoverService.changeRoverPosition(instructionsString,rover,plateau);
    	assertEquals(1,rover.getX());
    	assertEquals(3,rover.getY());
    	assertEquals(Direction.N,rover.getDirection());
    }
	
	@Test
    public void changeRoverPosition_only_right_side_instructions_should_succeed() {
    	Rover rover = new Rover(3,3,Direction.E);
    	Plateau plateau = new Plateau(5,5);
    	String instructionsString = "MMRMMRMRRM";
    	RoverService.changeRoverPosition(instructionsString,rover,plateau);
    	assertEquals(5,rover.getX());
    	assertEquals(1,rover.getY());
    	assertEquals(Direction.E,rover.getDirection());
    }
    
    @Test
    public void changeRoverPosition_exceeding_plateau_north_side_should_fail() {
        try {
        	Rover rover = new Rover(4,5,Direction.N);
        	Plateau plateau = new Plateau(5,5);
        	String instructionsString = "M";
        	RoverService.changeRoverPosition(instructionsString,rover,plateau);
            fail();
        }
        catch (IllegalArgumentException e) {
            // expected
        }
    }
    
    @Test
    public void changeRoverPosition_exceeding_plateau_south_side_should_fail() {
        try {
        	Rover rover = new Rover(4,0,Direction.S);
        	Plateau plateau = new Plateau(5,5);
        	String instructionsString = "M";
        	RoverService.changeRoverPosition(instructionsString,rover,plateau);
            fail();
        }
        catch (IllegalArgumentException e) {
            // expected
        }
    }
    
    @Test
    public void changeRoverPosition_exceeding_plateau_east_side_should_fail() {
        try {
        	Rover rover = new Rover(5,4,Direction.E);
        	Plateau plateau = new Plateau(5,5);
        	String instructionsString = "M";
        	RoverService.changeRoverPosition(instructionsString,rover,plateau);
            fail();
        }
        catch (IllegalArgumentException e) {
            // expected
        }
    }
    
    @Test
    public void changeRoverPosition_exceeding_plateau_west_side_should_fail() {
        try {
        	Rover rover = new Rover(0,4,Direction.W);
        	Plateau plateau = new Plateau(5,5);
        	String instructionsString = "M";
        	RoverService.changeRoverPosition(instructionsString,rover,plateau);
            fail();
        }
        catch (IllegalArgumentException e) {
            // expected
        }
    }
    
    @Test
    public void changeRoverPosition_wrong_instructions_should_fail() {
        try {
        	Rover rover = new Rover(1,3,Direction.N);
        	Plateau plateau = new Plateau(5,5);
        	String instructionsString = "SMM";
        	RoverService.changeRoverPosition(instructionsString,rover,plateau);
            fail();
        }
        catch (IllegalArgumentException e) {
            // expected
        }
    }
    
    @Test
    public void getNextDirection_north_right_should_succeed() {
    	Direction direction = Utils.getNextDirection(Direction.N,'R');
    	assertEquals(Direction.E,direction);
    }
    
    @Test
    public void getNextDirection_north_left_should_succeed() {
    	Direction direction = Utils.getNextDirection(Direction.N,'L');
    	assertEquals(Direction.W,direction);
    }
    
    @Test
    public void getNextDirection_east_right_should_succeed() {
    	Direction direction = Utils.getNextDirection(Direction.E,'R');
    	assertEquals(Direction.S,direction);
    }
    
    @Test
    public void getNextDirection_east_left_should_succeed() {
    	Direction direction = Utils.getNextDirection(Direction.E,'L');
    	assertEquals(Direction.N,direction);
    }
    
    @Test
    public void getNextDirection_south_right_should_succeed() {
    	Direction direction = Utils.getNextDirection(Direction.S,'R');
    	assertEquals(Direction.W,direction);
    }
    
    @Test
    public void getNextDirection_south_left_should_succeed() {
    	Direction direction = Utils.getNextDirection(Direction.S,'L');
    	assertEquals(Direction.E,direction);
    }
    
    @Test
    public void getNextDirection_west_right_should_succeed() {
    	Direction direction = Utils.getNextDirection(Direction.W,'R');
    	assertEquals(Direction.N,direction);
    }
    
    @Test
    public void getNextDirection_west_left_should_succeed() {
    	Direction direction = Utils.getNextDirection(Direction.W,'L');
    	assertEquals(Direction.S,direction);
    }
    
    @Test
    public void getNextDirection_wrong_side_should_fail() {
        try {
        	Rover rover = new Rover(1,3,Direction.N);
        	Utils.getNextDirection(rover.getDirection(),'G');
            fail();
        }
        catch (IllegalArgumentException e) {
            // expected
        }
    }
    
    @Test
    public void readRoverCoordinates_wrong_rover_abscissa_should_fail() {
        try {
        	Plateau plateau = new Plateau(5,5);
        	String line = "6 3 N";
        	Utils.readRoverCoordinates(line,plateau);
            fail();
        }
        catch (IllegalArgumentException e) {
            // expected
        }
    }
    
    @Test
    public void readRoverCoordinates_wrong_rover_ordinate_should_fail() {
        try {
        	Plateau plateau = new Plateau(5,5);
        	String line = "3 6 N";
        	Utils.readRoverCoordinates(line,plateau);
            fail();
        }
        catch (IllegalArgumentException e) {
            // expected
        }
    }
    
    @Test
    public void readRoverCoordinates_negative_abscissa_should_fail() {
        try {
        	Plateau plateau = new Plateau(5,5);
        	String line = "-3 4 N";
        	Utils.readRoverCoordinates(line,plateau);
            fail();
        }
        catch (IllegalArgumentException e) {
            // expected
        }
    }
    
    @Test
    public void readRoverCoordinates_negative_ordinate_should_fail() {
        try {
        	Plateau plateau = new Plateau(5,5);
        	String line = "3 -4 N";
        	Utils.readRoverCoordinates(line,plateau);
            fail();
        }
        catch (IllegalArgumentException e) {
            // expected
        }
    }
    
    @Test
    public void readRoverCoordinates_null_line_should_fail() {
        try {
        	Plateau plateau = new Plateau(5,5);
        	Utils.readRoverCoordinates(null,plateau);
            fail();
        }
        catch (IllegalArgumentException e) {
            // expected
        }
    }
    
    @Test
    public void readRoverCoordinates_wrong_number_of_coordinates_should_fail() {
        try {
        	Plateau plateau = new Plateau(5,5);
        	String line = "3 4 5 N";
        	Utils.readRoverCoordinates(line,plateau);
            fail();
        }
        catch (IllegalArgumentException e) {
            // expected
        }
    }
   
    @Test
    public void readPlateauCoordinates_wrong_number_of_coordinates_should_fail() {
        try {
        	String line = "3 4 5";
        	Utils.readPlateauCoordinates(line);
            fail();
        }
        catch (IllegalArgumentException e) {
            // expected
        }
    }
    
    @Test
    public void readPlateauCoordinates_wrong_abscissa_should_fail() {
        try {
        	String line = "-5 5";
        	Utils.readPlateauCoordinates(line);
            fail();
        }
        catch (IllegalArgumentException e) {
            // expected
        }
    }
    
    @Test
    public void readPlateauCoordinates_wrong_ordinate_should_fail() {
        try {
        	String line = "5 -5";
        	Utils.readPlateauCoordinates(line);
            fail();
        }
        catch (IllegalArgumentException e) {
            // expected
        }
    }
    
    @Test
    public void readPlateauCoordinates_null_line_should_fail() {
        try {
        	Utils.readPlateauCoordinates(null);
            fail();
        }
        catch (IllegalArgumentException e) {
            // expected
        }
    }
    
    @Test
    public void explorePlateau_null_file_path_should_fail() throws FileNotFoundException {
        try {
        	RoverService.explorePlateau(null);
            fail();
        }
        catch (Exception e) {
            // expected
        }
    }
    
    @Test
    public void explorePlateau_not_existant_file_should_fail() throws FileNotFoundException {
        try {
        	String emptyFilePath = "/home/souha/equipe4/Exercice/Rover/src/main/java/ressources/imaginary_file.txt";
        	RoverService.explorePlateau(emptyFilePath);
            fail();
        }
        catch (IOException e) {
            // expected
        }
    }
    
    @Test
    public void explorePlateau_empty_file_should_fail() throws FileNotFoundException {
        try {
        	String emptyFilePath = "/home/souha/equipe4/Exercice/Rover/src/main/java/ressources/empty_file.txt";
        	RoverService.explorePlateau(emptyFilePath);
            fail();
        }
        catch (IllegalArgumentException e) {
            // expected
        }
    }
    
    @Test
    public void explorePlateau_no_instructions_file_should_fail() throws FileNotFoundException {
        try {
        	String noInstructionsFilePath = "/home/souha/equipe4/Exercice/Rover/src/main/java/ressources/no_instructions_file.txt";
        	RoverService.explorePlateau(noInstructionsFilePath);
            fail();
        }
        catch (IllegalArgumentException e) {
            // expected
        }
    }
    
}
