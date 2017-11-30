package proyecto;


import java.util.*;

/**
 * 
 */
public class Estudiante extends Mago implements Volador {
    private int MateriasReg;
    
    public Estudiante(String Usuario, String Contraseña, String Nombres, String Apellidos, int Edad, String Casa, String Varita, TipoMago Tipo, int MateriasReg) {
        super(Usuario, Contraseña, Nombres, Apellidos, Edad, Casa, Varita, Tipo);
        this.MateriasReg=MateriasReg;
    }
    
    public void setMateria( int MateriasReg) {
        this.MateriasReg=MateriasReg;
    }

    public int getMateria() {
        
        return MateriasReg;
    }

    public void Registro( int Edad) {
       this.Edad=Edad;
    }

    public String VerHorarios() {
        
        return "";
    }

    public String DescripcionVuelo() {
        
        return "";
    }

    
    public void Despegar() {
        
    }

    public void Volar() {
    
    }

}
