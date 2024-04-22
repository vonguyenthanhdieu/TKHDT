package Lab1;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class MyITCenter {
	private List<Lecturer> lecturers = new ArrayList<Lecturer>();
	private List<Student> students = new ArrayList<Student>();
	private List<Course> courses = new ArrayList<Course>();

	public MyITCenter() {
		init();
	}

	public void init() {
		Lecturer l1 = new Lecturer("Pham Van Tinh", new Date(20, 11, 1970), "PhD");
		Lecturer l2 = new Lecturer("Mai Anh Tho", new Date(24, 12, 1979), "MS");
		Lecturer l3 = new Lecturer("Nguyen Duc Cong Song", new Date(14, 8, 1977), "MS");
		lecturers.add(l1);
		lecturers.add(l2);
		lecturers.add(l3);
		Course c1 = new Course("Lap trinh co ban", 4, l2);
		Course c2 = new Course("Lap trinh nang cao", 4, l3);
		Course c3 = new Course("Lap trinh mang", 4, l1);
		Course c4 = new Course("Mang may tinh", 4, l1);
		courses.add(c1);
		courses.add(c2);
		courses.add(c3);
		courses.add(c4);
		Student s1 = new Student("Nguyen Van Tuan", new Date(02, 9, 1999));
		Student s2 = new Student("Tran Van Thiet", new Date(15, 12, 1989));
		Student s3 = new Student("Nguyen Thi Lan", new Date(20, 3, 1993));
		Student s4 = new Student("Nguyen Thi Truc", new Date(21, 7, 1996));
		Student s5 = new Student("Vo Tan Doi", new Date(31, 12, 2004));
		Student s6 = new Student("Do The Sang", new Date(30, 11, 2002));
		students.add(s1);
		students.add(s2);
		students.add(s3);
		students.add(s4);
		students.add(s5);
		students.add(s6);
		s1.register(c1);
		s1.register(c2);
		s1.register(c3);
		s2.register(c2);
		s2.register(c3);
		s2.register(c4);
		s3.register(c1);
		s3.register(c2);
		s3.register(c3);
		s3.register(c4);
		s4.register(c1);
		s4.register(c3);
		s4.register(c4);
		s5.register(c1);
		s5.register(c2);
		s5.register(c3);
		s5.register(c4);
		s6.register(c1);
		s6.register(c2);
		s1.updateGrade(c1, 6);
		s1.updateGrade(c2, 7);
		s1.updateGrade(c3, 8);
		s2.updateGrade(c2, 8.5f);
		s2.updateGrade(c3, 5);
		s2.updateGrade(c4, 7);
		s3.updateGrade(c1, 4);
		s3.updateGrade(c2, 7.5f);
		s3.updateGrade(c3, 8);
		s3.updateGrade(c4, 10);
		s4.updateGrade(c1, 8);
		s4.updateGrade(c3, 3);
		s4.updateGrade(c4, 6);
		s5.updateGrade(c1, 5);
		s5.updateGrade(c2, 4);
		s5.updateGrade(c3, 6);
		s5.updateGrade(c4, 8);
		s6.updateGrade(c1, 5);
		s6.updateGrade(c2, 8);
	}

	public static void printList(List<?> list) {
		for (Object o : list) {
			System.out.println(o);
		}
		System.out.println("--------------------------");
	}

	public Student findStudentByName(String name) {

		for (Student s : students) {
			if (s.getName().equals(name))
				return s;
		}
		return null;
	}

	public Course findCourseByName(String name) {
		for (Course c : courses) {
			if (c.getName().equals(name))
				return c;
		}
		return null;
	}

	public List<Student> getStudentsOfCourse(Course c) {
		List<Student> result = new ArrayList<Student>();
		for (Student student : students) {
			for (Register register : student.getCourseRegisters()) {
				if (register.getCourse().getName().equals(c.getName()))
					result.add(student);
			}
		}
		return result;
	}

	// print report card use case
	public void printStudentReportCardUsecase() {
		Scanner in = new Scanner(System.in);
		System.out.println("Enter student name:");
		String studentName = in.nextLine();
		Student student = findStudentByName(studentName.trim());
		if (student != null) {
			student.printGradeReport();
		} else {
			System.out.println("Student name not found!");
		}
	}

	// print student list of course use case
	public void printStudentsOfCourseUsecase() {
		Scanner in = new Scanner(System.in);
		System.out.println("Enter course name:");
		String courseName = in.nextLine();
		Course course = findCourseByName(courseName.trim());
		if (course != null) {
			printList(getStudentsOfCourse(course));
		} else {
			System.out.println("Course name not found!");
		}
	}

	public static void main(String[] args) {
		MyITCenter myCenter = new MyITCenter();
		myCenter.printStudentReportCardUsecase();
		myCenter.printStudentsOfCourseUsecase();

	}
}
