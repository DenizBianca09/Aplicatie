import java.util.ArrayList;
import java.util.List;

public class ManagerCursuri {
	// Organizarea claselor se face deobicei dupa regula: Membri, Metode private, Constructori, metode publice
	List<Curs> cursuri;
	
	// Metoda cauta un curs in lista de cursuri si arunca exceptie in cazul in care nu-l gaseste. Exceptia trebuie tratata in exterior
	private Curs search(Curs unCurs) throws Exception {
		int i = cursuri.indexOf(unCurs);
		if ( i != -1 ) {
			return cursuri.get(i);
		}
		else {
			throw new Exception("Cursul " + unCurs + " nu se se regaseste in programa scolara");
		}
	}
	
	public ManagerCursuri() {
		this.cursuri = new ArrayList<Curs>();
	}
	
	public void AddCurs(Curs c) {
		this.cursuri.add(c);
	}
	
	public void RemoveCurs(Curs c) throws Exception {
		if (!this.cursuri.remove(c)) {
			throw new Exception("Cursrul " + c + " nu poate fi sters pentru ca nu se regaseste in programa scolara");
		}
	}
	
	public void EditCurs(Curs c, Curs cursNou) throws Exception {
		// Caut cursul in lista de cursuri
		int i = cursuri.indexOf(c);
		// verific daca cursul exista
		if ( i != -1) {
			cursuri.set(i, cursNou);
		} else {
			throw new Exception("Cursul " + c + " nu se regaseste in programa scolara");
		}
	}
	
	public void reportStudentsOf(Curs unCurs) throws Exception {
		Curs c = this.search(unCurs);
		c.AfisareStudenti();
	}
	
	public void reportAllCourses() {
		for( Curs c: cursuri) {
			System.out.println( c.nume + " " + c.descriere);
			try {
				// this.reportStudentsOf(c);
			} catch (Exception e) {

			}
		}
	}
	
	public void reportAllStudentsGrades() {
		for( Curs c: cursuri) {
			c.AfisareNumeCurs();
			for ( Student s: c.studenti) {
				String gradeAsString = c.nota.get(s) != null ? c.nota.get(s).toString() : " nu a fost notat";
				System.out.println( s.nume + " " + s.prenume + " are nota: " + gradeAsString);
			}
		}
	}
	
	public void reportGradesOf(Curs unCurs) throws Exception {
		Curs c = this.search(unCurs);
		System.out.println("Media studentilor la cursul " + c.nume + " este:" + c.MediaStudenti());	
	}
	
	public void reportAverageGradesOf(Profesor unProf) {
		float sum = 0;
		int count = 0;
		for( Curs c : cursuri) {
			if ( c.profu == unProf ) {
				sum += c.MediaStudenti();
				count += 1;
			}
		}
		float average = count == 0 ? 0 : sum / (float)count; 
		System.out.println("Mediat notelor date de profesorul: " + unProf.formatForDisplay() + " este: " + average );
	}
	
}
