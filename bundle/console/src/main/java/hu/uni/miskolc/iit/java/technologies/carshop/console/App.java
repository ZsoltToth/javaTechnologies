package hu.uni.miskolc.iit.java.technologies.carshop.console;

import hu.uni.miskolc.iit.java.technologies.carshop.api.model.Car;
import hu.uni.miskolc.iit.java.technologies.carshop.api.service.CarManagementService;
import hu.uni.miskolc.iit.java.technologies.carshop.persist.CarDAOJSON;
import hu.uni.miskolc.iit.java.technologies.carshop.service.impl.CarManagementServiceImpl;

/**
 * Hello world!
 *
 */
public class App 
{
    public static void main( String[] args )
    {
        CarManagementService carManager = new CarManagementServiceImpl(new CarDAOJSON("resources/cars.json!"));
        for(Car car : carManager.listCars()){
        	System.out.println(car.getPlateNo());
        }
    }
}
