package model;

public class Plateau {
	
	private int higherX;
	private int higherY;
	private static final int LOWER_X = 0;
	private static final int LOWER_Y = 0;
	
	/**
	 * @param higherX
	 * @param higherY
	 */
	public Plateau(int higherX,int higherY) {
		this.higherX = higherX;
		this.higherY = higherY;
	}
	
	/**
	 *
	 */
	@Override
	public String toString() {
		return (this.higherX + " " + this.higherY);
	}
	
	/**
	 * @return
	 */
	public int getHigherX() {
		return higherX;
	}
	
	/**
	 * @param higherX
	 */
	public void setHigherX(int higherX) {
		this.higherX = higherX;
	}
	
	/**
	 * @return
	 */
	public int getHigherY() {
		return higherY;
	}
	
	/**
	 * @param higherY
	 */
	public void setHigherY(int higherY) {
		this.higherY = higherY;
	}
	
	/**
	 * @return
	 */
	public static int getLowerX() {
		return LOWER_X;
	}
	
	/**
	 * @return
	 */
	public static int getLowerY() {
		return LOWER_Y;
	}
}
