package application;

import services.RoverService;

public class RoverApp {
	
    public static void main( String[] args ) throws Exception {
		try {
	    	RoverService.explorePlateau(args[0]);
		}
		catch (Exception e) {
            e.printStackTrace();
		}
	}
}
