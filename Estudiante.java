package proyecto;


//Importacion del paquete java.util
import java.util.*;

/**
 * 
 */
//Herencia de la clase Mago e implementando la interface Volador
public class Estudiante extends Mago implements Volador {
    //Declaración de atributos
    private int MateriasReg;
    
    //Declaración de los métodos
    public Estudiante(String Nombres, String Apellidos, int Edad, String Casa, String Varita, Tipo_Mago Tipo) {
        super(Nombres, Apellidos, Edad, Casa, Varita, Tipo);
        //Inicializacion del atributo MateriasReg
        MateriasReg=0;
    }
    //Métodos get an set de la clase Estudiante
    public void setNumMateria( int MateriasReg) {
        this.MateriasReg=MateriasReg;
    }

    public int getNumMateria() {
        
        return MateriasReg;
    }

    public void Registro( int Edad) {
       this.Edad=Edad;
    }
    //método VerHorarios
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
    //Implementando los métodos de la interface Volador
    @Override
    public void Despegar() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public void Volar() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
            }
