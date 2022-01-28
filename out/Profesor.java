public class Profesor {
	String nume;
	String prenume;
	
	public Profesor(String nume, String prenume) {
		this.nume = nume;
		this.prenume = prenume;
	}
	
	public String formatForDisplay() {
		return this.nume + " " + this.prenume;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((nume == null) ? 0 : nume.hashCode());
		result = prime * result + ((prenume == null) ? 0 : prenume.hashCode());
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
		Profesor other = (Profesor) obj;
		if (nume == null) {
			if (other.nume != null)
				return false;
		} else if (!nume.equals(other.nume))
			return false;
		if (prenume == null) {
			if (other.prenume != null)
				return false;
		} else if (!prenume.equals(other.prenume))
			return false;
		return true;
	}

	@Override
	public String toString() {
		return "Profesor [nume=" + nume + ", prenume=" + prenume + "]";
	}
}
