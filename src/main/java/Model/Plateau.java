package Model;

public class Plateau {
	
	private int higherX;
	private int higherY;
	private static final int LOWER_X = 0;
	private static final int LOWER_Y = 0;
	
	public Plateau(int higherX,int higherY) {
		this.higherX = higherX;
		this.higherY = higherY;
	}
	
	@Override
	public String toString() {
		return (this.higherX + " " + this.higherY);
	}
	
	public int getHigherX() {
		return higherX;
	}
	
	public void setHigherX(int higherX) {
		this.higherX = higherX;
	}
	
	public int getHigherY() {
		return higherY;
	}
	
	public void setHigherY(int higherY) {
		this.higherY = higherY;
	}
	
	public static int getLowerX() {
		return LOWER_X;
	}
	
	public static int getLowerY() {
		return LOWER_Y;
	}
}
