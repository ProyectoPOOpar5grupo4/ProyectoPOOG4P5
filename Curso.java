package proyecto;


/**
 * 
 */
public class Curso {
    private int Capacidad;
    private String NombreMateria;
    private String Hora;
    private String Dia;

     public Curso(int Capacidad,String NombreMateria,String Hora,String Dia) {
         this.Capacidad=Capacidad;
         this.NombreMateria=NombreMateria;
         this.Dia=Dia;
         this.Hora=Hora;
    }
     
    public void setCapacidad(int Capacidad) {
        this.Capacidad=Capacidad;
    }

    public void setMateria(String Materia) {
        NombreMateria=Materia;
    }

    public void setDia(String Dia) {
        this.Dia=Dia;
    }

    public void setHora(String Hora) {
       this.Hora=Hora;
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

}