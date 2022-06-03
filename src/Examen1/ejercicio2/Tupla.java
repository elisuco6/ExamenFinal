package Examen1.ejercicio2;

public class Tupla implements Comparable {
    private String localidad;
    private int poblacion;

    public Tupla() {

    }

    public Tupla(String localidad, int poblacion) {
        this.localidad = localidad;
        this.poblacion = poblacion;
    }

    public String getLocalidad() {
        return localidad;
    }

    public void setLocalidad(String localidad) {
        this.localidad = localidad;
    }

    public int getPoblacion() {
        return poblacion;
    }

    public void setPoblacion(int poblacion) {
        this.poblacion = poblacion;
    }

    @Override
    public int compareTo(Object o) {
        Tupla t = (Tupla) o;
        if(t.getPoblacion() < poblacion){
            return -1;
        } else if(t.getPoblacion() == poblacion){
            return 0;
        } else{
            return 1;
        }
    }

    @Override
    public String toString() {
        return "localidad=" + localidad + " poblacion=" + poblacion;
    }
}
