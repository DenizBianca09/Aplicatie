import java.util.HashMap;

public class Settings {
	static String STUDENTS_PATH = "studenti.csv";
	static String TEACHERS_PATH = "profesori.csv";
	static String COURSES_PATH = "cursuri.csv";
	static LOAD_TYPE loadType = LOAD_TYPE.HARDCODAT;
	static DISPLAY_TYPE displayType = DISPLAY_TYPE.GUI;
	static HashMap<LOAD_TYPE, IDataLoader> dataLoaderHashMap = new HashMap<>() {
		{
			put(LOAD_TYPE.HARDCODAT, new HardcodatDataManager());
			put(LOAD_TYPE.FILE, new FileDataManager());
			put(LOAD_TYPE.KEYBOARD, new KeyboardDataManager());
		}
	};
	static HashMap<DISPLAY_TYPE, IDisplayManager> displayHashMap = new HashMap<>() {
		{
			put(DISPLAY_TYPE.CONSOLA, new ConsoleDisplay());
			put(DISPLAY_TYPE.FISIER, new FileDisplay());
			put(DISPLAY_TYPE.GUI, new GraphicUserInterfaceDisplay());
		}
	};

}
