import java.util.HashSet;
import java.util.Random;
import java.util.Set;

public class DataManager {
	public ManagerCursuri manager = new ManagerCursuri();
	// Obiectul rand genereaza numere aleatorii. Folosit in programul de testare
	public Random rand = new Random();
	public int minimumRequiredStudents = 5;
	public Student[] dataSetOfStudent = createStudentsData();
	public Profesor[] dataSetOfProfesor = createProfesorData();
	
	public DataManager() {
		this.createCoursesData();
	}
	
	public Student[] createStudentsData() {
		String nume[] = { "Jarcau", "Oprea", "Solomon", "Patrascu", "Damian", "Cristea", "Visoiu", "Andrei", "Petreanu", "Dragomir", "Gavrila",	"Suciu", "Rotaru", "Grigorescu", "Dudulescu", "Stanculescu"
				, "Vajaiac", "Istudor",	"Bruma", "Neagu", "Popa", "Gribincea", "Cucu", "Milea",	"Coca",	"Iorga", "Budau", "Maracineanu", "Pascociu", "Ionita",	"Paltanea"
				, "Spunei", "Stoian", "Raulea",	"Trifan", "Visan", "Rusu", "Silitra", "Puia" };
		String prenume[] = { "Stefan", "Ionut", "Andrei" ,"Nicolae","Maria","Florinela","Andrei","Mihai","Marius","Sergiu","Iulian","Mihai","Daria","Stefan","Stefan","Daniel","Marius"
				,"Cristian","Daniel","Elena","Ana-Maria","Valentina","Ioana","Daniel","Paul","Bianca","David","Constantin","Andreea","Cezar","Auras","Razvan","Emanuel","Andrei","Ioan","Marian","Victor","Florin","Madalina"};
		
		Student studenti[] = new Student[nume.length];
		for (int i = 0; i < nume.length;i++) {
			Student s = new Student(nume[i], prenume[i], 1 + rand.nextInt(4));
			studenti[i] = s;
		}
		return studenti;
	}
	
	public Profesor[] createProfesorData() {
		String nume[] = { "URSUTIU", "PANA", "ALEXANDRU","CRETU ", "KRISTALY", "DANILA", "DEMETER",	"DIACONU", "ILEA", "POP", "BOER" };
		String prenume[] = {"DORU","GHEORGHE", "MARIAN","NICOLAE CONSTANTIN", "DOMINIC", "ADRIAN", "ROBERT", "LAURENTIU", "GELU","MIHAIL", "ATTILA"};
		Profesor profesori[] = new Profesor[nume.length];
		for (int i = 0; i < nume.length;i++) {
			profesori[i] = new Profesor(nume[i], prenume[i]);
		}
		return profesori;
	}
	
	public Set<Student> createRandomSetOfStudents() {
		int studentInscrisiLaCurs = minimumRequiredStudents + rand.nextInt(dataSetOfStudent.length - minimumRequiredStudents);
		Set<Student> setOfStudents = new HashSet<Student>();
		for (int i = 0; i < studentInscrisiLaCurs; i++) {
			int randomStudentIndex = rand.nextInt(dataSetOfStudent.length);
			setOfStudents.add(dataSetOfStudent[randomStudentIndex]);
		}
		return setOfStudents;
	}
	
	public void createCoursesData() {
		String curs[] = { "Teoria sistemelor", "Masurari electronice", "Dispozitive electronice", "Structuri de date", "Procesarea semnalelor", "Limba engleza", "Limbaje formale", "PCLP 1", "PCLP 2" };
		String descriere = "descriere curs";
		
		for (String numeCurs : curs) {
			Set<Student> studentsData = createRandomSetOfStudents();
			Profesor profesor = dataSetOfProfesor[rand.nextInt(dataSetOfProfesor.length)];
			Curs c = new Curs(numeCurs, descriere, profesor, studentsData);
			manager.AddCurs(c);
		}
	}
	
	public void gradeStudents() {
		for (Curs c: manager.cursuri) {
			for( Student s: c.studenti) {
				try {
					c.noteazaStudent(s, 1 + rand.nextInt(10));
				} catch (Exception e) {

				}
			}
		}
	}
}
