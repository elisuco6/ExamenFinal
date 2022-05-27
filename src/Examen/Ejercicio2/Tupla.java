package Examen.Ejercicio2;

/**
 * pre:---
 * Post: Esta clase nos permite almacenar datos de diferente tipo en este caso creamos accidentality
 * 		que nos permite almacenar un string y occurrences un enetero de este modo podremos posteriormente
 * 		sumar con el.
 */
public class Tupla implements Comparable {
	private String accidentality;
	private int occurrences;
	
	public Tupla() {
		
	}

	public Tupla(String accidentality, int occurrences) {
		this.accidentality = accidentality;
		this.occurrences = occurrences;
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

	/**
	 * Pre: ---
	 * Post: En esta clase comparamos los objetos para asi poder ordenarlos de mayor a menor en este
	 * 		caso.
	 */
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
