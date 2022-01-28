import java.util.HashMap;

public class TeacherStrategy implements MenuStrategy {
	public Profesor profesor;

	public TeacherStrategy() {
	}

	TeacherStrategy(Profesor p) {
		this.profesor = p;
	}

	@Override
	public UserAccountType getAccountType() {
		return UserAccountType.TEACHER;
	}

	@Override
	public HashMap<String, String> getAccountHolderInformation() {
		return new HashMap<>() {
			{
				put(profesor.nume, profesor.prenume);
			}
		};
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
