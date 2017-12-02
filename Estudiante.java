package proyecto;


import java.io.File;
import java.io.PrintWriter;
import java.util.*;

/**
 * 
 */
public class Estudiante extends Mago implements Volador {
    private int MateriasReg;
    
    
    public Estudiante(String Nombres, String Apellidos, int Edad, String Casa, String Varita, Tipo_Mago Tipo) {
        super(Nombres, Apellidos, Edad, Casa, Varita, Tipo);
        MateriasReg=0;
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
        String materia = "";
        Scanner sub = new Scanner(System.in);
        System.out.println("/** CURSOS PLANIFICADOS **/ ");
        for (ListadoMaterias subject : ListadoMaterias.values()) {
            System.out.println(subject.toString());
        }
        System.out.println("Escoja una materia: ");
        int k = sub.nextInt();
        return null;
        
    }

    @Override
    public void Despegar() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public void Volar() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
            }
