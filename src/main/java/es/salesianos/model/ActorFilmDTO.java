package es.salesianos.model;

public class ActorFilmDTO {
	private String title;
	private String name;
	private int birthYear;

	public String getTitle() {
		return title;
	}

	public void setTitle(String title) {
		this.title = title;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public int getBirthYear() {
		return birthYear;
	}

	public void setBirthYear(int year) {
		this.birthYear = year;
	}
}
