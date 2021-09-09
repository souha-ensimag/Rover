package Tools.Rover;

import services.RoverService;

public class App {
    public static void main( String[] args ) throws Exception {
		try {
	    	RoverService.explorePlateau(args[0]);
		}
		catch (Exception e) {
            e.printStackTrace();
		}
	}
}
