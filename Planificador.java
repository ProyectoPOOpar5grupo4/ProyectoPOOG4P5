package proyecto;

import java.io.File;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.*;

public class Planificador {

    File est = new File("estudiantes.txt");
    File pro = new File("profesores.txt");
    PrintWriter es;

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

    }

    public String getUsuario() {
        // TODO implement here
        return Usuario;
    }

    public String getContraseña() {
        // TODO implement here
        return Contraseña;
    }

    public void Login() {
        Scanner sc = new Scanner(System.in);
        String usernom = "", userapell = "", userrol = "";
        int checknum = -1;
        
        while (checknum == -1) {
            System.out.println("Usuario");
            String usuario = sc.nextLine();
            System.out.println("Contraseña");
            String password = sc.nextLine();
            File archivo = null;
            FileReader fr = null;
            BufferedReader br = null;
            try {
                InputStream inputstream = Planificador.class.getResourceAsStream("/resources/Usuarios.txt");
                InputStreamReader inputreader = new InputStreamReader(inputstream);
                br = new BufferedReader(inputreader);
                String linea;
                while ((linea = br.readLine()) != null) {
                    String texto[] = linea.split(",");
                    if (texto[0].equalsIgnoreCase(usuario) && texto[1].equalsIgnoreCase(password)) {
                        checknum= 0;
                        usernom = texto[2];
                        userapell = texto[3];
                        userrol = texto[4];
                    }
                }
            } catch (Exception e) {
                e.printStackTrace();

            } finally {
                try {
                    if (null != fr) {
                        fr.close();
                    }
                } catch (Exception e2) {
                    e2.printStackTrace();
                }
            }
            if (checknum == -1) {
                System.out.println("Los datos no son válidos.Intente nuevamente.");
                } else {
                System.out.println("Ingrese exitoso");
            }
        }
    

    public String CrearCurso(String Materia, String Profesor) {

        return "";
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
                String lineaprofesor = profea.Nombres + "," + profea.Apellidos + "," + profea.Edad + "," + profea.Varita + "," + profea.getIngreso() + "," + "A" + "," + profea.getAnimal()
                        + profea.getHechizo() + profea.getPocion() + "," + profea.getDeporte();
                System.out.println("Desea guardar datos? 1/0: ");
                int opsave = sc.nextInt();
                if (opsave == 1) {
                    if (pro.exists()) {
                        try {
                            es = new PrintWriter(pro, "utf-8");
                            es.println(lineaprofesor);
                            es.close();
                            System.out.println("Profesor creado");
                        } catch (IOException e) {
                            System.err.println(e);
                        }

                    }
                } else {
                    System.out.println("Profesor no creado");
                }
                //DEBERIA GUARDARSE EN TXT

            } else if (opcionbruja == 2) {
                checkdigit = 0;
                System.out.println("Poción:");
                String tipopocion = sc.nextLine();
                Profesor profem = new Profesor(nombreprof, apellidoprof, edadprof, casaprof, varitaprof, Tipo_Mago.Metamorfomago, fechaprof, "null", "null", tipopocion, "null");
                String lineaprofesor = profem.Nombres + "," + profem.Apellidos + "," + profem.Edad + "," + profem.Varita + "," + profem.getIngreso() + "," + "M" + "," + profem.getAnimal()
                        + profem.getHechizo() + profem.getPocion() + "," + profem.getDeporte();
                System.out.println("Desea guardar datos? 1/0: ");
                int opsave = sc.nextInt();
                if (opsave == 1) {
                    if (pro.exists()) {
                        try {
                            es = new PrintWriter(pro, "utf-8");
                            es.println(lineaprofesor);
                            es.close();
                            System.out.println("Profesor creado");
                        } catch (IOException e) {
                            System.err.println(e);
                        }

                    }
                } else {
                    System.out.println("Profesor no creado");
                }
                //DEBERIA GUARDARSE EN TXT
            } else if (opcionbruja == 3) {
                checkdigit = 0;
                System.out.println("Deporte: ");
                String deporte = sc.nextLine();
                Profesor profen = new Profesor(nombreprof, apellidoprof, edadprof, casaprof, varitaprof, Tipo_Mago.Normal, fechaprof, "null", "null", "null", deporte);
                String lineaprofesor = profen.Nombres + "," + profen.Apellidos + "," + profen.Edad + "," + profen.Varita + "," + profen.getIngreso() + "," + "N" + "," + profen.getAnimal()
                        + profen.getHechizo() + profen.getPocion() + "," + profen.getDeporte();
                System.out.println("Desea guardar datos? 1/0: ");
                int opsave = sc.nextInt();
                if (opsave == 1) {
                    if (pro.exists()) {
                        try {
                            es = new PrintWriter(pro, "utf-8");
                            es.println(lineaprofesor);
                            es.close();
                        } catch (IOException e) {
                            System.err.println(e);
                        }

                    }
                } else {
                    System.out.println("Profesor no creado");
                }
                //DEBERIA GUARDARSE EN TXT                
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
        int checkdigit = 0;
        while (checkdigit == 0) {
            System.out.println("Tipos de Brujas/Magos");
            System.out.println("1.- Animago");
            System.out.println("2.- Metamorfomago");
            System.out.println("3.- Normal");
            System.out.println("Escoga el tipo de mago:");
            int opcionbruja = sc.nextInt();
            String espacio2 = sc.nextLine();
            if (opcionbruja == 1) {
                checkdigit = 0;
                Estudiante esta = new Estudiante(nombreest, apellidoest, edadest, casaest, varitaest, Tipo_Mago.Animago);
                String lineaestudiante = esta.Nombres + "," + esta.Apellidos + "," + esta.Edad + "," + esta.Varita + "," + "A";
                System.out.println("Desea guardar datos? 1/0: ");
                int opsave = sc.nextInt();
                if (opsave == 1) {
                    if (est.exists()) {
                        try {
                            es = new PrintWriter(est, "utf-8");
                            es.println(lineaestudiante);
                            System.out.println("Estudiante creado");
                            es.close();
                        } catch (IOException e) {
                            System.err.println(e);
                        }

                    } else {
                        try {
                            est.createNewFile();
                        } catch (Exception e) {
                            System.err.println("Archivo no existe" + e);
                        }

                    }
                } else {
                    System.out.println("Estudiante no creado");
                }
                //DEBERIA GUARDARSE EN TXT  
            } else if (opcionbruja == 2) {
                checkdigit = 0;
                Estudiante estm = new Estudiante(nombreest, apellidoest, edadest, casaest, varitaest, Tipo_Mago.Metamorfomago);
                String lineaestudiante = estm.Nombres + "," + estm.Apellidos + "," + estm.Edad + "," + estm.Varita + "," + "M";
                System.out.println("Desea guardar datos? 1/0: ");
                int opsave = sc.nextInt();
                if (opsave == 1) {
                    if (est.exists()) {
                        try {
                            es = new PrintWriter(est, "utf-8");
                            es.println(lineaestudiante);
                            es.close();
                        } catch (IOException e) {
                            System.err.println(e);
                        }

                    } else {
                        try {
                            est.createNewFile();
                        } catch (Exception e) {
                            System.err.println("Archivo no existe" + e);
                        }

                    }
                } else {
                    System.out.println("Estudiante no creado");
                }
                //DEBERIA GUARDARSE EN TXT  
            } else if (opcionbruja == 3) {
                checkdigit = 0;
                Estudiante estn = new Estudiante(nombreest, apellidoest, edadest, casaest, varitaest, Tipo_Mago.Normal);
                String lineaestudiante = estn.Nombres + "," + estn.Apellidos + "," + estn.Edad + "," + estn.Varita + "," + "N";
                System.out.println("Desea guardar datos? 1/0: ");
                int opsave = sc.nextInt();
                if (opsave == 1) {
                    if (est.exists()) {
                        try {
                            es = new PrintWriter(est, "utf-8");
                            es.println(lineaestudiante);
                            System.out.println("Estudiante creado");
                            es.close();
                        } catch (IOException e) {
                            System.err.println(e);
                        }

                    } else {
                        try {
                            est.createNewFile();
                        } catch (Exception e) {
                            System.err.println("Archivo no existe" + e);
                        }

                    }
                } else {
                    System.out.println("Estudiante no creado");
                }
                //DEBERIA GUARDARSE EN TXT  
            } else if (opcionbruja == 3) {
                checkdigit = 0;
                Estudiante estn = new Estudiante(nombreest, apellidoest, edadest, casaest, varitaest, Tipo_Mago.Normal);
                String lineaestudiante = estn.Nombres + "," + estn.Apellidos + "," + estn.Edad + "," + estn.Varita + "," + "N";
                System.out.println("Desea guardar datos? 1/0: ");
                int opsave = sc.nextInt();
                if (opsave == 1) {
                    if (est.exists()) {
                        try {
                            es = new PrintWriter(est, "utf-8");
                            es.println(lineaestudiante);
                            System.out.println("Estudiante creado");
                            es.close();
                        } catch (IOException e) {
                            System.err.println(e);
                        }

                    } else {
                        try {
                            est.createNewFile();
                        } catch (Exception e) {
                            System.err.println("Archivo no existe" + e);
                        }

                    }
                } else {
                    System.out.println("Estudiante no creado");
                }
                //DEBERIA GUARDARSE EN TXT  

            }
        }
    }

    public String VerHorariosPlanificados(String Materia) {

        return "";
    }

    public ArrayList VerListadoEstudiantes() {
        // TODO implement here
        return null;
    }
}
