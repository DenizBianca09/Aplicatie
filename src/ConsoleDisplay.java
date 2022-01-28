public class ConsoleDisplay implements IDisplayManager {
	@Override
	public void displayStudents(Student[] students) {
		for (Student s : students) {
			System.out.println(s);
		}
	}

	@Override
	public void displayTeachers(Profesor[] profesors) {
		System.out.println(profesors);
	}

	@Override
	public void displayCourses(Curs[] cursuri) {
		System.out.println(cursuri);
	}
}
