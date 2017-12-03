package proyecto;



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
    
    public void setNumMateria( int MateriasReg) {
        this.MateriasReg=MateriasReg;
    }

    public int getNumMateria() {
        
        return MateriasReg;
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
                        System.out.println("Registrados " + v1.getCapacidad());}
        
            }}
        }
    @Override
	public String toString() {
	String d= Nombres+ " -- "+Apellidos+ " -- "+ Edad+ " -- "+ Casa+ " -- "+ MateriasReg;
            return d;
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
