/**
 * Name: Seyon Rajagopal
 * Student ID: 500885401
 * Class Name: CarDealership.java 
 * 
 */

import java.util.*;

// this class is for the Car dealership which containes all elements of a a car dealership
public class CarDealership {
	
	// instance variables
	private ArrayList<Car> cars;
	private double minPrice;
	private double maxPrice;
	private boolean electric;
	private boolean awd;
	private boolean price;
	private Car boughtCar;

	// constructor
	public CarDealership(){
		cars = new ArrayList<Car>();
	}

	// add all cars from arraylist to another
	public void addCars(ArrayList<Car> newCars) {
		cars.addAll(newCars);
		if (newCars.size() <= 0){
			throw new IndexOutOfBoundsException("\nSorry, There Are NO Cars In The File!");
		}
	}

	// check to see if array of cars is filled
	public boolean checkArrayFilled(){
		if (cars.size() <= 0){
			return false;
		}
		return true;
	}

	// buys the car buy taking the car from array
	public Car buyCar(int index){
		if (index < cars.size()){
			boughtCar = cars.get(index);
			cars.remove(index);
			return boughtCar;
		}
		if(cars.size() <= 0){
			throw new IllegalArgumentException("\nThere Are NO Cars To Filter. Please Add Cars Using Command 'ADD' First");
		}
		return null;
	}

	// adds car back to array list and sets bought car back to null
	public void returnCar(Car car){
		if (car != null){
			cars.add(car);
			boughtCar = null;
		}else{
			throw new IllegalArgumentException("\nYou Must Buy A Car First!");
		}
	}

	// changes which car is displayed based on which filter is set
	public void displayInventory(){
		for (int i = 0; i < cars.size(); i++){
			Car currentCar = cars.get(i);
			String displayCar = String.format("%-3d %s",i, currentCar.display());
			// filter check to see if all three filters are being used
			if(electric && price && awd){
				if (currentCar.getPower() == Car.ELECTRIC_MOTOR && (currentCar.getPrice() >= minPrice && currentCar.getPrice() <= maxPrice) && currentCar.isAWD()){
					System.out.println(displayCar);
				}
			// filter check to see if price and awd filters are being used
			}else if(price && awd){
				if((currentCar.getPrice() >= minPrice && currentCar.getPrice() <= maxPrice) && currentCar.isAWD()){
					System.out.println(displayCar);
				}
			// filter check to see if electric and price filters are being used
			}else if(electric && price){
				if (currentCar.getPower() == Car.ELECTRIC_MOTOR && (currentCar.getPrice() >= minPrice && currentCar.getPrice() <= maxPrice)){
					System.out.println(displayCar);
				}
			// filter check to see if awd and electric filters are being used
			}else if(awd && electric){
				if (currentCar.isAWD() && currentCar.getPower() ==  Car.ELECTRIC_MOTOR){
					System.out.println(displayCar);
				}
			// filter check to see if awd filter is being used
			}else if(awd){
				if(currentCar.isAWD()){
					System.out.println(displayCar);
				}
			// filter check to see if eletric filter is being used
			}else if(electric){
				if(currentCar.getPower() == Car.ELECTRIC_MOTOR){
					System.out.println(displayCar);
				}
			// filter check to see if price filter is being used			
			}else if (price){
				if(currentCar.getPrice() >= minPrice && currentCar.getPrice() <= maxPrice){
					System.out.println(displayCar);
				}
			// if no filters are in place just displays the car
			}else{
				System.out.println(displayCar);
			}
		}
	}

	// sets boolean for filter by electrc to true
	public void filterByElectric(){
		electric = true;
	}

	// sets boolean for filter by AWD to true
	public void filterByAWD(){
		awd = true;
	}

	// sets boolean for filter by price to true
	public void filterByPrice(double minPrice, double maxPrice){
		this.minPrice = minPrice;
		this.maxPrice = maxPrice;
		price = true;
	}

	// clears booleans for filters by setting all to false (reset)
	public void FiltersClear(){
		electric = false;
		awd = false;
		price = false;
	}
	
	// Sorts all cars in array in order of price
	public void sortByPrice(){
		Collections.sort(cars);
	}

	// comparator class that compares each cars safety rating to help sort
	class SafetyRatingComparator implements Comparator<Car>{
		public int compare(Car a, Car b){
			if (a.getSafetyRating() < b.getSafetyRating()){
				return 1;
			}
			if (a.getSafetyRating() > b.getSafetyRating()){
				return -1;
			}
			return 0;
		}
	}

	// Sorts all cars in array in order of safety rating
	public void sortBySafetyRating(){
		Collections.sort(cars, new SafetyRatingComparator());
	}

	// comparator class that compares each cars max range to help sort
	class MaxRangeComparator implements Comparator<Car>{
		public int compare(Car a, Car b){
			if (a.getMaxRange() < b.getMaxRange()){
				return 1;
			}
			if (a.getMaxRange() > b.getMaxRange()){
				return -1;
			}
			return 0;
		}
	}

	// Sorts all cars in array in order of max range
	public void sortByMaxRange(){
		Collections.sort(cars, new MaxRangeComparator());
	}

	/**
	 * @return the carBought
	 */
	public Car getCarBought() {
		return boughtCar;
	}

}