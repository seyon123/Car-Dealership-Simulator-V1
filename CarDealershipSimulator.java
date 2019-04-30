/**
 * Name: Seyon Rajagopal
 * Student ID: 500885401
 * Class Name: CarDealershipSimulator.java 
 * 
 */

import java.io.*;
import java.util.*;

// this class is for the simulator which the user inputs all cammands of Car Dealership into
public class CarDealershipSimulator {

	// Main
	public static void main(String[] args) throws IOException {

		// CarDealership object
		CarDealership dealer = new CarDealership();
		// array list of type Car
		ArrayList<Car> cars = new ArrayList<Car>();
		// Calls the class that reads the txt file and creates Car objects
		TxtReader file = new TxtReader();
		file.readFile();

		// Adds cars from the TxtReader class to cars arrylist
		cars.addAll(file.carsList);

		String text = "";
		String command = "";

		// Create a scanner object
		Scanner sc = new Scanner(System.in);
		System.out.print("Enter a command ('Q' to quit): ");
		// while the scanner has another line

		while (sc.hasNextLine()) {
			try {
				// read the input line
				text = sc.nextLine();
				// create another scanner object (call it "commandLine" or something) using the
				// input line instead of System.in
				Scanner commandLine = new Scanner(text);
				// read the next word from the commandLine scanner
				command = commandLine.next();
				// The following lines of if and else statements check if the command entered is equal
				// to one of the commands and if so, call the appropriate method via the CarDealership object

				// Formatting to print out list of cars when "L" is inputted
				if (command.equals("L") && !commandLine.hasNext()) {
					System.out.println("********************************************************************************************");
					System.out.println("NO      MF      Color   Model   Range   SR    AWD     Price         Engine      RT  Battery ");
					System.out.println("********************************************************************************************");

					// check to see if array is empty if it isnt displays all the cars
					if (!dealer.checkArrayFilled()) {
						System.out.println("\nPlease add cars using command 'ADD' first");
						System.out.println("\n********************************************************************************************");
					} else {
						dealer.displayInventory();
						System.out.println("********************************************************************************************");
					}

					// When user enters "Q" program quits
				} else if (command.equals("Q") && !commandLine.hasNext()) {
					commandLine.close();
					sc.close();
					System.out.print("\nYou Have Quitted The Program! \n");
					break;

				// When user enters "BUY" followed by a number(index/No of car) buys the car
				} else if (command.equals("BUY")) {
					if (!commandLine.hasNext()) {
						System.out.println("\nPlease Add 1 More Number After BUY (eg. BUY 6)");
					}else{				
						int index = commandLine.nextInt();
						// throws exception when input is enterd after command when not supposed to
						if (commandLine.hasNext()) {
							commandLine.close();
							throw new NoSuchElementException();
						}

						// store the current car
						Car currentCar = dealer.buyCar(index);

						// Check to see if current car exists, if it does prints it showing successfully bought car
						if (currentCar != null) {
							System.out.println("\nYou Have Succesfully Bought Car: \n# " + index + "  " + currentCar.display());
						}else {
							commandLine.close();
							throw new IndexOutOfBoundsException("\nSorry, Car#" + index + " Doesnt Exist!");
							
						}
					}

				// When user enters "RET" the car they bought is returned and put back into arraylist 
				} else if (command.equals("RET") && !commandLine.hasNext()) {

					Car currentCar = dealer.getCarBought();
					dealer.returnCar(currentCar);
					System.out.println("\nCar Successfully Returned!");

				// When user enters "ADD" adds all the cars to arraylist in CarDealership class
				} else if (command.equals("ADD") && !commandLine.hasNext()) {
					dealer.addCars(cars);
					System.out.println("\nSuccessfully Added Cars!");

				// When user enters "SPR" sorts by price
				} else if (command.equals("SPR") && !commandLine.hasNext()) {

					// check to see if array is filled
					if (!dealer.checkArrayFilled()) {
						System.out.println("\nThere Are NO Cars To Sort. Please Add Cars Using Command 'ADD' First");
					} else {
						dealer.sortByPrice();
						System.out.println("\nDone Sorting!");
					}

				// When user enters "SSR" sorts by safety rating
				} else if (command.equals("SSR") && !commandLine.hasNext()) {

					// check to see if array is filled
					if (!dealer.checkArrayFilled()) {
						System.out.println("\nThere Are NO Cars To Sort. Please Add Cars Using Command 'ADD' First");
					} else {
						dealer.sortBySafetyRating();
						System.out.println("\nDone Sorting!");
					}

				// When user enters "SMR" sorts by max range
				} else if (command.equals("SMR") && !commandLine.hasNext()) {

					// check to see if array is filled
					if (!dealer.checkArrayFilled()) {
						System.out.println("\nThere Are NO Cars To Sort. Please Add Cars Using Command 'ADD' First");
					} else {
						dealer.sortByMaxRange();
						System.out.println("\nDone Sorting!");
					}

				// When user enters "FPR" followed by a minimum price and max price it filters by price
				} else if (command.equals("FPR")) {

					// check to see if array is filled and if if the next values are valid
					if (!dealer.checkArrayFilled()) {
						System.out.println("\nThere Are NO Cars To Fiter. Please Add Cars Using Command 'ADD' First");
					} else {
						// check to see if there is text after 'FPR' to see if command is valid
						if (!commandLine.hasNext()) {
							System.out.println("\nPlease Add 2 Numbers After FPR (eg. FPR 20000 30000)");
						} else {
							int minPrice = commandLine.nextInt();
							// check to see if there is text after 'FPR (integer)' to see if command is valid
							if (!commandLine.hasNext()) {
								System.out.println("\nPlease Add 1 More Number After FPR (eg. FPR 20000 30000)");
							// throws exception when input is enterd after command when not supposed to
							} else {
								int maxPrice = commandLine.nextInt();
								if (commandLine.hasNext()) {
									commandLine.close();
									throw new NoSuchElementException();
								// if all conditions are fine then does the filter command
								}else {
									dealer.filterByPrice(minPrice, maxPrice);
									System.out.println("\nDone Filtering!");
								}
							}
						}
					}

				// When user enters "FEL" filters by electric cars
				} else if (command.equals("FEL") && !commandLine.hasNext()) {
					// check to see if array is filled
					if (!dealer.checkArrayFilled()) {
						System.out.println("\nThere Are NO Cars To Filter. Please Add Cars Using Command 'ADD' First");
					} else {
						dealer.filterByElectric();
						System.out.println("\nDone Filtering!");
					}

				// When user enters "FAW" filters by all-wheel-drive cars
				} else if (command.equals("FAW") && !commandLine.hasNext()) {

					// check to see if array is filled
					if (!dealer.checkArrayFilled()) {
						System.out.println("\nThere Are NO Cars To Filter. Please Add Cars Using Command 'ADD' First");
					} else {
						dealer.filterByAWD();
						System.out.println("\nDone Filtering!");
					}

				// When user enters "FCL" resets all filters
				} else if (command.equals("FCL") && !commandLine.hasNext()) {
					dealer.FiltersClear();
					System.out.println("\nCleared All Filters!");

					// If anything other than a command is entered No such element exception is thrown
				} else {
					commandLine.close();
					throw new NoSuchElementException();
				}
				commandLine.close();
			
			// Catches exception related to invalid arguments being used
			} catch (IllegalArgumentException e){
				System.out.println(e.getMessage());
			// Catches exception related to calling an object/item of invalid index in arrayList
			} catch (IndexOutOfBoundsException e){
				System.out.println(e.getMessage());
			// Catches exception related to input not having the right types
			} catch (InputMismatchException e) {
				System.out.println("\nSorry, '" + text + "' Is An Unknown Command! " + e + " Occured! Please Make Sure Your Input Has Correct Data");
			// Catches exception related to empty string or nothing being entered
			} catch (NoSuchElementException e) {
				System.out.println("\nSorry, '" + text + "' Is An Unknown Command! " + e + " Occured! Please Enter Valid Input");
			// Catches any other exception
			} catch (Exception e) {
				System.out.println("\nSorry, '" + text + "' Is An Unknown Command! " + e + " Occured!");
			}
			System.out.print("\nEnter another command ('Q' to quit): ");
		}
	}
}
