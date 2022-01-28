import java.util.HashMap;

public class StudentStrategy implements MenuStrategy{
    public Student student;
    public StudentStrategy() { }
    StudentStrategy(Student student) {
        this.student = student;
    }

    @Override
    public UserAccountType getAccountType() {
        return UserAccountType.STUDENT;
    }

    @Override
	public HashMap<String, String> getAccountHolderInformation() {
        return new HashMap<>() {{
            put(student.nume, student.prenume);
        }};
    }

    @Override
    public String[] getAccountMenuOptions() {
        return new String[0];
    }

    @Override
    public void nextMenuOption() {

    }

    @Override
    public void previousMenuOption() {

    }
}
