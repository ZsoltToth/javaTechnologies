package hu.uni.miskolc.iit.java.technologies.carshop.persist;

import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collection;

import com.fasterxml.jackson.core.JsonGenerationException;
import com.fasterxml.jackson.core.JsonParseException;
import com.fasterxml.jackson.databind.JsonMappingException;
import com.fasterxml.jackson.databind.ObjectMapper;

import hu.uni.miskolc.iit.java.technologies.carshop.api.model.Car;
import hu.uni.miskolc.iit.java.technologies.carshop.service.dao.CarDAO;

public class carDAOJSON implements CarDAO {

	private File database;
	
	public carDAOJSON(String databasePath) {
		this.database = new File(databasePath);
		System.out.println(database.getAbsolutePath());
	}

	public void createCar(Car car) {
		Collection<Car> allCars = readCars();
		allCars.add(car);
		Car[] extendedDatabase = allCars.toArray(new Car[allCars.size()]);
		ObjectMapper mapper = new ObjectMapper();
		try {
			mapper.writeValue(database, extendedDatabase);
		} catch (JsonGenerationException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (JsonMappingException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		

	}

	public Collection<Car> readCars() {
		ObjectMapper mapper = new ObjectMapper();
		Car[] cars = new Car[] {};
		try {
			cars = mapper.readValue(database, Car[].class);
		} catch (JsonParseException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (JsonMappingException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		Collection<Car> result = new ArrayList<Car>(Arrays.asList(cars));
		return result;
	}

}
