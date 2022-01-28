import java.util.Comparator;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Set;

public class Curs  {
	String nume;
	String descriere;
	Profesor profu;
	Set<Student> studenti;
	HashMap<Student, Integer> nota;

	// Adaugarea profesorului se face in constructor
	public Curs(String nume, String descriere, Profesor profu, Set<Student> studenti) {
		this.nume = nume;
		this.descriere = descriere;
		this.profu = profu;
		this.studenti = studenti;
		this.nota = new HashMap<Student, Integer>();
	}

	public Curs(String nume) {
		this.nume = nume;
		this.studenti = new HashSet<Student>();
	}
	
	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((nume == null) ? 0 : nume.hashCode());
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Curs other = (Curs) obj;
		if (nume == null) {
			if (other.nume != null)
				return false;
		} else if (!nume.equals(other.nume))
			return false;
		return true;
	}

	public void UpdateProfesor(Profesor profu) {
		this.profu = profu;
	}

	public void AddStudent(Student student) {
		this.studenti.add(student);
	}

	public void StergeStudent(Student student) throws Exception {
		// Verific daca studentul este inscris la curs
		if (!this.studenti.remove(student)) {
			throw new Exception("Studentul " + student + " nu este inscris la acest curs");
		}
		this.nota.remove(student);
	}

	public void ModificaStudent(Student student, Student studentnou) {
		// Sterg studentul vechi
		if( this.studenti.remove(student)) {
			// Adaug studentul nou in set
			this.studenti.add(studentnou);
		} 
		// Sterg nota studentului vechi si adaug aceeasi nota pentru studentul nou introdus
		if ( this.nota.get(student) != null) {
			Integer notaStudent = this.nota.get(student);
			this.nota.remove(student);
			this.nota.put(studentnou, notaStudent);
		}
	}

	@Override
	public String toString() {
		String str = "Curs: " + "nume=" + nume + ", descriere=" + descriere + ",\nprofu=" + profu + ",\nstudenti:\n";
		for (Student s : studenti) {
			Integer notaStudent = nota.get(s) != null ? nota.get(s) : 0; 
			str += s + " " +  notaStudent ;
		}
		return str;
	}

	public void AfisareStudenti() {
		String str = "";
		for (Student s : studenti) {
			str += s + " " +  nota.get(s);
		}
		System.out.println(str);
	}

	public void noteazaStudent(Student s, int notaStudentului) throws Exception {
		if ( this.studenti.contains(s)) {
			this.nota.put(s, notaStudentului);
		} else {
			throw new Exception("Studentul " + s + " nu poate fi notat pentru ca nu participa la curs");
		}
	}

	public void AfisareNumeCurs() {
		System.out.println(this.nume + ":");
	}

	public float MediaStudenti() {
		// Varianta moderna Java
		return (float) nota.values().stream().mapToInt(a -> a).average().orElse(0);
		/* Varianta in care scrieti voi parcurgerea
		int media = 0;
		for (Student s: studenti) {
			media += nota.get(s);
		}
		return media / (float)studenti.size(); */ 
	}

}