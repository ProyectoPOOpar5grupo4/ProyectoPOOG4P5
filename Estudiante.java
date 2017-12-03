package proyecto;



import java.util.*;
import java.io.*;
import java.util.Scanner;

/**
 * 
 */
public class Estudiante extends Mago implements Volador {
    private int MateriasReg;
    
    
    public Estudiante(String Nombres, String Apellidos, int Edad, String Casa, String Varita, Tipo_Mago Tipo) {
        super(Nombres, Apellidos, Edad, Casa, Varita, Tipo);
        MateriasReg=0;
    }
    public Estudiante(String Nombres, String Apellidos) {
        super(Nombres, Apellidos);

    }

    
    public void setNumMateria( int MateriasReg) {
        this.MateriasReg=MateriasReg;
    }

    public int getNumMateria() {
        
        return MateriasReg;
    }
    public String getCasa() {
        return Casa;
    }

    public void Registro( int Edad) {
       this.Edad=Edad;
    }

    public void VerHorarios() {
        Planificador p=new Planificador();
        Scanner sc = new Scanner(System.in);
        String NomMateria = "";
        int i=0,a=0;
            System.out.println("/** MATERIAS **/");
            for (ListadoMaterias d : ListadoMaterias.values()) {
                System.out.println(d.toString());
            }
            System.out.println("Elija una materia del listado de materias: ");
            int numMateria = sc.nextInt();
            for (ListadoMaterias d : ListadoMaterias.values()) {
                if (numMateria == d.getNumero()) {
                    NomMateria = d.getMateria();
                    System.out.println("Materia1 " + NomMateria);
                }for (i=0; i<p.leercurso().size(); i++){
                Curso v1 = (Curso) p.leercurso().get(i);   
                    if( NomMateria.equals(v1.getMateria())){
               System.out.println("Materia " + v1.getMateria());
                        System.out.println("Profesor " + v1.getProfesor());
                        System.out.println("Horario " + v1.getDia() + " " + v1.getHora());
                        }
        
            }}
        }
    @Override
    public String toString() {
        String mensaje = "Nombre: " + this.Nombres + " " + "Apellidos: " + this.Apellidos + " " + "Edad: " + this.Edad + " " + "Casa: " + this.Casa + " " + "Materias Registradas: " + this.MateriasReg + "\n";
        return mensaje;
    }
   
    @Override
    public void Despegar() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public void Volar(String nombres, String apellidos) {
        String line;
        try {
            FileReader fr = new FileReader("Estudiantes.txt");
            try (BufferedReader br = new BufferedReader(fr)) {
                while ((line = br.readLine()) != null) {
                    String lineaest[] = line.split(",");
                    if (lineaest[0].equalsIgnoreCase(nombres) && lineaest[1].equalsIgnoreCase(apellidos)) {
                        if (lineaest[5].equalsIgnoreCase("A")) {
                            System.out.println("Usted es un animago, para volar usted necesia su varita de " + lineaest[3]);
                        } else if (lineaest[5].equalsIgnoreCase("M")) {
                            System.out.println("Usted es un metamorfomago, usted puede volar usando su poder,sin varita ni escoba.");
                        } else if (lineaest[5].equalsIgnoreCase("N")) {
                            System.out.println("Usted es un mago normal, para volar necesita una nimbus 2000.");
                        } else {
                            System.out.println("No existe el alumno.");
                        }
                    }
                }
            }
        } catch (Exception ex) {
            ex.printStackTrace();
        }

    }
            }
