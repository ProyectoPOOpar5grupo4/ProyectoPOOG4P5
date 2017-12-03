package proyecto;


/**
 * 
 */
public class Curso {
    
    //Declaracion de los atributos
    private int Capacidad;
    private String NombreMateria;
    private String NombreProfesor;
    private String Hora;
    private String Dia;
    
    //Declaracion de los metodos de la clase Curso
     public Curso(int Capacidad,String NombreMateria, String NombreProfesor,String Hora,String Dia) {
         this.Capacidad=Capacidad;
         this.NombreMateria=NombreMateria;
         this.NombreProfesor=NombreProfesor;
         this.Dia=Dia;
         this.Hora=Hora;
    }
    
    //Métodos get and set de los atributos de la clase Curso
    public void setCapacidad(int Capacidad) {
        this.Capacidad=Capacidad;
    }
    
    public void setMateria(String Materia) {
        NombreMateria=Materia;
    }
    
    public void setProfesor(String Profesor) {
        NombreProfesor=Profesor;
    }
    
    public void setDia(String Dia) {
        this.Dia=Dia;
    }
     
    public void setHora(String Hora) {
       this.Hora=Hora;
    }
    public String getProfesor() {
        return NombreProfesor;
    }
    public String getMateria() {
        return NombreMateria;
    }

    public String getDia() {
        return Dia;
    }

    public int getCapacidad() {
        return Capacidad;
    }

    public String getHora() {
        return Hora;
    }
    
    //Método boolean esExtraordinario
    public boolean esExtraordionario(int edad) {
        return edad <=15;

    }


}
