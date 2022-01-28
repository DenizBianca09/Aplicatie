import java.io.FileNotFoundException;
import java.lang.reflect.Array;
import java.util.*;
import java.io.File;

public class TestClass {
	public static Student readStudentForm(String line) throws Exception {
		// Ana, are, mere - String
		// String[] substringuri = line.split(","); // -> ["ana", "are", "mere"];
		try( Scanner rowScanner = new Scanner(line)) {
			rowScanner.useDelimiter(",");
			ArrayList<String> properties = new ArrayList<String>();
			while (rowScanner.hasNext()) {
				properties.add(rowScanner.next());
			}
			return new Student(properties);
		}
	}

	public static void main(String[] args) {
		/* Scanner scanner = new Scanner(System.in);
		System.out.println("a =");
		String a = scanner.next();
		try {
			int aCaNrIntreg = Integer.parseInt(a);
			System.out.print("Am citit " + aCaNrIntreg);
		} catch (Exception e) {
			System.out.println(e.getMessage());
		} */
		ArrayList<Student> students = new ArrayList<>();
		try( Scanner scanner = new Scanner(new File("studenti.csv"))) {
			while(scanner.hasNextLine()) {
				try {
					Student s = readStudentForm(scanner.nextLine());
					students.add(s);
				} catch (Exception ex) {
					System.out.println(ex.getMessage());
				}
			}
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		}

		for( Student s: students) {
			System.out.println(s);
		}

	}
}
