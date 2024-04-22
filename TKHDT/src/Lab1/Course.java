package Lab1;

public class Course {
	String name;
	int credits;
	Lecturer lecturer;
	
	public Course(String name, int credits, Lecturer lecturer) {
		this.name = name;
		this.credits = credits;
		this.lecturer = lecturer;
	}
	
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public int getCredits() {
		return credits;
	}
	public void setCredits(int credits) {
		this.credits = credits;
	}
}
