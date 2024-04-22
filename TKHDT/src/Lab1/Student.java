package Lab1;

import java.util.ArrayList;
import java.util.List;

public class Student {
	String name;
	Date dateOfBirth;
	Lecturer assistant;
	List<Register> courseRegisters = new ArrayList<Register>();

	public Student(String name, Date dateOfBirth) {
		this.name = name;
		this.dateOfBirth = dateOfBirth;
	}
	

	public String getName() {
		return name;
	}


	public void setName(String name) {
		this.name = name;
	}


	public Date getDateOfBirth() {
		return dateOfBirth;
	}


	public void setDateOfBirth(Date dateOfBirth) {
		this.dateOfBirth = dateOfBirth;
	}


	public Lecturer getAssistant() {
		return assistant;
	}


	public void setAssistant(Lecturer assistant) {
		this.assistant = assistant;
	}


	public List<Register> getCourseRegisters() {
		return courseRegisters;
	}


	public void setCourseRegisters(List<Register> courseRegisters) {
		this.courseRegisters = courseRegisters;
	}


	// Them register
	public void register(Course c) {
		courseRegisters.add(new Register(c));
	}

	// Them diem cho register
	public void updateGrade(Course c, float grade) {
		for (Register r : courseRegisters) {
			if (r.getCourse().getName().equals(c.getName())) {
				r.setGrade(grade);
				break;
			}
		}
	}

	// Tinh diem trung binh
	public float averageOfGrade() {
		float total = 0;
		int creditTotal = 0;
		for (Register r : courseRegisters) {
			total += r.subTotal();
			creditTotal += r.getCourse().getCredits();
		}
		return total / creditTotal;
	}

	// Xep loai tot nghiep cho hoc vien
	public String rank() {
		float average = averageOfGrade();
		if (average >= 9)
			return "Xuat sac";
		else if (average >= 8)
			return "Gioi";
		else if (average >= 7)
			return "Kha";
		else if (average >= 6)
			return "Trung binh kha";
		else if (average >= 7)
			return "Trung binh";
		else
			return "Rot";
	}

	public void printGradeReport() {
		System.out.println("Name: " + getName());
		System.out.println("Date of birth: " + getDateOfBirth());
		System.out.println("STT\tMon\tDiem");
		for (int i = 0; i < courseRegisters.size(); i++) {
			System.out.println(
					i + "\t" + courseRegisters.get(i).getCourse().getName() + "\t" + courseRegisters.get(i).getGrade());
		}
		System.out.println("Average of grade: " + averageOfGrade());
		System.out.println("Rank: " + rank());
		System.out.println("----------------------------------------");
	}

	public String toString() {
		return getName() + " " + getDateOfBirth();
	}
}
