package hu.uni.miskolc.iit.java.technologies.carshop.service.impl;

import java.util.Collection;

import hu.uni.miskolc.iit.java.technologies.carshop.api.model.Car;
import hu.uni.miskolc.iit.java.technologies.carshop.api.service.CarManagementService;
import hu.uni.miskolc.iit.java.technologies.carshop.service.dao.CarDAO;

public class CarManagementServiceImpl implements CarManagementService {

	private CarDAO carDAO;

	public CarManagementServiceImpl(CarDAO carDAO) {
		super();
		this.carDAO = carDAO;
	}

	public Collection<Car> listCars() {
		return carDAO.readCars();
	}

	public void acquireCar(Car car) {
		carDAO.createCar(car);
	}

}
