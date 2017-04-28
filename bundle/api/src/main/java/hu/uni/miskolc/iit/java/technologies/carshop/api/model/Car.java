package hu.uni.miskolc.iit.java.technologies.carshop.api.model;

public class Car {

	public static enum Producer {
		AUDI, FERRARI, OPEL, BMW
	}

	private String plateNo;
	private Producer producer;
	private String color;
	private int numberOfDoors;
	private int horsePower;

	public Car(String plateNo, Producer producer, String color, int numberOfDoors, int horsePower) {
		super();
		this.plateNo = plateNo;
		this.producer = producer;
		this.color = color;
		this.numberOfDoors = numberOfDoors;
		this.horsePower = horsePower;
	}

	public String getPlateNo() {
		return plateNo;
	}

	public void setPlateNo(String plateNo) {
		this.plateNo = plateNo;
	}

	public Producer getProducer() {
		return producer;
	}

	public void setProducer(Producer producer) {
		this.producer = producer;
	}

	public String getColor() {
		return color;
	}

	public void setColor(String color) {
		this.color = color;
	}

	public int getNumberOfDoors() {
		return numberOfDoors;
	}

	public void setNumberOfDoors(int numberOfDoors) {
		this.numberOfDoors = numberOfDoors;
	}

	public int getHorsePower() {
		return horsePower;
	}

	public void setHorsePower(int horsePower) {
		this.horsePower = horsePower;
	}

}
