/**
 * Name: Seyon Rajagopal
 * Student ID: 500885401
 * Class Name: ElectricCar.java
 * 
 */

// this class is for Electric Car which containes all elements of an Electric Car
public class ElectricCar extends Car {
	
	// instance variables
	private int rechargeTime;
	private String batteryType;

	//constructor method
	public ElectricCar(String mfr, String color, int power, int numWheels, int model, int maxRange, double safetyRating, boolean AWD, double price, int rechargeTime, String batteryType) {
		super(mfr, color, power, numWheels, model, maxRange, safetyRating, AWD, price);
		this.rechargeTime = rechargeTime;
		this.batteryType = batteryType;
	}

	// displays cars in a formatted matter
	public String display() {
		return String.format("%s %-3d %s", super.display(), this.rechargeTime, this.batteryType);
	}

	/**
	 * @return the batteryType
	 */
	public String getBatteryType() {
		return batteryType;
	}

	/**
	 * @param batteryType the batteryType to set
	 */
	public void setBatteryType(String batteryType) {
		this.batteryType = batteryType;
	}

	/**
	 * @return the rechargeTime
	 */
	public int getRechargeTime() {
		return rechargeTime;
	}

	/**
	 * @param rechargeTime the rechargeTime to set
	 */
	public void setRechargeTime(int rechargeTime) {
		this.rechargeTime = rechargeTime;
	}
}