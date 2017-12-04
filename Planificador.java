package proyecto;

//Importando los paquetes util e io
import java.util.*;
import java.io.*;

public class Planificador {
    
    File estudiante = new File("estudiantes.txt");
    File profesor = new File("profesores.txt");
    
    FileWriter write;
    PrintWriter line;

    public Planificador() {
    }
    private String Usuario;
    private String Contraseña;
    private String Nombre;
    private String Apellido;

    public void setUsuario(String Usuario) {
        this.Usuario = Usuario;
    }

    public void setContraseña(String Contraseña) {
        this.Contraseña=Contraseña;
    }

    public String getUsuario() {
        // TODO implement here
        return Usuario;
    }

    public String getContraseña() {
        // TODO implement here
        return Contraseña;
    }

    
    public void EscribirArchivo(File f, String l){
        if (f.exists()) {
                        try {
                            write = new FileWriter(f, true);
                            line=new PrintWriter(write);
                            line.println(l);
                            write.close();
                            line.close();
                        } catch (IOException e) {
                            System.err.println(e);
                        } 
                    }else {
                    try {
                            f.createNewFile();
                            write = new FileWriter(f, true);
                            line=new PrintWriter(write);
                            line.println(l);
                            write.close();
                            line.close();
                        } catch (IOException e) {
                            System.err.println("Archivo no existe" + e);
                        }
                }
                
    }
    public ArrayList leerprofesor(){
        String nombre, apellido;
        ArrayList<String> p=new ArrayList<>();
        int i=1;
        FileReader fr;
        String cadena="";
        File archivo= new File("profesores.txt");
        try {
            fr=new FileReader(archivo);
            BufferedReader br=new BufferedReader(fr);
            while (cadena!=null){
                try {
                    cadena=br.readLine();
                    if(cadena!=null){  
                    String texto[] = cadena.split(",");
                    nombre= texto[0];
                    apellido = texto[1];                   
                    p.add(nombre+" "+apellido);
                    i=i+1;
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
        return p;
    }
    public ArrayList leercurso(){
        String materia, prof,dia, horario;
        int c=0;
        ArrayList<Curso> p=new ArrayList<>();
        FileReader fr;
        String cadena="";
        File archivo= new File("curso.txt");
        try {
            fr=new FileReader(archivo);
            BufferedReader br=new BufferedReader(fr);
            while (cadena!=null){
                try {
                    cadena=br.readLine();
                    if(cadena!=null){  
                    String texto[] = cadena.split(",");
                    materia= texto[0];
                    prof = texto[1];                   
                    c=Integer.parseInt(texto[2]);
                    dia=texto[3];
                    horario=texto[4];
                    p.add(new Curso(c,materia,prof,horario,dia));
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
    public void CrearCurso() {
        File curso = new File("curso.txt");
        String NomMateria="";
        String NombreProfesor="";
        
        Scanner sc = new Scanner(System.in);
        System.out.println("/** MATERIAS **/");
        for(ListadoMaterias d: ListadoMaterias.values()){
	System.out.println(d.toString());}
        System.out.println("Elija una materia del listado de materias: ");
        int numMateria = sc.nextInt();
        while(numMateria>8 || numMateria<1){
        System.out.println("Elija una materia de la lista");
        System.out.println("/** MATERIAS **/");
        for(ListadoMaterias d: ListadoMaterias.values()){
	System.out.println(d.toString());}
        System.out.println("Elija una materia del listado de materias: ");
        numMateria = sc.nextInt();
        }
        for(ListadoMaterias d: ListadoMaterias.values()){
            if(numMateria == d.getNumero()){
                NomMateria=d.getMateria();
            }
        }
        int Verificador=0;
        while(Verificador==0){
            
            for (int i=0; i<leercurso().size(); i++){
                Curso v1 = (Curso) leercurso().get(i);
            if( NomMateria.equals(v1.getMateria())){
            System.out.println("Ya existe este curso");
            System.out.println("/** MATERIAS **/");
        for(ListadoMaterias d: ListadoMaterias.values()){
	System.out.println(d.toString());}
        System.out.println("Elija una materia del listado de materias: ");
        numMateria = sc.nextInt();
        while(numMateria>8 || numMateria<1){
        System.out.println("Elija una materia de la lista");
        System.out.println("/** MATERIAS **/");
        for(ListadoMaterias d: ListadoMaterias.values()){
	System.out.println(d.toString());}
        System.out.println("Elija una materia del listado de materias: ");
        numMateria = sc.nextInt();
        }
        for(ListadoMaterias d: ListadoMaterias.values()){
            if(numMateria == d.getNumero()){
                NomMateria=d.getMateria();
            }
        }
            }else{Verificador=1;}
            }       
        }
        System.out.println("/**Profesores**/");
        for (int i=0; i<leerprofesor().size(); i++){
                String v1 = (String) leerprofesor().get(i);
                System.out.println(i+1+" "+v1);
            }
        System.out.println("Elija un profesor del listado de profesores: ");
        int numProfesor = sc.nextInt();
        while(numProfesor>leerprofesor().size()){
        System.out.println("/**Profesores**/");
        for (int i=0; i<leerprofesor().size(); i++){
                String v1 = (String) leerprofesor().get(i);
                System.out.println(i+1+" "+v1);
            }
        System.out.println("Elija un profesor del listado de profesores: ");
        numProfesor = sc.nextInt();
        }
        for (int i=0; i<leerprofesor().size(); i++){
            if(numProfesor==i+1) {
                String v1 = (String) leerprofesor().get(i);
                NombreProfesor=v1;}}
        System.out.println("Capacidad del curso de "+NomMateria+" : ");
        int Capacidad = sc.nextInt();
        System.out.println("Ingrese el día: ");
        String Día = sc.next();
        System.out.println("Ingrese el horario del curso: ");
        String Horario = sc.next();
        Verificador=0;
        while(Verificador==0){
            
            for (int i=0; i<leercurso().size(); i++){
                Curso v1 = (Curso) leercurso().get(i);
            if( Día.equals(v1.getDia())){
            if( Horario.equals(v1.getHora())){
            System.out.println("Ya existe un curso en este día con este mismo horario");
            System.out.println("Ingrese el día: ");
            Día = sc.next();
            System.out.println("Ingrese el horario del curso: ");
            Horario = sc.next();
            }    
            }else{Verificador=1;}
            }       
        }
        System.out.println("Desea guardar datos? 1/0: ");
        int opsave = sc.nextInt();
        Curso c=new Curso(Capacidad,NomMateria,NombreProfesor,Horario,Día);
            String lineacurso=c.getMateria()+","+c.getProfesor()+","+c.getCapacidad()+","+c.getDia()+","+c.getHora();
            if (opsave == 1) {
                    EscribirArchivo(curso,lineacurso);
                }else {
                    System.out.println("Curso no creado");
                }
        
        
        System.out.println("Se ha creado el curso: ");
        System.out.println("Materia: "+c.getMateria());
        System.out.println("Profesor: "+c.getProfesor());
        System.out.println("Capacidad: "+c.getCapacidad());
        System.out.println("Día: "+c.getDia());
        System.out.println("Horario: "+c.getHora());
    }
    

    public void CrearProfesor() {
        
        Scanner sc = new Scanner(System.in);
        System.out.println("/** CREAR PROFESOR **/");
        System.out.println("Ingrese Nombre: ");
        String nombreprof = sc.nextLine();
        System.out.println("Ingrese Apelllidos: ");
        String apellidoprof = sc.nextLine();
        System.out.println("Ingrese Edad: ");
        int edadprof = sc.nextInt();
        System.out.println("Casa: ");
        String espacio = sc.nextLine();
        String casaprof = sc.nextLine();
        System.out.println("Varita: ");
        String varitaprof = sc.nextLine();
        System.out.println("Fecha de Ingreso: ");
        String fechaprof = sc.nextLine();
        int checkdigit = -1;
        while (checkdigit == -1) {
            System.out.println("Tipos de Brujas/Magos");
            System.out.println("1. Animago");
            System.out.println("2. Metamorfomago");
            System.out.println("3. Normal");
            System.out.println("Elija el tipo de Mago/Bruja que es:");
            int opcionbruja = sc.nextInt();
            String space = sc.nextLine();
            if (opcionbruja == 1) {
                checkdigit = 0;
                System.out.println("¿En qué clase de animal puede convertirse? ");
                String tipoanimal = sc.nextLine();
                System.out.println("Hechizo:");
                String tipohechizo = sc.nextLine();
                Profesor profea = new Profesor(nombreprof, apellidoprof, edadprof, casaprof, varitaprof, Tipo_Mago.Animago, fechaprof, tipohechizo, tipoanimal, "null", "null");
                String lineaprofesor = profea.getNombres() + "," + profea.getApellidos() + "," + profea.getEdad() + "," + profea.getVarita() + "," + profea.getIngreso() + "," + "A" + "," + profea.getAnimal()
                        + "," + profea.getHechizo() + "," + profea.getPocion() + "," + profea.getDeporte() + "\n";
                System.out.println("Desea guardar datos? 1/0: ");
                int opsave = sc.nextInt();
                if (opsave == 1) {
                    EscribirArchivo(profesor,lineaprofesor);
                    System.out.println("Profesor creado");
                }else {
                    System.out.println("Profesor no creado");
                }
                

            } else if (opcionbruja == 2) {
                checkdigit = 0;
                System.out.println("Poción:");
                String tipopocion = sc.nextLine();
                Profesor profem = new Profesor(nombreprof, apellidoprof, edadprof, casaprof, varitaprof, Tipo_Mago.Metamorfomago, fechaprof, "null", "null", tipopocion, "null");
                String lineaprofesor = profem.getNombres() + "," + profem.getApellidos() + "," + profem.getEdad() + "," + profem.getVarita() + "," + profem.getIngreso() + "," + "M" + "," + profem.getAnimal()
                        + "," + profem.getHechizo() + "," + profem.getPocion() + "," + profem.getDeporte() + "\n";
                System.out.println("Desea guardar datos? 1/0: ");
                int opsave = sc.nextInt();
                if (opsave == 1) {
                    EscribirArchivo(profesor,lineaprofesor);
                    System.out.println("Profesor creado");

                }else {
                    System.out.println("Profesor no creado");
                }
                //DEBERIA GUARDARSE EN TXT
            } else if (opcionbruja == 3) {
                checkdigit = 0;
                System.out.println("Deporte: ");
                String deporte = sc.nextLine();
                Profesor profen = new Profesor(nombreprof, apellidoprof, edadprof, casaprof, varitaprof, Tipo_Mago.Normal, fechaprof, "null", "null", "null", deporte);
                String lineaprofesor = profen.getNombres() + "," + profen.getApellidos() + "," + profen.getEdad() + "," + profen.getVarita() + "," + profen.getIngreso() + "," + "N" + "," + profen.getAnimal()
                        + "," + profen.getHechizo() + "," + profen.getPocion() + "," + profen.getDeporte() + "\n";
                System.out.println("Desea guardar datos? 1/0: ");
                int opsave = sc.nextInt();
                if (opsave == 1) {
                    EscribirArchivo(profesor,lineaprofesor);
                                        System.out.println("Profesor creado");

                }else {
                    System.out.println("Profesor no creado");
                }
                               
            }else if ((opcionbruja > 3) || (opcionbruja < 1)){
                checkdigit = -1;
                System.out.println("Selección erronea");

            }
        }
    }

    public void CrearEstudiante() {
        Scanner sc = new Scanner(System.in);
        System.out.println("/** CREAR ESTUDIANTE **/");
        System.out.println("Ingrese nombre: ");
        String nombreest = sc.nextLine();
        System.out.println("Ingrese apellidos: ");
        String apellidoest = sc.nextLine();
        System.out.println("Edad: ");
        int edadest = sc.nextInt();
        System.out.println("Casa: ");
        String espacio = sc.nextLine();
        String casaest = sc.nextLine();
        System.out.println("Varita: ");
        String varitaest = sc.nextLine();
        int checkdigit = -1;
        while (checkdigit == -1) {
            System.out.println("Tipos de Brujas/Magos");
            System.out.println("1.- Animago");
            System.out.println("2.- Metamorfomago");
            System.out.println("3.- Normal");
            System.out.println("Escoja el tipo de mago:");
            int opcionbruja = sc.nextInt();
            String espacio2 = sc.nextLine();
            if (opcionbruja == 1) {
                checkdigit = 0;
                Estudiante esta = new Estudiante(nombreest, apellidoest, edadest, casaest, varitaest, Tipo_Mago.Animago);
                String lineaestudiante = "\n"+esta.getNombres() + "," + esta.getApellidos() + "," + esta.getEdad() + "," + esta.getVarita() + "," + esta.getCasa() + "," + "A";
                System.out.println("Desea guardar datos? 1/0: ");
                int opsave = sc.nextInt();
                if (opsave == 1) {
                    EscribirArchivo(estudiante,lineaestudiante);
                    System.out.println("Estudiante creado");
                } else {
                    System.out.println("Estudiante no creado");
                }
                //DEBERIA GUARDARSE EN TXT  
            } else if (opcionbruja == 2) {
                checkdigit = 0;
                Estudiante estm = new Estudiante(nombreest, apellidoest, edadest, casaest, varitaest, Tipo_Mago.Metamorfomago);
                String lineaestudiante = "\n"+estm.Nombres + "," + estm.Apellidos + "," + estm.Edad + "," + estm.Varita + "," + "M";
                System.out.println("Desea guardar datos? 1/0: ");
                int opsave = sc.nextInt();
                if (opsave == 1) {
                    EscribirArchivo(estudiante,lineaestudiante);
                    System.out.println("Estudiante creado");
                } else {
                    System.out.println("Estudiante no creado");
                }
                //DEBERIA GUARDARSE EN TXT  
            } else if (opcionbruja == 3) {
                checkdigit = 0;
                Estudiante estn = new Estudiante(nombreest, apellidoest, edadest, casaest, varitaest, Tipo_Mago.Normal);
                String lineaestudiante = "\n"+estn.Nombres + "," + estn.Apellidos + "," + estn.Edad + "," + estn.Varita + "," + "N";
                System.out.println("Desea guardar datos? 1/0: ");
                int opsave = sc.nextInt();
                if (opsave == 1) {
                    EscribirArchivo(estudiante,lineaestudiante);
                    System.out.println("Estudiante creado");
                } else {
                    System.out.println("Estudiante no creado");
                }
                  
            } else if ((opcionbruja > 3) || (opcionbruja < 1)){
                checkdigit = -1;
                System.out.println("Selección erronea");
            }
        }
    }
static Scanner sc = new Scanner(System.in);
    public static void VerHorariosPlanificados() {
	   int pos = -1;
        while (!(pos != -1)) {
            for (ListadoMaterias d : ListadoMaterias.values()) {
                System.out.println(d.toString());
            }
            System.out.print("Elija una de las materias del listado de materias: ");
            int op = sc.nextInt();
            if (op == 1 || op == 2 || op == 3 || op == 4 || op == 5 || op == 6 || op == 7 || op == 8) {
                int index = op - 1;
                String materia = Cursos.setListaMaterias().get(index);
                int registrados = Cursos.getRegistrados();
                pos = Planificador.arrayListaCursos().get(0).indexOf(materia);                
                if (pos != -1) {                    
                    System.out.println("\nMATERIA: " + materia);
                    System.out.println("PROFESOR: " + Planificador.arrayListaCursos().get(4).get(pos));
                    System.out.println("HORARIO: " + Planificador.arrayListaCursos().get(2).get(pos) + ", " + Planificador.arrayListaCursos().get(1).get(pos));
		    System.out.println("REGISTRADOS: "+ Planificador.arrayListaCursos().get(3).get(pos));

                } else {
                    System.out.print("No se ha creado un curso con la materia " );
                    String confirmar = sc.next();                 
                }

            } else {
                System.out.print("Opción incorrecta");

            }

        } 

       
    }

    public ArrayList VerListadoEstudiantes() {
        // TODO implement here
        return null;
    }
}
