import java.beans.ExceptionListener;
import java.beans.XMLDecoder;
import java.beans.XMLEncoder;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.Random;

public class Application {
	private static Application single_instance = null;
	private List<User> userList = new ArrayList<>();

	public User currentUser = null;

	static Application getInstance() {
		if (single_instance == null) {
			single_instance = new Application();
		}
		return single_instance;
	}

	private Application() {
		this.initUsers();
	}

	private void initUsers() {
		try (FileInputStream fis = new FileInputStream("users.xml")) {
			XMLDecoder decoder = new XMLDecoder(fis);
			this.userList = (ArrayList<User>) decoder.readObject();
			decoder.close();
			fis.close();
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}
	}

	public void login(User user) throws Exception {
		int index = userList.indexOf(user);
		if (index != -1) {
			Application.getInstance().currentUser = userList.get(index);
		} else {
			throw new Exception("Username sau parola este gresita!");
		}
	}
}
