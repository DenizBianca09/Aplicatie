import java.util.HashMap;

public interface MenuStrategy {
	UserAccountType getAccountType();

	HashMap<String, String> getAccountHolderInformation();

	String[] getAccountMenuOptions();

	void nextMenuOption();

	void previousMenuOption();
}
