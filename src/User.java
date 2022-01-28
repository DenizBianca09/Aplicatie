import java.util.Objects;

public class User {
	public String userName;
	public String password;
	public MenuStrategy menuStrategy;

	public User() {

	}

	@Override
	public boolean equals(Object o) {
		if (this == o)
			return true;
		if (!(o instanceof User))
			return false;
		User user = (User) o;
		return Objects.equals(userName, user.userName) && Objects.equals(password, user.password);
	}

	@Override
	public int hashCode() {
		return Objects.hash(userName, password);
	}

	public User(String userName, String password) {
		this.userName = userName;
		this.password = password;
	}

	@Override
	public String toString() {
		return "User{" + "userName='" + userName + '\'' + ", password='" + password + '\'' + '}';
	}

	public User(String userName, String password, MenuStrategy accountType) {
		this.userName = userName;
		this.password = password;
		this.menuStrategy = accountType;
	}
}
