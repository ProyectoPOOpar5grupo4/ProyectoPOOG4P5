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

    public void Registro(String Nombre, String Apellido, String dia,String mes,String año) {
        Planificador p = new Planificador();
        Scanner sc = new Scanner(System.in);
        Boolean b=true, bo=true;
        String linearegistro="";
        String NomMateria = "", R="";
        int Edadmin = 0;
        int i;
        System.out.println("/** MATERIAS **/");
        for (ListadoMaterias d : ListadoMaterias.values()) {
            System.out.println(d.toString());
        }
        System.out.println("Elija una materia del listado de materias: ");
        int numMateria = sc.nextInt();
        for (ListadoMaterias d : ListadoMaterias.values()) {
            if (numMateria == d.getNumero()) {
                NomMateria = d.getMateria();
                Edadmin = d.getEdadMin();
            }
        }
            for (i = 0; i < p.leercurso().size(); i++) {
                Curso v1 = (Curso) p.leercurso().get(i);
                if (NomMateria.equals(v1.getMateria())) {
                    System.out.println("El horario de " + v1.getMateria() + " es: " + v1.getDia() + " " + v1.getHora());
                    System.out.println("Desea registrarse 1/0: ");
                    int opc = sc.nextInt();
                    if (opc == 1) {
                        Curso c = new Curso(v1.getCapacidad(),v1.getMateria(),v1.getProfesor(),v1.getHora(),v1.getDia());
                        setNumMateria(getNumMateria()+1);
                        c.setRegistrados(c.getRegistrados()+1);
                        File regist = new File("registros.txt");
                        File f = new File("estudiantes.txt");
                        ArrayList estud = p.leermago(f, "estudiantes.txt");
                        for (int k = 0; k < estud.size(); k++) {
                            Mago v = (Mago) estud.get(k);
                            b=Nombre.equalsIgnoreCase(v.Nombres);
                            if(b==true){
                                if (v.Edad < Edadmin) {
                                R= "E";}
                            else {
                                R = "N";}
                            linearegistro =dia+"/"+mes+"/"+año+","+ v.Nombres + "," + v.Apellidos + ","+v1.getMateria()+"," + R;
                            String reg=v.Nombres+v.Apellidos+v1.getMateria();
                            int j=0;
                            while(j < leerregistro().size() && bo==true){
                                bo =!(leerregistro().get(j)).equals(reg);
                                
                            j++;}   
                                if(bo==false ){
                            System.out.println("Ya está registrado");                        
                            }    
                            else{
                            p.EscribirArchivo(regist, linearegistro);
                            System.out.println("Registro creado con exito");                        
                            }
                }
            }
        }else{
                        System.out.println("Registro no creado");
                    }
    }}}
       
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
    public ArrayList leerregistro(){
        String nom,ap,mat;
        int c=0;
        ArrayList<String> p=new ArrayList<>();
        FileReader fr;
        String cadena="";
        File archivo= new File("registros.txt");
        try {
            fr=new FileReader(archivo);
            BufferedReader br=new BufferedReader(fr);
            while (cadena!=null){
                try {
                    cadena=br.readLine();
                    if(cadena!=null){  
                    
                    String texto[] = cadena.split(",");
                    
                        nom = texto[1];
                        ap = texto[2];
                        mat = texto[3];
                        p.add(nom+ap+mat);
                    }
                } catch (IOException e) {
                    System.err.println(e);
                }
            }
            try {
                br.close();
                fr.close();
            } catch (IOException e) {
              System.out.println(e);
            }
            
        } catch (FileNotFoundException e) {
            System.err.println(e);
        }
        return p;}
    
  }
