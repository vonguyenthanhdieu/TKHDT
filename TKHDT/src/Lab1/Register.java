package Lab1;

public class Register {
	Course course;
	float grade;
	public Register(Course course) {
		this.course = course;
//		this.grade = grade;
	}
	public Course getCourse() {
		return course;
	}
	public void setCourse(Course course) {
		this.course = course;
	}
	public float getGrade() {
		return grade;
	}
	public void setGrade(float grade) {
		this.grade = grade;
	}
	
	public float subTotal() {
		return grade * getCourse().getCredits();
	}
}
