package hu.uni.miskolc.iit.java.technologies.carshop.api.service;

import java.util.Collection;

import hu.uni.miskolc.iit.java.technologies.carshop.api.model.Car;

public interface CarManagementService {

	Collection<Car> listCars();
	void acquireCar(Car car);
	
}
