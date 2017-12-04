package proyecto;

import java.util.*;

/**
 * 
 */
public class Profesor extends Mago implements Volador {

    private String FIngreso;
    private String Hechizo;
    private String Animal;
    private String Pocion;
    private String Deporte;

    public Profesor(String Nombres,String Apellidos, int Edad, String Casa,
    String Varita, Tipo_Mago Tipo,String FIngreso,String Hechizo,String Animal,String Pocion,String Deporte) {

        super(Nombres, Apellidos, Edad, Casa, Varita, Tipo);
        this.FIngreso=FIngreso;
        this.Deporte=Deporte;
        this.Animal=Animal;
        this.Pocion=Pocion;
        this.Hechizo=Hechizo;
    }

    public void setIngreso(String FIngreso) {
        this.FIngreso=FIngreso;
    }

    public void setAnimal(String Animal) {
        this.Animal=Animal;
    }

    public void setHechizo(String Hechizo) {
        this.Hechizo=Hechizo;
    }

    public void setDeporte(String Deporte) {
        this.Deporte=Deporte;
    }

    public void setPocion(String Pocion) {
        this.Pocion=Pocion;
    }

    public String getIngreso() {
        // TODO implement here
        return FIngreso;
    }

    public String getAnimal() {
        // TODO implement here
        return Animal;
    }

    public String getHechizo() {
        // TODO implement here
        return Hechizo;
    }

    public String getDeporte() {
        // TODO implement here
        return Deporte;
    }

    public String getPocion() {
        // TODO implement here
        return Pocion;
    }

    @Override
    public void Despegar() {
    
    }

    @Override
    public void Volar() {
    
    }

}