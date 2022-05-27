package Examen;

public class Tupla implements Comparable {
	private String accidentality;
	private int occurrences;
	private String con;
	
	public Tupla() {
		
	}
	
	public Tupla(String accidentality, int occurrences, String con) {
		this.accidentality = accidentality;
		this.occurrences = occurrences;
		this.con = con;
	}

	public String getAccidentality() {
		return accidentality;
	}

	public void setAccidentality(String accidentality) {
		this.accidentality = accidentality;
	}

	public int getOccurrences() {
		return occurrences;
	}

	public void setOccurrences(int occurrences) {
		this.occurrences = occurrences;
	}

	public String getCon() {
		return con;
	}

	public void setCon(String con) {
		this.con = con;
	}

	@Override
	public int compareTo(Object o) {
		Tupla t = (Tupla) o;
		if(t.getOccurrences() < occurrences){
            return -1;
        } else if(t.getOccurrences()==occurrences){
            return 0;
        } else{
            return 1;
        }
	}
}
