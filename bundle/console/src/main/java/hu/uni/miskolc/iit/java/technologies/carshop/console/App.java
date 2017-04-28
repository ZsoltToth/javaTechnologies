package hu.uni.miskolc.iit.java.technologies.carshop.console;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

import hu.uni.miskolc.iit.java.technologies.carshop.api.model.Car;
import hu.uni.miskolc.iit.java.technologies.carshop.api.model.Car.Producer;
import hu.uni.miskolc.iit.java.technologies.carshop.api.service.CarManagementService;
import hu.uni.miskolc.iit.java.technologies.carshop.persist.CarDAOJSON;
import hu.uni.miskolc.iit.java.technologies.carshop.service.impl.CarManagementServiceImpl;

/**
 * Hello world!
 *
 */
public class App 
{
	private static CarManagementService carManager;
	
	static {
		carManager = new CarManagementServiceImpl(new CarDAOJSON("resources/cars.json"));
	}
	
    public static void main( String[] args ) throws IOException
    {
    	boolean run = true;
    	while(run){
    		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    		String line = br.readLine();
    		if("exit".equals(line)){
    			break;
    		}
    		if("list cars".equals(line)){
    			listCars();
    		}
    		if("insert car".equals(line)){
    			addCar();
    		}
    	}
        
        
    }
    
    private static void listCars(){
    	for(int i = 0; i < 30; i++){
    		System.out.print("-");
    	}
    	System.out.println();
    	System.out.println("| PlateNo | Producer | Color | # Doors | Horse Power |");
    	for(int i = 0; i < 30; i++){
    		System.out.print("-");
    	}
    	System.out.println();
    	for(Car car : carManager.listCars()){
    		System.out.println(String.format("| %1$7s | %2$8s | %3$5s | %4$7d | %5$11d |", car.getPlateNo(), car.getProducer(),car.getColor(), car.getNumberOfDoors(), car.getHorsePower()));
//        	System.out.println(car.getPlateNo());
        	for(int i = 0; i < 30; i++){
        		System.out.print("-");
        	}
        	System.out.println();
        }
    }
    
    private static void addCar() throws IOException{
    	BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    	System.out.println("Plate No.: ");
    	String plateNo = br.readLine();
    	System.out.println("Producer: ");
    	Producer producer = Producer.valueOf(br.readLine());
    	System.out.println("Color");
    	String color = br.readLine();
    	System.out.println("Number of Doors: ");
    	int doors = Integer.parseInt(br.readLine());
    	System.out.println("Horse Power: ");
    	int horsePower = Integer.parseInt(br.readLine());
    	Car car = new Car(plateNo, producer, color, doors, horsePower);
    	carManager.acquireCar(car);
    	
    }
    
    
}
