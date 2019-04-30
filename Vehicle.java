/**
 * Name: Seyon Rajagopal
 * Student ID: 500885401
 * Class Name: Vehicle.java 
 * 
 */

// this class is for vehicle which containes all elements of a vehicle
public class Vehicle {
	
	// instance variables
	private String mfr;
	private String color;
	private int power;
	private int numWheels;

	// constant varibales for engine type
	public static final int ELECTRIC_MOTOR = 0;
	public static final int GAS_ENGINE = 1;

	// constructor
	public Vehicle(String mfr, String color, int power, int numWheels) {
		this.mfr = mfr;
		this.color = color;
		this.power = power;
		this.numWheels = numWheels;
	}

	// returns whether or not 2 vehicles are equal
	public boolean equals(Object other) {
		Vehicle othVehicle = (Vehicle) other;
		return this.mfr.equals(othVehicle.mfr) && this.power == othVehicle.power && this.numWheels == othVehicle.numWheels;
	}
	
	// displays cars in a formatted matter
	public String display() {
		return String.format("%-12s%-6s", this.mfr, this.color);
	}
	
	// helper mothod to convert power value to a string
	public String powerType(){
		if (power == 0){
			return "ELECTRIC MOTOR";
		}else if(power == 1){
			return "GAS ENGINE";
		}
		return "";
	}

	/**
	 * @return the manufaturer
	 */
	public String getMfr() {
		return mfr;
	}

	/**
	 * @param mfr the manufaturer to set
	 */
	public void setMfr(String mfr) {
		this.mfr = mfr;
	}

	/**
	 * @return the color
	 */
	public String getColor() {
		return color;
	}

	/**
	 * @param color the color to set
	 */
	public void setColor(String color) {
		this.color = color;
	}

	/**
	 * @return the numWheels
	 */
	public int getNumWheels() {
		return numWheels;
	}

	/**
	 * @param numWheels the numWheels to set
	 */
	public void setNumWheels(int numWheels) {
		this.numWheels = numWheels;
	}

	/**
	 * @return the power
	 */
	public int getPower() {
		return power;
	}

	/**
	 * @param power the power to set
	 */
	public void setPower(int power) {
		this.power = power;
	}
}