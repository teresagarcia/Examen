package es.salesianos.model;

public class Actor extends BaseEntity {

	private String name;
	private int yearOfBirthDate;

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public int getYearOfBirthDate() {
		return yearOfBirthDate;
	}

	public void setYearOfBirthDate(int yearOfBirthDate) {
		this.yearOfBirthDate = yearOfBirthDate;
	}

}
