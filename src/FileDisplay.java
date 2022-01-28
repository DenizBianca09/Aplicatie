import java.beans.ExceptionListener;
import java.beans.XMLDecoder;
import java.beans.XMLEncoder;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;

public class FileDisplay implements IDisplayManager {
	@Override
	public void displayStudents(Student[] students) {
		try {
			FileOutputStream fos = new FileOutputStream("studenti.xml");
			XMLEncoder encoder = new XMLEncoder(fos);
			encoder.setExceptionListener(new ExceptionListener() {
				@Override
				public void exceptionThrown(Exception e) {
					System.out.println(e);
				}
			});
			encoder.writeObject(students);
			encoder.close();
			fos.close();
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}
	}

	@Override
	public void displayTeachers(Profesor[] profesors) {
		try {
			FileOutputStream fos = new FileOutputStream("profesori.xml");
			XMLEncoder encoder = new XMLEncoder(fos);
			encoder.setExceptionListener(new ExceptionListener() {
				@Override
				public void exceptionThrown(Exception e) {
					System.out.println(e);
				}
			});
			encoder.writeObject(profesors);
			encoder.close();
			fos.close();
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}
	}

	@Override
	public void displayCourses(Curs[] cursuri) {
		try {
			FileOutputStream fos = new FileOutputStream("cursuri.xml");
			XMLEncoder encoder = new XMLEncoder(fos);
			encoder.setExceptionListener(new ExceptionListener() {
				@Override
				public void exceptionThrown(Exception e) {
					System.out.println(e);
				}
			});
			encoder.writeObject(cursuri);
			encoder.close();
			fos.close();
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
}
