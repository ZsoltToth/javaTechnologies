package hu.uni.miskolc.iit.java.technologies.carshop.service.dao;

import java.util.Collection;

import hu.uni.miskolc.iit.java.technologies.carshop.api.model.Car;

public interface CarDAO {

	void createCar(Car car);
	
	Collection<Car> readCars();
	
	
	
}
